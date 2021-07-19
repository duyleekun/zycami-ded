/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.BaseTransientBottomBar$OnLayoutChangeListener;

public class BaseTransientBottomBar$7
implements BaseTransientBottomBar$OnLayoutChangeListener {
    public final /* synthetic */ BaseTransientBottomBar this$0;

    public BaseTransientBottomBar$7(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onLayoutChange(View object, int n10, int n11, int n12, int n13) {
        this.this$0.view.setOnLayoutChangeListener(null);
        object = this.this$0;
        boolean bl2 = ((BaseTransientBottomBar)object).shouldAnimate();
        if (bl2) {
            object = this.this$0;
            ((BaseTransientBottomBar)object).animateViewIn();
        } else {
            object = this.this$0;
            ((BaseTransientBottomBar)object).onViewShown();
        }
    }
}

