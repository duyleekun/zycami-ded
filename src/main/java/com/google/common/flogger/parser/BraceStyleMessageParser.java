/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

import com.google.common.flogger.parser.MessageBuilder;
import com.google.common.flogger.parser.MessageParser;
import com.google.common.flogger.parser.ParseException;

public abstract class BraceStyleMessageParser
extends MessageParser {
    private static final char BRACE_STYLE_SEPARATOR = ',';

    public static int nextBraceFormatTerm(String string2, int n10) {
        int n11;
        block0: while (n10 < (n11 = string2.length())) {
            int n12;
            n11 = n10 + 1;
            if ((n10 = (int)string2.charAt(n10)) == (n12 = 123)) {
                return n11 + -1;
            }
            n12 = 39;
            if (n10 != n12) {
                n10 = n11;
                continue;
            }
            n10 = string2.length();
            if (n11 != n10) {
                int n13;
                n10 = n11 + 1;
                if ((n11 = (int)string2.charAt(n11)) == n12) continue;
                n11 = n10 + -2;
                while (n10 != (n13 = string2.length())) {
                    n13 = n10 + 1;
                    if ((n10 = (int)string2.charAt(n10)) == n12) {
                        n10 = n13;
                        continue block0;
                    }
                    n10 = n13;
                }
                throw ParseException.withStartPosition("unmatched single quote", string2, n11);
            }
            throw ParseException.withStartPosition("trailing single quote", string2, n11 += -1);
        }
        return -1;
    }

    public static void unescapeBraceFormat(StringBuilder stringBuilder, String string2, int n10, int n11) {
        int n12 = n10;
        boolean bl2 = false;
        while (n10 < n11) {
            int n13 = n10 + 1;
            n10 = string2.charAt(n10);
            int n14 = 92;
            int n15 = 39;
            if (n10 != n14 && n10 != n15) {
                n10 = n13;
                continue;
            }
            int n16 = n13 + -1;
            if (n10 == n14) {
                n10 = n13 + 1;
                if ((n13 = (int)string2.charAt(n13)) != n15) {
                    continue;
                }
            } else {
                n10 = n13;
            }
            stringBuilder.append(string2, n12, n16);
            if (n10 == n11) {
                n12 = n10;
                break;
            }
            if (bl2) {
                n12 = n10;
                bl2 = false;
            } else {
                n12 = string2.charAt(n10);
                if (n12 != n15) {
                    bl2 = true;
                    n12 = n10;
                } else {
                    n12 = n10 + 1;
                }
            }
            int n17 = n12;
            n12 = n10;
            n10 = n17;
        }
        if (n12 < n11) {
            stringBuilder.append(string2, n12, n11);
        }
    }

    public abstract void parseBraceFormatTerm(MessageBuilder var1, int var2, String var3, int var4, int var5, int var6);

    /*
     * Unable to fully structure code
     */
    public final void parseImpl(MessageBuilder var1_1) {
        var2_2 = var1_1.getMessage();
        var4_4 = var3_3 = BraceStyleMessageParser.nextBraceFormatTerm(var2_2, 0);
        block0: while (var4_4 >= 0) {
            block7: {
                block9: {
                    block11: {
                        block10: {
                            block8: {
                                var5_5 = var3_3 = var4_4 + 1;
                                var6_6 = 0;
                                while (true) {
                                    var7_7 = var2_2.length();
                                    var8_8 = "unterminated parameter";
                                    if (var5_5 >= var7_7) break block7;
                                    var7_7 = var5_5 + 1;
                                    var9_9 = (var5_5 = (int)var2_2.charAt(var5_5)) + -48;
                                    if (var9_9 >= (var10_10 = 10)) break block8;
                                    var5_5 = 1000000;
                                    if ((var6_6 = var6_6 * 10 + var9_9) >= var5_5) break;
                                    var5_5 = var7_7;
                                }
                                throw ParseException.withBounds("index too large", var2_2, var3_3, var7_7);
                            }
                            var9_9 = var7_7 + -1;
                            var10_10 = var9_9 - var3_3;
                            if (var10_10 == 0) break block9;
                            var11_11 = var2_2.charAt(var3_3);
                            if (var11_11 == (var12_12 = '0') && var10_10 > (var11_11 = '\u0001')) {
                                throw ParseException.withBounds("index has leading zero", var2_2, var3_3, var9_9);
                            }
                            var9_9 = 125;
                            if (var5_5 != var9_9) break block10;
                            var13_13 = var3_3 = -1;
                            var10_10 = var7_7;
                            ** GOTO lbl39
                        }
                        var10_10 = 44;
                        if (var5_5 != var10_10) break block11;
                        var3_3 = var7_7;
                        while (var3_3 != (var5_5 = var2_2.length())) {
                            block12: {
                                var5_5 = var3_3 + 1;
                                if ((var3_3 = (int)var2_2.charAt(var3_3)) != var9_9) break block12;
                                var10_10 = var5_5;
                                var13_13 = var7_7;
lbl39:
                                // 2 sources

                                var9_9 = var10_10;
                                this.parseBraceFormatTerm(var1_1, var6_6, var2_2, var4_4, var13_13, var10_10);
                                var4_4 = BraceStyleMessageParser.nextBraceFormatTerm(var2_2, var10_10);
                                continue block0;
                            }
                            var3_3 = var5_5;
                        }
                        throw ParseException.withStartPosition(var8_8, var2_2, var4_4);
                    }
                    throw ParseException.withBounds("malformed index", var2_2, var3_3, var7_7);
                }
                throw ParseException.withBounds("missing index", var2_2, var4_4, var7_7);
            }
            throw ParseException.withStartPosition(var8_8, var2_2, var4_4);
        }
    }

    public final void unescape(StringBuilder stringBuilder, String string2, int n10, int n11) {
        BraceStyleMessageParser.unescapeBraceFormat(stringBuilder, string2, n10, n11);
    }
}

