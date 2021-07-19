/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import java.util.ArrayList;

public class SpecialEffectsController$2
implements Runnable {
    public final /* synthetic */ SpecialEffectsController this$0;
    public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation val$operation;

    public SpecialEffectsController$2(SpecialEffectsController specialEffectsController, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
        this.this$0 = specialEffectsController;
        this.val$operation = specialEffectsController$FragmentStateManagerOperation;
    }

    public void run() {
        ArrayList arrayList = this.this$0.mPendingOperations;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.val$operation;
        arrayList.remove(specialEffectsController$FragmentStateManagerOperation);
        arrayList = this.this$0.mRunningOperations;
        specialEffectsController$FragmentStateManagerOperation = this.val$operation;
        arrayList.remove(specialEffectsController$FragmentStateManagerOperation);
    }
}

