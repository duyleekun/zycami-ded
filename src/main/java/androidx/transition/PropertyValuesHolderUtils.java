/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.PropertyValuesHolder
 *  android.graphics.Path
 *  android.os.Build$VERSION
 *  android.util.Property
 */
package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.os.Build;
import android.util.Property;
import androidx.transition.PathProperty;

public class PropertyValuesHolderUtils {
    private PropertyValuesHolderUtils() {
    }

    public static PropertyValuesHolder ofPointF(Property object, Path path) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return PropertyValuesHolder.ofObject((Property)object, null, (Path)path);
        }
        PathProperty pathProperty = new PathProperty((Property)object, path);
        Object object2 = object = (Object)new float[2];
        object2[0] = (Property)0.0f;
        object2[1] = (Property)1.0f;
        return PropertyValuesHolder.ofFloat((Property)pathProperty, (float[])object);
    }
}

