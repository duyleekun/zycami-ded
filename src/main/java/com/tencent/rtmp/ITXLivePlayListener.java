/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.rtmp;

import android.os.Bundle;

public interface ITXLivePlayListener {
    public void onNetStatus(Bundle var1);

    public void onPlayEvent(int var1, Bundle var2);
}

