/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.q1;
import g.h0.d;
import g.h0.l.g;
import g.s;
import h.m;
import h.m0;
import h.o;
import h.o0;
import java.io.EOFException;
import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class g$c
implements m0 {
    private final m a;
    private final m b;
    private s c;
    private boolean d;
    private final long e;
    private boolean f;
    public final /* synthetic */ g g;

    public g$c(g object, long l10, boolean bl2) {
        this.g = object;
        this.e = l10;
        this.f = bl2;
        this.a = object = new m();
        this.b = object = new m();
    }

    private final void n0(long l10) {
        g g10 = this.g;
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(g10))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object = Thread.currentThread();
            f0.o(object, "Thread.currentThread()");
            object = ((Thread)object).getName();
            charSequence.append((String)object);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(g10);
            charSequence = charSequence.toString();
            AssertionError assertionError = new AssertionError(charSequence);
            throw assertionError;
        }
        this.g.h().l1(l10);
    }

    public final m B() {
        return this.a;
    }

    public final s C() {
        return this.c;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void D(o object, long l10) {
        long l11;
        void var2_2;
        void cfr_temp_0;
        void var10_11;
        f0.p(object, "source");
        g g10 = this.g;
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(g10))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            stringBuilder.append((String)object2);
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(g10);
            String string2 = stringBuilder.toString();
            object = new AssertionError((Object)string2);
            throw object;
        }
        while ((var10_11 = (cfr_temp_0 = var2_2 - (l11 = 0L)) == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1)) > 0) {
            m m10;
            long l12;
            Object object3;
            long l13;
            Object object4 = this.g;
            // MONITORENTER : object4
            Object object5 = this.f;
            m m11 = this.b;
            long l14 = m11.S0() + var2_2;
            long l15 = this.e;
            Object object6 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
            int n10 = 1;
            if (object6 > 0) {
                object6 = n10;
            } else {
                object6 = 0;
                m11 = null;
            }
            // MONITOREXIT : object4
            if (object6 != false) {
                object.skip((long)var2_2);
                object = this.g;
                ErrorCode errorCode = ErrorCode.FLOW_CONTROL_ERROR;
                ((g)object).f(errorCode);
                return;
            }
            if (object5) {
                object.skip((long)var2_2);
                return;
            }
            object4 = this.a;
            long l16 = object.read((m)object4, (long)var2_2);
            long l17 = l16 - (l13 = (long)-1);
            object6 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object6 == false) {
                object = new EOFException();
                throw object;
            }
            var2_2 -= l16;
            object4 = this.g;
            // MONITORENTER : object4
            object5 = this.d;
            if (object5) {
                object3 = this.a;
                l12 = ((m)object3).S0();
                m10 = this.a;
                m10.B();
            } else {
                object3 = this.b;
                l12 = ((m)object3).S0();
                long l18 = l12 - l11;
                object5 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object5) {
                    n10 = 0;
                    m10 = null;
                }
                object3 = this.b;
                m11 = this.a;
                ((m)object3).v(m11);
                if (n10 != 0) {
                    object3 = this.g;
                    if (object3 == null) {
                        String string3 = "null cannot be cast to non-null type java.lang.Object";
                        object = new NullPointerException(string3);
                        throw object;
                    }
                    object3.notifyAll();
                }
                l12 = l11;
            }
            // MONITOREXIT : object4
            Object object7 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
            if (object7 <= 0) continue;
            this.n0(l12);
        }
    }

    public final void E(boolean bl2) {
        this.d = bl2;
    }

    public final void O(boolean bl2) {
        this.f = bl2;
    }

    public final void S(s s10) {
        this.c = s10;
    }

    public final boolean a() {
        return this.d;
    }

    public void close() {
        g g10 = this.g;
        synchronized (g10) {
            Object object;
            block11: {
                boolean bl2 = true;
                this.d = bl2;
                object = this.b;
                long l10 = ((m)object).S0();
                Object object2 = this.b;
                ((m)object2).B();
                object2 = this.g;
                if (object2 == null) break block11;
                object2.notifyAll();
                object2 = q1.a;
                long l11 = 0L;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 > 0) {
                    this.n0(l10);
                }
                this.g.b();
                return;
            }
            String string2 = "null cannot be cast to non-null type java.lang.Object";
            object = new NullPointerException(string2);
            throw object;
        }
    }

    public final boolean h() {
        return this.f;
    }

    public final m q() {
        return this.b;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long read(m var1_1, long var2_2) {
        var4_3 = this;
        var5_4 = var1_1;
        var6_6 = var2_2;
        var8_7 = "sink";
        f0.p(var1_1, (String)var8_7);
        var9_8 = 0L;
        var11_9 = var2_2 == var9_8 ? 0 : (var2_2 < var9_8 ? -1 : 1);
        if (var11_9 >= 0) {
            var11_9 = 1;
        } else {
            var11_9 = 0;
            var12_10 = null;
        }
        if (var11_9 == false) {
            var5_4 = new StringBuilder();
            var5_4.append("byteCount < 0: ");
            var5_4.append(var6_6);
            var5_4 = var5_4.toString();
            var5_4 = var5_4.toString();
            var33_28 = new IllegalArgumentException((String)var5_4);
            throw var33_28;
        }
        while (true) {
            var11_9 = 0;
            var12_10 = null;
            var13_11 = var4_3.g;
            synchronized (var13_11) {
                block21: {
                    var14_12 = var4_3.g;
                    var14_12 = var14_12.n();
                    var14_12.v();
                    var14_12 = var4_3.g;
                    var14_12 = var14_12.i();
                    if (var14_12 != null) {
                        var12_10 = var4_3.g;
                        if ((var12_10 = var12_10.j()) == null) {
                            var14_12 = var4_3.g;
                            var14_12 = var14_12.i();
                            f0.m(var14_12);
                            var12_10 = new StreamResetException((ErrorCode)var14_12);
                        }
                    }
                    if ((var15_13 = var4_3.d) != 0) ** break block20
                    var14_12 = var4_3.b;
                    var16_14 = var14_12.S0();
                    var15_13 = var16_14 == var9_8 ? 0 : (var16_14 < var9_8 ? -1 : 1);
                    var18_15 = -1;
                    if (var15_13 <= 0) break block21;
                    var14_12 = var4_3.b;
                    var20_16 = var14_12.S0();
                    var20_16 = Math.min(var6_6, var20_16);
                    var20_16 = var14_12.read((m)var5_4, var20_16);
                    var14_12 = var4_3.g;
                    var22_17 = var14_12.m();
                    var9_8 = var22_17 + var20_16;
                    var14_12.E(var9_8);
                    var8_7 = var4_3.g;
                    var9_8 = var8_7.m();
                    var14_12 = var4_3.g;
                    var22_17 = var14_12.l();
                    var9_8 -= var22_17;
                    if (var12_10 == null) {
                        var14_12 = var4_3.g;
                        var14_12 = var14_12.h();
                        var14_12 = var14_12.F0();
                        var15_13 = var14_12.e();
                        var24_18 = var15_13 /= 2;
                        cfr_temp_0 = var9_8 - var24_18;
                        var26_19 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                        if (var26_19 /* !! */  >= 0) {
                            var27_20 = var4_3.g;
                            var27_20 = var27_20.h();
                            var28_21 = var4_3.g;
                            var29_22 = var28_21.k();
                            var27_20.t1(var29_22, var9_8);
                            var8_7 = var4_3.g;
                            var24_18 = var8_7.m();
                            var8_7.D(var24_18);
                        }
                    }
                    ** GOTO lbl88
                }
                var30_23 = var4_3.f;
                if (!var30_23 && var12_10 == null) {
                    var8_7 = var4_3.g;
                    var8_7.J();
                    var20_16 = var18_15;
                    var30_23 = true;
                } else {
                    var20_16 = var18_15;
lbl88:
                    // 2 sources

                    var30_23 = false;
                    var8_7 = null;
                }
                var31_24 = var4_3.g;
                var31_24 = var31_24.n();
                var31_24.D();
                var31_24 = q1.a;
                if (!var30_23) break;
            }
            var9_8 = 0L;
        }
        var32_25 /* !! */  = (long)(var20_16 == var18_15 ? 0 : (var20_16 < var18_15 ? -1 : 1));
        if (var32_25 /* !! */  != false) {
            var4_3.n0(var20_16);
            return var20_16;
        }
        if (var12_10 == null) {
            return var18_15;
        }
        f0.m(var12_10);
        throw var12_10;
        {
            try {
                var33_26 = "stream closed";
                var5_4 = new IOException(var33_26);
                throw var5_4;
            }
            catch (Throwable var5_5) {
                var33_27 = var4_3.g;
                var33_27 = var33_27.n();
                var33_27.D();
                throw var5_5;
            }
        }
    }

    public o0 timeout() {
        return this.g.n();
    }
}

