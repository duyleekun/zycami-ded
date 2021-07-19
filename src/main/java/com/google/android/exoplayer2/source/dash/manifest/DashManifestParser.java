/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.Pair
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlPullParserFactory
 *  org.xmlpull.v1.XmlSerializer
 */
package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.ProgramInformation;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTimelineElement;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement;
import com.google.android.exoplayer2.source.dash.manifest.UrlTemplate;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class DashManifestParser
extends DefaultHandler
implements ParsingLoadable$Parser {
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN;
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN;
    private static final Pattern FRAME_RATE_PATTERN;
    private static final int[] MPEG_CHANNEL_CONFIGURATION_MAPPING;
    private static final String TAG = "MpdParser";
    private final XmlPullParserFactory xmlParserFactory;

    static {
        int[] nArray;
        FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
        CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
        CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
        int[] nArray2 = nArray = new int[21];
        int[] nArray3 = nArray;
        nArray2[0] = -1;
        nArray3[1] = 1;
        nArray2[2] = 2;
        nArray3[3] = 3;
        nArray2[4] = 4;
        nArray3[5] = 5;
        nArray2[6] = 6;
        nArray3[7] = 8;
        nArray2[8] = 2;
        nArray3[9] = 3;
        nArray2[10] = 4;
        nArray3[11] = 7;
        nArray2[12] = 8;
        nArray3[13] = 24;
        nArray2[14] = 8;
        nArray3[15] = 12;
        nArray2[16] = 10;
        nArray3[17] = 12;
        nArray2[18] = 14;
        nArray3[19] = 12;
        nArray3[20] = 14;
        MPEG_CHANNEL_CONFIGURATION_MAPPING = nArray;
    }

    public DashManifestParser() {
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

    private long addSegmentTimelineElementsToList(List list, long l10, long l11, int n10, long l12) {
        if (n10 >= 0) {
            ++n10;
        } else {
            long l13 = Util.ceilDivide(l12 -= l10, l11);
            n10 = (int)l13;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            SegmentBase$SegmentTimelineElement segmentBase$SegmentTimelineElement = this.buildSegmentTimelineElement(l10, l11);
            list.add(segmentBase$SegmentTimelineElement);
            l10 += l11;
        }
        return l10;
    }

    private static int checkContentTypeConsistency(int n10, int n11) {
        int n12 = -1;
        if (n10 == n12) {
            return n11;
        }
        if (n11 == n12) {
            return n10;
        }
        n11 = n10 == n11 ? 1 : 0;
        Assertions.checkState(n11 != 0);
        return n10;
    }

    private static String checkLanguageConsistency(String string2, String string3) {
        if (string2 == null) {
            return string3;
        }
        if (string3 == null) {
            return string2;
        }
        Assertions.checkState(string2.equals(string3));
        return string2;
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList arrayList) {
        block0: for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            int n10;
            DrmInitData$SchemeData drmInitData$SchemeData = (DrmInitData$SchemeData)arrayList.get(i10);
            int n11 = drmInitData$SchemeData.hasData();
            if (n11 != 0) continue;
            for (n11 = 0; n11 < (n10 = arrayList.size()); ++n11) {
                DrmInitData$SchemeData drmInitData$SchemeData2 = (DrmInitData$SchemeData)arrayList.get(n11);
                n10 = (int)(drmInitData$SchemeData2.canReplace(drmInitData$SchemeData) ? 1 : 0);
                if (n10 == 0) continue;
                arrayList.remove(i10);
                continue block0;
            }
        }
    }

    private static long getFinalAvailabilityTimeOffset(long l10, long l11) {
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l10 = l11;
        }
        l11 = Long.MAX_VALUE;
        long l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l14 != false) {
            l12 = l10;
        }
        return l12;
    }

    private static String getSampleMimeType(String string2, String string3) {
        boolean bl2 = MimeTypes.isAudio(string2);
        if (bl2) {
            return MimeTypes.getAudioMediaMimeType(string3);
        }
        bl2 = MimeTypes.isVideo(string2);
        if (bl2) {
            return MimeTypes.getVideoMediaMimeType(string3);
        }
        bl2 = MimeTypes.isText(string2);
        if (bl2) {
            String string4 = "application/x-rawcc";
            bl2 = string4.equals(string2);
            if (bl2) {
                string2 = MimeTypes.getTextMediaMimeType(string3);
            }
            return string2;
        }
        String string5 = "application/mp4";
        boolean bl3 = string5.equals(string2);
        if (bl3) {
            string3 = "text/vtt";
            string2 = MimeTypes.getMediaMimeType(string3);
            boolean bl4 = string3.equals(string2);
            if (bl4) {
                string2 = "application/x-mp4-vtt";
            }
            return string2;
        }
        return null;
    }

    public static void maybeSkipTag(XmlPullParser xmlPullParser) {
        int n10 = (int)(XmlPullParserUtil.isStartTag(xmlPullParser) ? 1 : 0);
        if (n10 == 0) {
            return;
        }
        n10 = 1;
        while (n10 != 0) {
            xmlPullParser.next();
            boolean bl2 = XmlPullParserUtil.isStartTag(xmlPullParser);
            if (bl2) {
                ++n10;
                continue;
            }
            bl2 = XmlPullParserUtil.isEndTag(xmlPullParser);
            if (!bl2) continue;
            n10 += -1;
        }
    }

    public static int parseCea608AccessibilityChannel(List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object = (Descriptor)list.get(i10);
            Object object2 = "urn:scte:dash:cc:cea-608:2015";
            Object object3 = ((Descriptor)object).schemeIdUri;
            boolean bl2 = ((String)object2).equals(object3);
            if (!bl2 || (object3 = ((Descriptor)object).value) == null) continue;
            object2 = CEA_608_ACCESSIBILITY_PATTERN;
            int n11 = ((Matcher)(object3 = ((Pattern)object2).matcher((CharSequence)object3))).matches();
            if (n11 != 0) {
                return Integer.parseInt(((Matcher)object3).group(1));
            }
            object3 = "Unable to parse CEA-608 channel number from: ";
            object = String.valueOf(((Descriptor)object).value);
            n11 = ((String)object).length();
            object = n11 != 0 ? ((String)object3).concat((String)object) : new String((String)object3);
            object3 = TAG;
            Log.w((String)object3, (String)object);
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object = (Descriptor)list.get(i10);
            Object object2 = "urn:scte:dash:cc:cea-708:2015";
            Object object3 = ((Descriptor)object).schemeIdUri;
            boolean bl2 = ((String)object2).equals(object3);
            if (!bl2 || (object3 = ((Descriptor)object).value) == null) continue;
            object2 = CEA_708_ACCESSIBILITY_PATTERN;
            int n11 = ((Matcher)(object3 = ((Pattern)object2).matcher((CharSequence)object3))).matches();
            if (n11 != 0) {
                return Integer.parseInt(((Matcher)object3).group(1));
            }
            object3 = "Unable to parse CEA-708 service block number from: ";
            object = String.valueOf(((Descriptor)object).value);
            n11 = ((String)object).length();
            object = n11 != 0 ? ((String)object3).concat((String)object) : new String((String)object3);
            object3 = TAG;
            Log.w((String)object3, (String)object);
        }
        return -1;
    }

    public static long parseDateTime(XmlPullParser object, String string2, long l10) {
        if ((object = object.getAttributeValue(null, string2)) == null) {
            return l10;
        }
        return Util.parseXsDateTime((String)object);
    }

    public static Descriptor parseDescriptor(XmlPullParser object, String string2) {
        boolean bl2;
        String string3 = DashManifestParser.parseString(object, "schemeIdUri", "");
        String string4 = DashManifestParser.parseString(object, "value", null);
        String string5 = "id";
        String string6 = DashManifestParser.parseString(object, string5, null);
        do {
            object.next();
        } while (!(bl2 = XmlPullParserUtil.isEndTag(object, string2)));
        object = new Descriptor(string3, string4, string6);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int parseDolbyChannelConfiguration(XmlPullParser object) {
        int n10;
        int n11;
        int n12;
        int n13;
        block13: {
            block14: {
                String string2 = "value";
                object = Util.toLowerInvariant(object.getAttributeValue(null, string2));
                n13 = -1;
                if (object == null) {
                    return n13;
                }
                ((String)object).hashCode();
                int n14 = ((String)object).hashCode();
                n12 = 2;
                n11 = 1;
                switch (n14) {
                    case 0x2FCFFC: {
                        string2 = "fa01";
                        n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 3;
                        break block13;
                    }
                    case 3094035: {
                        string2 = "f801";
                        n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n12;
                        break block13;
                    }
                    case 2937391: {
                        string2 = "a000";
                        n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n11;
                        break block13;
                    }
                    case 1596796: {
                        string2 = "4000";
                        n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                        if (n10 != 0) break block14;
                    }
                }
                n10 = n13;
                break block13;
            }
            n10 = 0;
            object = null;
        }
        switch (n10) {
            default: {
                return n13;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 6;
            }
            case 1: {
                return n12;
            }
            case 0: 
        }
        return n11;
    }

    public static long parseDuration(XmlPullParser object, String string2, long l10) {
        if ((object = object.getAttributeValue(null, string2)) == null) {
            return l10;
        }
        return Util.parseXsDuration((String)object);
    }

    public static String parseEac3SupplementalProperties(List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            boolean bl2;
            String string2;
            Object object = (Descriptor)list.get(i10);
            String string3 = "tag:dolby.com,2018:dash:EC3_ExtensionType:2018";
            String string4 = ((Descriptor)object).schemeIdUri;
            boolean bl3 = string3.equals(string4);
            if ((!bl3 || !(bl3 = (string2 = "JOC").equals(string3 = ((Descriptor)object).value))) && (!(bl2 = (string3 = "tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014").equals(string4)) || (n10 = (int)((string4 = "ec+3").equals(object = ((Descriptor)object).value) ? 1 : 0)) == 0)) continue;
            return "audio/eac3-joc";
        }
        return "audio/eac3";
    }

    public static float parseFloat(XmlPullParser object, String string2, float f10) {
        if ((object = object.getAttributeValue(null, string2)) != null) {
            f10 = Float.parseFloat((String)object);
        }
        return f10;
    }

    public static float parseFrameRate(XmlPullParser object, float f10) {
        boolean bl2 = false;
        Pattern pattern = null;
        String string2 = "frameRate";
        if ((object = object.getAttributeValue(null, string2)) != null && (bl2 = ((Matcher)(object = (pattern = FRAME_RATE_PATTERN).matcher((CharSequence)object))).matches())) {
            f10 = Float.MIN_VALUE;
            String string3 = ((Matcher)object).group(1);
            int n10 = Integer.parseInt(string3);
            bl2 = TextUtils.isEmpty((CharSequence)(object = ((Matcher)object).group(2)));
            if (!bl2) {
                f10 = n10;
                int n11 = Integer.parseInt((String)object);
                float f11 = n11;
                f10 /= f11;
            } else {
                f10 = n10;
            }
        }
        return f10;
    }

    public static int parseInt(XmlPullParser object, String string2, int n10) {
        if ((object = object.getAttributeValue(null, string2)) != null) {
            n10 = Integer.parseInt((String)object);
        }
        return n10;
    }

    public static long parseLastSegmentNumberSupplementalProperty(List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Descriptor descriptor = (Descriptor)list.get(i10);
            String string2 = "http://dashif.org/guidelines/last-segment-number";
            String string3 = descriptor.schemeIdUri;
            boolean bl2 = string2.equalsIgnoreCase(string3);
            if (!bl2) continue;
            return Long.parseLong(descriptor.value);
        }
        return -1;
    }

    public static long parseLong(XmlPullParser object, String string2, long l10) {
        if ((object = object.getAttributeValue(null, string2)) != null) {
            l10 = Long.parseLong((String)object);
        }
        return l10;
    }

    public static int parseMpegChannelConfiguration(XmlPullParser xmlPullParser) {
        int n10;
        Object object = "value";
        Object object2 = -1;
        int n11 = DashManifestParser.parseInt(xmlPullParser, (String)object, object2);
        if (n11 >= 0 && n11 < (n10 = ((Object)(object = (Object)MPEG_CHANNEL_CONFIGURATION_MAPPING)).length)) {
            object2 = object[n11];
        }
        return object2;
    }

    public static String parseString(XmlPullParser object, String string2, String string3) {
        if ((object = object.getAttributeValue(null, string2)) != null) {
            string3 = object;
        }
        return string3;
    }

    public static String parseText(XmlPullParser xmlPullParser, String string2) {
        int n10;
        String string3 = "";
        do {
            xmlPullParser.next();
            n10 = xmlPullParser.getEventType();
            int n11 = 4;
            if (n10 == n11) {
                string3 = xmlPullParser.getText();
                continue;
            }
            DashManifestParser.maybeSkipTag(xmlPullParser);
        } while ((n10 = (int)(XmlPullParserUtil.isEndTag(xmlPullParser, string2) ? 1 : 0)) == 0);
        return string3;
    }

    public AdaptationSet buildAdaptationSet(int n10, int n11, List list, List list2, List list3, List list4) {
        AdaptationSet adaptationSet = new AdaptationSet(n10, n11, list, list2, list3, list4);
        return adaptationSet;
    }

    public EventMessage buildEvent(String string2, String string3, long l10, long l11, byte[] byArray) {
        EventMessage eventMessage = new EventMessage(string2, string3, l11, l10, byArray);
        return eventMessage;
    }

    public EventStream buildEventStream(String string2, String string3, long l10, long[] lArray, EventMessage[] eventMessageArray) {
        EventStream eventStream = new EventStream(string2, string3, l10, lArray, eventMessageArray);
        return eventStream;
    }

    public Format buildFormat(String string2, String string3, int n10, int n11, float f10, int n12, int n13, int n14, String string4, List list, List list2, String string5, List list3, List list4) {
        Object object = string3;
        Object object2 = list;
        String string6 = string5;
        String string7 = "audio/eac3";
        String string8 = DashManifestParser.getSampleMimeType(string3, string5);
        int n15 = string7.equals(string8);
        if (n15 != 0) {
            string8 = DashManifestParser.parseEac3SupplementalProperties(list4);
        }
        n15 = this.parseSelectionFlagsFromRoleDescriptors((List)object2);
        int n16 = this.parseRoleFlagsFromRoleDescriptors((List)object2);
        int n17 = this.parseRoleFlagsFromAccessibilityDescriptors(list2);
        n16 |= n17;
        Object object3 = list3;
        n17 = this.parseRoleFlagsFromProperties(list3);
        n16 |= n17;
        object3 = list4;
        n17 = this.parseRoleFlagsFromProperties(list4);
        object3 = new Format$Builder();
        object3 = ((Format$Builder)object3).setId(string2);
        object = ((Format$Builder)object3).setContainerMimeType(string3).setSampleMimeType(string8).setCodecs(string6);
        int n18 = n14;
        object = ((Format$Builder)object).setPeakBitrate(n14).setSelectionFlags(n15).setRoleFlags(n16 |= n17);
        object2 = string4;
        object = ((Format$Builder)object).setLanguage(string4);
        n16 = (int)(MimeTypes.isVideo(string8) ? 1 : 0);
        if (n16 != 0) {
            n16 = n10;
            object2 = ((Format$Builder)object).setWidth(n10);
            n18 = n11;
            object2 = ((Format$Builder)object2).setHeight(n11);
            ((Format$Builder)object2).setFrameRate(f10);
        } else {
            n16 = (int)(MimeTypes.isAudio(string8) ? 1 : 0);
            if (n16 != 0) {
                n16 = n12;
                object2 = ((Format$Builder)object).setChannelCount(n12);
                n18 = n13;
                ((Format$Builder)object2).setSampleRate(n13);
            } else {
                n16 = (int)(MimeTypes.isText(string8) ? 1 : 0);
                if (n16 != 0) {
                    n16 = -1;
                    string6 = "application/cea-608";
                    n18 = (int)(string6.equals(string8) ? 1 : 0);
                    if (n18 != 0) {
                        n16 = DashManifestParser.parseCea608AccessibilityChannel(list2);
                    } else {
                        string6 = "application/cea-708";
                        n18 = (int)(string6.equals(string8) ? 1 : 0);
                        if (n18 != 0) {
                            n16 = DashManifestParser.parseCea708AccessibilityChannel(list2);
                        }
                    }
                    ((Format$Builder)object).setAccessibilityChannel(n16);
                }
            }
        }
        return ((Format$Builder)object).build();
    }

    public DashManifest buildMediaPresentationDescription(long l10, long l11, long l12, boolean bl2, long l13, long l14, long l15, long l16, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List list) {
        DashManifest dashManifest = new DashManifest(l10, l11, l12, bl2, l13, l14, l15, l16, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
        return dashManifest;
    }

    public Period buildPeriod(String string2, long l10, List list, List list2, Descriptor descriptor) {
        Period period = new Period(string2, l10, list, list2, descriptor);
        return period;
    }

    public RangedUri buildRangedUri(String string2, long l10, long l11) {
        RangedUri rangedUri = new RangedUri(string2, l10, l11);
        return rangedUri;
    }

    public Representation buildRepresentation(DashManifestParser$RepresentationInfo dashManifestParser$RepresentationInfo, String object, String string2, ArrayList object2, ArrayList arrayList) {
        Format$Builder format$Builder = dashManifestParser$RepresentationInfo.format.buildUpon();
        if (object != null) {
            format$Builder.setLabel((String)object);
        }
        if ((object = dashManifestParser$RepresentationInfo.drmSchemeType) != null) {
            string2 = object;
        }
        object = dashManifestParser$RepresentationInfo.drmSchemeDatas;
        ((ArrayList)object).addAll(object2);
        boolean bl2 = ((ArrayList)object).isEmpty();
        if (!bl2) {
            DashManifestParser.filterRedundantIncompleteSchemeDatas((ArrayList)object);
            object2 = new DrmInitData(string2, (List)object);
            format$Builder.setDrmInitData((DrmInitData)object2);
        }
        ArrayList arrayList2 = dashManifestParser$RepresentationInfo.inbandEventStreams;
        arrayList2.addAll(arrayList);
        long l10 = dashManifestParser$RepresentationInfo.revisionId;
        Format format = format$Builder.build();
        String string3 = dashManifestParser$RepresentationInfo.baseUrl;
        SegmentBase segmentBase = dashManifestParser$RepresentationInfo.segmentBase;
        return Representation.newInstance(l10, format, string3, segmentBase, arrayList2);
    }

    public SegmentBase$SegmentList buildSegmentList(RangedUri rangedUri, long l10, long l11, long l12, long l13, List list, long l14, List list2, long l15, long l16) {
        long l17 = C.msToUs(l15);
        long l18 = C.msToUs(l16);
        SegmentBase$SegmentList segmentBase$SegmentList = new SegmentBase$SegmentList(rangedUri, l10, l11, l12, l13, list, l14, list2, l17, l18);
        return segmentBase$SegmentList;
    }

    public SegmentBase$SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long l10, long l11, long l12, long l13, long l14, List list, long l15, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long l16, long l17) {
        long l18 = C.msToUs(l16);
        long l19 = C.msToUs(l17);
        SegmentBase$SegmentTemplate segmentBase$SegmentTemplate = new SegmentBase$SegmentTemplate(rangedUri, l10, l11, l12, l13, l14, list, l15, urlTemplate, urlTemplate2, l18, l19);
        return segmentBase$SegmentTemplate;
    }

    public SegmentBase$SegmentTimelineElement buildSegmentTimelineElement(long l10, long l11) {
        SegmentBase$SegmentTimelineElement segmentBase$SegmentTimelineElement = new SegmentBase$SegmentTimelineElement(l10, l11);
        return segmentBase$SegmentTimelineElement;
    }

    public SegmentBase$SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long l10, long l11, long l12, long l13) {
        SegmentBase$SingleSegmentBase segmentBase$SingleSegmentBase = new SegmentBase$SingleSegmentBase(rangedUri, l10, l11, l12, l13);
        return segmentBase$SingleSegmentBase;
    }

    public UtcTimingElement buildUtcTimingElement(String string2, String string3) {
        UtcTimingElement utcTimingElement = new UtcTimingElement(string2, string3);
        return utcTimingElement;
    }

    public DashManifest parse(Uri object, InputStream object2) {
        block9: {
            XmlPullParserFactory xmlPullParserFactory;
            try {
                xmlPullParserFactory = this.xmlParserFactory;
            }
            catch (XmlPullParserException xmlPullParserException) {
                object2 = new ParserException(xmlPullParserException);
                throw object2;
            }
            xmlPullParserFactory = xmlPullParserFactory.newPullParser();
            int n10 = 0;
            String string2 = null;
            xmlPullParserFactory.setInput((InputStream)object2, null);
            int n11 = xmlPullParserFactory.next();
            n10 = 2;
            if (n11 != n10) break block9;
            object2 = "MPD";
            string2 = xmlPullParserFactory.getName();
            n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
            if (n11 == 0) break block9;
            object = object.toString();
            return this.parseMediaPresentationDescription((XmlPullParser)xmlPullParserFactory, (String)object);
        }
        object2 = "inputStream does not contain a valid media presentation description";
        object = new ParserException((String)object2);
        throw object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public AdaptationSet parseAdaptationSet(XmlPullParser var1_1, String var2_2, SegmentBase var3_3, long var4_4, long var6_5, long var8_6, long var10_7, long var12_8) {
        var14_9 = this;
        var15_10 /* !! */  = var1_1 /* !! */ ;
        var16_11 = "id";
        var17_12 = -1;
        var18_13 = DashManifestParser.parseInt(var1_1 /* !! */ , (String)var16_11, var17_12);
        var19_14 = this.parseContentType(var1_1 /* !! */ );
        var20_15 = false;
        var21_16 = null;
        var22_17 = var1_1 /* !! */ .getAttributeValue(null, "mimeType");
        var23_18 = var1_1 /* !! */ .getAttributeValue(null, "codecs");
        var24_19 = DashManifestParser.parseInt(var1_1 /* !! */ , "width", var17_12);
        var25_20 = DashManifestParser.parseInt(var1_1 /* !! */ , "height", var17_12);
        var26_21 = -1082130432;
        var27_22 = -1.0f;
        var28_23 = DashManifestParser.parseFrameRate(var1_1 /* !! */ , var27_22);
        var29_24 = DashManifestParser.parseInt(var1_1 /* !! */ , "audioSamplingRate", var17_12);
        var30_25 = "lang";
        var31_26 = var1_1 /* !! */ .getAttributeValue(null, (String)var30_25);
        var32_27 = var1_1 /* !! */ .getAttributeValue(null, "label");
        var33_28 = new ArrayList();
        var34_29 = new ArrayList();
        var35_30 = new ArrayList<Object>();
        var36_31 = new ArrayList<ArrayList<E>>();
        var37_32 = new ArrayList<Object>();
        var38_33 = new ArrayList<Object>();
        var39_34 = new ArrayList<Object>();
        var40_35 = var2_2;
        var41_36 = var3_3;
        var42_37 = var19_14;
        var43_38 = var17_12;
        var44_39 = var31_26;
        var45_40 = var32_27;
        var46_41 = null;
        var47_42 = false;
        var48_43 = var6_5;
        var50_44 = var8_6;
        while (true) {
            block23: {
                block29: {
                    block28: {
                        block27: {
                            block26: {
                                block25: {
                                    block24: {
                                        var1_1 /* !! */ .next();
                                        var21_16 = "BaseURL";
                                        var20_15 = XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var21_16);
                                        if (!var20_15) break block24;
                                        if (!var47_42) {
                                            var48_43 = var14_9.parseAvailabilityTimeOffsetUs(var15_10 /* !! */ , var48_43);
                                            var40_35 = var14_9.parseBaseUrl(var15_10 /* !! */ , (String)var40_35);
                                            var47_42 = true;
lbl47:
                                            // 2 sources

                                            while (true) {
                                                var52_45 = var48_43;
                                                var14_9 = var39_34;
                                                var54_46 = var38_33;
                                                var55_47 = var37_32;
                                                var56_48 = var36_31;
                                                var57_49 = var35_30;
                                                var32_27 = var34_29;
                                                var58_50 = var33_28;
                                                var59_51 = var30_25;
                                                break block23;
                                                break;
                                            }
                                        }
                                        var52_45 = var48_43;
                                        var14_9 = var39_34;
                                        var54_46 = var38_33;
                                        var55_47 = var37_32;
                                        var56_48 = var36_31;
                                        var57_49 = var35_30;
                                        var32_27 = var34_29;
                                        var58_50 = var33_28;
                                        var59_51 = var30_25;
                                        var60_52 = var42_37;
                                        var61_53 = var44_39;
                                        var44_39 = var40_35;
                                        ** GOTO lbl290
                                    }
                                    var21_16 = "ContentProtection";
                                    var20_15 = XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var21_16);
                                    if (var20_15) {
                                        var21_16 = this.parseContentProtection(var1_1 /* !! */ );
                                        var62_54 = var50_44;
                                        var16_11 = var21_16.first;
                                        if (var16_11 != null) {
                                            var46_41 = var16_11;
                                            var46_41 = (String)var16_11;
                                        }
                                        if ((var16_11 = var21_16.second) != null) {
                                            var16_11 = (DrmInitData$SchemeData)var16_11;
                                            var33_28.add(var16_11);
                                        }
                                        var50_44 = var62_54;
                                        ** continue;
                                    }
                                    var62_54 = var50_44;
                                    var16_11 = "ContentComponent";
                                    var19_14 = (int)XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var16_11);
                                    if (var19_14 == 0) break block25;
                                    var20_15 = false;
                                    var21_16 = null;
                                    var16_11 = var15_10 /* !! */ .getAttributeValue(null, (String)var30_25);
                                    var64_55 = var44_39;
                                    var16_11 = DashManifestParser.checkLanguageConsistency((String)var44_39, (String)var16_11);
                                    var17_12 = this.parseContentType(var1_1 /* !! */ );
                                    var65_56 = var42_37;
                                    var17_12 = DashManifestParser.checkContentTypeConsistency(var42_37, var17_12);
                                    var44_39 = var16_11;
                                    var42_37 = var17_12;
                                    var52_45 = var48_43;
                                    var14_9 = var39_34;
                                    var54_46 = var38_33;
                                    var55_47 = var37_32;
                                    var56_48 = var36_31;
                                    var57_49 = var35_30;
                                    var32_27 = var34_29;
                                    var58_50 = var33_28;
                                    var59_51 = var30_25;
                                    break block23;
                                }
                                var65_56 = var42_37;
                                var64_55 = var44_39;
                                var20_15 = false;
                                var21_16 = null;
                                var16_11 = "Role";
                                var66_57 = XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var16_11);
                                if (!var66_57) break block26;
                                var16_11 = DashManifestParser.parseDescriptor(var15_10 /* !! */ , (String)var16_11);
                                var36_31.add(var16_11);
lbl122:
                                // 4 sources

                                while (true) {
                                    var61_53 = var64_55;
                                    var52_45 = var48_43;
                                    var44_39 = var40_35;
                                    var54_46 = var38_33;
                                    var55_47 = var37_32;
                                    var56_48 = var36_31;
                                    var57_49 = var35_30;
                                    var32_27 = var34_29;
                                    var58_50 = var33_28;
                                    var59_51 = var30_25;
                                    var60_52 = var65_56;
                                    var50_44 = var62_54;
                                    var14_9 = var39_34;
                                    ** GOTO lbl290
                                    break;
                                }
                            }
                            var16_11 = "AudioChannelConfiguration";
                            var19_14 = (int)XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var16_11);
                            if (var19_14 == 0) break block27;
                            var43_38 = var19_14 = this.parseAudioChannelConfiguration(var1_1 /* !! */ );
                            var52_45 = var48_43;
                            var54_46 = var38_33;
                            var55_47 = var37_32;
                            var56_48 = var36_31;
                            var57_49 = var35_30;
                            var32_27 = var34_29;
                            var58_50 = var33_28;
                            var59_51 = var30_25;
                            var14_9 = var39_34;
                            break block23;
                        }
                        var16_11 = "Accessibility";
                        var66_57 = XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var16_11);
                        if (!var66_57) break block28;
                        var16_11 = DashManifestParser.parseDescriptor(var15_10 /* !! */ , var16_11);
                        var35_30.add(var16_11);
                        ** GOTO lbl122
                    }
                    var16_11 = "EssentialProperty";
                    var66_57 = XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var16_11);
                    if (!var66_57) break block29;
                    var16_11 = DashManifestParser.parseDescriptor(var15_10 /* !! */ , (String)var16_11);
                    var37_32.add(var16_11);
                    ** GOTO lbl122
                }
                var16_11 = "SupplementalProperty";
                var66_57 = XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var16_11);
                if (var66_57) {
                    var16_11 = DashManifestParser.parseDescriptor(var15_10 /* !! */ , (String)var16_11);
                    var38_33.add(var16_11);
                    ** continue;
                }
                var16_11 = "Representation";
                var19_14 = (int)XmlPullParserUtil.isStartTag(var15_10 /* !! */ , (String)var16_11);
                if (var19_14 != 0) {
                    var6_5 = var50_44;
                    var16_11 = this;
                    var61_53 = var44_39;
                    var64_55 = var1_1 /* !! */ ;
                    var52_45 = var48_43;
                    var31_26 = var40_35;
                    var32_27 = var22_17;
                    var44_39 = var40_35;
                    var40_35 = var23_18;
                    var54_46 = var38_33;
                    var55_47 = var37_32;
                    var56_48 = var36_31;
                    var57_49 = var35_30;
                    var67_58 = var34_29;
                    var34_29 = var61_53;
                    var58_50 = var33_28;
                    var33_28 = var36_31;
                    var59_51 = var30_25;
                    var30_25 = var35_30;
                    var21_16 = var37_32;
                    var15_10 /* !! */  = var38_33;
                    var60_52 = var42_37;
                    var14_9 = var41_36;
                    var68_59 = var10_7;
                    var16_11 = this.parseRepresentation(var1_1 /* !! */ , (String)var31_26, var22_17, var23_18, var24_19, var25_20, var28_23, var43_38, var29_24, (String)var61_53, var36_31, var35_30, var37_32, var38_33, (SegmentBase)var41_36, var10_7, var4_4, var48_43, var50_44, var12_8);
                    var64_55 = var16_11.format.sampleMimeType;
                    var17_12 = MimeTypes.getTrackType(var64_55);
                    var17_12 = DashManifestParser.checkContentTypeConsistency(var42_37, var17_12);
                    var14_9 = var39_34;
                    var39_34.add(var16_11);
                    var15_10 /* !! */  = var1_1 /* !! */ ;
                    var40_35 = var31_26;
                    var32_27 = var67_58;
                    var44_39 = var61_53;
                    var42_37 = var17_12;
                } else {
                    var6_5 = var50_44;
                    var61_53 = var44_39;
                    var52_45 = var48_43;
                    var44_39 = var40_35;
                    var54_46 = var38_33;
                    var55_47 = var37_32;
                    var56_48 = var36_31;
                    var57_49 = var35_30;
                    var67_58 = var34_29;
                    var58_50 = var33_28;
                    var59_51 = var30_25;
                    var14_9 = var39_34;
                    var16_11 = "SegmentBase";
                    var21_16 = var1_1 /* !! */ ;
                    var19_14 = (int)XmlPullParserUtil.isStartTag(var1_1 /* !! */ , (String)var16_11);
                    if (var19_14 != 0) {
                        var16_11 = var41_36;
                        var16_11 = (SegmentBase$SingleSegmentBase)var41_36;
                        var33_28 = this;
                        var41_36 = var16_11 = this.parseSegmentBase(var1_1 /* !! */ , (SegmentBase$SingleSegmentBase)var16_11);
                        var32_27 = var34_29;
                        var44_39 = var64_55;
                        var15_10 /* !! */  = var1_1 /* !! */ ;
                    } else {
                        var33_28 = this;
                        var16_11 = "SegmentList";
                        var19_14 = (int)XmlPullParserUtil.isStartTag(var1_1 /* !! */ , (String)var16_11);
                        if (var19_14 != 0) {
                            var68_59 = this.parseAvailabilityTimeOffsetUs(var1_1 /* !! */ , var50_44);
                            var31_26 = var41_36;
                            var31_26 = (SegmentBase$SegmentList)var41_36;
                            var16_11 = this;
                            var64_55 = var1_1 /* !! */ ;
                            var60_52 = var42_37;
                            var15_10 /* !! */  = this;
                            var41_36 = var16_11 = this.parseSegmentList(var1_1 /* !! */ , (SegmentBase$SegmentList)var31_26, var10_7, var4_4, var48_43, var68_59, var12_8);
                            var15_10 /* !! */  = var1_1 /* !! */ ;
lbl253:
                            // 2 sources

                            while (true) {
                                var50_44 = var68_59;
                                var40_35 = var44_39;
                                var32_27 = var67_58;
                                break;
                            }
                        } else {
                            var60_52 = var42_37;
                            var15_10 /* !! */  = this;
                            var31_26 = "SegmentTemplate";
                            var26_21 = (int)XmlPullParserUtil.isStartTag(var1_1 /* !! */ , (String)var31_26);
                            if (var26_21 != 0) {
                                var68_59 = this.parseAvailabilityTimeOffsetUs(var1_1 /* !! */ , var50_44);
                                var31_26 = var41_36;
                                var31_26 = (SegmentBase$SegmentTemplate)var41_36;
                                var16_11 = this;
                                var64_55 = var1_1 /* !! */ ;
                                var32_27 = var38_33;
                                var15_10 /* !! */  = var1_1 /* !! */ ;
                                var41_36 = var16_11 = this.parseSegmentTemplate(var1_1 /* !! */ , (SegmentBase$SegmentTemplate)var31_26, var38_33, var10_7, var4_4, var48_43, var68_59, var12_8);
                                ** continue;
                            }
                            var15_10 /* !! */  = var1_1 /* !! */ ;
                            var31_26 = "InbandEventStream";
                            var70_60 = XmlPullParserUtil.isStartTag(var1_1 /* !! */ , (String)var31_26);
                            if (var70_60) {
                                var31_26 = DashManifestParser.parseDescriptor(var1_1 /* !! */ , (String)var31_26);
                                var32_27 = var34_29;
                                var34_29.add(var31_26);
                            } else {
                                var32_27 = var34_29;
                                var31_26 = "Label";
                                var26_21 = (int)XmlPullParserUtil.isStartTag(var1_1 /* !! */ , (String)var31_26);
                                if (var26_21 != 0) {
                                    var45_40 = var31_26 = this.parseLabel(var1_1 /* !! */ );
                                } else {
                                    var26_21 = (int)XmlPullParserUtil.isStartTag(var1_1 /* !! */ );
                                    if (var26_21 != 0) {
                                        this.parseAdaptationSetChild(var1_1 /* !! */ );
                                    }
                                }
                            }
lbl290:
                            // 7 sources

                            var40_35 = var44_39;
                        }
                        var44_39 = var61_53;
                        var42_37 = var60_52;
                    }
                }
            }
            var31_26 = "AdaptationSet";
            var26_21 = (int)XmlPullParserUtil.isEndTag(var15_10 /* !! */ , (String)var31_26);
            if (var26_21 != 0) {
                var17_12 = var14_9.size();
                var16_11 = new ArrayList(var17_12);
                var64_55 = null;
                for (var17_12 = 0; var17_12 < (var26_21 = var14_9.size()); ++var17_12) {
                    var31_26 = (DashManifestParser$RepresentationInfo)var14_9.get(var17_12);
                    var1_1 /* !! */  = this;
                    var2_2 = var31_26;
                    var3_3 = var45_40;
                    var31_26 = this.buildRepresentation((DashManifestParser$RepresentationInfo)var31_26, (String)var45_40, (String)var46_41, var58_50, var32_27);
                    var16_11.add(var31_26);
                }
                var1_1 /* !! */  = this;
                return this.buildAdaptationSet(var18_13, var42_37, (List)var16_11, var57_49, var55_47, var54_46);
            }
            var34_29 = var32_27;
            var39_34 = var14_9;
            var48_43 = var52_45;
            var38_33 = var54_46;
            var37_32 = var55_47;
            var36_31 = var56_48;
            var35_30 = var57_49;
            var33_28 = var58_50;
            var30_25 = var59_51;
            var20_15 = false;
            var21_16 = null;
            var14_9 = this;
        }
    }

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) {
        DashManifestParser.maybeSkipTag(xmlPullParser);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) {
        int n10;
        int n11;
        String string2;
        block12: {
            block13: {
                String string3 = null;
                string2 = DashManifestParser.parseString(xmlPullParser, "schemeIdUri", null);
                string2.hashCode();
                int n12 = string2.hashCode();
                n11 = -1;
                switch (n12) {
                    case 2036691300: {
                        string3 = "urn:dolby:dash:audio_channel_configuration:2011";
                        n10 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 3;
                        break block12;
                    }
                    case -986633423: {
                        string3 = "urn:mpeg:mpegB:cicp:ChannelConfiguration";
                        n10 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 2;
                        break block12;
                    }
                    case -1138141449: {
                        string3 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011";
                        n10 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 1;
                        break block12;
                    }
                    case -1352850286: {
                        string3 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011";
                        n10 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n10 != 0) break block13;
                    }
                }
                n10 = n11;
                break block12;
            }
            n10 = 0;
            string2 = null;
        }
        switch (n10) {
            default: {
                break;
            }
            case 2: {
                n11 = DashManifestParser.parseMpegChannelConfiguration(xmlPullParser);
                break;
            }
            case 1: 
            case 3: {
                n11 = DashManifestParser.parseDolbyChannelConfiguration(xmlPullParser);
                break;
            }
            case 0: {
                string2 = "value";
                n11 = DashManifestParser.parseInt(xmlPullParser, string2, n11);
            }
        }
        do {
            xmlPullParser.next();
        } while ((n10 = (int)(XmlPullParserUtil.isEndTag(xmlPullParser, string2 = "AudioChannelConfiguration") ? 1 : 0)) == 0);
        return n11;
    }

    public long parseAvailabilityTimeOffsetUs(XmlPullParser object, long l10) {
        String string2 = "availabilityTimeOffset";
        if ((object = object.getAttributeValue(null, string2)) == null) {
            return l10;
        }
        String string3 = "INF";
        boolean bl2 = string3.equals(object);
        if (bl2) {
            return Long.MAX_VALUE;
        }
        return (long)(Float.parseFloat((String)object) * 1000000.0f);
    }

    public String parseBaseUrl(XmlPullParser object, String string2) {
        object = DashManifestParser.parseText(object, "BaseURL");
        return UriUtil.resolve(string2, (String)object);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Pair parseContentProtection(XmlPullParser var1_1) {
        block18: {
            block20: {
                block19: {
                    block17: {
                        var2_2 = null;
                        var3_3 = var1_1 /* !! */ .getAttributeValue(null, "schemeIdUri");
                        if (var3_3 == null) break block17;
                        var3_3 = Util.toLowerInvariant(var3_3);
                        var3_3.hashCode();
                        var4_4 = -1;
                        var5_5 = var3_3.hashCode();
                        switch (var5_5) {
                            default: {
                                break;
                            }
                            case 1812765994: {
                                var6_6 /* !! */  = "urn:mpeg:dash:mp4protection:2011";
                                var7_7 = var3_3.equals(var6_6 /* !! */ );
                                if (!var7_7) break;
                                var4_4 = 2;
                                break;
                            }
                            case 755418770: {
                                var6_6 /* !! */  = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
                                var7_7 = var3_3.equals(var6_6 /* !! */ );
                                if (!var7_7) break;
                                var4_4 = 1;
                                break;
                            }
                            case 489446379: {
                                var6_6 /* !! */  = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95";
                                var7_7 = var3_3.equals(var6_6 /* !! */ );
                                if (!var7_7) break;
                                var4_4 = 0;
                                var8_8 /* !! */  = null;
                            }
                        }
                        switch (var4_4) {
                            default: {
                                break block17;
                            }
                            case 2: {
                                var3_3 = var1_1 /* !! */ .getAttributeValue(null, "value");
                                var8_8 /* !! */  = XmlPullParserUtil.getAttributeValueIgnorePrefix(var1_1 /* !! */ , "default_KID");
                                var5_5 = (int)TextUtils.isEmpty((CharSequence)var8_8 /* !! */ );
                                if (var5_5 != 0 || (var5_5 = (int)(var6_6 /* !! */  = "00000000-0000-0000-0000-000000000000").equals(var8_8 /* !! */ )) != 0) ** GOTO lbl50
                                var8_8 /* !! */  = var8_8 /* !! */ .split("\\s+");
                                var5_5 = var8_8 /* !! */ .length;
                                var6_6 /* !! */  = new UUID[var5_5];
                                var10_10 = null;
                                for (var9_9 = 0; var9_9 < (var11_11 = var8_8 /* !! */ .length); ++var9_9) {
                                    var6_6 /* !! */ [var9_9] = var12_12 = UUID.fromString(var8_8 /* !! */ [var9_9]);
                                }
                                var8_8 /* !! */  = C.COMMON_PSSH_UUID;
                                var6_6 /* !! */  = (UUID[])PsshAtomUtil.buildPsshAtom((UUID)var8_8 /* !! */ , var6_6 /* !! */ , null);
                                var9_9 = 0;
                                var10_10 = null;
                                break block18;
lbl50:
                                // 1 sources

                                var4_4 = 0;
                                var8_8 /* !! */  = null;
                                break block19;
                            }
                            case 1: {
                                var8_8 /* !! */  = C.WIDEVINE_UUID;
                                break;
                            }
                            case 0: {
                                var8_8 /* !! */  = C.PLAYREADY_UUID;
                            }
                        }
                        var7_7 = false;
                        var3_3 = null;
                        var5_5 = 0;
                        var6_6 /* !! */  = null;
                        break block20;
                    }
                    var7_7 = false;
                    var3_3 = null;
                    var4_4 = 0;
                    var8_8 /* !! */  = null;
                }
                var5_5 = 0;
                var6_6 /* !! */  = null;
            }
            var9_9 = 0;
            var10_10 = null;
        }
        do {
            var1_1 /* !! */ .next();
            var12_12 = "ms:laurl";
            var11_11 = XmlPullParserUtil.isStartTag(var1_1 /* !! */ , (String)var12_12);
            if (var11_11 != 0) {
                var10_10 = var1_1 /* !! */ .getAttributeValue(null, "licenseUrl");
                continue;
            }
            var11_11 = 4;
            if (var6_6 /* !! */  == null && (var14_14 = XmlPullParserUtil.isStartTagIgnorePrefix(var1_1 /* !! */ , (String)(var13_13 = "pssh"))) != 0 && (var14_14 = var1_1 /* !! */ .next()) == var11_11) {
                var8_8 /* !! */  = (String[])Base64.decode((String)var1_1 /* !! */ .getText(), (int)0);
                var6_6 /* !! */  = PsshAtomUtil.parseUuid((byte[])var8_8 /* !! */ );
                if (var6_6 /* !! */  == null) {
                    var12_12 = "Skipping malformed cenc:pssh data";
                    Log.w("MpdParser", (String)var12_12);
                    var8_8 /* !! */  = var6_6 /* !! */ ;
                    var5_5 = 0;
                    var6_6 /* !! */  = null;
                    continue;
                }
                var15_15 /* !! */  = var6_6 /* !! */ ;
                var6_6 /* !! */  = var8_8 /* !! */ ;
                var8_8 /* !! */  = var15_15 /* !! */ ;
                continue;
            }
            if (var6_6 /* !! */  == null && (var16_16 = (var13_13 = C.PLAYREADY_UUID).equals(var8_8 /* !! */ )) != 0 && (var16_16 = XmlPullParserUtil.isStartTag(var1_1 /* !! */ , var17_17 = "mspr:pro")) != 0 && (var16_16 = var1_1 /* !! */ .next()) == var11_11) {
                var6_6 /* !! */  = (UUID[])Base64.decode((String)var1_1 /* !! */ .getText(), (int)0);
                var6_6 /* !! */  = (UUID[])PsshAtomUtil.buildPsshAtom((UUID)var13_13, (byte[])var6_6 /* !! */ );
                continue;
            }
            DashManifestParser.maybeSkipTag(var1_1 /* !! */ );
        } while ((var11_11 = (int)XmlPullParserUtil.isEndTag(var1_1 /* !! */ , (String)(var12_12 = "ContentProtection"))) == 0);
        if (var8_8 /* !! */  != null) {
            var1_1 /* !! */  = "video/mp4";
            var2_2 = new DrmInitData$SchemeData((UUID)var8_8 /* !! */ , var10_10, (String)var1_1 /* !! */ , (byte[])var6_6 /* !! */ );
        }
        return Pair.create((Object)var3_3, (Object)var2_2);
    }

    public int parseContentType(XmlPullParser object) {
        String string2 = null;
        String string3 = "contentType";
        object = object.getAttributeValue(null, string3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        int n10 = -1;
        if (!bl2) {
            string2 = "audio";
            bl2 = string2.equals(object);
            if (bl2) {
                n10 = 1;
            } else {
                string2 = "video";
                bl2 = string2.equals(object);
                if (bl2) {
                    n10 = 2;
                } else {
                    string2 = "text";
                    boolean bl3 = string2.equals(object);
                    if (bl3) {
                        n10 = 3;
                    }
                }
            }
        }
        return n10;
    }

    public int parseDashRoleSchemeValue(String string2) {
        if (string2 == null) {
            return 0;
        }
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 8;
        int n13 = 4;
        int n14 = 2;
        int n15 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 1855372047: {
                String string3 = "supplementary";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n10 = 10;
                break;
            }
            case 1629013393: {
                String string4 = "emergency";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n10 = 9;
                break;
            }
            case 899152809: {
                String string5 = "commentary";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n10 = n12;
                break;
            }
            case 552573414: {
                String string6 = "caption";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n10 = 7;
                break;
            }
            case 3530173: {
                String string7 = "sign";
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n10 = 6;
                break;
            }
            case 3343801: {
                String string8 = "main";
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n10 = 5;
                break;
            }
            case 99825: {
                String string9 = "dub";
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n10 = n13;
                break;
            }
            case -1408024454: {
                String string10 = "alternate";
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n10 = 3;
                break;
            }
            case -1580883024: {
                String string11 = "enhanced-audio-intelligibility";
                boolean bl10 = string2.equals(string11);
                if (!bl10) break;
                n10 = n14;
                break;
            }
            case -1724546052: {
                String string12 = "description";
                boolean bl11 = string2.equals(string12);
                if (!bl11) break;
                n10 = n15;
                break;
            }
            case -2060497896: {
                String string13 = "subtitle";
                boolean bl12 = string2.equals(string13);
                if (!bl12) break;
                n10 = 0;
            }
        }
        switch (n10) {
            default: {
                return 0;
            }
            case 10: {
                return n13;
            }
            case 9: {
                return 32;
            }
            case 8: {
                return n12;
            }
            case 7: {
                return 64;
            }
            case 6: {
                return 256;
            }
            case 5: {
                return n15;
            }
            case 4: {
                return 16;
            }
            case 3: {
                return n14;
            }
            case 2: {
                return 2048;
            }
            case 1: {
                return 512;
            }
            case 0: 
        }
        return 128;
    }

    public Pair parseEvent(XmlPullParser xmlPullParser, String string2, String string3, long l10, ByteArrayOutputStream byteArrayOutputStream) {
        Object object = xmlPullParser;
        long l11 = 0L;
        long l12 = DashManifestParser.parseLong(xmlPullParser, "id", l11);
        long l13 = -9223372036854775807L;
        long l14 = DashManifestParser.parseLong(xmlPullParser, "duration", l13);
        long l15 = DashManifestParser.parseLong(xmlPullParser, "presentationTime", l11);
        long l16 = l10;
        l14 = Util.scaleLargeTimestamp(l14, 1000L, l10);
        l16 = 1000000L;
        l15 = Util.scaleLargeTimestamp(l15, l16, l10);
        String string4 = DashManifestParser.parseString(xmlPullParser, "messageData", null);
        object = this.parseEventObject(xmlPullParser, byteArrayOutputStream);
        Long l17 = l15;
        if (string4 != null) {
            object = Util.getUtf8Bytes(string4);
        }
        object = this.buildEvent(string2, string3, l12, l14, (byte[])object);
        return Pair.create((Object)l17, (Object)object);
    }

    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        int n10;
        byteArrayOutputStream.reset();
        XmlSerializer xmlSerializer = Xml.newSerializer();
        String string2 = Charsets.UTF_8.name();
        xmlSerializer.setOutput((OutputStream)byteArrayOutputStream, string2);
        xmlPullParser.nextToken();
        while ((n10 = XmlPullParserUtil.isEndTag(xmlPullParser, string2 = "Event")) == 0) {
            n10 = xmlPullParser.getEventType();
            switch (n10) {
                default: {
                    break;
                }
                case 10: {
                    string2 = xmlPullParser.getText();
                    xmlSerializer.docdecl(string2);
                    break;
                }
                case 9: {
                    string2 = xmlPullParser.getText();
                    xmlSerializer.comment(string2);
                    break;
                }
                case 8: {
                    string2 = xmlPullParser.getText();
                    xmlSerializer.processingInstruction(string2);
                    break;
                }
                case 7: {
                    string2 = xmlPullParser.getText();
                    xmlSerializer.ignorableWhitespace(string2);
                    break;
                }
                case 6: {
                    string2 = xmlPullParser.getText();
                    xmlSerializer.entityRef(string2);
                    break;
                }
                case 5: {
                    string2 = xmlPullParser.getText();
                    xmlSerializer.cdsect(string2);
                    break;
                }
                case 4: {
                    string2 = xmlPullParser.getText();
                    xmlSerializer.text(string2);
                    break;
                }
                case 3: {
                    string2 = xmlPullParser.getNamespace();
                    Object object = xmlPullParser.getName();
                    xmlSerializer.endTag(string2, (String)object);
                    break;
                }
                case 2: {
                    int n11;
                    string2 = xmlPullParser.getNamespace();
                    Object object = xmlPullParser.getName();
                    xmlSerializer.startTag(string2, (String)object);
                    string2 = null;
                    for (n10 = 0; n10 < (n11 = xmlPullParser.getAttributeCount()); ++n10) {
                        object = xmlPullParser.getAttributeNamespace(n10);
                        String string3 = xmlPullParser.getAttributeName(n10);
                        String string4 = xmlPullParser.getAttributeValue(n10);
                        xmlSerializer.attribute((String)object, string3, string4);
                    }
                    break;
                }
                case 1: {
                    xmlSerializer.endDocument();
                    break;
                }
                case 0: {
                    n10 = 0;
                    string2 = null;
                    Object object = Boolean.FALSE;
                    xmlSerializer.startDocument(null, (Boolean)object);
                }
            }
            xmlPullParser.nextToken();
        }
        xmlSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public EventStream parseEventStream(XmlPullParser xmlPullParser) {
        EventMessage[] eventMessageArray;
        Object object;
        String string2 = "";
        String string3 = DashManifestParser.parseString(xmlPullParser, "schemeIdUri", string2);
        string2 = DashManifestParser.parseString(xmlPullParser, "value", string2);
        Object object2 = "timescale";
        long l10 = 1L;
        long l11 = DashManifestParser.parseLong(xmlPullParser, (String)object2, l10);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = 512;
        EventMessage[] eventMessageArray2 = new ByteArrayOutputStream(n10);
        do {
            xmlPullParser.next();
            object2 = "Event";
            n10 = (int)(XmlPullParserUtil.isStartTag(xmlPullParser, (String)object2) ? 1 : 0);
            if (n10 != 0) {
                object2 = this;
                object = xmlPullParser;
                eventMessageArray = eventMessageArray2;
                object2 = this.parseEvent(xmlPullParser, string3, string2, l11, (ByteArrayOutputStream)eventMessageArray2);
                arrayList.add(object2);
                continue;
            }
            DashManifestParser.maybeSkipTag(xmlPullParser);
        } while ((n10 = (int)(XmlPullParserUtil.isEndTag(xmlPullParser, (String)(object2 = "EventStream")) ? 1 : 0)) == 0);
        long[] lArray = new long[arrayList.size()];
        eventMessageArray = new EventMessage[arrayList.size()];
        xmlPullParser = null;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            object2 = (Pair)arrayList.get(i10);
            object = (Long)((Pair)object2).first;
            lArray[i10] = l10 = ((Long)object).longValue();
            eventMessageArray[i10] = object2 = (EventMessage)((Pair)object2).second;
        }
        object2 = this;
        object = string3;
        return this.buildEventStream(string3, string2, l11, lArray, eventMessageArray);
    }

    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return this.parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    public String parseLabel(XmlPullParser xmlPullParser) {
        return DashManifestParser.parseText(xmlPullParser, "Label");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public DashManifest parseMediaPresentationDescription(XmlPullParser var1_1, String var2_2) {
        var3_3 = this;
        var4_4 = var1_1;
        var5_5 = -9223372036854775807L;
        var7_6 = -4.9E-324;
        var9_7 = DashManifestParser.parseDateTime(var1_1, "availabilityStartTime", var5_5);
        var11_8 = DashManifestParser.parseDuration(var1_1, "mediaPresentationDuration", var5_5);
        var13_9 = DashManifestParser.parseDuration(var1_1, "minBufferTime", var5_5);
        var15_10 /* !! */  = false;
        var16_11 = null;
        var18_13 = "dynamic";
        var17_12 = var1_1.getAttributeValue(null, "type");
        var19_14 = var18_13.equals(var17_12);
        if (var19_14) {
            var17_12 = "minimumUpdatePeriod";
            var22_16 = var20_15 = DashManifestParser.parseDuration(var1_1, (String)var17_12, var5_5);
        } else {
            var22_16 = var5_5;
        }
        if (var19_14) {
            var17_12 = "timeShiftBufferDepth";
            var24_17 = var20_15 = DashManifestParser.parseDuration(var4_4, (String)var17_12, var5_5);
        } else {
            var24_17 = var5_5;
        }
        if (var19_14) {
            var17_12 = "suggestedPresentationDelay";
            var26_18 = var20_15 = DashManifestParser.parseDuration(var4_4, (String)var17_12, var5_5);
        } else {
            var26_18 = var5_5;
        }
        var17_12 = "publishTime";
        var28_19 = DashManifestParser.parseDateTime(var4_4, (String)var17_12, var5_5);
        var20_15 = 0L;
        var30_20 = 0.0;
        var32_21 = var19_14 != false ? var20_15 : var5_5;
        var34_22 = new ArrayList<Object>();
        if (var19_14) {
            var20_15 = var5_5;
            var30_20 = var7_6;
        }
        var35_23 = var2_2 /* !! */ ;
        var36_24 = null;
        var37_25 = null;
        var38_26 = null;
        var39_27 = null;
        var40_28 = var20_15;
        var42_29 = var32_21;
        var44_30 = false;
        var45_31 = false;
        while (true) {
            block26: {
                block19: {
                    block22: {
                        block25: {
                            block24: {
                                block23: {
                                    block20: {
                                        block21: {
                                            var1_1.next();
                                            var16_11 = "BaseURL";
                                            var15_10 /* !! */  = XmlPullParserUtil.isStartTag(var4_4, (String)var16_11);
                                            var46_32 = true;
                                            if (!var15_10 /* !! */ ) break block20;
                                            if (var44_30) break block21;
                                            var47_33 = var3_3.parseAvailabilityTimeOffsetUs(var4_4, var42_29);
                                            var18_13 = var3_3.parseBaseUrl(var4_4, (String)var35_23);
                                            var42_29 = var47_33;
                                            var49_34 = var18_13;
                                            var35_23 = var34_22;
                                            var44_30 = var46_32;
                                            break block19;
                                        }
                                        var50_35 = var42_29;
                                        var49_34 = var35_23;
                                        var35_23 = var34_22;
                                        break block22;
                                    }
                                    var16_11 = "ProgramInformation";
                                    var15_10 /* !! */  = XmlPullParserUtil.isStartTag(var4_4, (String)var16_11);
                                    if (var15_10 /* !! */ ) {
                                        var36_24 = var16_11 = this.parseProgramInformation(var1_1);
lbl71:
                                        // 4 sources

                                        while (true) {
                                            var49_34 = var35_23;
                                            var35_23 = var34_22;
                                            break block19;
                                            break;
                                        }
                                    }
                                    var16_11 = "UTCTiming";
                                    var15_10 /* !! */  = XmlPullParserUtil.isStartTag(var4_4, (String)var16_11);
                                    if (!var15_10 /* !! */ ) break block23;
                                    var37_25 = var16_11 = this.parseUtcTiming(var1_1);
                                    ** GOTO lbl71
                                }
                                var16_11 = "Location";
                                var15_10 /* !! */  = XmlPullParserUtil.isStartTag(var4_4, (String)var16_11);
                                if (!var15_10 /* !! */ ) break block24;
                                var38_26 = var16_11 = Uri.parse((String)var1_1.nextText());
                                ** GOTO lbl71
                            }
                            var16_11 = "ServiceDescription";
                            var15_10 /* !! */  = XmlPullParserUtil.isStartTag(var4_4, (String)var16_11);
                            if (var15_10 /* !! */ ) {
                                var39_27 = var16_11 = this.parseServiceDescription(var1_1);
                                ** continue;
                            }
                            var16_11 = "Period";
                            var15_10 /* !! */  = XmlPullParserUtil.isStartTag(var4_4, (String)var16_11);
                            if (!var15_10 /* !! */  || var45_31) break block25;
                            var16_11 = this;
                            var17_12 = var1_1;
                            var18_13 = var35_23;
                            var32_21 = var40_28;
                            var52_36 = var42_29;
                            var50_35 = var42_29;
                            var42_29 = var9_7;
                            var2_2 /* !! */  = var34_22;
                            var49_34 = var35_23;
                            var16_11 = this.parsePeriod(var1_1, (String)var35_23, var40_28, var52_36, var9_7, var24_17);
                            var17_12 = (Period)var16_11.first;
                            var54_37 = var17_12.startMs;
                            cfr_temp_0 = var54_37 - var5_5;
                            var56_38 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            if (var56_38 /* !! */  != false) ** GOTO lbl123
                            if (var19_14) {
                                var35_23 = var34_22;
                                var45_31 = var46_32;
                            } else {
                                var57_40 = var34_22.size();
                                var58_41 = new StringBuilder(47);
                                var58_41.append("Unable to determine start of period ");
                                var58_41.append(var57_40);
                                var17_12 = var58_41.toString();
                                var16_11 = new ParserException((String)var17_12);
                                throw var16_11;
lbl123:
                                // 1 sources

                                var16_11 = (Long)var16_11.second;
                                var54_37 = var16_11.longValue();
                                cfr_temp_1 = var54_37 - var5_5;
                                var15_10 /* !! */  = cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
                                if (!var15_10 /* !! */ ) {
                                    var35_23 = var34_22;
                                    var40_28 = var5_5;
                                } else {
                                    var59_39 = var17_12.startMs + var54_37;
                                    var35_23 = var34_22;
                                    var40_28 = var59_39;
                                }
                                var35_23.add(var17_12);
                            }
                            break block22;
                        }
                        var50_35 = var42_29;
                        var49_34 = var35_23;
                        var35_23 = var34_22;
                        DashManifestParser.maybeSkipTag(var1_1);
                    }
                    var42_29 = var50_35;
                }
                var16_11 = "MPD";
                var15_10 /* !! */  = XmlPullParserUtil.isEndTag(var4_4, (String)var16_11);
                if (!var15_10 /* !! */ ) break block26;
                var15_10 /* !! */  = var11_8 == var5_5 ? 0 : (var11_8 < var5_5 ? -1 : 1);
                if (var15_10 /* !! */ ) ** GOTO lbl157
                var15_10 /* !! */  = var40_28 == var5_5 ? 0 : (var40_28 < var5_5 ? -1 : 1);
                if (var15_10 /* !! */ ) {
                    var32_21 = var40_28;
                } else {
                    if (!var19_14) {
                        var16_11 = new ParserException("Unable to determine duration of static manifest.");
                        throw var16_11;
                    }
lbl157:
                    // 3 sources

                    var32_21 = var11_8;
                }
                var15_10 /* !! */  = var35_23.isEmpty();
                if (!var15_10 /* !! */ ) {
                    var16_11 = this;
                    var20_15 = var9_7;
                    var52_36 = var13_9;
                    var5_5 = var26_18;
                    return this.buildMediaPresentationDescription(var9_7, var32_21, var13_9, var19_14, var22_16, var24_17, var26_18, var28_19, (ProgramInformation)var36_24, (UtcTimingElement)var37_25, (ServiceDescriptionElement)var39_27, (Uri)var38_26, var35_23);
                }
                var16_11 = new ParserException("No periods found.");
                throw var16_11;
            }
            var3_3 = this;
            var34_22 = var35_23;
            var35_23 = var49_34;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Pair parsePeriod(XmlPullParser var1_1, String var2_2, long var3_3, long var5_4, long var7_5, long var9_6) {
        var11_7 = this;
        var12_8 = var1_1 /* !! */ ;
        var13_9 = var1_1 /* !! */ .getAttributeValue(null, "id");
        var14_10 = "start";
        var15_11 = DashManifestParser.parseDuration(var1_1 /* !! */ , (String)var14_10, var3_3);
        var17_12 = -9223372036854775807L;
        var19_13 = -4.9E-324;
        var21_14 /* !! */  = (long)(var7_5 == var17_12 ? 0 : (var7_5 < var17_12 ? -1 : 1));
        var24_16 = var21_14 /* !! */  != false ? (var22_15 = var7_5 + var15_11) : var17_12;
        var26_17 = DashManifestParser.parseDuration(var12_8, "duration", var17_12);
        var28_18 = new ArrayList();
        var29_19 = new ArrayList<Object>();
        var21_14 /* !! */  = 0;
        var14_10 = null;
        var30_20 = var2_2;
        var31_21 = var5_4;
        var33_22 = false;
        var34_23 = var17_12;
        var36_24 = null;
        var37_25 = null;
        while (true) {
            block14: {
                block15: {
                    block12: {
                        block13: {
                            var1_1 /* !! */ .next();
                            var14_10 = "BaseURL";
                            var21_14 /* !! */  = (long)XmlPullParserUtil.isStartTag(var12_8, (String)var14_10);
                            if (var21_14 /* !! */  == false) break block12;
                            if (var33_22) break block13;
                            var22_15 = var11_7.parseAvailabilityTimeOffsetUs(var12_8, var31_21);
                            var38_26 = var11_7.parseBaseUrl(var12_8, var30_20);
                            var39_27 = true;
                            var31_21 = var22_15;
                            var30_20 = var38_26;
                            var33_22 = var39_27;
                            var40_28 = var29_19;
                            var41_29 = var17_12;
                            var43_30 = var19_13;
                            var11_7 = var28_18;
                            break block14;
                        }
                        var45_31 = var31_21;
                        var40_28 = var29_19;
                        var47_32 = var30_20;
                        var41_29 = var17_12;
                        var43_30 = var19_13;
                        var11_7 = var28_18;
                        ** GOTO lbl135
                    }
                    var14_10 = "AdaptationSet";
                    var21_14 /* !! */  = (long)XmlPullParserUtil.isStartTag(var12_8, (String)var14_10);
                    if (var21_14 /* !! */  == false) break block15;
                    var14_10 = this;
                    var48_33 /* !! */  = var1_1 /* !! */ ;
                    var38_26 = var30_20;
                    var49_34 = var36_24;
                    var45_31 = var31_21;
                    var11_7 = var29_19;
                    var47_32 = var30_20;
                    var17_12 = var24_16;
                    var2_2 = var29_19;
                    var11_7 = var28_18;
                    var14_10 = this.parseAdaptationSet(var1_1 /* !! */ , var30_20, (SegmentBase)var36_24, var26_17, var31_21, var34_23, var24_16, var9_6);
                    var28_18.add(var14_10);
                    var40_28 = var29_19;
lbl65:
                    // 2 sources

                    while (true) {
                        var41_29 = -9223372036854775807L;
                        var43_30 = -4.9E-324;
                        ** GOTO lbl135
                        break;
                    }
                }
                var45_31 = var31_21;
                var2_2 = var29_19;
                var47_32 = var30_20;
                var11_7 = var28_18;
                var14_10 = "EventStream";
                var21_14 /* !! */  = (long)XmlPullParserUtil.isStartTag(var12_8, (String)var14_10);
                if (var21_14 /* !! */  != false) {
                    var14_10 = this.parseEventStream(var1_1 /* !! */ );
                    var48_33 /* !! */  = var29_19;
                    var29_19.add(var14_10);
                    var40_28 = var29_19;
                    ** continue;
                }
                var48_33 /* !! */  = var29_19;
                var14_10 = "SegmentBase";
                var21_14 /* !! */  = (long)XmlPullParserUtil.isStartTag(var12_8, (String)var14_10);
                if (var21_14 /* !! */  != false) {
                    var28_18 = this;
                    var40_28 = var29_19;
                    var36_24 = var14_10 = this.parseSegmentBase(var12_8, null);
                    var41_29 = -9223372036854775807L;
                    var43_30 = -4.9E-324;
                } else {
                    var28_18 = this;
                    var40_28 = var29_19;
                    var14_10 = "SegmentList";
                    var21_14 /* !! */  = (long)XmlPullParserUtil.isStartTag(var12_8, (String)var14_10);
                    if (var21_14 /* !! */  != false) {
                        var50_35 = this.parseAvailabilityTimeOffsetUs(var12_8, -9223372036854775807L);
                        var38_26 = null;
                        var14_10 = this;
                        var48_33 /* !! */  = var1_1 /* !! */ ;
                        var14_10 = this.parseSegmentList(var1_1 /* !! */ , null, var24_16, var26_17, var31_21, var50_35, var9_6);
                        var34_23 = var50_35;
                        var41_29 = -9223372036854775807L;
                        var43_30 = -4.9E-324;
lbl106:
                        // 2 sources

                        while (true) {
                            var36_24 = var14_10;
                            break;
                        }
                    } else {
                        var14_10 = "SegmentTemplate";
                        var21_14 /* !! */  = (long)XmlPullParserUtil.isStartTag(var12_8, (String)var14_10);
                        if (var21_14 /* !! */  != false) {
                            var17_12 = -9223372036854775807L;
                            var19_13 = -4.9E-324;
                            var50_35 = this.parseAvailabilityTimeOffsetUs(var12_8, var17_12);
                            var38_26 = null;
                            var49_34 = ImmutableList.of();
                            var14_10 = this;
                            var48_33 /* !! */  = var1_1 /* !! */ ;
                            var31_21 = var26_17;
                            var41_29 = var17_12;
                            var43_30 = var19_13;
                            var17_12 = var50_35;
                            var14_10 = this.parseSegmentTemplate(var1_1 /* !! */ , null, (List)var49_34, var24_16, var26_17, var45_31, var50_35, var9_6);
                            var34_23 = var50_35;
                            var31_21 = var45_31;
                            ** continue;
                        }
                        var41_29 = -9223372036854775807L;
                        var43_30 = -4.9E-324;
                        var14_10 = "AssetIdentifier";
                        var52_36 = XmlPullParserUtil.isStartTag(var12_8, (String)var14_10);
                        if (var52_36) {
                            var37_25 = var14_10 = DashManifestParser.parseDescriptor(var12_8, (String)var14_10);
                        } else {
                            DashManifestParser.maybeSkipTag(var1_1 /* !! */ );
                        }
lbl135:
                        // 4 sources

                        var31_21 = var45_31;
                        var30_20 = var47_32;
                    }
                }
            }
            var14_10 = "Period";
            var21_14 /* !! */  = (long)XmlPullParserUtil.isEndTag(var12_8, (String)var14_10);
            if (var21_14 /* !! */  != false) {
                var1_1 /* !! */  = this;
                var2_2 = var13_9;
                var3_3 = var15_11;
                var14_10 = this.buildPeriod(var13_9, var15_11, (List)var11_7, var40_28, (Descriptor)var37_25);
                var48_33 /* !! */  = Long.valueOf(var26_17);
                return Pair.create((Object)var14_10, (Object)var48_33 /* !! */ );
            }
            var28_18 = var11_7;
            var29_19 = var40_28;
            var17_12 = var41_29;
            var19_13 = var43_30;
            var11_7 = this;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public ProgramInformation parseProgramInformation(XmlPullParser object) {
        String string2 = null;
        String string3 = DashManifestParser.parseString(object, "moreInformationURL", null);
        String string4 = DashManifestParser.parseString(object, "lang", null);
        String string5 = null;
        boolean bl2 = false;
        Object object2 = null;
        while (true) {
            object.next();
            String string6 = "Title";
            boolean bl3 = XmlPullParserUtil.isStartTag(object, string6);
            if (bl3) {
                string2 = object.nextText();
            } else {
                string6 = "Source";
                bl3 = XmlPullParserUtil.isStartTag(object, string6);
                if (bl3) {
                    string5 = object.nextText();
                } else {
                    string6 = "Copyright";
                    bl3 = XmlPullParserUtil.isStartTag(object, string6);
                    if (bl3) {
                        object2 = object.nextText();
                    } else {
                        DashManifestParser.maybeSkipTag(object);
                    }
                }
            }
            String string7 = object2;
            object2 = "ProgramInformation";
            bl2 = XmlPullParserUtil.isEndTag(object, (String)object2);
            if (bl2) {
                ProgramInformation programInformation;
                object2 = programInformation;
                string6 = string2;
                return new ProgramInformation(string2, string5, string7, string3, string4);
            }
            object2 = string7;
        }
    }

    public RangedUri parseRangedUrl(XmlPullParser object, String string2, String string3) {
        long l10;
        long l11;
        long l12;
        String string4;
        block2: {
            long l13;
            block1: {
                block0: {
                    Object object2 = null;
                    string4 = object.getAttributeValue(null, string2);
                    object = object.getAttributeValue(null, string3);
                    l13 = -1;
                    if (object == null) break block0;
                    object = ((String)object).split("-");
                    object2 = object[0];
                    l12 = Long.parseLong((String)object2);
                    int n10 = ((Object)object).length;
                    int n11 = 2;
                    if (n10 != n11) break block1;
                    int n12 = 1;
                    object = object[n12];
                    long l14 = Long.parseLong((String)object) - l12;
                    l11 = 1L;
                    l10 = l14 += l11;
                    break block2;
                }
                l12 = 0L;
            }
            l10 = l13;
        }
        l11 = l12;
        return this.buildRangedUri(string4, l12, l10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public DashManifestParser$RepresentationInfo parseRepresentation(XmlPullParser var1_1, String var2_2, String var3_3, String var4_4, int var5_5, int var6_6, float var7_7, int var8_8, int var9_9, String var10_10, List var11_11, List var12_12, List var13_13, List var14_14, SegmentBase var15_15, long var16_16, long var18_17, long var20_18, long var22_19, long var24_20) {
        var26_21 = this;
        var27_22 /* !! */  = var1_1 /* !! */ ;
        var28_23 = false;
        var29_24 = var1_1 /* !! */ .getAttributeValue(null, "id");
        var30_25 = DashManifestParser.parseInt(var1_1 /* !! */ , "bandwidth", -1);
        var31_26 = var3_3;
        var32_27 = DashManifestParser.parseString(var1_1 /* !! */ , "mimeType", var3_3);
        var31_26 = var4_4;
        var33_28 = DashManifestParser.parseString(var1_1 /* !! */ , "codecs", (String)var4_4);
        var34_29 = DashManifestParser.parseInt(var1_1 /* !! */ , "width", var5_5);
        var35_30 = DashManifestParser.parseInt(var1_1 /* !! */ , "height", var6_6);
        var36_31 = DashManifestParser.parseFrameRate(var1_1 /* !! */ , var7_7);
        var37_32 = DashManifestParser.parseInt(var1_1 /* !! */ , "audioSamplingRate", var9_9);
        var38_33 = new ArrayList<Object>();
        var39_34 = new ArrayList();
        var41_36 = var13_13;
        var40_35 = new ArrayList(var13_13);
        var42_37 = new ArrayList(var14_14);
        var41_36 = null;
        var43_38 = var2_2;
        var44_39 = var8_8;
        var45_40 = var20_18;
        var47_41 = null;
        var48_42 = 0;
        var49_43 = var15_15;
        var50_44 = var22_19;
        while (true) {
            block21: {
                block22: {
                    var1_1 /* !! */ .next();
                    var52_45 = "BaseURL";
                    var53_46 = XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                    if (var53_46 == 0) break block21;
                    if (var48_42 != 0) break block22;
                    var54_47 = var26_21.parseAvailabilityTimeOffsetUs(var27_22 /* !! */ , var45_40);
                    var56_48 = var26_21.parseBaseUrl(var27_22 /* !! */ , var43_38);
                    var57_49 = 1;
                    var58_50 = var56_48;
                    var48_42 = var57_49;
                    var26_21 = var38_33;
                    var59_51 = var44_39;
                    var60_52 = var49_43;
                    var45_40 = var54_47;
                    ** GOTO lbl60
                }
                var61_53 = var45_40;
                var58_50 = var43_38;
                var26_21 = var38_33;
                var38_33 = var39_34;
                var39_34 = var42_37;
                ** GOTO lbl160
            }
            var52_45 = "AudioChannelConfiguration";
            var53_46 = XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
            if (var53_46 != 0) {
                var53_46 = this.parseAudioChannelConfiguration(var1_1 /* !! */ );
                var60_52 = var49_43;
                var58_50 = var43_38;
                var26_21 = var38_33;
                var59_51 = var53_46;
lbl60:
                // 3 sources

                while (true) {
                    var38_33 = var39_34;
                    var39_34 = var42_37;
                    break;
                }
            } else {
                var52_45 = "SegmentBase";
                var53_46 = (int)XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                if (var53_46 != 0) {
                    var49_43 = (SegmentBase$SingleSegmentBase)var49_43;
                    var49_43 = var26_21.parseSegmentBase(var27_22 /* !! */ , (SegmentBase$SingleSegmentBase)var49_43);
                    var58_50 = var43_38;
                    var26_21 = var38_33;
                    var59_51 = var44_39;
                    var60_52 = var49_43;
                    ** continue;
                }
                var52_45 = "SegmentList";
                var53_46 = (int)XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                if (var53_46 != 0) {
                    var63_54 = var26_21.parseAvailabilityTimeOffsetUs(var27_22 /* !! */ , var50_44);
                    var31_26 = var49_43;
                    var31_26 = (SegmentBase$SegmentList)var49_43;
                    var49_43 = this;
                    var41_36 = var1_1 /* !! */ ;
                    var54_47 = var16_16;
                    var61_53 = var45_40;
                    var45_40 = var18_17;
                    var58_50 = var43_38;
                    var65_55 = var42_37;
                    var66_56 = var39_34;
                    var67_57 = var40_35;
                    var49_43 = this.parseSegmentList(var1_1 /* !! */ , (SegmentBase$SegmentList)var31_26, var16_16, var18_17, var61_53, var63_54, var24_20);
                    var26_21 = var38_33;
lbl91:
                    // 2 sources

                    while (true) {
                        var59_51 = var44_39;
                        var50_44 = var63_54;
lbl94:
                        // 2 sources

                        while (true) {
                            var45_40 = var61_53;
                            var39_34 = var65_55;
                            var38_33 = var66_56;
                            var40_35 = var67_57;
                            ** GOTO lbl162
                            break;
                        }
                        break;
                    }
                } else {
                    var61_53 = var45_40;
                    var58_50 = var43_38;
                    var65_55 = var42_37;
                    var66_56 = var39_34;
                    var67_57 = var40_35;
                    var52_45 = "SegmentTemplate";
                    var53_46 = (int)XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                    if (var53_46 != 0) {
                        var63_54 = var26_21.parseAvailabilityTimeOffsetUs(var27_22 /* !! */ , var50_44);
                        var31_26 = var49_43;
                        var31_26 = (SegmentBase$SegmentTemplate)var49_43;
                        var49_43 = this;
                        var41_36 = var1_1 /* !! */ ;
                        var52_45 = var14_14;
                        var26_21 = var38_33;
                        var49_43 = this.parseSegmentTemplate(var1_1 /* !! */ , (SegmentBase$SegmentTemplate)var31_26, var14_14, var16_16, var18_17, var45_40, var63_54, var24_20);
                        ** continue;
                    }
                    var26_21 = var38_33;
                    var52_45 = "ContentProtection";
                    var53_46 = (int)XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                    if (var53_46 != 0) {
                        var52_45 = this.parseContentProtection(var1_1 /* !! */ );
                        var68_58 = var52_45.first;
                        if (var68_58 != null) {
                            var47_41 = var68_58;
                            var47_41 = (String)var68_58;
                        }
                        if ((var52_45 = var52_45.second) != null) {
                            var52_45 = (DrmInitData$SchemeData)var52_45;
                            var26_21.add(var52_45);
                        }
                        var59_51 = var44_39;
                        ** continue;
                    }
                    var52_45 = "InbandEventStream";
                    var69_59 = (int)XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                    if (var69_59 != 0) {
                        var52_45 = DashManifestParser.parseDescriptor(var27_22 /* !! */ , (String)var52_45);
                        var38_33 = var39_34;
                        var39_34.add(var52_45);
                        var39_34 = var42_37;
                    } else {
                        var38_33 = var39_34;
                        var52_45 = "EssentialProperty";
                        var69_59 = (int)XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                        if (var69_59 != 0) {
                            var52_45 = DashManifestParser.parseDescriptor(var27_22 /* !! */ , (String)var52_45);
                            var40_35.add(var52_45);
                            var39_34 = var42_37;
                        } else {
                            var52_45 = "SupplementalProperty";
                            var69_59 = (int)XmlPullParserUtil.isStartTag(var27_22 /* !! */ , (String)var52_45);
                            if (var69_59 != 0) {
                                var52_45 = DashManifestParser.parseDescriptor(var27_22 /* !! */ , (String)var52_45);
                                var39_34 = var42_37;
                                var42_37.add(var52_45);
                            } else {
                                var39_34 = var42_37;
                                DashManifestParser.maybeSkipTag(var1_1 /* !! */ );
                            }
                        }
                    }
lbl160:
                    // 5 sources

                    var59_51 = var44_39;
                    var45_40 = var61_53;
                }
lbl162:
                // 2 sources

                var60_52 = var49_43;
            }
            var49_43 = "Representation";
            var28_23 = XmlPullParserUtil.isEndTag(var27_22 /* !! */ , (String)var49_43);
            if (var28_23) {
                var49_43 = this;
                var41_36 = var29_24;
                var31_26 = var32_27;
                var53_46 = var34_29;
                var69_59 = var35_30;
                var57_49 = var59_51;
                var59_51 = var37_32;
                var42_37 = var10_10;
                var70_60 = var39_34;
                var39_34 = var12_12;
                var71_61 = var40_35;
                var40_35 = var33_28;
                var72_62 = var38_33;
                var38_33 = var71_61;
                var27_22 /* !! */  = var70_60;
                var49_43 = this.buildFormat(var29_24, var32_27, var34_29, var35_30, var36_31, var57_49, var37_32, var30_25, var10_10, var11_11, var12_12, var33_28, var71_61, var70_60);
                if (var60_52 == null) {
                    var60_52 = var41_36 = new SegmentBase$SingleSegmentBase();
                }
                var1_1 /* !! */  = var41_36;
                var2_2 = var49_43;
                var3_3 = var58_50;
                var4_4 = var60_52;
                var73_63 = -1;
                var41_36 = new DashManifestParser$RepresentationInfo((Format)var49_43, var58_50, (SegmentBase)var60_52, (String)var47_41, var26_21, var72_62, var73_63);
                return var41_36;
            }
            var42_37 = var39_34;
            var39_34 = var38_33;
            var38_33 = var26_21;
            var49_43 = var60_52;
            var26_21 = this;
            var44_39 = var59_51;
            var43_38 = var58_50;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public int parseRoleFlagsFromAccessibilityDescriptors(List list) {
        int n10 = 0;
        int n11 = 0;
        while (true) {
            block7: {
                int n12;
                block6: {
                    boolean bl2;
                    String string2;
                    String string3;
                    Object object;
                    block5: {
                        if (n10 >= (n12 = list.size())) {
                            return n11;
                        }
                        object = (Descriptor)list.get(n10);
                        string3 = "urn:mpeg:dash:role:2011";
                        string2 = ((Descriptor)object).schemeIdUri;
                        bl2 = string3.equalsIgnoreCase(string2);
                        if (!bl2) break block5;
                        object = ((Descriptor)object).value;
                        n12 = this.parseDashRoleSchemeValue((String)object);
                        break block6;
                    }
                    string3 = "urn:tva:metadata:cs:AudioPurposeCS:2007";
                    string2 = ((Descriptor)object).schemeIdUri;
                    bl2 = string3.equalsIgnoreCase(string2);
                    if (!bl2) break block7;
                    object = ((Descriptor)object).value;
                    n12 = this.parseTvaAudioPurposeCsValue((String)object);
                }
                n11 |= n12;
            }
            ++n10;
        }
    }

    public int parseRoleFlagsFromProperties(List list) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            String string2 = "http://dashif.org/guidelines/trickmode";
            String string3 = ((Descriptor)list.get((int)i10)).schemeIdUri;
            n10 = (int)(string2.equalsIgnoreCase(string3) ? 1 : 0);
            if (n10 == 0) continue;
            n11 |= 0x4000;
        }
        return n11;
    }

    public int parseRoleFlagsFromRoleDescriptors(List list) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object = (Descriptor)list.get(i10);
            String string2 = "urn:mpeg:dash:role:2011";
            String string3 = ((Descriptor)object).schemeIdUri;
            boolean bl2 = string2.equalsIgnoreCase(string3);
            if (!bl2) continue;
            object = ((Descriptor)object).value;
            n10 = this.parseDashRoleSchemeValue((String)object);
            n11 |= n10;
        }
        return n11;
    }

    public SegmentBase$SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase$SingleSegmentBase segmentBase$SingleSegmentBase) {
        boolean bl2;
        long l10;
        long l11;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object object = segmentBase$SingleSegmentBase;
        long l12 = 1L;
        double d10 = Double.MIN_VALUE;
        long l13 = segmentBase$SingleSegmentBase != null ? segmentBase$SingleSegmentBase.timescale : l12;
        String string2 = "timescale";
        long l14 = DashManifestParser.parseLong(xmlPullParser2, string2, l13);
        l13 = 0L;
        long l15 = object != null ? ((SegmentBase)object).presentationTimeOffset : l13;
        Object object2 = "presentationTimeOffset";
        long l16 = DashManifestParser.parseLong(xmlPullParser2, (String)object2, l15);
        l15 = object != null ? ((SegmentBase$SingleSegmentBase)object).indexStart : l13;
        if (object != null) {
            l13 = ((SegmentBase$SingleSegmentBase)object).indexLength;
        }
        object2 = null;
        String string3 = xmlPullParser2.getAttributeValue(null, "indexRange");
        if (string3 != null) {
            Object object3 = string3.split("-");
            String string4 = object3[0];
            long l17 = Long.parseLong(string4);
            int n10 = 1;
            object3 = object3[n10];
            l11 = Long.parseLong((String)object3) - l17 + l12;
            l10 = l17;
        } else {
            l11 = l13;
            l10 = l15;
        }
        if (object != null) {
            object2 = ((SegmentBase)object).initialization;
        }
        do {
            xmlPullParser.next();
            object = "Initialization";
            bl2 = XmlPullParserUtil.isStartTag(xmlPullParser2, (String)object);
            if (bl2) {
                object2 = object = this.parseInitialization(xmlPullParser);
                continue;
            }
            DashManifestParser.maybeSkipTag(xmlPullParser);
        } while (!(bl2 = XmlPullParserUtil.isEndTag(xmlPullParser2, (String)(object = "SegmentBase"))));
        return this.buildSingleSegmentBase((RangedUri)object2, l14, l16, l10, l11);
    }

    public SegmentBase$SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase$SegmentList segmentBase$SegmentList, long l10, long l11, long l12, long l13, long l14) {
        Object object;
        boolean bl2;
        Object object2 = xmlPullParser;
        SegmentBase$SegmentList segmentBase$SegmentList2 = segmentBase$SegmentList;
        long l15 = 1L;
        long l16 = segmentBase$SegmentList != null ? segmentBase$SegmentList.timescale : l15;
        String string2 = "timescale";
        long l17 = DashManifestParser.parseLong(object2, string2, l16);
        l16 = segmentBase$SegmentList2 != null ? segmentBase$SegmentList2.presentationTimeOffset : 0L;
        string2 = "presentationTimeOffset";
        long l18 = DashManifestParser.parseLong(object2, string2, l16);
        l16 = segmentBase$SegmentList2 != null ? segmentBase$SegmentList2.duration : -9223372036854775807L;
        string2 = "duration";
        long l19 = DashManifestParser.parseLong(object2, string2, l16);
        if (segmentBase$SegmentList2 != null) {
            l15 = segmentBase$SegmentList2.startNumber;
        }
        String string3 = "startNumber";
        long l20 = DashManifestParser.parseLong(object2, string3, l15);
        long l21 = DashManifestParser.getFinalAvailabilityTimeOffset(l12, l13);
        Object object3 = null;
        List<Object> list = null;
        Object object4 = null;
        do {
            xmlPullParser.next();
            object = "Initialization";
            bl2 = XmlPullParserUtil.isStartTag(object2, (String)object);
            if (bl2) {
                object4 = object = this.parseInitialization(xmlPullParser);
                continue;
            }
            object = "SegmentTimeline";
            bl2 = XmlPullParserUtil.isStartTag(object2, (String)object);
            if (bl2) {
                object3 = this;
                object = xmlPullParser;
                l16 = l17;
                object3 = this.parseSegmentTimeline(xmlPullParser, l17, l11);
                continue;
            }
            object = "SegmentURL";
            bl2 = XmlPullParserUtil.isStartTag(object2, (String)object);
            if (bl2) {
                if (list == null) {
                    list = new List<Object>();
                }
                object = this.parseSegmentUrl(xmlPullParser);
                list.add(object);
                continue;
            }
            DashManifestParser.maybeSkipTag(xmlPullParser);
        } while (!(bl2 = XmlPullParserUtil.isEndTag(object2, (String)(object = "SegmentList"))));
        if (segmentBase$SegmentList2 != null) {
            if (object4 == null) {
                object4 = object = segmentBase$SegmentList2.initialization;
            }
            if (object3 == null) {
                object3 = segmentBase$SegmentList2.segmentTimeline;
            }
            if (list == null) {
                list = segmentBase$SegmentList2.mediaSegments;
            }
        }
        object = list;
        object2 = object4;
        return this.buildSegmentList((RangedUri)object4, l17, l18, l20, l19, (List)object3, l21, list, l14, l10);
    }

    public SegmentBase$SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase$SegmentTemplate segmentBase$SegmentTemplate, List list, long l10, long l11, long l12, long l13, long l14) {
        boolean bl2;
        Object object;
        Object object2 = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase$SegmentTemplate segmentBase$SegmentTemplate2 = segmentBase$SegmentTemplate;
        long l15 = 1L;
        long l16 = segmentBase$SegmentTemplate != null ? segmentBase$SegmentTemplate.timescale : l15;
        String string2 = "timescale";
        long l17 = DashManifestParser.parseLong(xmlPullParser2, string2, l16);
        l16 = segmentBase$SegmentTemplate2 != null ? segmentBase$SegmentTemplate2.presentationTimeOffset : 0L;
        string2 = "presentationTimeOffset";
        long l18 = DashManifestParser.parseLong(xmlPullParser2, string2, l16);
        l16 = segmentBase$SegmentTemplate2 != null ? segmentBase$SegmentTemplate2.duration : -9223372036854775807L;
        string2 = "duration";
        long l19 = DashManifestParser.parseLong(xmlPullParser2, string2, l16);
        if (segmentBase$SegmentTemplate2 != null) {
            l15 = segmentBase$SegmentTemplate2.startNumber;
        }
        String string3 = "startNumber";
        long l20 = DashManifestParser.parseLong(xmlPullParser2, string3, l15);
        long l21 = DashManifestParser.parseLastSegmentNumberSupplementalProperty(list);
        long l22 = DashManifestParser.getFinalAvailabilityTimeOffset(l12, l13);
        Object object3 = null;
        if (segmentBase$SegmentTemplate2 != null) {
            object = segmentBase$SegmentTemplate2.mediaTemplate;
        } else {
            bl2 = false;
            object = null;
        }
        string3 = "media";
        UrlTemplate urlTemplate = ((DashManifestParser)object2).parseUrlTemplate(xmlPullParser2, string3, (UrlTemplate)object);
        if (segmentBase$SegmentTemplate2 != null) {
            object = segmentBase$SegmentTemplate2.initializationTemplate;
        } else {
            bl2 = false;
            object = null;
        }
        string3 = "initialization";
        UrlTemplate urlTemplate2 = ((DashManifestParser)object2).parseUrlTemplate(xmlPullParser2, string3, (UrlTemplate)object);
        Object object4 = null;
        while (true) {
            long l23;
            xmlPullParser.next();
            object = "Initialization";
            bl2 = XmlPullParserUtil.isStartTag(xmlPullParser2, (String)object);
            if (bl2) {
                object4 = object = this.parseInitialization(xmlPullParser);
            } else {
                object = "SegmentTimeline";
                bl2 = XmlPullParserUtil.isStartTag(xmlPullParser2, (String)object);
                if (bl2) {
                    object3 = this;
                    object = xmlPullParser;
                    l16 = l17;
                    l23 = l11;
                    object3 = this.parseSegmentTimeline(xmlPullParser, l17, l11);
                } else {
                    DashManifestParser.maybeSkipTag(xmlPullParser);
                }
            }
            object = "SegmentTemplate";
            bl2 = XmlPullParserUtil.isEndTag(xmlPullParser2, (String)object);
            if (bl2) {
                if (segmentBase$SegmentTemplate2 != null) {
                    if (object4 == null) {
                        object4 = segmentBase$SegmentTemplate2.initialization;
                    }
                    if (object3 == null) {
                        object3 = segmentBase$SegmentTemplate2.segmentTimeline;
                    }
                }
                object = object4;
                object4 = object3;
                object3 = this;
                l16 = l17;
                l23 = l18;
                l17 = l21;
                l18 = l19;
                object2 = urlTemplate2;
                return this.buildSegmentTemplate((RangedUri)object, l16, l23, l20, l21, l19, (List)object4, l22, urlTemplate2, urlTemplate, l14, l10);
            }
            object2 = this;
        }
    }

    public List parseSegmentTimeline(XmlPullParser xmlPullParser, long l10, long l11) {
        long l12;
        long l13;
        Object object;
        boolean bl2;
        long l14;
        Object object2 = xmlPullParser;
        ArrayList arrayList = new ArrayList();
        long l15 = -9223372036854775807L;
        long l16 = l14 = 0L;
        boolean bl3 = false;
        ArrayList arrayList2 = null;
        int n10 = 0;
        long l17 = l15;
        do {
            xmlPullParser.next();
            object = "S";
            bl2 = XmlPullParserUtil.isStartTag(object2, (String)object);
            if (bl2) {
                object = "t";
                l13 = DashManifestParser.parseLong(object2, (String)object, l15);
                if (bl3) {
                    arrayList2 = this;
                    object = arrayList;
                    l12 = l13;
                    l16 = this.addSegmentTimelineElementsToList(arrayList, l16, l17, n10, l13);
                }
                if (!(bl3 = l13 == l15 ? 0 : (l13 < l15 ? -1 : 1))) {
                    l13 = l16;
                }
                arrayList2 = "d";
                l14 = DashManifestParser.parseLong(object2, (String)((Object)arrayList2), l15);
                String string2 = "r";
                int n11 = DashManifestParser.parseInt(object2, string2, 0);
                boolean bl4 = true;
                l17 = l14;
                n10 = n11;
                bl3 = bl4;
                l16 = l13;
                continue;
            }
            DashManifestParser.maybeSkipTag(xmlPullParser);
        } while (!(bl2 = XmlPullParserUtil.isEndTag(object2, (String)(object = "SegmentTimeline"))));
        if (bl3) {
            long l18 = 1000L;
            l13 = l11;
            l12 = Util.scaleLargeTimestamp(l11, l10, l18);
            object2 = this;
            arrayList2 = arrayList;
            this.addSegmentTimelineElementsToList(arrayList, l16, l17, n10, l12);
        }
        return arrayList;
    }

    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return this.parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    public int parseSelectionFlagsFromRoleDescriptors(List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object = (Descriptor)list.get(i10);
            String string2 = "urn:mpeg:dash:role:2011";
            String string3 = ((Descriptor)object).schemeIdUri;
            boolean bl2 = string2.equalsIgnoreCase(string3);
            if (!bl2 || (n10 = (int)((string3 = "main").equals(object = ((Descriptor)object).value) ? 1 : 0)) == 0) continue;
            return 1;
        }
        return 0;
    }

    public ServiceDescriptionElement parseServiceDescription(XmlPullParser xmlPullParser) {
        String string2;
        String string3;
        boolean bl2;
        Object object = xmlPullParser;
        float f10 = -3.4028235E38f;
        long l10 = -9223372036854775807L;
        float f11 = f10;
        float f12 = f10;
        long l11 = l10;
        long l12 = l10;
        long l13 = l10;
        do {
            xmlPullParser.next();
            string2 = "Latency";
            boolean bl3 = XmlPullParserUtil.isStartTag(object, string2);
            String string4 = "max";
            String string5 = "min";
            if (bl3) {
                string3 = "target";
                l11 = DashManifestParser.parseLong(object, string3, l10);
                l12 = DashManifestParser.parseLong(object, string5, l10);
                l13 = DashManifestParser.parseLong(object, string4, l10);
                continue;
            }
            string2 = "PlaybackRate";
            bl3 = XmlPullParserUtil.isStartTag(object, string2);
            if (!bl3) continue;
            f11 = DashManifestParser.parseFloat(object, string5, f10);
            f12 = DashManifestParser.parseFloat(object, string4, f10);
        } while (!(bl2 = XmlPullParserUtil.isEndTag(object, string3 = "ServiceDescription")));
        string2 = object;
        object = new ServiceDescriptionElement(l11, l12, l13, f11, f12);
        return object;
    }

    public int parseTvaAudioPurposeCsValue(String string2) {
        if (string2 == null) {
            return 0;
        }
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 4;
        int n13 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 54: {
                String string3 = "6";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n10 = n12;
                break;
            }
            case 52: {
                String string4 = "4";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n10 = 3;
                break;
            }
            case 51: {
                String string5 = "3";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n10 = 2;
                break;
            }
            case 50: {
                String string6 = "2";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n10 = n13;
                break;
            }
            case 49: {
                String string7 = "1";
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n10 = 0;
            }
        }
        switch (n10) {
            default: {
                return 0;
            }
            case 4: {
                return n13;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return n12;
            }
            case 1: {
                return 2048;
            }
            case 0: 
        }
        return 512;
    }

    public UrlTemplate parseUrlTemplate(XmlPullParser object, String string2, UrlTemplate urlTemplate) {
        if ((object = object.getAttributeValue(null, string2)) != null) {
            return UrlTemplate.compile((String)object);
        }
        return urlTemplate;
    }

    public UtcTimingElement parseUtcTiming(XmlPullParser object) {
        String string2 = object.getAttributeValue(null, "schemeIdUri");
        object = object.getAttributeValue(null, "value");
        return this.buildUtcTimingElement(string2, (String)object);
    }
}

