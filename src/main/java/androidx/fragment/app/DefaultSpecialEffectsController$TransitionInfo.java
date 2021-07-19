/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController$SpecialEffectsInfo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.fragment.app.SpecialEffectsController$Operation;
import androidx.fragment.app.SpecialEffectsController$Operation$State;

public class DefaultSpecialEffectsController$TransitionInfo
extends DefaultSpecialEffectsController$SpecialEffectsInfo {
    private final boolean mOverlapAllowed;
    private final Object mSharedElementTransition;
    private final Object mTransition;

    public DefaultSpecialEffectsController$TransitionInfo(SpecialEffectsController$Operation object, CancellationSignal object2, boolean bl2, boolean bl3) {
        super((SpecialEffectsController$Operation)object, (CancellationSignal)object2);
        object2 = ((SpecialEffectsController$Operation)object).getFinalState();
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.VISIBLE;
        if (object2 == specialEffectsController$Operation$State) {
            boolean bl4;
            object2 = bl2 ? ((SpecialEffectsController$Operation)object).getFragment().getReenterTransition() : ((SpecialEffectsController$Operation)object).getFragment().getEnterTransition();
            this.mTransition = object2;
            if (bl2) {
                object2 = ((SpecialEffectsController$Operation)object).getFragment();
                bl4 = ((Fragment)object2).getAllowReturnTransitionOverlap();
            } else {
                object2 = ((SpecialEffectsController$Operation)object).getFragment();
                bl4 = ((Fragment)object2).getAllowEnterTransitionOverlap();
            }
            this.mOverlapAllowed = bl4;
        } else {
            boolean bl5;
            object2 = bl2 ? ((SpecialEffectsController$Operation)object).getFragment().getReturnTransition() : ((SpecialEffectsController$Operation)object).getFragment().getExitTransition();
            this.mTransition = object2;
            this.mOverlapAllowed = bl5 = true;
        }
        if (bl3) {
            this.mSharedElementTransition = bl2 ? (object = ((SpecialEffectsController$Operation)object).getFragment().getSharedElementReturnTransition()) : (object = ((SpecialEffectsController$Operation)object).getFragment().getSharedElementEnterTransition());
        } else {
            object = null;
            this.mSharedElementTransition = null;
        }
    }

    private FragmentTransitionImpl getHandlingImpl(Object object) {
        boolean bl2;
        if (object == null) {
            return null;
        }
        Object object2 = FragmentTransition.PLATFORM_IMPL;
        if (object2 != null && (bl2 = ((FragmentTransitionImpl)object2).canHandle(object))) {
            return object2;
        }
        object2 = FragmentTransition.SUPPORT_IMPL;
        if (object2 != null && (bl2 = ((FragmentTransitionImpl)object2).canHandle(object))) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transition ");
        stringBuilder.append(object);
        stringBuilder.append(" for fragment ");
        object = this.getOperation().getFragment();
        stringBuilder.append(object);
        stringBuilder.append(" is not a valid framework Transition or AndroidX Transition");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public FragmentTransitionImpl getHandlingImpl() {
        Object object = this.mTransition;
        object = this.getHandlingImpl(object);
        Object object2 = this.mSharedElementTransition;
        object2 = this.getHandlingImpl(object2);
        if (object != null && object2 != null && object != object2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            Object object3 = this.getOperation().getFragment();
            ((StringBuilder)object2).append(object3);
            ((StringBuilder)object2).append(" returned Transition ");
            object3 = this.mTransition;
            ((StringBuilder)object2).append(object3);
            ((StringBuilder)object2).append(" which uses a different Transition  type than its shared element transition ");
            object3 = this.mSharedElementTransition;
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        if (object == null) {
            object = object2;
        }
        return object;
    }

    public Object getSharedElementTransition() {
        return this.mSharedElementTransition;
    }

    public Object getTransition() {
        return this.mTransition;
    }

    public boolean hasSharedElementTransition() {
        boolean bl2;
        Object object = this.mSharedElementTransition;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isOverlapAllowed() {
        return this.mOverlapAllowed;
    }
}

