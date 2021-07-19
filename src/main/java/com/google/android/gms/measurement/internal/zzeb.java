/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabaseLockedException
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzec;
import com.google.android.gms.measurement.internal.zzeg;
import java.io.File;

public final class zzeb
extends SQLiteOpenHelper {
    public final /* synthetic */ zzec zza;

    public zzeb(zzec zzec2, Context context, String string2) {
        this.zza = zzec2;
        super(context, "google_app_measurement_local.db", null, 1);
    }

    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        }
        catch (SQLiteException sQLiteException) {
            this.zza.zzx.zzat().zzb().zza("Opening the local database failed, dropping and recreating it");
            this.zza.zzx.zzc();
            String string2 = "google_app_measurement_local.db";
            Object object = this.zza.zzx.zzaw().getDatabasePath(string2);
            boolean bl2 = ((File)object).delete();
            if (!bl2) {
                object = this.zza.zzx.zzat().zzb();
                String string3 = "Failed to delete corrupted local db file";
                ((zzeg)object).zzb(string3, string2);
            }
            try {
                return super.getWritableDatabase();
            }
            catch (SQLiteException sQLiteException2) {
                this.zza.zzx.zzat().zzb().zzb("Failed to open local database. Events will bypass local storage", (Object)sQLiteException2);
                return null;
            }
        }
        catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
            throw sQLiteDatabaseLockedException;
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzaj.zzb(this.zza.zzx.zzat(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzaj.zza(this.zza.zzx.zzat(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
    }
}

