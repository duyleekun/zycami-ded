/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.fragment.app;

import android.content.Context;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController$SpecialEffectsInfo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentAnim$AnimationOrAnimator;
import androidx.fragment.app.SpecialEffectsController$Operation;
import androidx.fragment.app.SpecialEffectsController$Operation$State;

public class DefaultSpecialEffectsController$AnimationInfo
extends DefaultSpecialEffectsController$SpecialEffectsInfo {
    private FragmentAnim$AnimationOrAnimator mAnimation;
    private boolean mIsPop;
    private boolean mLoadedAnim = false;

    public DefaultSpecialEffectsController$AnimationInfo(SpecialEffectsController$Operation specialEffectsController$Operation, CancellationSignal cancellationSignal, boolean bl2) {
        super(specialEffectsController$Operation, cancellationSignal);
        this.mIsPop = bl2;
    }

    public FragmentAnim$AnimationOrAnimator getAnimation(Context object) {
        boolean bl2;
        boolean bl3 = this.mLoadedAnim;
        if (bl3) {
            return this.mAnimation;
        }
        Fragment fragment = this.getOperation().getFragment();
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State = this.getOperation().getFinalState();
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = SpecialEffectsController$Operation$State.VISIBLE;
        boolean bl4 = true;
        if (specialEffectsController$Operation$State == specialEffectsController$Operation$State2) {
            bl2 = bl4;
        } else {
            bl2 = false;
            specialEffectsController$Operation$State = null;
        }
        boolean bl5 = this.mIsPop;
        object = FragmentAnim.loadAnimation(object, fragment, bl2, bl5);
        this.mAnimation = object;
        this.mLoadedAnim = bl4;
        return object;
    }
}

