/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.os.SystemClock
 *  android.util.Log
 *  android.util.Size
 *  android.util.SizeF
 *  androidx.camera.core.CameraX$LensFacing
 *  androidx.camera.core.Preview$OnPreviewOutputUpdateListener
 *  androidx.camera.core.Preview$PreviewOutput
 *  androidx.camera.core.PreviewConfig
 *  androidx.camera.core.PreviewConfig$Builder
 */
package com.google.mediapipe.components;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.SystemClock;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.core.CameraX;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;
import androidx.camera.core.UseCase;
import androidx.lifecycle.LifecycleOwner;
import com.google.mediapipe.components.CameraHelper;
import com.google.mediapipe.components.CameraHelper$CameraFacing;
import d.h.b.a.a;
import java.util.Arrays;

public class CameraXPreviewHelper
extends CameraHelper {
    private static final int CLOCK_OFFSET_CALIBRATION_ATTEMPTS = 3;
    private static final String TAG = "CameraXPreviewHelper";
    private static final Size TARGET_SIZE;
    private CameraCharacteristics cameraCharacteristics = null;
    private int cameraTimestampSource = 0;
    private float focalLengthPixels = Float.MIN_VALUE;
    private int frameRotation;
    private Size frameSize;
    private Preview preview;

    static {
        Size size;
        TARGET_SIZE = size = new Size(1280, 720);
    }

    private /* synthetic */ void a(CameraHelper$CameraFacing object, Activity activity, Preview.PreviewOutput previewOutput) {
        float f10;
        int n10;
        Size size;
        Object object2 = previewOutput.getTextureSize();
        int n11 = object2.equals((Object)(size = this.frameSize));
        if (n11 == 0) {
            this.frameSize = object2 = previewOutput.getTextureSize();
            this.frameRotation = n11 = previewOutput.getRotationDegrees();
            object2 = this.frameSize;
            n11 = object2.getWidth();
            if (n11 == 0 || (n11 = (object2 = this.frameSize).getHeight()) == 0) {
                Log.d((String)TAG, (String)"Invalid frameSize.");
                return;
            }
        }
        if (object == (object2 = CameraHelper$CameraFacing.FRONT)) {
            n10 = 0;
            f10 = 0.0f;
            object = null;
        } else {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        }
        object = n10;
        object = CameraXPreviewHelper.getCameraCharacteristics(activity, (Integer)object);
        this.cameraCharacteristics = object;
        if (object != null) {
            activity = CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE;
            object = (Integer)object.get((CameraCharacteristics.Key)activity);
            this.cameraTimestampSource = n10 = ((Integer)object).intValue();
            this.focalLengthPixels = f10 = this.calculateFocalLengthInPixels();
        }
        if ((object = this.onCameraStartedListener) != null) {
            activity = previewOutput.getSurfaceTexture();
            object.onCameraStarted((SurfaceTexture)activity);
        }
    }

    private float calculateFocalLengthInPixels() {
        CameraCharacteristics cameraCharacteristics = this.cameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS;
        float f10 = ((float[])cameraCharacteristics.get(key))[0];
        key = this.cameraCharacteristics;
        CameraCharacteristics.Key key2 = CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE;
        float f11 = ((SizeF)key.get(key2)).getWidth();
        return (float)this.frameSize.getWidth() * f10 / f11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static CameraCharacteristics getCameraCharacteristics(Activity activity, Integer object) {
        Object object2 = "camera";
        activity = (CameraManager)activity.getSystemService((String)object2);
        object2 = activity.getCameraIdList();
        object2 = Arrays.asList(object2);
        try {
            object2 = object2.iterator();
        }
        catch (CameraAccessException cameraAccessException) {
            object = new StringBuilder();
            object2 = "Accessing camera ID info got error: ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append((Object)cameraAccessException);
            String string2 = ((StringBuilder)object).toString();
            object = TAG;
            Log.e((String)object, (String)string2);
        }
        while (true) {
            boolean bl2 = object2.hasNext();
            if (!bl2) return null;
            Object object3 = object2.next();
            object3 = (String)object3;
            object3 = activity.getCameraCharacteristics(object3);
            Object object4 = CameraCharacteristics.LENS_FACING;
            object4 = object3.get((CameraCharacteristics.Key)object4);
            object4 = (Integer)object4;
            if (object4 == null) continue;
            boolean bl3 = ((Integer)object4).equals(object);
            if (bl3) return object3;
            continue;
            break;
        }
        return null;
    }

    private static long getOffsetFromRealtimeTimestampSource() {
        int n10;
        long l10 = Long.MAX_VALUE;
        long l11 = l10;
        for (int i10 = 0; i10 < (n10 = 3); ++i10) {
            long l12 = System.nanoTime();
            long l13 = SystemClock.elapsedRealtimeNanos();
            long l14 = System.nanoTime();
            long l15 = l14 - l12;
            long l16 = l15 - l11;
            Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object >= 0) continue;
            l12 += l14;
            l10 = l12 = l12 / (long)2 - l13;
            l11 = l15;
        }
        return l10;
    }

    private static long getOffsetFromUnknownTimestampSource() {
        return 0L;
    }

    private Size getOptimalViewSize(Size size) {
        Size[] sizeArray = this.cameraCharacteristics;
        if (sizeArray != null) {
            int n10;
            Object object = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
            sizeArray = (StreamConfigurationMap)sizeArray.get(object);
            object = SurfaceTexture.class;
            sizeArray = sizeArray.getOutputSizes((Class)object);
            float f10 = 1000.0f;
            int n11 = size.getWidth();
            float f11 = n11;
            float f12 = size.getHeight();
            f11 /= f12;
            int n12 = sizeArray.length;
            int n13 = n10 = -1;
            int n14 = n10;
            for (int i10 = 0; i10 < n12; ++i10) {
                Size size2;
                int n15;
                Size size3 = sizeArray[i10];
                int n16 = size3.getWidth();
                float f13 = n16;
                float f14 = size3.getHeight();
                float f15 = (f13 = Math.abs(f13 / f14 - f11)) - f10;
                Object object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                if (object2 > 0 || (n13 != n10 || n14 != n10) && ((object2 = (Object)size3.getWidth()) > n13 || (object2 = (Object)size3.getWidth()) < (n15 = (size2 = this.frameSize).getWidth()) || (object2 = (Object)size3.getHeight()) > n14 || (object2 = (Object)size3.getHeight()) < (n15 = (size2 = this.frameSize).getHeight()))) continue;
                n13 = size3.getWidth();
                n14 = size3.getHeight();
                f10 = f13;
            }
            if (n13 != n10 && n14 != n10) {
                size = new Size(n13, n14);
                return size;
            }
        }
        return null;
    }

    public Size computeDisplaySizeFromViewSize(Size size) {
        Size size2;
        if (size != null && (size2 = this.frameSize) != null) {
            if ((size = this.getOptimalViewSize(size)) == null) {
                size = this.frameSize;
            }
            return size;
        }
        Log.d((String)TAG, (String)"viewSize or frameSize is null.");
        return null;
    }

    public float getFocalLengthPixels() {
        return this.focalLengthPixels;
    }

    public Size getFrameSize() {
        return this.frameSize;
    }

    public long getTimeOffsetToMonoClockNanos() {
        int n10 = this.cameraTimestampSource;
        int n11 = 1;
        if (n10 == n11) {
            return CameraXPreviewHelper.getOffsetFromRealtimeTimestampSource();
        }
        return CameraXPreviewHelper.getOffsetFromUnknownTimestampSource();
    }

    /*
     * WARNING - void declaration
     */
    public boolean isCameraRotated() {
        void var1_4;
        int bl2 = this.frameRotation % 180;
        int n10 = 90;
        if (bl2 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_4;
    }

    public void startCamera(Activity activity, CameraHelper$CameraFacing cameraHelper$CameraFacing, SurfaceTexture surfaceTexture) {
        Size size = TARGET_SIZE;
        this.startCamera(activity, cameraHelper$CameraFacing, surfaceTexture, size);
    }

    public void startCamera(Activity object, CameraHelper$CameraFacing useCaseArray, SurfaceTexture object2, Size object3) {
        object2 = CameraHelper$CameraFacing.FRONT;
        object2 = useCaseArray == object2 ? CameraX.LensFacing.FRONT : CameraX.LensFacing.BACK;
        PreviewConfig.Builder builder = new PreviewConfig.Builder();
        object2 = builder.setLensFacing((CameraX.LensFacing)object2).setTargetResolution(object3).build();
        object3 = new Preview((PreviewConfig)object2);
        this.preview = object3;
        object2 = new a(this, (CameraHelper$CameraFacing)useCaseArray, (Activity)object);
        object3.setOnPreviewOutputUpdateListener((Preview.OnPreviewOutputUpdateListener)object2);
        object = (LifecycleOwner)object;
        useCaseArray = new UseCase[1];
        object3 = this.preview;
        useCaseArray[0] = object3;
        CameraX.bindToLifecycle((LifecycleOwner)object, (UseCase[])useCaseArray);
    }
}

