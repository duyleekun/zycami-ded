/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package androidx.camera.core.impl.utils;

import android.util.Pair;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifData$1;
import androidx.camera.core.impl.utils.ExifData$Builder$1;
import androidx.camera.core.impl.utils.ExifData$Builder$2;
import androidx.camera.core.impl.utils.ExifData$Builder$3;
import androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode;
import androidx.camera.core.impl.utils.ExifTag;
import androidx.camera.core.impl.utils.LongRational;
import androidx.core.util.Preconditions;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class ExifData$Builder {
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final Pattern GPS_TIMESTAMP_PATTERN;
    public static final List sExifTagMapsForWriting;
    public final List mAttributes;
    private final ByteOrder mByteOrder;

    static {
        GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        ExifData$Builder$1 exifData$Builder$1 = new ExifData$Builder$1();
        sExifTagMapsForWriting = Collections.list(exifData$Builder$1);
    }

    public ExifData$Builder(ByteOrder byteOrder) {
        Object object = new ExifData$Builder$2(this);
        this.mAttributes = object = Collections.list(object);
        this.mByteOrder = byteOrder;
    }

    private static Pair guessDataFormat(String pair) {
        long l10;
        int n10;
        long l11;
        int n11;
        Object object = ",";
        int n12 = pair.contains((CharSequence)object);
        int n13 = 0;
        Integer n14 = null;
        int n15 = 2;
        Integer n16 = n15;
        int n17 = -1;
        Integer n18 = n17;
        if (n12 != 0) {
            pair = pair.split((String)object, n17);
            object = ExifData$Builder.guessDataFormat(pair[0]);
            Integer n19 = (Integer)((Pair)object).first;
            n12 = n19;
            if (n12 == n15) {
                return object;
            }
            for (n11 = 1; n11 < (n12 = ((Pair)pair).length); ++n11) {
                Object object2;
                n19 = ExifData$Builder.guessDataFormat((String)pair[n11]);
                n14 = (Integer)((Pair)n19).first;
                Object object3 = ((Pair)object).first;
                n13 = n14.equals(object3) ? 1 : 0;
                if (n13 == 0 && (n13 = (int)((n14 = (Integer)((Pair)n19).second).equals(object3 = ((Pair)object).first) ? 1 : 0)) == 0) {
                    n13 = n17;
                } else {
                    n14 = (Integer)((Pair)object).first;
                    n13 = n14;
                }
                object3 = (Integer)((Pair)object).second;
                n15 = (Integer)object3;
                if (n15 != n17 && ((n15 = (int)(((Integer)(object3 = (Integer)((Pair)n19).first)).equals(object2 = ((Pair)object).second) ? 1 : 0)) != 0 || (n12 = (int)((n19 = (Integer)((Pair)n19).second).equals(object3 = ((Pair)object).second) ? 1 : 0)) != 0)) {
                    n19 = (Integer)((Pair)object).second;
                    n12 = n19;
                } else {
                    n12 = n17;
                }
                if (n13 == n17 && n12 == n17) {
                    pair = new Pair((Object)n16, (Object)n18);
                    return pair;
                }
                if (n13 == n17) {
                    n19 = n12;
                    object = new Pair((Object)n19, (Object)n18);
                    continue;
                }
                if (n12 != n17) continue;
                n19 = n13;
                object = new Pair((Object)n19, (Object)n18);
            }
            return object;
        }
        object = "/";
        n12 = pair.contains((CharSequence)object);
        long l12 = 0L;
        if (n12 != 0) {
            int n20 = ((String[])(pair = pair.split((String)object, n17))).length;
            if (n20 == n15) {
                try {
                    object = pair[0];
                }
                catch (NumberFormatException numberFormatException) {}
                double d10 = Double.parseDouble((String)object);
                long l13 = (long)d10;
                pair = pair[n11];
                double d11 = Double.parseDouble((String)pair);
                long l14 = (long)d11;
                long l15 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
                n15 = 10;
                if (l15 >= 0 && (l15 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1)) >= 0) {
                    l12 = Integer.MAX_VALUE;
                    l15 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
                    n20 = 5;
                    if (l15 <= 0 && (l15 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1)) <= 0) {
                        Integer n21 = n15;
                        object = n20;
                        pair = new Pair((Object)n21, object);
                        return pair;
                    }
                    object = n20;
                    pair = new Pair(object, (Object)n18);
                    return pair;
                }
                object = n15;
                pair = new Pair(object, (Object)n18);
                return pair;
            }
            pair = new Pair((Object)n16, (Object)n18);
            return pair;
        }
        try {
            l11 = Long.parseLong((String)pair);
            n13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            n11 = 4;
        }
        catch (NumberFormatException numberFormatException) {
            try {
                Double.parseDouble((String)pair);
                n10 = 12;
            }
            catch (NumberFormatException numberFormatException2) {
                pair = new Pair((Object)n16, (Object)n18);
                return pair;
            }
            object = n10;
            pair = new Pair(object, (Object)n18);
            return pair;
        }
        if (n13 >= 0 && (n10 = (int)((l10 = l11 - (l12 = (long)((char)-1))) == 0L ? 0 : (l10 < 0L ? -1 : 1))) <= 0) {
            n12 = 3;
            Integer n22 = n12;
            n14 = n11;
            object = new Pair((Object)n22, (Object)n14);
            return object;
        }
        if (n13 < 0) {
            n12 = 9;
            Integer n23 = n12;
            object = new Pair((Object)n23, (Object)n18);
            return object;
        }
        Integer n24 = n11;
        object = new Pair((Object)n24, (Object)n18);
        return object;
    }

    private void setAttributeIfMissing(String string2, String string3, List list) {
        boolean bl2;
        Iterator iterator2 = list.iterator();
        while (bl2 = iterator2.hasNext()) {
            Map map = (Map)iterator2.next();
            bl2 = map.containsKey(string2);
            if (!bl2) continue;
            return;
        }
        this.setAttributeInternal(string2, string3, list);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void setAttributeInternal(String var1_1, String var2_2, List var3_3) {
        var4_4 = this;
        var5_5 = var1_1;
        var6_7 = var2_2;
        var7_8 = var3_3;
        var8_9 = "DateTime";
        var9_10 = var8_9.equals(var1_1);
        var10_11 = " : ";
        var11_12 = "Invalid value for ";
        var12_13 /* !! */  = "ExifData";
        if ((var9_10 || (var9_10 = (var8_9 = "DateTimeOriginal").equals(var1_1)) || (var9_10 = (var8_9 = "DateTimeDigitized").equals(var1_1))) && var6_7 != null) {
            var8_9 = ExifData$Builder.DATETIME_PRIMARY_FORMAT_PATTERN.matcher(var6_7);
            var9_10 = var8_9.find();
            var13_14 = ExifData$Builder.DATETIME_SECONDARY_FORMAT_PATTERN.matcher(var6_7);
            var14_15 = var13_14.find();
            var15_16 = var2_2.length();
            if (var15_16 == (var16_17 = 19) && (var9_10 || var14_15 != 0)) {
                if (var14_15 != 0) {
                    var8_9 = "-";
                    var13_14 = ":";
                    var6_7 = var6_7.replaceAll((String)var8_9, (String)var13_14);
                }
            } else {
                var7_8 = new StringBuilder();
                var7_8.append((String)var11_12);
                var7_8.append((String)var5_5);
                var7_8.append(var10_11);
                var7_8.append((String)var6_7);
                var5_5 = var7_8.toString();
                Logger.w((String)var12_13 /* !! */ , (String)var5_5);
                return;
            }
        }
        if (var9_10 = (var8_9 = "ISOSpeedRatings").equals(var5_5)) {
            var5_5 = "PhotographicSensitivity";
        }
        var8_9 = var5_5;
        var17_18 = 2;
        var14_15 = 1;
        var18_19 = 1.4E-45f;
        if (var6_7 != null && (var15_16 = (int)(var19_20 /* !! */  = ExifData.sTagSetForCompatibility).contains(var5_5)) != 0) {
            var19_20 /* !! */  = "GPSTimeStamp";
            var15_16 = (int)var5_5.equals(var19_20 /* !! */ );
            if (var15_16 != 0) {
                var19_20 /* !! */  = ExifData$Builder.GPS_TIMESTAMP_PATTERN.matcher(var6_7);
                var16_17 = (int)var19_20 /* !! */ .find();
                if (var16_17 == 0) {
                    var5_5 = new StringBuilder();
                    var5_5.append((String)var11_12);
                    var5_5.append((String)var8_9);
                    var5_5.append(var10_11);
                    var5_5.append((String)var6_7);
                    var5_5 = var5_5.toString();
                    Logger.w((String)var12_13 /* !! */ , (String)var5_5);
                    return;
                }
                var6_7 = new StringBuilder();
                var20_21 = Integer.parseInt((String)Preconditions.checkNotNull(var19_20 /* !! */ .group(var14_15)));
                var6_7.append(var20_21);
                var10_11 = "/1,";
                var6_7.append(var10_11);
                var11_12 = (String)Preconditions.checkNotNull(var19_20 /* !! */ .group(var17_18));
                var21_22 = Integer.parseInt((String)var11_12);
                var6_7.append(var21_22);
                var6_7.append(var10_11);
                var20_21 = Integer.parseInt((String)Preconditions.checkNotNull(var19_20 /* !! */ .group(3)));
                var6_7.append(var20_21);
                var10_11 = "/1";
                var6_7.append(var10_11);
                var6_7 = var6_7.toString();
            } else {
                try {
                    var22_23 = Double.parseDouble((String)var6_7);
                }
                catch (NumberFormatException var5_6) {
                    var7_8 = new StringBuilder();
                    var7_8.append((String)var11_12);
                    var7_8.append((String)var8_9);
                    var7_8.append(var10_11);
                    var7_8.append((String)var6_7);
                    var6_7 = var7_8.toString();
                    Logger.w((String)var12_13 /* !! */ , (String)var6_7, var5_6);
                    return;
                }
                var24_24 /* !! */  = new LongRational(var22_23);
                var6_7 = var24_24 /* !! */ .toString();
            }
        }
        var20_21 = 0;
        var10_11 = null;
        var21_22 = 0;
        var11_12 = null;
        while (var21_22 < (var25_25 = (var12_13 /* !! */  = ExifData.EXIF_TAGS).length)) {
            block35: {
                block30: {
                    block34: {
                        block32: {
                            block33: {
                                block31: {
                                    var12_13 /* !! */  = (ExifTag)((HashMap)ExifData$Builder.sExifTagMapsForWriting.get(var21_22)).get(var8_9);
                                    if (var12_13 /* !! */  == null) break block30;
                                    if (var6_7 != null) break block31;
                                    var12_13 /* !! */  = (Map)var7_8.get(var21_22);
                                    var12_13 /* !! */ .remove(var8_9);
                                    break block30;
                                }
                                var19_20 /* !! */  = ExifData$Builder.guessDataFormat((String)var6_7);
                                var16_17 = var12_13 /* !! */ .primaryFormat;
                                var24_24 /* !! */  = (Integer)var19_20 /* !! */ .first;
                                var26_26 = var24_24 /* !! */ .intValue();
                                var27_27 = -1;
                                if (var16_17 == var26_26 || (var16_17 = var12_13 /* !! */ .primaryFormat) == (var26_26 = (var24_24 /* !! */  = (Integer)var19_20 /* !! */ .second).intValue())) break block32;
                                var16_17 = var12_13 /* !! */ .secondaryFormat;
                                if (var16_17 == var27_27 || var16_17 != (var26_26 = (var24_24 /* !! */  = (Integer)var19_20 /* !! */ .first).intValue()) && (var16_17 = var12_13 /* !! */ .secondaryFormat) != (var15_16 = (var19_20 /* !! */  = (Integer)var19_20 /* !! */ .second).intValue())) break block33;
                                var25_25 = var12_13 /* !! */ .secondaryFormat;
                                break block34;
                            }
                            var25_25 = var12_13 /* !! */ .primaryFormat;
                            if (var25_25 != var14_15 && var25_25 != (var15_16 = 7) && var25_25 != var17_18) break block30;
                            break block34;
                        }
                        var25_25 = var12_13 /* !! */ .primaryFormat;
                    }
                    var19_20 /* !! */  = "/";
                    var28_28 = ",";
                    switch (var25_25) {
                        default: {
                            break block30;
                        }
                        case 12: {
                            var12_13 /* !! */  = var6_7.split((String)var28_28, var27_27);
                            var15_16 = var12_13 /* !! */ .length;
                            var19_20 /* !! */  = (String[])new double[var15_16];
                            var28_28 = null;
                            for (var16_17 = 0; var16_17 < (var26_26 = var12_13 /* !! */ .length); ++var16_17) {
                                var24_24 /* !! */  = var12_13 /* !! */ [var16_17];
                                var29_29 = Double.parseDouble((String)var24_24 /* !! */ );
                                var19_20 /* !! */ [var16_17] = var29_29;
                            }
                            var12_13 /* !! */  = (Map)var7_8.get(var21_22);
                            var28_28 = var4_4.mByteOrder;
                            var19_20 /* !! */  = ExifAttribute.createDouble((double[])var19_20 /* !! */ , (ByteOrder)var28_28);
                            var12_13 /* !! */ .put(var8_9, var19_20 /* !! */ );
                            break block30;
                        }
                        case 10: {
                            var12_13 /* !! */  = var6_7.split((String)var28_28, var27_27);
                            var16_17 = var12_13 /* !! */ .length;
                            var28_28 = new LongRational[var16_17];
                            var24_24 /* !! */  = null;
                            for (var26_26 = 0; var26_26 < (var31_30 = var12_13 /* !! */ .length); ++var26_26) {
                                var32_31 /* !! */  = var12_13 /* !! */ [var26_26].split((String)var19_20 /* !! */ , var27_27);
                                var34_33 = Double.parseDouble(var32_31 /* !! */ [0]);
                                var36_34 = (long)var34_33;
                                var32_31 /* !! */  = var32_31 /* !! */ [var14_15];
                                var38_35 = var19_20 /* !! */ ;
                                var39_36 = Double.parseDouble((String)var32_31 /* !! */ );
                                var41_37 = (long)var39_36;
                                var28_28[var26_26] = var33_32 = new LongRational(var36_34, var41_37);
                                var17_18 = 2;
                                var14_15 = 1;
                                var18_19 = 1.4E-45f;
                                var4_4 = this;
                            }
                            var5_5 = (Map)var7_8.get(var21_22);
                            var4_4 = this;
                            var12_13 /* !! */  = this.mByteOrder;
                            var12_13 /* !! */  = ExifAttribute.createSRational(var28_28, (ByteOrder)var12_13 /* !! */ );
                            var5_5.put(var8_9, var12_13 /* !! */ );
                            ** GOTO lbl192
                        }
                        case 9: {
                            var5_5 = var6_7.split((String)var28_28, var27_27);
                            var25_25 = ((CharSequence)var5_5).length;
                            var12_13 /* !! */  = (ExifTag[][])new int[var25_25];
                            var13_14 = null;
                            var18_19 = 0.0f;
                            for (var14_15 = 0; var14_15 < (var15_16 = ((Object)var5_5).length); ++var14_15) {
                                var19_20 /* !! */  = var5_5[var14_15];
                                var15_16 = Integer.parseInt((String)var19_20 /* !! */ );
                                var12_13 /* !! */ [var14_15] = (ExifTag[])var15_16;
                            }
                            var5_5 = (Map)var7_8.get(var21_22);
                            var13_14 = var4_4.mByteOrder;
                            var12_13 /* !! */  = ExifAttribute.createSLong((int[])var12_13 /* !! */ , (ByteOrder)var13_14);
                            var5_5.put(var8_9, var12_13 /* !! */ );
lbl192:
                            // 2 sources

                            var20_21 = var21_22;
                            var43_38 = 1;
                            var44_39 = 1.4E-45f;
                            break block35;
                        }
                        case 5: {
                            var38_35 = var19_20 /* !! */ ;
                            var5_5 = var6_7.split((String)var28_28, var27_27);
                            var25_25 = ((CharSequence)var5_5).length;
                            var12_13 /* !! */  = new LongRational[var25_25];
                            var13_14 = null;
                            var18_19 = 0.0f;
                            for (var14_15 = 0; var14_15 < (var15_16 = ((Object)var5_5).length); ++var14_15) {
                                var19_20 /* !! */  = var5_5[var14_15];
                                var28_28 = var38_35;
                                var19_20 /* !! */  = var19_20 /* !! */ .split((String)var38_35, var27_27);
                                var32_31 /* !! */  = var19_20 /* !! */ [0];
                                var45_40 = Double.parseDouble((String)var32_31 /* !! */ );
                                var47_41 = (long)var45_40;
                                var43_38 = 1;
                                var44_39 = 1.4E-45f;
                                var19_20 /* !! */  = var19_20 /* !! */ [var43_38];
                                var49_42 = Double.parseDouble((String)var19_20 /* !! */ );
                                var51_43 = (long)var49_42;
                                var24_24 /* !! */  = new LongRational(var47_41, var51_43);
                                var12_13 /* !! */ [var14_15] = var24_24 /* !! */ ;
                                var20_21 = 0;
                                var10_11 = null;
                            }
                            var20_21 = var21_22;
                            var43_38 = 1;
                            var44_39 = 1.4E-45f;
                            var5_5 = (Map)var7_8.get(var21_22);
                            var11_12 = var4_4.mByteOrder;
                            var11_12 = ExifAttribute.createURational((LongRational[])var12_13 /* !! */ , (ByteOrder)var11_12);
                            var5_5.put(var8_9, var11_12);
                            break block35;
                        }
                        case 4: {
                            var20_21 = var21_22;
                            var43_38 = var14_15;
                            var44_39 = var18_19;
                            var5_5 = var6_7.split((String)var28_28, var27_27);
                            var21_22 = ((Object)var5_5).length;
                            var11_12 = new long[var21_22];
                            var12_13 /* !! */  = null;
                            for (var25_25 = 0; var25_25 < (var14_15 = ((Object)var5_5).length); ++var25_25) {
                                var13_14 = var5_5[var25_25];
                                var41_37 = Long.parseLong((String)var13_14);
                                var11_12[var25_25] = var41_37;
                            }
                            var5_5 = (Map)var7_8.get(var20_21);
                            var12_13 /* !! */  = var4_4.mByteOrder;
                            var11_12 = ExifAttribute.createULong((long[])var11_12, (ByteOrder)var12_13 /* !! */ );
                            var5_5.put(var8_9, var11_12);
                            break block35;
                        }
                        case 3: {
                            var20_21 = var21_22;
                            var43_38 = var14_15;
                            var44_39 = var18_19;
                            var5_5 = var6_7.split((String)var28_28, var27_27);
                            var21_22 = ((Object)var5_5).length;
                            var11_12 = new int[var21_22];
                            var12_13 /* !! */  = null;
                            for (var25_25 = 0; var25_25 < (var14_15 = ((Object)var5_5).length); ++var25_25) {
                                var13_14 = var5_5[var25_25];
                                var14_15 = Integer.parseInt((String)var13_14);
                                var11_12[var25_25] = var14_15;
                            }
                            var5_5 = (Map)var7_8.get(var20_21);
                            var12_13 /* !! */  = var4_4.mByteOrder;
                            var11_12 = ExifAttribute.createUShort((int[])var11_12, (ByteOrder)var12_13 /* !! */ );
                            var5_5.put(var8_9, var11_12);
                            break block35;
                        }
                        case 2: 
                        case 7: {
                            var20_21 = var21_22;
                            var43_38 = var14_15;
                            var44_39 = var18_19;
                            var5_5 = (Map)var7_8.get(var21_22);
                            var11_12 = ExifAttribute.createString((String)var6_7);
                            var5_5.put(var8_9, var11_12);
                            break block35;
                        }
                        case 1: 
                    }
                    var20_21 = var21_22;
                    var43_38 = var14_15;
                    var44_39 = var18_19;
                    var5_5 = (Map)var7_8.get(var21_22);
                    var11_12 = ExifAttribute.createByte((String)var6_7);
                    var5_5.put(var8_9, var11_12);
                    break block35;
                }
                var20_21 = var21_22;
                var43_38 = var14_15;
                var44_39 = var18_19;
            }
            var21_22 = var20_21 + 1;
            var14_15 = var43_38;
            var18_19 = var44_39;
            var17_18 = 2;
            var20_21 = 0;
            var10_11 = null;
        }
    }

    public ExifData build() {
        Object object;
        Object object2 = new ExifData$Builder$3(this);
        object2 = Collections.list(object2);
        int n10 = 1;
        Object object3 = (Map)object2.get(n10);
        boolean bl2 = object3.isEmpty();
        int n11 = 2;
        if (!bl2) {
            bl2 = false;
            String string2 = String.valueOf(0);
            this.setAttributeIfMissing("ExposureProgram", string2, (List)object2);
            this.setAttributeIfMissing("ExifVersion", "0230", (List)object2);
            this.setAttributeIfMissing("ComponentsConfiguration", "1,2,3,0", (List)object2);
            string2 = String.valueOf(0);
            this.setAttributeIfMissing("MeteringMode", string2, (List)object2);
            string2 = String.valueOf(0);
            this.setAttributeIfMissing("LightSource", string2, (List)object2);
            this.setAttributeIfMissing("FlashpixVersion", "0100", (List)object2);
            string2 = String.valueOf(n11);
            this.setAttributeIfMissing("FocalPlaneResolutionUnit", string2, (List)object2);
            int n12 = 3;
            string2 = String.valueOf(n12);
            String string3 = "FileSource";
            this.setAttributeIfMissing(string3, string2, (List)object2);
            object = String.valueOf(n10);
            this.setAttributeIfMissing("SceneType", (String)object, (List)object2);
            object = String.valueOf(0);
            this.setAttributeIfMissing("CustomRendered", (String)object, (List)object2);
            object = String.valueOf(0);
            this.setAttributeIfMissing("SceneCaptureType", (String)object, (List)object2);
            object = String.valueOf(0);
            this.setAttributeIfMissing("Contrast", (String)object, (List)object2);
            object = String.valueOf(0);
            string2 = "Saturation";
            this.setAttributeIfMissing(string2, (String)object, (List)object2);
            object = String.valueOf(0);
            object3 = "Sharpness";
            this.setAttributeIfMissing((String)object3, (String)object, (List)object2);
        }
        if ((n10 = (int)((object = (Map)object2.get(n11)).isEmpty() ? 1 : 0)) == 0) {
            this.setAttributeIfMissing("GPSVersionID", "2300", (List)object2);
            object3 = "K";
            this.setAttributeIfMissing("GPSSpeedRef", (String)object3, (List)object2);
            String string4 = "T";
            this.setAttributeIfMissing("GPSTrackRef", string4, (List)object2);
            this.setAttributeIfMissing("GPSImgDirectionRef", string4, (List)object2);
            this.setAttributeIfMissing("GPSDestBearingRef", string4, (List)object2);
            object = "GPSDestDistanceRef";
            this.setAttributeIfMissing((String)object, (String)object3, (List)object2);
        }
        object3 = this.mByteOrder;
        object = new ExifData((ByteOrder)object3, (List)object2);
        return object;
    }

    public ExifData$Builder removeAttribute(String string2) {
        List list = this.mAttributes;
        this.setAttributeInternal(string2, null, list);
        return this;
    }

    public ExifData$Builder setAttribute(String string2, String string3) {
        List list = this.mAttributes;
        this.setAttributeInternal(string2, string3, list);
        return this;
    }

    public ExifData$Builder setExposureTimeNanos(long l10) {
        double d10 = l10;
        double d11 = TimeUnit.SECONDS.toNanos(1L);
        String string2 = String.valueOf(d10 / d11);
        return this.setAttribute("ExposureTime", string2);
    }

    public ExifData$Builder setFlashState(CameraCaptureMetaData$FlashState object) {
        int n10;
        Object object2 = CameraCaptureMetaData$FlashState.UNKNOWN;
        if (object == object2) {
            return this;
        }
        object2 = ExifData$1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;
        int n11 = object.ordinal();
        Object object3 = object2[n11];
        if (object3 != (n11 = 1)) {
            int n12 = 2;
            if (object3 != n12) {
                n12 = 3;
                if (object3 != n12) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Unknown flash state: ");
                    ((StringBuilder)object2).append(object);
                    object = ((StringBuilder)object2).toString();
                    Logger.w("ExifData", (String)object);
                    return this;
                }
                n10 = n11;
            } else {
                n10 = 32;
            }
        } else {
            n10 = 0;
            object = null;
        }
        object3 = n10 & 1;
        if (object3 == n11) {
            object3 = 4;
            object2 = String.valueOf((int)object3);
            String string2 = "LightSource";
            this.setAttribute(string2, (String)object2);
        }
        object = String.valueOf(n10);
        return this.setAttribute("Flash", (String)object);
    }

    public ExifData$Builder setFocalLength(float f10) {
        long l10 = (long)(f10 * 1000.0f);
        LongRational longRational = new LongRational(l10, 1000L);
        String string2 = longRational.toString();
        return this.setAttribute("FocalLength", string2);
    }

    public ExifData$Builder setImageHeight(int n10) {
        String string2 = String.valueOf(n10);
        return this.setAttribute("ImageLength", string2);
    }

    public ExifData$Builder setImageWidth(int n10) {
        String string2 = String.valueOf(n10);
        return this.setAttribute("ImageWidth", string2);
    }

    public ExifData$Builder setIso(int n10) {
        Object object = String.valueOf(3);
        object = this.setAttribute("SensitivityType", (String)object);
        String string2 = String.valueOf(Math.min((char)-1, n10));
        return ((ExifData$Builder)object).setAttribute("PhotographicSensitivity", string2);
    }

    public ExifData$Builder setLensFNumber(float f10) {
        String string2 = String.valueOf(f10);
        return this.setAttribute("FNumber", string2);
    }

    public ExifData$Builder setOrientationDegrees(int n10) {
        String string2;
        if (n10 != 0) {
            int n11 = 90;
            if (n10 != n11) {
                n11 = 180;
                if (n10 != n11) {
                    n11 = 270;
                    if (n10 != n11) {
                        CharSequence charSequence = new StringBuilder();
                        String string3 = "Unexpected orientation value: ";
                        charSequence.append(string3);
                        charSequence.append(n10);
                        charSequence.append(". Must be one of 0, 90, 180, 270.");
                        string2 = charSequence.toString();
                        charSequence = "ExifData";
                        Logger.w((String)charSequence, string2);
                        n10 = 0;
                        string2 = null;
                    } else {
                        n10 = 8;
                    }
                } else {
                    n10 = 3;
                }
            } else {
                n10 = 6;
            }
        } else {
            n10 = 1;
        }
        string2 = String.valueOf(n10);
        return this.setAttribute("Orientation", string2);
    }

    public ExifData$Builder setWhiteBalanceMode(ExifData$WhiteBalanceMode object) {
        int[] nArray = ExifData$1.$SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n10 = 0;
                object = null;
            } else {
                object = String.valueOf(n11);
            }
        } else {
            n10 = 0;
            object = String.valueOf(0);
        }
        return this.setAttribute("WhiteBalance", (String)object);
    }
}

