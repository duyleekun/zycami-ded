/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package androidx.legacy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class Space
extends View {
    public Space(Context context) {
        this(context, null);
    }

    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Space(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11 = this.getVisibility();
        if (n11 == 0) {
            n11 = 4;
            this.setVisibility(n11);
        }
    }

    private static int getDefaultSize2(int n10, int n11) {
        int n12 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        int n13 = -1 << -1;
        if (n12 != n13) {
            n13 = 0x40000000;
            if (n12 == n13) {
                n10 = n11;
            }
        } else {
            n10 = Math.min(n10, n11);
        }
        return n10;
    }

    public void draw(Canvas canvas) {
    }

    public void onMeasure(int n10, int n11) {
        n10 = Space.getDefaultSize2(this.getSuggestedMinimumWidth(), n10);
        n11 = Space.getDefaultSize2(this.getSuggestedMinimumHeight(), n11);
        this.setMeasuredDimension(n10, n11);
    }
}

