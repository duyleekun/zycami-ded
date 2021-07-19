/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner$MapJoiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableListMultimap$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.net.MediaType$1;
import com.google.common.net.MediaType$2;
import com.google.common.net.MediaType$Tokenizer;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Map;

public final class MediaType {
    public static final MediaType AAC_AUDIO;
    public static final MediaType ANY_APPLICATION_TYPE;
    public static final MediaType ANY_AUDIO_TYPE;
    public static final MediaType ANY_IMAGE_TYPE;
    public static final MediaType ANY_TEXT_TYPE;
    public static final MediaType ANY_TYPE;
    public static final MediaType ANY_VIDEO_TYPE;
    public static final MediaType APPLE_MOBILE_CONFIG;
    public static final MediaType APPLE_PASSBOOK;
    public static final MediaType APPLICATION_BINARY;
    private static final String APPLICATION_TYPE = "application";
    public static final MediaType APPLICATION_XML_UTF_8;
    public static final MediaType ATOM_UTF_8;
    private static final String AUDIO_TYPE = "audio";
    public static final MediaType BASIC_AUDIO;
    public static final MediaType BMP;
    public static final MediaType BZIP2;
    public static final MediaType CACHE_MANIFEST_UTF_8;
    private static final String CHARSET_ATTRIBUTE = "charset";
    public static final MediaType CRW;
    public static final MediaType CSS_UTF_8;
    public static final MediaType CSV_UTF_8;
    public static final MediaType DART_UTF_8;
    public static final MediaType EOT;
    public static final MediaType EPUB;
    public static final MediaType FLV_VIDEO;
    public static final MediaType FORM_DATA;
    public static final MediaType GEO_JSON;
    public static final MediaType GIF;
    public static final MediaType GZIP;
    public static final MediaType HAL_JSON;
    public static final MediaType HEIF;
    public static final MediaType HTML_UTF_8;
    public static final MediaType ICO;
    private static final String IMAGE_TYPE = "image";
    public static final MediaType I_CALENDAR_UTF_8;
    public static final MediaType JAVASCRIPT_UTF_8;
    public static final MediaType JOSE;
    public static final MediaType JOSE_JSON;
    public static final MediaType JP2K;
    public static final MediaType JPEG;
    public static final MediaType JSON_UTF_8;
    public static final MediaType KEY_ARCHIVE;
    public static final MediaType KML;
    public static final MediaType KMZ;
    private static final Map KNOWN_TYPES;
    public static final MediaType L16_AUDIO;
    public static final MediaType L24_AUDIO;
    private static final CharMatcher LINEAR_WHITE_SPACE;
    public static final MediaType MANIFEST_JSON_UTF_8;
    public static final MediaType MBOX;
    public static final MediaType MEDIA_PRESENTATION_DESCRIPTION;
    public static final MediaType MICROSOFT_EXCEL;
    public static final MediaType MICROSOFT_OUTLOOK;
    public static final MediaType MICROSOFT_POWERPOINT;
    public static final MediaType MICROSOFT_WORD;
    public static final MediaType MP4_AUDIO;
    public static final MediaType MP4_VIDEO;
    public static final MediaType MPEG_AUDIO;
    public static final MediaType MPEG_VIDEO;
    public static final MediaType NACL_APPLICATION;
    public static final MediaType NACL_PORTABLE_APPLICATION;
    public static final MediaType OCTET_STREAM;
    public static final MediaType OGG_AUDIO;
    public static final MediaType OGG_CONTAINER;
    public static final MediaType OGG_VIDEO;
    public static final MediaType OOXML_DOCUMENT;
    public static final MediaType OOXML_PRESENTATION;
    public static final MediaType OOXML_SHEET;
    public static final MediaType OPENDOCUMENT_GRAPHICS;
    public static final MediaType OPENDOCUMENT_PRESENTATION;
    public static final MediaType OPENDOCUMENT_SPREADSHEET;
    public static final MediaType OPENDOCUMENT_TEXT;
    public static final MediaType OPENSEARCH_DESCRIPTION_UTF_8;
    private static final Joiner$MapJoiner PARAMETER_JOINER;
    public static final MediaType PDF;
    public static final MediaType PLAIN_TEXT_UTF_8;
    public static final MediaType PNG;
    public static final MediaType POSTSCRIPT;
    public static final MediaType PROTOBUF;
    public static final MediaType PSD;
    public static final MediaType QUICKTIME;
    private static final CharMatcher QUOTED_TEXT_MATCHER;
    public static final MediaType RDF_XML_UTF_8;
    public static final MediaType RTF_UTF_8;
    public static final MediaType SFNT;
    public static final MediaType SHOCKWAVE_FLASH;
    public static final MediaType SKETCHUP;
    public static final MediaType SOAP_XML_UTF_8;
    public static final MediaType SVG_UTF_8;
    public static final MediaType TAR;
    public static final MediaType TEXT_JAVASCRIPT_UTF_8;
    private static final String TEXT_TYPE = "text";
    public static final MediaType THREE_GPP2_VIDEO;
    public static final MediaType THREE_GPP_VIDEO;
    public static final MediaType TIFF;
    private static final CharMatcher TOKEN_MATCHER;
    public static final MediaType TSV_UTF_8;
    private static final ImmutableListMultimap UTF_8_CONSTANT_PARAMETERS;
    public static final MediaType VCARD_UTF_8;
    private static final String VIDEO_TYPE = "video";
    public static final MediaType VND_REAL_AUDIO;
    public static final MediaType VND_WAVE_AUDIO;
    public static final MediaType VORBIS_AUDIO;
    public static final MediaType VTT_UTF_8;
    public static final MediaType WASM_APPLICATION;
    public static final MediaType WAX_AUDIO;
    public static final MediaType WEBM_AUDIO;
    public static final MediaType WEBM_VIDEO;
    public static final MediaType WEBP;
    private static final String WILDCARD = "*";
    public static final MediaType WMA_AUDIO;
    public static final MediaType WML_UTF_8;
    public static final MediaType WMV;
    public static final MediaType WOFF;
    public static final MediaType WOFF2;
    public static final MediaType XHTML_UTF_8;
    public static final MediaType XML_UTF_8;
    public static final MediaType XRD_UTF_8;
    public static final MediaType ZIP;
    private int hashCode;
    private final ImmutableListMultimap parameters;
    private Optional parsedCharset;
    private final String subtype;
    private String toString;
    private final String type;

