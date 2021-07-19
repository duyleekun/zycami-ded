/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 */
package d.v.d.g.c.d0;

import android.hardware.Camera;
import d.v.d.g.c.d0.i;
import java.util.List;
import java.util.function.Consumer;

public final class f
implements Consumer {
    public final /* synthetic */ List a;

    public /* synthetic */ f(List list) {
        this.a = list;
    }

    public final void accept(Object object) {
        List list = this.a;
        object = (Camera.Size)object;
        i.d1(list, (Camera.Size)object);
    }
}

