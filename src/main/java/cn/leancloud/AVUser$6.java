/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVUser;
import cn.leancloud.callback.FollowersAndFolloweesCallback;
import cn.leancloud.json.JSONObject;
import e.a.g0;
import e.a.s0.b;
import java.util.Map;

public class AVUser$6
implements g0 {
    public final /* synthetic */ AVUser this$0;
    public final /* synthetic */ FollowersAndFolloweesCallback val$callback;

    public AVUser$6(AVUser aVUser, FollowersAndFolloweesCallback followersAndFolloweesCallback) {
        this.this$0 = aVUser;
        this.val$callback = followersAndFolloweesCallback;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        FollowersAndFolloweesCallback followersAndFolloweesCallback = this.val$callback;
        AVException aVException = new AVException(throwable);
        followersAndFolloweesCallback.done(null, aVException);
    }

    public void onNext(JSONObject object) {
        if (object == null) {
            object = this.val$callback;
            ((FollowersAndFolloweesCallback)object).done(null, null);
        } else {
            object = AVUser.access$000(this.this$0, (JSONObject)object);
            FollowersAndFolloweesCallback followersAndFolloweesCallback = this.val$callback;
            followersAndFolloweesCallback.done((Map)object, null);
        }
    }

    public void onSubscribe(b b10) {
    }
}

