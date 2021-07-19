/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzhv;
import com.google.android.gms.measurement.internal.zzhw;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzhy;
import com.google.android.gms.measurement.internal.zzhz;
import com.google.android.gms.measurement.internal.zzia;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzkk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzib
extends zzf {
    public zzhu zza;
    private volatile zzhu zzb;
    private zzhu zzc;
    private final Map zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzhu zzg;
    private zzhu zzh;
    private boolean zzi;
    private final Object zzj;
    private zzhu zzk;
    private String zzl;

    public zzib(zzfl concurrentHashMap) {
        super((zzfl)((Object)concurrentHashMap));
        concurrentHashMap = new ConcurrentHashMap();
        this.zzj = concurrentHashMap;
        this.zzd = concurrentHashMap = new ConcurrentHashMap();
    }

    private final void zzA(Activity activity, zzhu zzhu2, boolean bl2) {
        Object object;
        Object object2;
        Object object3;
        zzib zzib2 = this;
        Object object4 = zzhu2;
        Object object5 = this.zzb;
        object5 = object5 == null ? this.zzc : this.zzb;
        zzhu zzhu3 = object5;
        object5 = ((zzhu)object4).zzb;
        if (object5 == null) {
            if (activity != null) {
                object5 = activity.getClass();
                object3 = "Activity";
                object5 = zzib2.zzi((Class)object5, (String)object3);
            } else {
                object5 = null;
            }
            Class<?> clazz = object5;
            object2 = ((zzhu)object4).zza;
            long l10 = ((zzhu)object4).zzc;
            boolean bl3 = ((zzhu)object4).zze;
            long l11 = ((zzhu)object4).zzf;
            object = object5;
            object3 = object5 = new zzhu((String)object2, (String)((Object)clazz), l10, bl3, l11);
        } else {
            object3 = object4;
        }
        object4 = zzib2.zzb;
        zzib2.zzc = object4;
        zzib2.zzb = object3;
        long l12 = zzib2.zzx.zzax().elapsedRealtime();
        object = zzib2.zzx.zzau();
        object4 = object2;
        object5 = this;
        object2 = new zzhw(this, (zzhu)object3, zzhu3, l12, bl2);
        ((zzfi)object).zzh((Runnable)object2);
    }

    private final void zzB(zzhu zzhu2, zzhu zzhu3, long l10, boolean bl2, Bundle bundle) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        long l11;
        long l12;
        long l13;
        long l14;
        zzhu zzhu4;
        zzib zzib2 = this;
        zzhu zzhu5 = zzhu2;
        Object object5 = zzhu3;
        long l15 = l10;
        Object object6 = bundle;
        ((zzge)this).zzg();
        int n10 = 0;
        int n11 = 1;
        if (bl2 && (zzhu4 = this.zza) != null) {
            n10 = n11;
        }
        if (n10 != 0) {
            zzhu4 = zzib2.zza;
            zzib2.zzC(zzhu4, n11 != 0, l15);
        }
        zzhu4 = null;
        if (object5 == null || (l14 = (l13 = (l12 = ((zzhu)object5).zzc) - (l11 = zzhu5.zzc)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false || (l14 = (long)zzkk.zzS((String)(object4 = ((zzhu)object5).zzb), (String)(object3 = zzhu5.zzb))) == false || (l14 = (long)zzkk.zzS((String)(object4 = ((zzhu)object5).zza), (String)(object3 = zzhu5.zza))) == false) {
            long l16;
            long l17;
            zzdv zzdv2;
            object4 = new Bundle();
            object3 = zzib2.zzx.zzc();
            boolean bl3 = ((zzae)object3).zzn(null, zzdv2 = zzdw.zzat);
            if (bl3) {
                object4 = object6 != null ? new Bundle(object6) : new Bundle();
            }
            zzib.zzm(zzhu5, (Bundle)object4, n11 != 0);
            if (object5 != null) {
                object6 = ((zzhu)object5).zza;
                if (object6 != null) {
                    object3 = "_pn";
                    object4.putString((String)object3, (String)object6);
                }
                if ((object6 = ((zzhu)object5).zzb) != null) {
                    object3 = "_pc";
                    object4.putString((String)object3, (String)object6);
                }
                l17 = ((zzhu)object5).zzc;
                object5 = "_pi";
                object4.putLong((String)object5, l17);
            }
            l17 = 0L;
            if (n10 != 0) {
                object5 = zzib2.zzx.zzh().zzb;
                long l18 = ((zzjo)object5).zzb;
                l18 = l15 - l18;
                ((zzjo)object5).zzb = l15;
                object2 = l18 == l17 ? 0 : (l18 < l17 ? -1 : 1);
                if (object2 > 0) {
                    object5 = zzib2.zzx.zzl();
                    ((zzkk)object5).zzac((Bundle)object4, l18);
                }
            }
            object5 = zzib2.zzx.zzc();
            object2 = ((zzae)object5).zzn(null, zzdv2);
            object = "auto";
            if (object2 != 0) {
                object5 = zzib2.zzx.zzc();
                object2 = ((zzae)object5).zzt();
                if (object2 == 0) {
                    l16 = 1L;
                    object5 = "_mst";
                    object4.putLong((String)object5, l16);
                }
                if (n11 == (object2 = (Object)zzhu5.zze)) {
                    object = object5 = "app";
                }
            }
            if ((object2 = (Object)((zzae)(object5 = zzib2.zzx.zzc())).zzn(null, zzdv2)) != 0) {
                long l19;
                long l20;
                object5 = zzib2.zzx.zzax();
                l16 = object5.currentTimeMillis();
                object2 = zzhu5.zze;
                long l21 = object2 != 0 && (object2 = (Object)((l20 = (l19 = zzhu5.zzf) - l17) == 0L ? 0 : (l20 < 0L ? -1 : 1))) != 0 ? l19 : l16;
                object5 = zzib2.zzx;
                zzhn zzhn2 = ((zzfl)object5).zzk();
                String string2 = "_vs";
                zzhn2.zzt((String)object, string2, l21, (Bundle)object4);
            } else {
                zzhn zzhn3 = zzib2.zzx.zzk();
                object5 = zzhn3.zzx;
                ((zzge)zzhn3).zzg();
                object5 = zzhn3.zzx.zzax();
                long l22 = object5.currentTimeMillis();
                String string3 = "_vs";
                zzhn3.zzt((String)object, string3, l22, (Bundle)object4);
            }
        }
        zzib2.zza = zzhu5;
        object5 = zzib2.zzx.zzc();
        object2 = ((zzae)object5).zzn(null, (zzdv)(object = zzdw.zzat));
        if (object2 != 0 && (object2 = (Object)zzhu5.zze) != 0) {
            zzib2.zzh = zzhu5;
        }
        zzib2.zzx.zzy().zzz(zzhu5);
    }

    private final void zzC(zzhu zzhu2, boolean bl2, long l10) {
        boolean bl3;
        zzd zzd2 = this.zzx.zzB();
        Clock clock = this.zzx.zzax();
        long l11 = clock.elapsedRealtime();
        zzd2.zzc(l11);
        zzd2 = null;
        if (zzhu2 != null && (bl3 = zzhu2.zzd)) {
            bl3 = true;
        } else {
            bl3 = false;
            clock = null;
        }
        zzjo zzjo2 = this.zzx.zzh().zzb;
        bl2 = zzjo2.zzd(bl3, bl2, l10);
        if (bl2 && zzhu2 != null) {
            zzhu2.zzd = false;
        }
    }

    private final zzhu zzD(Activity object) {
        boolean bl2;
        Object object2;
        Preconditions.checkNotNull(object);
        Object object3 = (zzhu)this.zzd.get(object);
        if (object3 == null) {
            object3 = object.getClass();
            object3 = this.zzi((Class)object3, "Activity");
            zzkk zzkk2 = this.zzx.zzl();
            long l10 = zzkk2.zzd();
            object2 = new zzhu(null, (String)object3, l10);
            this.zzd.put(object, object2);
            object3 = object2;
        }
        if (!(bl2 = ((zzae)(object = this.zzx.zzc())).zzn(null, (zzdv)(object2 = zzdw.zzat)))) {
            return object3;
        }
        object = this.zzg;
        if (object != null) {
            return this.zzg;
        }
        return object3;
    }

    public static void zzm(zzhu zzhu2, Bundle bundle, boolean bl2) {
        String string2 = "_si";
        String string3 = "_sn";
        String string4 = "_sc";
        if (zzhu2 != null) {
            boolean bl3 = bundle.containsKey(string4);
            if (bl3 && !bl2) {
                bl2 = false;
                Object var7_7 = null;
            } else {
                String string5 = zzhu2.zza;
                if (string5 != null) {
                    bundle.putString(string3, string5);
                } else {
                    bundle.remove(string3);
                }
                string5 = zzhu2.zzb;
                if (string5 != null) {
                    bundle.putString(string4, string5);
                } else {
                    bundle.remove(string4);
                }
                long l10 = zzhu2.zzc;
                bundle.putLong(string2, l10);
                return;
            }
        }
        if (zzhu2 == null && bl2) {
            bundle.remove(string3);
            bundle.remove(string4);
            bundle.remove(string2);
        }
    }

    public static /* synthetic */ void zzu(zzib zzib2, Bundle bundle, zzhu zzhu2, zzhu zzhu3, long l10) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        Bundle bundle2 = zzib2.zzx.zzl().zzF(null, "screen_view", bundle, null, true);
        boolean bl2 = true;
        zzib2.zzB(zzhu2, zzhu3, l10, bl2, bundle2);
    }

    public static /* synthetic */ void zzv(zzib zzib2, zzhu zzhu2, zzhu zzhu3, long l10, boolean bl2, Bundle bundle) {
        zzib2.zzB(zzhu2, zzhu3, l10, bl2, null);
    }

    public static /* synthetic */ zzhu zzx(zzib zzib2) {
        return zzib2.zzh;
    }

    public static /* synthetic */ void zzy(zzib zzib2, zzhu zzhu2, boolean bl2, long l10) {
        zzib2.zzC(zzhu2, false, l10);
    }

    public static /* synthetic */ zzhu zzz(zzib zzib2, zzhu zzhu2) {
        zzib2.zzh = null;
        return null;
    }

    public final boolean zze() {
        return false;
    }

    public final zzhu zzh(boolean bl2) {
        this.zzb();
        ((zzge)this).zzg();
        zzae zzae2 = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zzat;
        boolean bl3 = zzae2.zzn(null, zzdv2);
        if (bl3 && bl2) {
            zzhu zzhu2 = this.zza;
            if (zzhu2 != null) {
                return zzhu2;
            }
            return this.zzh;
        }
        return this.zza;
    }

    public final String zzi(Class object, String string2) {
        if ((object = ((Class)object).getCanonicalName()) == null) {
            return "Activity";
        }
        string2 = "\\.";
        int n10 = ((String[])(object = ((String)object).split(string2))).length;
        object = n10 > 0 ? object[n10 += -1] : "";
        n10 = ((String)object).length();
        zzfl zzfl2 = this.zzx;
        zzfl2.zzc();
        int n11 = 100;
        if (n10 > n11) {
            this.zzx.zzc();
            n10 = 0;
            string2 = null;
            object = ((String)object).substring(0, n11);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzj(Bundle object, long l10) {
        zzhv zzhv2;
        Object object2;
        Class<?> clazz;
        String string2;
        Object object3 = this.zzx.zzc();
        Object object4 = zzdw.zzat;
        int n10 = 0;
        Object object5 = null;
        boolean bl2 = ((zzae)object3).zzn(null, (zzdv)object4);
        if (!bl2) {
            this.zzx.zzat().zzh().zza("Manual screen reporting is disabled.");
            return;
        }
        object3 = this.zzj;
        synchronized (object3) {
            int n11;
            block19: {
                block20: {
                    block17: {
                        block18: {
                            n11 = this.zzi;
                            if (n11 == 0) {
                                object = this.zzx;
                                object = ((zzfl)object).zzat();
                                object = ((zzei)object).zzh();
                                String string3 = "Cannot log screen view event when the app is in the background.";
                                ((zzeg)object).zza(string3);
                                return;
                            }
                            object4 = "screen_name";
                            string2 = object.getString((String)object4);
                            n11 = 100;
                            if (string2 == null) break block17;
                            n10 = string2.length();
                            if (n10 <= 0) break block18;
                            n10 = string2.length();
                            clazz = this.zzx;
                            ((zzfl)((Object)clazz)).zzc();
                            if (n10 <= n11) break block17;
                        }
                        object = this.zzx;
                        object = ((zzfl)object).zzat();
                        object = ((zzei)object).zzh();
                        String string4 = "Invalid screen name length for screen view. Length";
                        int n12 = string2.length();
                        Integer n13 = n12;
                        ((zzeg)object).zzb(string4, n13);
                        return;
                    }
                    object5 = "screen_class";
                    if ((object5 = object.getString((String)object5)) == null) break block19;
                    int n14 = ((String)object5).length();
                    if (n14 <= 0) break block20;
                    n14 = ((String)object5).length();
                    object2 = this.zzx;
                    ((zzfl)object2).zzc();
                    if (n14 <= n11) break block19;
                }
                object = this.zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzh();
                String string5 = "Invalid screen class length for screen view. Length";
                int n15 = ((String)object5).length();
                Integer n16 = n15;
                ((zzeg)object).zzb(string5, n16);
                return;
            }
            if (object5 == null) {
                object4 = this.zze;
                if (object4 != null) {
                    object4 = object4.getClass();
                    object5 = "Activity";
                    object4 = this.zzi((Class)object4, (String)object5);
                } else {
                    object4 = "Activity";
                }
                clazz = object4;
            } else {
                clazz = object5;
            }
            object4 = this.zzb;
            n10 = (int)(this.zzf ? 1 : 0);
            if (n10 != 0 && object4 != null) {
                n10 = 0;
                object5 = null;
                this.zzf = false;
                object5 = ((zzhu)object4).zzb;
                n10 = (int)(zzkk.zzS((String)object5, clazz) ? 1 : 0);
                object4 = ((zzhu)object4).zza;
                n11 = (int)(zzkk.zzS((String)object4, string2) ? 1 : 0);
                if (n10 != 0 && n11 != 0) {
                    object = this.zzx;
                    object = ((zzfl)object).zzat();
                    object = ((zzei)object).zzh();
                    String string6 = "Ignoring call to log screen view event with duplicate parameters.";
                    ((zzeg)object).zza(string6);
                    return;
                }
            }
        }
        object3 = this.zzx.zzat().zzk();
        object4 = string2 == null ? "null" : string2;
        object5 = clazz == null ? "null" : clazz;
        object2 = "Logging screen view with name, class";
        ((zzeg)object3).zzc((String)object2, object4, object5);
        object3 = this.zzb;
        object3 = object3 == null ? this.zzc : this.zzb;
        long l11 = this.zzx.zzl().zzd();
        object5 = object4;
        this.zzb = object4 = new zzhu(string2, (String)((Object)clazz), l11, true, l10);
        this.zzc = object3;
        this.zzg = object4;
        long l12 = this.zzx.zzax().elapsedRealtime();
        zzfi zzfi2 = this.zzx.zzau();
        object2 = zzhv2;
        zzhv2 = new zzhv(this, (Bundle)object, (zzhu)object4, (zzhu)object3, l12);
        zzfi2.zzh(zzhv2);
    }

    public final void zzk(Activity object, String object2, String object3) {
        Object object4;
        Object object5;
        block13: {
            block14: {
                zzfl zzfl2;
                int n10;
                int n11;
                block11: {
                    block12: {
                        object5 = this.zzx.zzc();
                        boolean n112 = ((zzae)object5).zzt();
                        if (!n112) {
                            this.zzx.zzat().zzh().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
                            return;
                        }
                        object5 = this.zzb;
                        if (object5 == null) {
                            this.zzx.zzat().zzh().zza("setCurrentScreen cannot be called while no activity active");
                            return;
                        }
                        object4 = this.zzd.get(object);
                        if (object4 == null) {
                            this.zzx.zzat().zzh().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
                            return;
                        }
                        if (object3 == null) {
                            object3 = object.getClass();
                            object4 = "Activity";
                            object3 = this.zzi((Class)object3, (String)object4);
                        }
                        object4 = ((zzhu)object5).zzb;
                        n11 = zzkk.zzS(object4, object3);
                        object5 = ((zzhu)object5).zza;
                        boolean bl2 = zzkk.zzS((String)object5, (String)object2);
                        if (n11 != 0 && bl2) {
                            this.zzx.zzat().zzh().zza("setCurrentScreen cannot be called with the same class and name");
                            return;
                        }
                        n10 = 100;
                        if (object2 == null) break block11;
                        n11 = ((String)object2).length();
                        if (n11 <= 0) break block12;
                        n11 = ((String)object2).length();
                        zzfl2 = this.zzx;
                        zzfl2.zzc();
                        if (n11 <= n10) break block11;
                    }
                    object = this.zzx.zzat().zzh();
                    object2 = ((String)object2).length();
                    ((zzeg)object).zzb("Invalid screen name length in setCurrentScreen. Length", object2);
                    return;
                }
                if (object3 == null) break block13;
                n11 = ((String)object3).length();
                if (n11 <= 0) break block14;
                n11 = ((String)object3).length();
                zzfl2 = this.zzx;
                zzfl2.zzc();
                if (n11 <= n10) break block13;
            }
            object = this.zzx.zzat().zzh();
            object2 = ((String)object3).length();
            ((zzeg)object).zzb("Invalid class name length in setCurrentScreen. Length", object2);
            return;
        }
        object5 = this.zzx.zzat().zzk();
        object4 = object2 == null ? "null" : object2;
        ((zzeg)object5).zzc("Setting current screen to name, class", object4, object3);
        long l10 = this.zzx.zzl().zzd();
        object5 = new zzhu((String)object2, (String)object3, l10);
        this.zzd.put(object, object5);
        this.zzA((Activity)object, (zzhu)object5, true);
    }

    public final zzhu zzl() {
        return this.zzb;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzn(String string2, zzhu zzhu2) {
        ((zzge)this).zzg();
        synchronized (this) {
            boolean bl2;
            String string3 = this.zzl;
            if (string3 == null || (bl2 = string3.equals(string2)) || zzhu2 != null) {
                this.zzl = string2;
                this.zzk = zzhu2;
            }
            return;
        }
    }

    public final void zzo(Activity activity, Bundle bundle) {
        Object object = this.zzx.zzc();
        boolean bl2 = ((zzae)object).zzt();
        if (!bl2) {
            return;
        }
        if (bundle == null) {
            return;
        }
        object = "com.google.app_measurement.screen_service";
        if ((bundle = bundle.getBundle((String)object)) == null) {
            return;
        }
        String string2 = bundle.getString("name");
        String string3 = bundle.getString("referrer_name");
        long l10 = bundle.getLong("id");
        object = new zzhu(string2, string3, l10);
        this.zzd.put(activity, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzq(Activity object) {
        Object object2;
        Object object3 = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zzat;
        zzfi zzfi2 = null;
        boolean bl2 = ((zzae)object3).zzn(null, zzdv2);
        zzdv2 = null;
        if (bl2) {
            object3 = this.zzj;
            synchronized (object3) {
                boolean bl3;
                this.zzi = bl3 = true;
                object2 = this.zze;
                if (object != object2) {
                    object2 = this.zzj;
                    synchronized (object2) {
                        this.zze = object;
                        this.zzf = false;
                    }
                    object2 = this.zzx;
                    object2 = ((zzfl)object2).zzc();
                    Object object4 = zzdw.zzas;
                    bl3 = ((zzae)object2).zzn(null, (zzdv)object4);
                    if (bl3) {
                        object2 = this.zzx;
                        bl3 = ((zzae)(object2 = ((zzfl)object2).zzc())).zzt();
                        if (bl3) {
                            this.zzg = null;
                            object2 = this.zzx;
                            object2 = ((zzfl)object2).zzau();
                            object4 = new zzia(this);
                            ((zzfi)object2).zzh((Runnable)object4);
                        }
                    }
                }
            }
        }
        if ((bl2 = ((zzae)(object3 = this.zzx.zzc())).zzn(null, (zzdv)(object2 = zzdw.zzas))) && !(bl2 = ((zzae)(object3 = this.zzx.zzc())).zzt())) {
            object = this.zzg;
            this.zzb = object;
            object = this.zzx.zzau();
            object3 = new zzhx(this);
            ((zzfi)object).zzh((Runnable)object3);
            return;
        }
        object3 = this.zzD((Activity)object);
        this.zzA((Activity)object, (zzhu)object3, false);
        object = this.zzx.zzB();
        long l10 = ((zzge)object).zzx.zzax().elapsedRealtime();
        zzfi2 = ((zzge)object).zzx.zzau();
        object2 = new zzc((zzd)object, l10);
        zzfi2.zzh((Runnable)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzr(Activity object) {
        zzdv zzdv2;
        Object object2 = this.zzx.zzc();
        zzdv zzdv3 = zzdw.zzat;
        Object object3 = null;
        boolean bl2 = ((zzae)object2).zzn(null, zzdv3);
        if (bl2) {
            object2 = this.zzj;
            synchronized (object2) {
                boolean bl3 = false;
                zzdv3 = null;
                this.zzi = false;
                this.zzf = bl3 = true;
            }
        }
        object2 = this.zzx.zzax();
        long l10 = object2.elapsedRealtime();
        Object object4 = this.zzx.zzc();
        boolean bl4 = ((zzae)object4).zzn(null, zzdv2 = zzdw.zzas);
        if (bl4 && !(bl4 = ((zzae)(object4 = this.zzx.zzc())).zzt())) {
            this.zzb = null;
            object = this.zzx.zzau();
            object3 = new zzhy(this, l10);
            ((zzfi)object).zzh((Runnable)object3);
            return;
        }
        object = this.zzD((Activity)object);
        this.zzc = object4 = this.zzb;
        this.zzb = null;
        object3 = this.zzx.zzau();
        object4 = new zzhz(this, (zzhu)object, l10);
        ((zzfi)object3).zzh((Runnable)object4);
    }

    public final void zzs(Activity object, Bundle bundle) {
        Object object2 = this.zzx.zzc();
        boolean bl2 = ((zzae)object2).zzt();
        if (!bl2) {
            return;
        }
        if (bundle == null) {
            return;
        }
        object2 = this.zzd;
        if ((object = (zzhu)object2.get(object)) == null) {
            return;
        }
        object2 = new Bundle();
        long l10 = object.zzc;
        object2.putLong("id", l10);
        String string2 = object.zza;
        object2.putString("name", string2);
        object = object.zzb;
        object2.putString("referrer_name", (String)object);
        bundle.putBundle("com.google.app_measurement.screen_service", (Bundle)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzt(Activity activity) {
        Object object = this.zzj;
        synchronized (object) {
            Activity activity2 = this.zze;
            if (activity == activity2) {
                activity2 = null;
                this.zze = null;
            }
        }
        object = this.zzx.zzc();
        boolean bl2 = ((zzae)object).zzt();
        if (!bl2) {
            return;
        }
        this.zzd.remove(activity);
    }
}

