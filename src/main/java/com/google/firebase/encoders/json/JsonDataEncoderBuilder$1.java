/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonValueObjectEncoderContext;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class JsonDataEncoderBuilder$1
implements DataEncoder {
    public final /* synthetic */ JsonDataEncoderBuilder this$0;

    public JsonDataEncoderBuilder$1(JsonDataEncoderBuilder jsonDataEncoderBuilder) {
        this.this$0 = jsonDataEncoderBuilder;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String encode(Object object) {
        StringWriter stringWriter = new StringWriter();
        try {
            this.encode(object, stringWriter);
            return stringWriter.toString();
        }
        catch (IOException iOException) {
            return stringWriter.toString();
        }
    }

    public void encode(Object object, Writer writer) {
        Map map = JsonDataEncoderBuilder.access$100(this.this$0);
        Map map2 = JsonDataEncoderBuilder.access$200(this.this$0);
        ObjectEncoder objectEncoder = JsonDataEncoderBuilder.access$300(this.this$0);
        boolean bl2 = JsonDataEncoderBuilder.access$400(this.this$0);
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, map, map2, objectEncoder, bl2);
        jsonValueObjectEncoderContext.add(object, false);
        jsonValueObjectEncoderContext.close();
    }
}