    static {
        Object object = Ascii.toLowerCase(Charsets.UTF_8.name());
        UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of(CHARSET_ATTRIBUTE, object);
        object = CharMatcher.ascii();
        Object object2 = CharMatcher.javaIsoControl().negate();
        object = ((CharMatcher)object).and((CharMatcher)object2);
        object2 = CharMatcher.isNot(' ');
        object = ((CharMatcher)object).and((CharMatcher)object2);
        object2 = CharMatcher.noneOf("()<>@,;:\\\"/[]?=");
        TOKEN_MATCHER = ((CharMatcher)object).and((CharMatcher)object2);
        object = CharMatcher.ascii();
        object2 = CharMatcher.noneOf("\"\\\r");
        QUOTED_TEXT_MATCHER = ((CharMatcher)object).and((CharMatcher)object2);
        LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
        KNOWN_TYPES = Maps.newHashMap();
        object = WILDCARD;
        ANY_TYPE = MediaType.createConstant((String)object, (String)object);
        object2 = TEXT_TYPE;
        ANY_TEXT_TYPE = MediaType.createConstant((String)object2, (String)object);
        String string2 = IMAGE_TYPE;
        ANY_IMAGE_TYPE = MediaType.createConstant(string2, (String)object);
        String string3 = AUDIO_TYPE;
        ANY_AUDIO_TYPE = MediaType.createConstant(string3, (String)object);
        String string4 = VIDEO_TYPE;
        ANY_VIDEO_TYPE = MediaType.createConstant(string4, (String)object);
        String string5 = APPLICATION_TYPE;
        ANY_APPLICATION_TYPE = MediaType.createConstant(string5, (String)object);
        CACHE_MANIFEST_UTF_8 = MediaType.createConstantUtf8((String)object2, "cache-manifest");
        CSS_UTF_8 = MediaType.createConstantUtf8((String)object2, "css");
        CSV_UTF_8 = MediaType.createConstantUtf8((String)object2, "csv");
        HTML_UTF_8 = MediaType.createConstantUtf8((String)object2, "html");
        I_CALENDAR_UTF_8 = MediaType.createConstantUtf8((String)object2, "calendar");
        PLAIN_TEXT_UTF_8 = MediaType.createConstantUtf8((String)object2, "plain");
        object = "javascript";
        TEXT_JAVASCRIPT_UTF_8 = MediaType.createConstantUtf8((String)object2, (String)object);
        TSV_UTF_8 = MediaType.createConstantUtf8((String)object2, "tab-separated-values");
        VCARD_UTF_8 = MediaType.createConstantUtf8((String)object2, "vcard");
        WML_UTF_8 = MediaType.createConstantUtf8((String)object2, "vnd.wap.wml");
        String string6 = "xml";
        XML_UTF_8 = MediaType.createConstantUtf8((String)object2, string6);
        VTT_UTF_8 = MediaType.createConstantUtf8((String)object2, "vtt");
        BMP = MediaType.createConstant(string2, "bmp");
        CRW = MediaType.createConstant(string2, "x-canon-crw");
        GIF = MediaType.createConstant(string2, "gif");
        ICO = MediaType.createConstant(string2, "vnd.microsoft.icon");
        JPEG = MediaType.createConstant(string2, "jpeg");
        PNG = MediaType.createConstant(string2, "png");
        PSD = MediaType.createConstant(string2, "vnd.adobe.photoshop");
        SVG_UTF_8 = MediaType.createConstantUtf8(string2, "svg+xml");
        TIFF = MediaType.createConstant(string2, "tiff");
        WEBP = MediaType.createConstant(string2, "webp");
        HEIF = MediaType.createConstant(string2, "heif");
        JP2K = MediaType.createConstant(string2, "jp2");
        object2 = "mp4";
        MP4_AUDIO = MediaType.createConstant(string3, (String)object2);
        string2 = "mpeg";
        MPEG_AUDIO = MediaType.createConstant(string3, string2);
        String string7 = "ogg";
        OGG_AUDIO = MediaType.createConstant(string3, string7);
        String string8 = "webm";
        WEBM_AUDIO = MediaType.createConstant(string3, string8);
        L16_AUDIO = MediaType.createConstant(string3, "l16");
        L24_AUDIO = MediaType.createConstant(string3, "l24");
        BASIC_AUDIO = MediaType.createConstant(string3, "basic");
        AAC_AUDIO = MediaType.createConstant(string3, "aac");
        VORBIS_AUDIO = MediaType.createConstant(string3, "vorbis");
        WMA_AUDIO = MediaType.createConstant(string3, "x-ms-wma");
        WAX_AUDIO = MediaType.createConstant(string3, "x-ms-wax");
        VND_REAL_AUDIO = MediaType.createConstant(string3, "vnd.rn-realaudio");
        VND_WAVE_AUDIO = MediaType.createConstant(string3, "vnd.wave");
        MP4_VIDEO = MediaType.createConstant(string4, (String)object2);
        MPEG_VIDEO = MediaType.createConstant(string4, string2);
        OGG_VIDEO = MediaType.createConstant(string4, string7);
        QUICKTIME = MediaType.createConstant(string4, "quicktime");
        WEBM_VIDEO = MediaType.createConstant(string4, string8);
        WMV = MediaType.createConstant(string4, "x-ms-wmv");
        FLV_VIDEO = MediaType.createConstant(string4, "x-flv");
        THREE_GPP_VIDEO = MediaType.createConstant(string4, "3gpp");
        THREE_GPP2_VIDEO = MediaType.createConstant(string4, "3gpp2");
        APPLICATION_XML_UTF_8 = MediaType.createConstantUtf8(string5, string6);
        ATOM_UTF_8 = MediaType.createConstantUtf8(string5, "atom+xml");
        BZIP2 = MediaType.createConstant(string5, "x-bzip2");
        DART_UTF_8 = MediaType.createConstantUtf8(string5, "dart");
        APPLE_PASSBOOK = MediaType.createConstant(string5, "vnd.apple.pkpass");
        EOT = MediaType.createConstant(string5, "vnd.ms-fontobject");
        EPUB = MediaType.createConstant(string5, "epub+zip");
        FORM_DATA = MediaType.createConstant(string5, "x-www-form-urlencoded");
        KEY_ARCHIVE = MediaType.createConstant(string5, "pkcs12");
        APPLICATION_BINARY = MediaType.createConstant(string5, "binary");
        GEO_JSON = MediaType.createConstant(string5, "geo+json");
        GZIP = MediaType.createConstant(string5, "x-gzip");
        HAL_JSON = MediaType.createConstant(string5, "hal+json");
        JAVASCRIPT_UTF_8 = MediaType.createConstantUtf8(string5, (String)object);
        JOSE = MediaType.createConstant(string5, "jose");
        JOSE_JSON = MediaType.createConstant(string5, "jose+json");
        JSON_UTF_8 = MediaType.createConstantUtf8(string5, "json");
        MANIFEST_JSON_UTF_8 = MediaType.createConstantUtf8(string5, "manifest+json");
        KML = MediaType.createConstant(string5, "vnd.google-earth.kml+xml");
        KMZ = MediaType.createConstant(string5, "vnd.google-earth.kmz");
        MBOX = MediaType.createConstant(string5, "mbox");
        APPLE_MOBILE_CONFIG = MediaType.createConstant(string5, "x-apple-aspen-config");
        MICROSOFT_EXCEL = MediaType.createConstant(string5, "vnd.ms-excel");
        MICROSOFT_OUTLOOK = MediaType.createConstant(string5, "vnd.ms-outlook");
        MICROSOFT_POWERPOINT = MediaType.createConstant(string5, "vnd.ms-powerpoint");
        MICROSOFT_WORD = MediaType.createConstant(string5, "msword");
        MEDIA_PRESENTATION_DESCRIPTION = MediaType.createConstant(string5, "dash+xml");
        WASM_APPLICATION = MediaType.createConstant(string5, "wasm");
        NACL_APPLICATION = MediaType.createConstant(string5, "x-nacl");
        NACL_PORTABLE_APPLICATION = MediaType.createConstant(string5, "x-pnacl");
        OCTET_STREAM = MediaType.createConstant(string5, "octet-stream");
        OGG_CONTAINER = MediaType.createConstant(string5, string7);
        OOXML_DOCUMENT = MediaType.createConstant(string5, "vnd.openxmlformats-officedocument.wordprocessingml.document");
        OOXML_PRESENTATION = MediaType.createConstant(string5, "vnd.openxmlformats-officedocument.presentationml.presentation");
        OOXML_SHEET = MediaType.createConstant(string5, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        OPENDOCUMENT_GRAPHICS = MediaType.createConstant(string5, "vnd.oasis.opendocument.graphics");
        OPENDOCUMENT_PRESENTATION = MediaType.createConstant(string5, "vnd.oasis.opendocument.presentation");
        OPENDOCUMENT_SPREADSHEET = MediaType.createConstant(string5, "vnd.oasis.opendocument.spreadsheet");
        OPENDOCUMENT_TEXT = MediaType.createConstant(string5, "vnd.oasis.opendocument.text");
        OPENSEARCH_DESCRIPTION_UTF_8 = MediaType.createConstantUtf8(string5, "opensearchdescription+xml");
        PDF = MediaType.createConstant(string5, "pdf");
        POSTSCRIPT = MediaType.createConstant(string5, "postscript");
        PROTOBUF = MediaType.createConstant(string5, "protobuf");
        RDF_XML_UTF_8 = MediaType.createConstantUtf8(string5, "rdf+xml");
        RTF_UTF_8 = MediaType.createConstantUtf8(string5, "rtf");
        SFNT = MediaType.createConstant(string5, "font-sfnt");
        SHOCKWAVE_FLASH = MediaType.createConstant(string5, "x-shockwave-flash");
        SKETCHUP = MediaType.createConstant(string5, "vnd.sketchup.skp");
        SOAP_XML_UTF_8 = MediaType.createConstantUtf8(string5, "soap+xml");
        TAR = MediaType.createConstant(string5, "x-tar");
        WOFF = MediaType.createConstant(string5, "font-woff");
        WOFF2 = MediaType.createConstant(string5, "font-woff2");
        XHTML_UTF_8 = MediaType.createConstantUtf8(string5, "xhtml+xml");
        XRD_UTF_8 = MediaType.createConstantUtf8(string5, "xrd+xml");
        ZIP = MediaType.createConstant(string5, "zip");
        PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
    }

    private MediaType(String string2, String string3, ImmutableListMultimap immutableListMultimap) {
        this.type = string2;
        this.subtype = string3;
        this.parameters = immutableListMultimap;
    }

    public static /* synthetic */ CharMatcher access$000() {
        return TOKEN_MATCHER;
    }

    public static /* synthetic */ String access$100(String string2) {
        return MediaType.escapeAndQuote(string2);
    }

    private static MediaType addKnownType(MediaType mediaType) {
        KNOWN_TYPES.put(mediaType, mediaType);
        return mediaType;
    }

    private String computeToString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.type;
        stringBuilder.append((String)object);
        stringBuilder.append('/');
        object = this.subtype;
        stringBuilder.append((String)object);
        object = this.parameters;
        boolean bl2 = ((ImmutableMultimap)object).isEmpty();
        if (!bl2) {
            stringBuilder.append("; ");
            object = this.parameters;
            Object object2 = new MediaType$2(this);
            object = Multimaps.transformValues((ListMultimap)object, (Function)object2);
            object2 = PARAMETER_JOINER;
            object = object.entries();
            ((Joiner$MapJoiner)object2).appendTo(stringBuilder, (Iterable)object);
        }
        return stringBuilder.toString();
    }

