/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;

public class AppCompatDelegateImpl$4
implements FitWindowsViewGroup$OnFitSystemWindowsListener {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$4(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onFitSystemWindows(Rect rect) {
        int n10;
        rect.top = n10 = this.this$0.updateStatusGuard(null, rect);
    }
}

