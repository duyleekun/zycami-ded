/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionMatcher;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Iterator;
import java.util.Set;

public interface Config {
    public static boolean hasConflict(Config$OptionPriority config$OptionPriority, Config$OptionPriority config$OptionPriority2) {
        Config$OptionPriority config$OptionPriority3 = Config$OptionPriority.ALWAYS_OVERRIDE;
        boolean bl2 = true;
        if (config$OptionPriority == config$OptionPriority3 && config$OptionPriority2 == config$OptionPriority3) {
            return bl2;
        }
        config$OptionPriority3 = Config$OptionPriority.REQUIRED;
        if (config$OptionPriority == config$OptionPriority3 && config$OptionPriority2 == config$OptionPriority3) {
            return bl2;
        }
        return false;
    }

    public static Config mergeConfigs(Config config, Config config2) {
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        config2 = config2 != null ? MutableOptionsBundle.from(config2) : MutableOptionsBundle.create();
        if (config != null) {
            boolean bl2;
            Iterator iterator2 = config.listOptions().iterator();
            while (bl2 = iterator2.hasNext()) {
                Config$Option config$Option = (Config$Option)iterator2.next();
                Config$OptionPriority config$OptionPriority = config.getOptionPriority(config$Option);
                Object object = config.retrieveOption(config$Option);
                ((MutableOptionsBundle)config2).insertOption(config$Option, config$OptionPriority, object);
            }
        }
        return OptionsBundle.from(config2);
    }

    public boolean containsOption(Config$Option var1);

    public void findOptions(String var1, Config$OptionMatcher var2);

    public Config$OptionPriority getOptionPriority(Config$Option var1);

    public Set getPriorities(Config$Option var1);

    public Set listOptions();

    public Object retrieveOption(Config$Option var1);

    public Object retrieveOption(Config$Option var1, Object var2);

    public Object retrieveOptionWithPriority(Config$Option var1, Config$OptionPriority var2);
}

