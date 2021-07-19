/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TimeTypeAdapter$1;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeTypeAdapter
extends TypeAdapter {
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;

    static {
        TimeTypeAdapter$1 timeTypeAdapter$1 = new TimeTypeAdapter$1();
        FACTORY = timeTypeAdapter$1;
    }

    public TimeTypeAdapter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        this.format = simpleDateFormat;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Time read(JsonReader object) {
        synchronized (this) {
            Object object2 = ((JsonReader)object).peek();
            JsonToken jsonToken = JsonToken.NULL;
            if (object2 == jsonToken) {
                ((JsonReader)object).nextNull();
                return null;
            }
            try {
                object2 = this.format;
                object = ((JsonReader)object).nextString();
                object = ((DateFormat)object2).parse((String)object);
                long l10 = ((Date)object).getTime();
                return new Time(l10);
            }
            catch (ParseException parseException) {
                object2 = new JsonSyntaxException(parseException);
                throw object2;
            }
        }
    }

    public void write(JsonWriter jsonWriter, Time object) {
        synchronized (this) {
            if (object == null) {
                object = null;
            } else {
                DateFormat dateFormat = this.format;
                object = dateFormat.format((Date)object);
            }
            jsonWriter.value((String)object);
            return;
        }
    }
}

