/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.ContentFrameLayout$OnAttachListener;

public class AppCompatDelegateImpl$5
implements ContentFrameLayout$OnAttachListener {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$5(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onAttachedFromWindow() {
    }

    public void onDetachedFromWindow() {
        this.this$0.dismissPopups();
    }
}

