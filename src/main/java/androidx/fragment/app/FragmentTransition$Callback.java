/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;

public interface FragmentTransition$Callback {
    public void onComplete(Fragment var1, CancellationSignal var2);

    public void onStart(Fragment var1, CancellationSignal var2);
}

