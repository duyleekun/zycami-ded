/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package d.j.f.a.a.m;

import org.xmlpull.v1.XmlPullParserFactory;

public class c {
    public static XmlPullParserFactory a() {
        XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        boolean bl2 = true;
        xmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", bl2);
        xmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes", false);
        xmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", bl2);
        xmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#validation", false);
        return xmlPullParserFactory;
    }
}

