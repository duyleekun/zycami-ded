/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.AVIMEventHandler$1;
import cn.leancloud.internal.ThreadModel$MainThreadChecker;
import cn.leancloud.internal.ThreadModel$ThreadShuttle;

public abstract class AVIMEventHandler {
    private static volatile ThreadModel$MainThreadChecker mainThreadChecker;
    private static volatile boolean needCheckMainThread = false;
    private static volatile ThreadModel$ThreadShuttle threadShuttle;

    public static void setMainThreadChecker(ThreadModel$MainThreadChecker threadModel$MainThreadChecker, ThreadModel$ThreadShuttle threadModel$ThreadShuttle) {
        if (threadModel$MainThreadChecker == null) {
            needCheckMainThread = false;
            threadModel$MainThreadChecker = null;
            mainThreadChecker = null;
            threadShuttle = null;
        } else {
            boolean bl2;
            needCheckMainThread = bl2 = true;
            mainThreadChecker = threadModel$MainThreadChecker;
            threadShuttle = threadModel$ThreadShuttle;
        }
    }

    public void processEvent(int n10, Object object, Object object2, Object object3) {
        Object object4;
        boolean bl2 = needCheckMainThread;
        if (bl2 && !(bl2 = (object4 = mainThreadChecker).isMainThread())) {
            object4 = threadShuttle;
            AVIMEventHandler$1 aVIMEventHandler$1 = new AVIMEventHandler$1(this, n10, object, object2, object3);
            object4.launch(aVIMEventHandler$1);
        } else {
            this.processEvent0(n10, object, object2, object3);
        }
    }

    public abstract void processEvent0(int var1, Object var2, Object var3, Object var4);
}

