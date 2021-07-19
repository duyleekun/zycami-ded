/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.camera;

import android.content.Context;
import com.zhiyun.cama.camera.CameraFragment;
import d.v.c.s0.s6;
import d.v.c.s0.t6;
import d.v.c.s0.u;
import d.v.c.s0.u6;
import d.v.c.s0.v;
import d.v.c.s0.w;
import d.v.d.i.a.a;
import d.v.d.i.a.c$a;
import d.v.d.i.g.c;
import d.v.f.i.g;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class CameraFragment$f
implements c$a {
    private e.a.s0.b a;
    public final /* synthetic */ CameraFragment b;

    public CameraFragment$f(CameraFragment cameraFragment) {
        this.b = cameraFragment;
    }

    public static /* synthetic */ void b(CameraFragment$f cameraFragment$f) {
        cameraFragment$f.e();
    }

    public static /* synthetic */ void c(CameraFragment$f cameraFragment$f) {
        cameraFragment$f.g();
    }

    public static /* synthetic */ Long d(Long l10) {
        return l10 * (long)100;
    }

    private void e() {
        CameraFragment.q(this.b);
    }

    private void f() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = e.a.c1.b.d();
        Object object = z.m3(0L, 100, timeUnit, h02);
        Object object2 = w.a;
        object = ((z)object).H3((o)object2);
        object2 = e.a.q0.c.a.c();
        this.a = object = ((z)object).i4((h0)object2).a();
    }

    private void g() {
        Object object = this.b;
        CameraFragment.p((CameraFragment)object);
        long l10 = c.p();
        long l11 = 50;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 < 0) {
            object = CameraFragment.H(this.b);
            Object object2 = this.b.requireContext();
            int n10 = 2131951801;
            object2 = g.m(object2, n10);
            ((u6)object).o2((String)object2);
        }
    }

    private void h() {
        e.a.s0.b b10 = this.a;
        if (b10 != null) {
            b10.dispose();
        }
    }

    public void i(Integer object, int n10) {
        int n11;
        Object object2 = CameraFragment.w(this.b).getRecordStatus();
        n10 = (int)(((a)object2).i() ? 1 : 0);
        int n12 = (Integer)object;
        if (n12 != (n11 = 2)) {
            n11 = 5;
            if (n12 != n11) {
                n10 = 6;
                if (n12 == n10) {
                    this.h();
                    object = this.b.requireActivity();
                    object2 = new v(this);
                    object.runOnUiThread((Runnable)object2);
                }
            } else if (n10 != 0) {
                this.h();
                object = this.b.requireActivity();
                object2 = new v(this);
                object.runOnUiThread((Runnable)object2);
                object = CameraFragment.P(this.b);
                n10 = 1;
                String string2 = CameraFragment.n(this.b);
                ((s6)object).f0(n10 != 0, string2);
            } else {
                object = this.b.getContext();
                object2 = CameraFragment.n(this.b);
                t6.b((Context)object, (String)object2);
            }
        } else {
            object = this.b;
            String string3 = CameraFragment.w((CameraFragment)object).getRecordPath().p();
            CameraFragment.o((CameraFragment)object, string3);
            if (n10 != 0) {
                this.f();
                object = this.b.requireActivity();
                object2 = new u(this);
                object.runOnUiThread((Runnable)object2);
            }
        }
    }
}

