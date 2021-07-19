/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$InputCollection;
import com.google.mediapipe.proto.CalculatorProto$InputCollection$Builder;
import com.google.mediapipe.proto.CalculatorProto$InputCollectionSet;
import com.google.mediapipe.proto.CalculatorProto$InputCollectionSetOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class CalculatorProto$InputCollectionSet$Builder
extends GeneratedMessageLite$Builder
implements CalculatorProto$InputCollectionSetOrBuilder {
    private CalculatorProto$InputCollectionSet$Builder() {
        CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet = CalculatorProto$InputCollectionSet.access$3200();
        super(calculatorProto$InputCollectionSet);
    }

    public /* synthetic */ CalculatorProto$InputCollectionSet$Builder(CalculatorProto$1 calculatorProto$1) {
        this();
    }

    public CalculatorProto$InputCollectionSet$Builder addAllInputCollection(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet.access$3600((CalculatorProto$InputCollectionSet)this.instance, iterable);
        return this;
    }

    public CalculatorProto$InputCollectionSet$Builder addInputCollection(int n10, CalculatorProto$InputCollection$Builder calculatorProto$InputCollectionOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet = (CalculatorProto$InputCollectionSet)this.instance;
        calculatorProto$InputCollectionOrBuilder = (CalculatorProto$InputCollection)calculatorProto$InputCollectionOrBuilder.build();
        CalculatorProto$InputCollectionSet.access$3500(calculatorProto$InputCollectionSet, n10, (CalculatorProto$InputCollection)calculatorProto$InputCollectionOrBuilder);
        return this;
    }

    public CalculatorProto$InputCollectionSet$Builder addInputCollection(int n10, CalculatorProto$InputCollection calculatorProto$InputCollection) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet.access$3500((CalculatorProto$InputCollectionSet)this.instance, n10, calculatorProto$InputCollection);
        return this;
    }

    public CalculatorProto$InputCollectionSet$Builder addInputCollection(CalculatorProto$InputCollection$Builder calculatorProto$InputCollectionOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet = (CalculatorProto$InputCollectionSet)this.instance;
        calculatorProto$InputCollectionOrBuilder = (CalculatorProto$InputCollection)calculatorProto$InputCollectionOrBuilder.build();
        CalculatorProto$InputCollectionSet.access$3400(calculatorProto$InputCollectionSet, (CalculatorProto$InputCollection)calculatorProto$InputCollectionOrBuilder);
        return this;
    }

    public CalculatorProto$InputCollectionSet$Builder addInputCollection(CalculatorProto$InputCollection calculatorProto$InputCollection) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet.access$3400((CalculatorProto$InputCollectionSet)this.instance, calculatorProto$InputCollection);
        return this;
    }

    public CalculatorProto$InputCollectionSet$Builder clearInputCollection() {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet.access$3700((CalculatorProto$InputCollectionSet)this.instance);
        return this;
    }

    public CalculatorProto$InputCollection getInputCollection(int n10) {
        return ((CalculatorProto$InputCollectionSet)this.instance).getInputCollection(n10);
    }

    public int getInputCollectionCount() {
        return ((CalculatorProto$InputCollectionSet)this.instance).getInputCollectionCount();
    }

    public List getInputCollectionList() {
        return Collections.unmodifiableList(((CalculatorProto$InputCollectionSet)this.instance).getInputCollectionList());
    }

    public CalculatorProto$InputCollectionSet$Builder removeInputCollection(int n10) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet.access$3800((CalculatorProto$InputCollectionSet)this.instance, n10);
        return this;
    }

    public CalculatorProto$InputCollectionSet$Builder setInputCollection(int n10, CalculatorProto$InputCollection$Builder calculatorProto$InputCollectionOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet calculatorProto$InputCollectionSet = (CalculatorProto$InputCollectionSet)this.instance;
        calculatorProto$InputCollectionOrBuilder = (CalculatorProto$InputCollection)calculatorProto$InputCollectionOrBuilder.build();
        CalculatorProto$InputCollectionSet.access$3300(calculatorProto$InputCollectionSet, n10, (CalculatorProto$InputCollection)calculatorProto$InputCollectionOrBuilder);
        return this;
    }

    public CalculatorProto$InputCollectionSet$Builder setInputCollection(int n10, CalculatorProto$InputCollection calculatorProto$InputCollection) {
        this.copyOnWrite();
        CalculatorProto$InputCollectionSet.access$3300((CalculatorProto$InputCollectionSet)this.instance, n10, calculatorProto$InputCollection);
        return this;
    }
}

