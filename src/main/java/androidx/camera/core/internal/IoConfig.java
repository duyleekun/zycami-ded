/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

public interface IoConfig
extends ReadableConfig {
    public static final Config$Option OPTION_IO_EXECUTOR = Config$Option.create("camerax.core.io.ioExecutor", Executor.class);

    default public Executor getIoExecutor() {
        Config$Option config$Option = OPTION_IO_EXECUTOR;
        return (Executor)this.retrieveOption(config$Option);
    }

    default public Executor getIoExecutor(Executor executor) {
        Config$Option config$Option = OPTION_IO_EXECUTOR;
        return (Executor)this.retrieveOption(config$Option, executor);
    }
}

