/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package d.v.v.q;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d.v.v.q.g;

public class g$a
extends Handler {
    public final /* synthetic */ g a;

    public g$a(g g10, Looper looper) {
        this.a = g10;
        super(looper);
    }

    public void handleMessage(Message object) {
        super.handleMessage(object);
        int n10 = object.what;
        int n11 = 1;
        String string2 = "\u89c6\u9891\u5730\u5740\u4e0d\u80fd\u4e3a\u7a7a";
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 5;
                    if (n10 != n11) {
                        n11 = 6;
                        if (n10 == n11 && (n10 = (int)(g.d((g)(object = this.a)) ? 1 : 0)) == 0) {
                            g.b(this.a, string2);
                            object = this.a;
                            g.c((g)object);
                        }
                    } else {
                        g.e(this.a).quit();
                        object = this.a;
                        g.c((g)object);
                    }
                } else {
                    g.e(this.a).quit();
                    object = this.a;
                    g.g((g)object);
                }
            } else {
                g.e(this.a).quit();
                object = this.a;
                g.f((g)object);
            }
        } else {
            object = this.a;
            n10 = (int)(g.a((g)object) ? 1 : 0);
            if (n10 == 0) {
                g.b(this.a, string2);
                object = this.a;
                g.c((g)object);
            }
        }
    }
}

