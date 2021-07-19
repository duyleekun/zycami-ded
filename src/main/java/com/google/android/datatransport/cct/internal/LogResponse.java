/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  android.util.JsonToken
 */
package com.google.android.datatransport.cct.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import com.google.android.datatransport.cct.internal.AutoValue_LogResponse;
import java.io.IOException;
import java.io.Reader;

public abstract class LogResponse {
    private static final String LOG_TAG = "LogResponseInternal";

    public static LogResponse create(long l10) {
        AutoValue_LogResponse autoValue_LogResponse = new AutoValue_LogResponse(l10);
        return autoValue_LogResponse;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static LogResponse fromJson(Reader object) {
        JsonReader jsonReader = new JsonReader((Reader)object);
        try {
            String string2;
            boolean bl2;
            jsonReader.beginObject();
            while (bl2 = jsonReader.hasNext()) {
                object = jsonReader.nextName();
                bl2 = ((String)object).equals(string2 = "nextRequestWaitMillis");
                if (bl2) {
                    object = jsonReader.peek();
                    if (object == (string2 = JsonToken.STRING)) {
                        object = jsonReader.nextString();
                        long l10 = Long.parseLong((String)object);
                        object = LogResponse.create(l10);
                        return object;
                    }
                    long l11 = jsonReader.nextLong();
                    object = LogResponse.create(l11);
                    return object;
                }
                jsonReader.skipValue();
            }
            string2 = "Response is missing nextRequestWaitMillis field.";
            object = new IOException(string2);
            throw object;
        }
        finally {
            jsonReader.close();
        }
    }

    public abstract long getNextRequestWaitMillis();
}

