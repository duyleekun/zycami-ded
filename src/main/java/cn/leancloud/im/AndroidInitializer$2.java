/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVOSCloud;
import cn.leancloud.internal.ThreadModel$ThreadShuttle;

public final class AndroidInitializer$2
implements ThreadModel$ThreadShuttle {
    public void launch(Runnable runnable) {
        AVOSCloud.getHandler().post(runnable);
    }
}

