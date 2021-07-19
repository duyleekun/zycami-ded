/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;

public final class ConfigGetParameterHandler$$Lambda$1
implements Runnable {
    private final BiConsumer arg$1;
    private final String arg$2;
    private final ConfigContainer arg$3;

    private ConfigGetParameterHandler$$Lambda$1(BiConsumer biConsumer, String string2, ConfigContainer configContainer) {
        this.arg$1 = biConsumer;
        this.arg$2 = string2;
        this.arg$3 = configContainer;
    }

    public static Runnable lambdaFactory$(BiConsumer biConsumer, String string2, ConfigContainer configContainer) {
        ConfigGetParameterHandler$$Lambda$1 configGetParameterHandler$$Lambda$1 = new ConfigGetParameterHandler$$Lambda$1(biConsumer, string2, configContainer);
        return configGetParameterHandler$$Lambda$1;
    }

    public void run() {
        BiConsumer biConsumer = this.arg$1;
        String string2 = this.arg$2;
        ConfigContainer configContainer = this.arg$3;
        ConfigGetParameterHandler.lambda$callListeners$0(biConsumer, string2, configContainer);
    }
}

