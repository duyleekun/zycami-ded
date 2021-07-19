/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.convertor;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import e.a.g0;
import e.a.s0.b;
import java.util.List;

public class ObserverBuilder$CollectionObserver
implements g0 {
    private AVCallback callback;

    public ObserverBuilder$CollectionObserver(AVCallback aVCallback) {
        this.callback = aVCallback;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        AVException aVException = new AVException(throwable);
        this.callback.internalDone(aVException);
    }

    public void onNext(List list) {
        this.callback.internalDone(list, null);
    }

    public void onSubscribe(b b10) {
    }
}

