/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback$1;
import cn.leancloud.internal.ThreadModel$MainThreadChecker;
import cn.leancloud.internal.ThreadModel$ThreadShuttle;

public abstract class AVCallback {
    private static volatile ThreadModel$MainThreadChecker mainThreadChecker;
    private static volatile boolean needCheckMainThread = false;
    private static volatile ThreadModel$ThreadShuttle threadShuttle;

    public static void setMainThreadChecker(ThreadModel$MainThreadChecker mainThreadChecker, ThreadModel$ThreadShuttle threadShuttle) {
        if (mainThreadChecker == null) {
            needCheckMainThread = false;
            mainThreadChecker = null;
            AVCallback.mainThreadChecker = null;
            AVCallback.threadShuttle = null;
        } else {
            boolean bl2;
            needCheckMainThread = bl2 = true;
            AVCallback.mainThreadChecker = mainThreadChecker;
            AVCallback.threadShuttle = threadShuttle;
        }
    }

    public void internalDone(AVException aVException) {
        this.internalDone(null, aVException);
    }

    public void internalDone(Object object, AVException aVException) {
        Object object2;
        boolean bl2 = needCheckMainThread;
        if (bl2 && !(bl2 = (object2 = mainThreadChecker).isMainThread())) {
            object2 = threadShuttle;
            AVCallback$1 aVCallback$1 = new AVCallback$1(this, object, aVException);
            object2.launch(aVCallback$1);
        } else {
            this.internalDone0(object, aVException);
        }
    }

    public abstract void internalDone0(Object var1, AVException var2);
}

