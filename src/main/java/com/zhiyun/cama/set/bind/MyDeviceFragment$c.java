/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.set.bind;

import android.view.View;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.MyDeviceFragment;
import d.v.c.x1.l;
import d.v.e0.ce;

public class MyDeviceFragment$c {
    public final /* synthetic */ MyDeviceFragment a;

    public MyDeviceFragment$c(MyDeviceFragment myDeviceFragment) {
        this.a = myDeviceFragment;
    }

    public void a() {
        Object object = MyDeviceFragment.i(this.a);
        boolean bl2 = ((DeviceBindViewModel)object).F();
        boolean bl3 = true;
        if (bl2) {
            object = MyDeviceFragment.i(this.a);
            bl2 = ((DeviceBindViewModel)object).z();
            if (bl2) {
                object = this.a;
                MyDeviceFragment.j((MyDeviceFragment)object, bl3);
            } else {
                object = this.a;
                MyDeviceFragment.k((MyDeviceFragment)object);
            }
        } else {
            object = this.a;
            MyDeviceFragment.j((MyDeviceFragment)object, bl3);
        }
    }

    public void b(View view) {
        l.g(view);
    }

    public void c() {
        MyDeviceFragment.h(this.a);
    }

    public void d() {
        ce.E0().n5();
    }

    public void e() {
        Object object;
        BindDeviceInfo bindDeviceInfo = (BindDeviceInfo)MyDeviceFragment.i((MyDeviceFragment)this.a).b.getValue();
        if (bindDeviceInfo == null || (object = bindDeviceInfo.getTheme()) == null) {
            object = MyDeviceFragment.i(this.a);
            ((DeviceBindViewModel)object).t();
        }
        MyDeviceFragment.i(this.a).U(bindDeviceInfo);
        l.d(this.a, 2131362269);
    }
}

