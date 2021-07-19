/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.view.Display$Mode
 */
package androidx.core.view;

import android.graphics.Point;
import android.view.Display;
import androidx.core.util.Preconditions;

public final class DisplayCompat$ModeCompat {
    private final boolean mIsNative;
    private final Display.Mode mMode;
    private final Point mPhysicalSize;

    public DisplayCompat$ModeCompat(Point point) {
        Preconditions.checkNotNull(point, "physicalSize == null");
        this.mPhysicalSize = point;
        this.mMode = null;
        this.mIsNative = true;
    }

    public DisplayCompat$ModeCompat(Display.Mode mode, Point point) {
        Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
        Preconditions.checkNotNull(point, "physicalSize == null");
        this.mPhysicalSize = point;
        this.mMode = mode;
        this.mIsNative = true;
    }

    public DisplayCompat$ModeCompat(Display.Mode mode, boolean bl2) {
        Point point;
        Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
        int n10 = mode.getPhysicalWidth();
        int n11 = mode.getPhysicalHeight();
        this.mPhysicalSize = point = new Point(n10, n11);
        this.mMode = mode;
        this.mIsNative = bl2;
    }

    public int getPhysicalHeight() {
        return this.mPhysicalSize.y;
    }

    public int getPhysicalWidth() {
        return this.mPhysicalSize.x;
    }

    public boolean isNative() {
        return this.mIsNative;
    }

    public Display.Mode toMode() {
        return this.mMode;
    }
}

