/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Property
 *  android.view.View
 */
package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

public final class ViewUtils$2
extends Property {
    public ViewUtils$2(Class clazz, String string2) {
        super(clazz, string2);
    }

    public Rect get(View view) {
        return ViewCompat.getClipBounds(view);
    }

    public void set(View view, Rect rect) {
        ViewCompat.setClipBounds(view, rect);
    }
}

