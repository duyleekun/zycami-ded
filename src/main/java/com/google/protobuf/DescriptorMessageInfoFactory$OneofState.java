/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorMessageInfoFactory;
import com.google.protobuf.DescriptorMessageInfoFactory$1;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.OneofInfo;
import java.lang.reflect.Field;
import java.util.Arrays;

public final class DescriptorMessageInfoFactory$OneofState {
    private OneofInfo[] oneofs;

    private DescriptorMessageInfoFactory$OneofState() {
        OneofInfo[] oneofInfoArray = new OneofInfo[2];
        this.oneofs = oneofInfoArray;
    }

    public /* synthetic */ DescriptorMessageInfoFactory$OneofState(DescriptorMessageInfoFactory$1 descriptorMessageInfoFactory$1) {
        this();
    }

    private static OneofInfo newInfo(Class annotatedElement, Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        Object object = DescriptorMessageInfoFactory.access$200(descriptors$OneofDescriptor.getName());
        CharSequence charSequence = new StringBuilder();
        charSequence.append((String)object);
        charSequence.append("_");
        charSequence = charSequence.toString();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("Case_");
        object = ((StringBuilder)object2).toString();
        int n10 = descriptors$OneofDescriptor.getIndex();
        object = DescriptorMessageInfoFactory.access$300(annotatedElement, (String)object);
        annotatedElement = DescriptorMessageInfoFactory.access$300(annotatedElement, (String)charSequence);
        object2 = new OneofInfo(n10, (Field)object, (Field)annotatedElement);
        return object2;
    }

    public OneofInfo getOneof(Class oneofInfoArray, Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        Object object;
        int n10;
        int n11 = descriptors$OneofDescriptor.getIndex();
        if (n11 >= (n10 = ((OneofInfo[])(object = this.oneofs)).length)) {
            n10 = n11 * 2;
            this.oneofs = object = Arrays.copyOf(object, n10);
        }
        if ((object = this.oneofs[n11]) == null) {
            object = DescriptorMessageInfoFactory$OneofState.newInfo((Class)oneofInfoArray, descriptors$OneofDescriptor);
            oneofInfoArray = this.oneofs;
            oneofInfoArray[n11] = object;
        }
        return object;
    }
}

