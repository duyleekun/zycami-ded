/*
 * Decompiled with CFR 0.151.
 */
package kotlin.reflect;

import f.h2.s.l;
import f.h2.t.f0;
import java.lang.reflect.Type;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.TypesJVMKt;

public final class ParameterizedTypeImpl$getTypeName$1$1
extends FunctionReferenceImpl
implements l {
    public static final ParameterizedTypeImpl$getTypeName$1$1 INSTANCE;

    static {
        ParameterizedTypeImpl$getTypeName$1$1 parameterizedTypeImpl$getTypeName$1$1;
        INSTANCE = parameterizedTypeImpl$getTypeName$1$1 = new ParameterizedTypeImpl$getTypeName$1$1();
    }

    public ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    public final String invoke(Type type) {
        f0.p(type, "p1");
        return TypesJVMKt.b(type);
    }
}

