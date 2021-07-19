/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.Matrix
 *  android.view.View
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;
import androidx.transition.ChangeTransform$PathAnimatorMatrix;
import androidx.transition.ChangeTransform$Transforms;
import androidx.transition.R$id;
import androidx.transition.ViewUtils;

public class ChangeTransform$3
extends AnimatorListenerAdapter {
    private boolean mIsCanceled;
    private Matrix mTempMatrix;
    public final /* synthetic */ ChangeTransform this$0;
    public final /* synthetic */ Matrix val$finalEndMatrix;
    public final /* synthetic */ boolean val$handleParentChange;
    public final /* synthetic */ ChangeTransform$PathAnimatorMatrix val$pathAnimatorMatrix;
    public final /* synthetic */ ChangeTransform$Transforms val$transforms;
    public final /* synthetic */ View val$view;

    public ChangeTransform$3(ChangeTransform changeTransform, boolean bl2, Matrix matrix, View view, ChangeTransform$Transforms transforms, ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix) {
        this.this$0 = changeTransform;
        this.val$handleParentChange = bl2;
        this.val$finalEndMatrix = matrix;
        this.val$view = view;
        this.val$transforms = transforms;
        this.val$pathAnimatorMatrix = changeTransform$PathAnimatorMatrix;
        this.mTempMatrix = changeTransform;
    }

    private void setCurrentMatrix(Matrix object) {
        this.mTempMatrix.set((Matrix)object);
        object = this.val$view;
        int n10 = R$id.transition_transform;
        Matrix matrix = this.mTempMatrix;
        object.setTag(n10, (Object)matrix);
        object = this.val$transforms;
        View view = this.val$view;
        ((ChangeTransform$Transforms)object).restore(view);
    }

    public void onAnimationCancel(Animator animator2) {
        this.mIsCanceled = true;
    }

    /*
     * Unable to fully structure code
     */
    public void onAnimationEnd(Animator var1_1) {
        block2: {
            var2_2 = this.mIsCanceled;
            var3_3 = null;
            if (var2_2) break block2;
            var2_2 = this.val$handleParentChange;
            if (!var2_2) ** GOTO lbl-1000
            var1_1 = this.this$0;
            var2_2 = var1_1.mUseOverlay;
            if (var2_2) {
                var1_1 = this.val$finalEndMatrix;
                this.setCurrentMatrix((Matrix)var1_1);
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = this.val$view;
                var4_4 = R$id.transition_transform;
                var1_1.setTag(var4_4, null);
                var1_1 = this.val$view;
                var4_4 = R$id.parent_matrix;
                var1_1.setTag(var4_4, null);
            }
        }
        ViewUtils.setAnimationMatrix(this.val$view, null);
        var1_1 = this.val$transforms;
        var3_3 = this.val$view;
        var1_1.restore(var3_3);
    }

    public void onAnimationPause(Animator animator2) {
        animator2 = this.val$pathAnimatorMatrix.getMatrix();
        this.setCurrentMatrix((Matrix)animator2);
    }

    public void onAnimationResume(Animator animator2) {
        ChangeTransform.setIdentityTransforms(this.val$view);
    }
}

