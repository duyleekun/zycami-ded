/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.graphics.Path
 *  android.os.Build$VERSION
 *  android.util.Property
 */
package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.util.Property;
import androidx.transition.PathProperty;

public class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    public static ObjectAnimator ofPointF(Object object, Property object2, Path path) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ObjectAnimator.ofObject((Object)object, (Property)object2, null, (Path)path);
        }
        PathProperty pathProperty = new PathProperty((Property)object2, path);
        Object object3 = object2 = (Object)new float[2];
        object3[0] = (Property)0.0f;
        object3[1] = (Property)1.0f;
        return ObjectAnimator.ofFloat((Object)object, (Property)pathProperty, (float[])object2);
    }
}

