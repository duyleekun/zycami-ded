/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener;

public class WindowInsetsControllerCompat$Impl30$2
implements WindowInsetsController.OnControllableInsetsChangedListener {
    public final /* synthetic */ WindowInsetsControllerCompat$Impl30 this$0;
    public final /* synthetic */ WindowInsetsControllerCompat$OnControllableInsetsChangedListener val$listener;

    public WindowInsetsControllerCompat$Impl30$2(WindowInsetsControllerCompat$Impl30 windowInsetsControllerCompat$Impl30, WindowInsetsControllerCompat$OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.this$0 = windowInsetsControllerCompat$Impl30;
        this.val$listener = onControllableInsetsChangedListener;
    }

    public void onControllableInsetsChanged(WindowInsetsController object, int n10) {
        Object object2 = this.this$0;
        WindowInsetsController windowInsetsController = ((WindowInsetsControllerCompat$Impl30)object2).mInsetsController;
        if (windowInsetsController == object) {
            object = this.val$listener;
            object2 = ((WindowInsetsControllerCompat$Impl30)object2).mCompatController;
            object.onControllableInsetsChanged((WindowInsetsControllerCompat)object2, n10);
        }
    }
}

