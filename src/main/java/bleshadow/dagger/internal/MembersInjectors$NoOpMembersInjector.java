/*
 * Decompiled with CFR 0.151.
 */
package bleshadow.dagger.internal;

import c.a.g;
import c.a.l.l;

public final class MembersInjectors$NoOpMembersInjector
extends Enum
implements g {
    public static final /* enum */ MembersInjectors$NoOpMembersInjector INSTANCE;
    private static final /* synthetic */ MembersInjectors$NoOpMembersInjector[] a;

    static {
        MembersInjectors$NoOpMembersInjector membersInjectors$NoOpMembersInjector;
        INSTANCE = membersInjectors$NoOpMembersInjector = new MembersInjectors$NoOpMembersInjector("INSTANCE", 0);
        MembersInjectors$NoOpMembersInjector[] membersInjectors$NoOpMembersInjectorArray = new MembersInjectors$NoOpMembersInjector[]{membersInjectors$NoOpMembersInjector};
        a = membersInjectors$NoOpMembersInjectorArray;
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
        return (MembersInjectors$NoOpMembersInjector[])a.clone();
    }

    public void injectMembers(Object object) {
        l.b(object, "Cannot inject members into a null reference");
    }
}

