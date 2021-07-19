/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentManager;

public class FragmentManager$1
extends OnBackPressedCallback {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$1(FragmentManager fragmentManager, boolean bl2) {
        this.this$0 = fragmentManager;
        super(bl2);
    }

    public void handleOnBackPressed() {
        this.this$0.handleOnBackPressed();
    }
}

