/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.e0;
import g.h0.d;
import g.h0.i.c;
import g.h0.i.e;
import g.h0.j.f;
import g.h0.j.g;
import g.h0.j.j$a;
import g.t;
import g.u;
import g.u$a;
import g.z;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Regex;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class j
implements u {
    private static final int c = 20;
    public static final j$a d;
    private final z b;

    static {
        j$a j$a;
        d = j$a = new j$a(null);
    }

    public j(z z10) {
        f0.p(z10, "client");
        this.b = z10;
    }

    private final a0 a(c0 object, String string2) {
        Object object2 = this.b;
        boolean n10 = ((z)object2).V();
        b0 b02 = null;
        if (!n10) {
            return null;
        }
        Object object3 = "Location";
        int n11 = 2;
        object2 = c0.A0((c0)object, (String)object3, null, n11, null);
        if (object2 != null && (object2 = ((t)(object3 = ((c0)object).L0().q())).W((String)object2)) != null) {
            boolean bl2;
            String string3;
            object3 = ((t)object2).X();
            boolean bl3 = f0.g(object3, string3 = ((c0)object).L0().q().X());
            if (!bl3 && !(bl3 = ((z)(object3 = this.b)).W())) {
                return null;
            }
            object3 = ((c0)object).L0().n();
            int n12 = f.b(string2);
            if (n12 != 0) {
                n12 = ((c0)object).v0();
                f f10 = f.a;
                boolean bl4 = f10.d(string2);
                int n13 = 307;
                int n14 = 308;
                bl4 = bl4 || n12 == n14 || n12 == n13;
                boolean bl5 = f10.c(string2);
                if (bl5 && n12 != n14 && n12 != n13) {
                    string2 = "GET";
                    ((a0$a)object3).p(string2, null);
                } else {
                    if (bl4) {
                        b02 = ((c0)object).L0().f();
                    }
                    ((a0$a)object3).p(string2, b02);
                }
                if (!bl4) {
                    ((a0$a)object3).t("Transfer-Encoding");
                    ((a0$a)object3).t("Content-Length");
                    string2 = "Content-Type";
                    ((a0$a)object3).t(string2);
                }
            }
            if (!(bl2 = g.h0.d.i((t)(object = ((c0)object).L0().q()), (t)object2))) {
                object = "Authorization";
                ((a0$a)object3).t((String)object);
            }
            return ((a0$a)object3).D((t)object2).b();
        }
        return null;
    }

    private final a0 b(c0 object, c object2) {
        int n10;
        Object object3;
        Proxy.Type type = null;
        if (object2 != null && (object3 = object2.h()) != null) {
            object3 = ((RealConnection)object3).b();
        } else {
            n10 = 0;
            object3 = null;
        }
        int n11 = ((c0)object).v0();
        String string2 = ((c0)object).L0().m();
        int n12 = 307;
        if (n11 != n12 && n11 != (n12 = 308)) {
            n12 = 401;
            if (n11 != n12) {
                n12 = 421;
                if (n11 != n12) {
                    int n13 = 503;
                    if (n11 != n13) {
                        n13 = 407;
                        if (n11 != n13) {
                            n13 = 408;
                            if (n11 != n13) {
                                switch (n11) {
                                    default: {
                                        return null;
                                    }
                                    case 300: 
                                    case 301: 
                                    case 302: 
                                    case 303: {
                                        return this.a((c0)object, string2);
                                    }
                                }
                            }
                            object3 = this.b;
                            n10 = (int)(((z)object3).j0() ? 1 : 0);
                            if (n10 == 0) {
                                return null;
                            }
                            object3 = ((c0)object).L0().f();
                            if (object3 != null && (n10 = (int)(((b0)object3).isOneShot() ? 1 : 0)) != 0) {
                                return null;
                            }
                            object3 = ((c0)object).I0();
                            if (object3 != null && (n10 = ((c0)object3).v0()) == n13) {
                                return null;
                            }
                            object2 = null;
                            n13 = this.f((c0)object, 0);
                            if (n13 > 0) {
                                return null;
                            }
                            return ((c0)object).L0();
                        }
                        f0.m(object3);
                        object2 = ((e0)object3).e().type();
                        type = Proxy.Type.HTTP;
                        if (object2 == type) {
                            return this.b.g0().a((e0)object3, (c0)object);
                        }
                        object = new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        throw object;
                    }
                    object3 = ((c0)object).I0();
                    if (object3 != null && (n10 = ((c0)object3).v0()) == n13) {
                        return null;
                    }
                    n13 = this.f((c0)object, -1 >>> 1);
                    if (n13 == 0) {
                        return ((c0)object).L0();
                    }
                    return null;
                }
                object3 = ((c0)object).L0().f();
                if (object3 != null && (n10 = ((b0)object3).isOneShot()) != 0) {
                    return null;
                }
                if (object2 != null && (n10 = object2.k()) != 0) {
                    object2.h().F();
                    return ((c0)object).L0();
                }
                return null;
            }
            return this.b.I().a((e0)object3, (c0)object);
        }
        return this.a((c0)object, string2);
    }

    private final boolean c(IOException iOException, boolean bl2) {
        Throwable throwable;
        boolean bl3 = iOException instanceof ProtocolException;
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        bl3 = iOException instanceof InterruptedIOException;
        boolean bl5 = true;
        if (bl3) {
            boolean bl6 = iOException instanceof SocketTimeoutException;
            if (bl6 && !bl2) {
                bl4 = bl5;
            }
            return bl4;
        }
        bl2 = iOException instanceof SSLHandshakeException;
        if (bl2 && (bl2 = (throwable = iOException.getCause()) instanceof CertificateException)) {
            return false;
        }
        boolean bl7 = iOException instanceof SSLPeerUnverifiedException;
        if (bl7) {
            return false;
        }
        return bl5;
    }

    private final boolean d(IOException iOException, e e10, a0 a02, boolean bl2) {
        boolean bl3;
        z z10 = this.b;
        boolean bl4 = z10.j0();
        if (!bl4) {
            return false;
        }
        if (bl2 && (bl3 = this.e(iOException, a02))) {
            return false;
        }
        boolean bl5 = this.c(iOException, bl2);
        if (!bl5) {
            return false;
        }
        bl5 = e10.x();
        return bl5;
    }

    private final boolean e(IOException iOException, a0 object) {
        boolean bl2;
        boolean bl3;
        if ((object = ((a0)object).f()) != null && (bl3 = ((b0)object).isOneShot()) || (bl2 = iOException instanceof FileNotFoundException)) {
            bl2 = true;
        } else {
            bl2 = false;
            iOException = null;
        }
        return bl2;
    }

    private final int f(c0 object, int n10) {
        String string2 = "Retry-After";
        int n11 = 2;
        if ((object = c0.A0((c0)object, string2, null, n11, null)) != null) {
            string2 = "\\d+";
            Regex regex = new Regex(string2);
            n10 = (int)(regex.matches((CharSequence)object) ? 1 : 0);
            if (n10 != 0) {
                object = Integer.valueOf((String)object);
                f0.o(object, "Integer.valueOf(header)");
                return (Integer)object;
            }
            return -1 >>> 1;
        }
        return n10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c0 intercept(u$a var1_1) {
        block18: {
            f0.p(var1_1, "chain");
            var1_1 = (g)var1_1;
            var2_3 = var1_1.o();
            var3_4 = var1_1.k();
            var4_5 = CollectionsKt__CollectionsKt.E();
            var5_6 = true;
            var6_7 = null;
            var7_8 = var5_6;
            var8_9 = 0;
            while (true) {
                block21: {
                    block19: {
                        block20: {
                            var3_4.i((a0)var2_3, var7_8);
                            var7_8 = var3_4.isCanceled();
                            if (var7_8) break block18;
                            var2_3 = var1_1.c((a0)var2_3);
                            if (var6_7 == null) break block19;
                            break block20;
                            {
                                catch (Throwable var1_2) {
                                    throw var1_2;
                                }
                                catch (IOException var9_11) {}
                                var12_14 = var9_11 instanceof ConnectionShutdownException;
                                if (!var12_14) {
                                    var12_14 = var5_6;
                                } else {
                                    var12_14 = false;
                                    var13_15 = null;
                                }
                                var12_14 = this.d(var9_11, var3_4, (a0)var2_3, var12_14);
                                if (!var12_14) {
                                    var1_1 = g.h0.d.j0(var9_11, (List)var4_5);
                                    throw var1_1;
                                }
                                var4_5 = CollectionsKt___CollectionsKt.p4((Collection)var4_5, var9_11);
                                break block21;
                            }
                            catch (RouteException var9_12) {
                                var13_15 = var9_12.getLastConnectException();
                                var12_14 = this.d(var13_15, var3_4, (a0)var2_3, false);
                                if (!var12_14) break;
                                var9_10 = var9_12.getFirstConnectException();
                                var4_5 = CollectionsKt___CollectionsKt.p4((Collection)var4_5, var9_10);
                                break block21;
                            }
                        }
                        var2_3 = var2_3.G0();
                        var9_10 = var6_7.G0();
                        var9_10 = var9_10.b(null);
                        var9_10 = var9_10.c();
                        var2_3 = var2_3.A((c0)var9_10);
                        var2_3 = var2_3.c();
                    }
                    if ((var9_10 = this.b((c0)(var6_7 = var2_3), (c)(var2_3 = var3_4.p()))) == null) {
                        if (var2_3 != null && (var10_16 = var2_3.l())) {
                            var3_4.A();
                        }
                        var3_4.j(false);
                        return var6_7;
                    }
                    var2_3 = var9_10.f();
                    if (var2_3 == null || (var11_13 = var2_3.isOneShot()) == 0) ** GOTO lbl-1000
                    var3_4.j(false);
                    return var6_7;
lbl-1000:
                    // 1 sources

                    {
                        var2_3 = var6_7.r0();
                        if (var2_3 != null) {
                            g.h0.d.l((Closeable)var2_3);
                        }
                        if (++var8_9 > (var11_13 = 20)) ** GOTO lbl-1000
                        var3_4.j(var5_6);
                        var2_3 = var9_10;
                        var7_8 = var5_6;
                        continue;
                    }
lbl-1000:
                    // 1 sources

                    {
                        var2_3 = new StringBuilder();
                        var4_5 = "Too many follow-up requests: ";
                        var2_3.append((String)var4_5);
                        var2_3.append(var8_9);
                        var2_3 = var2_3.toString();
                        var1_1 = new ProtocolException((String)var2_3);
                        throw var1_1;
                    }
                }
                var7_8 = false;
                var9_10 = null;
            }
            var1_1 = var9_12.getFirstConnectException();
            var1_1 = g.h0.d.j0((Exception)var1_1, (List)var4_5);
            throw var1_1;
        }
        var2_3 = "Canceled";
        var1_1 = new IOException((String)var2_3);
        throw var1_1;
    }
}

