/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.activity.OnBackPressedCallback;
import androidx.navigation.NavController;

public class NavController$2
extends OnBackPressedCallback {
    public final /* synthetic */ NavController this$0;

    public NavController$2(NavController navController, boolean bl2) {
        this.this$0 = navController;
        super(bl2);
    }

    public void handleOnBackPressed() {
        this.this$0.popBackStack();
    }
}

