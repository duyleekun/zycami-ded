/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeVisitor;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

public final class Types$2
extends TypeVisitor {
    public final /* synthetic */ AtomicReference val$result;

    public Types$2(AtomicReference atomicReference) {
        this.val$result = atomicReference;
    }

    public void visitClass(Class clazz) {
        AtomicReference atomicReference = this.val$result;
        clazz = clazz.getComponentType();
        atomicReference.set(clazz);
    }

    public void visitGenericArrayType(GenericArrayType type) {
        AtomicReference atomicReference = this.val$result;
        type = type.getGenericComponentType();
        atomicReference.set(type);
    }

    public void visitTypeVariable(TypeVariable type) {
        AtomicReference atomicReference = this.val$result;
        type = Types.access$100(type.getBounds());
        atomicReference.set(type);
    }

    public void visitWildcardType(WildcardType type) {
        AtomicReference atomicReference = this.val$result;
        type = Types.access$100(type.getUpperBounds());
        atomicReference.set(type);
    }
}

