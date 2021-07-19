/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzco;
import com.google.android.gms.internal.measurement.zzcp;
import com.google.android.gms.internal.measurement.zzcr;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zziy;
import com.google.android.gms.measurement.internal.zzad;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzfc
extends zzjv
implements zzad {
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;
    private final Map zzf;
    private final Map zzg;

    public zzfc(zzkd object) {
        super((zzkd)object);
        this.zzb = object = new ArrayMap();
        this.zzc = object = new ArrayMap();
        this.zzd = object = new ArrayMap();
        this.zze = object = new ArrayMap();
        this.zzg = object = new ArrayMap();
        this.zzf = object = new ArrayMap();
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private final void zzn(String string2) {
        block31: {
            void var1_4;
            SQLiteDatabase sQLiteDatabase;
            block30: {
                Object object;
                Object object2;
                Object object3;
                block32: {
                    int n10;
                    block26: {
                        block27: {
                            Object object4;
                            Object object5;
                            block29: {
                                block28: {
                                    Object object6;
                                    block25: {
                                        this.zzX();
                                        this.zzg();
                                        Preconditions.checkNotEmpty(string2);
                                        object3 = this.zze.get(string2);
                                        if (object3 != null) break block31;
                                        object3 = this.zza.zzi();
                                        Preconditions.checkNotEmpty(string2);
                                        ((zzge)object3).zzg();
                                        ((zzjv)object3).zzX();
                                        sQLiteDatabase = null;
                                        object2 = ((zzai)object3).zze();
                                        object = "remote_config";
                                        object5 = new String[]{object};
                                        n10 = 1;
                                        object6 = new String[n10];
                                        object6[0] = string2;
                                        object = "apps";
                                        object4 = "app_id=?";
                                        object2 = object2.query((String)object, (String[])object5, (String)object4, object6, null, null, null);
                                        n10 = (int)(object2.moveToFirst() ? 1 : 0);
                                        if (n10 != 0) break block25;
                                        if (object2 == null) break block26;
                                        break block27;
                                    }
                                    object = object2.getBlob(0);
                                    boolean bl2 = object2.moveToNext();
                                    if (!bl2) break block28;
                                    object5 = ((zzge)object3).zzx;
                                    object5 = ((zzfl)object5).zzat();
                                    object5 = ((zzei)object5).zzb();
                                    object4 = "Got multiple records for app config, expected one. appId";
                                    object6 = zzei.zzl(string2);
                                    try {
                                        ((zzeg)object5).zzb((String)object4, object6);
                                    }
                                    catch (SQLiteException sQLiteException) {
                                        break block29;
                                    }
                                }
                                if (object2 != null) {
                                    object2.close();
                                }
                                break block32;
                                catch (Throwable throwable) {
                                    break block30;
                                }
                                catch (SQLiteException sQLiteException) {
                                    object2 = null;
                                }
                            }
                            object3 = ((zzge)object3).zzx;
                            object3 = ((zzfl)object3).zzat();
                            object3 = ((zzei)object3).zzb();
                            object5 = "Error querying remote config. appId";
                            object4 = zzei.zzl(string2);
                            try {
                                ((zzeg)object3).zzc((String)object5, object4, object);
                                if (object2 == null) break block26;
                            }
                            catch (Throwable throwable) {
                                sQLiteDatabase = object2;
                            }
                        }
                        object2.close();
                    }
                    n10 = 0;
                    object = null;
                }
                if (object == null) {
                    this.zzb.put(string2, null);
                    this.zzc.put(string2, null);
                    this.zzd.put(string2, null);
                    this.zze.put(string2, null);
                    this.zzg.put(string2, null);
                    this.zzf.put(string2, null);
                    return;
                }
                object3 = (zzco)this.zzq(string2, (byte[])object).zzbu();
                this.zzo(string2, (zzco)object3);
                object2 = this.zzb;
                object = zzfc.zzr((zzcp)((zzho)object3).zzaA());
                object2.put(string2, object);
                object2 = this.zze;
                object3 = (zzcp)((zzho)object3).zzaA();
                object2.put(string2, object3);
                this.zzg.put(string2, null);
                return;
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw var1_4;
        }
    }

    private final void zzo(String string2, zzco zzco2) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzco2 != null) {
            int n10;
            for (int i10 = 0; i10 < (n10 = zzco2.zza()); ++i10) {
                Object object = (zzcm)zzco2.zzb(i10).zzbu();
                Object object2 = ((zzcm)object).zza();
                int n11 = TextUtils.isEmpty((CharSequence)object2);
                if (n11 != 0) {
                    object = this.zzx.zzat().zze();
                    object2 = "EventConfig contained null event name";
                    ((zzeg)object).zza((String)object2);
                    continue;
                }
                object2 = ((zzcm)object).zza();
                Object object3 = zzgi.zzb(((zzcm)object).zza());
                boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
                if (!bl2) {
                    ((zzcm)object).zzb((String)object3);
                    zzco2.zzc(i10, (zzcm)object);
                }
                object3 = ((zzcm)object).zzc();
                arrayMap.put(object2, object3);
                object2 = ((zzcm)object).zza();
                int n12 = ((zzcm)object).zzd();
                object3 = n12 != 0;
                arrayMap2.put(object2, object3);
                n11 = ((zzcm)object).zze();
                if (n11 == 0) continue;
                n11 = ((zzcm)object).zzf();
                if (n11 >= (n12 = 2) && (n11 = ((zzcm)object).zzf()) <= (n12 = (int)((char)-1))) {
                    object2 = ((zzcm)object).zza();
                    n10 = ((zzcm)object).zzf();
                    object = n10;
                    arrayMap3.put(object2, object);
                    continue;
                }
                object2 = this.zzx.zzat().zze();
                object3 = ((zzcm)object).zza();
                n10 = ((zzcm)object).zzf();
                object = n10;
                String string3 = "Invalid sampling rate. Event name, sample rate";
                ((zzeg)object2).zzc(string3, object3, object);
            }
        }
        this.zzc.put(string2, arrayMap);
        this.zzd.put(string2, arrayMap2);
        this.zzf.put(string2, arrayMap3);
    }

    private final zzcp zzq(String object, byte[] object2) {
        String string2 = "Unable to merge remote config. appId";
        if (object2 != null) {
            Long l10;
            String string3;
            String string4;
            Object object3;
            block18: {
                boolean bl2;
                block17: {
                    object3 = zzcp.zzj();
                    object2 = zzkf.zzt((zziw)object3, (byte[])object2);
                    object2 = (zzco)object2;
                    object2 = ((zzho)object2).zzaA();
                    object2 = (zzcp)object2;
                    object3 = this.zzx;
                    object3 = ((zzfl)object3).zzat();
                    object3 = ((zzei)object3).zzk();
                    string4 = "Parsed config. version, gmp_app_id";
                    bl2 = ((zzcp)object2).zza();
                    string3 = null;
                    if (!bl2) break block17;
                    long l11 = ((zzcp)object2).zzb();
                    l10 = l11;
                }
                bl2 = false;
                l10 = null;
                boolean bl3 = ((zzcp)object2).zzc();
                if (!bl3) break block18;
                string3 = ((zzcp)object2).zzd();
            }
            try {
                ((zzeg)object3).zzc(string4, l10, string3);
                return object2;
            }
            catch (RuntimeException runtimeException) {
                object3 = this.zzx.zzat().zze();
                object = zzei.zzl((String)object);
                ((zzeg)object3).zzc(string2, object, runtimeException);
                return zzcp.zzk();
            }
            catch (zzic zzic2) {
                object3 = this.zzx.zzat().zze();
                object = zzei.zzl((String)object);
                ((zzeg)object3).zzc(string2, object, zzic2);
                return zzcp.zzk();
            }
        }
        return zzcp.zzk();
    }

    private static final Map zzr(zzcp object) {
        ArrayMap arrayMap = new ArrayMap();
        if (object != null) {
            boolean bl2;
            object = ((zzcp)object).zze().iterator();
            while (bl2 = object.hasNext()) {
                Object object2 = (zzcr)object.next();
                String string2 = ((zzcr)object2).zza();
                object2 = ((zzcr)object2).zzb();
                arrayMap.put(string2, object2);
            }
        }
        return arrayMap;
    }

    public final String zza(String object, String string2) {
        this.zzg();
        this.zzn((String)object);
        Map map = this.zzb;
        object = (Map)map.get(object);
        if (object != null) {
            return (String)object.get(string2);
        }
        return null;
    }

    public final boolean zzaz() {
        return false;
    }

    public final zzcp zzb(String string2) {
        this.zzX();
        this.zzg();
        Preconditions.checkNotEmpty(string2);
        this.zzn(string2);
        return (zzcp)this.zze.get(string2);
    }

    public final String zzc(String string2) {
        this.zzg();
        return (String)this.zzg.get(string2);
    }

    public final void zzd(String string2) {
        this.zzg();
        this.zzg.put(string2, null);
    }

    public final void zze(String string2) {
        this.zzg();
        this.zze.remove(string2);
    }

    public final boolean zzf(String object) {
        this.zzg();
        object = this.zzb((String)object);
        if (object == null) {
            return false;
        }
        return ((zzcp)object).zzi();
    }

    public final boolean zzh(String string2, byte[] byArray, String object) {
        boolean bl2;
        zziy zziy2;
        block15: {
            String[] stringArray;
            this.zzX();
            this.zzg();
            Preconditions.checkNotEmpty(string2);
            zziy2 = (zzco)this.zzq(string2, byArray).zzbu();
            boolean bl3 = false;
            Object object2 = null;
            if (zziy2 == null) {
                return false;
            }
            this.zzo(string2, (zzco)zziy2);
            Object object3 = this.zze;
            Object object4 = (zzcp)zziy2.zzaA();
            object3.put(string2, object4);
            this.zzg.put(string2, object);
            object = this.zzb;
            object3 = zzfc.zzr((zzcp)zziy2.zzaA());
            object.put(string2, object3);
            object = this.zza.zzi();
            object4 = zziy2.zzd();
            object3 = new ArrayList(object4);
            ((zzai)object).zzJ(string2, (List)object3);
            zziy2.zze();
            object = zziy2.zzaA();
            object = (zzcp)object;
            try {
                byArray = ((zzgb)object).zzbp();
            }
            catch (RuntimeException runtimeException) {
                object3 = this.zzx.zzat().zze();
                object4 = zzei.zzl(string2);
                stringArray = "Unable to serialize reduced-size config. Storing full config instead. appId";
                ((zzeg)object3).zzc((String)stringArray, object4, runtimeException);
            }
            object = this.zza.zzi();
            Preconditions.checkNotEmpty(string2);
            ((zzge)object).zzg();
            ((zzjv)object).zzX();
            object3 = new ContentValues();
            object4 = "remote_config";
            object3.put((String)object4, byArray);
            bl2 = true;
            object4 = ((zzai)object).zze();
            stringArray = new String[bl2];
            stringArray[0] = string2;
            object2 = "apps";
            String string3 = "app_id = ?";
            long l10 = object4.update((String)object2, (ContentValues)object3, string3, stringArray);
            long l11 = 0L;
            bl3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (bl3) break block15;
            object2 = ((zzge)object).zzx;
            object2 = ((zzfl)object2).zzat();
            object2 = ((zzei)object2).zzb();
            object3 = "Failed to update remote config (got 0). appId";
            object4 = zzei.zzl(string2);
            try {
                ((zzeg)object2).zzb((String)object3, object4);
            }
            catch (SQLiteException sQLiteException) {
                object = ((zzge)object).zzx.zzat().zzb();
                object3 = zzei.zzl(string2);
                object4 = "Error storing remote config. appId";
                ((zzeg)object).zzc((String)object4, object3, (Object)sQLiteException);
            }
        }
        object = this.zze;
        zziy2 = (zzcp)zziy2.zzaA();
        object.put(string2, zziy2);
        return bl2;
    }

    public final boolean zzi(String object, String string2) {
        this.zzg();
        this.zzn((String)object);
        boolean bl2 = this.zzl((String)object);
        boolean bl3 = true;
        if (bl2 && (bl2 = zzkk.zzR(string2))) {
            return bl3;
        }
        bl2 = this.zzm((String)object);
        if (bl2 && (bl2 = zzkk.zzh(string2))) {
            return bl3;
        }
        object = (Map)this.zzc.get(object);
        bl2 = false;
        if (object != null) {
            if ((object = (Boolean)object.get(string2)) == null) {
                return false;
            }
            return (Boolean)object;
        }
        return false;
    }

    public final boolean zzj(String object, String string2) {
        this.zzg();
        this.zzn((String)object);
        String string3 = "ecommerce_purchase";
        boolean bl2 = string3.equals(string2);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        string3 = "purchase";
        bl2 = string3.equals(string2);
        if (!bl2 && !(bl2 = (string3 = "refund").equals(string2))) {
            object = (Map)this.zzd.get(object);
            bl2 = false;
            string3 = null;
            if (object != null) {
                if ((object = (Boolean)object.get(string2)) == null) {
                    return false;
                }
                return (Boolean)object;
            }
            return false;
        }
        return bl3;
    }

    public final int zzk(String object, String string2) {
        this.zzg();
        this.zzn((String)object);
        Map map = this.zzf;
        object = (Map)map.get(object);
        int n10 = 1;
        if (object != null) {
            if ((object = (Integer)object.get(string2)) == null) {
                return n10;
            }
            return (Integer)object;
        }
        return n10;
    }

    public final boolean zzl(String string2) {
        string2 = this.zza(string2, "measurement.upload.blacklist_internal");
        return "1".equals(string2);
    }

    public final boolean zzm(String string2) {
        string2 = this.zza(string2, "measurement.upload.blacklist_public");
        return "1".equals(string2);
    }
}

