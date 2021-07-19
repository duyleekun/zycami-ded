/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.text.TextUtils
 */
package l.a;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import l.a.c;
import l.a.c$b;
import l.a.c$c;
import l.a.j.a.d;
import l.a.n.a;
import l.a.o.e;

public class c$a
extends AsyncTask {
    private final c$b a;
    private final c$c b;
    public final /* synthetic */ c c;

    public c$a(c c10, c$b c$b, c$c c11) {
        this.c = c10;
        this.a = c$b;
        this.b = c11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(String ... object) {
        int n10;
        Object object2;
        Object object3 = l.a.c.g(this.c);
        synchronized (object3) {
            boolean bl2;
            while (bl2 = l.a.c.h((c)(object2 = this.c))) {
                try {
                    object2 = this.c;
                    object2 = l.a.c.g((c)object2);
                    object2.wait();
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            object2 = this.c;
            n10 = 1;
            l.a.c.i((c)object2, n10 != 0);
        }
        try {
            int n11 = ((String[])object).length;
            if (n11 == n10) {
                object3 = this.b;
                object2 = this.c;
                object2 = l.a.c.j((c)object2);
                n10 = 0;
                String string2 = object[0];
                n11 = (int)(TextUtils.isEmpty((CharSequence)(object3 = object3.b((Context)object2, string2))) ? 1 : 0);
                if (n11 == 0) return object[0];
                object = d.h();
                object3 = this.b;
                ((d)object).w((c$c)object3);
                return "";
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        d.h().v();
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String object) {
        Object object2 = l.a.c.g(this.c);
        synchronized (object2) {
            int n10;
            Object object3;
            if (object != null) {
                object3 = e.b();
                object = ((e)object3).g((String)object);
                object3 = this.b;
                n10 = object3.getType();
                object = ((e)object).h(n10);
                ((e)object).a();
                object = this.c;
                ((a)object).e();
                object = this.a;
                if (object != null) {
                    object.onSuccess();
                }
            } else {
                object = e.b();
                object3 = "";
                object = ((e)object).g((String)object3);
                n10 = -1;
                object = ((e)object).h(n10);
                ((e)object).a();
                object = this.a;
                if (object != null) {
                    object3 = "\u76ae\u80a4\u8d44\u6e90\u83b7\u53d6\u5931\u8d25";
                    object.onFailed((String)object3);
                }
            }
            object = this.c;
            n10 = 0;
            object3 = null;
            l.a.c.i((c)object, false);
            object = this.c;
            object = l.a.c.g((c)object);
            object.notifyAll();
            return;
        }
    }

    public void onPreExecute() {
        c$b c$b = this.a;
        if (c$b != null) {
            c$b.onStart();
        }
    }
}

