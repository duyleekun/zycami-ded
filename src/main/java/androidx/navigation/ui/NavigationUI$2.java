/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.navigation.ui;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class NavigationUI$2
implements View.OnClickListener {
    public final /* synthetic */ AppBarConfiguration val$configuration;
    public final /* synthetic */ NavController val$navController;

    public NavigationUI$2(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.val$navController = navController;
        this.val$configuration = appBarConfiguration;
    }

    public void onClick(View object) {
        object = this.val$navController;
        AppBarConfiguration appBarConfiguration = this.val$configuration;
        NavigationUI.navigateUp((NavController)object, appBarConfiguration);
    }
}

