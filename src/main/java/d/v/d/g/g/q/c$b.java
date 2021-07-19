/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.g.q;

import com.huawei.camera.camerakit.ActionStateCallback;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.ActionStateCallback$PreviewResult;
import com.huawei.camera.camerakit.ActionStateCallback$TakePictureResult;
import com.huawei.camera.camerakit.Mode;
import d.v.d.g.g.m;
import d.v.d.g.g.q.c;
import d.v.d.h.f;
import d.v.d.i.b.d;
import d.v.d.i.e.g;
import d.v.d.i.e.h;
import d.v.d.i.f.u;

public class c$b
extends ActionStateCallback {
    public final /* synthetic */ c a;

    public c$b(c c10) {
        this.a = c10;
    }

    public void onFaceDetection(Mode mode, int n10, ActionStateCallback$FaceDetectionResult actionStateCallback$FaceDetectionResult) {
        if (actionStateCallback$FaceDetectionResult == null) {
            return;
        }
        c.A(this.a, actionStateCallback$FaceDetectionResult);
    }

    public void onPreview(Mode object, int n10, ActionStateCallback$PreviewResult actionStateCallback$PreviewResult) {
        int n11 = -1;
        int n12 = 4;
        if (n10 != n11) {
            n11 = 1;
            int n13 = 3;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    if (n10 == n13) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("onPreview CAMERA_SWITCH ");
                        d.v.d.i.c.c c10 = c.z(this.a);
                        ((StringBuilder)object).append(c10);
                        object = ((StringBuilder)object).toString();
                        f.a((String)object);
                    }
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("onPreview PREVIEW_STOPPED ");
                    Object object2 = c.I(this.a);
                    ((StringBuilder)object).append(object2);
                    f.a(((StringBuilder)object).toString());
                    object = c.y(this.a);
                    object2 = n12;
                    ((u)object).r((Integer)object2);
                }
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append("onPreview PREVIEW_STARTED getDeviceStatus");
                Object object3 = c.C(this.a);
                ((StringBuilder)object).append(object3);
                f.a(((StringBuilder)object).toString());
                object = c.D(this.a);
                object3 = n13;
                ((u)object).r((Integer)object3);
                object = c.E(this.a);
                object3 = n13;
                ((d)object).q((Integer)object3);
                c.B(this.a).y0();
                object = c.B(this.a);
                ((m)object).A0();
            }
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("onPreview ERROR_UNKNOWN ");
            Object object4 = c.F(this.a);
            ((StringBuilder)object).append(object4);
            f.a(((StringBuilder)object).toString());
            object = c.G(this.a);
            n10 = 5;
            object4 = n10;
            ((u)object).r((Integer)object4);
            object = c.H(this.a);
            object4 = n12;
            ((d)object).q((Integer)object4);
        }
    }

    public void onTakePicture(Mode object, int n10, ActionStateCallback$TakePictureResult actionStateCallback$TakePictureResult) {
        int n11 = 1;
        int n12 = 2;
        if (n10 != n11) {
            if (n10 != n12) {
                n11 = 3;
                if (n10 != n11) {
                    int n13 = 5;
                    if (n10 == n13) {
                        f.a("onState: capture completed");
                        g g10 = c.B(this.a).H0();
                        object = n11;
                        g10.r((Integer)object);
                    }
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("onState: capture_exposure_end =");
                    n10 = actionStateCallback$TakePictureResult.getExposureTime();
                    ((StringBuilder)object).append(n10);
                    f.a(((StringBuilder)object).toString());
                    object = c.B(this.a).I0();
                    n10 = actionStateCallback$TakePictureResult.getExposureTime();
                    Integer n14 = n10;
                    ((h)object).n(n14);
                }
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append("onState: capture_exposure_begin =");
                n10 = actionStateCallback$TakePictureResult.getExposureTime();
                ((StringBuilder)object).append(n10);
                f.a(((StringBuilder)object).toString());
                object = c.B(this.a).I0();
                n10 = actionStateCallback$TakePictureResult.getExposureTime();
                Integer n15 = n10;
                ((h)object).n(n15);
            }
        } else {
            f.a("onState: capture start");
            object = c.B(this.a).H0();
            Integer n16 = n12;
            ((g)object).r(n16);
        }
    }
}

