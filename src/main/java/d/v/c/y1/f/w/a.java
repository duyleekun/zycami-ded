/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.w;

import androidx.lifecycle.Observer;
import d.v.c.y1.f.w.f;
import java.util.List;

public final class a
implements Observer {
    public final /* synthetic */ f a;

    public /* synthetic */ a(f f10) {
        this.a = f10;
    }

    public final void onChanged(Object object) {
        f f10 = this.a;
        object = (List)object;
        f10.G((List)object);
    }
}

