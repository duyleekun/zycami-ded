/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public class Element
extends AccessibleObject
implements Member {
    private final AccessibleObject accessibleObject;
    private final Member member;

    public Element(AccessibleObject object) {
        Preconditions.checkNotNull(object);
        this.accessibleObject = object;
        this.member = object = (Member)object;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Element;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            TypeToken typeToken;
            object = (Element)object;
            Object object2 = this.getOwnerType();
            bl2 = ((TypeToken)object2).equals(typeToken = ((Element)object).getOwnerType());
            if (bl2 && (bl4 = (object2 = this.member).equals(object = ((Element)object).member))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public final Annotation getAnnotation(Class clazz) {
        return this.accessibleObject.getAnnotation(clazz);
    }

    public final Annotation[] getAnnotations() {
        return this.accessibleObject.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.accessibleObject.getDeclaredAnnotations();
    }

    public Class getDeclaringClass() {
        return this.member.getDeclaringClass();
    }

    public final int getModifiers() {
        return this.member.getModifiers();
    }

    public final String getName() {
        return this.member.getName();
    }

    public TypeToken getOwnerType() {
        return TypeToken.of(this.getDeclaringClass());
    }

    public int hashCode() {
        return this.member.hashCode();
    }

    public final boolean isAbstract() {
        return Modifier.isAbstract(this.getModifiers());
    }

    public final boolean isAccessible() {
        return this.accessibleObject.isAccessible();
    }

    public final boolean isAnnotationPresent(Class clazz) {
        return this.accessibleObject.isAnnotationPresent(clazz);
    }

    public final boolean isFinal() {
        return Modifier.isFinal(this.getModifiers());
    }

    public final boolean isNative() {
        return Modifier.isNative(this.getModifiers());
    }

    public final boolean isPackagePrivate() {
        boolean bl2 = this.isPrivate();
        bl2 = !bl2 && !(bl2 = this.isPublic()) && !(bl2 = this.isProtected());
        return bl2;
    }

    public final boolean isPrivate() {
        return Modifier.isPrivate(this.getModifiers());
    }

    public final boolean isProtected() {
        return Modifier.isProtected(this.getModifiers());
    }

    public final boolean isPublic() {
        return Modifier.isPublic(this.getModifiers());
    }

    public final boolean isStatic() {
        return Modifier.isStatic(this.getModifiers());
    }

    public final boolean isSynchronized() {
        return Modifier.isSynchronized(this.getModifiers());
    }

    public final boolean isSynthetic() {
        return this.member.isSynthetic();
    }

    public final boolean isTransient() {
        return Modifier.isTransient(this.getModifiers());
    }

    public final boolean isVolatile() {
        return Modifier.isVolatile(this.getModifiers());
    }

    public final void setAccessible(boolean bl2) {
        this.accessibleObject.setAccessible(bl2);
    }

    public String toString() {
        return this.member.toString();
    }
}

