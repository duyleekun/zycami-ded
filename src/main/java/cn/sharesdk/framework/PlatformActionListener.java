/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import java.util.HashMap;

public interface PlatformActionListener {
    public void onCancel(Platform var1, int var2);

    public void onComplete(Platform var1, int var2, HashMap var3);

    public void onError(Platform var1, int var2, Throwable var3);
}

