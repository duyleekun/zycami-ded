/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.os.Handler
 *  android.view.Surface
 */
package d.v.d.g.g;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.Surface;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.CameraKit;
import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeConfig$Builder;
import com.huawei.camera.camerakit.ModeStateCallback;
import d.v.d.g.g.m;
import d.v.d.g.g.o;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.b.d;
import d.v.d.i.c.c;
import d.v.d.i.f.h;
import d.v.d.i.f.h$a;
import d.v.d.i.f.u;
import d.v.d.i.f.w;
import java.util.ArrayList;
import java.util.List;

public abstract class l
implements o {
    public Mode a;
    public CameraKit b;
    public String c = "0";
    public ModeConfig$Builder d;
    public m e;
    public final ModeStateCallback f;
    private final RectF g;
    private Matrix h;
    private boolean i;
    private final List j;

    public l() {
        ArrayList arrayList = new ArrayList(this);
        this.f = arrayList;
        this.g = arrayList;
        this.j = arrayList = new ArrayList();
    }

    public static /* synthetic */ void d(l l10) {
        l10.u();
    }

    private void e() {
        this.e.a.a();
    }

    private void r() {
    }

    private void u() {
        this.e.a.d1();
    }

    public void a() {
        this.e.c();
    }

    public void b() {
        this.a();
        this.e.j0();
    }

    public void c() {
        this.e.Z();
    }

    public void f() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("close device getDeviceStatus=");
        Object object2 = this.j();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        this.e();
        object = this.j();
        boolean bl2 = ((c)object).o();
        if (!bl2 && !(bl2 = ((c)(object = this.j())).n())) {
            object = this.a;
            if (object == null) {
                d.v.d.h.f.a("current is mMode==null,return");
                this.u();
                return;
            }
            object = this.j();
            object2 = 0;
            ((c)object).s((Integer)object2);
            object = this.n();
            bl2 = ((u)object).o();
            if (bl2 || (bl2 = ((u)(object = this.n())).p())) {
                this.a.stopPreview();
                object = this.a;
                ((Mode)object).release();
            }
            return;
        }
        d.v.d.h.f.a("current is close device or close device ing,return");
        this.u();
    }

    public abstract void g(ModeConfig$Builder var1);

    public void h() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("config  mode mMode=");
        Mode mode = this.a;
        ((StringBuilder)object).append(mode);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        if (object == null) {
            d.v.d.h.f.a("current is mMode==null ,return");
            return;
        }
        this.d = object = ((Mode)object).getModeConfigBuilder();
        mode = this.e.y();
        ((ModeConfig$Builder)object).addPreviewSurface((Surface)mode);
        object = this.d;
        mode = this.e.e();
        ((ModeConfig$Builder)object).addPreviewSurface((Surface)mode);
        object = this.d;
        this.g((ModeConfig$Builder)object);
        this.a.configure();
    }

    public Handler i() {
        return this.e.f();
    }

    public c j() {
        return this.e.i();
    }

    public abstract int k();

    public d.v.d.i.f.l l() {
        return this.e.s();
    }

    public d.v.d.i.f.o m() {
        return this.e.u();
    }

    public u n() {
        return this.e.x();
    }

    public w o() {
        return this.e.z();
    }

    public d p() {
        return this.e.D();
    }

    public void q(Context object, m m10) {
        d.v.d.h.f.a("init huawei base  start");
        this.e = m10;
        object = CameraKit.getInstance(object.getApplicationContext());
        this.b = object;
        this.r();
    }

    public void s() {
        d.v.d.h.f.a("open Device");
        Object object = this.j();
        boolean bl2 = ((c)object).q();
        if (bl2) {
            d.v.d.h.f.a("current is open device ,return");
            this.u();
            return;
        }
        object = this.o().get();
        if (object == null) {
            d.v.d.h.f.a("current is phone view =null ,return");
            this.u();
            return;
        }
        object = this.j();
        Object object2 = 2;
        ((c)object).s((Integer)object2);
        this.c = object = String.valueOf(this.l().get());
        object = new StringBuilder();
        ((StringBuilder)object).append("select camera Id mCameraId=");
        object2 = this.c;
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        object2 = this.c;
        int n10 = this.k();
        ModeStateCallback modeStateCallback = this.f;
        Handler handler = this.i();
        ((CameraKit)object).createMode((String)object2, n10, modeStateCallback, handler);
    }

    public void t(ActionStateCallback$FaceDetectionResult object) {
        int n10;
        Object object2 = this.e.p();
        boolean n102 = ((a)object2).j();
        if (!n102) {
            this.h = null;
            return;
        }
        if ((object = ((ActionStateCallback$FaceDetectionResult)object).getFaces()) != null && (n10 = ((Object)object).length) > 0) {
            this.j.clear();
            this.v();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("onFaceDetection size=");
            int n11 = ((Object)object).length;
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            for (Object object3 : object) {
                int n12;
                int n13 = object3.getScore();
                if (n13 <= (n12 = 50)) continue;
                Rect rect = object3.getBounds();
                this.g.set(rect);
                Object object4 = this.h;
                Object object5 = this.g;
                object4.mapRect(object5);
                this.g.round(rect);
                object4 = this.j;
                int n14 = object3.getId();
                object5 = new h$a(n14, rect);
                object4.add(object5);
            }
            object = this.e.p();
            object2 = this.j;
            ((h)object).n((List)object2);
        }
    }

    public void v() {
        float f10;
        Matrix matrix;
        int n10 = this.i;
        d.v.d.i.f.l l10 = this.l();
        int n11 = l10.s();
        if (n10 == n11 && (matrix = this.h) != null) {
            return;
        }
        this.i = n11;
        this.h = matrix = new Matrix();
        int n12 = 1065353216;
        float f11 = 1.0f;
        float f12 = n11 != 0 ? -1.0f : f11;
        matrix.setScale(f11, f12);
        if (n11 != 0) {
            n11 = 180;
            f10 = 2.52E-43f;
        } else {
            n11 = 0;
            f10 = 0.0f;
            l10 = null;
        }
        matrix = this.h;
        f10 = n11;
        matrix.postRotate(f10);
        l10 = this.h;
        float f13 = this.o().o();
        f11 = 2000.0f;
        f12 = (float)this.o().n() / f11;
        l10.postScale(f13 /= f11, f12);
        l10 = this.h;
        f13 = this.o().o();
        f11 = 2.0f;
        f12 = (float)this.o().n() / f11;
        l10.postTranslate(f13 /= f11, f12);
    }
}

