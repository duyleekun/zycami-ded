/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.navigation;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class Navigation$2
implements View.OnClickListener {
    public final /* synthetic */ NavDirections val$directions;

    public Navigation$2(NavDirections navDirections) {
        this.val$directions = navDirections;
    }

    public void onClick(View object) {
        object = Navigation.findNavController((View)object);
        NavDirections navDirections = this.val$directions;
        ((NavController)object).navigate(navDirections);
    }
}

