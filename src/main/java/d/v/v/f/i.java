/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import com.meicam.sdk.NvsTimelineCaption;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.d.a;
import d.v.h.d.a$a;
import d.v.h.d.b;
import d.v.h.d.d;
import d.v.h.d.d$a;
import d.v.h.e.e;
import d.v.v.c;
import d.v.v.f.j;
import d.v.v.g.g;
import d.v.v.g.h;
import d.v.v.q.f;
import java.util.List;
import java.util.UUID;

public class i
implements b {
    private static final String d = "i";
    private final f a;
    private final g b;
    private final j c;

    public i(g object) {
        this.b = object;
        object = f.d();
        this.a = object;
        object = j.z();
        this.c = object;
    }

    private NvsTimelineData e() {
        return d.v.v.j.h.t().n();
    }

    private void h() {
        g g10 = this.b;
        if (g10 != null) {
            g10.Y();
        }
    }

    private void j() {
        h.k().E();
    }

    public void B(DecorationType object, int n10) {
        DecorationType decorationType = DecorationType.FONT;
        if (object != decorationType && object != (decorationType = DecorationType.CAPTION)) {
            return;
        }
        object = this.c;
        boolean bl2 = ((j)object).R(n10);
        if (bl2) {
            object = d.v.v.j.h.t();
            ((d.v.v.j.h)object).P(n10);
            this.j();
            this.h();
        }
    }

    public List D() {
        return this.e().getTextInfoList();
    }

    public void E(int n10) {
        DecorationType decorationType = DecorationType.FONT;
        this.B(decorationType, n10);
    }

    public void H() {
    }

    public void I(DecorationType decorationType, int n10, Long l10, long l11) {
    }

    public void a(d d10) {
        long l10;
        long l11 = d10.i();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        l11 = object == false ? 3000000L : d10.i();
        Long l13 = d10.e();
        if (l13 == null) {
            l10 = d.v.v.q.h.n();
        } else {
            l13 = d10.e();
            l10 = l13;
        }
        float[] fArray = d10.j();
        fArray = fArray == null ? d.v.v.c.i : d10.j();
        d10.p(l11);
        Object object2 = l10;
        d10.m((Long)object2);
        d10.q(fArray);
        object2 = this.c;
        object = ((j)object2).d(d10);
        if (object != false) {
            object2 = d.v.v.j.h.t();
            ((d.v.v.j.h)object2).g(d10);
        }
    }

    public void b(d d10, e e10) {
    }

    public void c(int n10, int n11) {
        d d10 = d.v.v.j.h.t().z(n10);
        j j10 = this.c;
        NvsTimelineCaption nvsTimelineCaption = j10.w(n10);
        if (d10 != null && nvsTimelineCaption != null) {
            j10 = this.c;
            j10.l(nvsTimelineCaption, d10, n11);
            this.j();
            this.h();
        }
    }

    public void clear() {
    }

    public void d(int n10, String string2, int n11) {
        d d10 = d.v.v.j.h.t().z(n10);
        j j10 = this.c;
        NvsTimelineCaption nvsTimelineCaption = j10.w(n10);
        if (d10 != null && nvsTimelineCaption != null) {
            j10 = this.c;
            j10.h(nvsTimelineCaption, d10, string2, n11);
            this.j();
            this.h();
        }
    }

    public void f(int n10, d$a d$a) {
        d d10 = d.v.v.j.h.t().z(n10);
        j j10 = this.c;
        NvsTimelineCaption nvsTimelineCaption = j10.w(n10);
        if (d10 != null && nvsTimelineCaption != null) {
            j10 = this.c;
            j10.k(nvsTimelineCaption, d10, d$a);
            this.j();
            this.h();
        }
    }

    public void g(d cloneable, int n10, e e10) {
        d d10 = d.v.v.j.h.t().z(n10);
        j j10 = this.c;
        NvsTimelineCaption nvsTimelineCaption = j10.w(n10);
        if (d10 != null && nvsTimelineCaption != null) {
            j10 = this.c;
            Long l10 = cloneable.e();
            long l11 = cloneable.i();
            Object object = nvsTimelineCaption;
            j10.f(nvsTimelineCaption, d10, l10, l11);
            j10 = this.c;
            float f10 = cloneable.d();
            j10.e(nvsTimelineCaption, d10, f10);
            j10 = this.c;
            object = cloneable.j();
            j10.j(nvsTimelineCaption, d10, (float[])object);
            j10 = this.c;
            object = cloneable.f();
            j10.i(nvsTimelineCaption, d10, (a$a)object);
            j10 = this.c;
            object = cloneable.y();
            j10.g(nvsTimelineCaption, d10, (String)object);
            j10 = this.c;
            object = cloneable.v();
            int n11 = cloneable.w();
            j10.h(nvsTimelineCaption, d10, (String)object, n11);
            j10 = this.c;
            int n12 = cloneable.x();
            j10.l(nvsTimelineCaption, d10, n12);
            j10 = this.c;
            cloneable = cloneable.t();
            j10.k(nvsTimelineCaption, d10, (d$a)cloneable);
            this.j();
            this.h();
            if (e10 != null) {
                e10.b();
            }
            return;
        }
        if (e10 != null) {
            e10.a();
        }
    }

    public void i(d d10) {
    }

    public void v(int n10, String string2) {
        d d10 = d.v.v.j.h.t().z(n10);
        j j10 = this.c;
        NvsTimelineCaption nvsTimelineCaption = j10.w(n10);
        if (d10 != null && nvsTimelineCaption != null) {
            j10 = this.c;
            j10.g(nvsTimelineCaption, d10, string2);
            this.j();
            this.h();
        }
    }

    public void w(int n10, Long l10, long l11) {
        d d10 = d.v.v.j.h.t().z(n10);
        j j10 = this.c;
        NvsTimelineCaption nvsTimelineCaption = j10.w(n10);
        if (d10 != null && nvsTimelineCaption != null) {
            j j11 = this.c;
            j11.f(nvsTimelineCaption, d10, l10, l11);
            this.j();
        }
    }

    public void x() {
        d.v.v.j.h h10 = d.v.v.j.h.t();
        List list = this.e().getTextInfoList();
        h10.R(list);
    }

    public void y() {
    }

    public void z(int n10) {
        d d10 = d.v.v.j.h.t().z(n10);
        if (d10 == null) {
            return;
        }
        Object object = d.v.v.j.h.t();
        Object object2 = ((d.v.v.j.h)object).z(++n10);
        d10 = d10.s();
        object = d10.e();
        long l10 = (Long)object;
        long l11 = d10.i();
        l10 += l11;
        if (object2 == null) {
            l11 = d10.i();
        } else {
            l11 = d10.i();
            object2 = ((a)object2).e();
            long l12 = (Long)object2 - l10;
            l11 = Math.min(l11, l12);
        }
        object2 = l10;
        d10.m((Long)object2);
        d10.p(l11);
        object2 = UUID.randomUUID().toString();
        d10.b((String)object2);
        object2 = this.c;
        n10 = (int)(((j)object2).d(d10) ? 1 : 0);
        if (n10 != 0) {
            object2 = d.v.v.j.h.t();
            ((d.v.v.j.h)object2).g(d10);
        }
    }
}

