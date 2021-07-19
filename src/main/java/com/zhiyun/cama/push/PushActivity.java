/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.Window
 */
package com.zhiyun.cama.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.push.PushEntity$PushType;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.c.i1.t2.n0$b;
import d.v.c.j1.b.m0$b;
import d.v.f.c.d;
import d.v.f.i.g;
import java.io.Serializable;

public class PushActivity
extends d {
    public static final String b = "extra_pushtype";
    public static final String c = "extra_url";
    public static final String d = "extra_title";
    public static final String e = "extra_time";
    public static final String f = "extra_content";

    private void d() {
        int n10;
        Object object = this.getIntent();
        if (object == null) {
            return;
        }
        object = (PushEntity$PushType)((Object)this.getIntent().getSerializableExtra(b));
        Object object2 = null;
        Object object3 = PushEntity$PushType.TEXT;
        int n11 = -1;
        String string2 = "";
        if (object3 == object) {
            n10 = 2131362895;
            object2 = this.getIntent().getStringExtra(d);
            object3 = this.getIntent().getStringExtra(e);
            Object object4 = this.getIntent();
            String string3 = f;
            object4 = object4.getStringExtra(string3);
            if (object2 == null) {
                object2 = string2;
            }
            if (object3 == null) {
                object3 = string2;
            }
            if (object4 != null) {
                string2 = object4;
            }
            object4 = new m0$b((String)object2, (String)object3, string2);
            object2 = ((m0$b)object4).a().f();
        } else {
            object3 = PushEntity$PushType.CONNECTION;
            if (object3 == object) {
                n10 = 2131363748;
                object2 = this.getIntent();
                object3 = c;
                if ((object2 = object2.getStringExtra((String)object3)) != null) {
                    string2 = object2;
                }
                object3 = null;
                object2 = new n0$b(string2, false);
                object2 = ((n0$b)object2).a().g();
            } else {
                n10 = n11;
            }
        }
        object3 = this.getSupportFragmentManager();
        int n12 = 2131362934;
        object3 = (NavHostFragment)((FragmentManager)object3).findFragmentById(n12);
        if (object3 != null && object2 != null && n11 != n10) {
            object3 = ((NavHostFragment)object3).getNavController();
            Object object5 = ((NavController)object3).getNavInflater();
            n12 = 2131755021;
            object5 = ((NavInflater)object5).inflate(n12);
            ((NavGraph)object5).setStartDestination(n10);
            ((NavController)object3).setGraph((NavGraph)object5, (Bundle)object2);
        }
    }

    public static void f(Context context, String string2, String string3, String string4) {
        Intent intent = new Intent(context, PushActivity.class);
        PushEntity$PushType pushEntity$PushType = PushEntity$PushType.TEXT;
        intent.putExtra(b, (Serializable)((Object)pushEntity$PushType));
        intent.putExtra(d, string2);
        intent.putExtra(e, string3);
        intent.putExtra(f, string4);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static void h(Context context, String string2) {
        Intent intent = new Intent(context, PushActivity.class);
        PushEntity$PushType pushEntity$PushType = PushEntity$PushType.CONNECTION;
        intent.putExtra(b, (Serializable)((Object)pushEntity$PushType));
        intent.putExtra(c, string2);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131558749);
        bundle = this.getWindow();
        int n10 = g.c((Context)this, 2131099772);
        StatusBarUtil.z((Window)bundle, n10);
        StatusBarUtil.E(this.getWindow(), true);
        this.d();
    }
}

