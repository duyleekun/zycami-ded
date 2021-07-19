/*
 * Decompiled with CFR 0.151.
 */
package d.v.h.d;

import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.h.b;
import d.v.h.d.a$a;
import java.util.UUID;

public class a
extends b
implements Cloneable {
    private a$a b;
    private DecorationType c;
    private float d;
    private float[] e;
    private Long f;
    private long g;
    private float h;

    public a() {
    }

    public a(a$a a$a, Long l10, long l11, float f10, float[] fArray, DecorationType decorationType) {
        this.b = a$a;
        this.f = l10;
        this.g = l11;
        this.d = f10;
        this.e = fArray;
        this.c = decorationType;
    }

    public a c() {
        a a10 = new a();
        float f10 = this.d();
        a10 = a10.l(f10);
        Object object = this.c;
        a10 = a10.o((DecorationType)((Object)object));
        object = this.e();
        a10 = a10.m((Long)object);
        object = this.f();
        if (object == null) {
            f10 = 0.0f;
            object = null;
        } else {
            object = this.f().a();
        }
        a10 = a10.n((a$a)object);
        long l10 = this.i();
        a10 = a10.p(l10);
        object = this.j();
        a10 = a10.q((float[])object);
        f10 = this.k();
        a10 = a10.r(f10);
        object = UUID.randomUUID().toString();
        return (a)a10.b((String)object);
    }

    public float d() {
        return this.d;
    }

    public Long e() {
        return this.f;
    }

    public a$a f() {
        return this.b;
    }

    public DecorationType g() {
        return this.c;
    }

    public long i() {
        return this.g;
    }

    public float[] j() {
        return this.e;
    }

    public float k() {
        return this.h;
    }

    public a l(float f10) {
        this.d = f10;
        return this;
    }

    public a m(Long l10) {
        this.f = l10;
        return this;
    }

    public a n(a$a a$a) {
        this.b = a$a;
        return this;
    }

    public a o(DecorationType decorationType) {
        this.c = decorationType;
        return this;
    }

    public a p(long l10) {
        this.g = l10;
        return this;
    }

    public a q(float[] fArray) {
        this.e = fArray;
        return this;
    }

    public a r(float f10) {
        this.h = f10;
        return this;
    }
}

