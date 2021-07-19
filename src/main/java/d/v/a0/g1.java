/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.a0;

import android.content.Context;
import android.text.TextUtils;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import com.zhiyun.zysocket.util.SocketUtil;
import d.v.a0.b0;
import d.v.a0.b1;
import d.v.a0.c0;
import d.v.a0.d0;
import d.v.a0.e0;
import d.v.a0.e1;
import d.v.a0.e1$a;
import d.v.a0.g1$a;
import d.v.a0.g1$b;
import d.v.a0.g1$c;
import d.v.a0.g1$d;
import d.v.a0.g1$e;
import d.v.a0.g1$f;
import d.v.a0.h1;
import d.v.a0.k1;
import d.v.a0.l1;
import d.v.a0.n1.a;
import d.v.a0.n1.c;
import d.v.a0.n1.e;
import d.v.a0.n1.f;
import d.v.a0.n1.g.u;
import d.v.a0.n1.g.v;
import d.v.a0.o;
import d.v.a0.p;
import d.v.a0.q;
import d.v.a0.r;
import d.v.a0.s;
import d.v.a0.t;
import d.v.a0.w;
import d.v.a0.x;
import d.v.a0.y;
import d.v.a0.z;
import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.m;
import d.v.z.l.i;
import d.v.z.n.b;
import d.v.z.n.d;
import d.v.z.n.g;
import d.v.z.n.h;
import e.a.h0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

