/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.Window
 */
package com.zhiyun.cama.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import com.zhiyun.common.util.Windows;
import d.v.c.o0.a;
import d.v.f.c.d;

public class AlbumActivity
extends d {
    private static final String b = "DIRECT_TO_DETAIL";

    private /* synthetic */ void d(int n10) {
        if ((n10 &= 4) == 0) {
            Window window = this.getWindow();
            Windows.p(window);
        }
    }

    public static void h(Context context) {
        Intent intent = new Intent(context, AlbumActivity.class);
        context.startActivity(intent);
    }

    public static void i(Context context) {
        Intent intent = new Intent(context, AlbumActivity.class);
        intent.putExtra(b, true);
        context.startActivity(intent);
    }

    public /* synthetic */ void f(int n10) {
        this.d(n10);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.setContentView(2131558448);
        object = this.getWindow().getDecorView();
        Object object2 = new a(this);
        object.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)object2);
        object = this.getIntent();
        object2 = b;
        int n10 = 0;
        int n11 = object.getBooleanExtra((String)object2, false);
        if (n11 != 0) {
            n11 = 2131362933;
            object = Navigation.findNavController(this, n11);
            object2 = ((NavController)object).getGraph();
            n10 = 2131362007;
            ((NavGraph)object2).setStartDestination(n10);
            ((NavController)object).setGraph((NavGraph)object2);
        }
    }

    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        Windows.p(this.getWindow());
    }
}

