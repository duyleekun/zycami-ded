/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;

public final class Functions$IdentityFunction
extends Enum
implements Function {
    private static final /* synthetic */ Functions$IdentityFunction[] $VALUES;
    public static final /* enum */ Functions$IdentityFunction INSTANCE;

    static {
        Functions$IdentityFunction functions$IdentityFunction;
        INSTANCE = functions$IdentityFunction = new Functions$IdentityFunction("INSTANCE", 0);
        Functions$IdentityFunction[] functions$IdentityFunctionArray = new Functions$IdentityFunction[]{functions$IdentityFunction};
        $VALUES = functions$IdentityFunctionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Functions$IdentityFunction() {
        void var2_-1;
        void var1_-1;
    }

    public static Functions$IdentityFunction valueOf(String string2) {
        return Enum.valueOf(Functions$IdentityFunction.class, string2);
    }

    public static Functions$IdentityFunction[] values() {
        return (Functions$IdentityFunction[])$VALUES.clone();
    }

    public Object apply(Object object) {
        return object;
    }

    public String toString() {
        return "Functions.identity()";
    }
}

