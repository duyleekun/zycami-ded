/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonDataException;
import com.airbnb.lottie.parser.moshi.JsonEncodingException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import h.c0;
import h.m;
import h.o;
import java.io.EOFException;
import java.util.Objects;
import okio.ByteString;

public final class JsonUtf8Reader
extends JsonReader {
    private static final ByteString CLOSING_BLOCK_COMMENT;
    private static final ByteString DOUBLE_QUOTE_OR_SLASH;
    private static final ByteString LINEFEED_OR_CARRIAGE_RETURN;
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
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private static final ByteString SINGLE_QUOTE_OR_SLASH;
    private static final ByteString UNQUOTED_STRING_TERMINALS;
    private final m buffer;
    private int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private final o source;

    static {
        SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
        DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
        UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
        LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
        CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");
    }

    public JsonUtf8Reader(o o10) {
        Objects.requireNonNull(o10, "source == null");
        this.source = o10;
        o10 = o10.b();
        this.buffer = o10;
        this.pushScope(6);
    }

    private void checkLenient() {
        boolean bl2 = this.lenient;
        if (bl2) {
            return;
        }
        throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private int doPeek() {
        Object object;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        JsonUtf8Reader jsonUtf8Reader;
        block32: {
            Object object2;
            block37: {
                int n18;
                int n19;
                int n20;
                int n21;
                int n22;
                long l10;
                block30: {
                    block36: {
                        block35: {
                            int n23;
                            block33: {
                                block34: {
                                    block31: {
                                        block29: {
                                            jsonUtf8Reader = this;
                                            object2 = this.scopes;
                                            n17 = this.stackSize;
                                            n16 = n17 + -1;
                                            n16 = object2[n16];
                                            l10 = 0L;
                                            n22 = 8;
                                            n15 = 34;
                                            n21 = 93;
                                            n20 = 3;
                                            n19 = 7;
                                            n14 = 59;
                                            n13 = 44;
                                            n23 = 4;
                                            n12 = 2;
                                            n11 = 1;
                                            if (n16 != n11) break block29;
                                            object2[n17 -= n11] = n12;
                                            break block30;
                                        }
                                        if (n16 != n12) break block31;
                                        n18 = this.nextNonWhitespace(n11 != 0);
                                        m m10 = this.buffer;
                                        m10.readByte();
                                        if (n18 != n13) {
                                            if (n18 != n14) {
                                                if (n18 == n21) {
                                                    this.peeked = n23;
                                                    return n23;
                                                }
                                                throw this.syntaxError("Unterminated array");
                                            }
                                            this.checkLenient();
                                        }
                                        break block30;
                                    }
                                    n12 = 5;
                                    if (n16 == n20 || n16 == n12) break block32;
                                    if (n16 != n23) break block33;
                                    object2[n17 -= n11] = n12;
                                    n18 = this.nextNonWhitespace(n11 != 0);
                                    m m11 = this.buffer;
                                    m11.readByte();
                                    n17 = 58;
                                    if (n18 == n17) break block30;
                                    n17 = 61;
                                    if (n18 != n17) break block34;
                                    this.checkLenient();
                                    object2 = this.source;
                                    long l11 = 1L;
                                    n18 = (int)(object2.request(l11) ? 1 : 0);
                                    if (n18 != 0 && (n18 = (int)((m)(object2 = this.buffer)).z0(l10)) == (n17 = 62)) {
                                        object2 = this.buffer;
                                        ((m)object2).readByte();
                                    }
                                    break block30;
                                }
                                throw this.syntaxError("Expected ':'");
                            }
                            n23 = 6;
                            if (n16 != n23) break block35;
                            object2[n17 -= n11] = n19;
                            break block30;
                        }
                        if (n16 != n19) break block36;
                        object2 = null;
                        n18 = this.nextNonWhitespace(false);
                        if (n18 == (n17 = -1)) {
                            this.peeked = n18 = 18;
                            return n18;
                        }
                        this.checkLenient();
                        break block30;
                    }
                    if (n16 == n22) break block37;
                }
                n18 = jsonUtf8Reader.nextNonWhitespace(n11 != 0);
                if (n18 != n15) {
                    n17 = 39;
                    if (n18 != n17) {
                        if (n18 != n13 && n18 != n14) {
                            n17 = 91;
                            if (n18 != n17) {
                                if (n18 != n21) {
                                    n17 = 123;
                                    if (n18 != n17) {
                                        n18 = this.peekKeyword();
                                        if (n18 != 0) {
                                            return n18;
                                        }
                                        n18 = this.peekNumber();
                                        if (n18 != 0) {
                                            return n18;
                                        }
                                        object2 = jsonUtf8Reader.buffer;
                                        n18 = ((m)object2).z0(l10);
                                        if ((n18 = (int)(jsonUtf8Reader.isLiteral(n18) ? 1 : 0)) != 0) {
                                            this.checkLenient();
                                            jsonUtf8Reader.peeked = n18 = 10;
                                            return n18;
                                        }
                                        throw jsonUtf8Reader.syntaxError("Expected value");
                                    }
                                    jsonUtf8Reader.buffer.readByte();
                                    jsonUtf8Reader.peeked = n11;
                                    return n11;
                                }
                                if (n16 == n11) {
                                    jsonUtf8Reader.buffer.readByte();
                                    jsonUtf8Reader.peeked = n18 = 4;
                                    return n18;
                                }
                            } else {
                                jsonUtf8Reader.buffer.readByte();
                                jsonUtf8Reader.peeked = n20;
                                return n20;
                            }
                        }
                        if (n16 != n11 && n16 != (n18 = 2)) {
                            throw jsonUtf8Reader.syntaxError("Unexpected value");
                        }
                        this.checkLenient();
                        jsonUtf8Reader.peeked = n19;
                        return n19;
                    }
                    this.checkLenient();
                    jsonUtf8Reader.buffer.readByte();
                    jsonUtf8Reader.peeked = n22;
                    return n22;
                }
                jsonUtf8Reader.buffer.readByte();
                jsonUtf8Reader.peeked = n18 = 9;
                return n18;
            }
            object2 = new IllegalStateException;
            ((IllegalStateException)object2)("JsonReader is closed");
            throw object2;
        }
        object2[n17 -= n11] = n10 = 4;
        int n24 = 125;
        if (n16 == n12) {
            n17 = jsonUtf8Reader.nextNonWhitespace(n11 != 0);
            object = jsonUtf8Reader.buffer;
            ((m)object).readByte();
            if (n17 != n13) {
                if (n17 != n14) {
                    if (n17 == n24) {
                        jsonUtf8Reader.peeked = n24 = 2;
                        return n24;
                    }
                    throw jsonUtf8Reader.syntaxError("Unterminated object");
                }
                this.checkLenient();
            }
        }
        if ((n17 = jsonUtf8Reader.nextNonWhitespace(n11 != 0)) != n15) {
            n10 = 39;
            if (n17 != n10) {
                object = "Expected name";
                if (n17 != n24) {
                    this.checkLenient();
                    n24 = (char)n17;
                    n24 = (int)(jsonUtf8Reader.isLiteral(n24) ? 1 : 0);
                    if (n24 != 0) {
                        jsonUtf8Reader.peeked = n24 = 14;
                        return n24;
                    }
                    throw jsonUtf8Reader.syntaxError((String)object);
                }
                if (n16 != n12) {
                    jsonUtf8Reader.buffer.readByte();
                    jsonUtf8Reader.peeked = n24 = 2;
                    return n24;
                }
                throw jsonUtf8Reader.syntaxError((String)object);
            }
            jsonUtf8Reader.buffer.readByte();
            this.checkLenient();
            jsonUtf8Reader.peeked = n24 = 12;
            return n24;
        }
        jsonUtf8Reader.buffer.readByte();
        jsonUtf8Reader.peeked = n24 = 13;
        return n24;
    }

    private int findName(String string2, JsonReader$Options stringArray) {
        String[] stringArray2 = stringArray.strings;
        int n10 = stringArray2.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = stringArray.strings[i10];
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            this.peeked = 0;
            stringArray = this.pathNames;
            n10 = this.stackSize + -1;
            stringArray[n10] = string2;
            return i10;
        }
        return -1;
    }

    private int findString(String object, JsonReader$Options jsonReader$Options) {
        String[] stringArray = jsonReader$Options.strings;
        Object object2 = stringArray.length;
        for (int i10 = 0; i10 < object2; ++i10) {
            String string2 = jsonReader$Options.strings[i10];
            boolean bl2 = ((String)object).equals(string2);
            if (!bl2) continue;
            this.peeked = 0;
            object = this.pathIndices;
            int n10 = this.stackSize + -1;
            object2 = object[n10] + true;
            object[n10] = object2;
            return i10;
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     */
    private boolean isLiteral(int var1_1) {
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
        block0: while (true) {
            int n10;
            long l10;
            o o10;
            int n11;
            int n12 = 0;
            m m10 = null;
            while ((n11 = (o10 = this.source).request(l10 = (long)(n10 = n12 + 1))) != 0) {
                o10 = this.buffer;
                l10 = n12;
                if ((n12 = (int)((m)o10).z0(l10)) != (n11 = 10) && n12 != (n11 = 32) && n12 != (n11 = 13) && n12 != (n11 = 9)) {
                    o10 = this.buffer;
                    long l11 = n10 += -1;
                    ((m)o10).skip(l11);
                    n11 = 47;
                    if (n12 == n11) {
                        o o11 = this.source;
                        l10 = 2;
                        n10 = (int)(o11.request(l10) ? 1 : 0);
                        if (n10 == 0) {
                            return n12;
                        }
                        this.checkLenient();
                        o11 = this.buffer;
                        l10 = 1L;
                        n10 = ((m)o11).z0(l10);
                        int n13 = 42;
                        if (n10 != n13) {
                            if (n10 != n11) {
                                return n12;
                            }
                            this.buffer.readByte();
                            m10 = this.buffer;
                            m10.readByte();
                            this.skipToEndOfLine();
                            continue block0;
                        }
                        this.buffer.readByte();
                        m10 = this.buffer;
                        m10.readByte();
                        n12 = (int)(this.skipToEndOfBlockComment() ? 1 : 0);
                        if (n12 != 0) continue block0;
                        throw this.syntaxError("Unterminated comment");
                    }
                    n11 = 35;
                    if (n12 == n11) {
                        this.checkLenient();
                        this.skipToEndOfLine();
                        continue block0;
                    }
                    return n12;
                }
                n12 = n10;
            }
            break;
        }
        if (!bl2) {
            return -1;
        }
        EOFException eOFException = new EOFException("End of input");
        throw eOFException;
    }

    private String nextQuotedValue(ByteString object) {
        long l10;
        Object object2;
        long l11;
        long l12;
        long l13;
        StringBuilder stringBuilder = null;
        while ((l13 = (l12 = (l11 = (object2 = this.source).m((ByteString)object)) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            int n10;
            m m10 = this.buffer;
            l13 = m10.z0(l11);
            if (l13 == (n10 = 92)) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                m10 = this.buffer;
                object2 = m10.P(l11);
                stringBuilder.append((String)object2);
                object2 = this.buffer;
                ((m)object2).readByte();
                char c10 = this.readEscapeCharacter();
                stringBuilder.append(c10);
                continue;
            }
            if (stringBuilder == null) {
                object = this.buffer.P(l11);
                this.buffer.readByte();
                return object;
            }
            object = this.buffer.P(l11);
            stringBuilder.append((String)object);
            this.buffer.readByte();
            return stringBuilder.toString();
        }
        throw this.syntaxError("Unterminated string");
    }

    private String nextUnquotedValue() {
        long l10;
        Object object = this.source;
        ByteString byteString = UNQUOTED_STRING_TERMINALS;
        long l11 = object.m(byteString);
        long l12 = l11 - (l10 = (long)-1);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            m m10 = this.buffer;
            object = m10.P(l11);
        } else {
            object = this.buffer.f0();
        }
        return object;
    }

    private int peekKeyword() {
        String string2;
        Object object;
        m m10 = this.buffer;
        long l10 = 0L;
        int n10 = m10.z0(l10);
        m m11 = null;
        int n11 = 116;
        if (n10 != n11 && n10 != (n11 = 84)) {
            n11 = 102;
            if (n10 != n11 && n10 != (n11 = 70)) {
                n11 = 110;
                if (n10 != n11 && n10 != (n11 = 78)) {
                    return 0;
                }
                n10 = 7;
                object = "null";
                string2 = "NULL";
            } else {
                n10 = 6;
                object = "false";
                string2 = "FALSE";
            }
        } else {
            n10 = 5;
            object = "true";
            string2 = "TRUE";
        }
        int n12 = ((String)object).length();
        int n13 = 1;
        while (n13 < n12) {
            char c10;
            o o10 = this.source;
            int n14 = n13 + 1;
            long l11 = n14;
            byte by2 = o10.request(l11);
            if (by2 == 0) {
                return 0;
            }
            o10 = this.buffer;
            l11 = n13;
            by2 = ((m)o10).z0(l11);
            if (by2 != (c10 = ((String)object).charAt(n13)) && by2 != (n13 = (int)string2.charAt(n13))) {
                return 0;
            }
            n13 = n14;
        }
        object = this.source;
        int n15 = n12 + 1;
        long l12 = n15;
        n11 = (int)(object.request(l12) ? 1 : 0);
        if (n11 != 0) {
            object = this.buffer;
            l12 = n12;
            n11 = ((m)object).z0(l12);
            if ((n11 = (int)(this.isLiteral(n11) ? 1 : 0)) != 0) {
                return 0;
            }
        }
        m11 = this.buffer;
        long l13 = n12;
        m11.skip(l13);
        this.peeked = n10;
        return n10;
    }

    private int peekNumber() {
        JsonUtf8Reader jsonUtf8Reader = this;
        long l10 = 0L;
        int n10 = 1;
        long l11 = l10;
        int n11 = n10;
        int n12 = 0;
        int n13 = 0;
        boolean bl2 = false;
        while (true) {
            int n14;
            block25: {
                block27: {
                    int n15;
                    block20: {
                        int n16;
                        block21: {
                            block28: {
                                block22: {
                                    block23: {
                                        block26: {
                                            int n17;
                                            long l12;
                                            long l13;
                                            block19: {
                                                int n18;
                                                block24: {
                                                    o o10 = jsonUtf8Reader.source;
                                                    n14 = n12 + 1;
                                                    long l14 = n14;
                                                    n18 = o10.request(l14);
                                                    n16 = 2;
                                                    if (n18 == 0) break block19;
                                                    o10 = jsonUtf8Reader.buffer;
                                                    l14 = n12;
                                                    n18 = ((m)o10).z0(l14);
                                                    int n19 = 43;
                                                    n15 = 5;
                                                    if (n18 == n19) break block20;
                                                    n19 = 69;
                                                    if (n18 == n19 || n18 == (n19 = 101)) break block21;
                                                    n19 = 45;
                                                    if (n18 == n19) break block22;
                                                    n19 = 46;
                                                    if (n18 == n19) break block23;
                                                    n19 = 48;
                                                    if (n18 < n19 || n18 > (n19 = 57)) break block24;
                                                    if (n13 != n10 && n13 != 0) {
                                                        if (n13 == n16) {
                                                            n12 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                                                            if (n12 == 0) {
                                                                return 0;
                                                            }
                                                            l14 = (long)10 * l11;
                                                            l13 = n18 += -48;
                                                            l14 -= l13;
                                                            l13 = -922337203685477580L;
                                                            long l15 = l11 - l13;
                                                            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                                                            n10 = n10 <= 0 && (n10 != 0 || (n10 = (int)(l14 == l11 ? 0 : (l14 < l11 ? -1 : 1))) >= 0) ? 0 : 1;
                                                            n11 &= n10;
                                                            l11 = l14;
                                                        } else {
                                                            n10 = 3;
                                                            if (n13 == n10) {
                                                                n13 = 4;
                                                            } else if (n13 == n15 || n13 == (n10 = 6)) {
                                                                n13 = 7;
                                                            }
                                                        }
                                                    } else {
                                                        n10 = -(n18 += -48);
                                                        l11 = n10;
                                                        n13 = n16;
                                                    }
                                                    break block25;
                                                }
                                                n10 = (int)(jsonUtf8Reader.isLiteral(n18) ? 1 : 0);
                                                if (n10 != 0) break block26;
                                            }
                                            if (!(n13 != n16 || n11 == 0 || (n10 = (l12 = l11 - (l13 = Long.MIN_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == 0 && !bl2 || (n17 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1))) == 0 && bl2)) {
                                                if (!bl2) {
                                                    l11 = -l11;
                                                }
                                                jsonUtf8Reader.peekedLong = l11;
                                                m m10 = jsonUtf8Reader.buffer;
                                                long l16 = n12;
                                                m10.skip(l16);
                                                jsonUtf8Reader.peeked = n17 = 16;
                                                return n17;
                                            }
                                            if (n13 != n16 && n13 != (n17 = 4) && n13 != (n17 = 7)) {
                                                return 0;
                                            }
                                            jsonUtf8Reader.peekedNumberLength = n12;
                                            jsonUtf8Reader.peeked = n17 = 17;
                                            return n17;
                                        }
                                        return 0;
                                    }
                                    n10 = 3;
                                    if (n13 != n16) {
                                        return 0;
                                    }
                                    break block27;
                                }
                                n10 = 6;
                                if (n13 != 0) break block28;
                                n13 = 1;
                                bl2 = true;
                                break block25;
                            }
                            if (n13 != n15) {
                                return 0;
                            }
                            break block27;
                        }
                        if (n13 != n16 && n13 != (n10 = 4)) {
                            return 0;
                        }
                        n13 = n15;
                        break block25;
                    }
                    n10 = 6;
                    if (n13 != n15) break;
                }
                n13 = n10;
            }
            n12 = n14;
            n10 = 1;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private char readEscapeCharacter() {
        long l10;
        int n10;
        int n11;
        Object object = this.source;
        long l11 = 1L;
        int n12 = object.request(l11);
        if (n12 == 0) {
            throw this.syntaxError("Unterminated escape sequence");
        }
        object = this.buffer;
        n12 = ((m)object).readByte();
        if (n12 != (n11 = 10) && n12 != (n10 = 34) && n12 != (n10 = 39) && n12 != (n10 = 47) && n12 != (n10 = 92)) {
            n10 = 98;
            if (n12 == n10) {
                return '\b';
            }
            n10 = 102;
            if (n12 == n10) {
                return '\f';
            }
            int n13 = 110;
            if (n12 == n13) {
                return (char)n11;
            }
            n13 = 114;
            if (n12 == n13) {
                return '\r';
            }
            n13 = 116;
            if (n12 == n13) {
                return '\t';
            }
            n13 = 117;
            if (n12 != n13) {
                n11 = (int)(this.lenient ? 1 : 0);
                if (n11 != 0) {
                    return (char)n12;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid escape sequence: \\");
                n12 = (char)n12;
                stringBuilder.append((char)n12);
                object = stringBuilder.toString();
                throw this.syntaxError((String)object);
            }
            object = this.source;
            l10 = 4;
            n12 = (int)(object.request(l10) ? 1 : 0);
            if (n12 == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unterminated escape sequence at path ");
                String string2 = this.getPath();
                stringBuilder.append(string2);
                String string3 = stringBuilder.toString();
                object = new EOFException(string3);
                throw object;
            }
        } else {
            return (char)n12;
        }
        n12 = 0;
        object = null;
        char c10 = '\u0000';
        while (true) {
            int n14;
            if (n12 >= (n14 = 4)) {
                this.buffer.skip(l10);
                return c10;
            }
            m m10 = this.buffer;
            long l12 = n12;
            n14 = m10.z0(l12);
            c10 = (char)(c10 << 4);
            int n15 = 48;
            if (n14 >= n15 && n14 <= (n15 = 57)) {
                n14 += -48;
            } else {
                n15 = 97;
                if (n14 >= n15 && n14 <= n10) {
                    n14 += -97;
                } else {
                    n15 = 65;
                    if (n14 < n15 || n14 > (n15 = 70)) break;
                    n14 += -65;
                }
                n14 += n11;
            }
            c10 = (char)(c10 + n14);
            ++n12;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("\\u");
        String string4 = this.buffer.P(l10);
        ((StringBuilder)object).append(string4);
        object = ((StringBuilder)object).toString();
        throw this.syntaxError((String)object);
    }

    private void skipQuotedValue(ByteString object) {
        long l10;
        o o10;
        long l11;
        long l12;
        long l13;
        while ((l13 = (l12 = (l11 = (o10 = this.source).m((ByteString)object)) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            m m10 = this.buffer;
            l13 = m10.z0(l11);
            int n10 = 92;
            long l14 = 1L;
            if (l13 == n10) {
                m10 = this.buffer;
                m10.skip(l11 += l14);
                this.readEscapeCharacter();
                continue;
            }
            object = this.buffer;
            ((m)object).skip(l11 += l14);
            return;
        }
        throw this.syntaxError("Unterminated string");
    }

    private boolean skipToEndOfBlockComment() {
        long l10;
        o o10 = this.source;
        ByteString byteString = CLOSING_BLOCK_COMMENT;
        long l11 = o10.i(byteString);
        long l12 = l11 - (l10 = (long)-1);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
        } else {
            object = 0;
            o10 = null;
        }
        m m10 = this.buffer;
        if (object != false) {
            int n10 = byteString.size();
            long l13 = n10;
            l11 += l13;
        } else {
            l11 = m10.S0();
        }
        m10.skip(l11);
        return (boolean)object;
    }

    private void skipToEndOfLine() {
        o o10 = this.source;
        ByteString byteString = LINEFEED_OR_CARRIAGE_RETURN;
        long l10 = o10.m(byteString);
        m m10 = this.buffer;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = 1L;
            l10 += l11;
        } else {
            l10 = m10.S0();
        }
        m10.skip(l10);
    }

    private void skipUnquotedValue() {
        o o10 = this.source;
        ByteString byteString = UNQUOTED_STRING_TERMINALS;
        long l10 = o10.m(byteString);
        m m10 = this.buffer;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = m10.S0();
        }
        m10.skip(l10);
    }

    public void beginArray() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        if (n11 == (n10 = 3)) {
            n11 = 1;
            this.pushScope(n11);
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
        charSequence.append(" at path ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
    }

    public void beginObject() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        if (n11 == (n10 = 1)) {
            this.pushScope(3);
            this.peeked = 0;
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected BEGIN_OBJECT but was ");
        Object object = this.peek();
        charSequence.append(object);
        charSequence.append(" at path ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
    }

    public void close() {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.B();
        this.source.close();
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
        charSequence.append(" at path ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
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
        charSequence.append(" at path ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
    }

    public boolean hasNext() {
        int n10;
        int n11 = this.peeked;
        if (n11 == 0) {
            n11 = this.doPeek();
        }
        n11 = n11 != (n10 = 2) && n11 != (n10 = 4) && n11 != (n10 = 18) ? 1 : 0;
        return n11 != 0;
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
        charSequence.append(" at path ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
    }

    public double nextDouble() {
        String string2;
        CharSequence charSequence;
        Object object;
        block14: {
            Object object2;
            Object object3;
            block10: {
                int n10;
                block13: {
                    int n11;
                    block12: {
                        block11: {
                            block9: {
                                n10 = this.peeked;
                                if (n10 == 0) {
                                    n10 = this.doPeek();
                                }
                                n11 = 16;
                                int n12 = 0;
                                object = null;
                                if (n10 == n11) {
                                    this.peeked = 0;
                                    int[] nArray = this.pathIndices;
                                    n11 = this.stackSize + -1;
                                    nArray[n11] = n12 = nArray[n11] + 1;
                                    return this.peekedLong;
                                }
                                n11 = 17;
                                charSequence = "Expected a double but was ";
                                object3 = 11;
                                string2 = " at path ";
                                if (n10 != n11) break block9;
                                object2 = this.buffer;
                                n11 = this.peekedNumberLength;
                                long l10 = n11;
                                this.peekedString = object2 = ((m)object2).P(l10);
                                break block10;
                            }
                            n11 = 9;
                            if (n10 != n11) break block11;
                            object2 = DOUBLE_QUOTE_OR_SLASH;
                            this.peekedString = object2 = this.nextQuotedValue((ByteString)object2);
                            break block10;
                        }
                        n11 = 8;
                        if (n10 != n11) break block12;
                        object2 = SINGLE_QUOTE_OR_SLASH;
                        this.peekedString = object2 = this.nextQuotedValue((ByteString)object2);
                        break block10;
                    }
                    n11 = 10;
                    if (n10 != n11) break block13;
                    this.peekedString = object2 = this.nextUnquotedValue();
                    break block10;
                }
                if (n10 != object3) break block14;
            }
            this.peeked = object3;
            try {
                object2 = this.peekedString;
            }
            catch (NumberFormatException numberFormatException) {
                CharSequence charSequence2 = new StringBuilder();
                charSequence2.append((String)charSequence);
                object = this.peekedString;
                charSequence2.append((String)object);
                charSequence2.append(string2);
                object = this.getPath();
                charSequence2.append((String)object);
                charSequence2 = charSequence2.toString();
                object2 = new JsonDataException((String)charSequence2);
                throw object2;
            }
            double d10 = Double.parseDouble((String)object2);
            int n13 = this.lenient;
            if (n13 == 0 && ((n13 = Double.isNaN(d10)) != 0 || (n13 = Double.isInfinite(d10)) != 0)) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("JSON forbids NaN and infinities: ");
                ((StringBuilder)charSequence).append(d10);
                ((StringBuilder)charSequence).append(string2);
                object2 = this.getPath();
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
                object = new JsonEncodingException((String)object2);
                throw object;
            }
            this.peekedString = null;
            this.peeked = 0;
            object = this.pathIndices;
            n13 = this.stackSize + -1;
            object3 = object[n13] + true;
            object[n13] = (JsonReader$Token)((Object)object3);
            return d10;
        }
        CharSequence charSequence3 = new StringBuilder();
        charSequence3.append((String)charSequence);
        object = this.peek();
        charSequence3.append(object);
        charSequence3.append(string2);
        object = this.getPath();
        charSequence3.append((String)object);
        charSequence3 = charSequence3.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence3);
        throw jsonDataException;
    }

    public int nextInt() {
        Object object;
        Object object2;
        int n10 = this.peeked;
        if (n10 == 0) {
            n10 = this.doPeek();
        }
        int n11 = 16;
        Object object3 = 0;
        Object object4 = null;
        String string2 = " at path ";
        String string3 = "Expected an int but was ";
        if (n10 == n11) {
            long l10 = this.peekedLong;
            int n12 = (int)l10;
            long l11 = n12;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 == 0) {
                this.peeked = 0;
                int[] nArray = this.pathIndices;
                n11 = this.stackSize + -1;
                nArray[n11] = object3 = nArray[n11] + 1;
                return n12;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string3);
            long l13 = this.peekedLong;
            charSequence.append(l13);
            charSequence.append(string2);
            object4 = this.getPath();
            charSequence.append((String)object4);
            charSequence = charSequence.toString();
            JsonDataException jsonDataException = new JsonDataException((String)charSequence);
            throw jsonDataException;
        }
        n11 = 17;
        int n13 = 11;
        if (n10 == n11) {
            object2 = this.buffer;
            n11 = this.peekedNumberLength;
            long l14 = n11;
            this.peekedString = object2 = ((m)object2).P(l14);
        } else {
            int n14;
            n11 = 9;
            if (n10 != n11 && n10 != (n14 = 8)) {
                if (n10 != n13) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string3);
                    object4 = this.peek();
                    charSequence.append(object4);
                    charSequence.append(string2);
                    object4 = this.getPath();
                    charSequence.append((String)object4);
                    charSequence = charSequence.toString();
                    JsonDataException jsonDataException = new JsonDataException((String)charSequence);
                    throw jsonDataException;
                }
            } else {
                if (n10 == n11) {
                    object2 = DOUBLE_QUOTE_OR_SLASH;
                    object2 = this.nextQuotedValue((ByteString)object2);
                } else {
                    object2 = SINGLE_QUOTE_OR_SLASH;
                    object2 = this.nextQuotedValue((ByteString)object2);
                }
                this.peekedString = object2;
                try {
                    n10 = Integer.parseInt((String)object2);
                }
                catch (NumberFormatException numberFormatException) {}
                this.peeked = 0;
                object = this.pathIndices;
                n14 = this.stackSize + -1;
                reference var17_21 = object[n14] + true;
                object[n14] = var17_21;
                return n10;
            }
        }
        this.peeked = n13;
        try {
            object2 = this.peekedString;
        }
        catch (NumberFormatException numberFormatException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            object4 = this.peekedString;
            ((StringBuilder)object).append((String)object4);
            ((StringBuilder)object).append(string2);
            object4 = this.getPath();
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            object2 = new JsonDataException((String)object);
            throw object2;
        }
        double d10 = Double.parseDouble((String)object2);
        n13 = (int)d10;
        double d11 = n13;
        n10 = (int)(d11 == d10 ? 0 : (d11 > d10 ? 1 : -1));
        if (n10 == 0) {
            this.peekedString = null;
            this.peeked = 0;
            object2 = this.pathIndices;
            n11 = this.stackSize + -1;
            object3 = object2[n11] + true;
            object2[n11] = object3;
            return n13;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string3);
        object4 = this.peekedString;
        ((StringBuilder)object).append((String)object4);
        ((StringBuilder)object).append(string2);
        object4 = this.getPath();
        ((StringBuilder)object).append((String)object4);
        object = ((StringBuilder)object).toString();
        object2 = new JsonDataException((String)object);
        throw object2;
    }

    public String nextName() {
        block8: {
            Object object;
            block5: {
                int n10;
                int n11;
                block7: {
                    block6: {
                        block4: {
                            n11 = this.peeked;
                            if (n11 == 0) {
                                n11 = this.doPeek();
                            }
                            if (n11 != (n10 = 14)) break block4;
                            object = this.nextUnquotedValue();
                            break block5;
                        }
                        n10 = 13;
                        if (n11 != n10) break block6;
                        object = DOUBLE_QUOTE_OR_SLASH;
                        object = this.nextQuotedValue((ByteString)object);
                        break block5;
                    }
                    n10 = 12;
                    if (n11 != n10) break block7;
                    object = SINGLE_QUOTE_OR_SLASH;
                    object = this.nextQuotedValue((ByteString)object);
                    break block5;
                }
                n10 = 15;
                if (n11 != n10) break block8;
                object = this.peekedString;
            }
            this.peeked = 0;
            String[] stringArray = this.pathNames;
            int n12 = this.stackSize + -1;
            stringArray[n12] = object;
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected a name but was ");
        Object object = this.peek();
        charSequence.append(object);
        charSequence.append(" at path ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
    }

    public String nextString() {
        block10: {
            int n10;
            int[] nArray;
            Object object;
            block5: {
                int n11;
                int n12;
                block9: {
                    block8: {
                        block7: {
                            block6: {
                                block4: {
                                    n12 = this.peeked;
                                    if (n12 == 0) {
                                        n12 = this.doPeek();
                                    }
                                    if (n12 != (n11 = 10)) break block4;
                                    object = this.nextUnquotedValue();
                                    break block5;
                                }
                                n11 = 9;
                                if (n12 != n11) break block6;
                                object = DOUBLE_QUOTE_OR_SLASH;
                                object = this.nextQuotedValue((ByteString)object);
                                break block5;
                            }
                            n11 = 8;
                            if (n12 != n11) break block7;
                            object = SINGLE_QUOTE_OR_SLASH;
                            object = this.nextQuotedValue((ByteString)object);
                            break block5;
                        }
                        n11 = 11;
                        if (n12 != n11) break block8;
                        object = this.peekedString;
                        n11 = 0;
                        nArray = null;
                        this.peekedString = null;
                        break block5;
                    }
                    n11 = 16;
                    if (n12 != n11) break block9;
                    long l10 = this.peekedLong;
                    object = Long.toString(l10);
                    break block5;
                }
                n11 = 17;
                if (n12 != n11) break block10;
                object = this.buffer;
                n11 = this.peekedNumberLength;
                long l11 = n11;
                object = ((m)object).P(l11);
            }
            this.peeked = 0;
            nArray = this.pathIndices;
            int n13 = this.stackSize + -1;
            nArray[n13] = n10 = nArray[n13] + 1;
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected a string but was ");
        Object object = this.peek();
        charSequence.append(object);
        charSequence.append(" at path ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
    }

    public JsonReader$Token peek() {
        int n10 = this.peeked;
        if (n10 == 0) {
            n10 = this.doPeek();
        }
        switch (n10) {
            default: {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            case 18: {
                return JsonReader$Token.END_DOCUMENT;
            }
            case 16: 
            case 17: {
                return JsonReader$Token.NUMBER;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return JsonReader$Token.NAME;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return JsonReader$Token.STRING;
            }
            case 7: {
                return JsonReader$Token.NULL;
            }
            case 5: 
            case 6: {
                return JsonReader$Token.BOOLEAN;
            }
            case 4: {
                return JsonReader$Token.END_ARRAY;
            }
            case 3: {
                return JsonReader$Token.BEGIN_ARRAY;
            }
            case 2: {
                return JsonReader$Token.END_OBJECT;
            }
            case 1: 
        }
        return JsonReader$Token.BEGIN_OBJECT;
    }

    public int selectName(JsonReader$Options object) {
        int n10 = this.peeked;
        if (n10 == 0) {
            n10 = this.doPeek();
        }
        int n11 = 12;
        int n12 = -1;
        if (n10 >= n11 && n10 <= (n11 = 15)) {
            if (n10 == n11) {
                String string2 = this.peekedString;
                return this.findName(string2, (JsonReader$Options)object);
            }
            Object object2 = this.source;
            Object object3 = ((JsonReader$Options)object).doubleQuoteSuffix;
            n10 = object2.m0((c0)object3);
            if (n10 != n12) {
                this.peeked = 0;
                String[] stringArray = this.pathNames;
                n12 = this.stackSize + -1;
                stringArray[n12] = object = ((JsonReader$Options)object).strings[n10];
                return n10;
            }
            object2 = this.pathNames;
            int n13 = this.stackSize + -1;
            object2 = object2[n13];
            object3 = this.nextName();
            int n14 = this.findName((String)object3, (JsonReader$Options)object);
            if (n14 == n12) {
                this.peeked = n11;
                this.peekedString = object3;
                String[] stringArray = this.pathNames;
                n12 = this.stackSize + -1;
                stringArray[n12] = object2;
            }
            return n14;
        }
        return n12;
    }

    public void skipName() {
        block4: {
            block9: {
                Object object;
                int n10;
                block6: {
                    int n11;
                    block8: {
                        block7: {
                            block5: {
                                n11 = this.failOnUnknown;
                                if (n11 != 0) break block4;
                                n11 = this.peeked;
                                if (n11 == 0) {
                                    n11 = this.doPeek();
                                }
                                if (n11 != (n10 = 14)) break block5;
                                this.skipUnquotedValue();
                                break block6;
                            }
                            n10 = 13;
                            if (n11 != n10) break block7;
                            object = DOUBLE_QUOTE_OR_SLASH;
                            this.skipQuotedValue((ByteString)object);
                            break block6;
                        }
                        n10 = 12;
                        if (n11 != n10) break block8;
                        object = SINGLE_QUOTE_OR_SLASH;
                        this.skipQuotedValue((ByteString)object);
                        break block6;
                    }
                    n10 = 15;
                    if (n11 != n10) break block9;
                }
                this.peeked = 0;
                object = this.pathNames;
                n10 = this.stackSize + -1;
                object[n10] = "null";
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Expected a name but was ");
            Object object = this.peek();
            charSequence.append(object);
            charSequence.append(" at path ");
            object = this.getPath();
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            JsonDataException jsonDataException = new JsonDataException((String)charSequence);
            throw jsonDataException;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot skip unexpected ");
        Object object = this.peek();
        charSequence.append(object);
        charSequence.append(" at ");
        object = this.getPath();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        JsonDataException jsonDataException = new JsonDataException((String)charSequence);
        throw jsonDataException;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void skipValue() {
        int n10;
        int n11;
        int n12;
        boolean bl2 = this.failOnUnknown;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot skip unexpected ");
            JsonReader$Token jsonReader$Token = this.peek();
            stringBuilder.append((Object)jsonReader$Token);
            stringBuilder.append(" at ");
            String string2 = this.getPath();
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            JsonDataException jsonDataException = new JsonDataException(string3);
            throw jsonDataException;
        }
        bl2 = false;
        Object var2_2 = null;
        int n13 = 0;
        Object var4_10 = null;
        do {
            block10: {
                block16: {
                    block17: {
                        String string4;
                        String string5;
                        block15: {
                            block14: {
                                block13: {
                                    block12: {
                                        block11: {
                                            if ((n12 = this.peeked) == 0) {
                                                n12 = this.doPeek();
                                            }
                                            n11 = 3;
                                            n10 = 1;
                                            if (n12 != n11) break block11;
                                            this.pushScope(n10);
                                            break block12;
                                        }
                                        if (n12 != n10) break block13;
                                        this.pushScope(n11);
                                    }
                                    ++n13;
                                    break block10;
                                }
                                n11 = 4;
                                string5 = " at path ";
                                string4 = "Expected a value but was ";
                                if (n12 != n11) break block14;
                                if ((n13 += -1) < 0) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string4);
                                    JsonReader$Token jsonReader$Token = this.peek();
                                    stringBuilder.append((Object)jsonReader$Token);
                                    stringBuilder.append(string5);
                                    String string6 = this.getPath();
                                    stringBuilder.append(string6);
                                    String string7 = stringBuilder.toString();
                                    JsonDataException jsonDataException = new JsonDataException(string7);
                                    throw jsonDataException;
                                }
                                this.stackSize = n12 = this.stackSize - n10;
                                break block10;
                            }
                            n11 = 2;
                            if (n12 != n11) break block15;
                            if ((n13 += -1) < 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(string4);
                                JsonReader$Token jsonReader$Token = this.peek();
                                stringBuilder.append((Object)jsonReader$Token);
                                stringBuilder.append(string5);
                                String string8 = this.getPath();
                                stringBuilder.append(string8);
                                String string9 = stringBuilder.toString();
                                JsonDataException jsonDataException = new JsonDataException(string9);
                                throw jsonDataException;
                            }
                            this.stackSize = n12 = this.stackSize - n10;
                            break block10;
                        }
                        n11 = 14;
                        if (n12 == n11 || n12 == (n11 = 10)) break block16;
                        n11 = 9;
                        if (n12 == n11 || n12 == (n11 = 13)) break block17;
                        n11 = 8;
                        if (n12 != n11 && n12 != (n11 = 12)) {
                            n11 = 17;
                            if (n12 == n11) {
                                m m10 = this.buffer;
                                n11 = this.peekedNumberLength;
                                long l10 = n11;
                                m10.skip(l10);
                                break block10;
                            } else {
                                n11 = 18;
                                if (n12 == n11) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string4);
                                    JsonReader$Token jsonReader$Token = this.peek();
                                    stringBuilder.append((Object)jsonReader$Token);
                                    stringBuilder.append(string5);
                                    String string10 = this.getPath();
                                    stringBuilder.append(string10);
                                    String string11 = stringBuilder.toString();
                                    JsonDataException jsonDataException = new JsonDataException(string11);
                                    throw jsonDataException;
                                }
                            }
                            break block10;
                        } else {
                            ByteString byteString = SINGLE_QUOTE_OR_SLASH;
                            this.skipQuotedValue(byteString);
                        }
                        break block10;
                    }
                    ByteString byteString = DOUBLE_QUOTE_OR_SLASH;
                    this.skipQuotedValue(byteString);
                    break block10;
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
        stringBuilder.append("JsonReader(");
        o o10 = this.source;
        stringBuilder.append(o10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

