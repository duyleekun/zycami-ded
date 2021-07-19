/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

public class JsonWriter
implements Closeable,
Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack;
    private int stackSize;

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
        stringArray = (String[])stringArray.clone();
        HTML_SAFE_REPLACEMENT_CHARS = stringArray;
        stringArray[60] = "\\u003c";
        stringArray[62] = "\\u003e";
        stringArray[38] = "\\u0026";
        stringArray[61] = "\\u003d";
        stringArray[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        int[] nArray = new int[32];
        this.stack = nArray;
        this.stackSize = 0;
        this.push(6);
        this.separator = ":";
        this.serializeNulls = true;
        Objects.requireNonNull(writer, "out == null");
        this.out = writer;
    }

    private void beforeName() {
        block4: {
            block3: {
                int n10;
                int n11;
                block2: {
                    n11 = this.peek();
                    if (n11 != (n10 = 5)) break block2;
                    Writer writer = this.out;
                    n10 = 44;
                    writer.write(n10);
                    break block3;
                }
                n10 = 3;
                if (n11 != n10) break block4;
            }
            this.newline();
            this.replaceTop(4);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Nesting problem.");
        throw illegalStateException;
    }

    private void beforeValue() {
        int n10 = this.peek();
        int n11 = 1;
        int n12 = 2;
        if (n10 != n11) {
            if (n10 != n12) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 6;
                    n12 = 7;
                    if (n10 != n11) {
                        if (n10 == n12) {
                            n10 = (int)(this.lenient ? 1 : 0);
                            if (n10 == 0) {
                                IllegalStateException illegalStateException = new IllegalStateException("JSON must have only one top-level value.");
                                throw illegalStateException;
                            }
                        } else {
                            IllegalStateException illegalStateException = new IllegalStateException("Nesting problem.");
                            throw illegalStateException;
                        }
                    }
                    this.replaceTop(n12);
                } else {
                    Writer writer = this.out;
                    String string2 = this.separator;
                    writer.append(string2);
                    n10 = 5;
                    this.replaceTop(n10);
                }
            } else {
                Writer writer = this.out;
                n11 = 44;
                writer.append((char)n11);
                this.newline();
            }
        } else {
            this.replaceTop(n12);
            this.newline();
        }
    }

    private JsonWriter close(int n10, int n11, char c10) {
        int n12 = this.peek();
        if (n12 != n11 && n12 != n10) {
            IllegalStateException illegalStateException = new IllegalStateException("Nesting problem.");
            throw illegalStateException;
        }
        Object object = this.deferredName;
        if (object == null) {
            this.stackSize = n10 = this.stackSize + -1;
            if (n12 == n11) {
                this.newline();
            }
            this.out.write(c10);
            return this;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Dangling name: ");
        String string2 = this.deferredName;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    private void newline() {
        Object object = this.indent;
        if (object == null) {
            return;
        }
        object = this.out;
        ((Writer)object).write(10);
        int n10 = this.stackSize;
        for (int i10 = 1; i10 < n10; ++i10) {
            Writer writer = this.out;
            String string2 = this.indent;
            writer.write(string2);
        }
    }

    private JsonWriter open(int n10, char c10) {
        this.beforeValue();
        this.push(n10);
        this.out.write(c10);
        return this;
    }

    private int peek() {
        int n10 = this.stackSize;
        if (n10 != 0) {
            int[] nArray = this.stack;
            return nArray[n10 += -1];
        }
        IllegalStateException illegalStateException = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException;
    }

    private void push(int n10) {
        int[] nArray;
        int n11 = this.stackSize;
        int[] nArray2 = this.stack;
        int n12 = nArray2.length;
        if (n11 == n12) {
            this.stack = nArray = Arrays.copyOf(nArray2, n11 *= 2);
        }
        nArray = this.stack;
        int n13 = this.stackSize;
        this.stackSize = n12 = n13 + 1;
        nArray[n13] = n10;
    }

    private void replaceTop(int n10) {
        int[] nArray = this.stack;
        int n11 = this.stackSize + -1;
        nArray[n11] = n10;
    }

    private void string(String string2) {
        boolean bl2 = this.htmlSafe;
        Object object = bl2 ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        Writer writer = this.out;
        int n10 = 34;
        writer.write(n10);
        int n11 = string2.length();
        int n12 = 0;
        Writer writer2 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            String string3;
            int n13;
            int n14 = string2.charAt(i10);
            if (n14 < (n13 = 128)) {
                string3 = object[n14];
                if (string3 == null) {
                    continue;
                }
            } else {
                n13 = 8232;
                if (n14 == n13) {
                    string3 = "\\u2028";
                } else {
                    n13 = 8233;
                    if (n14 != n13) continue;
                    string3 = "\\u2029";
                }
            }
            if (n12 < i10) {
                Writer writer3 = this.out;
                int n15 = i10 - n12;
                writer3.write(string2, n12, n15);
            }
            writer2 = this.out;
            writer2.write(string3);
            n12 = i10 + 1;
        }
        if (n12 < n11) {
            object = this.out;
            ((Writer)object).write(string2, n12, n11 -= n12);
        }
        this.out.write(n10);
    }

    private void writeDeferredName() {
        String string2 = this.deferredName;
        if (string2 != null) {
            this.beforeName();
            string2 = this.deferredName;
            this.string(string2);
            string2 = null;
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() {
        this.writeDeferredName();
        return this.open(1, '[');
    }

    public JsonWriter beginObject() {
        this.writeDeferredName();
        return this.open(3, '{');
    }

    public void close() {
        Object object;
        block2: {
            block3: {
                object = this.out;
                ((Writer)object).close();
                int n10 = this.stackSize;
                int n11 = 1;
                if (n10 > n11) break block2;
                if (n10 != n11) break block3;
                int[] nArray = this.stack;
                n10 -= n11;
                n11 = 7;
                if ((n10 = nArray[n10]) != n11) break block2;
            }
            this.stackSize = 0;
            return;
        }
        object = new IOException("Incomplete document");
        throw object;
    }

    public JsonWriter endArray() {
        return this.close(1, 2, ']');
    }

    public JsonWriter endObject() {
        return this.close(3, 5, '}');
    }

    public void flush() {
        int n10 = this.stackSize;
        if (n10 != 0) {
            this.out.flush();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String string2) {
        if (string2 == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        this.out.append(string2);
        return this;
    }

    public JsonWriter name(String object) {
        Objects.requireNonNull(object, "name == null");
        String string2 = this.deferredName;
        if (string2 == null) {
            int n10 = this.stackSize;
            if (n10 != 0) {
                this.deferredName = object;
                return this;
            }
            object = new IllegalStateException("JsonWriter is closed.");
            throw object;
        }
        object = new IllegalStateException();
        throw object;
    }

    public JsonWriter nullValue() {
        String string2 = this.deferredName;
        if (string2 != null) {
            boolean bl2 = this.serializeNulls;
            if (bl2) {
                this.writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        this.beforeValue();
        this.out.write("null");
        return this;
    }

    public final void setHtmlSafe(boolean bl2) {
        this.htmlSafe = bl2;
    }

    public final void setIndent(String string2) {
        int n10 = string2.length();
        if (n10 == 0) {
            this.indent = null;
            this.separator = string2 = ":";
        } else {
            this.indent = string2;
            this.separator = string2 = ": ";
        }
    }

    public final void setLenient(boolean bl2) {
        this.lenient = bl2;
    }

    public final void setSerializeNulls(boolean bl2) {
        this.serializeNulls = bl2;
    }

    public JsonWriter value(double d10) {
        this.writeDeferredName();
        boolean bl2 = this.lenient;
        if (!bl2 && ((bl2 = Double.isNaN(d10)) || (bl2 = Double.isInfinite(d10)))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(d10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        this.beforeValue();
        Writer writer = this.out;
        String string3 = Double.toString(d10);
        writer.append(string3);
        return this;
    }

    public JsonWriter value(long l10) {
        this.writeDeferredName();
        this.beforeValue();
        Writer writer = this.out;
        String string2 = Long.toString(l10);
        writer.write(string2);
        return this;
    }

    public JsonWriter value(Boolean object) {
        if (object == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        Writer writer = this.out;
        boolean bl2 = (Boolean)object;
        object = bl2 ? "true" : "false";
        writer.write((String)object);
        return this;
    }

    public JsonWriter value(Number object) {
        CharSequence charSequence;
        if (object == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        Object object2 = object.toString();
        boolean bl2 = this.lenient;
        if (!bl2 && ((bl2 = ((String)object2).equals(charSequence = "-Infinity")) || (bl2 = ((String)object2).equals(charSequence = "Infinity")) || (bl2 = ((String)object2).equals(charSequence = "NaN")))) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Numeric values must be finite, but was ");
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        this.beforeValue();
        this.out.append((CharSequence)object2);
        return this;
    }

    public JsonWriter value(String string2) {
        if (string2 == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        this.string(string2);
        return this;
    }

    public JsonWriter value(boolean bl2) {
        this.writeDeferredName();
        this.beforeValue();
        Writer writer = this.out;
        String string2 = bl2 ? "true" : "false";
        writer.write(string2);
        return this;
    }
}

