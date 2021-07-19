/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ByteOrderedDataInputStream;
import androidx.camera.core.impl.utils.LongRational;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class ExifAttribute {
    public static final Charset ASCII;
    public static final long BYTES_OFFSET_UNKNOWN = 255L;
    public static final byte[] EXIF_ASCII_PREFIX;
    public static final int IFD_FORMAT_BYTE = 1;
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
    public static final int IFD_FORMAT_DOUBLE = 12;
    public static final String[] IFD_FORMAT_NAMES;
    public static final int IFD_FORMAT_SBYTE = 6;
    public static final int IFD_FORMAT_SINGLE = 11;
    public static final int IFD_FORMAT_SLONG = 9;
    public static final int IFD_FORMAT_SRATIONAL = 10;
    public static final int IFD_FORMAT_SSHORT = 8;
    public static final int IFD_FORMAT_STRING = 2;
    public static final int IFD_FORMAT_ULONG = 4;
    public static final int IFD_FORMAT_UNDEFINED = 7;
    public static final int IFD_FORMAT_URATIONAL = 5;
    public static final int IFD_FORMAT_USHORT = 3;
    private static final String TAG = "ExifAttribute";
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    static {
        Object[] objectArray;
        ASCII = StandardCharsets.US_ASCII;
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        int[] nArray = objectArray = new int[14];
        int[] nArray2 = objectArray;
        nArray[0] = 0;
        nArray2[1] = 1;
        nArray[2] = 1;
        nArray2[3] = 2;
        nArray[4] = 4;
        nArray2[5] = 8;
        nArray[6] = 1;
        nArray2[7] = 1;
        nArray[8] = 2;
        nArray2[9] = 4;
        nArray[10] = 8;
        nArray2[11] = 4;
        nArray[12] = 8;
        nArray2[13] = 1;
        IFD_FORMAT_BYTES_PER_FORMAT = objectArray;
        Object[] objectArray2 = objectArray = (Object[])new byte[8];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = 65;
        objectArray3[1] = 83;
        objectArray2[2] = 67;
        objectArray3[3] = 73;
        objectArray2[4] = 73;
        objectArray3[5] = 0;
        objectArray2[6] = 0;
        objectArray3[7] = 0;
        EXIF_ASCII_PREFIX = (byte[])objectArray;
    }

    public ExifAttribute(int n10, int n11, long l10, byte[] byArray) {
        this.format = n10;
        this.numberOfComponents = n11;
        this.bytesOffset = l10;
        this.bytes = byArray;
    }

    public ExifAttribute(int n10, int n11, byte[] byArray) {
        this(n10, n11, -1, byArray);
    }

    public static ExifAttribute createByte(String object) {
        int n10;
        Object object2;
        int n11;
        int n12 = ((String)object).length();
        if (n12 == (n11 = 1)) {
            int n13;
            int n14;
            n12 = 0;
            object2 = null;
            n10 = ((String)object).charAt(0);
            if (n10 >= (n14 = 48) && (n10 = (int)((String)object).charAt(0)) <= (n13 = 49)) {
                byte by2;
                byte[] byArray = new byte[n11];
                byArray[0] = by2 = (byte)(((String)object).charAt(0) - n14);
                object = new ExifAttribute(n11, n11, byArray);
                return object;
            }
        }
        object2 = ASCII;
        object = ((String)object).getBytes((Charset)object2);
        n10 = ((Object)object).length;
        object2 = new ExifAttribute(n11, n10, (byte[])object);
        return object2;
    }

    public static ExifAttribute createDouble(double d10, ByteOrder byteOrder) {
        double[] dArray = new double[]{d10};
        return ExifAttribute.createDouble(dArray, byteOrder);
    }

    public static ExifAttribute createDouble(double[] dArray, ByteOrder object) {
        Object object2 = IFD_FORMAT_BYTES_PER_FORMAT;
        int n10 = 12;
        int n11 = object2[n10];
        int n12 = dArray.length;
        object2 = ByteBuffer.wrap(new byte[n11 *= n12]);
        object2.order((ByteOrder)object);
        int n13 = dArray.length;
        for (n12 = 0; n12 < n13; ++n12) {
            double d10 = dArray[n12];
            object2.putDouble(d10);
        }
        int n14 = dArray.length;
        object2 = object2.array();
        object = new ExifAttribute(n10, n14, (byte[])object2);
        return object;
    }

    public static ExifAttribute createSLong(int n10, ByteOrder byteOrder) {
        int[] nArray = new int[]{n10};
        return ExifAttribute.createSLong(nArray, byteOrder);
    }

    public static ExifAttribute createSLong(int[] nArray, ByteOrder object) {
        Object object2 = IFD_FORMAT_BYTES_PER_FORMAT;
        int n10 = 9;
        int n11 = object2[n10];
        int n12 = nArray.length;
        object2 = ByteBuffer.wrap(new byte[n11 *= n12]);
        object2.order((ByteOrder)object);
        int n13 = nArray.length;
        for (n12 = 0; n12 < n13; ++n12) {
            int n14 = nArray[n12];
            object2.putInt(n14);
        }
        int n15 = nArray.length;
        object2 = object2.array();
        object = new ExifAttribute(n10, n15, (byte[])object2);
        return object;
    }

    public static ExifAttribute createSRational(LongRational longRational, ByteOrder byteOrder) {
        LongRational[] longRationalArray = new LongRational[]{longRational};
        return ExifAttribute.createSRational(longRationalArray, byteOrder);
    }

    public static ExifAttribute createSRational(LongRational[] longRationalArray, ByteOrder object) {
        Object object2 = IFD_FORMAT_BYTES_PER_FORMAT;
        int n10 = 10;
        int n11 = object2[n10];
        int n12 = longRationalArray.length;
        object2 = ByteBuffer.wrap(new byte[n11 *= n12]);
        ((ByteBuffer)object2).order((ByteOrder)object);
        int n13 = longRationalArray.length;
        for (n12 = 0; n12 < n13; ++n12) {
            LongRational longRational = longRationalArray[n12];
            long l10 = longRational.getNumerator();
            int n14 = (int)l10;
            ((ByteBuffer)object2).putInt(n14);
            long l11 = longRational.getDenominator();
            int n15 = (int)l11;
            ((ByteBuffer)object2).putInt(n15);
        }
        int n16 = longRationalArray.length;
        object2 = ((ByteBuffer)object2).array();
        object = new ExifAttribute(n10, n16, (byte[])object2);
        return object;
    }

    public static ExifAttribute createString(String object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append('\u0000');
        object = ((StringBuilder)object2).toString();
        object2 = ASCII;
        object = ((String)object).getBytes((Charset)object2);
        int n10 = ((Object)object).length;
        object2 = new ExifAttribute(2, n10, (byte[])object);
        return object2;
    }

    public static ExifAttribute createULong(long l10, ByteOrder byteOrder) {
        long[] lArray = new long[]{l10};
        return ExifAttribute.createULong(lArray, byteOrder);
    }

    public static ExifAttribute createULong(long[] lArray, ByteOrder object) {
        Object object2 = IFD_FORMAT_BYTES_PER_FORMAT;
        int n10 = 4;
        int n11 = object2[n10];
        int n12 = lArray.length;
        object2 = ByteBuffer.wrap(new byte[n11 *= n12]);
        object2.order((ByteOrder)object);
        int n13 = lArray.length;
        for (n12 = 0; n12 < n13; ++n12) {
            long l10 = lArray[n12];
            int n14 = (int)l10;
            object2.putInt(n14);
        }
        int n15 = lArray.length;
        object2 = object2.array();
        object = new ExifAttribute(n10, n15, (byte[])object2);
        return object;
    }

    public static ExifAttribute createURational(LongRational longRational, ByteOrder byteOrder) {
        LongRational[] longRationalArray = new LongRational[]{longRational};
        return ExifAttribute.createURational(longRationalArray, byteOrder);
    }

    public static ExifAttribute createURational(LongRational[] longRationalArray, ByteOrder object) {
        Object object2 = IFD_FORMAT_BYTES_PER_FORMAT;
        int n10 = 5;
        int n11 = object2[n10];
        int n12 = longRationalArray.length;
        object2 = ByteBuffer.wrap(new byte[n11 *= n12]);
        ((ByteBuffer)object2).order((ByteOrder)object);
        int n13 = longRationalArray.length;
        for (n12 = 0; n12 < n13; ++n12) {
            LongRational longRational = longRationalArray[n12];
            long l10 = longRational.getNumerator();
            int n14 = (int)l10;
            ((ByteBuffer)object2).putInt(n14);
            long l11 = longRational.getDenominator();
            int n15 = (int)l11;
            ((ByteBuffer)object2).putInt(n15);
        }
        int n16 = longRationalArray.length;
        object2 = ((ByteBuffer)object2).array();
        object = new ExifAttribute(n10, n16, (byte[])object2);
        return object;
    }

    public static ExifAttribute createUShort(int n10, ByteOrder byteOrder) {
        int[] nArray = new int[]{n10};
        return ExifAttribute.createUShort(nArray, byteOrder);
    }

    public static ExifAttribute createUShort(int[] nArray, ByteOrder object) {
        Object object2 = IFD_FORMAT_BYTES_PER_FORMAT;
        int n10 = 3;
        int n11 = object2[n10];
        int n12 = nArray.length;
        object2 = ByteBuffer.wrap(new byte[n11 *= n12]);
        object2.order((ByteOrder)object);
        int n13 = nArray.length;
        for (n12 = 0; n12 < n13; ++n12) {
            short s10 = (short)nArray[n12];
            object2.putShort(s10);
        }
        int n14 = nArray.length;
        object2 = object2.array();
        object = new ExifAttribute(n10, n14, (byte[])object2);
        return object;
    }

    public double getDoubleValue(ByteOrder object) {
        if ((object = this.getValue((ByteOrder)object)) != null) {
            int n10 = object instanceof String;
            if (n10 != 0) {
                return Double.parseDouble((String)object);
            }
            n10 = object instanceof long[];
            String string2 = "There are more than one component";
            int n11 = 1;
            if (n10 != 0) {
                n10 = ((Object)(object = (Object)((long[])object))).length;
                if (n10 == n11) {
                    return (double)object[0];
                }
                object = new NumberFormatException(string2);
                throw object;
            }
            n10 = object instanceof int[];
            if (n10 != 0) {
                n10 = ((Object)(object = (Object)((int[])object))).length;
                if (n10 == n11) {
                    return (double)object[0];
                }
                object = new NumberFormatException(string2);
                throw object;
            }
            n10 = object instanceof double[];
            if (n10 != 0) {
                n10 = ((Object)(object = (Object)((double[])object))).length;
                if (n10 == n11) {
                    return (double)object[0];
                }
                object = new NumberFormatException(string2);
                throw object;
            }
            n10 = object instanceof LongRational[];
            if (n10 != 0) {
                n10 = ((LongRational[])(object = (LongRational[])object)).length;
                if (n10 == n11) {
                    return object[0].toDouble();
                }
                object = new NumberFormatException(string2);
                throw object;
            }
            object = new NumberFormatException("Couldn't find a double value");
            throw object;
        }
        object = new NumberFormatException("NULL can't be converted to a double value");
        throw object;
    }

    public int getIntValue(ByteOrder object) {
        if ((object = this.getValue((ByteOrder)object)) != null) {
            int n10 = object instanceof String;
            if (n10 != 0) {
                return Integer.parseInt((String)object);
            }
            n10 = object instanceof long[];
            String string2 = "There are more than one component";
            int n11 = 1;
            if (n10 != 0) {
                n10 = ((Object)(object = (Object)((long[])object))).length;
                if (n10 == n11) {
                    return (int)object[0];
                }
                object = new NumberFormatException(string2);
                throw object;
            }
            n10 = object instanceof int[];
            if (n10 != 0) {
                n10 = ((Object)(object = (Object)((int[])object))).length;
                if (n10 == n11) {
                    return (int)object[0];
                }
                object = new NumberFormatException(string2);
                throw object;
            }
            object = new NumberFormatException("Couldn't find a integer value");
            throw object;
        }
        object = new NumberFormatException("NULL can't be converted to a integer value");
        throw object;
    }

    public String getStringValue(ByteOrder longRationalArray) {
        longRationalArray = this.getValue((ByteOrder)longRationalArray);
        Object object = 0;
        LongRational longRational = null;
        if (longRationalArray == null) {
            return null;
        }
        boolean bl2 = longRationalArray instanceof String;
        if (bl2) {
            return (String)longRationalArray;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl3 = longRationalArray instanceof long[];
        String string2 = ",";
        int n10 = 0;
        if (bl3) {
            longRationalArray = (LongRational[])((long[])longRationalArray);
            while (n10 < (object = longRationalArray.length)) {
                Object object2 = longRationalArray[n10];
                stringBuilder.append((long)object2);
                object = longRationalArray.length;
                if (++n10 == object) continue;
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        bl3 = longRationalArray instanceof int[];
        if (bl3) {
            longRationalArray = (LongRational[])((int[])longRationalArray);
            while (n10 < (object = longRationalArray.length)) {
                object = longRationalArray[n10];
                stringBuilder.append((int)object);
                object = longRationalArray.length;
                if (++n10 == object) continue;
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        bl3 = longRationalArray instanceof double[];
        if (bl3) {
            longRationalArray = (LongRational[])((double[])longRationalArray);
            while (n10 < (object = longRationalArray.length)) {
                LongRational longRational2 = longRationalArray[n10];
                stringBuilder.append((double)longRational2);
                object = longRationalArray.length;
                if (++n10 == object) continue;
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        bl3 = longRationalArray instanceof LongRational[];
        if (bl3) {
            longRationalArray = longRationalArray;
            while (n10 < (object = longRationalArray.length)) {
                long l10 = longRationalArray[n10].getNumerator();
                stringBuilder.append(l10);
                stringBuilder.append('/');
                longRational = longRationalArray[n10];
                l10 = longRational.getDenominator();
                stringBuilder.append(l10);
                object = longRationalArray.length;
                if (++n10 == object) continue;
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Object getValue(ByteOrder var1_1) {
        block139: {
            block140: {
                block138: {
                    var2_9 = "IOException occurred while closing InputStream";
                    var3_10 = "ExifAttribute";
                    var4_11 = null;
                    var6_25 /* !! */  = this.bytes;
                    var5_24 = new ByteOrderedDataInputStream(var6_25 /* !! */ );
                    var5_24.setByteOrder((ByteOrder)var1_1);
                    var7_26 /* !! */  = this.format;
                    var8_27 = 1;
                    var9_28 = 1.4E-45f;
                    var10_29 = 0;
                    var11_30 = null;
                    switch (var7_26 /* !! */ ) {
                        default: {
                            break;
                        }
                        case 12: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new double[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var12_31 = var5_24.readDouble();
                                var1_1[var10_29] = (LongRational)var12_31;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_12) {
                                Logger.e(var3_10, var2_9, var4_12);
                            }
                            return var1_1;
                        }
                        case 11: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new double[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var9_28 = var5_24.readFloat();
                                var12_32 = var9_28;
                                var1_1[var10_29] = (LongRational)var12_32;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_13) {
                                Logger.e(var3_10, var2_9, var4_13);
                            }
                            return var1_1;
                        }
                        case 10: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new LongRational[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var8_27 = var5_24.readInt();
                                var14_33 = var8_27;
                                var8_27 = var5_24.readInt();
                                var16_36 = var8_27;
                                var6_25 /* !! */  = (byte[])new LongRational;
                                var6_25 /* !! */ (var14_33, var16_36);
                                var1_1[var10_29] = var6_25 /* !! */ ;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_14) {
                                Logger.e(var3_10, var2_9, var4_14);
                            }
                            return var1_1;
                        }
                        case 9: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new int[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var8_27 = var5_24.readInt();
                                var1_1[var10_29] = (LongRational)var8_27;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_15) {
                                Logger.e(var3_10, var2_9, var4_15);
                            }
                            return var1_1;
                        }
                        case 8: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new int[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var8_27 = var5_24.readShort();
                                var1_1[var10_29] = (LongRational)var8_27;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_16) {
                                Logger.e(var3_10, var2_9, var4_16);
                            }
                            return var1_1;
                        }
                        case 5: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new LongRational[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var14_34 = var5_24.readUnsignedInt();
                                var16_37 = var5_24.readUnsignedInt();
                                var6_25 /* !! */  = (byte[])new LongRational;
                                var6_25 /* !! */ (var14_34, var16_37);
                                var1_1[var10_29] = var6_25 /* !! */ ;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_17) {
                                Logger.e(var3_10, var2_9, var4_17);
                            }
                            return var1_1;
                        }
                        case 4: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new long[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var14_35 = var5_24.readUnsignedInt();
                                var1_1[var10_29] = (LongRational)var14_35;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_18) {
                                Logger.e(var3_10, var2_9, var4_18);
                            }
                            return var1_1;
                        }
                        case 3: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var1_1 = new int[var7_26 /* !! */ ];
                            while (true) {
                                var8_27 = this.numberOfComponents;
                                if (var10_29 >= var8_27) break;
                                var8_27 = var5_24.readUnsignedShort();
                                var1_1[var10_29] = (LongRational)var8_27;
                                ++var10_29;
                                continue;
                                break;
                            }
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_19) {
                                Logger.e(var3_10, var2_9, var4_19);
                            }
                            return var1_1;
                        }
                        case 2: 
                        case 7: {
                            var7_26 /* !! */  = this.numberOfComponents;
                            var18_38 = ExifAttribute.EXIF_ASCII_PREFIX;
                            var19_40 = var18_38.length;
                            if (var7_26 /* !! */  < var19_40) ** GOTO lbl234
                            var7_26 /* !! */  = 0;
                            var1_1 = null;
                            while (true) {
                                var18_38 = ExifAttribute.EXIF_ASCII_PREFIX;
                                var20_42 = var18_38.length;
                                if (var7_26 /* !! */  >= var20_42) break;
                                var21_43 = this.bytes;
                                var20_42 = var21_43[var7_26 /* !! */ ];
                                var22_44 = var18_38[var7_26 /* !! */ ];
                                if (var20_42 != var22_44) {
                                    var8_27 = 0;
                                    var6_25 /* !! */  = null;
                                    var9_28 = 0.0f;
                                    break;
                                }
                                ++var7_26 /* !! */ ;
                                continue;
                                break;
                            }
                            if (var8_27 != 0) {
                                var10_29 = var18_38.length;
                            }
lbl234:
                            // 5 sources

                            var1_1 = new StringBuilder();
                            ** while (var10_29 < (var8_27 = this.numberOfComponents))
lbl-1000:
                            // 1 sources

                            {
                                var6_25 /* !! */  = this.bytes;
                                var8_27 = var6_25 /* !! */ [var10_29];
                                if (var8_27 == 0) break;
                                var19_40 = 32;
                                if (var8_27 < var19_40) ** GOTO lbl248
                                var8_27 = (char)var8_27;
                                var1_1.append((char)var8_27);
                                ** GOTO lbl253
lbl248:
                                // 1 sources

                                var8_27 = 63;
                                var9_28 = 8.8E-44f;
                                var1_1.append((char)var8_27);
lbl253:
                                // 2 sources

                                ++var10_29;
                                continue;
                            }
lbl256:
                            // 3 sources

                            var1_1 = var1_1.toString();
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_20) {
                                Logger.e(var3_10, var2_9, var4_20);
                            }
                            return var1_1;
                        }
                        case 1: 
                        case 6: {
                            var1_1 = this.bytes;
                            var19_41 /* !! */  = ((Object)var1_1).length;
                            if (var19_41 /* !! */  != var8_27) ** GOTO lbl292
                            var19_41 /* !! */  = (int)var1_1[0];
                            if (var19_41 /* !! */  < 0) ** GOTO lbl292
                            var7_26 /* !! */  = (int)var1_1[0];
                            if (var7_26 /* !! */  > var8_27) ** GOTO lbl292
                            var6_25 /* !! */  = (byte[])new char[var8_27];
                            var18_39 = this.bytes;
                            var19_41 /* !! */  = (char)(var18_39[0] + 48);
                            var6_25 /* !! */ [0] = var19_41 /* !! */ ;
                            var1_1 = new String((char[])var6_25 /* !! */ );
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_21) {
                                Logger.e(var3_10, var2_9, var4_21);
                            }
                            return var1_1;
lbl292:
                            // 4 sources

                            var6_25 /* !! */  = this.bytes;
                            var11_30 = ExifAttribute.ASCII;
                            var1_1 = new String(var6_25 /* !! */ , var11_30);
                            try {
                                var5_24.close();
                            }
                            catch (IOException var4_22) {
                                Logger.e(var3_10, var2_9, var4_22);
                            }
                            return var1_1;
                        }
                    }
                    try {
                        var5_24.close();
                    }
                    catch (IOException var1_2) {
                        Logger.e(var3_10, var2_9, var1_2);
                    }
                    return null;
                    catch (IOException var1_3) {
                        break block138;
                    }
                    catch (Throwable var1_4) {
                        break block139;
                    }
                    catch (IOException var1_5) {
                        var5_24 = null;
                    }
                }
                var6_25 /* !! */  = (byte[])"IOException occurred during reading a value";
                Logger.w(var3_10, (String)var6_25 /* !! */ , (Throwable)var1_1);
                if (var5_24 == null) break block140;
                try {
                    var5_24.close();
                }
                catch (IOException var1_6) {
                    Logger.e(var3_10, var2_9, var1_6);
                }
            }
            return null;
            catch (Throwable var1_7) {
                var4_11 = var5_24;
            }
        }
        if (var4_11 != null) {
            try {
                var4_11.close();
            }
            catch (IOException var4_23) {
                Logger.e(var3_10, var2_9, var4_23);
            }
        }
        throw var1_8;
    }

    public int size() {
        int[] nArray = IFD_FORMAT_BYTES_PER_FORMAT;
        int n10 = this.format;
        int n11 = nArray[n10];
        n10 = this.numberOfComponents;
        return n11 * n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        Object object = IFD_FORMAT_NAMES;
        int n10 = this.format;
        object = object[n10];
        stringBuilder.append((String)object);
        stringBuilder.append(", data length:");
        int n11 = this.bytes.length;
        stringBuilder.append(n11);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

