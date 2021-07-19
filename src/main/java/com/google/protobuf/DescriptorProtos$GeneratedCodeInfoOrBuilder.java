/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$GeneratedCodeInfoOrBuilder
extends MessageOrBuilder {
    public DescriptorProtos$GeneratedCodeInfo$Annotation getAnnotation(int var1);

    public int getAnnotationCount();

    public List getAnnotationList();

    public DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder getAnnotationOrBuilder(int var1);

    public List getAnnotationOrBuilderList();
}

