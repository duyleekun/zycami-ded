/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.a.i.a.y0;

import android.content.Context;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.GT3Listener;
import d.v.a.i.a.y0.d$a;
import d.v.a.i.a.y0.d$b;

public class d {
    private GT3GeetestUtils a;
    private GT3ConfigBean b;
    private d$b c;

    public d(Context context) {
        this.d(context);
    }

    public static /* synthetic */ GT3GeetestUtils a(d d10) {
        return d10.a;
    }

    public static /* synthetic */ d$b b(d d10) {
        return d10.c;
    }

    public static /* synthetic */ GT3ConfigBean c(d d10) {
        return d10.b;
    }

    private void d(Context object) {
        Object object2 = new GT3GeetestUtils((Context)object);
        this.a = object2;
        object = new GT3ConfigBean();
        this.b = object;
        ((GT3ConfigBean)object).setPattern(1);
        this.b.setLang(null);
        object = this.b;
        object2 = new d$a(this);
        ((GT3ConfigBean)object).setListener((GT3Listener)object2);
        object = this.a;
        object2 = this.b;
        ((GT3GeetestUtils)object).init((GT3ConfigBean)object2);
    }

    public void e() {
        this.a.changeDialogLayout();
    }

    public void f() {
        this.c = null;
        this.a = null;
        this.b = null;
    }

    public void g(d$b d$b) {
        this.c = d$b;
        this.a.startCustomFlow();
    }
}

