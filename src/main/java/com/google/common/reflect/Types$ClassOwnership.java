/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Types$1;
import com.google.common.reflect.Types$ClassOwnership$1;
import com.google.common.reflect.Types$ClassOwnership$1LocalClass;
import com.google.common.reflect.Types$ClassOwnership$2;
import com.google.common.reflect.Types$ClassOwnership$3;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Types$ClassOwnership
extends Enum {
    private static final /* synthetic */ Types$ClassOwnership[] $VALUES;
    public static final Types$ClassOwnership JVM_BEHAVIOR;
    public static final /* enum */ Types$ClassOwnership LOCAL_CLASS_HAS_NO_OWNER;
    public static final /* enum */ Types$ClassOwnership OWNED_BY_ENCLOSING_CLASS;

    static {
        Types$ClassOwnership$1 types$ClassOwnership$1 = new Types$ClassOwnership$1();
        OWNED_BY_ENCLOSING_CLASS = types$ClassOwnership$1;
        int n10 = 1;
        Types$ClassOwnership$2 types$ClassOwnership$2 = new Types$ClassOwnership$2();
        LOCAL_CLASS_HAS_NO_OWNER = types$ClassOwnership$2;
        Types$ClassOwnership[] types$ClassOwnershipArray = new Types$ClassOwnership[2];
        types$ClassOwnershipArray[0] = types$ClassOwnership$1;
        types$ClassOwnershipArray[n10] = types$ClassOwnership$2;
        $VALUES = types$ClassOwnershipArray;
        JVM_BEHAVIOR = Types$ClassOwnership.detectJvmBehavior();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Types$ClassOwnership() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ Types$ClassOwnership(Types.1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    private static Types$ClassOwnership detectJvmBehavior() {
        new Types$ClassOwnership$3();
        Object object = (ParameterizedType)Types$ClassOwnership$3.class.getGenericSuperclass();
        for (Types$ClassOwnership types$ClassOwnership : Types$ClassOwnership.values()) {
            Type type;
            Class clazz = types$ClassOwnership.getOwnerType(Types$ClassOwnership$1LocalClass.class);
            if (clazz != (type = object.getOwnerType())) continue;
            return types$ClassOwnership;
        }
        object = new AssertionError();
        throw object;
    }

    public static Types$ClassOwnership valueOf(String string2) {
        return Enum.valueOf(Types$ClassOwnership.class, string2);
    }

    public static Types$ClassOwnership[] values() {
        return (Types$ClassOwnership[])$VALUES.clone();
    }

    public abstract Class getOwnerType(Class var1);
}

