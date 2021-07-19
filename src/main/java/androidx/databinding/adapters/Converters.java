/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.ColorDrawable
 */
package androidx.databinding.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;

public class Converters {
    public static ColorStateList convertColorToColorStateList(int n10) {
        return ColorStateList.valueOf((int)n10);
    }

    public static ColorDrawable convertColorToDrawable(int n10) {
        ColorDrawable colorDrawable = new ColorDrawable(n10);
        return colorDrawable;
    }
}

