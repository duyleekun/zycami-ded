/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.Observer;
import d.v.e.i.j;

public final class c
implements Observer {
    public final /* synthetic */ j a;
    public final /* synthetic */ Observer b;

    public /* synthetic */ c(j j10, Observer observer) {
        this.a = j10;
        this.b = observer;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        Observer observer = this.b;
        j10.c(observer, object);
    }
}

