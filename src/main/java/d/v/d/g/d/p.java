/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.g.d;

import android.content.Context;
import d.v.d.g.a;
import d.v.d.g.d.q;
import d.v.d.g.d.r.g;
import d.v.d.g.d.t.e;
import d.v.d.g.d.u.d;
import d.v.d.g.d.v.h;
import d.v.d.h.f;
import d.v.d.i.a.c;

public class p
implements a {
    private q a;
    private final d.v.d.e b;

    public p(Context context, d.v.d.e e10) {
        this.b = e10;
        int n10 = (Integer)e10.X0().get();
        this.e(n10, context);
    }

    private void e(int n10, Context object) {
        Object object2;
        Object object3 = new StringBuilder();
        String string2 = "open Camera2 mode =";
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(n10);
        object3 = ((StringBuilder)object3).toString();
        f.a((String)object3);
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
                                    object3 = this.b;
                                    this.a = object2 = new g((Context)object, (d.v.d.e)object3);
                                    break;
                                }
                                case 18: {
                                    object3 = this.b;
                                    this.a = object2 = new d.v.d.g.d.y.g((Context)object, (d.v.d.e)object3);
                                    break;
                                }
                                case 17: {
                                    object3 = this.b;
                                    this.a = object2 = new d.v.d.g.d.s.g((Context)object, (d.v.d.e)object3);
                                    break;
                                }
                                case 16: 
                                case 20: {
                                    object3 = this.b;
                                    this.a = object2 = new d.v.d.g.d.z.g((Context)object, (d.v.d.e)object3);
                                    break;
                                }
                            }
                        } else {
                            object3 = this.b;
                            this.a = object2 = new d.v.d.g.d.w.g((Context)object, (d.v.d.e)object3);
                        }
                    } else {
                        object3 = this.b;
                        this.a = object2 = new e((Context)object, (d.v.d.e)object3);
                    }
                } else {
                    object3 = this.b;
                    this.a = object2 = new h((Context)object, (d.v.d.e)object3);
                }
            } else {
                object3 = this.b;
                object2 = new d.v.d.g.d.a0.g((Context)object, (d.v.d.e)object3);
                this.a = object2;
            }
        } else {
            object3 = this.b;
            object2 = new d((Context)object, (d.v.d.e)object3);
            this.a = object2;
        }
        object2 = this.b.Z0();
        object = n12;
        ((d.v.d.i.b.e)object2).n((Integer)object);
    }

    public void a() {
        q q10 = this.a;
        if (q10 != null) {
            q10.a();
        }
    }

    public void b() {
        q q10 = this.a;
        if (q10 != null) {
            q10.b();
            q10 = null;
            this.a = null;
        }
    }

    public void c() {
        q q10 = this.a;
        if (q10 != null) {
            q10.c();
        }
    }

    public c d(int n10) {
        return (c)this.b.a1().get(n10);
    }
}

