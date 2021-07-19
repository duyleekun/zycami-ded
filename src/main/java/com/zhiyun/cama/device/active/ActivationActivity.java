/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.zhiyun.cama.device.active;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import com.zhiyun.cama.device.active.ActivationActivity$a;
import d.v.c.y0.a.a;
import d.v.f.c.d;

public class ActivationActivity
extends d {
    private NavController$OnDestinationChangedListener b;
    private d.v.c.w0.a c;

    private void d() {
        Object object = this.b;
        if (object == null) {
            this.b = object = new a(this);
        }
        object = Navigation.findNavController(this, 2131362932);
        NavController$OnDestinationChangedListener navController$OnDestinationChangedListener = this.b;
        ((NavController)object).addOnDestinationChangedListener(navController$OnDestinationChangedListener);
    }

    private /* synthetic */ void f(NavController navController, NavDestination navDestination, Bundle bundle) {
        int n10;
        int n11 = navDestination.getId();
        int n12 = 0;
        int n13 = 2131361997;
        n11 = n11 != n13 && (n11 = navDestination.getId()) != (n10 = 2131361998) ? 0 : 1;
        navDestination = this.c.a;
        if (n11 != 0) {
            n12 = 8;
        }
        navDestination.setVisibility(n12);
    }

    public static void i(Context context) {
        Intent intent = new Intent(context, ActivationActivity.class);
        context.startActivity(intent);
    }

    public /* synthetic */ void h(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.f(navController, navDestination, bundle);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = (d.v.c.w0.a)DataBindingUtil.setContentView(this, 2131558428);
        this.c = object;
        ActivationActivity$a activationActivity$a = new ActivationActivity$a(this);
        ((d.v.c.w0.a)object).z(activationActivity$a);
        this.c.setLifecycleOwner(this);
        this.d();
    }
}

