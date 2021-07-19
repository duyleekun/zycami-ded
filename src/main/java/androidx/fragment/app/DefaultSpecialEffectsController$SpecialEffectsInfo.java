/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.SpecialEffectsController$Operation;
import androidx.fragment.app.SpecialEffectsController$Operation$State;

public class DefaultSpecialEffectsController$SpecialEffectsInfo {
    private final SpecialEffectsController$Operation mOperation;
    private final CancellationSignal mSignal;

    public DefaultSpecialEffectsController$SpecialEffectsInfo(SpecialEffectsController$Operation specialEffectsController$Operation, CancellationSignal cancellationSignal) {
        this.mOperation = specialEffectsController$Operation;
        this.mSignal = cancellationSignal;
    }

    public void completeSpecialEffect() {
        SpecialEffectsController$Operation specialEffectsController$Operation = this.mOperation;
        CancellationSignal cancellationSignal = this.mSignal;
        specialEffectsController$Operation.completeSpecialEffect(cancellationSignal);
    }

    public SpecialEffectsController$Operation getOperation() {
        return this.mOperation;
    }

    public CancellationSignal getSignal() {
        return this.mSignal;
    }

    public boolean isVisibilityUnchanged() {
        boolean bl2;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State3 = SpecialEffectsController$Operation$State.from(this.mOperation.getFragment().mView);
        if (specialEffectsController$Operation$State3 != (specialEffectsController$Operation$State2 = this.mOperation.getFinalState()) && (specialEffectsController$Operation$State3 == (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.VISIBLE) || specialEffectsController$Operation$State2 == specialEffectsController$Operation$State)) {
            bl2 = false;
            specialEffectsController$Operation$State3 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

