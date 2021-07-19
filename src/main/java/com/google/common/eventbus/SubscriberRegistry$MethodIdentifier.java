/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.Objects;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class SubscriberRegistry$MethodIdentifier {
    private final String name;
    private final List parameterTypes;

    public SubscriberRegistry$MethodIdentifier(Method object) {
        String string2;
        this.name = string2 = ((Method)object).getName();
        this.parameterTypes = object = Arrays.asList(((Method)object).getParameterTypes());
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof SubscriberRegistry$MethodIdentifier;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (SubscriberRegistry$MethodIdentifier)object;
            Object object2 = this.name;
            String string2 = ((SubscriberRegistry$MethodIdentifier)object).name;
            bl2 = ((String)object2).equals(string2);
            if (bl2 && (bl4 = (object2 = this.parameterTypes).equals(object = ((SubscriberRegistry$MethodIdentifier)object).parameterTypes))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        Object object = this.name;
        object = this.parameterTypes;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }
}

