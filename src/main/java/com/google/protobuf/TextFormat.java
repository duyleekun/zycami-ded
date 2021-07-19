/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat$InvalidEscapeSequenceException;
import com.google.protobuf.TextFormat$Parser;
import com.google.protobuf.TextFormat$Printer;
import com.google.protobuf.TextFormat$TextGenerator;
import com.google.protobuf.TextFormatEscaper;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.math.BigInteger;
import java.util.logging.Logger;

public final class TextFormat {
    private static final TextFormat$Parser PARSER;
    private static final Logger logger;

    static {
        logger = Logger.getLogger(TextFormat.class.getName());
        PARSER = TextFormat$Parser.newBuilder().build();
    }

    private TextFormat() {
    }

    public static /* synthetic */ TextFormat$TextGenerator access$200(Appendable appendable) {
        return TextFormat.multiLineOutput(appendable);
    }

    public static /* synthetic */ TextFormat$TextGenerator access$300(Appendable appendable) {
        return TextFormat.singleLineOutput(appendable);
    }

    public static /* synthetic */ Logger access$600() {
        return logger;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int digitValue(byte n10) {
        int n11;
        int n12 = 48;
        if (n12 <= n10 && n10 <= (n11 = 57)) {
            return n10 - n12;
        }
        n12 = 97;
        if (n12 <= n10 && n10 <= (n11 = 122)) {
            n10 -= n12;
            return n10 + 10;
        }
        n10 += -65;
        return n10 + 10;
    }

    public static String escapeBytes(ByteString byteString) {
        return TextFormatEscaper.escapeBytes(byteString);
    }

    public static String escapeBytes(byte[] byArray) {
        return TextFormatEscaper.escapeBytes(byArray);
    }

    public static String escapeDoubleQuotesAndBackslashes(String string2) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(string2);
    }

    public static String escapeText(String string2) {
        return TextFormat.escapeBytes(ByteString.copyFromUtf8(string2));
    }

    public static TextFormat$Parser getParser() {
        return PARSER;
    }

    private static boolean isHex(byte n10) {
        int n11 = 48;
        n10 = n11 <= n10 && n10 <= (n11 = 57) || (n11 = 97) <= n10 && n10 <= (n11 = 102) || (n11 = 65) <= n10 && n10 <= (n11 = 70) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean isOctal(byte n10) {
        int n11 = 48;
        n10 = n11 <= n10 && n10 <= (n11 = 55) ? 1 : 0;
        return n10 != 0;
    }

    public static void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message$Builder message$Builder) {
        PARSER.merge(charSequence, extensionRegistry, message$Builder);
    }

    public static void merge(CharSequence charSequence, Message$Builder message$Builder) {
        PARSER.merge(charSequence, message$Builder);
    }

    public static void merge(Readable readable, ExtensionRegistry extensionRegistry, Message$Builder message$Builder) {
        PARSER.merge(readable, extensionRegistry, message$Builder);
    }

    public static void merge(Readable readable, Message$Builder message$Builder) {
        PARSER.merge(readable, message$Builder);
    }

    private static TextFormat$TextGenerator multiLineOutput(Appendable appendable) {
        TextFormat$TextGenerator textFormat$TextGenerator = new TextFormat$TextGenerator(appendable, false, null);
        return textFormat$TextGenerator;
    }

    public static Message parse(CharSequence charSequence, ExtensionRegistry extensionRegistry, Class object) {
        object = ((Message)Internal.getDefaultInstance((Class)object)).newBuilderForType();
        TextFormat.merge(charSequence, extensionRegistry, (Message$Builder)object);
        return object.build();
    }

    public static Message parse(CharSequence charSequence, Class object) {
        object = ((Message)Internal.getDefaultInstance((Class)object)).newBuilderForType();
        TextFormat.merge(charSequence, (Message$Builder)object);
        return object.build();
    }

    public static int parseInt32(String string2) {
        return (int)TextFormat.parseInteger(string2, true, false);
    }

