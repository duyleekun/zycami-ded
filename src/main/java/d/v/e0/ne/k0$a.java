/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import d.v.e0.ne.k0;
import d.v.e0.ne.m0;

public class k0$a
extends Thread {
    public final /* synthetic */ k0 a;

    public k0$a(k0 k02) {
        this.a = k02;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable2;
        block7: {
            try {
                try {
                    boolean bl2;
                    Object object = this.a;
                    int n10 = 1;
                    k0.e((k0)object, n10 != 0);
                    while (!(bl2 = k0.f((k0)(object = this.a)))) {
                        object = this.a;
                        bl2 = ((m0)(object = k0.g((k0)object))).b();
                        if (!bl2) {
                            object = this.a;
                            object = k0.g((k0)object);
                            k0 k02 = this.a;
                            n10 = k0.h(k02);
                            if ((n10 = ((Object)(object = (Object)((m0)object).a(n10))).length) <= 0) continue;
                            k02 = this.a;
                            k0.i(k02, (byte[])object);
                            continue;
                        }
                        break;
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            catch (Throwable throwable2) {
                break block7;
            }
            k0.e(this.a, false);
            return;
        }
        k0.e(this.a, false);
        throw throwable2;
    }
}

