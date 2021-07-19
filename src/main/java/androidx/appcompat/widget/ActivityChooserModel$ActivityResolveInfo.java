/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.ResolveInfo
 */
package androidx.appcompat.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class ActivityChooserModel$ActivityResolveInfo
implements Comparable {
    public final ResolveInfo resolveInfo;
    public float weight;

    public ActivityChooserModel$ActivityResolveInfo(ResolveInfo resolveInfo) {
        this.resolveInfo = resolveInfo;
    }

    public int compareTo(ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo) {
        int n10 = Float.floatToIntBits(activityChooserModel$ActivityResolveInfo.weight);
        int n11 = Float.floatToIntBits(this.weight);
        return n10 - n11;
    }

    public boolean equals(Object object) {
        float f10;
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object == null) {
            return false;
        }
        Class<ActivityChooserModel$ActivityResolveInfo> clazz = ActivityChooserModel$ActivityResolveInfo.class;
        Class<?> clazz2 = object.getClass();
        if (clazz != clazz2) {
            return false;
        }
        object = (ActivityChooserModel$ActivityResolveInfo)object;
        float f11 = this.weight;
        int n11 = Float.floatToIntBits(f11);
        if (n11 != (n10 = Float.floatToIntBits(f10 = ((ActivityChooserModel$ActivityResolveInfo)object).weight))) {
            return false;
        }
        return bl2;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.weight) + 31;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:");
        Object object = this.resolveInfo.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("; weight:");
        double d10 = this.weight;
        object = new BigDecimal(d10);
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

