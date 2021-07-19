/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.view.Surface
 */
package d.v.d.g.d.t;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import d.v.d.g.d.n;
import d.v.d.g.d.o;
import d.v.d.g.d.t.f;
import d.v.d.i.e.g;
import java.util.Arrays;
import java.util.List;

public class e
extends n {
    public f l;

    public e(Context object, d.v.d.e e10) {
        object = (CameraManager)object.getSystemService("camera");
        this.b = object;
        super(e10, this);
        this.l = object;
        this.I((o)object);
    }

    public List A() {
        return this.F();
    }

    public List F() {
        Surface surface = this.l.J();
        Surface[] surfaceArray = new Surface[]{surface, surface = this.l.j()};
        return Arrays.asList(surfaceArray);
    }

    public int G() {
        return 1;
    }

    public void V() {
        Object object;
        int n10;
        block26: {
            n10 = 4;
            object = "take Photo";
            d.v.d.h.f.a((String)object);
            boolean bl2 = this.i();
            if (!bl2) break block26;
            return;
        }
        object = this.l;
        object = ((f)object).b1();
        int n11 = 2;
        Object object2 = n11;
        ((g)object).r((Integer)object2);
        object = this.c;
        object = object.createCaptureRequest(n11);
        Object object3 = CaptureRequest.CONTROL_AF_MODE;
        object2 = n10;
        object.set((CaptureRequest.Key)object3, object2);
        object3 = this.l;
        object3 = ((o)object3).J();
        object.addTarget((Surface)object3);
        object3 = this.l;
        object3 = ((f)object3).c1();
        object.addTarget((Surface)object3);
        object3 = CaptureRequest.JPEG_ORIENTATION;
        object2 = this.l;
        int n12 = ((o)object2).r();
        object2 = n12;
        object.set((CaptureRequest.Key)object3, object2);
        object3 = CaptureRequest.JPEG_QUALITY;
        n12 = 90;
        object2 = (byte)n12;
        object.set((CaptureRequest.Key)object3, object2);
        object3 = "capture Still Picture done";
        d.v.d.h.f.a((String)object3);
        object3 = this.l;
        object3 = ((f)object3).b1();
        n12 = 3;
        object2 = n12;
        ((g)object3).r((Integer)object2);
        object3 = this.d;
        object = object.build();
        n12 = 0;
        object2 = null;
        try {
            object3.capture((CaptureRequest)object, null, null);
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
            object3 = new StringBuilder();
            object2 = "capture Still Picture failed,e=";
            ((StringBuilder)object3).append((String)object2);
            Object object4 = cameraAccessException.toString();
            ((StringBuilder)object3).append((String)object4);
            d.v.d.h.f.a(((StringBuilder)object3).toString());
            object4 = this.l.b1();
            Integer n13 = n10;
            ((g)object4).r(n13);
        }
    }
}

