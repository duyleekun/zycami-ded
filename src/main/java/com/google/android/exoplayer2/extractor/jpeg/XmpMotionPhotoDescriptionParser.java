/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.jpeg.MotionPhotoDescription;
import com.google.android.exoplayer2.extractor.jpeg.MotionPhotoDescription$ContainerItem;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import java.io.Reader;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class XmpMotionPhotoDescriptionParser {
    private static final String[] DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES;
    private static final String[] DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES;
    private static final String[] MOTION_PHOTO_ATTRIBUTE_NAMES;
    private static final String TAG = "MotionPhotoXmpParser";

    static {
        MOTION_PHOTO_ATTRIBUTE_NAMES = new String[]{"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
        DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES = new String[]{"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
        DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES = new String[]{"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};
    }

    private XmpMotionPhotoDescriptionParser() {
    }

    public static MotionPhotoDescription parse(String string2) {
        try {
            return XmpMotionPhotoDescriptionParser.parseInternal(string2);
        }
        catch (ParserException | NumberFormatException | XmlPullParserException throwable) {
            Log.w(TAG, "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static MotionPhotoDescription parseInternal(String object) {
        XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        StringReader stringReader = new StringReader((String)object);
        xmlPullParser.setInput((Reader)stringReader);
        xmlPullParser.next();
        object = "x:xmpmeta";
        boolean bl2 = XmlPullParserUtil.isStartTag(xmlPullParser, (String)object);
        if (bl2) {
            boolean bl3;
            long l10 = -9223372036854775807L;
            ImmutableList immutableList = ImmutableList.of();
            do {
                xmlPullParser.next();
                String string2 = "rdf:Description";
                bl3 = XmlPullParserUtil.isStartTag(xmlPullParser, string2);
                if (bl3) {
                    bl2 = XmpMotionPhotoDescriptionParser.parseMotionPhotoFlagFromDescription(xmlPullParser);
                    if (!bl2) {
                        return null;
                    }
                    l10 = XmpMotionPhotoDescriptionParser.parseMotionPhotoPresentationTimestampUsFromDescription(xmlPullParser);
                    immutableList = XmpMotionPhotoDescriptionParser.parseMicroVideoOffsetFromDescription(xmlPullParser);
                    continue;
                }
                string2 = "Container:Directory";
                bl3 = XmlPullParserUtil.isStartTag(xmlPullParser, string2);
                if (!bl3) continue;
                immutableList = XmpMotionPhotoDescriptionParser.parseMotionPhotoV1Directory(xmlPullParser);
            } while (!(bl3 = XmlPullParserUtil.isEndTag(xmlPullParser, (String)object)));
            boolean bl4 = immutableList.isEmpty();
            if (bl4) {
                return null;
            }
            object = new MotionPhotoDescription(l10, immutableList);
            return object;
        }
        object = new ParserException("Couldn't find xmp metadata");
        throw object;
    }

    private static ImmutableList parseMicroVideoOffsetFromDescription(XmlPullParser object) {
        Object object2 = DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES;
        int n10 = ((String[])object2).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = object2[i10];
            if ((string2 = XmlPullParserUtil.getAttributeValue(object, string2)) == null) continue;
            long l10 = Long.parseLong(string2);
            object2 = object;
            object = new MotionPhotoDescription$ContainerItem("image/jpeg", "Primary", 0L, 0L);
            object2 = new MotionPhotoDescription$ContainerItem("video/mp4", "MotionPhoto", l10, 0L);
            return ImmutableList.of(object, object2);
        }
        return ImmutableList.of();
    }

    private static boolean parseMotionPhotoFlagFromDescription(XmlPullParser xmlPullParser) {
        String[] stringArray = MOTION_PHOTO_ATTRIBUTE_NAMES;
        int n10 = stringArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12;
            String string2 = stringArray[i10];
            if ((string2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, string2)) == null) continue;
            int n13 = Integer.parseInt(string2);
            if (n13 == (n12 = 1)) {
                n11 = n12;
            }
            return n11 != 0;
        }
        return false;
    }

    private static long parseMotionPhotoPresentationTimestampUsFromDescription(XmlPullParser xmlPullParser) {
        long l10;
        String[] stringArray = DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES;
        int n10 = stringArray.length;
        int n11 = 0;
        while (true) {
            l10 = -9223372036854775807L;
            if (n11 >= n10) break;
            String string2 = stringArray[n11];
            if ((string2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, string2)) != null) {
                long l11;
                long l12 = Long.parseLong(string2);
                long l13 = l12 - (l11 = (long)-1);
                Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object != false) {
                    l10 = l12;
                }
                return l10;
            }
            ++n11;
        }
        return l10;
    }

    private static ImmutableList parseMotionPhotoV1Directory(XmlPullParser xmlPullParser) {
        String string2;
        boolean bl2;
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        do {
            xmlPullParser.next();
            string2 = "Container:Item";
            bl2 = XmlPullParserUtil.isStartTag(xmlPullParser, string2);
            if (!bl2) continue;
            String string3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "Item:Mime");
            String string4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "Item:Semantic");
            string2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "Item:Length");
            Object object = XmlPullParserUtil.getAttributeValue(xmlPullParser, "Item:Padding");
            if (string3 != null && string4 != null) {
                MotionPhotoDescription$ContainerItem motionPhotoDescription$ContainerItem;
                long l10;
                long l11 = 0L;
                long l12 = string2 != null ? Long.parseLong(string2) : l11;
                long l13 = object != null ? (l10 = Long.parseLong((String)object)) : l11;
                object = motionPhotoDescription$ContainerItem;
                l11 = l12;
                l12 = l13;
                motionPhotoDescription$ContainerItem = new MotionPhotoDescription$ContainerItem(string3, string4, l11, l13);
                immutableList$Builder.add(motionPhotoDescription$ContainerItem);
                continue;
            }
            return ImmutableList.of();
        } while (!(bl2 = XmlPullParserUtil.isEndTag(xmlPullParser, string2 = "Container:Directory")));
        return immutableList$Builder.build();
    }
}

