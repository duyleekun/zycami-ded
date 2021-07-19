/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;

public final class ExtensionRegistry$DescriptorIntPair {
    private final Descriptors$Descriptor descriptor;
    private final int number;

    public ExtensionRegistry$DescriptorIntPair(Descriptors$Descriptor descriptors$Descriptor, int n10) {
        this.descriptor = descriptors$Descriptor;
        this.number = n10;
    }

    public static /* synthetic */ Descriptors$Descriptor access$000(ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair) {
        return extensionRegistry$DescriptorIntPair.descriptor;
    }

    public boolean equals(Object object) {
        int n10;
        int n11 = object instanceof ExtensionRegistry$DescriptorIntPair;
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        object = (ExtensionRegistry$DescriptorIntPair)object;
        Descriptors$Descriptor descriptors$Descriptor = this.descriptor;
        Descriptors$Descriptor descriptors$Descriptor2 = ((ExtensionRegistry$DescriptorIntPair)object).descriptor;
        if (descriptors$Descriptor == descriptors$Descriptor2 && (n11 = this.number) == (n10 = ((ExtensionRegistry$DescriptorIntPair)object).number)) {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.descriptor.hashCode() * (char)-1;
        int n11 = this.number;
        return n10 + n11;
    }
}

