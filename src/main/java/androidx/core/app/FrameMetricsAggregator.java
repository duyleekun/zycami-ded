/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.util.SparseIntArray
 */
package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl;
import androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl;

public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX;
    private FrameMetricsAggregator$FrameMetricsBaseImpl mInstance;

    public FrameMetricsAggregator() {
        this(1);
    }

    public FrameMetricsAggregator(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl = new FrameMetricsAggregator$FrameMetricsApi24Impl(n10);
            this.mInstance = frameMetricsAggregator$FrameMetricsApi24Impl;
        } else {
            FrameMetricsAggregator$FrameMetricsBaseImpl frameMetricsAggregator$FrameMetricsBaseImpl;
            this.mInstance = frameMetricsAggregator$FrameMetricsBaseImpl = new FrameMetricsAggregator$FrameMetricsBaseImpl();
        }
    }

    public void add(Activity activity) {
        this.mInstance.add(activity);
    }

    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    public SparseIntArray[] remove(Activity activity) {
        return this.mInstance.remove(activity);
    }

    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    public SparseIntArray[] stop() {
        return this.mInstance.stop();
    }
}

