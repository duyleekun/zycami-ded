/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.android.CameraView;
import d.v.c.s0.v6;
import d.v.e.h.a;
import d.v.h0.g;

public class v6$c
implements g {
    public final /* synthetic */ CameraView a;
    public final /* synthetic */ v6 b;

    public v6$c(v6 v62, CameraView cameraView) {
        this.b = v62;
        this.a = cameraView;
    }

    public void b(String object, Throwable object2, int n10) {
        object = (Boolean)this.b.b.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (bl2) {
            object = this.b;
            object2 = this.a;
            ((v6)object).k0((CameraView)object2);
        }
    }
}

