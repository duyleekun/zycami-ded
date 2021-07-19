/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.Observer;
import d.v.e.i.g$b;

public class g$b$a
implements Observer {
    public final /* synthetic */ g$b a;

    public g$b$a(g$b g$b) {
        this.a = g$b;
    }

    public void onChanged(Object object) {
        this.a.c.setValue(object);
    }
}

