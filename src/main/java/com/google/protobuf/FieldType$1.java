/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldType$Collection;
import com.google.protobuf.JavaType;

public class FieldType$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType$Collection;
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13 = JavaType.values().length;
        int[] nArray = new int[n13];
        $SwitchMap$com$google$protobuf$JavaType = nArray;
        int n14 = 1;
        try {
            object3 = JavaType.BYTE_STRING;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = $SwitchMap$com$google$protobuf$JavaType;
            object2 = JavaType.MESSAGE;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (JavaType)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = $SwitchMap$com$google$protobuf$JavaType;
            enum_ = JavaType.STRING;
            n10 = enum_.ordinal();
            object2[n10] = (JavaType)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = FieldType$Collection.values().length;
        object2 = new int[n11];
        $SwitchMap$com$google$protobuf$FieldType$Collection = (int[])object2;
        try {
            enum_ = FieldType$Collection.MAP;
            n10 = enum_.ordinal();
            object2[n10] = (JavaType)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$FieldType$Collection;
            object2 = FieldType$Collection.VECTOR;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$FieldType$Collection;
            object = (Object)FieldType$Collection.SCALAR;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

