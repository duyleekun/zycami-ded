/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Internal$EnumVerifier;

public final class DescriptorMessageInfoFactory$1
implements Internal$EnumVerifier {
    public final /* synthetic */ Descriptors$FieldDescriptor val$fd;

    public DescriptorMessageInfoFactory$1(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.val$fd = descriptors$FieldDescriptor;
    }

    public boolean isInRange(int n10) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor = this.val$fd.getEnumType();
        Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor = descriptors$EnumDescriptor.findValueByNumber(n10);
        if (descriptors$EnumValueDescriptor != null) {
            n10 = 1;
        } else {
            n10 = 0;
            descriptors$EnumValueDescriptor = null;
        }
        return n10 != 0;
    }
}

