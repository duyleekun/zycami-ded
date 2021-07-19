/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;

public final class DefaultLoadControl$Builder {
    private DefaultAllocator allocator;
    private int backBufferDurationMs;
    private int bufferForPlaybackAfterRebufferMs;
    private int bufferForPlaybackMs;
    private boolean buildCalled;
    private int maxBufferMs;
    private int minBufferMs;
    private boolean prioritizeTimeOverSizeThresholds;
    private boolean retainBackBufferFromKeyframe;
    private int targetBufferBytes;

    public DefaultLoadControl$Builder() {
        int n10;
        this.minBufferMs = n10 = 50000;
        this.maxBufferMs = n10;
        this.bufferForPlaybackMs = 2500;
        this.bufferForPlaybackAfterRebufferMs = 5000;
        this.targetBufferBytes = -1;
        this.prioritizeTimeOverSizeThresholds = false;
        this.backBufferDurationMs = 0;
        this.retainBackBufferFromKeyframe = false;
    }

    public DefaultLoadControl build() {
        boolean bl2 = this.buildCalled;
        boolean bl3 = true;
        Assertions.checkState(bl2 ^= bl3);
        this.buildCalled = bl3;
        Object object = this.allocator;
        if (object == null) {
            int n10 = 65536;
            this.allocator = object = new DefaultAllocator(bl3, n10);
        }
        DefaultAllocator defaultAllocator = this.allocator;
        int n11 = this.minBufferMs;
        int n12 = this.maxBufferMs;
        int n13 = this.bufferForPlaybackMs;
        int n14 = this.bufferForPlaybackAfterRebufferMs;
        int n15 = this.targetBufferBytes;
        boolean bl4 = this.prioritizeTimeOverSizeThresholds;
        int n16 = this.backBufferDurationMs;
        boolean bl5 = this.retainBackBufferFromKeyframe;
        object = new DefaultLoadControl(defaultAllocator, n11, n12, n13, n14, n15, bl4, n16, bl5);
        return object;
    }

    public DefaultLoadControl createDefaultLoadControl() {
        return this.build();
    }

    public DefaultLoadControl$Builder setAllocator(DefaultAllocator defaultAllocator) {
        Assertions.checkState(this.buildCalled ^ true);
        this.allocator = defaultAllocator;
        return this;
    }

    public DefaultLoadControl$Builder setBackBuffer(int n10, boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        DefaultLoadControl.access$000(n10, 0, "backBufferDurationMs", "0");
        this.backBufferDurationMs = n10;
        this.retainBackBufferFromKeyframe = bl2;
        return this;
    }

    public DefaultLoadControl$Builder setBufferDurationsMs(int n10, int n11, int n12, int n13) {
        Assertions.checkState(this.buildCalled ^ true);
        String string2 = "bufferForPlaybackMs";
        String string3 = "0";
        DefaultLoadControl.access$000(n12, 0, string2, string3);
        String string4 = "bufferForPlaybackAfterRebufferMs";
        DefaultLoadControl.access$000(n13, 0, string4, string3);
        String string5 = "minBufferMs";
        DefaultLoadControl.access$000(n10, n12, string5, string2);
        DefaultLoadControl.access$000(n10, n13, string5, string4);
        DefaultLoadControl.access$000(n11, n10, "maxBufferMs", string5);
        this.minBufferMs = n10;
        this.maxBufferMs = n11;
        this.bufferForPlaybackMs = n12;
        this.bufferForPlaybackAfterRebufferMs = n13;
        return this;
    }

    public DefaultLoadControl$Builder setPrioritizeTimeOverSizeThresholds(boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.prioritizeTimeOverSizeThresholds = bl2;
        return this;
    }

    public DefaultLoadControl$Builder setTargetBufferBytes(int n10) {
        Assertions.checkState(this.buildCalled ^ true);
        this.targetBufferBytes = n10;
        return this;
    }
}

