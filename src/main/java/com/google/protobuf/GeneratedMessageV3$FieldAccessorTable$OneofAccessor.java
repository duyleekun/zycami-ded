/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.Internal$EnumLite;
import java.lang.reflect.Method;

public class GeneratedMessageV3$FieldAccessorTable$OneofAccessor {
    private final Method caseMethod;
    private final Method caseMethodBuilder;
    private final Method clearMethod;
    private final Descriptors$Descriptor descriptor;

    public GeneratedMessageV3$FieldAccessorTable$OneofAccessor(Descriptors$Descriptor object, String classArray, Class classArray2, Class clazz) {
        this.descriptor = object;
        object = new StringBuilder();
        String string2 = "get";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        String string3 = "Case";
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        Class[] classArray3 = new Class[]{};
        this.caseMethod = object = GeneratedMessageV3.access$1000((Class)classArray2, (String)object, classArray3);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        classArray2 = new Class[]{};
        this.caseMethodBuilder = object = GeneratedMessageV3.access$1000(clazz, (String)object, classArray2);
        object = new StringBuilder();
        ((StringBuilder)object).append("clear");
        ((StringBuilder)object).append((String)classArray);
        object = ((StringBuilder)object).toString();
        classArray = new Class[]{};
        this.clearMethod = object = GeneratedMessageV3.access$1000(clazz, (String)object, classArray);
    }

    public void clear(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        Method method = this.clearMethod;
        Object[] objectArray = new Object[]{};
        GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public Descriptors$FieldDescriptor get(GeneratedMessageV3$Builder object) {
        Method method = this.caseMethodBuilder;
        Object[] objectArray = new Object[0];
        int n10 = (object = (Internal$EnumLite)GeneratedMessageV3.access$1100(method, object, objectArray)).getNumber();
        if (n10 > 0) {
            return this.descriptor.findFieldByNumber(n10);
        }
        return null;
    }

    public Descriptors$FieldDescriptor get(GeneratedMessageV3 object) {
        Method method = this.caseMethod;
        Object[] objectArray = new Object[0];
        int n10 = (object = (Internal$EnumLite)GeneratedMessageV3.access$1100(method, object, objectArray)).getNumber();
        if (n10 > 0) {
            return this.descriptor.findFieldByNumber(n10);
        }
        return null;
    }

    public boolean has(GeneratedMessageV3$Builder object) {
        Method method = this.caseMethodBuilder;
        Object[] objectArray = new Object[0];
        int n10 = (object = (Internal$EnumLite)GeneratedMessageV3.access$1100(method, object, objectArray)).getNumber();
        return n10 != 0;
    }

    public boolean has(GeneratedMessageV3 object) {
        Method method = this.caseMethod;
        Object[] objectArray = new Object[0];
        int n10 = (object = (Internal$EnumLite)GeneratedMessageV3.access$1100(method, object, objectArray)).getNumber();
        return n10 != 0;
    }
}

