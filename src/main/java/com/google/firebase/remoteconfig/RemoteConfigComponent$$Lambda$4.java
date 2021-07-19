/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;

public final class RemoteConfigComponent$$Lambda$4
implements BiConsumer {
    private final Personalization arg$1;

    private RemoteConfigComponent$$Lambda$4(Personalization personalization) {
        this.arg$1 = personalization;
    }

    public static BiConsumer lambdaFactory$(Personalization personalization) {
        RemoteConfigComponent$$Lambda$4 remoteConfigComponent$$Lambda$4 = new RemoteConfigComponent$$Lambda$4(personalization);
        return remoteConfigComponent$$Lambda$4;
    }

    public void accept(Object object, Object object2) {
        Personalization personalization = this.arg$1;
        object = (String)object;
        object2 = (ConfigContainer)object2;
        personalization.logArmActive((String)object, (ConfigContainer)object2);
    }
}

