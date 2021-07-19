/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.q2.d;
import h.c0;
import h.e0;
import h.i0;
import h.j;
import h.j0;
import h.k0;
import h.m$a;
import h.m$b;
import h.m$c;
import h.m0;
import h.n;
import h.o;
import h.o0;
import h.q0.a;
import h.z;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;
import okio.SegmentedByteString;

public final class m
implements o,
n,
Cloneable,
ByteChannel {
    public i0 a;
    private long b;

    private final ByteString A0(String object, ByteString object2) {
        Object object3;
        block20: {
            object3 = Mac.getInstance((String)object);
            object2 = ((ByteString)object2).internalArray$okio();
            Object object4 = new SecretKeySpec((byte[])object2, (String)object);
            ((Mac)object3).init((Key)object4);
            object = this.a;
            if (object == null) break block20;
            object2 = ((i0)object).a;
            int n10 = ((i0)object).b;
            int n11 = ((i0)object).c - n10;
            ((Mac)object3).update((byte[])object2, n10, n11);
            object2 = ((i0)object).f;
            f0.m(object2);
            while (object2 != object) {
                object4 = ((i0)object2).a;
                n11 = ((i0)object2).b;
                int n12 = ((i0)object2).c - n11;
                ((Mac)object3).update((byte[])object4, n11, n12);
                object2 = ((i0)object2).f;
                f0.m(object2);
            }
        }
        try {
            object2 = ((Mac)object3).doFinal();
            object3 = "mac.doFinal()";
        }
        catch (InvalidKeyException invalidKeyException) {
            object2 = new IllegalArgumentException(invalidKeyException);
            throw object2;
        }
        f0.o(object2, (String)object3);
        object = new ByteString((byte[])object2);
        return object;
    }

    public static /* synthetic */ m$a H0(m m10, m$a m$a, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            m$a = new m$a();
        }
        return m10.G0(m$a);
    }

    private final void K0(InputStream object, long l10, boolean bl2) {
        long l11;
        long l12;
        long l13;
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 || bl2) {
            int n10;
            l13 = 1;
            i0 i02 = this.V0((int)l13);
            int n11 = i02.c;
            long l14 = 8192 - n11;
            l14 = Math.min(l10, l14);
            n11 = (int)l14;
            byte[] byArray = i02.a;
            int n12 = i02.c;
            if ((n11 = ((InputStream)object).read(byArray, n12, n11)) == (n10 = -1)) {
                int n13 = i02.b;
                int n14 = i02.c;
                if (n13 == n14) {
                    this.a = object = i02.b();
                    j0.d(i02);
                }
                if (bl2) {
                    return;
                }
                object = new EOFException();
                throw object;
            }
            i02.c = n10 = i02.c + n11;
            long l15 = this.b;
            l11 = n11;
            this.b = l15 += l11;
            l10 -= l11;
        }
        return;
    }

    public static /* synthetic */ m$a N0(m m10, m$a m$a, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            m$a = new m$a();
        }
        return m10.M0(m$a);
    }

    public static /* synthetic */ m o1(m m10, OutputStream outputStream, long l10, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            l10 = m10.b;
        }
        return m10.n1(outputStream, l10);
    }

    public static /* synthetic */ m t0(m m10, OutputStream outputStream, long l10, long l11, int n10, Object object) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            l10 = 0L;
        }
        long l12 = l10;
        int n12 = n10 & 4;
        if (n12 != 0) {
            l10 = m10.b;
            l11 = l10 - l12;
        }
        return m10.q0(outputStream, l12, l11);
    }

    public static /* synthetic */ m u0(m m10, m m11, long l10, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            l10 = 0L;
        }
        return m10.r0(m11, l10);
    }

    public static /* synthetic */ m v0(m m10, m m11, long l10, long l11, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            l10 = 0L;
        }
        return m10.s0(m11, l10, l11);
    }

    private final ByteString w0(String object) {
        object = MessageDigest.getInstance((String)object);
        Object object2 = this.a;
        if (object2 != null) {
            Object object3 = ((i0)object2).a;
            int n10 = ((i0)object2).b;
            int n11 = ((i0)object2).c - n10;
            ((MessageDigest)object).update((byte[])object3, n10, n11);
            object3 = ((i0)object2).f;
            f0.m(object3);
            while (object3 != object2) {
                byte[] byArray = object3.a;
                n11 = object3.b;
                int n12 = object3.c - n11;
                ((MessageDigest)object).update(byArray, n11, n12);
                object3 = object3.f;
                f0.m(object3);
            }
        }
        object = ((MessageDigest)object).digest();
        f0.o(object, "messageDigest.digest()");
        object2 = new ByteString((byte[])object);
        return object2;
    }

    public final void B() {
        long l10 = this.S0();
        this.skip(l10);
    }

    public final ByteString B0(ByteString byteString) {
        f0.p(byteString, "key");
        return this.A0("HmacSHA1", byteString);
    }

    public final ByteString C0(ByteString byteString) {
        f0.p(byteString, "key");
        return this.A0("HmacSHA256", byteString);
    }

    public final ByteString D0(ByteString byteString) {
        f0.p(byteString, "key");
        return this.A0("HmacSHA512", byteString);
    }

    public m E() {
        return this.n0();
    }

    public final ByteString E0() {
        return this.w0("MD5");
    }

    public final m$a F0() {
        return m.H0(this, null, 1, null);
    }

    public short G() {
        return j.j(this.readShort());
    }

    public final m$a G0(m$a object) {
        boolean bl2;
        f0.p(object, "unsafeCursor");
        Object object2 = ((m$a)object).a;
        boolean bl3 = true;
        if (object2 == null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            ((m$a)object).a = this;
            ((m$a)object).b = bl3;
            return object;
        }
        object2 = "already attached to a buffer".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public long I() {
        return j.i(this.readLong());
    }

    public final m I0(InputStream inputStream) {
        f0.p(inputStream, "input");
        this.K0(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final m J0(InputStream object, long l10) {
        String string2 = "input";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            l12 = 1;
        } else {
            l12 = 0;
            string2 = null;
        }
        if (l12 != false) {
            this.K0((InputStream)object, l10, false);
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    /*
     * Unable to fully structure code
     */
    public long K(ByteString var1_1, long var2_2) {
        var4_3 = "targetBytes";
        f0.p(var1_1, var4_3);
        var5_4 = 0L;
        var7_5 = var2_2 == var5_4 ? 0 : (var2_2 < var5_4 ? -1 : 1);
        var8_6 = 0;
        var9_7 = 1;
        if (var7_5 >= 0) {
            var7_5 = var9_7;
        } else {
            var7_5 = 0;
            var10_8 = null;
        }
        if (var7_5 != false) {
            block29: {
                var10_8 = this.a;
                var11_9 = -1;
                if (var10_8 != null) {
                    var13_10 = this.S0() - var2_2;
                    var15_11 = var13_10 == var2_2 ? 0 : (var13_10 < var2_2 ? -1 : 1);
                    var16_12 = 2;
                    if (var15_11 < 0) {
                        var5_4 = this.S0();
                        while ((var15_11 = var5_4 == var2_2 ? 0 : (var5_4 < var2_2 ? -1 : 1)) > 0) {
                            var10_8 = var10_8.g;
                            f0.m(var10_8);
                            var15_11 = var10_8.c;
                            var17_13 = var10_8.b;
                            var18_15 = var15_11 -= var17_13;
                            var5_4 -= var18_15;
                        }
                        if (var10_8 != null) {
                            var15_11 = var1_1.size();
                            if (var15_11 == var16_12) {
                                var8_6 = var1_1.getByte(0);
                                var20_17 = var1_1.getByte(var9_7);
                                while ((var9_7 = (int)((cfr_temp_0 = var5_4 - (var13_10 = this.S0())) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) < 0) {
                                    var21_18 = var10_8.a;
                                    var15_11 = var10_8.b;
                                    var13_10 = (long)var15_11 + var2_2 - var5_4;
                                    var23_23 = var10_8.c;
                                    for (var22_22 = (int)var13_10; var22_22 < var23_23; ++var22_22) {
                                        var15_11 = var21_18[var22_22];
                                        if (var15_11 != var8_6 && var15_11 != var20_17) {
                                            continue;
                                        }
                                        while (true) {
                                            var20_17 = var10_8.b;
lbl45:
                                            // 2 sources

                                            while (true) {
                                                var24_27 = var22_22 -= var20_17;
                                                var11_9 = var24_27 + var5_4;
                                                break block29;
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    var22_22 = var10_8.c;
                                    var23_23 = var10_8.b;
                                    var2_2 = var22_22 -= var23_23;
                                    var5_4 += var2_2;
                                    var10_8 = var10_8.f;
                                    f0.m(var10_8);
                                    var2_2 = var5_4;
                                }
                            } else {
                                var1_1 = var1_1.internalArray$okio();
                                while ((var9_7 = (int)((cfr_temp_1 = var5_4 - (var13_10 = this.S0())) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) < 0) {
                                    var21_19 = var10_8.a;
                                    var15_11 = var10_8.b;
                                    var13_10 = (long)var15_11 + var2_2 - var5_4;
                                    var23_24 = var10_8.c;
                                    for (var22_22 = (int)var13_10; var22_22 < var23_24; ++var22_22) {
                                        var15_11 = var21_19[var22_22];
                                        for (Object var26_28 : var1_1) {
                                            if (var15_11 != var26_28) continue;
                                            while (true) {
                                                var20_17 = var10_8.b;
                                                ** continue;
                                                break;
                                            }
                                        }
                                    }
                                    var22_22 = var10_8.c;
                                    var23_24 = var10_8.b;
                                    var2_2 = var22_22 -= var23_24;
                                    var5_4 += var2_2;
                                    var10_8 = var10_8.f;
                                    f0.m(var10_8);
                                    var2_2 = var5_4;
                                }
                            }
                        }
                    } else {
                        while (true) {
                            var15_11 = var10_8.c;
                            var17_14 = var10_8.b;
                            var18_16 = (long)(var15_11 - var17_14) + var5_4;
                            cfr_temp_2 = var18_16 - var2_2;
                            if ((var15_11 = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) > 0) {
                                if (var10_8 != null) {
                                    var15_11 = var1_1.size();
                                    if (var15_11 == var16_12) {
                                        var8_6 = var1_1.getByte(0);
                                        var20_17 = var1_1.getByte(var9_7);
                                        while ((var9_7 = (int)((cfr_temp_3 = var5_4 - (var13_10 = this.S0())) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) < 0) {
                                            var21_20 = var10_8.a;
                                            var15_11 = var10_8.b;
                                            var13_10 = (long)var15_11 + var2_2 - var5_4;
                                            var23_25 = var10_8.c;
                                            for (var22_22 = (int)var13_10; var22_22 < var23_25; ++var22_22) {
                                                if ((var15_11 = (long)var21_20[var22_22]) == var8_6 || var15_11 == var20_17) ** continue;
                                            }
                                            var22_22 = var10_8.c;
                                            var23_25 = var10_8.b;
                                            var2_2 = var22_22 -= var23_25;
                                            var5_4 += var2_2;
                                            var10_8 = var10_8.f;
                                            f0.m(var10_8);
                                            var2_2 = var5_4;
                                        }
                                    } else {
                                        var1_1 = var1_1.internalArray$okio();
                                        while ((var9_7 = (int)((cfr_temp_4 = var5_4 - (var13_10 = this.S0())) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) < 0) {
                                            var21_21 = var10_8.a;
                                            var15_11 = var10_8.b;
                                            var13_10 = (long)var15_11 + var2_2 - var5_4;
                                            var23_26 = var10_8.c;
                                            for (var22_22 = (int)var13_10; var22_22 < var23_26; ++var22_22) {
                                                var15_11 = var21_21[var22_22];
                                                for (Object var26_29 : var1_1) {
                                                    if (var15_11 == var26_29) ** continue;
                                                }
                                            }
                                            var22_22 = var10_8.c;
                                            var23_26 = var10_8.b;
                                            var2_2 = var22_22 -= var23_26;
                                            var5_4 += var2_2;
                                            var10_8 = var10_8.f;
                                            f0.m(var10_8);
                                            var2_2 = var5_4;
                                        }
                                    }
                                }
                                break;
                            }
                            var10_8 = var10_8.f;
                            f0.m(var10_8);
                            var5_4 = var18_16;
                        }
                    }
                }
            }
            return var11_9;
        }
        var1_1 = new StringBuilder();
        var1_1.append("fromIndex < 0: ");
        var1_1.append(var2_2);
        var1_1 = var1_1.toString();
        var1_1 = var1_1.toString();
        var27_30 = new IllegalArgumentException((String)var1_1);
        throw var27_30;
    }

    public void L(long l10) {
        long l11 = this.b;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            return;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public final m$a L0() {
        return m.N0(this, null, 1, null);
    }

    public final m$a M0(m$a object) {
        boolean bl2;
        f0.p(object, "unsafeCursor");
        Object object2 = ((m$a)object).a;
        if (object2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            ((m$a)object).a = this;
            ((m$a)object).b = false;
            return object;
        }
        object2 = "already attached to a buffer".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public long N(byte by2) {
        return this.l(by2, 0L, Long.MAX_VALUE);
    }

    public final long O() {
        long l10;
        long l11 = this.S0();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            i0 i02 = this.a;
            f0.m(i02);
            i02 = i02.g;
            f0.m(i02);
            int n10 = i02.c;
            object = 8192;
            if (n10 < object && (object = (Object)i02.e) != false) {
                int n11 = i02.b;
                l10 = n10 -= n11;
                l11 -= l10;
            }
            l10 = l11;
        }
        return l10;
    }

    public final void O0(long l10) {
        this.b = l10;
    }

    public String P(long l10) {
        Charset charset = d.a;
        return this.g0(l10, charset);
    }

    public final ByteString P0() {
        return this.w0("SHA-1");
    }

    public ByteString Q(long l10) {
        Comparable<StringBuilder> comparable;
        long l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l11 = l10 - (l12 = (long)(-1 >>> 1))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            object = 1;
        } else {
            object = 0;
            comparable = null;
        }
        if (object != false) {
            l12 = this.S0();
            long l14 = l12 - l10;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object >= 0) {
                l12 = 4096;
                long l15 = l10 - l12;
                object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object >= 0) {
                    object = (int)l10;
                    comparable = this.U0((int)object);
                    this.skip(l10);
                } else {
                    byte[] byArray = this.z(l10);
                    comparable = new ByteString(byArray);
                }
                return comparable;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        comparable = new StringBuilder();
        comparable.append("byteCount: ");
        comparable.append(l10);
        String string2 = comparable.toString();
        string2 = string2.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final ByteString Q0() {
        return this.w0("SHA-256");
    }

    public final ByteString R0() {
        return this.w0("SHA-512");
    }

    public final long S0() {
        return this.b;
    }

    public byte[] T() {
        long l10 = this.S0();
        return this.z(l10);
    }

    public final ByteString T0() {
        CharSequence charSequence;
        int n10;
        long l10;
        long l11 = this.S0();
        long l12 = l11 - (l10 = (long)(n10 = -1 >>> 1));
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            object = 1;
        } else {
            object = 0;
            charSequence = null;
        }
        if (object != false) {
            object = (int)this.S0();
            return this.U0((int)object);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("size > Int.MAX_VALUE: ");
        long l13 = this.S0();
        ((StringBuilder)charSequence).append(l13);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public final ByteString U0(int n10) {
        ByteString byteString;
        if (n10 == 0) {
            byteString = ByteString.EMPTY;
        } else {
            int n11;
            long l10 = this.S0();
            long l11 = 0L;
            long l12 = n10;
            j.e(l10, l11, l12);
            Object object = this.a;
            int n12 = 0;
            int n13 = 0;
            int[] nArray = null;
            int n14 = 0;
            while (n13 < n10) {
                f0.m(object);
                n11 = ((i0)object).c;
                int n15 = ((i0)object).b;
                if (n11 != n15) {
                    n13 += (n11 -= n15);
                    ++n14;
                    object = ((i0)object).f;
                    continue;
                }
                AssertionError assertionError = new AssertionError((Object)"s.limit == s.pos");
                throw assertionError;
            }
            object = new byte[n14][];
            n13 = n14 * 2;
            nArray = new int[n13];
            i0 i02 = this.a;
            n11 = 0;
            while (n12 < n10) {
                f0.m(i02);
                byte[] byArray = i02.a;
                object[n11] = byArray;
                int n16 = i02.c;
                int n17 = i02.b;
                nArray[n11] = n16 = Math.min(n12 += (n16 -= n17), n10);
                n16 = n11 + n14;
                nArray[n16] = n17 = i02.b;
                n16 = 1;
                i02.d = n16;
                n11 += n16;
                i02 = i02.f;
            }
            byteString = new SegmentedByteString((byte[][])object, nArray);
        }
        return byteString;
    }

    public boolean V() {
        long l10 = this.b;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public final i0 V0(int n10) {
        i0 i02;
        int n11 = 8192;
        int n12 = 1;
        if (n10 < n12 || n10 > n11) {
            n12 = 0;
            i02 = null;
        }
        if (n12 != 0) {
            i0 i03;
            i02 = this.a;
            if (i02 == null) {
                this.a = i03 = j0.e();
                i03.g = i03;
                i03.f = i03;
            } else {
                f0.m(i02);
                i02 = i02.g;
                f0.m(i02);
                int n13 = i02.c + n10;
                if (n13 <= n11 && (n10 = (int)(i02.e ? 1 : 0)) != 0) {
                    i03 = i02;
                } else {
                    i03 = j0.e();
                    i03 = i02.c(i03);
                }
            }
            return i03;
        }
        String string2 = "unexpected capacity".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public long W() {
        block9: {
            var1_1 = this;
            var2_2 = this.S0();
            cfr_temp_0 = var2_2 - (var4_3 = 0L);
            var6_4 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var6_4 /* !! */  == false) break block9;
            var2_2 = -7;
            var7_5 = 0;
            var8_6 = 0;
            var9_7 = 0;
            var10_8 = 0.0f;
            do {
                var11_9 = var1_1.a;
                f0.m(var11_9);
                var12_10 = var11_9.a;
                var13_11 = var11_9.b;
                var14_12 = var11_9.c;
                while (true) {
                    var15_13 /* !! */  = 1;
                    var16_14 = 1.4E-45f;
                    if (var13_11 >= var14_12) ** GOTO lbl82
                    var17_15 = var12_10[var13_11];
                    var18_16 = 48;
                    if (var17_15 < var18_16) ** GOTO lbl54
                    var19_17 = 8.0E-44f;
                    var20_18 = (byte)57;
                    if (var17_15 > var20_18) ** GOTO lbl54
                    var18_16 -= var17_15;
                    var21_19 = -922337203685477580L;
                    cfr_temp_1 = var4_3 - var21_19;
                    var15_13 /* !! */  = (byte)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                    if (var15_13 /* !! */  < 0) ** GOTO lbl-1000
                    var20_18 = var9_7;
                    var19_17 = var10_8;
                    var23_20 = var11_9;
                    if (var15_13 /* !! */  != 0 || (var9_7 = (byte)((cfr_temp_2 = (var24_21 = (long)var18_16) - var2_2) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) >= 0) {
                        var4_3 *= (long)10;
                        var24_21 = var18_16;
                        var4_3 += var24_21;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var26_23 = new m();
                        var26_23 = var26_23.c1(var4_3).b1(var17_15);
                        if (var8_6 == 0) {
                            var26_23.readByte();
                        }
                        var28_28 = new StringBuilder();
                        var28_28.append("Number too large: ");
                        var26_23 = var26_23.f0();
                        var28_28.append((String)var26_23);
                        var26_23 = var28_28.toString();
                        var27_26 = new NumberFormatException((String)var26_23);
                        throw var27_26;
lbl54:
                        // 2 sources

                        var20_18 = var9_7;
                        var19_17 = var10_8;
                        var23_20 = var11_9;
                        var10_8 = 6.3E-44f;
                        var9_7 = (byte)45;
                        if (var17_15 != var9_7 || var7_5 != 0) break;
                        var29_22 = 1L;
                        var2_2 -= var29_22;
                        var8_6 = var15_13 /* !! */ ;
                    }
                    ++var13_11;
                    ++var7_5;
                    var9_7 = var20_18;
                    var10_8 = var19_17;
                    var11_9 = var23_20;
                }
                if (var7_5 != 0) {
                    var9_7 = var15_13 /* !! */ ;
                    var10_8 = var16_14;
                } else {
                    var27_27 /* !! */  = new StringBuilder();
                    var27_27 /* !! */ .append("Expected leading [0-9] or '-' character but was 0x");
                    var28_29 = j.m(var17_15);
                    var27_27 /* !! */ .append(var28_29);
                    var27_27 /* !! */  = var27_27 /* !! */ .toString();
                    var26_24 = new NumberFormatException((String)var27_27 /* !! */ );
                    throw var26_24;
lbl82:
                    // 1 sources

                    var20_18 = var9_7;
                    var19_17 = var10_8;
                    var23_20 = var11_9;
                }
                if (var13_11 == var14_12) {
                    var1_1.a = var11_9 = var23_20.b();
                    j0.d(var23_20);
                    continue;
                }
                var11_9 = var23_20;
                var23_20.b = var13_11;
            } while (var9_7 == 0 && (var11_9 = var1_1.a) != null);
            var2_2 = this.S0();
            var24_21 = var7_5;
            var1_1.O0(var2_2 -= var24_21);
            if (var8_6 == 0) {
                var4_3 = -var4_3;
            }
            return var4_3;
        }
        var26_25 = new EOFException();
        throw var26_25;
    }

    public m W0(ByteString byteString) {
        f0.p(byteString, "byteString");
        int n10 = byteString.size();
        byteString.write$okio(this, 0, n10);
        return this;
    }

    public m X0(ByteString byteString, int n10, int n11) {
        f0.p(byteString, "byteString");
        byteString.write$okio(this, n10, n11);
        return this;
    }

    public String Y(Charset charset) {
        f0.p(charset, "charset");
        long l10 = this.b;
        return this.g0(l10, charset);
    }

    public m Y0(m0 object, long l10) {
        long l11;
        long l12;
        long l13;
        String string2 = "source";
        f0.p(object, string2);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            long l14;
            l11 = object.read(this, l10);
            long l15 = l11 - (l14 = (long)-1);
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 != false) {
                l10 -= l11;
                continue;
            }
            object = new EOFException();
            throw object;
        }
        return this;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int Z() {
        block5: {
            int n10;
            long l10;
            block10: {
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                byte by2;
                block7: {
                    block9: {
                        block8: {
                            block6: {
                                long l11;
                                l10 = this.S0();
                                long l12 = l10 - (l11 = 0L);
                                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                                if (object == false) break block5;
                                by2 = this.z0(l11);
                                n15 = by2 & 0x80;
                                n14 = 1;
                                n13 = 128;
                                n10 = -3;
                                if (n15 != 0) break block6;
                                n15 = by2 & 0x7F;
                                n12 = 0;
                                n11 = n14;
                                break block7;
                            }
                            n15 = by2 & 0xE0;
                            n11 = 192;
                            if (n15 != n11) break block8;
                            n15 = by2 & 0x1F;
                            n11 = 2;
                            n12 = n13;
                            break block7;
                        }
                        n15 = by2 & 0xF0;
                        n11 = 224;
                        if (n15 != n11) break block9;
                        n15 = by2 & 0xF;
                        n11 = 3;
                        n12 = 2048;
                        break block7;
                    }
                    n15 = by2 & 0xF8;
                    n11 = 240;
                    if (n15 != n11) break block10;
                    n15 = by2 & 7;
                    n11 = 4;
                    n12 = 65536;
                }
                long l13 = this.S0();
                long l14 = n11;
                long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
                if (l15 >= 0) {
                    while (n14 < n11) {
                        l13 = n14;
                        int n16 = this.z0(l13);
                        int n17 = n16 & 0xC0;
                        if (n17 == n13) {
                            n15 <<= 6;
                            n15 |= (n16 &= 0x3F);
                            ++n14;
                            continue;
                        }
                        this.skip(l13);
                        return n10;
                    }
                    this.skip(l14);
                    int n18 = 0x10FFFF;
                    if (n15 > n18) return n10;
                    int n19 = 57343;
                    n14 = 55296;
                    if (n14 <= n15 && n19 >= n15) return n10;
                    if (n15 >= n12) return n15;
                    return n10;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("size < ");
                stringBuilder.append(n11);
                stringBuilder.append(": ");
                long l16 = this.S0();
                stringBuilder.append(l16);
                stringBuilder.append(" (to read code point prefixed 0x");
                String string2 = j.m(by2);
                stringBuilder.append(string2);
                stringBuilder.append(')');
                string2 = stringBuilder.toString();
                EOFException eOFException = new EOFException(string2);
                throw eOFException;
            }
            l10 = 1L;
            this.skip(l10);
            return n10;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public m Z0(byte[] byArray) {
        f0.p(byArray, "source");
        int n10 = byArray.length;
        return this.a1(byArray, 0, n10);
    }

    public final byte a(long l10) {
        return this.z0(l10);
    }

    public m a1(byte[] byArray, int n10, int n11) {
        Object object = "source";
        f0.p(byArray, (String)object);
        int n12 = byArray.length;
        long l10 = n12;
        long l11 = n10;
        long l12 = n11;
        j.e(l10, l11, l12);
        n11 += n10;
        while (n10 < n11) {
            n12 = 1;
            object = this.V0(n12);
            int n13 = n11 - n10;
            int n14 = ((i0)object).c;
            n14 = 8192 - n14;
            n13 = Math.min(n13, n14);
            byte[] byArray2 = ((i0)object).a;
            int n15 = ((i0)object).c;
            int n16 = n10 + n13;
            f.x1.n.W0(byArray, byArray2, n15, n10, n16);
            ((i0)object).c = n10 = ((i0)object).c + n13;
            n10 = n16;
        }
        long l13 = this.S0() + l12;
        this.O0(l13);
        return this;
    }

    public m b() {
        return this;
    }

    public ByteString b0() {
        long l10 = this.S0();
        return this.Q(l10);
    }

    public m b1(int n10) {
        int n11;
        i0 i02 = this.V0(1);
        byte[] byArray = i02.a;
        int n12 = i02.c;
        i02.c = n11 = n12 + 1;
        byArray[n12] = n10 = (int)((byte)n10);
        long l10 = this.S0() + 1L;
        this.O0(l10);
        return this;
    }

    public long c(ByteString byteString, long l10) {
        long l11 = l10;
        Object object = "bytes";
        Comparable comparable = byteString;
        f0.p(byteString, (String)object);
        int n10 = byteString.size();
        byte by2 = 0;
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            long l12 = 0L;
            long l13 = l11 - l12;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 >= 0) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            if (n10 != 0) {
                long l14;
                block18: {
                    object = this;
                    i0 i02 = this.a;
                    if (i02 != null) {
                        long l15 = this.S0() - l11;
                        long l16 = l15 == l11 ? 0 : (l15 < l11 ? -1 : 1);
                        long l17 = 1L;
                        if (l16 < 0) {
                            long l18;
                            l12 = this.S0();
                            while ((l16 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) > 0) {
                                i02 = i02.g;
                                f0.m(i02);
                                l16 = i02.c;
                                int n11 = i02.b;
                                l18 = l16 -= n11;
                                l12 -= l18;
                            }
                            if (i02 != null) {
                                long l19;
                                byte[] byArray = byteString.internalArray$okio();
                                by2 = byArray[0];
                                int n12 = byteString.size();
                                l18 = this.S0();
                                l14 = n12;
                                l18 = l18 - l14 + l17;
                                while ((l19 = l12 == l18 ? 0 : (l12 < l18 ? -1 : 1)) < 0) {
                                    int n13;
                                    int n14;
                                    byte[] byArray2 = i02.a;
                                    int n15 = i02.c;
                                    int n16 = i02.b;
                                    l17 = (long)n16 + l18 - l12;
                                    long l20 = l12;
                                    long l21 = Math.min((long)n15, l17);
                                    int n17 = (int)l21;
                                    int n18 = i02.b;
                                    l12 = (long)n18 + l11 - l20;
                                    for (n14 = (int)l12; n14 < n17; ++n14) {
                                        n13 = byArray2[n14];
                                        if (n13 != by2) continue;
                                        n13 = n14 + 1;
                                        n18 = 1;
                                        if ((n13 = (int)(h.q0.a.a0(i02, n13, byArray, n18, n12) ? 1 : 0)) == 0) continue;
                                        n13 = i02.b;
                                        l11 = n14 -= n13;
                                        l14 = l11 + l20;
                                        break block18;
                                    }
                                    n14 = i02.c;
                                    n13 = i02.b;
                                    l11 = n14 -= n13;
                                    l12 = l20 + l11;
                                    i02 = i02.f;
                                    f0.m(i02);
                                    l11 = l12;
                                }
                            }
                        } else {
                            while (true) {
                                int n19;
                                int n20 = i02.c;
                                int n21 = i02.b;
                                l14 = (long)(n20 - n21) + l12;
                                long l22 = l14 - l11;
                                if ((n20 = (int)(l22 == 0L ? 0 : (l22 < 0L ? -1 : 1))) > 0) {
                                    if (i02 == null) break;
                                    byte[] byArray = byteString.internalArray$okio();
                                    by2 = byArray[0];
                                    int n22 = byteString.size();
                                    l14 = this.S0();
                                    long l23 = n22;
                                    l14 = l14 - l23 + l17;
                                    while ((l16 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1)) < 0) {
                                        int n23;
                                        int n24;
                                        byte[] byArray3 = i02.a;
                                        int n25 = i02.c;
                                        int n26 = i02.b;
                                        long l24 = (long)n26 + l14 - l12;
                                        long l25 = l14;
                                        l14 = Math.min((long)n25, l24);
                                        n21 = (int)l14;
                                        int n27 = i02.b;
                                        l17 = (long)n27 + l11 - l12;
                                        for (n24 = (int)l17; n24 < n21; ++n24) {
                                            n23 = byArray3[n24];
                                            if (n23 == by2) {
                                                n23 = n24 + 1;
                                                n19 = 1;
                                                if ((n23 = (int)(h.q0.a.a0(i02, n23, byArray, n19, n22) ? 1 : 0)) == 0) continue;
                                                n23 = i02.b;
                                                l11 = n24 -= n23;
                                                l14 = l11 + l12;
                                                break block18;
                                            }
                                            n19 = 1;
                                        }
                                        n19 = 1;
                                        n24 = i02.c;
                                        n23 = i02.b;
                                        l11 = n24 -= n23;
                                        l12 += l11;
                                        i02 = i02.f;
                                        f0.m(i02);
                                        l11 = l12;
                                        l14 = l25;
                                    }
                                    break;
                                }
                                n19 = 1;
                                i02 = i02.f;
                                f0.m(i02);
                                l12 = l14;
                            }
                        }
                    }
                    l14 = -1;
                }
                return l14;
            }
            object = this;
            comparable = new StringBuilder();
            ((StringBuilder)comparable).append("fromIndex < 0: ");
            ((StringBuilder)comparable).append(l11);
            String string2 = ((StringBuilder)comparable).toString();
            string2 = string2.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        object = this;
        String string3 = "bytes is empty".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public m c1(long var1_1) {
        block9: {
            block7: {
                block21: {
                    block23: {
                        block22: {
                            block18: {
                                block20: {
                                    block19: {
                                        block12: {
                                            block17: {
                                                block15: {
                                                    block16: {
                                                        block13: {
                                                            block14: {
                                                                block10: {
                                                                    block11: {
                                                                        block8: {
                                                                            var3_2 = 0L;
                                                                            cfr_temp_0 = var1_1 - var3_2;
                                                                            var5_3 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                            if (var5_3 /* !! */  != false) break block8;
                                                                            var6_4 = 48;
                                                                            var7_6 = this.b1(var6_4);
                                                                            break block9;
                                                                        }
                                                                        var8_7 = 0;
                                                                        var9_8 = 1;
                                                                        if (var5_3 /* !! */  >= 0) break block10;
                                                                        cfr_temp_1 = (var1_1 = -var1_1) - var3_2;
                                                                        var5_3 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                                                                        if (var5_3 /* !! */  >= 0) break block11;
                                                                        var7_6 = this.p1("-9223372036854775808");
                                                                        break block9;
                                                                    }
                                                                    var8_7 = var9_8;
                                                                }
                                                                var10_9 = 100000000L;
                                                                var5_3 /* !! */  = var1_1 == var10_9 ? 0 : (var1_1 < var10_9 ? -1 : 1);
                                                                var12_10 = 10;
                                                                var13_11 = 1.4E-44f;
                                                                if (var5_3 /* !! */  >= 0) break block12;
                                                                var14_12 = 10000L;
                                                                cfr_temp_2 = var1_1 - var14_12;
                                                                var5_3 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                                                                if (var5_3 /* !! */  >= 0) break block13;
                                                                var14_12 = 100;
                                                                cfr_temp_3 = var1_1 - var14_12;
                                                                var5_3 /* !! */  = (long)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                                                                if (var5_3 /* !! */  >= 0) break block14;
                                                                var14_12 = 10;
                                                                cfr_temp_4 = var1_1 - var14_12;
                                                                var5_3 /* !! */  = (long)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                                                                if (var5_3 /* !! */  >= 0) {
                                                                    var9_8 = 2;
                                                                }
                                                                break block7;
                                                            }
                                                            var14_12 = 1000L;
                                                            cfr_temp_5 = var1_1 - var14_12;
                                                            var5_3 /* !! */  = (long)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
                                                            if (var5_3 /* !! */  < 0) {
                                                                var5_3 /* !! */  = 3;
                                                                var16_13 = 4.2E-45f;
                                                            } else {
                                                                var5_3 /* !! */  = 4;
                                                                var16_13 = 5.6E-45f;
                                                            }
lbl49:
                                                            // 10 sources

                                                            while (true) {
                                                                var9_8 = (int)var5_3 /* !! */ ;
                                                                break block7;
                                                                break;
                                                            }
                                                        }
                                                        var14_12 = 1000000L;
                                                        cfr_temp_6 = var1_1 - var14_12;
                                                        var5_3 /* !! */  = (long)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
                                                        if (var5_3 /* !! */  >= 0) break block15;
                                                        var14_12 = 100000L;
                                                        cfr_temp_7 = var1_1 - var14_12;
                                                        var5_3 /* !! */  = (long)(cfr_temp_7 == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1));
                                                        if (var5_3 /* !! */  >= 0) break block16;
                                                        var5_3 /* !! */  = 5;
                                                        var16_13 = 7.0E-45f;
                                                        ** GOTO lbl49
                                                    }
                                                    var5_3 /* !! */  = 6;
                                                    var16_13 = 8.4E-45f;
                                                    ** GOTO lbl49
                                                }
                                                var14_12 = 10000000L;
                                                cfr_temp_8 = var1_1 - var14_12;
                                                var5_3 /* !! */  = (long)(cfr_temp_8 == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1));
                                                if (var5_3 /* !! */  >= 0) break block17;
                                                var5_3 /* !! */  = 7;
                                                var16_13 = 9.8E-45f;
                                                ** GOTO lbl49
                                            }
                                            var5_3 /* !! */  = 8;
                                            var16_13 = 1.1E-44f;
                                            ** GOTO lbl49
                                        }
                                        var14_12 = 1000000000000L;
                                        cfr_temp_9 = var1_1 - var14_12;
                                        var5_3 /* !! */  = (long)(cfr_temp_9 == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1));
                                        if (var5_3 /* !! */  >= 0) break block18;
                                        var14_12 = 10000000000L;
                                        cfr_temp_10 = var1_1 - var14_12;
                                        var5_3 /* !! */  = (long)(cfr_temp_10 == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1));
                                        if (var5_3 /* !! */  >= 0) break block19;
                                        var14_12 = 1000000000L;
                                        cfr_temp_11 = var1_1 - var14_12;
                                        var5_3 /* !! */  = (long)(cfr_temp_11 == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1));
                                        var9_8 = var5_3 /* !! */  < 0 ? 9 : var12_10;
                                        break block7;
                                    }
                                    var14_12 = 100000000000L;
                                    cfr_temp_12 = var1_1 - var14_12;
                                    var5_3 /* !! */  = (long)(cfr_temp_12 == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1));
                                    if (var5_3 /* !! */  >= 0) break block20;
                                    var5_3 /* !! */  = 11;
                                    var16_13 = 1.5E-44f;
                                    ** GOTO lbl49
                                }
                                var5_3 /* !! */  = 12;
                                var16_13 = 1.7E-44f;
                                ** GOTO lbl49
                            }
                            var14_12 = 1000000000000000L;
                            cfr_temp_13 = var1_1 - var14_12;
                            var5_3 /* !! */  = (long)(cfr_temp_13 == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1));
                            if (var5_3 /* !! */  >= 0) break block21;
                            var14_12 = 10000000000000L;
                            cfr_temp_14 = var1_1 - var14_12;
                            var5_3 /* !! */  = (long)(cfr_temp_14 == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1));
                            if (var5_3 /* !! */  >= 0) break block22;
                            var9_8 = 13;
                            break block7;
                        }
                        var14_12 = 100000000000000L;
                        cfr_temp_15 = var1_1 - var14_12;
                        var5_3 /* !! */  = (long)(cfr_temp_15 == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1));
                        if (var5_3 /* !! */  >= 0) break block23;
                        var5_3 /* !! */  = 14;
                        var16_13 = 2.0E-44f;
                        ** GOTO lbl49
                    }
                    var5_3 /* !! */  = 15;
                    var16_13 = 2.1E-44f;
                    ** while (true)
                }
                var14_12 = 100000000000000000L;
                cfr_temp_16 = var1_1 - var14_12;
                var5_3 /* !! */  = (long)(cfr_temp_16 == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1));
                var9_8 = var5_3 /* !! */  < 0 ? ((var5_3 /* !! */  = (cfr_temp_17 = var1_1 - (var14_12 = 10000000000000000L)) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1)) < 0 ? 16 : 17) : ((var5_3 /* !! */  = (cfr_temp_18 = var1_1 - (var14_12 = 1000000000000000000L)) == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1)) < 0 ? 18 : 19);
            }
            if (var8_7 != 0) {
                ++var9_8;
            }
            var17_14 = this.V0(var9_8);
            var18_15 = var17_14.a;
            var19_16 = var17_14.c + var9_8;
            while ((var20_17 = var1_1 == var3_2 ? 0 : (var1_1 < var3_2 ? -1 : 1)) != false) {
                var21_18 = var12_10;
                var23_19 = var1_1 % var21_18;
                var25_20 = (int)var23_19;
                var26_21 = h.q0.a.Z();
                var18_15[var19_16 += -1] = var25_20 = var26_21[var25_20];
                var1_1 /= var21_18;
            }
            if (var8_7 != 0) {
                var18_15[var19_16 += -1] = var6_5 = (int)((byte)45);
            }
            var17_14.c = var6_5 = var17_14.c + var9_8;
            var1_1 = this.S0();
            var3_2 = var9_8;
            this.O0(var1_1 += var3_2);
            var7_6 = this;
        }
        return var7_6;
    }

    public void close() {
    }

    public m d1(long l10) {
        m m10;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            int n10 = 48;
            m10 = this.b1(n10);
        } else {
            int n11;
            object = 1;
            long l13 = l10 >>> object | l10;
            int n12 = 2;
            long l14 = l13 >>> n12;
            int n13 = 4;
            long l15 = (l13 |= l14) >>> n13;
            int n14 = 8;
            long l16 = (l13 |= l15) >>> n14;
            int n15 = 16;
            long l17 = (l13 |= l16) >>> n15;
            int n16 = 32;
            long l18 = (l13 |= l17) >>> n16;
            l13 |= l18;
            l18 = l13 >>> object & 0x5555555555555555L;
            l13 -= l18;
            l18 = l13 >>> n12;
            long l19 = 0x3333333333333333L;
            l18 &= l19;
            l13 = ((l18 += (l13 &= l19)) >>> n13) + l18 & 0xF0F0F0F0F0F0F0FL;
            l18 = l13 >>> n14;
            l15 = (l13 += l18) >>> n15;
            l13 += l15;
            l15 = 63;
            l18 = l13 & l15;
            l13 = l13 >>> n16 & l15;
            l18 += l13;
            l13 = 3;
            l18 += l13;
            l13 = n13;
            int n17 = (int)(l18 /= l13);
            i0 i02 = this.V0(n17);
            byte[] byArray = i02.a;
            n14 = i02.c;
            for (n15 = n14 + n17 - object; n15 >= n14; n15 += -1) {
                byte[] byArray2 = h.q0.a.Z();
                l17 = (long)15 & l10;
                n16 = (int)l17;
                object = byArray2[n16];
                byArray[n15] = (byte)object;
                l10 >>>= n13;
            }
            i02.c = n11 = i02.c + n17;
            l10 = this.S0();
            l11 = n17;
            this.O0(l10 += l11);
            m10 = this;
        }
        return m10;
    }

    public int e0() {
        return j.h(this.readInt());
    }

    public m e1(int n10) {
        byte by2;
        i0 i02 = this.V0(4);
        byte[] byArray = i02.a;
        int n11 = i02.c;
        int n12 = n11 + 1;
        byArray[n11] = by2 = (byte)(n10 >>> 24 & 0xFF);
        n11 = n12 + 1;
        byArray[n12] = by2 = (byte)(n10 >>> 16 & 0xFF);
        n12 = n11 + 1;
        byArray[n11] = by2 = (byte)(n10 >>> 8 & 0xFF);
        n11 = n12 + 1;
        byArray[n12] = n10 = (int)((byte)(n10 & 0xFF));
        i02.c = n11;
        long l10 = this.S0() + (long)4;
        this.O0(l10);
        return this;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean equals(Object var1_1) {
        block6: {
            var2_2 = var1_1;
            var3_3 = false;
            var4_4 = true;
            if (this == var1_1) lbl-1000:
            // 3 sources

            {
                while (true) {
                    var3_3 = var4_4;
                    break block6;
                    break;
                }
            }
            var5_5 /* !! */  = var1_1 instanceof m;
            if (!var5_5 /* !! */  || (var5_5 /* !! */  = (cfr_temp_0 = (var6_6 = this.S0()) - (var8_7 = (var2_2 = (m)var1_1).S0())) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) break block6;
            var6_6 = this.S0();
            cfr_temp_1 = var6_6 - (var8_7 = 0L);
            var5_5 /* !! */  = cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
            if (!var5_5 /* !! */ ) ** GOTO lbl-1000
            var10_8 = this.a;
            f0.m(var10_8);
            var2_2 = var2_2.a;
            f0.m(var2_2);
            var11_9 = var10_8.b;
            var12_10 = var2_2.b;
            var13_11 = var8_7;
            block1: while (true) {
                if ((var17_13 = (cfr_temp_2 = var13_11 - (var15_12 = this.S0())) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) < 0) ** break;
                ** continue;
                var17_13 = var10_8.c - var11_9;
                var18_14 = var2_2.c - var12_10;
                var17_13 = Math.min((int)var17_13, var18_14);
                var15_12 = var17_13;
                var19_15 = var8_7;
                while ((var21_16 = var19_15 == var15_12 ? 0 : (var19_15 < var15_12 ? -1 : 1)) < 0) {
                    var22_17 = var10_8.a;
                    var23_18 = var11_9 + 1;
                    var11_9 = var22_17[var11_9];
                    var22_17 = var2_2.a;
                    var24_19 = var12_10 + 1;
                    if (var11_9 != (var12_10 = var22_17[var12_10])) break block1;
                    var25_20 = 1L;
                    var19_15 += var25_20;
                    var11_9 = var23_18;
                    var12_10 = var24_19;
                }
                var27_21 = var10_8.c;
                if (var11_9 == var27_21) {
                    var10_8 = var10_8.f;
                    f0.m(var10_8);
                    var11_9 = var10_8.b;
                }
                if (var12_10 == (var27_21 = var2_2.c)) {
                    var2_2 = var2_2.f;
                    f0.m(var2_2);
                    var12_10 = var2_2.b;
                }
                var13_11 += var15_12;
            }
        }
        return var3_3;
    }

    public String f0() {
        long l10 = this.b;
        Charset charset = d.a;
        return this.g0(l10, charset);
    }

    public m f1(int n10) {
        n10 = j.h(n10);
        return this.e1(n10);
    }

    public void flush() {
    }

    public String g0(long l10, Charset comparable) {
        long l11;
        long l12;
        int n10;
        Object object = "charset";
        f0.p(comparable, (String)object);
        long l13 = 0L;
        long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        n10 = l14 >= 0 && (n10 = (l12 = l10 - (l11 = (long)(-1 >>> 1))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0 ? 1 : 0;
        if (n10 != 0) {
            l11 = this.b;
            long l15 = l11 - l10;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 >= 0) {
                int n11;
                if (l14 == false) {
                    return "";
                }
                object = this.a;
                f0.m(object);
                n10 = ((i0)object).b;
                long l16 = (long)n10 + l10;
                int n12 = ((i0)object).c;
                long l17 = n12;
                long l18 = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
                if (l18 > 0) {
                    byte[] byArray = this.z(l10);
                    String string2 = new String(byArray, (Charset)comparable);
                    return string2;
                }
                byte[] byArray = ((i0)object).a;
                int n13 = (int)l10;
                String string3 = new String(byArray, n10, n13, (Charset)comparable);
                ((i0)object).b = n11 = ((i0)object).b + n13;
                this.b = l11 = this.b - l10;
                int n14 = ((i0)object).c;
                if (n11 == n14) {
                    i0 i02;
                    this.a = i02 = ((i0)object).b();
                    j0.d((i0)object);
                }
                return string3;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        comparable = new Comparable<Charset>();
        ((StringBuilder)comparable).append("byteCount: ");
        ((StringBuilder)comparable).append(l10);
        String string4 = ((StringBuilder)comparable).toString();
        string4 = string4.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
        throw illegalArgumentException;
    }

    public m g1(long l10) {
        byte by2;
        byte by3;
        int n10 = 8;
        i0 i02 = this.V0(n10);
        byte[] byArray = i02.a;
        int n11 = i02.c;
        int n12 = n11 + 1;
        long l11 = l10 >>> 56;
        long l12 = 255L;
        byArray[n11] = by3 = (byte)(l11 & l12);
        n11 = n12 + 1;
        byArray[n12] = by3 = (byte)(l10 >>> 48 & l12);
        n12 = n11 + 1;
        byArray[n11] = by3 = (byte)(l10 >>> 40 & l12);
        n11 = n12 + 1;
        byArray[n12] = by3 = (byte)(l10 >>> 32 & l12);
        n12 = n11 + 1;
        byArray[n11] = by3 = (byte)(l10 >>> 24 & l12);
        n11 = n12 + 1;
        byArray[n12] = by3 = (byte)(l10 >>> 16 & l12);
        n12 = n11 + 1;
        byArray[n11] = n10 = (int)((byte)(l10 >>> n10 & l12));
        n10 = n12 + 1;
        byArray[n12] = by2 = (byte)(l10 & l12);
        i02.c = n10;
        l10 = this.S0() + (long)8;
        this.O0(l10);
        return this;
    }

    public m getBuffer() {
        return this;
    }

    public m h1(long l10) {
        l10 = j.i(l10);
        return this.g1(l10);
    }

    public int hashCode() {
        int n10;
        i0 i02 = this.a;
        if (i02 != null) {
            i0 i03;
            n10 = 1;
            do {
                int n11 = i02.c;
                for (int i10 = i02.b; i10 < n11; ++i10) {
                    n10 *= 31;
                    byte[] byArray = i02.a;
                    byte by2 = byArray[i10];
                    n10 += by2;
                }
                i02 = i02.f;
                f0.m(i02);
            } while (i02 != (i03 = this.a));
        } else {
            n10 = 0;
        }
        return n10;
    }

    public long i(ByteString byteString) {
        f0.p(byteString, "bytes");
        return this.c(byteString, 0L);
    }

    public long i0(k0 k02) {
        String string2 = "sink";
        f0.p(k02, string2);
        long l10 = this.S0();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            k02.t(this, l10);
        }
        return l10;
    }

    public m i1(int n10) {
        byte by2;
        i0 i02 = this.V0(2);
        byte[] byArray = i02.a;
        int n11 = i02.c;
        int n12 = n11 + 1;
        byArray[n11] = by2 = (byte)(n10 >>> 8 & 0xFF);
        n11 = n12 + 1;
        byArray[n12] = n10 = (int)((byte)(n10 & 0xFF));
        i02.c = n11;
        long l10 = this.S0() + (long)2;
        this.O0(l10);
        return this;
    }

    public boolean isOpen() {
        return true;
    }

    public long j(byte by2, long l10) {
        return this.l(by2, l10, Long.MAX_VALUE);
    }

    public OutputStream j0() {
        m$c m$c = new m$c(this);
        return m$c;
    }

    public m j1(int n10) {
        n10 = j.j((short)n10);
        return this.i1(n10);
    }

    public void k(m object, long l10) {
        String string2 = "sink";
        f0.p(object, string2);
        long l11 = this.S0();
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (l12 >= 0) {
            ((m)object).t(this, l10);
            return;
        }
        l10 = this.S0();
        ((m)object).t(this, l10);
        object = new EOFException();
        throw object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public long k0() {
        void var5_5;
        i0 i02;
        long l10;
        long l11 = this.S0();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        boolean bl2 = false;
        Object object2 = null;
        boolean bl3 = false;
        Object object3 = null;
        long l13 = l10;
        do {
            int n10;
            long l14;
            i02 = this.a;
            f0.m(i02);
            byte[] byArray = i02.a;
            int n11 = i02.c;
            for (n10 = i02.b; n10 < n11; l13 |= l14, ++n10, ++var5_5) {
                byte by2;
                block11: {
                    byte by3;
                    int n12;
                    block10: {
                        block9: {
                            by2 = byArray[n10];
                            n12 = 48;
                            if (by2 < n12 || by2 > (by3 = (byte)57)) break block9;
                            n12 = by2 - n12;
                            break block10;
                        }
                        n12 = (byte)97;
                        if ((by2 < n12 || by2 > (by3 = (byte)102)) && (by2 < (n12 = (byte)65) || by2 > (by3 = (byte)70))) break block11;
                        n12 = by2 - n12 + 10;
                    }
                    long l15 = 0xF000000000000000L & l13;
                    by3 = (byte)(l15 == l10 ? 0 : (l15 < l10 ? -1 : 1));
                    if (by3 != 0) {
                        object2 = new m();
                        object2 = ((m)object2).d1(l13).b1(by2);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Number too large: ");
                        object2 = ((m)object2).f0();
                        stringBuilder.append((String)object2);
                        object2 = stringBuilder.toString();
                        object3 = new NumberFormatException((String)object2);
                        throw object3;
                    }
                    by2 = 4;
                    l13 <<= by2;
                    l14 = n12;
                    continue;
                }
                if (var5_5 == false) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Expected leading [0-9a-fA-F] character but was 0x");
                    String string2 = j.m(by2);
                    ((StringBuilder)object3).append(string2);
                    object3 = ((StringBuilder)object3).toString();
                    object2 = new NumberFormatException((String)object3);
                    throw object2;
                }
                bl3 = true;
                break;
            }
            if (n10 == n11) {
                i0 i03;
                this.a = i03 = i02.b();
                j0.d(i02);
                continue;
            }
            i02.b = n10;
        } while (!bl3 && (i02 = this.a) != null);
        long l16 = this.S0();
        long l17 = (long)var5_5;
        this.O0(l16 -= l17);
        return l13;
    }

    public m k1(String object, int n10, int n11, Charset charset) {
        f0.p(object, "string");
        Object object2 = "charset";
        f0.p(charset, (String)object2);
        int n12 = 1;
        int n13 = n10 >= 0 ? n12 : 0;
        if (n13 != 0) {
            n13 = n11 >= n10 ? n12 : 0;
            if (n13 != 0) {
                n13 = ((String)object).length();
                if (n11 > n13) {
                    n12 = 0;
                    object2 = null;
                }
                if (n12 != 0) {
                    object2 = d.a;
                    n12 = (int)(f0.g(charset, object2) ? 1 : 0);
                    if (n12 != 0) {
                        return this.q1((String)object, n10, n11);
                    }
                    object = ((String)object).substring(n10, n11);
                    f0.o(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.String");
                    object = ((String)object).getBytes(charset);
                    f0.o(object, "(this as java.lang.String).getBytes(charset)");
                    n10 = ((Object)object).length;
                    return this.a1((byte[])object, 0, n10);
                }
                Serializable serializable = new StringBuilder();
                serializable.append("endIndex > string.length: ");
                serializable.append(n11);
                serializable.append(" > ");
                int n14 = ((String)object).length();
                serializable.append(n14);
                object = serializable.toString();
                object = object.toString();
                serializable = new IllegalArgumentException((String)object);
                throw serializable;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex < beginIndex: ");
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(" < ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("beginIndex < 0: ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public long l(byte by2, long l10, long l11) {
        i0 i02;
        long l12;
        block14: {
            long l13;
            int n10;
            int n11;
            void var8_9;
            long l14;
            l12 = 0L;
            long l15 = l12 - l10;
            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object <= 0 && (l14 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) >= 0) {
                boolean bl2 = true;
            } else {
                boolean bl3 = false;
                i02 = null;
            }
            if (var8_9 == false) {
                CharSequence charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("size=");
                l12 = this.S0();
                ((StringBuilder)charSequence).append(l12);
                ((StringBuilder)charSequence).append(" fromIndex=");
                ((StringBuilder)charSequence).append(l10);
                ((StringBuilder)charSequence).append(" toIndex=");
                ((StringBuilder)charSequence).append(l11);
                charSequence = ((StringBuilder)charSequence).toString();
                charSequence = ((Object)charSequence).toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
                throw illegalArgumentException;
            }
            long l16 = this.S0();
            long l17 = l11 - l16;
            Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object2 > 0) {
                l11 = this.S0();
            }
            long l18 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            long l19 = -1;
            if (l18 == false) {
                return l19;
            }
            i02 = this.a;
            if (i02 == null) return l19;
            long l20 = this.S0() - l10;
            long l21 = l20 - l10;
            Object object3 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object3 < 0) {
                long l22;
                int n12;
                long l23;
                l12 = this.S0();
                while ((l23 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) > 0) {
                    i02 = i02.g;
                    f0.m(i02);
                    l23 = i02.c;
                    n12 = i02.b;
                    l20 = l23 -= n12;
                    l12 -= l20;
                }
                if (i02 == null) return l19;
                while ((l22 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) < 0) {
                    int n13;
                    byte[] byArray = i02.a;
                    long l24 = i02.c;
                    int n14 = i02.b;
                    long l25 = (long)n14 + l11 - l12;
                    l24 = Math.min(l24, l25);
                    n12 = (int)l24;
                    int n15 = i02.b;
                    long l26 = (long)n15 + l10 - l12;
                    for (n11 = (int)l26; n11 < n12; ++n11) {
                        n13 = byArray[n11];
                        if (n13 != by2) {
                            continue;
                        }
                        break block14;
                    }
                    n11 = i02.c;
                    n13 = i02.b;
                    l10 = n11 -= n13;
                    l12 += l10;
                    i02 = i02.f;
                    f0.m(i02);
                    l10 = l12;
                }
                return l19;
            }
            while (true) {
                int n16 = i02.c;
                n10 = i02.b;
                l20 = (long)(n16 -= n10) + l12;
                long l27 = l20 - l10;
                Object object4 = l27 == 0L ? 0 : (l27 < 0L ? -1 : 1);
                if (object4 > 0) break;
                i02 = i02.f;
                f0.m(i02);
                l12 = l20;
            }
            if (i02 == null) return l19;
            while ((l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) < 0) {
                int n17;
                byte[] byArray = i02.a;
                long l28 = i02.c;
                int n18 = i02.b;
                long l29 = (long)n18 + l11 - l12;
                l28 = Math.min(l28, l29);
                n10 = (int)l28;
                int n19 = i02.b;
                long l30 = (long)n19 + l10 - l12;
                for (n11 = (int)l30; n11 < n10; ++n11) {
                    n17 = byArray[n11];
                    if (n17 != by2) {
                        continue;
                    }
                    break block14;
                }
                n11 = i02.c;
                n17 = i02.b;
                l10 = n11 -= n17;
                l12 += l10;
                i02 = i02.f;
                f0.m(i02);
                l10 = l12;
            }
            return l19;
        }
        by2 = (byte)i02.b;
        long l31 = n11 -= by2;
        return l31 + l12;
    }

    public InputStream l0() {
        m$b m$b = new m$b(this);
        return m$b;
    }

    public m l1(String string2, Charset charset) {
        f0.p(string2, "string");
        f0.p(charset, "charset");
        int n10 = string2.length();
        return this.k1(string2, 0, n10, charset);
    }

    public long m(ByteString byteString) {
        f0.p(byteString, "targetBytes");
        return this.K(byteString, 0L);
    }

    public int m0(c0 object) {
        f0.p(object, "options");
        int n10 = h.q0.a.e0(this, (c0)object, false, 2, null);
        int n11 = -1;
        if (n10 == n11) {
            n10 = n11;
        } else {
            object = ((c0)object).f()[n10];
            int n12 = ((ByteString)object).size();
            long l10 = n12;
            this.skip(l10);
        }
        return n10;
    }

    public final m m1(OutputStream outputStream) {
        return m.o1(this, outputStream, 0L, 2, null);
    }

    public String n() {
        String string2;
        long l10;
        byte by2 = (byte)10;
        long l11 = this.N(by2);
        long l12 = l11 - (l10 = (long)-1);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            string2 = h.q0.a.b0(this, l11);
        } else {
            l11 = this.S0();
            long l13 = l11 - (l10 = 0L);
            by2 = (byte)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (by2 != 0) {
                l11 = this.S0();
                string2 = this.P(l11);
            } else {
                by2 = 0;
                string2 = null;
            }
        }
        return string2;
    }

    public final m n0() {
        long l10;
        m m10 = new m();
        long l11 = this.S0();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            i0 i02;
            i0 i03 = this.a;
            f0.m(i03);
            m10.a = i02 = i03.d();
            i02.g = i02;
            i02.f = i02;
            i0 i04 = i03.f;
            while (i04 != i03) {
                i0 i05 = i02.g;
                f0.m(i05);
                f0.m(i04);
                i0 i06 = i04.d();
                i05.c(i06);
                i04 = i04.f;
            }
            l11 = this.S0();
            m10.O0(l11);
        }
        return m10;
    }

    public final m n1(OutputStream outputStream, long l10) {
        long l11;
        long l12;
        f0.p(outputStream, "out");
        long l13 = this.b;
        long l14 = 0L;
        long l15 = l10;
        j.e(l13, l14, l10);
        i0 i02 = this.a;
        while ((l12 = (l11 = l10 - (l13 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            i0 i03;
            f0.m(i02);
            l12 = i02.c;
            int n10 = i02.b;
            l13 = l12 - n10;
            l13 = Math.min(l10, l13);
            l12 = (int)l13;
            byte[] byArray = i02.a;
            int n11 = i02.b;
            outputStream.write(byArray, n11, (int)l12);
            i02.b = n10 = i02.b + l12;
            l14 = this.b;
            l15 = l12;
            this.b = l14 -= l15;
            l10 -= l15;
            l12 = i02.c;
            if (n10 != l12) continue;
            this.a = i03 = i02.b();
            j0.d(i02);
            i02 = i03;
        }
        return this;
    }

    public final m o0(OutputStream outputStream) {
        return m.t0(this, outputStream, 0L, 0L, 6, null);
    }

    public String p(long l10) {
        Object object;
        block6: {
            block9: {
                String string2;
                block8: {
                    byte by2;
                    byte by3;
                    long l11;
                    long l12;
                    long l13;
                    long l14;
                    block7: {
                        l14 = 0L;
                        long l15 = l10 - l14;
                        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                        if (object2 >= 0) {
                            object2 = 1;
                        } else {
                            object2 = 0;
                            object = null;
                        }
                        if (object2 == false) break block6;
                        l14 = Long.MAX_VALUE;
                        l13 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
                        l12 = 1L;
                        if (l13 != false) {
                            l14 = l10 + l12;
                        }
                        l13 = (byte)10;
                        l11 = this.l((byte)l13, 0L, l14);
                        long l16 = -1;
                        long l17 = l11 == l16 ? 0 : (l11 < l16 ? -1 : 1);
                        if (l17 == false) break block7;
                        string2 = h.q0.a.b0(this, l11);
                        break block8;
                    }
                    l11 = this.S0();
                    long l18 = l14 - l11;
                    Object object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object3 >= 0 || (by3 = this.z0(l12 = l14 - l12)) != (by2 = (byte)13) || (by3 = this.z0(l14)) != l13) break block9;
                    string2 = h.q0.a.b0(this, l14);
                }
                return string2;
            }
            m m10 = new m();
            long l19 = this.S0();
            l19 = Math.min((long)32, l19);
            object = this;
            Object object4 = m10;
            this.s0(m10, 0L, l19);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("\\n not found: limit=");
            l10 = Math.min(this.S0(), l10);
            ((StringBuilder)object4).append(l10);
            ((StringBuilder)object4).append(" content=");
            String string3 = m10.b0().hex();
            ((StringBuilder)object4).append(string3);
            ((StringBuilder)object4).append('\u2026');
            string3 = ((StringBuilder)object4).toString();
            object = new EOFException(string3);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("limit < 0: ");
        ((StringBuilder)object).append(l10);
        String string4 = ((StringBuilder)object).toString();
        string4 = string4.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
        throw illegalArgumentException;
    }

    public final m p0(OutputStream outputStream, long l10) {
        return m.t0(this, outputStream, l10, 0L, 4, null);
    }

    public m p1(String string2) {
        f0.p(string2, "string");
        int n10 = string2.length();
        return this.q1(string2, 0, n10);
    }

    public o peek() {
        e0 e02 = new e0(this);
        return z.d(e02);
    }

    public final long q() {
        return this.b;
    }

    public final m q0(OutputStream outputStream, long l10, long l11) {
        int n10;
        String string2 = "out";
        f0.p(outputStream, string2);
        long l12 = this.b;
        long l13 = l10;
        long l14 = l11;
        j.e(l12, l10, l11);
        long l15 = 0L;
        long l16 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1);
        if (l16 == false) {
            return this;
        }
        i0 i02 = this.a;
        while (true) {
            f0.m(i02);
            n10 = i02.c;
            int n11 = i02.b;
            l14 = n10 - n11;
            long l17 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
            if (l17 < 0) break;
            l13 = n10 -= n11;
            l10 -= l13;
            i02 = i02.f;
        }
        while ((n10 = (int)(l11 == l15 ? 0 : (l11 < l15 ? -1 : 1))) > 0) {
            f0.m(i02);
            n10 = i02.b;
            int n12 = (int)((long)n10 + l10);
            l13 = Math.min((long)(i02.c - n12), l11);
            int n13 = (int)l13;
            byte[] byArray = i02.a;
            outputStream.write(byArray, n12, n13);
            l10 = n13;
            l11 -= l10;
            i02 = i02.f;
            l10 = l15;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public m q1(String charSequence, int n10, int n11) {
        f0.p(charSequence, "string");
        int n12 = 1;
        int n13 = n10 >= 0 ? n12 : 0;
        if (n13 == 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("beginIndex < 0: ");
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        n13 = n11 >= n10 ? n12 : 0;
        if (n13 == 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("endIndex < beginIndex: ");
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append(" < ");
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        n13 = ((String)charSequence).length();
        n13 = n11 <= n13 ? n12 : 0;
        if (n13 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n11);
            stringBuilder.append(" > ");
            int n14 = ((String)charSequence).length();
            stringBuilder.append(n14);
            charSequence = stringBuilder.toString();
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        while (n10 < n11) {
            long l10;
            long l11;
            int n15;
            int n16;
            int n17;
            i0 i02;
            int n18;
            n13 = ((String)charSequence).charAt(n10);
            if (n13 < (n18 = 128)) {
                i02 = this.V0(n12);
                byte[] byArray = i02.a;
                n17 = i02.c - n10;
                n16 = 8192 - n17;
                n16 = Math.min(n11, n16);
                n15 = n10 + 1;
                byArray[n10 += n17] = n13 = (int)((byte)n13);
            } else {
                int n19 = 2048;
                if (n13 < n19) {
                    n19 = 2;
                    i0 i03 = this.V0(n19);
                    byte[] byArray = i03.a;
                    n16 = i03.c;
                    byArray[n16] = n15 = (int)((byte)(n13 >> 6 | 0xC0));
                    n15 = n16 + 1;
                    byArray[n15] = n13 = (int)((byte)(n13 & 0x3F | n18));
                    i03.c = n16 += n19;
                    l11 = this.S0();
                    l10 = 2;
                    this.O0(l11 += l10);
                } else {
                    int n20;
                    int n21;
                    byte[] byArray;
                    n19 = 55296;
                    int n22 = 63;
                    if (n13 >= n19 && n13 <= (n19 = 57343)) {
                        n17 = n10 + 1;
                        if (n17 < n11) {
                            n16 = ((String)charSequence).charAt(n17);
                        } else {
                            n16 = 0;
                            byArray = null;
                        }
                        n15 = 56319;
                        if (n13 <= n15 && (n15 = 56320) <= n16 && n19 >= n16) {
                            n13 = (n13 & 0x3FF) << 10;
                            n17 = n16 & 0x3FF;
                            n13 = (n13 | n17) + 65536;
                            n19 = 4;
                            i0 i04 = this.V0(n19);
                            byArray = i04.a;
                            n15 = i04.c;
                            byArray[n15] = n21 = (int)((byte)(n13 >> 18 | 0xF0));
                            n21 = n15 + 1;
                            byArray[n21] = n20 = (int)((byte)(n13 >> 12 & n22 | n18));
                            n21 = n15 + 2;
                            byArray[n21] = n20 = (int)((byte)(n13 >> 6 & n22 | n18));
                            n21 = n15 + 3;
                            byArray[n21] = n13 = (int)((byte)(n13 & n22 | n18));
                            i04.c = n15 += n19;
                            l11 = this.S0();
                            l10 = 4;
                            this.O0(l11 += l10);
                            n10 += 2;
                            continue;
                        }
                        this.b1(n22);
                        n10 = n17;
                        continue;
                    }
                    n19 = 3;
                    i0 i05 = this.V0(n19);
                    byArray = i05.a;
                    n15 = i05.c;
                    byArray[n15] = n21 = (int)(n13 >> 12 | 0xE0);
                    n21 = n15 + 1;
                    n20 = n13 >> 6;
                    byArray[n21] = n22 = (int)((byte)(n22 & n20 | n18));
                    n22 = n15 + 2;
                    byArray[n22] = n13 = (int)((byte)(n13 & 0x3F | n18));
                    i05.c = n15 += n19;
                    l11 = this.S0();
                    l10 = 3;
                    this.O0(l11 += l10);
                }
                ++n10;
                continue;
            }
            while (n15 < n16 && (n10 = (int)((String)charSequence).charAt(n15)) < n18) {
                n13 = n15 + 1;
                byArray[n15 += n17] = n10 = (int)((byte)n10);
                n15 = n13;
            }
            n17 += n15;
            n10 = i02.c;
            n17 -= n10;
            i02.c = n10 += n17;
            l11 = this.S0();
            l10 = n17;
            this.O0(l11 += l10);
            n10 = n15;
        }
        return this;
    }

    public final m r0(m m10, long l10) {
        f0.p(m10, "out");
        long l11 = this.b - l10;
        return this.s0(m10, l10, l11);
    }

    public m r1(int n10) {
        block7: {
            block3: {
                byte by2;
                int n11;
                int n12;
                int n13;
                int n14;
                block6: {
                    byte by3;
                    int n15;
                    block5: {
                        block4: {
                            int n16;
                            block2: {
                                n14 = 128;
                                if (n10 >= n14) break block2;
                                this.b1(n10);
                                break block3;
                            }
                            n13 = 2048;
                            n12 = 63;
                            if (n10 >= n13) break block4;
                            n13 = 2;
                            i0 i02 = this.V0(n13);
                            byte[] byArray = i02.a;
                            int n17 = i02.c;
                            byArray[n17] = n16 = (int)(n10 >> 6 | 0xC0);
                            n16 = n17 + 1;
                            byArray[n16] = n10 = (int)((byte)(n10 & n12 | n14));
                            i02.c = n17 += n13;
                            long l10 = this.S0();
                            long l11 = 2;
                            this.O0(l10 += l11);
                            break block3;
                        }
                        n13 = 57343;
                        int n18 = 55296;
                        if (n18 > n10 || n13 < n10) break block5;
                        this.b1(n12);
                        break block3;
                    }
                    n13 = 65536;
                    if (n10 >= n13) break block6;
                    n13 = 3;
                    i0 i03 = this.V0(n13);
                    byte[] byArray = i03.a;
                    int n19 = i03.c;
                    byArray[n19] = n15 = (int)(n10 >> 12 | 0xE0);
                    n15 = n19 + 1;
                    byArray[n15] = by3 = (byte)(n10 >> 6 & n12 | n14);
                    n15 = n19 + 2;
                    byArray[n15] = n10 = (int)((byte)(n10 & n12 | n14));
                    i03.c = n19 += n13;
                    long l12 = this.S0();
                    long l13 = 3;
                    this.O0(l12 += l13);
                    break block3;
                }
                n13 = 0x10FFFF;
                if (n10 > n13) break block7;
                n13 = 4;
                i0 i04 = this.V0(n13);
                byte[] byArray = i04.a;
                int n20 = i04.c;
                byArray[n20] = n11 = (int)(n10 >> 18 | 0xF0);
                n11 = n20 + 1;
                byArray[n11] = by2 = (byte)(n10 >> 12 & n12 | n14);
                n11 = n20 + 2;
                byArray[n11] = by2 = (byte)(n10 >> 6 & n12 | n14);
                n11 = n20 + 3;
                byArray[n11] = n10 = (int)((byte)(n10 & n12 | n14));
                i04.c = n20 += n13;
                long l14 = this.S0();
                long l15 = 4;
                this.O0(l14 += l15);
            }
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected code point: 0x");
        String string2 = j.n(n10);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public int read(ByteBuffer object) {
        f0.p(object, "sink");
        i0 i02 = this.a;
        if (i02 != null) {
            int n10;
            int n11 = ((Buffer)object).remaining();
            int n12 = i02.c;
            int n13 = i02.b;
            n11 = Math.min(n11, n12 -= n13);
            byte[] byArray = i02.a;
            n13 = i02.b;
            ((ByteBuffer)object).put(byArray, n13, n11);
            i02.b = n10 = i02.b + n11;
            long l10 = this.b;
            long l11 = n11;
            this.b = l10 -= l11;
            n12 = i02.c;
            if (n10 == n12) {
                this.a = object = i02.b();
                j0.d(i02);
            }
            return n11;
        }
        return -1;
    }

    public int read(byte[] byArray) {
        f0.p(byArray, "sink");
        int n10 = byArray.length;
        return this.read(byArray, 0, n10);
    }

    public int read(byte[] object, int n10, int n11) {
        f0.p(object, "sink");
        int n12 = ((byte[])object).length;
        long l10 = n12;
        long l11 = n10;
        long l12 = n11;
        j.e(l10, l11, l12);
        i0 i02 = this.a;
        if (i02 != null) {
            int n13;
            int n14 = i02.c;
            int n15 = i02.b;
            n11 = Math.min(n11, n14 -= n15);
            byte[] byArray = i02.a;
            n15 = i02.b;
            int n16 = n15 + n11;
            f.x1.n.W0(byArray, object, n10, n15, n16);
            i02.b = n13 = i02.b + n11;
            long l13 = this.S0();
            l10 = n11;
            this.O0(l13 -= l10);
            n13 = i02.b;
            n10 = i02.c;
            if (n13 == n10) {
                object = i02.b();
                this.a = object;
                j0.d(i02);
            }
        } else {
            n11 = -1;
        }
        return n11;
    }

    public long read(m object, long l10) {
        String string2 = "sink";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 >= 0 ? (long)1 : (long)0;
        if (l12 != false) {
            long l13;
            long l14 = this.S0();
            long l15 = l14 - l11;
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 == false) {
                l13 = -1;
            } else {
                l11 = this.S0();
                long l16 = l10 - l11;
                object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object2 > 0) {
                    l10 = this.S0();
                }
                ((m)object).t(this, l10);
                l13 = l10;
            }
            return l13;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public byte readByte() {
        long l10;
        long l11 = this.S0();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            i0 i02 = this.a;
            f0.m(i02);
            int by2 = i02.b;
            int n10 = i02.c;
            byte[] byArray = i02.a;
            int n11 = by2 + 1;
            byte by3 = byArray[by2];
            long l13 = this.S0();
            long l14 = 1L;
            this.O0(l13 -= l14);
            if (n11 == n10) {
                i0 i03;
                this.a = i03 = i02.b();
                j0.d(i02);
            } else {
                i02.b = n11;
            }
            return by3;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public void readFully(byte[] object) {
        int n10;
        f0.p(object, "sink");
        for (int i10 = 0; i10 < (n10 = ((byte[])object).length); i10 += n10) {
            int n11;
            n10 = ((byte[])object).length - i10;
            if ((n10 = this.read((byte[])object, i10, n10)) != (n11 = -1)) {
                continue;
            }
            object = new EOFException;
            object();
            throw object;
        }
    }

    public int readInt() {
        long l10;
        long l11 = this.S0();
        long l12 = l11 - (l10 = (long)4);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            i0 i02 = this.a;
            f0.m(i02);
            int n10 = i02.b;
            int n11 = i02.c;
            long l13 = n11 - n10;
            long l14 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
            if (l14 < 0) {
                object = (this.readByte() & 0xFF) << 24;
                n10 = (this.readByte() & 0xFF) << 16;
                object = object | n10;
                n10 = (this.readByte() & 0xFF) << 8;
                object = object | n10;
                n10 = this.readByte() & 0xFF;
                object = object | n10;
            } else {
                byte[] byArray = i02.a;
                int n12 = n10 + 1;
                n10 = (byArray[n10] & 0xFF) << 24;
                int n13 = n12 + 1;
                n12 = (byArray[n12] & 0xFF) << 16;
                n10 |= n12;
                n12 = n13 + 1;
                n13 = (byArray[n13] & 0xFF) << 8;
                n10 |= n13;
                n13 = n12 + 1;
                l14 = byArray[n12] & 0xFF;
                n10 |= l14;
                l13 = this.S0() - l10;
                this.O0(l13);
                if (n13 == n11) {
                    i0 i03;
                    this.a = i03 = i02.b();
                    j0.d(i02);
                } else {
                    i02.b = n13;
                }
                object = n10;
            }
            return (int)object;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public long readLong() {
        long l10;
        long l11 = this.S0();
        long l12 = l11 - (l10 = (long)8);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            i0 i02 = this.a;
            f0.m(i02);
            int n10 = i02.b;
            int n11 = i02.c;
            long l13 = n11 - n10;
            long l14 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
            int n12 = 32;
            if (l14 < 0) {
                object = this.readInt();
                l11 = object;
                l10 = 0xFFFFFFFFL;
                l11 = (l11 & l10) << n12;
                n11 = this.readInt();
                long l15 = n11;
                l11 |= (l10 &= l15);
            } else {
                byte[] byArray = i02.a;
                int n13 = n10 + 1;
                long l16 = byArray[n10];
                long l17 = 255L;
                l16 = (l16 & l17) << 56;
                n10 = n13 + 1;
                long l18 = (long)byArray[n13] & l17;
                n13 = 48;
                long l19 = l16 | (l18 <<= n13);
                int n14 = n10 + 1;
                l18 = ((long)byArray[n10] & l17) << 40;
                l19 |= l18;
                n10 = n14 + 1;
                n14 = byArray[n14];
                l18 = ((long)n14 & l17) << n12;
                long l20 = l19 | l18;
                int n15 = n10 + 1;
                l18 = ((long)byArray[n10] & l17) << 24;
                l20 |= l18;
                n10 = n15 + 1;
                l16 = (long)byArray[n15] & l17;
                int n16 = 16;
                l20 |= (l16 <<= n16);
                n15 = n10 + 1;
                l18 = ((long)byArray[n10] & l17) << 8;
                n10 = n15 + 1;
                l14 = byArray[n15];
                l16 = (long)l14 & l17;
                l13 = (l20 |= l18) | l16;
                l19 = this.S0() - l10;
                this.O0(l19);
                if (n10 == n11) {
                    i0 i03;
                    this.a = i03 = i02.b();
                    j0.d(i02);
                } else {
                    i02.b = n10;
                }
                l11 = l13;
            }
            return l11;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public short readShort() {
        long l10;
        long l11 = this.S0();
        long l12 = l11 - (l10 = (long)2);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            i0 i02 = this.a;
            f0.m(i02);
            int n10 = i02.b;
            int n11 = i02.c;
            int n12 = n11 - n10;
            int n13 = 2;
            if (n12 < n13) {
                object = (this.readByte() & 0xFF) << 8;
                n10 = this.readByte() & 0xFF;
                object = (short)(object | n10);
            } else {
                byte[] byArray = i02.a;
                n13 = n10 + 1;
                n10 = (byArray[n10] & 0xFF) << 8;
                int n14 = n13 + 1;
                n12 = byArray[n13] & 0xFF;
                n10 |= n12;
                long l13 = this.S0() - l10;
                this.O0(l13);
                if (n14 == n11) {
                    i0 i03;
                    this.a = i03 = i02.b();
                    j0.d(i02);
                } else {
                    i02.b = n14;
                }
                object = (short)n10;
            }
            return (short)object;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public boolean request(long l10) {
        long l11 = this.b;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean s(long l10, ByteString byteString) {
        f0.p(byteString, "bytes");
        int n10 = byteString.size();
        return this.x(l10, byteString, 0, n10);
    }

    public final m s0(m m10, long l10, long l11) {
        String string2 = "out";
        f0.p(m10, string2);
        long l12 = this.S0();
        long l13 = l10;
        long l14 = l11;
        j.e(l12, l10, l11);
        long l15 = 0L;
        long l16 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1);
        if (l16 != false) {
            int n10;
            int n11;
            long l17 = m10.S0() + l11;
            m10.O0(l17);
            i0 i02 = this.a;
            while (true) {
                f0.m(i02);
                n11 = i02.c;
                n10 = i02.b;
                l14 = n11 - n10;
                long l18 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
                if (l18 < 0) break;
                l13 = n11 -= n10;
                l10 -= l13;
                i02 = i02.f;
            }
            while ((n11 = (int)(l11 == l15 ? 0 : (l11 < l15 ? -1 : 1))) > 0) {
                f0.m(i02);
                i0 i03 = i02.d();
                n10 = i03.b;
                int n12 = (int)l10;
                i03.b = n10 += n12;
                n12 = (int)l11;
                n10 += n12;
                n12 = i03.c;
                i03.c = n12 = Math.min(n10, n12);
                i0 i04 = m10.a;
                if (i04 == null) {
                    i03.g = i03;
                    i03.f = i03;
                    m10.a = i03;
                } else {
                    f0.m(i04);
                    i04 = i04.g;
                    f0.m(i04);
                    i04.c(i03);
                }
                n12 = i03.c;
                int n13 = i03.b;
                l10 = n12 -= n13;
                l11 -= l10;
                i02 = i02.f;
                l10 = l15;
            }
        }
        return this;
    }

    public void skip(long l10) {
        long l11;
        long l12;
        long l13;
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            i0 i02 = this.a;
            if (i02 != null) {
                i0 i03;
                int n10 = i02.c;
                int n11 = i02.b;
                long l14 = n10 - n11;
                l14 = Math.min(l10, l14);
                n10 = (int)l14;
                long l15 = this.S0();
                long l16 = n10;
                this.O0(l15 -= l16);
                l10 -= l16;
                i02.b = n11 = i02.b + n10;
                n10 = i02.c;
                if (n11 != n10) continue;
                this.a = i03 = i02.b();
                j0.d(i02);
                continue;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
    }

    public void t(m object, long l10) {
        i0 i02;
        int n10;
        f0.p(object, "source");
        i0 i03 = null;
        if (object != this) {
            n10 = 1;
        } else {
            n10 = 0;
            i02 = null;
        }
        if (n10 != 0) {
            long l11;
            long l12;
            long l13 = ((m)object).S0();
            long l14 = 0L;
            j.e(l13, l14, l10);
            while ((n10 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                i0 i04;
                i02 = ((m)object).a;
                f0.m(i02);
                n10 = i02.c;
                i0 i05 = ((m)object).a;
                f0.m(i05);
                int n11 = i05.b;
                l11 = n10 - n11;
                n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n10 < 0) {
                    i02 = this.a;
                    if (i02 != null) {
                        f0.m(i02);
                        i02 = i02.g;
                    } else {
                        n10 = 0;
                        i02 = null;
                    }
                    if (i02 != null && (n11 = (int)(i02.e ? 1 : 0)) != 0) {
                        n11 = i02.c;
                        l13 = (long)n11 + l10;
                        int n12 = i02.d;
                        if (n12 != 0) {
                            n12 = 0;
                            i04 = null;
                        } else {
                            n12 = i02.b;
                        }
                        l14 = n12;
                        l13 -= l14;
                        n12 = 8192;
                        l14 = n12;
                        n11 = (int)(l13 == l14 ? 0 : (l13 < l14 ? -1 : 1));
                        if (n11 <= 0) {
                            i03 = ((m)object).a;
                            f0.m(i03);
                            n11 = (int)l10;
                            i03.g(i02, n11);
                            long l15 = ((m)object).S0() - l10;
                            ((m)object).O0(l15);
                            l15 = this.S0() + l10;
                            this.O0(l15);
                            break;
                        }
                    }
                    i02 = ((m)object).a;
                    f0.m(i02);
                    n11 = (int)l10;
                    ((m)object).a = i02 = i02.e(n11);
                }
                i02 = ((m)object).a;
                f0.m(i02);
                n11 = i02.c;
                int n13 = i02.b;
                l13 = n11 -= n13;
                ((m)object).a = i04 = i02.b();
                i04 = this.a;
                if (i04 == null) {
                    this.a = i02;
                    i02.g = i02;
                    i02.f = i02;
                } else {
                    f0.m(i04);
                    i04 = i04.g;
                    f0.m(i04);
                    i02 = i04.c(i02);
                    i02.a();
                }
                l14 = ((m)object).S0() - l13;
                ((m)object).O0(l14);
                l14 = this.S0() + l13;
                this.O0(l14);
                l10 -= l13;
            }
            return;
        }
        String string2 = "source == this".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public o0 timeout() {
        return o0.d;
    }

    public String toString() {
        return this.T0().toString();
    }

    public long v(m0 m02) {
        String string2 = "source";
        f0.p(m02, string2);
        long l10 = 0L;
        while (true) {
            long l11;
            int n10 = 8192;
            long l12 = n10;
            long l13 = (l12 = m02.read(this, l12)) - (l11 = (long)-1);
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object == false) {
                return l10;
            }
            l10 += l12;
        }
    }

    public String w() {
        return this.p(Long.MAX_VALUE);
    }

    public int write(ByteBuffer byteBuffer) {
        int n10;
        int n11;
        String string2 = "source";
        f0.p(byteBuffer, string2);
        for (int i10 = n10 = byteBuffer.remaining(); i10 > 0; i10 -= n11) {
            int n12;
            int n13 = 1;
            i0 i02 = this.V0(n13);
            n11 = i02.c;
            n11 = 8192 - n11;
            n11 = Math.min(i10, n11);
            byte[] byArray = i02.a;
            int n14 = i02.c;
            byteBuffer.get(byArray, n14, n11);
            i02.c = n12 = i02.c + n11;
        }
        long l10 = this.b;
        long l11 = n10;
        this.b = l10 += l11;
        return n10;
    }

    public boolean x(long l10, ByteString byteString, int n10, int n11) {
        boolean bl2;
        block3: {
            long l11;
            long l12;
            long l13;
            String string2 = "bytes";
            f0.p(byteString, string2);
            long l14 = 0L;
            long l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
            bl2 = false;
            if (l15 >= 0 && n10 >= 0 && n11 >= 0 && (l15 = (l13 = (l12 = this.S0() - l10) - (l11 = (long)n11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0 && (l15 = (long)(byteString.size() - n10)) >= n11) {
                string2 = null;
                for (l15 = (long)0; l15 < n11; ++l15) {
                    l12 = (long)l15 + l10;
                    byte by2 = this.z0(l12);
                    int n12 = n10 + l15;
                    if (by2 == (n12 = (int)byteString.getByte(n12))) {
                        continue;
                    }
                    break block3;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    public m x0() {
        return this;
    }

    public m y0() {
        return this;
    }

    public byte[] z(long l10) {
        StringBuilder stringBuilder;
        long l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l11 = l10 - (l12 = (long)(-1 >>> 1))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            object = 1;
        } else {
            object = 0;
            stringBuilder = null;
        }
        if (object != false) {
            l12 = this.S0();
            long l14 = l12 - l10;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object >= 0) {
                byte[] byArray = new byte[(int)l10];
                this.readFully(byArray);
                return byArray;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount: ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        string2 = string2.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final byte z0(long l10) {
        int n10;
        long l11 = this.S0();
        long l12 = 1L;
        j.e(l11, l10, l12);
        i0 i02 = this.a;
        if (i02 != null) {
            long l13 = this.S0() - l10;
            long l14 = l13 - l10;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object < 0) {
                long l15;
                l13 = this.S0();
                while ((l15 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1)) > 0) {
                    i02 = i02.g;
                    f0.m(i02);
                    l15 = i02.c;
                    int n11 = i02.b;
                    long l16 = l15 -= n11;
                    l13 -= l16;
                }
                f0.m(i02);
                byte[] byArray = i02.a;
                int n12 = i02.b;
                l12 = (long)n12 + l10 - l13;
                n10 = (int)l12;
                return (byte)byArray[n10];
            }
            l13 = 0L;
            while (true) {
                int n13 = i02.c;
                int n14 = i02.b;
                long l17 = (long)(n13 -= n14) + l13;
                long l18 = l17 - l10;
                Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object2 > 0) {
                    f0.m(i02);
                    byte[] byArray = i02.a;
                    int n15 = i02.b;
                    l12 = (long)n15 + l10 - l13;
                    n10 = (int)l12;
                    return (byte)byArray[n10];
                }
                i02 = i02.f;
                f0.m(i02);
                l13 = l17;
            }
        }
        i02 = null;
        long l19 = -1;
        f0.m(null);
        byte[] byArray = null.a;
        int n16 = null.b;
        l12 = (long)n16 + l10 - l19;
        n10 = (int)l12;
        return (byte)byArray[n10];
    }
}

