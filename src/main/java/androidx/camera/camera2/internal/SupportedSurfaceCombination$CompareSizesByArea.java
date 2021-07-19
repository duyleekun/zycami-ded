/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.camera2.internal;

import android.util.Size;
import java.util.Comparator;

public final class SupportedSurfaceCombination$CompareSizesByArea
implements Comparator {
    private boolean mReverse = false;

    public SupportedSurfaceCombination$CompareSizesByArea() {
    }

    public SupportedSurfaceCombination$CompareSizesByArea(boolean bl2) {
        this.mReverse = bl2;
    }

    public int compare(Size size, Size size2) {
        int n10 = size.getWidth();
        long l10 = n10;
        long l11 = size.getHeight();
        l10 *= l11;
        l11 = size2.getWidth();
        long l12 = size2.getHeight();
        int n11 = Long.signum(l10 -= (l11 *= l12));
        boolean bl2 = this.mReverse;
        if (bl2) {
            n11 *= -1;
        }
        return n11;
    }
}

