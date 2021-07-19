/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$GenericDescriptor;

public final class Descriptors$DescriptorPool$DescriptorIntPair {
    private final Descriptors$GenericDescriptor descriptor;
    private final int number;

    public Descriptors$DescriptorPool$DescriptorIntPair(Descriptors$GenericDescriptor descriptors$GenericDescriptor, int n10) {
        this.descriptor = descriptors$GenericDescriptor;
        this.number = n10;
    }

    public boolean equals(Object object) {
        int n10;
        int n11 = object instanceof Descriptors$DescriptorPool$DescriptorIntPair;
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        object = (Descriptors$DescriptorPool$DescriptorIntPair)object;
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = this.descriptor;
        Descriptors$GenericDescriptor descriptors$GenericDescriptor2 = ((Descriptors$DescriptorPool$DescriptorIntPair)object).descriptor;
        if (descriptors$GenericDescriptor == descriptors$GenericDescriptor2 && (n11 = this.number) == (n10 = ((Descriptors$DescriptorPool$DescriptorIntPair)object).number)) {
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

