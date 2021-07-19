/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzef;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgf;

public final class zzei
extends zzgf {
    private char zza = '\u0000';
    private long zzb = -1;
    private String zzc;
    private final zzeg zzd;
    private final zzeg zze;
    private final zzeg zzf;
    private final zzeg zzg;
    private final zzeg zzh;
    private final zzeg zzi;
    private final zzeg zzj;
    private final zzeg zzk;
    private final zzeg zzl;

    public zzei(zzfl zzfl2) {
        super(zzfl2);
        zzeg zzeg2;
        int n10 = 6;
        this.zzd = zzeg2 = new zzeg(this, n10, false, false);
        boolean bl2 = true;
        this.zze = zzeg2 = new zzeg(this, n10, bl2, false);
        this.zzf = zzeg2 = new zzeg(this, n10, false, bl2);
        n10 = 5;
        this.zzg = zzeg2 = new zzeg(this, n10, false, false);
        this.zzh = zzeg2 = new zzeg(this, n10, bl2, false);
        this.zzi = zzeg2 = new zzeg(this, n10, false, bl2);
        this.zzj = zzeg2 = new zzeg(this, 4, false, false);
        this.zzk = zzeg2 = new zzeg(this, 3, false, false);
        this.zzl = zzeg2 = new zzeg(this, 2, false, false);
    }

    public static Object zzl(String string2) {
        if (string2 == null) {
            return null;
        }
        zzeh zzeh2 = new zzeh(string2);
        return zzeh2;
    }

    public static String zzo(boolean bl2, String string2, Object object, Object object2, Object object3) {
        String string3 = "";
        if (string2 == null) {
            string2 = string3;
        }
        object = zzei.zzp(bl2, object);
        object2 = zzei.zzp(bl2, object2);
        String string4 = zzei.zzp(bl2, object3);
        object3 = new StringBuilder();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            ((StringBuilder)object3).append(string2);
            string3 = ": ";
        }
        boolean bl4 = TextUtils.isEmpty((CharSequence)object);
        String string5 = ", ";
        if (!bl4) {
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append((String)object);
            string3 = string5;
        }
        if (!(bl4 = TextUtils.isEmpty((CharSequence)object2))) {
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append((String)object2);
        } else {
            string5 = string3;
        }
        bl4 = TextUtils.isEmpty((CharSequence)string4);
        if (!bl4) {
            ((StringBuilder)object3).append(string5);
            ((StringBuilder)object3).append(string4);
        }
        return ((StringBuilder)object3).toString();
    }

    public static String zzp(boolean bl2, Object stackTraceElementArray) {
        long l10;
        int n10;
        CharSequence charSequence = "";
        if (stackTraceElementArray == null) {
            return charSequence;
        }
        Object object = stackTraceElementArray instanceof Integer;
        if (object != 0) {
            n10 = (Integer)stackTraceElementArray;
            l10 = n10;
            stackTraceElementArray = l10;
        }
        object = stackTraceElementArray instanceof Long;
        String object22 = "-";
        if (object != 0) {
            long l11;
            if (!bl2) {
                return String.valueOf(stackTraceElementArray);
            }
            Object object2 = stackTraceElementArray;
            object2 = (Long)stackTraceElementArray;
            long l12 = Math.abs((Long)object2);
            long l13 = l12 - (l11 = (long)100);
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object < 0) {
                return String.valueOf(stackTraceElementArray);
            }
            n10 = ((String)(stackTraceElementArray = String.valueOf(stackTraceElementArray))).charAt(0);
            if (n10 == (object = 45)) {
                charSequence = object22;
            }
            object2 = String.valueOf(Math.abs((Long)object2));
            double d10 = ((String)object2).length() + -1;
            double d11 = 10.0;
            l10 = Math.round(Math.pow(d11, d10));
            double d12 = ((String)object2).length();
            long l14 = Math.round(Math.pow(d11, d12) + -1.0);
            int n11 = ((String)charSequence).length();
            int n12 = ((String)charSequence).length();
            n11 = n11 + 43 + n12;
            StringBuilder stringBuilder = new StringBuilder(n11);
            stringBuilder.append((String)charSequence);
            stringBuilder.append(l10);
            stringBuilder.append("...");
            stringBuilder.append((String)charSequence);
            stringBuilder.append(l14);
            return stringBuilder.toString();
        }
        boolean bl3 = stackTraceElementArray instanceof Boolean;
        if (bl3) {
            return String.valueOf(stackTraceElementArray);
        }
        bl3 = stackTraceElementArray instanceof Throwable;
        if (bl3) {
            stackTraceElementArray = (Throwable)stackTraceElementArray;
            String string2 = bl2 ? stackTraceElementArray.getClass().getName() : ((Throwable)stackTraceElementArray).toString();
            charSequence = new StringBuilder(string2);
            string2 = zzei.zzz(zzfl.class.getCanonicalName());
            for (StackTraceElement stackTraceElement : ((Throwable)stackTraceElementArray).getStackTrace()) {
                String string3;
                boolean bl4 = stackTraceElement.isNativeMethod();
                if (bl4 || (string3 = stackTraceElement.getClassName()) == null || !(bl4 = (string3 = zzei.zzz(string3)).equals(string2))) continue;
                string2 = ": ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(stackTraceElement);
                break;
            }
            return ((StringBuilder)charSequence).toString();
        }
        bl3 = stackTraceElementArray instanceof zzeh;
        if (bl3) {
            return zzeh.zza((zzeh)stackTraceElementArray);
        }
        if (bl2) {
            return object22;
        }
        return String.valueOf(stackTraceElementArray);
    }

    public static /* synthetic */ char zzq(zzei zzei2) {
        return zzei2.zza;
    }

    public static /* synthetic */ char zzr(zzei zzei2, char c10) {
        zzei2.zza = c10;
        return c10;
    }

    public static /* synthetic */ long zzs(zzei zzei2) {
        return zzei2.zzb;
    }

    public static /* synthetic */ long zzt(zzei zzei2, long l10) {
        zzei2.zzb = l10 = 39000L;
        return l10;
    }

    private static String zzz(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            return "";
        }
        n11 = string2.lastIndexOf(46);
        if (n11 == (n10 = -1)) {
            return string2;
        }
        return string2.substring(0, n11);
    }

    public final boolean zza() {
        return false;
    }

    public final zzeg zzb() {
        return this.zzd;
    }

    public final zzeg zzc() {
        return this.zze;
    }

    public final zzeg zzd() {
        return this.zzf;
    }

    public final zzeg zze() {
        return this.zzg;
    }

    public final zzeg zzf() {
        return this.zzh;
    }

    public final zzeg zzh() {
        return this.zzi;
    }

    public final zzeg zzi() {
        return this.zzj;
    }

    public final zzeg zzj() {
        return this.zzk;
    }

    public final zzeg zzk() {
        return this.zzl;
    }

    public final void zzm(int n10, boolean n11, boolean n12, String string2, Object object, Object object2, Object object3) {
        Object object4;
        Object object5;
        if (n11 == 0 && (n11 = Log.isLoggable((String)(object5 = this.zzn()), (int)n10)) != 0) {
            n11 = 0;
            object5 = zzei.zzo(false, string2, object, object2, object3);
            object4 = this.zzn();
            Log.println((int)n10, (String)object4, (String)object5);
        }
        if (n12 == 0 && n10 >= (n11 = 5)) {
            zzef zzef2;
            Preconditions.checkNotNull(string2);
            object5 = this.zzx.zzj();
            n12 = 6;
            if (object5 == null) {
                String string3 = this.zzn();
                Log.println((int)n12, (String)string3, (String)"Scheduler not set. Not logging error/warn");
                return;
            }
            boolean bl2 = ((zzgf)object5).zzu();
            if (!bl2) {
                String string4 = this.zzn();
                Log.println((int)n12, (String)string4, (String)"Scheduler not initialized. Not logging error/warn");
                return;
            }
            n12 = 9;
            if (n10 >= n12) {
                n10 = 8;
            }
            object4 = zzef2;
            zzef2 = new zzef(this, n10, string2, object, object2, object3);
            ((zzfi)object5).zzh(zzef2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String zzn() {
        synchronized (this) {
            Object object = this.zzc;
            if (object == null) {
                object = this.zzx;
                if ((object = ((zzfl)object).zzt()) != null) {
                    object = this.zzx;
                    this.zzc = object = ((zzfl)object).zzt();
                } else {
                    object = this.zzx;
                    object = ((zzfl)object).zzc();
                    this.zzc = object = ((zzae)object).zzb();
                }
            }
            object = this.zzc;
            Preconditions.checkNotNull(object);
            return this.zzc;
        }
    }
}

