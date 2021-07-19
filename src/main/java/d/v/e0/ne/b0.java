/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import d.v.e0.ne.q0;
import e.a.v0.g;
import io.reactivex.subjects.PublishSubject;

public final class b0
implements g {
    public final /* synthetic */ PublishSubject a;

    public /* synthetic */ b0(PublishSubject publishSubject) {
        this.a = publishSubject;
    }

    public final void accept(Object object) {
        PublishSubject publishSubject = this.a;
        object = (q0)object;
        publishSubject.onNext(object);
    }
}

