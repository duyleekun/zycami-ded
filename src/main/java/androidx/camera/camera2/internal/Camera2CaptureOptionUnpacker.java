/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.CaptureCallbackContainer;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.CaptureConfig$OptionUnpacker;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.Collection;

public class Camera2CaptureOptionUnpacker
implements CaptureConfig$OptionUnpacker {
    public static final Camera2CaptureOptionUnpacker INSTANCE;

    static {
        Camera2CaptureOptionUnpacker camera2CaptureOptionUnpacker;
        INSTANCE = camera2CaptureOptionUnpacker = new Camera2CaptureOptionUnpacker();
    }

    public void unpack(UseCaseConfig object, CaptureConfig$Builder captureConfig$Builder) {
        Object object2 = object.getDefaultCaptureConfig(null);
        Object object3 = OptionsBundle.emptyBundle();
        CaptureConfig captureConfig = CaptureConfig.defaultEmptyCaptureConfig();
        int n10 = captureConfig.getTemplateType();
        if (object2 != null) {
            n10 = ((CaptureConfig)object2).getTemplateType();
            object3 = ((CaptureConfig)object2).getCameraCaptureCallbacks();
            captureConfig$Builder.addAllCameraCaptureCallbacks((Collection)object3);
            object3 = ((CaptureConfig)object2).getImplementationOptions();
        }
        captureConfig$Builder.setImplementationOptions((Config)object3);
        object2 = new Camera2ImplConfig((Config)object);
        int n11 = ((Camera2ImplConfig)object2).getCaptureRequestTemplate(n10);
        captureConfig$Builder.setTemplateType(n11);
        object = Camera2CaptureCallbacks.createNoOpCallback();
        object = CaptureCallbackContainer.create(((Camera2ImplConfig)object2).getSessionCaptureCallback((CameraCaptureSession.CaptureCallback)object));
        captureConfig$Builder.addCameraCaptureCallback((CameraCaptureCallback)object);
        object = ((Camera2ImplConfig)object2).getCaptureRequestOptions();
        captureConfig$Builder.addImplementationOptions((Config)object);
    }
}

