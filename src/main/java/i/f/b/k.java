/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Size
 *  android.view.Surface
 */
package i.f.b;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import i.f.b.e;
import i.f.b.e$f;
import i.f.b.k$b;
import i.f.b.k$c;
import i.f.b.k$e;
import i.f.c.z;
import java.util.Arrays;
import java.util.List;

public class k
extends e {
    private static final String I = "JavaCamera2View";
    public static final /* synthetic */ boolean J;
    private CameraDevice A;
    private CameraCaptureSession B;
    private CaptureRequest.Builder C;
    private String D;
    private Size E;
    private HandlerThread F;
    private Handler G;
    private final CameraDevice.StateCallback H;
    private ImageReader y;
    private int z = 35;

    public k(Context object, int n10) {
        super((Context)object, n10);
        n10 = -1;
        super(n10, n10);
        this.E = object;
        super(this);
        this.H = object;
    }

    public k(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        int n10 = -1;
        super(n10, n10);
        this.E = object;
        super(this);
        this.H = object;
    }

    public static /* synthetic */ Handler A(k k10) {
        return k10.G;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void C() {
        Size size = this.E;
        int n10 = size.getWidth();
        Size size2 = this.E;
        int n11 = size2.getHeight();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createCameraPreviewSession(");
        stringBuilder.append(n10);
        stringBuilder.append("x");
        stringBuilder.append(n11);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        String string3 = I;
        Log.i((String)string3, (String)string2);
        if (n10 < 0) return;
        if (n11 < 0) {
            return;
        }
        try {
            CaptureRequest.Builder builder;
            ImageReader imageReader;
            CameraDevice cameraDevice = this.A;
            if (cameraDevice == null) {
                String string4 = "createCameraPreviewSession: camera isn't opened";
                Log.e((String)string3, (String)string4);
                return;
            }
            CameraCaptureSession cameraCaptureSession = this.B;
            if (cameraCaptureSession != null) {
                String string5 = "createCameraPreviewSession: mCaptureSession is already started";
                Log.e((String)string3, (String)string5);
                return;
            }
            int n12 = this.z;
            int n13 = 2;
            this.y = imageReader = ImageReader.newInstance((int)n10, (int)n11, (int)n12, (int)n13);
            k$b k$b = new k$b(this);
            Handler handler = this.G;
            imageReader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)k$b, handler);
            ImageReader imageReader2 = this.y;
            Surface surface = imageReader2.getSurface();
            CameraDevice cameraDevice2 = this.A;
            n12 = 1;
            this.C = builder = cameraDevice2.createCaptureRequest(n12);
            builder.addTarget(surface);
            CameraDevice cameraDevice3 = this.A;
            Surface[] surfaceArray = new Surface[n12];
            n13 = 0;
            surfaceArray[0] = surface;
            List<Surface> list = Arrays.asList(surfaceArray);
            k$c k$c = new k$c(this);
            n13 = 0;
            cameraDevice3.createCaptureSession(list, (CameraCaptureSession.StateCallback)k$c, null);
            return;
        }
        catch (CameraAccessException cameraAccessException) {
            String string6 = "createCameraPreviewSession";
            Log.e((String)string3, (String)string6, (Throwable)cameraAccessException);
        }
    }

    private void E() {
        HandlerThread handlerThread;
        Log.i((String)I, (String)"startBackgroundThread");
        this.F();
        this.F = handlerThread = new HandlerThread("OpenCVCameraBackground");
        handlerThread.start();
        Looper looper = this.F.getLooper();
        handlerThread = new Handler(looper);
        this.G = handlerThread;
    }

    private void F() {
        String string2 = I;
        String string3 = "stopBackgroundThread";
        Log.i((String)string2, (String)string3);
        HandlerThread handlerThread = this.F;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        handlerThread = this.F;
        handlerThread.join();
        handlerThread = null;
        this.F = null;
        try {
            this.G = null;
        }
        catch (InterruptedException interruptedException) {
            Log.e((String)string2, (String)string3, (Throwable)interruptedException);
        }
    }

    public static /* synthetic */ CameraDevice t(k k10) {
        return k10.A;
    }

    public static /* synthetic */ CameraDevice u(k k10, CameraDevice cameraDevice) {
        k10.A = cameraDevice;
        return cameraDevice;
    }

    public static /* synthetic */ void v(k k10) {
        k10.C();
    }

    public static /* synthetic */ int w(k k10) {
        return k10.z;
    }

    public static /* synthetic */ CameraCaptureSession x(k k10) {
        return k10.B;
    }

    public static /* synthetic */ CameraCaptureSession y(k k10, CameraCaptureSession cameraCaptureSession) {
        k10.B = cameraCaptureSession;
        return cameraCaptureSession;
    }

    public static /* synthetic */ CaptureRequest.Builder z(k k10) {
        return k10.C;
    }

    public boolean B(int n10, int n11) {
        Object object = new StringBuilder();
        object.append("calcPreviewSize: ");
        object.append(n10);
        String string2 = "x";
        object.append(string2);
        object.append(n11);
        object = object.toString();
        String string3 = I;
        Log.i((String)string3, (String)object);
        object = this.D;
        if (object == null) {
            Log.e((String)string3, (String)"Camera isn't initialized!");
            return false;
        }
        object = this.getContext();
        Object object2 = "camera";
        object = (CameraManager)object.getSystemService((String)object2);
        object2 = this.D;
        object = object.getCameraCharacteristics((String)object2);
        object2 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        object = object.get((CameraCharacteristics.Key)object2);
        object = (StreamConfigurationMap)object;
        object2 = ImageReader.class;
        object = object.getOutputSizes((Class)object2);
        object = Arrays.asList(object);
        object2 = new k$e();
        z z10 = this.c((List)object, (e$f)object2, n10, n11);
        CharSequence charSequence = new StringBuilder();
        object = "Selected preview size to ";
        ((StringBuilder)charSequence).append((String)object);
        double d10 = z10.a;
        int n12 = (int)d10;
        object = n12;
        ((StringBuilder)charSequence).append(object);
        ((StringBuilder)charSequence).append(string2);
        double d11 = z10.b;
        n12 = (int)d11;
        object = n12;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.i((String)string3, (String)charSequence);
        charSequence = this.E;
        n11 = charSequence.getWidth();
        d11 = n11;
        d10 = z10.a;
        n11 = (int)(d11 == d10 ? 0 : (d11 > d10 ? 1 : -1));
        if (n11 == 0) {
            charSequence = this.E;
            n11 = charSequence.getHeight();
            d11 = n11;
            d10 = z10.b;
            n11 = (int)(d11 == d10 ? 0 : (d11 > d10 ? 1 : -1));
            if (n11 == 0) {
                return false;
            }
        }
        d11 = z10.a;
        n12 = (int)d11;
        d10 = z10.b;
        n10 = (int)d10;
        charSequence = new Size(n12, n10);
        try {
            this.E = charSequence;
            return true;
        }
        catch (SecurityException securityException) {
            charSequence = "calcPreviewSize - Security Exception";
            Log.e((String)string3, (String)charSequence, (Throwable)securityException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            charSequence = "calcPreviewSize - Illegal Argument Exception";
            Log.e((String)string3, (String)charSequence, (Throwable)illegalArgumentException);
        }
        catch (CameraAccessException cameraAccessException) {
            charSequence = "calcPreviewSize - Camera Access Exception";
            Log.e((String)string3, (String)charSequence, (Throwable)cameraAccessException);
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean D() {
        String string2 = I;
        Log.i((String)string2, (String)"initializeCamera");
        CameraManager cameraManager = (CameraManager)this.getContext().getSystemService("camera");
        try {
            String string3;
            CharSequence charSequence;
            int n10;
            int n11;
            int n12;
            Object object;
            block12: {
                block11: {
                    object = cameraManager.getCameraIdList();
                    n12 = ((String[])object).length;
                    if (n12 == 0) {
                        String string4 = "Error: camera isn't detected.";
                        Log.e((String)string2, (String)string4);
                        return false;
                    }
                    n12 = this.l;
                    n11 = -1;
                    n10 = 1;
                    if (n12 != n11) break block11;
                    charSequence = object[0];
                    this.D = charSequence;
                    break block12;
                }
                n12 = ((String[])object).length;
                string3 = null;
                for (n11 = 0; n11 < n12; ++n11) {
                    String string5;
                    block14: {
                        Object object2;
                        int n13;
                        int n14;
                        Object object3;
                        block13: {
                            string5 = object[n11];
                            object3 = cameraManager.getCameraCharacteristics(string5);
                            n14 = this.l;
                            n13 = 99;
                            if (n14 != n13) break block13;
                            object2 = CameraCharacteristics.LENS_FACING;
                            object2 = object3.get((CameraCharacteristics.Key)object2);
                            n14 = (Integer)(object2 = (Integer)object2);
                            if (n14 == n10) break block14;
                        }
                        if ((n14 = this.l) != (n13 = 98)) continue;
                        object2 = CameraCharacteristics.LENS_FACING;
                        object3 = object3.get((CameraCharacteristics.Key)object2);
                        int n15 = (Integer)(object3 = (Integer)object3);
                        if (n15 != 0) continue;
                    }
                    this.D = string5;
                    break;
                }
            }
            charSequence = this.D;
            if (charSequence != null) {
                object = new StringBuilder();
                charSequence = "Opening camera: ";
                ((StringBuilder)object).append((String)charSequence);
                charSequence = this.D;
                ((StringBuilder)object).append((String)charSequence);
                object = ((StringBuilder)object).toString();
                Log.i((String)string2, (String)object);
                object = this.D;
                charSequence = this.H;
                string3 = this.G;
                cameraManager.openCamera((String)object, (CameraDevice.StateCallback)charSequence, (Handler)string3);
                return n10 != 0;
            }
            charSequence = new StringBuilder();
            string3 = "Trying to open camera with the value (";
            ((StringBuilder)charSequence).append(string3);
            n11 = this.l;
            ((StringBuilder)charSequence).append(n11);
            string3 = ")";
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.i((String)string2, (String)charSequence);
            n12 = this.l;
            n11 = ((Object)object).length;
            if (n12 < n11) {
                this.D = object = object[n12];
                charSequence = this.H;
                string3 = this.G;
                cameraManager.openCamera((String)object, (CameraDevice.StateCallback)charSequence, (Handler)string3);
                return n10 != 0;
            }
            int n16 = 2;
            CameraAccessException cameraAccessException = new CameraAccessException(n16);
            throw cameraAccessException;
        }
        catch (SecurityException securityException) {
            String string6 = "OpenCamera - Security Exception";
            Log.e((String)string2, (String)string6, (Throwable)securityException);
            return false;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string7 = "OpenCamera - Illegal Argument Exception";
            Log.e((String)string2, (String)string7, (Throwable)illegalArgumentException);
            return false;
        }
        catch (CameraAccessException cameraAccessException) {
            String string8 = "OpenCamera - Camera Access Exception";
            Log.e((String)string2, (String)string8, (Throwable)cameraAccessException);
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean e(int var1_1, int var2_2) {
        block20: {
            block19: {
                var3_3 /* !! */  = new StringBuilder();
                var3_3 /* !! */ .append("setCameraPreviewSize(");
                var3_3 /* !! */ .append(var1_1);
                var3_3 /* !! */ .append("x");
                var3_3 /* !! */ .append(var2_2);
                var3_3 /* !! */ .append(")");
                var3_3 /* !! */  = var3_3 /* !! */ .toString();
                var4_4 = "JavaCamera2View";
                Log.i((String)var4_4, (String)var3_3 /* !! */ );
                this.E();
                this.D();
                try {
                    var5_5 = this.B(var1_1, var2_2);
                }
                catch (RuntimeException var12_13) {
                    var13_14 = new RuntimeException("Interrupted while setCameraPreviewSize.", var12_13);
                    throw var13_14;
                }
                var6_6 = this.E;
                var7_7 = var6_6.getWidth();
                this.f = var7_7;
                var6_6 = this.E;
                var7_7 = var6_6.getHeight();
                this.g = var7_7;
                var6_6 = this.getLayoutParams();
                var7_7 = var6_6.width;
                var8_8 = -1;
                if (var7_7 != var8_8) break block19;
                var6_6 = this.getLayoutParams();
                var7_7 = var6_6.height;
                if (var7_7 != var8_8) break block19;
                var9_9 = var2_2;
                var7_7 = this.g;
                var10_10 = var7_7;
                var9_9 /= var10_10;
                var11_11 = var1_1;
                var7_7 = this.f;
                var10_10 = var7_7;
                var11_11 /= var10_10;
                var11_11 = Math.min(var9_9, var11_11);
                this.j = var11_11;
                ** GOTO lbl66
            }
            var1_1 = 0;
            var11_11 = 0.0f;
            var12_12 /* !! */  = null;
            this.j = 0.0f;
lbl66:
            // 2 sources

            this.a();
            if (!var5_5) break block20;
            var12_12 /* !! */  = this.B;
            if (var12_12 /* !! */  == null) ** GOTO lbl83
            var12_12 /* !! */  = "closing existing previewSession";
            Log.d((String)var4_4, (String)var12_12 /* !! */ );
            var12_12 /* !! */  = this.B;
            var12_12 /* !! */ .close();
            var1_1 = 0;
            var11_11 = 0.0f;
            var12_12 /* !! */  = null;
            this.B = null;
lbl83:
            // 2 sources

            this.C();
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i() {
        String string2 = I;
        String string3 = "closeCamera";
        Log.i((String)string2, (String)string3);
        try {
            string2 = this.A;
            string3 = null;
            this.A = null;
            CameraCaptureSession cameraCaptureSession = this.B;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.B = null;
            }
            if (string2 != null) {
                string2.close();
            }
            if ((string2 = this.y) == null) return;
            string2.close();
            this.y = null;
            return;
        }
        finally {
            this.F();
        }
    }
}

