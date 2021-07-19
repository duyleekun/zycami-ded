/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c.z;

import androidx.lifecycle.Observer;
import d.v.a.j.c.z.j;

public final class d
implements Observer {
    public final /* synthetic */ j a;

    public /* synthetic */ d(j j10) {
        this.a = j10;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        object = (String)object;
        j10.z((String)object);
    }
}

