/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package d.v.e.l;

import android.view.View;
import android.view.ViewGroup;

public class z0$a {
    private View a;

    public z0$a(View view) {
        this.a = view;
    }

    public int a() {
        return this.a.getLayoutParams().width;
    }

    public void b(float f10) {
        int n10;
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = n10 = (int)f10;
        this.a.requestLayout();
    }
}

