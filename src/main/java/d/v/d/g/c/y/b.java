/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 */
package d.v.d.g.c.y;

import android.hardware.Camera;
import d.v.d.g.c.y.h;
import java.util.List;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ List a;

    public /* synthetic */ b(List list) {
        this.a = list;
    }

    public final void accept(Object object) {
        List list = this.a;
        object = (Camera.Size)object;
        h.U0(list, (Camera.Size)object);
    }
}

