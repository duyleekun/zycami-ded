/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;

public final class JsonDataEncoderBuilder$$Lambda$5
implements ValueEncoder {
    private static final JsonDataEncoderBuilder$$Lambda$5 instance;

    static {
        JsonDataEncoderBuilder$$Lambda$5 jsonDataEncoderBuilder$$Lambda$5;
        instance = jsonDataEncoderBuilder$$Lambda$5 = new JsonDataEncoderBuilder$$Lambda$5();
    }

    private JsonDataEncoderBuilder$$Lambda$5() {
    }

    public static ValueEncoder lambdaFactory$() {
        return instance;
    }

    public void encode(Object object, Object object2) {
        object = (Boolean)object;
        object2 = (ValueEncoderContext)object2;
        JsonDataEncoderBuilder.lambda$static$2((Boolean)object, (ValueEncoderContext)object2);
    }
}

