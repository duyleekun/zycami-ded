/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.zhiyun.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.zhiyun.common.util.Windows;
import com.zhiyun.live.CropPhotoActivity$a;
import com.zhiyun.live.R$layout;
import d.v.f.c.d;
import d.v.n.l.c;
import d.v.n.l.c$a;
import d.v.n.l.c$b;

public class CropPhotoActivity
extends d {
    public static final int b = 10023;
    public static final String c = "action_crop_photo_uri";
    public static final String d = "action_go_mode";
    private static final int e = 1;
    private static final int f = 2;

    private c$a d() {
        int n10 = Windows.l((Context)this).getWidth();
        c$a c$a = new c$a(1, 1, n10, n10, 4);
        return c$a;
    }

    public static void f(Fragment fragment) {
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, CropPhotoActivity.class);
        intent.putExtra(d, 2);
        fragment.startActivityForResult(intent, 10023);
    }

    public static void h(Fragment fragment) {
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, CropPhotoActivity.class);
        intent.putExtra(d, 1);
        fragment.startActivityForResult(intent, 10023);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        boolean bl2 = d.v.n.l.c.e(n10);
        if (bl2) {
            c c10 = d.v.n.l.c.c();
            c10.f(this, n10, n11, intent);
        }
    }

    public void onCreate(Bundle object) {
        Object object2;
        super.onCreate((Bundle)object);
        int n10 = R$layout.activity_crop_photo;
        this.setContentView(n10);
        object = this.getIntent();
        if (object != null) {
            int n11;
            object = this.getIntent();
            n10 = object.getIntExtra((String)(object2 = d), n11 = 1);
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12) {
                    object = d.v.n.l.c.c();
                    object2 = this.d();
                    ((c)object).i(this, (c$a)object2);
                }
            } else {
                object = d.v.n.l.c.c();
                object2 = this.d();
                ((c)object).k(this, (c$a)object2);
            }
        }
        object = d.v.n.l.c.c();
        object2 = new CropPhotoActivity$a(this);
        ((c)object).g((c$b)object2);
    }

    public void onDestroy() {
        d.v.n.l.c.c().g(null);
        super.onDestroy();
    }
}

