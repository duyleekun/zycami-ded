/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import java.nio.ByteBuffer;

public interface NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback {
    public void notifyFinsih(long var1, int var3);

    public void notifyProgress(long var1, float var3);

    public void notifySengmentData(long var1, ByteBuffer var3, int var4, int var5, int var6, int var7);
}

