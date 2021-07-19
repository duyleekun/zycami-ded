/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.util;

import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;
import java.util.Map;

public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    private static final String EXTENSION_AAC = ".aac";
    private static final String EXTENSION_AC3 = ".ac3";
    private static final String EXTENSION_AC4 = ".ac4";
    private static final String EXTENSION_ADTS = ".adts";
    private static final String EXTENSION_AMR = ".amr";
    private static final String EXTENSION_EC3 = ".ec3";
    private static final String EXTENSION_FLAC = ".flac";
    private static final String EXTENSION_FLV = ".flv";
    private static final String EXTENSION_JPEG = ".jpeg";
    private static final String EXTENSION_JPG = ".jpg";
    private static final String EXTENSION_M2P = ".m2p";
    private static final String EXTENSION_MP3 = ".mp3";
    private static final String EXTENSION_MP4 = ".mp4";
    private static final String EXTENSION_MPEG = ".mpeg";
    private static final String EXTENSION_MPG = ".mpg";
    private static final String EXTENSION_OPUS = ".opus";
    private static final String EXTENSION_PREFIX_CMF = ".cmf";
    private static final String EXTENSION_PREFIX_M4 = ".m4";
    private static final String EXTENSION_PREFIX_MK = ".mk";
    private static final String EXTENSION_PREFIX_MP4 = ".mp4";
    private static final String EXTENSION_PREFIX_OG = ".og";
    private static final String EXTENSION_PREFIX_TS = ".ts";
    private static final String EXTENSION_PS = ".ps";
    private static final String EXTENSION_TS = ".ts";
    private static final String EXTENSION_VTT = ".vtt";
    private static final String EXTENSION_WAV = ".wav";
    private static final String EXTENSION_WAVE = ".wave";
    private static final String EXTENSION_WEBM = ".webm";
    private static final String EXTENSION_WEBVTT = ".webvtt";
    public static final int FLAC = 4;
    public static final int FLV = 5;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final int JPEG = 14;
    public static final int MATROSKA = 6;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;
    public static final int PS = 10;
    public static final int TS = 11;
    public static final int UNKNOWN = 255;
    public static final int WAV = 12;
    public static final int WEBVTT = 13;

    private FileTypes() {
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int inferFileTypeFromMimeType(String string2) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        int n20;
        int n21;
        int n22;
        int n23;
        int n24;
        block43: {
            String string3;
            block44: {
                n24 = -1;
                if (string2 == null) {
                    return n24;
                }
                string3 = MimeTypes.normalizeMimeType(string2);
                string3.hashCode();
                int n25 = string3.hashCode();
                n23 = 14;
                n22 = 13;
                n21 = 12;
                n20 = 11;
                n19 = 10;
                n18 = 9;
                n17 = 8;
                n16 = 7;
                n15 = 6;
                n14 = 5;
                n13 = 4;
                n12 = 3;
                n11 = 1;
                switch (n25) {
                    case 2039520277: {
                        String string4 = "video/x-matroska";
                        n10 = (int)(string3.equals(string4) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 23;
                        break block43;
                    }
                    case 1505118770: {
                        String string5 = "audio/webm";
                        n10 = (int)(string3.equals(string5) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 22;
                        break block43;
                    }
                    case 1504831518: {
                        String string6 = "audio/mpeg";
                        n10 = (int)(string3.equals(string6) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 21;
                        break block43;
                    }
                    case 1504619009: {
                        String string7 = "audio/flac";
                        n10 = (int)(string3.equals(string7) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 20;
                        break block43;
                    }
                    case 1504578661: {
                        String string8 = "audio/eac3";
                        n10 = (int)(string3.equals(string8) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 19;
                        break block43;
                    }
                    case 1503095341: {
                        String string9 = "audio/3gpp";
                        n10 = (int)(string3.equals(string9) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 18;
                        break block43;
                    }
                    case 1331848029: {
                        String string10 = "video/mp4";
                        n10 = (int)(string3.equals(string10) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 17;
                        break block43;
                    }
                    case 187099443: {
                        String string11 = "audio/wav";
                        n10 = (int)(string3.equals(string11) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 16;
                        break block43;
                    }
                    case 187091926: {
                        String string12 = "audio/ogg";
                        n10 = (int)(string3.equals(string12) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 15;
                        break block43;
                    }
                    case 187090232: {
                        String string13 = "audio/mp4";
                        n10 = (int)(string3.equals(string13) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n23;
                        break block43;
                    }
                    case 187078669: {
                        String string14 = "audio/amr";
                        n10 = (int)(string3.equals(string14) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n22;
                        break block43;
                    }
                    case 187078297: {
                        String string15 = "audio/ac4";
                        n10 = (int)(string3.equals(string15) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n21;
                        break block43;
                    }
                    case 187078296: {
                        String string16 = "audio/ac3";
                        n10 = (int)(string3.equals(string16) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n20;
                        break block43;
                    }
                    case 13915911: {
                        String string17 = "video/x-flv";
                        n10 = (int)(string3.equals(string17) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n19;
                        break block43;
                    }
                    case -43467528: {
                        String string18 = "application/webm";
                        n10 = (int)(string3.equals(string18) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n18;
                        break block43;
                    }
                    case -387023398: {
                        String string19 = "audio/x-matroska";
                        n10 = (int)(string3.equals(string19) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n17;
                        break block43;
                    }
                    case -1004728940: {
                        String string20 = "text/vtt";
                        n10 = (int)(string3.equals(string20) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n16;
                        break block43;
                    }
                    case -1248337486: {
                        String string21 = "application/mp4";
                        n10 = (int)(string3.equals(string21) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n15;
                        break block43;
                    }
                    case -1487394660: {
                        String string22 = "image/jpeg";
                        n10 = (int)(string3.equals(string22) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n14;
                        break block43;
                    }
                    case -1606874997: {
                        String string23 = "audio/amr-wb";
                        n10 = (int)(string3.equals(string23) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n13;
                        break block43;
                    }
                    case -1662095187: {
                        String string24 = "video/webm";
                        n10 = (int)(string3.equals(string24) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n12;
                        break block43;
                    }
                    case -1662384007: {
                        String string25 = "video/mp2t";
                        n10 = (int)(string3.equals(string25) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = 2;
                        break block43;
                    }
                    case -1662384011: {
                        String string26 = "video/mp2p";
                        n10 = (int)(string3.equals(string26) ? 1 : 0);
                        if (n10 == 0) break;
                        n10 = n11;
                        break block43;
                    }
                    case -2123537834: {
                        String string27 = "audio/eac3-joc";
                        n10 = (int)(string3.equals(string27) ? 1 : 0);
                        if (n10 != 0) break block44;
                    }
                }
                n10 = n24;
                break block43;
            }
            n10 = 0;
            string3 = null;
        }
        switch (n10) {
            default: {
                return n24;
            }
            case 21: {
                return n16;
            }
            case 20: {
                return n13;
            }
            case 16: {
                return n21;
            }
            case 15: {
                return n18;
            }
            case 12: {
                return n11;
            }
            case 10: {
                return n14;
            }
            case 7: {
                return n22;
            }
            case 6: 
            case 14: 
            case 17: {
                return n17;
            }
            case 5: {
                return n23;
            }
            case 4: 
            case 13: 
            case 18: {
                return n12;
            }
            case 3: 
            case 8: 
            case 9: 
            case 22: 
            case 23: {
                return n15;
            }
            case 2: {
                return n20;
            }
            case 1: {
                return n19;
            }
            case 0: 
            case 11: 
            case 19: 
        }
        return 0;
    }

    public static int inferFileTypeFromResponseHeaders(Map object) {
        boolean bl2;
        String string2 = HEADER_CONTENT_TYPE;
        if ((object = (List)object.get(string2)) != null && !(bl2 = object.isEmpty())) {
            bl2 = false;
            string2 = null;
            object = (String)object.get(0);
        } else {
            object = null;
        }
        return FileTypes.inferFileTypeFromMimeType((String)object);
    }

    public static int inferFileTypeFromUri(Uri object) {
        boolean bl2;
        object = object.getLastPathSegment();
        int n10 = -1;
        if (object == null) {
            return n10;
        }
        String string2 = EXTENSION_AC3;
        boolean n11 = ((String)object).endsWith(string2);
        if (!n11 && !(bl2 = ((String)object).endsWith(string2 = EXTENSION_EC3))) {
            boolean bl3;
            string2 = EXTENSION_AC4;
            boolean bl4 = ((String)object).endsWith(string2);
            if (bl4) {
                return 1;
            }
            string2 = EXTENSION_ADTS;
            boolean bl5 = ((String)object).endsWith(string2);
            if (!bl5 && !(bl3 = ((String)object).endsWith(string2 = EXTENSION_AAC))) {
                boolean bl6;
                string2 = EXTENSION_AMR;
                boolean bl7 = ((String)object).endsWith(string2);
                if (bl7) {
                    return 3;
                }
                string2 = EXTENSION_FLAC;
                boolean bl8 = ((String)object).endsWith(string2);
                int n12 = 4;
                if (bl8) {
                    return n12;
                }
                string2 = EXTENSION_FLV;
                boolean bl9 = ((String)object).endsWith(string2);
                int n13 = 5;
                if (bl9) {
                    return n13;
                }
                String string3 = EXTENSION_PREFIX_MK;
                int n14 = ((String)object).length() - n12;
                boolean bl10 = ((String)object).startsWith(string3, n14);
                if (!bl10 && !(bl6 = ((String)object).endsWith(string2 = EXTENSION_WEBM))) {
                    int n15;
                    String string4;
                    boolean bl11;
                    int n16;
                    boolean bl12;
                    int n17;
                    String string5;
                    boolean bl13;
                    string2 = EXTENSION_MP3;
                    boolean bl14 = ((String)object).endsWith(string2);
                    if (bl14) {
                        return 7;
                    }
                    string2 = ".mp4";
                    boolean bl15 = ((String)object).endsWith(string2);
                    if (!(bl15 || (bl13 = ((String)object).startsWith(string5 = EXTENSION_PREFIX_M4, n17 = ((String)object).length() - n12)) || (bl12 = ((String)object).startsWith(string2, n16 = ((String)object).length() - n13)) || (bl11 = ((String)object).startsWith(string4 = EXTENSION_PREFIX_CMF, n15 = ((String)object).length() - n13)))) {
                        boolean bl16;
                        string4 = EXTENSION_PREFIX_OG;
                        int n18 = ((String)object).length() - n12;
                        boolean bl17 = ((String)object).startsWith(string4, n18);
                        if (!bl17 && !(bl16 = ((String)object).endsWith(string2 = EXTENSION_OPUS))) {
                            boolean bl18;
                            boolean bl19;
                            boolean bl20;
                            string2 = EXTENSION_PS;
                            boolean bl21 = ((String)object).endsWith(string2);
                            if (!(bl21 || (bl20 = ((String)object).endsWith(string2 = EXTENSION_MPEG)) || (bl19 = ((String)object).endsWith(string2 = EXTENSION_MPG)) || (bl18 = ((String)object).endsWith(string2 = EXTENSION_M2P)))) {
                                boolean bl22;
                                string2 = ".ts";
                                n13 = (int)(((String)object).endsWith(string2) ? 1 : 0);
                                if (n13 == 0 && !(bl22 = ((String)object).startsWith(string2, n13 = ((String)object).length() - n12))) {
                                    boolean bl23;
                                    string2 = EXTENSION_WAV;
                                    boolean bl24 = ((String)object).endsWith(string2);
                                    if (!bl24 && !(bl23 = ((String)object).endsWith(string2 = EXTENSION_WAVE))) {
                                        boolean bl25;
                                        string2 = EXTENSION_VTT;
                                        boolean bl26 = ((String)object).endsWith(string2);
                                        if (!bl26 && !(bl25 = ((String)object).endsWith(string2 = EXTENSION_WEBVTT))) {
                                            boolean bl27;
                                            string2 = EXTENSION_JPG;
                                            boolean bl28 = ((String)object).endsWith(string2);
                                            if (!bl28 && !(bl27 = ((String)object).endsWith(string2 = EXTENSION_JPEG))) {
                                                return n10;
                                            }
                                            return 14;
                                        }
                                        return 13;
                                    }
                                    return 12;
                                }
                                return 11;
                            }
                            return 10;
                        }
                        return 9;
                    }
                    return 8;
                }
                return 6;
            }
            return 2;
        }
        return 0;
    }
}

