/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.heartbeatinfo.SdkHeartBeatResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HeartBeatInfoStorage {
    private static final SimpleDateFormat FORMATTER;
    private static final String GLOBAL = "fire-global";
    private static final int HEART_BEAT_COUNT_LIMIT = 200;
    private static final String HEART_BEAT_COUNT_TAG = "fire-count";
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static final String STORAGE_PREFERENCES_NAME = "FirebaseAppHeartBeatStorage";
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences heartBeatSharedPreferences;
    private final SharedPreferences sharedPreferences;

    static {
        SimpleDateFormat simpleDateFormat;
        FORMATTER = simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy z");
    }

    private HeartBeatInfoStorage(Context context) {
        SharedPreferences sharedPreferences;
        this.sharedPreferences = sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        context = context.getSharedPreferences(STORAGE_PREFERENCES_NAME, 0);
        this.heartBeatSharedPreferences = context;
    }

    public HeartBeatInfoStorage(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences;
        this.heartBeatSharedPreferences = sharedPreferences2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void cleanUpStoredHeartBeats() {
        synchronized (this) {
            long l10;
            long l11;
            int n10;
            Object object;
            boolean bl2;
            SharedPreferences sharedPreferences = this.sharedPreferences;
            String string2 = HEART_BEAT_COUNT_TAG;
            long l12 = 0L;
            long l13 = sharedPreferences.getLong(string2, l12);
            Object object2 = new ArrayList();
            Object object3 = this.heartBeatSharedPreferences;
            object3 = object3.getAll();
            object3 = object3.entrySet();
            object3 = object3.iterator();
            while (bl2 = object3.hasNext()) {
                object = object3.next();
                object = (Map.Entry)object;
                object = object.getKey();
                object = (String)object;
                long l14 = Long.parseLong(object);
                object = l14;
                ((ArrayList)object2).add(object);
            }
            Collections.sort(object2);
            object2 = ((ArrayList)object2).iterator();
            do {
                if ((n10 = object2.hasNext()) == 0) {
                    return;
                }
                object3 = object2.next();
                object3 = (Long)object3;
                object = this.heartBeatSharedPreferences;
                object = object.edit();
                object3 = String.valueOf(object3);
                object3 = object.remove((String)object3);
                object3.apply();
                object3 = this.sharedPreferences;
                object3 = object3.edit();
                object = HEART_BEAT_COUNT_TAG;
                long l15 = 1L;
                object3 = object3.putLong(object, l13 -= l15);
                object3.apply();
            } while ((n10 = (l11 = l13 - (l10 = (long)100)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0);
            return;
        }
    }

    public static HeartBeatInfoStorage getInstance(Context object) {
        Class<HeartBeatInfoStorage> clazz = HeartBeatInfoStorage.class;
        synchronized (clazz) {
            HeartBeatInfoStorage heartBeatInfoStorage = instance;
            if (heartBeatInfoStorage == null) {
                instance = heartBeatInfoStorage = new HeartBeatInfoStorage((Context)object);
            }
            object = instance;
            return object;
        }
    }

    public static boolean isSameDateUtc(long l10, long l11) {
        Date date = new Date(l10);
        Object object = new Date(l11);
        SimpleDateFormat simpleDateFormat = FORMATTER;
        String string2 = simpleDateFormat.format(date);
        object = simpleDateFormat.format((Date)object);
        return string2.equals(object) ^ true;
    }

    public void clearStoredHeartBeats() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.heartBeatSharedPreferences;
            sharedPreferences = sharedPreferences.edit();
            sharedPreferences = sharedPreferences.clear();
            sharedPreferences.apply();
            sharedPreferences = this.sharedPreferences;
            sharedPreferences = sharedPreferences.edit();
            String string2 = HEART_BEAT_COUNT_TAG;
            sharedPreferences = sharedPreferences.remove(string2);
            sharedPreferences.apply();
            return;
        }
    }

    public int getHeartBeatCount() {
        return (int)this.sharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
    }

    public long getLastGlobalHeartBeat() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.sharedPreferences;
            String string2 = GLOBAL;
            long l10 = -1;
            long l11 = sharedPreferences.getLong(string2, l10);
            return l11;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getStoredHeartBeats(boolean bl2) {
        synchronized (this) {
            boolean bl3;
            ArrayList arrayList = new ArrayList();
            Object object = this.heartBeatSharedPreferences;
            object = object.getAll();
            object = object.entrySet();
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (Map.Entry)object2;
                Object object3 = object2.getKey();
                object3 = (String)object3;
                long l10 = Long.parseLong(object3);
                object2 = object2.getValue();
                object2 = (String)object2;
                object2 = SdkHeartBeatResult.create(object2, l10);
                arrayList.add(object2);
            }
            Collections.sort(arrayList);
            if (bl2) {
                this.clearStoredHeartBeats();
            }
            return arrayList;
        }
    }

    public boolean shouldSendGlobalHeartBeat(long l10) {
        synchronized (this) {
            String string2 = GLOBAL;
            boolean bl2 = this.shouldSendSdkHeartBeat(string2, l10);
            return bl2;
        }
    }

    public boolean shouldSendSdkHeartBeat(String string2, long l10) {
        synchronized (this) {
            boolean bl2;
            SharedPreferences sharedPreferences;
            block15: {
                block16: {
                    sharedPreferences = this.sharedPreferences;
                    boolean bl3 = sharedPreferences.contains(string2);
                    bl2 = true;
                    if (!bl3) break block15;
                    sharedPreferences = this.sharedPreferences;
                    long l11 = -1;
                    l11 = sharedPreferences.getLong(string2, l11);
                    bl3 = HeartBeatInfoStorage.isSameDateUtc(l11, l10);
                    if (!bl3) break block16;
                    sharedPreferences = this.sharedPreferences;
                    sharedPreferences = sharedPreferences.edit();
                    string2 = sharedPreferences.putLong(string2, l10);
                    string2.apply();
                    return bl2;
                }
                return false;
            }
            sharedPreferences = this.sharedPreferences;
            sharedPreferences = sharedPreferences.edit();
            string2 = sharedPreferences.putLong(string2, l10);
            string2.apply();
            return bl2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void storeHeartBeatInformation(String string2, long l10) {
        synchronized (this) {
            void var2_2;
            SharedPreferences sharedPreferences = this.sharedPreferences;
            String string3 = HEART_BEAT_COUNT_TAG;
            long l11 = 0L;
            long l12 = sharedPreferences.getLong(string3, l11);
            SharedPreferences sharedPreferences2 = this.heartBeatSharedPreferences;
            sharedPreferences2 = sharedPreferences2.edit();
            String string4 = String.valueOf((long)var2_2);
            string2 = sharedPreferences2.putString(string4, string2);
            string2.apply();
            string2 = this.sharedPreferences;
            string2 = string2.edit();
            string4 = HEART_BEAT_COUNT_TAG;
            l11 = 1L;
            string2 = string2.putLong(string4, l12 += l11);
            string2.apply();
            long l13 = 200L;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 > 0) {
                this.cleanUpStoredHeartBeats();
            }
            return;
        }
    }

    public void updateGlobalHeartBeat(long l10) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.sharedPreferences;
            sharedPreferences = sharedPreferences.edit();
            String string2 = GLOBAL;
            SharedPreferences.Editor editor = sharedPreferences.putLong(string2, l10);
            editor.apply();
            return;
        }
    }
}