    public static MediaType create(String object, String object2) {
        ImmutableListMultimap immutableListMultimap = ImmutableListMultimap.of();
        object = MediaType.create((String)object, (String)object2, immutableListMultimap);
        ((MediaType)object).parsedCharset = object2 = Optional.absent();
        return object;
    }

    private static MediaType create(String string2, String string3, Multimap object) {
        boolean bl2;
        Preconditions.checkNotNull(string2);
        Preconditions.checkNotNull(string3);
        Preconditions.checkNotNull(object);
        string2 = MediaType.normalizeToken(string2);
        string3 = MediaType.normalizeToken(string3);
        Object object2 = WILDCARD;
        boolean bl3 = ((String)object2).equals(string2);
        if (bl3 && !(bl2 = ((String)object2).equals(string3))) {
            bl2 = false;
            object2 = null;
        } else {
            bl2 = true;
        }
        Object object3 = "A wildcard type cannot be used with a non-wildcard subtype";
        Preconditions.checkArgument(bl2, object3);
        object2 = ImmutableListMultimap.builder();
        object = object.entries().iterator();
        while (bl3 = object.hasNext()) {
            object3 = (Map.Entry)object.next();
            String string4 = MediaType.normalizeToken((String)object3.getKey());
            object3 = (String)object3.getValue();
            object3 = MediaType.normalizeParameterValue(string4, (String)object3);
            ((ImmutableListMultimap$Builder)object2).put(string4, object3);
        }
        object2 = ((ImmutableListMultimap$Builder)object2).build();
        object = new MediaType(string2, string3, (ImmutableListMultimap)object2);
        return (MediaType)MoreObjects.firstNonNull(KNOWN_TYPES.get(object), object);
    }

