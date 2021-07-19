/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import androidx.core.util.Pair;
import com.airbnb.lottie.PerformanceTracker;
import java.util.Comparator;

public class PerformanceTracker$1
implements Comparator {
    public final /* synthetic */ PerformanceTracker this$0;

    public PerformanceTracker$1(PerformanceTracker performanceTracker) {
        this.this$0 = performanceTracker;
    }

    public int compare(Pair object, Pair object2) {
        object = (Float)((Pair)object).second;
        float f10 = ((Float)object).floatValue();
        object2 = (Float)((Pair)object2).second;
        float f11 = ((Float)object2).floatValue();
        float f12 = f11 - f10;
        Object object3 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object3 > 0) {
            return 1;
        }
        Object object4 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object4 > 0) {
            return -1;
        }
        return 0;
    }
}

