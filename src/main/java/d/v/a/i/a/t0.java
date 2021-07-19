/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.lifecycle.ViewModel;
import d.v.a.f.c.b;
import m.a.a;

public class t0
extends ViewModel {
    public void onCleared() {
        super.onCleared();
        Object object = new Object[]{};
        String string2 = "-----onCleared----";
        a.b(string2, (Object[])object);
        object = b.N();
        boolean bl2 = ((b)object).D();
        if (bl2 && (bl2 = ((b)(object = b.N())).H())) {
            b.N().C();
            object = b.N();
            ((b)object).e(false);
        }
    }
}

