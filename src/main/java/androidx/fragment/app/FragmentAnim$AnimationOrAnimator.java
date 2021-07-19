/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.animation.Animation
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

public class FragmentAnim$AnimationOrAnimator {
    public final Animation animation;
    public final Animator animator;

    public FragmentAnim$AnimationOrAnimator(Animator object) {
        this.animation = null;
        this.animator = object;
        if (object != null) {
            return;
        }
        super("Animator cannot be null");
        throw object;
    }

    public FragmentAnim$AnimationOrAnimator(Animation object) {
        this.animation = object;
        this.animator = null;
        if (object != null) {
            return;
        }
        super("Animation cannot be null");
        throw object;
    }
}

