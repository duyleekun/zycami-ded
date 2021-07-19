/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.FastParser$ParseException;
import com.google.android.gms.common.server.response.FastParser$zaa;
import com.google.android.gms.common.server.response.zaa;
import com.google.android.gms.common.server.response.zab;
import com.google.android.gms.common.server.response.zac;
import com.google.android.gms.common.server.response.zad;
import com.google.android.gms.common.server.response.zae;
import com.google.android.gms.common.server.response.zaf;
import com.google.android.gms.common.server.response.zag;
import com.google.android.gms.common.server.response.zah;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class FastParser {
    private static final char[] zaqg;
    private static final char[] zaqh;
    private static final char[] zaqi;
    private static final char[] zaqj;
    private static final char[] zaqk;
    private static final char[] zaql;
    private static final FastParser$zaa zaqn;
    private static final FastParser$zaa zaqo;
    private static final FastParser$zaa zaqp;
    private static final FastParser$zaa zaqq;
    private static final FastParser$zaa zaqr;
    private static final FastParser$zaa zaqs;
    private static final FastParser$zaa zaqt;
    private static final FastParser$zaa zaqu;
    private final char[] zaqb;
    private final char[] zaqc;
    private final char[] zaqd;
    private final StringBuilder zaqe;
    private final StringBuilder zaqf;
    private final Stack zaqm;

    static {
        Object object;
        char[] cArray;
        int n10 = 3;
        char[] cArray2 = cArray = new char[n10];
        cArray[0] = 117;
        cArray2[1] = 108;
        cArray2[2] = 108;
        zaqg = cArray;
        char[] cArray3 = object = new char[n10];
        object[0] = 114;
        cArray3[1] = 117;
        cArray3[2] = 101;
        zaqh = object;
        n10 = 4;
        char[] cArray4 = cArray = new char[n10];
        char[] cArray5 = cArray;
        cArray4[0] = 114;
        cArray5[1] = 117;
        cArray4[2] = 101;
        cArray5[3] = 34;
        zaqi = cArray;
        char[] cArray6 = object = new char[n10];
        char[] cArray7 = object;
        cArray6[0] = 97;
        cArray7[1] = 108;
        cArray6[2] = 115;
        cArray7[3] = 101;
        zaqj = object;
        char[] cArray8 = object = new char[5];
        char[] cArray9 = object;
        cArray8[0] = 97;
        cArray9[1] = 108;
        cArray8[2] = 115;
        cArray9[3] = 101;
        cArray9[4] = 34;
        zaqk = object;
        object = new char[]{'\n'};
        zaql = object;
        object = new zaa;
        object();
        zaqn = object;
        object = new zab;
        object();
        zaqo = object;
        object = new zac;
        object();
        zaqp = object;
        object = new zad;
        object();
        zaqq = object;
        object = new zae;
        object();
        zaqr = object;
        object = new zaf;
        object();
        zaqs = object;
        object = new zag;
        object();
        zaqt = object;
        object = new zah;
        object();
        zaqu = object;
    }

    public FastParser() {
        Object object = new char[1];
        this.zaqb = object;
        int n10 = 32;
        char[] cArray = new char[n10];
        this.zaqc = cArray;
        int n11 = 1024;
        Object object2 = new char[n11];
        this.zaqd = object2;
        object2 = new StringBuilder;
        super(n10);
        this.zaqe = object2;
        object = new StringBuilder;
        super(n11);
        this.zaqf = object;
        object = new Stack;
        super();
        this.zaqm = object;
    }

    public static /* synthetic */ int zaa(FastParser fastParser, BufferedReader bufferedReader) {
        return fastParser.zad(bufferedReader);
    }

    private final int zaa(BufferedReader object, char[] cArray) {
        int n10 = this.zaj((BufferedReader)object);
        String string2 = "Unexpected EOF";
        if (n10 != 0) {
            int n11 = 44;
            if (n10 != n11) {
                int n12;
                int n13 = 110;
                if (n10 == n13) {
                    cArray = zaqg;
                    this.zab((BufferedReader)object, cArray);
                    return 0;
                }
                ((BufferedReader)object).mark(1024);
                n13 = -1;
                int n14 = 34;
                int n15 = 1;
                if (n10 == n14) {
                    int n16;
                    n11 = 0;
                    for (n10 = 0; n10 < (n16 = cArray.length) && (n16 = ((BufferedReader)object).read(cArray, n10, n15)) != n13; ++n10) {
                        n16 = cArray[n10];
                        int n17 = Character.isISOControl((char)n16);
                        if (n17 == 0) {
                            if (n16 == n14 && n11 == 0) {
                                ((BufferedReader)object).reset();
                                long l10 = n10 + '\u0001';
                                ((BufferedReader)object).skip(l10);
                                return n10;
                            }
                            n17 = 92;
                            if (n16 == n17) {
                                n11 ^= '\u0001';
                                continue;
                            }
                            n11 = 0;
                            continue;
                        }
                        object = new FastParser$ParseException("Unexpected control character while reading string");
                        throw object;
                    }
                } else {
                    cArray[0] = n10;
                    for (n10 = n15; n10 < (n14 = cArray.length) && (n14 = ((BufferedReader)object).read(cArray, n10, n15)) != n13; ++n10) {
                        n14 = cArray[n10];
                        int n18 = 125;
                        if (n14 != n18 && (n14 = cArray[n10]) != n11 && (n14 = (int)(Character.isWhitespace(cArray[n10]) ? 1 : 0)) == 0 && (n14 = cArray[n10]) != (n18 = 93)) {
                            continue;
                        }
                        ((BufferedReader)object).reset();
                        long l11 = n10 + -1;
                        ((BufferedReader)object).skip(l11);
                        cArray[n10] = '\u0000';
                        return n10;
                    }
                }
                if (n10 == (n12 = cArray.length)) {
                    object = new FastParser$ParseException("Absurdly long value");
                    throw object;
                }
                object = new FastParser$ParseException(string2);
                throw object;
            }
            object = new FastParser$ParseException("Missing value");
            throw object;
        }
        object = new FastParser$ParseException(string2);
        throw object;
    }

    private final String zaa(BufferedReader object) {
        Object object2 = this.zaqm;
        char c10 = '\u0002';
        Comparable<Integer> comparable = (int)c10;
        ((Stack)object2).push(comparable);
        int n10 = this.zaj((BufferedReader)object);
        int n11 = 34;
        if (n10 != n11) {
            int n12 = 93;
            if (n10 != n12) {
                n12 = 125;
                if (n10 == n12) {
                    this.zak(c10);
                    return null;
                }
                comparable = new Comparable<Integer>(19);
                ((StringBuilder)comparable).append("Unexpected token: ");
                ((StringBuilder)comparable).append((char)n10);
                object2 = ((StringBuilder)comparable).toString();
                object = new FastParser$ParseException((String)object2);
                throw object;
            }
            this.zak(c10);
            this.zak(1);
            this.zak(5);
            return null;
        }
        object2 = this.zaqm;
        c10 = '\u0003';
        comparable = (int)c10;
        ((Stack)object2).push(comparable);
        object2 = this.zaqc;
        comparable = this.zaqe;
        object2 = FastParser.zab((BufferedReader)object, (char[])object2, (StringBuilder)comparable, null);
        this.zak(c10);
        char c11 = this.zaj((BufferedReader)object);
        c10 = ':';
        if (c11 == c10) {
            return object2;
        }
        object = new FastParser$ParseException("Expected key/value separator");
        throw object;
    }

    private final String zaa(BufferedReader object, char[] cArray, StringBuilder stringBuilder, char[] cArray2) {
        char c10;
        char c11 = this.zaj((BufferedReader)object);
        if (c11 != (c10 = '\"')) {
            char c12 = 'n';
            if (c11 == c12) {
                cArray = zaqg;
                this.zab((BufferedReader)object, cArray);
                return null;
            }
            object = new FastParser$ParseException("Expected string");
            throw object;
        }
        return FastParser.zab((BufferedReader)object, cArray, stringBuilder, cArray2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final ArrayList zaa(BufferedReader object, FastJsonResponse$Field object2) {
        String string2 = "Error instantiating inner object";
        ArrayList<Object> arrayList = new ArrayList<Object>();
        char c10 = this.zaj((BufferedReader)object);
        char c11 = ']';
        int n10 = 5;
        if (c10 == c11) {
            this.zak(n10);
            return arrayList;
        }
        char c12 = 'n';
        if (c10 == c12) {
            object2 = zaqg;
            this.zab((BufferedReader)object, (char[])object2);
            this.zak(n10);
            return null;
        }
        String string3 = "Unexpected token: ";
        int n11 = 19;
        char c13 = '{';
        if (c10 != c13) {
            object2 = new StringBuilder(n11);
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(c10);
            object2 = ((StringBuilder)object2).toString();
            object = new FastParser$ParseException((String)object2);
            throw object;
        }
        Object object3 = this.zaqm;
        int n12 = 1;
        Integer n13 = n12;
        ((Stack)object3).push(n13);
        while (true) {
            block9: {
                try {
                    object3 = ((FastJsonResponse$Field)object2).zacp();
                    char c14 = this.zaa((BufferedReader)object, (FastJsonResponse)object3);
                    if (c14 == '\u0000') break;
                    arrayList.add(object3);
                    c10 = this.zaj((BufferedReader)object);
                    c14 = ',';
                    if (c10 == c14) break block9;
                    if (c10 == c11) {
                        this.zak(n10);
                        return arrayList;
                    }
                    object2 = new StringBuilder(n11);
                    ((StringBuilder)object2).append(string3);
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = new FastParser$ParseException(string2, illegalAccessException);
                    throw object2;
                }
                catch (InstantiationException instantiationException) {
                    object2 = new FastParser$ParseException(string2, instantiationException);
                    throw object2;
                }
                ((StringBuilder)object2).append(c10);
                object2 = ((StringBuilder)object2).toString();
                object = new FastParser$ParseException((String)object2);
                throw object;
            }
            c10 = this.zaj((BufferedReader)object);
            if (c10 != c13) {
                object = new FastParser$ParseException("Expected start of next object in array");
                throw object;
            }
            object3 = this.zaqm;
            n13 = n12;
            ((Stack)object3).push(n13);
        }
        return arrayList;
    }

    private final ArrayList zaa(BufferedReader object, FastParser$zaa object2) {
        int n10;
        int n11 = this.zaj((BufferedReader)object);
        if (n11 == (n10 = 110)) {
            object2 = zaqg;
            this.zab((BufferedReader)object, (char[])object2);
            return null;
        }
        n10 = 91;
        if (n11 == n10) {
            block3: {
                AbstractList abstractList = this.zaqm;
                n10 = 5;
                Object object3 = n10;
                ((Stack)abstractList).push(object3);
                abstractList = new ArrayList();
                while (true) {
                    ((BufferedReader)object).mark(1024);
                    int n12 = this.zaj((BufferedReader)object);
                    if (n12 == 0) break block3;
                    int n13 = 44;
                    if (n12 == n13) continue;
                    n13 = 93;
                    if (n12 == n13) break;
                    ((BufferedReader)object).reset();
                    object3 = object2.zah(this, (BufferedReader)object);
                    ((ArrayList)abstractList).add(object3);
                }
                this.zak(n10);
                return abstractList;
            }
            object = new FastParser$ParseException("Unexpected EOF");
            throw object;
        }
        object = new FastParser$ParseException("Expected start of array");
        throw object;
    }

    public static /* synthetic */ boolean zaa(FastParser fastParser, BufferedReader bufferedReader, boolean bl2) {
        return fastParser.zaa(bufferedReader, false);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final boolean zaa(BufferedReader var1_1, FastJsonResponse var2_2) {
        var3_3 = this;
        var4_4 = var1_1;
        var5_7 = var2_2;
        var6_8 = "Error instantiating inner object";
        var7_9 = var2_2.getFieldMappings();
        var8_10 = this.zaa(var1_1);
        var9_11 = '\u0000';
        var10_12 /* !! */  = null;
        var11_13 = 1;
        var12_14 = var11_13;
        if (var8_10 == null) {
            this.zak(var11_13);
            return false;
        }
        while (var8_10 != null) {
            block49: {
                block50: {
                    if ((var8_10 = (FastJsonResponse$Field)var7_9.get(var8_10)) == null) {
                        var8_10 = this.zab(var1_1);
                        continue;
                    }
                    var13_15 = var3_3.zaqm;
                    var14_16 = '\u0004';
                    var15_17 = (int)var14_16;
                    var13_15.push(var15_17);
                    var16_18 = var8_10.zapr;
                    var17_19 = '{';
                    var18_20 = ',';
                    var19_21 = '}';
                    var20_22 = 'n';
                    switch (var16_18) {
                        default: {
                            var21_29 = var8_10.zapr;
                            var7_9 = new StringBuilder(30);
                            var7_9.append("Invalid field type ");
                            var7_9.append(var21_29);
                            var5_7 = var7_9.toString();
                            var4_4 = new FastParser$ParseException((String)var5_7);
                            throw var4_4;
                        }
                        case '\u000b': {
                            var16_18 = (char)var8_10.zaps;
                            if (var16_18 == '\u0000') ** GOTO lbl62
                            var16_18 = this.zaj(var1_1);
                            if (var16_18 != var20_22) ** GOTO lbl49
                            var13_15 = FastParser.zaqg;
                            var3_3.zab((BufferedReader)var4_4, (char[])var13_15);
                            var13_15 = var8_10.zapv;
                            var5_7.addConcreteTypeArrayInternal((FastJsonResponse$Field)var8_10, (String)var13_15, null);
                            ** GOTO lbl68
lbl49:
                            // 1 sources

                            var15_17 = var3_3.zaqm;
                            var20_22 = '\u0005';
                            var22_23 /* !! */  = Integer.valueOf(var20_22);
                            var15_17.push(var22_23 /* !! */ );
                            var17_19 = '[';
                            if (var16_18 != var17_19) ** GOTO lbl60
                            var13_15 = var8_10.zapv;
                            var15_17 = var3_3.zaa((BufferedReader)var4_4, (FastJsonResponse$Field)var8_10);
                            var5_7.addConcreteTypeArrayInternal((FastJsonResponse$Field)var8_10, (String)var13_15, (ArrayList)var15_17);
                            ** GOTO lbl68
lbl60:
                            // 1 sources

                            var4_4 = new FastParser$ParseException("Expected array start");
                            throw var4_4;
lbl62:
                            // 1 sources

                            var16_18 = this.zaj(var1_1);
                            if (var16_18 != var20_22) ** GOTO lbl71
                            var13_15 = FastParser.zaqg;
                            var3_3.zab((BufferedReader)var4_4, (char[])var13_15);
                            var13_15 = var8_10.zapv;
                            var5_7.addConcreteTypeInternal((FastJsonResponse$Field)var8_10, (String)var13_15, null);
lbl68:
                            // 4 sources

                            while (true) {
                                var23_24 = var14_16;
                                break block49;
                                break;
                            }
lbl71:
                            // 1 sources

                            var22_23 /* !! */  = var3_3.zaqm;
                            var22_23 /* !! */ .push(var12_14);
                            if (var16_18 == var17_19) {
                                var13_15 = var8_10.zacp();
                                var3_3.zaa((BufferedReader)var4_4, (FastJsonResponse)var13_15);
                                var15_17 = var8_10.zapv;
                                try {
                                    var5_7.addConcreteTypeInternal((FastJsonResponse$Field)var8_10, (String)var15_17, (FastJsonResponse)var13_15);
                                    ** continue;
                                }
                                catch (IllegalAccessException var4_5) {
                                    var5_7 = new FastParser$ParseException((String)var6_8, var4_5);
                                    throw var5_7;
                                }
                                catch (InstantiationException var4_6) {
                                    var5_7 = new FastParser$ParseException((String)var6_8, var4_6);
                                    throw var5_7;
                                }
                            }
                            var4_4 = new FastParser$ParseException("Expected start of object");
                            throw var4_4;
                        }
                        case '\n': {
                            var16_18 = this.zaj(var1_1);
                            if (var16_18 != var20_22) ** GOTO lbl101
                            var13_15 = FastParser.zaqg;
                            var3_3.zab((BufferedReader)var4_4, (char[])var13_15);
                            var16_18 = '\u0000';
                            var13_15 = null;
                            var24_25 = 0.0f;
                            ** GOTO lbl147
lbl101:
                            // 1 sources

                            if (var16_18 != var17_19) ** GOTO lbl163
                            var3_3.zaqm.push(var12_14);
                            var13_15 = new HashMap();
                            while ((var17_19 = (char)this.zaj(var1_1)) != '\u0000') {
                                var20_22 = '\"';
                                if (var17_19 == var20_22) ** GOTO lbl111
                                if (var17_19 != var19_21) ** GOTO lbl157
                                var3_3.zak(var11_13);
                                ** GOTO lbl147
lbl111:
                                // 1 sources

                                var15_17 = var3_3.zaqc;
                                var25_26 /* !! */  = (char[])var3_3.zaqe;
                                var25_26 /* !! */  = (char[])FastParser.zab((BufferedReader)var4_4, (char[])var15_17, (StringBuilder)var25_26 /* !! */ , null);
                                var17_19 = this.zaj(var1_1);
                                if (var17_19 != (var9_11 = ':')) {
                                    var5_7 = "No map value found for key ";
                                    var6_8 = String.valueOf((Object)var25_26 /* !! */ );
                                    var26_30 = var6_8.length();
                                    if (var26_30 != 0) {
                                        var5_7 = var5_7.concat((String)var6_8);
                                    } else {
                                        var6_8 = new String((String)var5_7);
                                        var5_7 = var6_8;
                                    }
                                    var4_4 = new FastParser$ParseException((String)var5_7);
                                    throw var4_4;
                                }
                                var9_11 = this.zaj(var1_1);
                                if (var9_11 != var20_22) {
                                    var5_7 = "Expected String value for key ";
                                    var6_8 = String.valueOf((Object)var25_26 /* !! */ );
                                    var26_31 = var6_8.length();
                                    if (var26_31 != 0) {
                                        var5_7 = var5_7.concat((String)var6_8);
                                    } else {
                                        var6_8 = new String((String)var5_7);
                                        var5_7 = var6_8;
                                    }
                                    var4_4 = new FastParser$ParseException((String)var5_7);
                                    throw var4_4;
                                }
                                var10_12 /* !! */  = var3_3.zaqc;
                                var15_17 = var3_3.zaqe;
                                var10_12 /* !! */  = (char[])FastParser.zab((BufferedReader)var4_4, var10_12 /* !! */ , (StringBuilder)var15_17, null);
                                var13_15.put(var25_26 /* !! */ , var10_12 /* !! */ );
                                var9_11 = this.zaj(var1_1);
                                if (var9_11 == var18_20) ** GOTO lbl157
                                if (var9_11 != var19_21) ** GOTO lbl149
                                var3_3.zak(var11_13);
lbl147:
                                // 3 sources

                                var5_7.zaa((FastJsonResponse$Field)var8_10, (Map)var13_15);
                                ** GOTO lbl178
lbl149:
                                // 1 sources

                                var6_8 = new StringBuilder(48);
                                var6_8.append("Unexpected character while parsing string map: ");
                                var6_8.append(var9_11);
                                var5_7 = var6_8.toString();
                                var4_4 = new FastParser$ParseException((String)var5_7);
                                throw var4_4;
lbl157:
                                // 2 sources

                                var9_11 = '\u0000';
                                var10_12 /* !! */  = null;
                                var14_16 = '\u0004';
                            }
                            var4_4 = new FastParser$ParseException("Unexpected EOF");
                            throw var4_4;
lbl163:
                            // 1 sources

                            var4_4 = new FastParser$ParseException("Expected start of a map object");
                            throw var4_4;
                        }
                        case '\t': {
                            var10_12 /* !! */  = var3_3.zaqd;
                            var13_15 = var3_3.zaqf;
                            var25_26 /* !! */  = FastParser.zaql;
                            var10_12 /* !! */  = (char[])Base64Utils.decodeUrlSafe(var3_3.zaa((BufferedReader)var4_4, var10_12 /* !! */ , (StringBuilder)var13_15, var25_26 /* !! */ ));
                            var5_7.zaa((FastJsonResponse$Field)var8_10, (byte[])var10_12 /* !! */ );
                            ** GOTO lbl178
                        }
                        case '\b': {
                            var10_12 /* !! */  = var3_3.zaqd;
                            var13_15 = var3_3.zaqf;
                            var25_26 /* !! */  = FastParser.zaql;
                            var10_12 /* !! */  = (char[])Base64Utils.decode(var3_3.zaa((BufferedReader)var4_4, var10_12 /* !! */ , (StringBuilder)var13_15, var25_26 /* !! */ ));
                            var5_7.zaa((FastJsonResponse$Field)var8_10, (byte[])var10_12 /* !! */ );
lbl178:
                            // 6 sources

                            while (true) {
                                var23_24 = '\u0004';
                                var9_11 = '\u0000';
                                var10_12 /* !! */  = null;
                                break block49;
                                break;
                            }
                        }
                        case '\u0007': {
                            var9_11 = var8_10.zaps;
                            if (var9_11 == '\u0000') ** GOTO lbl190
                            var10_12 /* !! */  = (char[])FastParser.zaqs;
                            var10_12 /* !! */  = (char[])var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var10_12 /* !! */ );
                            var5_7.zah((FastJsonResponse$Field)var8_10, (ArrayList)var10_12 /* !! */ );
                            ** GOTO lbl178
lbl190:
                            // 1 sources

                            var10_12 /* !! */  = (char[])this.zac(var1_1);
                            var5_7.zaa((FastJsonResponse$Field)var8_10, (String)var10_12 /* !! */ );
                            ** GOTO lbl178
                        }
                        case '\u0006': {
                            var9_11 = var8_10.zaps;
                            if (var9_11 != '\u0000') {
                                var10_12 /* !! */  = (char[])FastParser.zaqr;
                                var10_12 /* !! */  = (char[])var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var10_12 /* !! */ );
                                var5_7.zag((FastJsonResponse$Field)var8_10, (ArrayList)var10_12 /* !! */ );
                                ** continue;
                            }
                            var9_11 = '\u0000';
                            var10_12 /* !! */  = null;
                            var16_18 = (char)var3_3.zaa((BufferedReader)var4_4, false);
                            var5_7.zaa((FastJsonResponse$Field)var8_10, (boolean)var16_18);
                            break block50;
                        }
                        case '\u0005': {
                            var16_18 = (char)var8_10.zaps;
                            if (var16_18 != '\u0000') {
                                var13_15 = FastParser.zaqu;
                                var13_15 = var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var13_15);
                                var5_7.zaf((FastJsonResponse$Field)var8_10, (ArrayList)var13_15);
                            } else {
                                var13_15 = this.zai(var1_1);
                                var5_7.zaa((FastJsonResponse$Field)var8_10, (BigDecimal)var13_15);
                            }
                            break block50;
                        }
                        case '\u0004': {
                            var16_18 = (char)var8_10.zaps;
                            if (var16_18 != '\u0000') {
                                var13_15 = FastParser.zaqq;
                                var13_15 = var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var13_15);
                                var5_7.zae((FastJsonResponse$Field)var8_10, (ArrayList)var13_15);
                            } else {
                                var27_27 = this.zah(var1_1);
                                var5_7.zaa((FastJsonResponse$Field)var8_10, var27_27);
                            }
                            break block50;
                        }
                        case '\u0003': {
                            var16_18 = (char)var8_10.zaps;
                            if (var16_18 != '\u0000') {
                                var13_15 = FastParser.zaqp;
                                var13_15 = var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var13_15);
                                var5_7.zad((FastJsonResponse$Field)var8_10, (ArrayList)var13_15);
                            } else {
                                var24_25 = this.zag(var1_1);
                                var5_7.zaa((FastJsonResponse$Field)var8_10, var24_25);
                            }
                            break block50;
                        }
                        case '\u0002': {
                            var16_18 = (char)var8_10.zaps;
                            if (var16_18 != '\u0000') {
                                var13_15 = FastParser.zaqo;
                                var13_15 = var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var13_15);
                                var5_7.zac((FastJsonResponse$Field)var8_10, (ArrayList)var13_15);
                            } else {
                                var29_28 = this.zae(var1_1);
                                var5_7.zaa((FastJsonResponse$Field)var8_10, var29_28);
                            }
                            break block50;
                        }
                        case '\u0001': {
                            var16_18 = (char)var8_10.zaps;
                            if (var16_18 != '\u0000') {
                                var13_15 = FastParser.zaqt;
                                var13_15 = var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var13_15);
                                var5_7.zab((FastJsonResponse$Field)var8_10, (ArrayList)var13_15);
                            } else {
                                var13_15 = this.zaf(var1_1);
                                var5_7.zaa((FastJsonResponse$Field)var8_10, (BigInteger)var13_15);
                            }
                            break block50;
                        }
                        case '\u0000': 
                    }
                    var16_18 = (char)var8_10.zaps;
                    if (var16_18 != '\u0000') {
                        var13_15 = FastParser.zaqn;
                        var13_15 = var3_3.zaa((BufferedReader)var4_4, (FastParser$zaa)var13_15);
                        var5_7.zaa((FastJsonResponse$Field)var8_10, (ArrayList)var13_15);
                    } else {
                        var16_18 = this.zad(var1_1);
                        var5_7.zaa((FastJsonResponse$Field)var8_10, var16_18);
                    }
                }
                var23_24 = '\u0004';
            }
            var3_3.zak(var23_24);
            var3_3.zak(2);
            var23_24 = this.zaj(var1_1);
            if (var23_24 != var18_20) {
                if (var23_24 == var19_21) {
                    var23_24 = '\u0000';
                    var8_10 = null;
                    continue;
                }
                var6_8 = new StringBuilder(55);
                var6_8.append("Expected end of object or field separator, but found: ");
                var6_8.append(var23_24);
                var5_7 = var6_8.toString();
                var4_4 = new FastParser$ParseException((String)var5_7);
                throw var4_4;
            }
            var8_10 = this.zaa(var1_1);
        }
        var3_3.zak(var11_13);
        return (boolean)var11_13;
    }

    private final boolean zaa(BufferedReader object, boolean bl2) {
        boolean bl3 = true;
        while (true) {
            char c10;
            char c11;
            if ((c11 = this.zaj((BufferedReader)object)) != (c10 = '\"')) {
                c10 = 'f';
                if (c11 != c10) {
                    c10 = 'n';
                    if (c11 != c10) {
                        c10 = 't';
                        if (c11 == c10) {
                            char[] cArray = bl2 ? zaqi : zaqh;
                            this.zab((BufferedReader)object, cArray);
                            return bl3;
                        }
                        StringBuilder stringBuilder = new StringBuilder(19);
                        stringBuilder.append("Unexpected token: ");
                        stringBuilder.append(c11);
                        String string2 = stringBuilder.toString();
                        object = new FastParser$ParseException(string2);
                        throw object;
                    }
                    char[] cArray = zaqg;
                    this.zab((BufferedReader)object, cArray);
                    return false;
                }
                char[] cArray = bl2 ? zaqk : zaqj;
                this.zab((BufferedReader)object, cArray);
                return false;
            }
            if (bl2) break;
            bl2 = bl3;
        }
        object = new FastParser$ParseException("No boolean value found in string");
        throw object;
    }

    public static /* synthetic */ long zab(FastParser fastParser, BufferedReader bufferedReader) {
        return fastParser.zae(bufferedReader);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final String zab(BufferedReader var1_1) {
        block25: {
            block22: {
                block23: {
                    block24: {
                        var2_2 = this;
                        var3_3 = var1_1;
                        var1_1.mark(1024);
                        var4_4 = this.zaj(var1_1);
                        var5_5 = 92;
                        var6_6 = "Unexpected token ";
                        var7_7 = 18;
                        var8_8 = 125;
                        var9_9 = 44;
                        var10_10 = 34;
                        if (var4_4 == var10_10) break block23;
                        if (var4_4 == var9_9) break block24;
                        var11_11 = 32;
                        var12_12 = 91;
                        var13_14 = 1;
                        if (var4_4 == var12_12) ** GOTO lbl49
                        var5_5 = 123;
                        if (var4_4 != var5_5) {
                            var1_1.reset();
                            var14_16 /* !! */  = this.zaqd;
                            this.zaa(var1_1, var14_16 /* !! */ );
                        } else {
                            var14_16 /* !! */  = (char[])this.zaqm;
                            var15_17 = var13_14;
                            var14_16 /* !! */ .push(var15_17);
                            var1_1.mark(var11_11);
                            var4_4 = this.zaj(var1_1);
                            if (var4_4 == var8_8) {
                                this.zak(var13_14);
                            } else if (var4_4 == var10_10) {
                                var1_1.reset();
                                this.zaa(var1_1);
                                while ((var14_16 /* !! */  = (char[])this.zab(var1_1)) != null) {
                                }
                                var2_2.zak(var13_14);
                            } else {
                                var15_17 = new Comparable<Integer>(var7_7);
                                var15_17.append(var6_6);
                                var15_17.append((char)var4_4);
                                var14_16 /* !! */  = (char[])var15_17.toString();
                                var3_3 = new FastParser$ParseException((String)var14_16 /* !! */ );
                                throw var3_3;
lbl49:
                                // 1 sources

                                var14_16 /* !! */  = (char[])this.zaqm;
                                var16_18 = 5;
                                var17_20 = var16_18;
                                var14_16 /* !! */ .push(var17_20);
                                var1_1.mark(var11_11);
                                var4_4 = this.zaj(var1_1);
                                var11_11 = 93;
                                if (var4_4 == var11_11) {
                                    this.zak(var16_18);
                                } else {
                                    var1_1.reset();
                                    var4_4 = 0;
                                    var14_16 /* !! */  = null;
                                    var18_21 = false;
                                    var17_20 = null;
                                    while (var13_14 > 0) {
                                        var19_22 = this.zaj(var1_1);
                                        if (var19_22 != '\u0000') {
                                            var20_23 = Character.isISOControl(var19_22);
                                            if (!var20_23) {
                                                if (var19_22 == var10_10 && var4_4 == 0) {
                                                    var18_21 ^= true;
                                                }
                                                if (var19_22 == var12_12 && !var18_21) {
                                                    ++var13_14;
                                                }
                                                if (var19_22 == var11_11 && !var18_21) {
                                                    var13_14 += -1;
                                                }
                                                if (var19_22 == var5_5 && var18_21) {
                                                    var4_4 ^= '\u0001';
                                                    continue;
                                                }
                                                var4_4 = 0;
                                                var14_16 /* !! */  = null;
                                                continue;
                                            }
                                            var3_3 = new FastParser$ParseException("Unexpected control character while reading array");
                                            throw var3_3;
                                        }
                                        var3_3 = new FastParser$ParseException("Unexpected EOF while parsing array");
                                        throw var3_3;
                                    }
                                    var2_2.zak(var16_18);
                                }
                            }
                        }
                        ** GOTO lbl102
                    }
                    var3_3 = new FastParser$ParseException("Missing value");
                    throw var3_3;
                }
                var14_16 /* !! */  = this.zaqb;
                var4_4 = var1_1.read(var14_16 /* !! */ );
                var21_24 = "Unexpected EOF while parsing string";
                var12_13 = -1;
                if (var4_4 == var12_13) break block25;
                var14_16 /* !! */  = this.zaqb;
                var4_4 = var14_16 /* !! */ [0];
                var13_15 = 0;
                do {
                    block26: {
                        if (var4_4 != var10_10 || var13_15 != 0) break block26;
lbl102:
                        // 6 sources

                        var4_4 = this.zaj(var1_1);
                        var5_5 = 2;
                        if (var4_4 != var9_9) {
                            if (var4_4 == var8_8) {
                                var2_2.zak(var5_5);
                                return null;
                            }
                            var15_17 = new Comparable<Integer>(var7_7);
                            var15_17.append(var6_6);
                            var15_17.append((char)var4_4);
                            var14_16 /* !! */  = (char[])var15_17.toString();
                            var3_3 = new FastParser$ParseException((String)var14_16 /* !! */ );
                            throw var3_3;
                        }
                        var2_2.zak(var5_5);
                        return this.zaa(var1_1);
                    }
                    var13_15 = var4_4 == var5_5 ? (var4_4 = var13_15 ^ 1) : 0;
                    var14_16 /* !! */  = var2_2.zaqb;
                    var4_4 = var3_3.read(var14_16 /* !! */ );
                    if (var4_4 == var12_13) break block22;
                } while (!(var16_19 = Character.isISOControl((char)(var4_4 = (var14_16 /* !! */  = var2_2.zaqb)[0]))));
                var3_3 = new FastParser$ParseException("Unexpected control character while reading string");
                throw var3_3;
            }
            var3_3 = new FastParser$ParseException(var21_24);
            throw var3_3;
        }
        var3_3 = new FastParser$ParseException(var21_24);
        throw var3_3;
    }

    private static String zab(BufferedReader object, char[] cArray, StringBuilder stringBuilder, char[] cArray2) {
        int n10;
        int n11;
        stringBuilder.setLength(0);
        int n12 = cArray.length;
        ((BufferedReader)object).mark(n12);
        n12 = 0;
        int n13 = 0;
        while ((n11 = ((Reader)object).read(cArray)) != (n10 = -1)) {
            for (n10 = 0; n10 < n11; ++n10) {
                int n14 = cArray[n10];
                int n15 = Character.isISOControl((char)n14);
                int n16 = 1;
                if (n15 != 0) {
                    if (cArray2 != null) {
                        int n17;
                        for (n15 = 0; n15 < (n17 = cArray2.length); ++n15) {
                            n17 = cArray2[n15];
                            if (n17 != n14) continue;
                            n15 = n16;
                            break;
                        }
                    } else {
                        n15 = 0;
                    }
                    if (n15 == 0) {
                        object = new FastParser$ParseException("Unexpected control character while reading string");
                        throw object;
                    }
                }
                if (n14 == (n15 = 34) && n12 == 0) {
                    stringBuilder.append(cArray, 0, n10);
                    ((BufferedReader)object).reset();
                    long l10 = n10 += n16;
                    ((BufferedReader)object).skip(l10);
                    if (n13 != 0) {
                        return JsonUtils.unescapeString(stringBuilder.toString());
                    }
                    return stringBuilder.toString();
                }
                n15 = 92;
                if (n14 == n15) {
                    n12 ^= 1;
                    n13 = n16;
                    continue;
                }
                n12 = 0;
            }
            stringBuilder.append(cArray, 0, n11);
            n11 = cArray.length;
            ((BufferedReader)object).mark(n11);
        }
        object = new FastParser$ParseException("Unexpected EOF while parsing string");
        throw object;
    }

    private final void zab(BufferedReader object, char[] cArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = cArray.length); i10 += n10) {
            char[] cArray2 = this.zaqc;
            int n11 = cArray.length - i10;
            n10 = ((BufferedReader)object).read(cArray2, 0, n11);
            if (n10 != (n11 = -1)) {
                for (n11 = 0; n11 < n10; ++n11) {
                    int n12 = n11 + i10;
                    char[] cArray3 = this.zaqc;
                    char c10 = cArray3[n11];
                    if ((n12 = cArray[n12]) == c10) {
                        continue;
                    }
                    object = new FastParser$ParseException("Unexpected character");
                    throw object;
                }
                continue;
            }
            object = new FastParser$ParseException("Unexpected EOF");
            throw object;
        }
    }

    public static /* synthetic */ float zac(FastParser fastParser, BufferedReader bufferedReader) {
        return fastParser.zag(bufferedReader);
    }

    private final String zac(BufferedReader bufferedReader) {
        char[] cArray = this.zaqc;
        StringBuilder stringBuilder = this.zaqe;
        return this.zaa(bufferedReader, cArray, stringBuilder, null);
    }

    public static /* synthetic */ double zad(FastParser fastParser, BufferedReader bufferedReader) {
        return fastParser.zah(bufferedReader);
    }

    private final int zad(BufferedReader object) {
        char[] cArray = this.zaqd;
        int n10 = this.zaa((BufferedReader)object, cArray);
        int n11 = 0;
        cArray = null;
        if (n10 == 0) {
            return 0;
        }
        char[] cArray2 = this.zaqd;
        if (n10 > 0) {
            int n12 = cArray2[0];
            int n13 = 45;
            int n14 = 1;
            float f10 = Float.MIN_VALUE;
            if (n12 == n13) {
                n12 = -1 << -1;
                n13 = n14;
            } else {
                n12 = -2147483647;
                n13 = 0;
            }
            int n15 = n13;
            String string2 = "Unexpected non-digit character";
            int n16 = 10;
            if (n13 < n10) {
                n11 = n13 + 1;
                if ((n13 = Character.digit(cArray2[n13], n16)) >= 0) {
                    int n17 = -n13;
                    n13 = n11;
                    n11 = n17;
                } else {
                    object = new FastParser$ParseException(string2);
                    throw object;
                }
            }
            while (n13 < n10) {
                int n18 = n13 + 1;
                if ((n13 = Character.digit(cArray2[n13], n16)) >= 0) {
                    int n19 = -214748364;
                    String string3 = "Number too large";
                    if (n11 >= n19) {
                        n19 = n12 + n13;
                        if ((n11 *= 10) >= n19) {
                            n11 -= n13;
                            n13 = n18;
                            continue;
                        }
                        object = new FastParser$ParseException(string3);
                        throw object;
                    }
                    object = new FastParser$ParseException(string3);
                    throw object;
                }
                object = new FastParser$ParseException(string2);
                throw object;
            }
            if (n15 != 0) {
                if (n13 > n14) {
                    return n11;
                }
                object = new FastParser$ParseException("No digits to parse");
                throw object;
            }
            return -n11;
        }
        object = new FastParser$ParseException("No number to parse");
        throw object;
    }

    private final long zae(BufferedReader bufferedReader) {
        Object object = this.zaqd;
        int n10 = this.zaa(bufferedReader, (char[])object);
        long l10 = 0L;
        if (n10 == 0) {
            return l10;
        }
        char[] cArray = this.zaqd;
        if (n10 > 0) {
            long l11;
            int n11 = 0;
            int n12 = cArray[0];
            int n13 = 45;
            int n14 = 1;
            float f10 = Float.MIN_VALUE;
            if (n12 == n13) {
                long l12;
                l11 = l12 = Long.MIN_VALUE;
                n11 = n14;
            } else {
                long l13;
                l11 = l13 = -9223372036854775807L;
            }
            n12 = n11;
            String string2 = "Unexpected non-digit character";
            int n15 = 10;
            if (n11 < n10) {
                int n16 = n11 + '\u0001';
                int n17 = Character.digit(cArray[n11], n15);
                if (n17 >= 0) {
                    n17 = -n17;
                    long l14 = n17;
                    n11 = n16;
                    l10 = l14;
                } else {
                    object = new FastParser$ParseException;
                    object(string2);
                    throw object;
                }
            }
            while (n11 < n10) {
                int n18 = n11 + '\u0001';
                if ((n11 = Character.digit(cArray[n11], n15)) >= 0) {
                    long l15 = -922337203685477580L;
                    long l16 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
                    String string3 = "Number too large";
                    if (l16 >= 0) {
                        l16 = n18;
                        long l17 = n11;
                        long l18 = l11 + l17;
                        long l19 = (l10 *= (long)10) - l18;
                        if ((n11 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1))) >= 0) {
                            l10 -= l17;
                            n11 = n18;
                            n15 = 10;
                            continue;
                        }
                        object = new FastParser$ParseException;
                        object(string3);
                        throw object;
                    }
                    object = new FastParser$ParseException;
                    object(string3);
                    throw object;
                }
                object = new FastParser$ParseException;
                object(string2);
                throw object;
            }
            if (n12 != 0) {
                if (n11 > n14) {
                    return l10;
                }
                object = new FastParser$ParseException;
                object("No digits to parse");
                throw object;
            }
            return -l10;
        }
        object = new FastParser$ParseException;
        object("No number to parse");
        throw object;
    }

    public static /* synthetic */ String zae(FastParser fastParser, BufferedReader bufferedReader) {
        return fastParser.zac(bufferedReader);
    }

    public static /* synthetic */ BigInteger zaf(FastParser fastParser, BufferedReader bufferedReader) {
        return fastParser.zaf(bufferedReader);
    }

    private final BigInteger zaf(BufferedReader bufferedReader) {
        Object object = this.zaqd;
        int n10 = this.zaa(bufferedReader, (char[])object);
        if (n10 == 0) {
            return null;
        }
        object = new BigInteger;
        char[] cArray = this.zaqd;
        String string2 = new String(cArray, 0, n10);
        object(string2);
        return object;
    }

    private final float zag(BufferedReader bufferedReader) {
        Object object = this.zaqd;
        int n10 = this.zaa(bufferedReader, (char[])object);
        if (n10 == 0) {
            return 0.0f;
        }
        object = new String;
        char[] cArray = this.zaqd;
        object(cArray, 0, n10);
        return Float.parseFloat((String)object);
    }

    public static /* synthetic */ BigDecimal zag(FastParser fastParser, BufferedReader bufferedReader) {
        return fastParser.zai(bufferedReader);
    }

    private final double zah(BufferedReader bufferedReader) {
        Object object = this.zaqd;
        int n10 = this.zaa(bufferedReader, (char[])object);
        if (n10 == 0) {
            return 0.0;
        }
        object = new String;
        char[] cArray = this.zaqd;
        object(cArray, 0, n10);
        return Double.parseDouble((String)object);
    }

    private final BigDecimal zai(BufferedReader bufferedReader) {
        Object object = this.zaqd;
        int n10 = this.zaa(bufferedReader, (char[])object);
        if (n10 == 0) {
            return null;
        }
        object = new BigDecimal;
        char[] cArray = this.zaqd;
        String string2 = new String(cArray, 0, n10);
        object(string2);
        return object;
    }

    private final char zaj(BufferedReader bufferedReader) {
        int n10;
        char[] cArray = this.zaqb;
        int n11 = bufferedReader.read(cArray);
        if (n11 == (n10 = -1)) {
            return '\u0000';
        }
        while ((n11 = (int)(Character.isWhitespace((cArray = this.zaqb)[0]) ? 1 : 0)) != 0) {
            cArray = this.zaqb;
            n11 = bufferedReader.read(cArray);
            if (n11 != n10) continue;
            return '\u0000';
        }
        return this.zaqb[0];
    }

    private final void zak(int n10) {
        Serializable serializable = this.zaqm;
        boolean n11 = ((Vector)serializable).isEmpty();
        String string2 = "Expected state ";
        int n12 = 46;
        if (!n11) {
            serializable = (Integer)this.zaqm.pop();
            int n13 = (Integer)serializable;
            if (n13 == n10) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder(n12);
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append(" but had ");
            stringBuilder.append(n13);
            String string4 = stringBuilder.toString();
            FastParser$ParseException stringBuilder2 = new FastParser$ParseException(string4);
            throw stringBuilder2;
        }
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append(" but had empty stack");
        String string3 = stringBuilder.toString();
        serializable = new FastParser$ParseException(string3);
        throw serializable;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void parse(InputStream var1_1, FastJsonResponse var2_4) {
        var3_5 = "Failed to close reader while parsing.";
        var4_6 = "FastParser";
        var6_8 = new InputStreamReader((InputStream)var1_1);
        var7_9 = '\u0400';
        var5_7 = new BufferedReader((Reader)var6_8, var7_9);
        try {
            block11: {
                block10: {
                    var1_1 = this.zaqm;
                    var8_10 = 0;
                    var6_8 = null;
                    var9_11 /* !! */  = 0;
                    var1_1.push(var9_11 /* !! */ );
                    var7_9 = this.zaj(var5_7);
                    if (var7_9 == '\u0000') ** GOTO lbl71
                    var10_12 = 91;
                    var11_13 = 1;
                    if (var7_9 == var10_12) break block10;
                    var10_12 = 123;
                    if (var7_9 != var10_12) {
                        var8_10 = 19;
                        var9_11 /* !! */  = new StringBuilder(var8_10);
                        var6_8 = "Unexpected token: ";
                        var9_11 /* !! */ .append((String)var6_8);
                        var9_11 /* !! */ .append(var7_9);
                        var1_1 = var9_11 /* !! */ .toString();
                        var2_4 = new FastParser$ParseException((String)var1_1);
                        throw var2_4;
                    }
                    var1_1 = this.zaqm;
                    var9_11 /* !! */  = var11_13;
                    var1_1.push(var9_11 /* !! */ );
                    this.zaa(var5_7, (FastJsonResponse)var2_4);
                    break block11;
                }
                var1_1 = this.zaqm;
                var10_12 = 5;
                var9_11 /* !! */  = var10_12;
                var1_1.push(var9_11 /* !! */ );
                var1_1 = var2_4.getFieldMappings();
                var10_12 = var1_1.size();
                if (var10_12 != var11_13) ** GOTO lbl-1000
                var1_1 = var1_1.entrySet();
                var1_1 = var1_1.iterator();
                var1_1 = var1_1.next();
                var1_1 = (Map.Entry)var1_1;
                var1_1 = var1_1.getValue();
                var1_1 = (FastJsonResponse$Field)var1_1;
                var9_11 /* !! */  = this.zaa(var5_7, (FastJsonResponse$Field)var1_1);
                var12_14 = var1_1.zapv;
                var2_4.addConcreteTypeArrayInternal((FastJsonResponse$Field)var1_1, var12_14, (ArrayList)var9_11 /* !! */ );
            }
            this.zak(0);
            ** GOTO lbl61
        }
        catch (IOException var1_3) {
            var2_4 = new FastParser$ParseException(var1_3);
            throw var2_4;
lbl61:
            // 1 sources

            try {
                var5_7.close();
                return;
            }
            catch (IOException v0) {
                Log.w((String)var4_6, (String)var3_5);
                return;
            }
lbl-1000:
            // 1 sources

            {
                var2_4 = "Object array response class must have a single Field";
                var1_1 = new FastParser$ParseException((String)var2_4);
                throw var1_1;
lbl71:
                // 1 sources

                var2_4 = "No data to parse";
                var1_1 = new FastParser$ParseException((String)var2_4);
                throw var1_1;
            }
            catch (Throwable var1_2) {}
        }
        try {
            var5_7.close();
            throw var1_2;
        }
        catch (IOException v1) {
            Log.w((String)var4_6, (String)var3_5);
        }
        throw var1_2;
    }
}

