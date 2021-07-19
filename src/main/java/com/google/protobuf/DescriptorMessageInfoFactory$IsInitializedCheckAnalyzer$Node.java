/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent;
import com.google.protobuf.Descriptors$Descriptor;

public class DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node {
    public DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent component;
    public final Descriptors$Descriptor descriptor;
    public final int index;
    public int lowLink;

    public DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node(Descriptors$Descriptor descriptors$Descriptor, int n10) {
        this.descriptor = descriptors$Descriptor;
        this.index = n10;
        this.lowLink = n10;
        this.component = null;
    }
}

