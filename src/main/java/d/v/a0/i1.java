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
import d.v.a0.a1;
import d.v.a0.b1;
import d.v.a0.e1;
import d.v.a0.e1$a;
import d.v.a0.h1;
import d.v.a0.i1$a;
import d.v.a0.i1$b;
import d.v.a0.i1$c;
import d.v.a0.i1$d;
import d.v.a0.i1$e;
import d.v.a0.i1$f;
import d.v.a0.k1;
import d.v.a0.l0;
import d.v.a0.l1;
import d.v.a0.m0;
import d.v.a0.n0;
import d.v.a0.n1.a;
import d.v.a0.n1.b;
import d.v.a0.n1.c;
import d.v.a0.n1.e;
import d.v.a0.n1.g.w;
import d.v.a0.n1.g.x;
import d.v.a0.o0;
import d.v.a0.p0;
import d.v.a0.q0;
import d.v.a0.r0;
import d.v.a0.s0;
import d.v.a0.t0;
import d.v.a0.u0;
import d.v.a0.v0;
import d.v.a0.w0;
import d.v.a0.x0;
import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.n;
import d.v.k0.f.e.p;
import d.v.k0.f.e.q;
import d.v.z.l.d;
import d.v.z.l.i;
import d.v.z.n.g;
import d.v.z.n.h;
import e.a.b0;
import e.a.e0;
import e.a.h0;
import e.a.v0.r;
import e.a.z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class i1
extends b1 {
    private final Context a;
    private final l1 b;
    private final n c;
    private int d;
    private final Map e;
    private q f;
    private final Map g;
    private final x h;
    private final Map i;
    private final e.a.s0.a j;
    private c k;
    private d.v.a0.n1.h.b l;
    private final e m;
    private final a n;
    private final k o;

    public i1(Context context) {
        n n10;
        l1 l12;
        this.b = l12 = new l1();
        this.c = n10 = d.v.k0.f.c.j.n.l();
        this.d = -1;
        Object object = new HashMap();
        this.e = object;
        object = new HashMap();
        this.g = object;
        this.h = object = new x();
        object = new HashMap();
        this.i = object;
        this.j = object = new e.a.s0.a();
        this.m = object = new i1$a(this);
        Object object2 = new w0(this);
        this.n = object2;
        this.o = object2 = new i1$b(this);
        this.a = context;
        l12.d((e)object);
        n10.e((k)object2);
    }

    public static /* synthetic */ c B(i1 i12) {
        return i12.k;
    }

    public static /* synthetic */ d.v.a0.n1.h.b C(i1 i12) {
        return i12.l;
    }

    public static /* synthetic */ void D(i1 i12, h1 h12, boolean bl2) {
        i12.l0(h12, bl2);
    }

    public static /* synthetic */ l1 E(i1 i12) {
        return i12.b;
    }

    public static /* synthetic */ void F(i1 i12, d.v.z.l.e e10) {
        i12.K(e10);
    }

    public static /* synthetic */ n G(i1 i12) {
        return i12.c;
    }

    private e1 H(String string2, d.v.z.l.e object) {
        e1 e12 = (e1)this.g.get(string2);
        if (e12 != null) {
            return e12;
        }
        e12 = new e1();
        e12.g(string2);
        e12.h((d.v.z.l.e)object);
        object = new t0(this);
        e12.i((e1$a)object);
        this.g.put(string2, e12);
        return e12;
    }

    private void I(String string2, e.a.s0.b object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        object2[0] = string2;
        String string3 = "prepare addToConnectDispose---------------:%s";
        m.a.a.b(string3, object2);
        object2 = this.i.get(string2);
        if (object2 == null) {
            Object object3 = new Object[n10];
            object3[0] = string2;
            object2 = "addToConnectDispose---------------:%s";
            m.a.a.b((String)object2, (Object[])object3);
            object3 = new e.a.s0.a();
            ((e.a.s0.a)object3).b((e.a.s0.b)object);
            object = this.i;
            object.put(string2, object3);
        }
    }

    private void J(String string2, int n10) {
        Map map = this.e;
        Integer n11 = n10;
        map.put(string2, n11);
    }

    private void K(d.v.z.l.e object) {
        Object object2;
        Object object3 = k1.b(this.a);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2 && !(bl2 = ((String)object3).equals(object2 = this.f.i()))) {
            object2 = this.f;
            ((p)object2).d((String)object3);
            ((d.v.z.l.e)object).w((String)object3);
            object3 = new d.v.z.n.c();
            ((g)object3).f((d.v.z.l.h)object);
            object = ((g)object3).i();
            object3 = this.f;
            ((q)object3).v((byte[])object);
        }
    }

    private void L(g g10, Consumer consumer) {
        n n10 = this.c;
        i1$e i1$e = new i1$e(this, g10, consumer);
        n10.g(i1$e);
    }

    private z M(g g10, Consumer consumer) {
        u0 u02 = new u0(this, g10, consumer);
        return z.y1(u02);
    }

    private void N(String objectArray) {
        int n10 = this.d;
        int n11 = -1;
        if (n10 == n11) {
            n10 = (int)(TextUtils.isEmpty((CharSequence)objectArray) ? 1 : 0);
            if (n10 != 0) {
                objectArray = k1.b(this.a);
            }
            int n12 = SocketUtil.i((String)objectArray);
            try {
                this.d = n12;
            }
            catch (IllegalStateException illegalStateException) {
                m.a.a.f(illegalStateException);
                this.d = n12 = 6061;
            }
            n12 = 1;
            objectArray = new Object[n12];
            n10 = 0;
            n11 = this.d;
            Integer n13 = n11;
            objectArray[0] = n13;
            String string2 = "mRecPort---------------:%s";
            m.a.a.b(string2, objectArray);
        }
    }

    private int O(String string2) {
        Object[] objectArray = (Object[])this.e.get(string2);
        if (objectArray == null) {
            objectArray = new Object[]{string2};
            m.a.a.i("\u6ca1\u6709\u8be5\u53d1\u9001\u5730\u5740\u7684\u7aef\u53e3\uff1a%s", objectArray);
            return -1;
        }
        return objectArray.intValue();
    }

    public static /* synthetic */ void P(i1 i12, String string2, e1 e12) {
        i12.q0(string2, e12);
    }

    private /* synthetic */ void Q(String string2) {
        this.p0(string2);
        this.r0(null, string2);
    }

    private /* synthetic */ void S(g g10, Consumer consumer, b0 b02) {
        n n10 = this.c;
        i1$d i1$d = new i1$d(this, g10, consumer, b02);
        n10.g(i1$d);
    }

    public static /* synthetic */ void U(Map object, String string2, e1 object2) {
        object2 = ((e1)object2).b();
        object = (d.v.z.l.e)object.put(string2, object2);
    }

    private /* synthetic */ void V(d.v.k0.f.d.a object) {
        object = ((d.v.k0.f.d.a)object).d();
        this.t0((String)object);
    }

    private /* synthetic */ void X(String string2, e1 e12) {
        e12.a();
        this.c.q(string2);
    }

    private /* synthetic */ void Z(h1 h12) {
        this.l0(h12, false);
    }

    private /* synthetic */ void b0(d.v.k0.f.d.a a10) {
        this.t(a10);
    }

    public static /* synthetic */ Object d0(Object object, Object object2) {
        return object;
    }

    public static /* synthetic */ void e0(Object object) {
    }

    private /* synthetic */ void f0(ZYEnumDefine$ConnectAction objectArray, String object, d.v.z.n.b b10, Throwable object2) {
        boolean bl2 = object2 instanceof TimeoutException;
        if (bl2) {
            object2 = ZYEnumDefine$ConnectAction.ConnectActionDisconnect;
            if (objectArray == object2) {
                objectArray = new Object[]{};
                m.a.a.b("\u65ad\u5f00\u8d85\u65f6,\u5c06\u5bf9\u65b9\u79fb\u9664----------", objectArray);
                this.p0((String)object);
                return;
            }
            object2 = new h1((g)b10, (String)object);
            object = this.h;
            ((x)object).t((h1)object2, (ZYEnumDefine$ConnectAction)objectArray);
        }
    }

    private /* synthetic */ boolean h0(Long l10) {
        return this.g.isEmpty() ^ true;
    }

    private /* synthetic */ void j0(Long object) {
        object = this.g;
        p0 p02 = new p0(this);
        object.forEach(p02);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void l0(h1 object, boolean bl2) {
        int n10;
        block9: {
            Object object2;
            Object object3;
            Object object4;
            block4: {
                int n11;
                block8: {
                    block5: {
                        block6: {
                            block7: {
                                object4 = (d)((d.v.z.n.b)((h1)object).b()).getData();
                                object3 = ((d)object4).k();
                                object2 = ((d)object4).j();
                                if (object2 == null) return;
                                object2 = ((d.v.z.l.e)object3).n();
                                int n12 = TextUtils.isEmpty((CharSequence)object2);
                                if (n12 != 0) {
                                    return;
                                }
                                object2 = ((h1)object).a();
                                this.m0((String)object2);
                                n12 = 2;
                                Object[] objectArray = new Object[n12];
                                Object object5 = ((d)object4).j();
                                n10 = 0;
                                objectArray[0] = object5;
                                object5 = bl2;
                                n11 = 1;
                                objectArray[n11] = object5;
                                m.a.a.b("\u6536\u5230\u8fde\u63a5\u7684\u56de\u590d\u6216\u8005\u901a\u77e5---------\uff1a%s,isReply:%s", objectArray);
                                int[] nArray = i1$f.b;
                                object5 = ((d)object4).j();
                                int n13 = ((Enum)object5).ordinal();
                                int n14 = nArray[n13];
                                if (n14 == n11) break block4;
                                if (n14 == n12) break block5;
                                int n15 = 3;
                                if (n14 == n15) break block6;
                                n15 = 4;
                                if (n14 == n15) break block7;
                                n15 = 5;
                                if (n14 == n15) break block8;
                                break block9;
                            }
                            object4 = ((h1)object).a();
                            object2 = ((h1)object).a();
                            object3 = this.H((String)object2, (d.v.z.l.e)object3);
                            this.q0((String)object4, (e1)object3);
                            object4 = this.h;
                            ((x)object4).s((h1)object);
                            break block9;
                        }
                        object4 = this.h;
                        ((x)object4).u((h1)object);
                        break block8;
                    }
                    object4 = (d.v.z.n.b)((h1)object).b();
                    boolean bl3 = ((g)object4).a();
                    if (!bl3) {
                        object4 = ((h1)object).a();
                        this.r0((h1)object, (String)object4);
                        object4 = new Object[]{};
                        object3 = "\u6536\u5230\u4e3b\u52a8\u65ad\u5f00\u8fde\u63a5\u7684\u56de\u590d-------";
                        m.a.a.b((String)object3, (Object[])object4);
                    } else {
                        object4 = new Object[]{};
                        object3 = "\u6536\u5230\u65ad\u5f00\u8fde\u63a5-------------";
                        m.a.a.b((String)object3, (Object[])object4);
                    }
                }
                n10 = n11;
                break block9;
            }
            object2 = ((h1)object).a();
            int n16 = ((d.v.z.l.e)object3).o();
            this.J((String)object2, n16);
            object3 = this.h;
            ((x)object3).w((h1)object, (d)object4);
        }
        if (bl2) {
            bl2 = false;
            this.p((h1)object, null);
        }
        if (n10 == 0) return;
        object = ((h1)object).a();
        this.p0((String)object);
    }

    private void m0(String string2) {
        int n10 = 1;
        Object object = new Object[n10];
        String string3 = null;
        object[0] = string2;
        String string4 = "prepare remoteFormConnectDispose-----------%s";
        m.a.a.b(string4, (Object[])object);
        object = (e.a.s0.a)this.i.get(string2);
        if (object != null) {
            Object object2 = new Object[n10];
            object2[0] = string2;
            string3 = "remoteFormConnectDispose-----------%s";
            m.a.a.b(string3, (Object[])object2);
            ((e.a.s0.a)object).e();
            object2 = this.i;
            object2.remove(string2);
        }
    }

    private void n0() {
        Map map = this.g;
        s0 s02 = new s0(this);
        map.forEach(s02);
        this.g.clear();
        this.j.e();
    }

    private void o0(String string2) {
        this.e.remove(string2);
    }

    private void p0(String string2) {
        e1 e12 = (e1)this.g.remove(string2);
        if (e12 != null) {
            e12.a();
        }
        this.c.q(string2);
    }

    private void q0(String object, e1 object2) {
        int n10;
        int n11 = this.O((String)object);
        if (n11 == (n10 = -1)) {
            return;
        }
        long l10 = System.currentTimeMillis();
        object2 = ((e1)object2).c();
        ((g)object2).e().clear();
        d.v.z.l.g g10 = (d.v.z.l.g)((g)object2).getData();
        long l11 = g10.j();
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        l11 = l13 == false ? l10 : g10.j();
        g10.l(l10, l11);
        d.v.k0.f.d.a a10 = new d.v.k0.f.d.a();
        object = a10.j(n11).h((String)object);
        object2 = ((g)object2).i();
        ((d.v.k0.f.d.a)object).g((byte[])object2);
        this.t(a10);
    }

    private void r0(h1 object, String string2) {
        if (object == null) {
            object = new d.v.z.n.b();
            h1 h12 = new h1((g)object, string2);
            object = h12;
        }
        this.h.v((h1)object);
    }

    private void s0(boolean bl2) {
        a a10;
        l1 l12 = this.b;
        if (bl2) {
            a10 = this.n;
        } else {
            bl2 = false;
            a10 = null;
        }
        l12.c(a10);
    }

    private void t0(String object) {
        Map map = this.g;
        if ((object = (e1)map.get(object)) == null) {
            return;
        }
        long l10 = System.currentTimeMillis();
        ((e1)object).j(l10);
        object = (d.v.z.l.g)((e1)object).c().getData();
        long l11 = ((d.v.z.l.g)object).k();
        ((d.v.z.l.g)object).l(l11, l10);
    }

    public void A(w w10) {
        this.h.r(w10);
    }

    public /* synthetic */ void R(String string2) {
        this.Q(string2);
    }

    public /* synthetic */ void T(g g10, Consumer consumer, b0 b02) {
        this.S(g10, consumer, b02);
    }

    public /* synthetic */ void W(d.v.k0.f.d.a a10) {
        this.V(a10);
    }

    public /* synthetic */ void Y(String string2, e1 e12) {
        this.X(string2, e12);
    }

    public boolean a(String object) {
        boolean bl2;
        Map map = this.g;
        if ((object = (e1)map.get(object)) != null && !(bl2 = ((e1)object).d())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public /* synthetic */ void a0(h1 h12) {
        this.Z(h12);
    }

    public void b(String string2, ZYEnumDefine$ConnectAction object, String object2) {
        int n10;
        int n11 = this.O(string2);
        if (n11 == (n10 = -1)) {
            return;
        }
        this.m0(string2);
        n10 = 2;
        Object object3 = new Object[n10];
        TimeUnit timeUnit = null;
        object3[0] = object;
        object3[1] = string2;
        m.a.a.b("\u53d1\u9001\u8fde\u63a5\u6307\u4ee4------------\uff1a%s,host:%s", object3);
        object3 = k1.f(this.a);
        int n12 = this.d;
        object3.x(n12);
        d.v.z.n.b b10 = new d.v.z.n.b();
        d d10 = (d)b10.getData();
        d10.m((ZYEnumDefine$ConnectAction)object);
        d10.n((d.v.z.l.e)object3);
        object3 = ZYEnumDefine$ConnectAction.ConnectActionReject;
        if (object == object3) {
            d10.o((String)object2);
        }
        object2 = new d.v.k0.f.d.a();
        Object object4 = ((d.v.k0.f.d.a)object2).h(string2).j(n11);
        object3 = b10.i();
        object4.g((byte[])object3);
        object4 = ZYEnumDefine$ConnectAction.ConnectActionDisconnect;
        if (object == object4) {
            object4 = new Object[]{};
            object3 = "\u544a\u8bc9\u4e0a\u5c42\u65ad\u5f00\u8fde\u63a5-------";
            m.a.a.b((String)object3, object4);
            n11 = 0;
            object4 = null;
            this.r0(null, string2);
        }
        object4 = new r0(this);
        object4 = this.M(b10, (Consumer)object4);
        object3 = new o0(this, (d.v.k0.f.d.a)object2);
        object2 = k1.a((d.v.e.g.e)object3);
        object3 = q0.a;
        object2 = z.W7((e0)object4, (e0)object2, (e.a.v0.c)object3);
        timeUnit = TimeUnit.MILLISECONDS;
        object2 = ((z)object2).s6(500L, timeUnit);
        object4 = e.a.c1.b.d();
        object2 = ((z)object2).L5((h0)object4);
        object4 = x0.a;
        object3 = new l0(this, (ZYEnumDefine$ConnectAction)object, string2, b10);
        object = ((z)object2).c((e.a.v0.g)object4, (e.a.v0.g)object3);
        this.I(string2, (e.a.s0.b)object);
    }

    public /* synthetic */ void c0(d.v.k0.f.d.a a10) {
        this.b0(a10);
    }

    public void clear() {
        d.v.z.k.b.b();
        this.v();
        this.h.b();
        this.c.o();
        this.j();
        q q10 = this.f;
        if (q10 != null) {
            this.f = null;
        }
        this.s0(false);
        this.b.d(null);
    }

    public Map e() {
        HashMap hashMap = new HashMap();
        Map map = this.g;
        n0 n02 = new n0(hashMap);
        map.forEach(n02);
        return hashMap;
    }

    public void g(String object, i object2, boolean bl2, h1 h12, d.v.a0.n1.h.b object3) {
        object3 = ((i)object2).D();
        if (object3 != null) {
            Object object4;
            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction;
            int n10;
            int n11 = this.O((String)object);
            if (n11 == (n10 = -1)) {
                return;
            }
            h h10 = new h();
            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction2 = ((i)object2).D();
            if (zYEnumDefine$EventTypeAction2 == (zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.EventTypeActionNoti)) {
                h10.o();
            }
            if (bl2 && h12 != null) {
                object4 = h12.b();
                h10.q((g)object4);
                bl2 = true;
                ((i)object2).k0(bl2);
            }
            h10.f((d.v.z.l.h)object2);
            object2 = new d.v.k0.f.d.a();
            object = ((d.v.k0.f.d.a)object2).h((String)object).j(n11);
            object4 = h10.i();
            ((d.v.k0.f.d.a)object).g((byte[])object4);
            this.L(h10, null);
            this.t((d.v.k0.f.d.a)object2);
            return;
        }
        object = new IllegalArgumentException("must set action type");
        throw object;
    }

    public /* synthetic */ void g0(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction, String string2, d.v.z.n.b b10, Throwable throwable) {
        this.f0(zYEnumDefine$ConnectAction, string2, b10, throwable);
    }

    public boolean h() {
        boolean bl2;
        q q10 = this.f;
        if (q10 != null && !(bl2 = q10.isClosed())) {
            bl2 = true;
        } else {
            bl2 = false;
            q10 = null;
        }
        return bl2;
    }

    public void i() {
        this.N(null);
        n n10 = this.c;
        int n11 = this.d;
        n10.j(n11);
        this.s();
    }

    public /* synthetic */ boolean i0(Long l10) {
        return this.h0(l10);
    }

    public void j() {
        q q10 = this.f;
        if (q10 == null) {
            return;
        }
        q10.h();
    }

    public /* synthetic */ void k0(Long l10) {
        this.j0(l10);
    }

    public void l(h1 object, Consumer object2) {
        int n10;
        Object object3 = ((h1)object).a();
        int n11 = this.a((String)object3);
        if (n11 == 0) {
            return;
        }
        n11 = this.O((String)object3);
        if (n11 == (n10 = -1)) {
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
        object2 = new d.v.k0.f.d.a();
        object3 = ((d.v.k0.f.d.a)object2).h((String)object3).j(n11);
        object = ((g)object).i();
        ((d.v.k0.f.d.a)object3).g((byte[])object);
        this.t((d.v.k0.f.d.a)object2);
    }

    public void n(int n10, int n11, boolean bl2, b b10) {
        d.v.z.l.e e10 = k1.e(this.a);
        if (e10 == null) {
            d.v.k0.g.d.h("\u83b7\u53d6\u8bbe\u5907\u4fe1\u606f\u5f02\u5e38", null, 700, b10);
            return;
        }
        Object object = e10.n();
        this.N((String)object);
        int n12 = this.d;
        e10.x(n12);
        this.f = object = new q();
        i1$c i1$c = new i1$c(this, e10, b10);
        ((q)object).w(i1$c);
        this.f.f(n11);
        this.f.e(n10);
        Object object2 = this.f;
        String string2 = e10.n();
        ((p)object2).d(string2);
        this.f.x(bl2);
        object2 = new d.v.z.n.c();
        ((g)object2).f(e10);
        object2 = ((g)object2).i();
        this.f.u((byte[])object2);
    }

    public void o(w w10) {
        this.h.a(w10);
    }

    public void p(h1 object, Consumer object2) {
        int n10;
        Object object3 = ((h1)object).a();
        int n11 = this.O((String)object3);
        if (n11 == (n10 = -1)) {
            return;
        }
        g g10 = ((h1)object).b().l();
        if (object2 != null) {
            object2.accept(g10);
        }
        g10.q(g10);
        object2 = new d.v.k0.f.d.a();
        object = ((h1)object).a();
        object = ((d.v.k0.f.d.a)object2).h((String)object).j(n11);
        object3 = g10.i();
        ((d.v.k0.f.d.a)object).g((byte[])object3);
        this.t((d.v.k0.f.d.a)object2);
    }

    public void q(c c10) {
        this.k = c10;
    }

    public void r(d.v.a0.n1.h.b b10) {
        this.l = b10;
    }

    public void s() {
        this.s0(true);
        this.j.e();
        Object object = TimeUnit.MILLISECONDS;
        object = z.n3(1000L, (TimeUnit)((Object)object));
        Object object2 = new v0(this);
        object = ((z)object).o2((r)object2);
        object2 = new m0(this);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object2).a();
        this.j.b((e.a.s0.b)object);
    }

    public void t(d.v.k0.f.d.a a10) {
        this.c.s(a10);
    }

    public void v() {
        Stream stream = this.i.values().stream();
        a1 a12 = a1.a;
        stream.forEach(a12);
        this.i.clear();
        this.c.w();
        this.n0();
        this.d = -1;
        this.e.clear();
    }
}

