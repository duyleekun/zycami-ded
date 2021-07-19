/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.MotionEvent
 */
package com.zhiyun.cama.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.account.me.country.CountryChooseActivity;
import com.zhiyun.cama.main.MainFragment;
import com.zhiyun.cama.prime.web.PrimeWebActivity;
import com.zhiyun.cama.splash.SplashActivity$a;
import com.zhiyun.common.util.RomUtils;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;
import d.v.a.f.c.d.d;
import d.v.a.i.b.e;
import d.v.c.i1.r2;
import d.v.c.i1.t2.i0;
import d.v.c.i1.t2.p0.h;
import d.v.c.n1.j2;
import d.v.c.t1.a;
import d.v.c.t1.s;
import d.v.e.i.j;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.e.l.v1;
import d.v.f.i.g;
import d.v.i0.b;

public class SplashActivity
extends d.v.f.c.d {
    private static final String d = "ACTION_TO_ME";
    public static final String e = "page_id";
    public static final String f = "type";
    public static final String g = "2";
    public static final String h = "prime";
    private s b;
    private r2 c;

    public static /* synthetic */ r2 d(SplashActivity splashActivity) {
        return splashActivity.c;
    }

    private void f() {
        Object object = new ViewModelProvider(this);
        this.c = object = (r2)((ViewModelProvider)object).get(r2.class);
        object = ((r2)object).j;
        d.v.c.t1.b b10 = new d.v.c.t1.b(this);
        ((LiveData)object).observe(this, b10);
    }

    private boolean h() {
        String string2;
        String string3;
        boolean bl2;
        Object object = this.getIntent();
        boolean bl3 = false;
        if (object != null && (bl2 = TextUtils.equals((CharSequence)(string3 = object.getAction()), (CharSequence)(string2 = "android.intent.action.VIEW")))) {
            boolean bl4;
            int n10;
            String string4;
            if ((object = object.getData()) == null) {
                return false;
            }
            string3 = object.getQueryParameter(e);
            string2 = object.getQueryParameter(f);
            String string5 = object.getScheme();
            int n11 = TextUtils.equals((CharSequence)string5, (CharSequence)(string4 = o1.L((Context)this, n10 = 2131951832)));
            if (n11 != 0 && (bl4 = TextUtils.equals((CharSequence)(object = object.getHost()), (CharSequence)(string5 = o1.L((Context)this, n11 = 2131951829)))) && (bl4 = TextUtils.equals((CharSequence)string3, (CharSequence)(object = g))) && (bl4 = TextUtils.equals((CharSequence)string2, (CharSequence)(object = h)))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    private /* synthetic */ void i(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.c.j.removeObservers(this);
            object = d.v.a.f.c.d.d.F();
            SplashActivity$a splashActivity$a = new SplashActivity$a(this);
            ((d)object).h0(splashActivity$a);
        }
    }

    private /* synthetic */ void k(DeviceViewModel$NetWorkEvent object) {
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent = DeviceViewModel$NetWorkEvent.NET_WORK_MOBILE_CONNECTED;
        if (object != deviceViewModel$NetWorkEvent && object != (deviceViewModel$NetWorkEvent = DeviceViewModel$NetWorkEvent.NET_WORK_WIFI_CONNECTED)) {
            int n10 = 2131952685;
            object = d.v.f.i.g.m((Context)this, n10);
            n2.e((String)object);
        } else {
            object = d.v.c.t0.i0.e();
            ((d.v.c.t0.i0)object).i();
        }
    }

    public static void m(Activity activity) {
        Intent intent = new Intent((Context)activity, SplashActivity.class);
        intent.setFlags(0x24000000);
        activity.startActivity(intent);
    }

    public static void n(Activity activity) {
        Intent intent = new Intent((Context)activity, SplashActivity.class);
        intent.setFlags(0x24000000);
        intent.putExtra(d, true);
        activity.startActivity(intent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        v1.j(this, motionEvent, false);
        return super.dispatchTouchEvent(motionEvent);
    }

    public /* synthetic */ void j(Boolean bl2) {
        this.i(bl2);
    }

    public /* synthetic */ void l(DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent) {
        this.k(deviceViewModel$NetWorkEvent);
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        d.v.a.f.c.b b10;
        super.onActivityResult(n10, n11, (Intent)object);
        boolean bl2 = d.v.c.i1.t2.p0.h.c(n10);
        if (bl2) {
            h h10 = d.v.c.i1.t2.p0.h.b();
            h10.d(this, n10, n11, (Intent)object);
        } else {
            Object object2 = CountryChooseActivity.p(n10, n11, (Intent)object);
            if (object2 != null) {
                object = d.v.i0.b.c(this);
                Class<i0> clazz = i0.class;
                object = (i0)((ViewModelProvider)object).get(clazz);
                object2 = ((e)object2).c();
                ((i0)object).I((String)object2);
            }
        }
        n11 = 50001;
        if (n11 == n10 && (n10 = (int)((b10 = d.v.a.f.c.b.N()).s() ? 1 : 0)) != 0) {
            PrimeWebActivity.d((Context)this);
        }
    }

    public void onCreate(Bundle object) {
        boolean bl2;
        Object object2;
        Object object3;
        super.onCreate((Bundle)object);
        boolean bl3 = this.isTaskRoot();
        if (!bl3) {
            object = this.getIntent();
            object3 = this.getIntent().getAction();
            object2 = "android.intent.category.LAUNCHER";
            bl3 = object.hasCategory((String)object2);
            if (bl3 && object3 != null && (bl3 = ((String)object3).equals(object = "android.intent.action.MAIN"))) {
                this.finish();
                return;
            }
        }
        this.setContentView(2131558777);
        object = d.v.a.f.c.b.N();
        bl3 = ((d.v.a.f.c.b)object).D();
        if (bl3 && (bl3 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).H())) {
            d.v.a.f.c.b.N().C();
            object = d.v.a.f.c.b.N();
            bl2 = false;
            object3 = null;
            ((d.v.a.f.c.b)object).e(false);
        }
        object = d.v.i0.b.c(this);
        object3 = d.v.i0.b.c(this);
        object2 = j2.class;
        object3 = (j2)((ViewModelProvider)object3).get((Class)object2);
        ((j2)object3).k();
        ((j2)object3).j();
        object = ((DeviceViewModel)object.get(DeviceViewModel.class)).c;
        object3 = new a(this);
        ((j)object).observe(this, (Observer)object3);
        bl3 = RomUtils.m();
        if (bl3) {
            d.v.c.o1.b.a(this);
        }
        this.b = object = (s)d.v.i0.b.c(this).get(s.class);
        bl2 = this.h();
        ((s)object).m(bl2);
        this.f();
    }

    public void onNewIntent(Intent object) {
        String string2;
        boolean bl2;
        super.onNewIntent((Intent)object);
        if (object != null && (bl2 = object.getBooleanExtra(string2 = d, false))) {
            object = this.getSupportFragmentManager();
            int n10 = 2131362934;
            if ((object = ((FragmentManager)object).findFragmentById(n10)) == null) {
                return;
            }
            n10 = (int)((object = ((Fragment)object).getChildFragmentManager().getFragments()).isEmpty() ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            n10 = (object = (Fragment)object.get(0)) instanceof MainFragment;
            if (n10 == 0) {
                return;
            }
            object = (MainFragment)object;
            ((MainFragment)object).p();
        }
    }
}

