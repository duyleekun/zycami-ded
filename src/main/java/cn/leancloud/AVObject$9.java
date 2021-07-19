/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.types.AVNull;
import e.a.g0;
import e.a.s0.b;

public class AVObject$9
implements g0 {
    public final /* synthetic */ AVObject this$0;

    public AVObject$9(AVObject aVObject) {
        this.this$0 = aVObject;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        AVObject.access$100(this.this$0, true);
    }

    public void onNext(AVNull aVNull) {
        AVObject.logger.d("succeed to delete directly.");
    }

    public void onSubscribe(b b10) {
    }
}

