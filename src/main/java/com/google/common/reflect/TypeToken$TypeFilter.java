/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.reflect.TypeToken$1;
import com.google.common.reflect.TypeToken$TypeFilter$1;
import com.google.common.reflect.TypeToken$TypeFilter$2;

public abstract class TypeToken$TypeFilter
extends Enum
implements Predicate {
    private static final /* synthetic */ TypeToken$TypeFilter[] $VALUES;
    public static final /* enum */ TypeToken$TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD;
    public static final /* enum */ TypeToken$TypeFilter INTERFACE_ONLY;

    static {
        TypeToken$TypeFilter$1 typeToken$TypeFilter$1 = new TypeToken$TypeFilter$1();
        IGNORE_TYPE_VARIABLE_OR_WILDCARD = typeToken$TypeFilter$1;
        int n10 = 1;
        TypeToken$TypeFilter$2 typeToken$TypeFilter$2 = new TypeToken$TypeFilter$2();
        INTERFACE_ONLY = typeToken$TypeFilter$2;
        TypeToken$TypeFilter[] typeToken$TypeFilterArray = new TypeToken$TypeFilter[2];
        typeToken$TypeFilterArray[0] = typeToken$TypeFilter$1;
        typeToken$TypeFilterArray[n10] = typeToken$TypeFilter$2;
        $VALUES = typeToken$TypeFilterArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TypeToken$TypeFilter() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ TypeToken$TypeFilter(TypeToken$1 typeToken$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static TypeToken$TypeFilter valueOf(String string2) {
        return Enum.valueOf(TypeToken$TypeFilter.class, string2);
    }

    public static TypeToken$TypeFilter[] values() {
        return (TypeToken$TypeFilter[])$VALUES.clone();
    }
}

