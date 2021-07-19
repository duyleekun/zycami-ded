/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 */
package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo;
import androidx.appcompat.widget.ActivityChooserModel$ActivitySorter;
import androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ActivityChooserModel$DefaultSorter
implements ActivityChooserModel$ActivitySorter {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    private final Map mPackageNameToActivityMap;

    public ActivityChooserModel$DefaultSorter() {
        HashMap hashMap;
        this.mPackageNameToActivityMap = hashMap = new HashMap();
    }

    public void sort(Intent object, List list, List list2) {
        Object object2;
        Object object3;
        int n10;
        object = this.mPackageNameToActivityMap;
        object.clear();
        int n11 = list.size();
        float f10 = 0.0f;
        for (n10 = 0; n10 < n11; ++n10) {
            object3 = (ActivityChooserModel$ActivityResolveInfo)list.get(n10);
            ((ActivityChooserModel$ActivityResolveInfo)object3).weight = 0.0f;
            Object object4 = object3.resolveInfo.activityInfo;
            String string2 = object4.packageName;
            object4 = object4.name;
            object2 = new ComponentName(string2, (String)object4);
            object.put(object2, object3);
        }
        n10 = 1065353216;
        f10 = 1.0f;
        for (n11 = list2.size() + -1; n11 >= 0; n11 += -1) {
            object3 = (ActivityChooserModel$HistoricalRecord)list2.get(n11);
            object2 = ((ActivityChooserModel$HistoricalRecord)object3).activity;
            if ((object2 = (ActivityChooserModel$ActivityResolveInfo)object.get(object2)) == null) continue;
            float f11 = object2.weight;
            float f12 = ((ActivityChooserModel$HistoricalRecord)object3).weight * f10;
            object2.weight = f11 += f12;
            f12 = 0.95f;
            f10 *= f12;
        }
        Collections.sort(list);
    }
}

