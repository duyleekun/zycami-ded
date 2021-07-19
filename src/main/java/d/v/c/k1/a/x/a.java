/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a.x;

import androidx.fragment.app.Fragment;
import d.v.c.k1.a.x.g;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public final class a
implements BiConsumer {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ a(Fragment fragment, ArrayList arrayList) {
        this.a = fragment;
        this.b = arrayList;
    }

    public final void accept(Object object, Object object2) {
        Fragment fragment = this.a;
        ArrayList arrayList = this.b;
        object = (Long)object;
        object2 = (List)object2;
        g.k(fragment, arrayList, (Long)object, (List)object2);
    }
}

