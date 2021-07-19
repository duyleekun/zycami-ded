/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 */
package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class VideoFrameReleaseHelper$VSyncSampler
implements Choreographer.FrameCallback,
Handler.Callback {
    private static final int CREATE_CHOREOGRAPHER = 0;
    private static final VideoFrameReleaseHelper$VSyncSampler INSTANCE;
    private static final int MSG_ADD_OBSERVER = 1;
    private static final int MSG_REMOVE_OBSERVER = 2;
    private Choreographer choreographer;
    private final HandlerThread choreographerOwnerThread;
    private final Handler handler;
    private int observerCount;
    public volatile long sampledVsyncTimeNs = -9223372036854775807L;

    static {
        VideoFrameReleaseHelper$VSyncSampler videoFrameReleaseHelper$VSyncSampler;
        INSTANCE = videoFrameReleaseHelper$VSyncSampler = new VideoFrameReleaseHelper$VSyncSampler();
    }

    private VideoFrameReleaseHelper$VSyncSampler() {
        HandlerThread handlerThread;
        this.choreographerOwnerThread = handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        handlerThread = Util.createHandler(handlerThread.getLooper(), this);
        this.handler = handlerThread;
        handlerThread.sendEmptyMessage(0);
    }

    private void addObserverInternal() {
        int n10 = this.observerCount;
        int n11 = 1;
        this.observerCount = n10 += n11;
        if (n10 == n11) {
            Choreographer choreographer = (Choreographer)Assertions.checkNotNull(this.choreographer);
            choreographer.postFrameCallback((Choreographer.FrameCallback)this);
        }
    }

    private void createChoreographerInstanceInternal() {
        Choreographer choreographer;
        this.choreographer = choreographer = Choreographer.getInstance();
    }

    public static VideoFrameReleaseHelper$VSyncSampler getInstance() {
        return INSTANCE;
    }

    private void removeObserverInternal() {
        int n10;
        this.observerCount = n10 = this.observerCount + -1;
        if (n10 == 0) {
            long l10;
            Choreographer choreographer = (Choreographer)Assertions.checkNotNull(this.choreographer);
            choreographer.removeFrameCallback((Choreographer.FrameCallback)this);
            this.sampledVsyncTimeNs = l10 = -9223372036854775807L;
        }
    }

    public void addObserver() {
        this.handler.sendEmptyMessage(1);
    }

    public void doFrame(long l10) {
        this.sampledVsyncTimeNs = l10;
        ((Choreographer)Assertions.checkNotNull(this.choreographer)).postFrameCallbackDelayed((Choreographer.FrameCallback)this, 500L);
    }

    public boolean handleMessage(Message message) {
        boolean bl2 = message.what;
        boolean bl3 = true;
        if (bl2) {
            if (bl2 != bl3) {
                boolean bl4 = 2 != 0;
                if (bl2 != bl4) {
                    return false;
                }
                this.removeObserverInternal();
                return bl3;
            }
            this.addObserverInternal();
            return bl3;
        }
        this.createChoreographerInstanceInternal();
        return bl3;
    }

    public void removeObserver() {
        this.handler.sendEmptyMessage(2);
    }
}

