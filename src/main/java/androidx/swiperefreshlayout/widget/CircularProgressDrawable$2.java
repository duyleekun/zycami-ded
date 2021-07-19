/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 */
package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable$Ring;

public class CircularProgressDrawable$2
implements Animator.AnimatorListener {
    public final /* synthetic */ CircularProgressDrawable this$0;
    public final /* synthetic */ CircularProgressDrawable$Ring val$ring;

    public CircularProgressDrawable$2(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable$Ring circularProgressDrawable$Ring) {
        this.this$0 = circularProgressDrawable;
        this.val$ring = circularProgressDrawable$Ring;
    }

    public void onAnimationCancel(Animator animator2) {
    }

    public void onAnimationEnd(Animator animator2) {
    }

    public void onAnimationRepeat(Animator object) {
        CircularProgressDrawable circularProgressDrawable = this.this$0;
        CircularProgressDrawable$Ring circularProgressDrawable$Ring = this.val$ring;
        float f10 = 1.0f;
        boolean bl2 = true;
        circularProgressDrawable.applyTransformation(f10, circularProgressDrawable$Ring, bl2);
        this.val$ring.storeOriginals();
        this.val$ring.goToNextColor();
        circularProgressDrawable = this.this$0;
        boolean bl3 = circularProgressDrawable.mFinishing;
        if (bl3) {
            bl3 = false;
            circularProgressDrawable$Ring = null;
            circularProgressDrawable.mFinishing = false;
            object.cancel();
            long l10 = 1332L;
            object.setDuration(l10);
            object.start();
            object = this.val$ring;
            ((CircularProgressDrawable$Ring)object).setShowArrow(false);
        } else {
            float f11;
            circularProgressDrawable.mRotationCount = f11 = circularProgressDrawable.mRotationCount + f10;
        }
    }

    public void onAnimationStart(Animator animator2) {
        this.this$0.mRotationCount = 0.0f;
    }
}

