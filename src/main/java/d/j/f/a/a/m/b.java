/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.m;

import javax.xml.parsers.SAXParserFactory;

public class b {
    public static SAXParserFactory a() {
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        boolean bl2 = true;
        sAXParserFactory.setFeature("http://xml.org/sax/features/namespaces", bl2);
        sAXParserFactory.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
        sAXParserFactory.setFeature("http://xml.org/sax/features/validation", false);
        sAXParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        sAXParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        sAXParserFactory.setFeature("http://xml.org/sax/features/string-interning", bl2);
        return sAXParserFactory;
    }
}

