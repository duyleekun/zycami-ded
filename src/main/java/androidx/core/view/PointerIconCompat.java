/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.view.PointerIcon
 */
package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

public final class PointerIconCompat {
    public static final int TYPE_ALIAS = 1010;
    public static final int TYPE_ALL_SCROLL = 1013;
    public static final int TYPE_ARROW = 1000;
    public static final int TYPE_CELL = 1006;
    public static final int TYPE_CONTEXT_MENU = 1001;
    public static final int TYPE_COPY = 1011;
    public static final int TYPE_CROSSHAIR = 1007;
    public static final int TYPE_DEFAULT = 1000;
    public static final int TYPE_GRAB = 1020;
    public static final int TYPE_GRABBING = 1021;
    public static final int TYPE_HAND = 1002;
    public static final int TYPE_HELP = 1003;
    public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 1014;
    public static final int TYPE_NO_DROP = 1012;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_TEXT = 1008;
    public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 1017;
    public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 1016;
    public static final int TYPE_VERTICAL_DOUBLE_ARROW = 1015;
    public static final int TYPE_VERTICAL_TEXT = 1009;
    public static final int TYPE_WAIT = 1004;
    public static final int TYPE_ZOOM_IN = 1018;
    public static final int TYPE_ZOOM_OUT = 1019;
    private Object mPointerIcon;

    private PointerIconCompat(Object object) {
        this.mPointerIcon = object;
    }

    public static PointerIconCompat create(Bitmap object, float f10, float f11) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object = PointerIcon.create((Bitmap)object, (float)f10, (float)f11);
            PointerIconCompat pointerIconCompat = new PointerIconCompat(object);
            return pointerIconCompat;
        }
        object = new PointerIconCompat(null);
        return object;
    }

    public static PointerIconCompat getSystemIcon(Context object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            object = PointerIcon.getSystemIcon((Context)object, (int)n10);
            PointerIconCompat pointerIconCompat = new PointerIconCompat(object);
            return pointerIconCompat;
        }
        object = new PointerIconCompat(null);
        return object;
    }

    public static PointerIconCompat load(Resources object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            object = PointerIcon.load((Resources)object, (int)n10);
            PointerIconCompat pointerIconCompat = new PointerIconCompat(object);
            return pointerIconCompat;
        }
        object = new PointerIconCompat(null);
        return object;
    }

    public Object getPointerIcon() {
        return this.mPointerIcon;
    }
}

