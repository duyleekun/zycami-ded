/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzaf {
    public static final zzaf zza;
    private final Boolean zzb;
    private final Boolean zzc;

    static {
        zzaf zzaf2;
        zza = zzaf2 = new zzaf(null, null);
    }

    public zzaf(Boolean bl2, Boolean bl3) {
        this.zzb = bl2;
        this.zzc = bl3;
    }

    public static String zza(Bundle object) {
        Boolean bl2;
        Object object2 = object.getString("ad_storage");
        if (object2 != null && (bl2 = zzaf.zzo((String)object2)) == null) {
            return object2;
        }
        object2 = "analytics_storage";
        if ((object = object.getString((String)object2)) != null && (object2 = zzaf.zzo((String)object)) == null) {
            return object;
        }
        return null;
    }

    public static zzaf zzb(Bundle object) {
        if (object == null) {
            return zza;
        }
        Boolean bl2 = zzaf.zzo(object.getString("ad_storage"));
        object = zzaf.zzo(object.getString("analytics_storage"));
        zzaf zzaf2 = new zzaf(bl2, (Boolean)object);
        return zzaf2;
    }

    public static zzaf zzc(String string2) {
        Object object;
        Object object2 = null;
        if (string2 != null) {
            int n10;
            int n11 = string2.length();
            if (n11 >= (n10 = 3)) {
                n11 = string2.charAt(2);
                object = zzaf.zzp((char)n11);
            } else {
                n11 = 0;
                object = null;
            }
            int n12 = string2.length();
            int n13 = 4;
            if (n12 >= n13) {
                char c10 = string2.charAt(n10);
                object2 = zzaf.zzp(c10);
            }
            string2 = object2;
            object2 = object;
        } else {
            boolean bl2 = false;
            string2 = null;
        }
        object = new zzaf((Boolean)object2, (Boolean)((Object)string2));
        return object;
    }

    public static Boolean zzj(Boolean bl2, Boolean bl3) {
        if (bl2 == null) {
            return bl3;
        }
        if (bl3 == null) {
            return bl2;
        }
        boolean bl4 = bl2;
        boolean bl5 = false;
        if (bl4 && (bl4 = bl3.booleanValue())) {
            bl5 = true;
        }
        return bl5;
    }

    public static boolean zzm(int n10, int n11) {
        return n10 <= n11;
    }

    public static final int zzn(Boolean bl2) {
        if (bl2 == null) {
            return 0;
        }
        boolean bl3 = bl2;
        if (bl3) {
            return 1;
        }
        return 2;
    }

    private static Boolean zzo(String string2) {
        if (string2 == null) {
            return null;
        }
        String string3 = "granted";
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return Boolean.TRUE;
        }
        string3 = "denied";
        boolean bl3 = string2.equals(string3);
        if (bl3) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static Boolean zzp(char n10) {
        int n11 = 48;
        if (n10 != n11) {
            n11 = 49;
            if (n10 != n11) {
                return null;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static final char zzq(Boolean bl2) {
        if (bl2 == null) {
            return '-';
        }
        boolean bl3 = bl2;
        if (bl3) {
            return '1';
        }
        return '0';
    }

    public final boolean equals(Object object) {
        int n10;
        Boolean bl2;
        int n11;
        int n12 = object instanceof zzaf;
        if (n12 == 0) {
            return false;
        }
        object = (zzaf)object;
        Boolean bl3 = this.zzb;
        n12 = zzaf.zzn(bl3);
        return n12 == (n11 = zzaf.zzn(bl2 = ((zzaf)object).zzb)) && (n12 = zzaf.zzn(bl3 = this.zzc)) == (n10 = zzaf.zzn((Boolean)(object = ((zzaf)object).zzc)));
    }

    public final int hashCode() {
        int n10 = (zzaf.zzn(this.zzb) + 527) * 31;
        int n11 = zzaf.zzn(this.zzc);
        return n10 + n11;
    }

    public final String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder("ConsentSettings: ");
        stringBuilder.append("adStorage=");
        Object object = this.zzb;
        String string2 = "denied";
        String string3 = "granted";
        String string4 = "uninitialized";
        boolean bl3 = true;
        if (object == null) {
            stringBuilder.append(string4);
        } else {
            bl2 = (Boolean)object;
            object = bl3 != bl2 ? string2 : string3;
            stringBuilder.append((String)object);
        }
        stringBuilder.append(", analyticsStorage=");
        object = this.zzc;
        if (object == null) {
            stringBuilder.append(string4);
        } else {
            bl2 = (Boolean)object;
            if (bl3 == bl2) {
                string2 = string3;
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public final String zzd() {
        StringBuilder stringBuilder = new StringBuilder("G1");
        char c10 = zzaf.zzq(this.zzb);
        stringBuilder.append(c10);
        c10 = zzaf.zzq(this.zzc);
        stringBuilder.append(c10);
        return stringBuilder.toString();
    }

    public final Boolean zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        boolean bl2;
        Boolean bl3 = this.zzb;
        return bl3 == null || (bl2 = bl3.booleanValue());
        {
        }
    }

    public final Boolean zzg() {
        return this.zzc;
    }

    public final boolean zzh() {
        boolean bl2;
        Boolean bl3 = this.zzc;
        return bl3 == null || (bl2 = bl3.booleanValue());
        {
        }
    }

    public final boolean zzi(zzaf object) {
        Boolean bl2 = this.zzb;
        Boolean bl3 = Boolean.FALSE;
        boolean bl4 = true;
        if (bl2 != bl3 || (bl2 = ((zzaf)object).zzb) == bl3) {
            bl2 = this.zzc;
            if (bl2 == bl3) {
                object = ((zzaf)object).zzc;
                if (object == bl3) {
                    return false;
                }
            } else {
                bl4 = false;
            }
        }
        return bl4;
    }

    public final zzaf zzk(zzaf object) {
        Boolean bl2 = this.zzb;
        Boolean bl3 = ((zzaf)object).zzb;
        bl2 = zzaf.zzj(bl2, bl3);
        bl3 = this.zzc;
        object = ((zzaf)object).zzc;
        object = zzaf.zzj(bl3, (Boolean)object);
        zzaf zzaf2 = new zzaf(bl2, (Boolean)object);
        return zzaf2;
    }

    public final zzaf zzl(zzaf zzaf2) {
        Boolean bl2;
        Boolean bl3 = this.zzb;
        if (bl3 == null) {
            bl3 = zzaf2.zzb;
        }
        if ((bl2 = this.zzc) == null) {
            bl2 = zzaf2.zzc;
        }
        zzaf zzaf3 = new zzaf(bl3, bl2);
        return zzaf3;
    }
}