    public static MediaType createApplicationType(String string2) {
        return MediaType.create(APPLICATION_TYPE, string2);
    }

    public static MediaType createAudioType(String string2) {
        return MediaType.create(AUDIO_TYPE, string2);
    }

    private static MediaType createConstant(String object, String object2) {
        ImmutableListMultimap immutableListMultimap = ImmutableListMultimap.of();
        MediaType mediaType = new MediaType((String)object, (String)object2, immutableListMultimap);
        object = MediaType.addKnownType(mediaType);
        ((MediaType)object).parsedCharset = object2 = Optional.absent();
        return object;
    }

    private static MediaType createConstantUtf8(String object, String object2) {
        ImmutableListMultimap immutableListMultimap = UTF_8_CONSTANT_PARAMETERS;
        MediaType mediaType = new MediaType((String)object, (String)object2, immutableListMultimap);
        object = MediaType.addKnownType(mediaType);
        ((MediaType)object).parsedCharset = object2 = Optional.of(Charsets.UTF_8);
        return object;
    }

    public static MediaType createImageType(String string2) {
        return MediaType.create(IMAGE_TYPE, string2);
    }

    public static MediaType createTextType(String string2) {
        return MediaType.create(TEXT_TYPE, string2);
    }

    public static MediaType createVideoType(String string2) {
        return MediaType.create(VIDEO_TYPE, string2);
    }

