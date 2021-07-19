/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.reflect.TypeCapture;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$1;
import com.google.common.reflect.Types$JavaVersion$1;
import com.google.common.reflect.Types$JavaVersion$2;
import com.google.common.reflect.Types$JavaVersion$3;
import com.google.common.reflect.Types$JavaVersion$4;
import com.google.common.reflect.Types$JavaVersion$5;
import com.google.common.reflect.Types$JavaVersion$6;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class Types$JavaVersion
extends Enum {
    private static final /* synthetic */ Types$JavaVersion[] $VALUES;
    public static final Types$JavaVersion CURRENT;
    public static final /* enum */ Types$JavaVersion JAVA6;
    public static final /* enum */ Types$JavaVersion JAVA7;
    public static final /* enum */ Types$JavaVersion JAVA8;
    public static final /* enum */ Types$JavaVersion JAVA9;

    static {
        Object object = new Types$JavaVersion$1();
        JAVA6 = object;
        int n10 = 1;
        Object object2 = new Types$JavaVersion$2();
        JAVA7 = object2;
        int n11 = 2;
        Types$JavaVersion$3 types$JavaVersion$3 = new Types$JavaVersion$3();
        JAVA8 = types$JavaVersion$3;
        int n12 = 3;
        Types$JavaVersion$4 types$JavaVersion$4 = new Types$JavaVersion$4();
        JAVA9 = types$JavaVersion$4;
        int n13 = 4;
        Types$JavaVersion[] types$JavaVersionArray = new Types$JavaVersion[n13];
        types$JavaVersionArray[0] = object;
        types$JavaVersionArray[n10] = object2;
        types$JavaVersionArray[n11] = types$JavaVersion$3;
        types$JavaVersionArray[n12] = types$JavaVersion$4;
        $VALUES = types$JavaVersionArray;
        Class<AnnotatedElement> clazz = AnnotatedElement.class;
        Class<TypeVariable> clazz2 = TypeVariable.class;
        boolean bl2 = clazz.isAssignableFrom(clazz2);
        if (bl2) {
            object = new Types$JavaVersion$5();
            boolean bl3 = ((String)(object = ((TypeCapture)object).capture().toString())).contains((CharSequence)(object2 = "java.util.Map.java.util.Map"));
            CURRENT = bl3 ? types$JavaVersion$3 : types$JavaVersion$4;
        } else {
            clazz = new Types$JavaVersion$6();
            bl2 = (clazz = ((TypeCapture)((Object)clazz)).capture()) instanceof Class;
            CURRENT = bl2 ? object2 : object;
        }
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Types$JavaVersion() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ Types$JavaVersion(Types$1 types$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static Types$JavaVersion valueOf(String string2) {
        return Enum.valueOf(Types$JavaVersion.class, string2);
    }

    public static Types$JavaVersion[] values() {
        return (Types$JavaVersion[])$VALUES.clone();
    }

    public boolean jdkTypeDuplicatesOwnerName() {
        return true;
    }

    public abstract Type newArrayType(Type var1);

    public String typeName(Type type) {
        return Types.toString(type);
    }

    public final ImmutableList usedInGenericType(Type[] typeArray) {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        for (Type type : typeArray) {
            type = this.usedInGenericType(type);
            immutableList$Builder.add(type);
        }
        return immutableList$Builder.build();
    }

    public abstract Type usedInGenericType(Type var1);
}

