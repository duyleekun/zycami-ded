/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import e.a.g0;
import e.a.s0.b;

public class AVObject$8
implements g0 {
    public final /* synthetic */ AVObject this$0;

    public AVObject$8(AVObject aVObject) {
        this.this$0 = aVObject;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        AVObject.access$100(this.this$0, false);
    }

    public void onNext(AVObject aVObject) {
        AVObject.logger.d("succeed to save directly");
    }

    public void onSubscribe(b b10) {
    }
}

