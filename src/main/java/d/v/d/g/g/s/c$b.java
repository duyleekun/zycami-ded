/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.g.s;

import com.huawei.camera.camerakit.ActionStateCallback;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.ActionStateCallback$ParametersResult;
import com.huawei.camera.camerakit.ActionStateCallback$PreviewResult;
import com.huawei.camera.camerakit.ActionStateCallback$TakePictureResult;
import com.huawei.camera.camerakit.Mode;
import d.v.d.g.g.m;
import d.v.d.g.g.s.c;
import d.v.d.h.f;
import d.v.d.i.b.d;
import d.v.d.i.e.g;
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
        c.C(this.a, actionStateCallback$FaceDetectionResult);
    }

    public void onParameters(Mode mode, int n10, ActionStateCallback$ParametersResult actionStateCallback$ParametersResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onParameters mode=");
        stringBuilder.append(mode);
        f.a(stringBuilder.toString());
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
                        d.v.d.i.c.c c10 = c.B(this.a);
                        ((StringBuilder)object).append(c10);
                        object = ((StringBuilder)object).toString();
                        f.a((String)object);
                    }
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("onPreview PREVIEW_STOPPED ");
                    Object object2 = c.z(this.a);
                    ((StringBuilder)object).append(object2);
                    f.a(((StringBuilder)object).toString());
                    object = c.A(this.a);
                    object2 = n12;
                    ((u)object).r((Integer)object2);
                }
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append("onPreview PREVIEW_STARTED getDeviceStatus");
                Object object3 = c.G(this.a);
                ((StringBuilder)object).append(object3);
                f.a(((StringBuilder)object).toString());
                object = c.H(this.a);
                object3 = n13;
                ((u)object).r((Integer)object3);
                object = c.I(this.a);
                object3 = n13;
                ((d)object).q((Integer)object3);
                c.F(this.a).y0();
                object = c.F(this.a);
                ((m)object).A0();
            }
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("onPreview ERROR_UNKNOWN ");
            Object object4 = c.J(this.a);
            ((StringBuilder)object).append(object4);
            f.a(((StringBuilder)object).toString());
            object = c.K(this.a);
            n10 = 5;
            object4 = n10;
            ((u)object).r((Integer)object4);
            object = c.y(this.a);
            object4 = n12;
            ((d)object).q((Integer)object4);
        }
    }

    public void onTakePicture(Mode object, int n10, ActionStateCallback$TakePictureResult object2) {
        int n11 = 1;
        if (n10 == n11) {
            f.a("onState: STATE_CAPTURE_STARTED");
            object = c.F(this.a).H0();
            int n12 = 2;
            object2 = n12;
            ((g)object).r((Integer)object2);
        }
        if (n10 == (n11 = 5)) {
            f.a("onState: STATE_CAPTURE_COMPLETED");
            object = c.F(this.a).H0();
            n10 = 3;
            Integer n13 = n10;
            ((g)object).r(n13);
        }
    }
}

