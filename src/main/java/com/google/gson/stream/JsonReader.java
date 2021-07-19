/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.stream.JsonReader$1;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

public class JsonReader
implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer;
    private final Reader in;
    private boolean lenient = false;
    private int limit;
    private int lineNumber;
    private int lineStart;
    private int[] pathIndices;
    private String[] pathNames;
    public int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos;
    private int[] stack;
    private int stackSize;

    static {
        JsonReader$1 jsonReader$1 = new JsonReader$1();
        JsonReaderInternalAccess.INSTANCE = jsonReader$1;
    }

    public JsonReader(Reader reader) {
        int n10;
        char[] cArray = new char[1024];
        this.buffer = cArray;
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        int n11 = 32;
        int[] nArray = new int[n11];
        this.stack = nArray;
        this.stackSize = 0;
        this.stackSize = n10 = 0 + 1;
        nArray[0] = 6;
        Object[] objectArray = new String[n11];
        this.pathNames = objectArray;
        objectArray = new int[n11];
        this.pathIndices = (int[])objectArray;
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() {
        boolean bl2 = this.lenient;
        if (bl2) {
            return;
        }
        throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() {
        int n10;
        int n11 = 1;
        this.nextNonWhitespace(n11 != 0);
        this.pos = n10 = this.pos - n11;
        n11 = n10 + 5;
        int n12 = this.limit;
        int n13 = 5;
        if (n11 > n12 && (n11 = (int)(this.fillBuffer(n13) ? 1 : 0)) == 0) {
            return;
        }
        char[] cArray = this.buffer;
        n12 = cArray[n10];
        int n14 = 41;
        if (n12 == n14) {
            n12 = n10 + 1;
            n14 = 93;
            if ((n12 = cArray[n12]) == n14) {
                n12 = n10 + 2;
                n14 = 125;
                if ((n12 = cArray[n12]) == n14) {
                    n12 = n10 + 3;
                    n14 = 39;
                    if ((n12 = cArray[n12]) == n14) {
                        n10 += 4;
                        n11 = cArray[n10];
                        if (n11 == (n10 = 10)) {
                            this.pos = n11 = this.pos + n13;
                        }
                    }
                }
            }
        }
    }

    private boolean fillBuffer(int n10) {
        block3: {
            int n11;
            char[] cArray = this.buffer;
            int n12 = this.lineStart;
            int n13 = this.pos;
            this.lineStart = n12 -= n13;
            n12 = this.limit;
            if (n12 != n13) {
                this.limit = n12 -= n13;
                System.arraycopy(cArray, n13, cArray, 0, n12);
            } else {
                this.limit = 0;
            }
            this.pos = 0;
            do {
                int n14;
                int n15;
                Reader reader = this.in;
                n13 = this.limit;
                n11 = cArray.length - n13;
                n12 = reader.read(cArray, n13, n11);
                if (n12 == (n13 = -1)) break block3;
                this.limit = n13 = this.limit + n12;
                n12 = this.lineNumber;
                n11 = 1;
                if (n12 != 0 || (n12 = this.lineStart) != 0 || n13 <= 0 || (n15 = cArray[0]) != (n14 = 65279)) continue;
                this.pos = n15 = this.pos + n11;
                this.lineStart = ++n12;
                ++n10;
            } while (n13 < n10);
            return n11 != 0;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private boolean isLiteral(char var1_1) {
        block4: {
            var2_2 = 9;
            if (var1_1 == var2_2 || var1_1 == (var2_2 = 10) || var1_1 == (var2_2 = 12) || var1_1 == (var2_2 = 13) || var1_1 == (var2_2 = 32)) break block4;
            var2_2 = 35;
            if (var1_1 == var2_2) ** GOTO lbl-1000
            var2_2 = 44;
            if (var1_1 == var2_2) break block4;
            var2_2 = 47;
            if (var1_1 == var2_2 || var1_1 == (var2_2 = 61)) ** GOTO lbl-1000
            var2_2 = 123;
            if (var1_1 == var2_2 || var1_1 == (var2_2 = 125) || var1_1 == (var2_2 = 58)) break block4;
            var2_2 = 59;
            if (var1_1 == var2_2) ** GOTO lbl-1000
            switch (var1_1) {
                default: {
                    return true;
                }
                case 92: lbl-1000:
                // 4 sources

                {
                    this.checkLenient();
                }
                case 91: 
                case 93: 
            }
        }
        return false;
    }

    private int nextNonWhitespace(boolean bl2) {
        Object object = this.buffer;
        int n10 = this.pos;
        int n11 = this.limit;
        while (true) {
            String string2;
            int n12 = 1;
            if (n10 == n11) {
                this.pos = n10;
                n10 = (int)(this.fillBuffer(n12) ? 1 : 0);
                if (n10 == 0) {
                    if (!bl2) {
                        return -1;
                    }
                    object = new StringBuilder;
                    ((StringBuilder)object)();
                    ((StringBuilder)object).append("End of input");
                    string2 = this.locationString();
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                    EOFException eOFException = new EOFException((String)object);
                    throw eOFException;
                }
                n10 = this.pos;
                n11 = this.limit;
            }
            int n13 = n10 + 1;
            int n14 = 10;
            if ((n10 = object[n10]) == n14) {
                this.lineNumber = n10 = this.lineNumber + n12;
                this.lineStart = n13;
            } else {
                n14 = 32;
                if (n10 != n14 && n10 != (n14 = 13) && n10 != (n14 = 9)) {
                    n14 = 47;
                    if (n10 == n14) {
                        this.pos = n13;
                        int n15 = 2;
                        if (n13 == n11) {
                            this.pos = n13 += -1;
                            n11 = (int)(this.fillBuffer(n15) ? 1 : 0);
                            this.pos = n13 = this.pos + n12;
                            if (n11 == 0) {
                                return n10;
                            }
                        }
                        this.checkLenient();
                        n11 = this.pos;
                        n12 = (int)object[n11];
                        n13 = 42;
                        if (n12 != n13) {
                            if (n12 != n14) {
                                return n10;
                            }
                            this.pos = ++n11;
                            this.skipToEndOfLine();
                            n10 = this.pos;
                            n11 = this.limit;
                            continue;
                        }
                        this.pos = ++n11;
                        string2 = "*/";
                        n10 = (int)(this.skipTo(string2) ? 1 : 0);
                        if (n10 != 0) {
                            n10 = this.pos + n15;
                            n11 = this.limit;
                            continue;
                        }
                        throw this.syntaxError("Unterminated comment");
                    }
                    n11 = 35;
                    if (n10 == n11) {
                        this.pos = n13;
                        this.checkLenient();
                        this.skipToEndOfLine();
                        n10 = this.pos;
                        n11 = this.limit;
                        continue;
                    }
                    this.pos = n13;
                    return n10;
                }
            }
            n10 = n13;
        }
    }

    private String nextQuotedValue(char c10) {
        int n10;
        char[] cArray = this.buffer;
        int n11 = 0;
        StringBuilder stringBuilder = null;
        do {
            int n12;
            int n13;
            int n14;
            n10 = this.pos;
            int n15 = this.limit;
            block1: while (true) {
                n14 = n15;
                n15 = n10;
                while (true) {
                    n13 = 16;
                    n12 = 1;
                    if (n10 >= n14) break block1;
                    int n16 = n10 + 1;
                    if ((n10 = cArray[n10]) == c10) {
                        this.pos = n16;
                        n16 = n16 - n15 - n12;
                        if (stringBuilder == null) {
                            String string2 = new String(cArray, n15, n16);
                            return string2;
                        }
                        stringBuilder.append(cArray, n15, n16);
                        return stringBuilder.toString();
                    }
                    int n17 = 92;
                    if (n10 == n17) {
                        this.pos = n16;
                        n16 = n16 - n15 - n12;
                        if (stringBuilder == null) {
                            StringBuilder stringBuilder2;
                            n11 = (n16 + 1) * 2;
                            n11 = Math.max(n11, n13);
                            stringBuilder = stringBuilder2 = new StringBuilder(n11);
                        }
                        stringBuilder.append(cArray, n15, n16);
                        n10 = this.readEscapeCharacter();
                        stringBuilder.append((char)n10);
                        n10 = this.pos;
                        n15 = this.limit;
                        continue block1;
                    }
                    n13 = 10;
                    if (n10 == n13) {
                        this.lineNumber = n10 = this.lineNumber + n12;
                        this.lineStart = n16;
                    }
                    n10 = n16;
                }
                break;
            }
            if (stringBuilder == null) {
                StringBuilder stringBuilder3;
                n11 = (n10 - n15) * 2;
                n11 = Math.max(n11, n13);
                stringBuilder = stringBuilder3 = new StringBuilder(n11);
            }
            n14 = n10 - n15;
            stringBuilder.append(cArray, n15, n14);
            this.pos = n10;
            n10 = (int)(this.fillBuffer(n12) ? 1 : 0);
        } while (n10 != 0);
        throw this.syntaxError("Unterminated string");
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private String nextUnquotedValue() {
        var1_1 = 0;
        var2_2 = null;
        do {
            block10: {
                var3_3 = 0;
                var4_4 = null;
                block5: while (true) {
                    if ((var6_6 = (var5_5 = this.pos) + var3_3) >= (var7_7 = this.limit)) ** GOTO lbl29
                    var8_8 = this.buffer;
                    var5_5 += var3_3;
                    var6_6 = 9;
                    if ((var5_5 = var8_8[var5_5]) == var6_6 || var5_5 == (var6_6 = 10) || var5_5 == (var6_6 = 12) || var5_5 == (var6_6 = 13) || var5_5 == (var6_6 = 32)) break;
                    var6_6 = 35;
                    if (var5_5 == var6_6) ** GOTO lbl-1000
                    var6_6 = 44;
                    if (var5_5 == var6_6) break;
                    var6_6 = 47;
                    if (var5_5 == var6_6 || var5_5 == (var6_6 = 61)) ** GOTO lbl-1000
                    var6_6 = 123;
                    if (var5_5 == var6_6 || var5_5 == (var6_6 = 125) || var5_5 == (var6_6 = 58)) break;
                    var6_6 = 59;
                    if (var5_5 == var6_6) ** GOTO lbl-1000
                    switch (var5_5) {
                        default: {
                            ++var3_3;
                            continue block5;
                        }
                        case 92: lbl-1000:
                        // 4 sources

                        {
                            this.checkLenient();
                            break block5;
                        }
lbl29:
                        // 1 sources

                        var9_9 = this.buffer;
                        var5_5 = var9_9.length;
                        if (var3_3 < var5_5) {
                            var5_5 = var3_3 + 1;
                            if ((var5_5 = (int)this.fillBuffer(var5_5)) == 0) break block5;
                            continue block5;
                        }
                        break block10;
                        case 91: 
                        case 93: 
                    }
                    break;
                }
                var1_1 = var3_3;
                break;
            }
            if (var2_2 == null) {
                var5_5 = Math.max(var3_3, 16);
                var2_2 = new StringBuilder(var5_5);
            }
            var9_9 = this.buffer;
            var6_6 = this.pos;
            var2_2.append(var9_9, var6_6, var3_3);
            this.pos = var5_5 = this.pos + var3_3;
        } while ((var3_3 = (int)this.fillBuffer(1)) != 0);
        if (var2_2 == null) {
            var4_4 = this.buffer;
            var5_5 = this.pos;
            var2_2 = new String(var4_4, var5_5, var1_1);
        } else {
            var4_4 = this.buffer;
            var5_5 = this.pos;
            var2_2.append(var4_4, var5_5, var1_1);
            var2_2 = var2_2.toString();
        }
        this.pos = var3_3 = this.pos + var1_1;
        return var2_2;
    }

    private int peekKeyword() {
        Object object;
        boolean bl2;
        int n10;
        boolean bl3;
        String string2;
        Object object2;
        int n11;
        char[] cArray = this.buffer;
        int n12 = this.pos;
        int n112 = cArray[n12];
        n12 = 0;
        int c10 = 116;
        if (n112 != c10 && n112 != (n11 = 84)) {
            int n13;
            int n14 = 102;
            if (n112 != n14 && n112 != (n13 = 70)) {
                int n15;
                int n16 = 110;
                if (n112 != n16 && n112 != (n15 = 78)) {
                    return 0;
                }
                n112 = 7;
                object2 = "null";
                string2 = "NULL";
            } else {
                n112 = 6;
                object2 = "false";
                string2 = "FALSE";
            }
        } else {
            n112 = 5;
            object2 = "true";
            string2 = "TRUE";
        }
        int n17 = ((String)object2).length();
        for (int i10 = 1; i10 < n17; ++i10) {
            int n18 = this.pos + i10;
            int n19 = this.limit;
            if (n18 >= n19) {
                n18 = i10 + 1;
                if ((n18 = (int)(this.fillBuffer(n18) ? 1 : 0)) == 0) {
                    return 0;
                }
            }
            char[] cArray2 = this.buffer;
            n19 = this.pos + i10;
            n18 = cArray2[n19];
            if (n18 == (n19 = (int)((String)object2).charAt(i10)) || n18 == (n19 = (int)string2.charAt(i10))) continue;
            return 0;
        }
        int n20 = this.pos + n17;
        int n21 = this.limit;
        if ((n20 < n21 || (bl3 = this.fillBuffer(n10 = n17 + 1))) && (bl2 = this.isLiteral((char)(object = (object2 = (Object)this.buffer)[n21 = this.pos + n17])))) {
            return 0;
        }
        this.pos = n12 = this.pos + n17;
        this.peeked = n112;
        return n112;
    }

    private int peekNumber() {
        JsonReader jsonReader = this;
        char[] cArray = this.buffer;
        int n10 = this.pos;
        int n11 = this.limit;
        int n12 = 1;
        int n13 = 0;
        int n14 = n12;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        long l10 = 0L;
        while (true) {
            block25: {
                int n18;
                block27: {
                    long l11;
                    int n19;
                    block15: {
                        int n20;
                        block16: {
                            block28: {
                                block17: {
                                    block18: {
                                        block26: {
                                            long l12;
                                            long l13;
                                            long l14;
                                            int n21;
                                            block14: {
                                                int n22;
                                                block19: {
                                                    block24: {
                                                        block22: {
                                                            block20: {
                                                                block23: {
                                                                    block21: {
                                                                        block13: {
                                                                            n22 = n10 + n15;
                                                                            n20 = 2;
                                                                            if (n22 != n11) break block13;
                                                                            n10 = cArray.length;
                                                                            if (n15 == n10) {
                                                                                return 0;
                                                                            }
                                                                            n10 = n15 + 1;
                                                                            if ((n10 = (int)(jsonReader.fillBuffer(n10) ? 1 : 0)) == 0) break block14;
                                                                            n10 = jsonReader.pos;
                                                                            n11 = jsonReader.limit;
                                                                        }
                                                                        n22 = n10 + n15;
                                                                        n22 = cArray[n22];
                                                                        n13 = 43;
                                                                        n18 = 3;
                                                                        n19 = 5;
                                                                        if (n22 == n13) break block15;
                                                                        n13 = 69;
                                                                        if (n22 == n13 || n22 == (n13 = 101)) break block16;
                                                                        n13 = 45;
                                                                        if (n22 == n13) break block17;
                                                                        n13 = 46;
                                                                        if (n22 == n13) break block18;
                                                                        n13 = 48;
                                                                        if (n22 < n13 || n22 > (n13 = 57)) break block19;
                                                                        if (n16 == n12 || n16 == 0) break block20;
                                                                        if (n16 != n20) break block21;
                                                                        l11 = 0L;
                                                                        long l15 = l10 - l11;
                                                                        n18 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                                                                        if (n18 == 0) {
                                                                            return 0;
                                                                        }
                                                                        long l16 = (long)10 * l10;
                                                                        long l17 = n22 += -48;
                                                                        l16 -= l17;
                                                                        l17 = -922337203685477580L;
                                                                        long l18 = l10 - l17;
                                                                        n13 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
                                                                        n13 = n13 <= 0 && (n13 != 0 || (n13 = (int)(l16 == l10 ? 0 : (l16 < l10 ? -1 : 1))) >= 0) ? 0 : n12;
                                                                        n14 &= n13;
                                                                        l10 = l16;
                                                                        break block22;
                                                                    }
                                                                    if (n16 != n18) break block23;
                                                                    n13 = 0;
                                                                    n16 = 4;
                                                                    break block24;
                                                                }
                                                                if (n16 != n19 && n16 != (n18 = 6)) break block22;
                                                                n13 = 0;
                                                                n16 = 7;
                                                                break block24;
                                                            }
                                                            n18 = -(n22 += -48);
                                                            l10 = n18;
                                                            n16 = n20;
                                                        }
                                                        n13 = 0;
                                                    }
                                                    l11 = 0L;
                                                    break block25;
                                                }
                                                n21 = (int)(jsonReader.isLiteral((char)n22) ? 1 : 0);
                                                if (n21 != 0) break block26;
                                            }
                                            if (!(n16 != n20 || n14 == 0 || (n21 = (int)((l14 = l10 - (l13 = Long.MIN_VALUE)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) == 0 && n17 == 0 || (n21 = (int)((l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0 && n17 != 0)) {
                                                if (n17 == 0) {
                                                    l10 = -l10;
                                                }
                                                jsonReader.peekedLong = l10;
                                                jsonReader.pos = n21 = jsonReader.pos + n15;
                                                jsonReader.peeked = n21 = 15;
                                                return n21;
                                            }
                                            if (n16 != n20 && n16 != (n21 = 4) && n16 != (n21 = 7)) {
                                                return 0;
                                            }
                                            jsonReader.peekedNumberLength = n15;
                                            jsonReader.peeked = n21 = 16;
                                            return n21;
                                        }
                                        return 0;
                                    }
                                    n13 = 0;
                                    l11 = 0L;
                                    if (n16 != n20) {
                                        return 0;
                                    }
                                    break block27;
                                }
                                n18 = 6;
                                n13 = 0;
                                l11 = 0L;
                                if (n16 != 0) break block28;
                                n16 = n12;
                                n17 = n12;
                                break block25;
                            }
                            if (n16 != n19) {
                                return 0;
                            }
                            break block27;
                        }
                        n13 = 0;
                        l11 = 0L;
                        if (n16 != n20 && n16 != (n18 = 4)) {
                            return 0;
                        }
                        n16 = n19;
                        break block25;
                    }
                    n18 = 6;
                    n13 = 0;
                    l11 = 0L;
                    if (n16 != n19) break;
                }
                n16 = n18;
            }
            ++n15;
        }
        return 0;
    }

    private void push(int n10) {
        Object[] objectArray;
        int n11 = this.stackSize;
        Object[] objectArray2 = this.stack;
        int n12 = objectArray2.length;
        if (n11 == n12) {
            this.stack = objectArray2 = Arrays.copyOf(objectArray2, n11 *= 2);
            objectArray2 = Arrays.copyOf(this.pathIndices, n11);
            this.pathIndices = objectArray2;
            objectArray2 = this.pathNames;
            objectArray = (String[])Arrays.copyOf(objectArray2, n11);
            this.pathNames = (String[])objectArray;
        }
        objectArray = this.stack;
        int n13 = this.stackSize;
        this.stackSize = n12 = n13 + 1;
        objectArray[n13] = n10;
    }

    /*
     * Enabled aggressive block sorting
     */
    private char readEscapeCharacter() {
        int n10;
        int n11;
        int n12;
        CharSequence charSequence;
        int n13;
        int n14;
        block16: {
            block15: {
                block14: {
                    n14 = this.pos;
                    n13 = this.limit;
                    charSequence = "Unterminated escape sequence";
                    n12 = 1;
                    if (n14 == n13 && (n14 = (int)(this.fillBuffer(n12) ? 1 : 0)) == 0) {
                        throw this.syntaxError((String)charSequence);
                    }
                    char[] cArray = this.buffer;
                    n13 = this.pos;
                    this.pos = n11 = n13 + 1;
                    n14 = cArray[n13];
                    if (n14 == (n13 = 10)) break block14;
                    n12 = 34;
                    if (n14 == n12 || n14 == (n12 = 39) || n14 == (n12 = 47) || n14 == (n12 = 92)) break block15;
                    n12 = 98;
                    if (n14 == n12) {
                        return '\b';
                    }
                    n12 = 102;
                    if (n14 == n12) {
                        return '\f';
                    }
                    n10 = 110;
                    if (n14 == n10) {
                        return (char)n13;
                    }
                    n10 = 114;
                    if (n14 == n10) {
                        return '\r';
                    }
                    n10 = 116;
                    if (n14 == n10) {
                        return '\t';
                    }
                    n10 = 117;
                    if (n14 != n10) {
                        throw this.syntaxError("Invalid escape sequence");
                    }
                    n14 = 4;
                    n10 = this.limit;
                    if ((n11 += n14) > n10 && (n11 = (int)(this.fillBuffer(n14) ? 1 : 0)) == 0) {
                        throw this.syntaxError((String)charSequence);
                    }
                    break block16;
                }
                this.lineNumber = n13 = this.lineNumber + n12;
                this.lineStart = n11;
            }
            return (char)n14;
        }
        char c10 = '\u0000';
        charSequence = null;
        n11 = this.pos;
        n10 = n11 + 4;
        while (true) {
            if (n11 >= n10) {
                this.pos = n13 = this.pos + n14;
                return c10;
            }
            char[] cArray = this.buffer;
            int n15 = cArray[n11];
            c10 = (char)(c10 << 4);
            int n16 = 48;
            if (n15 >= n16 && n15 <= (n16 = 57)) {
                n15 += -48;
            } else {
                n16 = 97;
                if (n15 >= n16 && n15 <= n12) {
                    n15 += -97;
                } else {
                    n16 = 65;
                    if (n15 < n16 || n15 > (n16 = 70)) break;
                    n15 += -65;
                }
                n15 += n13;
            }
            c10 = (char)(c10 + n15);
            ++n11;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("\\u");
        char[] cArray = this.buffer;
        n10 = this.pos;
        String string2 = new String(cArray, n10, n14);
        ((StringBuilder)charSequence).append(string2);
        String string3 = ((StringBuilder)charSequence).toString();
        NumberFormatException numberFormatException = new NumberFormatException(string3);
        throw numberFormatException;
    }

    private void skipQuotedValue(char c10) {
        int n10;
        int n11;
        char[] cArray = this.buffer;
        do {
            n11 = this.pos;
            int n12 = this.limit;
            while (true) {
                n10 = 1;
                if (n11 >= n12) break;
                int n13 = n11 + 1;
                if ((n11 = cArray[n11]) == c10) {
                    this.pos = n13;
                    return;
                }
                int n14 = 92;
                if (n11 == n14) {
                    this.pos = n13;
                    this.readEscapeCharacter();
                    n11 = this.pos;
                    n12 = this.limit;
                    continue;
                }
                n14 = 10;
                if (n11 == n14) {
                    this.lineNumber = n11 = this.lineNumber + n10;
                    this.lineStart = n13;
                }
                n11 = n13;
            }
            this.pos = n11;
        } while ((n11 = (int)(this.fillBuffer(n10) ? 1 : 0)) != 0);
        throw this.syntaxError("Unterminated string");
    }

    /*
     * Unable to fully structure code
     */
    private boolean skipTo(String var1_1) {
        var2_2 = var1_1.length();
        block0: while (true) {
            block3: {
                var3_3 = this.pos + var2_2;
                var4_4 = this.limit;
                if (var3_3 > var4_4 && (var3_3 = (int)this.fillBuffer(var2_2)) == 0) {
                    return false;
                }
                var6_6 = this.buffer;
                var4_4 = this.pos;
                var3_3 = var6_6[var4_4];
                var7_7 = 10;
                var8_8 = 1;
                if (var3_3 != var7_7) break block3;
                this.lineNumber = var3_3 = this.lineNumber + var8_8;
                this.lineStart = ++var4_4;
                ** GOTO lbl22
            }
            for (var5_5 = 0; var5_5 < var2_2; ++var5_5) {
                var6_6 = this.buffer;
                var4_4 = this.pos + var5_5;
                var3_3 = var6_6[var4_4];
                if (var3_3 == (var4_4 = (int)var1_1.charAt(var5_5))) continue;
lbl22:
                // 2 sources

                this.pos = var3_3 = this.pos + var8_8;
                continue block0;
            }
            break;
        }
        return (boolean)var8_8;
    }

    private void skipToEndOfLine() {
        int n10;
        int n11;
        do {
            int n12;
            n11 = this.pos;
            n10 = this.limit;
            int n13 = 1;
            if (n11 >= n10 && (n11 = (int)(this.fillBuffer(n13) ? 1 : 0)) == 0) break;
            char[] cArray = this.buffer;
            n10 = this.pos;
            this.pos = n12 = n10 + 1;
            n11 = cArray[n10];
            if (n11 != (n10 = 10)) continue;
            this.lineNumber = n11 = this.lineNumber + n13;
            this.lineStart = n12;
            break;
        } while (n11 != (n10 = 13));
    }

    /*
     * Unable to fully structure code
     */
    private void skipUnquotedValue() {
        do {
            var1_1 = 0;
            block5: while ((var3_3 = (var2_2 = this.pos) + var1_1) < (var4_4 = this.limit)) {
                block6: {
                    var5_5 = this.buffer;
                    var2_2 += var1_1;
                    var3_3 = 9;
                    if ((var2_2 = var5_5[var2_2]) == var3_3 || var2_2 == (var3_3 = 10) || var2_2 == (var3_3 = 12) || var2_2 == (var3_3 = 13) || var2_2 == (var3_3 = 32)) break block6;
                    var3_3 = 35;
                    if (var2_2 == var3_3) ** GOTO lbl-1000
                    var3_3 = 44;
                    if (var2_2 == var3_3) break block6;
                    var3_3 = 47;
                    if (var2_2 == var3_3 || var2_2 == (var3_3 = 61)) ** GOTO lbl-1000
                    var3_3 = 123;
                    if (var2_2 == var3_3 || var2_2 == (var3_3 = 125) || var2_2 == (var3_3 = 58)) break block6;
                    var3_3 = 59;
                    if (var2_2 == var3_3) ** GOTO lbl-1000
                    switch (var2_2) {
                        default: {
                            ++var1_1;
                            continue block5;
                        }
                        case 92: lbl-1000:
                        // 4 sources

                        {
                            this.checkLenient();
                        }
                        case 91: 
                        case 93: 
                    }
                }
                this.pos = var2_2 = this.pos + var1_1;
                return;
            }
            this.pos = var2_2 += var1_1;
        } while ((var1_1 = (int)this.fillBuffer(1)) != 0);
    }

    private IOException syntaxError(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        string2 = this.locationString();
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        MalformedJsonException malformedJsonException = new MalformedJsonException(string2);
        throw malformedJsonException;
    }

    public void beginArray() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        if (n11 == (n10 = 3)) {
            n11 = 1;
            this.push(n11);
            int[] nArray = this.pathIndices;
            int n12 = this.stackSize - n11;
            nArray[n12] = 0;
            this.peeked = 0;
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected BEGIN_ARRAY but was ");
        Object object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public void beginObject() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        if (n11 == (n10 = 1)) {
            this.push(3);
            this.peeked = 0;
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected BEGIN_OBJECT but was ");
        Object object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public void close() {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        block32: {
            Object object;
            block37: {
                int n20;
                int n21;
                int n22;
                int n23;
                int n24;
                block30: {
                    block36: {
                        block35: {
                            block33: {
                                block34: {
                                    block31: {
                                        block29: {
                                            object = this.stack;
                                            n19 = this.stackSize;
                                            n18 = n19 + -1;
                                            n18 = object[n18];
                                            n24 = 8;
                                            n17 = 39;
                                            n16 = 34;
                                            n23 = 93;
                                            n22 = 3;
                                            n21 = 7;
                                            n15 = 59;
                                            n14 = 44;
                                            n13 = 4;
                                            n12 = 2;
                                            n11 = 1;
                                            if (n18 != n11) break block29;
                                            object[n19 -= n11] = n12;
                                            break block30;
                                        }
                                        if (n18 != n12) break block31;
                                        n20 = this.nextNonWhitespace(n11 != 0);
                                        if (n20 != n14) {
                                            if (n20 != n15) {
                                                if (n20 == n23) {
                                                    this.peeked = n13;
                                                    return n13;
                                                }
                                                throw this.syntaxError("Unterminated array");
                                            }
                                            this.checkLenient();
                                        }
                                        break block30;
                                    }
                                    n10 = 5;
                                    if (n18 == n22 || n18 == n10) break block32;
                                    if (n18 != n13) break block33;
                                    object[n19 -= n11] = n10;
                                    n20 = this.nextNonWhitespace(n11 != 0);
                                    if (n20 == (n19 = 58)) break block30;
                                    n19 = 61;
                                    if (n20 != n19) break block34;
                                    this.checkLenient();
                                    n20 = this.pos;
                                    n19 = this.limit;
                                    if ((n20 < n19 || (n20 = (int)(this.fillBuffer(n11) ? 1 : 0)) != 0) && (n20 = (object = (Object)this.buffer)[n19 = this.pos]) == (n10 = 62)) {
                                        this.pos = n19 += n11;
                                    }
                                    break block30;
                                }
                                throw this.syntaxError("Expected ':'");
                            }
                            n20 = 6;
                            if (n18 != n20) break block35;
                            n20 = (int)(this.lenient ? 1 : 0);
                            if (n20 != 0) {
                                this.consumeNonExecutePrefix();
                            }
                            object = this.stack;
                            n19 = this.stackSize - n11;
                            object[n19] = n21;
                            break block30;
                        }
                        if (n18 != n21) break block36;
                        object = null;
                        n20 = this.nextNonWhitespace(false);
                        if (n20 == (n19 = -1)) {
                            this.peeked = n20 = 17;
                            return n20;
                        }
                        this.checkLenient();
                        this.pos = n20 = this.pos - n11;
                        break block30;
                    }
                    if (n18 == n24) break block37;
                }
                n20 = this.nextNonWhitespace(n11 != 0);
                if (n20 != n16) {
                    if (n20 != n17) {
                        if (n20 != n14 && n20 != n15) {
                            n19 = 91;
                            if (n20 != n19) {
                                if (n20 != n23) {
                                    n19 = 123;
                                    if (n20 != n19) {
                                        this.pos = n20 = this.pos - n11;
                                        n20 = this.peekKeyword();
                                        if (n20 != 0) {
                                            return n20;
                                        }
                                        n20 = this.peekNumber();
                                        if (n20 != 0) {
                                            return n20;
                                        }
                                        object = this.buffer;
                                        n19 = this.pos;
                                        n20 = object[n19];
                                        if ((n20 = (int)(this.isLiteral((char)n20) ? 1 : 0)) != 0) {
                                            this.checkLenient();
                                            this.peeked = n20 = 10;
                                            return n20;
                                        }
                                        throw this.syntaxError("Expected value");
                                    }
                                    this.peeked = n11;
                                    return n11;
                                }
                                if (n18 == n11) {
                                    this.peeked = n13;
                                    return n13;
                                }
                            } else {
                                this.peeked = n22;
                                return n22;
                            }
                        }
                        if (n18 != n11 && n18 != n12) {
                            throw this.syntaxError("Unexpected value");
                        }
                        this.checkLenient();
                        this.pos = n20 = this.pos - n11;
                        this.peeked = n21;
                        return n21;
                    }
                    this.checkLenient();
                    this.peeked = n24;
                    return n24;
                }
                this.peeked = n20 = 9;
                return n20;
            }
            object = new IllegalStateException;
            object("JsonReader is closed");
            throw object;
        }
        object[n19 -= n11] = n13;
        int n25 = 125;
        if (n18 == n10 && (n19 = this.nextNonWhitespace(n11 != 0)) != n14) {
            if (n19 != n15) {
                if (n19 == n25) {
                    this.peeked = n12;
                    return n12;
                }
                throw this.syntaxError("Unterminated object");
            }
            this.checkLenient();
        }
        if ((n19 = this.nextNonWhitespace(n11 != 0)) != n16) {
            if (n19 != n17) {
                String string2 = "Expected name";
                if (n19 != n25) {
                    this.checkLenient();
                    this.pos = n25 = this.pos - n11;
                    n25 = (char)n19;
                    n25 = (int)(this.isLiteral((char)n25) ? 1 : 0);
                    if (n25 != 0) {
                        this.peeked = n25 = 14;
                        return n25;
                    }
                    throw this.syntaxError(string2);
                }
                if (n18 != n10) {
                    this.peeked = n12;
                    return n12;
                }
                throw this.syntaxError(string2);
            }
            this.checkLenient();
            this.peeked = n25 = 12;
            return n25;
        }
        this.peeked = n25 = 13;
        return n25;
    }

    public void endArray() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        if (n11 == (n10 = 4)) {
            int n12;
            this.stackSize = n11 = this.stackSize + -1;
            int[] nArray = this.pathIndices;
            nArray[n11 += -1] = n12 = nArray[n11] + 1;
            this.peeked = 0;
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected END_ARRAY but was ");
        Object object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public void endObject() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        if (n11 == (n10 = 2)) {
            int n12;
            this.stackSize = n11 = this.stackSize + -1;
            this.pathNames[n11] = null;
            int[] nArray = this.pathIndices;
            nArray[n11 += -1] = n12 = nArray[n11] + 1;
            this.peeked = 0;
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected END_OBJECT but was ");
        Object object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public String getPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        int n10 = this.stackSize;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.stack;
            char c10 = object[i10];
            char c11 = '\u0001';
            if (c10 != c11 && c10 != (c11 = '\u0002')) {
                c11 = '\u0003';
                if (c10 != c11 && c10 != (c11 = '\u0004') && c10 != (c11 = '\u0005')) continue;
                c10 = '.';
                stringBuilder.append(c10);
                object = this.pathNames;
                int n11 = object[i10];
                if (n11 == null) continue;
                object = object[i10];
                stringBuilder.append((String)object);
                continue;
            }
            stringBuilder.append('[');
            object = this.pathIndices;
            c10 = object[i10];
            stringBuilder.append((int)c10);
            c10 = ']';
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public boolean hasNext() {
        int n10;
        int n11 = this.peeked;
        if (!n11) {
            n11 = this.doPeek();
        }
        n11 = n11 != (n10 = 2) && n11 != (n10 = 4) ? 1 : 0;
        return n11 != 0;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        int n10 = this.lineNumber + 1;
        int n11 = this.pos;
        int n12 = this.lineStart;
        n11 = n11 - n12 + 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" at line ");
        stringBuilder.append(n10);
        stringBuilder.append(" column ");
        stringBuilder.append(n11);
        stringBuilder.append(" path ");
        String string2 = this.getPath();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public boolean nextBoolean() {
        int n10 = this.peeked;
        if (n10 == 0) {
            n10 = this.doPeek();
        }
        int n11 = 5;
        int n12 = 0;
        Object object = null;
        int n13 = 1;
        if (n10 == n11) {
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n11 = this.stackSize - n13;
            nArray[n11] = n12 = nArray[n11] + n13;
            return n13 != 0;
        }
        n11 = 6;
        if (n10 == n11) {
            int n14;
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n11 = this.stackSize - n13;
            nArray[n11] = n14 = nArray[n11] + n13;
            return false;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected a boolean but was ");
        object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public double nextDouble() {
        String string2;
        Object object;
        int n10 = this.peeked;
        if (n10 == 0) {
            n10 = this.doPeek();
        }
        int n11 = 15;
        int n12 = 0;
        Object object2 = null;
        if (n10 == n11) {
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n11 = this.stackSize + -1;
            nArray[n11] = n12 = nArray[n11] + 1;
            return this.peekedLong;
        }
        n11 = 16;
        int n13 = 11;
        if (n10 == n11) {
            char[] cArray = this.buffer;
            object = this.pos;
            int n14 = this.peekedNumberLength;
            this.peekedString = string2 = new String(cArray, (int)object, n14);
            n10 = this.pos;
            n11 = this.peekedNumberLength;
            this.pos = n10 += n11;
        } else {
            n11 = 8;
            if (n10 != n11 && n10 != (object = 9)) {
                n11 = 10;
                if (n10 == n11) {
                    this.peekedString = string2 = this.nextUnquotedValue();
                } else if (n10 != n13) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Expected a double but was ");
                    object2 = this.peek();
                    charSequence.append(object2);
                    object2 = this.locationString();
                    charSequence.append((String)object2);
                    charSequence = charSequence.toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
                    throw illegalStateException;
                }
            } else {
                n10 = n10 == n11 ? 39 : 34;
                this.peekedString = string2 = this.nextQuotedValue((char)n10);
            }
        }
        this.peeked = n13;
        string2 = this.peekedString;
        double d10 = Double.parseDouble(string2);
        n13 = (int)(this.lenient ? 1 : 0);
        if (n13 == 0 && ((n13 = (int)(Double.isNaN(d10) ? 1 : 0)) != 0 || (n13 = (int)(Double.isInfinite(d10) ? 1 : 0)) != 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d10);
            string2 = this.locationString();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object2 = new MalformedJsonException(string2);
            throw object2;
        }
        this.peekedString = null;
        this.peeked = 0;
        object2 = this.pathIndices;
        n13 = this.stackSize + -1;
        object = object2[n13] + true;
        object2[n13] = (JsonToken)((Object)object);
        return d10;
    }

    public int nextInt() {
        Object object;
        int n10;
        Object object2;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        int n12 = 15;
        Object object3 = "Expected an int but was ";
        if (n11 == n12) {
            long l10 = this.peekedLong;
            int n13 = (int)l10;
            long l11 = n13;
            long l12 = l10 - l11;
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 == 0) {
                int n14;
                this.peeked = 0;
                int[] nArray = this.pathIndices;
                n12 = this.stackSize + -1;
                nArray[n12] = n14 = nArray[n12] + 1;
                return n13;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append((String)object3);
            long l13 = this.peekedLong;
            charSequence.append(l13);
            object3 = this.locationString();
            charSequence.append((String)object3);
            charSequence = charSequence.toString();
            NumberFormatException numberFormatException = new NumberFormatException((String)charSequence);
            throw numberFormatException;
        }
        n12 = 16;
        if (n11 == n12) {
            object2 = this.buffer;
            n10 = this.pos;
            int n15 = this.peekedNumberLength;
            object = new String((char[])object2, n10, n15);
            this.peekedString = object;
            n11 = this.pos;
            n12 = this.peekedNumberLength;
            this.pos = n11 += n12;
        } else {
            int n16;
            n12 = 10;
            n10 = 8;
            if (n11 != n10 && n11 != (n16 = 9) && n11 != n12) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append((String)object3);
                object3 = this.peek();
                charSequence.append(object3);
                object3 = this.locationString();
                charSequence.append((String)object3);
                charSequence = charSequence.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
                throw illegalStateException;
            }
            if (n11 == n12) {
                object = this.nextUnquotedValue();
                this.peekedString = object;
            } else {
                n11 = n11 == n10 ? 39 : 34;
                object = this.nextQuotedValue((char)n11);
                this.peekedString = object;
            }
            try {
                object = this.peekedString;
            }
            catch (NumberFormatException numberFormatException) {}
            n11 = Integer.parseInt((String)object);
            this.peeked = 0;
            object2 = this.pathIndices;
            n10 = this.stackSize + -1;
            n16 = object2[n10] + '\u0001';
            object2[n10] = n16;
            return n11;
        }
        this.peeked = 11;
        object = this.peekedString;
        double d10 = Double.parseDouble((String)object);
        n10 = (int)d10;
        double d11 = n10;
        n11 = (int)(d11 == d10 ? 0 : (d11 > d10 ? 1 : -1));
        if (n11 == 0) {
            reference var10_13;
            this.peekedString = null;
            this.peeked = 0;
            object = this.pathIndices;
            n12 = this.stackSize + -1;
            object[n12] = var10_13 = object[n12] + true;
            return n10;
        }
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append((String)object3);
        object3 = this.peekedString;
        ((StringBuilder)object2).append((String)object3);
        object3 = this.locationString();
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        object = new NumberFormatException((String)object2);
        throw object;
    }

    public long nextLong() {
        Object object;
        Object object2;
        int n10 = this.peeked;
        if (n10 == 0) {
            n10 = this.doPeek();
        }
        int n11 = 15;
        Object object3 = 0;
        Object object4 = null;
        if (n10 == n11) {
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n11 = this.stackSize + -1;
            nArray[n11] = object3 = nArray[n11] + 1;
            return this.peekedLong;
        }
        n11 = 16;
        String string2 = "Expected a long but was ";
        if (n10 == n11) {
            object2 = this.buffer;
            int n12 = this.pos;
            int n13 = this.peekedNumberLength;
            object = new String((char[])object2, n12, n13);
            this.peekedString = object;
            n10 = this.pos;
            n11 = this.peekedNumberLength;
            this.pos = n10 += n11;
        } else {
            int n14;
            n11 = 10;
            int n15 = 8;
            if (n10 != n15 && n10 != (n14 = 9) && n10 != n11) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append(string2);
                object4 = this.peek();
                charSequence.append(object4);
                object4 = this.locationString();
                charSequence.append((String)object4);
                charSequence = charSequence.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
                throw illegalStateException;
            }
            if (n10 == n11) {
                object = this.nextUnquotedValue();
                this.peekedString = object;
            } else {
                n10 = n10 == n15 ? 39 : 34;
                object = this.nextQuotedValue((char)n10);
                this.peekedString = object;
            }
            try {
                object = this.peekedString;
            }
            catch (NumberFormatException numberFormatException) {}
            long l10 = Long.parseLong((String)object);
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n14 = this.stackSize + -1;
            int n16 = nArray[n14] + 1;
            nArray[n14] = n16;
            return l10;
        }
        this.peeked = 11;
        object = this.peekedString;
        double d10 = Double.parseDouble((String)object);
        long l11 = (long)d10;
        double d11 = l11;
        n10 = (int)(d11 == d10 ? 0 : (d11 > d10 ? 1 : -1));
        if (n10 == 0) {
            this.peekedString = null;
            this.peeked = 0;
            object = this.pathIndices;
            n11 = this.stackSize + -1;
            object3 = object[n11] + true;
            object[n11] = object3;
            return l11;
        }
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append(string2);
        object4 = this.peekedString;
        ((StringBuilder)object2).append((String)object4);
        object4 = this.locationString();
        ((StringBuilder)object2).append((String)object4);
        object2 = ((StringBuilder)object2).toString();
        object = new NumberFormatException((String)object2);
        throw object;
    }

    public String nextName() {
        block7: {
            String string2;
            block5: {
                int n10;
                int n11;
                block6: {
                    block4: {
                        n11 = this.peeked;
                        if (n11 == 0) {
                            n11 = this.doPeek();
                        }
                        if (n11 != (n10 = 14)) break block4;
                        string2 = this.nextUnquotedValue();
                        break block5;
                    }
                    n10 = 12;
                    if (n11 != n10) break block6;
                    n11 = 39;
                    string2 = this.nextQuotedValue((char)n11);
                    break block5;
                }
                n10 = 13;
                if (n11 != n10) break block7;
                n11 = 34;
                string2 = this.nextQuotedValue((char)n11);
            }
            this.peeked = 0;
            String[] stringArray = this.pathNames;
            int n12 = this.stackSize + -1;
            stringArray[n12] = string2;
            return string2;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected a name but was ");
        Object object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public void nextNull() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        if (n11 == (n10 = 7)) {
            int n12;
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n10 = this.stackSize + -1;
            nArray[n10] = n12 = nArray[n10] + 1;
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected null but was ");
        Object object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public String nextString() {
        block10: {
            int n10;
            int n11;
            Object[] objectArray;
            String string2;
            block5: {
                int n12;
                int n13;
                block9: {
                    block8: {
                        block7: {
                            block6: {
                                block4: {
                                    n13 = this.peeked;
                                    if (n13 == 0) {
                                        n13 = this.doPeek();
                                    }
                                    if (n13 != (n12 = 10)) break block4;
                                    string2 = this.nextUnquotedValue();
                                    break block5;
                                }
                                n12 = 8;
                                if (n13 != n12) break block6;
                                n13 = 39;
                                string2 = this.nextQuotedValue((char)n13);
                                break block5;
                            }
                            n12 = 9;
                            if (n13 != n12) break block7;
                            n13 = 34;
                            string2 = this.nextQuotedValue((char)n13);
                            break block5;
                        }
                        n12 = 11;
                        if (n13 != n12) break block8;
                        string2 = this.peekedString;
                        n12 = 0;
                        objectArray = null;
                        this.peekedString = null;
                        break block5;
                    }
                    n12 = 15;
                    if (n13 != n12) break block9;
                    long l10 = this.peekedLong;
                    string2 = Long.toString(l10);
                    break block5;
                }
                n12 = 16;
                if (n13 != n12) break block10;
                objectArray = this.buffer;
                n11 = this.pos;
                n10 = this.peekedNumberLength;
                string2 = new String((char[])objectArray, n11, n10);
                n12 = this.pos;
                n11 = this.peekedNumberLength;
                this.pos = n12 += n11;
            }
            this.peeked = 0;
            objectArray = this.pathIndices;
            n11 = this.stackSize + -1;
            objectArray[n11] = n10 = objectArray[n11] + 1;
            return string2;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected a string but was ");
        Object object = this.peek();
        charSequence.append(object);
        object = this.locationString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public JsonToken peek() {
        int n10 = this.peeked;
        if (n10 == 0) {
            n10 = this.doPeek();
        }
        switch (n10) {
            default: {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            case 17: {
                return JsonToken.END_DOCUMENT;
            }
            case 15: 
            case 16: {
                return JsonToken.NUMBER;
            }
            case 12: 
            case 13: 
            case 14: {
                return JsonToken.NAME;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return JsonToken.STRING;
            }
            case 7: {
                return JsonToken.NULL;
            }
            case 5: 
            case 6: {
                return JsonToken.BOOLEAN;
            }
            case 4: {
                return JsonToken.END_ARRAY;
            }
            case 3: {
                return JsonToken.BEGIN_ARRAY;
            }
            case 2: {
                return JsonToken.END_OBJECT;
            }
            case 1: 
        }
        return JsonToken.BEGIN_OBJECT;
    }

    public final void setLenient(boolean bl2) {
        this.lenient = bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void skipValue() {
        int n10;
        int n11;
        int n12;
        Object var1_1 = null;
        int n13 = 0;
        do {
            block8: {
                block12: {
                    block13: {
                        block11: {
                            block10: {
                                block9: {
                                    block7: {
                                        block6: {
                                            block5: {
                                                if ((n12 = this.peeked) == 0) {
                                                    n12 = this.doPeek();
                                                }
                                                n11 = 3;
                                                n10 = 1;
                                                if (n12 != n11) break block5;
                                                this.push(n10);
                                                break block6;
                                            }
                                            if (n12 != n10) break block7;
                                            this.push(n11);
                                        }
                                        ++n13;
                                        break block8;
                                    }
                                    n11 = 4;
                                    if (n12 != n11) break block9;
                                    this.stackSize = n12 = this.stackSize - n10;
                                    break block10;
                                }
                                n11 = 2;
                                if (n12 != n11) break block11;
                                this.stackSize = n12 = this.stackSize - n10;
                            }
                            n13 += -1;
                            break block8;
                        }
                        n11 = 14;
                        if (n12 == n11 || n12 == (n11 = 10)) break block12;
                        n11 = 8;
                        if (n12 == n11 || n12 == (n11 = 12)) break block13;
                        n11 = 9;
                        if (n12 != n11 && n12 != (n11 = 13)) {
                            n11 = 16;
                            if (n12 == n11) {
                                n12 = this.pos;
                                n11 = this.peekedNumberLength;
                                this.pos = n12 += n11;
                            }
                            break block8;
                        } else {
                            n12 = 34;
                            this.skipQuotedValue((char)n12);
                        }
                        break block8;
                    }
                    n12 = 39;
                    this.skipQuotedValue((char)n12);
                    break block8;
                }
                this.skipUnquotedValue();
            }
            this.peeked = 0;
        } while (n13 != 0);
        int[] nArray = this.pathIndices;
        n13 = this.stackSize;
        n12 = n13 + -1;
        nArray[n12] = n11 = nArray[n12] + n10;
        String[] stringArray = this.pathNames;
        stringArray[n13 -= n10] = "null";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getClass().getSimpleName();
        stringBuilder.append(string2);
        string2 = this.locationString();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

