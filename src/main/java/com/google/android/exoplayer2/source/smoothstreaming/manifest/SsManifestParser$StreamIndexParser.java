/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$ElementParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$MissingFieldException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class SsManifestParser$StreamIndexParser
extends SsManifestParser$ElementParser {
    private static final String KEY_DISPLAY_HEIGHT = "DisplayHeight";
    private static final String KEY_DISPLAY_WIDTH = "DisplayWidth";
    private static final String KEY_FRAGMENT_DURATION = "d";
    private static final String KEY_FRAGMENT_REPEAT_COUNT = "r";
    private static final String KEY_FRAGMENT_START_TIME = "t";
    private static final String KEY_LANGUAGE = "Language";
    private static final String KEY_MAX_HEIGHT = "MaxHeight";
    private static final String KEY_MAX_WIDTH = "MaxWidth";
    private static final String KEY_NAME = "Name";
    private static final String KEY_SUB_TYPE = "Subtype";
    private static final String KEY_TIME_SCALE = "TimeScale";
    private static final String KEY_TYPE = "Type";
    private static final String KEY_TYPE_AUDIO = "audio";
    private static final String KEY_TYPE_TEXT = "text";
    private static final String KEY_TYPE_VIDEO = "video";
    private static final String KEY_URL = "Url";
    public static final String TAG = "StreamIndex";
    private static final String TAG_STREAM_FRAGMENT = "c";
    private final String baseUri;
    private int displayHeight;
    private int displayWidth;
    private final List formats;
    private String language;
    private long lastChunkDuration;
    private int maxHeight;
    private int maxWidth;
    private String name;
    private ArrayList startTimes;
    private String subType;
    private long timescale;
    private int type;
    private String url;

    public SsManifestParser$StreamIndexParser(SsManifestParser$ElementParser linkedList, String string2) {
        super((SsManifestParser$ElementParser)((Object)linkedList), string2, TAG);
        this.baseUri = string2;
        this.formats = linkedList = new LinkedList();
    }

    private void parseStreamElementStartTag(XmlPullParser object) {
        long l10;
        int n10;
        this.type = n10 = this.parseType((XmlPullParser)object);
        Object object2 = n10;
        this.putNormalizedAttribute(KEY_TYPE, object2);
        n10 = this.type;
        String string2 = KEY_SUB_TYPE;
        String string3 = null;
        int n11 = 3;
        this.subType = n10 == n11 ? (object2 = this.parseRequiredString((XmlPullParser)object, string2)) : (object2 = object.getAttributeValue(null, string2));
        object2 = this.subType;
        this.putNormalizedAttribute(string2, object2);
        this.name = object2 = object.getAttributeValue(null, KEY_NAME);
        this.url = object2 = this.parseRequiredString((XmlPullParser)object, KEY_URL);
        int n12 = -1;
        this.maxWidth = n10 = this.parseInt((XmlPullParser)object, KEY_MAX_WIDTH, n12);
        this.maxHeight = n10 = this.parseInt((XmlPullParser)object, KEY_MAX_HEIGHT, n12);
        this.displayWidth = n10 = this.parseInt((XmlPullParser)object, KEY_DISPLAY_WIDTH, n12);
        this.displayHeight = n10 = this.parseInt((XmlPullParser)object, KEY_DISPLAY_HEIGHT, n12);
        object2 = KEY_LANGUAGE;
        this.language = string3 = object.getAttributeValue(null, (String)object2);
        this.putNormalizedAttribute((String)object2, string3);
        object2 = KEY_TIME_SCALE;
        this.timescale = l10 = (long)this.parseInt((XmlPullParser)object, (String)object2, n12);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            long l13;
            object = (Long)this.getNormalizedAttribute((String)object2);
            this.timescale = l13 = ((Long)object).longValue();
        }
        object = new ArrayList();
        this.startTimes = object;
    }

    private void parseStreamFragmentStartTag(XmlPullParser object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2 = this.startTimes;
        int n10 = ((ArrayList)object2).size();
        Object object3 = KEY_FRAGMENT_START_TIME;
        long l14 = -9223372036854775807L;
        long l15 = this.parseLong((XmlPullParser)object, (String)object3, l14);
        Object object4 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1);
        int n11 = 1;
        if (object4 == false) {
            if (n10 == 0) {
                l15 = 0L;
            } else {
                l15 = this.lastChunkDuration;
                l13 = -1;
                long l16 = l15 - l13;
                object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object4 != false) {
                    object3 = this.startTimes;
                    object2 = (Long)((ArrayList)object3).get(n10 -= n11);
                    l12 = (Long)object2;
                    l15 = this.lastChunkDuration + l12;
                } else {
                    object = new ParserException("Unable to infer start time");
                    throw object;
                }
            }
        }
        object2 = this.startTimes;
        object3 = l15;
        ((ArrayList)object2).add(object3);
        this.lastChunkDuration = l12 = this.parseLong((XmlPullParser)object, KEY_FRAGMENT_DURATION, l14);
        object2 = KEY_FRAGMENT_REPEAT_COUNT;
        l13 = 1L;
        l12 = this.parseLong((XmlPullParser)object, (String)object2, l13);
        long l17 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l17 > 0 && (l17 = (l11 = (l13 = this.lastChunkDuration) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
            object = new ParserException("Repeated chunk with unspecified duration");
            throw object;
        }
        while ((l17 = (l10 = (l14 = (long)n11) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0) {
            object = this.startTimes;
            l13 = this.lastChunkDuration * l14 + l15;
            Long l18 = l13;
            ((ArrayList)object).add(l18);
            ++n11;
        }
    }

    private int parseType(XmlPullParser object) {
        boolean bl2 = false;
        Object object2 = null;
        String string2 = KEY_TYPE;
        if ((object = object.getAttributeValue(null, string2)) != null) {
            object2 = KEY_TYPE_AUDIO;
            bl2 = ((String)object2).equalsIgnoreCase((String)object);
            if (bl2) {
                return 1;
            }
            object2 = KEY_TYPE_VIDEO;
            bl2 = ((String)object2).equalsIgnoreCase((String)object);
            if (bl2) {
                return 2;
            }
            object2 = KEY_TYPE_TEXT;
            bl2 = ((String)object2).equalsIgnoreCase((String)object);
            if (bl2) {
                return 3;
            }
            int n10 = String.valueOf(object).length() + 19;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Invalid key value[");
            stringBuilder.append((String)object);
            stringBuilder.append("]");
            object = stringBuilder.toString();
            object2 = new ParserException((String)object);
            throw object2;
        }
        object = new SsManifestParser$MissingFieldException(string2);
        throw object;
    }

    public void addChild(Object object) {
        boolean bl2 = object instanceof Format;
        if (bl2) {
            List list = this.formats;
            object = (Format)object;
            list.add(object);
        }
    }

    public Object build() {
        Object object;
        Format[] formatArray = object = new Format[this.formats.size()];
        this.formats.toArray((T[])object);
        String string2 = this.baseUri;
        String string3 = this.url;
        int n10 = this.type;
        String string4 = this.subType;
        long l10 = this.timescale;
        String string5 = this.name;
        int n11 = this.maxWidth;
        int n12 = this.maxHeight;
        int n13 = this.displayWidth;
        int n14 = this.displayHeight;
        String string6 = this.language;
        object = this.startTimes;
        long l11 = this.lastChunkDuration;
        SsManifest$StreamElement ssManifest$StreamElement = new SsManifest$StreamElement(string2, string3, n10, string4, l10, string5, n11, n12, n13, n14, string6, formatArray, (List)object, l11);
        return ssManifest$StreamElement;
    }

    public boolean handleChildInline(String string2) {
        return TAG_STREAM_FRAGMENT.equals(string2);
    }

    public void parseStartTag(XmlPullParser xmlPullParser) {
        String string2 = TAG_STREAM_FRAGMENT;
        String string3 = xmlPullParser.getName();
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            this.parseStreamFragmentStartTag(xmlPullParser);
        } else {
            this.parseStreamElementStartTag(xmlPullParser);
        }
    }
}

