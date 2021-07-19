/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.a0;

import android.app.Application;
import android.content.Context;
import com.zhiyun.remotetransmitter.Constant$RemoteMode;
import d.v.a0.f1;
import d.v.a0.g1;
import d.v.a0.h1;
import d.v.a0.i1;
import d.v.a0.j1$a;
import d.v.a0.k1;
import d.v.e.l.b2;
import d.v.z.j;
import d.v.z.l.e;

public class j1 {
    public f1 a;
    public Constant$RemoteMode b;
    public Context c;

    public boolean a() {
        boolean bl2;
        f1 f12 = this.a;
        if (f12 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            f12 = null;
        }
        return bl2;
    }

    public void b(Application object, Constant$RemoteMode object2) {
        Object object3 = Constant$RemoteMode.SERVER;
        if (object2 != object3 && object2 != (object3 = Constant$RemoteMode.CLIENT)) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("error mode,");
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object = object.getApplicationContext();
        this.c = object;
        this.b = object2;
        j.a().l(null);
    }

    public boolean c() {
        boolean bl2 = b2.o();
        Context context = this.c;
        boolean bl3 = b2.k(context);
        Context context2 = this.c;
        boolean bl4 = b2.j(context2);
        if (bl2) {
            return bl3 ^ true;
        }
        return bl4 ^ true;
    }

    public e d() {
        return k1.e(this.c);
    }

    public void e(h1 h12) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.p(h12, null);
    }

    public void f(h1 h12) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.l(h12, null);
    }

    public boolean g() {
        return k1.h(this.c);
    }

    public void h() {
        Object object = j1$a.a;
        Constant$RemoteMode constant$RemoteMode = this.b;
        int n10 = constant$RemoteMode.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                object = new g1;
                constant$RemoteMode = this.c;
                object((Context)constant$RemoteMode);
                this.a = object;
            }
        } else {
            object = new i1;
            constant$RemoteMode = this.c;
            object((Context)constant$RemoteMode);
            this.a = object;
        }
    }

    public void i() {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.clear();
        f1 f12 = this.a;
        if (f12 != null) {
            bl2 = false;
            f12 = null;
            this.a = null;
        }
    }
}

