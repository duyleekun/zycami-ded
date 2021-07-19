/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Layout
 *  android.util.AttributeSet
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatTextView;

public class DialogTitle
extends AppCompatTextView {
    public DialogTitle(Context context) {
        super(context);
    }

    public DialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13;
        super.onMeasure(n10, n11);
        Layout layout2 = this.getLayout();
        if (layout2 != null && (n13 = layout2.getLineCount()) > 0 && (n12 = layout2.getEllipsisCount(n13 += -1)) > 0) {
            n12 = 0;
            layout2 = null;
            this.setSingleLine(false);
            n13 = 2;
            this.setMaxLines(n13);
            Context context = this.getContext();
            float f10 = 0.0f;
            int[] nArray = R$styleable.TextAppearance;
            int n14 = 0x1010041;
            int n15 = 16973892;
            context = context.obtainStyledAttributes(null, nArray, n14, n15);
            int n16 = R$styleable.TextAppearance_android_textSize;
            n16 = context.getDimensionPixelSize(n16, 0);
            if (n16 != 0) {
                f10 = n16;
                this.setTextSize(0, f10);
            }
            context.recycle();
            super.onMeasure(n10, n11);
        }
    }
}

