/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.l;
import c.a.n.c;
import c.a.n.d;
import java.lang.annotation.Annotation;

public final class r
implements d {
    private final c a;
    private final Annotation b;

    public r(c object, Annotation annotation) {
        object = (c)l.a(object);
        this.a = object;
        this.b = object = (Annotation)l.a(annotation);
    }

    public void a() {
        this.a.a();
    }

    public Annotation b() {
        return this.b;
    }

    public Class c() {
        return this.a.c();
    }

    public void d() {
        this.a.d();
    }
}

