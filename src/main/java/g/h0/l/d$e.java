/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.s.a;
import f.h2.t.f0;
import f.q1;
import g.h0.h.c;
import g.h0.l.d;
import g.h0.l.d$e$a;
import g.h0.l.d$e$b;
import g.h0.l.d$e$c;
import g.h0.l.d$e$d;
import g.h0.l.f;
import g.h0.l.f$c;
import g.h0.l.g;
import g.h0.l.k;
import g.s;
import h.o;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;

public final class d$e
implements f$c,
a {
    private final f a;
    public final /* synthetic */ d b;

    public d$e(d d10, f f10) {
        f0.p(f10, "reader");
        this.b = d10;
        this.a = f10;
    }

    public void a(boolean bl2, k k10) {
        f0.p(k10, "settings");
        c c10 = d.p0(this.b);
        Object object = new StringBuilder();
        String string2 = this.b.B0();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" applyAndAckSettings");
        String string3 = ((StringBuilder)object).toString();
        boolean bl3 = true;
        object = new d$e$d(string3, bl3, string3, bl3, this, bl2, k10);
        c10.n((g.h0.h.a)object, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(boolean bl2, int c10, int n10, List list) {
        f0.p(list, "headerBlock");
        Object object = this.b;
        int n11 = ((d)object).Z0(c10);
        if (n11 != 0) {
            this.b.V0(c10, list, bl2);
            return;
        }
        d d10 = this.b;
        synchronized (d10) {
            d$e$b d$e$b;
            Object object2;
            object = this.b;
            g g10 = ((d)object).L0(c10);
            if (g10 != null) {
                object = q1.a;
                // MONITOREXIT @DISABLED, blocks:[4, 8] lbl13 : MonitorExitStatement: MONITOREXIT : var7_7
                object = g.h0.d.X(list);
                g10.z((s)object, bl2);
                return;
            }
            object = this.b;
            n11 = d.q0((d)object);
            if (n11 != 0) {
                return;
            }
            object = this.b;
            n11 = ((d)object).C0();
            if (c10 <= n11) {
                return;
            }
            n11 = c10 % 2;
            Object object3 = this.b;
            int n13 = ((d)object3).E0();
            n13 = n13 % 2;
            if (n11 == n13) {
                return;
            }
            Object object4 = g.h0.d.X(list);
            d d11 = this.b;
            String string2 = null;
            object = object2;
            char c11 = c10;
            object2 = new g(c10, d11, false, bl2, (s)object4);
            object = this.b;
            ((d)object).c1(c10);
            object = this.b;
            object = ((d)object).M0();
            object3 = (int)c10;
            object.put(object3, object2);
            object = this.b;
            object = d.n0((d)object);
            c c12 = ((g.h0.h.d)object).j();
            object = new StringBuilder();
            object3 = this.b;
            object3 = ((d)object3).B0();
            ((StringBuilder)object).append((String)object3);
            char c13 = '[';
            ((StringBuilder)object).append(c13);
            ((StringBuilder)object).append((int)c10);
            object3 = "] onStream";
            ((StringBuilder)object).append((String)object3);
            string2 = ((StringBuilder)object).toString();
            boolean bl3 = true;
            object = d$e$b;
            object3 = string2;
            boolean bl4 = bl3;
            object4 = object2;
            object2 = this;
            bl3 = bl2;
            d$e$b = new d$e$b(string2, bl4, string2, bl4, (g)object4, this, g10, c10, list, bl2);
            long l10 = 0L;
            c12.n(d$e$b, l10);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void c(int n10, long l10) {
        if (n10 == 0) {
            d d10 = this.b;
            synchronized (d10) {
                Object object;
                block14: {
                    d d11 = this.b;
                    long l11 = d11.N0() + l10;
                    d.w0(d11, l11);
                    object = this.b;
                    if (object == null) break block14;
                    object.notifyAll();
                    object = q1.a;
                    return;
                }
                String string2 = "null cannot be cast to non-null type java.lang.Object";
                object = new NullPointerException(string2);
                throw object;
            }
        }
        d d12 = this.b;
        g g10 = d12.L0(n10);
        if (g10 == null) return;
        synchronized (g10) {
            g10.a(l10);
            q1 q12 = q1.a;
            return;
        }
    }

    public void d(int n10, String string2, ByteString byteString, String string3, int n11, long l10) {
        f0.p(string2, "origin");
        f0.p(byteString, "protocol");
        f0.p(string3, "host");
    }

    public void e(int n10, int n11, List list) {
        f0.p(list, "requestHeaders");
        this.b.W0(n11, list);
    }

    public void f() {
    }

    public void g(boolean bl2, int n10, o o10, int n11) {
        f0.p(o10, "source");
        Object object = this.b;
        boolean bl3 = ((d)object).Z0(n10);
        if (bl3) {
            this.b.U0(n10, o10, n11, bl2);
            return;
        }
        object = this.b.L0(n10);
        if (object == null) {
            d d10 = this.b;
            object = ErrorCode.PROTOCOL_ERROR;
            d10.s1(n10, (ErrorCode)((Object)object));
            d10 = this.b;
            long l10 = n11;
            d10.l1(l10);
            o10.skip(l10);
            return;
        }
        ((g)object).y(o10, n11);
        if (bl2) {
            s s10 = g.h0.d.b;
            n10 = 1;
            ((g)object).z(s10, n10 != 0);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i(boolean bl2, int n10, int n11) {
        if (!bl2) {
            c c10 = d.p0(this.b);
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = this.b.B0();
            stringBuilder.append(string2);
            string2 = " ping";
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            long l10 = 0L;
            boolean bl3 = true;
            d$e$c d$e$c = new d$e$c(string3, bl3, string3, bl3, this, n10, n11);
            c10.n(d$e$c, l10);
            return;
        }
        d d10 = this.b;
        synchronized (d10) {
            n11 = 1;
            long l11 = 1L;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    Object object;
                    n11 = 3;
                    if (n10 == n11) {
                        object = this.b;
                        long l12 = d.h((d)object) + l11;
                        d.r0((d)object, l12);
                        object = this.b;
                        if (object == null) {
                            String string4 = "null cannot be cast to non-null type java.lang.Object";
                            object = new NullPointerException(string4);
                            throw object;
                        }
                        object.notifyAll();
                    }
                    object = q1.a;
                } else {
                    d d11 = this.b;
                    long l13 = d.C(d11) + l11;
                    d.s0(d11, l13);
                }
            } else {
                d d12 = this.b;
                long l14 = d.E(d12) + l11;
                d.u0(d12, l14);
            }
            return;
        }
    }

    public void j(int n10, int n11, int n12, boolean bl2) {
    }

    public void k(int n10, ErrorCode errorCode) {
        f0.p((Object)errorCode, "errorCode");
        d d10 = this.b;
        boolean bl2 = d10.Z0(n10);
        if (bl2) {
            this.b.X0(n10, errorCode);
            return;
        }
        d10 = this.b;
        g g10 = d10.a1(n10);
        if (g10 != null) {
            g10.A(errorCode);
        }
    }

    public void l(int n10, ErrorCode object, ByteString object2) {
        String string2 = "errorCode";
        f0.p(object, string2);
        f0.p(object2, "debugData");
        ((ByteString)object2).size();
        object = this.b;
        synchronized (object) {
            block14: {
                d d10 = this.b;
                Map map = d10.M0();
                Collection collection = map.values();
                string2 = null;
                g[] gArray = new g[]{};
                g[] gArray2 = collection.toArray(gArray);
                if (gArray2 == null) break block14;
                g[] gArray3 = gArray2;
                d d11 = this.b;
                int n11 = 1;
                d.v0(d11, n11 != 0);
                q1 q12 = q1.a;
                for (g g10 : gArray3) {
                    n11 = g10.k();
                    if (n11 <= n10 || (n11 = (int)(g10.v() ? 1 : 0)) == 0) continue;
                    Object object3 = ErrorCode.REFUSED_STREAM;
                    g10.A((ErrorCode)((Object)object3));
                    object3 = this.b;
                    int n12 = g10.k();
                    ((d)object3).a1(n12);
                }
                return;
            }
            String string3 = "null cannot be cast to non-null type kotlin.Array<T>";
            try {
                NullPointerException nullPointerException = new NullPointerException(string3);
                throw nullPointerException;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public final void m(boolean var1_1, k var2_2) {
        var3_3 = this;
        var4_4 = var2_2;
        f0.p(var2_2, "settings");
        var5_10 = new Ref$LongRef();
        var6_11 = new Ref$ObjectRef();
        var7_12 = new Ref$ObjectRef();
        var8_13 = this.b;
        var9_14 = var8_13.P0();
        synchronized (var9_14) {
            var10_15 = this.b;
            ** synchronized (var10_15)
lbl-1000:
            // 1 sources

            {
                block64: {
                    block63: {
                        block61: {
                            block60: {
                                block59: {
                                    var8_13 = this.b;
                                    var8_13 = var8_13.G0();
                                    if (var1_1 == 0) break block59;
                                    var11_16 = var2_2;
                                    break block60;
                                }
                                var11_16 = new k();
                                var11_16.j((k)var8_13);
                                var11_16.j(var2_2);
                            }
                            var7_12.element = var11_16;
                            var12_17 = var11_16.e();
                            var13_18 = var12_17;
                            var15_19 = var8_13.e();
                            var16_20 = var15_19;
                            var13_18 -= var16_20;
                            var5_10.element = var13_18;
                            var18_21 = 0L;
                            var15_19 = (int)(var13_18 == var18_21 ? 0 : (var13_18 < var18_21 ? -1 : 1));
                            var20_22 = 0;
                            if (var15_19 != 0) {
                                block62: {
                                    var8_13 = var3_3.b;
                                    var8_13 = var8_13.M0();
                                    var15_19 = (int)var8_13.isEmpty();
                                    if (var15_19 != 0) break block61;
                                    var8_13 = var3_3.b;
                                    var8_13 = var8_13.M0();
                                    var8_13 = var8_13.values();
                                    var11_16 = new g[]{};
                                    var8_13 = var8_13.toArray((T[])var11_16);
                                    if (var8_13 == null) break block62;
                                    break block63;
                                }
                                var8_13 = "null cannot be cast to non-null type kotlin.Array<T>";
                                var4_4 = new NullPointerException((String)var8_13);
                                throw var4_4;
                            }
                        }
                        var15_19 = 0;
                        var8_13 = null;
                    }
                    var6_11.element = var8_13;
                    var8_13 = var3_3.b;
                    var11_16 = var7_12.element;
                    var11_16 = (k)var11_16;
                    var8_13.e1((k)var11_16);
                    var8_13 = var3_3.b;
                    var21_23 = d.S((d)var8_13);
                    var8_13 = new StringBuilder();
                    var11_16 = var3_3.b;
                    var11_16 = var11_16.B0();
                    var8_13.append((String)var11_16);
                    var11_16 = " onSettings";
                    var8_13.append((String)var11_16);
                    var22_24 = var8_13.toString();
                    var23_25 = true;
                    var11_16 = var22_24;
                    var24_26 = var21_23;
                    var21_23 = var7_12;
                    var20_22 = var1_1;
                    var25_27 = var10_15;
                    var10_15 = var6_11;
                    var8_13 = new d$e$a(var22_24, var23_25, var22_24, var23_25, this, var7_12, (boolean)var1_1, var2_2, var5_10, var6_11);
                    var4_4 = var24_26;
                    var13_18 = 0L;
                    var24_26.n((g.h0.h.a)var8_13, var13_18);
                    var4_4 = q1.a;
                    // ** MonitorExit[var25_27] (shouldn't be in output)
                    try {
                        var4_4 = var3_3.b;
                        var4_4 = var4_4.P0();
                        var8_13 = var7_12.element;
                    }
                    catch (IOException var4_5) {
                        var8_13 = var3_3.b;
                        d.a((d)var8_13, var4_5);
lbl125:
                        // 2 sources

                        var4_4 = q1.a;
                    }
                    var8_13 = (k)var8_13;
                    var4_4.a((k)var8_13);
                    ** GOTO lbl125
                    var4_4 = var6_11.element;
                    var8_13 = var4_4;
                    var8_13 = var4_4;
                    if (var8_13 != null) {
                        var4_4 = var4_4;
                        f0.m(var4_4);
                        for (Object var11_16 : var4_4) {
                            synchronized (var11_16) {
                                var26_28 = var5_10.element;
                                var11_16.a(var26_28);
                            }
                        }
                    }
                    return;
                    catch (Throwable var4_7) {}
                    break block64;
                    catch (Throwable var4_8) {
                        var25_27 = var10_15;
                    }
                }
                try {
                    // ** MonitorExit[var25_27] (shouldn't be in output)
                    throw var4_4;
                }
                catch (Throwable var4_9) {
                    throw var4_9;
                }
                finally {
                }
            }
        }
    }

    public final f n() {
        return this.a;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void o() {
        void var4_9;
        Object object;
        IOException iOException;
        ErrorCode errorCode;
        block10: {
            block8: {
                block9: {
                    d d10;
                    boolean bl2;
                    errorCode = ErrorCode.INTERNAL_ERROR;
                    iOException = null;
                    object = this.a;
                    object.q(this);
                    do {
                        object = this.a;
                        d10 = null;
                    } while (bl2 = object.h(false, this));
                    object = ErrorCode.NO_ERROR;
                    try {
                        errorCode = ErrorCode.CANCEL;
                        d10 = this.b;
                        d10.y0((ErrorCode)((Object)object), errorCode, null);
                        break block8;
                    }
                    catch (IOException iOException2) {
                        break block9;
                    }
                    catch (Throwable throwable) {
                        object = errorCode;
                        break block10;
                    }
                    catch (IOException iOException3) {
                        object = errorCode;
                    }
                }
                try {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    object = this.b;
                    ((d)object).y0(errorCode, errorCode, iOException);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            g.h0.d.l(this.a);
            return;
        }
        this.b.y0((ErrorCode)((Object)object), errorCode, iOException);
        g.h0.d.l(this.a);
        throw var4_9;
    }
}

