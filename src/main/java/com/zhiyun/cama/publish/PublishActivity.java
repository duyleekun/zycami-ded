/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.webkit.URLUtil
 */
package com.zhiyun.cama.publish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import d.v.c.n1.j2;
import d.v.c.u0.l;
import d.v.e.l.v1;
import d.v.f.c.d;
import d.v.f.i.g;
import d.v.i0.b;
import java.io.Serializable;

public class PublishActivity
extends d {
    public static final String d = "video_path";
    public static final String e = "upload_resolution";
    public static final int f = 1;
    private Intent b;
    private j2 c;

    private void f() {
        j2 j22;
        this.c = j22 = (j2)d.v.i0.b.c(this).get(j2.class);
        j22 = this.getIntent();
        this.b = j22;
        Object object = "publish_from_type";
        int n10 = 0;
        String string2 = null;
        int n11 = 1;
        int n12 = j22.getIntExtra((String)object, 0);
        if (n11 == n12) {
            object = this.c;
            n10 = 2131952800;
            string2 = g.m((Context)this, n10);
            ((j2)object).t0(string2);
        }
        object = ComposeParams$Resolution.RESOLUTION_ORIGINAL;
        n10 = 7;
        if (n12 == n10) {
            object = this.b;
            string2 = e;
            object = (ComposeParams$Resolution)((Object)object.getSerializableExtra(string2));
        }
        this.c.s0((ComposeParams$Resolution)((Object)object));
        this.c.q0(n12);
        j22 = this.c;
        object = this.b.getStringExtra(d);
        j22.u0((String)object);
        j22 = this.c;
        object = this.b.getLongExtra("draft_id", (long)-1);
        j22.n0((Long)object);
    }

    private void h() {
        j2 j22 = this.c;
        int n10 = j22.V();
        n10 = n10 != 0 ? 2131362202 : 2131363014;
        Object object = this.getSupportFragmentManager();
        int n11 = 2131362934;
        if ((object = (NavHostFragment)((FragmentManager)object).findFragmentById(n11)) != null) {
            object = ((NavHostFragment)object).getNavController();
            Object object2 = ((NavController)object).getNavInflater();
            int n12 = 2131755020;
            object2 = ((NavInflater)object2).inflate(n12);
            ((NavGraph)object2).setStartDestination(n10);
            n10 = 0;
            j22 = null;
            ((NavController)object).setGraph((NavGraph)object2, null);
        }
    }

    public static void i(Activity activity) {
        Intent intent = new Intent((Context)activity, PublishActivity.class);
        intent.putExtra("publish_from_type", 0);
        activity.startActivity(intent);
    }

    public static void j(Fragment fragment, long l10) {
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, PublishActivity.class);
        intent.putExtra("publish_from_type", 0);
        intent.putExtra("draft_id", l10);
        fragment.startActivity(intent);
    }

    public static void k(Fragment fragment, String string2) {
        Context context = fragment.requireContext();
        Class<PublishActivity> clazz = PublishActivity.class;
        Intent intent = new Intent(context, clazz);
        int n10 = URLUtil.isHttpsUrl((String)string2);
        int n11 = 1;
        if (n10 == 0 && (n10 = URLUtil.isHttpUrl((String)string2)) == 0) {
            n10 = 0;
            context = null;
        } else {
            n10 = n11;
        }
        n10 = n10 != 0 ? 5 : 4;
        intent.putExtra("publish_from_type", n10);
        intent.putExtra(d, string2);
        fragment.startActivityForResult(intent, n11);
    }

    public static void l(Fragment fragment, String string2) {
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, PublishActivity.class);
        int n10 = 1;
        intent.putExtra("publish_from_type", n10);
        intent.putExtra(d, string2);
        fragment.startActivityForResult(intent, n10);
    }

    public static void m(Fragment fragment, String string2, ComposeParams$Resolution composeParams$Resolution) {
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, PublishActivity.class);
        intent.putExtra("publish_from_type", 7);
        intent.putExtra(d, string2);
        intent.putExtra(e, (Serializable)((Object)composeParams$Resolution));
        fragment.startActivityForResult(intent, 1);
    }

    public Intent d() {
        return this.b;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        v1.j(this, motionEvent, false);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.getWindow();
        int n10 = 1024;
        object.setFlags(n10, n10);
        this.setContentView(2131558746);
        this.f();
        this.h();
        object = this.c;
        boolean n11 = ((j2)object).V();
        if (!n11) {
            int n12 = -1;
            this.setRequestedOrientation(n12);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Object object = this.c;
        boolean bl2 = ((j2)object).V();
        if (bl2) {
            object = d.v.i0.b.c(this);
            Class<l> clazz = l.class;
            object = (l)((ViewModelProvider)object).get(clazz);
            ((l)object).j();
            ((l)object).k();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b = intent;
    }
}

