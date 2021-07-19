/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzjr;
import java.io.File;

public final class zzah
extends SQLiteOpenHelper {
    public final /* synthetic */ zzai zza;

    public zzah(zzai zzai2, Context context, String string2) {
        this.zza = zzai2;
        super(context, "google_app_measurement.db", null, 1);
    }

    public final SQLiteDatabase getWritableDatabase() {
        Object object = zzai.zzL(this.zza);
        Object object2 = this.zza.zzx;
        ((zzfl)object2).zzc();
        long l10 = 3600000L;
        boolean bl2 = object.zzc(l10);
        if (bl2) {
            try {
                return super.getWritableDatabase();
            }
            catch (SQLiteException sQLiteException) {
                zzai.zzL(this.zza).zza();
                this.zza.zzx.zzat().zzb().zza("Opening the database failed, dropping and recreating it");
                this.zza.zzx.zzc();
                object = "google_app_measurement.db";
                object2 = this.zza.zzx.zzaw().getDatabasePath((String)object);
                boolean bl3 = ((File)object2).delete();
                if (!bl3) {
                    object2 = this.zza.zzx.zzat().zzb();
                    String string2 = "Failed to delete corrupted db file";
                    ((zzeg)object2).zzb(string2, object);
                }
                try {
                    object = super.getWritableDatabase();
                }
                catch (SQLiteException sQLiteException2) {
                    this.zza.zzx.zzat().zzb().zzb("Failed to open freshly created database", (Object)sQLiteException2);
                    throw sQLiteException2;
                }
                object2 = this.zza;
                object2 = zzai.zzL((zzai)object2);
                ((zzjr)object2).zzb();
                return object;
            }
        }
        object = new SQLiteException("Database open failed");
        throw object;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzaj.zzb(this.zza.zzx.zzat(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzei zzei2 = this.zza.zzx.zzat();
        String[] stringArray = zzai.zzM();
        zzaj.zza(zzei2, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", stringArray);
        zzaj.zza(this.zza.zzx.zzat(), sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        zzei2 = this.zza.zzx.zzat();
        stringArray = zzai.zzN();
        zzaj.zza(zzei2, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", stringArray);
        zzei2 = this.zza.zzx.zzat();
        stringArray = zzai.zzO();
        zzaj.zza(zzei2, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", stringArray);
        zzei2 = this.zza.zzx.zzat();
        stringArray = zzai.zzP();
        zzaj.zza(zzei2, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", stringArray);
        zzaj.zza(this.zza.zzx.zzat(), sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zzei2 = this.zza.zzx.zzat();
        stringArray = zzai.zzQ();
        zzaj.zza(zzei2, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", stringArray);
        zzei2 = this.zza.zzx.zzat();
        stringArray = zzai.zzR();
        zzaj.zza(zzei2, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", stringArray);
        zzei2 = this.zza.zzx.zzat();
        stringArray = zzai.zzS();
        zzaj.zza(zzei2, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", stringArray);
        zzaj.zza(this.zza.zzx.zzat(), sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        zzei2 = this.zza.zzx.zzat();
        stringArray = zzai.zzT();
        zzaj.zza(zzei2, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", stringArray);
        zzaj.zza(this.zza.zzx.zzat(), sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
        zzaj.zza(this.zza.zzx.zzat(), sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
        zzaj.zza(this.zza.zzx.zzat(), sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
    }
}

