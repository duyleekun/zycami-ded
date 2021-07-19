/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 */
package androidx.drawerlayout.widget;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerLayout$2
implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ DrawerLayout this$0;

    public DrawerLayout$2(DrawerLayout drawerLayout) {
        this.this$0 = drawerLayout;
    }

    public WindowInsets onApplyWindowInsets(View object, WindowInsets windowInsets) {
        object = (DrawerLayout)object;
        int n10 = windowInsets.getSystemWindowInsetTop();
        n10 = n10 > 0 ? 1 : 0;
        ((DrawerLayout)object).setChildInsets(windowInsets, n10 != 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}

