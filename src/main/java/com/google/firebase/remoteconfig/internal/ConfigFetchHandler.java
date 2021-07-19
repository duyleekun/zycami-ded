/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.format.DateUtils
 */
package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$Lambda$1;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$Lambda$2;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$Lambda$3;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$Lambda$4;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient$BackoffMetadata;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class ConfigFetchHandler {
    public static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES;
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = 0L;
    public static final int HTTP_TOO_MANY_REQUESTS = 429;
    private final AnalyticsConnector analyticsConnector;
    private final Clock clock;
    private final Map customHttpHeaders;
    private final Executor executor;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigFetchHttpClient frcBackendApiClient;
    private final ConfigMetadataClient frcMetadata;
    private final Random randomGenerator;

    static {
        int[] nArray;
        DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
        int[] nArray2 = nArray = new int[8];
        int[] nArray3 = nArray;
        nArray2[0] = 2;
        nArray3[1] = 4;
        nArray2[2] = 8;
        nArray3[3] = 16;
        nArray2[4] = 32;
        nArray3[5] = 64;
        nArray2[6] = 128;
        nArray3[7] = 256;
        BACKOFF_TIME_DURATIONS_IN_MINUTES = nArray;
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, AnalyticsConnector analyticsConnector, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = analyticsConnector;
        this.executor = executor;
        this.clock = clock;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcMetadata = configMetadataClient;
        this.customHttpHeaders = map;
    }

    private boolean areCachedFetchConfigsValid(long l10, Date date) {
        Date date2;
        Date date3 = this.frcMetadata.getLastSuccessfulFetchTime();
        boolean bl2 = date3.equals(date2 = ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET);
        if (bl2) {
            return false;
        }
        long l11 = date3.getTime();
        l10 = TimeUnit.SECONDS.toMillis(l10);
        date2 = new Date(l11 += l10);
        return date.before(date2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private FirebaseRemoteConfigServerException createExceptionWithGenericMessage(FirebaseRemoteConfigServerException firebaseRemoteConfigException) {
        String string2;
        block8: {
            block9: {
                int n10;
                int n11 = ((FirebaseRemoteConfigServerException)firebaseRemoteConfigException).getHttpStatusCode();
                if (n11 == (n10 = 401)) break block9;
                n10 = 403;
                if (n11 != n10) {
                    n10 = 429;
                    if (n11 == n10) {
                        FirebaseRemoteConfigClientException firebaseRemoteConfigClientException = new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
                        throw firebaseRemoteConfigClientException;
                    }
                    n10 = 500;
                    if (n11 != n10) {
                        switch (n11) {
                            default: {
                                string2 = "The server returned an unexpected error.";
                                break;
                            }
                            case 502: 
                            case 503: 
                            case 504: {
                                string2 = "The server is unavailable. Please try again later.";
                                break;
                            }
                        }
                        break block8;
                    } else {
                        string2 = "There was an internal server error.";
                    }
                    break block8;
                } else {
                    string2 = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
                }
                break block8;
            }
            string2 = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        }
        int n12 = ((FirebaseRemoteConfigServerException)firebaseRemoteConfigException).getHttpStatusCode();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fetch failed: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return new FirebaseRemoteConfigServerException(n12, string2, firebaseRemoteConfigException);
    }

    private String createThrottledMessage(long l10) {
        Object[] objectArray = new Object[1];
        String string2 = DateUtils.formatElapsedTime((long)TimeUnit.MILLISECONDS.toSeconds(l10));
        objectArray[0] = string2;
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", objectArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ConfigFetchHandler$FetchResponse fetchFromBackend(String object, String object2, Date date) {
        try {
            Object object3 = this.frcBackendApiClient;
            HttpURLConnection httpURLConnection = ((ConfigFetchHttpClient)object3).createHttpURLConnection();
            ConfigFetchHttpClient configFetchHttpClient = this.frcBackendApiClient;
            Map map = this.getUserProperties();
            object3 = this.frcMetadata;
            String string2 = ((ConfigMetadataClient)object3).getLastFetchETag();
            Map map2 = this.customHttpHeaders;
            object = configFetchHttpClient.fetch(httpURLConnection, (String)object, (String)object2, map, string2, map2, date);
            object2 = ((ConfigFetchHandler$FetchResponse)object).getLastFetchETag();
            if (object2 != null) {
                object2 = this.frcMetadata;
                object3 = ((ConfigFetchHandler$FetchResponse)object).getLastFetchETag();
                ((ConfigMetadataClient)object2).setLastFetchETag((String)object3);
            }
            object2 = this.frcMetadata;
            ((ConfigMetadataClient)object2).resetBackoff();
            return object;
        }
        catch (FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) {
            int n10 = firebaseRemoteConfigServerException.getHttpStatusCode();
            object2 = this.updateAndReturnBackoffMetadata(n10, date);
            int n11 = firebaseRemoteConfigServerException.getHttpStatusCode();
            n11 = (int)(this.shouldThrottle((ConfigMetadataClient$BackoffMetadata)object2, n11) ? 1 : 0);
            if (n11 != 0) {
                long l10 = ((ConfigMetadataClient$BackoffMetadata)object2).getBackoffEndTime().getTime();
                FirebaseRemoteConfigFetchThrottledException firebaseRemoteConfigFetchThrottledException = new FirebaseRemoteConfigFetchThrottledException(l10);
                throw firebaseRemoteConfigFetchThrottledException;
            }
            throw this.createExceptionWithGenericMessage(firebaseRemoteConfigServerException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Task fetchFromBackendAndCacheResponse(String object, String object2, Date object3) {
        try {
            object = this.fetchFromBackend((String)object, (String)object2, (Date)object3);
            int n10 = ((ConfigFetchHandler$FetchResponse)object).getStatus();
            if (n10 != 0) {
                return Tasks.forResult(object);
            }
            object2 = this.fetchedConfigsCache;
            object3 = ((ConfigFetchHandler$FetchResponse)object).getFetchedConfigs();
            object2 = ((ConfigCacheClient)object2).put((ConfigContainer)object3);
            object3 = this.executor;
            object = ConfigFetchHandler$$Lambda$4.lambdaFactory$((ConfigFetchHandler$FetchResponse)object);
            return ((Task)object2).onSuccessTask((Executor)object3, (SuccessContinuation)object);
        }
        catch (FirebaseRemoteConfigException firebaseRemoteConfigException) {
            return Tasks.forException(firebaseRemoteConfigException);
        }
    }

    private Task fetchIfCacheExpiredAndNotThrottled(Task object, long l10) {
        Object object2;
        Object object3;
        Object object4 = this.clock;
        long l11 = object4.currentTimeMillis();
        Date date = new Date(l11);
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2 && (bl2 = this.areCachedFetchConfigsValid(l10, date))) {
            return Tasks.forResult(ConfigFetchHandler$FetchResponse.forLocalStorageUsed(date));
        }
        object = this.getBackoffEndTimeInMillis(date);
        if (object != null) {
            l11 = ((Date)object).getTime();
            long l12 = date.getTime();
            object3 = this.createThrottledMessage(l11 -= l12);
            l11 = ((Date)object).getTime();
            object2 = new FirebaseRemoteConfigFetchThrottledException((String)object3, l11);
            object = Tasks.forException((Exception)object2);
        } else {
            object = this.firebaseInstallations.getId();
            object2 = this.firebaseInstallations.getToken(false);
            int n10 = 2;
            object4 = new Task[n10];
            object4[0] = object;
            int n11 = 1;
            object4[n11] = object2;
            object3 = Tasks.whenAllComplete(object4);
            object4 = this.executor;
            object = ConfigFetchHandler$$Lambda$2.lambdaFactory$(this, (Task)object, (Task)object2, date);
            object = ((Task)object3).continueWithTask((Executor)object4, (Continuation)object);
        }
        object2 = this.executor;
        object3 = ConfigFetchHandler$$Lambda$3.lambdaFactory$(this, date);
        return ((Task)object).continueWithTask((Executor)object2, (Continuation)object3);
    }

    private Date getBackoffEndTimeInMillis(Date date) {
        Date date2 = this.frcMetadata.getBackoffMetadata().getBackoffEndTime();
        boolean bl2 = date.before(date2);
        if (bl2) {
            return date2;
        }
        return null;
    }

    private long getRandomizedBackoffDurationInMillis(int n10) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] nArray = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        int n11 = nArray.length;
        n10 = Math.min(n10, n11) + -1;
        long l10 = nArray[n10];
        long l11 = timeUnit.toMillis(l10);
        long l12 = l11 / (long)2;
        Random random = this.randomGenerator;
        int n12 = (int)l11;
        l11 = random.nextInt(n12);
        return l12 + l11;
    }

    private Map getUserProperties() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = this.analyticsConnector;
        if (object == null) {
            return hashMap;
        }
        boolean bl2 = false;
        Object object2 = null;
        object = object.getUserProperties(false).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = object2.getValue().toString();
            hashMap.put(string2, object2);
        }
        return hashMap;
    }

    private boolean isThrottleableServerError(int n10) {
        int n11 = 429;
        n10 = n10 != n11 && n10 != (n11 = 502) && n10 != (n11 = 503) && n10 != (n11 = 504) ? 0 : 1;
        return n10 != 0;
    }

    public static /* synthetic */ Task lambda$fetch$0(ConfigFetchHandler configFetchHandler, long l10, Task task) {
        return configFetchHandler.fetchIfCacheExpiredAndNotThrottled(task, l10);
    }

    public static /* synthetic */ Task lambda$fetchFromBackendAndCacheResponse$3(ConfigFetchHandler$FetchResponse configFetchHandler$FetchResponse, ConfigContainer configContainer) {
        return Tasks.forResult(configFetchHandler$FetchResponse);
    }

    public static /* synthetic */ Task lambda$fetchIfCacheExpiredAndNotThrottled$1(ConfigFetchHandler object, Task object2, Task object3, Date date, Task task) {
        boolean bl2 = ((Task)object2).isSuccessful();
        if (!bl2) {
            object2 = ((Task)object2).getException();
            object = new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", (Throwable)object2);
            return Tasks.forException((Exception)object);
        }
        bl2 = ((Task)object3).isSuccessful();
        if (!bl2) {
            object2 = ((Task)object3).getException();
            object = new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", (Throwable)object2);
            return Tasks.forException((Exception)object);
        }
        object2 = (String)((Task)object2).getResult();
        object3 = ((InstallationTokenResult)((Task)object3).getResult()).getToken();
        return super.fetchFromBackendAndCacheResponse((String)object2, (String)object3, date);
    }

    public static /* synthetic */ Task lambda$fetchIfCacheExpiredAndNotThrottled$2(ConfigFetchHandler configFetchHandler, Date date, Task task) {
        configFetchHandler.updateLastFetchStatusAndTime(task, date);
        return task;
    }

    private boolean shouldThrottle(ConfigMetadataClient$BackoffMetadata configMetadataClient$BackoffMetadata, int n10) {
        int n11;
        int n12 = configMetadataClient$BackoffMetadata.getNumFailedFetches();
        if (n12 <= (n11 = 1) && n10 != (n12 = 429)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private ConfigMetadataClient$BackoffMetadata updateAndReturnBackoffMetadata(int n10, Date date) {
        if ((n10 = (int)(this.isThrottleableServerError(n10) ? 1 : 0)) != 0) {
            this.updateBackoffMetadataWithLastFailedFetchTime(date);
        }
        return this.frcMetadata.getBackoffMetadata();
    }

    private void updateBackoffMetadataWithLastFailedFetchTime(Date date) {
        int n10 = this.frcMetadata.getBackoffMetadata().getNumFailedFetches() + 1;
        long l10 = this.getRandomizedBackoffDurationInMillis(n10);
        long l11 = date.getTime() + l10;
        Date date2 = new Date(l11);
        this.frcMetadata.setBackoffMetadata(n10, date2);
    }

    private void updateLastFetchStatusAndTime(Task object, Date date) {
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2) {
            this.frcMetadata.updateLastFetchAsSuccessfulAt(date);
            return;
        }
        if ((object = ((Task)object).getException()) == null) {
            return;
        }
        boolean bl3 = object instanceof FirebaseRemoteConfigFetchThrottledException;
        if (bl3) {
            object = this.frcMetadata;
            ((ConfigMetadataClient)object).updateLastFetchAsThrottled();
        } else {
            object = this.frcMetadata;
            ((ConfigMetadataClient)object).updateLastFetchAsFailed();
        }
    }

    public Task fetch() {
        long l10 = this.frcMetadata.getMinimumFetchIntervalInSeconds();
        return this.fetch(l10);
    }

    public Task fetch(long l10) {
        Task task = this.fetchedConfigsCache.get();
        Executor executor = this.executor;
        Continuation continuation = ConfigFetchHandler$$Lambda$1.lambdaFactory$(this, l10);
        return task.continueWithTask(executor, continuation);
    }

    public AnalyticsConnector getAnalyticsConnector() {
        return this.analyticsConnector;
    }
}

