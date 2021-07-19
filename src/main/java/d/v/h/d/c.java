/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package d.v.h.d;

import android.graphics.PointF;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.h.d.a;
import d.v.h.d.a$a;

public class c
extends a {
    private String i;
    private float j;
    private long k;
    private String l;
    private boolean m;
    private float n;
    private String o;
    private String p;
    private PointF q;

    public c() {
        this.m = true;
    }

    public c(a$a a$a, Long l10, long l11, float f10, float[] fArray, DecorationType decorationType) {
        super(a$a, l10, l11, f10, fArray, decorationType);
        this.m = true;
    }

    public c(a$a a$a, Long l10, long l11, DecorationType decorationType) {
        float[] fArray = new float[]{1.0f, 1.0f};
        this(a$a, l10, l11, 0.0f, fArray, decorationType);
    }

    public String A() {
        return this.l;
    }

    public PointF B() {
        return this.q;
    }

    public int E() {
        return 1;
    }

    public boolean F() {
        return this.m;
    }

    public c G(boolean bl2) {
        this.m = bl2;
        return this;
    }

    public c H(String string2) {
        this.p = string2;
        return this;
    }

    public c I(String string2) {
        this.o = string2;
        return this;
    }

    public c J(float f10) {
        this.j = f10;
        return this;
    }

    public c K(String string2) {
        this.i = string2;
        return this;
    }

    public c L(float f10) {
        this.n = f10;
        return this;
    }

    public c M(long l10) {
        this.k = l10;
        return this;
    }

    public c N(String string2) {
        this.l = string2;
        return this;
    }

    public c O(PointF pointF) {
        this.q = pointF;
        return this;
    }

    public void s(float f10) {
        float f11 = this.n;
        float[] fArray = new float[]{f10 /= f11, f10};
        this.q(fArray);
    }

    public c t() {
        a a10 = new c();
        Object object = this.x();
        a10 = ((c)a10).K((String)object);
        float f10 = this.w();
        a10 = ((c)a10).J(f10);
        long l10 = this.z();
        a10 = ((c)a10).M(l10);
        object = this.A();
        a10 = ((c)a10).N((String)object);
        boolean bl2 = this.F();
        a10 = ((c)a10).G(bl2);
        object = this.v();
        a10 = ((c)a10).I((String)object);
        object = this.u();
        a10 = ((c)a10).H((String)object);
        object = this.B();
        a$a a$a = null;
        if (object == null) {
            bl2 = false;
            object = null;
            f10 = 0.0f;
        } else {
            PointF pointF = this.B();
            float f11 = pointF.x;
            PointF pointF2 = this.B();
            float f12 = pointF2.y;
            object = new PointF(f11, f12);
        }
        a10 = ((c)a10).O((PointF)object);
        f10 = this.d();
        a10 = a10.l(f10);
        object = this.g();
        a10 = a10.o((DecorationType)((Object)object));
        object = this.e();
        a10 = a10.m((Long)object);
        object = this.f();
        if (object != null) {
            object = this.f();
            a$a = ((a$a)object).a();
        }
        a10 = a10.n(a$a);
        l10 = this.i();
        a10 = a10.p(l10);
        object = this.j();
        a10 = a10.q((float[])object);
        f10 = this.k();
        a10 = a10.r(f10);
        object = this.a();
        return (c)a10.b((String)object);
    }

    public String u() {
        return this.p;
    }

    public String v() {
        return this.o;
    }

    public float w() {
        return this.j;
    }

    public String x() {
        return this.i;
    }

    public float y() {
        return this.n;
    }

    public long z() {
        return this.k;
    }
}

