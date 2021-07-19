/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AppCompatDelegateImpl$3
implements OnApplyWindowInsetsListener {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$3(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int n10 = windowInsetsCompat.getSystemWindowInsetTop();
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        int n11 = 0;
        int n12 = appCompatDelegateImpl.updateStatusGuard(windowInsetsCompat, null);
        if (n10 != n12) {
            n10 = windowInsetsCompat.getSystemWindowInsetLeft();
            n11 = windowInsetsCompat.getSystemWindowInsetRight();
            int n13 = windowInsetsCompat.getSystemWindowInsetBottom();
            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(n10, n12, n11, n13);
        }
        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
    }
}

