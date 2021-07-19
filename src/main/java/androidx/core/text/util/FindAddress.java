/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text.util;

import androidx.core.text.util.FindAddress$ZipRange;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAddress {
    private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final String HOUSE_END = "(?=[,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String HOUSE_POST_DELIM = ",\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String HOUSE_PRE_DELIM = ":,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int MAX_ADDRESS_LINES = 5;
    private static final int MAX_ADDRESS_WORDS = 14;
    private static final int MAX_LOCATION_NAME_DISTANCE = 5;
    private static final int MIN_ADDRESS_WORDS = 4;
    private static final String NL = "\n\u000b\f\r\u0085\u2028\u2029";
    private static final String SP = "\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000";
    private static final String WORD_DELIM = ",*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String WORD_END = "(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String WS = "\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int kMaxAddressNameWordLength = 25;
    private static final Pattern sHouseNumberRe;
    private static final Pattern sLocationNameRe;
    private static final Pattern sStateRe;
    private static final FindAddress$ZipRange[] sStateZipCodeRanges;
    private static final Pattern sSuffixedNumberRe;
    private static final Pattern sWordRe;
    private static final Pattern sZipCodeRe;

    static {
        FindAddress$ZipRange findAddress$ZipRange;
        FindAddress$ZipRange[] findAddress$ZipRangeArray = new FindAddress$ZipRange[59];
        int n10 = 99;
        int n11 = -1;
        findAddress$ZipRangeArray[0] = findAddress$ZipRange = new FindAddress$ZipRange(n10, n10, n11, n11);
        findAddress$ZipRange = new FindAddress$ZipRange(35, 36, n11, n11);
        int n12 = 1;
        findAddress$ZipRangeArray[n12] = findAddress$ZipRange;
        findAddress$ZipRange = new FindAddress$ZipRange(71, 72, n11, n11);
        int n13 = 2;
        findAddress$ZipRangeArray[n13] = findAddress$ZipRange;
        int n14 = 96;
        findAddress$ZipRange = new FindAddress$ZipRange(n14, n14, n11, n11);
        int n15 = 3;
        findAddress$ZipRangeArray[n15] = findAddress$ZipRange;
        findAddress$ZipRange = new FindAddress$ZipRange(85, 86, n11, n11);
        int n16 = 4;
        findAddress$ZipRangeArray[n16] = findAddress$ZipRange;
        findAddress$ZipRangeArray[5] = findAddress$ZipRange = new FindAddress$ZipRange(90, n14, n11, n11);
        findAddress$ZipRange = new FindAddress$ZipRange(80, 81, n11, n11);
        int n17 = 6;
        findAddress$ZipRangeArray[n17] = findAddress$ZipRange;
        findAddress$ZipRangeArray[7] = findAddress$ZipRange = new FindAddress$ZipRange(n17, n17, n11, n11);
        int n18 = 20;
        findAddress$ZipRangeArray[8] = findAddress$ZipRange = new FindAddress$ZipRange(n18, n18, n11, n11);
        int n19 = 19;
        findAddress$ZipRange = new FindAddress$ZipRange(n19, n19, n11, n11);
        int n20 = 9;
        findAddress$ZipRangeArray[n20] = findAddress$ZipRange;
        findAddress$ZipRangeArray[10] = findAddress$ZipRange = new FindAddress$ZipRange(32, 34, n11, n11);
        findAddress$ZipRangeArray[11] = findAddress$ZipRange = new FindAddress$ZipRange(n14, n14, n11, n11);
        findAddress$ZipRangeArray[12] = findAddress$ZipRange = new FindAddress$ZipRange(30, 31, n11, n11);
        findAddress$ZipRangeArray[13] = findAddress$ZipRange = new FindAddress$ZipRange(n14, n14, n11, n11);
        findAddress$ZipRangeArray[14] = findAddress$ZipRange = new FindAddress$ZipRange(n14, n14, n11, n11);
        findAddress$ZipRangeArray[15] = findAddress$ZipRange = new FindAddress$ZipRange(50, 52, n11, n11);
        n10 = 83;
        findAddress$ZipRangeArray[16] = findAddress$ZipRange = new FindAddress$ZipRange(n10, n10, n11, n11);
        findAddress$ZipRangeArray[17] = findAddress$ZipRange = new FindAddress$ZipRange(60, 62, n11, n11);
        findAddress$ZipRangeArray[18] = findAddress$ZipRange = new FindAddress$ZipRange(46, 47, n11, n11);
        findAddress$ZipRangeArray[n19] = findAddress$ZipRange = new FindAddress$ZipRange(66, 67, 73, n11);
        findAddress$ZipRangeArray[n18] = findAddress$ZipRange = new FindAddress$ZipRange(40, 42, n11, n11);
        findAddress$ZipRangeArray[21] = findAddress$ZipRange = new FindAddress$ZipRange(70, 71, n11, n11);
        findAddress$ZipRangeArray[22] = findAddress$ZipRange = new FindAddress$ZipRange(n12, n13, n11, n11);
        findAddress$ZipRangeArray[23] = findAddress$ZipRange = new FindAddress$ZipRange(n18, 21, n11, n11);
        findAddress$ZipRangeArray[24] = findAddress$ZipRange = new FindAddress$ZipRange(n15, n16, n11, n11);
        findAddress$ZipRangeArray[25] = findAddress$ZipRange = new FindAddress$ZipRange(n14, n14, n11, n11);
        findAddress$ZipRangeArray[26] = findAddress$ZipRange = new FindAddress$ZipRange(48, 49, n11, n11);
        n12 = 55;
        int n21 = 56;
        findAddress$ZipRangeArray[27] = findAddress$ZipRange = new FindAddress$ZipRange(n12, n21, n11, n11);
        findAddress$ZipRangeArray[28] = findAddress$ZipRange = new FindAddress$ZipRange(63, 65, n11, n11);
        findAddress$ZipRange = new FindAddress$ZipRange(n14, n14, n11, n11);
        n10 = 29;
        findAddress$ZipRangeArray[n10] = findAddress$ZipRange;
        int n22 = 38;
        findAddress$ZipRangeArray[30] = findAddress$ZipRange = new FindAddress$ZipRange(n22, 39, n11, n11);
        findAddress$ZipRangeArray[31] = findAddress$ZipRange = new FindAddress$ZipRange(n12, n21, n11, n11);
        findAddress$ZipRangeArray[32] = findAddress$ZipRange = new FindAddress$ZipRange(27, 28, n11, n11);
        n21 = 58;
        findAddress$ZipRangeArray[33] = findAddress$ZipRange = new FindAddress$ZipRange(n21, n21, n11, n11);
        findAddress$ZipRangeArray[34] = findAddress$ZipRange = new FindAddress$ZipRange(68, 69, n11, n11);
        findAddress$ZipRangeArray[35] = findAddress$ZipRange = new FindAddress$ZipRange(n15, n16, n11, n11);
        findAddress$ZipRangeArray[36] = findAddress$ZipRange = new FindAddress$ZipRange(7, 8, n11, n11);
        n16 = 88;
        findAddress$ZipRangeArray[37] = findAddress$ZipRange = new FindAddress$ZipRange(87, n16, 86, n11);
        findAddress$ZipRangeArray[n22] = findAddress$ZipRange = new FindAddress$ZipRange(n16, 89, n14, n11);
        findAddress$ZipRangeArray[39] = findAddress$ZipRange = new FindAddress$ZipRange(10, 14, 0, n17);
        findAddress$ZipRangeArray[40] = findAddress$ZipRange = new FindAddress$ZipRange(43, 45, n11, n11);
        findAddress$ZipRangeArray[41] = findAddress$ZipRange = new FindAddress$ZipRange(73, 74, n11, n11);
        findAddress$ZipRangeArray[42] = findAddress$ZipRange = new FindAddress$ZipRange(97, 97, n11, n11);
        findAddress$ZipRangeArray[43] = findAddress$ZipRange = new FindAddress$ZipRange(15, n19, n11, n11);
        findAddress$ZipRangeArray[44] = findAddress$ZipRange = new FindAddress$ZipRange(n17, n17, 0, n20);
        findAddress$ZipRangeArray[45] = findAddress$ZipRange = new FindAddress$ZipRange(n14, n14, n11, n11);
        findAddress$ZipRangeArray[46] = findAddress$ZipRange = new FindAddress$ZipRange(n13, n13, n11, n11);
        findAddress$ZipRangeArray[47] = findAddress$ZipRange = new FindAddress$ZipRange(n10, n10, n11, n11);
        n10 = 57;
        findAddress$ZipRangeArray[48] = findAddress$ZipRange = new FindAddress$ZipRange(n10, n10, n11, n11);
        findAddress$ZipRangeArray[49] = findAddress$ZipRange = new FindAddress$ZipRange(37, n22, n11, n11);
        findAddress$ZipRangeArray[50] = findAddress$ZipRange = new FindAddress$ZipRange(75, 79, 87, n16);
        findAddress$ZipRangeArray[51] = findAddress$ZipRange = new FindAddress$ZipRange(84, 84, n11, n11);
        findAddress$ZipRangeArray[52] = findAddress$ZipRange = new FindAddress$ZipRange(22, 24, 20, n11);
        findAddress$ZipRangeArray[53] = findAddress$ZipRange = new FindAddress$ZipRange(n17, n20, n11, n11);
        int n23 = 5;
        findAddress$ZipRangeArray[54] = findAddress$ZipRange = new FindAddress$ZipRange(n23, n23, n11, n11);
        findAddress$ZipRangeArray[n12] = findAddress$ZipRange = new FindAddress$ZipRange(98, 99, n11, n11);
        findAddress$ZipRangeArray[56] = findAddress$ZipRange = new FindAddress$ZipRange(53, 54, n11, n11);
        findAddress$ZipRangeArray[n10] = findAddress$ZipRange = new FindAddress$ZipRange(24, 26, n11, n11);
        findAddress$ZipRangeArray[58] = findAddress$ZipRange = new FindAddress$ZipRange(82, 83, n11, n11);
        sStateZipCodeRanges = findAddress$ZipRangeArray;
        sWordRe = Pattern.compile("[^,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", n13);
        sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", n13);
        sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+of[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+states[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+of[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+mariana[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+carolina)|(nd|north[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+hampshire)|(nj|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+jersey)|(nm|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+island)|(sc|south[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+carolina)|(sd|south[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000]+virginia)|(wy|wyoming))(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", n13);
        sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", n13);
        sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", n13);
        sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*\u2022\t \u00a0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", n13);
    }

    private FindAddress() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int attemptMatch(String string2, MatchResult matchResult) {
        int n10;
        int n11 = matchResult.end();
        Matcher matcher = sWordRe.matcher(string2);
        int n12 = -1;
        int n13 = 1;
        Object object = "";
        int n14 = n12;
        int n15 = n12;
        int n16 = 0;
        int n17 = n13;
        int n18 = n13;
        int n19 = n13;
        while (n11 < (n10 = string2.length())) {
            Object object2;
            int n20;
            n10 = (int)(matcher.find(n11) ? 1 : 0);
            if (n10 == 0) {
                n20 = string2.length();
                return -n20;
            }
            n10 = matcher.end();
            int n21 = matcher.start();
            if ((n10 -= n21) > (n21 = 25)) {
                n20 = matcher.end();
                return -n20;
            }
            while (n11 < (n10 = matcher.start())) {
                n10 = n11 + 1;
                n11 = string2.charAt(n11);
                object2 = NL;
                if ((n11 = ((String)object2).indexOf(n11)) != n12) {
                    ++n17;
                }
                n11 = n10;
            }
            n10 = 5;
            if (n17 > n10 || (n18 += n13) > (n21 = 14)) break;
            object2 = FindAddress.matchHouseNumber(string2, n11);
            if (object2 != null) {
                if (n19 != 0 && n17 > n13) {
                    return -n11;
                }
                if (n14 == n12) {
                    n14 = n11;
                }
            } else {
                String string3 = matcher.group(0);
                n19 = (int)(FindAddress.isValidLocationName(string3) ? 1 : 0);
                if (n19 != 0) {
                    n19 = 0;
                    string3 = null;
                    n16 = n13;
                } else {
                    if (n18 == n10 && n16 == 0) {
                        n11 = matcher.end();
                        break;
                    }
                    if (n16 != 0 && n18 > (n19 = 4) && (matchResult = FindAddress.matchState(string2, n11)) != null) {
                        string3 = "et";
                        boolean bl2 = ((String)object).equals(string3);
                        if (bl2 && (bl2 = ((String)(object = matchResult.group(0))).equals(string3 = "al"))) {
                            n11 = matchResult.end();
                            break;
                        }
                        object = sWordRe.matcher(string2);
                        n19 = matchResult.end();
                        if ((n19 = (int)(((Matcher)object).find(n19) ? 1 : 0)) != 0) {
                            string3 = ((Matcher)object).group(0);
                            n11 = (int)(FindAddress.isValidZipCode(string3, matchResult) ? 1 : 0);
                            if (n11 != 0) {
                                return ((Matcher)object).end();
                            }
                        } else {
                            n15 = matchResult.end();
                        }
                    }
                    n19 = 0;
                    string3 = null;
                }
            }
            object = matcher.group(0);
            n11 = matcher.end();
        }
        if (n15 > 0) {
            return n15;
        }
        if (n14 > 0) return -n14;
        n14 = n11;
        return -n14;
    }

    private static boolean checkHouseNumber(String object) {
        int n10;
        int n11;
        int n12 = 0;
        Object object2 = null;
        int n13 = 0;
        for (n11 = 0; n11 < (n10 = ((String)object).length()); ++n11) {
            n10 = (int)(Character.isDigit(((String)object).charAt(n11)) ? 1 : 0);
            if (n10 == 0) continue;
            ++n13;
        }
        n11 = 5;
        if (n13 > n11) {
            return false;
        }
        object2 = sSuffixedNumberRe;
        object = ((Pattern)object2).matcher((CharSequence)object);
        n11 = (int)(((Matcher)object).find() ? 1 : 0);
        n13 = 1;
        if (n11 != 0) {
            object2 = ((Matcher)object).group(n13);
            n11 = Integer.parseInt((String)object2);
            if (n11 == 0) {
                return false;
            }
            n12 = 2;
            object = ((Matcher)object).group(n12);
            Locale locale = Locale.getDefault();
            object = ((String)object).toLowerCase(locale);
            n10 = n11 % 10;
            String string2 = "th";
            if (n10 != n13) {
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        return ((String)object).equals(string2);
                    }
                    n12 = 13;
                    if ((n11 %= 100) != n12) {
                        string2 = "rd";
                    }
                    return ((String)object).equals(string2);
                }
                n12 = 12;
                if ((n11 %= 100) != n12) {
                    string2 = "nd";
                }
                return ((String)object).equals(string2);
            }
            n12 = 11;
            if ((n11 %= 100) != n12) {
                string2 = "st";
            }
            return ((String)object).equals(string2);
        }
        return n13 != 0;
    }

    public static String findAddress(String string2) {
        Matcher matcher = sHouseNumberRe.matcher(string2);
        int n10 = 0;
        String string3 = null;
        while ((n10 = (int)(matcher.find(n10) ? 1 : 0)) != 0) {
            string3 = matcher.group(0);
            n10 = (int)(FindAddress.checkHouseNumber(string3) ? 1 : 0);
            if (n10 != 0) {
                n10 = matcher.start();
                int n11 = FindAddress.attemptMatch(string2, matcher);
                if (n11 > 0) {
                    return string2.substring(n10, n11);
                }
                n10 = -n11;
                continue;
            }
            n10 = matcher.end();
        }
        return null;
    }

    public static boolean isValidLocationName(String string2) {
        return sLocationNameRe.matcher(string2).matches();
    }

    public static boolean isValidZipCode(String string2) {
        return sZipCodeRe.matcher(string2).matches();
    }

    public static boolean isValidZipCode(String string2, String object) {
        object = FindAddress.matchState((String)object, 0);
        return FindAddress.isValidZipCode(string2, (MatchResult)object);
    }

    private static boolean isValidZipCode(String string2, MatchResult object) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = false;
        if (object == null) {
            return false;
        }
        int n10 = object.groupCount();
        while (n10 > 0) {
            int n11 = n10 + -1;
            String string3 = object.group(n10);
            if (string3 != null) {
                n10 = n11;
                break;
            }
            n10 = n11;
        }
        if ((bl3 = ((Matcher)(object = sZipCodeRe.matcher(string2))).matches()) && (bl2 = ((FindAddress$ZipRange)(object = sStateZipCodeRanges[n10])).matches(string2))) {
            bl4 = true;
        }
        return bl4;
    }

    public static MatchResult matchHouseNumber(String object, int n10) {
        String string2;
        int n11;
        Matcher matcher;
        if (n10 > 0) {
            int n12;
            int n13 = n10 + -1;
            n13 = ((String)object).charAt(n13);
            String string3 = HOUSE_PRE_DELIM;
            if ((n13 = string3.indexOf(n13)) == (n12 = -1)) {
                return null;
            }
        }
        if ((n10 = (int)(((Matcher)(object = (matcher = sHouseNumberRe.matcher((CharSequence)object)).region(n10, n11 = ((String)object).length()))).lookingAt() ? 1 : 0)) != 0 && (n10 = (int)(FindAddress.checkHouseNumber(string2 = (object = ((Matcher)object).toMatchResult()).group(0)) ? 1 : 0)) != 0) {
            return object;
        }
        return null;
    }

    public static MatchResult matchState(String object, int n10) {
        int n11;
        Matcher matcher;
        MatchResult matchResult = null;
        if (n10 > 0) {
            int n12;
            int n13 = n10 + -1;
            n13 = ((String)object).charAt(n13);
            String string2 = WORD_DELIM;
            if ((n13 = string2.indexOf(n13)) == (n12 = -1)) {
                return null;
            }
        }
        if ((n10 = (int)(((Matcher)(object = (matcher = sStateRe.matcher((CharSequence)object)).region(n10, n11 = ((String)object).length()))).lookingAt() ? 1 : 0)) != 0) {
            matchResult = ((Matcher)object).toMatchResult();
        }
        return matchResult;
    }
}

