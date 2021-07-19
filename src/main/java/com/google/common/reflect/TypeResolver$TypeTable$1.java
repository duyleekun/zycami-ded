/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeResolver$TypeTable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver$TypeTable$1
extends TypeResolver$TypeTable {
    public final /* synthetic */ TypeResolver$TypeTable this$0;
    public final /* synthetic */ TypeResolver$TypeTable val$unguarded;
    public final /* synthetic */ TypeVariable val$var;

    public TypeResolver$TypeTable$1(TypeResolver$TypeTable typeResolver$TypeTable, TypeVariable typeVariable, TypeResolver$TypeTable typeResolver$TypeTable2) {
        this.this$0 = typeResolver$TypeTable;
        this.val$var = typeVariable;
        this.val$unguarded = typeResolver$TypeTable2;
    }

    public Type resolveInternal(TypeVariable typeVariable, TypeResolver$TypeTable typeResolver$TypeTable) {
        Object d10;
        Object d11 = typeVariable.getGenericDeclaration();
        boolean bl2 = d11.equals(d10 = this.val$var.getGenericDeclaration());
        if (bl2) {
            return typeVariable;
        }
        return this.val$unguarded.resolveInternal(typeVariable, typeResolver$TypeTable);
    }
}

