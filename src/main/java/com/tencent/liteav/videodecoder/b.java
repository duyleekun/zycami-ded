/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.videodecoder.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public interface b {
    public int GetDecodeCost();

    public int config(Surface var1);

    public void decode(TXSNALPacket var1);

    public void enableLimitDecCache(boolean var1);

    public boolean isHevc();

    public void setListener(f var1);

    public void setNotifyListener(WeakReference var1);

    public int start(ByteBuffer var1, ByteBuffer var2, boolean var3, boolean var4);

    public void stop();
}

