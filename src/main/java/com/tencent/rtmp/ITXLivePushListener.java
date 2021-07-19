/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.rtmp;

import android.os.Bundle;

public interface ITXLivePushListener {
    public void onNetStatus(Bundle var1);

    public void onPushEvent(int var1, Bundle var2);
}

