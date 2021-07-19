/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Comparator;

public class CoordinatorLayout$ViewElevationComparator
implements Comparator {
    public int compare(View view, View view2) {
        float f10;
        float f11 = ViewCompat.getZ(view);
        float f12 = f11 - (f10 = ViewCompat.getZ(view2));
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            return -1;
        }
        Object object2 = f11 == f10 ? 0 : (f11 < f10 ? -1 : 1);
        if (object2 < 0) {
            return 1;
        }
        return 0;
    }
}

