/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 */
package com.quvideo.mobile.external.component.cloudcomposite.compressor;

import android.graphics.BitmapFactory;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOO0O;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class OooO00o
extends Enum {
    public static final /* enum */ OooO00o SINGLE;
    private static final String a = "Compressor";
    private static final String b = ".jpg";
    private static final /* synthetic */ OooO00o[] c;
    private final byte[] JPEG_SIGNATURE;

    static {
        OooO00o oooO00o;
        SINGLE = oooO00o = new OooO00o("SINGLE", 0);
        OooO00o[] oooO00oArray = new OooO00o[]{oooO00o};
        c = oooO00oArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OooO00o() {
        byte[] byArray;
        void var2_-1;
        void var1_-1;
        byte[] byArray2 = byArray = new byte[3];
        byArray[0] = -1;
        byArray2[1] = -40;
        byArray2[2] = -1;
        this.JPEG_SIGNATURE = byArray;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int a(byte[] var1_1) {
        block12: {
            block14: {
                block13: {
                    block11: {
                        block10: {
                            if (var1_1 /* !! */  == null) {
                                return 0;
                            }
                            var2_2 = 0;
                            while (true) {
                                var3_3 = var2_2 + 3;
                                var4_4 = var1_1 /* !! */ .length;
                                var5_5 = 4;
                                var6_6 = "Compressor";
                                var7_7 = 1;
                                var8_8 = 8;
                                var9_9 = 2;
                                if (var3_3 >= var4_4) break block10;
                                var3_3 = var2_2 + 1;
                                var2_2 = var1_1 /* !! */ [var2_2];
                                var4_4 = 255;
                                if ((var2_2 &= var4_4) != var4_4) break;
                                var2_2 = var1_1 /* !! */ [var3_3] & var4_4;
                                if (var2_2 != var4_4) {
                                    ++var3_3;
                                    var4_4 = 216;
                                    if (var2_2 != var4_4 && var2_2 != var7_7) {
                                        var4_4 = 217;
                                        if (var2_2 == var4_4 || var2_2 == (var4_4 = 218)) break;
                                        var4_4 = this.c(var1_1 /* !! */ , var3_3, var9_9, false);
                                        if (var4_4 >= var9_9 && (var10_10 = var3_3 + var4_4) <= (var11_11 = var1_1 /* !! */ .length)) {
                                            var11_11 = 225;
                                            if (var2_2 == var11_11 && var4_4 >= var8_8) {
                                                var2_2 = var3_3 + 2;
                                                if ((var2_2 = this.c(var1_1 /* !! */ , var2_2, var5_5, false)) == (var11_11 = 1165519206)) {
                                                    var2_2 = var3_3 + 6;
                                                    if ((var2_2 = this.c(var1_1 /* !! */ , var2_2, var9_9, false)) == 0) {
                                                        var2_2 = var3_3 + 8;
                                                        var4_4 += -8;
                                                        break block11;
                                                    }
                                                }
                                            }
                                            var2_2 = var10_10;
                                            continue;
                                        }
                                        var1_1 /* !! */  = (byte[])"Invalid length";
lbl38:
                                        // 5 sources

                                        while (true) {
                                            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(var6_6, (String)var1_1 /* !! */ );
                                            return 0;
                                        }
                                    }
                                }
                                var2_2 = var3_3;
                            }
                            var4_4 = 0;
                            var2_2 = var3_3;
                            break block11;
                        }
                        var4_4 = 0;
                    }
                    if (var4_4 <= var8_8) break block12;
                    var3_3 = this.c(var1_1 /* !! */ , var2_2, var5_5, false);
                    if (var3_3 == (var10_10 = 1229531648) || var3_3 == (var11_11 = 1296891946)) break block13;
                    var1_1 /* !! */  = (byte[])"Invalid byte order";
                    ** GOTO lbl38
                }
                var3_3 = var3_3 == var10_10 ? var7_7 : 0;
                var10_10 = var2_2 + 4;
                if ((var5_5 = this.c(var1_1 /* !! */ , var10_10, var5_5, (boolean)var3_3) + var9_9) < (var10_10 = 10) || var5_5 > var4_4) break block14;
                var2_2 += var5_5;
                var4_4 -= var5_5;
                var5_5 = var2_2 + -2;
                var5_5 = this.c(var1_1 /* !! */ , var5_5, var9_9, (boolean)var3_3);
                while (true) {
                    block15: {
                        block16: {
                            block17: {
                                block18: {
                                    block19: {
                                        var10_10 = var5_5 + -1;
                                        if (var5_5 <= 0 || var4_4 < (var5_5 = 12)) break block12;
                                        var5_5 = this.c(var1_1 /* !! */ , var2_2, var9_9, (boolean)var3_3);
                                        if (var5_5 != (var11_11 = 274)) break block15;
                                        var12_12 = this.c(var1_1 /* !! */ , var2_2 += var8_8, var9_9, (boolean)var3_3);
                                        if (var12_12 == var7_7) break block16;
                                        var2_2 = 3;
                                        if (var12_12 == var2_2) break block17;
                                        var2_2 = 6;
                                        if (var12_12 == var2_2) break block18;
                                        if (var12_12 == var8_8) break block19;
                                        var1_1 /* !! */  = (byte[])"Unsupported orientation";
                                        ** GOTO lbl38
                                    }
                                    return 270;
                                }
                                return 90;
                            }
                            return 180;
                        }
                        return 0;
                    }
                    var2_2 += 12;
                    var4_4 += -12;
                    var5_5 = var10_10;
                }
            }
            var1_1 /* !! */  = (byte[])"Invalid offset";
            ** GOTO lbl38
        }
        var1_1 /* !! */  = (byte[])"Orientation not found";
        ** while (true)
    }

    private boolean b(byte[] byArray) {
        int n10;
        int n11;
        int n12 = 0;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 3)) {
            byte by2;
            byte[] byArray2 = new byte[n10];
            byArray2[0] = n10 = byArray[0];
            n12 = 1;
            byArray2[n12] = n10 = byArray[n12];
            n12 = 2;
            byArray2[n12] = by2 = byArray[n12];
            return Arrays.equals(this.JPEG_SIGNATURE, byArray2);
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private int c(byte[] byArray, int n10, int n11, boolean bl2) {
        if (bl2) {
            int n12 = n11 + -1;
            n10 += n12;
            int n13 = -1;
        } else {
            boolean bl3 = true;
        }
        int n14 = 0;
        while (true) {
            void var4_8;
            int n15 = n11 + -1;
            if (n11 <= 0) break;
            n11 = n14 << 8;
            n14 = byArray[n10] & 0xFF | n11;
            n10 += var4_8;
            n11 = n15;
        }
        return n14;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private byte[] d(InputStream object) {
        Throwable throwable222222;
        int n10;
        int n11;
        if (object == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        while ((n11 = ((InputStream)object).read(byArray, 0, n12)) != (n10 = -1)) {
            byteArrayOutputStream.write(byArray, 0, n11);
        }
        try {
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            return byteArrayOutputStream.toByteArray();
        }
        {
            block12: {
                catch (Throwable throwable222222) {
                    break block12;
                }
                catch (Exception exception) {}
                {
                    object = new byte[0];
                }
                byteArrayOutputStream.close();
                return object;
            }
            byteArrayOutputStream.close();
        }
        catch (IOException iOException) {
            throw throwable222222;
        }
        {
            throw throwable222222;
            catch (IOException iOException) {
                return object;
            }
        }
    }

    public static OooO00o valueOf(String string2) {
        return Enum.valueOf(OooO00o.class, string2);
    }

    public static OooO00o[] values() {
        return (OooO00o[])c.clone();
    }

    public String extSuffix(OooOO0O object) {
        boolean bl2;
        Object object2;
        try {
            object2 = new BitmapFactory.Options();
            bl2 = true;
        }
        catch (Exception exception) {
            return b;
        }
        object2.inJustDecodeBounds = bl2;
        object = object.OooO00o();
        bl2 = false;
        String string2 = null;
        BitmapFactory.decodeStream((InputStream)object, null, (BitmapFactory.Options)object2);
        object = object2.outMimeType;
        object2 = "image/";
        string2 = ".";
        return ((String)object).replace((CharSequence)object2, string2);
    }

    public int getOrientation(InputStream object) {
        object = this.d((InputStream)object);
        return this.a((byte[])object);
    }

    public boolean isJPG(InputStream object) {
        object = this.d((InputStream)object);
        return this.b((byte[])object);
    }

    public boolean needCompress(int n10, String string2) {
        long l10;
        long l11;
        long l12;
        File file;
        boolean bl2;
        boolean bl3 = true;
        if (!(n10 <= 0 || (bl2 = (file = new File(string2)).exists()) && (n10 = (int)((l12 = (l11 = file.length()) - (l10 = (long)(n10 << 10))) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0)) {
            bl3 = false;
        }
        return bl3;
    }
}

