/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonDataException;
import com.airbnb.lottie.parser.moshi.JsonEncodingException;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.parser.moshi.JsonScope;
import com.airbnb.lottie.parser.moshi.JsonUtf8Reader;
import h.n;
import h.o;
import java.io.Closeable;
import java.util.Arrays;

public abstract class JsonReader
implements Closeable {
    private static final String[] REPLACEMENT_CHARS;
    public boolean failOnUnknown;
    public boolean lenient;
    public int[] pathIndices;
    public String[] pathNames;
    public int[] scopes;
    public int stackSize;

    static {
        int n10;
        REPLACEMENT_CHARS = new String[128];
        String[] stringArray = null;
        for (int i10 = 0; i10 <= (n10 = 31); ++i10) {
            Object object;
            String[] stringArray2 = REPLACEMENT_CHARS;
            int n11 = 1;
            Object object2 = new Object[n11];
            object2[0] = object = Integer.valueOf(i10);
            object = "\\u%04x";
            stringArray2[i10] = object2 = String.format((String)object, object2);
        }
        stringArray = REPLACEMENT_CHARS;
        stringArray[34] = "\\\"";
        stringArray[92] = "\\\\";
        stringArray[9] = "\\t";
        stringArray[8] = "\\b";
        stringArray[10] = "\\n";
        stringArray[13] = "\\r";
        stringArray[12] = "\\f";
    }

    public JsonReader() {
        int n10 = 32;
        Object[] objectArray = new int[n10];
        this.scopes = objectArray;
        objectArray = new String[n10];
        this.pathNames = (String[])objectArray;
        int[] nArray = new int[n10];
        this.pathIndices = nArray;
    }

    public static /* synthetic */ void access$000(n n10, String string2) {
        JsonReader.string(n10, string2);
    }

    public static JsonReader of(o o10) {
        JsonUtf8Reader jsonUtf8Reader = new JsonUtf8Reader(o10);
        return jsonUtf8Reader;
    }

    private static void string(n n10, String string2) {
        String[] stringArray = REPLACEMENT_CHARS;
        int n11 = 34;
        n10.writeByte(n11);
        int n12 = string2.length();
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            String string3;
            int n14;
            int n15 = string2.charAt(i10);
            if (n15 < (n14 = 128)) {
                string3 = stringArray[n15];
                if (string3 == null) {
                    continue;
                }
            } else {
                n14 = 8232;
                if (n15 == n14) {
                    string3 = "\\u2028";
                } else {
                    n14 = 8233;
                    if (n15 != n14) continue;
                    string3 = "\\u2029";
                }
            }
            if (n13 < i10) {
                n10.u(string2, n13, i10);
            }
            n10.r(string3);
            n13 = i10 + 1;
        }
        if (n13 < n12) {
            n10.u(string2, n13, n12);
        }
        n10.writeByte(n11);
    }

    public abstract void beginArray();

    public abstract void beginObject();

    public abstract void endArray();

    public abstract void endObject();

    public final String getPath() {
        int n10 = this.stackSize;
        int[] nArray = this.scopes;
        String[] stringArray = this.pathNames;
        int[] nArray2 = this.pathIndices;
        return JsonScope.getPath(n10, nArray, stringArray, nArray2);
    }

    public abstract boolean hasNext();

    public abstract boolean nextBoolean();

    public abstract double nextDouble();

    public abstract int nextInt();

    public abstract String nextName();

    public abstract String nextString();

    public abstract JsonReader$Token peek();

    public final void pushScope(int n10) {
        int n11;
        Object[] objectArray;
        int n12 = this.stackSize;
        Object object = this.scopes;
        int n13 = ((int[])object).length;
        if (n12 == n13) {
            n13 = 256;
            if (n12 != n13) {
                n12 = ((int[])object).length * 2;
                this.scopes = objectArray = Arrays.copyOf(object, n12);
                objectArray = this.pathNames;
                n11 = objectArray.length * 2;
                objectArray = (String[])Arrays.copyOf(objectArray, n11);
                this.pathNames = (String[])objectArray;
                objectArray = this.pathIndices;
                n11 = objectArray.length * 2;
                objectArray = Arrays.copyOf(objectArray, n11);
                this.pathIndices = objectArray;
            } else {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Nesting too deep at ");
                object = this.getPath();
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                JsonDataException jsonDataException = new JsonDataException((String)charSequence);
                throw jsonDataException;
            }
        }
        objectArray = this.scopes;
        n11 = this.stackSize;
        this.stackSize = n13 = n11 + 1;
        objectArray[n11] = n10;
    }

    public abstract int selectName(JsonReader$Options var1);

    public abstract void skipName();

    public abstract void skipValue();

    public final JsonEncodingException syntaxError(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" at path ");
        string2 = this.getPath();
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        JsonEncodingException jsonEncodingException = new JsonEncodingException(string2);
        throw jsonEncodingException;
    }
}

