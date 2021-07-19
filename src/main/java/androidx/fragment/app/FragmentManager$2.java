/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition$Callback;

public class FragmentManager$2
implements FragmentTransition$Callback {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$2(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public void onComplete(Fragment fragment, CancellationSignal cancellationSignal) {
        boolean bl2 = cancellationSignal.isCanceled();
        if (!bl2) {
            FragmentManager fragmentManager = this.this$0;
            fragmentManager.removeCancellationSignal(fragment, cancellationSignal);
        }
    }

    public void onStart(Fragment fragment, CancellationSignal cancellationSignal) {
        this.this$0.addCancellationSignal(fragment, cancellationSignal);
    }
}

