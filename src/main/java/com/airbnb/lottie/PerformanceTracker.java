/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.PerformanceTracker$1;
import com.airbnb.lottie.PerformanceTracker$FrameListener;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {
    private boolean enabled = false;
    private final Comparator floatComparator;
    private final Set frameListeners;
    private final Map layerRenderTimes;

    public PerformanceTracker() {
        Object object = new ArraySet();
        this.frameListeners = object;
        object = new HashMap();
        this.layerRenderTimes = object;
        this.floatComparator = object = new PerformanceTracker$1(this);
    }

    public void addFrameListener(PerformanceTracker$FrameListener performanceTracker$FrameListener) {
        this.frameListeners.add(performanceTracker$FrameListener);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public List getSortedRenderTimes() {
        boolean bl2;
        boolean bl3 = this.enabled;
        if (!bl3) {
            return Collections.emptyList();
        }
        int n10 = this.layerRenderTimes.size();
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        Object object = this.layerRenderTimes.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            Object k10 = object2.getKey();
            float f10 = ((MeanCalculator)object2.getValue()).getMean();
            object2 = Float.valueOf(f10);
            Pair pair = new Pair(k10, object2);
            arrayList.add(pair);
        }
        object = this.floatComparator;
        Collections.sort(arrayList, object);
        return arrayList;
    }

    public void logRenderTimes() {
        int n10;
        boolean bl2 = this.enabled;
        if (!bl2) {
            return;
        }
        List list = this.getSortedRenderTimes();
        String string2 = "LOTTIE";
        Log.d((String)string2, (String)"Render times:");
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object;
            Object object2 = (Pair)list.get(i10);
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = ((Pair)object2).first;
            object2 = ((Pair)object2).second;
            int n12 = 1;
            objectArray[n12] = object2;
            object2 = String.format("\t\t%30s:%.2f", objectArray);
            Log.d((String)string2, (String)object2);
        }
    }

    public void recordRenderTime(String object, float f10) {
        boolean bl2 = this.enabled;
        if (!bl2) {
            return;
        }
        Object object2 = (MeanCalculator)this.layerRenderTimes.get(object);
        if (object2 == null) {
            object2 = new MeanCalculator();
            Map map = this.layerRenderTimes;
            map.put(object, object2);
        }
        ((MeanCalculator)object2).add(f10);
        object2 = "__container";
        boolean bl3 = ((String)object).equals(object2);
        if (bl3) {
            object = this.frameListeners.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (PerformanceTracker$FrameListener)object.next();
                object2.onFrameRendered(f10);
            }
        }
    }

    public void removeFrameListener(PerformanceTracker$FrameListener performanceTracker$FrameListener) {
        this.frameListeners.remove(performanceTracker$FrameListener);
    }

    public void setEnabled(boolean bl2) {
        this.enabled = bl2;
    }
}

