/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.Observer;
import d.v.e.i.i;

public final class b
implements Observer {
    public final /* synthetic */ i a;
    public final /* synthetic */ Observer b;

    public /* synthetic */ b(i i10, Observer observer) {
        this.a = i10;
        this.b = observer;
    }

    public final void onChanged(Object object) {
        i i10 = this.a;
        Observer observer = this.b;
        i10.e(observer, object);
    }
}

