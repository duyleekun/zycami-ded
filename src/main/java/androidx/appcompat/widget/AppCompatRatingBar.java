/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.RatingBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatProgressBarHelper;
import androidx.appcompat.widget.ThemeUtils;

public class AppCompatRatingBar
extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.ratingBarStyle;
        this(context, attributeSet, n10);
    }

    public AppCompatRatingBar(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        object = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object);
        super((ProgressBar)this);
        this.mAppCompatProgressBarHelper = object;
        ((AppCompatProgressBarHelper)object).loadFromAttributes(attributeSet, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onMeasure(int n10, int n11) {
        synchronized (this) {
            super.onMeasure(n10, n11);
            AppCompatProgressBarHelper appCompatProgressBarHelper = this.mAppCompatProgressBarHelper;
            appCompatProgressBarHelper = appCompatProgressBarHelper.getSampleTile();
            if (appCompatProgressBarHelper != null) {
                n11 = appCompatProgressBarHelper.getWidth();
                int n12 = this.getNumStars();
                n11 *= n12;
                n12 = 0;
                n10 = View.resolveSizeAndState((int)n11, (int)n10, (int)0);
                n11 = this.getMeasuredHeight();
                this.setMeasuredDimension(n10, n11);
            }
            return;
        }
    }
}

