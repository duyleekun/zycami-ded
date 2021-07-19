/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.ListPopupWindow
 */
package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListPopupWindow;

public final class ListPopupWindowCompat {
    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow listPopupWindow, View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return listPopupWindow.createDragToOpenListener(view);
        }
        return null;
    }

    public static View.OnTouchListener createDragToOpenListener(Object object, View view) {
        return ListPopupWindowCompat.createDragToOpenListener((ListPopupWindow)object, view);
    }
}

