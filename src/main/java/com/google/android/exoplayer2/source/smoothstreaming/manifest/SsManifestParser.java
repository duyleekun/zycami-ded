/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$ElementParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$SmoothStreamingMediaParser;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class SsManifestParser
implements ParsingLoadable$Parser {
    private final XmlPullParserFactory xmlParserFactory;

    public SsManifestParser() {
        XmlPullParserFactory xmlPullParserFactory;
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
        }
        catch (XmlPullParserException xmlPullParserException) {
            RuntimeException runtimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", xmlPullParserException);
            throw runtimeException;
        }
        this.xmlParserFactory = xmlPullParserFactory;
    }

    public SsManifest parse(Uri object, InputStream object2) {
        XmlPullParserFactory xmlPullParserFactory;
        try {
            xmlPullParserFactory = this.xmlParserFactory;
        }
        catch (XmlPullParserException xmlPullParserException) {
            object2 = new ParserException(xmlPullParserException);
            throw object2;
        }
        xmlPullParserFactory = xmlPullParserFactory.newPullParser();
        xmlPullParserFactory.setInput((InputStream)object2, null);
        object = object.toString();
        object2 = new SsManifestParser$SmoothStreamingMediaParser(null, (String)object);
        object = ((SsManifestParser$ElementParser)object2).parse((XmlPullParser)xmlPullParserFactory);
        return (SsManifest)object;
    }
}

