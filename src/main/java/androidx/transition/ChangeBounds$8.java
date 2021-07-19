/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.Rect
 *  android.view.View
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.ViewUtils;

public class ChangeBounds$8
extends AnimatorListenerAdapter {
    private boolean mIsCanceled;
    public final /* synthetic */ ChangeBounds this$0;
    public final /* synthetic */ int val$endBottom;
    public final /* synthetic */ int val$endLeft;
    public final /* synthetic */ int val$endRight;
    public final /* synthetic */ int val$endTop;
    public final /* synthetic */ Rect val$finalClip;
    public final /* synthetic */ View val$view;

    public ChangeBounds$8(ChangeBounds changeBounds, View view, Rect rect, int n10, int n11, int n12, int n13) {
        this.this$0 = changeBounds;
        this.val$view = view;
        this.val$finalClip = rect;
        this.val$endLeft = n10;
        this.val$endTop = n11;
        this.val$endRight = n12;
        this.val$endBottom = n13;
    }

    public void onAnimationCancel(Animator animator2) {
        this.mIsCanceled = true;
    }

    public void onAnimationEnd(Animator animator2) {
        boolean bl2 = this.mIsCanceled;
        if (!bl2) {
            animator2 = this.val$view;
            Rect rect = this.val$finalClip;
            ViewCompat.setClipBounds((View)animator2, rect);
            animator2 = this.val$view;
            int n10 = this.val$endLeft;
            int n11 = this.val$endTop;
            int n12 = this.val$endRight;
            int n13 = this.val$endBottom;
            ViewUtils.setLeftTopRightBottom((View)animator2, n10, n11, n12, n13);
        }
    }
}

