/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.ColorFilter
 */
package com.airbnb.lottie;

import android.graphics.ColorFilter;

public class LottieDrawable$ColorFilterData {
    public final ColorFilter colorFilter;
    public final String contentName;
    public final String layerName;

    public LottieDrawable$ColorFilterData(String string2, String string3, ColorFilter colorFilter) {
        this.layerName = string2;
        this.contentName = string3;
        this.colorFilter = colorFilter;
    }

    public boolean equals(Object object) {
        ColorFilter colorFilter;
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof LottieDrawable$ColorFilterData;
        if (n11 == 0) {
            return false;
        }
        object = (LottieDrawable$ColorFilterData)object;
        n11 = this.hashCode();
        if (n11 != (n10 = ((LottieDrawable$ColorFilterData)object).hashCode()) || (colorFilter = this.colorFilter) != (object = ((LottieDrawable$ColorFilterData)object).colorFilter)) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.layerName;
        if (string2 != null) {
            n11 = string2.hashCode();
            n10 = 527 * n11;
        } else {
            n10 = 17;
        }
        string2 = this.contentName;
        if (string2 != null) {
            n10 *= 31;
            n11 = string2.hashCode();
            n10 *= n11;
        }
        return n10;
    }
}

