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
import com.google.android.gms.vision.MultiProcessor$Factory;
import com.google.android.gms.vision.MultiProcessor$zza;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.zze;
import java.io.Serializable;
import java.util.HashSet;

public class MultiProcessor
implements Detector$Processor {
    private int zzat;
    private MultiProcessor$Factory zzbe;
    private SparseArray zzbf;

    private MultiProcessor() {
        SparseArray sparseArray;
        this.zzbf = sparseArray = new SparseArray();
        this.zzat = 3;
    }

    public /* synthetic */ MultiProcessor(zze zze2) {
        this();
    }

    public static /* synthetic */ int zza(MultiProcessor multiProcessor, int n10) {
        multiProcessor.zzat = n10;
        return n10;
    }

    public static /* synthetic */ MultiProcessor$Factory zza(MultiProcessor multiProcessor, MultiProcessor$Factory multiProcessor$Factory) {
        multiProcessor.zzbe = multiProcessor$Factory;
        return multiProcessor$Factory;
    }

    public void receiveDetections(Detector$Detections detector$Detections) {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12;
        int n13;
        Object object3 = detector$Detections.getDetectedItems();
        Serializable serializable = null;
        for (n13 = 0; n13 < (n12 = object3.size()); ++n13) {
            n12 = object3.keyAt(n13);
            object2 = object3.valueAt(n13);
            object = this.zzbf.get(n12);
            if (object != null) continue;
            n11 = 0;
            object = new MultiProcessor$zza(this, null);
            Tracker tracker = this.zzbe.create(object2);
            MultiProcessor$zza.zza((MultiProcessor$zza)object, tracker);
            tracker = MultiProcessor$zza.zza((MultiProcessor$zza)object);
            tracker.onNewItem(n12, object2);
            object2 = this.zzbf;
            object2.append(n12, object);
        }
        object3 = detector$Detections.getDetectedItems();
        serializable = new HashSet();
        Object object4 = null;
        for (n12 = 0; n12 < (n10 = (object2 = this.zzbf).size()); ++n12) {
            object2 = this.zzbf;
            n10 = object2.keyAt(n12);
            object = object3.get(n10);
            if (object != null) continue;
            object = (MultiProcessor$zza)this.zzbf.valueAt(n12);
            MultiProcessor$zza.zzb((MultiProcessor$zza)object);
            n11 = MultiProcessor$zza.zzc((MultiProcessor$zza)object);
            int n14 = this.zzat;
            if (n11 >= n14) {
                object = MultiProcessor$zza.zza((MultiProcessor$zza)object);
                ((Tracker)object).onDone();
                object2 = n10;
                serializable.add(object2);
                continue;
            }
            object2 = MultiProcessor$zza.zza((MultiProcessor$zza)object);
            ((Tracker)object2).onMissing(detector$Detections);
        }
        object3 = serializable.iterator();
        while ((n13 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            serializable = (Integer)object3.next();
            object4 = this.zzbf;
            n13 = (Integer)serializable;
            object4.delete(n13);
        }
        object3 = detector$Detections.getDetectedItems();
        serializable = null;
        for (n13 = 0; n13 < (n12 = object3.size()); ++n13) {
            n12 = object3.keyAt(n13);
            object2 = object3.valueAt(n13);
            object = this.zzbf;
            object4 = (MultiProcessor$zza)object.get(n12);
            MultiProcessor$zza.zza((MultiProcessor$zza)object4, 0);
            object4 = MultiProcessor$zza.zza((MultiProcessor$zza)object4);
            ((Tracker)object4).onUpdate(detector$Detections, object2);
        }
    }

    public void release() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.zzbf).size()); ++i10) {
            object = MultiProcessor$zza.zza((MultiProcessor$zza)this.zzbf.valueAt(i10));
            ((Tracker)object).onDone();
        }
        this.zzbf.clear();
    }
}

