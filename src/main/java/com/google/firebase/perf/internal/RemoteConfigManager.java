/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.google.firebase.perf.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.internal.RemoteConfigManager$$Lambda$1;
import com.google.firebase.perf.internal.RemoteConfigManager$$Lambda$2;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RemoteConfigManager {
    private static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0L;
    private static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    private static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    private static final AndroidLogger logger;
    private static final RemoteConfigManager sharedInstance;
    private final ConcurrentHashMap allRcConfigMap;
    private final Executor executor;
    private FirebaseRemoteConfig firebaseRemoteConfig;
    private long firebaseRemoteConfigLastFetchTimestampMs;
    private Provider firebaseRemoteConfigProvider;

    static {
        RemoteConfigManager remoteConfigManager;
        logger = AndroidLogger.getInstance();
        sharedInstance = remoteConfigManager = new RemoteConfigManager();
        TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);
    }

    private RemoteConfigManager() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 0L, timeUnit, linkedBlockingQueue);
        this(threadPoolExecutor, null);
    }

    public RemoteConfigManager(Executor concurrentHashMap, FirebaseRemoteConfig object) {
        long l10;
        this.firebaseRemoteConfigLastFetchTimestampMs = l10 = 0L;
        this.executor = concurrentHashMap;
        this.firebaseRemoteConfig = object;
        if (object == null) {
            concurrentHashMap = new ConcurrentHashMap();
        } else {
            object = ((FirebaseRemoteConfig)object).getAll();
            super(object);
        }
        this.allRcConfigMap = concurrentHashMap;
    }

    public static RemoteConfigManager getInstance() {
        return sharedInstance;
    }

    private FirebaseRemoteConfigValue getRemoteConfigValue(String string2) {
        int n10;
        int n11;
        Object object;
        this.triggerRemoteConfigFetchIfNecessary();
        boolean bl2 = this.isFirebaseRemoteConfigAvailable();
        if (bl2 && (bl2 = ((ConcurrentHashMap)(object = this.allRcConfigMap)).containsKey(string2)) && (n11 = (object = (FirebaseRemoteConfigValue)this.allRcConfigMap.get(string2)).getSource()) == (n10 = 2)) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n10];
            String string3 = object.asString();
            objectArray[0] = string3;
            objectArray[1] = string2;
            androidLogger.debug("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", objectArray);
            return object;
        }
        return null;
    }

    public static int getVersionCode(Context object) {
        PackageManager packageManager;
        try {
            packageManager = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return 0;
        }
        object = object.getPackageName();
        object = packageManager.getPackageInfo((String)object, 0);
        return object.versionCode;
    }

    public static /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0(RemoteConfigManager remoteConfigManager, Boolean object) {
        object = remoteConfigManager.firebaseRemoteConfig.getAll();
        remoteConfigManager.syncConfigValues((Map)object);
    }

    public static /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(RemoteConfigManager remoteConfigManager, Exception exception) {
        remoteConfigManager.firebaseRemoteConfigLastFetchTimestampMs = 0L;
    }

    private boolean shouldFetchAndActivateRemoteConfigValues() {
        long l10 = this.getCurrentSystemTimeMillis();
        long l11 = this.firebaseRemoteConfigLastFetchTimestampMs;
        long l12 = (l10 -= l11) - (l11 = TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        long l10;
        this.firebaseRemoteConfigLastFetchTimestampMs = l10 = this.getCurrentSystemTimeMillis();
        Task task = this.firebaseRemoteConfig.fetchAndActivate();
        Executor executor = this.executor;
        Object object = RemoteConfigManager$$Lambda$1.lambdaFactory$(this);
        task = task.addOnSuccessListener(executor, (OnSuccessListener)object);
        executor = this.executor;
        object = RemoteConfigManager$$Lambda$2.lambdaFactory$(this);
        task.addOnFailureListener(executor, (OnFailureListener)object);
    }

    private void triggerRemoteConfigFetchIfNecessary() {
        boolean bl2 = this.isFirebaseRemoteConfigAvailable();
        if (!bl2) {
            return;
        }
        Map map = this.allRcConfigMap;
        bl2 = map.isEmpty();
        if (bl2) {
            map = this.firebaseRemoteConfig.getAll();
            this.syncConfigValues(map);
        }
        if (bl2 = this.shouldFetchAndActivateRemoteConfigValues()) {
            this.triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
        }
    }

    public Optional getBoolean(String string2) {
        block6: {
            if (string2 == null) {
                logger.debug("The key to get Remote Config boolean value is null.");
                return Optional.absent();
            }
            Object object = this.getRemoteConfigValue(string2);
            if (object != null) {
                boolean bl2 = object.asBoolean();
                Object object2 = bl2;
                try {
                    return Optional.of(object2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object2 = object.asString();
                    bl2 = ((String)object2).isEmpty();
                    if (bl2) break block6;
                    object2 = logger;
                    int n10 = 2;
                    Object[] objectArray = new Object[n10];
                    objectArray[0] = object = object.asString();
                    int n11 = 1;
                    objectArray[n11] = string2;
                    string2 = "Could not parse value: '%s' for key: '%s'.";
                    ((AndroidLogger)object2).debug(string2, objectArray);
                }
            }
        }
        return Optional.absent();
    }

    public long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public Optional getFloat(String string2) {
        block8: {
            if (string2 == null) {
                logger.debug("The key to get Remote Config float value is null.");
                return Optional.absent();
            }
            Object object = this.getRemoteConfigValue(string2);
            if (object != null) {
                double d10 = object.asDouble();
                Object object2 = d10;
                float f10 = ((Double)object2).floatValue();
                object2 = Float.valueOf(f10);
                try {
                    return Optional.of(object2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object2 = object.asString();
                    boolean bl2 = ((String)object2).isEmpty();
                    if (bl2) break block8;
                    object2 = logger;
                    int n10 = 2;
                    Object[] objectArray = new Object[n10];
                    objectArray[0] = object = object.asString();
                    int n11 = 1;
                    objectArray[n11] = string2;
                    string2 = "Could not parse value: '%s' for key: '%s'.";
                    ((AndroidLogger)object2).debug(string2, objectArray);
                }
            }
        }
        return Optional.absent();
    }

    public Optional getLong(String string2) {
        block6: {
            if (string2 == null) {
                logger.debug("The key to get Remote Config long value is null.");
                return Optional.absent();
            }
            Object object = this.getRemoteConfigValue(string2);
            if (object != null) {
                long l10 = object.asLong();
                Object object2 = l10;
                try {
                    return Optional.of(object2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object2 = object.asString();
                    boolean bl2 = ((String)object2).isEmpty();
                    if (bl2) break block6;
                    object2 = logger;
                    int n10 = 2;
                    Object[] objectArray = new Object[n10];
                    objectArray[0] = object = object.asString();
                    int n11 = 1;
                    objectArray[n11] = string2;
                    string2 = "Could not parse value: '%s' for key: '%s'.";
                    ((AndroidLogger)object2).debug(string2, objectArray);
                }
            }
        }
        return Optional.absent();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object getRemoteConfigValueOrDefault(String object, Object object2) {
        Object[] objectArray;
        Object object3;
        Object object4 = this.getRemoteConfigValue((String)object);
        if (object4 == null) return object2;
        int n10 = 1;
        boolean bl2 = object2 instanceof Boolean;
        if (bl2) {
            bl2 = object4.asBoolean();
            object = bl2;
            return object;
        }
        bl2 = object2 instanceof Float;
        if (bl2) {
            double d10 = object4.asDouble();
            object3 = d10;
            float f10 = ((Double)object3).floatValue();
            return Float.valueOf(f10);
        }
        bl2 = object2 instanceof Long;
        if (!bl2 && !(bl2 = object2 instanceof Integer)) {
            bl2 = object2 instanceof String;
            if (bl2) {
                return object4.asString();
            }
            object3 = object4.asString();
            objectArray = logger;
            String string2 = "No matching type found for the defaultValue: '%s', using String.";
            Object[] objectArray2 = new Object[n10];
            objectArray2[0] = object2;
            try {
                objectArray.debug(string2, objectArray2);
                return object3;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = object3;
            }
        } else {
            long l10;
            try {
                l10 = object4.asLong();
            }
            catch (IllegalArgumentException illegalArgumentException) {}
            return l10;
        }
        object3 = object4.asString();
        bl2 = ((String)object3).isEmpty();
        if (bl2) return object2;
        object3 = logger;
        int n11 = 2;
        objectArray = new Object[n11];
        objectArray[0] = object4 = object4.asString();
        objectArray[n10] = object;
        object = "Could not parse value: '%s' for key: '%s'.";
        ((AndroidLogger)object3).debug((String)object, objectArray);
        return object2;
    }

    public Optional getString(String object) {
        if (object == null) {
            logger.debug("The key to get Remote Config String value is null.");
            return Optional.absent();
        }
        if ((object = this.getRemoteConfigValue((String)object)) != null) {
            return Optional.of(object.asString());
        }
        return Optional.absent();
    }

    public boolean isFirebaseRemoteConfigAvailable() {
        boolean bl2;
        Object object = this.firebaseRemoteConfig;
        if (object == null && (object = this.firebaseRemoteConfigProvider) != null && (object = (RemoteConfigComponent)object.get()) != null) {
            String string2 = FIREPERF_FRC_NAMESPACE_NAME;
            this.firebaseRemoteConfig = object = ((RemoteConfigComponent)object).get(string2);
        }
        if ((object = this.firebaseRemoteConfig) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isLastFetchFailed() {
        int n10;
        Object object = this.firebaseRemoteConfig;
        int n11 = 1;
        if (object != null && (n10 = (object = ((FirebaseRemoteConfig)object).getInfo()).getLastFetchStatus()) != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void setFirebaseRemoteConfigProvider(Provider provider) {
        this.firebaseRemoteConfigProvider = provider;
    }

    public void syncConfigValues(Map map) {
        boolean bl2;
        this.allRcConfigMap.putAll(map);
        Iterator iterator2 = this.allRcConfigMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            boolean bl3 = map.containsKey(string2);
            if (bl3) continue;
            ConcurrentHashMap concurrentHashMap = this.allRcConfigMap;
            concurrentHashMap.remove(string2);
        }
    }
}

