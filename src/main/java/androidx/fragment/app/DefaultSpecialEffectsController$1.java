/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController$Operation;
import java.util.List;

public class DefaultSpecialEffectsController$1
implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ List val$awaitingContainerChanges;
    public final /* synthetic */ SpecialEffectsController$Operation val$operation;

    public DefaultSpecialEffectsController$1(DefaultSpecialEffectsController defaultSpecialEffectsController, List list, SpecialEffectsController$Operation operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$awaitingContainerChanges = list;
        this.val$operation = operation;
    }

    public void run() {
        Object object = this.val$awaitingContainerChanges;
        SpecialEffectsController$Operation specialEffectsController$Operation = this.val$operation;
        boolean bl2 = object.contains(specialEffectsController$Operation);
        if (bl2) {
            object = this.val$awaitingContainerChanges;
            specialEffectsController$Operation = this.val$operation;
            object.remove(specialEffectsController$Operation);
            object = this.this$0;
            specialEffectsController$Operation = this.val$operation;
            ((DefaultSpecialEffectsController)object).applyContainerChanges(specialEffectsController$Operation);
        }
    }
}

