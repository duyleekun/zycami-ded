/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.m;

import javax.xml.parsers.DocumentBuilderFactory;

public class a {
    public static DocumentBuilderFactory a() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://xml.org/sax/features/namespaces", true);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/validation", false);
        documentBuilderFactory.setExpandEntityReferences(false);
        return documentBuilderFactory;
    }
}

