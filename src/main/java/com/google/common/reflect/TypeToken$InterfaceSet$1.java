/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.reflect.TypeToken$InterfaceSet;

public class TypeToken$InterfaceSet$1
implements Predicate {
    public final /* synthetic */ TypeToken.InterfaceSet this$1;

    public TypeToken$InterfaceSet$1(TypeToken.InterfaceSet interfaceSet) {
        this.this$1 = interfaceSet;
    }

    public boolean apply(Class clazz) {
        return clazz.isInterface();
    }
}