    public static long parseInt64(String string2) {
        boolean bl2 = true;
        return TextFormat.parseInteger(string2, bl2, bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static long parseInteger(String string2, boolean object, boolean n10) {
        int n11;
        String string3 = "-";
        int n12 = 0;
        String string4 = null;
        int n13 = string2.startsWith(string3, 0);
        int n14 = 1;
        if (n13 != 0) {
            if (object == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Number must be positive: ");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                NumberFormatException numberFormatException = new NumberFormatException(string2);
                throw numberFormatException;
            }
            n12 = n14;
        } else {
            n14 = 0;
        }
        n13 = 10;
        Object object2 = "0x";
        int n15 = string2.startsWith((String)object2, n12);
        int n16 = 16;
        if (n15 != 0) {
            n12 += 2;
            n13 = n16;
        } else {
            object2 = "0";
            n15 = string2.startsWith((String)object2, n12);
            if (n15 != 0) {
                n13 = 8;
            }
        }
        string4 = string2.substring(n12);
        n15 = string4.length();
        String string5 = "Number out of range for 32-bit signed integer: ";
        String string6 = "Number out of range for 32-bit unsigned integer: ";
        if (n15 < n16) {
            long l10;
            long l11;
            long l12 = Long.parseLong(string4, n13);
            if (n14 != 0) {
                l12 = -l12;
            }
            if (n11 != false) return l12;
            if (object != 0) {
                long l13;
                long l14;
                long l15 = Integer.MAX_VALUE;
                long l16 = l12 - l15;
                Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object3 <= 0 && (l14 = (l13 = l12 - (l15 = 0x80000000L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0) {
                    return l12;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string5);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                NumberFormatException numberFormatException = new NumberFormatException(string2);
                throw numberFormatException;
            }
            long l17 = 0x100000000L;
            long l18 = l12 - l17;
            Object object4 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object4 < 0 && (l11 = (l10 = l12 - (l17 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0) {
                return l12;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string6);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            NumberFormatException numberFormatException = new NumberFormatException(string2);
            throw numberFormatException;
        }
        object2 = new BigInteger(string4, n13);
        if (n14 != 0) {
            object2 = ((BigInteger)object2).negate();
        }
        if (n11 == 0) {
            if (object != 0) {
                int n17 = ((BigInteger)object2).bitLength();
                if (n17 <= (n11 = 31)) return ((BigInteger)object2).longValue();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string5);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                NumberFormatException numberFormatException = new NumberFormatException(string2);
                throw numberFormatException;
            }
            int n18 = ((BigInteger)object2).bitLength();
            if (n18 <= (n11 = 32)) return ((BigInteger)object2).longValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string6);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            NumberFormatException numberFormatException = new NumberFormatException(string2);
            throw numberFormatException;
        }
        if (object != 0) {
            int n19 = ((BigInteger)object2).bitLength();
            if (n19 <= (n11 = 63)) return ((BigInteger)object2).longValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Number out of range for 64-bit signed integer: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            NumberFormatException numberFormatException = new NumberFormatException(string2);
            throw numberFormatException;
        }
        int n20 = ((BigInteger)object2).bitLength();
        if (n20 <= (n11 = 64)) return ((BigInteger)object2).longValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Number out of range for 64-bit unsigned integer: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        NumberFormatException numberFormatException = new NumberFormatException(string2);
        throw numberFormatException;
    }

    public static int parseUInt32(String string2) {
        return (int)TextFormat.parseInteger(string2, false, false);
    }

    public static long parseUInt64(String string2) {
        return TextFormat.parseInteger(string2, false, true);
    }

    public static void print(MessageOrBuilder messageOrBuilder, Appendable appendable) {
        TextFormat.printer().print(messageOrBuilder, appendable);
    }

    public static void print(UnknownFieldSet unknownFieldSet, Appendable appendable) {
        TextFormat.printer().print(unknownFieldSet, appendable);
    }

    public static void printField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, Appendable appendable) {
        TextFormat.printer().printField(descriptors$FieldDescriptor, object, appendable);
    }

    public static String printFieldToString(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return TextFormat.printer().printFieldToString(descriptors$FieldDescriptor, object);
    }

    public static void printFieldValue(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, Appendable appendable) {
        TextFormat.printer().printFieldValue(descriptors$FieldDescriptor, object, appendable);
    }

    public static String printToString(MessageOrBuilder messageOrBuilder) {
        return TextFormat.printer().printToString(messageOrBuilder);
    }

    public static String printToString(UnknownFieldSet unknownFieldSet) {
        return TextFormat.printer().printToString(unknownFieldSet);
    }

    public static String printToUnicodeString(MessageOrBuilder messageOrBuilder) {
        return TextFormat.printer().escapingNonAscii(false).printToString(messageOrBuilder);
    }

    public static String printToUnicodeString(UnknownFieldSet unknownFieldSet) {
        return TextFormat.printer().escapingNonAscii(false).printToString(unknownFieldSet);
    }

    public static void printUnicode(MessageOrBuilder messageOrBuilder, Appendable appendable) {
        TextFormat.printer().escapingNonAscii(false).print(messageOrBuilder, appendable);
    }

    public static void printUnicode(UnknownFieldSet unknownFieldSet, Appendable appendable) {
        TextFormat.printer().escapingNonAscii(false).print(unknownFieldSet, appendable);
    }

    public static void printUnicodeFieldValue(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, Appendable appendable) {
        TextFormat.printer().escapingNonAscii(false).printFieldValue(descriptors$FieldDescriptor, object, appendable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void printUnknownFieldValue(int n10, Object object, TextFormat$TextGenerator object2) {
        int n11 = WireFormat.getTagWireType(n10);
        if (n11 == 0) {
            object = (Long)object;
            long l10 = (Long)object;
            String string2 = TextFormat.unsignedToString(l10);
            ((TextFormat$TextGenerator)object2).print(string2);
            return;
        }
        int n12 = 1;
        if (n11 == n12) {
            Object[] objectArray = new Object[n12];
            objectArray[0] = object = (Long)object;
            object = "0x%016x";
            String string3 = String.format(null, (String)object, objectArray);
            ((TextFormat$TextGenerator)object2).print(string3);
            return;
        }
        int n13 = 2;
        if (n11 != n13) {
            n13 = 3;
            if (n11 == n13) {
                object = (UnknownFieldSet)object;
                TextFormat$Printer.access$000((UnknownFieldSet)object, (TextFormat$TextGenerator)object2);
                return;
            }
            n13 = 5;
            if (n11 == n13) {
                Object[] objectArray = new Object[n12];
                objectArray[0] = object = (Integer)object;
                object = "0x%08x";
                String string4 = String.format(null, (String)object, objectArray);
                ((TextFormat$TextGenerator)object2).print(string4);
                return;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Bad tag: ");
            ((StringBuilder)object2).append(n10);
            String string5 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string5);
            throw object;
        }
        Object object3 = object;
        try {
            ByteString byteString = (ByteString)object;
            UnknownFieldSet unknownFieldSet = UnknownFieldSet.parseFrom(byteString);
            String string6 = "{";
            ((TextFormat$TextGenerator)object2).print(string6);
            ((TextFormat$TextGenerator)object2).eol();
            ((TextFormat$TextGenerator)object2).indent();
            TextFormat$Printer.access$000(unknownFieldSet, (TextFormat$TextGenerator)object2);
            ((TextFormat$TextGenerator)object2).outdent();
            String string7 = "}";
            ((TextFormat$TextGenerator)object2).print(string7);
            return;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            String string8 = "\"";
            ((TextFormat$TextGenerator)object2).print(string8);
            object = TextFormat.escapeBytes((ByteString)object);
            ((TextFormat$TextGenerator)object2).print((CharSequence)object);
            ((TextFormat$TextGenerator)object2).print(string8);
            return;
        }
    }

    public static void printUnknownFieldValue(int n10, Object object, Appendable object2) {
        object2 = TextFormat.multiLineOutput((Appendable)object2);
        TextFormat.printUnknownFieldValue(n10, object, (TextFormat$TextGenerator)object2);
    }

    public static TextFormat$Printer printer() {
        return TextFormat$Printer.access$100();
    }

    public static String shortDebugString(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return TextFormat.printer().shortDebugString(descriptors$FieldDescriptor, object);
    }

    public static String shortDebugString(MessageOrBuilder messageOrBuilder) {
        return TextFormat.printer().shortDebugString(messageOrBuilder);
    }

    public static String shortDebugString(UnknownFieldSet unknownFieldSet) {
        return TextFormat.printer().shortDebugString(unknownFieldSet);
    }

    private static TextFormat$TextGenerator singleLineOutput(Appendable appendable) {
        TextFormat$TextGenerator textFormat$TextGenerator = new TextFormat$TextGenerator(appendable, true, null);
        return textFormat$TextGenerator;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ByteString unescapeBytes(CharSequence object) {
        int n10;
        object = ByteString.copyFromUtf8(object.toString());
        int n11 = ((ByteString)object).size();
        byte[] byArray = new byte[n11];
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = ((ByteString)object).size()); ++i10) {
            int n13;
            block13: {
                block14: {
                    block12: {
                        int n14;
                        block16: {
                            block17: {
                                block18: {
                                    block19: {
                                        block20: {
                                            block21: {
                                                block22: {
                                                    block23: {
                                                        block15: {
                                                            n10 = ((ByteString)object).byteAt(i10);
                                                            if (n10 != (n13 = 92)) break block14;
                                                            n10 = ((ByteString)object).size();
                                                            if (++i10 >= n10) {
                                                                object = new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                                                                throw object;
                                                            }
                                                            n10 = ((ByteString)object).byteAt(i10);
                                                            n14 = TextFormat.isOctal((byte)n10);
                                                            if (n14 == 0) break block15;
                                                            n10 = TextFormat.digitValue((byte)n10);
                                                            n13 = i10 + 1;
                                                            n14 = ((ByteString)object).size();
                                                            if (n13 < n14 && (n14 = (int)(TextFormat.isOctal(((ByteString)object).byteAt(n13)) ? 1 : 0)) != 0) {
                                                                n10 *= 8;
                                                                i10 = TextFormat.digitValue(((ByteString)object).byteAt(n13));
                                                                n10 += i10;
                                                                i10 = n13;
                                                            }
                                                            if ((n13 = i10 + 1) < (n14 = ((ByteString)object).size()) && (n14 = (int)(TextFormat.isOctal(((ByteString)object).byteAt(n13)) ? 1 : 0)) != 0) {
                                                                n10 *= 8;
                                                                i10 = TextFormat.digitValue(((ByteString)object).byteAt(n13));
                                                                n10 += i10;
                                                                i10 = n13;
                                                            }
                                                            n13 = n12 + 1;
                                                            byArray[n12] = n10 = (int)((byte)n10);
                                                            break block13;
                                                        }
                                                        n14 = 34;
                                                        if (n10 == n14) break block16;
                                                        n14 = 39;
                                                        if (n10 == n14) break block17;
                                                        if (n10 == n13) break block18;
                                                        n13 = 102;
                                                        if (n10 == n13) break block19;
                                                        n13 = 110;
                                                        if (n10 == n13) break block20;
                                                        n13 = 114;
                                                        if (n10 == n13) break block21;
                                                        n13 = 116;
                                                        if (n10 == n13) break block22;
                                                        n13 = 118;
                                                        if (n10 == n13) break block23;
                                                        n13 = 120;
                                                        if (n10 != n13) {
                                                            n13 = 97;
                                                            if (n10 != n13) {
                                                                n13 = 98;
                                                                if (n10 != n13) {
                                                                    StringBuilder stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("Invalid escape sequence: '\\");
                                                                    char c10 = (char)n10;
                                                                    stringBuilder.append(c10);
                                                                    stringBuilder.append((char)n14);
                                                                    String string2 = stringBuilder.toString();
                                                                    object = new TextFormat$InvalidEscapeSequenceException(string2);
                                                                    throw object;
                                                                }
                                                                n10 = n12 + 1;
                                                                byArray[n12] = n13 = 8;
                                                                break block12;
                                                            } else {
                                                                n10 = n12 + 1;
                                                                byArray[n12] = n13 = 7;
                                                            }
                                                            break block12;
                                                        } else {
                                                            n10 = ((ByteString)object).size();
                                                            if (++i10 < n10 && (n10 = (int)(TextFormat.isHex(((ByteString)object).byteAt(i10)) ? 1 : 0)) != 0) {
                                                                n10 = TextFormat.digitValue(((ByteString)object).byteAt(i10));
                                                                n13 = i10 + 1;
                                                                n14 = ((ByteString)object).size();
                                                                if (n13 < n14 && (n14 = (int)(TextFormat.isHex(((ByteString)object).byteAt(n13)) ? 1 : 0)) != 0) {
                                                                    n10 *= 16;
                                                                    i10 = TextFormat.digitValue(((ByteString)object).byteAt(n13));
                                                                    n10 += i10;
                                                                    i10 = n13;
                                                                }
                                                                n13 = n12 + 1;
                                                                byArray[n12] = n10 = (int)((byte)n10);
                                                                break block13;
                                                            } else {
                                                                object = new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                                                                throw object;
                                                            }
                                                        }
                                                    }
                                                    n10 = n12 + 1;
                                                    byArray[n12] = n13 = 11;
                                                    break block12;
                                                }
                                                n10 = n12 + 1;
                                                byArray[n12] = n13 = 9;
                                                break block12;
                                            }
                                            n10 = n12 + 1;
                                            byArray[n12] = n13 = 13;
                                            break block12;
                                        }
                                        n10 = n12 + 1;
                                        byArray[n12] = n13 = 10;
                                        break block12;
                                    }
                                    n10 = n12 + 1;
                                    byArray[n12] = n13 = 12;
                                    break block12;
                                }
                                n10 = n12 + 1;
                                byArray[n12] = n13;
                                break block12;
                            }
                            n10 = n12 + 1;
                            byArray[n12] = n14;
                            break block12;
                        }
                        n10 = n12 + 1;
                        byArray[n12] = n14;
                    }
                    n12 = n10;
                    continue;
                }
                n13 = n12 + 1;
                byArray[n12] = n10;
            }
            n12 = n13;
        }
        if (n11 != n12) return ByteString.copyFrom(byArray, 0, n12);
        return ByteString.wrap(byArray);
    }

    public static String unescapeText(String string2) {
        return TextFormat.unescapeBytes(string2).toStringUtf8();
    }

    public static String unsignedToString(int n10) {
        if (n10 >= 0) {
            return Integer.toString(n10);
        }
        return Long.toString((long)n10 & 0xFFFFFFFFL);
    }

    public static String unsignedToString(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            return Long.toString(l10);
        }
        return BigInteger.valueOf(l10 & Long.MAX_VALUE).setBit(63).toString();
    }
}

