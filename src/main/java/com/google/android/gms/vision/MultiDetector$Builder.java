/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.MultiDetector;

public class MultiDetector$Builder {
    private MultiDetector zzbg;

    public MultiDetector$Builder() {
        MultiDetector multiDetector;
        this.zzbg = multiDetector = new MultiDetector(null);
    }

    public MultiDetector$Builder add(Detector detector) {
        MultiDetector.zza(this.zzbg).add(detector);
        return this;
    }

    public MultiDetector build() {
        Object object = MultiDetector.zza(this.zzbg);
        int n10 = object.size();
        if (n10 != 0) {
            return this.zzbg;
        }
        object = new RuntimeException("No underlying detectors added to MultiDetector.");
        throw object;
    }
}

