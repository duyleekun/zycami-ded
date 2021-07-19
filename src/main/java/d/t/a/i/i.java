/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 */
package d.t.a.i;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class i
extends StateListDrawable {
    private int a;

    public i(Drawable drawable2, int n10) {
        this.a = n10;
        int[] nArray = new int[]{0x10100A1};
        this.addState(nArray, drawable2);
        nArray = new int[]{};
        this.addState(nArray, drawable2);
    }

    public boolean isStateful() {
        return true;
    }

    public boolean onStateChange(int[] nArray) {
        int n10 = nArray.length;
        PorterDuff.Mode mode = null;
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            int n12 = 0x10100A1;
            if (n11 != n12) continue;
            bl2 = true;
        }
        if (bl2) {
            n10 = this.a;
            mode = PorterDuff.Mode.SRC_ATOP;
            super.setColorFilter(n10, mode);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(nArray);
    }
}

