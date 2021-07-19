/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzce;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzah;
import com.google.android.gms.measurement.internal.zzao;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzed;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzg;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzht;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzki;
import com.google.android.gms.measurement.internal.zzkk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzai
extends zzjv {
    private static final String[] zzb = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = new String[]{"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg;
    private static final String[] zzh;
    private static final String[] zzi;
    private final zzah zzj;
    private final zzjr zzk;

    static {
        String string2 = "session_scoped";
        zzg = new String[]{string2, "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
        zzh = new String[]{string2, "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
        zzi = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    }

    public zzai(zzkd object) {
        super((zzkd)object);
        Clock clock = this.zzx.zzax();
        this.zzk = object = new zzjr(clock);
        this.zzx.zzc();
        clock = this.zzx.zzaw();
        object = new zzah(this, (Context)clock, "google_app_measurement.db");
        this.zzj = object;
    }

    public static /* synthetic */ zzjr zzL(zzai zzai2) {
        return zzai2.zzk;
    }

    public static /* synthetic */ String[] zzM() {
        return zzb;
    }

    public static /* synthetic */ String[] zzN() {
        return zzc;
    }

    public static /* synthetic */ String[] zzO() {
        return zzd;
    }

    public static /* synthetic */ String[] zzP() {
        return zzf;
    }

    public static /* synthetic */ String[] zzQ() {
        return zze;
    }

    public static /* synthetic */ String[] zzR() {
        return zzg;
    }

    public static /* synthetic */ String[] zzS() {
        return zzh;
    }

    public static /* synthetic */ String[] zzT() {
        return zzi;
    }

    public static final void zzV(ContentValues object, String string2, Object object2) {
        string2 = "value";
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(object2);
        boolean bl2 = object2 instanceof String;
        if (bl2) {
            object2 = (String)object2;
            object.put(string2, (String)object2);
            return;
        }
        bl2 = object2 instanceof Long;
        if (bl2) {
            object2 = (Long)object2;
            object.put(string2, (Long)object2);
            return;
        }
        bl2 = object2 instanceof Double;
        if (bl2) {
            object2 = (Double)object2;
            object.put(string2, (Double)object2);
            return;
        }
        object = new IllegalArgumentException("Invalid value type");
        throw object;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final long zzZ(String string2, String[] object) {
        Throwable throwable2222222;
        Cursor cursor;
        block8: {
            Object object2;
            block6: {
                long l10;
                block7: {
                    object2 = this.zze();
                    cursor = null;
                    cursor = object2.rawQuery(string2, object);
                    boolean bl2 = cursor.moveToFirst();
                    if (!bl2) break block6;
                    bl2 = false;
                    object = null;
                    l10 = cursor.getLong(0);
                    if (cursor == null) break block7;
                    cursor.close();
                }
                return l10;
            }
            try {
                object2 = "Database returned empty set";
                object = new SQLiteException((String)object2);
                throw object;
            }
            catch (Throwable throwable2222222) {
                break block8;
            }
            catch (SQLiteException sQLiteException) {
                object2 = this.zzx;
                object2 = ((zzfl)object2).zzat();
                object2 = ((zzei)object2).zzb();
                String string3 = "Database error";
                ((zzeg)object2).zzc(string3, string2, (Object)sQLiteException);
                throw sQLiteException;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final long zzaa(String string2, String[] stringArray, long l10) {
        Throwable throwable2222222;
        Cursor cursor;
        block8: {
            block6: {
                long l11;
                block7: {
                    SQLiteDatabase sQLiteDatabase = this.zze();
                    cursor = null;
                    cursor = sQLiteDatabase.rawQuery(string2, stringArray);
                    boolean bl2 = cursor.moveToFirst();
                    if (!bl2) break block6;
                    bl2 = false;
                    stringArray = null;
                    l11 = cursor.getLong(0);
                    if (cursor == null) break block7;
                    {
                        catch (Throwable throwable2222222) {
                            break block8;
                        }
                        catch (SQLiteException sQLiteException) {}
                        {
                            Object object = this.zzx;
                            object = ((zzfl)object).zzat();
                            object = ((zzei)object).zzb();
                            String string3 = "Database error";
                            ((zzeg)object).zzc(string3, string2, (Object)sQLiteException);
                            throw sQLiteException;
                        }
                    }
                    cursor.close();
                }
                return l11;
            }
            if (cursor != null) {
                cursor.close();
            }
            return l10;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw throwable2222222;
    }

    public final Object zzA(Cursor object, int n10) {
        int n11 = object.getType(n10);
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 != n12) {
                    n12 = 3;
                    if (n11 != n12) {
                        int n13 = 4;
                        if (n11 != n13) {
                            object = this.zzx.zzat().zzb();
                            Integer n14 = n11;
                            ((zzeg)object).zzb("Loaded invalid unknown value type, ignoring it", n14);
                            return null;
                        }
                        this.zzx.zzat().zzb().zza("Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    return object.getString(n10);
                }
                return object.getDouble(n10);
            }
            return object.getLong(n10);
        }
        this.zzx.zzat().zzb().zza("Loaded invalid null value from database");
        return null;
    }

    public final long zzB() {
        return this.zzaa("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long zzC(String object, String string2) {
        Throwable throwable2;
        SQLiteDatabase sQLiteDatabase;
        block9: {
            long l10;
            block12: {
                SQLiteException sQLiteException;
                Object object2;
                block10: {
                    block11: {
                        Object object3;
                        long l11;
                        long l12;
                        String string3;
                        Object object4;
                        Object object5;
                        int n10;
                        long l13;
                        block7: {
                            block8: {
                                Preconditions.checkNotEmpty((String)object);
                                string2 = "first_open_count";
                                Preconditions.checkNotEmpty(string2);
                                this.zzg();
                                this.zzX();
                                sQLiteDatabase = this.zze();
                                sQLiteDatabase.beginTransaction();
                                l13 = 0L;
                                try {
                                    n10 = 48;
                                    object2 = new StringBuilder(n10);
                                    object5 = "select ";
                                    ((StringBuilder)object2).append((String)object5);
                                    ((StringBuilder)object2).append(string2);
                                    object5 = " from app2 where app_id=?";
                                    ((StringBuilder)object2).append((String)object5);
                                    object2 = ((StringBuilder)object2).toString();
                                    n10 = 1;
                                    object4 = new String[n10];
                                    string3 = null;
                                    object4[0] = object;
                                    l12 = -1;
                                    l10 = this.zzaa((String)object2, (String[])object4, l12);
                                    l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                                    object4 = "app2";
                                    object3 = "app_id";
                                    if (l11 != false) break block7;
                                    object2 = new ContentValues();
                                    object2.put((String)object3, (String)object);
                                    Integer n11 = 0;
                                    object2.put(string2, n11);
                                    String string4 = "previous_install_count";
                                    object2.put(string4, n11);
                                    n11 = null;
                                    int n12 = 5;
                                    l10 = sQLiteDatabase.insertWithOnConflict((String)object4, null, (ContentValues)object2, n12);
                                    l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                                    if (l11 != false) break block8;
                                    object2 = this.zzx;
                                    object2 = ((zzfl)object2).zzat();
                                    object2 = ((zzei)object2).zzb();
                                    object5 = "Failed to insert column (got -1). appId";
                                    object4 = zzei.zzl((String)object);
                                    ((zzeg)object2).zzc((String)object5, object4, string2);
                                }
                                catch (Throwable throwable2) {
                                    break block9;
                                }
                                catch (SQLiteException sQLiteException2) {
                                    l10 = l13;
                                    sQLiteException = sQLiteException2;
                                    break block10;
                                }
                                sQLiteDatabase.endTransaction();
                                return l12;
                            }
                            l10 = l13;
                        }
                        try {
                            object2 = new ContentValues();
                            object2.put((String)object3, (String)object);
                            long l14 = 1L + l10;
                            object3 = l14;
                            object2.put(string2, (Long)object3);
                            object5 = new String[n10];
                            object5[0] = object;
                            string3 = "app_id = ?";
                            l11 = sQLiteDatabase.update((String)object4, (ContentValues)object2, string3, object5);
                            long l15 = l11;
                            long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
                            if (l16 != false) break block11;
                            Object object6 = this.zzx;
                            object6 = ((zzfl)object6).zzat();
                            object6 = ((zzei)object6).zzb();
                            String string5 = "Failed to update column (got 0). appId";
                            object2 = zzei.zzl((String)object);
                            ((zzeg)object6).zzc(string5, object2, string2);
                        }
                        catch (SQLiteException sQLiteException3) {}
                        sQLiteDatabase.endTransaction();
                        return l12;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    break block12;
                }
                Object object7 = this.zzx;
                object7 = ((zzfl)object7).zzat();
                object7 = ((zzei)object7).zzb();
                object2 = "Error inserting column. appId";
                object = zzei.zzl((String)object);
                ((zzeg)object7).zzd((String)object2, object, string2, (Object)sQLiteException);
            }
            sQLiteDatabase.endTransaction();
            return l10;
        }
        sQLiteDatabase.endTransaction();
        throw throwable2;
    }

    public final long zzD() {
        return this.zzaa("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzE() {
        long l10;
        String string2 = "select count(1) > 0 from raw_events";
        long l11 = this.zzZ(string2, null);
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object != false;
    }

    public final boolean zzF() {
        long l10;
        String string2 = "select count(1) > 0 from raw_events where realtime = 1";
        long l11 = this.zzZ(string2, null);
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object != false;
    }

    public final long zzG(String string2) {
        Preconditions.checkNotEmpty(string2);
        String[] stringArray = new String[]{string2};
        return this.zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", stringArray, 0L);
    }

    public final boolean zzH(String object, Long l10, long l11, zzdb object2) {
        int n10;
        Object object3;
        this.zzg();
        this.zzX();
        Preconditions.checkNotNull(object2);
        Preconditions.checkNotEmpty((String)object);
        Preconditions.checkNotNull(l10);
        object2 = ((zzgb)object2).zzbp();
        zzeg zzeg2 = this.zzx.zzat().zzk();
        String string2 = this.zzx.zzm().zzc((String)object);
        int n11 = ((Object)object2).length;
        Integer n12 = n11;
        String string3 = "Saving complex main event, appId, data size";
        zzeg2.zzc(string3, string2, n12);
        zzeg2 = new ContentValues();
        zzeg2.put("app_id", (String)object);
        string2 = "event_id";
        zzeg2.put(string2, l10);
        l10 = l11;
        Object object4 = "children_to_process";
        zzeg2.put((String)object4, l10);
        zzeg2.put("main_event", (byte[])object2);
        l10 = null;
        try {
            object4 = this.zze();
            object3 = "main_event_params";
            object2 = null;
            n10 = 5;
        }
        catch (SQLiteException sQLiteException) {
            object3 = this.zzx.zzat().zzb();
            object = zzei.zzl((String)object);
            ((zzeg)object3).zzc("Error storing complex main event. appId", object, (Object)sQLiteException);
            return false;
        }
        l11 = object4.insertWithOnConflict((String)object3, null, (ContentValues)zzeg2, n10);
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false) {
            object4 = this.zzx;
            object4 = ((zzfl)object4).zzat();
            object4 = ((zzei)object4).zzb();
            object3 = "Failed to insert complex main event (got -1). appId";
            object2 = zzei.zzl((String)object);
            ((zzeg)object4).zzb((String)object3, object2);
            return false;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public final Bundle zzI(String var1_1) {
        block53: {
            block54: {
                block52: {
                    block49: {
                        block50: {
                            this.zzg();
                            this.zzX();
                            var2_7 = null;
                            var3_8 = this.zze();
                            var4_9 = 1;
                            var5_10 = new String[var4_9];
                            var6_12 = false;
                            var7_13 = 0.0f;
                            var8_14 = null;
                            var5_10[0] = var1_1;
                            var9_15 = "select parameters from default_event_params where app_id=?";
                            var3_8 = var3_8.rawQuery(var9_15, (String[])var5_10);
                            var4_9 = (int)var3_8.moveToFirst();
                            if (var4_9 != 0) break block49;
                            var1_1 = this.zzx;
                            var1_1 = var1_1.zzat();
                            var1_1 = var1_1.zzk();
                            var5_10 = "Default event parameters not found";
                            var1_1.zza((String)var5_10);
                            if (var3_8 == null) break block50;
                            var3_8.close();
                        }
                        return null;
                    }
                    var5_10 = var3_8.getBlob(0);
                    var8_14 = zzdb.zzk();
                    var5_10 = zzkf.zzt((zziw)var8_14, (byte[])var5_10);
                    var5_10 = (zzda)var5_10;
                    var5_10 = var5_10.zzaA();
                    var5_10 = (zzdb)var5_10;
                    var1_1 = this.zza;
                    var1_1.zzn();
                    var1_1 = var5_10.zza();
                    var5_10 = new Bundle();
                    var1_1 = var1_1.iterator();
                    while (true) {
                        var6_12 = var1_1.hasNext();
                        if (!var6_12) break;
                        var8_14 = var1_1.next();
                        var8_14 = (zzdf)var8_14;
                        var9_15 = var8_14.zzb();
                        var10_16 = var8_14.zzi();
                        if (!var10_16) ** GOTO lbl73
                        var11_17 = var8_14.zzj();
                        var5_10.putDouble(var9_15, var11_17);
                        continue;
lbl73:
                        // 1 sources

                        var10_16 = var8_14.zzg();
                        if (!var10_16) ** GOTO lbl80
                        var7_13 = var8_14.zzh();
                        var5_10.putFloat(var9_15, var7_13);
                        continue;
lbl80:
                        // 1 sources

                        var10_16 = var8_14.zzc();
                        if (!var10_16) ** GOTO lbl87
                        var8_14 = var8_14.zzd();
                        var5_10.putString(var9_15, (String)var8_14);
                        continue;
lbl87:
                        // 1 sources

                        var10_16 = var8_14.zze();
                        if (!var10_16) continue;
                        var13_18 = var8_14.zzf();
                        var5_10.putLong(var9_15, var13_18);
                        continue;
                        break;
                    }
                    if (var3_8 != null) {
                        var3_8.close();
                    }
                    return var5_10;
                    catch (IOException var5_11) {
                        block51: {
                            var8_14 = this.zzx;
                            var8_14 = var8_14.zzat();
                            var8_14 = var8_14.zzb();
                            var9_15 = "Failed to retrieve default event parameters. appId";
                            var1_1 = zzei.zzl((String)var1_1);
                            try {
                                var8_14.zzc(var9_15, var1_1, var5_11);
                                if (var3_8 == null) break block51;
                            }
                            catch (SQLiteException var1_2) {
                                break block52;
                            }
                            var3_8.close();
                        }
                        return null;
                    }
                    catch (Throwable var1_3) {
                        break block53;
                    }
                    catch (SQLiteException var1_4) {
                        var3_8 = null;
                    }
                }
                var5_10 = this.zzx;
                var5_10 = var5_10.zzat();
                var5_10 = var5_10.zzb();
                var8_14 = "Error selecting default event parameters";
                var5_10.zzb((String)var8_14, var1_1);
                if (var3_8 == null) break block54;
                var3_8.close();
            }
            return null;
            {
                catch (Throwable var1_5) {
                    var2_7 = var3_8;
                }
            }
        }
        if (var2_7 != null) {
            var2_7.close();
        }
        throw var1_6;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzJ(String var1_1, List var2_2) {
        var3_3 /* !! */  = this;
        var4_4 = var1_1;
        var5_5 = var2_2;
        var6_6 = "app_id=? and audience_id=?";
        var7_7 = "app_id=?";
        var8_14 = "event_filters";
        var9_15 = "property_filters";
        Preconditions.checkNotNull(var2_2);
        var10_16 = 0;
        var11_17 /* !! */  = null;
        while (true) {
            block52: {
                block51: {
                    block49: {
                        block50: {
                            if (var10_16 >= (var12_18 = var2_2.size())) break block49;
                            var13_19 = (zzbt)((zzbu)var5_5.get(var10_16)).zzbu();
                            var14_20 = var13_19.zzd();
                            if (var14_20 == 0) break block50;
                            var15_21 = var13_19;
                            var16_22 = null;
                            break block51;
                        }
                        var27_33 = var6_6;
                        var15_21 = var13_19;
                        break block52;
                    }
                    var27_33 = var6_6;
                    this.zzX();
                    this.zzg();
                    Preconditions.checkNotEmpty(var1_1);
                    Preconditions.checkNotNull(var2_2);
                    var3_3 /* !! */  = this.zze();
                    var3_3 /* !! */ .beginTransaction();
                    try {
                        this.zzX();
                        this.zzg();
                        Preconditions.checkNotEmpty(var1_1);
                        var6_6 = this.zze();
                        var22_28 = 1;
                        var11_17 /* !! */  = new String[var22_28];
                        var12_18 = 0;
                        var13_19 = null;
                        var11_17 /* !! */ [0] = var4_4;
                        var6_6.delete((String)var9_15, (String)var7_7, var11_17 /* !! */ );
                        var11_17 /* !! */  = new String[var22_28];
                        var11_17 /* !! */ [0] = var4_4;
                        var6_6.delete((String)var8_14, (String)var7_7, var11_17 /* !! */ );
                        var6_6 = var2_2.iterator();
                        break;
                    }
                    catch (Throwable var7_12) {
                        var13_19 = this;
                        ** GOTO lbl283
                    }
                }
                for (var14_20 = 0; var14_20 < (var17_23 = var15_21.zzd()); ++var14_20) {
                    var18_24 = (zzbv)var15_21.zze(var14_20).zzbu();
                    var19_25 = (zzbv)var18_24.zzay();
                    var20_26 = zzgi.zzb(var18_24.zza());
                    if (var20_26 != null) {
                        var19_25.zzb((String)var20_26);
                        var21_27 = true;
                    } else {
                        var21_27 = false;
                        var20_26 = null;
                    }
                    var23_29 = null;
                    for (var22_28 = 0; var22_28 < (var24_30 = var18_24.zzc()); ++var22_28) {
                        var25_31 = var18_24.zzd(var22_28);
                        var26_32 = var18_24;
                        var18_24 = var25_31.zzh();
                        var27_33 = var6_6;
                        var6_6 = zzgj.zza;
                        var3_3 /* !! */  = zzgj.zzb;
                        if ((var3_3 /* !! */  = zzht.zzd((String)var18_24, (String[])var6_6, var3_3 /* !! */ )) != null) {
                            var6_6 = (zzbx)var25_31.zzbu();
                            var6_6.zza((String)var3_3 /* !! */ );
                            var3_3 /* !! */  = (zzby)var6_6.zzaA();
                            var19_25.zze(var22_28, (zzby)var3_3 /* !! */ );
                            var21_27 = true;
                        }
                        var3_3 /* !! */  = this;
                        var18_24 = var26_32;
                        var6_6 = var27_33;
                    }
                    var27_33 = var6_6;
                    if (var21_27) {
                        var15_21.zzf(var14_20, (zzbv)var19_25);
                        var3_3 /* !! */  = (zzbu)var13_19.zzaA();
                        var5_5.set(var10_16, var3_3 /* !! */ );
                        var15_21 = var13_19;
                    }
                    var3_3 /* !! */  = this;
                    var6_6 = var27_33;
                }
                var27_33 = var6_6;
            }
            var28_34 = var15_21.zza();
            if (var28_34 != 0) {
                var3_3 /* !! */  = null;
                for (var28_34 = 0; var28_34 < (var29_35 = var15_21.zza()); ++var28_34) {
                    var6_6 = var15_21.zzb(var28_34);
                    var23_29 = var6_6.zzc();
                    var25_31 = zzgk.zza;
                    var16_22 = zzgk.zzb;
                    if ((var23_29 = zzht.zzd((String)var23_29, (String[])var25_31, (String[])var16_22)) == null) continue;
                    var6_6 = (zzce)var6_6.zzbu();
                    var6_6.zza((String)var23_29);
                    var15_21.zzc(var28_34, (zzce)var6_6);
                    var6_6 = (zzbu)var13_19.zzaA();
                    var5_5.set(var10_16, var6_6);
                    var15_21 = var13_19;
                }
            }
            ++var10_16;
            var3_3 /* !! */  = this;
            var6_6 = var27_33;
        }
        block14: while (true) {
            block46: {
                if (!(var30_36 = var6_6.hasNext())) ** GOTO lbl178
                var7_7 = var6_6.next();
                var7_7 = (zzbu)var7_7;
                this.zzX();
                this.zzg();
                Preconditions.checkNotEmpty(var1_1);
                Preconditions.checkNotNull(var7_7);
                var12_18 = (int)var7_7.zza();
                if (var12_18 != 0) ** GOTO lbl145
                var13_19 = this;
                try {
                    block47: {
                        var7_7 = this.zzx;
                        var7_7 = var7_7.zzat();
                        var7_7 = var7_7.zze();
                        var23_29 = "Audience with no ID. appId";
                        var11_17 /* !! */  = zzei.zzl(var1_1);
                        var7_7.zzb((String)var23_29, var11_17 /* !! */ );
                        continue;
lbl145:
                        // 1 sources

                        var13_19 = this;
                        var24_30 = var7_7.zzb();
                        var16_22 = var7_7.zzf();
                        var16_22 = var16_22.iterator();
                        while ((var31_37 = var16_22.hasNext()) != 0) {
                            var15_21 = var16_22.next();
                            var31_37 = (var15_21 = (zzbw)var15_21).zza();
                            if (var31_37 != 0) continue;
                            var7_7 = var13_19.zzx;
                            var7_7 = var7_7.zzat();
                            var7_7 = var7_7.zze();
                            var23_29 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            var11_17 /* !! */  = zzei.zzl(var1_1);
                            var25_31 = var24_30;
                            var7_7.zzc((String)var23_29, var11_17 /* !! */ , var25_31);
                            continue block14;
                        }
                        var16_22 = var7_7.zzc();
                        var16_22 = var16_22.iterator();
                        while ((var31_37 = var16_22.hasNext()) != 0) {
                            var15_21 = var16_22.next();
                            var31_37 = (var15_21 = (zzcf)var15_21).zza();
                            if (var31_37 != 0) continue;
                            var7_7 = var13_19.zzx;
                            var7_7 = var7_7.zzat();
                            var7_7 = var7_7.zze();
                            var23_29 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                            var11_17 /* !! */  = zzei.zzl(var1_1);
                            var25_31 = var24_30;
                            var7_7.zzc((String)var23_29, var11_17 /* !! */ , var25_31);
                            continue block14;
                        }
                        var16_22 = var7_7.zzf();
                        var16_22 = var16_22.iterator();
                        break block46;
lbl178:
                        // 1 sources

                        var39_43 = 0;
                        var5_5 = null;
                        var13_19 = this;
                        var7_7 = new ArrayList();
                        var6_6 = var2_2.iterator();
                        while ((var45_47 = var6_6.hasNext()) != 0) {
                            var8_14 = var6_6.next();
                            var46_48 = (var8_14 = (zzbu)var8_14).zza();
                            if (var46_48 != 0) {
                                var45_47 = var8_14.zzb();
                                var11_17 /* !! */  = var45_47;
                            } else {
                                var10_16 = 0;
                                var11_17 /* !! */  = null;
                            }
                            var7_7.add(var11_17 /* !! */ );
                        }
                        Preconditions.checkNotEmpty(var1_1);
                        this.zzX();
                        this.zzg();
                        var5_5 = this.zze();
                        var29_35 = 1;
                        try {
                            var8_14 = new String[var29_35];
                            var29_35 = 0;
                            var6_6 = null;
                            var8_14[0] = var4_4;
                            var6_6 = "select count(1) from audience_filter_values where app_id=?";
                            var47_49 = super.zzZ((String)var6_6, (String[])var8_14);
                            var9_15 = var13_19.zzx;
                            var9_15 = var9_15.zzc();
                            var22_28 = 2000;
                            var11_17 /* !! */  = zzdw.zzE;
                            var46_48 = var9_15.zzk((String)var4_4, (zzdv)var11_17 /* !! */ );
                        }
                        catch (SQLiteException var7_10) {
                            var5_5 = var13_19.zzx;
                            var5_5 = var5_5.zzat();
                            var5_5 = var5_5.zzb();
                            var6_6 = "Database error querying filters. appId";
                            var4_4 = zzei.zzl(var1_1);
                            var5_5.zzc((String)var6_6, var4_4, (Object)var7_10);
                        }
                        var46_48 = Math.min(var22_28, var46_48);
                        var22_28 = 0;
                        var23_29 = null;
                        var46_48 = Math.max(0, var46_48);
                        var37_42 = var46_48;
                        var29_35 = (int)(var47_49 == var37_42 ? 0 : (var47_49 < var37_42 ? -1 : 1));
                        if (var29_35 > 0) {
                            var6_6 = new ArrayList();
                            var8_14 = null;
                            for (var45_47 = 0; var45_47 < (var22_28 = var7_7.size()); ++var45_47) {
                                var23_29 = var7_7.get(var45_47);
                                if ((var23_29 = (Integer)var23_29) != null) {
                                    var22_28 = var23_29.intValue();
                                    var23_29 = Integer.toString(var22_28);
                                    var6_6.add(var23_29);
                                    continue;
                                }
                                break block47;
                            }
                            var7_7 = ",";
                            var7_7 = TextUtils.join((CharSequence)var7_7, (Iterable)var6_6);
                            var6_6 = String.valueOf(var7_7);
                            var29_35 = var6_6.length();
                            var45_47 = 2;
                            var8_14 = new StringBuilder(var29_35 += var45_47);
                            var6_6 = "(";
                            var8_14.append((String)var6_6);
                            var8_14.append((String)var7_7);
                            var7_7 = ")";
                            var8_14.append((String)var7_7);
                            var7_7 = var8_14.toString();
                            var6_6 = "audience_filter_values";
                            var8_14 = String.valueOf(var7_7);
                            var45_47 = var8_14.length() + 140;
                            var23_29 = new StringBuilder(var45_47);
                            var8_14 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ";
                            var23_29.append((String)var8_14);
                            var23_29.append((String)var7_7);
                            var7_7 = " order by rowid desc limit -1 offset ?)";
                            var23_29.append((String)var7_7);
                            var7_7 = var23_29.toString();
                            var45_47 = 2;
                            var8_14 = new String[var45_47];
                            var22_28 = 0;
                            var23_29 = null;
                            var8_14[0] = var4_4;
                            var4_4 = Integer.toString(var46_48);
                            var46_48 = 1;
                            var8_14[var46_48] = var4_4;
                            var5_5.delete((String)var6_6, (String)var7_7, (String[])var8_14);
                        }
                    }
                    var3_3 /* !! */ .setTransactionSuccessful();
                }
                catch (Throwable var7_11) {}
                var3_3 /* !! */ .endTransaction();
                return;
lbl283:
                // 2 sources

                var3_3 /* !! */ .endTransaction();
                throw var7_13;
            }
            while (true) {
                block53: {
                    var31_37 = var16_22.hasNext();
                    var23_29 = "data";
                    var18_24 = "session_scoped";
                    var19_25 = "filter_id";
                    var11_17 /* !! */  = "audience_id";
                    var20_26 = "app_id";
                    if (var31_37 == 0) break;
                    var15_21 = var16_22.next();
                    var15_21 = (zzbw)var15_21;
                    this.zzX();
                    this.zzg();
                    Preconditions.checkNotEmpty(var1_1);
                    Preconditions.checkNotNull(var15_21);
                    var32_38 = var15_21.zzc();
                    var33_39 = TextUtils.isEmpty((CharSequence)var32_38);
                    if (!var33_39) break block53;
                    var7_7 = var13_19.zzx;
                    var7_7 = var7_7.zzat();
                    var7_7 = var7_7.zze();
                    var23_29 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId";
                    var11_17 /* !! */  = zzei.zzl(var1_1);
                    var16_22 = var24_30;
                    var17_23 = (int)var15_21.zza();
                    if (var17_23 != 0) {
                        var31_37 = var15_21.zzb();
                        var34_40 = var15_21 = Integer.valueOf(var31_37);
                    } else {
                        var34_40 = null;
                    }
                    var15_21 = String.valueOf(var34_40);
                    var7_7.zzd((String)var23_29, var11_17 /* !! */ , var16_22, var15_21);
                    var32_38 = var6_6;
                    ** GOTO lbl457
                }
                var5_5 = var15_21.zzbp();
                var32_38 = var6_6;
                var6_6 = new ContentValues();
                var6_6.put((String)var20_26, (String)var4_4);
                var20_26 = var24_30;
                var6_6.put((String)var11_17 /* !! */ , (Integer)var20_26);
                var10_16 = (int)var15_21.zza();
                if (var10_16 != 0) {
                    var10_16 = var15_21.zzb();
                    var11_17 /* !! */  = var10_16;
                } else {
                    var10_16 = 0;
                    var11_17 /* !! */  = null;
                }
                var6_6.put((String)var19_25, (Integer)var11_17 /* !! */ );
                var11_17 /* !! */  = "event_name";
                var19_25 = var15_21.zzc();
                var6_6.put((String)var11_17 /* !! */ , (String)var19_25);
                var10_16 = (int)var15_21.zzk();
                if (var10_16 != 0) {
                    var10_16 = (int)var15_21.zzm();
                    var11_17 /* !! */  = (boolean)var10_16;
                } else {
                    var10_16 = 0;
                    var11_17 /* !! */  = null;
                }
                var6_6.put((String)var18_24, (Boolean)var11_17 /* !! */ );
                var6_6.put((String)var23_29, (byte[])var5_5);
                try {
                    var5_5 = this.zze();
                    var22_28 = 5;
                    var10_16 = 0;
                    var11_17 /* !! */  = null;
                    var35_41 = var5_5.insertWithOnConflict((String)var8_14, null, (ContentValues)var6_6, var22_28);
                    var37_42 = -1;
                    var39_43 = (int)(var35_41 == var37_42 ? 0 : (var35_41 < var37_42 ? -1 : 1));
                    if (var39_43 == 0) {
                        var5_5 = var13_19.zzx;
                        var5_5 = var5_5.zzat();
                        var5_5 = var5_5.zzb();
                        var6_6 = "Failed to insert event filter (got -1). appId";
                        var23_29 = zzei.zzl(var1_1);
                        var5_5.zzb((String)var6_6, var23_29);
                    }
                    var5_5 = var2_2;
                    var6_6 = var32_38;
                }
                catch (SQLiteException var7_8) {
                    var5_5 = var13_19.zzx;
                    var5_5 = var5_5.zzat();
                    var5_5 = var5_5.zzb();
                    var6_6 = "Error storing event filter. appId";
                    var23_29 = zzei.zzl(var1_1);
                    var5_5.zzc((String)var6_6, var23_29, (Object)var7_8);
                    ** GOTO lbl457
                }
            }
            var32_38 = var6_6;
            var7_7 = var7_7.zzc();
            var7_7 = var7_7.iterator();
            while ((var39_43 = var7_7.hasNext()) != 0) {
                block48: {
                    var5_5 = var7_7.next();
                    var5_5 = (zzcf)var5_5;
                    this.zzX();
                    this.zzg();
                    Preconditions.checkNotEmpty(var1_1);
                    Preconditions.checkNotNull(var5_5);
                    var6_6 = var5_5.zzc();
                    var29_35 = (int)TextUtils.isEmpty((CharSequence)var6_6);
                    if (var29_35 != 0) {
                        var7_7 = var13_19.zzx;
                        var7_7 = var7_7.zzat();
                        var7_7 = var7_7.zze();
                        var6_6 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId";
                        var23_29 = zzei.zzl(var1_1);
                        var11_17 /* !! */  = var24_30;
                        var14_20 = (int)var5_5.zza();
                        if (var14_20 != 0) {
                            var39_43 = var5_5.zzb();
                            var5_5 = var39_43;
                        } else {
                            var39_43 = 0;
                            var5_5 = null;
                        }
                        var5_5 = String.valueOf(var5_5);
                        var7_7.zzd((String)var6_6, var23_29, var11_17 /* !! */ , var5_5);
                    } else {
                        var6_6 = var5_5.zzbp();
                        var16_22 = new ContentValues();
                        var16_22.put((String)var20_26, (String)var4_4);
                        var15_21 = var24_30;
                        var16_22.put((String)var11_17 /* !! */ , (Integer)var15_21);
                        var31_37 = (int)var5_5.zza();
                        if (var31_37 != 0) {
                            var31_37 = var5_5.zzb();
                            var15_21 = var31_37;
                        } else {
                            var31_37 = 0;
                            var15_21 = null;
                        }
                        var16_22.put((String)var19_25, (Integer)var15_21);
                        var15_21 = "property_name";
                        var40_44 = var7_7;
                        var7_7 = var5_5.zzc();
                        var16_22.put((String)var15_21, (String)var7_7);
                        var30_36 = var5_5.zzg();
                        if (var30_36) {
                            var30_36 = var5_5.zzh();
                            var7_7 = var30_36;
                        } else {
                            var30_36 = false;
                            var7_7 = null;
                        }
                        var16_22.put((String)var18_24, (Boolean)var7_7);
                        var16_22.put((String)var23_29, (byte[])var6_6);
                        try {
                            var7_7 = this.zze();
                            var39_43 = 0;
                            var5_5 = null;
                            var29_35 = 5;
                            var41_45 = var7_7.insertWithOnConflict((String)var9_15, null, (ContentValues)var16_22, var29_35);
                            var43_46 = -1;
                            var30_36 = var41_45 == var43_46 ? 0 : (var41_45 < var43_46 ? -1 : 1);
                            if (!var30_36) {
                                var7_7 = var13_19.zzx;
                                var7_7 = var7_7.zzat();
                                var7_7 = var7_7.zzb();
                                var5_5 = "Failed to insert property filter (got -1). appId";
                                var6_6 = zzei.zzl(var1_1);
                                var7_7.zzb((String)var5_5, var6_6);
                                break block48;
                            }
                            var7_7 = var40_44;
                            continue;
                        }
                        catch (SQLiteException var7_9) {
                            var5_5 = var13_19.zzx;
                            var5_5 = var5_5.zzat();
                            var5_5 = var5_5.zzb();
                            var6_6 = "Error storing property filter. appId";
                            var23_29 = zzei.zzl(var1_1);
                            var5_5.zzc((String)var6_6, var23_29, (Object)var7_9);
                        }
                    }
                }
                this.zzX();
                this.zzg();
                Preconditions.checkNotEmpty(var1_1);
                var7_7 = this.zze();
                var39_43 = 2;
                var6_6 = new String[var39_43];
                var39_43 = 0;
                var5_5 = null;
                var6_6[0] = var4_4;
                var5_5 = String.valueOf(var24_30);
                var22_28 = 1;
                var6_6[var22_28] = var5_5;
                var5_5 = var27_33;
                var7_7.delete((String)var9_15, var27_33, (String[])var6_6);
                var29_35 = 2;
                var6_6 = new String[var29_35];
                var22_28 = 0;
                var23_29 = null;
                var6_6[0] = var4_4;
                var23_29 = String.valueOf(var24_30);
                var10_16 = 1;
                var6_6[var10_16] = var23_29;
                var7_7.delete((String)var8_14, var27_33, (String[])var6_6);
                var6_6 = var32_38;
                var5_5 = var2_2;
                continue block14;
            }
            var5_5 = var2_2;
            var6_6 = var32_38;
        }
    }

    public final boolean zzK() {
        Context context = this.zzx.zzaw();
        this.zzx.zzc();
        return context.getDatabasePath("google_app_measurement.db").exists();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzU(String var1_1, long var2_2, long var4_3, zzkc var6_4) {
        block40: {
            block38: {
                block39: {
                    block42: {
                        block35: {
                            block36: {
                                block37: {
                                    var7_5 = this;
                                    var8_6 = var6_4;
                                    Preconditions.checkNotNull(var6_4);
                                    this.zzg();
                                    this.zzX();
                                    var9_7 = null;
                                    var10_8 = this.zze();
                                    var11_22 /* !! */  = TextUtils.isEmpty(null);
                                    var12_23 = "";
                                    var13_24 = -1;
                                    var15_25 = 2;
                                    var16_26 = 1;
                                    var17_27 = null;
                                    if (var11_22 /* !! */  == 0) break block35;
                                    var11_22 /* !! */  = (int)(var4_3 == var13_24 ? 0 : (var4_3 < var13_24 ? -1 : 1));
                                    if (var11_22 /* !! */  != 0) {
                                        var18_28 /* !! */  = new String[var15_25];
                                        var19_29 = String.valueOf(var4_3);
                                        var18_28 /* !! */ [0] = var19_29;
                                        var19_29 = String.valueOf(var2_2);
                                        var18_28 /* !! */ [var16_26] = var19_29;
                                    } else {
                                        var18_28 /* !! */  = new String[var16_26];
                                        var19_29 = String.valueOf(var2_2);
                                        var18_28 /* !! */ [0] = var19_29;
                                    }
                                    if (var11_22 /* !! */  != 0) {
                                        var12_23 = "rowid <= ? and ";
                                    }
                                    var11_22 /* !! */  = var12_23.length() + 148;
                                    var19_29 = new StringBuilder(var11_22 /* !! */ );
                                    var20_30 = "select app_id, metadata_fingerprint from raw_events where ";
                                    var19_29.append((String)var20_30);
                                    var19_29.append((String)var12_23);
                                    var20_30 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
                                    var19_29.append((String)var20_30);
                                    var20_30 = var19_29.toString();
                                    var20_30 = var10_8.rawQuery((String)var20_30, var18_28 /* !! */ );
                                    var21_31 = var20_30.moveToFirst();
                                    if (var21_31 != 0) break block36;
                                    if (var20_30 == null) break block37;
                                    var20_30.close();
                                }
                                return;
                            }
                            var9_7 = var20_30.getString(0);
                            var12_23 = var20_30.getString(var16_26);
                            var20_30.close();
                        }
                        var11_22 /* !! */  = (int)(var4_3 == var13_24 ? 0 : (var4_3 < var13_24 ? -1 : 1));
                        if (var11_22 /* !! */  == 0) ** GOTO lbl64
                        var18_28 /* !! */  = new String[var15_25];
                        var18_28 /* !! */ [0] = null;
                        var19_29 = String.valueOf(var4_3);
                        var18_28 /* !! */ [var16_26] = var19_29;
                        break block42;
lbl64:
                        // 1 sources

                        var18_28 /* !! */  = new String[]{null};
                    }
                    if (var11_22 /* !! */  != 0) {
                        var12_23 = " and rowid <= ?";
                    }
                    var11_22 /* !! */  = var12_23.length() + 84;
                    var19_29 = new StringBuilder(var11_22 /* !! */ );
                    var20_30 = "select metadata_fingerprint from raw_events where app_id = ?";
                    var19_29.append((String)var20_30);
                    var19_29.append((String)var12_23);
                    var20_30 = " order by rowid limit 1;";
                    var19_29.append((String)var20_30);
                    var20_30 = var19_29.toString();
                    var20_30 = var10_8.rawQuery((String)var20_30, var18_28 /* !! */ );
                    var21_31 = var20_30.moveToFirst();
                    if (var21_31 != 0) break block38;
                    if (var20_30 == null) break block39;
                    var20_30.close();
                }
                return;
            }
            var12_23 = var20_30.getString(0);
            var20_30.close();
            catch (Throwable var10_19) {
                break block40;
            }
            catch (SQLiteException var10_20) {
                var11_22 /* !! */  = 0;
                var20_30 = null;
                ** GOTO lbl98
            }
            {
                block41: {
                    catch (SQLiteException var10_9) {}
lbl98:
                    // 2 sources

                    try {
                        var8_6 = var7_5.zzx;
                        var8_6 = var8_6.zzat();
                        var8_6 = var8_6.zzb();
                        var12_23 = "Data loss. Error selecting raw event. appId";
                        var9_7 = zzei.zzl(var9_7);
                        var8_6.zzc((String)var12_23, var9_7, var10_8);
                        if (var20_30 == null) break block41;
                    }
                    catch (Throwable var10_21) {}
                    var20_30.close();
                }
                return;
            }
            finally {
                var22_32 = var20_30;
            }
        }
        if (var9_7 != null) {
            var9_7.close();
        }
        throw var10_15;
    }

    public final boolean zzaz() {
        return false;
    }

    public final void zzb() {
        this.zzX();
        this.zze().beginTransaction();
    }

    public final void zzc() {
        this.zzX();
        this.zze().setTransactionSuccessful();
    }

    public final void zzd() {
        this.zzX();
        this.zze().endTransaction();
    }

    public final SQLiteDatabase zze() {
        zzah zzah2;
        this.zzg();
        try {
            zzah2 = this.zzj;
        }
        catch (SQLiteException sQLiteException) {
            this.zzx.zzat().zze().zzb("Error opening database", (Object)sQLiteException);
            throw sQLiteException;
        }
        return zzah2.getWritableDatabase();
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public final zzao zzf(String string2, String string3) {
        void var4_8;
        Cursor cursor;
        block70: {
            block71: {
                Cursor cursor2;
                Object object;
                String[] stringArray;
                Object object2;
                Object object3;
                Object object4;
                zzai zzai2;
                block72: {
                    Cursor cursor3;
                    block69: {
                        block68: {
                            zzao zzao2;
                            block67: {
                                long l10;
                                Object object5;
                                Object object6;
                                Object object7;
                                long l11;
                                long l12;
                                long l13;
                                long l14;
                                int n10;
                                Object object8;
                                block66: {
                                    long l15;
                                    int n11;
                                    block65: {
                                        long l16;
                                        boolean bl2;
                                        block64: {
                                            block63: {
                                                boolean bl3;
                                                boolean bl4;
                                                block62: {
                                                    long l17;
                                                    block61: {
                                                        block60: {
                                                            block59: {
                                                                block58: {
                                                                    block57: {
                                                                        block56: {
                                                                            block55: {
                                                                                block53: {
                                                                                    block54: {
                                                                                        zzai2 = this;
                                                                                        Preconditions.checkNotEmpty(string2);
                                                                                        Preconditions.checkNotEmpty(string3);
                                                                                        this.zzg();
                                                                                        this.zzX();
                                                                                        object4 = "current_bundle_count";
                                                                                        object3 = "last_fire_timestamp";
                                                                                        object2 = "last_bundled_timestamp";
                                                                                        stringArray = "last_bundled_day";
                                                                                        String string4 = "last_sampled_complex_event_id";
                                                                                        String string5 = "last_sampling_rate";
                                                                                        String string6 = "last_exempt_from_sampling";
                                                                                        String string7 = "current_session_count";
                                                                                        object = Arrays.asList("lifetime_count", object4, object3, object2, stringArray, string4, string5, string6, string7);
                                                                                        object8 = new ArrayList(object);
                                                                                        cursor = null;
                                                                                        object = this.zze();
                                                                                        bl4 = false;
                                                                                        string7 = null;
                                                                                        object4 = new String[]{};
                                                                                        object8 = ((ArrayList)object8).toArray((T[])object4);
                                                                                        object3 = object8;
                                                                                        object3 = object8;
                                                                                        n10 = 2;
                                                                                        stringArray = new String[n10];
                                                                                        stringArray[0] = string2;
                                                                                        bl3 = true;
                                                                                        stringArray[bl3] = string3;
                                                                                        object4 = "events";
                                                                                        object2 = "app_id=? and name=?";
                                                                                        string4 = null;
                                                                                        string5 = null;
                                                                                        bl2 = false;
                                                                                        string6 = null;
                                                                                        cursor2 = object.query((String)object4, object3, (String)object2, stringArray, null, null, null);
                                                                                        n11 = cursor2.moveToFirst();
                                                                                        if (n11 != 0) break block53;
                                                                                        if (cursor2 == null) break block54;
                                                                                        cursor2.close();
                                                                                    }
                                                                                    return null;
                                                                                }
                                                                                l14 = cursor2.getLong(0);
                                                                                l13 = cursor2.getLong((int)(bl3 ? 1 : 0));
                                                                                l12 = cursor2.getLong(n10);
                                                                                n10 = 3;
                                                                                n11 = cursor2.isNull(n10);
                                                                                l16 = 0L;
                                                                                if (n11 == 0) break block55;
                                                                                l11 = l16;
                                                                                break block56;
                                                                            }
                                                                            l11 = cursor2.getLong(n10);
                                                                        }
                                                                        n10 = 4;
                                                                        n11 = cursor2.isNull(n10);
                                                                        if (n11 == 0) break block57;
                                                                        n10 = 0;
                                                                        object8 = null;
                                                                        break block58;
                                                                    }
                                                                    l17 = cursor2.getLong(n10);
                                                                    object8 = l17;
                                                                }
                                                                n11 = 5;
                                                                bl2 = cursor2.isNull(n11);
                                                                if (!bl2) break block59;
                                                                object7 = null;
                                                                break block60;
                                                            }
                                                            l17 = cursor2.getLong(n11);
                                                            object7 = object = Long.valueOf(l17);
                                                        }
                                                        n11 = 6;
                                                        bl2 = cursor2.isNull(n11);
                                                        if (!bl2) break block61;
                                                        object6 = null;
                                                        break block62;
                                                    }
                                                    l17 = cursor2.getLong(n11);
                                                    object6 = object = Long.valueOf(l17);
                                                }
                                                n11 = 7;
                                                bl2 = cursor2.isNull(n11);
                                                if (bl2) break block63;
                                                long l18 = cursor2.getLong(n11);
                                                long l19 = 1L;
                                                n11 = (int)(l18 == l19 ? 0 : (l18 < l19 ? -1 : 1));
                                                if (n11 == 0) {
                                                    bl4 = bl3;
                                                }
                                                object5 = object = Boolean.valueOf(bl4);
                                                break block64;
                                            }
                                            object5 = null;
                                        }
                                        n11 = 8;
                                        bl2 = cursor2.isNull(n11);
                                        if (!bl2) break block65;
                                        l10 = l16;
                                        break block66;
                                    }
                                    l10 = l15 = cursor2.getLong(n11);
                                }
                                object = zzao2;
                                object4 = string2;
                                object3 = string3;
                                cursor3 = cursor2;
                                Object object9 = object7;
                                object7 = object5;
                                zzao2 = new zzao(string2, string3, l14, l13, l10, l12, l11, (Long)object8, (Long)object9, (Long)object6, (Boolean)object5);
                                n10 = (int)(cursor2.moveToNext() ? 1 : 0);
                                if (n10 == 0) break block67;
                                object8 = zzai2.zzx;
                                object8 = ((zzfl)object8).zzat();
                                object8 = ((zzei)object8).zzb();
                                object = "Got multiple records for event aggregates, expected one. appId";
                                object4 = zzei.zzl(string2);
                                try {
                                    ((zzeg)object8).zzb((String)object, object4);
                                }
                                catch (Throwable throwable) {
                                    break block68;
                                }
                                catch (SQLiteException sQLiteException) {
                                    break block69;
                                }
                            }
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            return zzao2;
                            catch (Throwable throwable) {
                                cursor3 = cursor2;
                            }
                        }
                        cursor = cursor3;
                        break block70;
                        catch (SQLiteException sQLiteException) {
                            cursor3 = cursor2;
                        }
                    }
                    cursor2 = cursor3;
                    break block72;
                    catch (Throwable throwable) {
                        break block70;
                    }
                    catch (SQLiteException sQLiteException) {
                        cursor2 = null;
                    }
                }
                object = zzai2.zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzb();
                object4 = "Error querying events. appId";
                object3 = zzei.zzl(string2);
                object2 = zzai2.zzx;
                object2 = ((zzfl)object2).zzm();
                stringArray = string3;
                object2 = ((zzed)object2).zzc(string3);
                try {
                    void var4_10;
                    ((zzeg)object).zzd((String)object4, object3, object2, var4_10);
                    if (cursor2 == null) break block71;
                }
                catch (Throwable throwable) {
                    cursor = cursor2;
                }
                cursor2.close();
            }
            return null;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw var4_8;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void zzh(zzao object) {
        int n10;
        boolean bl2;
        Preconditions.checkNotNull(object);
        this.zzg();
        this.zzX();
        Object object2 = new ContentValues();
        Object object3 = ((zzao)object).zza;
        object2.put("app_id", (String)object3);
        object3 = ((zzao)object).zzb;
        object2.put("name", (String)object3);
        object3 = ((zzao)object).zzc;
        object2.put("lifetime_count", (Long)object3);
        object3 = ((zzao)object).zzd;
        object2.put("current_bundle_count", (Long)object3);
        object3 = ((zzao)object).zzf;
        object2.put("last_fire_timestamp", (Long)object3);
        object3 = ((zzao)object).zzg;
        object2.put("last_bundled_timestamp", (Long)object3);
        object3 = ((zzao)object).zzh;
        object2.put("last_bundled_day", (Long)object3);
        object3 = ((zzao)object).zzi;
        object2.put("last_sampled_complex_event_id", (Long)object3);
        object3 = ((zzao)object).zzj;
        object2.put("last_sampling_rate", (Long)object3);
        long l10 = ((zzao)object).zze;
        object3 = l10;
        object2.put("current_session_count", (Long)object3);
        object3 = ((zzao)object).zzk;
        Object object4 = null;
        if (object3 != null && (bl2 = ((Boolean)object3).booleanValue())) {
            long l11 = 1L;
            object3 = l11;
        } else {
            bl2 = false;
            object3 = null;
        }
        String string2 = "last_exempt_from_sampling";
        object2.put(string2, (Long)object3);
        try {
            object3 = this.zze();
            string2 = "events";
            n10 = 5;
        }
        catch (SQLiteException sQLiteException) {
            object3 = this.zzx.zzat().zzb();
            object = zzei.zzl(((zzao)object).zza);
            ((zzeg)object3).zzc("Error storing event aggregates. appId", object, (Object)sQLiteException);
            return;
        }
        long l12 = object3.insertWithOnConflict(string2, null, (ContentValues)object2, n10);
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 != false) return;
        object2 = this.zzx;
        object2 = ((zzfl)object2).zzat();
        object2 = ((zzei)object2).zzb();
        object3 = "Failed to insert/update event aggregates (got -1). appId";
        object4 = ((zzao)object).zza;
        object4 = zzei.zzl((String)object4);
        ((zzeg)object2).zzb((String)object3, object4);
    }

    public final void zzi(String object, String string2) {
        String[] stringArray;
        int n10;
        SQLiteDatabase sQLiteDatabase;
        Preconditions.checkNotEmpty((String)object);
        Preconditions.checkNotEmpty(string2);
        this.zzg();
        this.zzX();
        try {
            sQLiteDatabase = this.zze();
            n10 = 2;
        }
        catch (SQLiteException sQLiteException) {
            stringArray = this.zzx.zzat().zzb();
            object = zzei.zzl((String)object);
            string2 = this.zzx.zzm().zze(string2);
            stringArray.zzd("Error deleting user property. appId", object, string2, (Object)sQLiteException);
            return;
        }
        stringArray = new String[n10];
        int n11 = 0;
        String string3 = null;
        stringArray[0] = object;
        n11 = 1;
        stringArray[n11] = string2;
        string3 = "user_attributes";
        String string4 = "app_id=? and name=?";
        sQLiteDatabase.delete(string3, string4, stringArray);
    }

    public final boolean zzj(zzki object) {
        boolean bl2;
        block15: {
            Object object2;
            Object object3;
            Object object4;
            Preconditions.checkNotNull(object);
            this.zzg();
            this.zzX();
            Object object5 = ((zzki)object).zza;
            String string2 = ((zzki)object).zzc;
            object5 = this.zzk((String)object5, string2);
            bl2 = true;
            if (object5 == null) {
                object5 = ((zzki)object).zzc;
                object4 = zzkk.zzh((String)object5);
                object3 = null;
                if (object4 != 0) {
                    int n10;
                    int n11;
                    zzdv zzdv2;
                    String string3;
                    long l10;
                    object5 = new String[bl2];
                    object2 = ((zzki)object).zza;
                    object5[0] = object2;
                    object2 = "select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'";
                    long l11 = this.zzZ((String)object2, (String[])object5);
                    long l12 = l11 - (l10 = (long)((zzae)(object5 = this.zzx.zzc())).zzl(string3 = ((zzki)object).zza, zzdv2 = zzdw.zzF, n11 = 25, n10 = 100));
                    object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object4 >= 0) {
                        return false;
                    }
                } else {
                    object2 = "_npa";
                    object5 = ((zzki)object).zzc;
                    object4 = ((String)object2).equals(object5);
                    if (object4 == 0) {
                        object5 = new String[2];
                        object2 = ((zzki)object).zza;
                        object5[0] = object2;
                        object2 = ((zzki)object).zzb;
                        object5[bl2] = object2;
                        object2 = "select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'";
                        long l13 = this.zzZ((String)object2, (String[])object5);
                        object5 = this.zzx;
                        ((zzfl)object5).zzc();
                        long l14 = 25;
                        object4 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
                        if (object4 >= 0) {
                            return false;
                        }
                    }
                }
            }
            object5 = new ContentValues();
            object3 = ((zzki)object).zza;
            object5.put("app_id", (String)object3);
            object3 = ((zzki)object).zzb;
            object5.put("origin", (String)object3);
            object3 = ((zzki)object).zzc;
            object5.put("name", (String)object3);
            long l15 = ((zzki)object).zzd;
            object3 = l15;
            object5.put("set_timestamp", (Long)object3);
            object3 = ((zzki)object).zze;
            object2 = "value";
            zzai.zzV((ContentValues)object5, (String)object2, object3);
            object3 = this.zze();
            object2 = "user_attributes";
            int n12 = 5;
            l15 = object3.insertWithOnConflict((String)object2, null, (ContentValues)object5, n12);
            long l16 = -1;
            object4 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            if (object4 != 0) break block15;
            object5 = this.zzx;
            object5 = ((zzfl)object5).zzat();
            object5 = ((zzei)object5).zzb();
            object3 = "Failed to insert/update user property (got -1). appId";
            object2 = ((zzki)object).zza;
            object2 = zzei.zzl((String)object2);
            try {
                ((zzeg)object5).zzb((String)object3, object2);
            }
            catch (SQLiteException sQLiteException) {
                object3 = this.zzx.zzat().zzb();
                object = zzei.zzl(((zzki)object).zza);
                object2 = "Error storing user property. appId";
                ((zzeg)object3).zzc((String)object2, object, (Object)sQLiteException);
            }
        }
        return bl2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public final zzki zzk(String string2, String string3) {
        void var7_12;
        SQLiteDatabase sQLiteDatabase;
        block37: {
            block38: {
                Object object;
                Object object2;
                String string4;
                Object object3;
                Object object4;
                SQLiteDatabase sQLiteDatabase2;
                String string5;
                zzai zzai2;
                block36: {
                    block35: {
                        Object object5;
                        long l10;
                        boolean bl2;
                        int n10;
                        block33: {
                            block34: {
                                int n11;
                                block31: {
                                    block32: {
                                        zzai2 = this;
                                        string5 = string3;
                                        Preconditions.checkNotEmpty(string2);
                                        Preconditions.checkNotEmpty(string3);
                                        this.zzg();
                                        this.zzX();
                                        sQLiteDatabase = null;
                                        sQLiteDatabase2 = this.zze();
                                        object4 = "set_timestamp";
                                        object3 = "value";
                                        string4 = "origin";
                                        String[] stringArray = new String[]{object4, object3, string4};
                                        n10 = 2;
                                        String[] stringArray2 = new String[n10];
                                        bl2 = false;
                                        object3 = null;
                                        stringArray2[0] = string2;
                                        n11 = 1;
                                        stringArray2[n11] = string3;
                                        String string6 = "user_attributes";
                                        String string7 = "app_id=? and name=?";
                                        sQLiteDatabase2 = sQLiteDatabase2.query(string6, stringArray, string7, stringArray2, null, null, null);
                                        boolean bl3 = sQLiteDatabase2.moveToFirst();
                                        if (bl3) break block31;
                                        if (sQLiteDatabase2 == null) break block32;
                                        sQLiteDatabase2.close();
                                    }
                                    return null;
                                }
                                l10 = sQLiteDatabase2.getLong(0);
                                object5 = this.zzA((Cursor)sQLiteDatabase2, n11);
                                if (object5 != null) break block33;
                                if (sQLiteDatabase2 == null) break block34;
                                sQLiteDatabase2.close();
                            }
                            return null;
                        }
                        object2 = sQLiteDatabase2.getString(n10);
                        object3 = object4;
                        string4 = string2;
                        object = string3;
                        object4 = new zzki(string2, (String)object2, string3, l10, object5);
                        bl2 = sQLiteDatabase2.moveToNext();
                        if (!bl2) break block35;
                        object3 = this.zzx;
                        object3 = ((zzfl)object3).zzat();
                        object3 = ((zzei)object3).zzb();
                        string4 = "Got multiple records for user property, expected one. appId";
                        object2 = zzei.zzl(string2);
                        try {
                            ((zzeg)object3).zzb(string4, object2);
                        }
                        catch (SQLiteException sQLiteException) {
                            break block36;
                        }
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    return object4;
                    catch (Throwable throwable) {
                        break block37;
                    }
                    catch (SQLiteException sQLiteException) {
                        sQLiteDatabase2 = null;
                    }
                }
                object3 = zzai2.zzx;
                object3 = ((zzfl)object3).zzat();
                object3 = ((zzei)object3).zzb();
                string4 = "Error querying user property. appId";
                object2 = zzei.zzl(string2);
                object = zzai2.zzx;
                object = ((zzfl)object).zzm();
                object = ((zzed)object).zze(string5);
                try {
                    ((zzeg)object3).zzd(string4, object2, object, object4);
                    if (sQLiteDatabase2 == null) break block38;
                }
                catch (Throwable throwable) {
                    sQLiteDatabase = sQLiteDatabase2;
                }
                sQLiteDatabase2.close();
            }
            return null;
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        throw var7_12;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final List zzl(String list) {
        Throwable throwable2222222;
        Cursor cursor;
        block11: {
            ArrayList<Object> arrayList;
            block9: {
                block10: {
                    Preconditions.checkNotEmpty((String)((Object)list));
                    this.zzg();
                    this.zzX();
                    arrayList = new ArrayList<Object>();
                    String string2 = "1000";
                    cursor = null;
                    Object object = this.zze();
                    String string3 = "user_attributes";
                    Object object2 = "name";
                    String string4 = "origin";
                    Object object3 = "set_timestamp";
                    Object object4 = "value";
                    object2 = new String[]{object2, string4, object3, object4};
                    string4 = "app_id=?";
                    int n10 = 1;
                    object3 = new String[n10];
                    object3[0] = list;
                    Object object5 = "rowid";
                    object4 = this.zzx;
                    ((zzfl)object4).zzc();
                    object4 = null;
                    cursor = object.query(string3, object2, string4, object3, null, null, (String)object5, string2);
                    int n11 = cursor.moveToFirst();
                    if (n11 == 0) break block9;
                    do {
                        object3 = cursor.getString(0);
                        object = cursor.getString(n10);
                        if (object == null) {
                            object = "";
                        }
                        string4 = object;
                        n11 = 2;
                        long l10 = cursor.getLong(n11);
                        n11 = 3;
                        object5 = this.zzA(cursor, n11);
                        if (object5 == null) {
                            object = this.zzx;
                            object = ((zzfl)object).zzat();
                            object = ((zzei)object).zzb();
                            string3 = "Read invalid user property value, ignoring it. appId";
                            object2 = zzei.zzl(list);
                            ((zzeg)object).zzb(string3, object2);
                            continue;
                        }
                        string3 = object;
                        object2 = list;
                        object = new zzki((String)((Object)list), string4, (String)object3, l10, object5);
                        arrayList.add(object);
                    } while ((n11 = (int)(cursor.moveToNext() ? 1 : 0)) != 0);
                    if (cursor == null) break block10;
                    {
                        block12: {
                            catch (Throwable throwable2222222) {
                                break block11;
                            }
                            catch (SQLiteException sQLiteException) {}
                            {
                                Object object6 = this.zzx;
                                object6 = ((zzfl)object6).zzat();
                                object6 = ((zzei)object6).zzb();
                                String string5 = "Error querying user properties. appId";
                                list = zzei.zzl((String)((Object)list));
                                ((zzeg)object6).zzc(string5, list, (Object)sQLiteException);
                                list = Collections.emptyList();
                                if (cursor == null) break block12;
                            }
                            cursor.close();
                        }
                        return list;
                    }
                    cursor.close();
                }
                return arrayList;
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw throwable2222222;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final List zzm(String var1_1, String var2_2, String var3_3) {
        block19: {
            block18: {
                var4_4 = this;
                Preconditions.checkNotEmpty(var1_1);
                this.zzg();
                this.zzX();
                var5_5 = new List<Object>();
                var6_10 = "1001";
                var7_11 = null;
                try {
                    block22: {
                        block17: {
                            block15: {
                                block21: {
                                    block16: {
                                        block20: {
                                            var9_13 = 3;
                                            var8_12 = new ArrayList(var9_13);
                                            try {
                                                var8_12.add(var1_1);
                                                var11_15 /* !! */  = "app_id=?";
                                                var10_14 = new StringBuilder((String)var11_15 /* !! */ );
                                                var12_16 = TextUtils.isEmpty((CharSequence)var2_2);
                                                if (var12_16 != 0) ** GOTO lbl29
                                                var13_17 = var2_2;
                                            }
                                            catch (SQLiteException var5_8) {}
                                            var8_12.add(var2_2);
                                            var11_15 /* !! */  = " and origin=?";
                                            var10_14.append((String)var11_15 /* !! */ );
                                            break block20;
lbl29:
                                            // 1 sources

                                            var13_17 = var2_2;
                                        }
                                        var12_16 = TextUtils.isEmpty((CharSequence)var3_3);
                                        if (var12_16 == 0) {
                                            var11_15 /* !! */  = String.valueOf(var3_3);
                                            var14_18 = "*";
                                            var11_15 /* !! */  = var11_15 /* !! */ .concat((String)var14_18);
                                            var8_12.add(var11_15 /* !! */ );
                                            var11_15 /* !! */  = " and name glob ?";
                                            var10_14.append((String)var11_15 /* !! */ );
                                        }
                                        var12_16 = var8_12.size();
                                        var11_15 /* !! */  = new String[var12_16];
                                        var8_12 = var8_12.toArray(var11_15 /* !! */ );
                                        var15_19 /* !! */  = var8_12;
                                        var15_19 /* !! */  = var8_12;
                                        var8_12 = this.zze();
                                        var11_15 /* !! */  = "user_attributes";
                                        var14_18 = "name";
                                        var16_20 = "set_timestamp";
                                        var17_21 = "value";
                                        var18_22 = "origin";
                                        var14_18 = new String[]{var14_18, var16_20, var17_21, var18_22};
                                        var16_20 = var10_14.toString();
                                        var18_22 = "rowid";
                                        var10_14 = var4_4.zzx;
                                        var10_14.zzc();
                                        var10_14 = var11_15 /* !! */ ;
                                        var11_15 /* !! */  = var14_18;
                                        var14_18 = var16_20;
                                        var16_20 = null;
                                        var17_21 = null;
                                        var7_11 = var8_12.query((String)var10_14, var11_15 /* !! */ , (String)var14_18, (String[])var15_19 /* !! */ , null, null, (String)var18_22, var6_10);
                                        var19_23 = var7_11.moveToFirst();
                                        if (var19_23 != 0) break block15;
                                        if (var7_11 == null) break block16;
                                        var7_11.close();
                                    }
                                    return var5_5;
                                    break block21;
                                    catch (SQLiteException var5_9) {
                                        // empty catch block
                                    }
                                }
                                var13_17 = var2_2;
                                break block22;
                            }
                            try {
                                do {
                                    var19_23 = var5_5.size();
                                    var10_14 = var4_4.zzx;
                                    var10_14.zzc();
                                    var20_24 = 1000;
                                    if (var19_23 >= var20_24) {
                                        var8_12 = var4_4.zzx;
                                        var8_12 = var8_12.zzat();
                                        var8_12 = var8_12.zzb();
                                        var11_15 /* !! */  = "Read more than the max allowed user properties, ignoring excess";
                                        var14_18 = var4_4.zzx;
                                        var14_18.zzc();
                                        var10_14 = var20_24;
                                        var8_12.zzb((String)var11_15 /* !! */ , var10_14);
                                        break;
                                    }
                                    var19_23 = 0;
                                    var8_12 = null;
                                    var15_19 /* !! */  = var7_11.getString(0);
                                    var19_23 = 1;
                                    var21_25 = var7_11.getLong(var19_23);
                                    var19_23 = 2;
                                    var18_22 = var4_4.zzA(var7_11, var19_23);
                                    var13_17 = var7_11.getString(var9_13);
                                    if (var18_22 == null) {
                                        var8_12 = var4_4.zzx;
                                        var8_12 = var8_12.zzat();
                                        var8_12 = var8_12.zzb();
                                        var10_14 = "(2)Read invalid user property value, ignoring it";
                                        var11_15 /* !! */  = zzei.zzl(var1_1);
                                        var6_10 = var3_3;
                                        var8_12.zzd((String)var10_14, var11_15 /* !! */ , var13_17, var3_3);
                                        continue;
                                    }
                                    var6_10 = var3_3;
                                    var10_14 = var8_12;
                                    var11_15 /* !! */  = var1_1;
                                    var14_18 = var13_17;
                                    var8_12 = new zzki(var1_1, var13_17, (String)var15_19 /* !! */ , var21_25, var18_22);
                                    var5_5.add(var8_12);
                                } while ((var19_23 = (int)var7_11.moveToNext()) != 0);
                                if (var7_11 == null) break block17;
                            }
                            catch (SQLiteException var5_6) {}
                            var7_11.close();
                        }
                        return var5_5;
                    }
                    var8_12 = var4_4.zzx;
                    var8_12 = var8_12.zzat();
                    var8_12 = var8_12.zzb();
                    var10_14 = "(2)Error querying user properties";
                    var11_15 /* !! */  = zzei.zzl(var1_1);
                    var8_12.zzd((String)var10_14, var11_15 /* !! */ , var13_17, var5_5);
                    var5_5 = Collections.emptyList();
                    if (var7_11 == null) break block18;
                }
                catch (Throwable var5_7) {
                    break block19;
                }
                var7_11.close();
            }
            return var5_5;
        }
        if (var7_11 != null) {
            var7_11.close();
        }
        throw var5_7;
    }

    public final boolean zzn(zzaa object) {
        boolean bl2;
        block10: {
            Object object2;
            Object object3;
            boolean bl3;
            Preconditions.checkNotNull(object);
            this.zzg();
            this.zzX();
            Object object4 = ((zzaa)object).zza;
            Preconditions.checkNotNull(object4);
            Object object5 = object.zzc.zzb;
            object5 = this.zzk((String)object4, (String)object5);
            bl2 = true;
            if (object5 == null) {
                object5 = new String[bl2];
                bl3 = false;
                object3 = null;
                object5[0] = object4;
                object2 = "SELECT COUNT(1) FROM conditional_properties WHERE app_id=?";
                long l10 = this.zzZ((String)object2, (String[])object5);
                object5 = this.zzx;
                ((zzfl)object5).zzc();
                long l11 = 1000L;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 >= 0) {
                    return false;
                }
            }
            object5 = new ContentValues();
            object5.put("app_id", (String)object4);
            object3 = ((zzaa)object).zzb;
            object5.put("origin", (String)object3);
            object3 = object.zzc.zzb;
            object5.put("name", (String)object3);
            object3 = Preconditions.checkNotNull(((zzaa)object).zzc.zza());
            zzai.zzV((ContentValues)object5, "value", object3);
            bl3 = ((zzaa)object).zze;
            object3 = bl3;
            object5.put("active", (Boolean)object3);
            object3 = ((zzaa)object).zzf;
            object5.put("trigger_event_name", (String)object3);
            object3 = ((zzaa)object).zzh;
            object5.put("trigger_timeout", (Long)object3);
            object3 = this.zzx.zzl();
            object2 = ((zzaa)object).zzg;
            object3 = ((zzkk)object3).zzX((Parcelable)object2);
            object5.put("timed_out_event", (byte[])object3);
            object3 = ((zzaa)object).zzd;
            object5.put("creation_timestamp", (Long)object3);
            object3 = this.zzx.zzl();
            object2 = ((zzaa)object).zzi;
            object3 = ((zzkk)object3).zzX((Parcelable)object2);
            object5.put("triggered_event", (byte[])object3);
            object3 = object.zzc.zzc;
            object5.put("triggered_timestamp", (Long)object3);
            long l13 = ((zzaa)object).zzj;
            object3 = l13;
            object2 = "time_to_live";
            object5.put((String)object2, (Long)object3);
            object3 = this.zzx.zzl();
            object = ((zzaa)object).zzk;
            object = ((zzkk)object3).zzX((Parcelable)object);
            object3 = "expired_event";
            object5.put((String)object3, (byte[])object);
            object = this.zze();
            object3 = "conditional_properties";
            object2 = null;
            int n10 = 5;
            l13 = object.insertWithOnConflict((String)object3, null, (ContentValues)object5, n10);
            long l14 = -1;
            long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
            if (l15 != false) break block10;
            object = this.zzx;
            object = ((zzfl)object).zzat();
            object = ((zzei)object).zzb();
            object5 = "Failed to insert/update conditional user property (got -1)";
            object3 = zzei.zzl((String)object4);
            try {
                ((zzeg)object).zzb((String)object5, object3);
            }
            catch (SQLiteException sQLiteException) {
                object5 = this.zzx.zzat().zzb();
                object4 = zzei.zzl((String)object4);
                object3 = "Error storing conditional user property";
                ((zzeg)object5).zzc((String)object3, object4, (Object)sQLiteException);
            }
        }
        return bl2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public final zzaa zzo(String string2, String string3) {
        void throwable;
        SQLiteDatabase sQLiteDatabase;
        block62: {
            block63: {
                Object object;
                Object object2;
                String string4;
                Object object3;
                Object object4;
                SQLiteDatabase sQLiteDatabase2;
                String string5;
                zzai zzai2;
                block61: {
                    block60: {
                        boolean bl2;
                        boolean bl3;
                        int n10;
                        int n11;
                        String string6;
                        Object object5;
                        String string7;
                        String string8;
                        Object object6;
                        block58: {
                            block59: {
                                zzai2 = this;
                                string5 = string3;
                                Preconditions.checkNotEmpty(string2);
                                Preconditions.checkNotEmpty(string3);
                                this.zzg();
                                this.zzX();
                                sQLiteDatabase = null;
                                sQLiteDatabase2 = this.zze();
                                String string9 = "origin";
                                String[] stringArray = "value";
                                String string10 = "active";
                                String[] stringArray2 = "trigger_event_name";
                                object6 = "trigger_timeout";
                                string8 = "timed_out_event";
                                string7 = "creation_timestamp";
                                object5 = "triggered_event";
                                String string11 = "triggered_timestamp";
                                String string12 = "time_to_live";
                                string6 = "expired_event";
                                stringArray = new String[]{string9, stringArray, string10, stringArray2, object6, string8, string7, object5, string11, string12, string6};
                                n11 = 2;
                                stringArray2 = new String[n11];
                                n10 = 0;
                                object4 = null;
                                stringArray2[0] = string2;
                                bl3 = true;
                                stringArray2[bl3] = string3;
                                string9 = "conditional_properties";
                                string10 = "app_id=? and name=?";
                                object6 = null;
                                string8 = null;
                                string7 = null;
                                sQLiteDatabase2 = sQLiteDatabase2.query(string9, stringArray, string10, stringArray2, null, null, null);
                                boolean bl4 = sQLiteDatabase2.moveToFirst();
                                if (bl4) break block58;
                                if (sQLiteDatabase2 == null) break block59;
                                sQLiteDatabase2.close();
                            }
                            return null;
                        }
                        string7 = sQLiteDatabase2.getString(0);
                        Object object7 = this.zzA((Cursor)sQLiteDatabase2, (int)(bl3 ? 1 : 0));
                        n11 = sQLiteDatabase2.getInt(n11);
                        if (n11 != 0) {
                            bl2 = bl3;
                        } else {
                            bl2 = false;
                            string6 = null;
                        }
                        n11 = 3;
                        String string13 = sQLiteDatabase2.getString(n11);
                        n11 = 4;
                        long l10 = sQLiteDatabase2.getLong(n11);
                        object3 = zzai2.zza;
                        object3 = ((zzkd)object3).zzn();
                        n10 = 5;
                        object4 = sQLiteDatabase2.getBlob(n10);
                        string4 = zzas.CREATOR;
                        Object object8 = object3 = ((zzkf)object3).zzk((byte[])object4, (Parcelable.Creator)string4);
                        object8 = (zzas)object3;
                        n11 = 6;
                        long l11 = sQLiteDatabase2.getLong(n11);
                        object3 = zzai2.zza;
                        object3 = ((zzkd)object3).zzn();
                        n10 = 7;
                        object4 = sQLiteDatabase2.getBlob(n10);
                        Object object9 = object3 = ((zzkf)object3).zzk((byte[])object4, (Parcelable.Creator)string4);
                        object9 = (zzas)object3;
                        n11 = 8;
                        long l12 = sQLiteDatabase2.getLong(n11);
                        n11 = 9;
                        long l13 = sQLiteDatabase2.getLong(n11);
                        object3 = zzai2.zza;
                        object3 = ((zzkd)object3).zzn();
                        n10 = 10;
                        object4 = sQLiteDatabase2.getBlob(n10);
                        Object object10 = object3 = ((zzkf)object3).zzk((byte[])object4, (Parcelable.Creator)string4);
                        object10 = (zzas)object3;
                        object4 = object5;
                        string4 = string3;
                        object5 = new zzkg(string3, l12, object7, string7);
                        object6 = object3;
                        string8 = string2;
                        object3 = new zzaa(string2, string7, (zzkg)object5, l11, bl2, string13, (zzas)object8, l10, (zzas)object9, l13, (zzas)object10);
                        n10 = (int)(sQLiteDatabase2.moveToNext() ? 1 : 0);
                        if (n10 == 0) break block60;
                        object4 = zzai2.zzx;
                        object4 = ((zzfl)object4).zzat();
                        object4 = ((zzei)object4).zzb();
                        string4 = "Got multiple records for conditional property, expected one";
                        object2 = zzei.zzl(string2);
                        object = zzai2.zzx;
                        object = ((zzfl)object).zzm();
                        object = ((zzed)object).zze(string5);
                        try {
                            ((zzeg)object4).zzc(string4, object2, object);
                        }
                        catch (SQLiteException sQLiteException) {
                            break block61;
                        }
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    return object3;
                    catch (Throwable throwable) {
                        break block62;
                    }
                    catch (SQLiteException sQLiteException) {
                        sQLiteDatabase2 = null;
                    }
                }
                object4 = zzai2.zzx;
                object4 = ((zzfl)object4).zzat();
                object4 = ((zzei)object4).zzb();
                string4 = "Error querying conditional property";
                object2 = zzei.zzl(string2);
                object = zzai2.zzx;
                object = ((zzfl)object).zzm();
                object = ((zzed)object).zze(string5);
                try {
                    ((zzeg)object4).zzd(string4, object2, object, object3);
                    if (sQLiteDatabase2 == null) break block63;
                }
                catch (Throwable throwable) {
                    sQLiteDatabase = sQLiteDatabase2;
                }
                sQLiteDatabase2.close();
            }
            return null;
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        throw throwable;
    }

    public final int zzp(String object, String string2) {
        String[] stringArray;
        int n10;
        SQLiteDatabase sQLiteDatabase;
        Preconditions.checkNotEmpty((String)object);
        Preconditions.checkNotEmpty(string2);
        this.zzg();
        this.zzX();
        try {
            sQLiteDatabase = this.zze();
            n10 = 2;
        }
        catch (SQLiteException sQLiteException) {
            stringArray = this.zzx.zzat().zzb();
            object = zzei.zzl((String)object);
            string2 = this.zzx.zzm().zze(string2);
            stringArray.zzd("Error deleting conditional property", object, string2, (Object)sQLiteException);
            return 0;
        }
        stringArray = new String[n10];
        stringArray[0] = object;
        int n11 = 1;
        stringArray[n11] = string2;
        String string3 = "conditional_properties";
        String string4 = "app_id=? and name=?";
        return sQLiteDatabase.delete(string3, string4, stringArray);
    }

    public final List zzq(String charSequence, String stringArray, String string2) {
        boolean bl2;
        Preconditions.checkNotEmpty((String)charSequence);
        this.zzg();
        this.zzX();
        ArrayList<Object> arrayList = new ArrayList<Object>(3);
        arrayList.add(charSequence);
        String string3 = "app_id=?";
        charSequence = new StringBuilder(string3);
        boolean bl3 = TextUtils.isEmpty((CharSequence)stringArray);
        if (!bl3) {
            arrayList.add(stringArray);
            stringArray = " and origin=?";
            ((StringBuilder)charSequence).append((String)stringArray);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            stringArray = String.valueOf(string2);
            string2 = "*";
            stringArray = stringArray.concat(string2);
            arrayList.add(stringArray);
            stringArray = " and name glob ?";
            ((StringBuilder)charSequence).append((String)stringArray);
        }
        stringArray = new String[arrayList.size()];
        stringArray = arrayList.toArray(stringArray);
        charSequence = ((StringBuilder)charSequence).toString();
        return this.zzr((String)charSequence, stringArray);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final List zzr(String string2, String[] stringArray) {
        Throwable throwable2222222;
        Cursor cursor;
        block12: {
            ArrayList<Object> arrayList;
            block10: {
                block11: {
                    zzai zzai2 = this;
                    this.zzg();
                    this.zzX();
                    arrayList = new ArrayList<Object>();
                    String string3 = "1001";
                    cursor = null;
                    Object object = this.zze();
                    Object object2 = "conditional_properties";
                    Object object3 = "app_id";
                    String string4 = "origin";
                    String string5 = "name";
                    Object object4 = "value";
                    String string6 = "active";
                    String string7 = "trigger_event_name";
                    String string8 = "trigger_timeout";
                    String string9 = "timed_out_event";
                    Object object5 = "creation_timestamp";
                    String string10 = "triggered_event";
                    String string11 = "triggered_timestamp";
                    Object object6 = "time_to_live";
                    String string12 = "expired_event";
                    Object object7 = new String[]{object3, string4, string5, object4, string6, string7, string8, string9, object5, string10, string11, object6, string12};
                    String string13 = "rowid";
                    Object object8 = this.zzx;
                    ((zzfl)object8).zzc();
                    Object object9 = null;
                    object8 = string2;
                    cursor = object.query((String)object2, (String[])object7, string2, stringArray, null, null, string13, string3);
                    boolean bl2 = cursor.moveToFirst();
                    if (!bl2) break block10;
                    do {
                        boolean bl3;
                        bl2 = arrayList.size();
                        object2 = zzai2.zzx;
                        ((zzfl)object2).zzc();
                        boolean bl4 = 1000 != 0;
                        if (bl2 >= bl4) {
                            object = zzai2.zzx;
                            object = ((zzfl)object).zzat();
                            object = ((zzei)object).zzb();
                            object7 = "Read more than the max allowed conditional properties, ignoring extra";
                            object8 = zzai2.zzx;
                            ((zzfl)object8).zzc();
                            object2 = (int)(bl4 ? 1 : 0);
                            ((zzeg)object).zzb((String)object7, object2);
                            break;
                        }
                        bl2 = false;
                        object = null;
                        string4 = cursor.getString(0);
                        bl4 = true;
                        string5 = cursor.getString((int)(bl4 ? 1 : 0));
                        int n10 = 2;
                        object8 = cursor.getString(n10);
                        n10 = 3;
                        object9 = zzai2.zzA(cursor, n10);
                        n10 = 4;
                        if ((n10 = cursor.getInt(n10)) != 0) {
                            bl3 = bl4;
                        } else {
                            bl3 = false;
                            string8 = null;
                        }
                        bl2 = 5 != 0;
                        string9 = cursor.getString((int)(bl2 ? 1 : 0));
                        bl2 = 6 != 0;
                        long l10 = cursor.getLong((int)(bl2 ? 1 : 0));
                        object = zzai2.zza;
                        object = ((zzkd)object).zzn();
                        bl4 = 7 != 0;
                        object2 = cursor.getBlob((int)(bl4 ? 1 : 0));
                        object7 = zzas.CREATOR;
                        object5 = object = ((zzkf)object).zzk((byte[])object2, (Parcelable.Creator)object7);
                        object5 = (zzas)object;
                        bl2 = 8 != 0;
                        long l11 = cursor.getLong((int)(bl2 ? 1 : 0));
                        object = zzai2.zza;
                        object = ((zzkd)object).zzn();
                        bl4 = 9 != 0;
                        object2 = cursor.getBlob((int)(bl4 ? 1 : 0));
                        object6 = object = ((zzkf)object).zzk((byte[])object2, (Parcelable.Creator)object7);
                        object6 = (zzas)object;
                        bl2 = 10 != 0;
                        long l12 = cursor.getLong((int)(bl2 ? 1 : 0));
                        bl2 = 11 != 0;
                        long l13 = cursor.getLong((int)(bl2 ? 1 : 0));
                        object = zzai2.zza;
                        object = ((zzkd)object).zzn();
                        bl4 = 12 != 0;
                        object2 = cursor.getBlob((int)(bl4 ? 1 : 0));
                        Object object10 = object = ((zzkf)object).zzk((byte[])object2, (Parcelable.Creator)object7);
                        object10 = (zzas)object;
                        object7 = object4;
                        string13 = string5;
                        object4 = new zzkg((String)object8, l12, object9, string5);
                        object3 = object;
                        object = new zzaa(string4, string5, (zzkg)object4, l11, bl3, string9, (zzas)object5, l10, (zzas)object6, l13, (zzas)object10);
                        arrayList.add(object);
                    } while (bl2 = cursor.moveToNext());
                    if (cursor == null) break block11;
                    {
                        List list;
                        block13: {
                            catch (Throwable throwable2222222) {
                                break block12;
                            }
                            catch (SQLiteException sQLiteException) {}
                            {
                                Object object11 = zzai2.zzx;
                                object11 = ((zzfl)object11).zzat();
                                object11 = ((zzei)object11).zzb();
                                String string14 = "Error querying conditional user property value";
                                ((zzeg)object11).zzb(string14, (Object)sQLiteException);
                                list = Collections.emptyList();
                                if (cursor == null) break block13;
                            }
                            cursor.close();
                        }
                        return list;
                    }
                    cursor.close();
                }
                return arrayList;
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw throwable2222222;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzg zzs(String string2) {
        void var45_48;
        SQLiteDatabase sQLiteDatabase;
        block23: {
            block24: {
                Object object;
                Object object2;
                SQLiteDatabase sQLiteDatabase2;
                Object object3;
                zzai zzai2;
                block22: {
                    block21: {
                        boolean bl2;
                        int n10;
                        Object object4;
                        block19: {
                            block20: {
                                zzai2 = this;
                                object3 = string2;
                                Preconditions.checkNotEmpty(string2);
                                this.zzg();
                                this.zzX();
                                sQLiteDatabase = null;
                                sQLiteDatabase2 = this.zze();
                                object2 = "app_instance_id";
                                object = "gmp_app_id";
                                object4 = "resettable_device_id_hash";
                                String[] stringArray = "last_bundle_index";
                                String string3 = "last_bundle_start_timestamp";
                                String string4 = "last_bundle_end_timestamp";
                                String string5 = "app_version";
                                String string6 = "app_store";
                                String string7 = "gmp_version";
                                String string8 = "dev_cert_hash";
                                String string9 = "measurement_enabled";
                                String string10 = "day";
                                String string11 = "daily_public_events_count";
                                String string12 = "daily_events_count";
                                String string13 = "daily_conversions_count";
                                String string14 = "config_fetched_time";
                                String string15 = "failed_config_fetch_time";
                                String string16 = "app_version_int";
                                String string17 = "firebase_instance_id";
                                String string18 = "daily_error_events_count";
                                String string19 = "daily_realtime_events_count";
                                String string20 = "health_monitor_sample";
                                String string21 = "android_id";
                                String string22 = "adid_reporting_enabled";
                                String string23 = "admob_app_id";
                                String string24 = "dynamite_version";
                                String string25 = "safelisted_events";
                                String string26 = "ga_app_id";
                                object = new String[]{object2, object, object4, stringArray, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, string24, string25, string26};
                                n10 = 1;
                                stringArray = new String[n10];
                                string6 = null;
                                stringArray[0] = string2;
                                object2 = "apps";
                                object4 = "app_id=?";
                                bl2 = false;
                                string3 = null;
                                string4 = null;
                                string5 = null;
                                sQLiteDatabase2 = sQLiteDatabase2.query((String)object2, (String[])object, (String)object4, stringArray, null, null, null);
                                boolean bl3 = sQLiteDatabase2.moveToFirst();
                                if (bl3) break block19;
                                if (sQLiteDatabase2 == null) break block20;
                                sQLiteDatabase2.close();
                            }
                            return null;
                        }
                        try {
                            Object object5;
                            object = this.zza;
                            object = ((zzkd)object).zzR();
                            object2 = new zzg((zzfl)object, string2);
                            object = sQLiteDatabase2.getString(0);
                            ((zzg)object2).zze((String)object);
                            object = sQLiteDatabase2.getString(n10);
                            ((zzg)object2).zzg((String)object);
                            int n11 = 2;
                            object = sQLiteDatabase2.getString(n11);
                            ((zzg)object2).zzm((String)object);
                            n11 = 3;
                            long l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzH(l10);
                            n11 = 4;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzq(l10);
                            n11 = 5;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzs(l10);
                            n11 = 6;
                            object = sQLiteDatabase2.getString(n11);
                            ((zzg)object2).zzu((String)object);
                            n11 = 7;
                            object = sQLiteDatabase2.getString(n11);
                            ((zzg)object2).zzy((String)object);
                            n11 = 8;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzA(l10);
                            n11 = 9;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzC(l10);
                            n11 = 10;
                            int n12 = sQLiteDatabase2.isNull(n11);
                            if (n12 == 0 && (n11 = sQLiteDatabase2.getInt(n11)) == 0) {
                                n11 = 0;
                                object = null;
                            } else {
                                n11 = n10;
                            }
                            ((zzg)object2).zzG(n11 != 0);
                            n11 = 11;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzP(l10);
                            n11 = 12;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzR(l10);
                            n11 = 13;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzT(l10);
                            n11 = 14;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzV(l10);
                            n11 = 15;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzK(l10);
                            n11 = 16;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzM(l10);
                            n11 = 17;
                            n12 = sQLiteDatabase2.isNull(n11);
                            if (n12 != 0) {
                                l10 = 0x80000000L;
                            } else {
                                n11 = sQLiteDatabase2.getInt(n11);
                                l10 = n11;
                            }
                            ((zzg)object2).zzw(l10);
                            n11 = 18;
                            object = sQLiteDatabase2.getString(n11);
                            ((zzg)object2).zzo((String)object);
                            n11 = 19;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzZ(l10);
                            n11 = 20;
                            l10 = sQLiteDatabase2.getLong(n11);
                            ((zzg)object2).zzX(l10);
                            n11 = 21;
                            object = sQLiteDatabase2.getString(n11);
                            ((zzg)object2).zzac((String)object);
                            object = zzai2.zzx;
                            object = ((zzfl)object).zzc();
                            object4 = zzdw.zzav;
                            n11 = (int)(((zzae)object).zzn(null, (zzdv)object4) ? 1 : 0);
                            long l11 = 0L;
                            if (n11 == 0) {
                                n11 = 22;
                                bl2 = sQLiteDatabase2.isNull(n11);
                                long l12 = bl2 ? l11 : sQLiteDatabase2.getLong(n11);
                                ((zzg)object2).zzae(l12);
                            }
                            if (!(bl2 = sQLiteDatabase2.isNull(n11 = 23)) && (n11 = sQLiteDatabase2.getInt(n11)) == 0) {
                                n10 = 0;
                                object5 = null;
                            }
                            ((zzg)object2).zzag(n10 != 0);
                            n10 = 24;
                            object5 = sQLiteDatabase2.getString(n10);
                            ((zzg)object2).zzi((String)object5);
                            n10 = 25;
                            n11 = (int)(sQLiteDatabase2.isNull(n10) ? 1 : 0);
                            if (n11 == 0) {
                                l11 = sQLiteDatabase2.getLong(n10);
                            }
                            ((zzg)object2).zzE(l11);
                            n10 = 26;
                            n11 = (int)(sQLiteDatabase2.isNull(n10) ? 1 : 0);
                            if (n11 == 0) {
                                object5 = sQLiteDatabase2.getString(n10);
                                object = ",";
                                n12 = -1;
                                object5 = ((String)object5).split((String)object, n12);
                                object5 = Arrays.asList(object5);
                                ((zzg)object2).zzak((List)object5);
                            }
                            zzmg.zzb();
                            object5 = zzai2.zzx;
                            object5 = ((zzfl)object5).zzc();
                            object = zzdw.zzah;
                            n10 = (int)(((zzae)object5).zzn((String)object3, (zzdv)object) ? 1 : 0);
                            if (n10 != 0) {
                                n10 = 27;
                                object5 = sQLiteDatabase2.getString(n10);
                                ((zzg)object2).zzk((String)object5);
                            }
                            ((zzg)object2).zzb();
                            n10 = (int)(sQLiteDatabase2.moveToNext() ? 1 : 0);
                            if (n10 != 0) {
                                object5 = zzai2.zzx;
                                object5 = ((zzfl)object5).zzat();
                                object5 = ((zzei)object5).zzb();
                                object = "Got multiple records for app, expected one. appId";
                                object4 = zzei.zzl(string2);
                                ((zzeg)object5).zzb((String)object, object4);
                            }
                            if (sQLiteDatabase2 == null) break block21;
                        }
                        catch (SQLiteException sQLiteException) {
                            break block22;
                        }
                        sQLiteDatabase2.close();
                    }
                    return object2;
                    catch (Throwable throwable) {
                        break block23;
                    }
                    catch (SQLiteException sQLiteException) {
                        sQLiteDatabase2 = null;
                    }
                }
                try {
                    void var45_46;
                    object2 = zzai2.zzx;
                    object2 = ((zzfl)object2).zzat();
                    object2 = ((zzei)object2).zzb();
                    object = "Error querying app. appId";
                    object3 = zzei.zzl(string2);
                    ((zzeg)object2).zzc((String)object, object3, var45_46);
                    if (sQLiteDatabase2 == null) break block24;
                }
                catch (Throwable throwable) {
                    sQLiteDatabase = sQLiteDatabase2;
                }
                sQLiteDatabase2.close();
            }
            return null;
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        throw var45_48;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void zzt(zzg object) {
        int n10;
        int n11;
        Object object2 = "apps";
        Preconditions.checkNotNull(object);
        this.zzg();
        this.zzX();
        Object object3 = ((zzg)object).zzc();
        Preconditions.checkNotNull(object3);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", (String)object3);
        String[] stringArray = ((zzg)object).zzd();
        contentValues.put("app_instance_id", (String)stringArray);
        stringArray = ((zzg)object).zzf();
        contentValues.put("gmp_app_id", (String)stringArray);
        stringArray = ((zzg)object).zzl();
        contentValues.put("resettable_device_id_hash", (String)stringArray);
        stringArray = ((zzg)object).zzI();
        contentValues.put("last_bundle_index", (Long)stringArray);
        stringArray = ((zzg)object).zzp();
        contentValues.put("last_bundle_start_timestamp", (Long)stringArray);
        stringArray = ((zzg)object).zzr();
        contentValues.put("last_bundle_end_timestamp", (Long)stringArray);
        stringArray = ((zzg)object).zzt();
        contentValues.put("app_version", (String)stringArray);
        stringArray = ((zzg)object).zzx();
        contentValues.put("app_store", (String)stringArray);
        stringArray = ((zzg)object).zzz();
        contentValues.put("gmp_version", (Long)stringArray);
        stringArray = ((zzg)object).zzB();
        contentValues.put("dev_cert_hash", (Long)stringArray);
        stringArray = ((zzg)object).zzF();
        contentValues.put("measurement_enabled", (Boolean)stringArray);
        stringArray = ((zzg)object).zzO();
        contentValues.put("day", (Long)stringArray);
        stringArray = ((zzg)object).zzQ();
        contentValues.put("daily_public_events_count", (Long)stringArray);
        stringArray = ((zzg)object).zzS();
        contentValues.put("daily_events_count", (Long)stringArray);
        stringArray = ((zzg)object).zzU();
        contentValues.put("daily_conversions_count", (Long)stringArray);
        stringArray = ((zzg)object).zzJ();
        contentValues.put("config_fetched_time", (Long)stringArray);
        stringArray = ((zzg)object).zzL();
        contentValues.put("failed_config_fetch_time", (Long)stringArray);
        stringArray = ((zzg)object).zzv();
        contentValues.put("app_version_int", (Long)stringArray);
        stringArray = ((zzg)object).zzn();
        contentValues.put("firebase_instance_id", (String)stringArray);
        stringArray = ((zzg)object).zzY();
        contentValues.put("daily_error_events_count", (Long)stringArray);
        stringArray = ((zzg)object).zzW();
        contentValues.put("daily_realtime_events_count", (Long)stringArray);
        stringArray = ((zzg)object).zzaa();
        contentValues.put("health_monitor_sample", (String)stringArray);
        stringArray = ((zzg)object).zzad();
        contentValues.put("android_id", (Long)stringArray);
        boolean bl2 = ((zzg)object).zzaf();
        stringArray = bl2;
        contentValues.put("adid_reporting_enabled", (Boolean)stringArray);
        stringArray = ((zzg)object).zzh();
        contentValues.put("admob_app_id", (String)stringArray);
        long l10 = ((zzg)object).zzD();
        stringArray = l10;
        Object object4 = "dynamite_version";
        contentValues.put((String)object4, (Long)stringArray);
        stringArray = ((zzg)object).zzaj();
        if (stringArray != null) {
            n11 = stringArray.size();
            if (n11 == 0) {
                stringArray = this.zzx.zzat().zze();
                object4 = "Safelisted events should not be an empty list. appId";
                stringArray.zzb((String)object4, object3);
            } else {
                stringArray = TextUtils.join((CharSequence)",", (Iterable)stringArray);
                object4 = "safelisted_events";
                contentValues.put((String)object4, (String)stringArray);
            }
        }
        zzmg.zzb();
        stringArray = this.zzx.zzc();
        object4 = zzdw.zzah;
        boolean bl3 = stringArray.zzn((String)object3, (zzdv)object4);
        if (bl3) {
            object = ((zzg)object).zzj();
            stringArray = "ga_app_id";
            contentValues.put((String)stringArray, (String)object);
        }
        try {
            object = this.zze();
            n10 = 1;
        }
        catch (SQLiteException sQLiteException) {
            object2 = this.zzx.zzat().zzb();
            object3 = zzei.zzl((String)object3);
            ((zzeg)object2).zzc("Error storing app. appId", object3, (Object)sQLiteException);
            return;
        }
        stringArray = new String[n10];
        n11 = 0;
        object4 = null;
        stringArray[0] = object3;
        object4 = "app_id = ?";
        l10 = object.update((String)object2, contentValues, (String)object4, stringArray);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) return;
        boolean bl4 = false;
        stringArray = null;
        n11 = 5;
        long l13 = object.insertWithOnConflict((String)object2, null, contentValues, n11);
        long l14 = -1;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        if (l15 != false) return;
        object = this.zzx;
        object = ((zzfl)object).zzat();
        object = ((zzei)object).zzb();
        object2 = "Failed to insert/update app (got -1). appId";
        Object object5 = zzei.zzl((String)object3);
        ((zzeg)object).zzb((String)object2, object5);
    }

    public final zzag zzu(long l10, String string2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        return this.zzv(l10, string2, 1L, false, false, bl4, false, bl6);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzag zzv(long l10, String string2, long l11, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        Throwable throwable222222;
        Cursor cursor;
        block15: {
            Object object;
            zzag zzag2;
            Object object2;
            Object object3;
            zzai zzai2;
            block14: {
                SQLiteDatabase sQLiteDatabase;
                boolean bl7;
                int n10;
                block12: {
                    block13: {
                        zzai2 = this;
                        Preconditions.checkNotEmpty(string2);
                        this.zzg();
                        this.zzX();
                        n10 = 1;
                        object3 = new String[n10];
                        bl7 = false;
                        object2 = null;
                        object3[0] = string2;
                        zzag2 = new zzag();
                        cursor = null;
                        sQLiteDatabase = this.zze();
                        object = "day";
                        String string3 = "daily_events_count";
                        String[] stringArray = "daily_public_events_count";
                        String string4 = "daily_conversions_count";
                        String[] stringArray2 = "daily_error_events_count";
                        String string5 = "daily_realtime_events_count";
                        stringArray = new String[]{object, string3, stringArray, string4, stringArray2, string5};
                        stringArray2 = new String[n10];
                        stringArray2[0] = string2;
                        string3 = "apps";
                        string4 = "app_id=?";
                        string5 = null;
                        object = sQLiteDatabase;
                        cursor = sQLiteDatabase.query(string3, stringArray, string4, stringArray2, null, null, null);
                        boolean bl8 = cursor.moveToFirst();
                        if (bl8) break block12;
                        Object object4 = this.zzx;
                        object4 = ((zzfl)object4).zzat();
                        object4 = ((zzei)object4).zze();
                        object3 = "Not updating daily counts, app is not known. appId";
                        object2 = zzei.zzl(string2);
                        ((zzeg)object4).zzb((String)object3, object2);
                        if (cursor == null) break block13;
                        cursor.close();
                    }
                    return zzag2;
                }
                long l12 = cursor.getLong(0);
                bl7 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                if (!bl7) {
                    zzag2.zzb = l12 = cursor.getLong(n10);
                    n10 = 2;
                    zzag2.zza = l12 = cursor.getLong(n10);
                    n10 = 3;
                    zzag2.zzc = l12 = cursor.getLong(n10);
                    n10 = 4;
                    zzag2.zzd = l12 = cursor.getLong(n10);
                    n10 = 5;
                    zzag2.zze = l12 = cursor.getLong(n10);
                }
                if (bl2) {
                    zzag2.zzb = l12 = zzag2.zzb + l11;
                }
                if (bl3) {
                    zzag2.zza = l12 = zzag2.zza + l11;
                }
                if (bl4) {
                    zzag2.zzc = l12 = zzag2.zzc + l11;
                }
                if (bl5) {
                    zzag2.zzd = l12 = zzag2.zzd + l11;
                }
                if (bl6) {
                    zzag2.zze = l12 = zzag2.zze + l11;
                }
                ContentValues contentValues = new ContentValues();
                object2 = "day";
                object = l10;
                contentValues.put((String)object2, (Long)object);
                object2 = "daily_public_events_count";
                l12 = zzag2.zza;
                object = l12;
                contentValues.put((String)object2, (Long)object);
                object2 = "daily_events_count";
                l12 = zzag2.zzb;
                object = l12;
                contentValues.put((String)object2, (Long)object);
                object2 = "daily_conversions_count";
                l12 = zzag2.zzc;
                object = l12;
                contentValues.put((String)object2, (Long)object);
                object2 = "daily_error_events_count";
                l12 = zzag2.zzd;
                object = l12;
                contentValues.put((String)object2, (Long)object);
                object2 = "daily_realtime_events_count";
                l12 = zzag2.zze;
                object = l12;
                contentValues.put((String)object2, (Long)object);
                object2 = "apps";
                object = "app_id=?";
                sQLiteDatabase.update((String)object2, contentValues, (String)object, (String[])object3);
                if (cursor == null) break block14;
                cursor.close();
            }
            return zzag2;
            {
                block16: {
                    catch (Throwable throwable222222) {
                        break block15;
                    }
                    catch (SQLiteException sQLiteException) {}
                    {
                        object3 = zzai2.zzx;
                        object3 = ((zzfl)object3).zzat();
                        object3 = ((zzei)object3).zzb();
                        object2 = "Error updating daily counts. appId";
                        object = zzei.zzl(string2);
                        ((zzeg)object3).zzc((String)object2, object, (Object)sQLiteException);
                        if (cursor == null) break block16;
                    }
                    cursor.close();
                }
                return zzag2;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        throw throwable222222;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public final String zzw() {
        Object object;
        Object object2;
        block16: {
            block17: {
                block15: {
                    block13: {
                        block14: {
                            object2 = this.zze();
                            object = null;
                            String string2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;";
                            object2 = object2.rawQuery(string2, null);
                            boolean bl2 = object2.moveToFirst();
                            if (!bl2) break block13;
                            bl2 = false;
                            string2 = null;
                            try {
                                object = object2.getString(0);
                                if (object2 == null) break block14;
                            }
                            catch (SQLiteException sQLiteException) {
                                break block15;
                            }
                            object2.close();
                        }
                        return object;
                    }
                    if (object2 != null) {
                        object2.close();
                    }
                    return null;
                    catch (Throwable throwable) {
                        break block16;
                    }
                    catch (SQLiteException sQLiteException) {
                        object2 = null;
                    }
                }
                Object object3 = this.zzx;
                object3 = ((zzfl)object3).zzat();
                object3 = ((zzei)object3).zzb();
                String string3 = "Database error getting next bundle app id";
                try {
                    void var3_7;
                    ((zzeg)object3).zzb(string3, var3_7);
                    if (object2 == null) break block17;
                }
                catch (Throwable throwable) {
                    object = object2;
                    object2 = throwable;
                }
                object2.close();
            }
            return null;
        }
        if (object != null) {
            object.close();
        }
        throw object2;
    }

    public final boolean zzx() {
        long l10;
        String string2 = "select count(1) > 0 from queue where has_realtime = 1";
        long l11 = this.zzZ(string2, null);
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object != false;
    }

    public final void zzy() {
        this.zzg();
        this.zzX();
        int n10 = this.zzK();
        if (n10 != 0) {
            Object object = this.zzx.zzd().zzf;
            long l10 = ((zzeu)object).zza();
            Object object2 = this.zzx.zzax();
            long l11 = object2.elapsedRealtime();
            l10 = Math.abs(l11 - l10);
            this.zzx.zzc();
            Long l12 = (Long)zzdw.zzx.zzb(null);
            long l13 = l12;
            n10 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            if (n10 > 0) {
                object = this.zzx.zzd().zzf;
                ((zzeu)object).zzb(l11);
                this.zzg();
                this.zzX();
                n10 = (int)(this.zzK() ? 1 : 0);
                if (n10 != 0) {
                    String string2;
                    object = this.zze();
                    int n11 = 2;
                    Object object3 = new String[n11];
                    object3[0] = string2 = String.valueOf(this.zzx.zzax().currentTimeMillis());
                    this.zzx.zzc();
                    int n12 = 1;
                    long l14 = zzae.zzA();
                    object3[n12] = string2 = String.valueOf(l14);
                    object2 = "queue";
                    string2 = "abs(bundle_end_timestamp - ?) > cast(? as integer)";
                    n10 = object.delete((String)object2, string2, (String[])object3);
                    if (n10 > 0) {
                        object3 = this.zzx.zzat().zzk();
                        object = n10;
                        object2 = "Deleted stale rows. rowsDeleted";
                        ((zzeg)object3).zzb((String)object2, object);
                    }
                }
            }
        }
    }

    public final void zzz(List object) {
        this.zzg();
        this.zzX();
        Preconditions.checkNotNull(object);
        Preconditions.checkNotZero(object.size());
        int n10 = this.zzK();
        if (n10 == 0) {
            return;
        }
        object = TextUtils.join((CharSequence)",", (Iterable)object);
        n10 = String.valueOf(object).length();
        Object object2 = new StringBuilder(n10 += 2);
        ((StringBuilder)object2).append("(");
        ((StringBuilder)object2).append((String)object);
        object = ")";
        ((StringBuilder)object2).append((String)object);
        String string2 = ((StringBuilder)object2).toString();
        int n11 = String.valueOf(string2).length();
        CharSequence charSequence = new StringBuilder(n11 += 80);
        ((StringBuilder)charSequence).append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(" AND retry_count =  2147483647 LIMIT 1");
        object2 = ((StringBuilder)charSequence).toString();
        int n12 = 0;
        charSequence = null;
        long l10 = this.zzZ((String)object2, null);
        long l11 = 0L;
        n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n11 > 0) {
            object2 = this.zzx.zzat().zze();
            charSequence = "The number of upload retries exceeds the limit. Will remain unchanged.";
            ((zzeg)object2).zza((String)charSequence);
        }
        try {
            object2 = this.zze();
        }
        catch (SQLiteException sQLiteException) {
            this.zzx.zzat().zzb().zzb("Error incrementing retry count. error", (Object)sQLiteException);
            return;
        }
        charSequence = String.valueOf(string2);
        n12 = ((String)charSequence).length() + 127;
        StringBuilder stringBuilder = new StringBuilder(n12);
        charSequence = "UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ";
        stringBuilder.append((String)charSequence);
        stringBuilder.append(string2);
        string2 = " AND (retry_count IS NULL OR retry_count < ";
        stringBuilder.append(string2);
        n10 = -1 >>> 1;
        stringBuilder.append(n10);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2.execSQL((String)object);
    }
}

