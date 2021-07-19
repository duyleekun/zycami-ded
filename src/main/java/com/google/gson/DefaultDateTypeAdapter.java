/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class DefaultDateTypeAdapter
extends TypeAdapter {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List dateFormats;
    private final Class dateType;

    public DefaultDateTypeAdapter(int n10, int n11) {
        this(java.util.Date.class, n10, n11);
    }

    public DefaultDateTypeAdapter(Class serializable) {
        ArrayList<Serializable> arrayList;
        this.dateFormats = arrayList = new ArrayList<Serializable>();
        this.dateType = serializable = DefaultDateTypeAdapter.verifyDateType(serializable);
        serializable = Locale.US;
        int n10 = 2;
        Cloneable cloneable = DateFormat.getDateTimeInstance(n10, n10, (Locale)serializable);
        arrayList.add((Serializable)((Object)cloneable));
        cloneable = Locale.getDefault();
        boolean bl2 = ((Locale)cloneable).equals(serializable);
        if (!bl2) {
            serializable = DateFormat.getDateTimeInstance(n10, n10);
            arrayList.add(serializable);
        }
        if (bl2 = JavaVersion.isJava9OrLater()) {
            serializable = PreJava9DateFormatProvider.getUSDateTimeFormat(n10, n10);
            arrayList.add(serializable);
        }
    }

    public DefaultDateTypeAdapter(Class serializable, int n10) {
        ArrayList<Serializable> arrayList;
        this.dateFormats = arrayList = new ArrayList<Serializable>();
        this.dateType = serializable = DefaultDateTypeAdapter.verifyDateType(serializable);
        serializable = Locale.US;
        Cloneable cloneable = DateFormat.getDateInstance(n10, (Locale)serializable);
        arrayList.add((Serializable)((Object)cloneable));
        cloneable = Locale.getDefault();
        boolean bl2 = ((Locale)cloneable).equals(serializable);
        if (!bl2) {
            serializable = DateFormat.getDateInstance(n10);
            arrayList.add(serializable);
        }
        if (bl2 = JavaVersion.isJava9OrLater()) {
            serializable = PreJava9DateFormatProvider.getUSDateFormat(n10);
            arrayList.add(serializable);
        }
    }

    public DefaultDateTypeAdapter(Class serializable, int n10, int n11) {
        ArrayList<Serializable> arrayList;
        this.dateFormats = arrayList = new ArrayList<Serializable>();
        this.dateType = serializable = DefaultDateTypeAdapter.verifyDateType(serializable);
        serializable = Locale.US;
        Cloneable cloneable = DateFormat.getDateTimeInstance(n10, n11, (Locale)serializable);
        arrayList.add((Serializable)((Object)cloneable));
        cloneable = Locale.getDefault();
        boolean bl2 = ((Locale)cloneable).equals(serializable);
        if (!bl2) {
            serializable = DateFormat.getDateTimeInstance(n10, n11);
            arrayList.add(serializable);
        }
        if (bl2 = JavaVersion.isJava9OrLater()) {
            serializable = PreJava9DateFormatProvider.getUSDateTimeFormat(n10, n11);
            arrayList.add(serializable);
        }
    }

    public DefaultDateTypeAdapter(Class serializable, String string2) {
        ArrayList<Serializable> arrayList;
        this.dateFormats = arrayList = new ArrayList<Serializable>();
        serializable = DefaultDateTypeAdapter.verifyDateType((Class)serializable);
        this.dateType = serializable;
        Locale locale = Locale.US;
        super(string2, locale);
        arrayList.add(serializable);
        serializable = Locale.getDefault();
        boolean bl2 = ((Locale)serializable).equals(locale);
        if (!bl2) {
            super(string2);
            arrayList.add(serializable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private java.util.Date deserializeToDate(String object) {
        List list = this.dateFormats;
        synchronized (list) {
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
            catch (ParseException parseException) {
                object2 = new JsonSyntaxException((String)object, parseException);
                throw object2;
            }
        }
    }

    private static Class verifyDateType(Class object) {
        Class<java.util.Date> clazz = java.util.Date.class;
        if (object != clazz && object != (clazz = Date.class) && object != (clazz = Timestamp.class)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Date type must be one of ");
            stringBuilder.append(java.util.Date.class);
            stringBuilder.append(", ");
            stringBuilder.append(Timestamp.class);
            stringBuilder.append(", or ");
            stringBuilder.append(Date.class);
            stringBuilder.append(" but was ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            clazz = new IllegalArgumentException((String)object);
            throw clazz;
        }
        return object;
    }

    public java.util.Date read(JsonReader object) {
        Object object2;
        Object object3 = ((JsonReader)object).peek();
        if (object3 == (object2 = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object = ((JsonReader)object).nextString();
        object = this.deserializeToDate((String)object);
        object3 = this.dateType;
        object2 = java.util.Date.class;
        if (object3 == object2) {
            return object;
        }
        object2 = Timestamp.class;
        if (object3 == object2) {
            long l10 = ((java.util.Date)object).getTime();
            object3 = new Timestamp(l10);
            return object3;
        }
        object2 = Date.class;
        if (object3 == object2) {
            long l11 = ((java.util.Date)object).getTime();
            object3 = new Date(l11);
            return object3;
        }
        object = new AssertionError();
        throw object;
    }

    public String toString() {
        Object object = this.dateFormats;
        StringBuilder stringBuilder = null;
        object = (DateFormat)object.get(0);
        boolean bl2 = object instanceof SimpleDateFormat;
        char c10 = ')';
        String string2 = "DefaultDateTypeAdapter(";
        if (bl2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            object = ((SimpleDateFormat)object).toPattern();
            stringBuilder.append((String)object);
            stringBuilder.append(c10);
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        object = object.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(JsonWriter jsonWriter, java.util.Date object) {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        List list = this.dateFormats;
        synchronized (list) {
            Object object2 = this.dateFormats;
            object2 = object2.get(0);
            object2 = (DateFormat)object2;
            object = ((DateFormat)object2).format((java.util.Date)object);
            jsonWriter.value((String)object);
            return;
        }
    }
}

