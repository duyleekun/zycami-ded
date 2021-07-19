/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabaseLockedException
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteFullException
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.SystemClock
 */
package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzat;
import com.google.android.gms.measurement.internal.zzeb;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzkh;
import com.google.android.gms.measurement.internal.zzkk;
import java.util.List;

public final class zzec
extends zzf {
    private final zzeb zza;
    private boolean zzb;

    public zzec(zzfl object) {
        super((zzfl)object);
        Context context = this.zzx.zzaw();
        this.zzx.zzc();
        super(this, context, "google_app_measurement_local.db");
        this.zza = object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean zzq(int var1_1, byte[] var2_2) {
        block38: {
            block42: {
                block45: {
                    block44: {
                        block39: {
                            var3_3 = this;
                            this.zzg();
                            var4_4 = this.zzb;
                            var5_5 = false;
                            var6_6 = null;
                            if (var4_4 != 0) {
                                return false;
                            }
                            var7_7 = new ContentValues();
                            var8_8 = var1_1;
                            var7_7.put("type", (Integer)var8_8);
                            var9_20 /* !! */  = var2_2;
                            var7_7.put("entry", var2_2);
                            var8_8 = this.zzx;
                            var8_8.zzc();
                            var10_21 = 5;
                            var11_22 = 0;
                            var12_23 = var10_21;
                            block22: while (true) {
                                block41: {
                                    block43: {
                                        block35: {
                                            block36: {
                                                block37: {
                                                    if (var11_22 >= var10_21) {
                                                        var3_3.zzx.zzat().zzk().zza("Failed to write entry to local database");
                                                        return false;
                                                    }
                                                    var13_24 = 1;
                                                    var14_25 = null;
                                                    var15_26 = this.zzo();
                                                    if (var15_26 != null) break block35;
                                                    try {}
                                                    catch (SQLiteException var8_13) {
                                                        var16_27 = null;
                                                        return (boolean)var16_27;
                                                    }
                                                    catch (SQLiteFullException var8_14) {
                                                        var16_27 = null;
                                                        return (boolean)var16_27;
                                                    }
                                                    catch (SQLiteDatabaseLockedException v0) {}
                                                    finally {
                                                        break block36;
                                                    }
lbl38:
                                                    // 1 sources

                                                    while (true) {
                                                        var14_25 = var15_26;
                                                        break block37;
                                                        break;
                                                    }
lbl41:
                                                    // 1 sources

                                                    while (true) {
                                                        var14_25 = var15_26;
                                                        ** GOTO lbl-1000
                                                        break;
                                                    }
                                                    catch (Throwable var8_15) {
                                                        var15_26 = null;
                                                        break block38;
                                                    }
                                                    catch (SQLiteException var8_16) {
                                                        var16_27 = null;
                                                    }
                                                }
                                                if (var14_25 == null) ** GOTO lbl55
                                                var5_5 = var14_25.inTransaction();
                                                if (var5_5) {
                                                    var14_25.endTransaction();
                                                }
lbl55:
                                                // 4 sources

                                                var6_6 = var3_3.zzx;
                                                var6_6 = var6_6.zzat();
                                                var6_6 = var6_6.zzb();
                                                var9_20 /* !! */  = (byte[])"Error writing entry to local database";
                                                var6_6.zzb((String)var9_20 /* !! */ , var8_8);
                                                var3_3.zzb = var5_5 = true;
                                                if (var16_27 == null) break block39;
                                                catch (SQLiteDatabaseLockedException v1) {
                                                    var15_26 = null;
                                                }
lbl65:
                                                // 2 sources

                                                while (true) {
                                                    block40: {
                                                        var24_32 = var12_23;
                                                        {
                                                            SystemClock.sleep((long)var24_32);
                                                            var12_23 += 20;
                                                            if (var14_25 == null) break block40;
                                                        }
                                                        var14_25.close();
                                                    }
                                                    if (var15_26 != null) {
                                                        var15_26.close();
                                                    }
                                                    break block41;
                                                    break;
                                                }
                                                catch (SQLiteFullException var8_17) {
                                                    var16_27 = null;
                                                    ** GOTO lbl-1000
                                                }
                                            }
                                            var3_3.zzb = var13_24;
                                            return false;
                                        }
                                        var15_26.beginTransaction();
                                        var8_8 = "select count(1) from messages";
                                        var16_27 = var15_26.rawQuery((String)var8_8, null);
                                        var17_28 = 0L;
                                        if (var16_27 != null) {
                                            try {
                                                var4_4 = var16_27.moveToFirst();
                                                if (var4_4 != 0) {
                                                    var17_28 = var16_27.getLong(0);
                                                }
                                            }
                                            catch (Throwable var8_9) {
                                                break block42;
                                            }
                                            catch (SQLiteException var8_10) {
                                                ** continue;
                                            }
                                            catch (SQLiteFullException var8_11) {
                                                ** continue;
                                            }
                                        }
                                        var19_29 = 100000L;
                                        var4_4 = var17_28 == var19_29 ? 0 : (var17_28 < var19_29 ? -1 : 1);
                                        var21_30 = "messages";
                                        if (var4_4 < 0) ** GOTO lbl128
                                        var8_8 = var3_3.zzx;
                                        var8_8 = var8_8.zzat();
                                        var8_8 = var8_8.zzb();
                                        var9_20 /* !! */  = (byte[])"Data loss, local db full";
                                        var8_8.zza((String)var9_20 /* !! */ );
                                        var19_29 -= var17_28;
                                        var17_28 = 1L;
                                        ** GOTO lbl-1000
                                        catch (SQLiteDatabaseLockedException v2) {
                                            var14_25 = var16_27;
                                            ** continue;
                                        }
lbl-1000:
                                        // 1 sources

                                        {
                                            var8_8 = new String[var13_24];
                                            var9_20 /* !! */  = (byte[])Long.toString(var19_29 += var17_28);
                                            var8_8[0] = var9_20 /* !! */ ;
                                            var9_20 /* !! */  = (byte[])"rowid in (select rowid from messages order by rowid asc limit ?)";
                                            var17_28 = var15_26.delete(var21_30, (String)var9_20 /* !! */ , (String[])var8_8);
                                            var4_4 = (int)(var17_28 == var19_29 ? 0 : (var17_28 < var19_29 ? -1 : 1));
                                            if (var4_4 == 0) ** GOTO lbl128
                                            var8_8 = var3_3.zzx;
                                            var8_8 = var8_8.zzat();
                                            var8_8 = var8_8.zzb();
                                            var9_20 /* !! */  = (byte[])"Different delete count than expected in local db. expected, received, difference";
                                            var6_6 = var19_29;
                                            var22_31 = var17_28;
                                        }
                                        {
                                            var23_33 = var19_29 -= var17_28;
                                            var8_8.zzd((String)var9_20 /* !! */ , var6_6, var22_31, var23_33);
lbl128:
                                            // 3 sources

                                            var15_26.insertOrThrow(var21_30, null, var7_7);
                                            var15_26.setTransactionSuccessful();
                                            var15_26.endTransaction();
                                            if (var16_27 == null) break block43;
                                        }
                                        var16_27.close();
                                    }
                                    var15_26.close();
                                    return true;
                                }
lbl138:
                                // 4 sources

                                while (true) {
                                    ++var11_22;
                                    var5_5 = false;
                                    var6_6 = null;
                                    var10_21 = 5;
                                    continue block22;
                                    break;
                                }
                                break;
                            }
                            catch (Throwable var8_18) {
                                var15_26 = var14_25;
                                break block42;
                            }
                            var16_27.close();
                        }
                        if (var14_25 == null) ** GOTO lbl138
                        break block45;
lbl-1000:
                        // 2 sources

                        {
                            var6_6 = var3_3.zzx;
                            var6_6 = var6_6.zzat();
                            var6_6 = var6_6.zzb();
                            var9_20 /* !! */  = (byte[])"Error writing entry; local database full";
                            var6_6.zzb((String)var9_20 /* !! */ , var8_8);
                            var3_3.zzb = var5_5 = true;
                            if (var16_27 == null) break block44;
                        }
                        var16_27.close();
                    }
                    if (var14_25 == null) ** GOTO lbl138
                }
                var14_25.close();
                ** while (true)
            }
            var14_25 = var16_27;
        }
        if (var14_25 != null) {
            var14_25.close();
        }
        if (var15_26 != null) {
            var15_26.close();
        }
        throw var8_19;
    }

    public final boolean zze() {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void zzh() {
        String string2;
        Object object;
        SQLiteDatabase sQLiteDatabase;
        ((zzge)this).zzg();
        try {
            sQLiteDatabase = this.zzo();
            if (sQLiteDatabase == null) return;
            object = "messages";
            string2 = null;
        }
        catch (SQLiteException sQLiteException) {
            this.zzx.zzat().zzb().zzb("Error resetting local analytics data. error", (Object)sQLiteException);
            return;
        }
        int n10 = sQLiteDatabase.delete((String)object, null, null);
        if (n10 <= 0) return;
        object = this.zzx;
        object = ((zzfl)object).zzat();
        object = ((zzei)object).zzk();
        string2 = "Reset local analytics data. records";
        Integer n11 = n10;
        ((zzeg)object).zzb(string2, n11);
    }

    public final boolean zzi(zzas object) {
        Parcel parcel = Parcel.obtain();
        zzat.zza((zzas)object, parcel, 0);
        object = parcel.marshall();
        parcel.recycle();
        int n10 = ((Object)object).length;
        int n11 = 131072;
        if (n10 > n11) {
            this.zzx.zzat().zzc().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return this.zzq(0, (byte[])object);
    }

    public final boolean zzj(zzkg object) {
        Parcel parcel = Parcel.obtain();
        zzkh.zza((zzkg)object, parcel, 0);
        object = parcel.marshall();
        parcel.recycle();
        int n10 = ((Object)object).length;
        int n11 = 131072;
        if (n10 > n11) {
            this.zzx.zzat().zzc().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return this.zzq(1, (byte[])object);
    }

    public final boolean zzk(zzaa object) {
        int n10;
        zzkk zzkk2 = this.zzx.zzl();
        object = zzkk2.zzX((Parcelable)object);
        int n11 = ((Object)object).length;
        if (n11 > (n10 = 131072)) {
            this.zzx.zzat().zzc().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return this.zzq(2, (byte[])object);
    }

    /*
     * Exception decompiling
     */
    public final List zzl(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 10[TRYBLOCK] [28, 27, 26, 25 : 281->286)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final boolean zzm() {
        byte[] byArray = new byte[]{};
        return this.zzq(3, byArray);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zzn() {
        block16: {
            var1_1 = "Error deleting app launch break from local database";
            this.zzg();
            var2_3 = this.zzb;
            if (var2_3 != 0) {
                return false;
            }
            var2_3 = this.zzp();
            if (var2_3 == 0) break block16;
            var3_4 = var2_3 = 5;
            block8: for (var4_5 = 0; var4_5 < var2_3; ++var4_5) {
                block14: {
                    block15: {
                        var5_6 = null;
                        var6_7 = true;
                        var5_6 = this.zzo();
                        if (var5_6 == null) {
                            this.zzb = var6_7;
                            return false;
                        }
                        var5_6.beginTransaction();
                        var7_8 = new String[var6_7];
                        var8_11 = 3;
                        var7_8[0] = var9_12 = Integer.toString(var8_11);
                        var9_12 = "messages";
                        var10_14 = "type == ?";
                        var5_6.delete((String)var9_12, var10_14, var7_8);
                        var5_6.setTransactionSuccessful();
                        var5_6.endTransaction();
                        {
                            catch (Throwable var1_2) {
                                break block14;
                            }
                            catch (SQLiteException var7_9) {
                                ** GOTO lbl-1000
                            }
                            catch (SQLiteFullException var7_10) {
                                ** GOTO lbl-1000
                            }
                            catch (SQLiteDatabaseLockedException v0) {}
                            var11_13 = var3_4;
                            {
                                SystemClock.sleep((long)var11_13);
                                var3_4 += 20;
                                if (var5_6 == null) continue;
                                break block15;
                            }
                        }
                        var5_6.close();
                        return var6_7;
lbl-1000:
                        // 1 sources

                        {
                            if (var5_6 != null && (var8_11 = var5_6.inTransaction()) != 0) {
                                var5_6.endTransaction();
                            }
                            var9_12 = this.zzx;
                            var9_12 = var9_12.zzat();
                            var9_12 = var9_12.zzb();
                            var9_12.zzb((String)var1_1, (Object)var7_9);
                            this.zzb = var6_7;
                            if (var5_6 == null) continue;
                        }
                    }
                    while (true) {
                        var5_6.close();
                        continue block8;
                        break;
                    }
lbl-1000:
                    // 1 sources

                    {
                        var9_12 = this.zzx;
                        var9_12 = var9_12.zzat();
                        var9_12 = var9_12.zzb();
                        var9_12.zzb((String)var1_1, (Object)var7_10);
                        this.zzb = var6_7;
                        if (var5_6 != null) ** continue;
                    }
                    continue;
                }
                if (var5_6 != null) {
                    var5_6.close();
                }
                throw var1_2;
            }
            var1_1 = this.zzx.zzat().zze();
            var13_15 = "Error deleting app launch break from local database in reasonable time";
            var1_1.zza(var13_15);
        }
        return false;
    }

    public final SQLiteDatabase zzo() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return null;
        }
        SQLiteDatabase sQLiteDatabase = this.zza.getWritableDatabase();
        if (sQLiteDatabase == null) {
            this.zzb = true;
            return null;
        }
        return sQLiteDatabase;
    }

    public final boolean zzp() {
        Context context = this.zzx.zzaw();
        this.zzx.zzc();
        return context.getDatabasePath("google_app_measurement_local.db").exists();
    }
}

