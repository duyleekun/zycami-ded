/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgo;
import com.google.android.gms.internal.vision.zzgp;
import com.google.android.gms.internal.vision.zzgq;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzhm;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzhz;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzif;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzje;
import com.google.android.gms.internal.vision.zzkb;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzlf;
import com.google.android.gms.internal.vision.zzlk;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public final class zzgr
extends zzgp {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zztq;
    private final int zztr;
    private int zzts;

    public zzgr(ByteBuffer byteBuffer, boolean bl2) {
        super(null);
        int n10;
        int n11;
        this.zztq = true;
        byte[] byArray = byteBuffer.array();
        this.buffer = byArray;
        int n12 = byteBuffer.arrayOffset();
        int n13 = byteBuffer.position();
        this.pos = n11 = n12 + n13;
        this.zztr = n11;
        int n14 = byteBuffer.arrayOffset();
        int n15 = byteBuffer.limit();
        this.limit = n10 = n14 + n15;
    }

    private final byte readByte() {
        int n10 = this.pos;
        int n11 = this.limit;
        if (n10 != n11) {
            int n12;
            byte[] byArray = this.buffer;
            this.pos = n12 = n10 + 1;
            return byArray[n10];
        }
        throw zzin.zzhh();
    }

    private final Object zza(zzlk object, Class clazz, zzho zzho2) {
        int[] nArray = zzgo.zztn;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("unsupported field type.");
                throw object;
            }
            case 17: {
                return this.zzeq();
            }
            case 16: {
                return this.zzey();
            }
            case 15: {
                return this.zzj(true);
            }
            case 14: {
                return this.zzfd();
            }
            case 13: {
                return this.zzfc();
            }
            case 12: {
                return this.zzfb();
            }
            case 11: {
                return this.zzfa();
            }
            case 10: {
                return this.zza(clazz, zzho2);
            }
            case 9: {
                return this.zzer();
            }
            case 8: {
                return this.zzes();
            }
            case 7: {
                return Float.valueOf(this.readFloat());
            }
            case 6: {
                return this.zzet();
            }
            case 5: {
                return this.zzeu();
            }
            case 4: {
                return this.zzez();
            }
            case 3: {
                return this.readDouble();
            }
            case 2: {
                return this.zzex();
            }
            case 1: 
        }
        return this.zzev();
    }

    private final void zza(List iterable, boolean n10) {
        int n11 = this.tag & 7;
        int n12 = 2;
        if (n11 == n12) {
            int n13;
            n11 = iterable instanceof zziu;
            if (n11 != 0 && n10 == 0) {
                int n14;
                List list = iterable;
                list = (zziu)iterable;
                do {
                    iterable = this.zzex();
                    list.zzc((zzgs)iterable);
                    n14 = this.zzen();
                    if (n14 != 0) {
                        return;
                    }
                    n14 = this.pos;
                } while ((n10 = this.zzfe()) == (n12 = this.tag));
                this.pos = n14;
                return;
            }
            do {
                String string2 = this.zzj(n10 != 0);
                iterable.add(string2);
                n11 = (int)(this.zzen() ? 1 : 0);
                if (n11 != 0) {
                    return;
                }
                n11 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n11;
            return;
        }
        throw zzin.zzhm();
    }

    private final void zzao(int n10) {
        int n11;
        this.zzap(n10);
        this.pos = n11 = this.pos + n10;
    }

    private final void zzap(int n10) {
        if (n10 >= 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                return;
            }
        }
        throw zzin.zzhh();
    }

    private final void zzaq(int n10) {
        int n11 = this.tag & 7;
        if (n11 == n10) {
            return;
        }
        throw zzin.zzhm();
    }

    private final void zzar(int n10) {
        this.zzap(n10);
        if ((n10 &= 7) == 0) {
            return;
        }
        throw zzin.zzhn();
    }

    private final void zzas(int n10) {
        this.zzap(n10);
        if ((n10 &= 3) == 0) {
            return;
        }
        throw zzin.zzhn();
    }

    private final void zzat(int n10) {
        int n11 = this.pos;
        if (n11 == n10) {
            return;
        }
        throw zzin.zzhh();
    }

    private final Object zzb(zzkf object, zzho zzho2) {
        block6: {
            Object object2;
            int n10;
            int n11 = this.zzfe();
            this.zzap(n11);
            int n12 = this.limit;
            this.limit = n10 = this.pos + n11;
            try {
                object2 = object.newInstance();
            }
            catch (Throwable throwable) {
                this.limit = n12;
                throw throwable;
            }
            object.zza(object2, this, zzho2);
            object.zzj(object2);
            int n13 = this.pos;
            if (n13 != n10) break block6;
            this.limit = n12;
            return object2;
        }
        object = zzin.zzhn();
        throw object;
    }

    private final Object zzd(zzkf object, zzho zzho2) {
        block7: {
            Object object2;
            int n10;
            int n11 = this.zzts;
            this.zzts = n10 = this.tag >>> 3 << 3 | 4;
            try {
                object2 = object.newInstance();
            }
            catch (Throwable throwable) {
                this.zzts = n11;
                throw throwable;
            }
            object.zza(object2, this, zzho2);
            object.zzj(object2);
            int n12 = this.tag;
            int n13 = this.zzts;
            if (n12 != n13) break block7;
            this.zzts = n11;
            return object2;
        }
        object = zzin.zzhn();
        throw object;
    }

    private final boolean zzen() {
        int n10 = this.pos;
        int n11 = this.limit;
        return n10 == n11;
    }

    /*
     * Unable to fully structure code
     */
    private final int zzfe() {
        block7: {
            block6: {
                block9: {
                    block8: {
                        var2_2 = this.limit;
                        var1_1 = this.pos;
                        if (var2_2 == var1_1) break block7;
                        var3_3 = this.buffer;
                        var4_4 = var1_1 + 1;
                        if ((var1_1 = var3_3[var1_1]) >= 0) {
                            this.pos = var4_4;
                            return var1_1;
                        }
                        var5_5 = 9;
                        if ((var2_2 -= var4_4) < var5_5) {
                            return (int)this.zzfg();
                        }
                        var2_2 = var4_4 + 1;
                        if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 7)) >= 0) break block8;
                        var1_1 ^= -128;
                        break block6;
                    }
                    var4_4 = var2_2 + 1;
                    if ((var1_1 ^= (var2_2 = var3_3[var2_2] << 14)) >= 0) {
                        var1_1 ^= 16256;
lbl20:
                        // 4 sources

                        while (true) {
                            var2_2 = var4_4;
                            break block6;
                            break;
                        }
                    }
                    var2_2 = var4_4 + 1;
                    if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 21)) >= 0) break block9;
                    var6_6 = -2080896;
                    var1_1 ^= var6_6;
                    break block6;
                }
                var4_4 = var2_2 + 1;
                var2_2 = var3_3[var2_2];
                var5_5 = var2_2 << 28;
                var1_1 ^= var5_5;
                var5_5 = 266354560;
                var1_1 ^= var5_5;
                if (var2_2 >= 0) ** GOTO lbl20
                var2_2 = var4_4 + 1;
                if ((var4_4 = var3_3[var4_4]) >= 0) break block6;
                var4_4 = var2_2 + 1;
                if ((var2_2 = var3_3[var2_2]) >= 0) ** GOTO lbl20
                var2_2 = var4_4 + 1;
                if ((var4_4 = var3_3[var4_4]) < 0) {
                    var4_4 = var2_2 + 1;
                    if ((var2_2 = var3_3[var2_2]) < 0) ** break;
                    ** continue;
                    var2_2 = var4_4 + 1;
                    var6_7 = var3_3[var4_4];
                    if (var6_7 < 0) {
                        throw zzin.zzhj();
                    }
                }
            }
            this.pos = var2_2;
            return var1_1;
        }
        throw zzin.zzhh();
    }

    /*
     * Unable to fully structure code
     */
    private final long zzff() {
        var2_2 = this.limit;
        var1_1 = this.pos;
        if (var2_2 != var1_1) {
            var3_3 = this.buffer;
            var4_4 = var1_1 + 1;
            if ((var1_1 = var3_3[var1_1]) >= 0) {
                this.pos = var4_4;
                return var1_1;
            }
            var5_5 = 9;
            if ((var2_2 -= var4_4) < var5_5) {
                return this.zzfg();
            }
            var2_2 = var4_4 + 1;
            if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 7)) < 0) {
                var1_1 ^= -128;
lbl15:
                // 2 sources

                while (true) {
                    var6_6 = var1_1;
                    break;
                }
            } else {
                var4_4 = var2_2 + 1;
                if ((var1_1 ^= (var2_2 = var3_3[var2_2] << 14)) >= 0) {
                    var8_7 = var1_1 ^= 16256;
                    var2_2 = var4_4;
                    var6_6 = var8_7;
                } else {
                    var2_2 = var4_4 + 1;
                    if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 21)) < 0) {
                        var10_8 = -2080896;
                        var1_1 ^= var10_8;
                        ** continue;
                    }
                    var11_9 = var1_1;
                    var1_1 = var2_2 + 1;
                    var13_10 = (long)var3_3[var2_2] << 28;
                    cfr_temp_0 = (var11_9 ^= var13_10) - (var13_10 = 0L);
                    var2_2 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var2_2 >= 0) {
                        var15_11 = 266354560L;
lbl36:
                        // 2 sources

                        while (true) {
                            var6_6 = var11_9 ^ var15_11;
                            var2_2 = var1_1;
                            break;
                        }
                    } else {
                        var2_2 = var1_1 + 1;
                        var17_12 = (long)var3_3[var1_1] << 35;
                        cfr_temp_1 = (var11_9 ^= var17_12) - var13_10;
                        if ((var1_1 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) < 0) {
                            var13_10 = -34093383808L;
lbl45:
                            // 2 sources

                            while (true) {
                                var6_6 = var11_9 ^ var13_10;
                                break;
                            }
                        } else {
                            var1_1 = var2_2 + 1;
                            var17_12 = (long)var3_3[var2_2] << 42;
                            cfr_temp_2 = (var11_9 ^= var17_12) - var13_10;
                            if ((var2_2 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) >= 0) {
                                var15_11 = 4363953127296L;
                                ** continue;
                            }
                            var2_2 = var1_1 + 1;
                            var17_12 = (long)var3_3[var1_1] << 49;
                            cfr_temp_3 = (var11_9 ^= var17_12) - var13_10;
                            if ((var1_1 = (int)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) < 0) {
                                var13_10 = -558586000294016L;
                                ** continue;
                            }
                            var1_1 = var2_2 + 1;
                            var17_12 = (long)var3_3[var2_2] << 56;
                            var11_9 ^= var17_12;
                            var17_12 = 71499008037633920L;
                            cfr_temp_4 = (var11_9 ^= var17_12) - var13_10;
                            var2_2 = (int)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                            if (var2_2 < 0) {
                                var2_2 = var1_1 + 1;
                                var17_12 = var3_3[var1_1];
                                cfr_temp_5 = var17_12 - var13_10;
                                if ((var1_1 = (int)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) < 0) {
                                    throw zzin.zzhj();
                                }
                            } else {
                                var2_2 = var1_1;
                            }
                            var6_6 = var11_9;
                        }
                    }
                }
            }
            this.pos = var2_2;
            return var6_6;
        }
        throw zzin.zzhh();
    }

    private final long zzfg() {
        int n10;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = 64); i10 += 7) {
            n10 = this.readByte();
            int n11 = n10 & 0x7F;
            long l11 = (long)n11 << i10;
            l10 |= l11;
            if ((n10 &= 0x80) != 0) continue;
            return l10;
        }
        throw zzin.zzhj();
    }

    private final int zzfh() {
        this.zzap(4);
        return this.zzfj();
    }

    private final long zzfi() {
        this.zzap(8);
        return this.zzfk();
    }

    private final int zzfj() {
        int n10;
        int n11 = this.pos;
        byte[] byArray = this.buffer;
        this.pos = n10 = n11 + 4;
        n10 = byArray[n11] & 0xFF;
        int n12 = n11 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n10 |= n12;
        n12 = n11 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n11 += 3] & 0xFF) << 24 | (n10 |= n12);
    }

    private final long zzfk() {
        int n10;
        int n11 = this.pos;
        byte[] byArray = this.buffer;
        this.pos = n10 = n11 + 8;
        long l10 = byArray[n11];
        long l11 = 255L;
        l10 &= l11;
        int n12 = n11 + 1;
        long l12 = ((long)byArray[n12] & l11) << 8;
        l10 |= l12;
        n12 = n11 + 2;
        l12 = ((long)byArray[n12] & l11) << 16;
        l10 |= l12;
        n12 = n11 + 3;
        l12 = ((long)byArray[n12] & l11) << 24;
        l10 |= l12;
        n12 = n11 + 4;
        l12 = ((long)byArray[n12] & l11) << 32;
        l10 |= l12;
        n12 = n11 + 5;
        l12 = ((long)byArray[n12] & l11) << 40;
        l10 |= l12;
        n12 = n11 + 6;
        l12 = ((long)byArray[n12] & l11) << 48;
        return ((long)byArray[n11 += 7] & l11) << 56 | (l10 |= l12);
    }

    private final String zzj(boolean bl2) {
        int n10;
        int n11;
        Object object;
        this.zzaq(2);
        int n12 = this.zzfe();
        if (n12 == 0) {
            return "";
        }
        this.zzap(n12);
        if (bl2 && !(bl2 = zzlf.zzf((byte[])(object = (Object)this.buffer), n11 = this.pos, n10 = n11 + n12))) {
            throw zzin.zzho();
        }
        byte[] byArray = this.buffer;
        n10 = this.pos;
        Charset charset = zzie.UTF_8;
        object = new String(byArray, n10, n12, charset);
        this.pos = n11 = this.pos + n12;
        return object;
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() {
        this.zzaq(1);
        return Double.longBitsToDouble(this.zzfi());
    }

    public final float readFloat() {
        this.zzaq(5);
        return Float.intBitsToFloat(this.zzfh());
    }

    public final String readString() {
        return this.zzj(false);
    }

    public final void readStringList(List list) {
        this.zza(list, false);
    }

    public final Object zza(zzkf zzkf2, zzho zzho2) {
        this.zzaq(2);
        return this.zzb(zzkf2, zzho2);
    }

    public final Object zza(Class object, zzho zzho2) {
        this.zzaq(2);
        object = zzkb.zzik().zzf((Class)object);
        return this.zzb((zzkf)object, zzho2);
    }

    public final void zza(List list) {
        int n10 = list instanceof zzhm;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            List list2 = list;
            list2 = (zzhm)list;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    n13 = this.zzfe();
                    this.zzar(n13);
                    n11 = this.pos + n13;
                    while ((n13 = this.pos) < n11) {
                        long l10 = this.zzfk();
                        double d10 = Double.longBitsToDouble(l10);
                        ((zzhm)list2).zzc(d10);
                    }
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                double d11 = this.readDouble();
                ((zzhm)list2).zzc(d11);
                n13 = (int)(this.zzen() ? 1 : 0);
                if (n13 != 0) {
                    return;
                }
                n13 = this.pos;
            } while ((n11 = this.zzfe()) == (n12 = this.tag));
            this.pos = n13;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                n10 = this.zzfe();
                this.zzar(n10);
                n11 = this.pos + n10;
                while ((n10 = this.pos) < n11) {
                    long l11 = this.zzfk();
                    double d12 = Double.longBitsToDouble(l11);
                    Double d13 = d12;
                    list.add(d13);
                }
                return;
            }
            throw zzin.zzhm();
        }
        do {
            double d14 = this.readDouble();
            Double d15 = d14;
            list.add(d15);
            n10 = (int)(this.zzen() ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            n10 = this.pos;
        } while ((n11 = this.zzfe()) == (n12 = this.tag));
        this.pos = n10;
    }

    public final void zza(List list, zzkf zzkf2, zzho zzho2) {
        int n10 = this.tag;
        int n11 = n10 & 7;
        int n12 = 2;
        if (n11 == n12) {
            do {
                Object object = this.zzb(zzkf2, zzho2);
                list.add(object);
                n11 = (int)(this.zzen() ? 1 : 0);
                if (n11 != 0) {
                    return;
                }
                n11 = this.pos;
            } while ((n12 = this.zzfe()) == n10);
            this.pos = n11;
            return;
        }
        throw zzin.zzhm();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Map object, zzje zzje2, zzho zzho2) {
        int n10;
        int n11;
        int n12;
        int n13 = 2;
        this.zzaq(n13);
        int n14 = this.zzfe();
        this.zzap(n14);
        int n15 = this.limit;
        this.limit = n12 = this.pos + n14;
        Object object2 = zzje2.zzaad;
        Object object3 = zzje2.zzgk;
        while ((n11 = this.zzeo()) != (n10 = -1 >>> 1)) {
            Class<?> clazz;
            n10 = 1;
            String string2 = "Unable to parse map entry.";
            if (n11 != n10) {
                if (n11 != n13) {
                    n11 = (int)(this.zzep() ? 1 : 0);
                    if (n11 != 0) continue;
                    zzin zzin2 = new zzin(string2);
                    throw zzin2;
                }
                zzlk zzlk2 = zzje2.zzaae;
                clazz = zzje2.zzgk;
                clazz = clazz.getClass();
                object3 = this.zza(zzlk2, clazz, zzho2);
                continue;
            }
            zzlk zzlk3 = zzje2.zzaac;
            n10 = 0;
            clazz = null;
            object2 = this.zza(zzlk3, null, null);
        }
        {
            object.put(object2, object3);
        }
        {
            catch (Throwable throwable) {
                this.limit = n15;
                throw throwable;
            }
        }
        {
            this.limit = n15;
            return;
        }
    }

    public final Object zzb(Class object, zzho zzho2) {
        this.zzaq(3);
        object = zzkb.zzik().zzf((Class)object);
        return this.zzd((zzkf)object, zzho2);
    }

    public final void zzb(List list) {
        int n10 = list instanceof zzhz;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            list = (zzhz)list;
            n10 = this.tag & 7;
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        float f10 = this.readFloat();
                        ((zzhz)list).zzu(f10);
                        n10 = (int)(this.zzen() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.zzfe()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw zzin.zzhm();
            }
            n10 = this.zzfe();
            this.zzas(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.zzfj();
                float f11 = Float.intBitsToFloat(n10);
                ((zzhz)list).zzu(f11);
            }
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                do {
                    float f12 = this.readFloat();
                    Float f13 = Float.valueOf(f12);
                    list.add(f13);
                    n10 = (int)(this.zzen() ? 1 : 0);
                    if (n10 != 0) {
                        return;
                    }
                    n10 = this.pos;
                } while ((n11 = this.zzfe()) == (n12 = this.tag));
                this.pos = n10;
                return;
            }
            throw zzin.zzhm();
        }
        n10 = this.zzfe();
        this.zzas(n10);
        n11 = this.pos + n10;
        while ((n10 = this.pos) < n11) {
            n10 = this.zzfj();
            float f14 = Float.intBitsToFloat(n10);
            Float f15 = Float.valueOf(f14);
            list.add(f15);
        }
    }

    public final void zzb(List list, zzkf zzkf2, zzho zzho2) {
        int n10 = this.tag;
        int n11 = n10 & 7;
        int n12 = 3;
        if (n11 == n12) {
            do {
                Object object = this.zzd(zzkf2, zzho2);
                list.add(object);
                n11 = (int)(this.zzen() ? 1 : 0);
                if (n11 != 0) {
                    return;
                }
                n11 = this.pos;
            } while ((n12 = this.zzfe()) == n10);
            this.pos = n11;
            return;
        }
        throw zzin.zzhm();
    }

    public final Object zzc(zzkf zzkf2, zzho zzho2) {
        this.zzaq(3);
        return this.zzd(zzkf2, zzho2);
    }

    public final void zzc(List list) {
        int n10;
        int n11 = list instanceof zzjb;
        int n12 = 2;
        if (n11 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzjb)list;
            int n14 = this.tag & 7;
            if (n14 != 0) {
                if (n14 == n12) {
                    n14 = this.zzfe();
                    n12 = this.pos + n14;
                    while ((n14 = this.pos) < n12) {
                        long l10 = this.zzff();
                        ((zzjb)list2).zzac(l10);
                    }
                    this.zzat(n12);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzeq();
                ((zzjb)list2).zzac(l11);
                n14 = (int)(this.zzen() ? 1 : 0);
                if (n14 != 0) {
                    return;
                }
                n14 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n14;
            return;
        }
        n11 = this.tag & 7;
        if (n11 != 0) {
            if (n11 == n12) {
                n11 = this.zzfe();
                n12 = this.pos + n11;
                while ((n11 = this.pos) < n12) {
                    long l12 = this.zzff();
                    Long l13 = l12;
                    list.add(l13);
                }
                this.zzat(n12);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l14 = this.zzeq();
            Long l15 = l14;
            list.add(l15);
            n11 = (int)(this.zzen() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            n11 = this.pos;
        } while ((n12 = this.zzfe()) == (n10 = this.tag));
        this.pos = n11;
    }

    public final void zzd(List list) {
        int n10;
        int n11 = list instanceof zzjb;
        int n12 = 2;
        if (n11 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzjb)list;
            int n14 = this.tag & 7;
            if (n14 != 0) {
                if (n14 == n12) {
                    n14 = this.zzfe();
                    n12 = this.pos + n14;
                    while ((n14 = this.pos) < n12) {
                        long l10 = this.zzff();
                        ((zzjb)list2).zzac(l10);
                    }
                    this.zzat(n12);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzer();
                ((zzjb)list2).zzac(l11);
                n14 = (int)(this.zzen() ? 1 : 0);
                if (n14 != 0) {
                    return;
                }
                n14 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n14;
            return;
        }
        n11 = this.tag & 7;
        if (n11 != 0) {
            if (n11 == n12) {
                n11 = this.zzfe();
                n12 = this.pos + n11;
                while ((n11 = this.pos) < n12) {
                    long l12 = this.zzff();
                    Long l13 = l12;
                    list.add(l13);
                }
                this.zzat(n12);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l14 = this.zzer();
            Long l15 = l14;
            list.add(l15);
            n11 = (int)(this.zzen() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            n11 = this.pos;
        } while ((n12 = this.zzfe()) == (n10 = this.tag));
        this.pos = n11;
    }

    public final void zze(List list) {
        int n10;
        int n11 = list instanceof zzif;
        int n12 = 2;
        if (n11 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzif)list;
            int n14 = this.tag & 7;
            if (n14 != 0) {
                if (n14 == n12) {
                    n14 = this.zzfe();
                    n12 = this.pos + n14;
                    while ((n14 = this.pos) < n12) {
                        n14 = this.zzfe();
                        ((zzif)list2).zzbs(n14);
                    }
                    this.zzat(n12);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n14 = this.zzes();
                ((zzif)list2).zzbs(n14);
                n14 = (int)(this.zzen() ? 1 : 0);
                if (n14 != 0) {
                    return;
                }
                n14 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n14;
            return;
        }
        n11 = this.tag & 7;
        if (n11 != 0) {
            if (n11 == n12) {
                n11 = this.zzfe();
                n12 = this.pos + n11;
                while ((n11 = this.pos) < n12) {
                    n11 = this.zzfe();
                    Integer n15 = n11;
                    list.add(n15);
                }
                this.zzat(n12);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            Integer n16 = this.zzes();
            list.add(n16);
            n11 = (int)(this.zzen() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            n11 = this.pos;
        } while ((n12 = this.zzfe()) == (n10 = this.tag));
        this.pos = n11;
    }

    public final int zzeo() {
        int n10 = this.zzen();
        int n11 = -1 >>> 1;
        if (n10 != 0) {
            return n11;
        }
        this.tag = n10 = this.zzfe();
        int n12 = this.zzts;
        if (n10 == n12) {
            return n11;
        }
        return n10 >>> 3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean zzep() {
        int n10 = this.zzen();
        int n11 = 0;
        if (n10 != 0) return false;
        n10 = this.tag;
        int n12 = this.zzts;
        if (n10 == n12) return false;
        int n13 = n10 & 7;
        int n14 = 1;
        if (n13 != 0) {
            if (n13 != n14) {
                n11 = 2;
                if (n13 != n11) {
                    n11 = 4;
                    int n15 = 3;
                    if (n13 != n15) {
                        n10 = 5;
                        if (n13 != n10) throw zzin.zzhm();
                        this.zzao(n11);
                        return n14 != 0;
                    }
                    this.zzts = n10 = n10 >>> n15 << n15 | n11;
                    while ((n10 = this.zzeo()) != (n11 = -1 >>> 1) && (n10 = (int)(this.zzep() ? 1 : 0)) != 0) {
                    }
                    n10 = this.tag;
                    n11 = this.zzts;
                    if (n10 != n11) throw zzin.zzhn();
                    this.zzts = n12;
                    return n14 != 0;
                }
                n10 = this.zzfe();
                this.zzao(n10);
                return n14 != 0;
            }
            this.zzao(8);
            return n14 != 0;
        }
        n10 = this.limit;
        n12 = this.pos;
        n13 = 10;
        if ((n10 -= n12) >= n13) {
            byte[] byArray = this.buffer;
            for (int i10 = 0; i10 < n13; ++i10) {
                int n16 = n12 + 1;
                if ((n12 = byArray[n12]) >= 0) {
                    this.pos = n16;
                    return n14 != 0;
                }
                n12 = n16;
            }
        }
        while (n11 < n13) {
            n10 = this.readByte();
            if (n10 >= 0) return n14 != 0;
            ++n11;
        }
        throw zzin.zzhj();
    }

    public final long zzeq() {
        this.zzaq(0);
        return this.zzff();
    }

    public final long zzer() {
        this.zzaq(0);
        return this.zzff();
    }

    public final int zzes() {
        this.zzaq(0);
        return this.zzfe();
    }

    public final long zzet() {
        this.zzaq(1);
        return this.zzfi();
    }

    public final int zzeu() {
        this.zzaq(5);
        return this.zzfh();
    }

    public final boolean zzev() {
        boolean bl2 = false;
        this.zzaq(0);
        int n10 = this.zzfe();
        if (n10 != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public final String zzew() {
        return this.zzj(true);
    }

    public final zzgs zzex() {
        int n10;
        Object object;
        this.zzaq(2);
        int n11 = this.zzfe();
        if (n11 == 0) {
            return zzgs.zztt;
        }
        this.zzap(n11);
        boolean bl2 = this.zztq;
        if (bl2) {
            object = this.buffer;
            n10 = this.pos;
            object = zzgs.zzb(object, n10, n11);
        } else {
            object = this.buffer;
            n10 = this.pos;
            object = zzgs.zza(object, n10, n11);
        }
        this.pos = n10 = this.pos + n11;
        return object;
    }

    public final int zzey() {
        this.zzaq(0);
        return this.zzfe();
    }

    public final int zzez() {
        this.zzaq(0);
        return this.zzfe();
    }

    public final void zzf(List list) {
        int n10 = list instanceof zzjb;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            List list2 = list;
            list2 = (zzjb)list;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    n13 = this.zzfe();
                    this.zzar(n13);
                    n11 = this.pos + n13;
                    while ((n13 = this.pos) < n11) {
                        long l10 = this.zzfk();
                        ((zzjb)list2).zzac(l10);
                    }
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzet();
                ((zzjb)list2).zzac(l11);
                n13 = (int)(this.zzen() ? 1 : 0);
                if (n13 != 0) {
                    return;
                }
                n13 = this.pos;
            } while ((n11 = this.zzfe()) == (n12 = this.tag));
            this.pos = n13;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                n10 = this.zzfe();
                this.zzar(n10);
                n11 = this.pos + n10;
                while ((n10 = this.pos) < n11) {
                    long l12 = this.zzfk();
                    Long l13 = l12;
                    list.add(l13);
                }
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l14 = this.zzet();
            Long l15 = l14;
            list.add(l15);
            n10 = (int)(this.zzen() ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            n10 = this.pos;
        } while ((n11 = this.zzfe()) == (n12 = this.tag));
        this.pos = n10;
    }

    public final int zzfa() {
        this.zzaq(5);
        return this.zzfh();
    }

    public final long zzfb() {
        this.zzaq(1);
        return this.zzfi();
    }

    public final int zzfc() {
        this.zzaq(0);
        return zzhe.zzbb(this.zzfe());
    }

    public final long zzfd() {
        this.zzaq(0);
        return zzhe.zzr(this.zzff());
    }

    public final void zzg(List list) {
        int n10 = list instanceof zzif;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            list = (zzif)list;
            n10 = this.tag & 7;
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        n10 = this.zzeu();
                        ((zzif)list).zzbs(n10);
                        n10 = (int)(this.zzen() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.zzfe()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw zzin.zzhm();
            }
            n10 = this.zzfe();
            this.zzas(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.zzfj();
                ((zzif)list).zzbs(n10);
            }
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                do {
                    Integer n13 = this.zzeu();
                    list.add(n13);
                    n10 = (int)(this.zzen() ? 1 : 0);
                    if (n10 != 0) {
                        return;
                    }
                    n10 = this.pos;
                } while ((n11 = this.zzfe()) == (n12 = this.tag));
                this.pos = n10;
                return;
            }
            throw zzin.zzhm();
        }
        n10 = this.zzfe();
        this.zzas(n10);
        n11 = this.pos + n10;
        while ((n10 = this.pos) < n11) {
            n10 = this.zzfj();
            Integer n14 = n10;
            list.add(n14);
        }
    }

    public final void zzh(List list) {
        int n10 = list instanceof zzgq;
        int n11 = 1;
        int n12 = 0;
        int n13 = 2;
        if (n10) {
            List list2 = list;
            list2 = (zzgq)list;
            int n14 = this.tag & 7;
            if (n14) {
                if (n14 == n13) {
                    n14 = this.zzfe();
                    n13 = this.pos + n14;
                    while ((n14 = this.pos) < n13) {
                        n14 = this.zzfe();
                        if (n14) {
                            n14 = n11;
                        } else {
                            n14 = 0;
                            list = null;
                        }
                        ((zzgq)list2).addBoolean(n14 != 0);
                    }
                    this.zzat(n13);
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n14 = (int)(this.zzev() ? 1 : 0);
                ((zzgq)list2).addBoolean(n14 != 0);
                n14 = this.zzen();
                if (n14) {
                    return;
                }
                n14 = this.pos;
            } while ((n11 = this.zzfe()) == (n12 = this.tag));
            this.pos = n14;
            return;
        }
        n10 = this.tag & 7;
        if (n10) {
            if (n10 == n13) {
                n10 = this.zzfe();
                n13 = this.pos + n10;
                while ((n10 = this.pos) < n13) {
                    Boolean bl2;
                    n10 = this.zzfe();
                    if (n10) {
                        n10 = n11;
                    } else {
                        n10 = 0;
                        bl2 = null;
                    }
                    bl2 = n10 != 0;
                    list.add(bl2);
                }
                this.zzat(n13);
                return;
            }
            throw zzin.zzhm();
        }
        do {
            Boolean bl3 = this.zzev();
            list.add(bl3);
            n10 = (int)(this.zzen() ? 1 : 0);
            if (n10) {
                return;
            }
            n10 = this.pos;
        } while ((n11 = this.zzfe()) == (n12 = this.tag));
        this.pos = n10;
    }

    public final void zzi(List list) {
        this.zza(list, true);
    }

    public final void zzj(List list) {
        int n10 = this.tag & 7;
        int n11 = 2;
        if (n10 == n11) {
            int n12;
            do {
                zzgs zzgs2 = this.zzex();
                list.add(zzgs2);
                n10 = (int)(this.zzen() ? 1 : 0);
                if (n10 != 0) {
                    return;
                }
                n10 = this.pos;
            } while ((n11 = this.zzfe()) == (n12 = this.tag));
            this.pos = n10;
            return;
        }
        throw zzin.zzhm();
    }

    public final void zzk(List list) {
        int n10;
        int n11 = list instanceof zzif;
        int n12 = 2;
        if (n11 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzif)list;
            int n14 = this.tag & 7;
            if (n14 != 0) {
                if (n14 == n12) {
                    n14 = this.zzfe();
                    n12 = this.pos + n14;
                    while ((n14 = this.pos) < n12) {
                        n14 = this.zzfe();
                        ((zzif)list2).zzbs(n14);
                    }
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n14 = this.zzey();
                ((zzif)list2).zzbs(n14);
                n14 = (int)(this.zzen() ? 1 : 0);
                if (n14 != 0) {
                    return;
                }
                n14 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n14;
            return;
        }
        n11 = this.tag & 7;
        if (n11 != 0) {
            if (n11 == n12) {
                n11 = this.zzfe();
                n12 = this.pos + n11;
                while ((n11 = this.pos) < n12) {
                    n11 = this.zzfe();
                    Integer n15 = n11;
                    list.add(n15);
                }
                return;
            }
            throw zzin.zzhm();
        }
        do {
            Integer n16 = this.zzey();
            list.add(n16);
            n11 = (int)(this.zzen() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            n11 = this.pos;
        } while ((n12 = this.zzfe()) == (n10 = this.tag));
        this.pos = n11;
    }

    public final void zzl(List list) {
        int n10;
        int n11 = list instanceof zzif;
        int n12 = 2;
        if (n11 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzif)list;
            int n14 = this.tag & 7;
            if (n14 != 0) {
                if (n14 == n12) {
                    n14 = this.zzfe();
                    n12 = this.pos + n14;
                    while ((n14 = this.pos) < n12) {
                        n14 = this.zzfe();
                        ((zzif)list2).zzbs(n14);
                    }
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n14 = this.zzez();
                ((zzif)list2).zzbs(n14);
                n14 = (int)(this.zzen() ? 1 : 0);
                if (n14 != 0) {
                    return;
                }
                n14 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n14;
            return;
        }
        n11 = this.tag & 7;
        if (n11 != 0) {
            if (n11 == n12) {
                n11 = this.zzfe();
                n12 = this.pos + n11;
                while ((n11 = this.pos) < n12) {
                    n11 = this.zzfe();
                    Integer n15 = n11;
                    list.add(n15);
                }
                return;
            }
            throw zzin.zzhm();
        }
        do {
            Integer n16 = this.zzez();
            list.add(n16);
            n11 = (int)(this.zzen() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            n11 = this.pos;
        } while ((n12 = this.zzfe()) == (n10 = this.tag));
        this.pos = n11;
    }

    public final void zzm(List list) {
        int n10 = list instanceof zzif;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            list = (zzif)list;
            n10 = this.tag & 7;
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        n10 = this.zzfa();
                        ((zzif)list).zzbs(n10);
                        n10 = (int)(this.zzen() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.zzfe()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw zzin.zzhm();
            }
            n10 = this.zzfe();
            this.zzas(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.zzfj();
                ((zzif)list).zzbs(n10);
            }
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                do {
                    Integer n13 = this.zzfa();
                    list.add(n13);
                    n10 = (int)(this.zzen() ? 1 : 0);
                    if (n10 != 0) {
                        return;
                    }
                    n10 = this.pos;
                } while ((n11 = this.zzfe()) == (n12 = this.tag));
                this.pos = n10;
                return;
            }
            throw zzin.zzhm();
        }
        n10 = this.zzfe();
        this.zzas(n10);
        n11 = this.pos + n10;
        while ((n10 = this.pos) < n11) {
            n10 = this.zzfj();
            Integer n14 = n10;
            list.add(n14);
        }
    }

    public final void zzn(List list) {
        int n10 = list instanceof zzjb;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            List list2 = list;
            list2 = (zzjb)list;
            int n13 = this.tag & 7;
            if (n13 != n12) {
                if (n13 == n11) {
                    n13 = this.zzfe();
                    this.zzar(n13);
                    n11 = this.pos + n13;
                    while ((n13 = this.pos) < n11) {
                        long l10 = this.zzfk();
                        ((zzjb)list2).zzac(l10);
                    }
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzfb();
                ((zzjb)list2).zzac(l11);
                n13 = (int)(this.zzen() ? 1 : 0);
                if (n13 != 0) {
                    return;
                }
                n13 = this.pos;
            } while ((n11 = this.zzfe()) == (n12 = this.tag));
            this.pos = n13;
            return;
        }
        n10 = this.tag & 7;
        if (n10 != n12) {
            if (n10 == n11) {
                n10 = this.zzfe();
                this.zzar(n10);
                n11 = this.pos + n10;
                while ((n10 = this.pos) < n11) {
                    long l12 = this.zzfk();
                    Long l13 = l12;
                    list.add(l13);
                }
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l14 = this.zzfb();
            Long l15 = l14;
            list.add(l15);
            n10 = (int)(this.zzen() ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            n10 = this.pos;
        } while ((n11 = this.zzfe()) == (n12 = this.tag));
        this.pos = n10;
    }

    public final void zzo(List list) {
        int n10;
        int n11 = list instanceof zzif;
        int n12 = 2;
        if (n11 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzif)list;
            int n14 = this.tag & 7;
            if (n14 != 0) {
                if (n14 == n12) {
                    n14 = this.zzfe();
                    n12 = this.pos + n14;
                    while ((n14 = this.pos) < n12) {
                        n14 = zzhe.zzbb(this.zzfe());
                        ((zzif)list2).zzbs(n14);
                    }
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                n14 = this.zzfc();
                ((zzif)list2).zzbs(n14);
                n14 = (int)(this.zzen() ? 1 : 0);
                if (n14 != 0) {
                    return;
                }
                n14 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n14;
            return;
        }
        n11 = this.tag & 7;
        if (n11 != 0) {
            if (n11 == n12) {
                n11 = this.zzfe();
                n12 = this.pos + n11;
                while ((n11 = this.pos) < n12) {
                    n11 = zzhe.zzbb(this.zzfe());
                    Integer n15 = n11;
                    list.add(n15);
                }
                return;
            }
            throw zzin.zzhm();
        }
        do {
            Integer n16 = this.zzfc();
            list.add(n16);
            n11 = (int)(this.zzen() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            n11 = this.pos;
        } while ((n12 = this.zzfe()) == (n10 = this.tag));
        this.pos = n11;
    }

    public final void zzp(List list) {
        int n10;
        int n11 = list instanceof zzjb;
        int n12 = 2;
        if (n11 != 0) {
            int n13;
            List list2 = list;
            list2 = (zzjb)list;
            int n14 = this.tag & 7;
            if (n14 != 0) {
                if (n14 == n12) {
                    n14 = this.zzfe();
                    n12 = this.pos + n14;
                    while ((n14 = this.pos) < n12) {
                        long l10 = zzhe.zzr(this.zzff());
                        ((zzjb)list2).zzac(l10);
                    }
                    return;
                }
                throw zzin.zzhm();
            }
            do {
                long l11 = this.zzfd();
                ((zzjb)list2).zzac(l11);
                n14 = (int)(this.zzen() ? 1 : 0);
                if (n14 != 0) {
                    return;
                }
                n14 = this.pos;
            } while ((n12 = this.zzfe()) == (n13 = this.tag));
            this.pos = n14;
            return;
        }
        n11 = this.tag & 7;
        if (n11 != 0) {
            if (n11 == n12) {
                n11 = this.zzfe();
                n12 = this.pos + n11;
                while ((n11 = this.pos) < n12) {
                    long l12 = zzhe.zzr(this.zzff());
                    Long l13 = l12;
                    list.add(l13);
                }
                return;
            }
            throw zzin.zzhm();
        }
        do {
            long l14 = this.zzfd();
            Long l15 = l14;
            list.add(l15);
            n11 = (int)(this.zzen() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            n11 = this.pos;
        } while ((n12 = this.zzfe()) == (n10 = this.tag));
        this.pos = n11;
    }
}

