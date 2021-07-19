/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 */
package com.geetest.sdk;

import android.app.Application;
import android.content.Context;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.a$d;
import com.geetest.sdk.as;
import com.geetest.sdk.at;
import com.geetest.sdk.ax;
import com.geetest.sdk.bb;
import com.geetest.sdk.bc;
import com.geetest.sdk.d;
import com.geetest.sdk.g;
import com.geetest.sdk.g$f;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.c;
import com.geetest.sdk.q;
import com.geetest.sdk.s;
import com.geetest.sdk.t;
import com.geetest.sdk.u;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.w;
import com.geetest.sdk.x;
import java.util.Map;

public class b {
    private static final String m = "b";
    private Context a;
    private GT3ConfigBean b;
    private bc c;
    private g d;
    private as e;
    private String f;
    private at g;
    private String h;
    private a$d i;
    private String j;
    private boolean k = false;
    private int l = 1;

    public b(Context context) {
        this.a = context;
        Object object = new as();
        this.e = object;
        object = (Application)context.getApplicationContext();
        as as2 = this.e;
        object.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)as2);
        this.g = object = new at(context);
        ((at)object).b();
    }

    public void a() {
        Object object = this.c;
        if (object != null && (object = ((bb)object).e()) != null) {
            object = this.c.e();
            ((g)object).a();
        }
    }

    public void a(int n10) {
        this.l = n10;
    }

    public void a(GT3ConfigBean gT3ConfigBean) {
        this.b = gT3ConfigBean;
    }

    public void a(String string2) {
        this.j = string2;
    }

    public void a(boolean bl2) {
        this.k = bl2;
    }

    public void b() {
        Object object = this.e;
        if (object != null && (object = this.a) != null) {
            object = (Application)object.getApplicationContext();
            as as2 = this.e;
            object.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)as2);
            object = this.e;
            ((as)object).a();
            this.e = null;
        }
        if ((object = this.g) != null) {
            ((at)object).c();
            this.g = null;
        }
        ax.b();
        object = this.c;
        if (object != null && (object = ((bb)object).e()) != null) {
            object = this.c.e();
            ((g)object).j();
        }
    }

    public void c() {
        Object object = this.c;
        if (object != null && (object = ((bb)object).e()) != null) {
            object = this.c.e();
            ((g)object).c();
        }
    }

    public String d() {
        return this.j;
    }

    public GT3ConfigBean e() {
        return this.b;
    }

    public Context f() {
        return this.a;
    }

    public int g() {
        return this.l;
    }

    public boolean h() {
        return this.k;
    }

    public void i() {
        Object object = this.c;
        if (object != null && (object = ((bb)object).e()) != null) {
            com.geetest.sdk.utils.l.b(m, "api2\u63a5\u53e3\u9519\u8bef\uff0c\u9519\u8bef\u7801\u4e3a\uff1a209-->API2 Result Error !");
            object = new a();
            ((a)object).c("API2 Result Error !  { 1. \u5ba2\u6237\u7aef\u548c\u670d\u52a1\u7aef\u6570\u636e\u4e0d\u901a\uff0c\u68c0\u67e5\u6570\u636e\u8bf7\u6c42get\u3001post\u662f\u5426\u5bf9\u5e94\uff0c\u68c0\u67e5\u6570\u636e\u683c\u5f0fjson\u3001form\u8868\u5355; 2.\u670d\u52a1\u7aefSDK\u4e8c\u6b21\u6821\u9a8c\u5931\u8d25\uff0c\u68c0\u67e5\u4f20\u5165challenge\u3001validate\u6570\u636e\u662f\u5426\u6b63\u5e38\uff0c\u6392\u67e5md5\u5904\u7406\u540e\u5931\u8d25\u539f\u56e0 }");
            ((a)object).b("209");
            long l10 = System.currentTimeMillis();
            bc bc2 = this.c;
            long l11 = bc2.j();
            ((a)object).a(l10 -= l11);
            Object object2 = this.c.d().c();
            ((a)object).a((String)object2);
            object2 = this.c.e();
            object = ((a)object).clone();
            ((g)object2).a((GT3ErrorBean)object);
        }
    }

    public void j() {
        g g10;
        Context context = this.a;
        GT3ConfigBean gT3ConfigBean = this.b;
        this.d = g10 = new g(context, gT3ConfigBean);
        int n10 = this.g();
        g10.a(n10);
        this.d.k();
    }

    public void k() {
        Object object = this.c;
        if (object != null && (object = ((bb)object).e()) != null) {
            object = this.c.e();
            ((g)object).m();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l() {
        int n10;
        int n11;
        g$f g$f;
        Object object = this.d;
        if (object != null && (object = ((g)object).h()) == (g$f = g$f.SHOW_WEB) && (n11 = ((g)(object = this.d)).e()) != 0 && (n11 = this.g()) != (n10 = 3)) {
            n11 = 1;
            com.geetest.sdk.utils.d.a = n11;
            try {
                object = this.d;
                object = ((g)object).g();
                ((d)((Object)object)).show();
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return;
        }
        n11 = 0;
        com.geetest.sdk.utils.d.a = false;
        com.geetest.sdk.utils.l.b(m, "startCustomFlow");
        object = this.e;
        n10 = 0;
        g$f = null;
        if (object != null) {
            object = (Application)this.a.getApplicationContext();
            as as2 = this.e;
            object.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)as2);
            this.f = object = this.e.b();
            object = this.e;
            ((as)object).a();
            this.e = null;
        }
        if ((object = this.g) != null) {
            this.h = object = ((at)object).a();
            object = this.g;
            ((at)object).c();
            this.g = null;
        }
        if ((n11 = this.g()) != (n10 = 2)) {
            this.j();
            object = this.b.getListener();
            object.onButtonClick();
            return;
        }
        object = this.i;
        if (object != null) {
            object.d();
            object = this.i;
            object.i();
        }
        if ((n11 = (int)(this.h() ? 1 : 0)) != 0) {
            object = this.b.getListener();
            object.onButtonClick();
            return;
        }
        object = new IllegalArgumentException("Mode configuration error !");
        throw object;
    }

    public void m() {
        Object object;
        Object object2 = this.e;
        int n10 = 0;
        Object object3 = null;
        if (object2 != null) {
            object2 = (Application)this.a.getApplicationContext();
            object = this.e;
            object2.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
            this.f = object2 = this.e.b();
            object2 = this.e;
            ((as)object2).a();
            this.e = null;
        }
        if ((object2 = this.g) != null) {
            this.h = object2 = ((at)object2).a();
            object2 = this.g;
            ((at)object2).c();
            this.g = null;
        }
        object2 = m;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("sensorData-->");
        object = this.h;
        ((StringBuilder)object3).append((String)object);
        object3 = ((StringBuilder)object3).toString();
        com.geetest.sdk.utils.l.d((String)object2, (String)object3);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("motionString-->");
        object = this.f;
        ((StringBuilder)object3).append((String)object);
        object3 = ((StringBuilder)object3).toString();
        com.geetest.sdk.utils.l.d((String)object2, (String)object3);
        this.c = object2 = new bc(0);
        object = this.i;
        ((bb)object2).setButtonListener((a$d)object);
        object2 = this.c;
        object = this.f();
        ((bb)object2).a((Context)object);
        object2 = this.c;
        object = this.e();
        ((bb)object2).a((GT3ConfigBean)object);
        object2 = this.c;
        int n11 = this.g();
        ((bb)object2).a(n11);
        object2 = this.c;
        object = new c();
        ((bb)object2).a((c)object);
        object2 = new com.geetest.sdk.model.beans.b();
        object = this.f;
        ((com.geetest.sdk.model.beans.b)object2).i((String)object);
        object = this.h;
        ((com.geetest.sdk.model.beans.b)object2).k((String)object);
        object = this.e().getUserInfo();
        ((com.geetest.sdk.model.beans.b)object2).b((Map)object);
        object = this.e().getGTViewWithParams();
        ((com.geetest.sdk.model.beans.b)object2).a((Map)object);
        ((com.geetest.sdk.model.beans.b)object2).a(false);
        object3 = this.e().getLang();
        ((com.geetest.sdk.model.beans.b)object2).h((String)object3);
        n10 = this.e().getTimeout();
        ((com.geetest.sdk.model.beans.b)object2).d(n10);
        n10 = this.e().getWebviewTimeout();
        ((com.geetest.sdk.model.beans.b)object2).e(n10);
        n10 = this.e().getCorners();
        ((com.geetest.sdk.model.beans.b)object2).a(n10);
        object3 = this.d();
        ((com.geetest.sdk.model.beans.b)object2).b((String)object3);
        this.c.a((com.geetest.sdk.model.beans.b)object2);
        object2 = new q();
        object3 = new w();
        object = new s();
        Object object4 = new x();
        t t10 = new t();
        ((u)object2).a((u)object3);
        ((u)object3).a((u)object);
        ((u)object).a((u)object4);
        ((u)object4).a(t10);
        n10 = this.g();
        n11 = 1;
        if (n10 == n11) {
            object3 = this.d;
            if (object3 == null) {
                object = this.a;
                object4 = this.b;
                this.d = object3 = new g((Context)object, (GT3ConfigBean)object4);
            }
        } else {
            object = this.a;
            object4 = this.b;
            this.d = object3 = new g((Context)object, (GT3ConfigBean)object4);
        }
        object3 = this.d;
        n11 = this.g();
        ((g)object3).a(n11);
        object3 = this.d;
        object = this.i;
        ((g)object3).setButtonListener((a$d)object);
        object3 = this.d;
        n11 = (int)(this.h() ? 1 : 0);
        ((g)object3).a(n11 != 0);
        object3 = this.c;
        object = this.d;
        ((bb)object3).a((g)object);
        object3 = this.c;
        ((u)object2).c((bb)object3);
    }

    public void setButtonListener(a$d a$d) {
        this.i = a$d;
    }
}

