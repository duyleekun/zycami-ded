/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.MembersInjector;
import com.google.android.datatransport.runtime.dagger.internal.MembersInjectors$NoOpMembersInjector;

public final class MembersInjectors {
    private MembersInjectors() {
    }

    public static MembersInjector noOp() {
        return MembersInjectors$NoOpMembersInjector.INSTANCE;
    }
}

