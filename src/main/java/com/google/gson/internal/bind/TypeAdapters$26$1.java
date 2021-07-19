/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters$26;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

public class TypeAdapters$26$1
extends TypeAdapter {
    public final /* synthetic */ TypeAdapters$26 this$0;
    public final /* synthetic */ TypeAdapter val$dateTypeAdapter;

    public TypeAdapters$26$1(TypeAdapters$26 typeAdapters$26, TypeAdapter typeAdapter) {
        this.this$0 = typeAdapters$26;
        this.val$dateTypeAdapter = typeAdapter;
    }

    public Timestamp read(JsonReader object) {
        Object object2 = this.val$dateTypeAdapter;
        if ((object = (Date)((TypeAdapter)object2).read((JsonReader)object)) != null) {
            long l10 = ((Date)object).getTime();
            object2 = new Timestamp(l10);
        } else {
            object2 = null;
        }
        return object2;
    }

    public void write(JsonWriter jsonWriter, Timestamp timestamp) {
        this.val$dateTypeAdapter.write(jsonWriter, timestamp);
    }
}

