/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import d.v.c.s0.a7.d1;
import d.v.c.s0.s6;
import d.v.c.s0.u6;

public class d1$a {
    public final /* synthetic */ d1 a;

    public d1$a(d1 d12) {
        this.a = d12;
    }

    public void a() {
        d1.y(this.a).C1(0);
        d1.u(this.a).K(false);
    }

    public void b() {
        u6 u62 = d1.y(this.a);
        boolean bl2 = true;
        u62.C1((int)(bl2 ? 1 : 0));
        d1.u(this.a).K(bl2);
    }

    public void c() {
        d1.u(this.a).N(3);
        d1.y(this.a).M1(2);
    }

    public void d() {
        d1.u(this.a).N(1);
        d1.y(this.a).M1(0);
    }

    public void e() {
        d1.u(this.a).T(1);
        d1 d12 = this.a;
        KeyFunc keyFunc = KeyFunc.DEFAULT;
        d1.w(d12, keyFunc);
    }

    public void f() {
        d1.u(this.a).T(3);
        d1 d12 = this.a;
        KeyFunc keyFunc = KeyFunc.APP_CUSTOM_MENU;
        d1.w(d12, keyFunc);
    }

    public void g() {
        d1.u(this.a).T(2);
        d1 d12 = this.a;
        KeyFunc keyFunc = KeyFunc.APP_PHOTO_VIDEO;
        d1.w(d12, keyFunc);
    }

    public void h() {
        Object object = d1.u(this.a).p();
        boolean bl2 = ((Integer)object).intValue();
        boolean bl3 = 2 != 0;
        boolean bl4 = true;
        if (bl2 != bl4) {
            boolean bl5 = 3 != 0;
            if (bl2 != bl3) {
                if (bl2 == bl5) {
                    this.a.dismiss();
                    d1.u(this.a).S(bl4);
                    object = d1.x(this.a);
                    KeyFunc keyFunc = d1.v(this.a);
                    ((BleViewModel)object).m1(keyFunc);
                }
            } else {
                object = d1.u(this.a);
                ((s6)object).U((int)(bl5 ? 1 : 0));
            }
        } else {
            object = d1.u(this.a);
            ((s6)object).U((int)(bl3 ? 1 : 0));
        }
    }

    public void i() {
        d1.u(this.a).N(2);
        d1.y(this.a).M1(1);
    }

    public void j() {
        this.a.dismiss();
        d1.u(this.a).S(true);
        BleViewModel bleViewModel = d1.x(this.a);
        KeyFunc keyFunc = d1.v(this.a);
        bleViewModel.m1(keyFunc);
    }
}

