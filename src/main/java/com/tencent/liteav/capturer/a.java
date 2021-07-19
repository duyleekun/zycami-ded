/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$Area
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$ErrorCallback
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$Size
 *  android.os.Build$VERSION
 */
package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.capturer.a$1;
import com.tencent.liteav.capturer.a$2;
import com.tencent.liteav.capturer.a$a;
import com.tencent.liteav.capturer.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class a
implements Camera.AutoFocusCallback,
Camera.ErrorCallback,
Camera.PreviewCallback {
    private Matrix a;
    private int b;
    private Camera c;
    private boolean d;
    private b e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private SurfaceTexture l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;

    public a() {
        boolean bl2;
        Matrix matrix;
        this.a = matrix = new Matrix();
        this.b = 0;
        this.d = bl2 = true;
        this.f = 15;
        this.g = (int)(bl2 ? 1 : 0);
        this.p = false;
        this.s = false;
        this.t = false;
    }

    private Rect a(float f10, float f11, float f12) {
        float f13 = 200.0f;
        f12 *= f13;
        int n10 = this.d;
        int n11 = 1;
        float f14 = Float.MIN_VALUE;
        if (n10 == n11) {
            n10 = 1065353216;
            f13 = 1.0f;
            f10 = f13 - f10;
        }
        n10 = this.j / 90;
        f14 = 0.0f;
        Rect rect = null;
        for (n11 = 0; n11 < n10; ++n11) {
            float f15 = 0.5f;
            f10 -= f15;
            f11 = -(-(f11 - f15));
            f10 = -f10;
            float f16 = f11 += f15;
            f11 = f10 += f15;
            f10 = f16;
        }
        f13 = 2000.0f;
        f10 *= f13;
        n11 = 1148846080;
        f14 = 1000.0f;
        int n12 = (int)(f10 -= f14);
        f11 = f11 * f13 - f14;
        int n13 = (int)f11;
        n10 = -1000;
        f13 = 0.0f / 0.0f;
        if (n12 < n10) {
            n12 = n10;
            f10 = f13;
        }
        if (n13 < n10) {
            n13 = n10;
            f11 = f13;
        }
        int n14 = (int)f12;
        n10 = n12 + n14;
        n14 += n13;
        n11 = 1000;
        f14 = 1.401E-42f;
        if (n10 > n11) {
            n10 = n11;
            f13 = f14;
        }
        if (n14 > n11) {
            n14 = n11;
            f12 = f14;
        }
        rect = new Rect(n12, n13, n10, n14);
        return rect;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static e a(Camera.Parameters var0, int var1_1, int var2_2) {
        var3_3 = 2;
        var4_4 = new Object[var3_3];
        var4_4[0] = var5_5 = Integer.valueOf(var1_1);
        var5_5 = var2_2;
        var6_6 = 1;
        var4_4[var6_6] = var5_5;
        var5_5 = "TXCCameraCapturer";
        var7_7 = "camera preview wanted: %d x %d";
        TXCLog.d((String)var5_5, var7_7, (Object[])var4_4);
        var0 = var0.getSupportedPreviewSizes();
        var8_8 = var1_1;
        var9_9 = 1065353216;
        var10_10 = 1.0f;
        var8_8 *= var10_10;
        var11_11 = var2_2;
        var8_8 /= var11_11;
        var12_12 = new ArrayList();
        var0 = var0.iterator();
        var13_13 = -1 >>> 1;
        var14_14 = 0.0f / 0.0f;
        var15_15 = var13_13;
        while (var16_16 = var0.hasNext()) {
            var17_17 = (Camera.Size)var0.next();
            var18_18 = new Object[var3_3];
            var18_18[0] = var19_19 = Integer.valueOf(var17_17.width);
            var18_18[var6_6] = var19_19 = Integer.valueOf(var17_17.height);
            var19_19 = "camera support preview size: %dx%d";
            TXCLog.d((String)var5_5, (String)var19_19, var18_18);
            var20_20 = var17_17.width;
            var21_21 = 640;
            var22_22 = 8.97E-43f;
            if (var20_20 < var21_21) ** GOTO lbl-1000
            var21_21 = var17_17.height;
            var23_23 = 480;
            var24_24 = 6.73E-43f;
            if (var21_21 >= var23_23) {
                var23_23 = 1092616192;
                var24_24 = 10.0f;
                var25_25 = (float)var20_20 * var10_10;
                var22_22 = var21_21;
                var25_25 = Math.abs(var25_25 / var22_22 - var8_8) * var24_24;
                var20_20 = Math.round(var25_25);
            } else lbl-1000:
            // 2 sources

            {
                var20_20 = var13_13;
                var25_25 = var14_14;
            }
            if (var20_20 < var15_15) {
                var12_12.clear();
                var12_12.add(var17_17);
                var15_15 = var20_20;
                continue;
            }
            if (var20_20 != var15_15) continue;
            var12_12.add(var17_17);
        }
        var0 = new a$1();
        Collections.sort(var12_12, var0);
        var0 = (Camera.Size)var12_12.get(0);
        var26_26 = var1_1 *= var2_2;
        var2_2 = 0x4F000000;
        var27_27 = 2.14748365E9f;
        var4_4 = var12_12.iterator();
        while ((var9_9 = (int)var4_4.hasNext()) != 0) {
            var7_7 = (Camera.Size)var4_4.next();
            var12_12 = new Object[var3_3];
            var12_12[0] = var28_28 = Integer.valueOf(var7_7.width);
            var12_12[var6_6] = var28_28 = Integer.valueOf(var7_7.height);
            var28_28 = "size in same buck: %dx%d";
            TXCLog.i((String)var5_5, (String)var28_28, var12_12);
            var29_29 = var7_7.width;
            var13_13 = var7_7.height;
            var11_11 = var29_29 *= var13_13;
            var14_14 = var11_11 / var26_26;
            var30_30 = var14_14;
            var32_31 = 0.9;
            cfr_temp_0 = var30_30 - var32_31;
            if ((var13_13 = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 > 0.0 ? 1 : -1))) < 0 || (var13_13 = (int)((cfr_temp_1 = (var14_14 = Math.abs(var11_11 -= var26_26)) - var27_27) == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1))) >= 0) continue;
            var27_27 = var34_32 = Math.abs(var11_11);
            var0 = var7_7;
        }
        var35_33 /* !! */  = new Object[var3_3];
        var36_34 = var0.width;
        var35_33 /* !! */ [0] = var36_34;
        var36_34 = var0.height;
        var35_33 /* !! */ [var6_6] = var36_34;
        TXCLog.i((String)var5_5, "best match preview size: %d x %d", var35_33 /* !! */ );
        var2_2 = var0.width;
        var37_35 = var0.height;
        var35_33 /* !! */  = new e(var2_2, var37_35);
        return var35_33 /* !! */ ;
    }

    private static e b(boolean n10, int n11, int n12) {
        if (n10) {
            e e10 = new e(n11, n12);
            return e10;
        }
        n10 = 1;
        float f10 = Float.MIN_VALUE;
        e[] eArray = new e[n10];
        e e11 = new e(1080, 1920);
        eArray[0] = e11;
        int n13 = Math.min(n11, n12);
        float f11 = n13;
        int n14 = Math.max(n11, n12);
        float f12 = n14;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n15;
            float f13;
            e e12 = eArray[i10];
            int n16 = e12.a;
            float f14 = n16;
            float f15 = f11 - f14;
            Object object = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (object > 0 || (object = (f13 = f12 - (f14 = (float)(n15 = e12.b))) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) > 0) continue;
            f10 = (float)n16 / f11;
            float f16 = (float)n15 / f12;
            f10 = Math.min(f10, f16);
            float f17 = (float)n11 * f10;
            n11 = (int)f17;
            float f18 = (float)n12 * f10;
            n12 = (int)f18;
            break;
        }
        e e13 = new e(n11, n12);
        return e13;
    }

    private int d(int n10) {
        int n11;
        Object object = this.a();
        int n12 = 1;
        if (object == null) {
            return n12;
        }
        object = object.getSupportedPreviewFrameRates();
        String string2 = "TXCCameraCapturer";
        if (object == null) {
            TXCLog.e(string2, "getSupportedFPS error");
            return n12;
        }
        Integer n13 = (Integer)object.get(0);
        int n14 = n13;
        for (n12 = 0; n12 < (n11 = object.size()); ++n12) {
            Integer n15 = (Integer)object.get(n12);
            n11 = n15;
            int n16 = Math.abs(n11 - n10);
            int n17 = Math.abs(n14 - n10);
            if ((n16 -= n17) >= 0) continue;
            n14 = n11;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("choose fps=");
        charSequence.append(n14);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        return n14;
    }

    private int[] e(int n10) {
        int n11;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("camera supported preview fps range: wantFPS = ");
        charSequence.append(n10 *= 1000);
        Object object = "\n";
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object object2 = this.a();
        if (object2 == null) {
            return null;
        }
        if ((object2 = object2.getSupportedPreviewFpsRange()) != null && (n11 = object2.size()) > 0) {
            boolean bl2;
            int n12;
            int n13;
            String string2;
            Object object3 = (int[])object2.get(0);
            Object object4 = new a$2(this);
            Collections.sort(object2, object4);
            object4 = object2.iterator();
            while (true) {
                boolean bl3 = object4.hasNext();
                string2 = " - ";
                n13 = 1;
                if (!bl3) break;
                int[] nArray = (int[])object4.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append("camera supported preview fps range: ");
                n12 = nArray[0];
                stringBuilder.append(n12);
                stringBuilder.append(string2);
                n12 = nArray[n13];
                stringBuilder.append(n12);
                stringBuilder.append((String)object);
                charSequence = stringBuilder.toString();
            }
            object = object2.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (int[])object.next();
                Camera.Parameters parameters = object2[0];
                if (parameters > n10 || n10 > (parameters = object2[n13])) continue;
                object3 = object2;
                break;
            }
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append((String)charSequence);
            charSequence2.append("choose preview fps range: ");
            n12 = object3[0];
            charSequence2.append(n12);
            charSequence2.append(string2);
            n12 = object3[n13];
            charSequence2.append(n12);
            charSequence2 = charSequence2.toString();
            TXCLog.i("TXCCameraCapturer", (String)charSequence2);
            return object3;
        }
        return null;
    }

    private int f(int n10) {
        int n11;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo((int)n10, (Camera.CameraInfo)cameraInfo);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("vsize camera orientation ");
        int n12 = cameraInfo.orientation;
        charSequence.append(n12);
        String string2 = ", front ";
        charSequence.append(string2);
        n12 = cameraInfo.facing;
        int n13 = 1;
        if (n12 == n13) {
            n12 = n13;
        } else {
            n12 = 0;
            string2 = null;
        }
        charSequence.append(n12 != 0);
        charSequence = charSequence.toString();
        string2 = "TXCCameraCapturer";
        TXCLog.i(string2, (String)charSequence);
        n10 = cameraInfo.orientation;
        if (n10 == 0 || n10 == (n12 = 180)) {
            n10 += 90;
        }
        n10 = (n11 = cameraInfo.facing) == n13 ? (360 - n10) % 360 : (n10 + 360) % 360;
        return n10;
    }

    public Camera.Parameters a() {
        Camera camera = this.c;
        if (camera == null) {
            return null;
        }
        try {
            return camera.getParameters();
        }
        catch (Exception exception) {
            TXCLog.e("TXCCameraCapturer", "getCameraParameters error ", exception);
            return null;
        }
    }

    public void a(float f10) {
        Object object = this.c;
        if (object != null) {
            CharSequence charSequence;
            int n10;
            int n11 = 1065353216;
            float f11 = 1.0f;
            float f12 = f10 - f11;
            Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object2 > 0) {
                n10 = n11;
                f10 = f11;
            }
            n11 = -1082130432;
            f11 = -1.0f;
            float f13 = f10 - f11;
            object2 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (object2 < 0) {
                n10 = n11;
                f10 = f11;
            }
            object = this.a();
            String string2 = "TXCCameraCapturer";
            if (object == null) {
                TXCLog.e(string2, "camera setExposureCompensation camera parameter is null");
                return;
            }
            int n12 = object.getMinExposureCompensation();
            int n13 = object.getMaxExposureCompensation();
            if (n12 != 0 && n13 != 0) {
                c c10 = com.tencent.liteav.basic.c.c.a();
                int n14 = c10.e();
                float f14 = n13;
                f10 *= f14;
                String string3 = "camera setExposureCompensation: ";
                if (n14 != 0 && n14 <= n13 && n14 >= n12) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(n14);
                    charSequence = ((StringBuilder)charSequence).toString();
                    TXCLog.i(string2, (String)charSequence);
                    object.setExposureCompensation(n14);
                } else {
                    float f15;
                    float f16;
                    n13 = (int)(f10 == f14 ? 0 : (f10 < f14 ? -1 : 1));
                    if (n13 <= 0 && (n12 = (int)((f16 = f10 - (f15 = (float)n12)) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1))) >= 0) {
                        CharSequence charSequence2 = new StringBuilder();
                        charSequence2.append(string3);
                        charSequence2.append(f10);
                        charSequence2 = charSequence2.toString();
                        TXCLog.i(string2, (String)charSequence2);
                        n10 = (int)f10;
                        object.setExposureCompensation(n10);
                    }
                }
            } else {
                charSequence = "camera not support setExposureCompensation!";
                TXCLog.e(string2, (String)charSequence);
            }
            charSequence = this.c;
            try {
                charSequence.setParameters((Camera.Parameters)object);
            }
            catch (Exception exception) {
                object = "setExposureCompensation failed.";
                TXCLog.e(string2, (String)object, exception);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(float f10, float f11) {
        Camera camera;
        Camera.Area area;
        float f12;
        ArrayList<Camera.Area> arrayList;
        int n10;
        boolean bl2;
        Camera camera2;
        block10: {
            boolean bl3 = this.s;
            if (!bl3) {
                return;
            }
            try {
                camera2 = this.c;
            }
            catch (Exception exception) {
                return;
            }
            camera2.cancelAutoFocus();
            camera2 = this.c;
            camera2 = camera2.getParameters();
            bl2 = this.m;
            n10 = 1000;
            if (!bl2) break block10;
            arrayList = new ArrayList<Camera.Area>();
            f12 = 2.0f;
            Rect rect = this.a(f10, f11, f12);
            area = new Camera.Area(rect, n10);
            arrayList.add(area);
            camera2.setFocusAreas(arrayList);
        }
        if (bl2 = this.n) {
            arrayList = new ArrayList<Camera.Area>();
            f12 = 3.0f;
            camera = this.a(f10, f11, f12);
            area = new Camera.Area((Rect)camera, n10);
            arrayList.add(area);
            camera2.setMeteringAreas(arrayList);
        }
        camera = this.c;
        camera.setParameters((Camera.Parameters)camera2);
        camera = this.c;
        camera.autoFocus((Camera.AutoFocusCallback)this);
    }

    public void a(int n10) {
        this.f = n10;
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.l = surfaceTexture;
    }

    public void a(a$a object) {
        Object object2 = a$a.a;
        if (object != object2) {
            int n10;
            this.q = n10 = a$a.a(object);
            this.r = n10 = a$a.b(object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("set resolution ");
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        TXCLog.i("TXCCameraCapturer", (String)object);
    }

    public void a(b b10) {
        this.e = b10;
    }

    public void a(boolean bl2, int n10, int n11) {
        this.p = bl2;
        this.q = n10;
        this.r = n11;
        Object[] objectArray = new Object[3];
        Comparable<Boolean> comparable = bl2;
        objectArray[0] = comparable;
        comparable = n10;
        objectArray[1] = comparable;
        comparable = n11;
        objectArray[2] = comparable;
        TXCLog.i("TXCCameraCapturer", "setCaptureBuffer %b, width: %d, height: %d", objectArray);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean a(boolean var1_1) {
        block6: {
            block8: {
                block7: {
                    this.o = var1_1;
                    var2_2 /* !! */  = this.c;
                    var3_3 = false;
                    if (var2_2 /* !! */  == null) break block6;
                    var4_4 = true;
                    var5_5 = this.a();
                    if (var5_5 == null) {
                        return false;
                    }
                    var6_6 = var5_5.getSupportedFlashModes();
                    var7_7 = "TXCCameraCapturer";
                    if (!var1_1) break block7;
                    if (var6_6 == null || !(var9_10 = var6_6.contains(var8_8 = "torch"))) ** GOTO lbl-1000
                    var6_6 = "set FLASH_MODE_TORCH";
                    TXCLog.i(var7_7, (String)var6_6);
                    var5_5.setFlashMode(var8_8);
                    break block8;
                }
                if (var6_6 != null && (var9_11 = var6_6.contains(var8_8 = "off"))) {
                    var6_6 = "set FLASH_MODE_OFF";
                    TXCLog.i(var7_7, (String)var6_6);
                    var5_5.setFlashMode(var8_8);
                } else lbl-1000:
                // 2 sources

                {
                    var4_4 = false;
                    var2_2 /* !! */  = null;
                }
            }
            var8_8 = this.c;
            try {
                var8_8.setParameters(var5_5);
                var3_3 = var4_4;
            }
            catch (Exception var8_9) {
                var2_2 /* !! */  = "setParameters failed.";
                TXCLog.e(var7_7, (String)var2_2 /* !! */ , var8_9);
            }
        }
        return var3_3;
    }

    public int b() {
        int n10;
        int n11;
        Camera.Parameters parameters = this.a();
        if (parameters != null && (n11 = parameters.getMaxZoom()) > 0 && (n11 = (int)(parameters.isZoomSupported() ? 1 : 0)) != 0) {
            n10 = parameters.getMaxZoom();
        } else {
            n10 = 0;
            parameters = null;
        }
        return n10;
    }

    public void b(boolean bl2) {
        this.t = bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set performance mode to ");
        stringBuilder.append(bl2);
        String string2 = stringBuilder.toString();
        TXCLog.i("TXCCameraCapturer", string2);
    }

    public boolean b(int n10) {
        Object object = this.c;
        boolean bl2 = false;
        if (object != null) {
            int n11;
            object = this.a();
            String string2 = "TXCCameraCapturer";
            if (object != null && (n11 = object.getMaxZoom()) > 0 && (n11 = (int)(object.isZoomSupported() ? 1 : 0)) != 0) {
                if (n10 >= 0 && n10 <= (n11 = object.getMaxZoom())) {
                    object.setZoom(n10);
                    Camera camera = this.c;
                    try {
                        camera.setParameters((Camera.Parameters)object);
                        bl2 = true;
                    }
                    catch (Exception exception) {
                        object = "set zoom failed.";
                        TXCLog.e(string2, (String)object, exception);
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "invalid zoom value : ";
                    stringBuilder.append(string3);
                    stringBuilder.append(n10);
                    stringBuilder.append(", while max zoom is ");
                    n10 = object.getMaxZoom();
                    stringBuilder.append(n10);
                    String string4 = stringBuilder.toString();
                    TXCLog.e(string2, string4);
                }
            } else {
                String string5 = "camera not support zoom!";
                TXCLog.e(string2, string5);
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Throwable throwable2;
        block4: {
            Camera camera = this.c;
            if (camera == null) return;
            try {
                try {
                    camera.setErrorCallback(null);
                    camera = this.c;
                    camera.setPreviewCallback(null);
                    camera = this.c;
                    camera.stopPreview();
                    camera = this.c;
                    camera.release();
                }
                catch (Exception exception) {
                    String string2 = "TXCCameraCapturer";
                    String string3 = "stop capture failed.";
                    TXCLog.e(string2, string3, exception);
                }
            }
            catch (Throwable throwable2) {
                break block4;
            }
            this.c = null;
            this.l = null;
            return;
        }
        this.c = null;
        this.l = null;
        throw throwable2;
    }

    public void c(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("vsize setHomeOrientation ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.w("TXCCameraCapturer", (String)charSequence);
        this.g = n10;
        int n11 = this.k + -90;
        this.j = n11 = (n11 + (n10 *= 90) + 360) % 360;
    }

    public void c(boolean bl2) {
        this.s = bl2;
    }

    public int d() {
        return this.j;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int d(boolean bl2) {
        int n10;
        Camera camera;
        Object object = "auto";
        String string2 = "continuous-video";
        String string3 = "open camera failed.";
        String string4 = "TXCCameraCapturer";
        int n11 = -1;
        Object object2 = "trtc_capture: start capture";
        try {
            int n12;
            int n13;
            int n14;
            boolean bl3;
            boolean bl4;
            int n15;
            TXCLog.i(string4, (String)object2);
            object2 = this.l;
            if (object2 == null) {
                return -2;
            }
            object2 = this.c;
            if (object2 != null) {
                this.c();
            }
            object2 = new Camera.CameraInfo();
            int n16 = n11;
            int n17 = n11;
            int n18 = 0;
            String string5 = null;
            while (true) {
                int n19 = Camera.getNumberOfCameras();
                n15 = 1;
                if (n18 >= n19) break;
                Camera.getCameraInfo((int)n18, (Camera.CameraInfo)object2);
                StringBuilder stringBuilder = new StringBuilder();
                String string6 = "camera index ";
                stringBuilder.append(string6);
                stringBuilder.append(n18);
                string6 = ", facing = ";
                stringBuilder.append(string6);
                int n20 = ((Camera.CameraInfo)object2).facing;
                stringBuilder.append(n20);
                String string7 = stringBuilder.toString();
                TXCLog.i(string4, string7);
                n19 = ((Camera.CameraInfo)object2).facing;
                if (n19 == n15 && n16 == n11) {
                    n16 = n18;
                }
                if (n19 == 0 && n17 == n11) {
                    n17 = n18;
                }
                ++n18;
            }
            object2 = new StringBuilder();
            string5 = "camera front, id = ";
            ((StringBuilder)object2).append(string5);
            ((StringBuilder)object2).append(n16);
            object2 = ((StringBuilder)object2).toString();
            TXCLog.i(string4, (String)object2);
            object2 = new StringBuilder();
            string5 = "camera back , id = ";
            ((StringBuilder)object2).append(string5);
            ((StringBuilder)object2).append(n17);
            object2 = ((StringBuilder)object2).toString();
            TXCLog.i(string4, (String)object2);
            if (n16 == n11 && n17 != n11) {
                n16 = n17;
            }
            if (n17 == n11 && n16 != n11) {
                n17 = n16;
            }
            this.d = bl2;
            this.c = bl2 ? (camera = Camera.open((int)n16)) : (camera = Camera.open((int)n17));
            camera = this.c;
            camera = camera.getParameters();
            object2 = camera.getSupportedFocusModes();
            n18 = (int)(this.s ? 1 : 0);
            if (n18 != 0 && object2 != null && (n18 = (int)(object2.contains(object) ? 1 : 0)) != 0) {
                string2 = "support FOCUS_MODE_AUTO";
                TXCLog.i(string4, string2);
                camera.setFocusMode((String)object);
            } else if (object2 != null && (bl4 = object2.contains(string2))) {
                object = "support FOCUS_MODE_CONTINUOUS_VIDEO";
                TXCLog.i(string4, (String)object);
                camera.setFocusMode(string2);
            }
            int n21 = Build.VERSION.SDK_INT;
            int n22 = 14;
            if (n21 >= n22) {
                int n23;
                int n24 = camera.getMaxNumFocusAreas();
                if (n24 > 0) {
                    this.m = n15;
                }
                if ((n23 = camera.getMaxNumMeteringAreas()) > 0) {
                    this.n = n15;
                }
            }
            if (bl3 = this.p) {
                int n25 = 17;
                camera.setPreviewFormat(n25);
                object = this.c;
                object.setPreviewCallback((Camera.PreviewCallback)this);
            }
            boolean bl5 = this.t;
            int n26 = this.q;
            int n27 = this.r;
            object = com.tencent.liteav.capturer.a.b(bl5, n26, n27);
            int n28 = ((e)object).a;
            n27 = ((e)object).b;
            int n29 = Math.max(n28, n27);
            n27 = ((e)object).a;
            int n31 = ((e)object).b;
            n31 = Math.min(n27, n31);
            object = com.tencent.liteav.capturer.a.a((Camera.Parameters)camera, n29, n31);
            this.h = n14 = ((e)object).a;
            this.i = n13 = ((e)object).b;
            camera.setPreviewSize(n14, n13);
            int n32 = this.f;
            object = this.e(n32);
            if (object != null) {
                Object object3 = object[0];
                Object object4 = object[n15];
                camera.setPreviewFpsRange((int)object3, (int)object4);
            } else {
                int n34 = this.f;
                n34 = this.d(n34);
                camera.setPreviewFrameRate(n34);
            }
            boolean bl6 = this.d;
            if (!bl6) {
                n16 = n17;
            }
            this.k = n12 = this.f(n16);
            int n35 = n12 + -90;
            int n36 = this.g * 90;
            n10 = n35 + n36 + 360;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            String string8 = exception.getMessage();
            ((StringBuilder)object).append(string8);
            string8 = ((StringBuilder)object).toString();
            TXCLog.e(string4, string8);
            return n11;
        }
        catch (IOException iOException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            String string9 = iOException.getMessage();
            ((StringBuilder)object).append(string9);
            string9 = ((StringBuilder)object).toString();
            TXCLog.e(string4, string9);
            return n11;
        }
        {
            int n37;
            this.j = n37 = n10 % 360;
            object = this.c;
            object.setDisplayOrientation(0);
            object = new StringBuilder();
            string2 = "vsize camera orientation ";
            ((StringBuilder)object).append(string2);
            int n38 = this.k;
            ((StringBuilder)object).append(n38);
            string2 = ", preview ";
            ((StringBuilder)object).append(string2);
            int n39 = this.j;
            ((StringBuilder)object).append(n39);
            string2 = ", home orientation ";
            ((StringBuilder)object).append(string2);
            int n40 = this.g;
            ((StringBuilder)object).append(n40);
            object = ((StringBuilder)object).toString();
            TXCLog.i(string4, (String)object);
            object = this.c;
            string2 = this.l;
            object.setPreviewTexture((SurfaceTexture)string2);
            object = this.c;
            object.setParameters((Camera.Parameters)camera);
            camera = this.c;
            camera.setErrorCallback((Camera.ErrorCallback)this);
            camera = this.c;
            camera.startPreview();
            return 0;
        }
    }

    public boolean e() {
        return this.d;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.i;
    }

    public Camera h() {
        return this.c;
    }

    public void onAutoFocus(boolean bl2, Camera object) {
        object = "TXCCameraCapturer";
        if (bl2) {
            String string2 = "AUTO focus success";
            TXCLog.i((String)object, string2);
        } else {
            String string3 = "AUTO focus failed";
            TXCLog.i((String)object, string3);
        }
    }

    public void onError(int n10, Camera object) {
        b b10;
        object = new StringBuilder();
        ((StringBuilder)object).append("camera catch error ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXCCameraCapturer";
        TXCLog.w(string2, (String)object);
        int n11 = 1;
        if ((n10 == n11 || n10 == (n11 = 2) || n10 == (n11 = 100)) && (b10 = this.e) != null) {
            b10.h();
        }
    }

    public void onPreviewFrame(byte[] byArray, Camera object) {
        object = this.e;
        if (object != null) {
            object.a(byArray);
        }
    }
}

