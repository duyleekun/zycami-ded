/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeResolver$WildcardCapturer;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class TypeResolver$WildcardCapturer$1
extends TypeResolver$WildcardCapturer {
    public final /* synthetic */ TypeResolver$WildcardCapturer this$0;
    public final /* synthetic */ TypeVariable val$typeParam;

    public TypeResolver$WildcardCapturer$1(TypeResolver$WildcardCapturer typeResolver$WildcardCapturer, AtomicInteger atomicInteger, TypeVariable typeVariable) {
        this.this$0 = typeResolver$WildcardCapturer;
        this.val$typeParam = typeVariable;
        super(atomicInteger, null);
    }

    public TypeVariable captureAsTypeVariable(Type[] typeArray) {
        typeArray = Arrays.asList(typeArray);
        LinkedHashSet linkedHashSet = new LinkedHashSet(typeArray);
        typeArray = Arrays.asList(this.val$typeParam.getBounds());
        linkedHashSet.addAll(typeArray);
        int n10 = linkedHashSet.size();
        int n11 = 1;
        if (n10 > n11) {
            typeArray = Object.class;
            linkedHashSet.remove(typeArray);
        }
        typeArray = new Type[]{};
        typeArray = linkedHashSet.toArray(typeArray);
        return super.captureAsTypeVariable(typeArray);
    }
}

