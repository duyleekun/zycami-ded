/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnUnhandledKeyEventListener
 */
package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat;

public class ViewCompat$CompatImplApi28$1
implements View.OnUnhandledKeyEventListener {
    public final /* synthetic */ ViewCompat$OnUnhandledKeyEventListenerCompat val$listener;

    public ViewCompat$CompatImplApi28$1(ViewCompat$OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.val$listener = onUnhandledKeyEventListenerCompat;
    }

    public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.val$listener.onUnhandledKeyEvent(view, keyEvent);
    }
}

