/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package com.google.firebase.perf.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;

public class DeviceCacheManager {
    private static final String PREFS_NAME = "FirebasePerfSharedPrefs";
    private static DeviceCacheManager instance;
    private static final AndroidLogger logger;
    private SharedPreferences sharedPref;

    static {
        logger = AndroidLogger.getInstance();
    }

    private DeviceCacheManager() {
    }

    public static void clearInstance() {
        instance = null;
    }

    private Context getFirebaseApplicationContext() {
        try {
            FirebaseApp.getInstance();
        }
        catch (IllegalStateException illegalStateException) {
            return null;
        }
        return FirebaseApp.getInstance().getApplicationContext();
    }

    public static DeviceCacheManager getInstance() {
        Class<DeviceCacheManager> clazz = DeviceCacheManager.class;
        synchronized (clazz) {
            DeviceCacheManager deviceCacheManager = instance;
            if (deviceCacheManager == null) {
                instance = deviceCacheManager = new DeviceCacheManager();
            }
            deviceCacheManager = instance;
            return deviceCacheManager;
        }
    }

    public void clear(String string2) {
        if (string2 == null) {
            logger.debug("Key is null. Cannot clear nullable key");
            return;
        }
        this.sharedPref.edit().remove(string2).apply();
    }

    public boolean containsKey(String string2) {
        boolean bl2;
        SharedPreferences sharedPreferences = this.sharedPref;
        if (sharedPreferences != null && string2 != null && (bl2 = sharedPreferences.contains(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public Optional getBoolean(String string2) {
        Object object;
        boolean bl2;
        if (string2 == null) {
            logger.debug("Key is null when getting boolean value on device cache.");
            return Optional.absent();
        }
        Object object2 = this.sharedPref;
        if (object2 == null) {
            object2 = this.getFirebaseApplicationContext();
            this.setContext((Context)object2);
            object2 = this.sharedPref;
            if (object2 == null) {
                return Optional.absent();
            }
        }
        if (!(bl2 = (object2 = this.sharedPref).contains(string2))) {
            return Optional.absent();
        }
        bl2 = false;
        object2 = null;
        try {
            object = this.sharedPref;
        }
        catch (ClassCastException classCastException) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            object2 = classCastException.getMessage();
            objectArray[1] = object2;
            androidLogger.debug("Key %s from sharedPreferences has type other than long: %s", objectArray);
            return Optional.absent();
        }
        boolean bl3 = object.getBoolean(string2, false);
        object = bl3;
        return Optional.of(object);
    }

    public Optional getFloat(String string2) {
        AndroidLogger androidLogger;
        boolean bl2;
        if (string2 == null) {
            logger.debug("Key is null when getting float value on device cache.");
            return Optional.absent();
        }
        Object object = this.sharedPref;
        if (object == null) {
            object = this.getFirebaseApplicationContext();
            this.setContext((Context)object);
            object = this.sharedPref;
            if (object == null) {
                return Optional.absent();
            }
        }
        if (!(bl2 = (object = this.sharedPref).contains(string2))) {
            return Optional.absent();
        }
        try {
            object = this.sharedPref;
            androidLogger = null;
        }
        catch (ClassCastException classCastException) {
            androidLogger = logger;
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            String string3 = classCastException.getMessage();
            objectArray[1] = string3;
            androidLogger.debug("Key %s from sharedPreferences has type other than float: %s", objectArray);
            return Optional.absent();
        }
        float f10 = object.getFloat(string2, 0.0f);
        object = Float.valueOf(f10);
        return Optional.of(object);
    }

    public Optional getLong(String string2) {
        long l10;
        boolean bl2;
        if (string2 == null) {
            logger.debug("Key is null when getting long value on device cache.");
            return Optional.absent();
        }
        Object object = this.sharedPref;
        if (object == null) {
            object = this.getFirebaseApplicationContext();
            this.setContext((Context)object);
            object = this.sharedPref;
            if (object == null) {
                return Optional.absent();
            }
        }
        if (!(bl2 = (object = this.sharedPref).contains(string2))) {
            return Optional.absent();
        }
        try {
            object = this.sharedPref;
            l10 = 0L;
        }
        catch (ClassCastException classCastException) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            String string3 = classCastException.getMessage();
            objectArray[1] = string3;
            androidLogger.debug("Key %s from sharedPreferences has type other than long: %s", objectArray);
            return Optional.absent();
        }
        long l11 = object.getLong(string2, l10);
        object = l11;
        return Optional.of(object);
    }

    public Optional getString(String string2) {
        Object object;
        boolean bl2;
        if (string2 == null) {
            logger.debug("Key is null when getting String value on device cache.");
            return Optional.absent();
        }
        Object object2 = this.sharedPref;
        if (object2 == null) {
            object2 = this.getFirebaseApplicationContext();
            this.setContext((Context)object2);
            object2 = this.sharedPref;
            if (object2 == null) {
                return Optional.absent();
            }
        }
        if (!(bl2 = (object2 = this.sharedPref).contains(string2))) {
            return Optional.absent();
        }
        try {
            object2 = this.sharedPref;
            object = "";
        }
        catch (ClassCastException classCastException) {
            object = logger;
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            String string3 = classCastException.getMessage();
            objectArray[1] = string3;
            ((AndroidLogger)object).debug("Key %s from sharedPreferences has type other than String: %s", objectArray);
            return Optional.absent();
        }
        object2 = object2.getString(string2, (String)object);
        return Optional.of(object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setContext(Context context) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.sharedPref;
            if (sharedPreferences == null && context != null) {
                String string2 = PREFS_NAME;
                context = context.getSharedPreferences(string2, 0);
                this.sharedPref = context;
            }
            return;
        }
    }

    public boolean setValue(String string2, float f10) {
        if (string2 == null) {
            logger.debug("Key is null when setting float value on device cache.");
            return false;
        }
        SharedPreferences sharedPreferences = this.sharedPref;
        if (sharedPreferences == null) {
            sharedPreferences = this.getFirebaseApplicationContext();
            this.setContext((Context)sharedPreferences);
            sharedPreferences = this.sharedPref;
            if (sharedPreferences == null) {
                return false;
            }
        }
        this.sharedPref.edit().putFloat(string2, f10).apply();
        return true;
    }

    public boolean setValue(String string2, long l10) {
        if (string2 == null) {
            logger.debug("Key is null when setting long value on device cache.");
            return false;
        }
        SharedPreferences sharedPreferences = this.sharedPref;
        if (sharedPreferences == null) {
            sharedPreferences = this.getFirebaseApplicationContext();
            this.setContext((Context)sharedPreferences);
            sharedPreferences = this.sharedPref;
            if (sharedPreferences == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(string2, l10).apply();
        return true;
    }

    public boolean setValue(String string2, String string3) {
        boolean bl2 = false;
        if (string2 == null) {
            logger.debug("Key is null when setting String value on device cache.");
            return false;
        }
        SharedPreferences sharedPreferences = this.sharedPref;
        if (sharedPreferences == null) {
            sharedPreferences = this.getFirebaseApplicationContext();
            this.setContext((Context)sharedPreferences);
            sharedPreferences = this.sharedPref;
            if (sharedPreferences == null) {
                return false;
            }
        }
        bl2 = true;
        if (string3 == null) {
            this.sharedPref.edit().remove(string2).apply();
            return bl2;
        }
        this.sharedPref.edit().putString(string2, string3).apply();
        return bl2;
    }

    public boolean setValue(String string2, boolean bl2) {
        if (string2 == null) {
            logger.debug("Key is null when setting boolean value on device cache.");
            return false;
        }
        SharedPreferences sharedPreferences = this.sharedPref;
        if (sharedPreferences == null) {
            sharedPreferences = this.getFirebaseApplicationContext();
            this.setContext((Context)sharedPreferences);
            sharedPreferences = this.sharedPref;
            if (sharedPreferences == null) {
                return false;
            }
        }
        this.sharedPref.edit().putBoolean(string2, bl2).apply();
        return true;
    }
}

