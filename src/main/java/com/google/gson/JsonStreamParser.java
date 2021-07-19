/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser
implements Iterator {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader object) {
        JsonReader jsonReader;
        this.parser = jsonReader = new JsonReader((Reader)object);
        jsonReader.setLenient(true);
        this.lock = object = new Object();
    }

    public JsonStreamParser(String string2) {
        StringReader stringReader = new StringReader(string2);
        this(stringReader);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasNext() {
        Object object = this.lock;
        synchronized (object) {
            try {
                Object object2 = this.parser;
                object2 = object2.peek();
                JsonToken jsonToken = JsonToken.END_DOCUMENT;
                if (object2 == jsonToken) return false;
                return true;
            }
            catch (Throwable throwable) {
            }
            catch (IOException iOException) {
                JsonIOException jsonIOException = new JsonIOException(iOException);
                throw jsonIOException;
            }
            catch (MalformedJsonException malformedJsonException) {
                JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(malformedJsonException);
                throw jsonSyntaxException;
            }
            throw throwable;
        }
    }

    public JsonElement next() {
        Object object = "Failed parsing JSON source to Json";
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object object2 = this.parser;
            try {
                return Streams.parse((JsonReader)object2);
            }
            catch (JsonParseException jsonParseException) {
                NoSuchElementException noSuchElementException;
                object2 = jsonParseException.getCause();
                bl2 = object2 instanceof EOFException;
                if (bl2) {
                    noSuchElementException = new NoSuchElementException();
                }
                throw noSuchElementException;
            }
            catch (OutOfMemoryError outOfMemoryError) {
                JsonParseException jsonParseException = new JsonParseException((String)object, outOfMemoryError);
                throw jsonParseException;
            }
            catch (StackOverflowError stackOverflowError) {
                JsonParseException jsonParseException = new JsonParseException((String)object, stackOverflowError);
                throw jsonParseException;
            }
        }
        object = new NoSuchElementException();
        throw object;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

