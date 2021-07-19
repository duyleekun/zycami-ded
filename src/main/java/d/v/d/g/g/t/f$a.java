/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.g.t;

import com.huawei.camera.camerakit.ActionStateCallback;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.ActionStateCallback$PreviewResult;
import com.huawei.camera.camerakit.Mode;
import d.v.d.g.g.m;
import d.v.d.g.g.t.f;
import d.v.d.i.b.d;
import d.v.d.i.c.c;
import d.v.d.i.f.u;

public class f$a
extends ActionStateCallback {
    public final /* synthetic */ f a;

    public f$a(f f10) {
        this.a = f10;
    }

    public void onFaceDetection(Mode mode, int n10, ActionStateCallback$FaceDetectionResult actionStateCallback$FaceDetectionResult) {
        if (actionStateCallback$FaceDetectionResult == null) {
            return;
        }
        f.y(this.a, actionStateCallback$FaceDetectionResult);
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
                        c c10 = f.G(this.a);
                        ((StringBuilder)object).append(c10);
                        object = ((StringBuilder)object).toString();
                        d.v.d.h.f.a((String)object);
                    }
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("onPreview PREVIEW_STOPPED ");
                    Object object2 = f.E(this.a);
                    ((StringBuilder)object).append(object2);
                    d.v.d.h.f.a(((StringBuilder)object).toString());
                    object = f.F(this.a);
                    object2 = n12;
                    ((u)object).r((Integer)object2);
                }
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append("onPreview PREVIEW_STARTED getDeviceStatus");
                Object object3 = f.w(this.a);
                ((StringBuilder)object).append(object3);
                d.v.d.h.f.a(((StringBuilder)object).toString());
                object = f.x(this.a);
                object3 = n13;
                ((u)object).r((Integer)object3);
                object = f.z(this.a);
                object3 = n13;
                ((d)object).q((Integer)object3);
                f.A(this.a).y0();
                object = f.A(this.a);
                ((m)object).A0();
            }
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("onPreview ERROR_UNKNOWN ");
            Object object4 = f.B(this.a);
            ((StringBuilder)object).append(object4);
            d.v.d.h.f.a(((StringBuilder)object).toString());
            object = f.C(this.a);
            n10 = 5;
            object4 = n10;
            ((u)object).r((Integer)object4);
            object = f.D(this.a);
            object4 = n12;
            ((d)object).q((Integer)object4);
        }
    }
}

