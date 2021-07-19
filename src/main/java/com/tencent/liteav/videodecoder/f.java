/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videodecoder;

import com.tencent.liteav.basic.structs.TXSVideoFrame;

public interface f {
    public void onDecodeFailed(int var1);

    public void onDecodeFrame(TXSVideoFrame var1, int var2, int var3, long var4, long var6, int var8);

    public void onVideoSizeChange(int var1, int var2);
}

