/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package com.google.firebase.remoteconfig;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigComponent$$Lambda$1;
import com.google.firebase.remoteconfig.RemoteConfigComponent$$Lambda$4;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60L;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    private static final Clock DEFAULT_CLOCK;
    public static final String DEFAULT_NAMESPACE = "firebase";
    private static final Random DEFAULT_RANDOM;
    public static final String FETCH_FILE_NAME = "fetch";
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    private final AnalyticsConnector analyticsConnector;
    private final String appId;
    private final Context context;
    private Map customHeaders;
    private final ExecutorService executorService;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Map frcNamespaceInstances;

    static {
        Random random;
        DEFAULT_CLOCK = DefaultClock.getInstance();
        DEFAULT_RANDOM = random = new Random();
    }

    public RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        this(context, executorService, firebaseApp, firebaseInstallationsApi, firebaseABTesting, analyticsConnector, true);
    }

    public RemoteConfigComponent(Context object, ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector, boolean bl2) {
        HashMap hashMap;
        this.frcNamespaceInstances = hashMap = new HashMap();
        this.customHeaders = hashMap = new HashMap();
        this.context = object;
        this.executorService = executorService;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = analyticsConnector;
        object = firebaseApp.getOptions().getApplicationId();
        this.appId = object;
        if (bl2) {
            object = RemoteConfigComponent$$Lambda$1.lambdaFactory$(this);
            Tasks.call(executorService, (Callable)object);
        }
    }

    private ConfigCacheClient getCacheClient(String object, String object2) {
        Object[] objectArray = new Object[4];
        objectArray[0] = FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX;
        String string2 = this.appId;
        objectArray[1] = string2;
        objectArray[2] = object;
        objectArray[3] = object2;
        object = String.format("%s_%s_%s_%s.json", objectArray);
        object2 = Executors.newCachedThreadPool();
        object = ConfigStorageClient.getInstance(this.context, (String)object);
        return ConfigCacheClient.getInstance((ExecutorService)object2, (ConfigStorageClient)object);
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        ExecutorService executorService = this.executorService;
        ConfigGetParameterHandler configGetParameterHandler = new ConfigGetParameterHandler(executorService, configCacheClient, configCacheClient2);
        return configGetParameterHandler;
    }

    public static ConfigMetadataClient getMetadataClient(Context context, String object, String string2) {
        Object[] objectArray = new Object[]{FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX, object, string2, PREFERENCES_FILE_NAME};
        object = String.format("%s_%s_%s_%s", objectArray);
        context = context.getSharedPreferences((String)object, 0);
        object = new ConfigMetadataClient((SharedPreferences)context);
        return object;
    }

    private static Personalization getPersonalization(FirebaseApp object, String string2, AnalyticsConnector analyticsConnector) {
        boolean bl2 = RemoteConfigComponent.isPrimaryApp((FirebaseApp)object);
        if (bl2 && (bl2 = string2.equals(object = DEFAULT_NAMESPACE)) && analyticsConnector != null) {
            object = new Personalization(analyticsConnector);
            return object;
        }
        return null;
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp, String string2) {
        boolean bl2;
        String string3 = DEFAULT_NAMESPACE;
        boolean bl3 = string2.equals(string3);
        if (bl3 && (bl2 = RemoteConfigComponent.isPrimaryApp(firebaseApp))) {
            bl2 = true;
        } else {
            bl2 = false;
            firebaseApp = null;
        }
        return bl2;
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals("[DEFAULT]");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FirebaseRemoteConfig get(FirebaseApp firebaseApp, String string2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        RemoteConfigComponent remoteConfigComponent = this;
        Object object = string2;
        synchronized (this) {
            Object object2 = this.frcNamespaceInstances;
            boolean bl2 = object2.containsKey(string2);
            if (!bl2) {
                Object object3;
                FirebaseABTesting firebaseABTesting2;
                Context context = this.context;
                boolean bl3 = RemoteConfigComponent.isAbtSupported(firebaseApp, string2);
                if (bl3) {
                    firebaseABTesting2 = firebaseABTesting;
                } else {
                    bl3 = false;
                    object3 = null;
                    firebaseABTesting2 = null;
                }
                object3 = object2;
                object2 = new FirebaseRemoteConfig(context, firebaseApp, firebaseInstallationsApi, firebaseABTesting2, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
                ((FirebaseRemoteConfig)object2).startLoadingConfigsFromDisk();
                object3 = remoteConfigComponent.frcNamespaceInstances;
                object3.put(object, object2);
            }
            object2 = remoteConfigComponent.frcNamespaceInstances;
            object = object2.get(object);
            return (FirebaseRemoteConfig)object;
        }
    }

    public FirebaseRemoteConfig get(String object) {
        synchronized (this) {
            Object object2 = FETCH_FILE_NAME;
            ConfigCacheClient configCacheClient = this.getCacheClient((String)object, (String)object2);
            object2 = ACTIVATE_FILE_NAME;
            ConfigCacheClient configCacheClient2 = this.getCacheClient((String)object, (String)object2);
            object2 = DEFAULTS_FILE_NAME;
            ConfigCacheClient configCacheClient3 = this.getCacheClient((String)object, (String)object2);
            object2 = this.context;
            Object object3 = this.appId;
            ConfigMetadataClient configMetadataClient = RemoteConfigComponent.getMetadataClient((Context)object2, (String)object3, (String)object);
            ConfigGetParameterHandler configGetParameterHandler = this.getGetHandler(configCacheClient2, configCacheClient3);
            object2 = this.firebaseApp;
            object3 = this.analyticsConnector;
            object2 = RemoteConfigComponent.getPersonalization((FirebaseApp)object2, (String)object, (AnalyticsConnector)object3);
            if (object2 != null) {
                object2.getClass();
                object2 = RemoteConfigComponent$$Lambda$4.lambdaFactory$((Personalization)object2);
                configGetParameterHandler.addListener((BiConsumer)object2);
            }
            FirebaseApp firebaseApp = this.firebaseApp;
            FirebaseInstallationsApi firebaseInstallationsApi = this.firebaseInstallations;
            FirebaseABTesting firebaseABTesting = this.firebaseAbt;
            ExecutorService executorService = this.executorService;
            ConfigFetchHandler configFetchHandler = this.getFetchHandler((String)object, configCacheClient, configMetadataClient);
            object3 = this;
            object = this.get(firebaseApp, (String)object, firebaseInstallationsApi, firebaseABTesting, executorService, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
            return object;
        }
    }

    public FirebaseRemoteConfig getDefault() {
        return this.get(DEFAULT_NAMESPACE);
    }

    public ConfigFetchHandler getFetchHandler(String string2, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        synchronized (this) {
            ConfigFetchHandler configFetchHandler;
            Object object;
            FirebaseInstallationsApi firebaseInstallationsApi;
            block17: {
                boolean bl2;
                block16: {
                    firebaseInstallationsApi = this.firebaseInstallations;
                    object = this.firebaseApp;
                    bl2 = RemoteConfigComponent.isPrimaryApp((FirebaseApp)object);
                    if (!bl2) break block16;
                    object = this.analyticsConnector;
                    break block17;
                }
                bl2 = false;
                object = null;
            }
            Object object2 = object;
            ExecutorService executorService = this.executorService;
            Clock clock = DEFAULT_CLOCK;
            Random random = DEFAULT_RANDOM;
            object = this.firebaseApp;
            object = ((FirebaseApp)object).getOptions();
            object = ((FirebaseOptions)object).getApiKey();
            ConfigFetchHttpClient configFetchHttpClient = this.getFrcBackendApiClient((String)object, string2, configMetadataClient);
            Map map = this.customHeaders;
            object = configFetchHandler;
            configFetchHandler = new ConfigFetchHandler(firebaseInstallationsApi, (AnalyticsConnector)object2, executorService, clock, random, configCacheClient, configFetchHttpClient, configMetadataClient, map);
            return configFetchHandler;
        }
    }

    public ConfigFetchHttpClient getFrcBackendApiClient(String string2, String string3, ConfigMetadataClient configMetadataClient) {
        String string4 = this.firebaseApp.getOptions().getApplicationId();
        Context context = this.context;
        long l10 = configMetadataClient.getFetchTimeoutInSeconds();
        long l11 = configMetadataClient.getFetchTimeoutInSeconds();
        ConfigFetchHttpClient configFetchHttpClient = new ConfigFetchHttpClient(context, string4, string2, string3, l10, l11);
        return configFetchHttpClient;
    }

    public void setCustomHeaders(Map map) {
        synchronized (this) {
            this.customHeaders = map;
            return;
        }
    }
}

