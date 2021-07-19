/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;

public class ActionBarDrawerToggle$1
implements View.OnClickListener {
    public final /* synthetic */ ActionBarDrawerToggle this$0;

    public ActionBarDrawerToggle$1(ActionBarDrawerToggle actionBarDrawerToggle) {
        this.this$0 = actionBarDrawerToggle;
    }

    public void onClick(View view) {
        ActionBarDrawerToggle actionBarDrawerToggle = this.this$0;
        boolean bl2 = actionBarDrawerToggle.mDrawerIndicatorEnabled;
        if (bl2) {
            actionBarDrawerToggle.toggle();
        } else {
            actionBarDrawerToggle = actionBarDrawerToggle.mToolbarNavigationClickListener;
            if (actionBarDrawerToggle != null) {
                actionBarDrawerToggle.onClick(view);
            }
        }
    }
}

