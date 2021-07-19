/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.a$c;
import i.g.a$d;
import i.g.b;
import i.g.d;
import i.g.e;
import java.util.concurrent.Flow;

public final class a$f
implements b {
    public final Flow.Processor a;

    public a$f(Flow.Processor processor) {
        this.a = processor;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(e object) {
        Flow.Processor processor = this.a;
        if (object == null) {
            object = null;
        } else {
            a$d a$d = new a$d((e)object);
            object = a$d;
        }
        processor.onSubscribe((Flow.Subscription)object);
    }

    public void subscribe(d object) {
        Flow.Processor processor = this.a;
        if (object == null) {
            object = null;
        } else {
            a$c a$c = new a$c((d)object);
            object = a$c;
        }
        processor.subscribe(object);
    }
}

