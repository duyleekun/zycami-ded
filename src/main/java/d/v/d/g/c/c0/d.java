/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 */
package d.v.d.g.c.c0;

import android.hardware.Camera;
import d.v.d.g.c.c0.j;
import java.util.List;
import java.util.function.Consumer;

public final class d
implements Consumer {
    public final /* synthetic */ List a;

    public /* synthetic */ d(List list) {
        this.a = list;
    }

    public final void accept(Object object) {
        List list = this.a;
        object = (Camera.Size)object;
        j.g1(list, (Camera.Size)object);
    }
}

