/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.vision;

import android.util.Log;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Detector$Detections;
import com.google.android.gms.vision.Detector$Processor;
import com.google.android.gms.vision.Tracker;

public abstract class FocusingProcessor
implements Detector$Processor {
    private Tracker zzas;
    private int zzat = 3;
    private boolean zzau = false;
    private int zzav;
    private int zzaw = 0;
    private Detector zzx;

    public FocusingProcessor(Detector detector, Tracker tracker) {
        this.zzx = detector;
        this.zzas = tracker;
    }

    public void receiveDetections(Detector$Detections object) {
        Object object2;
        Object object3 = ((Detector$Detections)object).getDetectedItems();
        int n10 = object3.size();
        int n11 = 1;
        if (n10 == 0) {
            int n12;
            int n13 = this.zzaw;
            n10 = this.zzat;
            if (n13 == n10) {
                object = this.zzas;
                ((Tracker)object).onDone();
                this.zzau = false;
            } else {
                object3 = this.zzas;
                ((Tracker)object3).onMissing((Detector$Detections)object);
            }
            this.zzaw = n12 = this.zzaw + n11;
            return;
        }
        this.zzaw = 0;
        n10 = (int)(this.zzau ? 1 : 0);
        if (n10 != 0) {
            n10 = this.zzav;
            object2 = object3.get(n10);
            if (object2 != null) {
                this.zzas.onUpdate((Detector$Detections)object, object2);
                return;
            }
            object2 = this.zzas;
            ((Tracker)object2).onDone();
            this.zzau = false;
        }
        if ((object3 = object3.get(n10 = this.selectFocus((Detector$Detections)object))) == null) {
            object3 = new StringBuilder(35);
            ((StringBuilder)object3).append("Invalid focus selected: ");
            ((StringBuilder)object3).append(n10);
            object = ((StringBuilder)object3).toString();
            Log.w((String)"FocusingProcessor", (String)object);
            return;
        }
        this.zzau = n11;
        this.zzav = n10;
        this.zzx.setFocus(n10);
        object2 = this.zzas;
        n11 = this.zzav;
        ((Tracker)object2).onNewItem(n11, object3);
        this.zzas.onUpdate((Detector$Detections)object, object3);
    }

    public void release() {
        this.zzas.onDone();
    }

    public abstract int selectFocus(Detector$Detections var1);

    public final void zza(int n10) {
        if (n10 >= 0) {
            this.zzat = n10;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(28);
        stringBuilder.append("Invalid max gap: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

