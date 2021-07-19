/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionMatcher;
import androidx.camera.core.impl.Config$OptionPriority;
import java.util.Set;

public interface ReadableConfig
extends Config {
    default public boolean containsOption(Config$Option config$Option) {
        return this.getConfig().containsOption(config$Option);
    }

    default public void findOptions(String string2, Config$OptionMatcher config$OptionMatcher) {
        this.getConfig().findOptions(string2, config$OptionMatcher);
    }

    public Config getConfig();

    default public Config$OptionPriority getOptionPriority(Config$Option config$Option) {
        return this.getConfig().getOptionPriority(config$Option);
    }

    default public Set getPriorities(Config$Option config$Option) {
        return this.getConfig().getPriorities(config$Option);
    }

    default public Set listOptions() {
        return this.getConfig().listOptions();
    }

    default public Object retrieveOption(Config$Option config$Option) {
        return this.getConfig().retrieveOption(config$Option);
    }

    default public Object retrieveOption(Config$Option config$Option, Object object) {
        return this.getConfig().retrieveOption(config$Option, object);
    }

    default public Object retrieveOptionWithPriority(Config$Option config$Option, Config$OptionPriority config$OptionPriority) {
        return this.getConfig().retrieveOptionWithPriority(config$Option, config$OptionPriority);
    }
}

