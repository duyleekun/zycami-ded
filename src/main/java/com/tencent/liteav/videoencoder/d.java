/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 */
package com.tencent.liteav.videoencoder;

import android.media.MediaFormat;
import com.tencent.liteav.basic.structs.TXSNALPacket;

public interface d {
    public void a(int var1, long var2, long var4);

    public void a(MediaFormat var1);

    public void a(TXSNALPacket var1, int var2);

    public void g(int var1);

    public void h(int var1);
}

