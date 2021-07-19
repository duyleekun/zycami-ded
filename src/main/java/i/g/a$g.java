/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.a$d;
import i.g.d;
import i.g.e;
import java.util.concurrent.Flow;

public final class a$g
implements d {
    public final Flow.Subscriber a;

    public a$g(Flow.Subscriber subscriber) {
        this.a = subscriber;
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
        Flow.Subscriber subscriber = this.a;
        if (object == null) {
            object = null;
        } else {
            a$d a$d = new a$d((e)object);
            object = a$d;
        }
        subscriber.onSubscribe((Flow.Subscription)object);
    }
}

