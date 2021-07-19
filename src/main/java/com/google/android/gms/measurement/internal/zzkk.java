/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzkw;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzed;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzej;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgh;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzkj;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class zzkk
extends zzgf {
    public static final /* synthetic */ int zza;
    private static final String[] zzb = new String[]{"firebase_", "google_", "ga_"};
    private static final String[] zzc = new String[]{"_err"};
    private SecureRandom zzd;
    private final AtomicLong zze;
    private int zzf;
    private Integer zzg = null;

    public zzkk(zzfl object) {
        super((zzfl)object);
        this.zze = object = new AtomicLong(0L);
    }

    public static MessageDigest zzN() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 2); ++i10) {
            Object object = "MD5";
            try {
                object = MessageDigest.getInstance((String)object);
                if (object == null) continue;
                return object;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        }
        return null;
    }

    public static long zzO(byte[] byArray) {
        int n10;
        Preconditions.checkNotNull(byArray);
        int n11 = byArray.length;
        int n12 = 0;
        boolean bl2 = n11 > 0;
        Preconditions.checkState(bl2);
        n11 += -1;
        long l10 = 0L;
        while (n11 >= 0 && n11 >= (n10 = byArray.length + -8)) {
            n10 = byArray[n11];
            long l11 = n10;
            long l12 = 255L;
            l11 = (l11 & l12) << n12;
            l10 += l11;
            n12 += 8;
            n11 += -1;
        }
        return l10;
    }

    public static boolean zzP(Context context, boolean n10) {
        Preconditions.checkNotNull(context);
        n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return zzkk.zzaq(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzkk.zzaq(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzR(String string2) {
        String string3;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        return !bl3 && (bl2 = string2.startsWith(string3 = "_"));
    }

    public static boolean zzS(String string2, String string3) {
        if (string2 == null && string3 == null) {
            return true;
        }
        if (string2 == null) {
            return false;
        }
        return string2.equals(string3);
    }

    public static boolean zzY(String string2) {
        String string3 = zzc[0];
        boolean bl2 = string3.equals(string2);
        return !bl2;
    }

    public static ArrayList zzak(List object) {
        if (object == null) {
            object = new ArrayList(0);
            return object;
        }
        int n10 = object.size();
        ArrayList<Bundle> arrayList = new ArrayList<Bundle>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            AbstractSafeParcelable abstractSafeParcelable = (zzaa)object.next();
            Bundle bundle = new Bundle();
            Object object2 = ((zzaa)abstractSafeParcelable).zza;
            bundle.putString("app_id", (String)object2);
            object2 = ((zzaa)abstractSafeParcelable).zzb;
            bundle.putString("origin", (String)object2);
            long l10 = ((zzaa)abstractSafeParcelable).zzd;
            String string2 = "creation_timestamp";
            bundle.putLong(string2, l10);
            object2 = abstractSafeParcelable.zzc.zzb;
            bundle.putString("name", (String)object2);
            object2 = ((zzaa)abstractSafeParcelable).zzc.zza();
            zzgh.zza(bundle, object2);
            boolean bl2 = ((zzaa)abstractSafeParcelable).zze;
            String string3 = "active";
            bundle.putBoolean(string3, bl2);
            object2 = ((zzaa)abstractSafeParcelable).zzf;
            if (object2 != null) {
                string3 = "trigger_event_name";
                bundle.putString(string3, (String)object2);
            }
            if ((object2 = ((zzaa)abstractSafeParcelable).zzg) != null) {
                object2 = ((zzas)object2).zza;
                string3 = "timed_out_event_name";
                bundle.putString(string3, (String)object2);
                object2 = abstractSafeParcelable.zzg.zzb;
                if (object2 != null) {
                    object2 = ((zzaq)object2).zzf();
                    string3 = "timed_out_event_params";
                    bundle.putBundle(string3, (Bundle)object2);
                }
            }
            l10 = ((zzaa)abstractSafeParcelable).zzh;
            string2 = "trigger_timeout";
            bundle.putLong(string2, l10);
            object2 = ((zzaa)abstractSafeParcelable).zzi;
            if (object2 != null) {
                object2 = ((zzas)object2).zza;
                string3 = "triggered_event_name";
                bundle.putString(string3, (String)object2);
                object2 = abstractSafeParcelable.zzi.zzb;
                if (object2 != null) {
                    object2 = ((zzaq)object2).zzf();
                    string3 = "triggered_event_params";
                    bundle.putBundle(string3, (Bundle)object2);
                }
            }
            l10 = abstractSafeParcelable.zzc.zzc;
            bundle.putLong("triggered_timestamp", l10);
            l10 = ((zzaa)abstractSafeParcelable).zzj;
            string2 = "time_to_live";
            bundle.putLong(string2, l10);
            object2 = ((zzaa)abstractSafeParcelable).zzk;
            if (object2 != null) {
                object2 = ((zzas)object2).zza;
                string3 = "expired_event_name";
                bundle.putString(string3, (String)object2);
                abstractSafeParcelable = abstractSafeParcelable.zzk.zzb;
                if (abstractSafeParcelable != null) {
                    abstractSafeParcelable = ((zzaq)abstractSafeParcelable).zzf();
                    object2 = "expired_event_params";
                    bundle.putBundle((String)object2, (Bundle)abstractSafeParcelable);
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static final boolean zzam(Bundle bundle, int n10) {
        long l10;
        String string2 = "_err";
        long l11 = bundle.getLong(string2);
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l11 = n10;
            bundle.putLong(string2, l11);
            return true;
        }
        return false;
    }

    public static final boolean zzan(String string2) {
        Preconditions.checkNotNull(string2);
        return string2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final Object zzao(int n10, Object parcelableArray, boolean bl2, boolean bl3) {
        Parcelable parcelable2 = null;
        if (parcelableArray == null) {
            return null;
        }
        boolean bl4 = parcelableArray instanceof Long;
        if (!bl4 && !(bl4 = parcelableArray instanceof Double)) {
            bl4 = parcelableArray instanceof Integer;
            if (bl4) {
                return (long)((Integer)parcelableArray).intValue();
            }
            bl4 = parcelableArray instanceof Byte;
            if (bl4) {
                return (long)((Byte)parcelableArray).byteValue();
            }
            bl4 = parcelableArray instanceof Short;
            if (bl4) {
                return (long)((Short)parcelableArray).shortValue();
            }
            bl4 = parcelableArray instanceof Boolean;
            if (bl4) {
                int n11 = 1;
                n10 = (int)((parcelableArray = (Boolean)parcelableArray).booleanValue() ? 1 : 0);
                long l10 = n11 != n10 ? 0L : 1L;
                return l10;
            }
            bl4 = parcelableArray instanceof Float;
            if (bl4) {
                return ((Float)parcelableArray).doubleValue();
            }
            bl4 = parcelableArray instanceof String;
            if (!(bl4 || (bl4 = parcelableArray instanceof Character) || (bl4 = parcelableArray instanceof CharSequence))) {
                if (bl3 && ((n10 = parcelableArray instanceof Bundle[]) != 0 || (n10 = parcelableArray instanceof Parcelable[]) != 0)) {
                    ArrayList<Parcelable> arrayList = new ArrayList<Parcelable>();
                    for (Parcelable parcelable2 : (Parcelable[])parcelableArray) {
                        bl4 = parcelable2 instanceof Bundle;
                        if (!bl4) continue;
                        parcelable2 = (Bundle)parcelable2;
                        bl4 = (parcelable2 = this.zzU((Bundle)parcelable2)).isEmpty();
                        if (bl4) continue;
                        arrayList.add(parcelable2);
                    }
                    parcelableArray = new Bundle[arrayList.size()];
                    return arrayList.toArray(parcelableArray);
                }
                return null;
            }
            parcelableArray = String.valueOf(parcelableArray);
            return this.zzC((String)parcelableArray, n10, bl2);
        }
        return parcelableArray;
    }

    private final int zzap(String string2) {
        Object object = "_ldl";
        boolean bl2 = ((String)object).equals(string2);
        if (bl2) {
            this.zzx.zzc();
            return 2048;
        }
        object = "_id";
        bl2 = ((String)object).equals(string2);
        if (!bl2) {
            boolean bl3;
            zzdv zzdv2;
            object = this.zzx.zzc();
            bl2 = ((zzae)object).zzn(null, zzdv2 = zzdw.zzaf);
            if (bl2 && (bl3 = ((String)(object = "_lgclid")).equals(string2))) {
                this.zzx.zzc();
                return 100;
            }
            this.zzx.zzc();
            return 36;
        }
        this.zzx.zzc();
        return 256;
    }

    private static boolean zzaq(Context context, String string2) {
        block8: {
            PackageManager packageManager;
            block7: {
                try {
                    packageManager = context.getPackageManager();
                    if (packageManager != null) break block7;
                    return false;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            }
            ComponentName componentName = new ComponentName(context, string2);
            context = packageManager.getServiceInfo(componentName, 0);
            if (context == null) break block8;
            boolean bl2 = context.enabled;
            if (bl2) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzar(String string2, String[] stringArray) {
        Preconditions.checkNotNull(stringArray);
        for (String string3 : stringArray) {
            boolean bl2 = zzkk.zzS(string2, string3);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static boolean zzh(String string2) {
        String string3;
        boolean bl2;
        Preconditions.checkNotEmpty(string2);
        char c10 = string2.charAt(0);
        char c11 = '_';
        return c10 != c11 || (bl2 = string2.equals(string3 = "_ep"));
        {
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean zzA(String object, String object2, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            boolean bl3 = zzkk.zzan((String)object);
            if (bl3) return true;
            object2 = this.zzx;
            bl3 = ((zzfl)object2).zzq();
            if (!bl3) return false;
            object2 = this.zzx.zzat().zzd();
            object = zzei.zzl((String)object);
            string2 = "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id";
            ((zzeg)object2).zzb(string2, object);
            return false;
        }
        zzmg.zzb();
        object = this.zzx.zzc();
        bl2 = false;
        zzdv zzdv2 = zzdw.zzah;
        boolean bl4 = ((zzae)object).zzn(null, zzdv2);
        if (bl4 && !(bl4 = TextUtils.isEmpty((CharSequence)string2))) return true;
        bl4 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl4) {
            bl4 = zzkk.zzan((String)object2);
            if (bl4) return true;
            object = this.zzx.zzat().zzd();
            object2 = zzei.zzl((String)object2);
            ((zzeg)object).zzb("Invalid admob_app_id. Analytics disabled.", object2);
            return false;
        }
        object = this.zzx;
        bl4 = ((zzfl)object).zzq();
        if (!bl4) return false;
        object = this.zzx.zzat().zzd();
        object2 = "Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI";
        ((zzeg)object).zza((String)object2);
        return false;
    }

    public final boolean zzB(String string2, String string3, String string4, String string5) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        boolean bl4 = true;
        if (!bl2 && !bl3) {
            Preconditions.checkNotNull(string2);
            boolean bl5 = string2.equals(string3);
            if (!bl5) {
                return bl4;
            }
            return false;
        }
        if (bl2 && bl3) {
            boolean bl6 = TextUtils.isEmpty((CharSequence)string4);
            if (!bl6 && !(bl6 = TextUtils.isEmpty((CharSequence)string5))) {
                bl6 = string4.equals(string5);
                if (!bl6) {
                    return bl4;
                }
                return false;
            }
            bl6 = TextUtils.isEmpty((CharSequence)string5);
            if (!bl6) {
                return bl4;
            }
            return false;
        }
        if (!bl2) {
            boolean bl7 = TextUtils.isEmpty((CharSequence)string5);
            if (bl7) {
                return false;
            }
            bl7 = TextUtils.isEmpty((CharSequence)string4);
            if (!bl7 && (bl7 = string4.equals(string5))) {
                return false;
            }
            return bl4;
        }
        boolean bl8 = TextUtils.isEmpty((CharSequence)string4);
        if (!bl8 && (bl8 = string4.equals(string5))) {
            return false;
        }
        return bl4;
    }

    public final String zzC(String string2, int n10, boolean bl2) {
        if (string2 == null) {
            return null;
        }
        int n11 = string2.length();
        if ((n11 = string2.codePointCount(0, n11)) > n10) {
            if (bl2) {
                n10 = string2.offsetByCodePoints(0, n10);
                return String.valueOf(string2.substring(0, n10)).concat("...");
            }
            return null;
        }
        return string2;
    }

    /*
     * WARNING - void declaration
     */
    public final int zzD(String string2, String string3, String string4, Object parcelableArray, Bundle bundle, List list, boolean bl2, boolean bl3) {
        block17: {
            int n10;
            block24: {
                Object object;
                Object object2;
                String string5;
                Object object3;
                Parcelable[] object42;
                String string6;
                zzkk zzkk2;
                block25: {
                    block23: {
                        void var22_49;
                        boolean bl4;
                        boolean bl5;
                        Object object4;
                        block22: {
                            block18: {
                                block19: {
                                    void var17_33;
                                    Object object5;
                                    int n11;
                                    int n12;
                                    block21: {
                                        block20: {
                                            int n13;
                                            zzkk2 = this;
                                            string6 = string4;
                                            object42 = parcelableArray;
                                            object3 = bundle;
                                            this.zzg();
                                            n12 = this.zzs(parcelableArray);
                                            string5 = "param";
                                            n11 = 17;
                                            if (n12 == 0) break block18;
                                            if (!bl3) break block19;
                                            object2 = zzgj.zzc;
                                            n12 = zzkk.zzar(string4, (String[])object2);
                                            if (n12 == 0) {
                                                return 20;
                                            }
                                            object2 = this.zzx.zzy();
                                            ((zzge)object2).zzg();
                                            ((zzf)object2).zzb();
                                            boolean bl6 = ((zzjb)object2).zzD();
                                            if (bl6 && (n12 = ((zzkk)(object2 = ((zzge)object2).zzx.zzl())).zzZ()) < (n13 = 200900)) {
                                                return 25;
                                            }
                                            object2 = zzkk2.zzx;
                                            ((zzfl)object2).zzc();
                                            n12 = object42 instanceof Parcelable[];
                                            if (n12 == 0) break block20;
                                            object5 = object42;
                                            object5 = object42;
                                            int n14 = ((Parcelable[])object5).length;
                                            break block21;
                                        }
                                        boolean bl7 = object42 instanceof ArrayList;
                                        if (!bl7) break block18;
                                        object5 = object42;
                                        object5 = (ArrayList)object42;
                                        int n15 = ((ArrayList)object5).size();
                                    }
                                    n10 = 200;
                                    if (var17_33 <= n10) break block18;
                                    object4 = zzkk2.zzx.zzat().zzh();
                                    object5 = (int)var17_33;
                                    object = "Parameter array is too long; discarded. Value kind, name, array length";
                                    ((zzeg)object4).zzd((String)object, string5, string6, object5);
                                    object5 = zzkk2.zzx;
                                    ((zzfl)object5).zzc();
                                    if (n12 != 0) {
                                        object2 = object42;
                                        object2 = object42;
                                        int n16 = ((Object)object2).length;
                                        if (n16 > n10) {
                                            object2 = (Parcelable[])Arrays.copyOf(object2, n10);
                                            object3.putParcelableArray(string6, (Parcelable[])object2);
                                        }
                                    } else {
                                        n12 = object42 instanceof ArrayList;
                                        if (n12 != 0) {
                                            object2 = object42;
                                            object2 = (ArrayList)object42;
                                            int n17 = ((ArrayList)object2).size();
                                            if (n17 > n10) {
                                                object2 = ((ArrayList)object2).subList(0, n10);
                                                object5 = new ArrayList(object2);
                                                object3.putParcelableArrayList(string6, (ArrayList)object5);
                                            }
                                        }
                                    }
                                    n10 = n11;
                                    break block22;
                                }
                                return 21;
                            }
                            n10 = 0;
                        }
                        object3 = zzkk2.zzx.zzc();
                        object2 = zzdw.zzR;
                        object4 = string2;
                        boolean bl8 = ((zzae)object3).zzn(string2, (zzdv)object2);
                        if (bl8 && (bl5 = zzkk.zzR(string3)) || (bl4 = zzkk.zzR(string4))) {
                            object3 = zzkk2.zzx;
                            ((zzfl)object3).zzc();
                            int n18 = 256;
                        } else {
                            object3 = zzkk2.zzx;
                            ((zzfl)object3).zzc();
                            int n19 = 100;
                        }
                        boolean bl9 = this.zzt(string5, string6, (int)var22_49, object42);
                        if (bl9) {
                            return n10;
                        }
                        if (!bl3) break block17;
                        boolean bl10 = object42 instanceof Bundle;
                        if (!bl10) break block23;
                        Parcelable[] parcelableArray2 = object42;
                        parcelableArray2 = object42;
                        zzkk zzkk3 = this;
                        object3 = string2;
                        object2 = string3;
                        string5 = string4;
                        boolean bl11 = bl2;
                        this.zzz(string2, string3, string4, (Bundle)parcelableArray2, list, bl2);
                        break block24;
                    }
                    boolean bl12 = object42 instanceof Parcelable[];
                    if (!bl12) break block25;
                    object = object42;
                    for (Parcelable parcelable : (Parcelable[])object42) {
                        boolean bl13 = parcelable instanceof Bundle;
                        if (!bl13) {
                            object3 = zzkk2.zzx.zzat().zzh();
                            Class<?> clazz = parcelable.getClass();
                            object2 = "All Parcelable[] elements must be of type Bundle. Value type, name";
                            ((zzeg)object3).zzc((String)object2, clazz, string6);
                            break block17;
                        }
                        Parcelable parcelable2 = parcelable;
                        parcelable2 = (Bundle)parcelable;
                        zzkk zzkk4 = this;
                        object3 = string2;
                        object2 = string3;
                        string5 = string4;
                        boolean bl14 = bl2;
                        this.zzz(string2, string3, string4, (Bundle)parcelable2, list, bl2);
                    }
                    break block24;
                }
                boolean bl15 = object42 instanceof ArrayList;
                if (bl15) {
                    object = object42;
                    object = (ArrayList)object42;
                    int n20 = object.size();
                    for (int i10 = 0; i10 < n20; ++i10) {
                        Object e10 = object.get(i10);
                        boolean bl16 = e10 instanceof Bundle;
                        if (!bl16) {
                            void var11_21;
                            object3 = zzkk2.zzx.zzat().zzh();
                            if (e10 != null) {
                                Class<?> clazz = e10.getClass();
                            } else {
                                String string7 = "null";
                            }
                            object2 = "All ArrayList elements must be of type Bundle. Value type, name";
                            ((zzeg)object3).zzc((String)object2, var11_21, string6);
                            break block17;
                        }
                        Object object6 = e10;
                        object6 = (Bundle)e10;
                        zzkk zzkk5 = this;
                        object3 = string2;
                        object2 = string3;
                        string5 = string4;
                        boolean bl17 = bl2;
                        this.zzz(string2, string3, string4, (Bundle)object6, list, bl2);
                    }
                }
                break block17;
            }
            return n10;
        }
        return 4;
    }

    public final Object zzE(String object, Object object2) {
        String string2 = "_ev";
        boolean bl2 = string2.equals(object);
        int n10 = 256;
        boolean bl3 = true;
        if (bl2) {
            this.zzx.zzc();
            return this.zzao(n10, object2, bl3, bl3);
        }
        boolean bl4 = zzkk.zzR((String)object);
        if (bl4) {
            object = this.zzx;
            ((zzfl)object).zzc();
        } else {
            object = this.zzx;
            ((zzfl)object).zzc();
            n10 = 100;
        }
        return this.zzao(n10, object2, false, bl3);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Bundle zzF(String var1_1, String var2_2, Bundle var3_3, List var4_4, boolean var5_5) {
        var6_6 = this;
        var7_7 = var2_2;
        var8_8 = var3_3;
        var9_9 = var4_4;
        var10_10 = zzgi.zzd;
        var11_11 = zzkk.zzar(var2_2, (String[])var10_10);
        var12_12 = new Bundle(var3_3);
        var13_13 = this.zzx.zzc().zzc();
        var10_10 = this.zzx.zzc();
        var15_15 = var10_10.zzn(var1_1, (zzdv)(var14_14 = zzdw.zzX));
        if (var15_15 != 0) {
            var14_14 = var3_3.keySet();
            var10_10 = new TreeSet(var14_14);
        } else {
            var10_10 = var3_3.keySet();
        }
        var16_16 = var10_10.iterator();
        var17_17 = 0;
        while ((var15_15 = var16_16.hasNext()) != 0) {
            block16: {
                var10_10 = var16_16.next();
                var18_18 = var10_10;
                var18_18 = (String)var10_10;
                if (var9_9 != null && (var15_15 = var9_9.contains(var18_18)) != 0) {
                    var19_19 = 0;
                    var20_20 = null;
                } else {
                    if (var5_5) {
                        var15_15 = var6_6.zzq((String)var18_18);
                    } else {
                        var15_15 = 0;
                        var10_10 = null;
                    }
                    if (var15_15 == 0) {
                        var15_15 = var6_6.zzr((String)var18_18);
                    }
                    var19_19 = var15_15;
                }
                if (var19_19 != 0) {
                    var15_15 = 3;
                    if (var19_19 == var15_15) {
                        var21_21 /* !! */  = var18_18;
                    } else {
                        var15_15 = 0;
                        var10_10 = null;
                        var21_21 /* !! */  = null;
                    }
                    var10_10 = this;
                    var14_14 = var12_12;
                    var22_22 /* !! */  = var18_18;
                    var23_23 /* !! */  = var18_18;
                    this.zzI(var12_12, var19_19, (String)var18_18, (String)var18_18, var21_21 /* !! */ );
                    var12_12.remove((String)var18_18);
                    continue;
                }
                var23_23 /* !! */  = var8_8.get((String)var18_18);
                var10_10 = this;
                var14_14 = var1_1;
                var20_20 = var2_2;
                var22_22 /* !! */  = var18_18;
                var21_21 /* !! */  = var12_12;
                var24_24 = var4_4;
                var25_25 = var18_18;
                var19_19 = this.zzD(var1_1, var2_2, (String)var18_18, var23_23 /* !! */ , var12_12, (List)var4_4, var5_5, var11_11);
                if (var19_19 != (var15_15 = 17)) break block16;
                var19_19 = 17;
                var21_21 /* !! */  = Boolean.FALSE;
                var14_14 = var12_12;
                var23_23 /* !! */  = var18_18;
                this.zzI(var12_12, var19_19, (String)var18_18, (String)var18_18, var21_21 /* !! */ );
                ** GOTO lbl-1000
            }
            if (var19_19 != 0) {
                var10_10 = "_ev";
                var24_24 = var18_18;
                var15_15 = (int)var10_10.equals(var18_18);
                if (var15_15 == 0) {
                    var15_15 = 21;
                    if (var19_19 == var15_15) {
                        var22_22 /* !! */  = var7_7;
                    }
                    var21_21 /* !! */  = var8_8.get((String)var24_24);
                    var10_10 = this;
                    var14_14 = var12_12;
                    var23_23 /* !! */  = var24_24;
                    this.zzI(var12_12, var19_19, (String)var22_22 /* !! */ , (String)var24_24, var21_21 /* !! */ );
                    var12_12.remove((String)var24_24);
                    continue;
                }
            } else lbl-1000:
            // 2 sources

            {
                var24_24 = var25_25;
            }
            if ((var15_15 = (int)zzkk.zzh((String)var24_24)) == 0) continue;
            var15_15 = var17_17 + 1;
            if (var15_15 > var13_13) {
                var19_19 = 48;
                var14_14 = new StringBuilder(var19_19);
                var14_14.append("Event can't contain more than ");
                var14_14.append(var13_13);
                var14_14.append(" params");
                var14_14 = var14_14.toString();
                var20_20 = var6_6.zzx.zzat().zzd();
                var22_22 /* !! */  = var6_6.zzx.zzm().zzc(var7_7);
                var23_23 /* !! */  = var6_6.zzx.zzm().zzf(var8_8);
                var20_20.zzc((String)var14_14, var22_22 /* !! */ , var23_23 /* !! */ );
                var26_26 = 5;
                zzkk.zzam(var12_12, var26_26);
                var12_12.remove((String)var24_24);
            }
            var17_17 = var15_15;
        }
        return var12_12;
    }

    public final void zzG(zzej zzej2, int n10) {
        boolean bl2;
        Set set = zzej2.zzd.keySet();
        Object object = new TreeSet(set);
        object = object.iterator();
        int n11 = 0;
        set = null;
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            boolean bl3 = zzkk.zzh(string2);
            if (!bl3 || ++n11 <= n10) continue;
            CharSequence charSequence = new StringBuilder(48);
            charSequence.append("Event can't contain more than ");
            charSequence.append(n10);
            charSequence.append(" params");
            charSequence = charSequence.toString();
            zzeg zzeg2 = this.zzx.zzat().zzd();
            Object object2 = this.zzx.zzm();
            Object object3 = zzej2.zza;
            object2 = ((zzed)object2).zzc((String)object3);
            object3 = this.zzx.zzm();
            Bundle bundle = zzej2.zzd;
            object3 = ((zzed)object3).zzf(bundle);
            zzeg2.zzc((String)charSequence, object2, object3);
            charSequence = zzej2.zzd;
            int n12 = 5;
            zzkk.zzam((Bundle)charSequence, n12);
            charSequence = zzej2.zzd;
            charSequence.remove(string2);
        }
    }

    public final void zzH(Bundle bundle, Bundle bundle2) {
        boolean bl2;
        if (bundle2 == null) {
            return;
        }
        Iterator iterator2 = bundle2.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            boolean bl3 = bundle.containsKey(string2);
            if (bl3) continue;
            zzkk zzkk2 = this.zzx.zzl();
            Object object = bundle2.get(string2);
            zzkk2.zzL(bundle, string2, object);
        }
    }

    public final void zzI(Bundle bundle, int n10, String string2, String string3, Object object) {
        if ((n10 = (int)(zzkk.zzam(bundle, n10) ? 1 : 0)) != 0) {
            this.zzx.zzc();
            n10 = 40;
            boolean bl2 = true;
            String string4 = this.zzC(string2, n10, bl2);
            string2 = "_ev";
            bundle.putString(string2, string4);
            if (object != null) {
                Preconditions.checkNotNull(bundle);
                n10 = object instanceof String;
                if (n10 != 0 || (n10 = object instanceof CharSequence) != 0) {
                    string4 = String.valueOf(object);
                    n10 = string4.length();
                    long l10 = n10;
                    string3 = "_el";
                    bundle.putLong(string3, l10);
                }
            }
        }
    }

    public final int zzJ(String string2, Object object) {
        boolean bl2;
        String string3 = "_ldl";
        int n10 = string3.equals(string2);
        if (n10 != 0) {
            n10 = this.zzap(string2);
            String string4 = "user property referrer";
            bl2 = this.zzt(string4, string2, n10, object);
        } else {
            n10 = this.zzap(string2);
            String string5 = "user property";
            bl2 = this.zzt(string5, string2, n10, object);
        }
        if (bl2) {
            return 0;
        }
        return 7;
    }

    public final Object zzK(String string2, Object object) {
        String string3 = "_ldl";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            int n10 = this.zzap(string2);
            return this.zzao(n10, object, true, false);
        }
        int n11 = this.zzap(string2);
        return this.zzao(n11, object, false, false);
    }

    public final void zzL(Bundle object, String string2, Object object2) {
        if (object == null) {
            return;
        }
        boolean bl2 = object2 instanceof Long;
        if (bl2) {
            long l10 = (Long)object2;
            object.putLong(string2, l10);
            return;
        }
        bl2 = object2 instanceof String;
        if (bl2) {
            object2 = String.valueOf(object2);
            object.putString(string2, (String)object2);
            return;
        }
        bl2 = object2 instanceof Double;
        if (bl2) {
            double d10 = (Double)object2;
            object.putDouble(string2, d10);
            return;
        }
        bl2 = object2 instanceof Bundle[];
        if (bl2) {
            object2 = (Bundle[])object2;
            object.putParcelableArray(string2, (Parcelable[])object2);
            return;
        }
        if (string2 != null) {
            object = object2 != null ? object2.getClass().getSimpleName() : null;
            object2 = this.zzx.zzat().zzh();
            string2 = this.zzx.zzm().zzd(string2);
            String string3 = "Not putting event parameter. Invalid value type. name, type";
            ((zzeg)object2).zzc(string3, string2, object);
        }
    }

    public final void zzM(zzkj zzkj2, String string2, int n10, String string3, String object, int n11) {
        int n12;
        Bundle bundle = new Bundle();
        zzkk.zzam(bundle, n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            bundle.putString(string3, (String)object);
        }
        if (n10 == (n12 = 6) || n10 == (n12 = 7) || n10 == (n12 = 2)) {
            long l10 = n11;
            object = "_el";
            bundle.putLong((String)object, l10);
        }
        zzkw.zzb();
        zzae zzae2 = this.zzx.zzc();
        n12 = 0;
        string3 = null;
        object = zzdw.zzaA;
        n10 = (int)(zzae2.zzn(null, (zzdv)object) ? 1 : 0);
        if (n10 != 0) {
            zzkj2.zza(string2, bundle);
            return;
        }
        this.zzx.zzas();
        this.zzx.zzk().zzs("auto", "_err", bundle);
    }

    public final boolean zzQ(String string2) {
        this.zzg();
        PackageManagerWrapper packageManagerWrapper = Wrappers.packageManager(this.zzx.zzaw());
        int n10 = packageManagerWrapper.checkCallingOrSelfPermission(string2);
        if (n10 == 0) {
            return true;
        }
        this.zzx.zzat().zzj().zzb("Permission not granted", string2);
        return false;
    }

    public final boolean zzT(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        String string3 = this.zzx.zzc().zzu();
        this.zzx.zzas();
        return string3.equals(string2);
    }

    public final Bundle zzU(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            boolean bl2;
            Iterator iterator2 = bundle.keySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                Object object = bundle.get(string2);
                if ((object = this.zzE(string2, object)) == null) {
                    object = this.zzx.zzat().zzh();
                    string2 = this.zzx.zzm().zzd(string2);
                    String string3 = "Param value can't be null";
                    ((zzeg)object).zzb(string3, string2);
                    continue;
                }
                this.zzL(bundle2, string2, object);
            }
        }
        return bundle2;
    }

    public final zzas zzV(String object, String string2, Bundle object2, String string3, long l10, boolean bl2, boolean bl3) {
        boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
        if (bl4) {
            return null;
        }
        int n10 = this.zzn(string2);
        if (n10 == 0) {
            Bundle bundle = object2 != null ? new Bundle((Bundle)object2) : new Bundle();
            object2 = "_o";
            bundle.putString((String)object2, string3);
            List list = CollectionUtils.listOf(object2);
            Object object3 = string2;
            object = this.zzF((String)object, string2, bundle, list, false);
            if (bl2) {
                object = this.zzU((Bundle)object);
            }
            Preconditions.checkNotNull(object);
            object3 = new zzaq((Bundle)object);
            object2 = new zzas(string2, (zzaq)object3, string3, l10);
            return object2;
        }
        object = this.zzx.zzat().zzb();
        string2 = this.zzx.zzm().zze(string2);
        ((zzeg)object).zzb("Invalid conditional property event name", string2);
        object = new IllegalArgumentException();
        throw object;
    }

    public final boolean zzW(Context object, String object2) {
        block15: {
            Object object3 = "CN=Android Debug,O=Android,C=US";
            Object object4 = new X500Principal((String)object3);
            object = Wrappers.packageManager((Context)object);
            int n10 = 64;
            object = ((PackageManagerWrapper)object).getPackageInfo((String)object2, n10);
            if (object == null) break block15;
            object = ((PackageInfo)object).signatures;
            if (object == null) break block15;
            int n11 = ((Object)object).length;
            if (n11 <= 0) break block15;
            n11 = 0;
            object2 = null;
            object = object[0];
            object2 = "X.509";
            object2 = CertificateFactory.getInstance((String)object2);
            object = object.toByteArray();
            object3 = new ByteArrayInputStream((byte[])object);
            object = ((CertificateFactory)object2).generateCertificate((InputStream)object3);
            object = (X509Certificate)object;
            object = ((X509Certificate)object).getSubjectX500Principal();
            try {
                return ((X500Principal)object).equals(object4);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object2 = this.zzx.zzat().zzb();
                object4 = "Package name not found";
                ((zzeg)object2).zzb((String)object4, (Object)nameNotFoundException);
            }
            catch (CertificateException certificateException) {
                object2 = this.zzx.zzat().zzb();
                object4 = "Error obtaining certificate";
                ((zzeg)object2).zzb((String)object4, certificateException);
            }
        }
        return true;
    }

    public final byte[] zzX(Parcelable object) {
        if (object == null) {
            return null;
        }
        Parcel parcel = Parcel.obtain();
        try {
            object.writeToParcel(parcel, 0);
            object = parcel.marshall();
            return object;
        }
        finally {
            parcel.recycle();
        }
    }

    public final int zzZ() {
        Object object = this.zzg;
        if (object == null) {
            object = GoogleApiAvailabilityLight.getInstance();
            Context context = this.zzx.zzaw();
            int n10 = ((GoogleApiAvailabilityLight)object).getApkVersion(context) / 1000;
            this.zzg = object = Integer.valueOf(n10);
        }
        return this.zzg;
    }

    public final boolean zza() {
        return true;
    }

    public final int zzaa(int n10) {
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Context context = this.zzx.zzaw();
        return googleApiAvailabilityLight.isGooglePlayServicesAvailable(context, 12451000);
    }

    public final long zzab(long l10, long l11) {
        return (l10 + (l11 *= 60000L)) / 86400000L;
    }

    public final void zzac(Bundle bundle, long l10) {
        long l11;
        String string2 = "_et";
        long l12 = bundle.getLong(string2);
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            zzeg zzeg2 = this.zzx.zzat().zze();
            Long l14 = l12;
            String string3 = "Params already contained engagement";
            zzeg2.zzb(string3, l14);
        }
        bundle.putLong(string2, l10 += l12);
    }

    public final void zzad(zzs zzs2, String string2) {
        Bundle bundle = new Bundle();
        String string3 = "r";
        bundle.putString(string3, string2);
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzx.zzat().zze().zzb("Error returning string value to wrapper", (Object)remoteException);
            return;
        }
    }

    public final void zzae(zzs zzs2, long l10) {
        Bundle bundle = new Bundle();
        String string2 = "r";
        bundle.putLong(string2, l10);
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzx.zzat().zze().zzb("Error returning long value to wrapper", (Object)remoteException);
            return;
        }
    }

    public final void zzaf(zzs zzs2, int n10) {
        Bundle bundle = new Bundle();
        String string2 = "r";
        bundle.putInt(string2, n10);
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzx.zzat().zze().zzb("Error returning int value to wrapper", (Object)remoteException);
            return;
        }
    }

    public final void zzag(zzs zzs2, byte[] byArray) {
        Bundle bundle = new Bundle();
        String string2 = "r";
        bundle.putByteArray(string2, byArray);
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzx.zzat().zze().zzb("Error returning byte array to wrapper", (Object)remoteException);
            return;
        }
    }

    public final void zzah(zzs zzs2, boolean bl2) {
        Bundle bundle = new Bundle();
        String string2 = "r";
        bundle.putBoolean(string2, bl2);
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzx.zzat().zze().zzb("Error returning boolean value to wrapper", (Object)remoteException);
            return;
        }
    }

    public final void zzai(zzs zzs2, Bundle bundle) {
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzx.zzat().zze().zzb("Error returning bundle value to wrapper", (Object)remoteException);
            return;
        }
    }

    public final void zzaj(zzs zzs2, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        String string2 = "r";
        bundle.putParcelableArrayList(string2, arrayList);
        try {
            zzs2.zzb(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzx.zzat().zze().zzb("Error returning bundle list to wrapper", (Object)remoteException);
            return;
        }
    }

    public final URL zzal(long l10, String string2, String object, long l11) {
        String string3;
        Object object2;
        Object object3;
        block23: {
            Preconditions.checkNotEmpty((String)object);
            Preconditions.checkNotEmpty(string2);
            int n10 = 4;
            object3 = new Object[n10];
            int n11 = 2;
            Object object4 = new Object[n11];
            long l12 = 39000L;
            Object object5 = l12;
            object4[0] = object5;
            int n12 = this.zzZ();
            object5 = n12;
            int n13 = 1;
            object4[n13] = object5;
            object5 = "v%s.%s";
            object4 = String.format((String)object5, object4);
            object3[0] = object4;
            object3[n13] = object;
            object3[n11] = string2;
            n11 = 3;
            object = l11;
            object3[n11] = object;
            object2 = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s";
            object3 = String.format((String)object2, (Object[])object3);
            object2 = this.zzx;
            object2 = ((zzfl)object2).zzc();
            object2 = ((zzae)object2).zzv();
            n11 = (int)(string2.equals(object2) ? 1 : 0);
            if (n11 == 0) break block23;
            object2 = "&ddl_test=1";
            object3 = ((String)object3).concat((String)object2);
        }
        try {
            object2 = new URL((String)object3);
            return object2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (MalformedURLException malformedURLException) {
            // empty catch block
        }
        object2 = this.zzx.zzat().zzb();
        string3 = ((Throwable)((Object)string3)).getMessage();
        ((zzeg)object2).zzb("Failed to create BOW URL for Deferred Deep Link. exception", string3);
        return null;
    }

    public final void zzay() {
        long l10;
        long l11;
        this.zzg();
        Object object = new SecureRandom();
        long l12 = ((Random)object).nextLong();
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 == false && (l11 = (l10 = (l12 = ((Random)object).nextLong()) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            object = this.zzx.zzat().zze();
            String string2 = "Utils falling back to Random for random id";
            ((zzeg)object).zza(string2);
        }
        this.zze.set(l12);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long zzd() {
        long l10;
        AtomicLong atomicLong = this.zze;
        long l11 = atomicLong.get();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            atomicLong = this.zze;
            synchronized (atomicLong) {
                int n10;
                l10 = System.nanoTime();
                Object object2 = this.zzx;
                object2 = ((zzfl)object2).zzax();
                long l13 = object2.currentTimeMillis();
                Random random = new Random(l10 ^= l13);
                long l14 = random.nextLong();
                this.zzf = n10 = this.zzf + 1;
                long l15 = n10;
                return l14 += l15;
            }
        }
        atomicLong = this.zze;
        synchronized (atomicLong) {
            AtomicLong atomicLong2 = this.zze;
            l10 = -1;
            long l16 = 1L;
            atomicLong2.compareAndSet(l10, l16);
            atomicLong2 = this.zze;
            return atomicLong2.getAndIncrement();
        }
    }

    public final SecureRandom zzf() {
        this.zzg();
        SecureRandom secureRandom = this.zzd;
        if (secureRandom == null) {
            this.zzd = secureRandom = new SecureRandom();
        }
        return this.zzd;
    }

    public final Bundle zzi(Uri object) {
        Bundle bundle = null;
        if (object != null) {
            boolean bl2;
            boolean bl3;
            String string2;
            String string3;
            String string4;
            Object object2;
            String string5;
            boolean bl4;
            block18: {
                block17: {
                    bl4 = object.isHierarchical();
                    string5 = "gclid";
                    if (!bl4) break block17;
                    object2 = "utm_campaign";
                    object2 = object.getQueryParameter((String)object2);
                    string4 = "utm_source";
                    string4 = object.getQueryParameter(string4);
                    string3 = "utm_medium";
                    string3 = object.getQueryParameter(string3);
                    try {
                        string2 = object.getQueryParameter(string5);
                        break block18;
                    }
                    catch (UnsupportedOperationException unsupportedOperationException) {
                        object2 = this.zzx.zzat().zze();
                        string5 = "Install referrer url isn't a hierarchical URI";
                        ((zzeg)object2).zzb(string5, unsupportedOperationException);
                    }
                }
                bl4 = false;
                object2 = null;
                bl3 = false;
                string4 = null;
                string3 = null;
                string2 = null;
            }
            boolean bl5 = TextUtils.isEmpty((CharSequence)object2);
            if (bl5 && (bl5 = TextUtils.isEmpty((CharSequence)string4)) && (bl5 = TextUtils.isEmpty((CharSequence)string3)) && (bl5 = TextUtils.isEmpty((CharSequence)string2))) {
                return null;
            }
            bundle = new Bundle();
            bl5 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl5) {
                String string6 = "campaign";
                bundle.putString(string6, (String)object2);
            }
            if (!(bl4 = TextUtils.isEmpty((CharSequence)string4))) {
                object2 = "source";
                bundle.putString((String)object2, string4);
            }
            if (!(bl4 = TextUtils.isEmpty((CharSequence)string3))) {
                object2 = "medium";
                bundle.putString((String)object2, string3);
            }
            if (!(bl4 = TextUtils.isEmpty((CharSequence)string2))) {
                bundle.putString(string5, string2);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)(object2 = object.getQueryParameter("utm_term"))))) {
                string5 = "term";
                bundle.putString(string5, (String)object2);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)(object2 = object.getQueryParameter("utm_content"))))) {
                string5 = "content";
                bundle.putString(string5, (String)object2);
            }
            if (!(bl3 = TextUtils.isEmpty((CharSequence)(string5 = object.getQueryParameter((String)(object2 = "aclid")))))) {
                bundle.putString((String)object2, string5);
            }
            if (!(bl3 = TextUtils.isEmpty((CharSequence)(string5 = object.getQueryParameter((String)(object2 = "cp1")))))) {
                bundle.putString((String)object2, string5);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)(object = object.getQueryParameter((String)(object2 = "anid")))))) {
                bundle.putString((String)object2, (String)object);
            }
            return bundle;
        }
        return null;
    }

    public final boolean zzj(String string2, String string3) {
        int n10;
        if (string3 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", string2);
            return false;
        }
        int n11 = string3.length();
        if (n11 == 0) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be empty. Type", string2);
            return false;
        }
        n11 = string3.codePointAt(0);
        int n12 = Character.isLetter(n11);
        if (n12 == 0) {
            this.zzx.zzat().zzd().zzc("Name must start with a letter. Type, name", string2, string3);
            return false;
        }
        n12 = string3.length();
        for (n11 = Character.charCount(n11); n11 < n12; n11 += n10) {
            int n13;
            n10 = string3.codePointAt(n11);
            if (n10 != (n13 = 95) && (n13 = (int)(Character.isLetterOrDigit(n10) ? 1 : 0)) == 0) {
                this.zzx.zzat().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", string2, string3);
                return false;
            }
            n10 = Character.charCount(n10);
        }
        return true;
    }

    public final boolean zzk(String string2, String string3) {
        int n10;
        if (string3 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", string2);
            return false;
        }
        int n11 = string3.length();
        if (n11 == 0) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be empty. Type", string2);
            return false;
        }
        n11 = string3.codePointAt(0);
        int n12 = Character.isLetter(n11);
        int n13 = 95;
        if (n12 == 0) {
            if (n11 == n13) {
                n11 = n13;
            } else {
                this.zzx.zzat().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", string2, string3);
                return false;
            }
        }
        n12 = string3.length();
        for (n11 = Character.charCount(n11); n11 < n12; n11 += n10) {
            boolean bl2;
            n10 = string3.codePointAt(n11);
            if (n10 != n13 && !(bl2 = Character.isLetterOrDigit(n10))) {
                this.zzx.zzat().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", string2, string3);
                return false;
            }
            n10 = Character.charCount(n10);
        }
        return true;
    }

    public final boolean zzl(String string2, String[] stringArray, String[] stringArray2, String string3) {
        boolean bl2;
        int n10;
        if (string3 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", string2);
            return false;
        }
        Preconditions.checkNotNull(string3);
        String[] stringArray3 = zzb;
        for (int i10 = 0; i10 < (n10 = 3); ++i10) {
            String string4 = stringArray3[i10];
            n10 = (int)(string3.startsWith(string4) ? 1 : 0);
            if (n10 == 0) continue;
            this.zzx.zzat().zzd().zzc("Name starts with reserved prefix. Type, name", string2, string3);
            return false;
        }
        if (stringArray != null && (bl2 = zzkk.zzar(string3, stringArray)) && (stringArray2 == null || !(bl2 = zzkk.zzar(string3, stringArray2)))) {
            this.zzx.zzat().zzd().zzc("Name is reserved. Type, name", string2, string3);
            return false;
        }
        return true;
    }

    public final boolean zzm(String string2, int n10, String string3) {
        if (string3 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", string2);
            return false;
        }
        int n11 = string3.length();
        if ((n11 = string3.codePointCount(0, n11)) > n10) {
            zzeg zzeg2 = this.zzx.zzat().zzd();
            Integer n12 = n10;
            zzeg2.zzd("Name is too long. Type, maximum supported length, name", string2, n12, string3);
            return false;
        }
        return true;
    }

    public final int zzn(String string2) {
        String string3 = "event";
        int n10 = this.zzk(string3, string2);
        int n11 = 2;
        if (n10 == 0) {
            return n11;
        }
        Object object = zzgi.zza;
        String[] stringArray = zzgi.zzb;
        n10 = this.zzl(string3, (String[])object, stringArray, string2);
        if (n10 == 0) {
            return 13;
        }
        object = this.zzx;
        ((zzfl)object).zzc();
        n10 = 40;
        boolean bl2 = this.zzm(string3, n10, string2);
        if (!bl2) {
            return n11;
        }
        return 0;
    }

    public final int zzo(String string2) {
        String string3 = "user property";
        int n10 = this.zzk(string3, string2);
        int n11 = 6;
        if (n10 == 0) {
            return n11;
        }
        Object object = zzgk.zza;
        n10 = this.zzl(string3, (String[])object, null, string2);
        if (n10 == 0) {
            return 15;
        }
        object = this.zzx;
        ((zzfl)object).zzc();
        n10 = 24;
        boolean bl2 = this.zzm(string3, n10, string2);
        if (!bl2) {
            return n11;
        }
        return 0;
    }

    public final int zzq(String string2) {
        String string3 = "event param";
        int n10 = this.zzj(string3, string2);
        int n11 = 3;
        if (n10 == 0) {
            return n11;
        }
        zzfl zzfl2 = null;
        n10 = this.zzl(string3, null, null, string2);
        if (n10 == 0) {
            return 14;
        }
        zzfl2 = this.zzx;
        zzfl2.zzc();
        n10 = 40;
        boolean bl2 = this.zzm(string3, n10, string2);
        if (!bl2) {
            return n11;
        }
        return 0;
    }

    public final int zzr(String string2) {
        String string3 = "event param";
        int n10 = this.zzk(string3, string2);
        int n11 = 3;
        if (n10 == 0) {
            return n11;
        }
        zzfl zzfl2 = null;
        n10 = this.zzl(string3, null, null, string2);
        if (n10 == 0) {
            return 14;
        }
        zzfl2 = this.zzx;
        zzfl2.zzc();
        n10 = 40;
        boolean bl2 = this.zzm(string3, n10, string2);
        if (!bl2) {
            return n11;
        }
        return 0;
    }

    public final boolean zzs(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Parcelable[];
        return bl3 || (bl3 = object instanceof ArrayList) || (bl2 = object instanceof Bundle);
        {
        }
    }

    public final boolean zzt(String string2, String string3, int n10, Object object) {
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        int n11 = object instanceof Long;
        if (n11 == 0 && (n11 = object instanceof Float) == 0 && (n11 = object instanceof Integer) == 0 && (n11 = object instanceof Byte) == 0 && (n11 = object instanceof Short) == 0 && (n11 = object instanceof Boolean) == 0 && (n11 = object instanceof Double) == 0) {
            n11 = object instanceof String;
            if (n11 == 0 && (n11 = object instanceof Character) == 0 && (n11 = object instanceof CharSequence) == 0) {
                return false;
            }
            object = String.valueOf(object);
            n11 = ((String)object).length();
            if ((n11 = ((String)object).codePointCount(0, n11)) > n10) {
                zzeg zzeg2 = this.zzx.zzat().zzh();
                object = ((String)object).length();
                zzeg2.zzd("Value is too long; discarded. Value kind, name, value length", string2, string3, object);
                return false;
            }
        }
        return bl2;
    }

    public final void zzz(String string2, String string3, String string4, Bundle bundle, List list, boolean bl2) {
        int n10;
        zzkk zzkk2 = this;
        String string5 = string3;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        this.zzx.zzc();
        Object object = bundle.keySet();
        Object object2 = new TreeSet(object);
        Iterator iterator2 = object2.iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object3;
            Object object4;
            Object object5;
            Object object6;
            String string6;
            int n12;
            Object object7 = object2 = iterator2.next();
            object7 = (String)object2;
            if (list2 != null && (n10 = list2.contains(object7)) != 0) {
                n12 = 0;
                string6 = null;
            } else {
                if (bl2) {
                    n10 = zzkk2.zzq((String)object7);
                } else {
                    n10 = 0;
                    object2 = null;
                }
                if (n10 == 0) {
                    n10 = zzkk2.zzr((String)object7);
                }
                n12 = n10;
            }
            if (n12 != 0) {
                n10 = 3;
                if (n12 == n10) {
                    object6 = object7;
                } else {
                    n10 = 0;
                    object2 = null;
                    object6 = null;
                }
                object2 = this;
                object = bundle;
                object5 = object7;
                object4 = object7;
                this.zzI(bundle, n12, (String)object7, (String)object7, object6);
                bundle2.remove((String)object7);
                continue;
            }
            object2 = bundle2.get((String)object7);
            n10 = (int)(zzkk2.zzs(object2) ? 1 : 0);
            if (n10 != 0) {
                object2 = zzkk2.zzx.zzat().zzh();
                object = "Nested Bundle parameters are not allowed; discarded. event name, param name, child param name";
                ((zzeg)object2).zzd((String)object, string5, string4, object7);
                n12 = n10 = 22;
                object3 = object7;
            } else {
                object4 = bundle2.get((String)object7);
                object2 = this;
                object = string2;
                string6 = string3;
                object5 = object7;
                object6 = bundle;
                object3 = object7;
                object7 = null;
                n12 = n10 = this.zzD(string2, string3, (String)object5, object4, bundle, list, bl2, false);
            }
            if (n12 != 0 && (n10 = (int)(((String)(object2 = "_ev")).equals(object3) ? 1 : 0)) == 0) {
                object6 = bundle2.get((String)object3);
                object2 = this;
                object = bundle;
                object5 = object3;
                object4 = object3;
                this.zzI(bundle, n12, (String)object3, (String)object3, object6);
                bundle2.remove((String)object3);
                continue;
            }
            n10 = (int)(zzkk.zzh((String)object3) ? 1 : 0);
            if (n10 == 0 || (n10 = (int)(zzkk.zzar((String)object3, (String[])(object2 = zzgj.zzd)) ? 1 : 0)) != 0 || ++n11 <= 0) continue;
            object2 = zzkk2.zzx.zzat().zzd();
            object = zzkk2.zzx.zzm().zzc(string5);
            string6 = zzkk2.zzx.zzm().zzf(bundle2);
            object5 = "Item cannot contain custom parameters";
            ((zzeg)object2).zzc((String)object5, object, string6);
            n10 = 23;
            zzkk.zzam(bundle2, n10);
            bundle2.remove((String)object3);
        }
    }
}

