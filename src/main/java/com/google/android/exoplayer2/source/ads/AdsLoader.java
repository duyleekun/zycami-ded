/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider;
import com.google.android.exoplayer2.source.ads.AdsLoader$EventListener;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public interface AdsLoader {
    public void handlePrepareComplete(AdsMediaSource var1, int var2, int var3);

    public void handlePrepareError(AdsMediaSource var1, int var2, int var3, IOException var4);

    public void release();

    public void setPlayer(Player var1);

    public void setSupportedContentTypes(int ... var1);

    public void start(AdsMediaSource var1, DataSpec var2, Object var3, AdsLoader$AdViewProvider var4, AdsLoader$EventListener var5);

    public void stop(AdsMediaSource var1, AdsLoader$EventListener var2);
}

