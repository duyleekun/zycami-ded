/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.Observer;
import d.v.e.i.e;
import d.v.e.i.f$a;

public class f
implements Observer {
    private final f$a a;

    public f(f$a f$a) {
        this.a = f$a;
    }

    public void a(e object) {
        f$a f$a;
        if (object != null && (f$a = this.a) != null && (object = ((e)object).b()) != null) {
            f$a = this.a;
            f$a.a(object);
        }
    }
}

