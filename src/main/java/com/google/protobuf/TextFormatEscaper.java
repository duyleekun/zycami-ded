/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormatEscaper$1;
import com.google.protobuf.TextFormatEscaper$2;
import com.google.protobuf.TextFormatEscaper$ByteSequence;

public final class TextFormatEscaper {
    private TextFormatEscaper() {
    }

    public static String escapeBytes(ByteString byteString) {
        TextFormatEscaper$1 textFormatEscaper$1 = new TextFormatEscaper$1(byteString);
        return TextFormatEscaper.escapeBytes(textFormatEscaper$1);
    }

    public static String escapeBytes(TextFormatEscaper$ByteSequence textFormatEscaper$ByteSequence) {
        char c10;
        int n10 = textFormatEscaper$ByteSequence.size();
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (n10 = 0; n10 < (c10 = textFormatEscaper$ByteSequence.size()); ++n10) {
            String string2;
            char c11;
            c10 = (char)textFormatEscaper$ByteSequence.byteAt(n10);
            if (c10 != (c11 = '\"')) {
                c11 = '\'';
                if (c10 != c11) {
                    c11 = '\\';
                    if (c10 != c11) {
                        switch (c10) {
                            default: {
                                char c12 = ' ';
                                if (c10 >= c12 && c10 <= (c12 = '~')) {
                                    c10 = c10;
                                    stringBuilder.append(c10);
                                    break;
                                }
                                stringBuilder.append(c11);
                                c11 = (char)((c10 >>> 6 & 3) + 48);
                                stringBuilder.append(c11);
                                c11 = (char)((c10 >>> 3 & 7) + 48);
                                stringBuilder.append(c11);
                                c10 = (char)((c10 & 7) + 48);
                                stringBuilder.append(c10);
                                break;
                            }
                            case '\r': {
                                string2 = "\\r";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\f': {
                                string2 = "\\f";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\u000b': {
                                string2 = "\\v";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\n': {
                                string2 = "\\n";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\t': {
                                string2 = "\\t";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\b': {
                                string2 = "\\b";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\u0007': {
                                string2 = "\\a";
                                stringBuilder.append(string2);
                                break;
                            }
                        }
                        continue;
                    }
                    string2 = "\\\\";
                    stringBuilder.append(string2);
                    continue;
                }
                string2 = "\\'";
                stringBuilder.append(string2);
                continue;
            }
            string2 = "\\\"";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static String escapeBytes(byte[] byArray) {
        TextFormatEscaper$2 textFormatEscaper$2 = new TextFormatEscaper$2(byArray);
        return TextFormatEscaper.escapeBytes(textFormatEscaper$2);
    }

    public static String escapeDoubleQuotesAndBackslashes(String string2) {
        return string2.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static String escapeText(String string2) {
        return TextFormatEscaper.escapeBytes(ByteString.copyFromUtf8(string2));
    }
}

