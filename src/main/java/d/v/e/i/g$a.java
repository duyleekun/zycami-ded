/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.arch.core.util.Function;
import androidx.lifecycle.Observer;
import d.v.e.i.i;

public class g$a
implements Observer {
    public final /* synthetic */ i a;
    public final /* synthetic */ Function b;

    public g$a(i i10, Function function) {
        this.a = i10;
        this.b = function;
    }

    public void onChanged(Object object) {
        i i10 = this.a;
        object = this.b.apply(object);
        i10.setValue(object);
    }
}

