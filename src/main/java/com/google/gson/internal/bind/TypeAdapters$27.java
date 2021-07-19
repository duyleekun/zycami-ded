/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TypeAdapters$27
extends TypeAdapter {
    private static final String DAY_OF_MONTH = "dayOfMonth";
    private static final String HOUR_OF_DAY = "hourOfDay";
    private static final String MINUTE = "minute";
    private static final String MONTH = "month";
    private static final String SECOND = "second";
    private static final String YEAR = "year";

    public Calendar read(JsonReader object) {
        Object object2;
        Object object3 = ((JsonReader)object).peek();
        if (object3 == (object2 = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        ((JsonReader)object).beginObject();
        boolean bl2 = false;
        object3 = null;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        while ((object3 = ((JsonReader)object).peek()) != (object2 = JsonToken.END_OBJECT)) {
            object3 = ((JsonReader)object).nextName();
            int n16 = ((JsonReader)object).nextInt();
            String string2 = YEAR;
            boolean bl3 = string2.equals(object3);
            if (bl3) {
                n10 = n16;
                continue;
            }
            string2 = MONTH;
            bl3 = string2.equals(object3);
            if (bl3) {
                n11 = n16;
                continue;
            }
            string2 = DAY_OF_MONTH;
            bl3 = string2.equals(object3);
            if (bl3) {
                n12 = n16;
                continue;
            }
            string2 = HOUR_OF_DAY;
            bl3 = string2.equals(object3);
            if (bl3) {
                n13 = n16;
                continue;
            }
            string2 = MINUTE;
            bl3 = string2.equals(object3);
            if (bl3) {
                n14 = n16;
                continue;
            }
            string2 = SECOND;
            bl2 = string2.equals(object3);
            if (!bl2) continue;
            n15 = n16;
        }
        ((JsonReader)object).endObject();
        object2 = object;
        object = new GregorianCalendar(n10, n11, n12, n13, n14, n15);
        return object;
    }

    public void write(JsonWriter jsonWriter, Calendar calendar) {
        if (calendar == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name(YEAR);
        long l10 = calendar.get(1);
        jsonWriter.value(l10);
        jsonWriter.name(MONTH);
        l10 = calendar.get(2);
        jsonWriter.value(l10);
        jsonWriter.name(DAY_OF_MONTH);
        l10 = calendar.get(5);
        jsonWriter.value(l10);
        jsonWriter.name(HOUR_OF_DAY);
        l10 = calendar.get(11);
        jsonWriter.value(l10);
        jsonWriter.name(MINUTE);
        l10 = calendar.get(12);
        jsonWriter.value(l10);
        jsonWriter.name(SECOND);
        l10 = calendar.get(13);
        jsonWriter.value(l10);
        jsonWriter.endObject();
    }
}

