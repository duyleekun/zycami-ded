/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.a$a;
import i.g.a$b;
import i.g.a$c;
import i.g.a$e;
import i.g.a$f;
import i.g.a$g;
import i.g.b;
import i.g.c;
import i.g.d;
import java.util.Objects;
import java.util.concurrent.Flow;

public final class a {
    private a() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static Flow.Processor a(b b10) {
        throw null;
    }

    public static Flow.Publisher b(c c10) {
        throw null;
    }

    public static Flow.Subscriber c(d d10) {
        throw null;
    }

    public static b d(Flow.Processor object) {
        Object object2 = "flowProcessor";
        Objects.requireNonNull(object, (String)object2);
        boolean bl2 = object instanceof a$b;
        object = bl2 ? ((a$b)object).a : ((bl2 = object instanceof b) ? (b)object : (object2 = new a$f((Flow.Processor)object)));
        return object;
    }

    public static c e(Flow.Publisher object) {
        Object object2 = "flowPublisher";
        Objects.requireNonNull(object, (String)object2);
        boolean bl2 = object instanceof a$a;
        object = bl2 ? ((a$a)object).a : ((bl2 = object instanceof c) ? (c)object : (object2 = new a$e((Flow.Publisher)object)));
        return object;
    }

    public static d f(Flow.Subscriber object) {
        Object object2 = "flowSubscriber";
        Objects.requireNonNull(object, (String)object2);
        boolean bl2 = object instanceof a$c;
        object = bl2 ? ((a$c)object).a : ((bl2 = object instanceof d) ? (d)object : (object2 = new a$g((Flow.Subscriber)object)));
        return object;
    }
}

