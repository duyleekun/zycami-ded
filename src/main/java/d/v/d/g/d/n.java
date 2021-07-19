/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.params.Face
 *  android.os.Handler
 *  android.util.SparseIntArray
 *  android.view.Surface
 */
package d.v.d.g.d;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.Face;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.Surface;
import d.v.d.g.d.a;
import d.v.d.g.d.n$a;
import d.v.d.g.d.n$b;
import d.v.d.g.d.n$c;
import d.v.d.g.d.o;
import d.v.d.g.d.q;
import d.v.d.h.f;
import d.v.d.i.b.d;
import d.v.d.i.c.c;
import d.v.d.i.f.e;
import d.v.d.i.f.h;
import d.v.d.i.f.h$a;
import d.v.d.i.f.i;
import d.v.d.i.f.l;
import d.v.d.i.f.s;
import d.v.d.i.f.u;
import d.v.d.i.f.w;
import d.v.d.i.f.y;
import d.v.d.i.f.z;
import java.util.List;

public abstract class n
implements q {
    public CameraCharacteristics a;
    public CameraManager b;
    public CameraDevice c;
    public CameraCaptureSession d;
    private CaptureRequest.Builder e;
    private o f;
    private final CameraCaptureSession.CaptureCallback g;
    private final RectF h;
    private Matrix i;
    private boolean j;
    private final List k;

    public n() {
        Object object = new n$c(this);
        this.g = object;
        this.h = object;
        super();
        this.k = object;
    }

    private Rect H() {
        CaptureRequest.Builder builder = this.e;
        CaptureRequest.Key key = CaptureRequest.SCALER_CROP_REGION;
        if ((builder = (Rect)builder.get(key)) != null) {
            return builder;
        }
        builder = this.a;
        key = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        builder = (Rect)builder.get((CameraCharacteristics.Key)key);
        int n10 = builder.right;
        int n11 = builder.left;
        builder.right = n10 -= n11;
        builder.left = 0;
        n11 = builder.bottom;
        int n12 = builder.top;
        builder.bottom = n11 -= n12;
        builder.top = 0;
        return builder;
    }

    private /* synthetic */ void J(Surface surface) {
        this.e.addTarget(surface);
    }

    private void N() {
        this.f.a.d1();
    }

    private void Q(CaptureRequest.Builder object) {
        Object object2 = CaptureRequest.STATISTICS_FACE_DETECT_MODE;
        Number number = this.f.p();
        object.set((CaptureRequest.Key)object2, (Object)number);
        this.R((CaptureRequest.Builder)object);
        object2 = this.f;
        number = (Integer)this.u().get();
        int n10 = (Integer)number;
        ((o)object2).R0((CaptureRequest.Builder)object, n10);
        object2 = this.x();
        boolean bl2 = ((s)object2).n();
        if (bl2) {
            object2 = this.v();
            bl2 = ((l)object2).t();
            if (bl2) {
                object2 = this.f;
                number = (Float)this.D().get();
                float f10 = ((Float)number).floatValue();
                ((o)object2).U0((CaptureRequest.Builder)object, f10);
            }
            object = this.x();
            ((s)object).o();
        }
    }

    private void S() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("start real preview getDeviceStatus=");
        Object object2 = this.y().get();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.p();
        boolean bl2 = ((c)object).r();
        int n10 = 5;
        object2 = n10;
        if (!bl2) {
            d.v.d.h.f.a("current session is not succeed ,return");
            this.y().r((Integer)object2);
            return;
        }
        object = this.c;
        if (object != null && (object = this.d) != null) {
            object = "start real preview ,create builder ";
            d.v.d.h.f.a((String)object);
            object = this.c;
            int n11 = 1;
            object = object.createCaptureRequest(n11);
            this.e = object;
            Object object3 = CaptureRequest.CONTROL_CAPTURE_INTENT;
            int n12 = this.G();
            Object object4 = n12;
            object.set((CaptureRequest.Key)object3, object4);
            object = this.e;
            this.Q((CaptureRequest.Builder)object);
            object = this.A();
            object3 = new a(this);
            object.forEach(object3);
            object = "start real preview succeed";
            d.v.d.h.f.a((String)object);
            object = this.d;
            object3 = this.e;
            object3 = object3.build();
            object4 = this.g;
            Handler handler = this.o();
            object.setRepeatingRequest((CaptureRequest)object3, (CameraCaptureSession.CaptureCallback)object4, handler);
            object = this.y();
            n11 = 2;
            object3 = n11;
            try {
                ((u)object).r((Integer)object3);
            }
            catch (Exception exception) {
                object3 = new StringBuilder();
                object4 = "start preview failed e=";
                ((StringBuilder)object3).append((String)object4);
                Object object5 = exception.toString();
                ((StringBuilder)object3).append((String)object5);
                d.v.d.h.f.a(((StringBuilder)object3).toString());
                object5 = this.y();
                ((u)object5).r((Integer)object2);
            }
            return;
        }
        d.v.d.h.f.a("current mCameraSession or mCameraDevice==null ,return");
        this.y().r((Integer)object2);
    }

    public static /* synthetic */ void d(n n10) {
        n10.m();
    }

    public static /* synthetic */ void e(n n10) {
        n10.N();
    }

    public static /* synthetic */ void f(n n10) {
        n10.S();
    }

    private void g() {
        this.f.a.a();
    }

    private Rect k(Rect rect, Rect rect2) {
        int n10 = rect2.left;
        int n11 = rect.left;
        double d10 = n10 - n11;
        double d11 = rect.width() + -1;
        d10 /= d11;
        int n12 = rect2.top;
        int n13 = rect.top;
        d11 = n12 - n13;
        double d12 = rect.height() + -1;
        d11 /= d12;
        int n14 = rect2.right;
        int n15 = rect.left;
        d12 = n14 - n15;
        double d13 = rect.width() + -1;
        d12 /= d13;
        int n16 = rect2.bottom;
        int n17 = rect.top;
        d13 = n16 - n17;
        double d14 = rect.height() + -1;
        d13 /= d14;
        d14 = 2000.0;
        n10 = (int)(d10 * d14);
        n11 = 1000;
        n10 -= n11;
        n14 = (int)(d12 * d14) - n11;
        n12 = (int)(d11 * d14) - n11;
        int n18 = (int)(d13 * d14) - n11;
        n16 = -1000;
        n10 = Math.max(n10, n16);
        n13 = Math.max(n14, n16);
        n12 = Math.max(n12, n16);
        n18 = Math.max(n18, n16);
        n16 = Math.min(n10, n11);
        n10 = Math.min(n13, n11);
        n12 = Math.min(n12, n11);
        n18 = Math.min(n18, n11);
        Rect rect3 = new Rect(n16, n12, n10, n18);
        return rect3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void m() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Object object = "create session DeviceStatus()=";
            stringBuilder.append((String)object);
            object = this.p();
            object = ((d.v.d.i.a.a)object).get();
            stringBuilder.append(object);
            String string2 = stringBuilder.toString();
            d.v.d.h.f.a(string2);
            Surface surface = this.n();
            if (surface == null) {
                String string3 = "current is preview surface=null, return";
                d.v.d.h.f.a(string3);
                return;
            }
            CameraDevice cameraDevice = this.c;
            object = this.F();
            n$b n$b = new n$b(this);
            Handler handler = this.o();
            cameraDevice.createCaptureSession((List)object, (CameraCaptureSession.StateCallback)n$b, handler);
        }
        catch (Exception exception) {
            Comparable<StringBuilder> comparable = new StringBuilder();
            String string4 = "session create failed,e=";
            comparable.append(string4);
            String string5 = exception.toString();
            comparable.append(string5);
            d.v.d.h.f.a(comparable.toString());
            c c10 = this.p();
            comparable = 5;
            c10.s((Integer)comparable);
            d d10 = this.E();
            int n10 = 4;
            comparable = n10;
            d10.q((Integer)comparable);
            this.N();
        }
        d.v.d.h.f.a("create Session finish");
    }

    public abstract List A();

    public w B() {
        return this.f.K();
    }

    public y C() {
        return this.f.L();
    }

    public z D() {
        return this.f.M();
    }

    public d E() {
        return this.f.Q();
    }

    public abstract List F();

    public abstract int G();

    public void I(o o10) {
        d.v.d.h.f.a("init Camera2Base");
        this.f = o10;
    }

    public /* synthetic */ void K(Surface surface) {
        this.J(surface);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void L() {
        try {
            Object object = new StringBuilder();
            Object object2 = "openDevice getPreviewView=";
            ((StringBuilder)object).append((String)object2);
            object2 = this.B();
            object2 = ((d.v.d.i.a.a)object2).get();
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            d.v.d.h.f.a((String)object);
            object = this.B();
            object = ((d.v.d.i.a.a)object).get();
            if (object == null) {
                object = "current is preview view=null, return";
                d.v.d.h.f.a((String)object);
                return;
            }
            object = this.p();
            object2 = new StringBuilder();
            String string2 = "openDevice DeviceStatus=";
            ((StringBuilder)object2).append(string2);
            Object object3 = ((d.v.d.i.a.a)object).get();
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            boolean bl2 = ((c)object).q();
            if (bl2) {
                object = "current is open or ing , return";
                d.v.d.h.f.a((String)object);
                return;
            }
            this.g();
            object = "start device open";
            d.v.d.h.f.a((String)object);
            object = this.p();
            int n10 = 2;
            object2 = n10;
            ((c)object).s((Integer)object2);
            object = this.v();
            object = ((d.v.d.i.a.a)object).get();
            object = String.valueOf(object);
            object2 = new StringBuilder();
            String string3 = "select Camera ID mCameraId=";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            object2 = this.b;
            object2 = object2.getCameraCharacteristics((String)object);
            this.a = object2;
            o o10 = this.f;
            o10.M0((CameraCharacteristics)object2);
            object2 = new StringBuilder();
            String string4 = "open device cameraId=";
            ((StringBuilder)object2).append(string4);
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            object2 = this.b;
            n$a n$a = new n$a(this);
            Handler handler = this.o();
            object2.openCamera((String)object, (CameraDevice.StateCallback)n$a, handler);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            Comparable<StringBuilder> comparable = new StringBuilder();
            String string5 = "device open fail e=";
            comparable.append(string5);
            Object object = exception.toString();
            comparable.append((String)object);
            d.v.d.h.f.a(comparable.toString());
            object = this.p();
            comparable = 5;
            ((c)object).s((Integer)comparable);
            object = this.E();
            int n11 = 4;
            comparable = n11;
            ((d)object).q((Integer)comparable);
            this.N();
        }
    }

    public void M(CaptureResult object) {
        int n10;
        Object object2 = this.t();
        boolean n102 = ((d.v.d.i.a.a)object2).j();
        if (!n102) {
            return;
        }
        object2 = CaptureResult.STATISTICS_FACES;
        if ((object = (Face[])object.get((CaptureResult.Key)object2)) != null && (n10 = ((Object)object).length) > 0) {
            object2 = this.k;
            object2.clear();
            this.U();
            for (Object object3 : object) {
                int n11;
                int n12 = object3.getScore();
                if (n12 <= (n11 = 50)) continue;
                Rect rect = this.H();
                Object object4 = object3.getBounds();
                rect = this.k(rect, (Rect)object4);
                this.h.set(rect);
                object4 = this.i;
                Object object5 = this.h;
                object4.mapRect(object5);
                this.h.round(rect);
                object4 = this.k;
                int n13 = object3.getId();
                object5 = new h$a(n13, rect);
                object4.add(object5);
            }
            object = this.t();
            object2 = this.k;
            ((h)object).n((List)object2);
        }
    }

    public void O(CaptureRequest.Builder object, CameraCaptureSession.CaptureCallback object2, Handler object3) {
        block9: {
            String string2 = "set Once Capture";
            d.v.d.h.f.a(string2);
            if (object != null) {
                string2 = this.d;
                if (string2 == null) break block9;
                boolean bl2 = this.i();
                if (bl2) {
                    return;
                }
                string2 = "update once Capture---succeed";
                d.v.d.h.f.a(string2);
                string2 = this.d;
                object = object.build();
                string2.capture((CaptureRequest)object, (CameraCaptureSession.CaptureCallback)object2, object3);
            }
        }
        object = "current is mPreviewBuilder or mCameraSession ==null,return";
        try {
            d.v.d.h.f.a((String)object);
            return;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            object3 = "update preview error e=";
            ((StringBuilder)object2).append((String)object3);
            String string3 = exception.toString();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a(string3);
        }
    }

    public void P(CaptureRequest.Builder object, CameraCaptureSession.CaptureCallback object2, Handler object3) {
        block9: {
            String string2 = "set Repeating Capture ";
            d.v.d.h.f.a(string2);
            if (object != null) {
                block10: {
                    string2 = this.d;
                    if (string2 == null) break block9;
                    boolean bl2 = this.i();
                    if (!bl2) break block10;
                    object = "current is not session succeed,return";
                    d.v.d.h.f.a((String)object);
                    return;
                }
                string2 = "set Repeating Capture---succeed";
                d.v.d.h.f.a(string2);
                string2 = this.d;
                object = object.build();
                string2.setRepeatingRequest((CaptureRequest)object, (CameraCaptureSession.CaptureCallback)object2, object3);
            }
        }
        object = "current is mPreviewBuilder or mCameraSession==null,return";
        try {
            d.v.d.h.f.a((String)object);
            return;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            object3 = "set Repeating Capture failed e=";
            ((StringBuilder)object2).append((String)object3);
            String string3 = exception.toString();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a(string3);
        }
    }

    public void R(CaptureRequest.Builder builder) {
        o o10 = this.f;
        SparseIntArray sparseIntArray = o10.f;
        int n10 = (Integer)this.C().get();
        int n11 = sparseIntArray.get(n10, 1);
        o10.T0(builder, n11);
    }

    public void T() {
        String string2;
        block5: {
            string2 = "stop Repeating Capture ";
            d.v.d.h.f.a(string2);
            boolean bl2 = this.i();
            if (!bl2) break block5;
            string2 = "current is not session succeed,return";
            d.v.d.h.f.a(string2);
            return;
        }
        string2 = "stop Repeating Capture---succeed";
        d.v.d.h.f.a(string2);
        string2 = this.d;
        try {
            string2.stopRepeating();
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "stop Repeating Capture failed e=";
            stringBuilder.append(string3);
            String string4 = exception.toString();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            d.v.d.h.f.a(string4);
        }
    }

    public void U() {
        float f10;
        Matrix matrix;
        int n10 = this.j;
        l l10 = this.v();
        int n11 = l10.s();
        if (n10 == n11 && (matrix = this.i) != null) {
            return;
        }
        this.j = n11;
        this.i = matrix = new Matrix();
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
        matrix = this.i;
        f10 = n11;
        matrix.postRotate(f10);
        l10 = this.i;
        float f13 = this.B().o();
        f11 = 2000.0f;
        f12 = (float)this.B().n() / f11;
        l10.postScale(f13 /= f11, f12);
        l10 = this.i;
        f13 = this.B().o();
        f11 = 2.0f;
        f12 = (float)this.B().n() / f11;
        l10.postTranslate(f13 /= f11, f12);
    }

    public void a() {
        d.v.d.h.f.a("stopPreview");
        this.f.g();
    }

    public void b() {
        d.v.d.h.f.a("destroy");
        this.f.y0();
        this.a();
    }

    public void c() {
        d.v.d.h.f.a("startPreview");
        this.f.o0();
    }

    public void h(CaptureResult captureResult, CaptureRequest captureRequest) {
    }

    public boolean i() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("checkStatus getDeviceStatus=");
        Object object2 = this.p().get();
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(",getPreviewStatus=");
        object2 = this.y().get();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.p();
        boolean bl2 = ((c)object).r();
        boolean bl3 = true;
        if (!bl2) {
            d.v.d.h.f.a("current is not session succeed ,return");
            return bl3;
        }
        object = this.y();
        bl2 = ((u)object).o();
        if (!bl2) {
            d.v.d.h.f.a("current is not preview ing ,return");
            return bl3;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void j() {
        int n10;
        Object object = this.p();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("closeDevice DeviceStatus=");
        Object object3 = ((d.v.d.i.a.a)object).get();
        ((StringBuilder)object2).append(object3);
        object2 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a((String)object2);
        boolean bl2 = ((c)object).n();
        if (!bl2 && (n10 = ((c)object).o()) == 0) {
            this.g();
            d.v.d.h.f.a("set close device ing");
            object = this.p();
            object2 = 0;
            ((c)object).s((Integer)object2);
            n10 = 4;
            int n11 = 1;
            try {
                Integer n12;
                boolean bl3;
                object3 = this.d;
                Object var6_9 = null;
                if (object3 != null && (bl3 = ((u)(object3 = this.y())).o())) {
                    object3 = "stop preview ,succeed";
                    d.v.d.h.f.a((String)object3);
                    object3 = this.d;
                    object3.stopRepeating();
                    object3 = this.y();
                    n12 = n10;
                    ((u)object3).r(n12);
                    object3 = this.d;
                    object3.close();
                    this.d = null;
                }
                if ((object3 = this.c) != null) {
                    object3 = "close device ,succeed";
                    d.v.d.h.f.a((String)object3);
                    object3 = this.p();
                    n12 = n11;
                    ((c)object3).s(n12);
                    object3 = this.c;
                    object3.close();
                    this.c = null;
                }
                this.N();
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "close device failed e=";
                stringBuilder.append(string2);
                Object object4 = exception.toString();
                stringBuilder.append((String)object4);
                d.v.d.h.f.a(stringBuilder.toString());
                object4 = this.p();
                object2 = n11;
                ((c)object4).s((Integer)object2);
                object2 = this.y();
                object = n10;
                ((u)object2).r((Integer)object);
                this.N();
            }
            return;
        }
        d.v.d.h.f.a("current is close or ing ,return");
    }

    public CaptureRequest.Builder l(int n10) {
        return this.c.createCaptureRequest(n10);
    }

    public Surface n() {
        return this.f.j();
    }

    public Handler o() {
        return this.f.k();
    }

    public c p() {
        return this.f.o();
    }

    public e q() {
        return this.f.t();
    }

    public CaptureRequest.Builder r() {
        return this.e;
    }

    public CameraCaptureSession.CaptureCallback s() {
        return this.g;
    }

    public h t() {
        return this.f.x();
    }

    public i u() {
        return this.f.y();
    }

    public l v() {
        return this.f.C();
    }

    public d.v.d.i.f.o w() {
        return this.f.E();
    }

    public s x() {
        return this.f.G();
    }

    public u y() {
        return this.f.I();
    }

    public Surface z() {
        return this.f.J();
    }
}

