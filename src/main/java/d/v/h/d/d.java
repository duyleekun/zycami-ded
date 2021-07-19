/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package d.v.h.d;

import android.graphics.PointF;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.h.b;
import d.v.h.d.a;
import d.v.h.d.a$a;
import d.v.h.d.d$a;

public class d
extends a {
    private String i;
    private String j;
    private int k;
    private int l;
    private boolean m;
    private d$a n;
    private PointF o;
    private String p;

    public d() {
    }

    public d(a$a a$a, Long l10, long l11) {
        float[] fArray = new float[]{1.0f, 1.0f};
        DecorationType decorationType = DecorationType.FONT;
        this(a$a, l10, l11, 0.0f, fArray, decorationType);
    }

    public d(a$a cloneable, Long l10, long l11, float f10, float[] fArray, DecorationType decorationType) {
        super((a$a)cloneable, l10, l11, f10, fArray, decorationType);
        super();
        this.n = cloneable;
    }

    public boolean A() {
        return this.m;
    }

    public d B(d$a d$a) {
        this.n = d$a;
        return this;
    }

    public d E(String string2) {
        this.p = string2;
        return this;
    }

    public d F(boolean bl2) {
        this.m = bl2;
        return this;
    }

    public d G(String string2) {
        this.j = string2;
        return this;
    }

    public d H(int n10) {
        this.k = n10;
        return this;
    }

    public d I(int n10) {
        this.l = n10;
        return this;
    }

    public d J(String string2) {
        this.i = string2;
        return this;
    }

    public d K(PointF pointF) {
        this.o = pointF;
        return this;
    }

    public d s() {
        float f10;
        d d10;
        Object object = super.c();
        a$a a$a = ((a)object).f();
        Long l10 = ((a)object).e();
        long l11 = ((a)object).i();
        float f11 = ((a)object).d();
        float[] fArray = ((a)object).j();
        DecorationType decorationType = ((a)object).g();
        Object object2 = d10;
        d10 = new d(a$a, l10, l11, f11, fArray, decorationType);
        object = this.y();
        object = d10.J((String)object);
        object2 = this.v();
        object = ((d)object).G((String)object2);
        int n10 = this.w();
        object = ((d)object).H(n10);
        n10 = (int)(this.A() ? 1 : 0);
        object = ((d)object).F(n10 != 0);
        n10 = this.x();
        object = ((d)object).I(n10);
        object2 = this.t();
        a$a = null;
        if (object2 == null) {
            n10 = 0;
            object2 = null;
            f10 = 0.0f;
        } else {
            object2 = this.t().a();
        }
        object = ((d)object).B((d$a)object2);
        object2 = this.z();
        if (object2 != null) {
            object2 = this.z();
            f10 = ((PointF)object2).x;
            l10 = this.z();
            float f12 = ((PointF)l10).y;
            a$a = new PointF(f10, f12);
        }
        object = ((d)object).K((PointF)a$a);
        object2 = this.u();
        object = ((d)object).E((String)object2);
        object2 = this.a();
        return (d)((b)object).b((String)object2);
    }

    public d$a t() {
        return this.n;
    }

    public String u() {
        return this.p;
    }

    public String v() {
        return this.j;
    }

    public int w() {
        return this.k;
    }

    public int x() {
        return this.l;
    }

    public String y() {
        return this.i;
    }

    public PointF z() {
        return this.o;
    }
}

