/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 */
package com.google.android.exoplayer2.util;

import org.xmlpull.v1.XmlPullParser;

public final class XmlPullParserUtil {
    private XmlPullParserUtil() {
    }

    public static String getAttributeValue(XmlPullParser xmlPullParser, String string2) {
        int n10 = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = xmlPullParser.getAttributeName(i10);
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return xmlPullParser.getAttributeValue(i10);
        }
        return null;
    }

    public static String getAttributeValueIgnorePrefix(XmlPullParser xmlPullParser, String string2) {
        int n10 = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = XmlPullParserUtil.stripPrefix(xmlPullParser.getAttributeName(i10));
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return xmlPullParser.getAttributeValue(i10);
        }
        return null;
    }

    public static boolean isEndTag(XmlPullParser xmlPullParser) {
        int n10;
        int n11 = xmlPullParser.getEventType();
        if (n11 == (n10 = 3)) {
            n11 = 1;
        } else {
            n11 = 0;
            xmlPullParser = null;
        }
        return n11 != 0;
    }

    public static boolean isEndTag(XmlPullParser object, String string2) {
        boolean bl2;
        boolean bl3 = XmlPullParserUtil.isEndTag((XmlPullParser)object);
        if (bl3 && (bl2 = ((String)(object = object.getName())).equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean isStartTag(XmlPullParser xmlPullParser) {
        int n10;
        int n11 = xmlPullParser.getEventType();
        if (n11 == (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            xmlPullParser = null;
        }
        return n11 != 0;
    }

    public static boolean isStartTag(XmlPullParser object, String string2) {
        boolean bl2;
        boolean bl3 = XmlPullParserUtil.isStartTag((XmlPullParser)object);
        if (bl3 && (bl2 = ((String)(object = object.getName())).equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean isStartTagIgnorePrefix(XmlPullParser object, String string2) {
        boolean bl2;
        boolean bl3 = XmlPullParserUtil.isStartTag((XmlPullParser)object);
        if (bl3 && (bl2 = ((String)(object = XmlPullParserUtil.stripPrefix(object.getName()))).equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static String stripPrefix(String string2) {
        int n10;
        int n11 = string2.indexOf(58);
        if (n11 != (n10 = -1)) {
            string2 = string2.substring(++n11);
        }
        return string2;
    }
}

