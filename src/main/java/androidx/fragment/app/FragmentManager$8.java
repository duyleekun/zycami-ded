/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

public class FragmentManager$8
implements FragmentOnAttachListener {
    public final /* synthetic */ FragmentManager this$0;
    public final /* synthetic */ Fragment val$parent;

    public FragmentManager$8(FragmentManager fragmentManager, Fragment fragment) {
        this.this$0 = fragmentManager;
        this.val$parent = fragment;
    }

    public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
        this.val$parent.onAttachFragment(fragment);
    }
}

