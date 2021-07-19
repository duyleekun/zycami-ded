/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.MembersInjector;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class MembersInjectors$NoOpMembersInjector
extends Enum
implements MembersInjector {
    private static final /* synthetic */ MembersInjectors$NoOpMembersInjector[] $VALUES;
    public static final /* enum */ MembersInjectors$NoOpMembersInjector INSTANCE;

    static {
        MembersInjectors$NoOpMembersInjector membersInjectors$NoOpMembersInjector;
        INSTANCE = membersInjectors$NoOpMembersInjector = new MembersInjectors$NoOpMembersInjector("INSTANCE", 0);
        MembersInjectors$NoOpMembersInjector[] membersInjectors$NoOpMembersInjectorArray = new MembersInjectors$NoOpMembersInjector[]{membersInjectors$NoOpMembersInjector};
        $VALUES = membersInjectors$NoOpMembersInjectorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MembersInjectors$NoOpMembersInjector() {
        void var2_-1;
        void var1_-1;
    }

    public static MembersInjectors$NoOpMembersInjector valueOf(String string2) {
        return Enum.valueOf(MembersInjectors$NoOpMembersInjector.class, string2);
    }

    public static MembersInjectors$NoOpMembersInjector[] values() {
        return (MembersInjectors$NoOpMembersInjector[])$VALUES.clone();
    }

    public void injectMembers(Object object) {
        Preconditions.checkNotNull(object, "Cannot inject members into a null reference");
    }
}

