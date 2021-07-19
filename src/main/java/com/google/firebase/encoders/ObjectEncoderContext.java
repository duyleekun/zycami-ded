/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders;

import com.google.firebase.encoders.FieldDescriptor;

public interface ObjectEncoderContext {
    public ObjectEncoderContext add(FieldDescriptor var1, double var2);

    public ObjectEncoderContext add(FieldDescriptor var1, float var2);

    public ObjectEncoderContext add(FieldDescriptor var1, int var2);

    public ObjectEncoderContext add(FieldDescriptor var1, long var2);

    public ObjectEncoderContext add(FieldDescriptor var1, Object var2);

    public ObjectEncoderContext add(FieldDescriptor var1, boolean var2);

    public ObjectEncoderContext add(String var1, double var2);

    public ObjectEncoderContext add(String var1, int var2);

    public ObjectEncoderContext add(String var1, long var2);

    public ObjectEncoderContext add(String var1, Object var2);

    public ObjectEncoderContext add(String var1, boolean var2);

    public ObjectEncoderContext inline(Object var1);

    public ObjectEncoderContext nested(FieldDescriptor var1);

    public ObjectEncoderContext nested(String var1);
}

