/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.json.JSONObject;
import cn.leancloud.livequery.AVLiveQuery;
import cn.leancloud.livequery.AVLiveQuerySubscribeCallback;
import e.a.g0;
import e.a.s0.b;

public class AVLiveQuery$3
implements g0 {
    public final /* synthetic */ AVLiveQuery this$0;
    public final /* synthetic */ AVLiveQuerySubscribeCallback val$callback;

    public AVLiveQuery$3(AVLiveQuery aVLiveQuery, AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback) {
        this.this$0 = aVLiveQuery;
        this.val$callback = aVLiveQuerySubscribeCallback;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback = this.val$callback;
        if (aVLiveQuerySubscribeCallback != null) {
            AVException aVException = new AVException(throwable);
            aVLiveQuerySubscribeCallback.internalDone(aVException);
        }
    }

    public void onNext(JSONObject object) {
        object = AVLiveQuery.access$200();
        Object object2 = this.this$0;
        object.remove(object2);
        object = this.this$0;
        object2 = "";
        AVLiveQuery.access$102((AVLiveQuery)object, (String)object2);
        object = this.val$callback;
        if (object != null) {
            object2 = null;
            ((AVCallback)object).internalDone(null);
        }
    }

    public void onSubscribe(b b10) {
    }
}

