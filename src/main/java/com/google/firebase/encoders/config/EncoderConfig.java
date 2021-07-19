/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders.config;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;

public interface EncoderConfig {
    public EncoderConfig registerEncoder(Class var1, ObjectEncoder var2);

    public EncoderConfig registerEncoder(Class var1, ValueEncoder var2);
}

