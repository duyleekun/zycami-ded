/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision.face;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.LargestFaceFocusingProcessor;

public class LargestFaceFocusingProcessor$Builder {
    private LargestFaceFocusingProcessor zzcx;

    public LargestFaceFocusingProcessor$Builder(Detector detector, Tracker tracker) {
        LargestFaceFocusingProcessor largestFaceFocusingProcessor;
        this.zzcx = largestFaceFocusingProcessor = new LargestFaceFocusingProcessor(detector, tracker);
    }

    public LargestFaceFocusingProcessor build() {
        return this.zzcx;
    }

    public LargestFaceFocusingProcessor$Builder setMaxGapFrames(int n10) {
        LargestFaceFocusingProcessor.zza(this.zzcx, n10);
        return this;
    }
}

