/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.FrameMetrics
 *  android.view.Window
 *  android.view.Window$OnFrameMetricsAvailableListener
 */
package androidx.core.app;

import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl;

public class FrameMetricsAggregator$FrameMetricsApi24Impl$1
implements Window.OnFrameMetricsAvailableListener {
    public final /* synthetic */ FrameMetricsAggregator$FrameMetricsApi24Impl this$0;

    public FrameMetricsAggregator$FrameMetricsApi24Impl$1(FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsApi24Impl) {
        this.this$0 = frameMetricsApi24Impl;
    }

    public void onFrameMetricsAvailable(Window object, FrameMetrics frameMetrics, int n10) {
        long l10;
        long l11;
        long l12;
        SparseIntArray sparseIntArray;
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags;
        int n11 = 1;
        int n12 = 8;
        if ((n10 &= n11) != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[0];
            long l13 = frameMetrics.getMetric(n12);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l13);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags;
        int n13 = 2;
        if ((n10 &= n13) != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n11];
            l12 = frameMetrics.getMetric(n11);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l12);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags;
        n11 = 4;
        int n14 = 3;
        if ((n10 &= n11) != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n13];
            l11 = frameMetrics.getMetric(n14);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l11);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags & n12;
        if (n10 != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n14];
            l12 = frameMetrics.getMetric(n11);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l12);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags & 0x10;
        n14 = 5;
        if (n10 != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n11];
            l11 = frameMetrics.getMetric(n14);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l11);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags & 0x40;
        n11 = 7;
        int n15 = 6;
        if (n10 != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n15];
            long l14 = frameMetrics.getMetric(n11);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l14);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags & 0x20;
        if (n10 != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n14];
            l12 = frameMetrics.getMetric(n15);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l12);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags & 0x80;
        if (n10 != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n11];
            l10 = frameMetrics.getMetric(0);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l10);
        }
        object = this.this$0;
        n10 = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mTrackingFlags & 0x100;
        if (n10 != 0) {
            sparseIntArray = ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).mMetrics[n12];
            l10 = frameMetrics.getMetric(n13);
            ((FrameMetricsAggregator$FrameMetricsApi24Impl)object).addDurationItem(sparseIntArray, l10);
        }
    }
}

