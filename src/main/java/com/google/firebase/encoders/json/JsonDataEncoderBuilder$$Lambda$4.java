/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;

public final class JsonDataEncoderBuilder$$Lambda$4
implements ValueEncoder {
    private static final JsonDataEncoderBuilder$$Lambda$4 instance;

    static {
        JsonDataEncoderBuilder$$Lambda$4 jsonDataEncoderBuilder$$Lambda$4;
        instance = jsonDataEncoderBuilder$$Lambda$4 = new JsonDataEncoderBuilder$$Lambda$4();
    }

    private JsonDataEncoderBuilder$$Lambda$4() {
    }

    public static ValueEncoder lambdaFactory$() {
        return instance;
    }

    public void encode(Object object, Object object2) {
        object = (String)object;
        object2 = (ValueEncoderContext)object2;
        JsonDataEncoderBuilder.lambda$static$1((String)object, (ValueEncoderContext)object2);
    }
}

