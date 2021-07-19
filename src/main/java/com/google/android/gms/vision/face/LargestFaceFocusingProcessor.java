/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision.face;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Detector$Detections;
import com.google.android.gms.vision.FocusingProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;

public class LargestFaceFocusingProcessor
extends FocusingProcessor {
    public LargestFaceFocusingProcessor(Detector detector, Tracker tracker) {
        super(detector, tracker);
    }

    public static /* synthetic */ void zza(LargestFaceFocusingProcessor largestFaceFocusingProcessor, int n10) {
        largestFaceFocusingProcessor.zza(n10);
    }

    public int selectFocus(Detector$Detections object) {
        int n10 = (object = ((Detector$Detections)object).getDetectedItems()).size();
        if (n10 != 0) {
            int n11;
            n10 = 0;
            int n12 = object.keyAt(0);
            Face face = (Face)object.valueAt(0);
            float f10 = face.getWidth();
            for (int i10 = 1; i10 < (n11 = object.size()); ++i10) {
                n11 = object.keyAt(i10);
                Face face2 = (Face)object.valueAt(i10);
                float f11 = face2.getWidth();
                float f12 = f11 - f10;
                Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                if (object2 <= 0) continue;
                n12 = n11;
                f10 = f11;
            }
            return n12;
        }
        object = new IllegalArgumentException("No faces for selectFocus.");
        throw object;
    }
}

