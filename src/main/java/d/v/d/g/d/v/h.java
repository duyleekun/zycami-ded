/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.params.RggbChannelVector
 *  android.view.Surface
 */
package d.v.d.g.d.v;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.RggbChannelVector;
import android.view.Surface;
import d.v.d.e;
import d.v.d.g.d.n;
import d.v.d.g.d.o;
import d.v.d.g.d.v.i;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.e.g;
import d.v.d.i.f.m;
import d.v.d.i.f.r;
import d.v.d.i.f.x;
import java.util.Arrays;
import java.util.List;

public class h
extends n {
    public i l;

    public h(Context object, e e10) {
        object = (CameraManager)object.getSystemService("camera");
        this.b = object;
        super(e10, this);
        this.l = object;
        this.I((o)object);
    }

    private m V() {
        return this.l.j1();
    }

    private r W() {
        return this.l.k1();
    }

    private x X() {
        return this.l.l1();
    }

    private void Y(CaptureResult object) {
        a a10;
        Object object2 = CaptureResult.SENSOR_SENSITIVITY;
        if ((object2 = (Integer)object.get((CaptureResult.Key)object2)) != null) {
            a10 = this.V();
            ((m)a10).n((Integer)object2);
        }
        object2 = CaptureResult.SENSOR_EXPOSURE_TIME;
        if ((object2 = (Long)object.get((CaptureResult.Key)object2)) != null) {
            a10 = this.W();
            ((r)a10).n((Long)object2);
        }
        if ((object = (RggbChannelVector)object.get((CaptureResult.Key)(object2 = CaptureResult.COLOR_CORRECTION_GAINS))) != null) {
            object2 = this.X();
            int n10 = d.v.d.h.e.b((RggbChannelVector)object);
            object = n10;
            ((x)object2).n((Integer)object);
        }
    }

    public List A() {
        Surface surface = this.l.J();
        Surface[] surfaceArray = new Surface[]{surface, surface = this.l.j()};
        return Arrays.asList(surfaceArray);
    }

    public List F() {
        Surface surface = this.l.J();
        Surface[] surfaceArray = new Surface[]{surface, surface = this.l.j(), surface = this.l.h1()};
        return Arrays.asList(surfaceArray);
    }

    public int G() {
        return 1;
    }

    public void Z() {
        String string2;
        block23: {
            string2 = "take Photo";
            f.a(string2);
            boolean bl2 = this.i();
            if (!bl2) break block23;
            return;
        }
        string2 = this.c;
        int n10 = 2;
        string2 = string2.createCaptureRequest(n10);
        Object object = CaptureRequest.CONTROL_AF_MODE;
        int by2 = 4;
        Object object2 = by2;
        string2.set((CaptureRequest.Key)object, object2);
        object = this.l;
        object = ((o)object).J();
        string2.addTarget((Surface)object);
        object = this.l;
        object = ((i)object).h1();
        string2.addTarget((Surface)object);
        object = CaptureRequest.JPEG_ORIENTATION;
        object2 = this.l;
        int n11 = ((o)object2).r();
        object2 = n11;
        string2.set((CaptureRequest.Key)object, object2);
        object = CaptureRequest.JPEG_QUALITY;
        byte by3 = 90;
        object2 = by3;
        string2.set((CaptureRequest.Key)object, object2);
        object = "capture Still Picture done";
        f.a((String)object);
        object = this.l;
        object = ((i)object).g1();
        Integer n12 = n10;
        ((g)object).r(n12);
        n12 = this.d;
        string2 = string2.build();
        object = null;
        try {
            n12.capture((CaptureRequest)string2, null, null);
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
        }
    }

    public void h(CaptureResult captureResult, CaptureRequest captureRequest) {
        this.Y(captureResult);
    }
}

