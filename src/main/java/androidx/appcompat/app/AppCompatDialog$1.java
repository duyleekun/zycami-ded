/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 */
package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.KeyEventDispatcher$Component;

public class AppCompatDialog$1
implements KeyEventDispatcher$Component {
    public final /* synthetic */ AppCompatDialog this$0;

    public AppCompatDialog$1(AppCompatDialog appCompatDialog) {
        this.this$0 = appCompatDialog;
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.this$0.superDispatchKeyEvent(keyEvent);
    }
}

