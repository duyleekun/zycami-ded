/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorMessageInfoFactory$1;
import java.util.ArrayList;
import java.util.List;

public class DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent {
    public final List messages;
    public boolean needsIsInitializedCheck;

    private DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent() {
        ArrayList arrayList;
        this.messages = arrayList = new ArrayList();
        this.needsIsInitializedCheck = false;
    }

    public /* synthetic */ DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent(DescriptorMessageInfoFactory.1 var1_1) {
        this();
    }
}

