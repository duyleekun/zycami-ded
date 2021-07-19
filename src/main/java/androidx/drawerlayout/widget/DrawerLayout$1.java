/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.drawerlayout.widget;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerLayout$1
implements AccessibilityViewCommand {
    public final /* synthetic */ DrawerLayout this$0;

    public DrawerLayout$1(DrawerLayout drawerLayout) {
        this.this$0 = drawerLayout;
    }

    public boolean perform(View view, AccessibilityViewCommand$CommandArguments object) {
        int n10;
        int n11;
        object = this.this$0;
        boolean n112 = ((DrawerLayout)object).isDrawerOpen(view);
        if (n112 && (n11 = ((DrawerLayout)(object = this.this$0)).getDrawerLockMode(view)) != (n10 = 2)) {
            this.this$0.closeDrawer(view);
            return true;
        }
        return false;
    }
}

