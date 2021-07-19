/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2SessionOptionUnpacker;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;

public class MeteringRepeatingSession$MeteringRepeatingConfig
implements UseCaseConfig {
    private final Config mConfig;

    public MeteringRepeatingSession$MeteringRepeatingConfig() {
        MutableOptionsBundle mutableOptionsBundle = MutableOptionsBundle.create();
        Config$Option config$Option = UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER;
        Camera2SessionOptionUnpacker camera2SessionOptionUnpacker = new Camera2SessionOptionUnpacker();
        mutableOptionsBundle.insertOption(config$Option, camera2SessionOptionUnpacker);
        this.mConfig = mutableOptionsBundle;
    }

    public Config getConfig() {
        return this.mConfig;
    }
}

