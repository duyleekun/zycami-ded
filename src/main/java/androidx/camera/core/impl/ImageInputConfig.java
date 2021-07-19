/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;

public interface ImageInputConfig
extends ReadableConfig {
    public static final Config$Option OPTION_INPUT_FORMAT;

    static {
        Class<Integer> clazz = Integer.TYPE;
        OPTION_INPUT_FORMAT = Config$Option.create("camerax.core.imageInput.inputFormat", clazz);
    }

    default public int getInputFormat() {
        Config$Option config$Option = OPTION_INPUT_FORMAT;
        return (Integer)this.retrieveOption(config$Option);
    }
}

