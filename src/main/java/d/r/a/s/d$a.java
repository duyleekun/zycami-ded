/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.s;

import android.content.Context;
import d.r.a.d;
import d.r.a.k.a;
import d.r.a.l;
import d.r.a.u.c;
import d.r.a.u.s;
import d.r.a.u.u;

public final class d$a
implements Runnable {
    private Context a;
    private String b;

    public static /* synthetic */ void a(d$a d$a, Context context, String string2) {
        d$a.a = context = c.c(context).getApplicationContext();
        d$a.b = string2;
    }

    public final void run() {
        boolean bl2;
        Object object = u.a(this.a);
        if (object != null) {
            bl2 = object.isConnectedOrConnecting();
        } else {
            bl2 = false;
            object = null;
        }
        String string2 = ")";
        String string3 = ",";
        CharSequence charSequence = "PushServiceReceiver";
        if (!bl2) {
            object = new StringBuilder();
            String string4 = this.a.getPackageName();
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(": \u65e0\u7f51\u7edc  by ");
            string4 = this.b;
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            s.m((String)charSequence, (String)object);
            object = this.a;
            charSequence = new StringBuilder("\u89e6\u53d1\u9759\u6001\u5e7f\u64ad:\u65e0\u7f51\u7edc(");
            string4 = this.b;
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string3);
            string3 = this.a.getPackageName();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            s.e((Context)object, string2);
            return;
        }
        object = new StringBuilder();
        String string5 = this.a.getPackageName();
        ((StringBuilder)object).append(string5);
        ((StringBuilder)object).append(": \u6267\u884c\u5f00\u59cb\u51fa\u53d1\u52a8\u4f5c: ");
        string5 = this.b;
        ((StringBuilder)object).append(string5);
        object = ((StringBuilder)object).toString();
        s.m((String)charSequence, (String)object);
        object = this.a;
        charSequence = new StringBuilder("\u89e6\u53d1\u9759\u6001\u5e7f\u64ad(");
        string5 = this.b;
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append(string3);
        string3 = this.a.getPackageName();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        s.e((Context)object, string2);
        object = l.b();
        string2 = this.a;
        ((l)object).d((Context)string2);
        object = d.r.a.k.a.d(this.a);
        bl2 = ((a)object).i();
        if (!bl2) {
            object = d.f(this.a);
            ((d)object).j();
        }
    }
}

