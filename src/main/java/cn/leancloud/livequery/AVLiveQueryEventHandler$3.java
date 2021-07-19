/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVObject;
import cn.leancloud.livequery.AVLiveQueryEventHandler;

public class AVLiveQueryEventHandler$3
implements Runnable {
    public final /* synthetic */ AVLiveQueryEventHandler this$0;
    public final /* synthetic */ AVObject val$avObject;

    public AVLiveQueryEventHandler$3(AVLiveQueryEventHandler aVLiveQueryEventHandler, AVObject aVObject) {
        this.this$0 = aVLiveQueryEventHandler;
        this.val$avObject = aVObject;
    }

    public void run() {
        AVLiveQueryEventHandler aVLiveQueryEventHandler = this.this$0;
        String string2 = this.val$avObject.getObjectId();
        aVLiveQueryEventHandler.onObjectDeleted(string2);
    }
}

