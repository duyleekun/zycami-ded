/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.loopshare.watermark;

public interface WaterMarkListener {
    public void onCancel();

    public void onEnd(int var1);

    public void onFailed(String var1, int var2);

    public void onProgress(int var1);

    public void onStart();
}

