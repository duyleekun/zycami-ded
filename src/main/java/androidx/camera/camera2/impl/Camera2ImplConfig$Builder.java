/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest$Key
 */
package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Iterator;

public final class Camera2ImplConfig$Builder
implements ExtendableBuilder {
    private final MutableOptionsBundle mMutableOptionsBundle;

    public Camera2ImplConfig$Builder() {
        MutableOptionsBundle mutableOptionsBundle;
        this.mMutableOptionsBundle = mutableOptionsBundle = MutableOptionsBundle.create();
    }

    public Camera2ImplConfig build() {
        OptionsBundle optionsBundle = OptionsBundle.from(this.mMutableOptionsBundle);
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(optionsBundle);
        return camera2ImplConfig;
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableOptionsBundle;
    }

    public Camera2ImplConfig$Builder insertAllOptions(Config config) {
        boolean bl2;
        Iterator iterator2 = config.listOptions().iterator();
        while (bl2 = iterator2.hasNext()) {
            Config$Option config$Option = (Config$Option)iterator2.next();
            MutableOptionsBundle mutableOptionsBundle = this.mMutableOptionsBundle;
            Object object = config.retrieveOption(config$Option);
            mutableOptionsBundle.insertOption(config$Option, object);
        }
        return this;
    }

    public Camera2ImplConfig$Builder setCaptureRequestOption(CaptureRequest.Key object, Object object2) {
        object = Camera2ImplConfig.createCaptureRequestOption(object);
        this.mMutableOptionsBundle.insertOption((Config$Option)object, object2);
        return this;
    }

    public Camera2ImplConfig$Builder setCaptureRequestOptionWithPriority(CaptureRequest.Key object, Object object2, Config$OptionPriority config$OptionPriority) {
        object = Camera2ImplConfig.createCaptureRequestOption(object);
        this.mMutableOptionsBundle.insertOption((Config$Option)object, config$OptionPriority, object2);
        return this;
    }
}

