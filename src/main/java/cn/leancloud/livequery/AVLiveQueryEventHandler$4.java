/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVObject;
import cn.leancloud.livequery.AVLiveQueryEventHandler;
import java.util.List;

public class AVLiveQueryEventHandler$4
implements Runnable {
    public final /* synthetic */ AVLiveQueryEventHandler this$0;
    public final /* synthetic */ AVObject val$avObject;
    public final /* synthetic */ List val$updateKeyList;

    public AVLiveQueryEventHandler$4(AVLiveQueryEventHandler aVLiveQueryEventHandler, AVObject aVObject, List list) {
        this.this$0 = aVLiveQueryEventHandler;
        this.val$avObject = aVObject;
        this.val$updateKeyList = list;
    }

    public void run() {
        AVLiveQueryEventHandler aVLiveQueryEventHandler = this.this$0;
        AVObject aVObject = this.val$avObject;
        List list = this.val$updateKeyList;
        aVLiveQueryEventHandler.onObjectLeave(aVObject, list);
    }
}

