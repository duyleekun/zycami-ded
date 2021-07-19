/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.a$g;
import i.g.c;
import i.g.d;
import java.util.concurrent.Flow;

public final class a$a
implements Flow.Publisher {
    public final c a;

    public a$a(c c10) {
        this.a = c10;
    }

    public void a(Flow.Subscriber object) {
        c c10 = this.a;
        if (object == null) {
            object = null;
        } else {
            a$g a$g = new a$g((Flow.Subscriber)object);
            object = a$g;
        }
        c10.subscribe((d)object);
    }
}

