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
 *  android.hardware.Camera$PictureCallback
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$ShutterCallback
 *  android.hardware.Camera$Size
 *  android.util.Log
 *  android.view.SurfaceHolder
 *  android.view.WindowManager
 */
package com.google.android.gms.vision;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.CameraSource$PictureCallback;
import com.google.android.gms.vision.CameraSource$ShutterCallback;
import com.google.android.gms.vision.CameraSource$zza;
import com.google.android.gms.vision.CameraSource$zzb;
import com.google.android.gms.vision.CameraSource$zzc;
import com.google.android.gms.vision.CameraSource$zzd;
import com.google.android.gms.vision.CameraSource$zze;
import com.google.android.gms.vision.zza;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CameraSource {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    private int facing;
    private int rotation;
    private Context zzg;
    private final Object zzh;
    private Camera zzi;
    private Size zzj;
    private float zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private String zzo;
    private SurfaceTexture zzp;
    private boolean zzq;
    private Thread zzr;
    private CameraSource$zza zzs;
    private Map zzt;

    private CameraSource() {
        HashMap hashMap = new HashMap();
        this.zzh = hashMap;
        this.facing = 0;
        this.zzk = 30.0f;
        this.zzl = 1024;
        this.zzm = 768;
        this.zzn = false;
        this.zzt = hashMap = new HashMap();
    }

    public /* synthetic */ CameraSource(zza zza2) {
        this();
    }

    public static /* synthetic */ float zza(CameraSource cameraSource, float f10) {
        cameraSource.zzk = f10;
        return f10;
    }

    public static /* synthetic */ int zza(CameraSource cameraSource, int n10) {
        cameraSource.zzl = n10;
        return n10;
    }

    public static /* synthetic */ Context zza(CameraSource cameraSource, Context context) {
        cameraSource.zzg = context;
        return context;
    }

    public static /* synthetic */ CameraSource$zza zza(CameraSource cameraSource, CameraSource$zza cameraSource$zza) {
        cameraSource.zzs = cameraSource$zza;
        return cameraSource$zza;
    }

    public static /* synthetic */ Object zza(CameraSource cameraSource) {
        return cameraSource.zzh;
    }

    public static /* synthetic */ String zza(CameraSource cameraSource, String string2) {
        cameraSource.zzo = string2;
        return string2;
    }

    public static /* synthetic */ boolean zza(CameraSource cameraSource, boolean bl2) {
        cameraSource.zzn = bl2;
        return bl2;
    }

    private final byte[] zza(Size object) {
        byte[] byArray;
        int n10 = ImageFormat.getBitsPerPixel((int)17);
        int n11 = ((Size)object).getHeight();
        int n12 = ((Size)object).getWidth();
        long l10 = n11 * n12 * n10;
        double d10 = l10;
        double d11 = 8.0;
        n12 = (int)(d10 = Math.ceil(d10 / d11)) + 1;
        object = new byte[n12];
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])object);
        n11 = (int)(byteBuffer.hasArray() ? 1 : 0);
        if (n11 != 0 && (byArray = byteBuffer.array()) == object) {
            this.zzt.put(object, byteBuffer);
            return object;
        }
        object = new IllegalStateException("Failed to create valid buffer for camera source.");
        throw object;
    }

    public static /* synthetic */ int zzb(CameraSource cameraSource, int n10) {
        cameraSource.zzm = n10;
        return n10;
    }

    public static /* synthetic */ Camera zzb(CameraSource cameraSource) {
        return cameraSource.zzi;
    }

    public static /* synthetic */ int zzc(CameraSource cameraSource, int n10) {
        cameraSource.facing = n10;
        return n10;
    }

    private final Camera zzc() {
        block18: {
            Object object;
            block19: {
                block20: {
                    Size size;
                    Object object2;
                    Object object3;
                    Object object4;
                    Object object5;
                    Object object6;
                    String string2;
                    Object object7;
                    String string3;
                    Object object8;
                    CameraSource cameraSource;
                    block25: {
                        block21: {
                            block22: {
                                block23: {
                                    block24: {
                                        int n10;
                                        Object object9;
                                        int n11;
                                        Object object10;
                                        Object object11;
                                        float f10;
                                        float f11;
                                        int n12;
                                        Camera.Size size2;
                                        boolean bl2;
                                        float f12;
                                        Object object12;
                                        block17: {
                                            cameraSource = this;
                                            int n13 = this.facing;
                                            object8 = new Camera.CameraInfo();
                                            string3 = null;
                                            object7 = 0;
                                            string2 = null;
                                            while (true) {
                                                object12 = Camera.getNumberOfCameras();
                                                object6 = -1;
                                                f12 = 0.0f / 0.0f;
                                                if (object7 >= object12) break;
                                                Camera.getCameraInfo((int)object7, (Camera.CameraInfo)object8);
                                                object12 = object8.facing;
                                                if (object12 != n13) {
                                                    ++object7;
                                                    continue;
                                                }
                                                break block17;
                                                break;
                                            }
                                            object7 = object6;
                                        }
                                        if (object7 == object6) break block18;
                                        object = Camera.open((int)object7);
                                        object5 = cameraSource.zzl;
                                        object12 = cameraSource.zzm;
                                        object4 = object.getParameters();
                                        Object object13 = object4.getSupportedPreviewSizes();
                                        object4 = object4.getSupportedPictureSizes();
                                        Object object14 = new ArrayList();
                                        object3 = object13.iterator();
                                        block1: while (bl2 = object3.hasNext()) {
                                            size2 = (Camera.Size)object3.next();
                                            n12 = size2.width;
                                            f11 = n12;
                                            object2 = size2.height;
                                            f10 = object2;
                                            f11 /= f10;
                                            object11 = object4.iterator();
                                            while ((object10 = object11.hasNext()) != 0) {
                                                Camera.Size size3 = (Camera.Size)object11.next();
                                                float f13 = size3.width;
                                                float f14 = size3.height;
                                                f13 /= f14;
                                                f13 = Math.abs(f11 - f13);
                                                n11 = 1008981770;
                                                f14 = 0.01f;
                                                float f15 = f13 - f14;
                                                Object object15 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                                                if (object15 >= 0) continue;
                                                object9 = new CameraSource$zze(size2, size3);
                                                object14.add(object9);
                                                continue block1;
                                            }
                                        }
                                        object6 = object14.size();
                                        object3 = "CameraSource";
                                        bl2 = false;
                                        size2 = null;
                                        if (object6 == 0) {
                                            Log.w((String)object3, (String)"No preview sizes have a corresponding same-aspect-ratio picture size");
                                            object4 = object13.iterator();
                                            while ((n10 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                                                object13 = (Camera.Size)object4.next();
                                                object9 = new CameraSource$zze((Camera.Size)object13, null);
                                                object14.add(object9);
                                            }
                                        }
                                        object6 = ((ArrayList)object14).size();
                                        n10 = -1 >>> 1;
                                        object9 = null;
                                        f11 = 0.0f;
                                        object10 = n10;
                                        object2 = 0;
                                        object11 = null;
                                        f10 = 0.0f;
                                        for (n12 = 0; n12 < object6; ++n12) {
                                            Object object16 = ((ArrayList)object14).get(n12);
                                            object16 = (CameraSource$zze)object16;
                                            Size size4 = ((CameraSource$zze)object16).zzd();
                                            int n14 = Math.abs(size4.getWidth() - object5);
                                            n11 = Math.abs(size4.getHeight() - object12);
                                            if ((n11 = n14 + n11) >= object10) continue;
                                            object11 = object16;
                                            object10 = n11;
                                        }
                                        if (object11 == null) break block19;
                                        object8 = ((CameraSource$zze)object11).zze();
                                        cameraSource.zzj = size = ((CameraSource$zze)object11).zzd();
                                        float f16 = cameraSource.zzk;
                                        object6 = 1148846080;
                                        f12 = 1000.0f;
                                        object12 = (int)(f16 *= f12);
                                        object4 = object.getParameters().getSupportedPreviewFpsRange().iterator();
                                        object14 = null;
                                        while (true) {
                                            n12 = (int)(object4.hasNext() ? 1 : 0);
                                            object2 = 1;
                                            f10 = Float.MIN_VALUE;
                                            if (n12 == 0) break;
                                            object9 = (int[])object4.next();
                                            object10 = object9[0];
                                            object10 = object12 - object10;
                                            object2 = object9[object2];
                                            object2 = object12 - object2;
                                            object10 = Math.abs(object10);
                                            if ((object10 += (object2 = Math.abs(object2))) >= n10) continue;
                                            object14 = object9;
                                            n10 = object10;
                                        }
                                        if (object14 == null) break block20;
                                        size = object.getParameters();
                                        if (object8 != null) {
                                            object6 = object8.getWidth();
                                            object5 = object8.getHeight();
                                            size.setPictureSize((int)object6, (int)object5);
                                        }
                                        object5 = cameraSource.zzj.getWidth();
                                        object6 = cameraSource.zzj.getHeight();
                                        size.setPreviewSize((int)object5, (int)object6);
                                        object5 = object14[0];
                                        object6 = object14[object2];
                                        size.setPreviewFpsRange((int)object5, (int)object6);
                                        size.setPreviewFormat(17);
                                        object8 = cameraSource.zzg;
                                        object4 = "window";
                                        object8 = ((WindowManager)object8.getSystemService((String)object4)).getDefaultDisplay();
                                        object5 = object8.getRotation();
                                        if (object5 == 0) break block21;
                                        if (object5 == object2) break block22;
                                        object6 = 2;
                                        f12 = 2.8E-45f;
                                        if (object5 == object6) break block23;
                                        object6 = 3;
                                        f12 = 4.2E-45f;
                                        if (object5 == object6) break block24;
                                        object6 = 31;
                                        f12 = 4.3E-44f;
                                        object13 = new StringBuilder((int)object6);
                                        object4 = "Bad rotation value: ";
                                        ((StringBuilder)object13).append((String)object4);
                                        ((StringBuilder)object13).append((int)object5);
                                        object8 = ((StringBuilder)object13).toString();
                                        Log.e((String)object3, (String)object8);
                                        break block21;
                                    }
                                    object5 = 270;
                                    break block25;
                                }
                                object5 = 180;
                                break block25;
                            }
                            object5 = 90;
                            break block25;
                        }
                        object5 = 0;
                        object8 = null;
                    }
                    object4 = new Camera.CameraInfo();
                    Camera.getCameraInfo((int)object7, (Camera.CameraInfo)object4);
                    object7 = ((Camera.CameraInfo)object4).facing;
                    if (object7 == object2) {
                        object7 = (((Camera.CameraInfo)object4).orientation + object5) % 360;
                        object5 = (360 - object7) % 360;
                    } else {
                        object5 = object7 = (((Camera.CameraInfo)object4).orientation - object5 + 360) % 360;
                    }
                    cameraSource.rotation = object6 = object7 / 90;
                    object.setDisplayOrientation(object5);
                    size.setRotation((int)object7);
                    object8 = cameraSource.zzo;
                    if (object8 != null) {
                        object8 = size.getSupportedFocusModes();
                        object5 = object8.contains(string2 = cameraSource.zzo);
                        if (object5 != 0) {
                            object8 = cameraSource.zzo;
                            size.setFocusMode((String)object8);
                        } else {
                            object8 = new Object[object2];
                            string2 = cameraSource.zzo;
                            object8[0] = string2;
                            string3 = "FocusMode %s is not supported on this device.";
                            object8 = String.format(string3, (Object[])object8);
                            Log.w((String)object3, (String)object8);
                            cameraSource.zzo = null;
                        }
                    }
                    if ((object8 = cameraSource.zzo) == null && (object5 = (Object)cameraSource.zzn) != 0) {
                        object8 = size.getSupportedFocusModes();
                        object5 = object8.contains(string3 = "continuous-video");
                        if (object5 != 0) {
                            size.setFocusMode(string3);
                            cameraSource.zzo = string3;
                        } else {
                            object8 = "Camera auto focus is not supported on this device.";
                            Log.i((String)object3, (String)object8);
                        }
                    }
                    object.setParameters((Camera.Parameters)size);
                    object8 = new CameraSource$zzb(cameraSource, null);
                    object.setPreviewCallbackWithBuffer((Camera.PreviewCallback)object8);
                    object8 = cameraSource.zzj;
                    object8 = cameraSource.zza((Size)object8);
                    object.addCallbackBuffer((byte[])object8);
                    object8 = cameraSource.zzj;
                    object8 = cameraSource.zza((Size)object8);
                    object.addCallbackBuffer((byte[])object8);
                    object8 = cameraSource.zzj;
                    object8 = cameraSource.zza((Size)object8);
                    object.addCallbackBuffer((byte[])object8);
                    object8 = cameraSource.zzj;
                    object8 = cameraSource.zza((Size)object8);
                    object.addCallbackBuffer((byte[])object8);
                    return object;
                }
                object = new IOException("Could not find suitable preview frames per second range.");
                throw object;
            }
            object = new IOException("Could not find suitable preview size.");
            throw object;
        }
        IOException iOException = new IOException("Could not find requested camera.");
        throw iOException;
    }

    public static /* synthetic */ CameraSource$zza zzc(CameraSource cameraSource) {
        return cameraSource.zzs;
    }

    public static /* synthetic */ Map zzd(CameraSource cameraSource) {
        return cameraSource.zzt;
    }

    public static /* synthetic */ int zze(CameraSource cameraSource) {
        return cameraSource.rotation;
    }

    public static /* synthetic */ Size zzf(CameraSource cameraSource) {
        return cameraSource.zzj;
    }

    public int getCameraFacing() {
        return this.facing;
    }

    public Size getPreviewSize() {
        return this.zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        Object object = this.zzh;
        synchronized (object) {
            this.stop();
            CameraSource$zza cameraSource$zza = this.zzs;
            cameraSource$zza.release();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraSource start() {
        Object object = this.zzh;
        synchronized (object) {
            boolean bl2;
            Object object2 = this.zzi;
            if (object2 != null) {
                return this;
            }
            object2 = this.zzc();
            this.zzi = object2;
            int n10 = 100;
            object2 = new SurfaceTexture(n10);
            this.zzp = object2;
            Object object3 = this.zzi;
            object3.setPreviewTexture((SurfaceTexture)object2);
            this.zzq = bl2 = true;
            object3 = this.zzi;
            object3.startPreview();
            Object object4 = this.zzs;
            object3 = new Thread((Runnable)object4);
            this.zzr = object3;
            object4 = "gms.vision.CameraSource";
            ((Thread)object3).setName((String)object4);
            object3 = this.zzs;
            ((CameraSource$zza)object3).setActive(bl2);
            object2 = this.zzr;
            ((Thread)object2).start();
            return this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraSource start(SurfaceHolder object) {
        Object object2 = this.zzh;
        synchronized (object2) {
            Object object3 = this.zzi;
            if (object3 != null) {
                return this;
            }
            this.zzi = object3 = this.zzc();
            object3.setPreviewDisplay((SurfaceHolder)object);
            object = this.zzi;
            object.startPreview();
            object3 = this.zzs;
            object = new Thread((Runnable)object3);
            this.zzr = object;
            object = this.zzs;
            boolean bl2 = true;
            ((CameraSource$zza)object).setActive(bl2);
            object = this.zzr;
            ((Thread)object).start();
            object = null;
            this.zzq = false;
            return this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stop() {
        Object object = this.zzh;
        synchronized (object) {
            String string2;
            Object object2 = this.zzs;
            ((CameraSource$zza)object2).setActive(false);
            object2 = this.zzr;
            if (object2 != null) {
                try {
                    ((Thread)object2).join();
                }
                catch (InterruptedException interruptedException) {
                    object2 = "CameraSource";
                    string2 = "Frame processing thread interrupted on release.";
                    Log.d((String)object2, (String)string2);
                }
                this.zzr = null;
            }
            if ((object2 = this.zzi) != null) {
                object2.stopPreview();
                object2 = this.zzi;
                object2.setPreviewCallbackWithBuffer(null);
                try {
                    boolean bl2 = this.zzq;
                    if (bl2) {
                        object2 = this.zzi;
                        object2.setPreviewTexture(null);
                    } else {
                        object2 = this.zzi;
                        object2.setPreviewDisplay(null);
                    }
                }
                catch (Exception exception) {
                    string2 = "CameraSource";
                    object2 = String.valueOf(exception);
                    String string3 = String.valueOf(object2);
                    int n10 = string3.length() + 32;
                    StringBuilder stringBuilder = new StringBuilder(n10);
                    string3 = "Failed to clear camera preview: ";
                    stringBuilder.append(string3);
                    stringBuilder.append((String)object2);
                    object2 = stringBuilder.toString();
                    Log.e((String)string2, (String)object2);
                }
                object2 = this.zzi;
                object2.release();
                this.zzi = null;
            }
            object2 = this.zzt;
            object2.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void takePicture(CameraSource$ShutterCallback object, CameraSource$PictureCallback cameraSource$PictureCallback) {
        Object object2 = this.zzh;
        synchronized (object2) {
            Object object3 = this.zzi;
            if (object3 != null) {
                object3 = new CameraSource$zzd(null);
                CameraSource$zzd.zza((CameraSource$zzd)object3, (CameraSource$ShutterCallback)object);
                object = new CameraSource$zzc(this, null);
                CameraSource$zzc.zza((CameraSource$zzc)object, cameraSource$PictureCallback);
                cameraSource$PictureCallback = this.zzi;
                cameraSource$PictureCallback.takePicture((Camera.ShutterCallback)object3, null, null, (Camera.PictureCallback)object);
            }
            return;
        }
    }
}

