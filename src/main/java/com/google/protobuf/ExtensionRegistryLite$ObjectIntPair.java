/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class ExtensionRegistryLite$ObjectIntPair {
    private final int number;
    private final Object object;

    public ExtensionRegistryLite$ObjectIntPair(Object object, int n10) {
        this.object = object;
        this.number = n10;
    }

    public boolean equals(Object object) {
        int n10;
        int n11 = object instanceof ExtensionRegistryLite$ObjectIntPair;
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        object = (ExtensionRegistryLite$ObjectIntPair)object;
        Object object2 = this.object;
        Object object3 = ((ExtensionRegistryLite$ObjectIntPair)object).object;
        if (object2 == object3 && (n11 = this.number) == (n10 = ((ExtensionRegistryLite$ObjectIntPair)object).number)) {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = System.identityHashCode(this.object) * (char)-1;
        int n11 = this.number;
        return n10 + n11;
    }
}

