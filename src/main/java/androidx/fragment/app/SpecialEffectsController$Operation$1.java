/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.fragment.app.SpecialEffectsController$Operation;

public class SpecialEffectsController$Operation$1
implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ SpecialEffectsController$Operation this$0;

    public SpecialEffectsController$Operation$1(SpecialEffectsController$Operation specialEffectsController$Operation) {
        this.this$0 = specialEffectsController$Operation;
    }

    public void onCancel() {
        this.this$0.cancel();
    }
}

