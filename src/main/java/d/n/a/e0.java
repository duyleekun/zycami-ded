/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a;

import android.content.Context;
import d.n.a.e0$a;
import d.n.a.e0$b;
import e.a.c0;
import e.a.c1.b;
import e.a.g0;
import e.a.h0;
import e.a.z;

public class e0
extends z {
    private final z a;

    public e0(Context object) {
        Object object2 = new e0$a(this, (Context)object);
        object = z.y1((c0)object2);
        object2 = b.i();
        object = ((z)object).L5((h0)object2);
        object2 = b.i();
        this.a = object = ((z)object).m7((h0)object2).p5();
    }

    public static e0$b h8(int n10) {
        switch (n10) {
            default: {
                return e0$b.d;
            }
            case 13: {
                return e0$b.f;
            }
            case 12: {
                return e0$b.c;
            }
            case 11: 
        }
        return e0$b.e;
    }

    public void K5(g0 g02) {
        this.a.subscribe(g02);
    }
}

