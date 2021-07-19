/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsAnimationControlListener
 *  android.view.WindowInsetsAnimationController
 */
package androidx.core.view;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;

public class WindowInsetsControllerCompat$Impl30$1
implements WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationControllerCompat mCompatAnimController = null;
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 this$0;
    public final /* synthetic */ WindowInsetsAnimationControlListenerCompat val$listener;

    public WindowInsetsControllerCompat$Impl30$1(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.this$0 = impl30;
        this.val$listener = windowInsetsAnimationControlListenerCompat;
    }

    public void onCancelled(WindowInsetsAnimationController object) {
        WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat = this.val$listener;
        object = object == null ? null : this.mCompatAnimController;
        windowInsetsAnimationControlListenerCompat.onCancelled((WindowInsetsAnimationControllerCompat)object);
    }

    public void onFinished(WindowInsetsAnimationController object) {
        object = this.val$listener;
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.mCompatAnimController;
        object.onFinished(windowInsetsAnimationControllerCompat);
    }

    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int n10) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat;
        this.mCompatAnimController = windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
        this.val$listener.onReady(windowInsetsAnimationControllerCompat, n10);
    }
}

