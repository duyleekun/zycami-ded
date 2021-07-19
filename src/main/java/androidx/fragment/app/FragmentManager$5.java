/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;

public class FragmentManager$5
implements Runnable {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$5(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public void run() {
        this.this$0.execPendingActions(true);
    }
}

