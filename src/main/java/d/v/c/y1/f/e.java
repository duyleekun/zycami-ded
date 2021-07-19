/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.lifecycle.Observer;
import d.v.c.y1.f.p;

public final class e
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ e(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (Boolean)object;
        p10.G((Boolean)object);
    }
}

