/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.android;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.android.CameraYun;
import d.v.d.h.f;

public class CameraYun$2
implements DefaultLifecycleObserver {
    public final /* synthetic */ CameraYun a;

    public CameraYun$2(CameraYun cameraYun) {
        this.a = cameraYun;
    }

    public void onCreate(LifecycleOwner object) {
        f.a("CameraLifeCycleObserver onCreate");
        object = d.v.b.c0.f.b();
        Context context = CameraYun.h(this.a);
        ((d.v.b.c0.f)object).f(context);
    }

    public void onDestroy(LifecycleOwner object) {
        f.a("CameraLifeCycleObserver onDestroy");
        CameraYun.j(this.a);
        object = object.getLifecycle();
        DefaultLifecycleObserver defaultLifecycleObserver = CameraYun.k(this.a);
        ((Lifecycle)object).removeObserver(defaultLifecycleObserver);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        f.a("CameraLifeCycleObserver onPause");
        CameraYun.i(this.a, false);
        this.a.a();
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        f.a("CameraLifeCycleObserver onResume");
        CameraYun.i(this.a, true);
        this.a.c();
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        f.a("CameraLifeCycleObserver onStop");
    }
}

