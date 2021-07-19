/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

import com.google.common.flogger.parser.MessageBuilder;
import com.google.common.flogger.parser.MessageParser;
import com.google.common.flogger.parser.ParseException;

public abstract class PrintfMessageParser
extends MessageParser {
    private static final String ALLOWED_NEWLINE_PATTERN = "\\n|\\r(?:\\n)?";
    private static final String SYSTEM_NEWLINE = PrintfMessageParser.getSafeSystemNewline();

    private static int findFormatChar(String string2, int n10, int n11) {
        int n12;
        while (n11 < (n12 = string2.length())) {
            int n13;
            n12 = (char)((string2.charAt(n11) & 0xFFFFFFDF) + -65);
            if (n12 < (n13 = 26)) {
                return n11;
            }
            ++n11;
        }
        throw ParseException.withStartPosition("unterminated parameter", string2, n10);
    }

    public static String getSafeSystemNewline() {
        String string2;
        String string3 = "line.separator";
        try {
            string3 = System.getProperty(string3);
            string2 = ALLOWED_NEWLINE_PATTERN;
        }
        catch (SecurityException securityException) {}
        boolean bl2 = string3.matches(string2);
        if (bl2) {
            return string3;
        }
        return "\n";
    }

    public static int nextPrintfTerm(String string2, int n10) {
        int n11;
        while (n10 < (n11 = string2.length())) {
            int n12;
            n11 = n10 + 1;
            if ((n10 = (int)string2.charAt(n10)) != (n12 = 37)) {
                n10 = n11;
                continue;
            }
            n10 = string2.length();
            if (n11 < n10) {
                n10 = string2.charAt(n11);
                if (n10 != n12 && n10 != (n12 = 110)) {
                    return n11 + -1;
                }
                n10 = n11 + 1;
                continue;
            }
            throw ParseException.withStartPosition("trailing unquoted '%' character", string2, n11 += -1);
        }
        return -1;
    }

    public static void unescapePrintf(StringBuilder stringBuilder, String string2, int n10, int n11) {
        int n12 = n10;
        while (n10 < n11) {
            int n13;
            block5: {
                block7: {
                    int n14;
                    block6: {
                        n13 = n10 + 1;
                        if ((n10 = (int)string2.charAt(n10)) != (n14 = 37)) break block5;
                        if (n13 == n11) break;
                        n10 = string2.charAt(n13);
                        if (n10 != n14) break block6;
                        stringBuilder.append(string2, n12, n13);
                        break block7;
                    }
                    n14 = 110;
                    if (n10 != n14) break block5;
                    n10 = n13 + -1;
                    stringBuilder.append(string2, n12, n10);
                    String string3 = SYSTEM_NEWLINE;
                    stringBuilder.append(string3);
                }
                n10 = n12 = n13 + 1;
                continue;
            }
            n10 = n13;
        }
        if (n12 < n11) {
            stringBuilder.append(string2, n12, n11);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void parseImpl(MessageBuilder messageBuilder) {
        String string2 = messageBuilder.getMessage();
        int n10 = PrintfMessageParser.nextPrintfTerm(string2, 0);
        int n11 = -1;
        int n12 = n10;
        n10 = 0;
        int n13 = n11;
        while (n12 >= 0) {
            int n14;
            int n15;
            String string3;
            int n16;
            int n17;
            int n18 = n17 = n12 + 1;
            int n19 = 0;
            while (true) {
                int n20;
                n16 = string2.length();
                string3 = "unterminated parameter";
                if (n18 >= n16) throw ParseException.withStartPosition(string3, string2, n12);
                n16 = n18 + 1;
                n15 = (n18 = (int)string2.charAt(n18)) + -48;
                if (n15 >= (n20 = 10)) break;
                n18 = 1000000;
                if ((n19 = n19 * 10 + n15) >= n18) throw ParseException.withBounds("index too large", string2, n12, n16);
                n18 = n16;
            }
            n15 = 36;
            if (n18 == n15) {
                n13 = n16 + -1 - n17;
                if (n13 == 0) throw ParseException.withBounds("missing index", string2, n12, n16);
                n13 = string2.charAt(n17);
                if (n13 == (n17 = 48)) throw ParseException.withBounds("index has leading zero", string2, n12, n16);
                n13 = string2.length();
                if (n16 == n13) throw ParseException.withStartPosition(string3, string2, n12);
                n13 = n16 + 1;
                string2.charAt(n16);
                n14 = n10;
                n15 = n19 += -1;
                n19 = n16;
                n16 = n13;
            } else {
                n19 = 60;
                if (n18 == n19) {
                    if (n13 == n11) throw ParseException.withBounds("invalid relative parameter", string2, n12, n16);
                    n17 = string2.length();
                    if (n16 == n17) throw ParseException.withStartPosition(string3, string2, n12);
                    n17 = n16 + 1;
                    string2.charAt(n16);
                    n14 = n10;
                    n15 = n13;
                    n19 = n16;
                    n16 = n17;
                } else {
                    n13 = n10 + 1;
                    n15 = n10;
                    n14 = n13;
                    n19 = n17;
                }
            }
            n16 += -1;
            n16 = PrintfMessageParser.findFormatChar(string2, n12, n16);
            n17 = n15;
            n10 = this.parsePrintfTerm(messageBuilder, n15, string2, n12, n19, n16);
            n12 = PrintfMessageParser.nextPrintfTerm(string2, n10);
            n10 = n14;
            n13 = n15;
        }
    }

    public abstract int parsePrintfTerm(MessageBuilder var1, int var2, String var3, int var4, int var5, int var6);

    public final void unescape(StringBuilder stringBuilder, String string2, int n10, int n11) {
        PrintfMessageParser.unescapePrintf(stringBuilder, string2, n10, n11);
    }
}

