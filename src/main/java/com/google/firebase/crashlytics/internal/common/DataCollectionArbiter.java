/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.Utils;

public class DataCollectionArbiter {
    private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    private Boolean crashlyticsDataCollectionEnabled;
    public TaskCompletionSource dataCollectionEnabledTask;
    private final TaskCompletionSource dataCollectionExplicitlyApproved;
    private final FirebaseApp firebaseApp;
    private boolean setInManifest;
    private final SharedPreferences sharedPreferences;
    private final Object taskLock;
    public boolean taskResolved;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DataCollectionArbiter(FirebaseApp object) {
        TaskCompletionSource taskCompletionSource;
        Object object2;
        this.taskLock = object2 = new Object();
        this.dataCollectionEnabledTask = taskCompletionSource = new TaskCompletionSource();
        this.taskResolved = false;
        this.setInManifest = false;
        this.dataCollectionExplicitlyApproved = taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource = ((FirebaseApp)object).getApplicationContext();
        this.firebaseApp = object;
        object = CommonUtils.getSharedPrefs((Context)taskCompletionSource);
        this.sharedPreferences = object;
        object = this.getDataCollectionValueFromSharedPreferences();
        if (object == null) {
            object = this.getDataCollectionValueFromManifest((Context)taskCompletionSource);
        }
        this.crashlyticsDataCollectionEnabled = object;
        synchronized (object2) {
            boolean bl2 = this.isAutomaticDataCollectionEnabled();
            if (bl2) {
                object = this.dataCollectionEnabledTask;
                taskCompletionSource = null;
                ((TaskCompletionSource)object).trySetResult(null);
                this.taskResolved = bl2 = true;
            }
            return;
        }
    }

    private Boolean getDataCollectionValueFromManifest(Context object) {
        if ((object = DataCollectionArbiter.readCrashlyticsDataCollectionEnabledFromManifest(object)) == null) {
            this.setInManifest = false;
            return null;
        }
        this.setInManifest = true;
        return Boolean.TRUE.equals(object);
    }

    private Boolean getDataCollectionValueFromSharedPreferences() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        String string2 = FIREBASE_CRASHLYTICS_COLLECTION_ENABLED;
        boolean bl2 = sharedPreferences.contains(string2);
        if (bl2) {
            this.setInManifest = false;
            return this.sharedPreferences.getBoolean(string2, true);
        }
        return null;
    }

    private void logDataCollectionState(boolean bl2) {
        boolean bl3;
        String string2 = bl2 ? "ENABLED" : "DISABLED";
        Object object = this.crashlyticsDataCollectionEnabled;
        object = object == null ? "global Firebase setting" : ((bl3 = this.setInManifest) ? "firebase_crashlytics_collection_enabled manifest flag" : "API");
        Logger logger = Logger.getLogger();
        Object[] objectArray = new Object[]{string2, object};
        string2 = String.format("Crashlytics automatic data collection %s by %s.", objectArray);
        logger.d(string2);
    }

    private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context object) {
        block9: {
            Object object2 = FIREBASE_CRASHLYTICS_COLLECTION_ENABLED;
            Object object3 = object.getPackageManager();
            if (object3 == null) break block9;
            object = object.getPackageName();
            int n10 = 128;
            object = object3.getApplicationInfo((String)object, n10);
            if (object == null) break block9;
            object3 = object.metaData;
            if (object3 == null) break block9;
            boolean bl2 = object3.containsKey((String)object2);
            if (!bl2) break block9;
            object = object.metaData;
            boolean bl3 = object.getBoolean((String)object2);
            try {
                return bl3;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object2 = Logger.getLogger();
                object3 = "Could not read data collection permission from manifest";
                ((Logger)object2).e((String)object3, nameNotFoundException);
            }
        }
        return null;
    }

    private static void storeDataCollectionValueInSharedPreferences(SharedPreferences sharedPreferences, Boolean bl2) {
        sharedPreferences = sharedPreferences.edit();
        String string2 = FIREBASE_CRASHLYTICS_COLLECTION_ENABLED;
        if (bl2 != null) {
            boolean bl3 = bl2;
            sharedPreferences.putBoolean(string2, bl3);
        } else {
            sharedPreferences.remove(string2);
        }
        sharedPreferences.commit();
    }

    public void grantDataCollectionPermission(boolean bl2) {
        if (bl2) {
            this.dataCollectionExplicitlyApproved.trySetResult(null);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("An invalid data collection token was used.");
        throw illegalStateException;
    }

    public boolean isAutomaticDataCollectionEnabled() {
        synchronized (this) {
            boolean bl2;
            block8: {
                Object object;
                block7: {
                    object = this.crashlyticsDataCollectionEnabled;
                    if (object == null) break block7;
                    bl2 = (Boolean)object;
                    break block8;
                }
                object = this.firebaseApp;
                bl2 = ((FirebaseApp)object).isDataCollectionDefaultEnabled();
            }
            this.logDataCollectionState(bl2);
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setCrashlyticsDataCollectionEnabled(Boolean object) {
        synchronized (this) {
            Throwable throwable2;
            block13: {
                Object object2;
                boolean bl2 = false;
                TaskCompletionSource taskCompletionSource = null;
                if (object != null) {
                    try {
                        this.setInManifest = false;
                    }
                    catch (Throwable throwable2) {
                        break block13;
                    }
                }
                if (object != null) {
                    object2 = object;
                } else {
                    object2 = this.firebaseApp;
                    object2 = ((FirebaseApp)object2).getApplicationContext();
                    object2 = this.getDataCollectionValueFromManifest((Context)object2);
                }
                this.crashlyticsDataCollectionEnabled = object2;
                object2 = this.sharedPreferences;
                DataCollectionArbiter.storeDataCollectionValueInSharedPreferences((SharedPreferences)object2, (Boolean)object);
                object = this.taskLock;
                synchronized (object) {
                    boolean bl3 = this.isAutomaticDataCollectionEnabled();
                    if (bl3) {
                        bl2 = this.taskResolved;
                        if (!bl2) {
                            taskCompletionSource = this.dataCollectionEnabledTask;
                            bl3 = false;
                            object2 = null;
                            taskCompletionSource.trySetResult(null);
                            this.taskResolved = bl2 = true;
                        }
                    } else {
                        bl3 = this.taskResolved;
                        if (bl3) {
                            this.dataCollectionEnabledTask = object2 = new TaskCompletionSource();
                            this.taskResolved = false;
                        }
                    }
                    return;
                }
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Task waitForAutomaticDataCollectionEnabled() {
        Object object = this.taskLock;
        synchronized (object) {
            TaskCompletionSource taskCompletionSource = this.dataCollectionEnabledTask;
            return taskCompletionSource.getTask();
        }
    }

    public Task waitForDataCollectionPermission() {
        Task task = this.dataCollectionExplicitlyApproved.getTask();
        Task task2 = this.waitForAutomaticDataCollectionEnabled();
        return Utils.race(task, task2);
    }
}

