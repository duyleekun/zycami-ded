/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.AVIMEventHandler;

public class AVIMEventHandler$1
implements Runnable {
    public final /* synthetic */ AVIMEventHandler this$0;
    public final /* synthetic */ Object val$eventScene;
    public final /* synthetic */ Object val$operand;
    public final /* synthetic */ int val$operation;
    public final /* synthetic */ Object val$operator;

    public AVIMEventHandler$1(AVIMEventHandler aVIMEventHandler, int n10, Object object, Object object2, Object object3) {
        this.this$0 = aVIMEventHandler;
        this.val$operation = n10;
        this.val$operator = object;
        this.val$operand = object2;
        this.val$eventScene = object3;
    }

    public void run() {
        AVIMEventHandler aVIMEventHandler = this.this$0;
        int n10 = this.val$operation;
        Object object = this.val$operator;
        Object object2 = this.val$operand;
        Object object3 = this.val$eventScene;
        aVIMEventHandler.processEvent0(n10, object, object2, object3);
    }
}

