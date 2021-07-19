/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

public interface ThreadConfig
extends ReadableConfig {
    public static final Config$Option OPTION_BACKGROUND_EXECUTOR = Config$Option.create("camerax.core.thread.backgroundExecutor", Executor.class);

    default public Executor getBackgroundExecutor() {
        Config$Option config$Option = OPTION_BACKGROUND_EXECUTOR;
        return (Executor)this.retrieveOption(config$Option);
    }

    default public Executor getBackgroundExecutor(Executor executor) {
        Config$Option config$Option = OPTION_BACKGROUND_EXECUTOR;
        return (Executor)this.retrieveOption(config$Option, executor);
    }
}

