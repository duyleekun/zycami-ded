/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RatingBar
 *  android.widget.RatingBar$OnRatingBarChangeListener
 */
package androidx.databinding.adapters;

import android.widget.RatingBar;
import androidx.databinding.InverseBindingListener;

public final class RatingBarBindingAdapter$1
implements RatingBar.OnRatingBarChangeListener {
    public final /* synthetic */ RatingBar.OnRatingBarChangeListener val$listener;
    public final /* synthetic */ InverseBindingListener val$ratingChange;

    public RatingBarBindingAdapter$1(RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, InverseBindingListener inverseBindingListener) {
        this.val$listener = onRatingBarChangeListener;
        this.val$ratingChange = inverseBindingListener;
    }

    public void onRatingChanged(RatingBar ratingBar, float f10, boolean bl2) {
        RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = this.val$listener;
        if (onRatingBarChangeListener != null) {
            onRatingBarChangeListener.onRatingChanged(ratingBar, f10, bl2);
        }
        this.val$ratingChange.onChange();
    }
}

