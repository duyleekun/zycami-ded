/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Property
 */
package androidx.appcompat.widget;

import android.util.Property;
import androidx.appcompat.widget.SwitchCompat;

public class SwitchCompat$1
extends Property {
    public SwitchCompat$1(Class clazz, String string2) {
        super(clazz, string2);
    }

    public Float get(SwitchCompat switchCompat) {
        return Float.valueOf(switchCompat.mThumbPosition);
    }

    public void set(SwitchCompat switchCompat, Float f10) {
        float f11 = f10.floatValue();
        switchCompat.setThumbPosition(f11);
    }
}

