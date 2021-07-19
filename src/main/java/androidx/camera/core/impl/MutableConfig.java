/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionPriority;

public interface MutableConfig
extends Config {
    public void insertOption(Config$Option var1, Config$OptionPriority var2, Object var3);

    public void insertOption(Config$Option var1, Object var2);

    public Object removeOption(Config$Option var1);
}

