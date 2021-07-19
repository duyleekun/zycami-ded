/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.DateTypeAdapter$1;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateTypeAdapter
extends TypeAdapter {
    public static final TypeAdapterFactory FACTORY;
    private final List dateFormats;

    static {
        DateTypeAdapter$1 dateTypeAdapter$1 = new DateTypeAdapter$1();
        FACTORY = dateTypeAdapter$1;
    }

    public DateTypeAdapter() {
        ArrayList<Cloneable> arrayList;
        this.dateFormats = arrayList = new ArrayList<Cloneable>();
        Cloneable cloneable = Locale.US;
        int n10 = 2;
        Cloneable cloneable2 = DateFormat.getDateTimeInstance(n10, n10, cloneable);
        arrayList.add(cloneable2);
        cloneable2 = Locale.getDefault();
        boolean bl2 = ((Locale)cloneable2).equals(cloneable);
        if (!bl2) {
            cloneable = DateFormat.getDateTimeInstance(n10, n10);
            arrayList.add(cloneable);
        }
        if (bl2 = JavaVersion.isJava9OrLater()) {
            cloneable = PreJava9DateFormatProvider.getUSDateTimeFormat(n10, n10);
            arrayList.add(cloneable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Date deserializeToDate(String object) {
        synchronized (this) {
            Object object2;
            boolean bl2;
            Object object3 = this.dateFormats;
            object3 = object3.iterator();
            while (bl2 = object3.hasNext()) {
                object2 = object3.next();
                object2 = (DateFormat)object2;
                try {
                    return ((DateFormat)object2).parse((String)object);
                }
                catch (ParseException parseException) {
                }
            }
            try {
                bl2 = false;
                object2 = null;
                object3 = new ParsePosition(0);
                return ISO8601Utils.parse((String)object, (ParsePosition)object3);
            }
            catch (ParseException object22) {
                object2 = new JsonSyntaxException((String)object, object22);
                throw object2;
            }
        }
    }

    public Date read(JsonReader object) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = ((JsonReader)object).peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object = ((JsonReader)object).nextString();
        return this.deserializeToDate((String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(JsonWriter jsonWriter, Date object) {
        synchronized (this) {
            String string2;
            if (string2 == null) {
                jsonWriter.nullValue();
                return;
            }
            Object object2 = this.dateFormats;
            object2 = object2.get(0);
            object2 = (DateFormat)object2;
            string2 = ((DateFormat)object2).format((Date)((Object)string2));
            jsonWriter.value(string2);
            return;
        }
    }
}

