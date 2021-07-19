/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.g.c;

import android.content.Context;
import d.v.d.e;
import d.v.d.g.a;
import d.v.d.g.c.d0.h;
import d.v.d.g.c.u;
import d.v.d.g.c.v.i;
import d.v.d.g.c.y.g;
import d.v.d.g.c.z.f;
import d.v.d.i.a.c;

public class t
implements a {
    private u a;
    private final e b;

    public t(Context context, e e10) {
        this.b = e10;
        int n10 = (Integer)e10.X0().get();
        this.e(n10, context);
    }

    private void e(int n10, Context object) {
        Object object2;
        object = new StringBuilder();
        String string2 = "open Camera1 mode =";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = 1;
        int n12 = 2;
        if (n10 != n11) {
            if (n10 != n12) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 8;
                    if (n10 != n11) {
                        n11 = 9;
                        if (n10 != n11) {
                            switch (n10) {
                                default: {
                                    break;
                                }
                                case 19: {
                                    object = this.b;
                                    this.a = object2 = new i((e)object);
                                    break;
                                }
                                case 18: {
                                    object = this.b;
                                    this.a = object2 = new d.v.d.g.c.c0.i((e)object);
                                    break;
                                }
                                case 17: {
                                    object = this.b;
                                    this.a = object2 = new d.v.d.g.c.w.i((e)object);
                                    break;
                                }
                                case 16: 
                                case 20: {
                                    object = this.b;
                                    this.a = object2 = new h((e)object);
                                    break;
                                }
                            }
                        } else {
                            object = this.b;
                            this.a = object2 = new d.v.d.g.c.a0.h((e)object);
                        }
                    } else {
                        object = this.b;
                        this.a = object2 = new d.v.d.g.c.x.f((e)object);
                    }
                } else {
                    object = this.b;
                    this.a = object2 = new f((e)object);
                }
            } else {
                object = this.b;
                object2 = new d.v.d.g.c.e0.i((e)object);
                this.a = object2;
            }
        } else {
            object = this.b;
            object2 = new g((e)object);
            this.a = object2;
        }
        object2 = this.b.Z0();
        object = n12;
        ((d.v.d.i.b.e)object2).n((Integer)object);
    }

    public void a() {
        u u10 = this.a;
        if (u10 != null) {
            u10.a();
        }
    }

    public void b() {
        u u10 = this.a;
        if (u10 != null) {
            u10.b();
            u10 = null;
            this.a = null;
        }
    }

    public void c() {
        u u10 = this.a;
        if (u10 != null) {
            u10.c();
        }
    }

    public c d(int n10) {
        return (c)this.b.a1().get(n10);
    }
}

