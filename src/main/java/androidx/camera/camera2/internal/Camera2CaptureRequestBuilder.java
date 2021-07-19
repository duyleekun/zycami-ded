/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Camera2CaptureRequestBuilder {
    private static final String TAG = "CaptureRequestBuilder";

    private Camera2CaptureRequestBuilder() {
    }

    private static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder builder, Config config) {
        boolean bl2;
        config = CaptureRequestOptions$Builder.from(config).build();
        Iterator iterator2 = config.listOptions().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Config$Option)iterator2.next();
            Object object2 = (CaptureRequest.Key)((Config$Option)object).getToken();
            object = config.retrieveOption((Config$Option)object);
            try {
                builder.set(object2, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = new StringBuilder();
                String string2 = "CaptureRequest.Key is not supported: ";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(object2);
                object = ((StringBuilder)object).toString();
                object2 = TAG;
                Logger.e((String)object2, (String)object);
            }
        }
    }

    public static CaptureRequest build(CaptureConfig object, CameraDevice cameraDevice, Map object2) {
        Config config;
        int n10 = 0;
        Config config2 = null;
        if (cameraDevice == null) {
            return null;
        }
        Object object3 = ((CaptureConfig)object).getSurfaces();
        object2 = Camera2CaptureRequestBuilder.getConfiguredSurfaces((List)object3, (Map)object2);
        byte by2 = object2.isEmpty();
        if (by2 != 0) {
            return null;
        }
        n10 = ((CaptureConfig)object).getTemplateType();
        cameraDevice = cameraDevice.createCaptureRequest(n10);
        config2 = ((CaptureConfig)object).getImplementationOptions();
        Camera2CaptureRequestBuilder.applyImplementationOptionToCaptureBuilder((CaptureRequest.Builder)cameraDevice, config2);
        config2 = ((CaptureConfig)object).getImplementationOptions();
        object3 = CaptureConfig.OPTION_ROTATION;
        n10 = config2.containsOption((Config$Option)object3) ? 1 : 0;
        if (n10 != 0) {
            config2 = CaptureRequest.JPEG_ORIENTATION;
            config = ((CaptureConfig)object).getImplementationOptions();
            object3 = (Integer)config.retrieveOption((Config$Option)object3);
            cameraDevice.set((CaptureRequest.Key)config2, object3);
        }
        if ((n10 = (int)((config2 = ((CaptureConfig)object).getImplementationOptions()).containsOption((Config$Option)(object3 = CaptureConfig.OPTION_JPEG_QUALITY)) ? 1 : 0)) != 0) {
            config2 = CaptureRequest.JPEG_QUALITY;
            config = ((CaptureConfig)object).getImplementationOptions();
            by2 = ((Integer)config.retrieveOption((Config$Option)object3)).byteValue();
            object3 = by2;
            cameraDevice.set((CaptureRequest.Key)config2, object3);
        }
        object2 = object2.iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            config2 = (Surface)object2.next();
            cameraDevice.addTarget((Surface)config2);
        }
        object = ((CaptureConfig)object).getTagBundle();
        cameraDevice.setTag(object);
        return cameraDevice.build();
    }

    public static CaptureRequest buildWithoutTarget(CaptureConfig object, CameraDevice cameraDevice) {
        if (cameraDevice == null) {
            return null;
        }
        int n10 = ((CaptureConfig)object).getTemplateType();
        cameraDevice = cameraDevice.createCaptureRequest(n10);
        object = ((CaptureConfig)object).getImplementationOptions();
        Camera2CaptureRequestBuilder.applyImplementationOptionToCaptureBuilder((CaptureRequest.Builder)cameraDevice, (Config)object);
        return cameraDevice.build();
    }

    private static List getConfiguredSurfaces(List object, Map map) {
        boolean bl2;
        ArrayList<DeferrableSurface> arrayList = new ArrayList<DeferrableSurface>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            DeferrableSurface deferrableSurface = (DeferrableSurface)object.next();
            if ((deferrableSurface = (Surface)map.get(deferrableSurface)) != null) {
                arrayList.add(deferrableSurface);
                continue;
            }
            object = new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            throw object;
        }
        return arrayList;
    }
}

