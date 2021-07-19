/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.ImageFormat
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 */
package i.f.b;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import i.f.b.e;
import i.f.b.e$f;
import i.f.b.l$b;
import i.f.b.l$c;
import i.f.b.l$d;
import i.f.c.a;
import java.util.List;
import org.opencv.core.Mat;

public class l
extends e
implements Camera.PreviewCallback {
    private static final int I = 10;
    private static final String J = "JavaCameraView";
    private int A = 0;
    private Thread B;
    private boolean C;
    public Camera D;
    public l$c[] E;
    private SurfaceTexture F;
    private int G = 17;
    private boolean H = false;
    private byte[] y;
    private Mat[] z;

    public l(Context context, int n10) {
        super(context, n10);
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ int t(l l10) {
        return l10.G;
    }

    public static /* synthetic */ boolean u(l l10) {
        return l10.H;
    }

    public static /* synthetic */ boolean v(l l10, boolean bl2) {
        l10.H = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean w(l l10) {
        return l10.C;
    }

    public static /* synthetic */ int x(l l10) {
        return l10.A;
    }

    public static /* synthetic */ int y(l l10, int n10) {
        l10.A = n10;
        return n10;
    }

    public static /* synthetic */ Mat[] z(l l10) {
        return l10.z;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean A(int var1_1, int var2_2) {
        var3_3 = Build.VERSION.SDK_INT;
        var4_4 /* !! */  = "Initialize java camera";
        Log.d((String)"JavaCameraView", (String)var4_4 /* !! */ );
        synchronized (this) {
            block41: {
                block39: {
                    block40: {
                        block43: {
                            block42: {
                                this.D = null;
                                var5_6 = this.l;
                                var6_7 = 9;
                                var7_8 = 1.3E-44f;
                                var8_9 = -1;
                                var9_10 = 0;
                                var10_11 = 1;
                                var11_12 = 1.4E-45f;
                                if (var5_6 != var8_9) break block42;
                                var4_4 /* !! */  = "JavaCameraView";
                                var12_13 = "Trying to open camera with old open()";
                                Log.d((String)var4_4 /* !! */ , (String)var12_13);
                                try {
                                    var4_4 /* !! */  = Camera.open();
                                    this.D = var4_4 /* !! */ ;
                                }
                                catch (Exception var4_5) {
                                    var12_13 = "JavaCameraView";
                                    var13_15 = new StringBuilder();
                                    var14_16 = "Camera is not available (in use or does not exist): ";
                                    var13_15.append((String)var14_16);
                                    var4_4 /* !! */  = var4_5.getLocalizedMessage();
                                    var13_15.append((String)var4_4 /* !! */ );
                                    var4_4 /* !! */  = var13_15.toString();
                                    Log.e((String)var12_13, (String)var4_4 /* !! */ );
                                }
                                var4_4 /* !! */  = this.D;
                                if (var4_4 /* !! */  == null && var3_3 >= var6_7) {
                                    var4_4 /* !! */  = null;
                                    var6_7 = 0;
                                    var15_17 = null;
                                    var7_8 = 0.0f;
                                    for (var5_6 = 0; var5_6 < (var16_19 = Camera.getNumberOfCameras()); ++var5_6) {
                                        var12_13 = "JavaCameraView";
                                        var13_15 = new StringBuilder();
                                        var14_16 = "Trying to open camera with new open(";
                                        var13_15.append((String)var14_16);
                                        var14_16 = var5_6;
                                        var13_15.append(var14_16);
                                        var14_16 = ")";
                                        var13_15.append((String)var14_16);
                                        var13_15 = var13_15.toString();
                                        Log.d((String)var12_13, (String)var13_15);
                                        try {
                                            var12_13 = Camera.open((int)var5_6);
                                            this.D = var12_13;
                                            var6_7 = var10_11;
                                            var7_8 = var11_12;
                                        }
                                        catch (RuntimeException var12_14) {
                                            var13_15 = "JavaCameraView";
                                            var14_16 = new StringBuilder();
                                            var17_20 = "Camera #";
                                            var14_16.append(var17_20);
                                            var14_16.append(var5_6);
                                            var17_20 = "failed to open: ";
                                            var14_16.append(var17_20);
                                            var12_13 = var12_14.getLocalizedMessage();
                                            var14_16.append((String)var12_13);
                                            var12_13 = var14_16.toString();
                                            Log.e((String)var13_15, (String)var12_13);
                                        }
                                        if (var6_7 == 0) {
                                            continue;
                                        }
                                        break block39;
                                    }
                                }
                                break block39;
                            }
                            if (var3_3 < var6_7) break block39;
                            var6_7 = 98;
                            var7_8 = 1.37E-43f;
                            var16_19 = 99;
                            if (var5_6 != var16_19) break block43;
                            var13_15 = "JavaCameraView";
                            var14_16 = "Trying to open back camera";
                            Log.i((String)var13_15, (String)var14_16);
                            var13_15 = new Camera.CameraInfo();
                            var14_16 = null;
                            for (var18_21 = 0; var18_21 < (var19_22 = Camera.getNumberOfCameras()); ++var18_21) {
                                Camera.getCameraInfo((int)var18_21, (Camera.CameraInfo)var13_15);
                                var19_22 = var13_15.facing;
                                if (var19_22 != 0) {
                                    continue;
                                }
                                ** GOTO lbl-1000
                            }
                            break block40;
                        }
                        if (var5_6 == var6_7) {
                            var13_15 = "JavaCameraView";
                            var14_16 = "Trying to open front camera";
                            Log.i((String)var13_15, (String)var14_16);
                            var13_15 = new Camera.CameraInfo();
                            var14_16 = null;
                            for (var18_21 = 0; var18_21 < (var19_23 = Camera.getNumberOfCameras()); ++var18_21) {
                                Camera.getCameraInfo((int)var18_21, (Camera.CameraInfo)var13_15);
                                var19_23 = var13_15.facing;
                                if (var19_23 != var10_11) continue;
                            }
                        }
                        break block40;
lbl-1000:
                        // 2 sources

                        {
                            var5_6 = var18_21;
                        }
                    }
                    if (var5_6 == var16_19) {
                        var4_4 /* !! */  = "JavaCameraView";
                        var15_17 = "Back camera not found!";
                        Log.e((String)var4_4 /* !! */ , (String)var15_17);
                    } else if (var5_6 == var6_7) {
                        var4_4 /* !! */  = "JavaCameraView";
                        var15_17 = "Front camera not found!";
                        Log.e((String)var4_4 /* !! */ , (String)var15_17);
                    } else {
                        var15_17 = "JavaCameraView";
                        var12_13 = new StringBuilder();
                        var13_15 = "Trying to open camera with new open(";
                        var12_13.append((String)var13_15);
                        var13_15 = var5_6;
                        var12_13.append(var13_15);
                        var13_15 = ")";
                        var12_13.append((String)var13_15);
                        var12_13 = var12_13.toString();
                        Log.d((String)var15_17, (String)var12_13);
                        try {
                            var15_17 = Camera.open((int)var5_6);
                            this.D = var15_17;
                        }
                        catch (RuntimeException var15_18) {
                            var12_13 = "JavaCameraView";
                            var13_15 = new StringBuilder();
                            var14_16 = "Camera #";
                            var13_15.append((String)var14_16);
                            var13_15.append(var5_6);
                            var4_4 /* !! */  = "failed to open: ";
                            var13_15.append((String)var4_4 /* !! */ );
                            var4_4 /* !! */  = var15_18.getLocalizedMessage();
                            var13_15.append((String)var4_4 /* !! */ );
                            var4_4 /* !! */  = var13_15.toString();
                            Log.e((String)var12_13, (String)var4_4 /* !! */ );
                        }
                    }
                }
                if ((var4_4 /* !! */  = this.D) == null) {
                    return false;
                }
                try {
                    var4_4 /* !! */  = var4_4 /* !! */ .getParameters();
                    var15_17 = "JavaCameraView";
                    var12_13 = "getSupportedPreviewSizes()";
                    Log.d((String)var15_17, (String)var12_13);
                    var15_17 = var4_4 /* !! */ .getSupportedPreviewSizes();
                    if (var15_17 == null) return (boolean)var9_10;
                    var12_13 = new l$d();
                    var15_17 = this.c((List)var15_17, (e$f)var12_13, var1_1, var2_2);
                    var12_13 = Build.FINGERPRINT;
                    var13_15 = "generic";
                    var20_24 = var12_13.startsWith((String)var13_15);
                    if (!(var20_24 || (var16_19 = (int)var12_13.startsWith((String)(var13_15 = "unknown"))) != 0 || (var20_24 = (var12_13 = Build.MODEL).contains((CharSequence)(var13_15 = "google_sdk"))) || (var20_24 = var12_13.contains((CharSequence)(var13_15 = "Emulator"))) || (var16_19 = (int)var12_13.contains((CharSequence)(var13_15 = "Android SDK built for x86"))) != 0 || (var16_19 = (int)(var12_13 = Build.MANUFACTURER).contains((CharSequence)(var13_15 = "Genymotion"))) != 0 || (var16_19 = (int)(var12_13 = Build.BRAND).startsWith((String)(var13_15 = "generic"))) != 0 && (var16_19 = (int)(var12_13 = Build.DEVICE).startsWith((String)(var13_15 = "generic"))) != 0 || (var16_19 = (int)(var12_13 = "google_sdk").equals(var13_15 = Build.PRODUCT)) != 0)) {
                        var16_19 = 17;
                        var4_4 /* !! */ .setPreviewFormat(var16_19);
                    } else {
                        var16_19 = 842094169;
                        var4_4 /* !! */ .setPreviewFormat(var16_19);
                    }
                    this.G = var16_19 = var4_4 /* !! */ .getPreviewFormat();
                    var12_13 = "JavaCameraView";
                    var13_15 = new StringBuilder();
                    var14_16 = "Set preview size to ";
                    var13_15.append((String)var14_16);
                    var21_25 = var15_17.a;
                }
                catch (Exception var29_31) {
                    var29_31.printStackTrace();
                    break block41;
                }
                var18_21 = (int)var21_25;
                {
                    var14_16 = var18_21;
                    var13_15.append(var14_16);
                    var14_16 = "x";
                    var13_15.append((String)var14_16);
                    var21_25 = var15_17.b;
                }
                var18_21 = (int)var21_25;
                {
                    var14_16 = var18_21;
                    var13_15.append(var14_16);
                    var13_15 = var13_15.toString();
                    Log.d((String)var12_13, (String)var13_15);
                    var23_26 = var15_17.a;
                }
                var16_19 = (int)var23_26;
                {
                    var25_27 = var15_17.b;
                }
                var6_7 = (int)var25_27;
                {
                    var4_4 /* !! */ .setPreviewSize(var16_19, var6_7);
                    var6_7 = 14;
                    var7_8 = 2.0E-44f;
                    if (var3_3 >= var6_7 && (var6_7 = (int)(var15_17 = Build.MODEL).equals(var12_13 = "GT-I9100")) == 0) {
                        var4_4 /* !! */ .setRecordingHint((boolean)var10_11);
                    }
                    if ((var15_17 = var4_4 /* !! */ .getSupportedFocusModes()) != null && (var6_7 = (int)var15_17.contains(var12_13 = "continuous-video")) != 0) {
                        var15_17 = "continuous-video";
                        var4_4 /* !! */ .setFocusMode((String)var15_17);
                    }
                    var15_17 = this.D;
                    var15_17.setParameters((Camera.Parameters)var4_4 /* !! */ );
                    var4_4 /* !! */  = this.D;
                    var4_4 /* !! */  = var4_4 /* !! */ .getParameters();
                    var15_17 = var4_4 /* !! */ .getPreviewSize();
                    this.f = var6_7 = var15_17.width;
                    var15_17 = var4_4 /* !! */ .getPreviewSize();
                    this.g = var6_7 = var15_17.height;
                    var15_17 = this.getLayoutParams();
                    var6_7 = var15_17.width;
                    if (var6_7 != var8_9) ** GOTO lbl250
                    var15_17 = this.getLayoutParams();
                    var6_7 = var15_17.height;
                    if (var6_7 != var8_9) ** GOTO lbl250
                }
                var27_28 = var2_2;
                {
                    var6_7 = this.g;
                }
                var7_8 = var6_7;
                var27_28 /= var7_8;
                var28_29 = var1_1;
                {
                    var6_7 = this.f;
                }
                var7_8 = var6_7;
                var28_29 /= var7_8;
                {
                    block44: {
                        this.j = var28_29 = Math.min(var27_28, var28_29);
                        break block44;
lbl250:
                        // 2 sources

                        var1_1 = 0;
                        var28_29 = 0.0f;
                        var29_30 /* !! */  = null;
                        this.j = 0.0f;
                    }
                    var29_30 /* !! */  = this.o;
                    if (var29_30 /* !! */  != null) {
                        var2_2 = this.f;
                        var6_7 = this.g;
                        var29_30 /* !! */ .d(var2_2, var6_7);
                    }
                    var1_1 = this.f;
                    var2_2 = this.g;
                    var1_1 *= var2_2;
                }
                {
                    var2_2 = var4_4 /* !! */ .getPreviewFormat();
                    var2_2 = ImageFormat.getBitsPerPixel((int)var2_2);
                    var1_1 *= var2_2;
                }
                {
                    var29_30 /* !! */  = (SurfaceTexture)new byte[var1_1 /= 8];
                    this.y = (byte[])var29_30 /* !! */ ;
                    var30_32 = this.D;
                    var30_32.addCallbackBuffer((byte[])var29_30 /* !! */ );
                    var29_30 /* !! */  = this.D;
                    var29_30 /* !! */ .setPreviewCallbackWithBuffer((Camera.PreviewCallback)this);
                    var1_1 = 2;
                    var28_29 = 2.8E-45f;
                    var30_32 = new Mat[var1_1];
                    this.z = var30_32;
                    var6_7 = this.g;
                    var8_9 = var6_7 / 2;
                    var6_7 += var8_9;
                    var8_9 = this.f;
                    var16_19 = a.j;
                    var4_4 /* !! */  = new Mat(var6_7, var8_9, var16_19);
                    var30_32[0] = var4_4 /* !! */ ;
                    var30_32 = this.z;
                    var6_7 = this.g;
                    var8_9 = var6_7 / 2;
                    var6_7 += var8_9;
                    var8_9 = this.f;
                    var4_4 /* !! */  = new Mat(var6_7, var8_9, var16_19);
                    var30_32[var10_11] = var4_4 /* !! */ ;
                    this.a();
                    var29_30 /* !! */  = new l$c[var1_1];
                    this.E = var29_30 /* !! */ ;
                    var4_4 /* !! */  = this.z;
                    var4_4 /* !! */  = var4_4 /* !! */ [0];
                    var6_7 = this.f;
                    var8_9 = this.g;
                    var30_32 = new l$c(this, (Mat)var4_4 /* !! */ , var6_7, var8_9);
                    var29_30 /* !! */ [0] = var30_32;
                    var29_30 /* !! */  = this.E;
                    var4_4 /* !! */  = this.z;
                    var4_4 /* !! */  = var4_4 /* !! */ [var10_11];
                    var6_7 = this.f;
                    var8_9 = this.g;
                    var30_32 = new l$c(this, (Mat)var4_4 /* !! */ , var6_7, var8_9);
                    var29_30 /* !! */ [var10_11] = var30_32;
                    var1_1 = 11;
                    var28_29 = 1.5E-44f;
                    if (var3_3 >= var1_1) {
                        var2_2 = 10;
                        var27_28 = 1.4E-44f;
                        this.F = var29_30 /* !! */  = new SurfaceTexture(var2_2);
                        var30_32 = this.D;
                        var30_32.setPreviewTexture(var29_30 /* !! */ );
                    } else {
                        var29_30 /* !! */  = this.D;
                        var29_30 /* !! */ .setPreviewDisplay(null);
                    }
                    var29_30 /* !! */  = "JavaCameraView";
                    var30_32 = "startPreview";
                    Log.d((String)var29_30 /* !! */ , (String)var30_32);
                    var29_30 /* !! */  = this.D;
                    var29_30 /* !! */ .startPreview();
                    return (boolean)var10_11;
                }
            }
            return (boolean)var9_10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B() {
        synchronized (this) {
            Object object = this.D;
            int n10 = 0;
            if (object != null) {
                object.stopPreview();
                object = this.D;
                object.setPreviewCallback(null);
                object = this.D;
                object.release();
            }
            this.D = null;
            object = this.z;
            n10 = 1;
            if (object != null) {
                object = object[0];
                ((Mat)object).u0();
                object = this.z;
                object = object[n10];
                ((Mat)object).u0();
            }
            if ((object = this.E) != null) {
                object = object[0];
                ((l$c)object).c();
                object = this.E;
                object = object[n10];
                ((l$c)object).c();
            }
            return;
        }
    }

    public boolean e(int n10, int n11) {
        Thread thread;
        String string2 = J;
        String string3 = "Connecting to camera";
        Log.d((String)string2, (String)string3);
        n10 = (int)(this.A(n10, n11) ? 1 : 0);
        n11 = 0;
        l$b l$b = null;
        if (n10 == 0) {
            return false;
        }
        this.H = false;
        Log.d((String)string2, (String)"Starting processing thread");
        this.C = false;
        l$b = new l$b(this, null);
        this.B = thread = new Thread(l$b);
        thread.start();
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i() {
        Throwable throwable2;
        block9: {
            block10: {
                String string2;
                Object object = J;
                Log.d((String)object, (String)"Disconnecting from camera");
                boolean bl2 = true;
                try {
                    this.C = bl2;
                    object = J;
                    string2 = "Notify thread";
                    Log.d((String)object, (String)string2);
                    synchronized (this) {
                        ((Object)((Object)this)).notify();
                    }
                }
                catch (Throwable throwable2) {
                    break block9;
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    break block10;
                }
                object = J;
                string2 = "Waiting for thread";
                {
                    Log.d((String)object, (String)string2);
                    object = this.B;
                    if (object == null) break block10;
                    ((Thread)object).join();
                }
            }
            this.B = null;
            this.B();
            this.H = false;
            return;
        }
        this.B = null;
        throw throwable2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onPreviewFrame(byte[] object, Camera object2) {
        synchronized (this) {
            boolean bl2;
            object2 = this.z;
            int n10 = this.A;
            object2 = object2[n10];
            n10 = 0;
            object2.i0(0, 0, (byte[])object);
            this.H = bl2 = true;
            ((Object)((Object)this)).notify();
        }
        object = this.D;
        if (object != null) {
            object2 = this.y;
            object.addCallbackBuffer((byte[])object2);
        }
    }
}

