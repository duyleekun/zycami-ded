/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.Observer;
import d.v.e.i.g$d;

public class g$d$a
implements Observer {
    public final /* synthetic */ g$d a;

    public g$d$a(g$d g$d) {
        this.a = g$d;
    }

    public void onChanged(Object object) {
        this.a.c.setValue(object);
    }
}

