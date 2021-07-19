/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  android.os.StrictMode$VmPolicy
 *  android.os.StrictMode$VmPolicy$Builder
 */
package com.zhiyun.cama;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.os.StrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.mob.MobSDK;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.zhiyun.cama.App$a;
import com.zhiyun.cama.App$b;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import com.zhiyun.cama.push.NotifyClickReceiver;
import com.zhiyun.cama.splash.SplashActivity;
import com.zhiyun.cama.statelog.ApplicationObserver;
import com.zhiyun.net.ChangeHostInterceptor;
import com.zhiyun.net.NetConfiguration;
import com.zhiyun.remotetransmitter.Constant$RemoteMode;
import com.zhiyun.renderengine.engine.faceunity.FaceUnityPlatform;
import com.zhiyun.renderengine.engine.faceunity.FaceUnityPlatform$Key;
import d.v.a0.m1;
import d.v.c.a;
import d.v.c.d;
import d.v.c.g1.i;
import d.v.c.i0;
import d.v.c.l1.b0;
import d.v.c.m0;
import d.v.c.v0.u.b0.c;
import d.v.c.x1.h;
import d.v.e.c$a;
import d.v.e.j.b;
import d.v.e.l.c1;
import d.v.e0.ce;
import d.v.q.e;
import d.v.w.y;
import io.reactivex.exceptions.UndeliverableException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.Executor;

public class App
extends Application {
    public static final String a = "zycami";
    public static final String b = "Android";

    private void a() {
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder();
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)builder.detectAll().penaltyLog().permitDiskReads().build());
        builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy((StrictMode.VmPolicy)builder.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());
    }

    private void b() {
        Handler handler = new Handler();
        d.v.c.b b10 = new d.v.c.b(this);
        handler.postAtFrontOfQueue((Runnable)b10);
    }

    private void d() {
        this.g();
        ce.E0().u1((Context)this, false);
        h.e().g(this);
        Object object = d.v.e.b.i();
        this.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
        this.m();
        object = NetConfiguration.create().setHost("https://api.zhiyun-tech.com/v1/");
        Object object2 = new ChangeHostInterceptor();
        object = ((NetConfiguration)object).setHostInterceptor((ChangeHostInterceptor)object2).setZyProduction(a).setLogEnable(false).setEnv("prd");
        object2 = "1.2.6";
        ((NetConfiguration)object).setAppVersion((String)object2).addOtherHost("service", "https://service.zhiyun-tech.com/").addOtherHost("purchase", "https://purchase-overseas.zhiyun-tech.com/v1/");
        d.v.e.c.b().d();
        object = d.v.e.c.b();
        Object object3 = d.v.c.a.a;
        ((d.v.e.c)object).a((c$a)object3);
        object = ProcessLifecycleOwner.get().getLifecycle();
        object3 = new ApplicationObserver();
        ((Lifecycle)object).addObserver((LifecycleObserver)object3);
        this.e();
        c.Z();
        m0.o(this);
        e.A((Context)this, false);
        d.v.g.b.a().c(false, (String)object2);
        i.o().j();
        object = m1.o();
        Object object4 = Constant$RemoteMode.SERVER;
        ((m1)object).b(this, (Constant$RemoteMode)((Object)object4));
        object = b0.e();
        object4 = this.c();
        ((b0)object).g(this, (y)object4);
    }

    private void e() {
        MobSDK.init((Context)this);
        KWaiManager.getInstance().init(this, "ks680887970458072564", "Nbub0ELrXlXvn5FSmf4rXg");
        d.v.c.o1.b.d(this);
        d.v.c.o1.b.c((Context)this, SplashActivity.class, 2131231773, NotifyClickReceiver.class);
        b0 b02 = b0.e();
        y y10 = this.c();
        b02.g(this, y10);
    }

    private void g() {
        i0 i02 = i0.e();
        boolean bl2 = i02.D();
        if (bl2) {
            this.f();
        } else {
            i02 = i0.e();
            App$a app$a = new App$a(this);
            i02.b(app$a);
        }
    }

    public static String getProcessName() {
        Object object;
        Object object2;
        try {
            object2 = new StringBuilder();
            object = "/proc/";
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        ((StringBuilder)object2).append((String)object);
        int n10 = Process.myPid();
        ((StringBuilder)object2).append(n10);
        object = "/cmdline";
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        Object object3 = new File((String)object2);
        object = new FileReader((File)object3);
        object2 = new BufferedReader((Reader)object);
        object3 = ((BufferedReader)object2).readLine();
        object3 = ((String)object3).trim();
        ((BufferedReader)object2).close();
        return object3;
    }

    public static /* synthetic */ void h(App app) {
        app.a();
    }

    public static /* synthetic */ void i() {
        d.v.c.v0.x.b.j().b();
    }

    private /* synthetic */ void j() {
        FaceUnityPlatform.f();
        d.v.o.g.b.c((Context)this, false);
        FaceUnityPlatform$Key faceUnityPlatform$Key = FaceUnityPlatform$Key.KEY_FACE_AI;
        Object object = d.v.e.j.b.d("model/ai_face_processor.bundle");
        FaceUnityPlatform.a(faceUnityPlatform$Key, object);
        object = FaceUnityPlatform$Key.KEY_FACE_BEAUTIFUL;
        String string2 = d.v.e.j.b.d("graphics/face_beautification.bundle");
        FaceUnityPlatform.a((FaceUnityPlatform$Key)((Object)object), string2);
        FaceUnityPlatform.j((Context)this, faceUnityPlatform$Key);
        FaceUnityPlatform.j((Context)this, (FaceUnityPlatform$Key)((Object)object));
    }

    public static /* synthetic */ void l(Throwable throwable) {
        boolean bl2 = throwable instanceof UndeliverableException;
        if (bl2) {
            throwable = throwable.getCause();
        }
        if (bl2 = throwable instanceof BleException) {
            return;
        }
        bl2 = throwable instanceof IOException;
        if (bl2) {
            return;
        }
        bl2 = throwable instanceof InterruptedException;
        if (bl2) {
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (uncaughtExceptionHandler != null && throwable != null) {
            Thread thread = Thread.currentThread();
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    }

    private void m() {
        h h10 = h.e();
        App$b app$b = new App$b(this);
        h10.c(app$b);
    }

    private void n() {
        e.a.a1.a.k0(d.a);
    }

    public y c() {
        return y.E(this);
    }

    public void f() {
        Executor executor = c1.b().d();
        d.v.c.c c10 = new d.v.c.c(this);
        executor.execute(c10);
    }

    public /* synthetic */ void k() {
        this.j();
    }

    public void onCreate() {
        super.onCreate();
        String string2 = App.getProcessName();
        String string3 = "com.zhiyun.cama";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            this.d();
        }
        this.n();
    }
}

