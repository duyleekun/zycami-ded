/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders;

public interface ValueEncoderContext {
    public ValueEncoderContext add(double var1);

    public ValueEncoderContext add(float var1);

    public ValueEncoderContext add(int var1);

    public ValueEncoderContext add(long var1);

    public ValueEncoderContext add(String var1);

    public ValueEncoderContext add(boolean var1);

    public ValueEncoderContext add(byte[] var1);
}

