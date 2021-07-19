/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout;

public class BaseTransientBottomBar$11
implements ValueAnimator.AnimatorUpdateListener {
    private int previousAnimatedIntValue = 0;
    public final /* synthetic */ BaseTransientBottomBar this$0;

    public BaseTransientBottomBar$11(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator object) {
        object = (Integer)object.getAnimatedValue();
        int n10 = (Integer)object;
        boolean bl2 = BaseTransientBottomBar.access$200();
        if (bl2) {
            BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout = this.this$0.view;
            int n11 = this.previousAnimatedIntValue;
            n11 = n10 - n11;
            ViewCompat.offsetTopAndBottom((View)baseTransientBottomBar$SnackbarBaseLayout, n11);
        } else {
            BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout = this.this$0.view;
            float f10 = n10;
            baseTransientBottomBar$SnackbarBaseLayout.setTranslationY(f10);
        }
        this.previousAnimatedIntValue = n10;
    }
}

