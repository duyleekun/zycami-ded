/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.rtmp.TXVodPlayer;

public interface ITXVodPlayListener {
    public void onNetStatus(TXVodPlayer var1, Bundle var2);

    public void onPlayEvent(TXVodPlayer var1, int var2, Bundle var3);
}

