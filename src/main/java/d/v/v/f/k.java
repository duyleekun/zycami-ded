/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTimelineAnimatedSticker;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.nvseditor.data.CustomerAssetInfo;
import com.zhiyun.nvseditor.data.NvsAssetInfo;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.e.l.c1;
import d.v.h.d.a;
import d.v.h.d.a$a;
import d.v.h.d.b;
import d.v.h.d.c;
import d.v.h.d.d$a;
import d.v.v.f.e;
import d.v.v.f.f;
import d.v.v.f.g;
import d.v.v.f.h;
import d.v.v.f.j;
import d.v.v.f.k$a;
import d.v.v.j.i;
import java.util.List;
import java.util.concurrent.Executor;

public class k
implements b {
    private static final String d = "k";
    private d.v.v.g.g a;
    private d.v.v.q.f b;
    private d.v.h.e.e c;

    public k(d.v.v.g.g object) {
        this.a = object;
        object = d.v.v.q.f.d();
        this.b = object;
    }

    private void J() {
        d.v.v.g.g g10 = this.a;
        if (g10 != null) {
            g10.Y();
        }
    }

    private void L() {
        d.v.v.g.h h10 = d.v.v.g.h.k();
        boolean bl2 = h10.r();
        if (!bl2) {
            h10 = d.v.v.g.h.k();
            int n10 = 4;
            h10.F(n10);
        }
    }

    private void M() {
        d.v.h.e.e e10 = this.c;
        if (e10 != null) {
            e10.a();
        }
    }

    private void N() {
        d.v.h.e.e e10 = this.c;
        if (e10 != null) {
            e10.b();
        }
    }

    private void a(c c10) {
        Object object = j.z();
        boolean bl2 = ((j)object).a(c10);
        if (bl2) {
            object = d.v.v.j.h.t();
            ((d.v.v.j.h)object).d(c10);
            this.L();
            this.N();
        } else {
            this.M();
        }
    }

    private void g(c c10) {
        String string2 = c10.x();
        Executor executor = c1.b().d();
        e e10 = new e(this, string2, c10);
        executor.execute(e10);
    }

    private int h(DecorationType object, int n10) {
        int n11;
        DecorationType decorationType = DecorationType.IMAGE_PASTER;
        if (object == decorationType) {
            object = d.v.v.j.h.t().r(n10);
        } else {
            decorationType = DecorationType.GIF_PASTER;
            if (object == decorationType) {
                object = d.v.v.j.h.t().p(n10);
            } else {
                n11 = 0;
                object = null;
            }
        }
        if (object != null) {
            List list = this.j().getPasteInfoList();
            n11 = list.indexOf(object);
        } else {
            n11 = -1;
        }
        return n11;
    }

    private NvsTimeline i() {
        return i.e().f();
    }

    private NvsTimelineData j() {
        return d.v.v.j.h.t().n();
    }

    private void k(c c10, String object, long l10) {
        int n10;
        int n11;
        d.v.v.q.f f10 = this.b;
        if ((object = f10.k((String)object)) != null && (n11 = ((NvsAssetInfo)object).getStatus()) == (n10 = 1)) {
            long l11;
            long l12 = c10.i();
            long l13 = l12 - (l11 = 0L);
            n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n11 == 0) {
                c10.p(l10);
            }
            String string2 = ((CustomerAssetInfo)object).getCustomerPath();
            c10.H(string2);
            object = ((NvsAssetInfo)object).getUuid();
            c10.I((String)object);
            this.a(c10);
            return;
        }
        this.M();
    }

    private void l(c c10) {
        int n10;
        int n11;
        String string2;
        Object object;
        boolean bl2 = c10.F();
        if (bl2) {
            object = this.b;
            string2 = c10.x();
            object = ((d.v.v.q.f)object).l(string2);
        } else {
            object = this.b;
            string2 = c10.x();
            object = ((d.v.v.q.f)object).n(string2);
        }
        if (object != null && (n11 = ((NvsAssetInfo)object).getStatus()) == (n10 = 1)) {
            string2 = ((CustomerAssetInfo)object).getCustomerPath();
            c10.H(string2);
            object = ((NvsAssetInfo)object).getUuid();
            c10.I((String)object);
            this.a(c10);
            return;
        }
        this.M();
    }

    private /* synthetic */ void m(String object, c c10) {
        Object object2 = d.v.v.q.f.d();
        boolean bl2 = ((d.v.v.q.f)object2).a((String)object);
        if (bl2) {
            long l10;
            String string2 = d.v.v.q.f.d().b((String)object);
            object2 = ".caf";
            bl2 = ((String)object).endsWith((String)object2);
            if (bl2) {
                l10 = 3000000L;
            } else {
                object2 = d.v.v.q.f.d();
                l10 = ((d.v.v.q.f)object2).c((String)object);
            }
            object = c1.b().c();
            Object object3 = object2;
            object2 = new g(this, c10, string2, l10);
            object.execute((Runnable)object2);
        } else {
            object2 = this.b;
            h h10 = new h(this, c10);
            ((d.v.v.q.f)object2).g((String)object, h10);
        }
    }

    private /* synthetic */ void o(c c10, String string2, long l10) {
        this.k(c10, string2, l10);
    }

    private /* synthetic */ void q(boolean bl2, c c10, String string2, long l10) {
        if (bl2) {
            this.k(c10, string2, l10);
        } else {
            this.M();
        }
    }

    private /* synthetic */ void s(c c10, String string2, long l10, boolean bl2) {
        Object object = i.e();
        boolean bl3 = ((i)object).k();
        if (bl3) {
            return;
        }
        object = c1.b().c();
        f f10 = new f(this, bl2, c10, string2, l10);
        object.execute(f10);
    }

    public void B(DecorationType decorationType, int n10) {
        int n11;
        int n12 = this.h(decorationType, n10);
        if (n12 != (n11 = -1)) {
            this.E(n10);
        }
    }

    public List D() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("this method can not be use");
        throw unsupportedOperationException;
    }

    public void E(int n10) {
        Object object = j.z();
        boolean bl2 = ((j)object).Q(n10);
        if (bl2) {
            object = d.v.v.j.h.t();
            ((d.v.v.j.h)object).L(n10);
            this.L();
            this.J();
        }
    }

    public void H() {
    }

    public void I(DecorationType decorationType, int n10, Long l10, long l11) {
        int n11 = this.h(decorationType, n10);
        if (n11 != (n10 = -1)) {
            this.w(n11, l10, l11);
        }
    }

    public void K(c c10) {
    }

    public void b(c c10) {
        long l10;
        long l11;
        long l12;
        j j10 = j.z();
        boolean bl2 = j10.F(c10);
        if (!bl2) {
            this.M();
        }
        l11 = !(bl2 = (l12 = (l11 = c10.i()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) ? 3000000L : c10.i();
        int[] nArray = k$a.a;
        DecorationType decorationType = c10.g();
        int n10 = decorationType.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                this.M();
            } else {
                c10.p(l11);
                this.l(c10);
            }
        } else {
            bl2 = c10.F();
            if (bl2) {
                this.g(c10);
            } else {
                this.l(c10);
            }
        }
    }

    public void c(int n10, int n11) {
    }

    public void clear() {
    }

    public void d(int n10, String string2, int n11) {
    }

    public void e(c c10, d.v.h.e.e e10) {
        this.c = e10;
        this.b(c10);
    }

    public void f(int n10, d$a d$a) {
    }

    public /* synthetic */ void n(String string2, c c10) {
        this.m(string2, c10);
    }

    public /* synthetic */ void p(c c10, String string2, long l10) {
        this.o(c10, string2, l10);
    }

    public /* synthetic */ void r(boolean bl2, c c10, String string2, long l10) {
        this.q(bl2, c10, string2, l10);
    }

    public /* synthetic */ void t(c c10, String string2, long l10, boolean bl2) {
        this.s(c10, string2, l10, bl2);
    }

    public void u(c cloneable, int n10, d.v.h.e.e e10) {
        Object object = d.v.v.j.h.t().x(n10);
        Object object2 = j.z();
        NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = ((j)object2).v(n10);
        if (object != null && nvsTimelineAnimatedSticker != null) {
            Object object3;
            object2 = ((c)object).x();
            boolean bl2 = ((String)object2).equals(object3 = cloneable.x());
            if (!bl2) {
                j.z().Q(n10);
                object = d.v.v.j.h.t();
                ((d.v.v.j.h)object).L(n10);
                this.e((c)cloneable, e10);
            } else {
                object2 = j.z();
                Long l10 = cloneable.e();
                long l11 = cloneable.i();
                object3 = nvsTimelineAnimatedSticker;
                ((j)object2).n(nvsTimelineAnimatedSticker, (c)object, l10, l11);
                j j10 = j.z();
                float f10 = cloneable.w();
                object3 = cloneable.j();
                j10.q(nvsTimelineAnimatedSticker, (c)object, f10, (float[])object3);
                j10 = j.z();
                f10 = cloneable.d();
                j10.m(nvsTimelineAnimatedSticker, (c)object, f10);
                j10 = j.z();
                cloneable = cloneable.f();
                j10.p(nvsTimelineAnimatedSticker, (c)object, (a$a)cloneable);
                this.L();
                this.J();
                if (e10 != null) {
                    e10.b();
                }
            }
            return;
        }
        if (e10 != null) {
            e10.a();
        }
    }

    public void v(int n10, String string2) {
    }

    public void w(int n10, Long l10, long l11) {
        c c10 = d.v.v.j.h.t().x(n10);
        j j10 = j.z();
        NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = j10.v(n10);
        if (c10 != null && nvsTimelineAnimatedSticker != null) {
            j j11 = j.z();
            j11.n(nvsTimelineAnimatedSticker, c10, l10, l11);
            this.L();
        }
    }

    public void x() {
        d.v.v.j.h h10 = d.v.v.j.h.t();
        List list = this.j().getPasteInfoList();
        h10.R(list);
    }

    public void y() {
    }

    public void z(int n10) {
        c c10 = d.v.v.j.h.t().x(n10);
        if (c10 == null) {
            return;
        }
        Object object = d.v.v.j.h.t();
        Object object2 = ((d.v.v.j.h)object).x(++n10);
        c10 = c10.t();
        object = c10.e();
        long l10 = (Long)object;
        long l11 = c10.i();
        l10 += l11;
        if (object2 == null) {
            l11 = c10.i();
        } else {
            l11 = c10.i();
            object2 = ((a)object2).e();
            long l12 = (Long)object2 - l10;
            l11 = Math.min(l11, l12);
        }
        object2 = l10;
        c10.m((Long)object2);
        c10.p(l11);
        object2 = j.z();
        n10 = (int)(((j)object2).a(c10) ? 1 : 0);
        if (n10 != 0) {
            object2 = d.v.v.j.h.t();
            ((d.v.v.j.h)object2).d(c10);
        }
    }
}

