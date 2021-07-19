/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.display.DisplayManager
 *  android.hardware.display.DisplayManager$DisplayListener
 *  android.os.Handler
 */
package com.google.android.exoplayer2.video;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper;

public final class VideoFrameReleaseHelper$DefaultDisplayListener
implements DisplayManager.DisplayListener {
    private final DisplayManager displayManager;
    public final /* synthetic */ VideoFrameReleaseHelper this$0;

    public VideoFrameReleaseHelper$DefaultDisplayListener(VideoFrameReleaseHelper videoFrameReleaseHelper, DisplayManager displayManager) {
        this.this$0 = videoFrameReleaseHelper;
        this.displayManager = displayManager;
    }

    public void onDisplayAdded(int n10) {
    }

    public void onDisplayChanged(int n10) {
        if (n10 == 0) {
            VideoFrameReleaseHelper videoFrameReleaseHelper = this.this$0;
            VideoFrameReleaseHelper.access$000(videoFrameReleaseHelper);
        }
    }

    public void onDisplayRemoved(int n10) {
    }

    public void register() {
        DisplayManager displayManager = this.displayManager;
        Handler handler = Util.createHandlerForCurrentLooper();
        displayManager.registerDisplayListener((DisplayManager.DisplayListener)this, handler);
    }

    public void unregister() {
        this.displayManager.unregisterDisplayListener((DisplayManager.DisplayListener)this);
    }
}

