/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcb;
import com.google.android.gms.internal.clearcut.zzee;
import com.google.android.gms.internal.clearcut.zzeh;
import java.lang.reflect.Field;
import java.util.Arrays;

public final class zzed {
    private final int flags;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final int[] zzms;
    private final zzee zznh;
    private Class zzni;
    private final int zznj;
    private final int zznk;
    private final int zznl;
    private final int zznm;
    private final int zznn;
    private final int zzno;
    private int zznp;
    private int zznq;
    private int zznr = -1 >>> 1;
    private int zzns = -1 << -1;
    private int zznt;
    private int zznu;
    private int zznv;
    private int zznw;
    private int zznx;
    private int zzny;
    private int zznz;
    private int zzoa;
    private int zzob;
    private int zzoc;
    private Field zzod;
    private Object zzoe;
    private Object zzof;
    private Object zzog;

    public zzed(Class object, String string2, Object[] objectArray) {
        int n10;
        int n11;
        int n12 = 0;
        this.zznt = 0;
        this.zznu = 0;
        this.zznv = 0;
        this.zznw = 0;
        this.zznx = 0;
        this.zzni = object;
        this.zznh = object = new zzee(string2);
        this.zzmj = objectArray;
        this.flags = n11 = ((zzee)object).next();
        this.zznj = n11 = ((zzee)object).next();
        objectArray = null;
        if (n11 == 0) {
            this.zznk = 0;
            this.zznl = 0;
            this.zzmk = 0;
            this.zzml = 0;
            this.zznm = 0;
            this.zznn = 0;
            this.zzmm = 0;
            this.zzno = 0;
            this.zzms = null;
            return;
        }
        this.zznk = n11 = ((zzee)object).next();
        this.zznl = n12 = ((zzee)object).next();
        this.zzmk = n10 = ((zzee)object).next();
        this.zzml = n10 = ((zzee)object).next();
        this.zznn = n10 = ((zzee)object).next();
        this.zzmm = n10 = ((zzee)object).next();
        this.zznm = n10 = ((zzee)object).next();
        this.zzno = n10 = ((zzee)object).next();
        int n13 = ((zzee)object).next();
        if (n13 != 0) {
            objectArray = new int[n13];
        }
        this.zzms = (int[])objectArray;
        this.zznp = n13 = (n11 << 1) + n12;
    }

    public static /* synthetic */ int zza(zzed zzed2) {
        return zzed2.flags;
    }

