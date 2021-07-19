/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVException;
import cn.leancloud.livequery.AVLiveQuery;
import cn.leancloud.livequery.AVLiveQuerySubscribeCallback;
import java.util.Map;

public class AVLiveQuery$1
extends AVLiveQuerySubscribeCallback {
    public final /* synthetic */ AVLiveQuery this$0;
    public final /* synthetic */ AVLiveQuerySubscribeCallback val$callback;
    public final /* synthetic */ Map val$dataMap;

    public AVLiveQuery$1(AVLiveQuery aVLiveQuery, AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback, Map map) {
        this.this$0 = aVLiveQuery;
        this.val$callback = aVLiveQuerySubscribeCallback;
        this.val$dataMap = map;
    }

    public void done(AVException object) {
        if (object != null) {
            AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback = this.val$callback;
            if (aVLiveQuerySubscribeCallback != null) {
                aVLiveQuerySubscribeCallback.internalDone((AVException)object);
            }
            return;
        }
        object = this.this$0;
        Map map = this.val$dataMap;
        AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback = this.val$callback;
        AVLiveQuery.access$000((AVLiveQuery)object, map, aVLiveQuerySubscribeCallback);
    }
}

