/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.CascadingMenuPopup;

public class CascadingMenuPopup$2
implements View.OnAttachStateChangeListener {
    public final /* synthetic */ CascadingMenuPopup this$0;

    public CascadingMenuPopup$2(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        Object object = this.this$0.mTreeObserver;
        if (object != null) {
            ViewTreeObserver viewTreeObserver;
            boolean bl2 = object.isAlive();
            if (!bl2) {
                object = this.this$0;
                object.mTreeObserver = viewTreeObserver = view.getViewTreeObserver();
            }
            object = this.this$0;
            viewTreeObserver = object.mTreeObserver;
            object = object.mGlobalLayoutListener;
            viewTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
        }
        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }
}

