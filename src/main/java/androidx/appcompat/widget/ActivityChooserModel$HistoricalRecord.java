/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 */
package androidx.appcompat.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ActivityChooserModel$HistoricalRecord {
    public final ComponentName activity;
    public final long time;
    public final float weight;

    public ActivityChooserModel$HistoricalRecord(ComponentName componentName, long l10, float f10) {
        this.activity = componentName;
        this.time = l10;
        this.weight = f10;
    }

    public ActivityChooserModel$HistoricalRecord(String string2, long l10, float f10) {
        string2 = ComponentName.unflattenFromString((String)string2);
        this((ComponentName)string2, l10, f10);
    }

    public boolean equals(Object object) {
        float f10;
        int n10;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object == null) {
            return false;
        }
        ComponentName componentName = ActivityChooserModel$HistoricalRecord.class;
        ComponentName componentName2 = object.getClass();
        if (componentName != componentName2) {
            return false;
        }
        object = (ActivityChooserModel$HistoricalRecord)object;
        componentName = this.activity;
        if (componentName == null ? (componentName = ((ActivityChooserModel$HistoricalRecord)object).activity) != null : (n11 = componentName.equals((Object)(componentName2 = ((ActivityChooserModel$HistoricalRecord)object).activity))) == 0) {
            return false;
        }
        long l10 = this.time;
        long l11 = ((ActivityChooserModel$HistoricalRecord)object).time;
        long l12 = l10 - l11;
        n11 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (n11 != 0) {
            return false;
        }
        float f11 = this.weight;
        n11 = Float.floatToIntBits(f11);
        if (n11 != (n10 = Float.floatToIntBits(f10 = ((ActivityChooserModel$HistoricalRecord)object).weight))) {
            return false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        ComponentName componentName = this.activity;
        if (componentName == null) {
            n10 = 0;
            componentName = null;
        } else {
            n10 = componentName.hashCode();
        }
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        long l10 = this.time;
        long l11 = l10 >>> 32;
        int n12 = (int)(l10 ^ l11);
        n10 = (n10 + n12) * n11;
        n11 = Float.floatToIntBits(this.weight);
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:");
        Object object = this.activity;
        stringBuilder.append(object);
        stringBuilder.append("; time:");
        long l10 = this.time;
        stringBuilder.append(l10);
        stringBuilder.append("; weight:");
        double d10 = this.weight;
        object = new BigDecimal(d10);
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

