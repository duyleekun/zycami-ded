/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;

public class Fragment$1
implements Runnable {
    public final /* synthetic */ Fragment this$0;

    public Fragment$1(Fragment fragment) {
        this.this$0 = fragment;
    }

    public void run() {
        this.this$0.startPostponedEnterTransition();
    }
}

