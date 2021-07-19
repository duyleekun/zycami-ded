/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.convertor;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import e.a.g0;
import e.a.s0.b;

public class ObserverBuilder$SingleObjectObserver
implements g0 {
    private AVCallback callback;
    private boolean nextCalled = false;

    public ObserverBuilder$SingleObjectObserver(AVCallback aVCallback) {
        this.callback = aVCallback;
    }

    public void onComplete() {
        boolean bl2 = this.nextCalled;
        if (!bl2) {
            AVCallback aVCallback = this.callback;
            aVCallback.internalDone(null, null);
        }
    }

    public void onError(Throwable throwable) {
        AVException aVException = new AVException(throwable);
        this.callback.internalDone(aVException);
    }

    public void onNext(Object object) {
        this.nextCalled = true;
        this.callback.internalDone(object, null);
    }

    public void onSubscribe(b b10) {
    }
}

