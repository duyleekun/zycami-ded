/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.b;
import d.v.c.s0.c;
import d.v.c.s0.d;
import d.v.c.s0.d7.z;
import d.v.c.s0.i7.k;
import d.v.c.s0.s6;
import d.v.c.s0.v6;
import d.v.e.h.a;
import d.v.e.l.c1;
import d.v.e.l.v1;
import java.util.concurrent.Executor;

public class CameraActivity
extends d.v.f.c.d {
    private k b;
    private z c;
    private v6 d;
    private DynamicZoomViewModel e;
    private s6 f;

    private /* synthetic */ void d(View view) {
        this.f.a.postValue(view);
    }

    private /* synthetic */ void h(View view, int n10, ViewGroup object) {
        Executor executor = c1.b().a();
        object = new c(this, view);
        executor.execute((Runnable)object);
    }

    private /* synthetic */ void j(View view, int n10) {
        if ((n10 &= 4) == 0) {
            n10 = 5638;
            view.setSystemUiVisibility(n10);
        }
        this.f.v();
    }

    public static void l(Activity activity) {
        Intent intent = new Intent((Context)activity, CameraActivity.class);
        activity.startActivity(intent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (!n10) {
            int n11;
            Object object = (Boolean)this.d.d.getValue();
            n10 = (int)(a.c((Boolean)object) ? 1 : 0);
            if (n10) {
                object = this.d.d;
                Boolean bl2 = Boolean.FALSE;
                ((MutableLiveData)object).setValue(bl2);
            }
            object = this.c;
            n10 = ((z)object).k;
            if (n10 && n10 != (n11 = 2)) {
                n10 = 0;
                object = null;
            } else {
                n10 = 1;
            }
            v1.j(this, motionEvent, n10 != 0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        super.e();
        k k10 = this.b;
        if (k10 != null) {
            k10.a();
        }
    }

    public /* synthetic */ void f(View view) {
        this.d(view);
    }

    public /* synthetic */ void i(View view, int n10, ViewGroup viewGroup) {
        this.h(view, n10, viewGroup);
    }

    public /* synthetic */ void k(View view, int n10) {
        this.j(view, n10);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        int n12 = 379;
        if (n10 == n12 && n11 == 0) {
            MutableLiveData mutableLiveData = this.c.L();
            Comparable<Boolean> comparable = Boolean.FALSE;
            mutableLiveData.setValue(comparable);
            mutableLiveData = this.c.A();
            n11 = 375;
            comparable = n11;
            mutableLiveData.setValue(comparable);
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = d.v.i0.b.c(this);
        Object object2 = (s6)((ViewModelProvider)object).get(s6.class);
        this.f = object2;
        this.b = object2 = new k((Context)this);
        d d10 = new d(this);
        ((k)object2).c(2131558465, null, d10);
        this.setContentView(2131558456);
        this.c = object2 = (z)((ViewModelProvider)object).get(z.class);
        this.d = object2 = (v6)((ViewModelProvider)object).get(v6.class);
        this.e = object = (DynamicZoomViewModel)((ViewModelProvider)object).get(DynamicZoomViewModel.class);
        ((DynamicZoomViewModel)object).N(true);
        Windows.p(this.getWindow());
        object = this.getWindow().getDecorView();
        object2 = new b(this, (View)object);
        object.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)object2);
    }

    public void onDestroy() {
        super.onDestroy();
        l.a.c.r().H();
    }

    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        Windows.p(this.getWindow());
    }
}

