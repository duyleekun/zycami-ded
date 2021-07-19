/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.fragment.app.SpecialEffectsController$Operation$State;
import java.util.ArrayList;

public class SpecialEffectsController$1
implements Runnable {
    public final /* synthetic */ SpecialEffectsController this$0;
    public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation val$operation;

    public SpecialEffectsController$1(SpecialEffectsController specialEffectsController, SpecialEffectsController$FragmentStateManagerOperation fragmentStateManagerOperation) {
        this.this$0 = specialEffectsController;
        this.val$operation = fragmentStateManagerOperation;
    }

    public void run() {
        Object object = this.this$0.mPendingOperations;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.val$operation;
        boolean bl2 = ((ArrayList)object).contains(specialEffectsController$FragmentStateManagerOperation);
        if (bl2) {
            object = this.val$operation.getFinalState();
            specialEffectsController$FragmentStateManagerOperation = this.val$operation.getFragment().mView;
            ((SpecialEffectsController$Operation$State)((Object)object)).applyState((View)specialEffectsController$FragmentStateManagerOperation);
        }
    }
}

