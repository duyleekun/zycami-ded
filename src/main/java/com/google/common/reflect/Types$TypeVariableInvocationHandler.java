/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.reflect.Types$TypeVariableImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;

public final class Types$TypeVariableInvocationHandler
implements InvocationHandler {
    private static final ImmutableMap typeVariableMethods;
    private final Types$TypeVariableImpl typeVariableImpl;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Class<Types$TypeVariableImpl> clazz = Types$TypeVariableImpl.class;
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Method[] methodArray = clazz.getMethods();
        int n10 = methodArray.length;
        int n11 = 0;
        while (true) {
            if (n11 >= n10) {
                typeVariableMethods = immutableMap$Builder.build();
                return;
            }
            Method method = methodArray[n11];
            Class<?> clazz2 = method.getDeclaringClass();
            boolean bl2 = clazz2.equals(clazz);
            if (bl2) {
                bl2 = true;
                try {
                    method.setAccessible(bl2);
                }
                catch (AccessControlException accessControlException) {}
                clazz2 = method.getName();
                immutableMap$Builder.put(clazz2, method);
            }
            ++n11;
        }
    }

    public Types$TypeVariableInvocationHandler(Types$TypeVariableImpl types$TypeVariableImpl) {
        this.typeVariableImpl = types$TypeVariableImpl;
    }

    public static /* synthetic */ Types$TypeVariableImpl access$600(Types$TypeVariableInvocationHandler types$TypeVariableInvocationHandler) {
        return types$TypeVariableInvocationHandler.typeVariableImpl;
    }

    public Object invoke(Object object, Method object2, Object[] objectArray) {
        object = ((Method)object2).getName();
        if ((object2 = (Method)typeVariableMethods.get(object)) != null) {
            try {
                object = this.typeVariableImpl;
            }
            catch (InvocationTargetException invocationTargetException) {
                throw invocationTargetException.getCause();
            }
            return ((Method)object2).invoke(object, objectArray);
        }
        object2 = new UnsupportedOperationException((String)object);
        throw object2;
    }
}