    private static String escapeAndQuote(String string2) {
        int n10;
        char c10 = string2.length() + 16;
        StringBuilder stringBuilder = new StringBuilder(c10);
        c10 = '\"';
        stringBuilder.append(c10);
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            int n11 = 13;
            int n12 = 92;
            if (n10 == n11 || n10 == n12 || n10 == c10) {
                stringBuilder.append((char)n12);
            }
            stringBuilder.append((char)n10);
        }
        stringBuilder.append(c10);
        return stringBuilder.toString();
    }

    private static String normalizeParameterValue(String string2, String string3) {
        Preconditions.checkNotNull(string3);
        boolean bl2 = CharMatcher.ascii().matchesAllOf(string3);
        String string4 = "parameter values must be ASCII: %s";
        Preconditions.checkArgument(bl2, string4, (Object)string3);
        String string5 = CHARSET_ATTRIBUTE;
        boolean bl3 = string5.equals(string2);
        if (bl3) {
            string3 = Ascii.toLowerCase(string3);
        }
        return string3;
    }

    private static String normalizeToken(String string2) {
        Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(string2));
        Preconditions.checkArgument(string2.isEmpty() ^ true);
        return Ascii.toLowerCase(string2);
    }

    private Map parametersAsMap() {
        ImmutableMap immutableMap = this.parameters.asMap();
        MediaType$1 mediaType$1 = new MediaType$1(this);
        return Maps.transformValues(immutableMap, (Function)mediaType$1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MediaType parse(String string2) {
        Preconditions.checkNotNull(string2);
        Object object = new MediaType$Tokenizer(string2);
        try {
            Object object2 = TOKEN_MATCHER;
            String string3 = ((MediaType$Tokenizer)object).consumeToken((CharMatcher)object2);
            char c10 = '/';
            ((MediaType$Tokenizer)object).consumeCharacter(c10);
            object2 = ((MediaType$Tokenizer)object).consumeToken((CharMatcher)object2);
            ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
            while (true) {
                boolean bl2;
                if (!(bl2 = ((MediaType$Tokenizer)object).hasMore())) {
                    object = immutableListMultimap$Builder.build();
                    return MediaType.create(string3, (String)object2, (Multimap)object);
                }
                Object object3 = LINEAR_WHITE_SPACE;
                ((MediaType$Tokenizer)object).consumeTokenIfPresent((CharMatcher)object3);
                char c11 = ';';
                ((MediaType$Tokenizer)object).consumeCharacter(c11);
                ((MediaType$Tokenizer)object).consumeTokenIfPresent((CharMatcher)object3);
                object3 = TOKEN_MATCHER;
                String string4 = ((MediaType$Tokenizer)object).consumeToken((CharMatcher)object3);
                char c12 = '=';
                ((MediaType$Tokenizer)object).consumeCharacter(c12);
                c12 = ((MediaType$Tokenizer)object).previewChar();
                char c13 = '\"';
                if (c13 != c12) {
                    object3 = ((MediaType$Tokenizer)object).consumeToken((CharMatcher)object3);
                } else {
                    ((MediaType$Tokenizer)object).consumeCharacter(c13);
                    object3 = new StringBuilder();
                    while (c13 != (c12 = ((MediaType$Tokenizer)object).previewChar())) {
                        Object object4;
                        char c14 = '\\';
                        c12 = ((MediaType$Tokenizer)object).previewChar();
                        if (c14 == c12) {
                            ((MediaType$Tokenizer)object).consumeCharacter(c14);
                            object4 = CharMatcher.ascii();
                            c12 = ((MediaType$Tokenizer)object).consumeCharacter((CharMatcher)object4);
                            ((StringBuilder)object3).append(c12);
                            continue;
                        }
                        object4 = QUOTED_TEXT_MATCHER;
                        object4 = ((MediaType$Tokenizer)object).consumeToken((CharMatcher)object4);
                        ((StringBuilder)object3).append((String)object4);
                    }
                    object3 = ((StringBuilder)object3).toString();
                    ((MediaType$Tokenizer)object).consumeCharacter(c13);
                }
                immutableListMultimap$Builder.put(string4, object3);
            }
        }
        catch (IllegalStateException illegalStateException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not parse '");
            stringBuilder.append(string2);
            stringBuilder.append("'");
            string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2, illegalStateException);
            throw illegalArgumentException;
        }
    }

    public Optional charset() {
        Serializable serializable = this.parsedCharset;
        if (serializable == null) {
            boolean bl2;
            Object object = Optional.absent();
            Object object2 = this.parameters;
            String string2 = CHARSET_ATTRIBUTE;
            object2 = ((ImmutableList)((ImmutableListMultimap)object2).get(string2)).iterator();
            Optional optional = object;
            object = null;
            serializable = optional;
            while (bl2 = object2.hasNext()) {
                string2 = (String)object2.next();
                if (object == null) {
                    serializable = Optional.of(Charset.forName(string2));
                    object = string2;
                    continue;
                }
                boolean bl3 = ((String)object).equals(string2);
                if (bl3) continue;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Multiple charset values defined: ");
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(", ");
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
                serializable = new IllegalStateException((String)object);
                throw serializable;
            }
            this.parsedCharset = serializable;
        }
        return serializable;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof MediaType;
        if (bl3) {
            boolean bl4;
            object = (MediaType)object;
            Object object2 = this.type;
            String string2 = ((MediaType)object).type;
            bl3 = ((String)object2).equals(string2);
            if (!(bl3 && (bl3 = ((String)(object2 = this.subtype)).equals(string2 = ((MediaType)object).subtype)) && (bl4 = (object2 = this.parametersAsMap()).equals(object = super.parametersAsMap())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean hasWildcard() {
        String string2 = WILDCARD;
        String string3 = this.type;
        boolean bl2 = string2.equals(string3);
        if (!bl2 && !(bl2 = string2.equals(string3 = this.subtype))) {
            bl2 = false;
            string3 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            Object object;
            Object[] objectArray = new Object[3];
            objectArray[0] = object = this.type;
            objectArray[1] = object = this.subtype;
            int n11 = 2;
            objectArray[n11] = object = this.parametersAsMap();
            this.hashCode = n10 = Objects.hashCode(objectArray);
        }
        return n10;
    }

    public boolean is(MediaType object) {
        boolean bl2;
        String string2;
        Object object2 = ((MediaType)object).type;
        String string3 = WILDCARD;
        boolean bl3 = ((String)object2).equals(string3);
        if ((bl3 || (bl3 = ((String)(object2 = ((MediaType)object).type)).equals(string2 = this.type))) && ((bl3 = ((String)(object2 = ((MediaType)object).subtype)).equals(string3)) || (bl3 = ((String)(object2 = ((MediaType)object).subtype)).equals(string3 = this.subtype))) && (bl2 = ((AbstractCollection)(object2 = this.parameters.entries())).containsAll((Collection<?>)(object = ((MediaType)object).parameters.entries())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public ImmutableListMultimap parameters() {
        return this.parameters;
    }

    public String subtype() {
        return this.subtype;
    }

    public String toString() {
        String string2 = this.toString;
        if (string2 == null) {
            this.toString = string2 = this.computeToString();
        }
        return string2;
    }

    public String type() {
        return this.type;
    }

    public MediaType withCharset(Charset object) {
        Preconditions.checkNotNull(object);
        Object object2 = ((Charset)object).name();
        object2 = this.withParameter(CHARSET_ATTRIBUTE, (String)object2);
        ((MediaType)object2).parsedCharset = object = Optional.of(object);
        return object2;
    }

    public MediaType withParameter(String string2, String object) {
        object = ImmutableSet.of(object);
        return this.withParameters(string2, (Iterable)object);
    }

    public MediaType withParameters(Multimap multimap) {
        String string2 = this.type;
        String string3 = this.subtype;
        return MediaType.create(string2, string3, multimap);
    }

    public MediaType withParameters(String object, Iterable object2) {
        boolean bl2;
        Object object3;
        boolean bl3;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        object = MediaType.normalizeToken((String)object);
        Object object4 = ImmutableListMultimap.builder();
        Object object5 = this.parameters.entries().iterator();
        while (bl3 = object5.hasNext()) {
            object3 = (Map.Entry)object5.next();
            String string2 = (String)object3.getKey();
            boolean bl4 = ((String)object).equals(string2);
            if (bl4) continue;
            object3 = object3.getValue();
            ((ImmutableListMultimap$Builder)object4).put(string2, object3);
        }
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            object5 = (String)object2.next();
            object5 = MediaType.normalizeParameterValue((String)object, (String)object5);
            ((ImmutableListMultimap$Builder)object4).put(object, object5);
        }
        object5 = this.type;
        object3 = this.subtype;
        object4 = ((ImmutableListMultimap$Builder)object4).build();
        object2 = new MediaType((String)object5, (String)object3, (ImmutableListMultimap)object4);
        object4 = CHARSET_ATTRIBUTE;
        boolean bl5 = ((String)object).equals(object4);
        if (!bl5) {
            ((MediaType)object2).parsedCharset = object = this.parsedCharset;
        }
        return (MediaType)MoreObjects.firstNonNull(KNOWN_TYPES.get(object2), object2);
    }

    public MediaType withoutParameters() {
        Object object = this.parameters;
        boolean bl2 = ((ImmutableMultimap)object).isEmpty();
        if (bl2) {
            object = this;
        } else {
            object = this.type;
            String string2 = this.subtype;
            object = MediaType.create((String)object, string2);
        }
        return object;
    }
}

