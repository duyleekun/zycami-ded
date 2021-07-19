/*
 * Decompiled with CFR 0.151.
 */
package kotlin.reflect;

import f.h2.s.l;
import f.h2.t.f0;
import kotlin.jvm.internal.FunctionReferenceImpl;

public final class TypesJVMKt$typeToString$unwrap$1
extends FunctionReferenceImpl
implements l {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE;

    static {
        TypesJVMKt$typeToString$unwrap$1 typesJVMKt$typeToString$unwrap$1;
        INSTANCE = typesJVMKt$typeToString$unwrap$1 = new TypesJVMKt$typeToString$unwrap$1();
    }

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    public final Class invoke(Class clazz) {
        f0.p(clazz, "p1");
        return clazz.getComponentType();
    }
}

