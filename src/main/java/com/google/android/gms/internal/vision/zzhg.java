/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzhh;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzlf;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzhg
extends zzhe {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzug;
    private int zzuh;
    private int zzui;
    private int zzuj;
    private int zzuk = -1 >>> 1;

    private zzhg(byte[] byArray, int n10, int n11, boolean bl2) {
        super(null);
        this.buffer = byArray;
        this.limit = n11 += n10;
        this.pos = n10;
        this.zzui = n10;
        this.zzug = bl2;
    }

    public /* synthetic */ zzhg(byte[] byArray, int n10, int n11, boolean bl2, zzhh zzhh2) {
        this(byArray, 0, n11, false);
    }

    private final void zzbc(int n10) {
        if (n10 >= 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                this.pos = n12 += n10;
                return;
            }
        }
        if (n10 < 0) {
            throw zzin.zzhi();
        }
        throw zzin.zzhh();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final int zzfu() {
        block1: {
            int n10;
            int n11;
            block3: {
                int n12;
                block5: {
                    int n13;
                    byte[] byArray;
                    block6: {
                        block4: {
                            block2: {
                                n11 = this.limit;
                                n10 = this.pos;
                                if (n11 == n10) break block1;
                                byArray = this.buffer;
                                n12 = n10 + 1;
                                if ((n10 = byArray[n10]) >= 0) {
                                    this.pos = n12;
                                    return n10;
                                }
                                n13 = 9;
                                if ((n11 -= n12) < n13) break block1;
                                n11 = n12 + 1;
                                if ((n10 ^= (n12 = byArray[n12] << 7)) >= 0) break block2;
                                n10 ^= 0xFFFFFF80;
                                break block3;
                            }
                            n12 = n11 + 1;
                            if ((n10 ^= (n11 = byArray[n11] << 14)) < 0) break block4;
                            n10 ^= 0x3F80;
                            break block5;
                        }
                        n11 = n12 + 1;
                        if ((n10 ^= (n12 = byArray[n12] << 21)) >= 0) break block6;
                        int n14 = -2080896;
                        n10 ^= n14;
                        break block3;
                    }
                    n12 = n11 + 1;
                    n11 = byArray[n11];
                    n13 = n11 << 28;
                    n10 ^= n13;
                    n13 = 266354560;
                    n10 ^= n13;
                    if (n11 >= 0) break block5;
                    n11 = n12 + 1;
                    if ((n12 = byArray[n12]) >= 0) break block3;
                    n12 = n11 + 1;
                    if ((n11 = byArray[n11]) >= 0) break block5;
                    n11 = n12 + 1;
                    if ((n12 = byArray[n12]) >= 0) break block3;
                    n12 = n11 + 1;
                    if ((n11 = byArray[n11]) >= 0) break block5;
                    n11 = n12 + 1;
                    byte by2 = byArray[n12];
                    if (by2 < 0) break block1;
                    break block3;
                }
                n11 = n12;
            }
            this.pos = n11;
            return n10;
        }
        return (int)((zzhe)this).zzfs();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final long zzfv() {
        block1: {
            long l10;
            int n10;
            block5: {
                long l11;
                block14: {
                    int n11;
                    block13: {
                        long l12;
                        long l13;
                        byte[] byArray;
                        block12: {
                            block10: {
                                block11: {
                                    long l14;
                                    block8: {
                                        block9: {
                                            block7: {
                                                block6: {
                                                    block3: {
                                                        int n12;
                                                        block4: {
                                                            block2: {
                                                                n10 = this.limit;
                                                                n11 = this.pos;
                                                                if (n10 == n11) break block1;
                                                                byArray = this.buffer;
                                                                n12 = n11 + 1;
                                                                if ((n11 = byArray[n11]) >= 0) {
                                                                    this.pos = n12;
                                                                    return n11;
                                                                }
                                                                int n13 = 9;
                                                                if ((n10 -= n12) < n13) break block1;
                                                                n10 = n12 + 1;
                                                                if ((n11 ^= (n12 = byArray[n12] << 7)) >= 0) break block2;
                                                                n11 ^= 0xFFFFFF80;
                                                                break block3;
                                                            }
                                                            n12 = n10 + 1;
                                                            if ((n11 ^= (n10 = byArray[n10] << 14)) < 0) break block4;
                                                            long l15 = n11 ^= 0x3F80;
                                                            n10 = n12;
                                                            l10 = l15;
                                                            break block5;
                                                        }
                                                        n10 = n12 + 1;
                                                        if ((n11 ^= (n12 = byArray[n12] << 21)) >= 0) break block6;
                                                        int n14 = -2080896;
                                                        n11 ^= n14;
                                                    }
                                                    l10 = n11;
                                                    break block5;
                                                }
                                                l11 = n11;
                                                n11 = n10 + 1;
                                                l13 = (long)byArray[n10] << 28;
                                                long l16 = (l11 ^= l13) - (l13 = 0L);
                                                n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                                                if (n10 < 0) break block7;
                                                l14 = 266354560L;
                                                break block8;
                                            }
                                            n10 = n11 + 1;
                                            l12 = (long)byArray[n11] << 35;
                                            long l17 = (l11 ^= l12) - l13;
                                            if ((n11 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1))) >= 0) break block9;
                                            l13 = -34093383808L;
                                            break block10;
                                        }
                                        n11 = n10 + 1;
                                        l12 = (long)byArray[n10] << 42;
                                        long l18 = (l11 ^= l12) - l13;
                                        if ((n10 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1))) < 0) break block11;
                                        l14 = 4363953127296L;
                                    }
                                    l10 = l11 ^ l14;
                                    n10 = n11;
                                    break block5;
                                }
                                n10 = n11 + 1;
                                l12 = (long)byArray[n11] << 49;
                                long l19 = (l11 ^= l12) - l13;
                                if ((n11 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1))) >= 0) break block12;
                                l13 = -558586000294016L;
                            }
                            l10 = l11 ^ l13;
                            break block5;
                        }
                        n11 = n10 + 1;
                        l12 = (long)byArray[n10] << 56;
                        l11 ^= l12;
                        l12 = 71499008037633920L;
                        long l20 = (l11 ^= l12) - l13;
                        n10 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
                        if (n10 >= 0) break block13;
                        n10 = n11 + 1;
                        l12 = byArray[n11];
                        long l21 = l12 - l13;
                        if ((n11 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1))) < 0) break block1;
                        break block14;
                    }
                    n10 = n11;
                }
                l10 = l11;
            }
            this.pos = n10;
            return l10;
        }
        return ((zzhe)this).zzfs();
    }

    private final int zzfw() {
        int n10 = this.pos;
        int n11 = this.limit - n10;
        int n12 = 4;
        if (n11 >= n12) {
            byte[] byArray = this.buffer;
            this.pos = n12 = n10 + 4;
            n12 = byArray[n10] & 0xFF;
            int n13 = n10 + 1;
            n13 = (byArray[n13] & 0xFF) << 8;
            n12 |= n13;
            n13 = n10 + 2;
            n13 = (byArray[n13] & 0xFF) << 16;
            return (byArray[n10 += 3] & 0xFF) << 24 | (n12 |= n13);
        }
        throw zzin.zzhh();
    }

    private final long zzfx() {
        int n10 = this.pos;
        int n11 = this.limit - n10;
        int n12 = 8;
        if (n11 >= n12) {
            int n13;
            byte[] byArray = this.buffer;
            this.pos = n13 = n10 + 8;
            long l10 = byArray[n10];
            long l11 = 255L;
            int n14 = n10 + 1;
            long l12 = ((long)byArray[n14] & l11) << n12;
            long l13 = (l10 &= l11) | l12;
            int n15 = n10 + 2;
            l12 = ((long)byArray[n15] & l11) << 16;
            l13 |= l12;
            n15 = n10 + 3;
            l12 = ((long)byArray[n15] & l11) << 24;
            l13 |= l12;
            n15 = n10 + 4;
            l12 = ((long)byArray[n15] & l11) << 32;
            l13 |= l12;
            n15 = n10 + 5;
            l12 = ((long)byArray[n15] & l11) << 40;
            l13 |= l12;
            n15 = n10 + 6;
            l12 = ((long)byArray[n15] & l11) << 48;
            return ((long)byArray[n10 += 7] & l11) << 56 | (l13 |= l12);
        }
        throw zzin.zzhh();
    }

    private final void zzfy() {
        int n10 = this.limit;
        int n11 = this.zzuh;
        this.limit = n10 += n11;
        n11 = this.zzui;
        int n12 = this.zzuk;
        if ((n11 = n10 - n11) > n12) {
            this.zzuh = n11 -= n12;
            this.limit = n10 -= n11;
            return;
        }
        this.zzuh = 0;
    }

    private final byte zzfz() {
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

    public final double readDouble() {
        return Double.longBitsToDouble(this.zzfx());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(this.zzfw());
    }

    public final String readString() {
        int n10 = this.zzfu();
        if (n10 > 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                byte[] byArray = this.buffer;
                int n13 = this.pos;
                Charset charset = zzie.UTF_8;
                String string2 = new String(byArray, n13, n10, charset);
                this.pos = n12 = this.pos + n10;
                return string2;
            }
        }
        if (n10 == 0) {
            return "";
        }
        if (n10 < 0) {
            throw zzin.zzhi();
        }
        throw zzin.zzhh();
    }

    public final void zzax(int n10) {
        int n11 = this.zzuj;
        if (n11 == n10) {
            return;
        }
        throw zzin.zzhl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean zzay(int n10) {
        int n11;
        int n12 = n10 & 7;
        int n13 = 1;
        if (n12 != 0) {
            if (n12 != n13) {
                int n14 = 2;
                if (n12 != n14) {
                    n14 = 4;
                    int n15 = 3;
                    if (n12 != n15) {
                        if (n12 == n14) return false;
                        n10 = 5;
                        if (n12 != n10) throw zzin.zzhm();
                        this.zzbc(n14);
                        return n13 != 0;
                    }
                    while ((n12 = ((zzhe)this).zzfr()) != 0 && (n12 = (int)(((zzhe)this).zzay(n12) ? 1 : 0)) != 0) {
                    }
                    n10 = n10 >>> n15 << n15 | n14;
                    ((zzhe)this).zzax(n10);
                    return n13 != 0;
                }
                n10 = this.zzfu();
                this.zzbc(n10);
                return n13 != 0;
            }
            this.zzbc(8);
            return n13 != 0;
        }
        n10 = this.limit;
        n12 = this.pos;
        if ((n10 -= n12) >= (n12 = 10)) {
            for (n11 = 0; n11 < n12; ++n11) {
                int n16;
                byte[] byArray = this.buffer;
                int n17 = this.pos;
                this.pos = n16 = n17 + 1;
                n10 = byArray[n17];
                if (n10 >= 0) return n13 != 0;
            }
            throw zzin.zzhj();
        }
        while (n11 < n12) {
            n10 = this.zzfz();
            if (n10 >= 0) return n13 != 0;
            ++n11;
        }
        throw zzin.zzhj();
    }

    public final int zzaz(int n10) {
        if (n10 >= 0) {
            int n11 = ((zzhe)this).zzft();
            if ((n10 += n11) <= (n11 = this.zzuk)) {
                this.zzuk = n10;
                this.zzfy();
                return n11;
            }
            throw zzin.zzhh();
        }
        throw zzin.zzhi();
    }

    public final void zzba(int n10) {
        this.zzuk = n10;
        this.zzfy();
    }

    public final boolean zzen() {
        int n10 = this.pos;
        int n11 = this.limit;
        return n10 == n11;
    }

    public final long zzeq() {
        return this.zzfv();
    }

    public final long zzer() {
        return this.zzfv();
    }

    public final int zzes() {
        return this.zzfu();
    }

    public final long zzet() {
        return this.zzfx();
    }

    public final int zzeu() {
        return this.zzfw();
    }

    public final boolean zzev() {
        long l10;
        long l11 = this.zzfv();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object != false;
    }

    public final String zzew() {
        int n10 = this.zzfu();
        if (n10 > 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                String string2 = zzlf.zzh(this.buffer, n12, n10);
                this.pos = n12 = this.pos + n10;
                return string2;
            }
        }
        if (n10 == 0) {
            return "";
        }
        if (n10 <= 0) {
            throw zzin.zzhi();
        }
        throw zzin.zzhh();
    }

    public final zzgs zzex() {
        block8: {
            block9: {
                byte[] byArray;
                block7: {
                    int n10;
                    block6: {
                        int n11;
                        int n12;
                        n10 = this.zzfu();
                        if (n10 > 0) {
                            n12 = this.limit;
                            n11 = this.pos;
                            if (n10 <= (n12 -= n11)) {
                                zzgs zzgs2 = zzgs.zza(this.buffer, n11, n10);
                                this.pos = n11 = this.pos + n10;
                                return zzgs2;
                            }
                        }
                        if (n10 == 0) {
                            return zzgs.zztt;
                        }
                        if (n10 <= 0) break block6;
                        n12 = this.limit;
                        n11 = this.pos;
                        if (n10 > (n12 -= n11)) break block6;
                        this.pos = n10 += n11;
                        byte[] byArray2 = this.buffer;
                        byArray = Arrays.copyOfRange(byArray2, n11, n10);
                        break block7;
                    }
                    if (n10 > 0) break block8;
                    if (n10 != 0) break block9;
                    byArray = zzie.zzys;
                }
                return zzgs.zzd(byArray);
            }
            throw zzin.zzhi();
        }
        throw zzin.zzhh();
    }

    public final int zzey() {
        return this.zzfu();
    }

    public final int zzez() {
        return this.zzfu();
    }

    public final int zzfa() {
        return this.zzfw();
    }

    public final long zzfb() {
        return this.zzfx();
    }

    public final int zzfc() {
        return zzhe.zzbb(this.zzfu());
    }

    public final long zzfd() {
        return zzhe.zzr(this.zzfv());
    }

    public final int zzfr() {
        int n10;
        boolean n102 = ((zzhe)this).zzen();
        if (n102) {
            this.zzuj = 0;
            return 0;
        }
        this.zzuj = n10 = this.zzfu();
        int n11 = n10 >>> 3;
        if (n11 != 0) {
            return n10;
        }
        throw zzin.zzhk();
    }

    public final long zzfs() {
        int n10;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = 64); i10 += 7) {
            n10 = this.zzfz();
            int n11 = n10 & 0x7F;
            long l11 = (long)n11 << i10;
            l10 |= l11;
            if ((n10 &= 0x80) != 0) continue;
            return l10;
        }
        throw zzin.zzhj();
    }

    public final int zzft() {
        int n10 = this.pos;
        int n11 = this.zzui;
        return n10 - n11;
    }
}

