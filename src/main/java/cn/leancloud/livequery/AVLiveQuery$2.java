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

public class AVLiveQuery$2
implements g0 {
    public final /* synthetic */ AVLiveQuery this$0;
    public final /* synthetic */ AVLiveQuerySubscribeCallback val$callback;

    public AVLiveQuery$2(AVLiveQuery aVLiveQuery, AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback) {
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
        Object object2;
        int n10;
        if (object != null && (n10 = object.containsKey(object2 = "query_id")) != 0) {
            AVLiveQuery aVLiveQuery = this.this$0;
            object = ((JSONObject)object).getString((String)object2);
            AVLiveQuery.access$102(aVLiveQuery, (String)object);
            object = AVLiveQuery.access$200();
            object2 = this.this$0;
            object.add(object2);
            object = this.val$callback;
            if (object != null) {
                object2 = null;
                ((AVCallback)object).internalDone(null);
            }
            return;
        }
        object = this.val$callback;
        if (object != null) {
            n10 = 999;
            String string2 = "response isn't recognized";
            object2 = new AVException(n10, string2);
            ((AVCallback)object).internalDone((AVException)object2);
        }
    }

    public void onSubscribe(b b10) {
    }
}

