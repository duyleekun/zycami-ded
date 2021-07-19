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
import androidx.databinding.adapters.RatingBarBindingAdapter$1;

public class RatingBarBindingAdapter {
    public static void setListeners(RatingBar ratingBar, RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
        } else {
            RatingBarBindingAdapter$1 ratingBarBindingAdapter$1 = new RatingBarBindingAdapter$1(onRatingBarChangeListener, inverseBindingListener);
            ratingBar.setOnRatingBarChangeListener((RatingBar.OnRatingBarChangeListener)ratingBarBindingAdapter$1);
        }
    }

    public static void setRating(RatingBar ratingBar, float f10) {
        float f11 = ratingBar.getRating();
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            ratingBar.setRating(f10);
        }
    }
}

