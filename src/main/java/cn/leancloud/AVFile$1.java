/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.ProgressCallback;
import e.a.g0;
import e.a.s0.b;

public class AVFile$1
implements g0 {
    public final /* synthetic */ AVFile this$0;
    public final /* synthetic */ ProgressCallback val$progressCallback;

    public AVFile$1(AVFile aVFile, ProgressCallback progressCallback) {
        this.this$0 = aVFile;
        this.val$progressCallback = progressCallback;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        ProgressCallback progressCallback = this.val$progressCallback;
        if (progressCallback != null) {
            int n10 = 90;
            Integer n11 = n10;
            AVException aVException = new AVException(throwable);
            progressCallback.internalDone(n11, aVException);
        }
    }

    public void onNext(AVFile object) {
        object = this.val$progressCallback;
        if (object != null) {
            int n10 = 100;
            Integer n11 = n10;
            ((AVCallback)object).internalDone(n11, null);
        }
    }

    public void onSubscribe(b b10) {
    }
}

