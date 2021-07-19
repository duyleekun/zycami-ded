/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector$Detections;
import com.google.android.gms.vision.Detector$Processor;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame$Metadata;

public abstract class Detector {
    private final Object zzah;
    private Detector$Processor zzai;

    public Detector() {
        Object object;
        this.zzah = object = new Object();
    }

    public abstract SparseArray detect(Frame var1);

    public boolean isOperational() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void receiveFrame(Frame object) {
        Object object2 = ((Frame)object).getMetadata();
        Object object3 = new Frame$Metadata((Frame$Metadata)object2);
        ((Frame$Metadata)object3).zzf();
        object = this.detect((Frame)object);
        boolean bl2 = this.isOperational();
        Detector$Detections detector$Detections = new Detector$Detections((SparseArray)object, (Frame$Metadata)object3, bl2);
        object = this.zzah;
        synchronized (object) {
            object3 = this.zzai;
            if (object3 != null) {
                object3.receiveDetections(detector$Detections);
                return;
            }
            object2 = "Detector processor must first be set with setProcessor in order to receive detection results.";
            object3 = new IllegalStateException((String)object2);
            throw object3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        Object object = this.zzah;
        synchronized (object) {
            Detector$Processor detector$Processor = this.zzai;
            if (detector$Processor != null) {
                detector$Processor.release();
                detector$Processor = null;
                this.zzai = null;
            }
            return;
        }
    }

    public boolean setFocus(int n10) {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setProcessor(Detector$Processor detector$Processor) {
        Object object = this.zzah;
        synchronized (object) {
            Detector$Processor detector$Processor2 = this.zzai;
            if (detector$Processor2 != null) {
                detector$Processor2.release();
            }
            this.zzai = detector$Processor;
            return;
        }
    }
}

