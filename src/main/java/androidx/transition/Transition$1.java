/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 */
package androidx.transition;

import android.graphics.Path;
import androidx.transition.PathMotion;

public final class Transition$1
extends PathMotion {
    public Path getPath(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(f10, f11);
        path.lineTo(f12, f13);
        return path;
    }
}

