/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzcj;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzkf;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class zzw {
    public final String zzb;
    public final int zzc;
    public Boolean zzd;
    public Boolean zze;
    public Long zzf;
    public Long zzg;

    public zzw(String string2, int n10) {
        this.zzb = string2;
        this.zzc = n10;
    }

    private static Boolean zzd(String object, zzcj object2, boolean n10, String string2, List list, String string3, zzei zzei2) {
        Object object3 = zzcj.zzg;
        if (object2 == object3) {
            int n11;
            if (list == null || (n11 = list.size()) == 0) {
                return null;
            }
        } else if (string2 == null) {
            return null;
        }
        if (n10 == 0 && object2 != (object3 = zzcj.zzb)) {
            object3 = Locale.ENGLISH;
            object = ((String)object).toUpperCase((Locale)object3);
        }
        object3 = zzcc.zza;
        int n12 = ((Enum)object2).ordinal();
        switch (n12) {
            default: {
                return null;
            }
            case 6: {
                if (list == null) {
                    return null;
                }
                return list.contains(object);
            }
            case 5: {
                return ((String)object).equals(string2);
            }
            case 4: {
                return ((String)object).contains(string2);
            }
            case 3: {
                return ((String)object).endsWith(string2);
            }
            case 2: {
                return ((String)object).startsWith(string2);
            }
            case 1: 
        }
        if (string3 == null) {
            return null;
        }
        n12 = 1;
        if (n12 != n10) {
            n12 = 66;
        } else {
            n12 = 0;
            object2 = null;
        }
        try {
            object2 = Pattern.compile(string3, n12);
        }
        catch (PatternSyntaxException patternSyntaxException) {
            if (zzei2 != null) {
                object = zzei2.zze();
                object2 = "Invalid regular expression in REGEXP audience filter. expression";
                ((zzeg)object).zzb((String)object2, string3);
            }
            return null;
        }
        object = ((Pattern)object2).matcher((CharSequence)object);
        boolean bl2 = ((Matcher)object).matches();
        return bl2;
    }

    public static Boolean zze(Boolean bl2, boolean bl3) {
        if (bl2 == null) {
            return null;
        }
        boolean bl4 = bl2;
        if (bl4 != bl3) {
            bl4 = true;
        } else {
            bl4 = false;
            bl2 = null;
        }
        return bl4;
    }

    public static Boolean zzf(String string2, zzck object, zzei zzei2) {
        Object object2;
        Object object3;
        Preconditions.checkNotNull(object);
        if (string2 == null) {
            return null;
        }
        boolean n10 = ((zzck)object).zza();
        if (n10 && (object3 = ((zzck)object).zzb()) != (object2 = zzcj.zza)) {
            Object object4;
            Iterator iterator2;
            object3 = ((zzck)object).zzb();
            if (object3 == (object2 = zzcj.zzg)) {
                int n11 = ((zzck)object).zzh();
                if (n11 == 0) {
                    return null;
                }
            } else {
                boolean bl2 = ((zzck)object).zzc();
                if (!bl2) {
                    return null;
                }
            }
            zzcj zzcj2 = ((zzck)object).zzb();
            boolean bl3 = ((zzck)object).zzf();
            if (!bl3 && zzcj2 != (object3 = zzcj.zzb) && zzcj2 != object2) {
                object3 = ((zzck)object).zzd();
                object2 = Locale.ENGLISH;
                object3 = ((String)object3).toUpperCase((Locale)object2);
            } else {
                object3 = ((zzck)object).zzd();
            }
            ArrayList<Object> arrayList = object3;
            int n12 = ((zzck)object).zzh();
            if (n12 == 0) {
                iterator2 = null;
            } else {
                object = ((zzck)object).zzg();
                if (!bl3) {
                    int n13 = object.size();
                    object3 = new Object(n13);
                    object = object.iterator();
                    while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        object2 = (String)object.next();
                        object4 = Locale.ENGLISH;
                        object2 = ((String)object2).toUpperCase((Locale)object4);
                        object3.add(object2);
                    }
                    object = Collections.unmodifiableList(object3);
                }
                iterator2 = object;
            }
            object = zzcj.zzb;
            ArrayList<Object> arrayList2 = zzcj2 == object ? arrayList : null;
            object4 = string2;
            return zzw.zzd(string2, zzcj2, bl3, arrayList, iterator2, arrayList2, zzei2);
        }
        return null;
    }

    public static Boolean zzg(long l10, zzcd zzcd2) {
        double d10;
        BigDecimal bigDecimal;
        try {
            bigDecimal = new BigDecimal(l10);
            l10 = 0L;
            d10 = 0.0;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        return zzw.zzj(bigDecimal, zzcd2, d10);
    }

    public static Boolean zzh(double d10, zzcd zzcd2) {
        BigDecimal bigDecimal;
        try {
            bigDecimal = new BigDecimal(d10);
            d10 = Math.ulp(d10);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        return zzw.zzj(bigDecimal, zzcd2, d10);
    }

    public static Boolean zzi(String string2, zzcd zzcd2) {
        double d10;
        BigDecimal bigDecimal;
        boolean bl2 = zzkf.zzl(string2);
        if (!bl2) {
            return null;
        }
        try {
            bigDecimal = new BigDecimal(string2);
            d10 = 0.0;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        return zzw.zzj(bigDecimal, zzcd2, d10);
    }

    public static Boolean zzj(BigDecimal bigDecimal, zzcd object, double d10) {
        block38: {
            int n10;
            int n11;
            int n12;
            Object object2;
            block43: {
                Boolean bl2;
                block40: {
                    block42: {
                        Object object3;
                        Object object4;
                        Enum enum_;
                        Object object5;
                        block41: {
                            block39: {
                                block37: {
                                    Preconditions.checkNotNull(object);
                                    boolean n13 = ((zzcd)object).zza();
                                    bl2 = null;
                                    if (!n13 || (object5 = ((zzcd)object).zzb()) == (enum_ = zzcc.zza)) break block38;
                                    object5 = ((zzcd)object).zzb();
                                    if (object5 == (enum_ = zzcc.zze)) {
                                        boolean bl3;
                                        boolean bl4 = ((zzcd)object).zzg();
                                        if (!bl4 || !(bl3 = ((zzcd)object).zzi())) {
                                            return null;
                                        }
                                    } else {
                                        boolean bl5 = ((zzcd)object).zze();
                                        if (!bl5) {
                                            return null;
                                        }
                                    }
                                    object5 = ((zzcd)object).zzb();
                                    object2 = ((zzcd)object).zzb();
                                    if (object2 == enum_) {
                                        object2 = ((zzcd)object).zzh();
                                        boolean bl6 = zzkf.zzl((String)object2);
                                        if (bl6 && (bl6 = zzkf.zzl((String)(object2 = ((zzcd)object).zzj())))) {
                                            try {
                                                object4 = ((zzcd)object).zzh();
                                            }
                                            catch (NumberFormatException numberFormatException) {}
                                            object2 = new BigDecimal((String)object4);
                                            object = ((zzcd)object).zzj();
                                            object4 = new BigDecimal((String)object);
                                            object = object2;
                                            bl6 = false;
                                            object2 = null;
                                            break block37;
                                        }
                                        return null;
                                    }
                                    object2 = ((zzcd)object).zzf();
                                    boolean bl7 = zzkf.zzl((String)object2);
                                    if (!bl7) {
                                        return null;
                                    }
                                    try {
                                        object = ((zzcd)object).zzf();
                                    }
                                    catch (NumberFormatException numberFormatException) {}
                                    object2 = new BigDecimal((String)object);
                                    object3 = 0;
                                    object = null;
                                    object4 = null;
                                }
                                if (object5 != enum_) break block39;
                                if (object == null) break block40;
                                break block41;
                            }
                            if (object2 == null) break block40;
                        }
                        enum_ = zzcj.zza;
                        int n13 = ((Enum)object5).ordinal();
                        n12 = -1;
                        n11 = 0;
                        n10 = 1;
                        if (n13 == n10) break block42;
                        int n14 = 2;
                        if (n13 != n14) {
                            int n15 = 3;
                            if (n13 != n15) {
                                int n16 = 4;
                                if (n13 == n16 && object != null) {
                                    int n17;
                                    object3 = bigDecimal.compareTo((BigDecimal)object);
                                    if (object3 != n12 && (n17 = bigDecimal.compareTo((BigDecimal)object4)) != n10) {
                                        n11 = n10;
                                    }
                                    bl2 = n11 != 0;
                                }
                            } else if (object2 != null) {
                                double d11 = 0.0;
                                double d12 = d10 - d11;
                                object3 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
                                if (object3 != 0) {
                                    object = new BigDecimal(d10);
                                    object5 = new BigDecimal(n14);
                                    object = ((BigDecimal)object).multiply((BigDecimal)object5);
                                    object3 = bigDecimal.compareTo((BigDecimal)(object = ((BigDecimal)object2).subtract((BigDecimal)object)));
                                    if (object3 == n10) {
                                        object = new BigDecimal(d10);
                                        BigDecimal bigDecimal2 = new BigDecimal(n14);
                                        object = ((BigDecimal)object).multiply(bigDecimal2);
                                        int n18 = bigDecimal.compareTo((BigDecimal)(object = ((BigDecimal)object2).add((BigDecimal)object)));
                                        if (n18 == n12) {
                                            n11 = n10;
                                        }
                                    }
                                    bl2 = n11 != 0;
                                } else {
                                    int n19 = bigDecimal.compareTo((BigDecimal)object2);
                                    if (n19 == 0) {
                                        n11 = n10;
                                    }
                                    bl2 = n11 != 0;
                                }
                            }
                        } else if (object2 != null) {
                            int n20 = bigDecimal.compareTo((BigDecimal)object2);
                            if (n20 == n10) {
                                n11 = n10;
                            }
                            return n11 != 0;
                        }
                        break block40;
                    }
                    if (object2 != null) break block43;
                }
                return bl2;
            }
            int n21 = bigDecimal.compareTo((BigDecimal)object2);
            if (n21 == n12) {
                n11 = n10;
            }
            return n11 != 0;
        }
        return null;
    }

    public abstract int zza();

    public abstract boolean zzb();

    public abstract boolean zzc();
}

