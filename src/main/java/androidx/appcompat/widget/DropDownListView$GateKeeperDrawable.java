/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

public class DropDownListView$GateKeeperDrawable
extends DrawableWrapper {
    private boolean mEnabled = true;

    public DropDownListView$GateKeeperDrawable(Drawable drawable2) {
        super(drawable2);
    }

    public void draw(Canvas canvas) {
        boolean bl2 = this.mEnabled;
        if (bl2) {
            super.draw(canvas);
        }
    }

    public void setEnabled(boolean bl2) {
        this.mEnabled = bl2;
    }

    public void setHotspot(float f10, float f11) {
        boolean bl2 = this.mEnabled;
        if (bl2) {
            super.setHotspot(f10, f11);
        }
    }

    public void setHotspotBounds(int n10, int n11, int n12, int n13) {
        boolean bl2 = this.mEnabled;
        if (bl2) {
            super.setHotspotBounds(n10, n11, n12, n13);
        }
    }

    public boolean setState(int[] nArray) {
        boolean bl2 = this.mEnabled;
        if (bl2) {
            return super.setState(nArray);
        }
        return false;
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        boolean bl4 = this.mEnabled;
        if (bl4) {
            return super.setVisible(bl2, bl3);
        }
        return false;
    }
}

