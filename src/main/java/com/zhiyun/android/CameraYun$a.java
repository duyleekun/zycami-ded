/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.android;

import com.zhiyun.android.CameraYun;
import com.zhiyun.renderengine.business.display.DisplayRender$u;
import d.v.d.h.f;
import d.v.d.i.b.b;
import d.v.d.i.g.k$a;

public class CameraYun$a
implements DisplayRender$u {
    public final /* synthetic */ CameraYun a;

    public CameraYun$a(CameraYun cameraYun) {
        this.a = cameraYun;
    }

    public void a() {
        f.a("filter stop record");
        d.v.d.i.g.f f10 = this.a.getRecordControl();
        Integer n10 = 3;
        f10.n(n10);
    }

    public boolean b() {
        return CameraYun.g(this.a);
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        f.a("filter start record");
        Object object = this.a.getRecordControl();
        int n10 = 1;
        Integer n11 = n10;
        ((d.v.d.i.g.f)object).n(n11);
        object = this.a;
        n11 = null;
        CameraYun.e((CameraYun)object, false);
        object = this.a.getCameraMode();
        boolean n12 = ((b)object).r();
        if (n12) {
            CameraYun.e(this.a, n10 != 0);
            object = (k$a)this.a.getRecordSize().get();
            int n13 = ((k$a)object).c();
            n10 = 30;
            double d10 = 1.0E9;
            if (n13 == n10) {
                object = this.a;
                Double d13 = (Double)((CameraYun)object).getRecordCapture().get();
                double d14 = d13;
                long l11 = (long)(d10 /= d14);
                CameraYun.f((CameraYun)object, l11);
            } else {
                object = this.a;
                Double d11 = (Double)((CameraYun)object).getRecordCapture().get();
                double d12 = d11;
                d10 /= d12;
                d12 = 300000.0;
                long l10 = (long)(d10 += d12);
                CameraYun.f((CameraYun)object, l10);
            }
        }
    }
}

