/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision;

import com.google.android.gms.vision.Detector$Detections;

public interface Detector$Processor {
    public void receiveDetections(Detector$Detections var1);

    public void release();
}

