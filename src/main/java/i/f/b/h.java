/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$Size
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package i.f.b;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import i.f.b.f;
import i.f.b.g;
import java.io.IOException;
import java.util.Iterator;

public class h
extends f {
    public static final String K = "CameraRenderer";
    private Camera I;
    private boolean J = false;

    public h(g g10) {
        super(g10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        synchronized (this) {
            String string2 = K;
            String string3 = "closeCamera";
            Log.i((String)string2, (String)string3);
            string2 = this.I;
            if (string2 != null) {
                string2.stopPreview();
                string2 = null;
                this.J = false;
                string2 = this.I;
                string2.release();
                string2 = null;
                this.I = null;
            }
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void q(int var1_1) {
        var2_2 = Build.VERSION.SDK_INT;
        synchronized (this) {
            block22: {
                block23: {
                    block28: {
                        block27: {
                            block25: {
                                block26: {
                                    block24: {
                                        var3_3 = "CameraRenderer";
                                        var4_4 = "openCamera";
                                        Log.i((String)var3_3, (String)var4_4);
                                        this.a();
                                        var5_5 = -1;
                                        var6_6 = 9;
                                        var8_8 = null;
                                        var9_9 = 1;
                                        if (var1_1 != var5_5) break block24;
                                        var10_10 = "CameraRenderer";
                                        var3_3 = "Trying to open camera with old open()";
                                        Log.d((String)var10_10, (String)var3_3);
                                        try {
                                            var10_10 = Camera.open();
                                            this.I = var10_10;
                                        }
                                        catch (Exception var10_11) {
                                            var3_3 = "CameraRenderer";
                                            var11_14 /* !! */  = new StringBuilder();
                                            var12_16 = "Camera is not available (in use or does not exist): ";
                                            var11_14 /* !! */ .append(var12_16);
                                            var10_10 = var10_11.getLocalizedMessage();
                                            var11_14 /* !! */ .append(var10_10);
                                            var10_10 = var11_14 /* !! */ .toString();
                                            Log.e((String)var3_3, (String)var10_10);
                                        }
                                        var10_10 = this.I;
                                        if (var10_10 != null || var2_2 < var6_6) break block22;
                                        var1_1 = 0;
                                        var10_10 = null;
                                        break block25;
                                    }
                                    if (var2_2 < var6_6) break block22;
                                    var1_1 = this.A;
                                    var2_2 = 98;
                                    var5_5 = 99;
                                    if (var1_1 != var5_5) break block26;
                                    var4_4 = "CameraRenderer";
                                    var14_20 = "Trying to open BACK camera";
                                    Log.i((String)var4_4, (String)var14_20);
                                    var4_4 = new Camera.CameraInfo();
                                    break block27;
                                }
                                if (var1_1 != var2_2) break block23;
                                var4_4 = "CameraRenderer";
                                var11_15 = "Trying to open FRONT camera";
                                Log.i((String)var4_4, (String)var11_15);
                                var4_4 = new Camera.CameraInfo();
                                break block28;
                            }
                            while (var7_7 < (var2_2 = Camera.getNumberOfCameras())) {
                                var13_17 = "CameraRenderer";
                                var3_3 = new StringBuilder();
                                var4_4 = "Trying to open camera with new open(";
                                var3_3.append((String)var4_4);
                                var3_3.append(var7_7);
                                var4_4 = ")";
                                var3_3.append((String)var4_4);
                                var3_3 = var3_3.toString();
                                Log.d((String)var13_17, (String)var3_3);
                                try {
                                    var13_17 = Camera.open((int)var7_7);
                                    this.I = var13_17;
                                    var1_1 = var9_9;
                                }
                                catch (RuntimeException var13_18) {
                                    var3_3 = "CameraRenderer";
                                    var4_4 = new StringBuilder();
                                    var11_14 /* !! */  = "Camera #";
                                    var4_4.append((String)var11_14 /* !! */ );
                                    var4_4.append(var7_7);
                                    var11_14 /* !! */  = "failed to open: ";
                                    var4_4.append((String)var11_14 /* !! */ );
                                    var13_17 = var13_18.getLocalizedMessage();
                                    var4_4.append((String)var13_17);
                                    var13_17 = var4_4.toString();
                                    Log.e((String)var3_3, (String)var13_17);
                                }
                                if (var1_1 == 0) {
                                    ++var7_7;
                                    continue;
                                }
                                break block22;
                            }
                            break block22;
                        }
                        for (var7_7 = 0; var7_7 < (var9_9 = Camera.getNumberOfCameras()); ++var7_7) {
                            Camera.getCameraInfo((int)var7_7, (Camera.CameraInfo)var4_4);
                            var9_9 = var4_4.facing;
                            if (var9_9 != 0) {
                                continue;
                            }
                            ** GOTO lbl113
                        }
                        break block23;
                    }
                    while (var7_7 < (var15_21 = Camera.getNumberOfCameras())) {
                        block29: {
                            Camera.getCameraInfo((int)var7_7, (Camera.CameraInfo)var4_4);
                            var15_21 = var4_4.facing;
                            if (var15_21 != var9_9) break block29;
lbl113:
                            // 2 sources

                            var1_1 = var7_7;
                            break;
                        }
                        ++var7_7;
                    }
                }
                if (var1_1 == var5_5) {
                    var10_10 = "CameraRenderer";
                    var13_17 = "Back camera not found!";
                    Log.e((String)var10_10, (String)var13_17);
                } else if (var1_1 == var2_2) {
                    var10_10 = "CameraRenderer";
                    var13_17 = "Front camera not found!";
                    Log.e((String)var10_10, (String)var13_17);
                } else {
                    var13_17 = "CameraRenderer";
                    var3_3 = new StringBuilder();
                    var4_4 = "Trying to open camera with new open(";
                    var3_3.append((String)var4_4);
                    var3_3.append(var1_1);
                    var4_4 = ")";
                    var3_3.append((String)var4_4);
                    var3_3 = var3_3.toString();
                    Log.d((String)var13_17, (String)var3_3);
                    try {
                        var13_17 = Camera.open((int)var1_1);
                        this.I = var13_17;
                    }
                    catch (RuntimeException var13_19) {
                        var3_3 = "CameraRenderer";
                        var4_4 = new StringBuilder();
                        var8_8 = "Camera #";
                        var4_4.append(var8_8);
                        var4_4.append(var1_1);
                        var10_10 = "failed to open: ";
                        var4_4.append(var10_10);
                        var10_10 = var13_19.getLocalizedMessage();
                        var4_4.append(var10_10);
                        var10_10 = var4_4.toString();
                        Log.e((String)var3_3, (String)var10_10);
                    }
                }
            }
            if ((var10_10 = this.I) == null) {
                var10_10 = "CameraRenderer";
                var13_17 = "Error: can't open camera";
                Log.e((String)var10_10, (String)var13_17);
                return;
            }
            var13_17 = (var10_10 = var10_10.getParameters()).getSupportedFocusModes();
            if (var13_17 != null && (var2_2 = (int)var13_17.contains(var3_3 = "continuous-video")) != 0) {
                var13_17 = "continuous-video";
                var10_10.setFocusMode((String)var13_17);
            }
            var13_17 = this.I;
            var13_17.setParameters((Camera.Parameters)var10_10);
            try {
                var10_10 = this.I;
                var13_17 = this.B;
                var10_10.setPreviewTexture((SurfaceTexture)var13_17);
            }
            catch (IOException var10_12) {
                var13_17 = "CameraRenderer";
                var3_3 = new StringBuilder();
                var4_4 = "setPreviewTexture() failed: ";
                var3_3.append((String)var4_4);
                var10_13 = var10_12.getMessage();
                var3_3.append(var10_13);
                var10_13 = var3_3.toString();
                Log.e((String)var13_17, (String)var10_13);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void s(int n10, int n11) {
        synchronized (this) {
            CharSequence charSequence;
            int n12;
            String string2 = K;
            Object object = new StringBuilder();
            String string3 = "setCameraPreviewSize: ";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(n10);
            string3 = "x";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            Log.i((String)string2, (String)object);
            string2 = this.I;
            if (string2 == null) {
                String string4 = K;
                String string5 = "Camera isn't initialized!";
                Log.e((String)string4, (String)string5);
                return;
            }
            int n13 = this.y;
            if (n13 > 0 && n13 < n10) {
                n10 = n13;
            }
            if ((n13 = this.z) > 0 && n13 < n11) {
                n11 = n13;
            }
            if ((n12 = (object = (string2 = string2.getParameters()).getSupportedPreviewSizes()).size()) > 0) {
                int n14;
                float f10 = n10;
                float f11 = n11;
                f10 /= f11;
                Iterator iterator2 = object.iterator();
                int n15 = 0;
                int n16 = 0;
                while ((n14 = iterator2.hasNext()) != 0) {
                    double d10;
                    Object e10 = iterator2.next();
                    Camera.Size size = (Camera.Size)e10;
                    int n17 = size.width;
                    n14 = size.height;
                    String string6 = K;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string7 = "checking camera preview size: ";
                    stringBuilder.append(string7);
                    stringBuilder.append(n17);
                    string7 = "x";
                    stringBuilder.append(string7);
                    stringBuilder.append(n14);
                    String string8 = stringBuilder.toString();
                    Log.d((String)string6, (String)string8);
                    if (n17 > n10 || n14 > n11 || n17 < n15 || n14 < n16) continue;
                    float f12 = n17;
                    float f13 = n14;
                    f12 /= f13;
                    f12 = f10 - f12;
                    double d11 = f12 = Math.abs(f12);
                    double d12 = d11 - (d10 = 0.2);
                    Object object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
                    if (object2 >= 0) continue;
                    n16 = n14;
                    n15 = n17;
                }
                if (n15 > 0 && n16 > 0) {
                    String string9 = K;
                    charSequence = new StringBuilder();
                    object = "Selected best size: ";
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(n15);
                    object = " x ";
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(n16);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.i((String)string9, (String)charSequence);
                } else {
                    Object e11 = object.get(0);
                    Camera.Size size = (Camera.Size)e11;
                    n15 = size.width;
                    Object e12 = object.get(0);
                    Camera.Size size2 = (Camera.Size)e12;
                    n16 = size2.height;
                    String string10 = K;
                    charSequence = new StringBuilder();
                    object = "Error: best size was not selected, using ";
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(n15);
                    object = " x ";
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(n16);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.e((String)string10, (String)charSequence);
                }
                n10 = (int)(this.J ? 1 : 0);
                if (n10 != 0) {
                    Camera camera = this.I;
                    camera.stopPreview();
                    this.J = false;
                }
                this.u = n15;
                this.v = n16;
                string2.setPreviewSize(n15, n16);
            }
            String string11 = "orientation";
            charSequence = "landscape";
            string2.set(string11, (String)charSequence);
            Camera camera = this.I;
            camera.setParameters((Camera.Parameters)string2);
            Camera camera2 = this.I;
            camera2.startPreview();
            n10 = 1;
            this.J = n10;
            return;
        }
    }
}

