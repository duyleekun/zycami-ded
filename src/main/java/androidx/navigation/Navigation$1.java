/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.navigation;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class Navigation$1
implements View.OnClickListener {
    public final /* synthetic */ Bundle val$args;
    public final /* synthetic */ int val$resId;

    public Navigation$1(int n10, Bundle bundle) {
        this.val$resId = n10;
        this.val$args = bundle;
    }

    public void onClick(View object) {
        object = Navigation.findNavController((View)object);
        int n10 = this.val$resId;
        Bundle bundle = this.val$args;
        ((NavController)object).navigate(n10, bundle);
    }
}

