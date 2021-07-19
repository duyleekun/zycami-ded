/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 */
package d.v.d.g.g.t;

import android.content.Context;
import android.os.Handler;
import com.huawei.camera.camerakit.ActionStateCallback;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.ModeConfig$Builder;
import d.v.d.e;
import d.v.d.g.g.l;
import d.v.d.g.g.m;
import d.v.d.g.g.t.f$a;
import d.v.d.g.g.t.g;
import d.v.d.i.b.d;
import d.v.d.i.c.c;
import d.v.d.i.f.u;

public class f
extends l {
    private final g k;
    private final ActionStateCallback l;

    public f(Context context, e e10) {
        Object object = new f$a(this);
        this.l = object;
        this.k = object = new g(this, e10, context);
        this.q(context, (m)object);
    }

    public static /* synthetic */ g A(f f10) {
        return f10.k;
    }

    public static /* synthetic */ c B(f f10) {
        return f10.j();
    }

    public static /* synthetic */ u C(f f10) {
        return f10.n();
    }

    public static /* synthetic */ d D(f f10) {
        return f10.p();
    }

    public static /* synthetic */ c E(f f10) {
        return f10.j();
    }

    public static /* synthetic */ u F(f f10) {
        return f10.n();
    }

    public static /* synthetic */ c G(f f10) {
        return f10.j();
    }

    public static /* synthetic */ c w(f f10) {
        return f10.j();
    }

    public static /* synthetic */ u x(f f10) {
        return f10.n();
    }

    public static /* synthetic */ void y(f f10, ActionStateCallback$FaceDetectionResult actionStateCallback$FaceDetectionResult) {
        f10.t(actionStateCallback$FaceDetectionResult);
    }

    public static /* synthetic */ d z(f f10) {
        return f10.p();
    }

    public void g(ModeConfig$Builder modeConfig$Builder) {
        ActionStateCallback actionStateCallback = this.l;
        Handler handler = this.i();
        modeConfig$Builder.setStateCallback(actionStateCallback, handler);
    }

    public int k() {
        return 5;
    }
}

