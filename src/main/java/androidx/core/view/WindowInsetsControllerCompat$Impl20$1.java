/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 */
package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowInsetsControllerCompat$Impl20;

public class WindowInsetsControllerCompat$Impl20$1
implements Runnable {
    public final /* synthetic */ WindowInsetsControllerCompat.Impl20 this$0;
    public final /* synthetic */ View val$finalView;

    public WindowInsetsControllerCompat$Impl20$1(WindowInsetsControllerCompat.Impl20 impl20, View view) {
        this.this$0 = impl20;
        this.val$finalView = view;
    }

    public void run() {
        InputMethodManager inputMethodManager = (InputMethodManager)this.val$finalView.getContext().getSystemService("input_method");
        View view = this.val$finalView;
        inputMethodManager.showSoftInput(view, 0);
    }
}

