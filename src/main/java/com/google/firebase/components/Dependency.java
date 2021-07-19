/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Preconditions;

public final class Dependency {
    private final Class anInterface;
    private final int injection;
    private final int type;

    private Dependency(Class clazz, int n10, int n11) {
        this.anInterface = clazz = (Class)Preconditions.checkNotNull(clazz, "Null dependency anInterface.");
        this.type = n10;
        this.injection = n11;
    }

    public static Dependency deferred(Class clazz) {
        Dependency dependency = new Dependency(clazz, 0, 2);
        return dependency;
    }

    private static String describeInjection(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    return "deferred";
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported injection: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                AssertionError assertionError = new AssertionError((Object)string2);
                throw assertionError;
            }
            return "provider";
        }
        return "direct";
    }

    public static Dependency optional(Class clazz) {
        Dependency dependency = new Dependency(clazz, 0, 0);
        return dependency;
    }

    public static Dependency optionalProvider(Class clazz) {
        Dependency dependency = new Dependency(clazz, 0, 1);
        return dependency;
    }

    public static Dependency required(Class clazz) {
        Dependency dependency = new Dependency(clazz, 1, 0);
        return dependency;
    }

    public static Dependency requiredProvider(Class clazz) {
        int n10 = 1;
        Dependency dependency = new Dependency(clazz, n10, n10);
        return dependency;
    }

    public static Dependency setOf(Class clazz) {
        Dependency dependency = new Dependency(clazz, 2, 0);
        return dependency;
    }

    public static Dependency setOfProvider(Class clazz) {
        Dependency dependency = new Dependency(clazz, 2, 1);
        return dependency;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof Dependency;
        boolean bl2 = false;
        if (n10 != 0) {
            int n11;
            int n12;
            object = (Dependency)object;
            Class clazz = this.anInterface;
            Class clazz2 = ((Dependency)object).anInterface;
            if (clazz == clazz2 && (n10 = this.type) == (n12 = ((Dependency)object).type) && (n10 = this.injection) == (n11 = ((Dependency)object).injection)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public Class getInterface() {
        return this.anInterface;
    }

    public int hashCode() {
        int n10 = this.anInterface.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.type;
        n10 = (n10 ^ n12) * n11;
        n11 = this.injection;
        return n10 ^ n11;
    }

    public boolean isDeferred() {
        int n10 = this.injection;
        int n11 = 2;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isDirectInjection() {
        int n10 = this.injection;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isRequired() {
        int n10 = this.type;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isSet() {
        int n10 = this.type;
        int n11 = 2;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Dependency{anInterface=");
        Object object = this.anInterface;
        stringBuilder.append(object);
        object = ", type=";
        stringBuilder.append((String)object);
        int n10 = this.type;
        int n11 = 1;
        object = n10 == n11 ? "required" : (n10 == 0 ? "optional" : "set");
        stringBuilder.append((String)object);
        stringBuilder.append(", injection=");
        object = Dependency.describeInjection(this.injection);
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

