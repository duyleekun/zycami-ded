/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.livequery.AVLiveQueryEventHandler;

public class AVLiveQueryEventHandler$5
implements Runnable {
    public final /* synthetic */ AVLiveQueryEventHandler this$0;
    public final /* synthetic */ AVObject val$avObject;

    public AVLiveQueryEventHandler$5(AVLiveQueryEventHandler aVLiveQueryEventHandler, AVObject aVObject) {
        this.this$0 = aVLiveQueryEventHandler;
        this.val$avObject = aVObject;
    }

    public void run() {
        AVObject aVObject = this.val$avObject;
        boolean bl2 = aVObject instanceof AVUser;
        if (bl2) {
            AVLiveQueryEventHandler aVLiveQueryEventHandler = this.this$0;
            aVObject = (AVUser)aVObject;
            aVLiveQueryEventHandler.onUserLogin((AVUser)aVObject);
        }
    }
}

