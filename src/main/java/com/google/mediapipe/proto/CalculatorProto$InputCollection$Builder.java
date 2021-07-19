/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$InputCollection;
import com.google.mediapipe.proto.CalculatorProto$InputCollection$InputType;
import com.google.mediapipe.proto.CalculatorProto$InputCollectionOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class CalculatorProto$InputCollection$Builder
extends GeneratedMessageLite$Builder
implements CalculatorProto$InputCollectionOrBuilder {
    private CalculatorProto$InputCollection$Builder() {
        CalculatorProto$InputCollection calculatorProto$InputCollection = CalculatorProto$InputCollection.access$1100();
        super(calculatorProto$InputCollection);
    }

    public /* synthetic */ CalculatorProto$InputCollection$Builder(CalculatorProto$1 calculatorProto$1) {
        this();
    }

    public CalculatorProto$InputCollection$Builder addAllExternalInputName(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2200((CalculatorProto$InputCollection)this.instance, iterable);
        return this;
    }

    public CalculatorProto$InputCollection$Builder addAllSidePacketName(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1700((CalculatorProto$InputCollection)this.instance, iterable);
        return this;
    }

    public CalculatorProto$InputCollection$Builder addExternalInputName(String string2) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2100((CalculatorProto$InputCollection)this.instance, string2);
        return this;
    }

    public CalculatorProto$InputCollection$Builder addExternalInputNameBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2400((CalculatorProto$InputCollection)this.instance, byteString);
        return this;
    }

    public CalculatorProto$InputCollection$Builder addSidePacketName(String string2) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1600((CalculatorProto$InputCollection)this.instance, string2);
        return this;
    }

    public CalculatorProto$InputCollection$Builder addSidePacketNameBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1900((CalculatorProto$InputCollection)this.instance, byteString);
        return this;
    }

    public CalculatorProto$InputCollection$Builder clearExternalInputName() {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2300((CalculatorProto$InputCollection)this.instance);
        return this;
    }

    public CalculatorProto$InputCollection$Builder clearFileName() {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2900((CalculatorProto$InputCollection)this.instance);
        return this;
    }

    public CalculatorProto$InputCollection$Builder clearInputType() {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2700((CalculatorProto$InputCollection)this.instance);
        return this;
    }

    public CalculatorProto$InputCollection$Builder clearName() {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1300((CalculatorProto$InputCollection)this.instance);
        return this;
    }

    public CalculatorProto$InputCollection$Builder clearSidePacketName() {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1800((CalculatorProto$InputCollection)this.instance);
        return this;
    }

    public String getExternalInputName(int n10) {
        return ((CalculatorProto$InputCollection)this.instance).getExternalInputName(n10);
    }

    public ByteString getExternalInputNameBytes(int n10) {
        return ((CalculatorProto$InputCollection)this.instance).getExternalInputNameBytes(n10);
    }

    public int getExternalInputNameCount() {
        return ((CalculatorProto$InputCollection)this.instance).getExternalInputNameCount();
    }

    public List getExternalInputNameList() {
        return Collections.unmodifiableList(((CalculatorProto$InputCollection)this.instance).getExternalInputNameList());
    }

    public String getFileName() {
        return ((CalculatorProto$InputCollection)this.instance).getFileName();
    }

    public ByteString getFileNameBytes() {
        return ((CalculatorProto$InputCollection)this.instance).getFileNameBytes();
    }

    public CalculatorProto$InputCollection$InputType getInputType() {
        return ((CalculatorProto$InputCollection)this.instance).getInputType();
    }

    public int getInputTypeValue() {
        return ((CalculatorProto$InputCollection)this.instance).getInputTypeValue();
    }

    public String getName() {
        return ((CalculatorProto$InputCollection)this.instance).getName();
    }

    public ByteString getNameBytes() {
        return ((CalculatorProto$InputCollection)this.instance).getNameBytes();
    }

    public String getSidePacketName(int n10) {
        return ((CalculatorProto$InputCollection)this.instance).getSidePacketName(n10);
    }

    public ByteString getSidePacketNameBytes(int n10) {
        return ((CalculatorProto$InputCollection)this.instance).getSidePacketNameBytes(n10);
    }

    public int getSidePacketNameCount() {
        return ((CalculatorProto$InputCollection)this.instance).getSidePacketNameCount();
    }

    public List getSidePacketNameList() {
        return Collections.unmodifiableList(((CalculatorProto$InputCollection)this.instance).getSidePacketNameList());
    }

    public CalculatorProto$InputCollection$Builder setExternalInputName(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2000((CalculatorProto$InputCollection)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$InputCollection$Builder setFileName(String string2) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2800((CalculatorProto$InputCollection)this.instance, string2);
        return this;
    }

    public CalculatorProto$InputCollection$Builder setFileNameBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$3000((CalculatorProto$InputCollection)this.instance, byteString);
        return this;
    }

    public CalculatorProto$InputCollection$Builder setInputType(CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2600((CalculatorProto$InputCollection)this.instance, calculatorProto$InputCollection$InputType);
        return this;
    }

    public CalculatorProto$InputCollection$Builder setInputTypeValue(int n10) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$2500((CalculatorProto$InputCollection)this.instance, n10);
        return this;
    }

    public CalculatorProto$InputCollection$Builder setName(String string2) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1200((CalculatorProto$InputCollection)this.instance, string2);
        return this;
    }

    public CalculatorProto$InputCollection$Builder setNameBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1400((CalculatorProto$InputCollection)this.instance, byteString);
        return this;
    }

    public CalculatorProto$InputCollection$Builder setSidePacketName(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$InputCollection.access$1500((CalculatorProto$InputCollection)this.instance, n10, string2);
        return this;
    }
}

