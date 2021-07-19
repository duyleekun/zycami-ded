/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.appcompat.widget.TooltipCompatHandler;

public class TooltipCompat {
    private TooltipCompat() {
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            view.setTooltipText(charSequence);
        } else {
            TooltipCompatHandler.setTooltipText(view, charSequence);
        }
    }
}

