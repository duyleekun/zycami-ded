/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

import com.google.common.flogger.backend.FormatChar;
import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.parameter.DateTimeFormat;
import com.google.common.flogger.parameter.DateTimeParameter;
import com.google.common.flogger.parameter.Parameter;
import com.google.common.flogger.parameter.SimpleParameter;
import com.google.common.flogger.parser.DefaultPrintfMessageParser$1;
import com.google.common.flogger.parser.MessageBuilder;
import com.google.common.flogger.parser.ParseException;
import com.google.common.flogger.parser.PrintfMessageParser;

public class DefaultPrintfMessageParser
extends PrintfMessageParser {
    private static final PrintfMessageParser INSTANCE;

    static {
        DefaultPrintfMessageParser defaultPrintfMessageParser = new DefaultPrintfMessageParser();
        INSTANCE = defaultPrintfMessageParser;
    }

    private DefaultPrintfMessageParser() {
    }

    public static PrintfMessageParser getInstance() {
        return INSTANCE;
    }

    private static Parameter wrapHexParameter(FormatOptions formatOptions, int n10) {
        DefaultPrintfMessageParser$1 defaultPrintfMessageParser$1 = new DefaultPrintfMessageParser$1(formatOptions, n10, formatOptions);
        return defaultPrintfMessageParser$1;
    }

    public int parsePrintfTerm(MessageBuilder messageBuilder, int n10, String string2, int n11, int n12, int n13) {
        String string3;
        int n14;
        block9: {
            block10: {
                block11: {
                    Parameter parameter;
                    block6: {
                        FormatOptions formatOptions;
                        int n15;
                        int n16;
                        block7: {
                            block8: {
                                block4: {
                                    block5: {
                                        n14 = n13 + 1;
                                        n16 = string2.charAt(n13);
                                        n15 = n16 & 0x20;
                                        n15 = n15 == 0 ? 1 : 0;
                                        formatOptions = FormatOptions.parse(string2, n12, n13, n15 != 0);
                                        FormatChar formatChar = FormatChar.of((char)n16);
                                        if (formatChar == null) break block4;
                                        n16 = (int)(formatOptions.areValidFor(formatChar) ? 1 : 0);
                                        if (n16 == 0) break block5;
                                        parameter = SimpleParameter.of(n10, formatChar, formatOptions);
                                        break block6;
                                    }
                                    throw ParseException.withBounds("invalid format specifier", string2, n11, n14);
                                }
                                n13 = 116;
                                n15 = 160;
                                string3 = "invalid format specification";
                                if (n16 == n13 || n16 == (n13 = 84)) break block7;
                                n13 = 104;
                                if (n16 != n13 && n16 != (n13 = 72)) {
                                    throw ParseException.withBounds(string3, string2, n11, n14);
                                }
                                n13 = (int)(formatOptions.validate(n15, false) ? 1 : 0);
                                if (n13 == 0) break block8;
                                parameter = DefaultPrintfMessageParser.wrapHexParameter(formatOptions, n10);
                                break block6;
                            }
                            throw ParseException.withBounds(string3, string2, n11, n14);
                        }
                        n13 = (int)(formatOptions.validate(n15, false) ? 1 : 0);
                        if (n13 == 0) break block9;
                        n13 = n14 + 1;
                        n16 = string2.length();
                        if (n13 > n16) break block10;
                        n16 = string2.charAt(n14);
                        DateTimeFormat dateTimeFormat = DateTimeFormat.of((char)n16);
                        if (dateTimeFormat == null) break block11;
                        parameter = DateTimeParameter.of(dateTimeFormat, formatOptions, n10);
                        n14 = n13;
                    }
                    messageBuilder.addParameter(n11, n14, parameter);
                    return n14;
                }
                throw ParseException.atPosition("illegal date/time conversion", string2, n14);
            }
            throw ParseException.atPosition("truncated format specifier", string2, n11);
        }
        throw ParseException.withBounds(string3, string2, n11, n14);
    }
}

