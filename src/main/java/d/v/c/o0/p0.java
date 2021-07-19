/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 */
package d.v.c.o0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import d.v.e.l.o1;
import d.v.f.i.g;

public class p0
extends AppCompatTextView {
    public p0(Context context) {
        super(context);
    }

    public void b(int n10, int n11) {
        String string2 = g.q((View)this, n10);
        this.setText(string2);
        this.setCompoundDrawablesWithIntrinsicBounds(0, n11, 0, 0);
    }

    public void c(int n10) {
        int n11 = 3;
        int n12 = n10 == n11 ? 2131231807 : 2131231811;
        int n13 = 1;
        n10 = n10 != n13 ? (n10 != (n13 = 2) ? (n10 != n11 ? 2131951747 : 2131951748) : 2131951749) : 2131951750;
        String string2 = g.q((View)this, n10);
        this.setText(string2);
        this.setCompoundDrawablesWithIntrinsicBounds(0, n12, 0, 0);
    }

    public void onAttachedToWindow() {
        int n10;
        super.onAttachedToWindow();
        Object object = this.getContext();
        int n11 = 2131099737;
        int n12 = o1.a(object, n11);
        this.setTextColor(n12);
        this.setTextAlignment(4);
        n12 = 17;
        this.setGravity(n12);
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        layoutParams.width = n10 = -2;
        layoutParams.height = n10;
        n10 = layoutParams instanceof ConstraintLayout$LayoutParams;
        if (n10 != 0) {
            object = layoutParams;
            object = (ConstraintLayout$LayoutParams)layoutParams;
            n10 = 0;
            Object var6_6 = null;
            object.topToTop = 0;
            object.bottomToBottom = 0;
            object.startToStart = 0;
            object.endToEnd = 0;
        } else {
            n10 = layoutParams instanceof FrameLayout.LayoutParams;
            if (n10 != 0) {
                ViewGroup.LayoutParams layoutParams2 = layoutParams;
                layoutParams2 = (FrameLayout.LayoutParams)layoutParams;
                layoutParams2.gravity = n12;
            }
        }
        this.setLayoutParams(layoutParams);
    }
}

