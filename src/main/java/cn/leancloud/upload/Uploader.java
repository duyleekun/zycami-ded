/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;

public interface Uploader {
    public boolean cancel(boolean var1);

    public AVException execute();

    public boolean isCancelled();

    public void publishProgress(int var1);
}

