/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.fragment.app;

import android.view.View;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.fragment.app.Fragment;

public class FragmentAnim$1
implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ Fragment val$fragment;

    public FragmentAnim$1(Fragment fragment) {
        this.val$fragment = fragment;
    }

    public void onCancel() {
        View view = this.val$fragment.getAnimatingAway();
        if (view != null) {
            view = this.val$fragment.getAnimatingAway();
            Fragment fragment = this.val$fragment;
            fragment.setAnimatingAway(null);
            view.clearAnimation();
        }
        this.val$fragment.setAnimator(null);
    }
}

