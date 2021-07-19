/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
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
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Log
 *  android.util.Size
 *  android.view.Surface
 */
package i.f.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import i.f.b.c$b;
import i.f.b.f;
import i.f.b.g;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class c
extends f {
    public final String I;
    private CameraDevice J;
    private CameraCaptureSession K;
    private CaptureRequest.Builder L;
    private String M;
    private Size N;
    private HandlerThread O;
    private Handler P;
    private Semaphore Q;
    private final CameraDevice.StateCallback R;

    public c(g object) {
        super((g)((Object)object));
        this.I = "Camera2Renderer";
        int n10 = -1;
        super(n10, n10);
        this.N = object;
        super(1);
        this.Q = object;
        super(this);
        this.R = object;
    }

    public static /* synthetic */ CameraCaptureSession A(c c10, CameraCaptureSession cameraCaptureSession) {
        c10.K = cameraCaptureSession;
        return cameraCaptureSession;
    }

    public static /* synthetic */ CaptureRequest.Builder B(c c10) {
        return c10.L;
    }

    public static /* synthetic */ Handler C(c c10) {
        return c10.P;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void E() {
        Object object = this.N;
        int n10 = object.getWidth();
        Object object2 = this.N;
        int n11 = object2.getHeight();
        Object object3 = new StringBuilder();
        object3.append("createCameraPreviewSession(");
        object3.append(n10);
        object3.append("x");
        object3.append(n11);
        object3.append(")");
        object3 = object3.toString();
        String string2 = "Camera2Renderer";
        Log.i((String)string2, (String)object3);
        if (n10 < 0) return;
        if (n11 < 0) {
            return;
        }
        try {
            object3 = this.Q;
            object3.acquire();
            object3 = this.J;
            if (object3 == null) {
                object = this.Q;
                ((Semaphore)object).release();
                object = "createCameraPreviewSession: camera isn't opened";
                Log.e((String)string2, (String)object);
                return;
            }
            object3 = this.K;
            if (object3 != null) {
                object = this.Q;
                ((Semaphore)object).release();
                object = "createCameraPreviewSession: mCaptureSession is already started";
                Log.e((String)string2, (String)object);
                return;
            }
            object3 = this.B;
            if (object3 == null) {
                object = this.Q;
                ((Semaphore)object).release();
                object = "createCameraPreviewSession: preview SurfaceTexture is null";
                Log.e((String)string2, (String)object);
                return;
            }
            object3.setDefaultBufferSize(n10, n11);
            object2 = this.B;
            object = new Surface((SurfaceTexture)object2);
            object2 = this.J;
            int n12 = 1;
            object2 = object2.createCaptureRequest(n12);
            this.L = object2;
            object2.addTarget((Surface)object);
            object2 = this.J;
            object3 = new Surface[n12];
            Handler handler = null;
            object3[0] = object;
            object = Arrays.asList(object3);
            object3 = new c$b(this);
            handler = this.P;
            object2.createCaptureSession((List)object, (CameraCaptureSession.StateCallback)object3, handler);
            return;
        }
        catch (InterruptedException interruptedException) {
            object3 = "Interrupted while createCameraPreviewSession";
            object2 = new RuntimeException((String)object3, interruptedException);
            throw object2;
        }
        catch (CameraAccessException cameraAccessException) {
        }
        object = "createCameraPreviewSession";
        Log.e((String)string2, (String)object);
    }

    private void F() {
        HandlerThread handlerThread;
        Log.i((String)"Camera2Renderer", (String)"startBackgroundThread");
        this.G();
        this.O = handlerThread = new HandlerThread("CameraBackground");
        handlerThread.start();
        Looper looper = this.O.getLooper();
        handlerThread = new Handler(looper);
        this.P = handlerThread;
    }

    private void G() {
        String string2 = "Camera2Renderer";
        String string3 = "stopBackgroundThread";
        Log.i((String)string2, (String)string3);
        HandlerThread handlerThread = this.O;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        handlerThread = this.O;
        handlerThread.join();
        handlerThread = null;
        this.O = null;
        try {
            this.P = null;
        }
        catch (InterruptedException interruptedException) {
            Log.e((String)string2, (String)string3);
        }
    }

    public static /* synthetic */ CameraDevice w(c c10, CameraDevice cameraDevice) {
        c10.J = cameraDevice;
        return cameraDevice;
    }

    public static /* synthetic */ Semaphore x(c c10) {
        return c10.Q;
    }

    public static /* synthetic */ void y(c c10) {
        c10.E();
    }

    public static /* synthetic */ CameraCaptureSession z(c c10) {
        return c10.K;
    }

    public boolean D(int n10, int n11) {
        block39: {
            block37: {
                CharSequence charSequence;
                int n12;
                int n13;
                String string2;
                block38: {
                    c c10 = this;
                    int n14 = n10;
                    int n15 = n11;
                    Size[] sizeArray = new StringBuilder();
                    sizeArray.append("cacPreviewSize: ");
                    sizeArray.append(n10);
                    String string3 = "x";
                    sizeArray.append(string3);
                    sizeArray.append(n11);
                    sizeArray = sizeArray.toString();
                    string2 = "Camera2Renderer";
                    Log.i((String)string2, (String)sizeArray);
                    sizeArray = this.M;
                    if (sizeArray == null) {
                        Log.e((String)string2, (String)"Camera isn't initialized!");
                        return false;
                    }
                    sizeArray = this.H.getContext();
                    String string4 = "camera";
                    sizeArray = (CameraManager)sizeArray.getSystemService(string4);
                    string4 = this.M;
                    sizeArray = sizeArray.getCameraCharacteristics(string4);
                    string4 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
                    sizeArray = sizeArray.get((CameraCharacteristics.Key)string4);
                    sizeArray = (StreamConfigurationMap)sizeArray;
                    float f10 = n10;
                    float f11 = n11;
                    f10 /= f11;
                    Class<SurfaceTexture> clazz = SurfaceTexture.class;
                    sizeArray = sizeArray.getOutputSizes(clazz);
                    int n16 = sizeArray.length;
                    n13 = 0;
                    n12 = 0;
                    for (int i10 = 0; i10 < n16; ++i10) {
                        Size size = sizeArray[i10];
                        int n17 = size.getWidth();
                        int n18 = size.getHeight();
                        CharSequence charSequence2 = new StringBuilder();
                        String string5 = "trying size: ";
                        charSequence2.append(string5);
                        charSequence2.append(n17);
                        charSequence2.append(string3);
                        charSequence2.append(n18);
                        charSequence2 = charSequence2.toString();
                        Log.d((String)string2, (String)charSequence2);
                        if (n14 < n17 || n15 < n18 || n13 > n17 || n12 > n18) continue;
                        float f12 = n17;
                        float f13 = n18;
                        f12 /= f13;
                        f12 = f10 - f12;
                        f12 = Math.abs(f12);
                        double d10 = f12;
                        double d11 = 0.2;
                        double d12 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
                        if (d12 >= 0) continue;
                        n12 = n18;
                        n13 = n17;
                    }
                    charSequence = new StringBuilder();
                    String string6 = "best size: ";
                    ((StringBuilder)charSequence).append(string6);
                    ((StringBuilder)charSequence).append(n13);
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(n12);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.i((String)string2, (String)charSequence);
                    if (n13 == 0 || n12 == 0) break block37;
                    charSequence = c10.N;
                    n14 = charSequence.getWidth();
                    if (n14 != n13) break block38;
                    charSequence = c10.N;
                    n14 = charSequence.getHeight();
                    if (n14 == n12) break block37;
                }
                charSequence = new Size(n13, n12);
                try {
                    c10.N = charSequence;
                    return true;
                }
                catch (SecurityException securityException) {
                    charSequence = "cacPreviewSize - Security Exception";
                    Log.e((String)string2, (String)charSequence);
                    break block39;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    charSequence = "cacPreviewSize - Illegal Argument Exception";
                    Log.e((String)string2, (String)charSequence);
                    break block39;
                }
                catch (CameraAccessException cameraAccessException) {
                    charSequence = "cacPreviewSize - Camera Access Exception";
                    Log.e((String)string2, (String)charSequence);
                }
            }
            return false;
        }
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Throwable throwable2222222;
        Object object = "Camera2Renderer";
        Object object2 = "closeCamera";
        Log.i((String)object, (String)object2);
        object = this.Q;
        ((Semaphore)object).acquire();
        object = this.K;
        object2 = null;
        if (object != null) {
            object.close();
            this.K = null;
        }
        if ((object = this.J) != null) {
            object.close();
            this.J = null;
        }
        this.Q.release();
        return;
        {
            catch (Throwable throwable2222222) {
            }
            catch (InterruptedException interruptedException) {}
            {
                String string2 = "Interrupted while trying to lock camera closing.";
                object2 = new RuntimeException(string2, interruptedException);
                throw object2;
            }
        }
        this.Q.release();
        throw throwable2222222;
    }

    public void f() {
        Log.d((String)"Camera2Renderer", (String)"doStart");
        this.F();
        super.f();
    }

    public void g() {
        Log.d((String)"Camera2Renderer", (String)"doStop");
        super.g();
        this.G();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void q(int n10) {
        String string2 = "Camera2Renderer";
        Log.i((String)string2, (String)"openCamera");
        Context context = this.H.getContext();
        CameraDevice.StateCallback stateCallback = "camera";
        CameraManager cameraManager = (CameraManager)context.getSystemService((String)stateCallback);
        try {
            Object object;
            TimeUnit timeUnit;
            block12: {
                block11: {
                    stateCallback = cameraManager.getCameraIdList();
                    int n11 = ((String[])stateCallback).length;
                    if (n11 == 0) {
                        String string3 = "Error: camera isn't detected.";
                        Log.e((String)string2, (String)string3);
                        return;
                    }
                    n11 = -1;
                    timeUnit = null;
                    if (n10 != n11) break block11;
                    object = stateCallback[0];
                    this.M = object;
                    break block12;
                }
                for (String string4 : stateCallback) {
                    block14: {
                        Object object2;
                        int n12;
                        Object object3;
                        block13: {
                            int n13;
                            object3 = cameraManager.getCameraCharacteristics(string4);
                            n12 = 99;
                            if (n10 != n12) break block13;
                            object2 = CameraCharacteristics.LENS_FACING;
                            object2 = object3.get((CameraCharacteristics.Key)object2);
                            n12 = (Integer)(object2 = (Integer)object2);
                            if (n12 == (n13 = 1)) break block14;
                        }
                        if (n10 != (n12 = 98)) continue;
                        object2 = CameraCharacteristics.LENS_FACING;
                        object3 = object3.get((CameraCharacteristics.Key)object2);
                        int n14 = (Integer)(object3 = (Integer)object3);
                        if (n14 != 0) continue;
                    }
                    this.M = string4;
                    break;
                }
            }
            object = this.M;
            if (object == null) return;
            object = this.Q;
            long l10 = 2500L;
            timeUnit = TimeUnit.MILLISECONDS;
            n10 = (int)(((Semaphore)object).tryAcquire(l10, timeUnit) ? 1 : 0);
            if (n10 != 0) {
                object = new StringBuilder();
                stateCallback = "Opening camera: ";
                ((StringBuilder)object).append((String)stateCallback);
                stateCallback = this.M;
                ((StringBuilder)object).append((String)stateCallback);
                object = ((StringBuilder)object).toString();
                Log.i((String)string2, (String)object);
                object = this.M;
                stateCallback = this.R;
                Handler handler = this.P;
                cameraManager.openCamera((String)object, stateCallback, handler);
                return;
            }
            String string5 = "Time out waiting to lock camera opening.";
            object = new RuntimeException(string5);
            throw object;
        }
        catch (SecurityException securityException) {
            String string6 = "OpenCamera - Security Exception";
            Log.e((String)string2, (String)string6);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string7 = "OpenCamera - Illegal Argument Exception";
            Log.e((String)string2, (String)string7);
            return;
        }
        catch (CameraAccessException cameraAccessException) {
            String string8 = "OpenCamera - Camera Access Exception";
            Log.e((String)string2, (String)string8);
            return;
        }
        catch (InterruptedException interruptedException) {}
        String string9 = "OpenCamera - Interrupted Exception";
        Log.e((String)string2, (String)string9);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void s(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setCameraPreviewSize(");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(")");
        object = ((StringBuilder)object).toString();
        String string2 = "Camera2Renderer";
        Log.i((String)string2, (String)object);
        int n12 = this.y;
        if (n12 > 0 && n12 < n10) {
            n10 = n12;
        }
        if ((n12 = this.z) > 0 && n12 < n11) {
            n11 = n12;
        }
        try {
            object = this.Q;
            ((Semaphore)object).acquire();
            n10 = (int)(this.D(n10, n11) ? 1 : 0);
            Size size = this.N;
            this.u = n11 = size.getWidth();
            size = this.N;
            this.v = n11 = size.getHeight();
            if (n10 == 0) {
                Semaphore semaphore = this.Q;
                semaphore.release();
                return;
            }
            Object object2 = this.K;
            if (object2 != null) {
                object2 = "closing existing previewSession";
                Log.d((String)string2, (String)object2);
                object2 = this.K;
                object2.close();
                n10 = 0;
                object2 = null;
                this.K = null;
            }
            object2 = this.Q;
            ((Semaphore)object2).release();
            this.E();
            return;
        }
        catch (InterruptedException interruptedException) {
            this.Q.release();
            RuntimeException runtimeException = new RuntimeException("Interrupted while setCameraPreviewSize.", interruptedException);
            throw runtimeException;
        }
    }
}

