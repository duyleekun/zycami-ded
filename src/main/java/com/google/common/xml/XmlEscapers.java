/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.xml;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import com.google.common.escape.Escapers$Builder;

public class XmlEscapers {
    private static final char MAX_ASCII_CONTROL_CHAR = '\u001f';
    private static final char MIN_ASCII_CONTROL_CHAR;
    private static final Escaper XML_ATTRIBUTE_ESCAPER;
    private static final Escaper XML_CONTENT_ESCAPER;
    private static final Escaper XML_ESCAPER;

    static {
        char c10;
        char c11;
        char c12;
        Escapers$Builder escapers$Builder = Escapers.builder();
        char c13 = '\u0000';
        char c14 = (char)-3;
        escapers$Builder.setSafeRange('\u0000', c14);
        String string2 = "\ufffd";
        escapers$Builder.setUnsafeReplacement(string2);
        while (true) {
            char c15 = '\u001f';
            c12 = '\r';
            c11 = '\n';
            c10 = '\t';
            if (c13 > c15) break;
            if (c13 != c10 && c13 != c11 && c13 != c12) {
                escapers$Builder.addEscape(c13, string2);
            }
            c13 = (char)(c13 + 1);
        }
        escapers$Builder.addEscape('&', "&amp;");
        escapers$Builder.addEscape('<', "&lt;");
        escapers$Builder.addEscape('>', "&gt;");
        XML_CONTENT_ESCAPER = escapers$Builder.build();
        escapers$Builder.addEscape('\'', "&apos;");
        escapers$Builder.addEscape('\"', "&quot;");
        XML_ESCAPER = escapers$Builder.build();
        escapers$Builder.addEscape(c10, "&#x9;");
        escapers$Builder.addEscape(c11, "&#xA;");
        escapers$Builder.addEscape(c12, "&#xD;");
        XML_ATTRIBUTE_ESCAPER = escapers$Builder.build();
    }

    private XmlEscapers() {
    }

    public static Escaper xmlAttributeEscaper() {
        return XML_ATTRIBUTE_ESCAPER;
    }

    public static Escaper xmlContentEscaper() {
        return XML_CONTENT_ESCAPER;
    }
}

