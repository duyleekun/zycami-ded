/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest$Key
 */
package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import b.a.a.e.j;

public final class CaptureRequestOptions$Builder
implements ExtendableBuilder {
    private final MutableOptionsBundle mMutableOptionsBundle;

    public CaptureRequestOptions$Builder() {
        MutableOptionsBundle mutableOptionsBundle;
        this.mMutableOptionsBundle = mutableOptionsBundle = MutableOptionsBundle.create();
    }

    public static /* synthetic */ boolean a(CaptureRequestOptions$Builder object, Config object2, Config$Option config$Option) {
        object = ((CaptureRequestOptions$Builder)object).getMutableConfig();
        Config$OptionPriority config$OptionPriority = object2.getOptionPriority(config$Option);
        object2 = object2.retrieveOption(config$Option);
        object.insertOption(config$Option, config$OptionPriority, object2);
        return true;
    }

    public static CaptureRequestOptions$Builder from(Config config) {
        CaptureRequestOptions$Builder captureRequestOptions$Builder = new CaptureRequestOptions$Builder();
        j j10 = new j(captureRequestOptions$Builder, config);
        config.findOptions("camera2.captureRequest.option.", j10);
        return captureRequestOptions$Builder;
    }

    public CaptureRequestOptions build() {
        OptionsBundle optionsBundle = OptionsBundle.from(this.mMutableOptionsBundle);
        CaptureRequestOptions captureRequestOptions = new CaptureRequestOptions(optionsBundle);
        return captureRequestOptions;
    }

    public CaptureRequestOptions$Builder clearCaptureRequestOption(CaptureRequest.Key object) {
        object = Camera2ImplConfig.createCaptureRequestOption(object);
        this.mMutableOptionsBundle.removeOption((Config$Option)object);
        return this;
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableOptionsBundle;
    }

    public CaptureRequestOptions$Builder setCaptureRequestOption(CaptureRequest.Key object, Object object2) {
        object = Camera2ImplConfig.createCaptureRequestOption(object);
        this.mMutableOptionsBundle.insertOption((Config$Option)object, object2);
        return this;
    }
}

