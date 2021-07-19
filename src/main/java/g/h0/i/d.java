/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import f.q1;
import g.a;
import g.a0;
import g.e0;
import g.h0.i.e;
import g.h0.i.g;
import g.h0.i.h;
import g.i;
import g.q;
import g.t;
import g.z;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.connection.RouteSelector$b;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class d {
    private RouteSelector$b a;
    private RouteSelector b;
    private int c;
    private int d;
    private int e;
    private e0 f;
    private final g g;
    private final a h;
    private final e i;
    private final q j;

    public d(g g10, a a10, e e10, q q10) {
        f0.p(g10, "connectionPool");
        f0.p(a10, "address");
        f0.p(e10, "call");
        f0.p(q10, "eventListener");
        this.g = g10;
        this.h = a10;
        this.i = e10;
        this.j = q10;
    }

    /*
     * Unable to fully structure code
     */
    private final RealConnection b(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        block38: {
            var6_6 = this;
            var7_7 = this.i;
            var8_11 = var7_7.isCanceled();
            if (var8_11) break block38;
            var7_7 = this.i;
            var9_12 = var7_7.l();
            var8_11 = true;
            var10_13 = false;
            var11_14 = null;
            var12_15 = null;
            if (var9_12 == null) ** GOTO lbl54
            synchronized (var9_12) {
                block40: {
                    block37: {
                        block36: {
                            block39: {
                                block35: {
                                    block34: {
                                        var13_16 = var9_12.x();
                                        if (var13_16) break block34;
                                        var14_17 = var9_12.b();
                                        var14_17 = var14_17.d();
                                        var14_17 = var14_17.w();
                                        var13_16 = this.g((t)var14_17);
                                        if (!var13_16) break block34;
                                        var13_16 = false;
                                        var14_17 = null;
                                        ** GOTO lbl34
                                    }
                                    var14_17 = var6_6.i;
                                    var14_17 = var14_17.w();
lbl34:
                                    // 2 sources

                                    var15_18 = q1.a;
                                    var15_18 = var6_6.i.l();
                                    if (var15_18 == null) break block35;
                                    if (var14_17 != null) {
                                        var8_11 = false;
                                        var7_7 = null;
                                    }
                                    if (var8_11) {
                                        return var9_12;
                                    }
                                    var7_7 = "Check failed.".toString();
                                    var9_12 = new IllegalStateException((String)var7_7);
                                    throw var9_12;
                                }
                                if (var14_17 != null) {
                                    g.h0.d.n((Socket)var14_17);
                                }
                                var14_17 = var6_6.j;
                                var15_18 = var6_6.i;
                                var14_17.l((g.e)var15_18, (i)var9_12);
                                break block39;
                                finally {
                                }
                            }
                            var6_6.c = 0;
                            var6_6.d = 0;
                            var6_6.e = 0;
                            var9_12 = var6_6.g;
                            var14_17 = var6_6.h;
                            var15_18 = var6_6.i;
                            var16_19 = var9_12.a((a)var14_17, (e)var15_18, null, false);
                            if (var16_19) {
                                var7_7 = var6_6.i.l();
                                f0.m(var7_7);
                                var9_12 = var6_6.j;
                                var11_14 = var6_6.i;
                                var9_12.k((g.e)var11_14, (i)var7_7);
                                return var7_7;
                            }
                            var9_12 = var6_6.f;
                            if (var9_12 != null) {
                                f0.m(var9_12);
                                var6_6.f = null;
lbl73:
                                // 2 sources

                                while (true) {
                                    var13_16 = false;
                                    var14_17 = null;
                                    break block36;
                                    break;
                                }
                            }
                            var9_12 = var6_6.a;
                            if (var9_12 != null) {
                                f0.m(var9_12);
                                var16_19 = var9_12.b();
                                if (var16_19) {
                                    var9_12 = var6_6.a;
                                    f0.m(var9_12);
                                    var9_12 = var9_12.c();
                                    ** continue;
                                }
                            }
                            if ((var9_12 = var6_6.b) == null) {
                                var14_17 = var6_6.h;
                                var15_18 = var6_6.i.k().X();
                                var17_20 = var6_6.i;
                                var18_21 = var6_6.j;
                                var6_6.b = var9_12 = new RouteSelector((a)var14_17, (h)var15_18, (g.e)var17_20, (q)var18_21);
                            }
                            var6_6.a = var9_12 = var9_12.d();
                            var14_17 = var9_12.a();
                            var15_18 = var6_6.i;
                            var19_22 = var15_18.isCanceled();
                            if (var19_22) break block40;
                            var15_18 = var6_6.g;
                            var17_20 = var6_6.h;
                            var18_21 = var6_6.i;
                            var10_13 = var15_18.a((a)var17_20, (e)var18_21, (List)var14_17, false);
                            if (var10_13) {
                                var7_7 = var6_6.i.l();
                                f0.m(var7_7);
                                var9_12 = var6_6.j;
                                var11_14 = var6_6.i;
                                var9_12.k((g.e)var11_14, (i)var7_7);
                                return var7_7;
                            }
                            var9_12 = var9_12.c();
                        }
                        var15_18 = var6_6.g;
                        var11_14 = new RealConnection((g)var15_18, (e0)var9_12);
                        var15_18 = var6_6.i;
                        var15_18.y((RealConnection)var11_14);
                        var20_23 = var6_6.i;
                        var21_24 = var6_6.j;
                        var15_18 = var11_14;
                        var11_14.m(var1_1, var2_2, var3_3, var4_4, var5_5, var20_23, var21_24);
                        var12_15 = var6_6.i.k().X();
                        var15_18 = var11_14.b();
                        var12_15.a((e0)var15_18);
                        var12_15 = var6_6.g;
                        var15_18 = var6_6.h;
                        var17_20 = var6_6.i;
                        var8_11 = var12_15.a((a)var15_18, (e)var17_20, (List)var14_17, var8_11);
                        if (!var8_11) break block37;
                        var7_7 = var6_6.i.l();
                        f0.m(var7_7);
                        var6_6.f = var9_12;
                        g.h0.d.n(var11_14.d());
                        var9_12 = var6_6.j;
                        var11_14 = var6_6.i;
                        var9_12.k((g.e)var11_14, (i)var7_7);
                        return var7_7;
                    }
                    synchronized (var11_14) {
                        var7_7 = var6_6.g;
                        var7_7.h((RealConnection)var11_14);
                        var7_7 = var6_6.i;
                        var7_7.c((RealConnection)var11_14);
                        var7_7 = q1.a;
                        var7_7 = var6_6.j;
                        var9_12 = var6_6.i;
                        var7_7.k((g.e)var9_12, (i)var11_14);
                        return var11_14;
                    }
                    finally {
                        var6_6.i.y(null);
                    }
                }
                var7_7 = new IOException("Canceled");
                throw var7_7;
            }
        }
        var7_7 = new IOException("Canceled");
        throw var7_7;
    }

    private final RealConnection c(int n10, int n11, int n12, int n13, boolean bl2, boolean bl3) {
        while (true) {
            Object object;
            boolean bl4;
            if (bl4 = ((RealConnection)(object = this.b(n10, n11, n12, n13, bl2))).B(bl3)) {
                return object;
            }
            ((RealConnection)object).G();
            object = this.f;
            if (object != null) continue;
            object = this.a;
            bl4 = true;
            boolean bl5 = object != null ? ((RouteSelector$b)object).b() : bl4;
            if (bl5) continue;
            object = this.b;
            if (object != null) {
                bl4 = ((RouteSelector)object).b();
            }
            if (!bl4) break;
        }
        IOException iOException = new IOException("exhausted all routes");
        throw iOException;
    }

    private final e0 f() {
        RealConnection realConnection;
        int n10 = this.c;
        int n11 = 1;
        if (n10 <= n11 && (n10 = this.d) <= n11 && (n10 = this.e) <= 0 && (realConnection = this.i.l()) != null) {
            synchronized (realConnection) {
                Object object;
                block13: {
                    block12: {
                        n11 = realConnection.y();
                        if (n11 == 0) break block12;
                        return null;
                    }
                    object = realConnection.b();
                    object = ((e0)object).d();
                    object = ((a)object).w();
                    Object object2 = this.h;
                    object2 = ((a)object2).w();
                    n11 = (int)(g.h0.d.i((t)object, (t)object2) ? 1 : 0);
                    if (n11 != 0) break block13;
                    return null;
                }
                object = realConnection.b();
                return object;
            }
        }
        return null;
    }

    public final g.h0.j.d a(z z10, g.h0.j.g object) {
        f0.p(z10, "client");
        Object object2 = "chain";
        f0.p(object, (String)object2);
        int n10 = ((g.h0.j.g)object).l();
        int n11 = ((g.h0.j.g)object).n();
        int n12 = ((g.h0.j.g)object).p();
        int n13 = z10.d0();
        boolean bl2 = z10.j0();
        object2 = ((g.h0.j.g)object).o();
        object2 = ((a0)object2).m();
        Object object3 = "GET";
        boolean bl3 = f0.g(object2, object3);
        boolean bl4 = bl3 ^ true;
        object3 = this;
        object2 = this.c(n10, n11, n12, n13, bl2, bl4);
        try {
            return ((RealConnection)object2).D(z10, (g.h0.j.g)object);
        }
        catch (IOException iOException) {
            this.h(iOException);
            object = new RouteException(iOException);
            throw object;
        }
        catch (RouteException routeException) {
            object = routeException.getLastConnectException();
            this.h((IOException)object);
            throw routeException;
        }
    }

    public final a d() {
        return this.h;
    }

    public final boolean e() {
        int n10 = this.c;
        if (!(n10 || (n10 = this.d) || (n10 = this.e))) {
            return false;
        }
        Object object = this.f;
        int n11 = 1;
        if (object != null) {
            return n11 != 0;
        }
        object = this.f();
        if (object != null) {
            this.f = object;
            return n11 != 0;
        }
        object = this.a;
        if (object != null && (n10 = (int)(((RouteSelector$b)object).b() ? 1 : 0)) == n11) {
            return n11 != 0;
        }
        object = this.b;
        if (object != null) {
            return ((RouteSelector)object).b();
        }
        return n11 != 0;
    }

    public final boolean g(t object) {
        boolean bl2;
        f0.p(object, "url");
        Object object2 = this.h.w();
        int n10 = ((t)object).N();
        int n11 = ((t)object2).N();
        if (n10 == n11 && (bl2 = f0.g(object = ((t)object).F(), object2 = ((t)object2).F()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void h(IOException iOException) {
        int n10;
        f0.p(iOException, "e");
        Object var2_2 = null;
        this.f = null;
        boolean bl2 = iOException instanceof StreamResetException;
        if (bl2) {
            IOException iOException2 = iOException;
            ErrorCode errorCode = ((StreamResetException)iOException).errorCode;
            ErrorCode errorCode2 = ErrorCode.REFUSED_STREAM;
            if (errorCode == errorCode2) {
                int n11;
                this.c = n11 = this.c + 1;
                return;
            }
        }
        if ((n10 = iOException instanceof ConnectionShutdownException) != 0) {
            this.d = n10 = this.d + 1;
            return;
        }
        this.e = n10 = this.e + 1;
    }
}

