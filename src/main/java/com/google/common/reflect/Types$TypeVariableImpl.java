/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$NativeTypeVariableEquals;
import com.google.common.reflect.Types$TypeVariableInvocationHandler;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class Types$TypeVariableImpl {
    private final ImmutableList bounds;
    private final GenericDeclaration genericDeclaration;
    private final String name;

    public Types$TypeVariableImpl(GenericDeclaration object, String string2, Type[] typeArray) {
        Types.access$200(typeArray, "bound for type variable");
        object = (GenericDeclaration)Preconditions.checkNotNull(object);
        this.genericDeclaration = object;
        this.name = object = (String)Preconditions.checkNotNull(string2);
        this.bounds = object = ImmutableList.copyOf(typeArray);
    }

    public boolean equals(Object object) {
        boolean bl2 = Types$NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY;
        boolean bl3 = true;
        if (bl2) {
            Object object2;
            if (object != null && (bl2 = Proxy.isProxyClass(object2 = object.getClass())) && (bl2 = (object2 = Proxy.getInvocationHandler(object)) instanceof Types$TypeVariableInvocationHandler)) {
                boolean bl4;
                object2 = this.name;
                Object object3 = ((Types$TypeVariableImpl)(object = Types$TypeVariableInvocationHandler.access$600((Types$TypeVariableInvocationHandler)Proxy.getInvocationHandler(object)))).getName();
                bl2 = ((String)object2).equals(object3);
                if (!(bl2 && (bl2 = (object2 = this.genericDeclaration).equals(object3 = ((Types$TypeVariableImpl)object).getGenericDeclaration())) && (bl4 = ((ImmutableList)(object2 = this.bounds)).equals(object = ((Types$TypeVariableImpl)object).bounds)))) {
                    bl3 = false;
                }
                return bl3;
            }
            return false;
        }
        bl2 = object instanceof TypeVariable;
        if (bl2) {
            boolean bl5;
            Object object4 = this.name;
            String string2 = (object = (TypeVariable)object).getName();
            bl2 = ((String)object4).equals(string2);
            if (!bl2 || !(bl5 = (object4 = this.genericDeclaration).equals(object = object.getGenericDeclaration()))) {
                bl3 = false;
            }
            return bl3;
        }
        return false;
    }

    public Type[] getBounds() {
        return Types.access$300(this.bounds);
    }

    public GenericDeclaration getGenericDeclaration() {
        return this.genericDeclaration;
    }

    public String getName() {
        return this.name;
    }

    public String getTypeName() {
        return this.name;
    }

    public int hashCode() {
        int n10 = this.genericDeclaration.hashCode();
        int n11 = this.name.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        return this.name;
    }
}

