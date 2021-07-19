/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.a$c;
import i.g.c;
import i.g.d;
import java.util.concurrent.Flow;

public final class a$e
implements c {
    public final Flow.Publisher a;

    public a$e(Flow.Publisher publisher) {
        this.a = publisher;
    }

    public void subscribe(d object) {
        Flow.Publisher publisher = this.a;
        if (object == null) {
            object = null;
        } else {
            a$c a$c = new a$c((d)object);
            object = a$c;
        }
        publisher.subscribe(object);
    }
}

