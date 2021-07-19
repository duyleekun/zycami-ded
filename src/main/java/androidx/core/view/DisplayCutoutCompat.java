/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.DisplayCutout
 */
package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.os.BuildCompat;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DisplayCutoutCompat {
    private final Object mDisplayCutout;

    public DisplayCutoutCompat(Rect rect, List list) {
        DisplayCutout displayCutout;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            displayCutout = new DisplayCutout(rect, list);
        } else {
            n10 = 0;
            displayCutout = null;
        }
        this(displayCutout);
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, androidx.core.graphics.Insets insets2) {
        insets = DisplayCutoutCompat.constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
        this(insets);
    }

    private DisplayCutoutCompat(Object object) {
        this.mDisplayCutout = object;
    }

    private static DisplayCutout constructDisplayCutout(androidx.core.graphics.Insets arrayList, Rect rect, Rect rect2, Rect rect3, Rect rect4, androidx.core.graphics.Insets insets) {
        int n10 = BuildCompat.isAtLeastR();
        if (n10 != 0) {
            Insets insets2 = ((androidx.core.graphics.Insets)((Object)arrayList)).toPlatformInsets();
            Insets insets3 = insets.toPlatformInsets();
            DisplayCutout displayCutout = new DisplayCutout(insets2, rect, rect2, rect3, rect4, insets3);
            return displayCutout;
        }
        int n11 = Build.VERSION.SDK_INT;
        n10 = 29;
        if (n11 >= n10) {
            Insets insets4 = ((androidx.core.graphics.Insets)((Object)arrayList)).toPlatformInsets();
            insets = new DisplayCutout(insets4, rect, rect2, rect3, rect4);
            return insets;
        }
        n10 = 28;
        if (n11 >= n10) {
            n10 = ((androidx.core.graphics.Insets)arrayList).left;
            int n12 = ((androidx.core.graphics.Insets)arrayList).top;
            int n13 = ((androidx.core.graphics.Insets)arrayList).right;
            int n14 = ((androidx.core.graphics.Insets)arrayList).bottom;
            insets = new Rect(n10, n12, n13, n14);
            arrayList = new ArrayList<Rect>();
            if (rect != null) {
                arrayList.add(rect);
            }
            if (rect2 != null) {
                arrayList.add(rect2);
            }
            if (rect3 != null) {
                arrayList.add(rect3);
            }
            if (rect4 != null) {
                arrayList.add(rect4);
            }
            rect = new DisplayCutout((Rect)insets, arrayList);
            return rect;
        }
        return null;
    }

    public static DisplayCutoutCompat wrap(Object object) {
        if (object == null) {
            object = null;
        } else {
            DisplayCutoutCompat displayCutoutCompat = new DisplayCutoutCompat(object);
            object = displayCutoutCompat;
        }
        return object;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = DisplayCutoutCompat.class) == (clazz = object.getClass())) {
            object = (DisplayCutoutCompat)object;
            object2 = this.mDisplayCutout;
            object = ((DisplayCutoutCompat)object).mDisplayCutout;
            return ObjectsCompat.equals(object2, object);
        }
        return false;
    }

    public List getBoundingRects() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return ((DisplayCutout)this.mDisplayCutout).getBoundingRects();
        }
        return Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return ((DisplayCutout)this.mDisplayCutout).getSafeInsetBottom();
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return ((DisplayCutout)this.mDisplayCutout).getSafeInsetLeft();
        }
        return 0;
    }

    public int getSafeInsetRight() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return ((DisplayCutout)this.mDisplayCutout).getSafeInsetRight();
        }
        return 0;
    }

    public int getSafeInsetTop() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return ((DisplayCutout)this.mDisplayCutout).getSafeInsetTop();
        }
        return 0;
    }

    public androidx.core.graphics.Insets getWaterfallInsets() {
        boolean bl2 = BuildCompat.isAtLeastR();
        if (bl2) {
            return androidx.core.graphics.Insets.toCompatInsets(((DisplayCutout)this.mDisplayCutout).getWaterfallInsets());
        }
        return androidx.core.graphics.Insets.NONE;
    }

    public int hashCode() {
        int n10;
        Object object = this.mDisplayCutout;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        return n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DisplayCutoutCompat{");
        Object object = this.mDisplayCutout;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DisplayCutout unwrap() {
        return (DisplayCutout)this.mDisplayCutout;
    }
}

