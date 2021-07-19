/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.UseCase$EventCallback;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ReadableConfig;

public interface UseCaseEventConfig
extends ReadableConfig {
    public static final Config$Option OPTION_USE_CASE_EVENT_CALLBACK = Config$Option.create("camerax.core.useCaseEventCallback", UseCase$EventCallback.class);

    default public UseCase$EventCallback getUseCaseEventCallback() {
        Config$Option config$Option = OPTION_USE_CASE_EVENT_CALLBACK;
        return (UseCase$EventCallback)this.retrieveOption(config$Option);
    }

    default public UseCase$EventCallback getUseCaseEventCallback(UseCase$EventCallback useCase$EventCallback) {
        Config$Option config$Option = OPTION_USE_CASE_EVENT_CALLBACK;
        return (UseCase$EventCallback)this.retrieveOption(config$Option, useCase$EventCallback);
    }
}

