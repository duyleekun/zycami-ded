/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 */
package androidx.fragment.app;

import android.animation.Animator;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.fragment.app.DefaultSpecialEffectsController;

public class DefaultSpecialEffectsController$3
implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ Animator val$animator;

    public DefaultSpecialEffectsController$3(DefaultSpecialEffectsController defaultSpecialEffectsController, Animator animator2) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$animator = animator2;
    }

    public void onCancel() {
        this.val$animator.end();
    }
}

