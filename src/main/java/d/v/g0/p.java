/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View$MeasureSpec
 *  android.widget.ScrollView
 */
package d.v.g0;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.zhiyun.ui.R$styleable;

public class p
extends ScrollView {
    private int a;

    public p(Context context) {
        super(context);
    }

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context, attributeSet);
    }

    public p(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.MaxHeightScrollView;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.MaxHeightScrollView_maxHeight;
        int n11 = this.a;
        this.a = n10 = context.getLayoutDimension(n10, n11);
        context.recycle();
    }

    public void onMeasure(int n10, int n11) {
        int n12 = this.a;
        if (n12 > 0) {
            n11 = View.MeasureSpec.makeMeasureSpec((int)n12, (int)(-1 << -1));
        }
        super.onMeasure(n10, n11);
    }
}

