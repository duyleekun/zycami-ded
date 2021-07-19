/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Detector$Processor;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiDetector
extends Detector {
    private List zzbd;

    private MultiDetector() {
        ArrayList arrayList;
        this.zzbd = arrayList = new ArrayList();
    }

    public /* synthetic */ MultiDetector(zzd zzd2) {
        this();
    }

    public static /* synthetic */ List zza(MultiDetector multiDetector) {
        return multiDetector.zzbd;
    }

    public SparseArray detect(Frame object) {
        boolean bl2;
        Object object2 = new SparseArray();
        Object object3 = this.zzbd.iterator();
        while (bl2 = object3.hasNext()) {
            int n10;
            SparseArray sparseArray = ((Detector)object3.next()).detect((Frame)object);
            for (int i10 = 0; i10 < (n10 = sparseArray.size()); ++i10) {
                n10 = sparseArray.keyAt(i10);
                Object object4 = object2.get(n10);
                if (object4 == null) {
                    object4 = sparseArray.valueAt(i10);
                    object2.append(n10, object4);
                    continue;
                }
                object3 = new StringBuilder(104);
                ((StringBuilder)object3).append("Detection ID overlap for id = ");
                ((StringBuilder)object3).append(n10);
                ((StringBuilder)object3).append("  This means that one of the detectors is not using global IDs.");
                object2 = ((StringBuilder)object3).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
        }
        return object2;
    }

    public boolean isOperational() {
        boolean bl2;
        Iterator iterator2 = this.zzbd.iterator();
        while (bl2 = iterator2.hasNext()) {
            Detector detector = (Detector)iterator2.next();
            bl2 = detector.isOperational();
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public void receiveFrame(Frame frame) {
        boolean bl2;
        Iterator iterator2 = this.zzbd.iterator();
        while (bl2 = iterator2.hasNext()) {
            Detector detector = (Detector)iterator2.next();
            detector.receiveFrame(frame);
        }
    }

    public void release() {
        boolean bl2;
        Iterator iterator2 = this.zzbd.iterator();
        while (bl2 = iterator2.hasNext()) {
            Detector detector = (Detector)iterator2.next();
            detector.release();
        }
        this.zzbd.clear();
    }

    public void setProcessor(Detector$Processor object) {
        object = new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
        throw object;
    }
}

