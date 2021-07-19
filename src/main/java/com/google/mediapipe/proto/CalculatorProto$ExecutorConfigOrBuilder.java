/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  mediapipe.MediapipeOptions$MediaPipeOptions
 */
package com.google.mediapipe.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import mediapipe.MediapipeOptions;

public interface CalculatorProto$ExecutorConfigOrBuilder
extends MessageLiteOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public MediapipeOptions.MediaPipeOptions getOptions();

    public String getType();

    public ByteString getTypeBytes();

    public boolean hasOptions();
}

