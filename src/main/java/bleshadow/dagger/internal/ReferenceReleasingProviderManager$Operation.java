/*
 * Decompiled with CFR 0.151.
 */
package bleshadow.dagger.internal;

import bleshadow.dagger.internal.ReferenceReleasingProviderManager$Operation$1;
import bleshadow.dagger.internal.ReferenceReleasingProviderManager$Operation$2;
import bleshadow.dagger.internal.ReferenceReleasingProviderManager$a;
import c.a.l.n;

public abstract class ReferenceReleasingProviderManager$Operation
extends Enum {
    public static final /* enum */ ReferenceReleasingProviderManager$Operation RELEASE;
    public static final /* enum */ ReferenceReleasingProviderManager$Operation RESTORE;
    private static final /* synthetic */ ReferenceReleasingProviderManager$Operation[] a;

    static {
        ReferenceReleasingProviderManager$Operation$1 referenceReleasingProviderManager$Operation$1 = new ReferenceReleasingProviderManager$Operation$1();
        RELEASE = referenceReleasingProviderManager$Operation$1;
        int n10 = 1;
        ReferenceReleasingProviderManager$Operation$2 referenceReleasingProviderManager$Operation$2 = new ReferenceReleasingProviderManager$Operation$2();
        RESTORE = referenceReleasingProviderManager$Operation$2;
        ReferenceReleasingProviderManager$Operation[] referenceReleasingProviderManager$OperationArray = new ReferenceReleasingProviderManager$Operation[2];
        referenceReleasingProviderManager$OperationArray[0] = referenceReleasingProviderManager$Operation$1;
        referenceReleasingProviderManager$OperationArray[n10] = referenceReleasingProviderManager$Operation$2;
        a = referenceReleasingProviderManager$OperationArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ReferenceReleasingProviderManager$Operation() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ ReferenceReleasingProviderManager$Operation(ReferenceReleasingProviderManager.a a10) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static ReferenceReleasingProviderManager$Operation valueOf(String string2) {
        return Enum.valueOf(ReferenceReleasingProviderManager$Operation.class, string2);
    }

    public static ReferenceReleasingProviderManager$Operation[] values() {
        return (ReferenceReleasingProviderManager$Operation[])a.clone();
    }

    public abstract void execute(n var1);
}

