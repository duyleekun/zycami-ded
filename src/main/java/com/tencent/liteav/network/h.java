/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;

public interface h {
    public void onPullAudio(a var1);

    public void onPullNAL(TXSNALPacket var1);
}

