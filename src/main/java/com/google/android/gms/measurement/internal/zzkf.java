/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzan;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzed;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public final class zzkf
extends zzjv {
    public zzkf(zzkd zzkd2) {
        super(zzkd2);
    }

    public static final Object zzA(zzdb bundleArray, String arrayList) {
        if ((bundleArray = zzkf.zzz((zzdb)bundleArray, (String)((Object)arrayList))) != null) {
            int n10 = bundleArray.zzc();
            if (n10 != 0) {
                return bundleArray.zzd();
            }
            n10 = bundleArray.zze();
            if (n10 != 0) {
                return bundleArray.zzf();
            }
            n10 = bundleArray.zzi();
            if (n10 != 0) {
                return bundleArray.zzj();
            }
            n10 = bundleArray.zzm();
            if (n10 > 0) {
                boolean bl2;
                bundleArray = bundleArray.zzk();
                arrayList = new ArrayList<Bundle>();
                bundleArray = bundleArray.iterator();
                while (bl2 = bundleArray.hasNext()) {
                    boolean bl3;
                    Object object = (zzdf)bundleArray.next();
                    if (object == null) continue;
                    Bundle bundle = new Bundle();
                    object = ((zzdf)object).zzk().iterator();
                    while (bl3 = object.hasNext()) {
                        String string2;
                        Object object2 = (zzdf)object.next();
                        boolean bl4 = ((zzdf)object2).zzc();
                        if (bl4) {
                            string2 = ((zzdf)object2).zzb();
                            object2 = ((zzdf)object2).zzd();
                            bundle.putString(string2, (String)object2);
                            continue;
                        }
                        bl4 = ((zzdf)object2).zze();
                        if (bl4) {
                            string2 = ((zzdf)object2).zzb();
                            long l10 = ((zzdf)object2).zzf();
                            bundle.putLong(string2, l10);
                            continue;
                        }
                        bl4 = ((zzdf)object2).zzi();
                        if (!bl4) continue;
                        string2 = ((zzdf)object2).zzb();
                        double d10 = ((zzdf)object2).zzj();
                        bundle.putDouble(string2, d10);
                    }
                    bl2 = bundle.isEmpty();
                    if (bl2) continue;
                    arrayList.add(bundle);
                }
                bundleArray = new Bundle[arrayList.size()];
                return arrayList.toArray(bundleArray);
            }
        }
        return null;
    }

    private final void zzB(StringBuilder stringBuilder, int n10, List object) {
        boolean bl2;
        if (object == null) {
            return;
        }
        ++n10;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            Object object2 = (zzdf)object.next();
            if (object2 == null) continue;
            zzkf.zzD(stringBuilder, n10);
            Object object3 = "param {\n";
            stringBuilder.append((String)object3);
            int n11 = ((zzdf)object2).zza();
            Double d10 = null;
            if (n11 != 0) {
                object3 = this.zzx.zzm();
                string2 = ((zzdf)object2).zzb();
                object3 = ((zzed)object3).zzd(string2);
            } else {
                n11 = 0;
                object3 = null;
            }
            string2 = "name";
            zzkf.zzG(stringBuilder, n10, string2, object3);
            n11 = ((zzdf)object2).zzc();
            if (n11 != 0) {
                object3 = ((zzdf)object2).zzd();
            } else {
                n11 = 0;
                object3 = null;
            }
            string2 = "string_value";
            zzkf.zzG(stringBuilder, n10, string2, object3);
            n11 = ((zzdf)object2).zze();
            if (n11 != 0) {
                long l10 = ((zzdf)object2).zzf();
                object3 = l10;
            } else {
                n11 = 0;
                object3 = null;
            }
            string2 = "int_value";
            zzkf.zzG(stringBuilder, n10, string2, object3);
            n11 = ((zzdf)object2).zzi();
            if (n11 != 0) {
                double d11 = ((zzdf)object2).zzj();
                d10 = d11;
            }
            object3 = "double_value";
            zzkf.zzG(stringBuilder, n10, (String)object3, d10);
            n11 = ((zzdf)object2).zzm();
            if (n11 > 0) {
                object2 = ((zzdf)object2).zzk();
                this.zzB(stringBuilder, n10, (List)object2);
            }
            zzkf.zzD(stringBuilder, n10);
            object2 = "}\n";
            stringBuilder.append((String)object2);
        }
    }

    private final void zzC(StringBuilder stringBuilder, int n10, zzby zzhs2) {
        Object object;
        String string2;
        if (zzhs2 == null) {
            return;
        }
        zzkf.zzD(stringBuilder, n10);
        Object object2 = "filter {\n";
        stringBuilder.append((String)object2);
        int n11 = ((zzby)zzhs2).zze();
        if (n11 != 0) {
            n11 = ((zzby)zzhs2).zzf();
            object2 = n11 != 0;
            string2 = "complement";
            zzkf.zzG(stringBuilder, n10, string2, object2);
        }
        if ((n11 = ((zzby)zzhs2).zzg()) != 0) {
            object2 = this.zzx.zzm();
            string2 = ((zzby)zzhs2).zzh();
            object2 = ((zzed)object2).zzd(string2);
            string2 = "param_name";
            zzkf.zzG(stringBuilder, n10, string2, object2);
        }
        n11 = ((zzby)zzhs2).zza();
        string2 = "}\n";
        if (n11 != 0) {
            n11 = n10 + 1;
            object = ((zzby)zzhs2).zzb();
            if (object != null) {
                int n12;
                boolean bl2;
                boolean bl3;
                String string3;
                zzkf.zzD(stringBuilder, n11);
                Object object3 = "string_filter {\n";
                stringBuilder.append((String)object3);
                boolean n122 = ((zzck)object).zza();
                if (n122) {
                    object3 = ((zzck)object).zzb().name();
                    string3 = "match_type";
                    zzkf.zzG(stringBuilder, n11, string3, object3);
                }
                if (bl3 = ((zzck)object).zzc()) {
                    object3 = ((zzck)object).zzd();
                    string3 = "expression";
                    zzkf.zzG(stringBuilder, n11, string3, object3);
                }
                if (bl2 = ((zzck)object).zze()) {
                    boolean bl4 = ((zzck)object).zzf();
                    object3 = bl4;
                    string3 = "case_sensitive";
                    zzkf.zzG(stringBuilder, n11, string3, object3);
                }
                if ((n12 = ((zzck)object).zzh()) > 0) {
                    boolean bl5;
                    int n13 = n11 + 1;
                    zzkf.zzD(stringBuilder, n13);
                    object3 = "expression_list {\n";
                    stringBuilder.append((String)object3);
                    object = ((zzck)object).zzg().iterator();
                    while (bl5 = object.hasNext()) {
                        object3 = (String)object.next();
                        int n14 = n11 + 2;
                        zzkf.zzD(stringBuilder, n14);
                        stringBuilder.append((String)object3);
                        object3 = "\n";
                        stringBuilder.append((String)object3);
                    }
                    stringBuilder.append(string2);
                }
                zzkf.zzD(stringBuilder, n11);
                stringBuilder.append(string2);
            }
        }
        if ((n11 = ((zzby)zzhs2).zzc()) != 0) {
            n11 = n10 + 1;
            zzhs2 = ((zzby)zzhs2).zzd();
            object = "number_filter";
            zzkf.zzH(stringBuilder, n11, (String)object, (zzcd)zzhs2);
        }
        zzkf.zzD(stringBuilder, n10);
        stringBuilder.append(string2);
    }

    private static final void zzD(StringBuilder stringBuilder, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = "  ";
            stringBuilder.append(string2);
        }
    }

    private static final String zzE(boolean bl2, boolean bl3, boolean bl4) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        if (bl2) {
            string2 = "Dynamic ";
            stringBuilder.append(string2);
        }
        if (bl3) {
            string2 = "Sequence ";
            stringBuilder.append(string2);
        }
        if (bl4) {
            string2 = "Session-Scoped ";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    private static final void zzF(StringBuilder stringBuilder, int n10, String iterator2, zzdq object, String string2) {
        Object object2;
        int n11;
        Object object3;
        int n12;
        String string3;
        int n13;
        if (object == null) {
            return;
        }
        n10 = 3;
        zzkf.zzD(stringBuilder, n10);
        stringBuilder.append((String)((Object)iterator2));
        iterator2 = " {\n";
        stringBuilder.append((String)((Object)iterator2));
        int n14 = ((zzdq)object).zzd();
        char c10 = '\n';
        int n15 = 4;
        String string4 = ", ";
        if (n14 != 0) {
            zzkf.zzD(stringBuilder, n15);
            stringBuilder.append("results: ");
            iterator2 = ((zzdq)object).zzc().iterator();
            n13 = 0;
            string3 = null;
            while ((n12 = iterator2.hasNext()) != 0) {
                object3 = (Long)iterator2.next();
                n11 = n13 + 1;
                if (n13 != 0) {
                    stringBuilder.append(string4);
                }
                stringBuilder.append(object3);
                n13 = n11;
            }
            stringBuilder.append(c10);
        }
        if ((n14 = ((zzdq)object).zzb()) != 0) {
            zzkf.zzD(stringBuilder, n15);
            stringBuilder.append("status: ");
            iterator2 = ((zzdq)object).zza().iterator();
            n13 = 0;
            string3 = null;
            while ((n12 = iterator2.hasNext()) != 0) {
                object3 = (Long)iterator2.next();
                n11 = n13 + 1;
                if (n13 != 0) {
                    stringBuilder.append(string4);
                }
                stringBuilder.append(object3);
                n13 = n11;
            }
            stringBuilder.append(c10);
        }
        n14 = ((zzdq)object).zzf();
        c10 = '\u0000';
        string3 = "}\n";
        if (n14 != 0) {
            zzkf.zzD(stringBuilder, n15);
            stringBuilder.append("dynamic_filter_timestamps: {");
            iterator2 = ((zzdq)object).zze().iterator();
            n12 = 0;
            object3 = null;
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object2 = (zzcz)iterator2.next();
                int n16 = n12 + 1;
                if (n12 != 0) {
                    stringBuilder.append(string4);
                }
                if ((n12 = (int)(((zzcz)object2).zza() ? 1 : 0)) != 0) {
                    n12 = ((zzcz)object2).zzb();
                    object3 = n12;
                } else {
                    n12 = 0;
                    object3 = null;
                }
                stringBuilder.append(object3);
                object3 = ":";
                stringBuilder.append((String)object3);
                n12 = (int)(((zzcz)object2).zzc() ? 1 : 0);
                if (n12 != 0) {
                    long l10 = ((zzcz)object2).zzd();
                    object3 = l10;
                } else {
                    n12 = 0;
                    object3 = null;
                }
                stringBuilder.append(object3);
                n12 = n16;
            }
            stringBuilder.append(string3);
        }
        if ((n14 = ((zzdq)object).zzi()) != 0) {
            zzkf.zzD(stringBuilder, n15);
            stringBuilder.append("sequence_filter_timestamps: {");
            iterator2 = ((zzdq)object).zzh().iterator();
            int n17 = 0;
            object = null;
            while ((n15 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                zzds zzds2 = (zzds)iterator2.next();
                n12 = n17 + 1;
                if (n17 != 0) {
                    stringBuilder.append(string4);
                }
                if ((n17 = (int)(zzds2.zza() ? 1 : 0)) != 0) {
                    n17 = zzds2.zzb();
                    object = n17;
                } else {
                    n17 = 0;
                    object = null;
                }
                stringBuilder.append(object);
                stringBuilder.append(": [");
                object = zzds2.zzc().iterator();
                n15 = 0;
                zzds2 = null;
                while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object2 = (Long)object.next();
                    long l11 = (Long)object2;
                    int n18 = n15 + 1;
                    if (n15 != 0) {
                        stringBuilder.append(string4);
                    }
                    stringBuilder.append(l11);
                    n15 = n18;
                }
                object = "]";
                stringBuilder.append((String)object);
                n17 = n12;
            }
            stringBuilder.append(string3);
        }
        zzkf.zzD(stringBuilder, n10);
        stringBuilder.append(string3);
    }

    private static final void zzG(StringBuilder stringBuilder, int n10, String string2, Object object) {
        if (object == null) {
            return;
        }
        zzkf.zzD(stringBuilder, ++n10);
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(object);
        stringBuilder.append('\n');
    }

    private static final void zzH(StringBuilder stringBuilder, int n10, String object, zzcd object2) {
        String string2;
        if (object2 == null) {
            return;
        }
        zzkf.zzD(stringBuilder, n10);
        stringBuilder.append((String)object);
        object = " {\n";
        stringBuilder.append((String)object);
        boolean bl2 = ((zzcd)object2).zza();
        if (bl2) {
            object = ((zzcd)object2).zzb().name();
            string2 = "comparison_type";
            zzkf.zzG(stringBuilder, n10, string2, object);
        }
        if (bl2 = ((zzcd)object2).zzc()) {
            bl2 = ((zzcd)object2).zzd();
            object = bl2;
            string2 = "match_as_float";
            zzkf.zzG(stringBuilder, n10, string2, object);
        }
        if (bl2 = ((zzcd)object2).zze()) {
            object = ((zzcd)object2).zzf();
            string2 = "comparison_value";
            zzkf.zzG(stringBuilder, n10, string2, object);
        }
        if (bl2 = ((zzcd)object2).zzg()) {
            object = ((zzcd)object2).zzh();
            string2 = "min_comparison_value";
            zzkf.zzG(stringBuilder, n10, string2, object);
        }
        if (bl2 = ((zzcd)object2).zzi()) {
            object = ((zzcd)object2).zzj();
            object2 = "max_comparison_value";
            zzkf.zzG(stringBuilder, n10, (String)object2, object);
        }
        zzkf.zzD(stringBuilder, n10);
        stringBuilder.append("}\n");
    }

    public static boolean zzl(String string2) {
        int n10;
        String string3;
        int n11;
        return string2 != null && (n11 = string2.matches(string3 = "([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) != 0 && (n10 = string2.length()) <= (n11 = 310);
    }

    public static boolean zzm(List object, int n10) {
        int n11 = object.size() * 64;
        if (n10 < n11) {
            n11 = n10 / 64;
            object = (Long)object.get(n11);
            long l10 = (Long)object;
            long l11 = 1L;
            long l12 = l11 << (n10 %= 64) & l10;
            long l13 = l12 - (l10 = 0L);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != false) {
                return true;
            }
        }
        return false;
    }

    public static List zzn(BitSet bitSet) {
        int n10 = bitSet.length() + 63;
        int n11 = 64;
        ArrayList<Long> arrayList = new ArrayList<Long>(n10 /= n11);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12;
            int n13;
            long l10 = 0L;
            for (int i11 = 0; i11 < n11 && (n13 = i10 * 64 + i11) < (n12 = bitSet.length()); ++i11) {
                if ((n13 = (int)(bitSet.get(n13) ? 1 : 0)) == 0) continue;
                long l11 = 1L << i11;
                l10 |= l11;
            }
            Long l12 = l10;
            arrayList.add(l12);
        }
        return arrayList;
    }

    public static zziw zzt(zziw zziw2, byte[] byArray) {
        zzhe zzhe2 = zzhe.zzb();
        if (zzhe2 != null) {
            return zziw2.zzav(byArray, zzhe2);
        }
        return zziw2.zzaw(byArray);
    }

    public static int zzu(zzdi zzdi2, String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = zzdi2.zzk()); ++i10) {
            String string3 = zzdi2.zzl(i10).zzc();
            n10 = (int)(string2.equals(string3) ? 1 : 0);
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }

    public static List zzv(Bundle[] bundleArray) {
        ArrayList<Bundle> arrayList = new ArrayList<Bundle>();
        for (Object object : bundleArray) {
            boolean bl2;
            if (object == null) continue;
            zzde zzde2 = zzdf.zzn();
            Iterator iterator2 = object.keySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object2 = (String)iterator2.next();
                zzde zzde3 = zzdf.zzn();
                zzde3.zza((String)object2);
                object2 = object.get((String)object2);
                boolean bl3 = object2 instanceof Long;
                if (bl3) {
                    object2 = (Long)object2;
                    long l10 = (Long)object2;
                    zzde3.zzd(l10);
                } else {
                    bl3 = object2 instanceof String;
                    if (bl3) {
                        object2 = (String)object2;
                        zzde3.zzb((String)object2);
                    } else {
                        bl3 = object2 instanceof Double;
                        if (!bl3) continue;
                        object2 = (Double)object2;
                        double d10 = (Double)object2;
                        zzde3.zzf(d10);
                    }
                }
                zzde2.zzi(zzde3);
            }
            int n10 = zzde2.zzh();
            if (n10 <= 0) continue;
            object = (zzdf)zzde2.zzaA();
            arrayList.add((Bundle)object);
        }
        return arrayList;
    }

    public static final void zzx(zzda zzda2, String object, Object bundleArray) {
        int n10;
        Object object2;
        block10: {
            int n11;
            object2 = zzda2.zza();
            for (n10 = 0; n10 < (n11 = object2.size()); ++n10) {
                String string2 = ((zzdf)object2.get(n10)).zzb();
                n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                if (n11 == 0) {
                    continue;
                }
                break block10;
            }
            n10 = -1;
        }
        object2 = zzdf.zzn();
        ((zzde)object2).zza((String)object);
        boolean bl2 = bundleArray instanceof Long;
        if (bl2) {
            bundleArray = (Long)bundleArray;
            long l10 = bundleArray.longValue();
            ((zzde)object2).zzd(l10);
        } else {
            bl2 = bundleArray instanceof String;
            if (bl2) {
                bundleArray = (String)bundleArray;
                ((zzde)object2).zzb((String)bundleArray);
            } else {
                bl2 = bundleArray instanceof Double;
                if (bl2) {
                    bundleArray = (Double)bundleArray;
                    double d10 = bundleArray.doubleValue();
                    ((zzde)object2).zzf(d10);
                } else {
                    bl2 = bundleArray instanceof Bundle[];
                    if (bl2) {
                        bundleArray = bundleArray;
                        object = zzkf.zzv(bundleArray);
                        ((zzde)object2).zzj((Iterable)object);
                    }
                }
            }
        }
        if (n10 >= 0) {
            zzda2.zze(n10, (zzde)object2);
            return;
        }
        zzda2.zzg((zzde)object2);
    }

    public static final boolean zzy(zzas object, zzp zzp2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(zzp2);
        object = zzp2.zzb;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        return !bl2 || !(bl2 = TextUtils.isEmpty((CharSequence)(object = zzp2.zzq)));
    }

    public static final zzdf zzz(zzdb object, String string2) {
        boolean bl2;
        object = ((zzdb)object).zza().iterator();
        while (bl2 = object.hasNext()) {
            zzdf zzdf2 = (zzdf)object.next();
            String string3 = zzdf2.zzb();
            boolean bl3 = string3.equals(string2);
            if (!bl3) continue;
            return zzdf2;
        }
        return null;
    }

    public final boolean zzaz() {
        return false;
    }

    public final void zzc(zzdt zzdt2, Object object) {
        Preconditions.checkNotNull(object);
        zzdt2.zzd();
        zzdt2.zzf();
        zzdt2.zzh();
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            zzdt2.zzc((String)object);
            return;
        }
        bl2 = object instanceof Long;
        if (bl2) {
            long l10 = (Long)object;
            zzdt2.zze(l10);
            return;
        }
        bl2 = object instanceof Double;
        if (bl2) {
            double d10 = (Double)object;
            zzdt2.zzg(d10);
            return;
        }
        this.zzx.zzat().zzb().zzb("Ignoring invalid (type) user attribute value", object);
    }

    public final void zzd(zzde zzde2, Object object) {
        Preconditions.checkNotNull(object);
        zzde2.zzc();
        zzde2.zze();
        zzde2.zzg();
        zzde2.zzk();
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            zzde2.zzb((String)object);
            return;
        }
        bl2 = object instanceof Long;
        if (bl2) {
            long l10 = (Long)object;
            zzde2.zzd(l10);
            return;
        }
        bl2 = object instanceof Double;
        if (bl2) {
            double d10 = (Double)object;
            zzde2.zzf(d10);
            return;
        }
        bl2 = object instanceof Bundle[];
        if (bl2) {
            object = zzkf.zzv((Bundle[])object);
            zzde2.zzj((Iterable)object);
            return;
        }
        this.zzx.zzat().zzb().zzb("Ignoring invalid (type) event param value", object);
    }

    public final zzdb zzf(zzan zzan2) {
        boolean bl2;
        zzda zzda2 = zzdb.zzk();
        long l10 = zzan2.zze;
        zzda2.zzq(l10);
        Object object = zzan2.zzf;
        zzap zzap2 = new zzap((zzaq)object);
        while (bl2 = zzap2.hasNext()) {
            object = zzap2.zza();
            zzde zzde2 = zzdf.zzn();
            zzde2.zza((String)object);
            zzaq zzaq2 = zzan2.zzf;
            object = zzaq2.zza((String)object);
            Preconditions.checkNotNull(object);
            this.zzd(zzde2, object);
            zzda2.zzg(zzde2);
        }
        return (zzdb)zzda2.zzaA();
    }

    public final String zzh(zzdh object) {
        String string2;
        if (object == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = "\nbatch {\n";
        stringBuilder.append((String)object2);
        object = ((zzdh)((Object)object)).zza().iterator();
        while (true) {
            String string3;
            boolean bl2;
            Object object3;
            Object object4;
            boolean bl3;
            long l10;
            long l11;
            long l12;
            Object object5;
            boolean bl4 = object.hasNext();
            string2 = "}\n";
            if (!bl4) break;
            object2 = (zzdj)object.next();
            if (object2 == null) continue;
            int n10 = 1;
            zzkf.zzD(stringBuilder, n10);
            Object object6 = "bundle {\n";
            stringBuilder.append((String)object6);
            int n11 = ((zzdj)object2).zza();
            if (n11 != 0) {
                n11 = ((zzdj)object2).zzb();
                object6 = n11;
                object5 = "protocol_version";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzt();
            object5 = "platform";
            zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            n11 = (int)(((zzdj)object2).zzC() ? 1 : 0);
            if (n11 != 0) {
                l12 = ((zzdj)object2).zzD();
                object6 = l12;
                object5 = "gmp_version";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzE() ? 1 : 0)) != 0) {
                l12 = ((zzdj)object2).zzF();
                object6 = l12;
                object5 = "uploading_gmp_version";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzae() ? 1 : 0)) != 0) {
                l12 = ((zzdj)object2).zzaf();
                object6 = l12;
                object5 = "dynamite_version";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzW() ? 1 : 0)) != 0) {
                l12 = ((zzdj)object2).zzX();
                object6 = l12;
                object5 = "config_version";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzP();
            zzkf.zzG(stringBuilder, n10, "gmp_app_id", object6);
            object6 = ((zzdj)object2).zzad();
            zzkf.zzG(stringBuilder, n10, "admob_app_id", object6);
            object6 = ((zzdj)object2).zzA();
            zzkf.zzG(stringBuilder, n10, "app_id", object6);
            object6 = ((zzdj)object2).zzB();
            object5 = "app_version";
            zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            n11 = (int)(((zzdj)object2).zzU() ? 1 : 0);
            if (n11 != 0) {
                n11 = ((zzdj)object2).zzV();
                object6 = n11;
                object5 = "app_version_major";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzT();
            object5 = "firebase_instance_id";
            zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            n11 = (int)(((zzdj)object2).zzK() ? 1 : 0);
            if (n11 != 0) {
                l12 = ((zzdj)object2).zzL();
                object6 = l12;
                object5 = "dev_cert_hash";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzz();
            object5 = "app_store";
            zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            n11 = (int)(((zzdj)object2).zzi() ? 1 : 0);
            if (n11 != 0) {
                l12 = ((zzdj)object2).zzj();
                object6 = l12;
                object5 = "upload_timestamp_millis";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzk() ? 1 : 0)) != 0) {
                l12 = ((zzdj)object2).zzm();
                object6 = l12;
                object5 = "start_timestamp_millis";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzn() ? 1 : 0)) != 0) {
                l12 = ((zzdj)object2).zzo();
                object6 = l12;
                object5 = "end_timestamp_millis";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzp() ? 1 : 0)) != 0) {
                l12 = ((zzdj)object2).zzq();
                object6 = l12;
                object5 = "previous_bundle_start_timestamp_millis";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzr() ? 1 : 0)) != 0) {
                l12 = ((zzdj)object2).zzs();
                object6 = l12;
                object5 = "previous_bundle_end_timestamp_millis";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzJ();
            zzkf.zzG(stringBuilder, n10, "app_instance_id", object6);
            object6 = ((zzdj)object2).zzG();
            zzkf.zzG(stringBuilder, n10, "resettable_device_id", object6);
            object6 = ((zzdj)object2).zzaa();
            object5 = "ds_id";
            zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            n11 = (int)(((zzdj)object2).zzH() ? 1 : 0);
            if (n11 != 0) {
                n11 = (int)(((zzdj)object2).zzI() ? 1 : 0);
                object6 = n11 != 0;
                object5 = "limited_ad_tracking";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzu();
            zzkf.zzG(stringBuilder, n10, "os_version", object6);
            object6 = ((zzdj)object2).zzv();
            zzkf.zzG(stringBuilder, n10, "device_model", object6);
            object6 = ((zzdj)object2).zzw();
            object5 = "user_default_language";
            zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            n11 = ((zzdj)object2).zzx();
            if (n11 != 0) {
                n11 = ((zzdj)object2).zzy();
                object6 = n11;
                object5 = "time_zone_offset_minutes";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzM() ? 1 : 0)) != 0) {
                n11 = ((zzdj)object2).zzN();
                object6 = n11;
                object5 = "bundle_sequential_index";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzQ() ? 1 : 0)) != 0) {
                n11 = (int)(((zzdj)object2).zzR() ? 1 : 0);
                object6 = n11 != 0;
                object5 = "service_upload";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzO();
            zzkf.zzG(stringBuilder, n10, "health_monitor", object6);
            object6 = this.zzx.zzc();
            object5 = zzdw.zzav;
            int n12 = 0;
            Object object7 = null;
            n11 = ((zzae)object6).zzn(null, (zzdv)object5);
            if (n11 == 0 && (n11 = ((zzdj)object2).zzY()) != 0 && (n11 = (int)((l11 = (l12 = ((zzdj)object2).zzZ()) - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
                l12 = ((zzdj)object2).zzZ();
                object6 = l12;
                object5 = "android_id";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = ((zzdj)object2).zzab()) != 0) {
                n11 = ((zzdj)object2).zzac();
                object6 = n11;
                object5 = "retry_counter";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            if ((n11 = (int)(((zzdj)object2).zzah() ? 1 : 0)) != 0) {
                object6 = ((zzdj)object2).zzai();
                object5 = "consent_signals";
                zzkf.zzG(stringBuilder, n10, (String)object5, object6);
            }
            object6 = ((zzdj)object2).zzf();
            object5 = "name";
            int n13 = 2;
            if (object6 != null) {
                object6 = object6.iterator();
                while (bl3 = object6.hasNext()) {
                    long l13;
                    object4 = (zzdu)object6.next();
                    if (object4 == null) continue;
                    zzkf.zzD(stringBuilder, n13);
                    object3 = "user_property {\n";
                    stringBuilder.append((String)object3);
                    bl2 = ((zzdu)object4).zza();
                    if (bl2) {
                        l13 = ((zzdu)object4).zzb();
                        object3 = l13;
                    } else {
                        bl2 = false;
                        object3 = null;
                    }
                    zzkf.zzG(stringBuilder, n13, "set_timestamp_millis", object3);
                    object3 = this.zzx.zzm();
                    string3 = ((zzdu)object4).zzc();
                    object3 = ((zzed)object3).zze(string3);
                    zzkf.zzG(stringBuilder, n13, (String)object5, object3);
                    object3 = ((zzdu)object4).zze();
                    string3 = "string_value";
                    zzkf.zzG(stringBuilder, n13, string3, object3);
                    bl2 = ((zzdu)object4).zzf();
                    if (bl2) {
                        l13 = ((zzdu)object4).zzg();
                        object3 = l13;
                    } else {
                        bl2 = false;
                        object3 = null;
                    }
                    string3 = "int_value";
                    zzkf.zzG(stringBuilder, n13, string3, object3);
                    bl2 = ((zzdu)object4).zzh();
                    if (bl2) {
                        double d10 = ((zzdu)object4).zzi();
                        object4 = d10;
                    } else {
                        bl3 = false;
                        object4 = null;
                    }
                    object3 = "double_value";
                    zzkf.zzG(stringBuilder, n13, (String)object3, object4);
                    zzkf.zzD(stringBuilder, n13);
                    stringBuilder.append(string2);
                }
            }
            object6 = ((zzdj)object2).zzS();
            object7 = ((zzdj)object2).zzA();
            if (object6 != null) {
                object6 = object6.iterator();
                while (bl3 = object6.hasNext()) {
                    object4 = (zzcx)object6.next();
                    if (object4 == null) continue;
                    zzkf.zzD(stringBuilder, n13);
                    object3 = "audience_membership {\n";
                    stringBuilder.append((String)object3);
                    bl2 = ((zzcx)object4).zza();
                    if (bl2) {
                        bl2 = ((zzcx)object4).zzb();
                        object3 = (int)(bl2 ? 1 : 0);
                        string3 = "audience_id";
                        zzkf.zzG(stringBuilder, n13, string3, object3);
                    }
                    if (bl2 = (boolean)((zzcx)object4).zzf()) {
                        bl2 = ((zzcx)object4).zzg();
                        object3 = bl2;
                        string3 = "new_audience";
                        zzkf.zzG(stringBuilder, n13, string3, object3);
                    }
                    object3 = ((zzcx)object4).zzc();
                    string3 = "current_data";
                    zzkf.zzF(stringBuilder, n13, string3, (zzdq)object3, (String)object7);
                    bl2 = ((zzcx)object4).zzd();
                    if (bl2) {
                        object4 = ((zzcx)object4).zze();
                        object3 = "previous_data";
                        zzkf.zzF(stringBuilder, n13, (String)object3, (zzdq)object4, (String)object7);
                    }
                    zzkf.zzD(stringBuilder, n13);
                    stringBuilder.append(string2);
                }
            }
            object2 = ((zzdj)object2).zzc();
            if (object2 != null) {
                object2 = object2.iterator();
                while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    long l14;
                    object6 = (zzdb)object2.next();
                    if (object6 == null) continue;
                    zzkf.zzD(stringBuilder, n13);
                    stringBuilder.append("event {\n");
                    object7 = this.zzx.zzm();
                    object4 = ((zzdb)object6).zzd();
                    object7 = ((zzed)object7).zzc((String)object4);
                    zzkf.zzG(stringBuilder, n13, (String)object5, object7);
                    n12 = ((zzdb)object6).zze();
                    if (n12 != 0) {
                        l14 = ((zzdb)object6).zzf();
                        object7 = l14;
                        object4 = "timestamp_millis";
                        zzkf.zzG(stringBuilder, n13, (String)object4, object7);
                    }
                    if ((n12 = ((zzdb)object6).zzg()) != 0) {
                        l14 = ((zzdb)object6).zzh();
                        object7 = l14;
                        object4 = "previous_timestamp_millis";
                        zzkf.zzG(stringBuilder, n13, (String)object4, object7);
                    }
                    if ((n12 = ((zzdb)object6).zzi()) != 0) {
                        n12 = ((zzdb)object6).zzj();
                        object7 = n12;
                        object4 = "count";
                        zzkf.zzG(stringBuilder, n13, (String)object4, object7);
                    }
                    if ((n12 = ((zzdb)object6).zzb()) != 0) {
                        object6 = ((zzdb)object6).zza();
                        this.zzB(stringBuilder, n13, (List)object6);
                    }
                    zzkf.zzD(stringBuilder, n13);
                    stringBuilder.append(string2);
                }
            }
            zzkf.zzD(stringBuilder, n10);
            stringBuilder.append(string2);
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final String zzi(zzbw object) {
        int n10;
        Object object2;
        if (object == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object object3 = "\nevent_filter {\n";
        stringBuilder.append((String)object3);
        boolean n102 = ((zzbw)((Object)object)).zza();
        int n11 = 0;
        if (n102) {
            int n12 = ((zzbw)((Object)object)).zzb();
            object3 = n12;
            object2 = "filter_id";
            zzkf.zzG(stringBuilder, 0, (String)object2, object3);
        }
        object3 = this.zzx.zzm();
        object2 = ((zzbw)((Object)object)).zzc();
        object3 = ((zzed)object3).zzc((String)object2);
        object2 = "event_name";
        zzkf.zzG(stringBuilder, 0, (String)object2, object3);
        boolean bl2 = ((zzbw)((Object)object)).zzi();
        boolean bl3 = ((zzbw)((Object)object)).zzj();
        boolean bl4 = ((zzbw)((Object)object)).zzm();
        object3 = zzkf.zzE(bl2, bl3, bl4);
        bl3 = ((String)object3).isEmpty();
        if (!bl3) {
            object2 = "filter_type";
            zzkf.zzG(stringBuilder, 0, (String)object2, object3);
        }
        boolean bl5 = ((zzbw)((Object)object)).zzg();
        n11 = 1;
        if (bl5) {
            object3 = ((zzbw)((Object)object)).zzh();
            object2 = "event_count_filter";
            zzkf.zzH(stringBuilder, n11, (String)object2, (zzcd)object3);
        }
        if ((n10 = ((zzbw)((Object)object)).zze()) > 0) {
            int n13;
            object3 = "  filters {\n";
            stringBuilder.append((String)object3);
            object = ((zzbw)((Object)object)).zzd().iterator();
            while ((n13 = object.hasNext()) != 0) {
                n13 = 2;
                object2 = (zzby)object.next();
                this.zzC(stringBuilder, n13, (zzby)object2);
            }
        }
        zzkf.zzD(stringBuilder, n11);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public final String zzj(zzcf zzhs2) {
        String string2;
        if (zzhs2 == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object object = "\nproperty_filter {\n";
        stringBuilder.append((String)object);
        boolean bl2 = ((zzcf)zzhs2).zza();
        if (bl2) {
            int n10 = ((zzcf)zzhs2).zzb();
            object = n10;
            string2 = "filter_id";
            zzkf.zzG(stringBuilder, 0, string2, object);
        }
        object = this.zzx.zzm();
        string2 = ((zzcf)zzhs2).zzc();
        object = ((zzed)object).zze(string2);
        string2 = "property_name";
        zzkf.zzG(stringBuilder, 0, string2, object);
        boolean bl3 = ((zzcf)zzhs2).zze();
        boolean bl4 = ((zzcf)zzhs2).zzf();
        boolean bl5 = ((zzcf)zzhs2).zzh();
        object = zzkf.zzE(bl3, bl4, bl5);
        bl4 = ((String)object).isEmpty();
        if (!bl4) {
            string2 = "filter_type";
            zzkf.zzG(stringBuilder, 0, string2, object);
        }
        zzhs2 = ((zzcf)zzhs2).zzd();
        this.zzC(stringBuilder, 1, (zzby)zzhs2);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Parcelable zzk(byte[] object, Parcelable.Creator object2) {
        Throwable throwable2222222;
        Parcel parcel;
        block5: {
            if (object == null) {
                return null;
            }
            parcel = Parcel.obtain();
            int n10 = ((byte[])object).length;
            parcel.unmarshall((byte[])object, 0, n10);
            parcel.setDataPosition(0);
            object = object2.createFromParcel(parcel);
            object = (Parcelable)object;
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (SafeParcelReader$ParseException safeParcelReader$ParseException) {}
                {
                    object = this.zzx;
                    object = ((zzfl)object).zzat();
                    object = ((zzei)object).zzb();
                    object2 = "Failed to load parcelable from buffer";
                    ((zzeg)object).zza((String)object2);
                }
                parcel.recycle();
                return null;
            }
            parcel.recycle();
            return object;
        }
        parcel.recycle();
        throw throwable2222222;
    }

    public final List zzo(List object, List object2) {
        Object object3;
        int n10;
        int n11;
        ArrayList<Object> arrayList = new ArrayList<Object>((Collection<Object>)object);
        object = object2.iterator();
        while ((n11 = object.hasNext()) != 0) {
            int n12;
            Object object4;
            object2 = (Integer)object.next();
            n10 = (Integer)object2;
            if (n10 < 0) {
                object3 = this.zzx.zzat().zze();
                object4 = "Ignoring negative bit index to be cleared";
                ((zzeg)object3).zzb((String)object4, object2);
                continue;
            }
            n10 = (Integer)object2 / 64;
            if (n10 >= (n12 = arrayList.size())) {
                object3 = this.zzx.zzat().zze();
                n12 = arrayList.size();
                object4 = n12;
                String string2 = "Ignoring bit index greater than bitSet size";
                ((zzeg)object3).zzc(string2, object2, object4);
                continue;
            }
            object4 = (Long)arrayList.get(n10);
            long l10 = (Long)object4;
            n11 = (Integer)object2 % 64;
            long l11 = 1L << n11 ^ (long)-1;
            object2 = l10 &= l11;
            arrayList.set(n10, object2);
        }
        int n13 = arrayList.size();
        n11 = arrayList.size() + -1;
        while (true) {
            long l12;
            long l13;
            long l14;
            int n14 = n11;
            n11 = n13;
            n13 = n14;
            if (n14 < 0 || (n10 = (int)((l14 = (l13 = ((Long)(object3 = (Long)arrayList.get(n14))).longValue()) - (l12 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) break;
            n11 = n14 + -1;
        }
        return arrayList.subList(0, n11);
    }

    public final boolean zzq(long l10, long l11) {
        Clock clock;
        long l12;
        long l13;
        long l14;
        long l15 = 0L;
        long l16 = l10 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        return object == false || (l14 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1)) <= 0 || (l13 = (l12 = (l10 = Math.abs(l15 = (clock = this.zzx.zzax()).currentTimeMillis() - l10)) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0;
        {
        }
    }

    public final long zzr(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
        this.zzx.zzl().zzg();
        MessageDigest messageDigest = zzkk.zzN();
        if (messageDigest == null) {
            this.zzx.zzat().zzb().zza("Failed to get MD5");
            return 0L;
        }
        return zzkk.zzO(messageDigest.digest(byArray));
    }

    public final byte[] zzs(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        }
        catch (IOException iOException) {
            this.zzx.zzat().zzb().zzb("Failed to gzip content", iOException);
            throw iOException;
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(byArray);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}

