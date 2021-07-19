/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.util.Size
 */
package d.v.d.g.g.q;

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
import d.v.d.g.g.q.c$a;
import d.v.d.g.g.q.c$b;
import d.v.d.g.g.q.d;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.e.g;
import d.v.d.i.f.o;
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
        d.v.d.h.f.a("init huawei night  start");
        this.k = object = new d(this, e10, context);
        this.q(context, (m)object);
    }

    public static /* synthetic */ void A(c c10, ActionStateCallback$FaceDetectionResult actionStateCallback$FaceDetectionResult) {
        c10.t(actionStateCallback$FaceDetectionResult);
    }

    public static /* synthetic */ d B(c c10) {
        return c10.k;
    }

    public static /* synthetic */ d.v.d.i.c.c C(c c10) {
        return c10.j();
    }

    public static /* synthetic */ u D(c c10) {
        return c10.n();
    }

    public static /* synthetic */ d.v.d.i.b.d E(c c10) {
        return c10.p();
    }

    public static /* synthetic */ d.v.d.i.c.c F(c c10) {
        return c10.j();
    }

    public static /* synthetic */ u G(c c10) {
        return c10.n();
    }

    public static /* synthetic */ d.v.d.i.b.d H(c c10) {
        return c10.p();
    }

    public static /* synthetic */ d.v.d.i.c.c I(c c10) {
        return c10.j();
    }

    private boolean J() {
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

    public static /* synthetic */ boolean w(c c10) {
        return c10.J();
    }

    public static /* synthetic */ o x(c c10) {
        return c10.m();
    }

    public static /* synthetic */ u y(c c10) {
        return c10.n();
    }

    public static /* synthetic */ d.v.d.i.c.c z(c c10) {
        return c10.j();
    }

    public void K() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("take photo ");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        if (object == null) {
            return;
        }
        object = this.k.H0();
        object2 = 1;
        ((g)object).r((Integer)object2);
        object = this.a;
        int n10 = this.k.k();
        ((Mode)object).setImageRotation(n10);
        this.a.takePicture();
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
        return 6;
    }
}

