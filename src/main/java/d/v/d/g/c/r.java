/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PixelFormat
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Face
 *  android.hardware.Camera$FaceDetectionListener
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.c;

import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Size;
import android.view.Surface;
import androidx.collection.SparseArrayCompat;
import d.v.d.g.c.b;
import d.v.d.g.c.c;
import d.v.d.g.c.d;
import d.v.d.g.c.s;
import d.v.d.g.c.u;
import d.v.d.h.f;
import d.v.d.i.c.a;
import d.v.d.i.f.e;
import d.v.d.i.f.g;
import d.v.d.i.f.h;
import d.v.d.i.f.h$a;
import d.v.d.i.f.i;
import d.v.d.i.f.k;
import d.v.d.i.f.l;
import d.v.d.i.f.n;
import d.v.d.i.f.o;
import d.v.d.i.f.t;
import d.v.d.i.f.v;
import d.v.d.i.f.w;
import d.v.d.i.f.y;
import d.v.d.i.f.z;
import java.util.List;

public abstract class r
implements u {
    private static final int i = 17;
    public s a;
    public Camera b;
    public Camera.CameraInfo c;
    public int d;
    public Camera.Parameters e;
    private final RectF f;
    private final Matrix g;
    private final List h;

    public r() {
        Object object;
        this.c = object = new Camera.CameraInfo();
        this.f = object;
        super();
        this.g = object;
        super();
        this.h = object;
    }

    private /* synthetic */ void B(byte[] byArray, Camera camera) {
        this.k().o(byArray);
        camera.addCallbackBuffer(byArray);
    }

    private /* synthetic */ void D(Camera.Face[] object, Camera object2) {
        object2 = this.h;
        object2.clear();
        for (Camera.Face face : object) {
            int n10 = face.score;
            int n11 = 50;
            if (n10 <= n11) continue;
            Rect rect = face.rect;
            this.f.set(rect);
            Object object3 = this.g;
            Object object4 = this.f;
            object3.mapRect(object4);
            this.f.round(rect);
            object3 = this.h;
            int n12 = face.id;
            object4 = new h$a(n12, rect);
            object3.add(object4);
        }
        object = this.l();
        object2 = this.h;
        ((h)object).n((List)object2);
    }

    private /* synthetic */ void F(byte[] object, Camera object2) {
        d.v.d.h.f.a("start real preview finish ");
        object = this.b;
        if (object != null) {
            object.setPreviewCallback(null);
            object = this.z();
            int n10 = 3;
            Integer n11 = n10;
            ((d.v.d.i.b.d)object).q(n11);
            object = this.t();
            object2 = n10;
            ((d.v.d.i.f.u)object).r((Integer)object2);
            boolean bl2 = this.k().j();
            this.e(bl2);
            object = this.l();
            bl2 = ((d.v.d.i.a.a)object).j();
            this.f(bl2);
        }
    }

    private void I() {
        this.a.a.d1();
    }

    private void J() {
        int n10;
        this.d = n10 = ((Integer)this.p().get()).intValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select camera mCameraIde=");
        int n11 = this.d;
        stringBuilder.append(n11);
        d.v.d.h.f.a(stringBuilder.toString());
        n10 = this.d;
        Camera.CameraInfo cameraInfo = this.c;
        Camera.getCameraInfo((int)n10, (Camera.CameraInfo)cameraInfo);
    }

    private void L() {
        Object object = this.e;
        Object object2 = s.p;
        int n10 = (Integer)this.n().get();
        object2 = (String)((SparseArrayCompat)object2).get(n10);
        object.setFlashMode((String)object2);
        object = this.e;
        object2 = this.a;
        Integer n11 = (Integer)this.x().get();
        n10 = n11;
        object2 = ((s)object2).L(n10);
        object.setWhiteBalance((String)object2);
        object = this.e.getSupportedFocusModes();
        object2 = "continuous-picture";
        boolean bl2 = object.contains(object2);
        if (bl2) {
            this.e.setFocusMode((String)object2);
            object = this.e;
            object2 = null;
            object.setFocusAreas(null);
            object = this.e;
            object.setMeteringAreas(null);
        }
        this.K();
    }

    private void M() {
        Object object = "start real preview";
        d.v.d.h.f.a((String)object);
        object = this.e;
        Object object2 = this.s();
        int n10 = ((t)object2).s();
        t t10 = this.s();
        int n11 = t10.o();
        object.setPreviewSize(n10, n11);
        object = this.b;
        object2 = this.v();
        object2 = ((d.v.d.i.a.a)object2).get();
        object2 = (SurfaceTexture)object2;
        object.setPreviewTexture((SurfaceTexture)object2);
        object = this.b;
        n10 = 90;
        object.setDisplayOrientation(n10);
        this.L();
        object = this.t();
        n10 = 2;
        object2 = n10;
        ((d.v.d.i.f.u)object).r((Integer)object2);
        object = this.b;
        object2 = new d(this);
        object.setPreviewCallback((Camera.PreviewCallback)object2);
        object = this.b;
        try {
            object.startPreview();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            d.v.d.h.f.a("start real preview failed");
            object = this.t();
            object2 = 5;
            ((d.v.d.i.f.u)object).r((Integer)object2);
            object = this.z();
            n10 = 4;
            object2 = n10;
            ((d.v.d.i.b.d)object).q((Integer)object2);
            this.I();
        }
        this.I();
    }

    private void N() {
        float f10;
        this.g.reset();
        l l10 = this.p();
        int n10 = l10.s();
        Matrix matrix = this.g;
        int n11 = 1065353216;
        float f11 = 1.0f;
        if (n10 != 0) {
            n10 = -1082130432;
            f10 = -1.0f;
        } else {
            n10 = n11;
            f10 = f11;
        }
        matrix.setScale(f10, f11);
        this.g.postRotate(0.0f);
        l10 = this.g;
        float f12 = this.w().o();
        f11 = 2000.0f;
        float f13 = (float)this.w().n() / f11;
        l10.postScale(f12 /= f11, f13);
        l10 = this.g;
        f12 = this.w().o();
        f11 = 2.0f;
        f13 = (float)this.w().n() / f11;
        l10.postTranslate(f12 /= f11, f13);
    }

    private void d() {
        this.a.a.a();
    }

    public void A(s s10) {
        d.v.d.h.f.a("init Camera1Base");
        this.a = s10;
    }

    public /* synthetic */ void C(byte[] byArray, Camera camera) {
        this.B(byArray, camera);
    }

    public /* synthetic */ void E(Camera.Face[] faceArray, Camera camera) {
        this.D(faceArray, camera);
    }

    public /* synthetic */ void G(byte[] byArray, Camera camera) {
        this.F(byArray, camera);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H() {
        int n13;
        Object object3;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("openDevice getPreviewView=");
        Object object2 = this.w().get();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.w().get();
        if (object == null) {
            d.v.d.h.f.a("current is preview view=null, return");
            this.I();
            return;
        }
        this.d();
        d.v.d.h.f.a("start device open");
        object = this.i();
        object2 = 2;
        ((d.v.d.i.c.c)object).s((Integer)object2);
        this.J();
        object = new StringBuilder();
        object2 = "open device cameraId=";
        ((StringBuilder)object).append((String)object2);
        int n10 = this.d;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n11 = 4;
        n10 = 5;
        try {
            int n12 = this.d;
            object3 = Camera.open((int)n12);
            this.b = object3;
            object3 = object3.getParameters();
            this.e = object3;
            object3 = this.i();
            n13 = 3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("open device failed e=");
            stringBuilder.append(exception);
            d.v.d.h.f.a(stringBuilder.toString());
            d.v.d.i.c.c c11 = this.i();
            object2 = n10;
            c11.s((Integer)object2);
            object2 = this.z();
            object = n11;
            ((d.v.d.i.b.d)object2).q((Integer)object);
            this.I();
            return;
        }
        Comparable<Integer> comparable = n13;
        ((d.v.d.i.c.c)object3).s((Integer)comparable);
        try {
            object3 = this.a;
            comparable = this.e;
            Camera.CameraInfo cameraInfo = this.c;
            ((s)object3).J0((Camera.Parameters)comparable, cameraInfo);
            this.M();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            comparable = new Comparable<Integer>();
            ((StringBuilder)comparable).append("open Parameter failed e=");
            ((StringBuilder)comparable).append(exception);
            d.v.d.h.f.a(((StringBuilder)comparable).toString());
            d.v.d.i.c.c c10 = this.i();
            object2 = n10;
            c10.s((Integer)object2);
            object2 = this.z();
            object = n11;
            ((d.v.d.i.b.d)object2).q((Integer)object);
            this.I();
            return;
        }
    }

    public void K() {
        Camera.Parameters parameters;
        Object object = this.b;
        if (object != null && (parameters = this.e) != null) {
            object.setParameters(parameters);
            object = "set Parameter succeed ";
            try {
                d.v.d.h.f.a((String)object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                object = "set Parameter failed ";
                d.v.d.h.f.a((String)object);
            }
        }
    }

    public void a() {
        d.v.d.h.f.a("stopPreview");
        this.a.f();
    }

    public void b() {
        d.v.d.h.f.a("destroy");
        this.a.v0();
        this.a();
    }

    public void c() {
        d.v.d.h.f.a("startPreview");
        this.a.l0();
    }

    public void e(boolean bl2) {
        Object object = (Size)this.s().get();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("addPreviewDataListener  add = ");
        ((StringBuilder)object2).append(bl2);
        String string2 = ",previewSize=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(object);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        object2 = this.e;
        if (object2 != null && (string2 = this.b) != null) {
            if (bl2) {
                object2.setPreviewFormat(17);
                int n10 = object.getWidth();
                int n11 = object.getHeight();
                int n12 = this.e.getPreviewFormat();
                string2 = new PixelFormat();
                PixelFormat.getPixelFormatInfo((int)n12, (PixelFormat)string2);
                int n13 = n10 * n11;
                n11 = ((PixelFormat)string2).bitsPerPixel;
                int n14 = n13 * n11 / 8;
                object = this.b;
                object2 = new byte[n14];
                object.addCallbackBuffer((byte[])object2);
                object = this.b;
                object2 = new byte[n14];
                object.addCallbackBuffer((byte[])object2);
                object = this.b;
                object2 = new byte[n14];
                object.addCallbackBuffer((byte[])object2);
                object = new StringBuilder();
                object2 = "Add three callback buffers with size: ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(n14);
                d.v.d.h.f.a(((StringBuilder)object).toString());
                Camera camera = this.b;
                object = new b(this);
                camera.setPreviewCallback((Camera.PreviewCallback)object);
            } else {
                boolean bl3 = false;
                Object var7_12 = null;
                string2.setPreviewCallback(null);
            }
        }
    }

    public void f(boolean bl2) {
        block9: {
            Object object = new StringBuilder();
            String string2 = "addPreviewFaceListener  add = ";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(bl2);
            d.v.d.h.f.a(((StringBuilder)object).toString());
            object = this.e;
            if (object != null && (object = this.b) != null) {
                object.stopFaceDetection();
                object = this.b;
                string2 = null;
                object.setFaceDetectionListener(null);
                if (!bl2) break block9;
                Camera camera = this.b;
                camera.startFaceDetection();
                this.N();
                camera = this.b;
                object = new c(this);
                try {
                    camera.setFaceDetectionListener((Camera.FaceDetectionListener)object);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    object = new StringBuilder();
                    string2 = "addPreviewFaceListener failed e=";
                    ((StringBuilder)object).append(string2);
                    String string3 = exception.toString();
                    ((StringBuilder)object).append(string3);
                    string3 = ((StringBuilder)object).toString();
                    d.v.d.h.f.a(string3);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g() {
        boolean bl2;
        Object object = this.i();
        Object object2 = new StringBuilder();
        Object object3 = "closeDevice DeviceStatus=";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a((String)object2);
        boolean bl3 = ((d.v.d.i.c.c)object).n();
        if (!bl3 && !(bl2 = ((d.v.d.i.c.c)object).o())) {
            this.d();
            d.v.d.h.f.a("set close device ing");
            object = this.i();
            object2 = 0;
            ((d.v.d.i.c.c)object).s((Integer)object2);
            object = this.b;
            bl3 = false;
            object2 = null;
            if (object != null) {
                try {
                    int n10;
                    object.setPreviewCallback(null);
                    object = this.t();
                    bl2 = ((d.v.d.i.f.u)object).o();
                    if (bl2 || (bl2 = ((d.v.d.i.f.u)(object = this.t())).p())) {
                        object = this.b;
                        object.stopPreview();
                        object = this.t();
                        n10 = 4;
                        object3 = n10;
                        ((d.v.d.i.f.u)object).r((Integer)object3);
                        object = "stop preview ,succeed";
                        d.v.d.h.f.a((String)object);
                    }
                    object = this.i();
                    n10 = 1;
                    object3 = n10;
                    ((d.v.d.i.c.c)object).s((Integer)object3);
                    object = this.b;
                    object.release();
                    object = "close device ,succeed";
                    d.v.d.h.f.a((String)object);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            this.b = null;
            this.I();
            return;
        }
        d.v.d.h.f.a("current is close or close ing");
    }

    public a h() {
        return this.a.k();
    }

    public d.v.d.i.c.c i() {
        return this.a.l();
    }

    public e j() {
        return this.a.p();
    }

    public g k() {
        return this.a.q();
    }

    public h l() {
        return this.a.r();
    }

    public d.v.d.i.f.s m() {
        return this.a.s();
    }

    public i n() {
        return this.a.t();
    }

    public k o() {
        return this.a.v();
    }

    public l p() {
        return this.a.w();
    }

    public n q() {
        return this.a.x();
    }

    public o r() {
        return this.a.y();
    }

    public t s() {
        return this.a.A();
    }

    public d.v.d.i.f.u t() {
        return this.a.B();
    }

    public Surface u() {
        return this.a.C();
    }

    public v v() {
        return this.a.D();
    }

    public w w() {
        return this.a.E();
    }

    public y x() {
        return this.a.F();
    }

    public z y() {
        return this.a.G();
    }

    public d.v.d.i.b.d z() {
        return this.a.J();
    }
}

