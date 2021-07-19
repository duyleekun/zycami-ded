/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Handler
 *  android.provider.Settings$Global
 *  android.telephony.PhoneStateListener
 *  android.telephony.TelephonyManager
 */
package com.zhiyun.common.viewmodel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.zhiyun.common.viewmodel.DeviceViewModel$a;
import com.zhiyun.common.viewmodel.DeviceViewModel$b;
import com.zhiyun.common.viewmodel.DeviceViewModel$c;
import com.zhiyun.common.viewmodel.DeviceViewModel$d;
import com.zhiyun.common.viewmodel.DeviceViewModel$e;
import com.zhiyun.common.viewmodel.DeviceViewModel$f;
import d.v.e.i.j;
import d.v.e.l.b1;
import d.v.e.m.b;
import d.v.e.m.c;
import d.v.e.m.e;
import d.v.e.m.f;
import d.v.e.m.g;
import d.v.e.m.h;
import e.a.l;
import io.reactivex.BackpressureStrategy;

public class DeviceViewModel
extends AndroidViewModel {
    public final LiveData a;
    public final LiveData b;
    public final j c;
    public final b1 d;
    public final LiveData e;
    public final LiveData f;
    public final LiveData g;

    public DeviceViewModel(Application application) {
        super(application);
        Object object = LiveDataReactiveStreams.fromPublisher(this.g((Context)application));
        this.a = object;
        object = LiveDataReactiveStreams.fromPublisher(this.c((Context)application));
        this.b = object;
        object = LiveDataReactiveStreams.fromPublisher(this.d((Context)application));
        this.e = object;
        object = LiveDataReactiveStreams.fromPublisher(this.b((Context)application));
        this.f = object;
        object = LiveDataReactiveStreams.fromPublisher(this.e((Context)application));
        this.g = object;
        super();
        this.c = object;
        this.d = object = new b1();
        DeviceViewModel$a deviceViewModel$a = new DeviceViewModel$a(this);
        ((b1)object).p((Context)application, deviceViewModel$a);
    }

    private e.a.j b(Context object) {
        f f10 = new f(this, (Context)object);
        object = BackpressureStrategy.LATEST;
        return e.a.j.D1(f10, (BackpressureStrategy)((Object)object));
    }

    private e.a.j c(Context object) {
        DeviceViewModel$c deviceViewModel$c = new DeviceViewModel$c(this, (Context)object);
        object = BackpressureStrategy.LATEST;
        return e.a.j.D1(deviceViewModel$c, (BackpressureStrategy)((Object)object));
    }

    private e.a.j d(Context object) {
        object = (TelephonyManager)object.getApplicationContext().getSystemService("phone");
        g g10 = new g(this, (TelephonyManager)object);
        object = BackpressureStrategy.MISSING;
        return e.a.j.D1(g10, (BackpressureStrategy)((Object)object));
    }

    private e.a.j e(Context object) {
        c c10 = new c(this, (Context)object);
        object = BackpressureStrategy.LATEST;
        return e.a.j.D1(c10, (BackpressureStrategy)((Object)object));
    }

    private e.a.j g(Context object) {
        DeviceViewModel$b deviceViewModel$b = new DeviceViewModel$b(this, (Context)object);
        object = BackpressureStrategy.LATEST;
        return e.a.j.D1(deviceViewModel$b, (BackpressureStrategy)((Object)object));
    }

    public static /* synthetic */ void k(ContentResolver contentResolver, ContentObserver contentObserver) {
        contentResolver.unregisterContentObserver(contentObserver);
    }

    private /* synthetic */ void l(Context context, l l10) {
        Object object = Settings.Global.getUriFor((String)"airplane_mode_on");
        Handler handler = new Handler();
        DeviceViewModel$e deviceViewModel$e = new DeviceViewModel$e(this, handler, (Uri)object, l10);
        context = context.getContentResolver();
        context.registerContentObserver(object, false, (ContentObserver)deviceViewModel$e);
        object = new h((ContentResolver)context, deviceViewModel$e);
        l10.setCancellable((e.a.v0.f)object);
    }

    public static /* synthetic */ void n(TelephonyManager telephonyManager, PhoneStateListener phoneStateListener) {
        telephonyManager.listen(phoneStateListener, 0);
    }

    private /* synthetic */ void o(TelephonyManager telephonyManager, l l10) {
        DeviceViewModel$d deviceViewModel$d = new DeviceViewModel$d(this, l10);
        telephonyManager.listen((PhoneStateListener)deviceViewModel$d, 256);
        b b10 = new b(telephonyManager, deviceViewModel$d);
        l10.setCancellable(b10);
    }

    public static /* synthetic */ void r(Context context, BroadcastReceiver broadcastReceiver) {
        context.unregisterReceiver(broadcastReceiver);
    }

    private /* synthetic */ void s(Context context, l l10) {
        DeviceViewModel$f deviceViewModel$f = new DeviceViewModel$f(this, l10);
        Object object = new IntentFilter();
        object.addAction("android.net.wifi.RSSI_CHANGED");
        context.registerReceiver((BroadcastReceiver)deviceViewModel$f, object);
        object = new e(context, deviceViewModel$f);
        l10.setCancellable((e.a.v0.f)object);
    }

    public LiveData f() {
        return this.c;
    }

    public boolean i() {
        ContentResolver contentResolver = this.getApplication().getApplicationContext().getContentResolver();
        String string2 = "airplane_mode_on";
        boolean bl2 = false;
        int n10 = Settings.Global.getInt((ContentResolver)contentResolver, (String)string2, (int)0);
        if (n10 != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean j(boolean bl2) {
        return this.d.m(bl2);
    }

    public /* synthetic */ void m(Context context, l l10) {
        this.l(context, l10);
    }

    public void onCleared() {
        this.d.q();
    }

    public /* synthetic */ void p(TelephonyManager telephonyManager, l l10) {
        this.o(telephonyManager, l10);
    }

    public /* synthetic */ void t(Context context, l l10) {
        this.s(context, l10);
    }
}

