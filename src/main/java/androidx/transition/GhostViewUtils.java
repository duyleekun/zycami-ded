/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.GhostView;
import androidx.transition.GhostViewPlatform;
import androidx.transition.GhostViewPort;

public class GhostViewUtils {
    private GhostViewUtils() {
    }

    public static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 == n11) {
            return GhostViewPlatform.addGhost(view, viewGroup, matrix);
        }
        return GhostViewPort.addGhost(view, viewGroup, matrix);
    }

    public static void removeGhost(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 == n11) {
            GhostViewPlatform.removeGhost(view);
        } else {
            GhostViewPort.removeGhost(view);
        }
    }
}

