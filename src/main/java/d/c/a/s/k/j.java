/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.c.a.s.k;

import android.view.View;
import d.c.a.s.k.f;
import d.c.a.s.k.f$a;
import d.c.a.s.k.j$a;

public class j
implements f {
    private final j$a a;

    public j(j$a j$a) {
        this.a = j$a;
    }

    public boolean a(Object object, f$a f$a) {
        object = f$a.getView();
        if (object != null) {
            object = this.a;
            f$a = f$a.getView();
            object.a((View)f$a);
        }
        return false;
    }
}

