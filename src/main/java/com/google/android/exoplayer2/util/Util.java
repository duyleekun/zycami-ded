/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.UiModeManager
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.database.DatabaseUtils
 *  android.database.sqlite.SQLiteDatabase
 *  android.graphics.Point
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.SystemClock
 *  android.security.NetworkSecurityPolicy
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.SparseLongArray
 *  android.view.Display
 *  android.view.WindowManager
 */
package com.google.android.exoplayer2.util;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseLongArray;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.MediaItem$Subtitle;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.base.Charsets;
import d.h.a.a.r0.e;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class Util {
    private static final int[] CRC32_BYTES_MSBF;
    private static final int[] CRC8_BYTES_MSBF;
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    public static final byte[] EMPTY_BYTE_ARRAY;
    private static final Pattern ESCAPED_CHARACTER_PATTERN;
    private static final String ISM_DASH_FORMAT_EXTENSION = "format=mpd-time-csf";
    private static final String ISM_HLS_FORMAT_EXTENSION = "format=m3u8-aapl";
    private static final Pattern ISM_URL_PATTERN;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT = 0;
    private static final String TAG = "Util";
    private static final Pattern XS_DATE_TIME_PATTERN;
    private static final Pattern XS_DURATION_PATTERN;
    private static final String[] additionalIsoLanguageReplacements;
    private static final String[] isoLegacyTagReplacements;
    private static HashMap languageTagReplacementMap;

    static {
        String string2;
        String string3;
        int n10;
        String string4 = "S";
        Object object = Build.VERSION.CODENAME;
        boolean bl2 = string4.equals(object);
        n10 = bl2 ? 31 : ((n10 = (int)((string4 = "R").equals(object) ? 1 : 0)) != 0 ? 30 : Build.VERSION.SDK_INT);
        SDK_INT = n10;
        DEVICE = string4 = Build.DEVICE;
        MANUFACTURER = string3 = Build.MANUFACTURER;
        MODEL = string2 = Build.MODEL;
        int n11 = String.valueOf(string4).length() + 17;
        int n12 = String.valueOf(string2).length();
        n11 += n12;
        n12 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n12);
        stringBuilder.append(string4);
        string4 = ", ";
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        stringBuilder.append(n10);
        DEVICE_DEBUG_INFO = stringBuilder.toString();
        EMPTY_BYTE_ARRAY = new byte[0];
        XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
        ISM_URL_PATTERN = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        additionalIsoLanguageReplacements = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        isoLegacyTagReplacements = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        Object object2 = object = (Object)new int[256];
        object2[0] = false;
        object2[1] = 79764919;
        object2[2] = 159529838;
        object2[3] = 222504665;
        object2[4] = 319059676;
        object2[5] = 398814059;
        object2[6] = 445009330;
        object2[7] = 507990021;
        object2[8] = 638119352;
        object2[9] = 583659535;
        object2[10] = 797628118;
        object2[11] = 726387553;
        object2[12] = 890018660;
        object2[13] = 835552979;
        object2[14] = 1015980042;
        object2[15] = 944750013;
        object2[16] = 1276238704;
        object2[17] = 1221641927;
        object2[18] = 1167319070;
        object2[19] = 1095957929;
        object2[20] = 1595256236;
        object2[21] = 1540665371;
        object2[22] = 1452775106;
        object2[23] = 1381403509;
        object2[24] = 1780037320;
        object2[25] = 1859660671;
        object2[26] = 1671105958;
        object2[27] = 1733955601;
        object2[28] = 2031960084;
        object2[29] = 2111593891;
        object2[30] = 1889500026;
        object2[31] = 1952343757;
        object2[32] = -1742489888;
        object2[33] = -1662866601;
        object2[34] = -1851683442;
        object2[35] = -1788833735;
        object2[36] = -1960329156;
        object2[37] = -1880695413;
        object2[38] = -2103051438;
        object2[39] = -2040207643;
        object2[40] = -1104454824;
        object2[41] = -1159051537;
        object2[42] = -1213636554;
        object2[43] = -1284997759;
        object2[44] = -1389417084;
        object2[45] = -1444007885;
        object2[46] = -1532160278;
        object2[47] = -1603531939;
        object2[48] = -734892656;
        object2[49] = -789352409;
        object2[50] = -575645954;
        object2[51] = -646886583;
        object2[52] = -952755380;
        object2[53] = -1007220997;
        object2[54] = -827056094;
        object2[55] = -898286187;
        object2[56] = -231047128;
        object2[57] = -151282273;
        object2[58] = -71779514;
        object2[59] = -8804623;
        object2[60] = -515967244;
        object2[61] = -436212925;
        object2[62] = -390279782;
        object2[63] = -327299027;
        object2[64] = 881225847;
        object2[65] = 809987520;
        object2[66] = 1023691545;
        object2[67] = 969234094;
        object2[68] = 662832811;
        object2[69] = 591600412;
        object2[70] = 771767749;
        object2[71] = 717299826;
        object2[72] = 311336399;
        object2[73] = 374308984;
        object2[74] = 453813921;
        object2[75] = 533576470;
        object2[76] = 25881363;
        object2[77] = 88864420;
        object2[78] = 134795389;
        object2[79] = 214552010;
        object2[80] = 2023205639;
        object2[81] = 2086057648;
        object2[82] = 1897238633;
        object2[83] = 1976864222;
        object2[84] = 1804852699;
        object2[85] = 1867694188;
        object2[86] = 1645340341;
        object2[87] = 1724971778;
        object2[88] = 1587496639;
        object2[89] = 1516133128;
        object2[90] = 1461550545;
        object2[91] = 1406951526;
        object2[92] = 1302016099;
        object2[93] = 1230646740;
        object2[94] = 1142491917;
        object2[95] = 1087903418;
        object2[96] = -1398421865;
        object2[97] = -1469785312;
        object2[98] = -1524105735;
        object2[99] = -1578704818;
        object2[100] = -1079922613;
        object2[101] = -1151291908;
        object2[102] = -1239184603;
        object2[103] = -1293773166;
        object2[104] = -1968362705;
        object2[105] = -1905510760;
        object2[106] = -2094067647;
        object2[107] = -2014441994;
        object2[108] = -1716953613;
        object2[109] = -1654112188;
        object2[110] = -1876203875;
        object2[111] = -1796572374;
        object2[112] = -525066777;
        object2[113] = -462094256;
        object2[114] = -382327159;
        object2[115] = -302564546;
        object2[116] = -206542021;
        object2[117] = -143559028;
        object2[118] = -97365931;
        object2[119] = -17609246;
        object2[120] = -960696225;
        object2[121] = -1031934488;
        object2[122] = -817968335;
        object2[123] = -872425850;
        object2[124] = -709327229;
        object2[125] = -780559564;
        object2[126] = -600130067;
        object2[127] = -654598054;
        object2[128] = 1762451694;
        object2[129] = 1842216281;
        object2[130] = 1619975040;
        object2[131] = 1682949687;
        object2[132] = 2047383090;
        object2[133] = 2127137669;
        object2[134] = 1938468188;
        object2[135] = 2001449195;
        object2[136] = 1325665622;
        object2[137] = 1271206113;
        object2[138] = 1183200824;
        object2[139] = 1111960463;
        object2[140] = 1543535498;
        object2[141] = 1489069629;
        object2[142] = 1434599652;
        object2[143] = 1363369299;
        object2[144] = 622672798;
        object2[145] = 568075817;
        object2[146] = 748617968;
        object2[147] = 677256519;
        object2[148] = 907627842;
        object2[149] = 853037301;
        object2[150] = 1067152940;
        object2[151] = 995781531;
        object2[152] = 51762726;
        object2[153] = 131386257;
        object2[154] = 177728840;
        object2[155] = 240578815;
        object2[156] = 269590778;
        object2[157] = 349224269;
        object2[158] = 429104020;
        object2[159] = 491947555;
        object2[160] = -248556018;
        object2[161] = -168932423;
        object2[162] = -122852000;
        object2[163] = -60002089;
        object2[164] = -500490030;
        object2[165] = -420856475;
        object2[166] = -341238852;
        object2[167] = -278395381;
        object2[168] = -685261898;
        object2[169] = -739858943;
        object2[170] = -559578920;
        object2[171] = -630940305;
        object2[172] = -1004286614;
        object2[173] = -1058877219;
        object2[174] = -845023740;
        object2[175] = -916395085;
        object2[176] = -1119974018;
        object2[177] = -1174433591;
        object2[178] = -1262701040;
        object2[179] = -1333941337;
        object2[180] = -1371866206;
        object2[181] = -1426332139;
        object2[182] = -1481064244;
        object2[183] = -1552294533;
        object2[184] = -1690935098;
        object2[185] = -1611170447;
        object2[186] = -1833673816;
        object2[187] = -1770699233;
        object2[188] = -2009983462;
        object2[189] = -1930228819;
        object2[190] = -2119160460;
        object2[191] = -2056179517;
        object2[192] = 1569362073;
        object2[193] = 1498123566;
        object2[194] = 1409854455;
        object2[195] = 1355396672;
        object2[196] = 1317987909;
        object2[197] = 1246755826;
        object2[198] = 1192025387;
        object2[199] = 1137557660;
        object2[200] = 2072149281;
        object2[201] = 2135122070;
        object2[202] = 1912620623;
        object2[203] = 1992383480;
        object2[204] = 1753615357;
        object2[205] = 1816598090;
        object2[206] = 1627664531;
        object2[207] = 1707420964;
        object2[208] = 295390185;
        object2[209] = 358241886;
        object2[210] = 404320391;
        object2[211] = 483945776;
        object2[212] = 43990325;
        object2[213] = 106832002;
        object2[214] = 186451547;
        object2[215] = 266083308;
        object2[216] = 932423249;
        object2[217] = 861060070;
        object2[218] = 1041341759;
        object2[219] = 986742920;
        object2[220] = 613929101;
        object2[221] = 542559546;
        object2[222] = 756411363;
        object2[223] = 701822548;
        object2[224] = -978770311;
        object2[225] = -1050133554;
        object2[226] = -869589737;
        object2[227] = -924188512;
        object2[228] = -693284699;
        object2[229] = -764654318;
        object2[230] = -550540341;
        object2[231] = -605129092;
        object2[232] = -475935807;
        object2[233] = -413084042;
        object2[234] = -366743377;
        object2[235] = -287118056;
        object2[236] = -257573603;
        object2[237] = -194731862;
        object2[238] = -114850189;
        object2[239] = -35218492;
        object2[240] = -1984365303;
        object2[241] = -1921392450;
        object2[242] = -2143631769;
        object2[243] = -2063868976;
        object2[244] = -1698919467;
        object2[245] = -1635936670;
        object2[246] = -1824608069;
        object2[247] = -1744851700;
        object2[248] = -1347415887;
        object2[249] = -1418654458;
        object2[250] = -1506661409;
        object2[251] = -1561119128;
        object2[252] = -1129027987;
        object2[253] = -1200260134;
        object2[254] = -1254728445;
        object2[255] = -1309196108;
        CRC32_BYTES_MSBF = (int[])object;
        Object object3 = object = (Object)new int[256];
        object3[0] = false;
        object3[1] = 7;
        object3[2] = 14;
        object3[3] = 9;
        object3[4] = 28;
        object3[5] = 27;
        object3[6] = 18;
        object3[7] = 21;
        object3[8] = 56;
        object3[9] = 63;
        object3[10] = 54;
        object3[11] = 49;
        object3[12] = 36;
        object3[13] = 35;
        object3[14] = 42;
        object3[15] = 45;
        object3[16] = 112;
        object3[17] = 119;
        object3[18] = 126;
        object3[19] = 121;
        object3[20] = 108;
        object3[21] = 107;
        object3[22] = 98;
        object3[23] = 101;
        object3[24] = 72;
        object3[25] = 79;
        object3[26] = 70;
        object3[27] = 65;
        object3[28] = 84;
        object3[29] = 83;
        object3[30] = 90;
        object3[31] = 93;
        object3[32] = 224;
        object3[33] = 231;
        object3[34] = 238;
        object3[35] = 233;
        object3[36] = 252;
        object3[37] = 251;
        object3[38] = 242;
        object3[39] = 245;
        object3[40] = 216;
        object3[41] = 223;
        object3[42] = 214;
        object3[43] = 209;
        object3[44] = 196;
        object3[45] = 195;
        object3[46] = 202;
        object3[47] = 205;
        object3[48] = 144;
        object3[49] = 151;
        object3[50] = 158;
        object3[51] = 153;
        object3[52] = 140;
        object3[53] = 139;
        object3[54] = 130;
        object3[55] = 133;
        object3[56] = 168;
        object3[57] = 175;
        object3[58] = 166;
        object3[59] = 161;
        object3[60] = 180;
        object3[61] = 179;
        object3[62] = 186;
        object3[63] = 189;
        object3[64] = 199;
        object3[65] = 192;
        object3[66] = 201;
        object3[67] = 206;
        object3[68] = 219;
        object3[69] = 220;
        object3[70] = 213;
        object3[71] = 210;
        object3[72] = 255;
        object3[73] = 248;
        object3[74] = 241;
        object3[75] = 246;
        object3[76] = 227;
        object3[77] = 228;
        object3[78] = 237;
        object3[79] = 234;
        object3[80] = 183;
        object3[81] = 176;
        object3[82] = 185;
        object3[83] = 190;
        object3[84] = 171;
        object3[85] = 172;
        object3[86] = 165;
        object3[87] = 162;
        object3[88] = 143;
        object3[89] = 136;
        object3[90] = 129;
        object3[91] = 134;
        object3[92] = 147;
        object3[93] = 148;
        object3[94] = 157;
        object3[95] = 154;
        object3[96] = 39;
        object3[97] = 32;
        object3[98] = 41;
        object3[99] = 46;
        object3[100] = 59;
        object3[101] = 60;
        object3[102] = 53;
        object3[103] = 50;
        object3[104] = 31;
        object3[105] = 24;
        object3[106] = 17;
        object3[107] = 22;
        object3[108] = 3;
        object3[109] = 4;
        object3[110] = 13;
        object3[111] = 10;
        object3[112] = 87;
        object3[113] = 80;
        object3[114] = 89;
        object3[115] = 94;
        object3[116] = 75;
        object3[117] = 76;
        object3[118] = 69;
        object3[119] = 66;
        object3[120] = 111;
        object3[121] = 104;
        object3[122] = 97;
        object3[123] = 102;
        object3[124] = 115;
        object3[125] = 116;
        object3[126] = 125;
        object3[127] = 122;
        object3[128] = 137;
        object3[129] = 142;
        object3[130] = 135;
        object3[131] = 128;
        object3[132] = 149;
        object3[133] = 146;
        object3[134] = 155;
        object3[135] = 156;
        object3[136] = 177;
        object3[137] = 182;
        object3[138] = 191;
        object3[139] = 184;
        object3[140] = 173;
        object3[141] = 170;
        object3[142] = 163;
        object3[143] = 164;
        object3[144] = 249;
        object3[145] = 254;
        object3[146] = 247;
        object3[147] = 240;
        object3[148] = 229;
        object3[149] = 226;
        object3[150] = 235;
        object3[151] = 236;
        object3[152] = 193;
        object3[153] = 198;
        object3[154] = 207;
        object3[155] = 200;
        object3[156] = 221;
        object3[157] = 218;
        object3[158] = 211;
        object3[159] = 212;
        object3[160] = 105;
        object3[161] = 110;
        object3[162] = 103;
        object3[163] = 96;
        object3[164] = 117;
        object3[165] = 114;
        object3[166] = 123;
        object3[167] = 124;
        object3[168] = 81;
        object3[169] = 86;
        object3[170] = 95;
        object3[171] = 88;
        object3[172] = 77;
        object3[173] = 74;
        object3[174] = 67;
        object3[175] = 68;
        object3[176] = 25;
        object3[177] = 30;
        object3[178] = 23;
        object3[179] = 16;
        object3[180] = 5;
        object3[181] = 2;
        object3[182] = 11;
        object3[183] = 12;
        object3[184] = 33;
        object3[185] = 38;
        object3[186] = 47;
        object3[187] = 40;
        object3[188] = 61;
        object3[189] = 58;
        object3[190] = 51;
        object3[191] = 52;
        object3[192] = 78;
        object3[193] = 73;
        object3[194] = 64;
        object3[195] = 71;
        object3[196] = 82;
        object3[197] = 85;
        object3[198] = 92;
        object3[199] = 91;
        object3[200] = 118;
        object3[201] = 113;
        object3[202] = 120;
        object3[203] = 127;
        object3[204] = 106;
        object3[205] = 109;
        object3[206] = 100;
        object3[207] = 99;
        object3[208] = 62;
        object3[209] = 57;
        object3[210] = 48;
        object3[211] = 55;
        object3[212] = 34;
        object3[213] = 37;
        object3[214] = 44;
        object3[215] = 43;
        object3[216] = 6;
        object3[217] = true;
        object3[218] = 8;
        object3[219] = 15;
        object3[220] = 26;
        object3[221] = 29;
        object3[222] = 20;
        object3[223] = 19;
        object3[224] = 174;
        object3[225] = 169;
        object3[226] = 160;
        object3[227] = 167;
        object3[228] = 178;
        object3[229] = 181;
        object3[230] = 188;
        object3[231] = 187;
        object3[232] = 150;
        object3[233] = 145;
        object3[234] = 152;
        object3[235] = 159;
        object3[236] = 138;
        object3[237] = 141;
        object3[238] = 132;
        object3[239] = 131;
        object3[240] = 222;
        object3[241] = 217;
        object3[242] = 208;
        object3[243] = 215;
        object3[244] = 194;
        object3[245] = 197;
        object3[246] = 204;
        object3[247] = 203;
        object3[248] = 230;
        object3[249] = 225;
        object3[250] = 232;
        object3[251] = 239;
        object3[252] = 250;
        object3[253] = 253;
        object3[254] = 244;
        object3[255] = 243;
        CRC8_BYTES_MSBF = (int[])object;
    }

    private Util() {
    }

    public static /* synthetic */ Thread a(String string2, Runnable runnable) {
        Thread thread = new Thread(runnable, string2);
        return thread;
    }

    public static long addWithOverflowDefault(long l10, long l11, long l12) {
        long l13 = l10 + l11;
        l10 ^= l13;
        l11 ^= l13;
        long l14 = (l10 &= l11) - (l11 = 0L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0) {
            return l12;
        }
        return l13;
    }

    public static boolean areEqual(Object object, Object object2) {
        boolean bl2;
        if (object == null) {
            if (object2 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
        } else {
            bl2 = object.equals(object2);
        }
        return bl2;
    }

    public static int binarySearchCeil(List list, Comparable comparable, boolean bl2, boolean bl3) {
        int n10;
        int n11 = Collections.binarySearch(list, comparable);
        if (n11 < 0) {
            n10 = ~n11;
        } else {
            Comparable comparable2;
            int n12;
            int n13 = list.size();
            while (++n11 < n13 && (n12 = (comparable2 = (Comparable)list.get(n11)).compareTo(comparable)) == 0) {
            }
            n10 = bl2 ? n11 + -1 : n11;
        }
        if (bl3) {
            int n14 = list.size() + -1;
            n10 = Math.min(n14, n10);
        }
        return n10;
    }

    public static int binarySearchCeil(int[] nArray, int n10, boolean bl2, boolean bl3) {
        int n11 = Arrays.binarySearch(nArray, n10);
        if (n11 < 0) {
            n10 = ~n11;
        } else {
            int n12;
            while (++n11 < (n12 = nArray.length) && (n12 = nArray[n11]) == n10) {
            }
            n10 = bl2 ? n11 + -1 : n11;
        }
        if (bl3) {
            int n13 = nArray.length + -1;
            n10 = Math.min(n13, n10);
        }
        return n10;
    }

    public static int binarySearchCeil(long[] lArray, long l10, boolean bl2, boolean bl3) {
        int n10;
        int n11 = Arrays.binarySearch(lArray, l10);
        if (n11 < 0) {
            n10 = ~n11;
        } else {
            long l11;
            long l12;
            int n12;
            while (++n11 < (n12 = lArray.length) && (n12 = (int)((l12 = (l11 = lArray[n11]) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
            }
            n10 = bl2 ? n11 + -1 : n11;
        }
        if (bl3) {
            int n13 = lArray.length + -1;
            n10 = Math.min(n13, n10);
        }
        return n10;
    }

    public static int binarySearchFloor(LongArray longArray, long l10, boolean n10, boolean bl2) {
        long l11;
        long l12;
        int n11;
        int n12 = longArray.size() + -1;
        int n13 = 0;
        int n14 = 0;
        while (n14 <= n12) {
            int n15 = n14 + n12 >>> 1;
            long l13 = longArray.get(n15);
            long l14 = l13 - l10;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object < 0) {
                n14 = n15 + 1;
                continue;
            }
            n12 = n15 += -1;
        }
        if (n10 != 0 && (n10 = n12 + 1) < (n14 = longArray.size()) && (n11 = (int)((l12 = (l11 = longArray.get(n10)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
            n13 = n10;
        } else if (!bl2 || n12 != (n11 = -1)) {
            n13 = n12;
        }
        return n13;
    }

    public static int binarySearchFloor(List list, Comparable comparable, boolean bl2, boolean bl3) {
        int n10;
        int n11 = Collections.binarySearch(list, comparable);
        if (n11 < 0) {
            n10 = -(n11 += 2);
        } else {
            Comparable comparable2;
            int n12;
            while ((n11 += -1) >= 0 && (n12 = (comparable2 = (Comparable)list.get(n11)).compareTo(comparable)) == 0) {
            }
            n10 = bl2 ? n11 + 1 : n11;
        }
        if (bl3) {
            comparable = null;
            n10 = Math.max(0, n10);
        }
        return n10;
    }

    public static int binarySearchFloor(int[] nArray, int n10, boolean bl2, boolean bl3) {
        int n11;
        int n12 = Arrays.binarySearch(nArray, n10);
        if (n12 < 0) {
            n11 = -(n12 += 2);
        } else {
            int n13;
            while ((n12 += -1) >= 0 && (n13 = nArray[n12]) == n10) {
            }
            n11 = bl2 ? n12 + 1 : n12;
        }
        if (bl3) {
            n10 = 0;
            n11 = Math.max(0, n11);
        }
        return n11;
    }

    public static int binarySearchFloor(long[] lArray, long l10, boolean bl2, boolean bl3) {
        int n10;
        int n11 = Arrays.binarySearch(lArray, l10);
        if (n11 < 0) {
            n10 = -(n11 += 2);
        } else {
            long l11;
            long l12;
            long l13;
            while ((n11 += -1) >= 0 && (l13 = (l12 = (l11 = lArray[n11]) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            }
            n10 = bl2 ? n11 + 1 : n11;
        }
        if (bl3) {
            n10 = Math.max(0, n10);
        }
        return n10;
    }

    public static Object castNonNull(Object object) {
        return object;
    }

    public static Object[] castNonNullTypeArray(Object[] objectArray) {
        return objectArray;
    }

    public static int ceilDivide(int n10, int n11) {
        return (n10 + n11 + -1) / n11;
    }

    public static long ceilDivide(long l10, long l11) {
        return (l10 + l11 - 1L) / l11;
    }

    public static boolean checkCleartextTrafficPermitted(MediaItem ... mediaItemArray) {
        int n10 = SDK_INT;
        boolean bl2 = true;
        int n11 = 24;
        if (n10 < n11) {
            return bl2;
        }
        n10 = mediaItemArray.length;
        n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            List list;
            int n12;
            MediaItem mediaItem = mediaItemArray[i10];
            MediaItem$PlaybackProperties mediaItem$PlaybackProperties = mediaItem.playbackProperties;
            if (mediaItem$PlaybackProperties == null) continue;
            mediaItem$PlaybackProperties = mediaItem$PlaybackProperties.uri;
            int n13 = Util.isTrafficRestricted((Uri)mediaItem$PlaybackProperties);
            if (n13 != 0) {
                return false;
            }
            mediaItem$PlaybackProperties = null;
            for (n13 = 0; n13 < (n12 = (list = mediaItem.playbackProperties.subtitles).size()); ++n13) {
                list = ((MediaItem$Subtitle)mediaItem.playbackProperties.subtitles.get((int)n13)).uri;
                n12 = (int)(Util.isTrafficRestricted((Uri)list) ? 1 : 0);
                if (n12 == 0) continue;
                return false;
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void closeQuietly(DataSource dataSource) {
        if (dataSource == null) return;
        try {
            dataSource.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static int compareLong(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object < 0 ? (Object)-1 : (object == false ? (Object)0 : (Object)1);
        return (int)object;
    }

    public static float constrainValue(float f10, float f11, float f12) {
        f10 = Math.min(f10, f12);
        return Math.max(f11, f10);
    }

    public static int constrainValue(int n10, int n11, int n12) {
        n10 = Math.min(n10, n12);
        return Math.max(n11, n10);
    }

    public static long constrainValue(long l10, long l11, long l12) {
        l10 = Math.min(l10, l12);
        return Math.max(l11, l10);
    }

    public static boolean contains(Object[] objectArray, Object object) {
        for (Object object2 : objectArray) {
            boolean bl2 = Util.areEqual(object2, object);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static int crc32(byte[] byArray, int n10, int n11, int n12) {
        while (n10 < n11) {
            int n13 = n12 << 8;
            int[] nArray = CRC32_BYTES_MSBF;
            n12 >>>= 24;
            int n14 = byArray[n10] & 0xFF;
            n12 = (n12 ^ n14) & 0xFF;
            n12 = nArray[n12] ^ n13;
            ++n10;
        }
        return n12;
    }

    public static int crc8(byte[] byArray, int n10, int n11, int n12) {
        while (n10 < n11) {
            int[] nArray = CRC8_BYTES_MSBF;
            int n13 = byArray[n10] & 0xFF;
            n12 ^= n13;
            n12 = nArray[n12];
            ++n10;
        }
        return n12;
    }

    public static Handler createHandler(Looper looper, Handler.Callback callback) {
        Handler handler = new Handler(looper, callback);
        return handler;
    }

    public static Handler createHandlerForCurrentLooper() {
        return Util.createHandlerForCurrentLooper(null);
    }

    public static Handler createHandlerForCurrentLooper(Handler.Callback callback) {
        return Util.createHandler((Looper)Assertions.checkStateNotNull(Looper.myLooper()), callback);
    }

    public static Handler createHandlerForCurrentOrMainLooper() {
        return Util.createHandlerForCurrentOrMainLooper(null);
    }

    public static Handler createHandlerForCurrentOrMainLooper(Handler.Callback callback) {
        return Util.createHandler(Util.getCurrentOrMainLooper(), callback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static HashMap createIsoLanguageReplacementMap() {
        String[] stringArray = Locale.getISOLanguages();
        int n10 = stringArray.length;
        int n11 = additionalIsoLanguageReplacements.length;
        HashMap<Object, String> hashMap = new HashMap<Object, String>(n10 += n11);
        n10 = stringArray.length;
        n11 = 0;
        int n12 = 0;
        while (true) {
            if (n12 >= n10) {
                String[] stringArray2;
                while (n11 < (n10 = (stringArray2 = additionalIsoLanguageReplacements).length)) {
                    String string3 = stringArray2[n11];
                    n12 = n11 + 1;
                    String string4 = stringArray2[n12];
                    hashMap.put(string3, string4);
                    n11 += 2;
                }
                return hashMap;
            }
            String string2 = stringArray[n12];
            try {
                Object object = new Locale(string2);
                object = ((Locale)object).getISO3Language();
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    hashMap.put(object, string2);
                }
            }
            catch (MissingResourceException missingResourceException) {}
            ++n12;
        }
    }

    public static File createTempDirectory(Context object, String string2) {
        object = Util.createTempFile((Context)object, string2);
        ((File)object).delete();
        ((File)object).mkdir();
        return object;
    }

    public static File createTempFile(Context object, String string2) {
        object = (File)Assertions.checkNotNull(object.getCacheDir());
        return File.createTempFile(string2, null, (File)object);
    }

    public static String escapeFileName(String string2) {
        int n10;
        int n11 = string2.length();
        int n12 = 0;
        String string3 = null;
        StringBuilder stringBuilder = null;
        int n13 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            n10 = Util.shouldEscapeCharacter(string2.charAt(i10));
            if (n10 == 0) continue;
            ++n13;
        }
        if (n13 == 0) {
            return string2;
        }
        n10 = n13 * 2 + n11;
        stringBuilder = new StringBuilder(n10);
        while (n13 > 0) {
            n10 = n12 + 1;
            char c10 = Util.shouldEscapeCharacter((char)(n12 = (int)string2.charAt(n12)));
            if (c10 != '\u0000') {
                c10 = '%';
                stringBuilder.append(c10);
                string3 = Integer.toHexString(n12);
                stringBuilder.append(string3);
                n13 += -1;
            } else {
                stringBuilder.append((char)n12);
            }
            n12 = n10;
        }
        if (n12 < n11) {
            stringBuilder.append(string2, n12, n11);
        }
        return stringBuilder.toString();
    }

    public static Uri fixSmoothStreamingIsmManifestUri(Uri uri) {
        Object object = Util.toLowerInvariant(uri.getPath());
        if (object == null) {
            return uri;
        }
        Pattern pattern = ISM_URL_PATTERN;
        int n10 = (int)(((Matcher)(object = pattern.matcher((CharSequence)object))).matches() ? 1 : 0);
        if (n10 != 0 && (object = ((Matcher)object).group(n10 = 1)) == null) {
            object = "Manifest";
            uri = Uri.withAppendedPath((Uri)uri, (String)object);
        }
        return uri;
    }

    public static String formatInvariant(String string2, Object ... objectArray) {
        return String.format(Locale.US, string2, objectArray);
    }

    public static String fromUtf8Bytes(byte[] byArray) {
        Charset charset = Charsets.UTF_8;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static String fromUtf8Bytes(byte[] byArray, int n10, int n11) {
        Charset charset = Charsets.UTF_8;
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public static String getAdaptiveMimeTypeForContentType(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return "application/x-mpegURL";
            }
            return "application/vnd.ms-sstr+xml";
        }
        return "application/dash+xml";
    }

    public static int getAudioContentTypeForStreamType(int n10) {
        int n11 = 1;
        if (n10 != 0) {
            int n12;
            int n13 = 4;
            if (n10 != n11 && n10 != (n11 = 2) && n10 != n13 && n10 != (n12 = 5) && n10 != (n12 = 8)) {
                return n11;
            }
            return n13;
        }
        return n11;
    }

    public static int getAudioTrackChannelConfig(int n10) {
        switch (n10) {
            default: {
                return 0;
            }
            case 8: {
                n10 = SDK_INT;
                int n11 = 23;
                int n12 = 6396;
                if (n10 >= n11) {
                    return n12;
                }
                n11 = 21;
                if (n10 >= n11) {
                    return n12;
                }
                return 0;
            }
            case 7: {
                return 1276;
            }
            case 6: {
                return 252;
            }
            case 5: {
                return 220;
            }
            case 4: {
                return 204;
            }
            case 3: {
                return 28;
            }
            case 2: {
                return 12;
            }
            case 1: 
        }
        return 4;
    }

    public static int getAudioUsageForStreamType(int n10) {
        int n11 = 2;
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11 && n10 != (n11 = 5)) {
                        n11 = 8;
                        if (n10 != n11) {
                            return n12;
                        }
                        return 3;
                    }
                    return n11;
                }
                return 6;
            }
            return 13;
        }
        return n11;
    }

    public static int getBigEndianInt(ByteBuffer object, int n10) {
        ByteOrder byteOrder;
        n10 = ((ByteBuffer)object).getInt(n10);
        if ((object = ((ByteBuffer)object).order()) != (byteOrder = ByteOrder.BIG_ENDIAN)) {
            n10 = Integer.reverseBytes(n10);
        }
        return n10;
    }

    public static byte[] getBytesFromHexString(String string2) {
        int n10 = string2.length() / 2;
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = i10 * 2;
            int n12 = string2.charAt(n11);
            int n13 = 16;
            n12 = Character.digit((char)n12, n13) << 4;
            ++n11;
            n11 = Character.digit(string2.charAt(n11), n13);
            n12 += n11;
            byArray[i10] = n11 = (int)((byte)n12);
        }
        return byArray;
    }

    public static int getCodecCountOfType(String stringArray, int n10) {
        stringArray = Util.splitCodecs((String)stringArray);
        int n11 = stringArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            String string2 = stringArray[i10];
            int n13 = MimeTypes.getTrackTypeOfCodec(string2);
            if (n10 != n13) continue;
            ++n12;
        }
        return n12;
    }

    public static String getCodecsOfType(String stringArray, int n10) {
        stringArray = Util.splitCodecs((String)stringArray);
        int n11 = stringArray.length;
        String string2 = null;
        if (n11 == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string3 : stringArray) {
            int n12 = MimeTypes.getTrackTypeOfCodec(string3);
            if (n10 != n12) continue;
            n12 = stringBuilder.length();
            if (n12 > 0) {
                String string4 = ",";
                stringBuilder.append(string4);
            }
            stringBuilder.append(string3);
        }
        int n13 = stringBuilder.length();
        if (n13 > 0) {
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objectArray) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = objectArray.length); ++i10) {
            String string2 = objectArray[i10].getClass().getSimpleName();
            stringBuilder.append(string2);
            n10 = objectArray.length + -1;
            if (i10 >= n10) continue;
            string2 = ", ";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static String getCountryCode(Context object) {
        boolean bl2;
        String string2;
        if (object != null && (object = (TelephonyManager)object.getSystemService(string2 = "phone")) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = object.getNetworkCountryIso())))) {
            return Util.toUpperInvariant((String)object);
        }
        return Util.toUpperInvariant(Locale.getDefault().getCountry());
    }

    public static Point getCurrentDisplayModeSize(Context context) {
        Display display = ((WindowManager)Assertions.checkNotNull((WindowManager)context.getSystemService("window"))).getDefaultDisplay();
        return Util.getCurrentDisplayModeSize(context, display);
    }

    public static Point getCurrentDisplayModeSize(Context object, Display display) {
        int n10 = SDK_INT;
        int n11 = 29;
        if (n10 <= n11 && (n11 = display.getDisplayId()) == 0 && (n11 = (int)(Util.isTv((Context)object) ? 1 : 0)) != 0) {
            int n12;
            String string2 = "Sony";
            String string3 = MANUFACTURER;
            n11 = (int)(string2.equals(string3) ? 1 : 0);
            if (n11 != 0 && (n11 = (int)((string3 = MODEL).startsWith(string2 = "BRAVIA") ? 1 : 0)) != 0 && (n12 = (int)((object = object.getPackageManager()).hasSystemFeature(string3 = "com.sony.dtv.hardware.panel.qfhd") ? 1 : 0)) != 0) {
                object = new Point(3840, 2160);
                return object;
            }
            n12 = 28;
            object = n10 < n12 ? Util.getSystemProperty("sys.display-size") : Util.getSystemProperty("vendor.display-size");
            if ((n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) == 0) {
                Object object2;
                block17: {
                    try {
                        object2 = ((String)object).trim();
                        string3 = "x";
                    }
                    catch (NumberFormatException numberFormatException) {}
                    object2 = Util.split((String)object2, string3);
                    n11 = ((String[])object2).length;
                    int n13 = 2;
                    if (n11 != n13) break block17;
                    n11 = 0;
                    string3 = null;
                    string3 = object2[0];
                    n11 = Integer.parseInt(string3);
                    n13 = 1;
                    object2 = object2[n13];
                    n10 = Integer.parseInt((String)object2);
                    if (n11 <= 0 || n10 <= 0) break block17;
                    string2 = new Point(n11, n10);
                    return string2;
                }
                object2 = "Invalid display size: ";
                n11 = ((String)(object = String.valueOf(object))).length();
                object = n11 != 0 ? object2.concat((String)object) : new String((String)object2);
                object2 = TAG;
                Log.e((String)object2, (String)object);
            }
        }
        object = new Point();
        n10 = SDK_INT;
        n11 = 23;
        if (n10 >= n11) {
            Util.getDisplaySizeV23(display, (Point)object);
        } else {
            n11 = 17;
            if (n10 >= n11) {
                Util.getDisplaySizeV17(display, (Point)object);
            } else {
                Util.getDisplaySizeV16(display, (Point)object);
            }
        }
        return object;
    }

    public static Looper getCurrentOrMainLooper() {
        Looper looper = Looper.myLooper();
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        return looper;
    }

    public static Uri getDataUriForString(String string2, String string3) {
        string3 = Base64.encodeToString((byte[])string3.getBytes(), (int)2);
        int n10 = String.valueOf(string2).length() + 13;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("data:");
        stringBuilder.append(string2);
        stringBuilder.append(";base64,");
        stringBuilder.append(string3);
        return Uri.parse((String)stringBuilder.toString());
    }

    private static void getDisplaySizeV16(Display display, Point point) {
        display.getSize(point);
    }

    private static void getDisplaySizeV17(Display display, Point point) {
        display.getRealSize(point);
    }

    private static void getDisplaySizeV23(Display display, Point point) {
        int n10;
        int n11;
        display = display.getMode();
        point.x = n11 = display.getPhysicalWidth();
        point.y = n10 = display.getPhysicalHeight();
    }

    public static UUID getDrmUuid(String string2) {
        String string3 = Util.toLowerInvariant(string2);
        string3.hashCode();
        int n10 = string3.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 790309106: {
                String string4 = "clearkey";
                boolean bl2 = string3.equals(string4);
                if (!bl2) break;
                n11 = 2;
                break;
            }
            case -1400551171: {
                String string5 = "widevine";
                boolean bl3 = string3.equals(string5);
                if (!bl3) break;
                n11 = 1;
                break;
            }
            case -1860423953: {
                String string6 = "playready";
                boolean bl4 = string3.equals(string6);
                if (!bl4) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                try {
                    return UUID.fromString(string2);
                }
                catch (RuntimeException runtimeException) {
                    return null;
                }
            }
            case 2: {
                return C.CLEARKEY_UUID;
            }
            case 1: {
                return C.WIDEVINE_UUID;
            }
            case 0: 
        }
        return C.PLAYREADY_UUID;
    }

    public static int getIntegerCodeForString(String string2) {
        int n10 = string2.length();
        int n11 = 4;
        n11 = n10 <= n11 ? 1 : 0;
        Assertions.checkArgument(n11 != 0);
        n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            n11 <<= 8;
            char c10 = string2.charAt(i10);
            n11 |= c10;
        }
        return n11;
    }

    public static String getLocaleLanguageTag(Locale object) {
        int n10 = SDK_INT;
        int n11 = 21;
        object = n10 >= n11 ? Util.getLocaleLanguageTagV21((Locale)object) : ((Locale)object).toString();
        return object;
    }

    private static String getLocaleLanguageTagV21(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long getMediaDurationForPlayoutDuration(long l10, float f10) {
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return l10;
        }
        double d10 = l10;
        double d11 = f10;
        return Math.round(d10 * d11);
    }

    private static int getMobileNetworkType(NetworkInfo networkInfo) {
        int n10 = networkInfo.getSubtype();
        switch (n10) {
            default: {
                return 6;
            }
            case 20: {
                n10 = SDK_INT;
                int n11 = 29;
                if (n10 >= n11) {
                    n10 = 9;
                } else {
                    n10 = 0;
                    networkInfo = null;
                }
                return n10;
            }
            case 18: {
                return 2;
            }
            case 13: {
                return 5;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 14: 
            case 15: 
            case 17: {
                return 4;
            }
            case 1: 
            case 2: 
        }
        return 3;
    }

    public static int getNetworkType(Context context) {
        int n10;
        int n11 = 0;
        if (context == null) {
            return 0;
        }
        String string2 = "connectivity";
        if ((context = (ConnectivityManager)context.getSystemService(string2)) == null) {
            return 0;
        }
        try {
            context = context.getActiveNetworkInfo();
            n11 = 1;
        }
        catch (SecurityException securityException) {}
        if (context != null && (n10 = context.isConnected()) != 0) {
            n10 = context.getType();
            if (n10 != 0) {
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11 && n10 != (n11 = 5)) {
                        int n12 = 6;
                        if (n10 != n12) {
                            n12 = 9;
                            if (n10 != n12) {
                                return 8;
                            }
                            return 7;
                        }
                        return n11;
                    }
                } else {
                    return 2;
                }
            }
            return Util.getMobileNetworkType((NetworkInfo)context);
        }
        return n11;
    }

    public static long getNowUnixTimeMs(long l10) {
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = System.currentTimeMillis();
        } else {
            l11 = SystemClock.elapsedRealtime();
            l10 += l11;
        }
        return l10;
    }

    public static int getPcmEncoding(int n10) {
        int n11 = 8;
        if (n10 != n11) {
            n11 = 16;
            if (n10 != n11) {
                n11 = 24;
                if (n10 != n11) {
                    n11 = 32;
                    if (n10 != n11) {
                        return 0;
                    }
                    return 0x30000000;
                }
                return 0x20000000;
            }
            return 2;
        }
        return 3;
    }

    public static Format getPcmFormat(int n10, int n11, int n12) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setSampleMimeType("audio/raw").setChannelCount(n11).setSampleRate(n12).setPcmEncoding(n10).build();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int getPcmFrameSize(int n10, int n11) {
        int n12 = 2;
        if (n10 == n12) return n11 * n12;
        int n13 = 3;
        if (n10 == n13) return n11;
        int n14 = 4;
        if (n10 != n14) {
            int n15 = 0x10000000;
            if (n10 == n15) return n11 * n12;
            n12 = 0x20000000;
            if (n10 == n12) return n11 * n13;
            n12 = 0x30000000;
            if (n10 != n12) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                throw illegalArgumentException;
            }
        }
        n11 *= n14;
        return n11;
    }

    public static long getPlayoutDurationForMediaDuration(long l10, float f10) {
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return l10;
        }
        double d10 = l10;
        double d11 = f10;
        return Math.round(d10 / d11);
    }

    public static int getStreamTypeForAudioUsage(int n10) {
        int n11 = 13;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    return 3;
                }
                case 6: {
                    return 2;
                }
                case 5: 
                case 7: 
                case 8: 
                case 9: 
                case 10: {
                    return 5;
                }
                case 4: {
                    return 4;
                }
                case 3: {
                    return 8;
                }
                case 2: 
            }
            return 0;
        }
        return 1;
    }

    public static String getStringForTime(StringBuilder object, Formatter formatter, long l10) {
        long l11 = -9223372036854775807L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l13 = 0L;
        if (l12 == false) {
            l10 = l13;
        }
        String string2 = (l12 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) < 0 ? "-" : "";
        l10 = (Math.abs(l10) + 500L) / 1000L;
        long l14 = 60;
        long l15 = l10 % l14;
        long l16 = l10 / l14 % l14;
        l14 = 3600L;
        object.setLength(0);
        long l17 = (l10 /= l14) - l13;
        long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        int n10 = 2;
        int n11 = 1;
        int n12 = 3;
        if (l18 > 0) {
            Object object2;
            l18 = 4;
            object = new Object[l18];
            object[0] = string2;
            object[n11] = object2 = Long.valueOf(l10);
            object[n10] = object2 = Long.valueOf(l16);
            object[n12] = object2 = Long.valueOf(l15);
            object2 = "%s%d:%02d:%02d";
            object = formatter.format((String)object2, object).toString();
        } else {
            Object object3;
            object = new Object[n12];
            object[0] = string2;
            object[n11] = object3 = Long.valueOf(l16);
            object[n10] = object3 = Long.valueOf(l15);
            object3 = "%s%02d:%02d";
            object = formatter.format((String)object3, object).toString();
        }
        return object;
    }

    public static String[] getSystemLanguageCodes() {
        int n10;
        String[] stringArray = Util.getSystemLocales();
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            String string2;
            stringArray[i10] = string2 = Util.normalizeLanguageCode(stringArray[i10]);
        }
        return stringArray;
    }

    private static String[] getSystemLocales() {
        Object object = Resources.getSystem().getConfiguration();
        int n10 = SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object = Util.getSystemLocalesV24((Configuration)object);
        } else {
            n10 = 1;
            String[] stringArray = new String[n10];
            n11 = 0;
            stringArray[0] = object = Util.getLocaleLanguageTag(object.locale);
            object = stringArray;
        }
        return object;
    }

    private static String[] getSystemLocalesV24(Configuration configuration) {
        return Util.split(configuration.getLocales().toLanguageTags(), ",");
    }

    private static String getSystemProperty(String string2) {
        int n10;
        Object object;
        Object object2 = "android.os.SystemProperties";
        try {
            object2 = Class.forName((String)object2);
            object = "get";
            n10 = 1;
        }
        catch (Exception exception) {
            object = "Failed to read system property ";
            string2 = String.valueOf(string2);
            n10 = string2.length();
            string2 = n10 != 0 ? ((String)object).concat(string2) : new String((String)object);
            Log.e(TAG, string2, exception);
            return null;
        }
        Class[] classArray = new Class[n10];
        Class<String> clazz = String.class;
        classArray[0] = clazz;
        object = ((Class)object2).getMethod((String)object, classArray);
        Object[] objectArray = new Object[n10];
        objectArray[0] = string2;
        object2 = ((Method)object).invoke(object2, objectArray);
        return (String)object2;
    }

    public static String getTrackTypeString(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            n11 = 6;
                            if (n10 != n11) {
                                n11 = 7;
                                if (n10 != n11) {
                                    String string2;
                                    n11 = 10000;
                                    if (n10 >= n11) {
                                        n11 = 20;
                                        StringBuilder stringBuilder = new StringBuilder(n11);
                                        String string3 = "custom (";
                                        stringBuilder.append(string3);
                                        stringBuilder.append(n10);
                                        stringBuilder.append(")");
                                        string2 = stringBuilder.toString();
                                    } else {
                                        string2 = "?";
                                    }
                                    return string2;
                                }
                                return "none";
                            }
                            return "camera motion";
                        }
                        return "metadata";
                    }
                    return "text";
                }
                return "video";
            }
            return "audio";
        }
        return "default";
    }

    public static String getUserAgent(Context object, String string2) {
        String string3 = object.getPackageName();
        object = object.getPackageManager();
        int n10 = 0;
        object = object.getPackageInfo(string3, 0);
        try {
            object = object.versionName;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = "?";
        }
        string3 = Build.VERSION.RELEASE;
        n10 = String.valueOf(string2).length() + 38;
        int n11 = String.valueOf(object).length();
        n10 += n11;
        n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append("/");
        stringBuilder.append((String)object);
        stringBuilder.append(" (Linux;Android ");
        stringBuilder.append(string3);
        stringBuilder.append(") ");
        stringBuilder.append("ExoPlayerLib/2.13.2");
        return stringBuilder.toString();
    }

    public static byte[] getUtf8Bytes(String string2) {
        Charset charset = Charsets.UTF_8;
        return string2.getBytes(charset);
    }

    /*
     * Exception decompiling
     */
    public static byte[] gzip(byte[] var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static int inferContentType(Uri object) {
        int n10 = (object = object.getPath()) == null ? 3 : Util.inferContentType((String)object);
        return n10;
    }

    public static int inferContentType(Uri object, String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            n10 = Util.inferContentType((Uri)object);
        } else {
            object = ".";
            n11 = (string2 = String.valueOf(string2)).length();
            if (n11 != 0) {
                object = ((String)object).concat(string2);
            } else {
                string2 = new String((String)object);
                object = string2;
            }
            n10 = Util.inferContentType((String)object);
        }
        return n10;
    }

    public static int inferContentType(String object) {
        Object object2;
        boolean bl2 = ((String)(object = Util.toLowerInvariant((String)object))).endsWith((String)(object2 = ".mpd"));
        if (bl2) {
            return 0;
        }
        object2 = ".m3u8";
        bl2 = ((String)object).endsWith((String)object2);
        int n10 = 2;
        if (bl2) {
            return n10;
        }
        object2 = ISM_URL_PATTERN;
        bl2 = ((Matcher)(object = ((Pattern)object2).matcher((CharSequence)object))).matches();
        if (bl2) {
            if ((object = ((Matcher)object).group(n10)) != null) {
                object2 = ISM_DASH_FORMAT_EXTENSION;
                bl2 = ((String)object).contains((CharSequence)object2);
                if (bl2) {
                    return 0;
                }
                object2 = ISM_HLS_FORMAT_EXTENSION;
                boolean bl3 = ((String)object).contains((CharSequence)object2);
                if (bl3) {
                    return n10;
                }
            }
            return 1;
        }
        return 3;
    }

    public static int inferContentTypeForUriAndMimeType(Uri uri, String string2) {
        if (string2 == null) {
            return Util.inferContentType(uri);
        }
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 2;
        int n13 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 64194685: {
                String string3 = "application/dash+xml";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n10 = n12;
                break;
            }
            case -156749520: {
                String string4 = "application/vnd.ms-sstr+xml";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n10 = n13;
                break;
            }
            case -979127466: {
                String string5 = "application/x-mpegURL";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n10 = 0;
                uri = null;
            }
        }
        switch (n10) {
            default: {
                return 3;
            }
            case 2: {
                return 0;
            }
            case 1: {
                return n13;
            }
            case 0: 
        }
        return n12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean inflate(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        if (n11 <= 0) {
            return false;
        }
        n11 = parsableByteArray2.capacity();
        if (n11 < (n10 = parsableByteArray.bytesLeft())) {
            n11 = parsableByteArray.bytesLeft() * 2;
            parsableByteArray2.ensureCapacity(n11);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        byte[] byArray = parsableByteArray.getData();
        n10 = parsableByteArray.getPosition();
        int n12 = parsableByteArray.bytesLeft();
        inflater.setInput(byArray, n10, n12);
        n12 = 0;
        parsableByteArray = null;
        try {
            while (true) {
                byArray = parsableByteArray2.getData();
                n10 = parsableByteArray2.capacity() - n12;
                n11 = inflater.inflate(byArray, n12, n10);
                n12 += n11;
                n11 = (int)(inflater.finished() ? 1 : 0);
                if (n11 != 0) {
                    parsableByteArray2.setLimit(n12);
                    return true;
                }
                n11 = (int)(inflater.needsDictionary() ? 1 : 0);
                if (n11 != 0) return false;
                n11 = (int)(inflater.needsInput() ? 1 : 0);
                if (n11 != 0) {
                    return false;
                }
                n11 = parsableByteArray2.capacity();
                if (n12 != n11) continue;
                n11 = parsableByteArray2.capacity() * 2;
                parsableByteArray2.ensureCapacity(n11);
            }
        }
        catch (DataFormatException dataFormatException) {
            return false;
        }
        finally {
            inflater.reset();
        }
    }

    public static boolean isEncodingHighResolutionPcm(int n10) {
        int n11 = 0x20000000;
        n10 = n10 != n11 && n10 != (n11 = 0x30000000) && n10 != (n11 = 4) ? 0 : 1;
        return n10 != 0;
    }

    public static boolean isEncodingLinearPcm(int n10) {
        int n11 = 3;
        n10 = n10 != n11 && n10 != (n11 = 2) && n10 != (n11 = 0x10000000) && n10 != (n11 = 0x20000000) && n10 != (n11 = 0x30000000) && n10 != (n11 = 4) ? 0 : 1;
        return n10 != 0;
    }

    public static boolean isLinebreak(int n10) {
        int n11 = 10;
        n10 = n10 != n11 && n10 != (n11 = 13) ? 0 : 1;
        return n10 != 0;
    }

    public static boolean isLocalFileUri(Uri object) {
        String string2;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object = object.getScheme()));
        if (!bl3 && !(bl2 = (string2 = "file").equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean isTrafficRestricted(Uri object) {
        boolean bl2;
        String string2 = "http";
        String string3 = object.getScheme();
        boolean bl3 = string2.equals(string3);
        if (bl3 && !(bl2 = (string3 = NetworkSecurityPolicy.getInstance()).isCleartextTrafficPermitted((String)(object = (String)Assertions.checkNotNull(object.getHost()))))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean isTv(Context context) {
        int n10;
        int n11;
        context = context.getApplicationContext();
        String string2 = "uimode";
        if ((context = (UiModeManager)context.getSystemService(string2)) != null && (n11 = context.getCurrentModeType()) == (n10 = 4)) {
            n11 = 1;
        } else {
            n11 = 0;
            context = null;
        }
        return n11 != 0;
    }

    public static int linearSearch(int[] nArray, int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = nArray.length); ++i10) {
            n11 = nArray[i10];
            if (n11 != n10) continue;
            return i10;
        }
        return -1;
    }

    public static int linearSearch(long[] lArray, long l10) {
        int n10;
        for (int i10 = 0; i10 < (n10 = lArray.length); ++i10) {
            long l11 = lArray[i10];
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
            return i10;
        }
        return -1;
    }

    private static String maybeReplaceLegacyLanguageTags(String string2) {
        String[] stringArray;
        int n10;
        String string3 = null;
        for (int i10 = 0; i10 < (n10 = (stringArray = isoLegacyTagReplacements).length); i10 += 2) {
            String string4 = stringArray[i10];
            n10 = (int)(string2.startsWith(string4) ? 1 : 0);
            if (n10 == 0) continue;
            n10 = i10 + 1;
            string4 = String.valueOf(stringArray[n10]);
            string3 = stringArray[i10];
            i10 = string3.length();
            string2 = (i10 = (string2 = String.valueOf(string2.substring(i10))).length()) != 0 ? string4.concat(string2) : new String(string4);
            return string2;
        }
        return string2;
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri ... uriArray) {
        int n10 = SDK_INT;
        int n11 = 23;
        if (n10 < n11) {
            return false;
        }
        for (Uri uri : uriArray) {
            boolean bl2 = Util.isLocalFileUri(uri);
            if (!bl2) continue;
            return Util.requestExternalStoragePermission(activity);
        }
        return false;
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, MediaItem ... mediaItemArray) {
        int n10 = SDK_INT;
        int n11 = 23;
        if (n10 < n11) {
            return false;
        }
        for (MediaItem mediaItem : mediaItemArray) {
            List list;
            int n12;
            MediaItem$PlaybackProperties mediaItem$PlaybackProperties = mediaItem.playbackProperties;
            if (mediaItem$PlaybackProperties == null) continue;
            mediaItem$PlaybackProperties = mediaItem$PlaybackProperties.uri;
            int n13 = Util.isLocalFileUri((Uri)mediaItem$PlaybackProperties);
            if (n13 != 0) {
                return Util.requestExternalStoragePermission(activity);
            }
            mediaItem$PlaybackProperties = null;
            for (n13 = 0; n13 < (n12 = (list = mediaItem.playbackProperties.subtitles).size()); ++n13) {
                list = ((MediaItem$Subtitle)mediaItem.playbackProperties.subtitles.get((int)n13)).uri;
                n12 = (int)(Util.isLocalFileUri((Uri)list) ? 1 : 0);
                if (n12 == 0) continue;
                return Util.requestExternalStoragePermission(activity);
            }
        }
        return false;
    }

    public static long minValue(SparseLongArray object) {
        int n10 = object.size();
        if (n10 != 0) {
            int n11;
            long l10 = Long.MAX_VALUE;
            for (int i10 = 0; i10 < (n11 = object.size()); ++i10) {
                long l11 = object.valueAt(i10);
                l10 = Math.min(l10, l11);
            }
            return l10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static void moveItems(List list, int n10, int n11, int n12) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (n11 = n11 - n10 + -1; n11 >= 0; n11 += -1) {
            int n13 = n10 + n11;
            Object e10 = list.remove(n13);
            arrayDeque.addFirst(e10);
        }
        n10 = list.size();
        n10 = Math.min(n12, n10);
        list.addAll(n10, arrayDeque);
    }

    public static ExecutorService newSingleThreadExecutor(String string2) {
        e e10 = new e(string2);
        return Executors.newSingleThreadExecutor(e10);
    }

    public static String normalizeLanguageCode(String object) {
        Object object2;
        if (object == null) {
            return null;
        }
        int n10 = 95;
        Object object3 = ((String)object).replace((char)n10, '-');
        boolean bl2 = ((String)object3).isEmpty();
        if (!bl2 && !(bl2 = ((String)(object2 = "und")).equals(object3))) {
            object = object3;
        }
        object = Util.toLowerInvariant((String)object);
        object3 = Util.splitAtFirst((String)object, "-");
        bl2 = false;
        object3 = object3[0];
        object2 = languageTagReplacementMap;
        if (object2 == null) {
            languageTagReplacementMap = object2 = Util.createIsoLanguageReplacementMap();
        }
        if ((object2 = (String)languageTagReplacementMap.get(object3)) != null) {
            String string2 = String.valueOf(object2);
            n10 = ((String)object3).length();
            object = (n10 = ((String)(object = String.valueOf(((String)object).substring(n10)))).length()) != 0 ? string2.concat((String)object) : new String(string2);
            object3 = object2;
        }
        if ((bl2 = ((String)(object2 = "no")).equals(object3)) || (bl2 = ((String)(object2 = "i")).equals(object3)) || (n10 = (int)(((String)(object2 = "zh")).equals(object3) ? 1 : 0)) != 0) {
            object = Util.maybeReplaceLegacyLanguageTags((String)object);
        }
        return object;
    }

    public static Object[] nullSafeArrayAppend(Object[] objectArray, Object object) {
        int n10 = objectArray.length + 1;
        Object[] objectArray2 = Arrays.copyOf(objectArray, n10);
        int n11 = objectArray.length;
        objectArray2[n11] = object;
        return Util.castNonNullTypeArray(objectArray2);
    }

    public static Object[] nullSafeArrayConcatenation(Object[] objectArray, Object[] objectArray2) {
        int n10 = objectArray.length;
        int n11 = objectArray2.length;
        Object[] objectArray3 = Arrays.copyOf(objectArray, n10 += n11);
        int n12 = objectArray.length;
        n11 = objectArray2.length;
        System.arraycopy(objectArray2, 0, objectArray3, n12, n11);
        return objectArray3;
    }

    public static Object[] nullSafeArrayCopy(Object[] objectArray, int n10) {
        int n11 = objectArray.length;
        n11 = n10 <= n11 ? 1 : 0;
        Assertions.checkArgument(n11 != 0);
        return Arrays.copyOf(objectArray, n10);
    }

    public static Object[] nullSafeArrayCopyOfRange(Object[] objectArray, int n10, int n11) {
        int n12 = 1;
        int n13 = n10 >= 0 ? n12 : 0;
        Assertions.checkArgument(n13 != 0);
        n13 = objectArray.length;
        if (n11 > n13) {
            n12 = 0;
        }
        Assertions.checkArgument(n12 != 0);
        return Arrays.copyOfRange(objectArray, n10, n11);
    }

    public static void nullSafeListToArray(List list, Object[] objectArray) {
        int n10;
        int n11 = list.size();
        n11 = n11 == (n10 = objectArray.length) ? 1 : 0;
        Assertions.checkState(n11 != 0);
        list.toArray(objectArray);
    }

    public static long parseXsDateTime(String object) {
        Object object2 = XS_DATE_TIME_PATTERN.matcher((CharSequence)object);
        boolean n10 = ((Matcher)object2).matches();
        if (!n10) {
            String string2 = "Invalid date/time format: ";
            int n11 = ((String)(object = String.valueOf(object))).length();
            object = n11 != 0 ? string2.concat((String)object) : new String(string2);
            object2 = new ParserException((String)object);
            throw object2;
        }
        int n12 = 9;
        Object object3 = ((Matcher)object2).group(n12);
        int n13 = 0;
        if (object3 != null && (n12 = (int)(((String)(object = ((Matcher)object2).group(n12))).equalsIgnoreCase((String)(object3 = "Z")) ? 1 : 0)) == 0) {
            n12 = Integer.parseInt(((Matcher)object2).group(12)) * 60;
            int n14 = Integer.parseInt(((Matcher)object2).group(13));
            n13 = n12 + n14;
            object3 = "-";
            object = ((Matcher)object2).group(11);
            n12 = (int)(((String)object3).equals(object) ? 1 : 0);
            if (n12 != 0) {
                n13 *= -1;
            }
        }
        object3 = DesugarTimeZone.getTimeZone("GMT");
        object = new GregorianCalendar((TimeZone)object3);
        ((Calendar)object).clear();
        int n15 = Integer.parseInt(((Matcher)object2).group(1));
        int n16 = Integer.parseInt(((Matcher)object2).group(2)) + -1;
        int n17 = 3;
        int n18 = Integer.parseInt(((Matcher)object2).group(n17));
        int n19 = Integer.parseInt(((Matcher)object2).group(4));
        int n20 = Integer.parseInt(((Matcher)object2).group(5));
        int n21 = Integer.parseInt(((Matcher)object2).group(6));
        ((Calendar)object).set(n15, n16, n18, n19, n20, n21);
        int n22 = 8;
        Object object4 = ((Matcher)object2).group(n22);
        n15 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
        if (n15 == 0) {
            String string3 = "0.";
            object2 = (n22 = ((String)(object2 = String.valueOf(((Matcher)object2).group(n22)))).length()) != 0 ? string3.concat((String)object2) : new String(string3);
            object4 = new BigDecimal((String)object2);
            int n23 = 14;
            object3 = ((BigDecimal)object4).movePointRight(n17);
            int n24 = ((BigDecimal)object3).intValue();
            ((Calendar)object).set(n23, n24);
        }
        long l10 = ((Calendar)object).getTimeInMillis();
        if (n13 != 0) {
            n12 = 60000;
            long l11 = n13 *= n12;
            l10 -= l11;
        }
        return l10;
    }

    public static long parseXsDuration(String string2) {
        Object object = XS_DURATION_PATTERN.matcher(string2);
        boolean n10 = ((Matcher)object).matches();
        double d10 = 1000.0;
        double d11 = 3600.0;
        if (n10) {
            double d12;
            double d13;
            double d14;
            int n11 = 1;
            int n12 = TextUtils.isEmpty((CharSequence)((Matcher)object).group(n11));
            n11 ^= n12;
            int n13 = 3;
            String string3 = ((Matcher)object).group(n13);
            double d15 = 0.0;
            if (string3 != null) {
                d14 = Double.parseDouble(string3);
                d13 = 3.1556908E7;
                d14 *= d13;
            } else {
                d14 = d15;
            }
            int n14 = 5;
            string3 = ((Matcher)object).group(n14);
            if (string3 != null) {
                d13 = Double.parseDouble(string3);
                d12 = 2629739.0;
                d13 *= d12;
            } else {
                d13 = d15;
            }
            d14 += d13;
            int n15 = 7;
            string3 = ((Matcher)object).group(n15);
            if (string3 != null) {
                d13 = Double.parseDouble(string3);
                d12 = 86400.0;
                d13 *= d12;
            } else {
                d13 = d15;
            }
            d14 += d13;
            int n16 = 10;
            string3 = ((Matcher)object).group(n16);
            d13 = string3 != null ? Double.parseDouble(string3) * d11 : d15;
            d14 += d13;
            int n17 = 12;
            string3 = ((Matcher)object).group(n17);
            if (string3 != null) {
                d11 = Double.parseDouble(string3);
                d13 = 60.0;
                d11 *= d13;
            } else {
                d11 = d15;
            }
            d14 += d11;
            int n18 = 14;
            object = ((Matcher)object).group(n18);
            if (object != null) {
                d15 = Double.parseDouble((String)object);
            }
            d14 = (d14 + d15) * d10;
            long l10 = (long)d14;
            if (n11 != 0) {
                l10 = -l10;
            }
            return l10;
        }
        return (long)(Double.parseDouble(string2) * d11 * d10);
    }

    public static boolean postOrRun(Handler handler, Runnable runnable) {
        Looper looper;
        Thread thread = handler.getLooper().getThread();
        boolean bl2 = thread.isAlive();
        if (!bl2) {
            return false;
        }
        thread = handler.getLooper();
        if (thread == (looper = Looper.myLooper())) {
            runnable.run();
            return true;
        }
        return handler.post(runnable);
    }

    public static boolean readBoolean(Parcel parcel) {
        int n10 = parcel.readInt();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            parcel = null;
        }
        return n10 != 0;
    }

    public static byte[] readExactly(DataSource object, int n10) {
        int n11;
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; i10 += n11) {
            int n12;
            n11 = n10 - i10;
            if ((n11 = object.read(byArray, i10, n11)) != (n12 = -1)) {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder(56);
            stringBuilder.append("Not enough data could be read: ");
            stringBuilder.append(i10);
            stringBuilder.append(" < ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            object = new IllegalStateException(string2);
            throw object;
        }
        return byArray;
    }

    public static byte[] readToEnd(DataSource dataSource) {
        int n10;
        int n11 = 1024;
        byte[] byArray = new byte[n11];
        int n12 = 0;
        int n13 = 0;
        while (n12 != (n10 = -1)) {
            n12 = byArray.length;
            if (n13 == n12) {
                n12 = byArray.length * 2;
                byArray = Arrays.copyOf(byArray, n12);
            }
            n12 = byArray.length - n13;
            if ((n12 = dataSource.read(byArray, n13, n12)) == n10) continue;
            n13 += n12;
        }
        return Arrays.copyOf(byArray, n13);
    }

    public static void recursiveDelete(File file) {
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (File file2 : fileArray) {
                Util.recursiveDelete(file2);
            }
        }
        file.delete();
    }

    public static void removeRange(List list, int n10, int n11) {
        int n12;
        if (n10 >= 0 && n11 <= (n12 = list.size()) && n10 <= n11) {
            if (n10 != n11) {
                list = list.subList(n10, n11);
                list.clear();
            }
            return;
        }
        list = new List();
        throw list;
    }

    private static boolean requestExternalStoragePermission(Activity activity) {
        String[] stringArray = "android.permission.READ_EXTERNAL_STORAGE";
        int n10 = activity.checkSelfPermission((String)stringArray);
        if (n10 != 0) {
            stringArray = new String[]{stringArray};
            activity.requestPermissions(stringArray, 0);
            return true;
        }
        return false;
    }

    public static long scaleLargeTimestamp(long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15;
        long l16;
        long l17 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        long l18 = 0L;
        if (l17 >= 0 && (l16 = (l15 = (l14 = l12 % l11) - l18) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false) {
            return l10 / (l12 /= l11);
        }
        if (l17 < 0 && (l17 = (l13 = (l14 = l11 % l12) - l18) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
            return l10 * (l11 /= l12);
        }
        double d10 = l11;
        double d11 = l12;
        return (long)((double)l10 * (d10 /= d11));
    }

    public static long[] scaleLargeTimestamps(List list, long l10, long l11) {
        long l12;
        int n10;
        long l13;
        long l14;
        long l15;
        int n11 = list.size();
        long[] lArray = new long[n11];
        long l16 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        long l17 = 0L;
        if (l16 >= 0 && (l15 = (l14 = (l13 = l11 % l10) - l17) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) {
            l11 /= l10;
            for (n10 = 0; n10 < n11; ++n10) {
                Long l18 = (Long)list.get(n10);
                lArray[n10] = l10 = l18 / l11;
            }
        } else if (l16 < 0 && (l16 = (l12 = (l13 = l10 % l11) - l17) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            l10 /= l11;
            while (n10 < n11) {
                Long l19 = (Long)list.get(n10);
                lArray[n10] = l11 = l19 * l10;
                ++n10;
            }
        } else {
            double d10 = l10;
            double d11 = l11;
            d10 /= d11;
            while (n10 < n11) {
                Long l20 = (Long)list.get(n10);
                d11 = (double)l20.longValue() * d10;
                lArray[n10] = l11 = (long)d11;
                ++n10;
            }
        }
        return lArray;
    }

    public static void scaleLargeTimestampsInPlace(long[] lArray, long l10, long l11) {
        long l12;
        int n10;
        long l13;
        long l14;
        long l15;
        long l16 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        long l17 = 0L;
        if (l16 >= 0 && (l15 = (l14 = (l13 = l11 % l10) - l17) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) {
            int n11;
            l11 /= l10;
            for (n10 = 0; n10 < (n11 = lArray.length); ++n10) {
                lArray[n10] = l10 = lArray[n10] / l11;
            }
        } else if (l16 < 0 && (l16 = (l12 = (l13 = l10 % l11) - l17) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            int n12;
            l10 /= l11;
            while (n10 < (n12 = lArray.length)) {
                lArray[n10] = l11 = lArray[n10] * l10;
                ++n10;
            }
        } else {
            int n13;
            double d10 = l10;
            double d11 = l11;
            d10 /= d11;
            while (n10 < (n13 = lArray.length)) {
                d11 = (double)lArray[n10] * d10;
                lArray[n10] = l11 = (long)d11;
                ++n10;
            }
        }
    }

    private static boolean shouldEscapeCharacter(char n10) {
        int n11 = 34;
        return n10 == n11 || n10 == (n11 = 37) || n10 == (n11 = 42) || n10 == (n11 = 47) || n10 == (n11 = 58) || n10 == (n11 = 60) || n10 == (n11 = 92) || n10 == (n11 = 124) || n10 == (n11 = 62) || n10 == (n11 = 63);
    }

    public static void sneakyThrow(Throwable throwable) {
        Util.sneakyThrowInternal(throwable);
    }

    private static void sneakyThrowInternal(Throwable throwable) {
        throw throwable;
    }

    public static String[] split(String string2, String string3) {
        return string2.split(string3, -1);
    }

    public static String[] splitAtFirst(String string2, String string3) {
        return string2.split(string3, 2);
    }

    public static String[] splitCodecs(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return new String[0];
        }
        return Util.split(string2.trim(), "(\\s*,\\s*)");
    }

    public static ComponentName startForegroundService(Context context, Intent intent) {
        int n10 = SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static long subtractWithOverflowDefault(long l10, long l11, long l12) {
        long l13 = l10 - l11;
        l11 ^= l10;
        long l14 = (l10 = (l10 ^ l13) & l11) - (l11 = 0L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0) {
            return l12;
        }
        return l13;
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase, String string2) {
        long l10;
        boolean bl2 = true;
        String[] stringArray = new String[bl2];
        stringArray[0] = string2;
        string2 = "sqlite_master";
        String string3 = "tbl_name = ?";
        long l11 = DatabaseUtils.queryNumEntries((SQLiteDatabase)sQLiteDatabase, (String)string2, (String)string3, (String[])stringArray);
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        int n10;
        int n11;
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((n11 = inputStream.read(byArray)) != (n10 = -1)) {
            n10 = 0;
            byteArrayOutputStream.write(byArray, 0, n11);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toHexString(byte[] byArray) {
        char c10;
        int n10 = byArray.length * 2;
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (n10 = 0; n10 < (c10 = byArray.length); ++n10) {
            c10 = byArray[n10] >> 4 & 0xF;
            int n11 = 16;
            c10 = Character.forDigit(c10, n11);
            stringBuilder.append(c10);
            c10 = Character.forDigit(byArray[n10] & 0xF, n11);
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static long toLong(int n10, int n11) {
        long l10 = Util.toUnsignedLong(n10) << 32;
        return Util.toUnsignedLong(n11) | l10;
    }

    public static String toLowerInvariant(String string2) {
        if (string2 != null) {
            Locale locale = Locale.US;
            string2 = string2.toLowerCase(locale);
        }
        return string2;
    }

    public static long toUnsignedLong(int n10) {
        return (long)n10 & 0xFFFFFFFFL;
    }

    public static String toUpperInvariant(String string2) {
        if (string2 != null) {
            Locale locale = Locale.US;
            string2 = string2.toUpperCase(locale);
        }
        return string2;
    }

    public static CharSequence truncateAscii(CharSequence charSequence, int n10) {
        int n11 = charSequence.length();
        if (n11 > n10) {
            n11 = 0;
            charSequence = charSequence.subSequence(0, n10);
        }
        return charSequence;
    }

    public static String unescapeFileName(String string2) {
        int n10;
        char c10;
        int n11;
        int n12 = string2.length();
        int n13 = 0;
        int n14 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            char c11;
            char c12 = string2.charAt(n11);
            if (c12 != (c11 = '%')) continue;
            ++n14;
        }
        if (n14 == 0) {
            return string2;
        }
        n11 = n14 * 2;
        n11 = n12 - n11;
        StringBuilder stringBuilder = new StringBuilder(n11);
        Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(string2);
        while (n14 > 0 && (c10 = matcher.find()) != '\u0000') {
            String string3 = (String)Assertions.checkNotNull(matcher.group(1));
            c10 = (char)Integer.parseInt(string3, 16);
            int n15 = matcher.start();
            stringBuilder.append(string2, n13, n15);
            stringBuilder.append(c10);
            n13 = matcher.end();
            n14 += -1;
        }
        if (n13 < n12) {
            stringBuilder.append(string2, n13, n12);
        }
        if ((n10 = stringBuilder.length()) != n11) {
            return null;
        }
        return stringBuilder.toString();
    }

    public static void writeBoolean(Parcel parcel, boolean bl2) {
        parcel.writeInt((int)(bl2 ? 1 : 0));
    }
}

