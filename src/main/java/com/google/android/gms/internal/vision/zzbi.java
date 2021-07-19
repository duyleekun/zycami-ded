/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.vision.zzaq;
import com.google.android.gms.internal.vision.zzau;
import com.google.android.gms.internal.vision.zzav;
import com.google.android.gms.internal.vision.zzbd;
import com.google.android.gms.internal.vision.zzbe;
import com.google.android.gms.internal.vision.zzbg;
import com.google.android.gms.internal.vision.zzbh;
import com.google.android.gms.internal.vision.zzbj;
import com.google.android.gms.internal.vision.zzbk;
import com.google.android.gms.internal.vision.zzbl;
import com.google.android.gms.internal.vision.zzbm;
import com.google.android.gms.internal.vision.zzbn;
import com.google.android.gms.internal.vision.zzbo;
import com.google.android.gms.internal.vision.zzbp;
import com.google.android.gms.internal.vision.zzbq;
import com.google.android.gms.internal.vision.zzbr;
import com.google.android.gms.internal.vision.zzbs;
import com.google.android.gms.internal.vision.zzbv;
import com.google.android.gms.internal.vision.zzcy;
import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzdf;
import com.google.android.gms.internal.vision.zzdi;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class zzbi {
    private static final Object zzge;
    private static volatile zzbr zzgf;
    private static volatile boolean zzgg = false;
    private static final AtomicReference zzgh;
    private static zzbs zzgi;
    private static final AtomicInteger zzgl;
    private final String name;
    private final zzbo zzgj;
    private final Object zzgk;
    private volatile int zzgm;
    private volatile Object zzgn;
    private final boolean zzgo;

    static {
        Object object;
        zzge = object = new Object();
        object = new AtomicReference();
        zzgh = object;
        zzbv zzbv2 = zzbk.zzgq;
        zzgi = object = new zzbs(zzbv2);
        zzgl = object = new AtomicInteger();
    }

    private zzbi(zzbo object, String string2, Object object2, boolean bl2) {
        Uri uri;
        int n10;
        this.zzgm = n10 = -1;
        String string3 = ((zzbo)object).zzgt;
        if (string3 == null && (uri = ((zzbo)object).zzgu) == null) {
            object = new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
            throw object;
        }
        if (string3 != null && (string3 = ((zzbo)object).zzgu) != null) {
            object = new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
            throw object;
        }
        this.zzgj = object;
        this.name = string2;
        this.zzgk = object2;
        this.zzgo = bl2;
    }

    public /* synthetic */ zzbi(zzbo zzbo2, String string2, Object object, boolean bl2, zzbn zzbn2) {
        this(zzbo2, string2, object, bl2);
    }

    private static zzbi zza(zzbo zzbo2, String string2, Object object, zzbp zzbp2, boolean bl2) {
        zzbm zzbm2 = new zzbm(zzbo2, string2, object, true, zzbp2);
        return zzbm2;
    }

    /*
     * WARNING - void declaration
     */
    private final Object zza(zzbr object) {
        Object object2;
        Object object3 = this.zzgj;
        boolean n10 = ((zzbo)object3).zzgz;
        int n11 = 0;
        Object object4 = null;
        int n12 = 1;
        if (!n10) {
            void var3_7;
            boolean bl2;
            object3 = zzbd.zze(((zzbr)object).zzaa());
            object2 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype";
            if ((object3 = (String)((zzbd)object3).zzb((String)object2)) != null && (bl2 = ((Matcher)(object3 = ((Pattern)(object2 = zzaq.zzfb)).matcher((CharSequence)object3))).matches())) {
                int n13 = n12;
            } else {
                boolean bl3 = false;
                object3 = null;
            }
            if (var3_7 != false) {
                n11 = n12;
            }
        }
        boolean bl4 = false;
        object3 = null;
        if (n11 == 0) {
            object4 = this.zzgj.zzgu;
            if (object4 != null) {
                object4 = ((zzbr)object).zzaa();
                n11 = zzbg.zza((Context)object4, (Uri)(object2 = this.zzgj.zzgu));
                if (n11 != 0) {
                    object4 = this.zzgj;
                    n11 = ((zzbo)object4).zzha;
                    if (n11 != 0) {
                        object4 = ((zzbr)object).zzaa().getContentResolver();
                        object2 = this.zzgj.zzgu.getLastPathSegment();
                        object = ((zzbr)object).zzaa().getPackageName();
                        String string2 = String.valueOf(object2);
                        int n14 = string2.length() + n12;
                        n12 = String.valueOf(object).length();
                        StringBuilder stringBuilder = new StringBuilder(n14 += n12);
                        stringBuilder.append((String)object2);
                        object2 = "#";
                        stringBuilder.append((String)object2);
                        stringBuilder.append((String)object);
                        object = zzbj.getContentProviderUri(stringBuilder.toString());
                        object = zzau.zza((ContentResolver)object4, (Uri)object);
                    } else {
                        object = ((zzbr)object).zzaa().getContentResolver();
                        object4 = this.zzgj.zzgu;
                        object = zzau.zza((ContentResolver)object, (Uri)object4);
                    }
                } else {
                    boolean bl5 = false;
                    object = null;
                }
            } else {
                object = ((zzbr)object).zzaa();
                object4 = this.zzgj.zzgt;
                object = zzbq.zzb((Context)object, (String)object4);
            }
            if (object != null && (object = object.zzb((String)(object4 = this.zzag()))) != null) {
                return this.zza(object);
            }
        } else {
            object4 = "PhenotypeFlag";
            boolean bl6 = Log.isLoggable((String)object4, (int)3);
            if (bl6) {
                object = "Bypass reading Phenotype values for flag: ";
                String string3 = String.valueOf(this.zzag());
                int n15 = string3.length();
                if (n15 != 0) {
                    object = ((String)object).concat(string3);
                } else {
                    string3 = new String((String)object);
                    object = string3;
                }
                Log.d((String)object4, (String)object);
            }
        }
        return null;
    }

    public static void zzaf() {
        zzgl.incrementAndGet();
    }

    public static final /* synthetic */ boolean zzah() {
        return true;
    }

    public static /* synthetic */ zzbi zzb(zzbo zzbo2, String string2, Object object, zzbp zzbp2, boolean bl2) {
        return zzbi.zza(zzbo2, string2, object, zzbp2, true);
    }

    private final Object zzb(zzbr object) {
        Context context;
        boolean bl2;
        Object object2 = this.zzgj;
        boolean bl3 = ((zzbo)object2).zzgx;
        if (!bl3 && ((object2 = ((zzbo)object2).zzhb) == null || (bl2 = ((Boolean)(object2 = (Boolean)object2.apply(context = ((zzbr)object).zzaa()))).booleanValue()))) {
            object = zzbd.zze(((zzbr)object).zzaa());
            object2 = this.zzgj;
            bl3 = ((zzbo)object2).zzgx;
            if (bl3) {
                bl2 = false;
                object2 = null;
            } else {
                object2 = ((zzbo)object2).zzgv;
                object2 = this.zze((String)object2);
            }
            object = object.zzb((String)object2);
            if (object != null) {
                return this.zza(object);
            }
        }
        return null;
    }

    private final String zze(String string2) {
        boolean bl2;
        if (string2 != null && (bl2 = string2.isEmpty())) {
            return this.name;
        }
        string2 = String.valueOf(string2);
        String string3 = String.valueOf(this.name);
        int n10 = string3.length();
        if (n10 != 0) {
            return string2.concat(string3);
        }
        string3 = new String(string2);
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zzi(Context object) {
        Object object2 = zzge;
        synchronized (object2) {
            Object object3 = zzgf;
            Object object4 = object.getApplicationContext();
            if (object4 != null) {
                object = object4;
            }
            if (object3 == null || (object3 = ((zzbr)object3).zzaa()) != object) {
                zzau.zzy();
                zzbq.zzy();
                zzbd.zzae();
                object3 = new zzbl((Context)object);
                object3 = zzdi.zza((zzdf)object3);
                object4 = new zzav((Context)object, (zzdf)object3);
                zzgf = object4;
                object = zzgl;
                ((AtomicInteger)object).incrementAndGet();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zzj(Context context) {
        Object object = zzgf;
        if (object != null) {
            return;
        }
        object = zzge;
        synchronized (object) {
            zzbr zzbr2 = zzgf;
            if (zzbr2 == null) {
                zzbi.zzi(context);
            }
            return;
        }
    }

    public static final /* synthetic */ zzcy zzk(Context context) {
        new zzbh();
        return zzbh.zzg(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object get() {
        int n10;
        Object object;
        Object object2;
        int n11 = this.zzgo;
        if (n11 == 0) {
            object2 = zzgi;
            object = this.name;
            n11 = (int)(((zzbs)object2).zzg((String)object) ? 1 : 0);
            object = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.";
            zzde.checkState(n11 != 0, object);
        }
        if ((n10 = this.zzgm) >= (n11 = ((AtomicInteger)(object2 = zzgl)).get())) return this.zzgn;
        synchronized (this) {
            Object object3;
            boolean bl2;
            n10 = this.zzgm;
            if (n10 >= n11) return this.zzgn;
            object = zzgf;
            if (object != null) {
                bl2 = true;
            } else {
                bl2 = false;
                object3 = null;
            }
            String string2 = "Must call PhenotypeFlag.init() first";
            zzde.checkState(bl2, string2);
            object3 = this.zzgj;
            bl2 = ((zzbo)object3).zzgy;
            if (!(bl2 ? (object3 = this.zzb((zzbr)object)) != null || (object3 = this.zza((zzbr)object)) != null : (object3 = this.zza((zzbr)object)) != null || (object3 = this.zzb((zzbr)object)) != null)) {
                object3 = this.zzgk;
            }
            object = ((zzbr)object).zzab();
            object = object.get();
            boolean bl3 = ((zzcy)(object = (zzcy)object)).isPresent();
            if (bl3) {
                object = ((zzcy)object).get();
                object = (zzbe)object;
                object3 = this.zzgj;
                string2 = ((zzbo)object3).zzgu;
                String string3 = ((zzbo)object3).zzgt;
                object3 = ((zzbo)object3).zzgw;
                String string4 = this.name;
                object3 = (object = ((zzbe)object).zza((Uri)string2, string3, (String)object3, string4)) == null ? this.zzgk : this.zza(object);
            }
            this.zzgn = object3;
            this.zzgm = n11;
            return this.zzgn;
        }
    }

    public abstract Object zza(Object var1);

    public final String zzag() {
        String string2 = this.zzgj.zzgw;
        return this.zze(string2);
    }
}

