/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;

public interface TargetConfig
extends ReadableConfig {
    public static final Config$Option OPTION_TARGET_CLASS;
    public static final Config$Option OPTION_TARGET_NAME;

    static {
        OPTION_TARGET_NAME = Config$Option.create("camerax.core.target.name", String.class);
        OPTION_TARGET_CLASS = Config$Option.create("camerax.core.target.class", Class.class);
    }

    default public Class getTargetClass() {
        Config$Option config$Option = OPTION_TARGET_CLASS;
        return (Class)this.retrieveOption(config$Option);
    }

    default public Class getTargetClass(Class clazz) {
        Config$Option config$Option = OPTION_TARGET_CLASS;
        return (Class)this.retrieveOption(config$Option, clazz);
    }

    default public String getTargetName() {
        Config$Option config$Option = OPTION_TARGET_NAME;
        return (String)this.retrieveOption(config$Option);
    }

    default public String getTargetName(String string2) {
        Config$Option config$Option = OPTION_TARGET_NAME;
        return (String)this.retrieveOption(config$Option, string2);
    }
}

