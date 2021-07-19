/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$1;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$10;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$2;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$3;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$4;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$5;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$6;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$7;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$8;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$Lambda$9;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigContainer$Builder;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0;
    public static final long DEFAULT_VALUE_FOR_LONG = 0L;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = 255;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC;
    private final ConfigCacheClient activatedConfigsCache;
    private final Context context;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final ConfigFetchHandler fetchHandler;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigMetadataClient frcMetadata;
    private final ConfigGetParameterHandler getHandler;

    public FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.context = context;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.executor = executor;
        this.fetchedConfigsCache = configCacheClient;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
        this.fetchHandler = configFetchHandler;
        this.getHandler = configGetParameterHandler;
        this.frcMetadata = configMetadataClient;
    }

    public static /* synthetic */ boolean access$lambda$0(FirebaseRemoteConfig firebaseRemoteConfig, Task task) {
        return firebaseRemoteConfig.processActivatePutTask(task);
    }

    public static FirebaseRemoteConfig getInstance() {
        return FirebaseRemoteConfig.getInstance(FirebaseApp.getInstance());
    }

    public static FirebaseRemoteConfig getInstance(FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent)firebaseApp.get(RemoteConfigComponent.class)).getDefault();
    }

    private static boolean isFetchedFresh(ConfigContainer object, ConfigContainer object2) {
        boolean bl2;
        if (object2 != null && (bl2 = ((Date)(object = ((ConfigContainer)object).getFetchTime())).equals(object2 = ((ConfigContainer)object2).getFetchTime()))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ Task lambda$activate$2(FirebaseRemoteConfig object, Task object2, Task object3, Task object4) {
        Object object5;
        object4 = Boolean.FALSE;
        boolean bl2 = ((Task)object2).isSuccessful();
        if (bl2 && (object5 = ((Task)object2).getResult()) != null) {
            boolean bl3;
            object2 = (ConfigContainer)((Task)object2).getResult();
            bl2 = ((Task)object3).isSuccessful();
            if (bl2 && !(bl3 = FirebaseRemoteConfig.isFetchedFresh((ConfigContainer)object2, (ConfigContainer)(object3 = (ConfigContainer)((Task)object3).getResult())))) {
                return Tasks.forResult(object4);
            }
            object2 = ((FirebaseRemoteConfig)object).activatedConfigsCache.put((ConfigContainer)object2);
            object3 = ((FirebaseRemoteConfig)object).executor;
            object = FirebaseRemoteConfig$$Lambda$10.lambdaFactory$((FirebaseRemoteConfig)object);
            return ((Task)object2).continueWith((Executor)object3, (Continuation)object);
        }
        return Tasks.forResult(object4);
    }

    public static /* synthetic */ FirebaseRemoteConfigInfo lambda$ensureInitialized$0(Task task, Task task2) {
        return (FirebaseRemoteConfigInfo)task.getResult();
    }

    public static /* synthetic */ Task lambda$fetch$3(ConfigFetchHandler.FetchResponse fetchResponse) {
        return Tasks.forResult(null);
    }

    public static /* synthetic */ Task lambda$fetch$4(ConfigFetchHandler.FetchResponse fetchResponse) {
        return Tasks.forResult(null);
    }

    public static /* synthetic */ Task lambda$fetchAndActivate$1(FirebaseRemoteConfig firebaseRemoteConfig, Void void_) {
        return firebaseRemoteConfig.activate();
    }

    public static /* synthetic */ Void lambda$reset$6(FirebaseRemoteConfig firebaseRemoteConfig) {
        firebaseRemoteConfig.activatedConfigsCache.clear();
        firebaseRemoteConfig.fetchedConfigsCache.clear();
        firebaseRemoteConfig.defaultConfigsCache.clear();
        firebaseRemoteConfig.frcMetadata.clear();
        return null;
    }

    public static /* synthetic */ Void lambda$setConfigSettingsAsync$5(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        firebaseRemoteConfig.frcMetadata.setConfigSettings(firebaseRemoteConfigSettings);
        return null;
    }

    public static /* synthetic */ Task lambda$setDefaultsWithStringsMapAsync$7(ConfigContainer configContainer) {
        return Tasks.forResult(null);
    }

    private boolean processActivatePutTask(Task object) {
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2) {
            this.fetchedConfigsCache.clear();
            Object object2 = ((Task)object).getResult();
            if (object2 != null) {
                object = ((ConfigContainer)((Task)object).getResult()).getAbtExperiments();
                this.updateAbtWithActivatedExperiments((JSONArray)object);
            } else {
                object = TAG;
                object2 = "Activated configs written to disk are null.";
                Log.e((String)object, (String)object2);
            }
            return true;
        }
        return false;
    }

    private Task setDefaultsWithStringsMapAsync(Map object) {
        Object object2;
        try {
            object2 = ConfigContainer.newBuilder();
        }
        catch (JSONException jSONException) {
            Log.e((String)TAG, (String)"The provided defaults map could not be processed.", (Throwable)jSONException);
            return Tasks.forResult(null);
        }
        object = ((ConfigContainer$Builder)object2).replaceConfigsWith((Map)object);
        object = ((ConfigContainer$Builder)object).build();
        object = this.defaultConfigsCache.put((ConfigContainer)object);
        object2 = FirebaseRemoteConfig$$Lambda$9.lambdaFactory$();
        return ((Task)object).onSuccessTask((SuccessContinuation)object2);
    }

    public static List toExperimentInfoMaps(JSONArray jSONArray) {
        int n10;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < (n10 = jSONArray.length()); ++i10) {
            boolean bl2;
            HashMap<String, String> hashMap = new HashMap<String, String>();
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            Iterator iterator2 = jSONObject.keys();
            while (bl2 = iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                String string3 = jSONObject.getString(string2);
                hashMap.put(string2, string3);
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public Task activate() {
        Object object = this.fetchedConfigsCache.get();
        Task task = this.activatedConfigsCache.get();
        Object object2 = new Task[]{object, task};
        object2 = Tasks.whenAllComplete((Task[])object2);
        Executor executor = this.executor;
        object = FirebaseRemoteConfig$$Lambda$4.lambdaFactory$(this, (Task)object, task);
        return ((Task)object2).continueWithTask(executor, (Continuation)object);
    }

    public Task ensureInitialized() {
        Task task = this.activatedConfigsCache.get();
        Object object = this.defaultConfigsCache.get();
        Object object2 = this.fetchedConfigsCache.get();
        Object object3 = this.executor;
        Object object4 = FirebaseRemoteConfig$$Lambda$1.lambdaFactory$(this);
        object3 = Tasks.call((Executor)object3, (Callable)object4);
        object4 = this.firebaseInstallations.getId();
        Task task2 = this.firebaseInstallations.getToken(false);
        Task[] taskArray = new Task[]{task, object, object2, object3, object4, task2};
        task = Tasks.whenAllComplete(taskArray);
        object = this.executor;
        object2 = FirebaseRemoteConfig$$Lambda$2.lambdaFactory$((Task)object3);
        return task.continueWith((Executor)object, (Continuation)object2);
    }

    public Task fetch() {
        Task task = this.fetchHandler.fetch();
        SuccessContinuation successContinuation = FirebaseRemoteConfig$$Lambda$5.lambdaFactory$();
        return task.onSuccessTask(successContinuation);
    }

    public Task fetch(long l10) {
        Task task = this.fetchHandler.fetch(l10);
        SuccessContinuation successContinuation = FirebaseRemoteConfig$$Lambda$6.lambdaFactory$();
        return task.onSuccessTask(successContinuation);
    }

    public Task fetchAndActivate() {
        Task task = this.fetch();
        Executor executor = this.executor;
        SuccessContinuation successContinuation = FirebaseRemoteConfig$$Lambda$3.lambdaFactory$(this);
        return task.onSuccessTask(executor, successContinuation);
    }

    public Map getAll() {
        return this.getHandler.getAll();
    }

    public boolean getBoolean(String string2) {
        return this.getHandler.getBoolean(string2);
    }

    public double getDouble(String string2) {
        return this.getHandler.getDouble(string2);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        return this.frcMetadata.getInfo();
    }

    public Set getKeysByPrefix(String string2) {
        return this.getHandler.getKeysByPrefix(string2);
    }

    public long getLong(String string2) {
        return this.getHandler.getLong(string2);
    }

    public String getString(String string2) {
        return this.getHandler.getString(string2);
    }

    public FirebaseRemoteConfigValue getValue(String string2) {
        return this.getHandler.getValue(string2);
    }

    public Task reset() {
        Executor executor = this.executor;
        Callable callable = FirebaseRemoteConfig$$Lambda$8.lambdaFactory$(this);
        return Tasks.call(executor, callable);
    }

    public Task setConfigSettingsAsync(FirebaseRemoteConfigSettings object) {
        Executor executor = this.executor;
        object = FirebaseRemoteConfig$$Lambda$7.lambdaFactory$(this, (FirebaseRemoteConfigSettings)object);
        return Tasks.call(executor, (Callable)object);
    }

    public Task setDefaultsAsync(int n10) {
        Map map = DefaultsXmlParser.getDefaultsFromXml(this.context, n10);
        return this.setDefaultsWithStringsMapAsync(map);
    }

    public Task setDefaultsAsync(Map object) {
        boolean bl2;
        HashMap<Object, String> hashMap = new HashMap<Object, String>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object object3 = object2.getValue();
            boolean bl3 = object3 instanceof byte[];
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (byte[])object3;
                String string2 = new String((byte[])object3);
                hashMap.put(object2, string2);
                continue;
            }
            object2 = (String)object2.getKey();
            object3 = object3.toString();
            hashMap.put(object2, (String)object3);
        }
        return this.setDefaultsWithStringsMapAsync(hashMap);
    }

    public void startLoadingConfigsFromDisk() {
        this.activatedConfigsCache.get();
        this.defaultConfigsCache.get();
        this.fetchedConfigsCache.get();
    }

    public void updateAbtWithActivatedExperiments(JSONArray object) {
        String string2 = TAG;
        Object object2 = this.firebaseAbt;
        if (object2 == null) {
            return;
        }
        object = FirebaseRemoteConfig.toExperimentInfoMaps(object);
        object2 = this.firebaseAbt;
        try {
            ((FirebaseABTesting)object2).replaceAllExperiments((List)object);
        }
        catch (AbtException abtException) {
            object2 = "Could not update ABT experiments.";
            Log.w((String)string2, (String)object2, (Throwable)abtException);
        }
        catch (JSONException jSONException) {
            object2 = "Could not parse ABT experiments from the JSON response.";
            Log.e((String)string2, (String)object2, (Throwable)jSONException);
        }
    }
}

