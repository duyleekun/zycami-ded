/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 */
package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

public class DataCollectionConfigStorage {
    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
    private static final String FIREBASE_APP_PREFS = "com.google.firebase.common.prefs:";
    private boolean dataCollectionDefaultEnabled;
    private final Context deviceProtectedContext;
    private final Publisher publisher;
    private final SharedPreferences sharedPreferences;

    public DataCollectionConfigStorage(Context context, String string2, Publisher publisher) {
        boolean bl2;
        this.deviceProtectedContext = context = DataCollectionConfigStorage.directBootSafe(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIREBASE_APP_PREFS);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        context = context.getSharedPreferences(string2, 0);
        this.sharedPreferences = context;
        this.publisher = publisher;
        this.dataCollectionDefaultEnabled = bl2 = this.readAutoDataCollectionEnabled();
    }

    private static Context directBootSafe(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return context;
        }
        return ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean readAutoDataCollectionEnabled() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        String string2 = DATA_COLLECTION_DEFAULT_ENABLED;
        boolean bl2 = sharedPreferences.contains(string2);
        if (bl2) {
            return this.sharedPreferences.getBoolean(string2, true);
        }
        return this.readManifestDataCollectionEnabled();
    }

    private boolean readManifestDataCollectionEnabled() {
        block10: {
            Context context;
            String string2 = DATA_COLLECTION_DEFAULT_ENABLED;
            try {
                context = this.deviceProtectedContext;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            context = context.getPackageManager();
            if (context == null) break block10;
            Object object = this.deviceProtectedContext;
            object = object.getPackageName();
            int n10 = 128;
            context = context.getApplicationInfo((String)object, n10);
            if (context == null) break block10;
            object = context.metaData;
            if (object == null) break block10;
            boolean bl2 = object.containsKey(string2);
            if (!bl2) break block10;
            context = context.metaData;
            return context.getBoolean(string2);
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateDataCollectionDefaultEnabled(boolean bl2) {
        synchronized (this) {
            boolean bl3 = this.dataCollectionDefaultEnabled;
            if (bl3 != bl2) {
                this.dataCollectionDefaultEnabled = bl2;
                Publisher publisher = this.publisher;
                Class<DataCollectionDefaultChange> clazz = DataCollectionDefaultChange.class;
                DataCollectionDefaultChange dataCollectionDefaultChange = new DataCollectionDefaultChange(bl2);
                Event event = new Event(clazz, dataCollectionDefaultChange);
                publisher.publish(event);
            }
            return;
        }
    }

    public boolean isEnabled() {
        synchronized (this) {
            boolean bl2 = this.dataCollectionDefaultEnabled;
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setEnabled(Boolean bl2) {
        synchronized (this) {
            if (bl2 == null) {
                bl2 = this.sharedPreferences;
                bl2 = bl2.edit();
                String string2 = DATA_COLLECTION_DEFAULT_ENABLED;
                bl2 = bl2.remove(string2);
                bl2.apply();
                boolean bl3 = this.readManifestDataCollectionEnabled();
                this.updateDataCollectionDefaultEnabled(bl3);
            } else {
                Boolean bl4 = Boolean.TRUE;
                boolean bl5 = bl4.equals(bl2);
                bl4 = this.sharedPreferences;
                bl4 = bl4.edit();
                String string3 = DATA_COLLECTION_DEFAULT_ENABLED;
                bl4 = bl4.putBoolean(string3, bl5);
                bl4.apply();
                this.updateDataCollectionDefaultEnabled(bl5);
            }
            return;
        }
    }
}