public class g1
extends b1 {
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 3;
    private static final int s = 4;
    private int a = 0;
    private final Context b;
    private final l1 c;
    private d.v.k0.f.e.t d;
    private final Map e;
    private final m f;
    private int g;
    private final e1 h;
    private final e.a.s0.a i;
    private final u j;
    private d.v.a0.n1.h.a k;
    private final e l;
    private a m;
    private final k n;

    public g1(Context object) {
        e1 e12;
        l1 l12;
        this.c = l12 = new l1();
        Object object2 = new HashMap();
        this.e = object2;
        this.f = object2 = d.v.k0.f.c.j.m.k();
        this.g = -1;
        this.h = e12 = new e1();
        Object object3 = new e.a.s0.a();
        this.i = object3;
        this.j = object3 = new u();
        this.l = object3 = new g1$a(this);
        Object object4 = new r(this);
        this.m = object4;
        this.n = object4 = new g1$b(this);
        this.b = object;
        l12.d((e)object3);
        ((m)object2).f((k)object4);
        super(this);
        e12.i((e1$a)object);
    }

    public static /* synthetic */ d.v.a0.n1.h.a B(g1 g12) {
        return g12.k;
    }

    public static /* synthetic */ void C(g1 g12, h1 h12, boolean bl2) {
        g12.o0(h12, bl2);
    }

    public static /* synthetic */ l1 D(g1 g12) {
        return g12.c;
    }

    public static /* synthetic */ u E(g1 g12) {
        return g12.j;
    }

    public static /* synthetic */ Map F(g1 g12) {
        return g12.e;
    }

    public static /* synthetic */ m G(g1 g12) {
        return g12.f;
    }

    private void H(g g10, Consumer consumer) {
        m m10 = this.f;
        g1$e g1$e = new g1$e(this, g10, consumer);
        m10.g(g1$e);
    }

    private e.a.z I(g g10, Consumer consumer) {
        c0 c02 = new c0(this, g10, consumer);
        return e.a.z.y1(c02);
    }

    private int J(String string2) {
        try {
            return SocketUtil.i(string2);
        }
        catch (IllegalStateException illegalStateException) {
            m.a.a.f(illegalStateException);
            return 7061;
        }
    }

    private /* synthetic */ void K(g g10, Consumer consumer, e.a.b0 b02) {
        m m10 = this.f;
        g1$d g1$d = new g1$d(this, g10, consumer, b02);
        m10.g(g1$d);
    }

    private /* synthetic */ void M(d.v.k0.f.d.a object) {
        object = this.h;
        long l10 = System.currentTimeMillis();
        ((e1)object).j(l10);
    }

    private /* synthetic */ void O(String objectArray) {
        objectArray = new Object[]{};
        m.a.a.b("\u5fc3\u8df3\u8d85\u65f6\u7684\u65ad\u5f00---------", objectArray);
        this.v();
        this.j.t();
    }

    public static /* synthetic */ void Q(c c10, h1 h12) {
        d.v.z.l.f f10 = (d.v.z.l.f)((d)h12.b()).getData();
        c10.a(h12, f10);
    }

    public static /* synthetic */ void R(d.v.a0.n1.h.a a10, h1 object) {
        object = (i)((h)((h1)object).b()).getData();
        a10.b((i)object);
    }

    private /* synthetic */ void S(b b10) {
        d.v.z.l.e e10 = k1.f(this.b);
        int n10 = this.g;
        e10.x(n10);
        ((d.v.z.l.d)b10.getData()).n(e10);
    }

    private /* synthetic */ void U(h1 h12) {
        this.p0(true);
        this.o0(h12, false);
    }

    private /* synthetic */ void W(byte[] byArray) {
        this.send(byArray);
    }

    public static /* synthetic */ Object Y(Object object, Object object2) {
        return object2;
    }

    public static /* synthetic */ void Z(Object object) {
    }

    private /* synthetic */ void a0(Throwable object) {
        int n10 = object instanceof TimeoutException;
        if (n10 != 0) {
            n10 = 1;
            object = new Object[n10];
            ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionConnect;
            object[0] = zYEnumDefine$ConnectAction;
            String string2 = "timeout action-------------:%s";
            m.a.a.b(string2, (Object[])object);
            this.v();
            object = this.j;
            ((u)object).q(zYEnumDefine$ConnectAction);
        }
    }

    public static /* synthetic */ void c0(Object object) {
    }

    private /* synthetic */ void d0(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction, Throwable object) {
        int n10 = object instanceof TimeoutException;
        if (n10 != 0) {
            n10 = 1;
            object = new Object[n10];
            object[0] = zYEnumDefine$ConnectAction;
            String string2 = "timeout action-------------:%s";
            m.a.a.b(string2, (Object[])object);
            object = ZYEnumDefine$ConnectAction.ConnectActionCanecl;
            if (zYEnumDefine$ConnectAction == object || zYEnumDefine$ConnectAction == (object = ZYEnumDefine$ConnectAction.ConnectActionDisconnect)) {
                this.v();
            }
            if (zYEnumDefine$ConnectAction == (object = ZYEnumDefine$ConnectAction.ConnectActionDisconnect)) {
                return;
            }
            object = this.j;
            ((u)object).q(zYEnumDefine$ConnectAction);
        }
    }

    private /* synthetic */ void f0(h1 h12) {
        this.o0(h12, false);
    }

    private /* synthetic */ void h0(byte[] byArray) {
        this.send(byArray);
    }

    public static /* synthetic */ Object j0(Object object, Object object2) {
        return object2;
    }

    private /* synthetic */ void k0(c c10, h1 h12) {
        boolean bl2;
        if (c10 != null && (bl2 = this.isConnected())) {
            e0 e02 = new e0(c10, h12);
            d.v.k0.g.d.j(e02, c10);
        }
    }

    private /* synthetic */ void m0(d.v.a0.n1.h.a a10, h1 h12) {
        boolean bl2;
        if (a10 != null && (bl2 = this.isConnected())) {
            x x10 = new x(a10, h12);
            d.v.k0.g.d.j(x10, a10);
        }
    }

    private void o0(h1 objectArray, boolean n10) {
        int n11;
        d.v.z.l.d d10 = (d.v.z.l.d)((b)objectArray.b()).getData();
        Object object = d10.k();
        Object object2 = d10.j();
        if (object2 != null && (n11 = TextUtils.isEmpty((CharSequence)(object = ((d.v.z.l.e)object).n()))) == 0) {
            Object object3;
            Object object4;
            n11 = 2;
            object2 = new Object[n11];
            object2[0] = object4 = d10.j();
            object4 = n10 != 0;
            int n12 = 1;
            object2[n12] = object4;
            object4 = "\u6536\u5230\u8fde\u63a5\u7684\u56de\u590d\u6216\u8005\u901a\u77e5---------\uff1a%s,isReply:%s";
            m.a.a.b((String)object4, (Object[])object2);
            if (n10 != 0) {
                object3 = new q(this);
                this.p((h1)objectArray, (Consumer)object3);
            }
            this.i.e();
            object3 = g1$f.a;
            object2 = d10.j();
            int n13 = ((Enum)object2).ordinal();
            n10 = object3[n13];
            n13 = 3;
            if (n10 != n12) {
                if (n10 != n11) {
                    int n14 = 4;
                    if (n10 != n13) {
                        if (n10 == n14) {
                            this.v();
                        }
                    } else {
                        this.v();
                        objectArray = (b)objectArray.b();
                        boolean bl2 = objectArray.a();
                        if (!bl2) {
                            this.j.t();
                            objectArray = new Object[]{};
                            object3 = "\u6536\u5230\u4e3b\u52a8\u65ad\u5f00\u8fde\u63a5\u7684\u56de\u590d-------";
                            m.a.a.b((String)object3, objectArray);
                        } else {
                            objectArray = new Object[]{};
                            object3 = "\u6536\u5230\u65ad\u5f00\u8fde\u63a5-------------";
                            m.a.a.b((String)object3, objectArray);
                        }
                        this.a = n14;
                    }
                } else {
                    this.v();
                    int n15 = this.a;
                    if (n15 == n12) {
                        objectArray = this.j;
                        object3 = d10.l();
                        objectArray.s((String)object3);
                    }
                }
            } else {
                int n16 = this.a;
                if (n16 == n12) {
                    objectArray = this.j;
                    objectArray.r();
                    this.a = n13;
                }
            }
        }
    }

    private void p0(boolean bl2) {
        a a10;
        l1 l12 = this.c;
        if (bl2) {
            a10 = this.m;
        } else {
            bl2 = false;
            a10 = null;
        }
        l12.c(a10);
    }

    public /* synthetic */ void L(g g10, Consumer consumer, e.a.b0 b02) {
        this.K(g10, consumer, b02);
    }

    public /* synthetic */ void N(d.v.k0.f.d.a a10) {
        this.M(a10);
    }

    public /* synthetic */ void P(String string2) {
        this.O(string2);
    }

    public /* synthetic */ void T(b b10) {
        this.S(b10);
    }

    public /* synthetic */ void V(h1 h12) {
        this.U(h12);
    }

    public /* synthetic */ void X(byte[] byArray) {
        this.W(byArray);
    }

    public /* synthetic */ void b0(Throwable throwable) {
        this.a0(throwable);
    }

    public void c(ZYEnumDefine$ConnectAction object) {
        this.i.e();
        int n10 = 1;
        Object object2 = new Object[n10];
        int n11 = 0;
        Object object3 = null;
        object2[0] = object;
        m.a.a.b("\u53d1\u9001\u8fde\u63a5\u6307\u4ee4------------\uff1a%s", (Object[])object2);
        object2 = k1.f(this.b);
        int n12 = this.g;
        ((d.v.z.l.e)object2).x(n12);
        Object object4 = new b();
        Object object5 = (d.v.z.l.d)((g)object4).getData();
        ((d.v.z.l.d)object5).n((d.v.z.l.e)object2);
        ((d.v.z.l.d)object5).m((ZYEnumDefine$ConnectAction)object);
        object2 = ((g)object4).i();
        object5 = ZYEnumDefine$ConnectAction.ConnectActionDisconnect;
        if (object == object5) {
            this.p0(false);
            this.h.a();
            this.a = n11 = 4;
            object3 = this.j;
            ((u)object3).t();
        } else {
            object3 = ZYEnumDefine$ConnectAction.ConnectActionCanecl;
            if (object == object3) {
                this.a = n11 = 2;
            }
        }
        object3 = new d.v.a0.u(this);
        object3 = this.I((g)object4, (Consumer)object3);
        object4 = new o(this, (byte[])object2);
        object2 = k1.a((d.v.e.g.e)object4);
        object4 = w.a;
        object2 = e.a.z.W7((e.a.e0)object3, (e.a.e0)object2, (e.a.v0.c)object4);
        object5 = TimeUnit.MILLISECONDS;
        object2 = ((e.a.z)object2).s6(500L, (TimeUnit)((Object)object5));
        object3 = e.a.c1.b.d();
        object2 = ((e.a.z)object2).L5((h0)object3);
        object3 = d.v.a0.e.a;
        object4 = new b0(this, (ZYEnumDefine$ConnectAction)object);
        object = ((e.a.z)object2).c((e.a.v0.g)object3, (e.a.v0.g)object4);
        this.i.b((e.a.s0.b)object);
    }

    public void clear() {
        d.v.z.k.b.b();
        this.v();
        this.j.b();
        this.f.o();
        this.z();
        d.v.k0.f.e.t t10 = this.d;
        if (t10 != null) {
            this.d = null;
        }
        this.c.d(null);
    }

    public void d(d.v.z.l.f object, c c10) {
        d d10 = new d();
        d10.f((d.v.z.l.h)object);
        object = d10.i();
        z z10 = new z(this, c10);
        this.H(d10, z10);
        this.send((byte[])object);
    }

    public /* synthetic */ void e0(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction, Throwable throwable) {
        this.d0(zYEnumDefine$ConnectAction, throwable);
    }

    public void f(v v10) {
        this.j.a(v10);
    }

    public /* synthetic */ void g0(h1 h12) {
        this.f0(h12);
    }

    public /* synthetic */ void i0(byte[] byArray) {
        this.h0(byArray);
    }

    public boolean isConnected() {
        return this.h.d() ^ true;
    }

    public void k(d.v.a0.n1.h.a a10) {
        this.k = a10;
    }

    public void l(h1 object, Consumer object2) {
        boolean bl2 = this.isConnected();
        if (!bl2) {
            return;
        }
        object = ((h1)object).b().l();
        if (object2 != null) {
            object2.accept(object);
        }
        ((g)object).q((g)object);
        object2 = ((g)object).getData();
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode = ZYEnumDefine$ErrorCode.ErrorCodePara;
        object2.b(zYEnumDefine$ErrorCode);
        object = ((g)object).i();
        this.send((byte[])object);
    }

    public /* synthetic */ void l0(c c10, h1 h12) {
        this.k0(c10, h12);
    }

    public boolean m() {
        boolean bl2;
        d.v.k0.f.e.t t10 = this.d;
        if (t10 != null && !(bl2 = t10.isClosed())) {
            bl2 = true;
        } else {
            bl2 = false;
            t10 = null;
        }
        return bl2;
    }

    public /* synthetic */ void n0(d.v.a0.n1.h.a a10, h1 h12) {
        this.m0(a10, h12);
    }

    public void p(h1 object, Consumer consumer) {
        object = ((h1)object).b().l();
        if (consumer != null) {
            consumer.accept(object);
        }
        ((g)object).q((g)object);
        object = ((g)object).i();
        this.send((byte[])object);
    }

    public void send(byte[] byArray) {
        this.f.r(byArray);
    }

    public void u(int n10, int n11, boolean bl2, f f10) {
        d.v.k0.f.e.t t10;
        Context context = this.b;
        this.d = t10 = new d.v.k0.f.e.t(context);
        t10.e(n10);
        this.d.f(n11);
        this.d.w(bl2);
        d.v.k0.f.e.t t11 = this.d;
        g1$c g1$c = new g1$c(this, f10);
        t11.v(g1$c);
        this.d.u();
        this.a = 0;
    }

    public void v() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("\u65ad\u5f00udp----------", objectArray);
        this.i.e();
        this.f.i();
        this.f.v();
        this.p0(false);
        this.h.a();
    }

    public void w(v v10) {
        this.j.p(v10);
    }

    public void x(i object, boolean bl2, d.v.a0.n1.h.a a10) {
        Object object2 = ((i)object).D();
        if (object2 != null) {
            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction;
            object2 = new h();
            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction2 = ((i)object).D();
            if (zYEnumDefine$EventTypeAction2 == (zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.EventTypeActionNoti)) {
                ((g)object2).o();
            }
            if (bl2) {
                ((g)object2).p();
                bl2 = true;
                ((i)object).k0(bl2);
            }
            ((g)object2).f((d.v.z.l.h)object);
            object = ((g)object2).i();
            s s10 = new s(this, a10);
            this.H((g)object2, s10);
            this.send((byte[])object);
            return;
        }
        object = new IllegalArgumentException("must set action type");
        throw object;
    }

    public void y(int n10, String object) {
        Object object2;
        Object object3 = k1.e(this.b);
        if (object3 == null) {
            this.j.u("\u83b7\u53d6\u8bbe\u5907\u4fe1\u606f\u5f02\u5e38", null, 700);
            return;
        }
        int n11 = this.isConnected();
        if (n11 != 0) {
            return;
        }
        this.v();
        String string2 = ((d.v.z.l.e)object3).n();
        this.g = n11 = this.J(string2);
        ((d.v.z.l.e)object3).x(n11);
        n11 = 1;
        Object object4 = new Object[n11];
        object4[0] = object2 = Integer.valueOf(this.g);
        m.a.a.b("receive port----------%s", (Object[])object4);
        object4 = new Object[n11];
        object4[0] = object2 = ZYEnumDefine$ConnectAction.ConnectActionConnect;
        m.a.a.b("\u53d1\u9001\u8fde\u63a5\u6307\u4ee4------------\uff1a%s", (Object[])object4);
        object4 = new b();
        d.v.z.l.d d10 = (d.v.z.l.d)((g)object4).getData();
        d10.m((ZYEnumDefine$ConnectAction)object2);
        d10.n((d.v.z.l.e)object3);
        object3 = ((g)object4).i();
        int n12 = this.g;
        Object object5 = d.v.k0.f.c.i.a(n10, (String)object, n12);
        this.f.j((d.v.k0.f.c.i)object5, null);
        object5 = new d.v.a0.v(this);
        object5 = this.I((g)object4, (Consumer)object5);
        object = new p(this, (byte[])object3);
        object = k1.a((d.v.e.g.e)object);
        object3 = t.a;
        object5 = e.a.z.W7((e.a.e0)object5, (e.a.e0)object, (e.a.v0.c)object3);
        object = TimeUnit.MILLISECONDS;
        object5 = ((e.a.z)object5).s6(500L, (TimeUnit)((Object)object));
        object = e.a.c1.b.d();
        object5 = ((e.a.z)object5).L5((h0)object);
        object = d0.a;
        object3 = new y(this);
        object5 = ((e.a.z)object5).c((e.a.v0.g)object, (e.a.v0.g)object3);
        this.i.b((e.a.s0.b)object5);
        this.a = n11;
    }

    public void z() {
        d.v.k0.f.e.t t10 = this.d;
        if (t10 == null) {
            return;
        }
        t10.h();
    }
}

