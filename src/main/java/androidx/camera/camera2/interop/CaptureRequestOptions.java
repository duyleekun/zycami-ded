/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest$Key
 */
package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;

public class CaptureRequestOptions
implements ReadableConfig {
    private final Config mConfig;

    public CaptureRequestOptions(Config config) {
        this.mConfig = config;
    }

    public Object getCaptureRequestOption(CaptureRequest.Key object) {
        object = Camera2ImplConfig.createCaptureRequestOption(object);
        return this.mConfig.retrieveOption((Config$Option)object, null);
    }

    public Object getCaptureRequestOption(CaptureRequest.Key object, Object object2) {
        object = Camera2ImplConfig.createCaptureRequestOption(object);
        return this.mConfig.retrieveOption((Config$Option)object, object2);
    }

    public Config getConfig() {
        return this.mConfig;
    }
}

