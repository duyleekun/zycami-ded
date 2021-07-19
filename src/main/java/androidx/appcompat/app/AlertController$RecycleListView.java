/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.ListView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.appcompat.R$styleable;

public class AlertController$RecycleListView
extends ListView {
    private final int mPaddingBottomNoButtons;
    private final int mPaddingTopNoTitle;

    public AlertController$RecycleListView(Context context) {
        this(context, null);
    }

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        int[] nArray = R$styleable.RecycleListView;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n11 = R$styleable.RecycleListView_paddingBottomNoButtons;
        int n12 = -1;
        this.mPaddingBottomNoButtons = n11 = context.getDimensionPixelOffset(n11, n12);
        n11 = R$styleable.RecycleListView_paddingTopNoTitle;
        this.mPaddingTopNoTitle = n10 = context.getDimensionPixelOffset(n11, n12);
    }

    /*
     * WARNING - void declaration
     */
    public void setHasDecor(boolean bl2, boolean bl3) {
        void var2_5;
        if (var2_5 == false || !bl2) {
            void var2_8;
            void var1_4;
            int n10 = this.getPaddingLeft();
            if (bl2) {
                int n11 = this.getPaddingTop();
            } else {
                int n12 = this.mPaddingTopNoTitle;
            }
            int n13 = this.getPaddingRight();
            if (var2_5 != false) {
                int n14 = this.getPaddingBottom();
            } else {
                int n15 = this.mPaddingBottomNoButtons;
            }
            this.setPadding(n10, (int)var1_4, n13, (int)var2_8);
        }
    }
}

