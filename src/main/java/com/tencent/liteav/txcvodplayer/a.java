/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.tencent.liteav.txcvodplayer;

import android.view.View;
import com.tencent.liteav.txcvodplayer.a$a;

public interface a {
    public void addRenderCallback(a$a var1);

    public View getView();

    public void removeRenderCallback(a$a var1);

    public void setAspectRatio(int var1);

    public void setVideoRotation(int var1);

    public void setVideoSampleAspectRatio(int var1, int var2);

    public void setVideoSize(int var1, int var2);

    public boolean shouldWaitForResize();
}

