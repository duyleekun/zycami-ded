/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.n;

import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.c.v0.n.d;

public final class a
implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ CameraParam b;

    public /* synthetic */ a(d d10, CameraParam cameraParam) {
        this.a = d10;
        this.b = cameraParam;
    }

    public final void run() {
        d d10 = this.a;
        CameraParam cameraParam = this.b;
        d10.Q(cameraParam);
    }
}

