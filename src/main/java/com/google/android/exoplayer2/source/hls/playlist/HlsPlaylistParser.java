/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$RenditionReport;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$DeltaUpdateException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$LineIterator;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HlsPlaylistParser
implements ParsingLoadable$Parser {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String LOG_TAG = "HlsPlaylistParser";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final Pattern REGEX_ATTR_BYTERANGE;
    private static final Pattern REGEX_ATTR_DURATION;
    private static final Pattern REGEX_AUDIO;
    private static final Pattern REGEX_AUTOSELECT;
    private static final Pattern REGEX_AVERAGE_BANDWIDTH;
    private static final Pattern REGEX_BANDWIDTH;
    private static final Pattern REGEX_BYTERANGE;
    private static final Pattern REGEX_BYTERANGE_LENGTH;
    private static final Pattern REGEX_BYTERANGE_START;
    private static final Pattern REGEX_CAN_BLOCK_RELOAD;
    private static final Pattern REGEX_CAN_SKIP_DATE_RANGES;
    private static final Pattern REGEX_CAN_SKIP_UNTIL;
    private static final Pattern REGEX_CHANNELS;
    private static final Pattern REGEX_CHARACTERISTICS;
    private static final Pattern REGEX_CLOSED_CAPTIONS;
    private static final Pattern REGEX_CODECS;
    private static final Pattern REGEX_DEFAULT;
    private static final Pattern REGEX_FORCED;
    private static final Pattern REGEX_FRAME_RATE;
    private static final Pattern REGEX_GAP;
    private static final Pattern REGEX_GROUP_ID;
    private static final Pattern REGEX_HOLD_BACK;
    private static final Pattern REGEX_IMPORT;
    private static final Pattern REGEX_INDEPENDENT;
    private static final Pattern REGEX_INSTREAM_ID;
    private static final Pattern REGEX_IV;
    private static final Pattern REGEX_KEYFORMAT;
    private static final Pattern REGEX_KEYFORMATVERSIONS;
    private static final Pattern REGEX_LANGUAGE;
    private static final Pattern REGEX_LAST_MSN;
    private static final Pattern REGEX_LAST_PART;
    private static final Pattern REGEX_MEDIA_DURATION;
    private static final Pattern REGEX_MEDIA_SEQUENCE;
    private static final Pattern REGEX_MEDIA_TITLE;
    private static final Pattern REGEX_METHOD;
    private static final Pattern REGEX_NAME;
    private static final Pattern REGEX_PART_HOLD_BACK;
    private static final Pattern REGEX_PART_TARGET_DURATION;
    private static final Pattern REGEX_PLAYLIST_TYPE;
    private static final Pattern REGEX_PRELOAD_HINT_TYPE;
    private static final Pattern REGEX_RESOLUTION;
    private static final Pattern REGEX_SKIPPED_SEGMENTS;
    private static final Pattern REGEX_SUBTITLES;
    private static final Pattern REGEX_TARGET_DURATION;
    private static final Pattern REGEX_TIME_OFFSET;
    private static final Pattern REGEX_TYPE;
    private static final Pattern REGEX_URI;
    private static final Pattern REGEX_VALUE;
    private static final Pattern REGEX_VARIABLE_REFERENCE;
    private static final Pattern REGEX_VERSION;
    private static final Pattern REGEX_VIDEO;
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_IFRAME = "#EXT-X-I-FRAMES-ONLY";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_I_FRAME_STREAM_INF = "#EXT-X-I-FRAME-STREAM-INF";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PART = "#EXT-X-PART";
    private static final String TAG_PART_INF = "#EXT-X-PART-INF";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PRELOAD_HINT = "#EXT-X-PRELOAD-HINT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_RENDITION_REPORT = "#EXT-X-RENDITION-REPORT";
    private static final String TAG_SERVER_CONTROL = "#EXT-X-SERVER-CONTROL";
    private static final String TAG_SESSION_KEY = "#EXT-X-SESSION-KEY";
    private static final String TAG_SKIP = "#EXT-X-SKIP";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_MAP = "MAP";
    private static final String TYPE_PART = "PART";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMasterPlaylist masterPlaylist;
    private final HlsMediaPlaylist previousMediaPlaylist;

    static {
        REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
        REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
        REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
        REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
        REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
        REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
        REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
        REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
        REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
        REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
        REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        REGEX_ATTR_DURATION = Pattern.compile("DURATION=([\\d\\.]+)\\b");
        REGEX_PART_TARGET_DURATION = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
        REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
        REGEX_CAN_SKIP_UNTIL = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
        REGEX_CAN_SKIP_DATE_RANGES = HlsPlaylistParser.compileBooleanAttrPattern("CAN-SKIP-DATERANGES");
        REGEX_SKIPPED_SEGMENTS = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
        REGEX_HOLD_BACK = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
        REGEX_PART_HOLD_BACK = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
        REGEX_CAN_BLOCK_RELOAD = HlsPlaylistParser.compileBooleanAttrPattern("CAN-BLOCK-RELOAD");
        REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
        REGEX_LAST_MSN = Pattern.compile("LAST-MSN=(\\d+)\\b");
        REGEX_LAST_PART = Pattern.compile("LAST-PART=(\\d+)\\b");
        REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
        REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
        REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
        REGEX_BYTERANGE_START = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
        REGEX_BYTERANGE_LENGTH = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
        REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
        REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
        REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
        REGEX_IV = Pattern.compile("IV=([^,.*]+)");
        REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
        REGEX_PRELOAD_HINT_TYPE = Pattern.compile("TYPE=(PART|MAP)");
        REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
        REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
        REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
        REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
        REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
        REGEX_AUTOSELECT = HlsPlaylistParser.compileBooleanAttrPattern("AUTOSELECT");
        REGEX_DEFAULT = HlsPlaylistParser.compileBooleanAttrPattern("DEFAULT");
        REGEX_FORCED = HlsPlaylistParser.compileBooleanAttrPattern("FORCED");
        REGEX_INDEPENDENT = HlsPlaylistParser.compileBooleanAttrPattern("INDEPENDENT");
        REGEX_GAP = HlsPlaylistParser.compileBooleanAttrPattern("GAP");
        REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
        REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
        REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    }

    public HlsPlaylistParser() {
        HlsMasterPlaylist hlsMasterPlaylist = HlsMasterPlaylist.EMPTY;
        this(hlsMasterPlaylist, null);
    }

    public HlsPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.masterPlaylist = hlsMasterPlaylist;
        this.previousMediaPlaylist = hlsMediaPlaylist;
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) {
        int n10;
        int n11 = bufferedReader.read();
        if (n11 == (n10 = 239)) {
            n11 = bufferedReader.read();
            if (n11 == (n10 = 187) && (n11 = bufferedReader.read()) == (n10 = 191)) {
                n11 = bufferedReader.read();
            } else {
                return false;
            }
        }
        n11 = HlsPlaylistParser.skipIgnorableWhitespace(bufferedReader, true, n11);
        n10 = 7;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = PLAYLIST_HEADER;
            char c10 = string2.charAt(i10);
            if (n11 != c10) {
                return false;
            }
            n11 = bufferedReader.read();
        }
        return Util.isLinebreak(HlsPlaylistParser.skipIgnorableWhitespace(bufferedReader, false, n11));
    }

    private static Pattern compileBooleanAttrPattern(String string2) {
        int n10 = String.valueOf(string2).length() + 9;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append(string2);
        stringBuilder.append("=(");
        stringBuilder.append(BOOLEAN_FALSE);
        stringBuilder.append("|");
        stringBuilder.append(BOOLEAN_TRUE);
        stringBuilder.append(")");
        return Pattern.compile(stringBuilder.toString());
    }

    private static DrmInitData getPlaylistProtectionSchemes(String string2, DrmInitData$SchemeData[] object) {
        int n10;
        int n11 = ((DrmInitData$SchemeData[])object).length;
        DrmInitData$SchemeData[] drmInitData$SchemeDataArray = new DrmInitData$SchemeData[n11];
        for (int i10 = 0; i10 < (n10 = ((DrmInitData$SchemeData[])object).length); ++i10) {
            DrmInitData$SchemeData drmInitData$SchemeData;
            drmInitData$SchemeDataArray[i10] = drmInitData$SchemeData = object[i10].copyWithData(null);
        }
        object = new DrmInitData(string2, drmInitData$SchemeDataArray);
        return object;
    }

    private static String getSegmentEncryptionIV(long l10, String string2, String string3) {
        if (string2 == null) {
            return null;
        }
        if (string3 != null) {
            return string3;
        }
        return Long.toHexString(l10);
    }

    private static HlsMasterPlaylist$Variant getVariantWithAudioGroup(ArrayList arrayList, String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            HlsMasterPlaylist$Variant hlsMasterPlaylist$Variant = (HlsMasterPlaylist$Variant)arrayList.get(i10);
            String string3 = hlsMasterPlaylist$Variant.audioGroupId;
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return hlsMasterPlaylist$Variant;
        }
        return null;
    }

    private static HlsMasterPlaylist$Variant getVariantWithSubtitleGroup(ArrayList arrayList, String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            HlsMasterPlaylist$Variant hlsMasterPlaylist$Variant = (HlsMasterPlaylist$Variant)arrayList.get(i10);
            String string3 = hlsMasterPlaylist$Variant.subtitleGroupId;
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return hlsMasterPlaylist$Variant;
        }
        return null;
    }

    private static HlsMasterPlaylist$Variant getVariantWithVideoGroup(ArrayList arrayList, String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            HlsMasterPlaylist$Variant hlsMasterPlaylist$Variant = (HlsMasterPlaylist$Variant)arrayList.get(i10);
            String string3 = hlsMasterPlaylist$Variant.videoGroupId;
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return hlsMasterPlaylist$Variant;
        }
        return null;
    }

    private static double parseDoubleAttr(String string2, Pattern pattern) {
        Map map = Collections.emptyMap();
        return Double.parseDouble(HlsPlaylistParser.parseStringAttr(string2, pattern, map));
    }

    private static DrmInitData$SchemeData parseDrmSchemeData(String object, String object2, Map object3) {
        Object object4 = REGEX_KEYFORMATVERSIONS;
        String string2 = "1";
        object4 = HlsPlaylistParser.parseOptionalStringAttr((String)object, (Pattern)object4, string2, (Map)object3);
        String string3 = KEYFORMAT_WIDEVINE_PSSH_BINARY;
        boolean bl2 = string3.equals(object2);
        int n10 = 44;
        String string4 = "video/mp4";
        if (bl2) {
            object2 = REGEX_URI;
            object = HlsPlaylistParser.parseStringAttr((String)object, (Pattern)object2, (Map)object3);
            object3 = C.WIDEVINE_UUID;
            int n11 = ((String)object).indexOf(n10);
            object = Base64.decode((String)((String)object).substring(n11), (int)0);
            object2 = new DrmInitData$SchemeData((UUID)object3, string4, (byte[])object);
            return object2;
        }
        string3 = KEYFORMAT_WIDEVINE_PSSH_JSON;
        bl2 = string3.equals(object2);
        if (bl2) {
            object3 = C.WIDEVINE_UUID;
            object = Util.getUtf8Bytes((String)object);
            object2 = new DrmInitData$SchemeData((UUID)object3, "hls", (byte[])object);
            return object2;
        }
        string3 = KEYFORMAT_PLAYREADY;
        int n12 = string3.equals(object2);
        if (n12 != 0 && (n12 = string2.equals(object4)) != 0) {
            object2 = REGEX_URI;
            object = HlsPlaylistParser.parseStringAttr((String)object, (Pattern)object2, (Map)object3);
            n12 = ((String)object).indexOf(n10);
            object = Base64.decode((String)((String)object).substring(n12), (int)0);
            object2 = C.PLAYREADY_UUID;
            object = PsshAtomUtil.buildPsshAtom((UUID)object2, (byte[])object);
            object3 = new DrmInitData$SchemeData((UUID)object2, string4, (byte[])object);
            return object3;
        }
        return null;
    }

    private static String parseEncryptionScheme(String string2) {
        boolean bl2;
        String string3 = METHOD_SAMPLE_AES_CENC;
        boolean bl3 = string3.equals(string2);
        string2 = !bl3 && !(bl2 = (string3 = METHOD_SAMPLE_AES_CTR).equals(string2)) ? "cbcs" : "cenc";
        return string2;
    }

    private static int parseIntAttr(String string2, Pattern pattern) {
        Map map = Collections.emptyMap();
        return Integer.parseInt(HlsPlaylistParser.parseStringAttr(string2, pattern, map));
    }

    private static long parseLongAttr(String string2, Pattern pattern) {
        Map map = Collections.emptyMap();
        return Long.parseLong(HlsPlaylistParser.parseStringAttr(string2, pattern, map));
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static HlsMasterPlaylist parseMasterPlaylist(HlsPlaylistParser$LineIterator var0, String var1_1) {
        block54: {
            var2_2 = var1_1;
            var3_3 = new HashMap();
            var4_4 = new HashMap<Metadata$Entry[], Object>();
            var5_5 = new ArrayList<ArrayList<Object>>();
            var6_6 = new ArrayList();
            var7_7 = new ArrayList();
            var8_8 /* !! */  = new ArrayList();
            var9_9 = new ArrayList();
            var10_10 = new ArrayList();
            var11_11 = new ArrayList();
            var12_12 = new ArrayList();
            var13_13 = 0;
            var14_14 = 0.0f;
            var15_15 = null;
            var16_16 = 0;
            var17_17 = null;
            while (true) {
                block57: {
                    block59: {
                        block58: {
                            block56: {
                                block55: {
                                    var18_18 = var0.hasNext();
                                    var19_19 /* !! */  = "application/x-mpegURL";
                                    if (var18_18 == 0) break block54;
                                    var20_20 = var0.next();
                                    var22_22 = var20_20.startsWith((String)(var21_21 = "#EXT"));
                                    if (var22_22) {
                                        var12_12.add(var20_20);
                                    }
                                    var21_21 = "#EXT-X-I-FRAME-STREAM-INF";
                                    var22_22 = var20_20.startsWith((String)var21_21);
                                    var23_23 = var13_13;
                                    var24_24 = var14_14;
                                    var15_15 = "#EXT-X-DEFINE";
                                    var13_13 = var20_20.startsWith((String)var15_15);
                                    if (var13_13 == 0) break block55;
                                    var21_21 = HlsPlaylistParser.REGEX_NAME;
                                    var21_21 = HlsPlaylistParser.parseStringAttr((String)var20_20, (Pattern)var21_21, var4_4);
                                    var15_15 = HlsPlaylistParser.REGEX_VALUE;
                                    var15_15 = HlsPlaylistParser.parseStringAttr((String)var20_20, (Pattern)var15_15, var4_4);
                                    var4_4.put((Metadata$Entry[])var21_21, var15_15);
                                    ** GOTO lbl-1000
                                }
                                var15_15 = "#EXT-X-INDEPENDENT-SEGMENTS";
                                var13_13 = var20_20.equals(var15_15);
                                if (var13_13 == 0) break block56;
                                var2_2 = var3_3;
                                var25_25 = var10_10;
                                var26_26 = var6_6;
                                var27_27 = var7_7;
                                var28_28 = var8_8 /* !! */ ;
                                var29_29 = var9_9;
                                var30_30 = var12_12;
                                var31_31 = var11_11;
                                var13_13 = 1;
                                var14_14 = 1.4E-45f;
                                break block57;
                            }
                            var15_15 = "#EXT-X-MEDIA";
                            var13_13 = var20_20.startsWith((String)var15_15);
                            if (var13_13 == 0) break block58;
                            var10_10.add(var20_20);
                            ** GOTO lbl-1000
                        }
                        var15_15 = "#EXT-X-SESSION-KEY";
                        var13_13 = var20_20.startsWith((String)var15_15);
                        if (var13_13 == 0) break block59;
                        var21_21 = HlsPlaylistParser.REGEX_KEYFORMAT;
                        var15_15 = "identity";
                        var21_21 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, (Pattern)var21_21, (String)var15_15, var4_4);
                        if ((var21_21 = HlsPlaylistParser.parseDrmSchemeData((String)var20_20, (String)var21_21, var4_4)) != null) {
                            var15_15 = HlsPlaylistParser.REGEX_METHOD;
                            var15_15 = HlsPlaylistParser.parseEncryptionScheme(HlsPlaylistParser.parseStringAttr((String)var20_20, (Pattern)var15_15, var4_4));
                            var32_32 = 1;
                            var33_33 = 1.4E-45f;
                            var19_19 /* !! */  = new DrmInitData$SchemeData[var32_32];
                            var19_19 /* !! */ [0] = var21_21;
                            var20_20 = new DrmInitData((String)var15_15, var19_19 /* !! */ );
                            var11_11.add(var20_20);
                        }
                        ** GOTO lbl-1000
                    }
                    var15_15 = "#EXT-X-STREAM-INF";
                    var13_13 = var20_20.startsWith((String)var15_15);
                    if (var13_13 == 0 && !var22_22) lbl-1000:
                    // 4 sources

                    {
                        var2_2 = var3_3;
                        var25_25 = var10_10;
                        var26_26 = var6_6;
                        var27_27 = var7_7;
                        var28_28 = var8_8 /* !! */ ;
                        var29_29 = var9_9;
                        var30_30 = var12_12;
                        var31_31 = var11_11;
                        var13_13 = var23_23;
                        var14_14 = var24_24;
                    } else {
                        var15_15 = "CLOSED-CAPTIONS=NONE";
                        var13_13 = var20_20.contains((CharSequence)var15_15);
                        var16_16 |= var13_13;
                        if (var22_22) {
                            var13_13 = 16384;
                            var14_14 = 2.2959E-41f;
                            var34_34 = var16_16;
                        } else {
                            var34_34 = var16_16;
                            var13_13 = 0;
                            var14_14 = 0.0f;
                            var15_15 = null;
                        }
                        var17_17 = HlsPlaylistParser.REGEX_BANDWIDTH;
                        var16_16 = HlsPlaylistParser.parseIntAttr((String)var20_20, (Pattern)var17_17);
                        var31_31 = var11_11;
                        var11_11 = HlsPlaylistParser.REGEX_AVERAGE_BANDWIDTH;
                        var29_29 = var9_9;
                        var35_35 = -1;
                        var36_36 = HlsPlaylistParser.parseOptionalIntAttr((String)var20_20, (Pattern)var11_11, var35_35);
                        var9_9 = HlsPlaylistParser.REGEX_CODECS;
                        var9_9 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, (Pattern)var9_9, var4_4);
                        var30_30 = var12_12;
                        var12_12 = HlsPlaylistParser.REGEX_RESOLUTION;
                        var12_12 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, var12_12, var4_4);
                        if (var12_12 != null) {
                            var28_28 = var8_8 /* !! */ ;
                            var8_8 /* !! */  = Util.split((String)var12_12, "x");
                            var12_12 = null;
                            var37_37 /* !! */  = var8_8 /* !! */ [0];
                            var38_38 = Integer.parseInt((String)var37_37 /* !! */ );
                            var39_39 = 1;
                            var8_8 /* !! */  = var8_8 /* !! */ [var39_39];
                            var40_40 = Integer.parseInt((String)var8_8 /* !! */ );
                            if (var38_38 > 0 && var40_40 > 0) {
                                var41_41 = var38_38;
                            } else {
                                var40_40 = -1;
                                var41_41 = -1;
                                var42_42 = 0.0f / 0.0f;
                            }
                            var38_38 = var40_40;
                            var40_40 = var41_41;
                        } else {
                            var28_28 = var8_8 /* !! */ ;
                            var40_40 = -1;
                            var38_38 = -1;
                        }
                        var41_41 = -1082130432;
                        var42_42 = -1.0f;
                        var27_27 = var7_7;
                        var7_7 = HlsPlaylistParser.REGEX_FRAME_RATE;
                        var7_7 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, (Pattern)var7_7, var4_4);
                        if (var7_7 != null) {
                            var42_42 = Float.parseFloat((String)var7_7);
                        }
                        var26_26 = var6_6;
                        var43_43 = var42_42;
                        var6_6 = HlsPlaylistParser.REGEX_VIDEO;
                        var6_6 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, (Pattern)var6_6, var4_4);
                        var25_25 = var10_10;
                        var10_10 = HlsPlaylistParser.REGEX_AUDIO;
                        var10_10 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, var10_10, var4_4);
                        var44_44 = var3_3;
                        var3_3 = HlsPlaylistParser.REGEX_SUBTITLES;
                        var45_45 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, (Pattern)var3_3, var4_4);
                        var3_3 = HlsPlaylistParser.REGEX_CLOSED_CAPTIONS;
                        var3_3 = HlsPlaylistParser.parseOptionalStringAttr((String)var20_20, (Pattern)var3_3, var4_4);
                        if (var22_22) {
                            var21_21 = HlsPlaylistParser.REGEX_URI;
                            var21_21 = HlsPlaylistParser.parseStringAttr((String)var20_20, (Pattern)var21_21, var4_4);
                            var21_21 = UriUtil.resolveToUri((String)var2_2, (String)var21_21);
                        } else {
                            var22_22 = var0.hasNext();
                            if (!var22_22) break;
                            var21_21 = HlsPlaylistParser.replaceVariableReferences(var0.next(), var4_4);
                            var21_21 = UriUtil.resolveToUri((String)var2_2, (String)var21_21);
                        }
                        var20_20 = new Format$Builder();
                        var46_46 = var5_5.size();
                        var47_47 = var20_20.setId(var46_46).setContainerMimeType((String)var19_19 /* !! */ ).setCodecs((String)var9_9).setAverageBitrate(var36_36).setPeakBitrate(var16_16).setWidth(var40_40).setHeight(var38_38).setFrameRate(var43_43).setRoleFlags(var13_13).build();
                        var37_37 /* !! */  = var2_2;
                        var48_48 /* !! */  = var21_21;
                        var2_2 = new ArrayList<Object>(var21_21, var47_47, (String)var6_6, (String)var10_10, var45_45, (String)var3_3);
                        var5_5.add(var2_2);
                        var2_2 = var44_44;
                        var7_7 = (ArrayList)var44_44.get(var21_21);
                        if (var7_7 == null) {
                            var7_7 = new ArrayList();
                            var44_44.put(var21_21, var7_7);
                        }
                        var37_37 /* !! */  = var8_8 /* !! */ ;
                        var8_8 /* !! */  = new HlsTrackMetadataEntry$VariantInfo(var36_36, var16_16, (String)var6_6, (String)var10_10, var45_45, (String)var3_3);
                        var7_7.add(var8_8 /* !! */ );
                        var13_13 = var23_23;
                        var14_14 = var24_24;
                        var16_16 = var34_34;
                    }
                }
                var3_3 = var2_2;
                var11_11 = var31_31;
                var9_9 = var29_29;
                var12_12 = var30_30;
                var8_8 /* !! */  = var28_28;
                var7_7 = var27_27;
                var6_6 = var26_26;
                var10_10 = var25_25;
                var2_2 = var1_1;
            }
            var3_3 = new ParserException("#EXT-X-STREAM-INF must be followed by another line");
            throw var3_3;
        }
        var2_2 = var3_3;
        var25_25 = var10_10;
        var26_26 = var6_6;
        var27_27 = var7_7;
        var28_28 = var8_8 /* !! */ ;
        var29_29 = var9_9;
        var30_30 = var12_12;
        var23_23 = var13_13;
        var24_24 = var14_14;
        var31_31 = var11_11;
        var10_10 = new ArrayList();
        var3_3 = new HashSet();
        var49_49 = 0;
        var50_50 = 0.0f;
        var6_6 = null;
        while (true) {
            var51_51 = var5_5.size();
            var40_40 = 0;
            var8_8 /* !! */  = null;
            if (var49_49 >= var51_51) break;
            var7_7 = (HlsMasterPlaylist$Variant)var5_5.get(var49_49);
            var9_9 = var7_7.url;
            var35_35 = var3_3.add(var9_9);
            if (var35_35 != 0) {
                var9_9 = var7_7.format.metadata;
                if (var9_9 == null) {
                    var35_35 = 1;
                } else {
                    var35_35 = 0;
                    var9_9 = null;
                }
                Assertions.checkState((boolean)var35_35);
                var12_12 = var7_7.url;
                var12_12 = (List)Assertions.checkNotNull((ArrayList)var2_2.get(var12_12));
                var9_9 = new HlsTrackMetadataEntry(null, null, (List)var12_12);
                var21_21 = new Metadata$Entry[1];
                var38_38 = 0;
                var12_12 = null;
                var21_21[0] = var9_9;
                var8_8 /* !! */  = new Metadata((Metadata$Entry[])var21_21);
                var9_9 = var7_7.format.buildUpon();
                var8_8 /* !! */  = var9_9.setMetadata((Metadata)var8_8 /* !! */ ).build();
                var7_7 = var7_7.copyWithFormat((Format)var8_8 /* !! */ );
                var10_10.add(var7_7);
            }
            ++var49_49;
        }
        var46_46 = 0;
        var2_2 = null;
        var38_38 = 0;
        var12_12 = null;
        var3_3 = null;
        for (var52_52 = 0; var52_52 < (var49_49 = var25_25.size()); ++var52_52) {
            block60: {
                var6_6 = var25_25;
                var7_7 = (String)var25_25.get(var52_52);
                var9_9 = HlsPlaylistParser.REGEX_GROUP_ID;
                var9_9 = HlsPlaylistParser.parseStringAttr((String)var7_7, (Pattern)var9_9, var4_4);
                var21_21 = HlsPlaylistParser.REGEX_NAME;
                var21_21 = HlsPlaylistParser.parseStringAttr((String)var7_7, (Pattern)var21_21, var4_4);
                var15_15 = new Format$Builder();
                var36_36 = String.valueOf(var9_9).length() + 1;
                var18_18 = String.valueOf(var21_21).length();
                var20_20 = new StringBuilder(var36_36 += var18_18);
                var20_20.append((String)var9_9);
                var20_20.append(":");
                var20_20.append((String)var21_21);
                var11_11 = var20_20.toString();
                var15_15 = var15_15.setId((String)var11_11).setLabel((String)var21_21).setContainerMimeType((String)var19_19 /* !! */ );
                var36_36 = HlsPlaylistParser.parseSelectionFlags((String)var7_7);
                var15_15 = var15_15.setSelectionFlags(var36_36);
                var36_36 = HlsPlaylistParser.parseRoleFlags((String)var7_7, var4_4);
                var15_15 = var15_15.setRoleFlags(var36_36);
                var11_11 = HlsPlaylistParser.REGEX_LANGUAGE;
                var11_11 = HlsPlaylistParser.parseOptionalStringAttr((String)var7_7, (Pattern)var11_11, var4_4);
                var15_15 = var15_15.setLanguage((String)var11_11);
                var11_11 = HlsPlaylistParser.REGEX_URI;
                var11_11 = HlsPlaylistParser.parseOptionalStringAttr((String)var7_7, (Pattern)var11_11, var4_4);
                var20_20 = var1_1;
                if (var11_11 == null) {
                    var36_36 = 0;
                    var11_11 = null;
                } else {
                    var11_11 = UriUtil.resolveToUri(var1_1, (String)var11_11);
                }
                var25_25 = var6_6;
                var49_49 = 1;
                var50_50 = 1.4E-45f;
                var20_20 = new Metadata$Entry[var49_49];
                var53_53 = var19_19 /* !! */ ;
                var19_19 /* !! */  = Collections.emptyList();
                var6_6 = new HlsTrackMetadataEntry((String)var9_9, (String)var21_21, (List)var19_19 /* !! */ );
                var19_19 /* !! */  = null;
                var20_20[0] = var6_6;
                var8_8 /* !! */  = new Metadata((Metadata$Entry[])var20_20);
                var6_6 = HlsPlaylistParser.REGEX_TYPE;
                var6_6 = HlsPlaylistParser.parseStringAttr((String)var7_7, (Pattern)var6_6, var4_4);
                var6_6.hashCode();
                var18_18 = var6_6.hashCode();
                var32_32 = 2;
                var33_33 = 2.8E-45f;
                switch (var18_18) lbl-1000:
                // 5 sources

                {
                    default: {
                        var49_49 = -1;
                        var50_50 = 0.0f / 0.0f;
                        break;
                    }
                    case 81665115: {
                        var20_20 = "VIDEO";
                        var49_49 = (int)var6_6.equals(var20_20);
                        if (var49_49 == 0) ** GOTO lbl-1000
                        var49_49 = 3;
                        var50_50 = 4.2E-45f;
                        break;
                    }
                    case 62628790: {
                        var20_20 = "AUDIO";
                        var49_49 = (int)var6_6.equals(var20_20);
                        if (var49_49 == 0) ** GOTO lbl-1000
                        var49_49 = var32_32;
                        var50_50 = var33_33;
                        break;
                    }
                    case -333210994: {
                        var20_20 = "CLOSED-CAPTIONS";
                        var49_49 = (int)var6_6.equals(var20_20);
                        if (var49_49 == 0) ** GOTO lbl-1000
                        var49_49 = 1;
                        var50_50 = 1.4E-45f;
                        break;
                    }
                    case -959297733: {
                        var20_20 = "SUBTITLES";
                        var49_49 = (int)var6_6.equals(var20_20);
                        if (var49_49 == 0) ** GOTO lbl-1000
                        var49_49 = 0;
                        var50_50 = 0.0f;
                        var6_6 = null;
                    }
                }
                switch (var49_49) lbl-1000:
                // 2 sources

                {
                    default: {
                        var48_48 /* !! */  = var12_12;
                        var8_8 /* !! */  = var28_28;
                        var12_12 = var27_27;
                        var20_20 = var26_26;
                        break block60;
                    }
                    case 3: {
                        var6_6 = HlsPlaylistParser.getVariantWithVideoGroup(var5_5, (String)var9_9);
                        if (var6_6 != null) {
                            var6_6 = var6_6.format;
                            var7_7 = Util.getCodecsOfType(var6_6.codecs, var32_32);
                            var20_20 = var15_15.setCodecs((String)var7_7);
                            var7_7 = MimeTypes.getMediaMimeType(var7_7);
                            var7_7 = var20_20.setSampleMimeType((String)var7_7);
                            var18_18 = var6_6.width;
                            var7_7 = var7_7.setWidth(var18_18);
                            var18_18 = var6_6.height;
                            var7_7 = var7_7.setHeight(var18_18);
                            var50_50 = var6_6.frameRate;
                            var7_7.setFrameRate(var50_50);
                        }
                        if (var11_11 == null) ** GOTO lbl-1000
                        var15_15.setMetadata((Metadata)var8_8 /* !! */ );
                        var7_7 = var15_15.build();
                        var6_6 = new HlsMasterPlaylist$Rendition((Uri)var11_11, (Format)var7_7, (String)var9_9, (String)var21_21);
                        var20_20 = var26_26;
                        var26_26.add(var6_6);
                        var48_48 /* !! */  = var12_12;
                        var8_8 /* !! */  = var28_28;
                        var12_12 = var27_27;
                        break block60;
                    }
                    case 2: {
                        var20_20 = var26_26;
                        var6_6 = HlsPlaylistParser.getVariantWithAudioGroup(var5_5, (String)var9_9);
                        if (var6_6 != null) {
                            var19_19 /* !! */  = var6_6.format.codecs;
                            var48_48 /* !! */  = var12_12;
                            var38_38 = 1;
                            var19_19 /* !! */  = Util.getCodecsOfType((String)var19_19 /* !! */ , var38_38);
                            var15_15.setCodecs((String)var19_19 /* !! */ );
                            var19_19 /* !! */  = MimeTypes.getMediaMimeType((String)var19_19 /* !! */ );
                        } else {
                            var48_48 /* !! */  = var12_12;
                            var32_32 = 0;
                            var33_33 = 0.0f;
                            var19_19 /* !! */  = null;
                        }
                        var12_12 = HlsPlaylistParser.REGEX_CHANNELS;
                        var7_7 = HlsPlaylistParser.parseOptionalStringAttr(var7_7, (Pattern)var12_12, var4_4);
                        if (var7_7 != null) {
                            var38_38 = Integer.parseInt(Util.splitAtFirst((String)var7_7, "/")[0]);
                            var15_15.setChannelCount(var38_38);
                            var12_12 = "audio/eac3";
                            var38_38 = (int)var12_12.equals(var19_19 /* !! */ );
                            if (var38_38 != 0 && (var51_51 = (int)var7_7.endsWith((String)(var12_12 = "/JOC"))) != 0) {
                                var19_19 /* !! */  = "audio/eac3-joc";
                            }
                        }
                        var15_15.setSampleMimeType((String)var19_19 /* !! */ );
                        if (var11_11 != null) {
                            var15_15.setMetadata((Metadata)var8_8 /* !! */ );
                            var7_7 = var15_15.build();
                            var6_6 = new HlsMasterPlaylist$Rendition((Uri)var11_11, (Format)var7_7, (String)var9_9, (String)var21_21);
                            var12_12 = var27_27;
                            var27_27.add(var6_6);
                        } else {
                            var12_12 = var27_27;
                            if (var6_6 != null) {
                                var6_6 = var15_15.build();
                                var48_48 /* !! */  = var6_6;
                            }
                        }
                        ** GOTO lbl440
                    }
                    case 1: {
                        var48_48 /* !! */  = var12_12;
                        var12_12 = var27_27;
                        var20_20 = var26_26;
                        var6_6 = HlsPlaylistParser.REGEX_INSTREAM_ID;
                        var6_6 = HlsPlaylistParser.parseStringAttr((String)var7_7, (Pattern)var6_6, var4_4);
                        var7_7 = "CC";
                        var51_51 = (int)var6_6.startsWith((String)var7_7);
                        if (var51_51 != 0) {
                            var6_6 = var6_6.substring(var32_32);
                            var49_49 = Integer.parseInt((String)var6_6);
                            var7_7 = "application/cea-608";
                        } else {
                            var51_51 = 7;
                            var43_43 = 9.8E-45f;
                            var6_6 = var6_6.substring(var51_51);
                            var49_49 = Integer.parseInt((String)var6_6);
                            var7_7 = "application/cea-708";
                        }
                        if (var2_2 == null) {
                            var2_2 = new ArrayList<Object>();
                        }
                        var7_7 = var15_15.setSampleMimeType((String)var7_7);
                        var7_7.setAccessibilityChannel(var49_49);
                        var6_6 = var15_15.build();
                        var2_2.add(var6_6);
lbl440:
                        // 3 sources

                        var8_8 /* !! */  = var28_28;
                        break block60;
                    }
                    case 0: 
                }
                var48_48 /* !! */  = var12_12;
                var12_12 = var27_27;
                var20_20 = var26_26;
                var6_6 = HlsPlaylistParser.getVariantWithSubtitleGroup(var5_5, (String)var9_9);
                if (var6_6 != null) {
                    var6_6 = var6_6.format.codecs;
                    var51_51 = 3;
                    var43_43 = 4.2E-45f;
                    var6_6 = Util.getCodecsOfType((String)var6_6, var51_51);
                    var15_15.setCodecs((String)var6_6);
                    var6_6 = MimeTypes.getMediaMimeType((String)var6_6);
                } else {
                    var49_49 = 0;
                    var50_50 = 0.0f;
                    var6_6 = null;
                }
                if (var6_6 == null) {
                    var6_6 = "text/vtt";
                }
                var6_6 = var15_15.setSampleMimeType((String)var6_6);
                var6_6.setMetadata((Metadata)var8_8 /* !! */ );
                if (var11_11 != null) {
                    var7_7 = var15_15.build();
                    var6_6 = new HlsMasterPlaylist$Rendition((Uri)var11_11, (Format)var7_7, (String)var9_9, (String)var21_21);
                    var8_8 /* !! */  = var28_28;
                    var28_28.add(var6_6);
                } else {
                    var8_8 /* !! */  = var28_28;
                    var6_6 = "HlsPlaylistParser";
                    var7_7 = "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping";
                    Log.w((String)var6_6, (String)var7_7);
                }
            }
            var28_28 = var8_8 /* !! */ ;
            var27_27 = var12_12;
            var26_26 = var20_20;
            var19_19 /* !! */  = var53_53;
            var12_12 = var48_48 /* !! */ ;
            var40_40 = 0;
            var8_8 /* !! */  = null;
        }
        var48_48 /* !! */  = var12_12;
        var8_8 /* !! */  = var28_28;
        var12_12 = var27_27;
        var20_20 = var26_26;
        if (var16_16 != 0) {
            var3_3 = Collections.emptyList();
            var21_21 = var3_3;
        } else {
            var21_21 = var2_2;
        }
        var3_3 = var17_17;
        var2_2 = var1_1;
        var5_5 = var30_30;
        var6_6 = var20_20;
        var7_7 = var12_12;
        var9_9 = var29_29;
        var12_12 = var48_48 /* !! */ ;
        var13_13 = var23_23;
        var14_14 = var24_24;
        var11_11 = var31_31;
        var17_17 = new HlsMasterPlaylist(var1_1, (List)var30_30, (List)var10_10, (List)var20_20, (List)var7_7, (List)var8_8 /* !! */ , (List)var29_29, (Format)var48_48 /* !! */ , (List)var21_21, (boolean)var23_23, var4_4, var31_31);
        return var17_17;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static HlsMediaPlaylist parseMediaPlaylist(HlsMasterPlaylist var0, HlsMediaPlaylist var1_1, HlsPlaylistParser$LineIterator var2_2, String var3_3) {
        var4_4 = var0;
        var5_5 /* !! */  = var1_1;
        var6_6 = var0.hasIndependentSegments;
        var7_7 /* !! */  = new HashMap();
        var8_8 = new HashMap();
        var9_9 = new ArrayList<Object>();
        var10_10 = new ArrayList<DrmInitData$SchemeData[]>();
        var11_11 /* !! */  = new HashMap();
        var12_12 /* !! */  = new ArrayList();
        var14_14 = -9223372036854775807L;
        var16_15 = -9223372036854775807L;
        var13_13 = new HlsMediaPlaylist$ServerControl(-9223372036854775807L, false, var14_14, var16_15, false);
        var18_16 = new TreeMap();
        var19_17 /* !! */  = "";
        var20_18 = 0L;
        var22_19 = var6_6;
        var23_20 = var13_13;
        var24_21 = var19_17 /* !! */ ;
        var25_22 = 0;
        var26_23 = null;
        var27_24 = 0;
        var28_25 = null;
        var29_26 = null;
        var30_27 = 0;
        var31_28 /* !! */  = null;
        var32_29 = null;
        var33_30 = null;
        var34_31 = null;
        var35_32 = var20_18;
        var37_33 = var20_18;
        var39_34 = var20_18;
        var41_35 = var20_18;
        var43_36 = var20_18;
        var45_37 = var20_18;
        var47_38 = var20_18;
        var49_39 = var20_18;
        var6_6 = 0;
        var51_40 = 0.0f;
        var52_41 = null;
        var53_42 = 0;
        var54_43 = 0.0f;
        var13_13 = null;
        var55_44 = -9223372036854775807L;
        var57_45 = 0;
        var58_46 = 1;
        var59_47 = -9223372036854775807L;
        var61_48 = -9223372036854775807L;
        var63_49 = false;
        var64_50 = false;
        var65_51 = -1;
        var67_52 = 0;
        var68_53 = false;
        block0: while (var69_54 = var2_2.hasNext()) {
            block71: {
                block81: {
                    block80: {
                        block79: {
                            block78: {
                                block77: {
                                    block76: {
                                        block75: {
                                            block74: {
                                                block72: {
                                                    block66: {
                                                        block73: {
                                                            block69: {
                                                                block70: {
                                                                    block68: {
                                                                        block67: {
                                                                            var70_55 = var2_2.next();
                                                                            var72_57 = var70_55.startsWith((String)(var71_56 = "#EXT"));
                                                                            if (var72_57 != 0) {
                                                                                var12_12 /* !! */ .add(var70_55);
                                                                            }
                                                                            if ((var72_57 = var70_55.startsWith((String)(var71_56 = "#EXT-X-PLAYLIST-TYPE"))) != 0) {
                                                                                var71_56 = HlsPlaylistParser.REGEX_PLAYLIST_TYPE;
                                                                                var70_55 = "VOD";
                                                                                var73_58 = var70_55.equals(var71_56 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var71_56, var7_7 /* !! */ ));
                                                                                if (var73_58 != 0) {
                                                                                    var53_42 = 1;
                                                                                    var54_43 = 1.4E-45f;
                                                                                    continue;
                                                                                }
                                                                                var70_55 = "EVENT";
                                                                                var72_57 = var70_55.equals(var71_56);
                                                                                if (var72_57 == 0) continue;
                                                                                var53_42 = 2;
                                                                                var54_43 = 2.8E-45f;
                                                                                continue;
                                                                            }
                                                                            var71_56 = "#EXT-X-I-FRAMES-ONLY";
                                                                            var72_57 = var70_55.equals(var71_56);
                                                                            if (var72_57 != 0) {
                                                                                var68_53 = true;
                                                                                continue;
                                                                            }
                                                                            var71_56 = "#EXT-X-START";
                                                                            var72_57 = var70_55.startsWith((String)var71_56);
                                                                            var74_59 = 4696837146684686336L;
                                                                            var76_60 = 1000000.0;
                                                                            if (var72_57 != 0) {
                                                                                var71_56 = HlsPlaylistParser.REGEX_TIME_OFFSET;
                                                                                var78_61 = HlsPlaylistParser.parseDoubleAttr((String)var70_55, (Pattern)var71_56) * var76_60;
                                                                                var55_44 = var80_62 = (long)var78_61;
                                                                                continue;
                                                                            }
                                                                            var71_56 = "#EXT-X-SERVER-CONTROL";
                                                                            var72_57 = var70_55.startsWith((String)var71_56);
                                                                            if (var72_57 != 0) {
                                                                                var23_20 = HlsPlaylistParser.parseServerControl((String)var70_55);
                                                                                continue;
                                                                            }
                                                                            var71_56 = "#EXT-X-PART-INF";
                                                                            var72_57 = var70_55.startsWith((String)var71_56);
                                                                            if (var72_57 != 0) {
                                                                                var71_56 = HlsPlaylistParser.REGEX_PART_TARGET_DURATION;
                                                                                var78_61 = HlsPlaylistParser.parseDoubleAttr((String)var70_55, (Pattern)var71_56) * var76_60;
                                                                                var61_48 = var80_62 = (long)var78_61;
                                                                                continue;
                                                                            }
                                                                            var71_56 = "#EXT-X-MAP";
                                                                            var72_57 = var70_55.startsWith((String)var71_56);
                                                                            var82_63 = var6_6;
                                                                            var83_64 = var51_40;
                                                                            var52_41 = "@";
                                                                            if (var72_57 != 0) {
                                                                                var71_56 = HlsPlaylistParser.REGEX_URI;
                                                                                var84_65 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var71_56, var7_7 /* !! */ );
                                                                                var71_56 = HlsPlaylistParser.REGEX_ATTR_BYTERANGE;
                                                                                if ((var71_56 = HlsPlaylistParser.parseOptionalStringAttr((String)var70_55, (Pattern)var71_56, var7_7 /* !! */ )) != null) {
                                                                                    var52_41 = Util.split((String)var71_56, (String)var52_41);
                                                                                    var71_56 = null;
                                                                                    var70_55 = var52_41[0];
                                                                                    var85_66 = var80_62 = Long.parseLong((String)var70_55);
                                                                                    var72_57 = ((String[])var52_41).length;
                                                                                    var73_58 = 1;
                                                                                    if (var72_57 > var73_58) {
                                                                                        var52_41 = var52_41[var73_58];
                                                                                        var80_62 = Long.parseLong((String)var52_41);
                                                                                        var87_67 = var85_66;
                                                                                        var85_66 = var80_62;
                                                                                    } else {
                                                                                        var87_67 = var80_62;
                                                                                        var85_66 = var39_34;
                                                                                    }
                                                                                } else {
                                                                                    var85_66 = var39_34;
                                                                                    var87_67 = var65_51;
                                                                                }
                                                                                if (var26_23 != null && var28_25 == null) {
                                                                                    var4_4 = new ParserException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                                                                                    throw var4_4;
                                                                                }
                                                                                var89_68 = var34_31;
                                                                                var34_31 = new HlsMediaPlaylist$Segment((String)var84_65, var85_66, var87_67, (String)var26_23, (String)var28_25);
                                                                                var39_34 = var20_18;
                                                                                var6_6 = var82_63;
                                                                                var51_40 = var83_64;
                                                                                var65_51 = -1;
                                                                                continue;
                                                                            }
                                                                            var71_56 = "#EXT-X-TARGETDURATION";
                                                                            var72_57 = var70_55.startsWith((String)var71_56);
                                                                            if (var72_57 != 0) {
                                                                                var52_41 = HlsPlaylistParser.REGEX_TARGET_DURATION;
                                                                                var6_6 = HlsPlaylistParser.parseIntAttr((String)var70_55, (Pattern)var52_41);
                                                                                var80_62 = var6_6;
                                                                                var59_47 = 1000000L * var80_62;
lbl143:
                                                                                // 3 sources

                                                                                while (true) {
                                                                                    var6_6 = var82_63;
                                                                                    var51_40 = var83_64;
                                                                                    continue block0;
                                                                                    break;
                                                                                }
                                                                            }
                                                                            var71_56 = "#EXT-X-MEDIA-SEQUENCE";
                                                                            var72_57 = var70_55.startsWith((String)var71_56);
                                                                            if (var72_57 == 0) break block67;
                                                                            var52_41 = HlsPlaylistParser.REGEX_MEDIA_SEQUENCE;
                                                                            var37_33 = var45_37 = HlsPlaylistParser.parseLongAttr((String)var70_55, (Pattern)var52_41);
                                                                            ** GOTO lbl143
                                                                        }
                                                                        var71_56 = "#EXT-X-VERSION";
                                                                        var72_57 = var70_55.startsWith((String)var71_56);
                                                                        if (var72_57 != 0) {
                                                                            var52_41 = HlsPlaylistParser.REGEX_VERSION;
                                                                            var58_46 = HlsPlaylistParser.parseIntAttr((String)var70_55, (Pattern)var52_41);
                                                                            ** continue;
                                                                        }
                                                                        var71_56 = "#EXT-X-DEFINE";
                                                                        var72_57 = var70_55.startsWith((String)var71_56);
                                                                        if (var72_57 == 0) break block68;
                                                                        var52_41 = HlsPlaylistParser.REGEX_IMPORT;
                                                                        if ((var52_41 = HlsPlaylistParser.parseOptionalStringAttr((String)var70_55, (Pattern)var52_41, var7_7 /* !! */ )) != null) {
                                                                            var71_56 = (String)var4_4.variableDefinitions.get(var52_41);
                                                                            if (var71_56 != null) {
                                                                                var7_7 /* !! */ .put(var52_41, var71_56);
                                                                            }
                                                                        } else {
                                                                            var52_41 = HlsPlaylistParser.REGEX_NAME;
                                                                            var52_41 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var52_41, var7_7 /* !! */ );
                                                                            var71_56 = HlsPlaylistParser.REGEX_VALUE;
                                                                            var71_56 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var71_56, var7_7 /* !! */ );
                                                                            var7_7 /* !! */ .put(var52_41, var71_56);
                                                                        }
                                                                        var90_69 = var7_7 /* !! */ ;
                                                                        var91_70 = var19_17 /* !! */ ;
                                                                        var71_56 = var26_23;
                                                                        var19_17 /* !! */  = var28_25;
                                                                        var92_71 = var11_11 /* !! */ ;
                                                                        var26_23 = var33_30;
                                                                        var93_72 = var45_37;
                                                                        var6_6 = 0;
                                                                        var51_40 = 0.0f;
                                                                        var52_41 = null;
                                                                        var95_73 = -1;
                                                                        var97_74 = var53_42;
                                                                        var98_75 = var54_43;
                                                                        var33_30 = var12_12 /* !! */ ;
                                                                        ** GOTO lbl667
                                                                    }
                                                                    var71_56 = "#EXTINF";
                                                                    var72_57 = (int)var70_55.startsWith((String)var71_56);
                                                                    if (var72_57 != 0) {
                                                                        var52_41 = HlsPlaylistParser.REGEX_MEDIA_DURATION;
                                                                        var99_76 = HlsPlaylistParser.parseDoubleAttr((String)var70_55, (Pattern)var52_41);
                                                                        var71_56 = var26_23;
                                                                        var101_77 = var28_25;
                                                                        var102_78 = var99_76 * var76_60;
                                                                        var104_79 = (long)var102_78;
                                                                        var52_41 = HlsPlaylistParser.REGEX_MEDIA_TITLE;
                                                                        var24_21 = HlsPlaylistParser.parseOptionalStringAttr((String)var70_55, (Pattern)var52_41, (String)var19_17 /* !! */ , var7_7 /* !! */ );
                                                                        var47_38 = var104_79;
lbl204:
                                                                        // 7 sources

                                                                        while (true) {
                                                                            var26_23 = var71_56;
                                                                            continue block0;
                                                                            break;
                                                                        }
                                                                    }
                                                                    var71_56 = var26_23;
                                                                    var101_77 = var28_25;
                                                                    var26_23 = "#EXT-X-SKIP";
                                                                    var25_22 = var70_55.startsWith((String)var26_23);
                                                                    var85_66 = 1L;
                                                                    var99_76 = 4.9E-324;
                                                                    if (var25_22 == 0) break block69;
                                                                    var52_41 = HlsPlaylistParser.REGEX_SKIPPED_SEGMENTS;
                                                                    var6_6 = HlsPlaylistParser.parseIntAttr((String)var70_55, (Pattern)var52_41);
                                                                    if (var5_5 /* !! */  != null && (var73_58 = (int)var9_9.isEmpty()) != 0) {
                                                                        var73_58 = 1;
                                                                    } else {
                                                                        var73_58 = 0;
                                                                        var70_55 = null;
                                                                    }
                                                                    Assertions.checkState((boolean)var73_58);
                                                                    var70_55 = (HlsMediaPlaylist)Util.castNonNull(var1_1);
                                                                    var106_80 = var70_55.mediaSequence;
                                                                    var106_80 = var37_33 - var106_80;
                                                                    if (var73_58 < 0 || (var6_6 += var73_58) > (var25_22 = (var26_23 = var5_5 /* !! */ .segments).size())) break block70;
                                                                    var91_70 = var19_17 /* !! */ ;
                                                                    var26_23 = var71_56;
                                                                    var108_81 = var43_36;
                                                                    var28_25 = var101_77;
                                                                    for (var73_58 = (int)var106_80; var73_58 < var6_6; ++var73_58) {
                                                                        var26_23 = (HlsMediaPlaylist$Segment)var5_5 /* !! */ .segments.get(var73_58);
                                                                        var89_68 = var28_25;
                                                                        var92_71 = var11_11 /* !! */ ;
                                                                        var93_72 = var5_5 /* !! */ .mediaSequence;
                                                                        cfr_temp_0 = var37_33 - var93_72;
                                                                        var27_24 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                        if (var27_24 != 0) {
                                                                            var27_24 = var5_5 /* !! */ .discontinuitySequence - var57_45;
                                                                            var110_82 = var26_23.relativeDiscontinuitySequence;
                                                                            var26_23 = var26_23.copyWith(var108_81, var27_24 += var110_82);
                                                                        }
                                                                        var9_9.add(var26_23);
                                                                        var93_72 = var26_23.durationUs;
                                                                        var108_81 += var93_72;
                                                                        var93_72 = var26_23.byteRangeLength;
                                                                        var87_67 = -1;
                                                                        var30_27 = var93_72 == var87_67 ? 0 : (var93_72 < var87_67 ? -1 : 1);
                                                                        if (var30_27 != 0) {
                                                                            var39_34 = var111_83 = var26_23.byteRangeOffset + var93_72;
                                                                        }
                                                                        var113_84 = var26_23.relativeDiscontinuitySequence;
                                                                        var5_5 /* !! */  = var26_23.initializationSegment;
                                                                        var28_25 = var26_23.drmInitData;
                                                                        var11_11 /* !! */  = var26_23.fullSegmentEncryptionKeyUri;
                                                                        var30_27 = var113_84;
                                                                        var4_4 = var26_23.encryptionIV;
                                                                        var84_65 = var5_5 /* !! */ ;
                                                                        var4_4 = var4_4 != null && (var113_84 = (int)var4_4.equals(var5_5 /* !! */  = Long.toHexString(var45_37))) != 0 ? var89_68 : var26_23.encryptionIV;
                                                                        var45_37 += var85_66;
                                                                        var5_5 /* !! */  = var1_1;
                                                                        var41_35 = var108_81;
                                                                        var26_23 = var11_11 /* !! */ ;
                                                                        var67_52 = var30_27;
                                                                        var34_31 = var84_65;
                                                                        var11_11 /* !! */  = var92_71;
                                                                        var31_28 /* !! */  = var28_25;
                                                                        var28_25 = var4_4;
                                                                        var4_4 = var0;
                                                                    }
                                                                    var89_68 = var28_25;
                                                                    var4_4 = var0;
                                                                    var5_5 /* !! */  = var1_1;
                                                                    var43_36 = var108_81;
                                                                    var6_6 = var82_63;
                                                                    var51_40 = var83_64;
                                                                    break block71;
                                                                }
                                                                var4_4 = new HlsPlaylistParser$DeltaUpdateException();
                                                                throw var4_4;
                                                            }
                                                            var91_70 = var19_17 /* !! */ ;
                                                            var92_71 = var11_11 /* !! */ ;
                                                            var4_4 = "#EXT-X-KEY";
                                                            var113_84 = var70_55.startsWith((String)var4_4);
                                                            if (var113_84 == 0) break block72;
                                                            var4_4 = HlsPlaylistParser.REGEX_METHOD;
                                                            var4_4 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var4_4, var7_7 /* !! */ );
                                                            var5_5 /* !! */  = HlsPlaylistParser.REGEX_KEYFORMAT;
                                                            var52_41 = "identity";
                                                            var5_5 /* !! */  = HlsPlaylistParser.parseOptionalStringAttr((String)var70_55, var5_5 /* !! */ , (String)var52_41, var7_7 /* !! */ );
                                                            var19_17 /* !! */  = "NONE";
                                                            var114_85 = var19_17 /* !! */ .equals(var4_4);
                                                            if (var114_85 == 0) break block73;
                                                            var18_16.clear();
                                                            var25_22 = 0;
                                                            var26_23 = null;
                                                            var27_24 = 0;
                                                            var28_25 = null;
                                                            var30_27 = 0;
                                                            var31_28 /* !! */  = null;
                                                            break block66;
                                                        }
                                                        var19_17 /* !! */  = HlsPlaylistParser.REGEX_IV;
                                                        var19_17 /* !! */  = HlsPlaylistParser.parseOptionalStringAttr((String)var70_55, (Pattern)var19_17 /* !! */ , var7_7 /* !! */ );
                                                        var6_6 = (int)var52_41.equals(var5_5 /* !! */ );
                                                        if (var6_6 == 0) ** GOTO lbl318
                                                        var5_5 /* !! */  = "AES-128";
                                                        var113_84 = (int)var5_5 /* !! */ .equals(var4_4);
                                                        if (var113_84 != 0) {
                                                            var4_4 = HlsPlaylistParser.REGEX_URI;
                                                            var26_23 = var4_4 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var4_4, var7_7 /* !! */ );
                                                            var28_25 = var19_17 /* !! */ ;
                                                        } else {
                                                            while (true) {
                                                                var28_25 = var19_17 /* !! */ ;
                                                                var25_22 = 0;
                                                                var26_23 = null;
                                                                break block66;
                                                                break;
                                                            }
lbl318:
                                                            // 1 sources

                                                            var26_23 = var33_30;
                                                            if (var33_30 == null) {
                                                                var33_30 = HlsPlaylistParser.parseEncryptionScheme((String)var4_4);
                                                            }
                                                            if ((var4_4 = HlsPlaylistParser.parseDrmSchemeData((String)var70_55, (String)var5_5 /* !! */ , var7_7 /* !! */ )) == null) ** continue;
                                                            var18_16.put(var5_5 /* !! */ , var4_4);
                                                            var28_25 = var19_17 /* !! */ ;
                                                            var25_22 = 0;
                                                            var26_23 = null;
                                                            var30_27 = 0;
                                                            var31_28 /* !! */  = null;
                                                        }
                                                    }
                                                    var4_4 = var0;
                                                    var5_5 /* !! */  = var1_1;
                                                    var6_6 = var82_63;
                                                    var51_40 = var83_64;
                                                    var19_17 /* !! */  = var91_70;
                                                    var11_11 /* !! */  = var92_71;
                                                    continue;
                                                }
                                                var26_23 = var33_30;
                                                var4_4 = "#EXT-X-BYTERANGE";
                                                var113_84 = var70_55.startsWith((String)var4_4);
                                                if (var113_84 == 0) break block74;
                                                var4_4 = HlsPlaylistParser.REGEX_BYTERANGE;
                                                var4_4 = Util.split(HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var4_4, var7_7 /* !! */ ), (String)var52_41);
                                                var5_5 /* !! */  = null;
                                                var52_41 = var4_4[0];
                                                var65_51 = Long.parseLong((String)var52_41);
                                                var115_86 = ((String[])var4_4).length;
                                                var114_85 = 1;
                                                if (var115_86 > var114_85) {
                                                    var4_4 = var4_4[var114_85];
                                                    var39_34 = Long.parseLong((String)var4_4);
                                                }
lbl352:
                                                // 5 sources

                                                while (true) {
                                                    var4_4 = var0;
                                                    var5_5 /* !! */  = var1_1;
                                                    var33_30 = var26_23;
                                                    var6_6 = var82_63;
                                                    var51_40 = var83_64;
                                                    var28_25 = var101_77;
                                                    var19_17 /* !! */  = var91_70;
                                                    var11_11 /* !! */  = var92_71;
                                                    ** GOTO lbl204
                                                    break;
                                                }
                                            }
                                            var114_85 = 1;
                                            var4_4 = "#EXT-X-DISCONTINUITY-SEQUENCE";
                                            var113_84 = var70_55.startsWith((String)var4_4);
                                            var115_86 = 58;
                                            if (var113_84 == 0) break block75;
                                            var113_84 = var70_55.indexOf((int)var115_86) + var114_85;
                                            var57_45 = Integer.parseInt(var70_55.substring(var113_84));
                                            var4_4 = var0;
                                            var5_5 /* !! */  = var1_1;
                                            var6_6 = 1;
                                            var51_40 = 1.4E-45f;
                                            ** GOTO lbl204
                                        }
                                        var4_4 = "#EXT-X-DISCONTINUITY";
                                        var113_84 = (int)var70_55.equals(var4_4);
                                        if (var113_84 == 0) break block76;
                                        ++var67_52;
                                        ** GOTO lbl352
                                    }
                                    var4_4 = "#EXT-X-PROGRAM-DATE-TIME";
                                    var113_84 = (int)var70_55.startsWith((String)var4_4);
                                    if (var113_84 == 0) break block77;
                                    var113_84 = (int)(var35_32 == var20_18 ? 0 : (var35_32 < var20_18 ? -1 : 1));
                                    if (var113_84 == 0) {
                                        var113_84 = var70_55.indexOf((int)var115_86);
                                        var115_86 = 1;
                                        var4_4 = var70_55.substring(var113_84 += var115_86);
                                        var111_83 = C.msToUs(Util.parseXsDateTime((String)var4_4));
                                        var35_32 = var111_83 - var43_36;
                                        ** continue;
                                    }
lbl393:
                                    // 4 sources

                                    while (true) {
                                        var90_69 = var7_7 /* !! */ ;
                                        var33_30 = var12_12 /* !! */ ;
                                        var93_72 = var45_37;
                                        var19_17 /* !! */  = var101_77;
                                        var6_6 = 0;
                                        var51_40 = 0.0f;
                                        var52_41 = null;
                                        var95_73 = -1;
                                        var97_74 = var53_42;
                                        var98_75 = var54_43;
                                        ** GOTO lbl667
                                        break;
                                    }
                                }
                                var4_4 = "#EXT-X-GAP";
                                var113_84 = (int)var70_55.equals(var4_4);
                                if (var113_84 == 0) break block78;
                                var4_4 = var0;
                                var5_5 /* !! */  = var1_1;
                                var64_50 = true;
                                ** GOTO lbl204
                            }
                            var4_4 = "#EXT-X-INDEPENDENT-SEGMENTS";
                            var113_84 = (int)var70_55.equals(var4_4);
                            if (var113_84 == 0) break block79;
                            var4_4 = var0;
                            var5_5 /* !! */  = var1_1;
                            var22_19 = 1;
                            ** GOTO lbl204
                        }
                        var4_4 = "#EXT-X-ENDLIST";
                        var113_84 = (int)var70_55.equals(var4_4);
                        if (var113_84 == 0) break block80;
                        var4_4 = var0;
                        var5_5 /* !! */  = var1_1;
                        var63_49 = true;
                        ** GOTO lbl204
                    }
                    var4_4 = "#EXT-X-RENDITION-REPORT";
                    var113_84 = (int)var70_55.startsWith((String)var4_4);
                    if (var113_84 == 0) break block81;
                    var113_84 = var9_9.size();
                    var111_83 = var113_84;
                    var111_83 = var37_33 + var111_83;
                    var93_72 = (long)var10_10.isEmpty();
                    var111_83 -= var93_72;
                    var52_41 = HlsPlaylistParser.REGEX_LAST_MSN;
                    var111_83 = HlsPlaylistParser.parseOptionalLongAttr((String)var70_55, (Pattern)var52_41, var111_83);
                    var6_6 = (int)var10_10.isEmpty();
                    var52_41 = var6_6 != 0 ? ((HlsMediaPlaylist$Segment)Iterables.getLast(var9_9)).parts : var10_10;
                    var93_72 = -9223372036854775807L;
                    cfr_temp_1 = var61_48 - var93_72;
                    var114_85 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                    if (var114_85 != 0) {
                        var6_6 = var52_41.size();
                        var114_85 = 1;
                        var6_6 -= var114_85;
                    } else {
                        var6_6 = -1;
                        var51_40 = 0.0f / 0.0f;
                    }
                    var19_17 /* !! */  = HlsPlaylistParser.REGEX_LAST_PART;
                    var6_6 = HlsPlaylistParser.parseOptionalIntAttr((String)var70_55, (Pattern)var19_17 /* !! */ , var6_6);
                    var19_17 /* !! */  = HlsPlaylistParser.REGEX_URI;
                    var19_17 /* !! */  = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var19_17 /* !! */ , var7_7 /* !! */ );
                    var70_55 = var3_3;
                    var19_17 /* !! */  = Uri.parse((String)UriUtil.resolve(var3_3, (String)var19_17 /* !! */ ));
                    var28_25 = new HlsMediaPlaylist$RenditionReport((Uri)var19_17 /* !! */ , var111_83, var6_6);
                    var4_4 = var92_71;
                    var92_71.put(var19_17 /* !! */ , var28_25);
                    ** GOTO lbl393
                }
                var4_4 = var11_11 /* !! */ ;
                var5_5 /* !! */  = "#EXT-X-PRELOAD-HINT";
                var115_86 = (long)var70_55.startsWith((String)var5_5 /* !! */ );
                if (var115_86 != false) {
                    var5_5 /* !! */  = var32_29;
                    if (var32_29 != null) {
                        while (true) {
                            var92_71 = var4_4;
                            var32_29 = var5_5 /* !! */ ;
                            ** continue;
                            break;
                        }
                    }
                    var52_41 = HlsPlaylistParser.REGEX_PRELOAD_HINT_TYPE;
                    if ((var6_6 = (int)(var19_17 /* !! */  = "PART").equals(var52_41 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var52_41, var7_7 /* !! */ ))) == 0) ** continue;
                    var52_41 = HlsPlaylistParser.REGEX_URI;
                    var116_87 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var52_41, var7_7 /* !! */ );
                    var52_41 = HlsPlaylistParser.REGEX_BYTERANGE_START;
                    var93_72 = -1;
                    var74_59 = HlsPlaylistParser.parseOptionalLongAttr((String)var70_55, (Pattern)var52_41, var93_72);
                    var52_41 = HlsPlaylistParser.REGEX_BYTERANGE_LENGTH;
                    var117_88 = HlsPlaylistParser.parseOptionalLongAttr((String)var70_55, (Pattern)var52_41, var93_72);
                    var93_72 = var45_37;
                    var19_17 /* !! */  = var28_25;
                    var119_89 = HlsPlaylistParser.getSegmentEncryptionIV(var45_37, (String)var71_56, (String)var28_25);
                    if (var31_28 /* !! */  == null && (var6_6 = (int)var18_16.isEmpty()) == 0) {
                        var52_41 = var18_16.values();
                        var73_58 = 0;
                        var70_55 = null;
                        var4_4 = new DrmInitData$SchemeData[]{};
                        var4_4 = (DrmInitData$SchemeData[])var52_41.toArray((T[])var4_4);
                        var52_41 = new DrmInitData((String)var33_30, (DrmInitData$SchemeData[])var4_4);
                        if (var29_26 == null) {
                            var29_26 = HlsPlaylistParser.getPlaylistProtectionSchemes(var33_30, (DrmInitData$SchemeData[])var4_4);
                        }
                        var31_28 /* !! */  = var52_41;
                    } else {
                        var92_71 = var4_4;
                    }
                    var85_66 = -1;
                    var99_76 = 0.0 / 0.0;
                    var113_84 = (int)(var74_59 == var85_66 ? 0 : (var74_59 < var85_66 ? -1 : 1));
                    if (var113_84 != 0 && (var6_6 = (int)(var117_88 == var85_66 ? 0 : (var117_88 < var85_66 ? -1 : 1))) == 0) {
                        var32_29 = var5_5 /* !! */ ;
                    } else {
                        var120_90 = 0L;
                        var122_91 = var113_84 != 0 ? var74_59 : var20_18;
                        var124_92 = false;
                        var125_93 = false;
                        var126_94 = true;
                        var32_29 = new HlsMediaPlaylist$Part(var116_87, (HlsMediaPlaylist$Segment)var34_31, var120_90, var67_52, var41_35, (DrmInitData)var31_28 /* !! */ , (String)var71_56, var119_89, var122_91, var117_88, false, false, var126_94);
                    }
                    var4_4 = var0;
                    var5_5 /* !! */  = var1_1;
                    var33_30 = var26_23;
                    var45_37 = var93_72;
                    var6_6 = var82_63;
                    var51_40 = var83_64;
                } else {
                    var5_5 /* !! */  = var32_29;
                    var93_72 = var45_37;
                    var19_17 /* !! */  = var28_25;
                    var4_4 = "#EXT-X-PART";
                    var113_84 = (int)var70_55.startsWith((String)var4_4);
                    if (var113_84 != 0) {
                        var119_89 = HlsPlaylistParser.getSegmentEncryptionIV(var45_37, (String)var71_56, (String)var28_25);
                        var4_4 = HlsPlaylistParser.REGEX_URI;
                        var116_87 = HlsPlaylistParser.parseStringAttr((String)var70_55, (Pattern)var4_4, var7_7 /* !! */ );
                        var4_4 = HlsPlaylistParser.REGEX_ATTR_DURATION;
                        var99_76 = HlsPlaylistParser.parseDoubleAttr((String)var70_55, (Pattern)var4_4);
                        var127_95 = var99_76 * var76_60;
                        var111_83 = (long)var127_95;
                        var33_30 = var12_12 /* !! */ ;
                        var12_12 /* !! */  = HlsPlaylistParser.REGEX_INDEPENDENT;
                        var97_74 = var53_42;
                        var98_75 = var54_43;
                        var53_42 = 0;
                        var54_43 = 0.0f;
                        var13_13 = null;
                        var129_96 = HlsPlaylistParser.parseOptionalBooleanAttribute((String)var70_55, (Pattern)var12_12 /* !! */ , false);
                        var130_97 = var22_19 != 0 && (var69_54 = var10_10.isEmpty()) != false;
                        var125_93 = var129_96 | var130_97;
                        var12_12 /* !! */  = HlsPlaylistParser.REGEX_GAP;
                        var124_92 = HlsPlaylistParser.parseOptionalBooleanAttribute((String)var70_55, (Pattern)var12_12 /* !! */ , false);
                        var12_12 /* !! */  = HlsPlaylistParser.REGEX_ATTR_BYTERANGE;
                        if ((var12_12 /* !! */  = HlsPlaylistParser.parseOptionalStringAttr((String)var70_55, (Pattern)var12_12 /* !! */ , (Map)var7_7 /* !! */ )) != null) {
                            var52_41 = Util.split((String)var12_12 /* !! */ , (String)var52_41);
                            var12_12 /* !! */  = var52_41[0];
                            var74_59 = Long.parseLong((String)var12_12 /* !! */ );
                            var53_42 = ((Object)var52_41).length;
                            var129_96 = 1;
                            if (var53_42 > var129_96) {
                                var52_41 = var52_41[var129_96];
                                var49_39 = Long.parseLong((String)var52_41);
                            }
                            var87_67 = var74_59;
                            var74_59 = -1;
                            var76_60 = 0.0 / 0.0;
                        } else {
                            var129_96 = 1;
                            var74_59 = -1;
                            var76_60 = 0.0 / 0.0;
                            var87_67 = -1;
                        }
                        var6_6 = (int)(var87_67 == var74_59 ? 0 : (var87_67 < var74_59 ? -1 : 1));
                        if (var6_6 == 0) {
                            var49_39 = var20_18;
                        }
                        if (var31_28 /* !! */  == null && (var53_42 = (int)var18_16.isEmpty()) == 0) {
                            var13_13 = var18_16.values();
                            var73_58 = 0;
                            var70_55 = null;
                            var12_12 /* !! */  = new DrmInitData$SchemeData[]{};
                            var13_13 = var13_13.toArray(var12_12 /* !! */ );
                            var12_12 /* !! */  = new DrmInitData((String)var26_23, var13_13);
                            if (var29_26 == null) {
                                var29_26 = HlsPlaylistParser.getPlaylistProtectionSchemes((String)var26_23, var13_13);
                            }
                            var31_28 /* !! */  = var12_12 /* !! */ ;
                        }
                        var126_94 = false;
                        var120_90 = var111_83;
                        var122_91 = var49_39;
                        var117_88 = var87_67;
                        var13_13 = new HlsMediaPlaylist$Part(var116_87, (HlsMediaPlaylist$Segment)var34_31, var111_83, var67_52, var41_35, (DrmInitData)var31_28 /* !! */ , (String)var71_56, var119_89, var49_39, var87_67, var124_92, var125_93, false);
                        var10_10.add(var13_13);
                        var41_35 += var111_83;
                        if (var6_6 != 0) {
                            var49_39 += var87_67;
                        }
                        var4_4 = var0;
                        var5_5 /* !! */  = var1_1;
                    } else {
                        var97_74 = var53_42;
                        var98_75 = var54_43;
                        var33_30 = var12_12 /* !! */ ;
                        var4_4 = "#";
                        var113_84 = (int)var70_55.startsWith((String)var4_4);
                        if (var113_84 == 0) {
                            var4_4 = HlsPlaylistParser.getSegmentEncryptionIV(var45_37, (String)var71_56, (String)var28_25);
                            var131_98 = var45_37 + var85_66;
                            var13_13 = HlsPlaylistParser.replaceVariableReferences((String)var70_55, var7_7 /* !! */ );
                            var12_12 /* !! */  = (HlsMediaPlaylist$Segment)var8_8.get(var13_13);
                            var95_73 = -1;
                            cfr_temp_2 = var65_51 - var95_73;
                            var73_58 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                            if (var73_58 == 0) {
                                var93_72 = var20_18;
                            } else {
                                if (var68_53 && var34_31 == null && var12_12 /* !! */  == null) {
                                    var85_66 = 0L;
                                    var99_76 = 0.0;
                                    var89_68 = var12_12 /* !! */ ;
                                    var84_65 = var13_13;
                                    var87_67 = var39_34;
                                    var12_12 /* !! */  = new HlsMediaPlaylist$Segment((String)var13_13, var85_66, var39_34, null, null);
                                    var8_8.put(var13_13, var12_12 /* !! */ );
                                }
                                var93_72 = var39_34;
                            }
                            if (var31_28 /* !! */  == null && !(var133_99 = var18_16.isEmpty())) {
                                var134_100 = var131_98;
                                var5_5 /* !! */  = var18_16.values();
                                var90_69 = var7_7 /* !! */ ;
                                var6_6 = 0;
                                var51_40 = 0.0f;
                                var52_41 = null;
                                var7_7 /* !! */  = new DrmInitData$SchemeData[]{};
                                var5_5 /* !! */  = var5_5 /* !! */ .toArray(var7_7 /* !! */ );
                                var7_7 /* !! */  = new DrmInitData((String)var26_23, var5_5 /* !! */ );
                                if (var29_26 == null) {
                                    var29_26 = HlsPlaylistParser.getPlaylistProtectionSchemes((String)var26_23, var5_5 /* !! */ );
                                }
                            } else {
                                var134_100 = var131_98;
                                var90_69 = var7_7 /* !! */ ;
                                var6_6 = 0;
                                var51_40 = 0.0f;
                                var52_41 = null;
                                var7_7 /* !! */  = var31_28 /* !! */ ;
                            }
                            var31_28 /* !! */  = var34_31 != null ? var34_31 : var12_12 /* !! */ ;
                            var74_59 = var47_38;
                            var41_35 = var93_72;
                            var5_5 /* !! */  = new HlsMediaPlaylist$Segment((String)var13_13, (HlsMediaPlaylist$Segment)var31_28 /* !! */ , (String)var24_21, var47_38, var67_52, var43_36, (DrmInitData)var7_7 /* !! */ , (String)var71_56, (String)var4_4, var93_72, var65_51, var64_50, var10_10);
                            var9_9.add(var5_5 /* !! */ );
                            var41_35 = var43_36 + var47_38;
                            var10_10 = new ArrayList<DrmInitData$SchemeData[]>();
                            if (var73_58 != 0) {
                                var93_72 += var65_51;
                            }
                            var39_34 = var93_72;
                            var4_4 = var0;
                            var5_5 /* !! */  = var1_1;
                            var64_50 = false;
                            var31_28 /* !! */  = var7_7 /* !! */ ;
                            var28_25 = var19_17 /* !! */ ;
                            var47_38 = var20_18;
                            var43_36 = var41_35;
                            var65_51 = var95_73;
                            var7_7 /* !! */  = var90_69;
                            var12_12 /* !! */  = var33_30;
                            var53_42 = var97_74;
                            var54_43 = var98_75;
                            var6_6 = var82_63;
                            var51_40 = var83_64;
                            var19_17 /* !! */  = var91_70;
                            var24_21 = var91_70;
                            var11_11 /* !! */  = var92_71;
                            var33_30 = var26_23;
                            var45_37 = var134_100;
                            ** continue;
                        }
                        var90_69 = var7_7 /* !! */ ;
                        var6_6 = 0;
                        var51_40 = 0.0f;
                        var52_41 = null;
                        var95_73 = -1;
lbl667:
                        // 3 sources

                        var4_4 = var0;
                        var5_5 /* !! */  = var1_1;
                        var7_7 /* !! */  = var90_69;
                    }
                    var12_12 /* !! */  = var33_30;
                    var53_42 = var97_74;
                    var54_43 = var98_75;
                    var6_6 = var82_63;
                    var51_40 = var83_64;
                    var33_30 = var26_23;
                    var45_37 = var93_72;
                }
                var11_11 /* !! */  = var92_71;
                var28_25 = var19_17 /* !! */ ;
                var26_23 = var71_56;
            }
            var19_17 /* !! */  = var91_70;
        }
        var82_63 = var6_6;
        var83_64 = var51_40;
        var97_74 = var53_42;
        var98_75 = var54_43;
        var33_30 = var12_12 /* !! */ ;
        var92_71 = var11_11 /* !! */ ;
        var6_6 = 0;
        var51_40 = 0.0f;
        var52_41 = null;
        if (var32_29 != null) {
            var4_4 = var32_29;
            var10_10.add((DrmInitData$SchemeData[])var32_29);
        }
        if ((var115_86 = var35_32 == var20_18 ? 0 : (var35_32 < var20_18 ? -1 : 1)) != false) {
            var5_5 /* !! */  = var10_10;
            var6_6 = 1;
            var51_40 = 1.4E-45f;
        } else {
            var5_5 /* !! */  = var10_10;
        }
        var10_10 = var4_4;
        var53_42 = var97_74;
        var54_43 = var98_75;
        var18_16 = var3_3;
        var12_12 /* !! */  = var33_30;
        var108_81 = var55_44;
        var106_80 = var35_32;
        var27_24 = var82_63;
        var7_7 /* !! */  = var92_71;
        var110_82 = var57_45;
        var8_8 = var9_9;
        var14_14 = var61_48;
        var4_4 = new HlsMediaPlaylist(var97_74, var3_3, (List)var33_30, var55_44, var35_32, (boolean)var82_63, var57_45, var37_33, var58_46, var59_47, var61_48, (boolean)var22_19, var63_49, (boolean)var6_6, var29_26, var9_9, (List)var5_5 /* !! */ , var23_20, (Map)var92_71);
        return var4_4;
    }

    private static boolean parseOptionalBooleanAttribute(String object, Pattern pattern, boolean bl2) {
        boolean bl3 = ((Matcher)(object = pattern.matcher((CharSequence)object))).find();
        if (bl3) {
            object = ((Matcher)object).group(1);
            return BOOLEAN_TRUE.equals(object);
        }
        return bl2;
    }

    private static double parseOptionalDoubleAttr(String object, Pattern pattern, double d10) {
        boolean bl2 = ((Matcher)(object = pattern.matcher((CharSequence)object))).find();
        if (bl2) {
            return Double.parseDouble((String)Assertions.checkNotNull(((Matcher)object).group(1)));
        }
        return d10;
    }

    private static int parseOptionalIntAttr(String object, Pattern pattern, int n10) {
        boolean bl2 = ((Matcher)(object = pattern.matcher((CharSequence)object))).find();
        if (bl2) {
            return Integer.parseInt((String)Assertions.checkNotNull(((Matcher)object).group(1)));
        }
        return n10;
    }

    private static long parseOptionalLongAttr(String object, Pattern pattern, long l10) {
        boolean bl2 = ((Matcher)(object = pattern.matcher((CharSequence)object))).find();
        if (bl2) {
            return Long.parseLong((String)Assertions.checkNotNull(((Matcher)object).group(1)));
        }
        return l10;
    }

    private static String parseOptionalStringAttr(String object, Pattern pattern, String object2, Map map) {
        boolean bl2;
        int n10 = (int)(((Matcher)(object = pattern.matcher((CharSequence)object))).find() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            object2 = object = Assertions.checkNotNull(((Matcher)object).group(n10));
            object2 = (String)object;
        }
        if (!(bl2 = map.isEmpty()) && object2 != null) {
            object2 = HlsPlaylistParser.replaceVariableReferences((String)object2, map);
        }
        return object2;
    }

    private static String parseOptionalStringAttr(String string2, Pattern pattern, Map map) {
        return HlsPlaylistParser.parseOptionalStringAttr(string2, pattern, null, map);
    }

    private static int parseRoleFlags(String objectArray, Map object) {
        boolean bl2;
        Pattern pattern = REGEX_CHARACTERISTICS;
        objectArray = HlsPlaylistParser.parseOptionalStringAttr((String)objectArray, pattern, (Map)object);
        boolean bl3 = TextUtils.isEmpty((CharSequence)objectArray);
        int n10 = 0;
        pattern = null;
        if (bl3) {
            return 0;
        }
        bl3 = Util.contains(objectArray = Util.split((String)objectArray, ","), object = "public.accessibility.describes-video");
        if (bl3) {
            n10 = 512;
        }
        if (bl3 = Util.contains(objectArray, object = "public.accessibility.transcribes-spoken-dialog")) {
            n10 |= 0x1000;
        }
        if (bl3 = Util.contains(objectArray, object = "public.accessibility.describes-music-and-sound")) {
            n10 |= 0x400;
        }
        if (bl2 = Util.contains(objectArray, object = "public.easy-to-read")) {
            n10 |= 0x2000;
        }
        return n10;
    }

    private static int parseSelectionFlags(String string2) {
        boolean bl2;
        Pattern pattern = REGEX_DEFAULT;
        int n10 = (int)(HlsPlaylistParser.parseOptionalBooleanAttribute(string2, pattern, false) ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            pattern = null;
        }
        Pattern pattern2 = REGEX_FORCED;
        boolean bl3 = HlsPlaylistParser.parseOptionalBooleanAttribute(string2, pattern2, false);
        if (bl3) {
            n10 |= 2;
        }
        if (bl2 = HlsPlaylistParser.parseOptionalBooleanAttribute(string2, pattern2 = REGEX_AUTOSELECT, false)) {
            n10 |= 4;
        }
        return n10;
    }

    private static HlsMediaPlaylist$ServerControl parseServerControl(String string2) {
        long l10;
        long l11;
        Object object = string2;
        Pattern pattern = REGEX_CAN_SKIP_UNTIL;
        double d10 = -9.223372036854776E18;
        double d11 = HlsPlaylistParser.parseOptionalDoubleAttr(string2, pattern, d10);
        Object object2 = d11 == d10 ? 0 : (d11 > d10 ? 1 : -1);
        long l12 = -9223372036854775807L;
        double d12 = -4.9E-324;
        double d13 = 1000000.0;
        long l13 = object2 == false ? l12 : (l11 = (long)(d11 *= d13));
        pattern = REGEX_CAN_SKIP_DATE_RANGES;
        boolean bl2 = HlsPlaylistParser.parseOptionalBooleanAttribute((String)object, pattern, false);
        pattern = REGEX_HOLD_BACK;
        double d14 = HlsPlaylistParser.parseOptionalDoubleAttr((String)object, pattern, d10);
        double d15 = d14 - d10;
        object2 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
        if (object2 == false) {
            l10 = l12;
            d14 = d12;
        } else {
            l10 = (long)(d14 *= d13);
        }
        pattern = REGEX_PART_HOLD_BACK;
        double d16 = HlsPlaylistParser.parseOptionalDoubleAttr((String)object, pattern, d10);
        object2 = d16 == d10 ? 0 : (d16 > d10 ? 1 : -1);
        if (object2 != false) {
            double d17 = d16 * d13;
            l12 = (long)d17;
        }
        pattern = REGEX_CAN_BLOCK_RELOAD;
        boolean bl3 = HlsPlaylistParser.parseOptionalBooleanAttribute((String)object, pattern, false);
        object = new HlsMediaPlaylist$ServerControl(l13, bl2, l10, l12, bl3);
        return object;
    }

    private static String parseStringAttr(String string2, Pattern object, Map object2) {
        if ((object2 = HlsPlaylistParser.parseOptionalStringAttr(string2, (Pattern)object, (Map)object2)) != null) {
            return object2;
        }
        object = ((Pattern)object).pattern();
        int n10 = String.valueOf(object).length() + 19;
        int n11 = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("Couldn't match ");
        stringBuilder.append((String)object);
        stringBuilder.append(" in ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object2 = new ParserException(string2);
        throw object2;
    }

    private static String replaceVariableReferences(String object, Map map) {
        int n10;
        object = REGEX_VARIABLE_REFERENCE.matcher((CharSequence)object);
        StringBuffer stringBuffer = new StringBuffer();
        while ((n10 = ((Matcher)object).find()) != 0) {
            n10 = 1;
            String string2 = ((Matcher)object).group(n10);
            boolean bl2 = map.containsKey(string2);
            if (!bl2) continue;
            string2 = Matcher.quoteReplacement((String)map.get(string2));
            ((Matcher)object).appendReplacement(stringBuffer, string2);
        }
        ((Matcher)object).appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean bl2, int n10) {
        int n11;
        while (n10 != (n11 = -1) && (n11 = (int)(Character.isWhitespace(n10) ? 1 : 0)) != 0 && (bl2 || (n11 = (int)(Util.isLinebreak(n10) ? 1 : 0)) == 0)) {
            n10 = bufferedReader.read();
        }
        return n10;
    }

    public HlsPlaylist parse(Uri object, InputStream serializable) {
        BufferedReader bufferedReader;
        Object object2;
        block27: {
            block28: {
                Object object3;
                object2 = new InputStreamReader((InputStream)((Object)serializable));
                bufferedReader = new BufferedReader((Reader)object2);
                serializable = new ArrayDeque();
                boolean bl2 = HlsPlaylistParser.checkPlaylistHeader(bufferedReader);
                if (!bl2) break block27;
                while (true) {
                    boolean bl3;
                    block29: {
                        object2 = bufferedReader.readLine();
                        if (object2 == null) break block28;
                        object2 = ((String)object2).trim();
                        bl3 = ((String)object2).isEmpty();
                        if (bl3) continue;
                        object3 = TAG_STREAM_INF;
                        bl3 = ((String)object2).startsWith((String)object3);
                        if (!bl3) break block29;
                        serializable.add(object2);
                        object2 = new HlsPlaylistParser$LineIterator((Queue)((Object)serializable), bufferedReader);
                        object = object.toString();
                        object = HlsPlaylistParser.parseMasterPlaylist((HlsPlaylistParser$LineIterator)object2, (String)object);
                        return object;
                    }
                    object3 = TAG_TARGET_DURATION;
                    bl3 = ((String)object2).startsWith((String)object3);
                    if (bl3) break;
                    object3 = TAG_MEDIA_SEQUENCE;
                    bl3 = ((String)object2).startsWith((String)object3);
                    if (bl3) break;
                    object3 = TAG_MEDIA_DURATION;
                    bl3 = ((String)object2).startsWith((String)object3);
                    if (bl3) break;
                    object3 = TAG_KEY;
                    bl3 = ((String)object2).startsWith((String)object3);
                    if (bl3) break;
                    object3 = TAG_BYTERANGE;
                    bl3 = ((String)object2).startsWith((String)object3);
                    if (bl3) break;
                    object3 = TAG_DISCONTINUITY;
                    bl3 = ((String)object2).equals(object3);
                    if (bl3) break;
                    object3 = TAG_DISCONTINUITY_SEQUENCE;
                    bl3 = ((String)object2).equals(object3);
                    if (bl3) break;
                    object3 = TAG_ENDLIST;
                    bl3 = ((String)object2).equals(object3);
                    if (bl3) break;
                    serializable.add(object2);
                    continue;
                    break;
                }
                serializable.add(object2);
                object2 = this.masterPlaylist;
                object3 = this.previousMediaPlaylist;
                HlsPlaylistParser$LineIterator hlsPlaylistParser$LineIterator = new HlsPlaylistParser$LineIterator((Queue)((Object)serializable), bufferedReader);
                object = object.toString();
                object = HlsPlaylistParser.parseMediaPlaylist((HlsMasterPlaylist)object2, (HlsMediaPlaylist)object3, hlsPlaylistParser$LineIterator, (String)object);
                Util.closeQuietly(bufferedReader);
                return object;
            }
            Util.closeQuietly(bufferedReader);
            object = new ParserException("Failed to parse the playlist, could not identify any tags.");
            throw object;
        }
        object2 = "Input does not start with the #EXTM3U header.";
        try {
            serializable = new UnrecognizedInputFormatException((String)object2, (Uri)object);
            throw serializable;
        }
        finally {
            Util.closeQuietly(bufferedReader);
        }
    }
}

