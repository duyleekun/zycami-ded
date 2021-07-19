/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.zhiyun.cama.prime.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.cama.prime.web.PrimeWebFragment;
import d.v.f.c.d;

public class PrimeWebActivity
extends d {
    public static void d(Context context) {
        Intent intent = new Intent(context, PrimeWebActivity.class);
        context.startActivity(intent);
    }

    public static void f(Activity activity, int n10) {
        Intent intent = new Intent((Context)activity, PrimeWebActivity.class);
        activity.startActivityForResult(intent, n10);
    }

    public static void h(Fragment fragment, int n10) {
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, PrimeWebActivity.class);
        fragment.startActivityForResult(intent, n10);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        int n10 = 2131558445;
        this.setContentView(n10);
        object = this.getSupportFragmentManager();
        int n11 = 2131362208;
        object = (PrimeWebFragment)((FragmentManager)object).findFragmentById(n11);
        if (object == null) {
            object = new PrimeWebFragment();
            FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(n11, (Fragment)object);
            fragmentTransaction.commit();
        }
    }
}