    private static Field zza(Class object, String string2) {
        try {
            return ((Class)object).getDeclaredField(string2);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            int n10;
            Object[] object2 = ((Class)object).getDeclaredFields();
            int n11 = object2.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Field field = object2[n10];
                String string3 = field.getName();
                boolean bl2 = string2.equals(string3);
                if (!bl2) continue;
                return field;
            }
            object = ((Class)object).getName();
            String string4 = Arrays.toString(object2);
            n10 = String.valueOf(string2).length() + 40;
            int n12 = String.valueOf(object).length();
            n10 += n12;
            n12 = String.valueOf(string4).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += n12);
            stringBuilder.append("Field ");
            stringBuilder.append(string2);
            stringBuilder.append(" for ");
            stringBuilder.append((String)object);
            stringBuilder.append(" not found. Known fields are ");
            stringBuilder.append(string4);
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object);
            throw runtimeException;
        }
    }

    public static /* synthetic */ int zzb(zzed zzed2) {
        return zzed2.zzmk;
    }

    public static /* synthetic */ int zzc(zzed zzed2) {
        return zzed2.zzml;
    }

    private final Object zzcw() {
        int n10;
        Object[] objectArray = this.zzmj;
        int n11 = this.zznp;
        this.zznp = n10 = n11 + 1;
        return objectArray[n11];
    }

    private final boolean zzcz() {
        int bl2 = this.flags;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            return n10 != 0;
        }
        return false;
    }

    public static /* synthetic */ int zzd(zzed zzed2) {
        return zzed2.zznj;
    }

    public static /* synthetic */ int zze(zzed zzed2) {
        return zzed2.zznm;
    }

    public static /* synthetic */ int zzf(zzed zzed2) {
        return zzed2.zzno;
    }

    public static /* synthetic */ int[] zzg(zzed zzed2) {
        return zzed2.zzms;
    }

    public static /* synthetic */ int zzh(zzed zzed2) {
        return zzed2.zznn;
    }

    public static /* synthetic */ int zzi(zzed zzed2) {
        return zzed2.zzmm;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final boolean next() {
        block18: {
            block21: {
                block22: {
                    block19: {
                        block20: {
                            var1_1 = this.zznh;
                            var2_2 = var1_1.hasNext();
                            var3_3 = 0;
                            var4_4 = null;
                            if (var2_2 == 0) {
                                return false;
                            }
                            this.zzny = var2_2 = this.zznh.next();
                            var1_1 = this.zznh;
                            this.zznz = var2_2 = var1_1.next();
                            this.zzoa = var2_2 &= 255;
                            var5_5 = this.zzny;
                            var6_6 = this.zznr;
                            if (var5_5 < var6_6) {
                                this.zznr = var5_5;
                            }
                            if (var5_5 > (var6_6 = this.zzns)) {
                                this.zzns = var5_5;
                            }
                            var7_7 = zzcb.zziw;
                            var6_6 = var7_7.id();
                            var8_8 = 1;
                            if (var2_2 == var6_6) {
                                this.zznt = var2_2 = this.zznt + var8_8;
                            } else {
                                var2_2 = this.zzoa;
                                var9_9 /* !! */  = zzcb.zzhq;
                                var6_6 = var9_9 /* !! */ .id();
                                if (var2_2 >= var6_6 && (var2_2 = this.zzoa) <= (var6_6 = (var9_9 /* !! */  = zzcb.zziv).id())) {
                                    this.zznu = var2_2 = this.zznu + var8_8;
                                }
                            }
                            this.zznx = var2_2 = this.zznx + var8_8;
                            var6_6 = this.zznr;
                            var10_10 = this.zzny;
                            var2_2 = (int)zzeh.zzc(var6_6, var10_10, var2_2);
                            if (var2_2 != 0) {
                                this.zznw = var2_2 = this.zzny + var8_8;
                                var6_6 = this.zznr;
                                var2_2 -= var6_6;
                            } else {
                                var2_2 = this.zznv + var8_8;
                            }
                            this.zznv = var2_2;
                            var2_2 = this.zznz & 1024;
                            if (var2_2 != 0) {
                                var2_2 = var8_8;
                            } else {
                                var2_2 = 0;
                                var1_1 = null;
                            }
                            if (var2_2 != 0) {
                                var1_1 = this.zzms;
                                var6_6 = this.zznq;
                                this.zznq = var10_10 = var6_6 + 1;
                                var10_10 = this.zzny;
                                var1_1[var6_6] = var10_10;
                            }
                            var1_1 = null;
                            this.zzoe = null;
                            this.zzof = null;
                            this.zzog = null;
                            var2_2 = (int)this.zzda();
                            if (var2_2 == 0) break block19;
                            var1_1 = this.zznh;
                            this.zzob = var2_2 = var1_1.next();
                            var2_2 = this.zzoa;
                            var4_4 = zzcb.zzhh;
                            var3_3 = var4_4.id() + 51;
                            if (var2_2 == var3_3 || (var2_2 = this.zzoa) == (var3_3 = (var4_4 = zzcb.zzhp).id() + 51)) break block20;
                            var2_2 = this.zzoa;
                            var4_4 = zzcb.zzhk;
                            var3_3 = var4_4.id() + 51;
                            if (var2_2 == var3_3 && (var2_2 = (int)this.zzcz()) != 0) lbl-1000:
                            // 3 sources

                            {
                                while (true) {
                                    this.zzof = var1_1 = this.zzcw();
                                    ** GOTO lbl108
                                    break;
                                }
                            }
                            break block18;
                        }
lbl72:
                        // 2 sources

                        while (true) {
                            var1_1 = this.zzcw();
lbl74:
                            // 2 sources

                            while (true) {
                                this.zzoe = var1_1;
                                break block18;
                                break;
                            }
                            break;
                        }
                    }
                    var1_1 = this.zzni;
                    var9_9 /* !! */  = (String)this.zzcw();
                    this.zzod = var1_1 = zzed.zza((Class)var1_1, (String)var9_9 /* !! */ );
                    var2_2 = (int)this.zzde();
                    if (var2_2 != 0) {
                        var1_1 = this.zznh;
                        this.zzoc = var2_2 = var1_1.next();
                    }
                    if ((var2_2 = this.zzoa) == (var6_6 = (var9_9 /* !! */  = zzcb.zzhh).id()) || (var2_2 = this.zzoa) == (var6_6 = (var9_9 /* !! */  = zzcb.zzhp).id())) break block21;
                    ** while ((var2_2 = this.zzoa) == (var6_6 = (var9_9 /* !! */  = zzcb.zzhz).id()) || (var2_2 = this.zzoa) == (var6_6 = (var9_9 /* !! */  = zzcb.zziv).id()))
lbl87:
                    // 1 sources

                    var2_2 = this.zzoa;
                    var9_9 /* !! */  = zzcb.zzhk;
                    var6_6 = var9_9 /* !! */ .id();
                    if (var2_2 == var6_6 || (var2_2 = this.zzoa) == (var6_6 = (var9_9 /* !! */  = zzcb.zzic).id()) || (var2_2 = this.zzoa) == (var6_6 = (var9_9 /* !! */  = zzcb.zziq).id())) break block22;
                    var2_2 = this.zzoa;
                    var5_5 = var7_7.id();
                    if (var2_2 != var5_5) break block18;
                    this.zzog = var1_1 = this.zzcw();
                    var2_2 = this.zznz & 2048;
                    if (var2_2 != 0) {
                        var3_3 = var8_8;
                    }
                    if (var3_3 == 0) break block18;
                    ** GOTO lbl-1000
                }
                var2_2 = (int)this.zzcz();
                if (var2_2 != 0) {
                    ** continue;
                }
                break block18;
            }
            var1_1 = this.zzod.getType();
            ** while (true)
        }
        return (boolean)var8_8;
    }

    public final int zzcx() {
        return this.zzny;
    }

    public final int zzcy() {
        return this.zzoa;
    }

    public final boolean zzda() {
        int n10 = this.zzoa;
        zzcb zzcb2 = zzcb.zziw;
        int n11 = zzcb2.id();
        return n10 > n11;
    }

    public final Field zzdb() {
        int n10 = this.zzob << 1;
        Object object = this.zzmj[n10];
        boolean bl2 = object instanceof Field;
        if (bl2) {
            return (Field)object;
        }
        Class clazz = this.zzni;
        object = (String)object;
        this.zzmj[n10] = object = zzed.zza(clazz, (String)object);
        return object;
    }

    public final Field zzdc() {
        int n10 = (this.zzob << 1) + 1;
        Object object = this.zzmj[n10];
        boolean bl2 = object instanceof Field;
        if (bl2) {
            return (Field)object;
        }
        Class clazz = this.zzni;
        object = (String)object;
        this.zzmj[n10] = object = zzed.zza(clazz, (String)object);
        return object;
    }

    public final Field zzdd() {
        return this.zzod;
    }

    public final boolean zzde() {
        zzcb zzcb2;
        int n10;
        int n11 = this.zzcz();
        return n11 != 0 && (n11 = this.zzoa) <= (n10 = (zzcb2 = zzcb.zzhp).id());
    }

    public final Field zzdf() {
        int n10 = this.zznk << 1;
        int n11 = this.zzoc / 32;
        Object object = this.zzmj[n10 += n11];
        boolean bl2 = object instanceof Field;
        if (bl2) {
            return (Field)object;
        }
        Class clazz = this.zzni;
        object = (String)object;
        this.zzmj[n10] = object = zzed.zza(clazz, (String)object);
        return object;
    }

    public final int zzdg() {
        return this.zzoc % 32;
    }

    public final boolean zzdh() {
        int n10 = this.zznz & 0x100;
        return n10 != 0;
    }

    public final boolean zzdi() {
        int n10 = this.zznz & 0x200;
        return n10 != 0;
    }

    public final Object zzdj() {
        return this.zzoe;
    }

    public final Object zzdk() {
        return this.zzof;
    }

    public final Object zzdl() {
        return this.zzog;
    }
}

