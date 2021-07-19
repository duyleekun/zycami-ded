/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.internal.ThreadModel$MainThreadChecker;
import cn.leancloud.util.AndroidUtil;

public final class AVOSCloud$1
implements ThreadModel$MainThreadChecker {
    public boolean isMainThread() {
        return AndroidUtil.isMainThread();
    }
}

