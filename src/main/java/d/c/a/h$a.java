/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView$ScaleType
 */
package d.c.a;

import android.widget.ImageView;
import com.bumptech.glide.Priority;

public class h$a {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Priority priority;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = Priority.values().length;
        int[] nArray = new int[n14];
        b = nArray;
        int n15 = 1;
        try {
            object4 = Priority.LOW;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = b;
            object3 = Priority.NORMAL;
            n12 = object3.ordinal();
            object4[n12] = (Priority)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = b;
            object2 = Priority.HIGH;
            n11 = object2.ordinal();
            object3[n11] = (Priority)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = b;
            priority = Priority.IMMEDIATE;
            n10 = priority.ordinal();
            object2[n10] = (Priority)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = ImageView.ScaleType.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            priority = ImageView.ScaleType.CENTER_CROP;
            n10 = priority.ordinal();
            object2[n10] = (Priority)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = ImageView.ScaleType.CENTER_INSIDE;
            n11 = object2.ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = ImageView.ScaleType.FIT_CENTER;
            n15 = object.ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = ImageView.ScaleType.FIT_START;
            n15 = object.ordinal();
            nArray[n15] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = ImageView.ScaleType.FIT_END;
            n15 = object.ordinal();
            nArray[n15] = n13 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = ImageView.ScaleType.FIT_XY;
            n15 = object.ordinal();
            nArray[n15] = n13 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = ImageView.ScaleType.CENTER;
            n15 = object.ordinal();
            nArray[n15] = n13 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = ImageView.ScaleType.MATRIX;
            n15 = object.ordinal();
            nArray[n15] = n13 = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

