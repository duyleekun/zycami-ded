/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice
 *  android.os.Handler
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$CameraDeviceCompatImpl;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class CameraDeviceCompatBaseImpl
implements CameraDeviceCompat$CameraDeviceCompatImpl {
    public final CameraDevice mCameraDevice;
    public final Object mImplParams;

    public CameraDeviceCompatBaseImpl(CameraDevice cameraDevice, Object object) {
        this.mCameraDevice = cameraDevice = (CameraDevice)Preconditions.checkNotNull(cameraDevice);
        this.mImplParams = object;
    }

    private static void checkPhysicalCameraIdValid(CameraDevice object, List object2) {
        boolean bl2;
        object = object.getId();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            String string2 = ((OutputConfigurationCompat)object2.next()).getPhysicalCameraId();
            if (string2 == null || (bl3 = string2.isEmpty())) continue;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Camera ");
            charSequence.append((String)object);
            String string3 = ": Camera doesn't support physicalCameraId ";
            charSequence.append(string3);
            charSequence.append(string2);
            charSequence.append(". Ignoring.");
            string2 = charSequence.toString();
            charSequence = "CameraDeviceCompat";
            Logger.w((String)charSequence, string2);
        }
    }

    public static void checkPreconditions(CameraDevice object, SessionConfigurationCompat object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Preconditions.checkNotNull(((SessionConfigurationCompat)object2).getStateCallback());
        List list = ((SessionConfigurationCompat)object2).getOutputConfigurations();
        if (list != null) {
            if ((object2 = ((SessionConfigurationCompat)object2).getExecutor()) != null) {
                CameraDeviceCompatBaseImpl.checkPhysicalCameraIdValid(object, list);
                return;
            }
            object = new IllegalArgumentException("Invalid executor");
            throw object;
        }
        object = new IllegalArgumentException("Invalid output configurations");
        throw object;
    }

    public static CameraDeviceCompatBaseImpl create(CameraDevice cameraDevice, Handler handler) {
        CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 = new CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21(handler);
        CameraDeviceCompatBaseImpl cameraDeviceCompatBaseImpl = new CameraDeviceCompatBaseImpl(cameraDevice, cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21);
        return cameraDeviceCompatBaseImpl;
    }

    public static List unpackSurfaces(List object) {
        int n10 = object.size();
        ArrayList<Surface> arrayList = new ArrayList<Surface>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Surface surface = ((OutputConfigurationCompat)object.next()).getSurface();
            arrayList.add(surface);
        }
        return arrayList;
    }

    public void createBaseCaptureSession(CameraDevice cameraDevice, List list, CameraCaptureSession.StateCallback stateCallback, Handler handler) {
        cameraDevice.createCaptureSession(list, stateCallback, handler);
    }

    public void createCaptureSession(SessionConfigurationCompat object) {
        CameraDeviceCompatBaseImpl.checkPreconditions(this.mCameraDevice, (SessionConfigurationCompat)object);
        Object object2 = ((SessionConfigurationCompat)object).getInputConfiguration();
        if (object2 == null) {
            int n10;
            int n11 = ((SessionConfigurationCompat)object).getSessionType();
            if (n11 != (n10 = 1)) {
                Object object3 = ((SessionConfigurationCompat)object).getExecutor();
                CameraCaptureSession.StateCallback stateCallback = ((SessionConfigurationCompat)object).getStateCallback();
                object2 = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper((Executor)object3, stateCallback);
                object = CameraDeviceCompatBaseImpl.unpackSurfaces(((SessionConfigurationCompat)object).getOutputConfigurations());
                object3 = (CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21)this.mImplParams;
                stateCallback = this.mCameraDevice;
                object3 = ((CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21)object3).mCompatHandler;
                this.createBaseCaptureSession((CameraDevice)stateCallback, (List)object, (CameraCaptureSession.StateCallback)object2, (Handler)object3);
                return;
            }
            object = new IllegalArgumentException("High speed capture sessions not supported until API 23");
            throw object;
        }
        object = new IllegalArgumentException("Reprocessing sessions not supported until API 23");
        throw object;
    }

    public CameraDevice unwrap() {
        return this.mCameraDevice;
    }
}

