/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;

public final class JsonDataEncoderBuilder$$Lambda$1
implements ObjectEncoder {
    private static final JsonDataEncoderBuilder$$Lambda$1 instance;

    static {
        JsonDataEncoderBuilder$$Lambda$1 jsonDataEncoderBuilder$$Lambda$1;
        instance = jsonDataEncoderBuilder$$Lambda$1 = new JsonDataEncoderBuilder$$Lambda$1();
    }

    private JsonDataEncoderBuilder$$Lambda$1() {
    }

    public static ObjectEncoder lambdaFactory$() {
        return instance;
    }

    public void encode(Object object, Object object2) {
        object2 = (ObjectEncoderContext)object2;
        JsonDataEncoderBuilder.lambda$static$0(object, (ObjectEncoderContext)object2);
    }
}

