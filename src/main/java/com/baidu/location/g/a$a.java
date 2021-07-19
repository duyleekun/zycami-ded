/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.baidu.location.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.b.b;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.f;
import com.baidu.location.g.a;
import com.baidu.location.indoor.g;
import java.lang.ref.WeakReference;

public class a$a
extends Handler {
    private final WeakReference a;

    public a$a(Looper object, a a10) {
        super(object);
        super(a10);
        this.a = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message message) {
        int n10;
        int n11;
        a a10;
        block15: {
            block16: {
                block17: {
                    block18: {
                        block19: {
                            block20: {
                                block21: {
                                    block22: {
                                        block23: {
                                            a10 = (a)this.a.get();
                                            if (a10 == null) {
                                                return;
                                            }
                                            n11 = f.isServing;
                                            n10 = 1;
                                            if (n11 != n10) break block15;
                                            n11 = message.what;
                                            int n12 = 11;
                                            if (n11 == n12) break block16;
                                            n12 = 12;
                                            if (n11 == n12) break block17;
                                            n12 = 15;
                                            if (n11 == n12) break block18;
                                            n12 = 22;
                                            if (n11 == n12) break block19;
                                            n12 = 28;
                                            if (n11 == n12) break block20;
                                            n12 = 41;
                                            if (n11 == n12) break block21;
                                            n12 = 114;
                                            if (n11 == n12) break block22;
                                            n12 = 401;
                                            if (n11 == n12) break block23;
                                            n12 = 406;
                                            if (n11 != n12) {
                                                n12 = 705;
                                                if (n11 != n12) {
                                                    switch (n11) {
                                                        default: {
                                                            break;
                                                        }
                                                        case 112: {
                                                            g g10 = g.a();
                                                            g10.b();
                                                            break;
                                                        }
                                                        case 111: {
                                                            g g11 = g.a();
                                                            g11.d();
                                                            break;
                                                        }
                                                        case 110: {
                                                            g g12 = g.a();
                                                            g12.c();
                                                            break;
                                                        }
                                                    }
                                                    break block15;
                                                } else {
                                                    Bundle bundle = message.getData();
                                                    n11 = (int)(bundle.getBoolean("foreground") ? 1 : 0);
                                                    b b10 = b.a();
                                                    b10.a(n11 != 0);
                                                }
                                                break block15;
                                            } else {
                                                k k10 = k.a();
                                                k10.e();
                                            }
                                            break block15;
                                        }
                                        try {
                                            message.getData();
                                            break block15;
                                        }
                                        catch (Exception exception) {}
                                    }
                                    Object object = message.obj;
                                    if (object != null) {
                                        g g13 = g.a();
                                        object = (Bundle)object;
                                        g13.a((Bundle)object);
                                    }
                                    break block15;
                                }
                                o o10 = o.c();
                                o10.j();
                                break block15;
                            }
                            o o11 = o.c();
                            o11.a(n10 != 0, n10 != 0);
                            break block15;
                        }
                        o o12 = o.c();
                        o12.b(message);
                        break block15;
                    }
                    com.baidu.location.g.a.c(a10, message);
                    break block15;
                }
                com.baidu.location.g.a.b(a10, message);
                break block15;
            }
            com.baidu.location.g.a.a(a10, message);
        }
        if ((n11 = message.what) == n10) {
            com.baidu.location.g.a.b(a10);
        }
        if (!(n11 = message.what)) {
            com.baidu.location.g.a.c(a10);
        }
        super.handleMessage(message);
    }
}

