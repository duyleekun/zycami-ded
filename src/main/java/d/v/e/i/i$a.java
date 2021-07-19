/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.Observer;
import d.v.e.i.i;

public class i$a
implements Observer {
    public boolean a = true;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Observer c;
    public final /* synthetic */ i d;

    public i$a(i i10, boolean bl2, Observer observer) {
        this.d = i10;
        this.b = bl2;
        this.c = observer;
    }

    public void onChanged(Object object) {
        boolean bl2 = this.a;
        if (bl2) {
            this.a = false;
            bl2 = this.b;
            if (bl2) {
                return;
            }
        }
        this.c.onChanged(object);
    }
}

