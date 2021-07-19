/*
 * Decompiled with CFR 0.151.
 */
package bleshadow.dagger.internal;

import bleshadow.dagger.internal.MembersInjectors$NoOpMembersInjector;
import c.a.g;

public final class MembersInjectors {
    private MembersInjectors() {
    }

    public static g a() {
        return MembersInjectors$NoOpMembersInjector.INSTANCE;
    }
}

