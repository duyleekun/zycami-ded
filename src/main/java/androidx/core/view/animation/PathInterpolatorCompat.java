/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.os.Build$VERSION
 *  android.view.animation.Interpolator
 *  android.view.animation.PathInterpolator
 */
package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.animation.PathInterpolatorApi14;

public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(float f10, float f11) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            PathInterpolator pathInterpolator = new PathInterpolator(f10, f11);
            return pathInterpolator;
        }
        PathInterpolatorApi14 pathInterpolatorApi14 = new PathInterpolatorApi14(f10, f11);
        return pathInterpolatorApi14;
    }

    public static Interpolator create(float f10, float f11, float f12, float f13) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            PathInterpolator pathInterpolator = new PathInterpolator(f10, f11, f12, f13);
            return pathInterpolator;
        }
        PathInterpolatorApi14 pathInterpolatorApi14 = new PathInterpolatorApi14(f10, f11, f12, f13);
        return pathInterpolatorApi14;
    }

    public static Interpolator create(Path path) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            PathInterpolator pathInterpolator = new PathInterpolator(path);
            return pathInterpolator;
        }
        PathInterpolatorApi14 pathInterpolatorApi14 = new PathInterpolatorApi14(path);
        return pathInterpolatorApi14;
    }
}

