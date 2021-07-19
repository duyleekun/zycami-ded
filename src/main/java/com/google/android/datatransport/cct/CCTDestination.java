/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.StringMerger;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class CCTDestination
implements EncodedDestination {
    private static final String DEFAULT_API_KEY;
    public static final String DEFAULT_END_POINT;
    public static final String DESTINATION_NAME = "cct";
    private static final String EXTRAS_DELIMITER = "\\";
    private static final String EXTRAS_VERSION_MARKER = "1$";
    public static final CCTDestination INSTANCE;
    public static final String LEGACY_END_POINT;
    public static final CCTDestination LEGACY_INSTANCE;
    private static final Set SUPPORTED_ENCODINGS;
    private final String apiKey;
    private final String endPoint;

    static {
        String string2;
        String string3;
        Object object = StringMerger.mergeStrings("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        DEFAULT_END_POINT = object;
        LEGACY_END_POINT = string3 = StringMerger.mergeStrings("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        DEFAULT_API_KEY = string2 = StringMerger.mergeStrings("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        Encoding encoding = Encoding.of("proto");
        Object object2 = new Encoding[]{encoding, encoding = Encoding.of("json")};
        object2 = Arrays.asList(object2);
        Object object3 = new HashSet(object2);
        SUPPORTED_ENCODINGS = Collections.unmodifiableSet(object3);
        INSTANCE = object3 = new CCTDestination((String)object, null);
        LEGACY_INSTANCE = object = new CCTDestination(string3, string2);
    }

    public CCTDestination(String string2, String string3) {
        this.endPoint = string2;
        this.apiKey = string3;
    }

    public static String decodeExtras(byte[] byArray) {
        Charset charset = Charset.forName("UTF-8");
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static byte[] encodeString(String string2) {
        Charset charset = Charset.forName("UTF-8");
        return string2.getBytes(charset);
    }

    public static CCTDestination fromByteArray(byte[] object) {
        Object object2 = Charset.forName("UTF-8");
        Object object3 = new String((byte[])object, (Charset)object2);
        boolean n10 = ((String)object3).startsWith((String)(object = EXTRAS_VERSION_MARKER));
        if (n10) {
            int n11 = 2;
            object3 = ((String)object3).substring(n11);
            object2 = Pattern.quote(EXTRAS_DELIMITER);
            int n12 = ((String[])(object3 = ((String)object3).split((String)object2, n11))).length;
            if (n12 == n11) {
                boolean bl2 = false;
                object = object3[0];
                n12 = (int)(((String)object).isEmpty() ? 1 : 0);
                if (n12 == 0) {
                    n12 = 1;
                    boolean bl3 = ((String)(object3 = object3[n12])).isEmpty();
                    if (bl3) {
                        object3 = null;
                    }
                    object2 = new CCTDestination((String)object, (String)object3);
                    return object2;
                }
                object = new IllegalArgumentException("Missing endpoint in CCTDestination extras");
                throw object;
            }
            object = new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
            throw object;
        }
        object = new IllegalArgumentException("Version marker missing from extras");
        throw object;
    }

    public byte[] asByteArray() {
        Object object;
        String string2 = this.apiKey;
        if (string2 == null && (object = this.endPoint) == null) {
            return null;
        }
        int n10 = 4;
        object = new Object[n10];
        object[0] = EXTRAS_VERSION_MARKER;
        String string3 = this.endPoint;
        object[1] = string3;
        string3 = EXTRAS_DELIMITER;
        object[2] = string3;
        int n11 = 3;
        if (string2 == null) {
            string2 = "";
        }
        object[n11] = string2;
        string2 = String.format("%s%s%s%s", object);
        object = Charset.forName("UTF-8");
        return string2.getBytes((Charset)object);
    }

    public String getAPIKey() {
        return this.apiKey;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public byte[] getExtras() {
        return this.asByteArray();
    }

    public String getName() {
        return DESTINATION_NAME;
    }

    public Set getSupportedEncodings() {
        return SUPPORTED_ENCODINGS;
    }
}

