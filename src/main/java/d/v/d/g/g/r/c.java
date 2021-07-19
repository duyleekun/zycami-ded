/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.util.Size
 */
package d.v.d.g.g.r;

import android.content.Context;
import android.os.Handler;
import android.util.Size;
import com.huawei.camera.camerakit.ActionDataCallback;
import com.huawei.camera.camerakit.ActionStateCallback;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeConfig$Builder;
import d.v.d.e;
import d.v.d.g.g.l;
import d.v.d.g.g.m;
import d.v.d.g.g.r.c$a;
import d.v.d.g.g.r.c$b;
import d.v.d.g.g.r.d;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.e.g;
import d.v.d.i.f.u;

public class c
extends l {
    private final d k;
    private final ActionDataCallback l;
    private final ActionStateCallback m;

    public c(Context context, e e10) {
        Object object = new c$a(this);
        this.l = object;
        this.m = object = new c$b(this);
        d.v.d.h.f.a("init huawei Photo  start");
        this.k = object = new d(this, e10, context);
        this.q(context, (m)object);
    }

    public static /* synthetic */ d.v.d.i.c.c A(c c10) {
        return c10.j();
    }

    public static /* synthetic */ Mode B(c c10) {
        return c10.a;
    }

    public static /* synthetic */ Mode C(c c10) {
        return c10.a;
    }

    public static /* synthetic */ void D(c c10, ActionStateCallback$FaceDetectionResult actionStateCallback$FaceDetectionResult) {
        c10.t(actionStateCallback$FaceDetectionResult);
    }

    public static /* synthetic */ boolean E(c c10) {
        return c10.M();
    }

    public static /* synthetic */ d F(c c10) {
        return c10.k;
    }

    public static /* synthetic */ d.v.d.i.c.c G(c c10) {
        return c10.j();
    }

    public static /* synthetic */ u H(c c10) {
        return c10.n();
    }

    public static /* synthetic */ d.v.d.i.b.d I(c c10) {
        return c10.p();
    }

    public static /* synthetic */ d.v.d.i.c.c J(c c10) {
        return c10.j();
    }

    public static /* synthetic */ u K(c c10) {
        return c10.n();
    }

    public static /* synthetic */ d.v.d.i.b.d L(c c10) {
        return c10.p();
    }

    private boolean M() {
        a a10 = this.k.F0();
        boolean bl2 = ((d.v.d.i.e.c)a10).n();
        if (bl2 && (bl2 = ((d.v.d.i.f.l)(a10 = this.k.s())).s())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    public static /* synthetic */ u w(c c10) {
        return c10.n();
    }

    public static /* synthetic */ u x(c c10) {
        return c10.n();
    }

    public static /* synthetic */ d.v.d.i.c.c y(c c10) {
        return c10.j();
    }

    public static /* synthetic */ u z(c c10) {
        return c10.n();
    }

    public void N() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("take photo ");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        if (object != null) {
            object = this.k.H0();
            object2 = 1;
            ((g)object).r((Integer)object2);
            object = this.a;
            object2 = this.k;
            int n10 = ((m)object2).k();
            ((Mode)object).setImageRotation(n10);
            object = this.a;
            ((Mode)object).takePicture();
        }
    }

    public void g(ModeConfig$Builder modeConfig$Builder) {
        modeConfig$Builder = this.d;
        Object object = (Size)this.k.G0().get();
        modeConfig$Builder.addCaptureImage((Size)object, 256);
        modeConfig$Builder = this.d;
        object = this.l;
        Handler handler = this.i();
        modeConfig$Builder.setDataCallback((ActionDataCallback)object, handler);
        modeConfig$Builder = this.d;
        object = this.m;
        handler = this.i();
        modeConfig$Builder.setStateCallback((ActionStateCallback)object, handler);
    }

    public int k() {
        return 1;
    }
}

