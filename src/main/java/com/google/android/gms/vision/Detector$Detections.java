/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame$Metadata;

public class Detector$Detections {
    private final SparseArray zzal;
    private final Frame.Metadata zzam;
    private final boolean zzan;

    public Detector$Detections(SparseArray sparseArray, Frame.Metadata metadata, boolean bl2) {
        this.zzal = sparseArray;
        this.zzam = metadata;
        this.zzan = bl2;
    }

    public boolean detectorIsOperational() {
        return this.zzan;
    }

    public SparseArray getDetectedItems() {
        return this.zzal;
    }

    public Frame.Metadata getFrameMetadata() {
        return this.zzam;
    }
}

