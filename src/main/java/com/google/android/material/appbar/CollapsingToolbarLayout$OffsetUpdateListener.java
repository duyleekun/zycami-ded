/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams;
import com.google.android.material.appbar.ViewOffsetHelper;
import com.google.android.material.internal.CollapsingTextHelper;

public class CollapsingToolbarLayout$OffsetUpdateListener
implements AppBarLayout$OnOffsetChangedListener {
    public final /* synthetic */ CollapsingToolbarLayout this$0;

    public CollapsingToolbarLayout$OffsetUpdateListener(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.this$0 = collapsingToolbarLayout;
    }

    public void onOffsetChanged(AppBarLayout object, int n10) {
        int n11;
        object = this.this$0;
        ((CollapsingToolbarLayout)object).currentOffset = n10;
        object = ((CollapsingToolbarLayout)object).lastInsets;
        int n12 = 0;
        float f10 = 0.0f;
        CollapsingToolbarLayout collapsingToolbarLayout = null;
        if (object != null) {
            n11 = ((WindowInsetsCompat)object).getSystemWindowInsetTop();
        } else {
            n11 = 0;
            object = null;
        }
        CollapsingToolbarLayout collapsingToolbarLayout2 = this.this$0;
        int n13 = collapsingToolbarLayout2.getChildCount();
        for (int i10 = 0; i10 < n13; ++i10) {
            int n14;
            View view = this.this$0.getChildAt(i10);
            CollapsingToolbarLayout$LayoutParams collapsingToolbarLayout$LayoutParams = (CollapsingToolbarLayout$LayoutParams)view.getLayoutParams();
            ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(view);
            int n15 = collapsingToolbarLayout$LayoutParams.collapseMode;
            int n16 = 1;
            if (n15 != n16) {
                n14 = 2;
                float f11 = 2.8E-45f;
                if (n15 != n14) continue;
                f11 = -n10;
                float f12 = collapsingToolbarLayout$LayoutParams.parallaxMult;
                n14 = Math.round(f11 *= f12);
                viewOffsetHelper.setTopAndBottomOffset(n14);
                continue;
            }
            int n17 = -n10;
            CollapsingToolbarLayout collapsingToolbarLayout3 = this.this$0;
            n14 = collapsingToolbarLayout3.getMaxOffsetForPinChild(view);
            n14 = MathUtils.clamp(n17, 0, n14);
            viewOffsetHelper.setTopAndBottomOffset(n14);
        }
        this.this$0.updateScrimVisibility();
        collapsingToolbarLayout = this.this$0;
        collapsingToolbarLayout2 = collapsingToolbarLayout.statusBarScrim;
        if (collapsingToolbarLayout2 != null && n11 > 0) {
            ViewCompat.postInvalidateOnAnimation((View)collapsingToolbarLayout);
        }
        n12 = this.this$0.getHeight();
        n13 = ViewCompat.getMinimumHeight((View)this.this$0);
        n12 = n12 - n13 - n11;
        object = this.this$0.collapsingTextHelper;
        float f13 = Math.abs(n10);
        f10 = n12;
        ((CollapsingTextHelper)object).setExpansionFraction(f13 /= f10);
    }
}

