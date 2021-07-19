/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Property
 *  android.widget.ImageView
 */
package androidx.transition;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.transition.ImageViewUtils;

public final class ChangeImageTransform$2
extends Property {
    public ChangeImageTransform$2(Class clazz, String string2) {
        super(clazz, string2);
    }

    public Matrix get(ImageView imageView) {
        return null;
    }

    public void set(ImageView imageView, Matrix matrix) {
        ImageViewUtils.animateTransform(imageView, matrix);
    }
}

