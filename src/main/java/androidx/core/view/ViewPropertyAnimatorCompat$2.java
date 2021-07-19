/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

public class ViewPropertyAnimatorCompat$2
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewPropertyAnimatorCompat this$0;
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener val$listener;
    public final /* synthetic */ View val$view;

    public ViewPropertyAnimatorCompat$2(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.this$0 = viewPropertyAnimatorCompat;
        this.val$listener = viewPropertyAnimatorUpdateListener;
        this.val$view = view;
    }

    public void onAnimationUpdate(ValueAnimator object) {
        object = this.val$listener;
        View view = this.val$view;
        object.onAnimationUpdate(view);
    }
}

