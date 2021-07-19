/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p0.o;

import androidx.fragment.app.FragmentActivity;
import d.v.c.p0.o.f;
import d.v.g0.t.e;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ FragmentActivity b;

    public /* synthetic */ b(String string2, FragmentActivity fragmentActivity) {
        this.a = string2;
        this.b = fragmentActivity;
    }

    public final void accept(Object object) {
        String string2 = this.a;
        FragmentActivity fragmentActivity = this.b;
        object = (e)object;
        f.c(string2, fragmentActivity, (e)object);
    }
}

