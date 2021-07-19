/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Xfermode
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Xfermode;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.dvb.DvbParser$ClutDefinition;
import com.google.android.exoplayer2.text.dvb.DvbParser$DisplayDefinition;
import com.google.android.exoplayer2.text.dvb.DvbParser$ObjectData;
import com.google.android.exoplayer2.text.dvb.DvbParser$PageComposition;
import com.google.android.exoplayer2.text.dvb.DvbParser$PageRegion;
import com.google.android.exoplayer2.text.dvb.DvbParser$RegionComposition;
import com.google.android.exoplayer2.text.dvb.DvbParser$RegionObject;
import com.google.android.exoplayer2.text.dvb.DvbParser$SubtitleService;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DvbParser {
    private static final int DATA_TYPE_24_TABLE_DATA = 32;
    private static final int DATA_TYPE_28_TABLE_DATA = 33;
    private static final int DATA_TYPE_2BP_CODE_STRING = 16;
    private static final int DATA_TYPE_48_TABLE_DATA = 34;
    private static final int DATA_TYPE_4BP_CODE_STRING = 17;
    private static final int DATA_TYPE_8BP_CODE_STRING = 18;
    private static final int DATA_TYPE_END_LINE = 240;
    private static final int OBJECT_CODING_PIXELS = 0;
    private static final int OBJECT_CODING_STRING = 1;
    private static final int PAGE_STATE_NORMAL = 0;
    private static final int REGION_DEPTH_4_BIT = 2;
    private static final int REGION_DEPTH_8_BIT = 3;
    private static final int SEGMENT_TYPE_CLUT_DEFINITION = 18;
    private static final int SEGMENT_TYPE_DISPLAY_DEFINITION = 20;
    private static final int SEGMENT_TYPE_OBJECT_DATA = 19;
    private static final int SEGMENT_TYPE_PAGE_COMPOSITION = 16;
    private static final int SEGMENT_TYPE_REGION_COMPOSITION = 17;
    private static final String TAG = "DvbParser";
    private static final byte[] defaultMap2To4;
    private static final byte[] defaultMap2To8;
    private static final byte[] defaultMap4To8;
    private Bitmap bitmap;
    private final Canvas canvas;
    private final DvbParser$ClutDefinition defaultClutDefinition;
    private final DvbParser$DisplayDefinition defaultDisplayDefinition;
    private final Paint defaultPaint;
    private final Paint fillRegionPaint;
    private final DvbParser$SubtitleService subtitleService;

    static {
        byte[] byArray;
        byte[] byArray2;
        int n10 = 4;
        byte[] byArray3 = byArray2 = new byte[n10];
        byte[] byArray4 = byArray2;
        byArray3[0] = 0;
        byArray4[1] = 7;
        byArray3[2] = 8;
        byArray4[3] = 15;
        defaultMap2To4 = byArray2;
        byte[] byArray5 = byArray = new byte[n10];
        byte[] byArray6 = byArray;
        byArray5[0] = 0;
        byArray6[1] = 119;
        byArray5[2] = -120;
        byArray6[3] = -1;
        defaultMap2To8 = byArray;
        byte[] byArray7 = byArray = new byte[16];
        byte[] byArray8 = byArray;
        byArray7[0] = 0;
        byArray8[1] = 17;
        byArray7[2] = 34;
        byArray8[3] = 51;
        byArray7[4] = 68;
        byArray8[5] = 85;
        byArray7[6] = 102;
        byArray8[7] = 119;
        byArray7[8] = -120;
        byArray8[9] = -103;
        byArray7[10] = -86;
        byArray8[11] = -69;
        byArray7[12] = -52;
        byArray8[13] = -35;
        byArray7[14] = -18;
        byArray8[15] = -1;
        defaultMap4To8 = byArray;
    }

    public DvbParser(int n10, int n11) {
        Object object;
        this.defaultPaint = object = new Paint();
        Object object2 = Paint.Style.FILL_AND_STROKE;
        object.setStyle(object2);
        Object object3 = PorterDuff.Mode.SRC;
        super(object3);
        object.setXfermode((Xfermode)object2);
        object.setPathEffect(null);
        this.fillRegionPaint = object = new Paint();
        object3 = Paint.Style.FILL;
        object.setStyle((Paint.Style)object3);
        Object object4 = PorterDuff.Mode.DST_OVER;
        super(object4);
        object.setXfermode((Xfermode)object3);
        object.setPathEffect(null);
        super();
        this.canvas = object;
        object2 = object;
        super(719, 575, 0, 719, 0, 575);
        this.defaultDisplayDefinition = object;
        object2 = DvbParser.generateDefault2BitClutEntries();
        object3 = DvbParser.generateDefault4BitClutEntries();
        object4 = DvbParser.generateDefault8BitClutEntries();
        super(0, (int[])object2, (int[])object3, (int[])object4);
        this.defaultClutDefinition = object;
        super(n10, n11);
        this.subtitleService = object;
    }

    private static byte[] buildClutMapTable(int n10, int n11, ParsableBitArray parsableBitArray) {
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2;
            byArray[i10] = by2 = (byte)parsableBitArray.readBits(n11);
        }
        return byArray;
    }

    private static int[] generateDefault2BitClutEntries() {
        int[] nArray;
        int[] nArray2 = nArray = new int[4];
        int[] nArray3 = nArray;
        nArray2[0] = 0;
        nArray3[1] = -1;
        nArray2[2] = -16777216;
        nArray3[3] = -8421505;
        return nArray;
    }

    private static int[] generateDefault4BitClutEntries() {
        int n10 = 16;
        int[] nArray = new int[n10];
        nArray[0] = 0;
        for (int i10 = 1; i10 < n10; ++i10) {
            int n11;
            int n12;
            int n13 = 8;
            int n14 = 255;
            float f10 = 3.57E-43f;
            if (i10 < n13) {
                n13 = i10 & 1;
                n13 = n13 != 0 ? n14 : 0;
                n12 = i10 & 2;
                n12 = n12 != 0 ? n14 : 0;
                n11 = i10 & 4;
                n11 = n11 != 0 ? n14 : 0;
                nArray[i10] = n13 = DvbParser.getColor(n14, n13, n12, n11);
                continue;
            }
            n13 = i10 & 1;
            n12 = 127;
            n13 = n13 != 0 ? n12 : 0;
            n11 = i10 & 2;
            n11 = n11 != 0 ? n12 : 0;
            int n15 = i10 & 4;
            if (n15 == 0) {
                n12 = 0;
            }
            nArray[i10] = n13 = DvbParser.getColor(n14, n13, n11, n12);
        }
        return nArray;
    }

    private static int[] generateDefault8BitClutEntries() {
        int n10 = 256;
        int[] nArray = new int[n10];
        nArray[0] = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12;
            float f10;
            int n13;
            int n14;
            int n15 = 8;
            int n16 = 255;
            float f11 = 3.57E-43f;
            if (i10 < n15) {
                n15 = 63;
                n14 = i10 & 1;
                n14 = n14 != 0 ? n16 : 0;
                n13 = i10 & 2;
                if (n13 != 0) {
                    n13 = n16;
                    f10 = f11;
                } else {
                    n13 = 0;
                    f10 = 0.0f;
                }
                n12 = i10 & 4;
                if (n12 == 0) {
                    n16 = 0;
                    f11 = 0.0f;
                }
                nArray[i10] = n15 = DvbParser.getColor(n15, n14, n13, n16);
                continue;
            }
            n14 = i10 & 0x88;
            n13 = 170;
            f10 = 2.38E-43f;
            n12 = 85;
            float f12 = 1.19E-43f;
            if (n14 != 0) {
                n11 = 127;
                if (n14 != n15) {
                    n15 = 128;
                    n13 = 43;
                    f10 = 6.0E-44f;
                    if (n14 != n15) {
                        n15 = 136;
                        if (n14 != n15) continue;
                        n15 = i10 & 1;
                        n15 = n15 != 0 ? n13 : 0;
                        n14 = i10 & 0x10;
                        n14 = n14 != 0 ? n12 : 0;
                        n15 += n14;
                        n14 = i10 & 2;
                        n14 = n14 != 0 ? n13 : 0;
                        n11 = i10 & 0x20;
                        n11 = n11 != 0 ? n12 : 0;
                        n14 += n11;
                        n11 = i10 & 4;
                        if (n11 == 0) {
                            n13 = 0;
                            f10 = 0.0f;
                        }
                        n11 = i10 & 0x40;
                        if (n11 == 0) {
                            n12 = 0;
                            f12 = 0.0f;
                        }
                        nArray[i10] = n15 = DvbParser.getColor(n16, n15, n14, n13 += n12);
                        continue;
                    }
                    n15 = i10 & 1;
                    n15 = n15 != 0 ? n13 : 0;
                    n15 += n11;
                    n14 = i10 & 0x10;
                    n14 = n14 != 0 ? n12 : 0;
                    n15 += n14;
                    n14 = i10 & 2;
                    n14 = n14 != 0 ? n13 : 0;
                    n14 += n11;
                    int n17 = i10 & 0x20;
                    n17 = n17 != 0 ? n12 : 0;
                    n14 += n17;
                    n17 = i10 & 4;
                    if (n17 == 0) {
                        n13 = 0;
                        f10 = 0.0f;
                    }
                    n13 += n11;
                    n11 = i10 & 0x40;
                    if (n11 == 0) {
                        n12 = 0;
                        f12 = 0.0f;
                    }
                    nArray[i10] = n15 = DvbParser.getColor(n16, n15, n14, n13 += n12);
                    continue;
                }
                n15 = i10 & 1;
                n15 = n15 != 0 ? n12 : 0;
                n16 = i10 & 0x10;
                if (n16 != 0) {
                    n16 = n13;
                    f11 = f10;
                } else {
                    n16 = 0;
                    f11 = 0.0f;
                }
                n15 += n16;
                n16 = i10 & 2;
                if (n16 != 0) {
                    n16 = n12;
                    f11 = f12;
                } else {
                    n16 = 0;
                    f11 = 0.0f;
                }
                n14 = i10 & 0x20;
                n14 = n14 != 0 ? n13 : 0;
                n16 += n14;
                n14 = i10 & 4;
                if (n14 == 0) {
                    n12 = 0;
                    f12 = 0.0f;
                }
                n14 = i10 & 0x40;
                if (n14 == 0) {
                    n13 = 0;
                    f10 = 0.0f;
                }
                nArray[i10] = n15 = DvbParser.getColor(n11, n15, n16, n12 += n13);
                continue;
            }
            n15 = i10 & 1;
            n15 = n15 != 0 ? n12 : 0;
            n14 = i10 & 0x10;
            n14 = n14 != 0 ? n13 : 0;
            n15 += n14;
            n14 = i10 & 2;
            n14 = n14 != 0 ? n12 : 0;
            n11 = i10 & 0x20;
            n11 = n11 != 0 ? n13 : 0;
            n14 += n11;
            n11 = i10 & 4;
            if (n11 == 0) {
                n12 = 0;
                f12 = 0.0f;
            }
            n11 = i10 & 0x40;
            if (n11 == 0) {
                n13 = 0;
                f10 = 0.0f;
            }
            nArray[i10] = n15 = DvbParser.getColor(n16, n15, n14, n12 += n13);
        }
        return nArray;
    }

    private static int getColor(int n10, int n11, int n12, int n13) {
        n10 <<= 24;
        n11 = n12 << 8;
        return (n10 |= (n11 <<= 16)) | n11 | n13;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int paint2BitPixelCodeString(ParsableBitArray parsableBitArray, int[] nArray, byte[] byArray, int n10, int n11, Paint paint, Canvas canvas) {
        int n12 = n11;
        Paint paint2 = paint;
        int n13 = n10;
        int n14 = 0;
        float f10 = 0.0f;
        while (true) {
            float f11;
            float f12;
            int n15;
            float f13;
            int n16;
            float f14;
            int n17;
            float f15;
            block5: {
                block14: {
                    int n18;
                    block10: {
                        block9: {
                            int n19;
                            block11: {
                                block7: {
                                    block12: {
                                        block13: {
                                            int n20;
                                            block8: {
                                                block6: {
                                                    block4: {
                                                        n19 = 2;
                                                        f15 = 2.8E-45f;
                                                        n17 = parsableBitArray.readBits(n19);
                                                        n18 = 1;
                                                        f14 = Float.MIN_VALUE;
                                                        if (n17 == 0) break block4;
                                                        n16 = n14;
                                                        f13 = f10;
                                                        n15 = n18;
                                                        break block5;
                                                    }
                                                    n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
                                                    n20 = 3;
                                                    f12 = 4.2E-45f;
                                                    if (n17 == 0) break block6;
                                                    n17 = parsableBitArray.readBits(n20) + n20;
                                                    n19 = parsableBitArray.readBits(n19);
                                                    break block7;
                                                }
                                                n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
                                                if (n17 == 0) break block8;
                                                n16 = n14;
                                                f13 = f10;
                                                n15 = n18;
                                                break block9;
                                            }
                                            n17 = parsableBitArray.readBits(n19);
                                            if (n17 == 0) break block10;
                                            if (n17 == n18) break block11;
                                            if (n17 == n19) break block12;
                                            if (n17 == n20) break block13;
                                            n16 = n14;
                                            f13 = f10;
                                            break block14;
                                        }
                                        f11 = 1.1E-44f;
                                        n17 = parsableBitArray.readBits(8) + 29;
                                        n19 = parsableBitArray.readBits(n19);
                                        break block7;
                                    }
                                    f11 = 5.6E-45f;
                                    n17 = parsableBitArray.readBits(4) + 12;
                                    n19 = parsableBitArray.readBits(n19);
                                }
                                n16 = n14;
                                f13 = f10;
                                n15 = n17;
                                n17 = n19;
                                break block5;
                            }
                            n16 = n14;
                            f13 = f10;
                            n15 = n19;
                        }
                        n17 = 0;
                        f11 = 0.0f;
                        break block5;
                    }
                    n16 = n18;
                    f13 = f14;
                }
                n17 = 0;
                f11 = 0.0f;
                n15 = 0;
            }
            if (n15 != 0 && paint2 != null) {
                if (byArray != null) {
                    n17 = byArray[n17];
                }
                n14 = nArray[n17];
                paint2.setColor(n14);
                f15 = n13;
                f11 = n12;
                f12 = n13 + n15;
                n14 = n12 + 1;
                float f16 = n14;
                f14 = f12;
                f12 = f16;
                canvas.drawRect(f15, f11, f14, f16, paint);
            }
            n13 += n15;
            if (n16 != 0) {
                return n13;
            }
            n14 = n16;
            f10 = f13;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int paint4BitPixelCodeString(ParsableBitArray parsableBitArray, int[] nArray, byte[] byArray, int n10, int n11, Paint paint, Canvas canvas) {
        int n12 = n11;
        Paint paint2 = paint;
        int n13 = n10;
        int n14 = 0;
        float f10 = 0.0f;
        while (true) {
            float f11;
            int n15;
            float f12;
            int n16;
            float f13;
            float f14;
            int n17;
            float f15;
            block5: {
                block15: {
                    int n18;
                    block12: {
                        int n19;
                        block11: {
                            int n20;
                            block13: {
                                block14: {
                                    block9: {
                                        block8: {
                                            int n21;
                                            block10: {
                                                block6: {
                                                    block7: {
                                                        block4: {
                                                            n20 = 4;
                                                            f15 = 5.6E-45f;
                                                            n17 = parsableBitArray.readBits(n20);
                                                            n19 = 2;
                                                            f14 = 2.8E-45f;
                                                            n18 = 1;
                                                            f13 = Float.MIN_VALUE;
                                                            if (n17 == 0) break block4;
                                                            n16 = n14;
                                                            f12 = f10;
                                                            n15 = n18;
                                                            break block5;
                                                        }
                                                        n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
                                                        n21 = 3;
                                                        if (n17 != 0) break block6;
                                                        n20 = parsableBitArray.readBits(n21);
                                                        if (n20 == 0) break block7;
                                                        n19 = n20 + 2;
                                                        break block8;
                                                    }
                                                    n16 = n18;
                                                    f12 = f13;
                                                    break block9;
                                                }
                                                n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
                                                if (n17 != 0) break block10;
                                                n19 = parsableBitArray.readBits(n19) + 4;
                                                n17 = parsableBitArray.readBits(n20);
                                                break block11;
                                            }
                                            n17 = parsableBitArray.readBits(n19);
                                            if (n17 == 0) break block12;
                                            if (n17 == n18) break block8;
                                            if (n17 == n19) break block13;
                                            if (n17 == n21) break block14;
                                            n16 = n14;
                                            f12 = f10;
                                            break block9;
                                        }
                                        n16 = n14;
                                        f12 = f10;
                                        n15 = n19;
                                        break block15;
                                    }
                                    n17 = 0;
                                    f11 = 0.0f;
                                    n15 = 0;
                                    break block5;
                                }
                                f11 = 1.1E-44f;
                                n19 = parsableBitArray.readBits(8) + 25;
                                n17 = parsableBitArray.readBits(n20);
                                break block11;
                            }
                            n19 = parsableBitArray.readBits(n20) + 9;
                            n17 = parsableBitArray.readBits(n20);
                        }
                        n16 = n14;
                        f12 = f10;
                        n15 = n19;
                        break block5;
                    }
                    n16 = n14;
                    f12 = f10;
                    n15 = n18;
                }
                n17 = 0;
                f11 = 0.0f;
            }
            if (n15 != 0 && paint2 != null) {
                if (byArray != null) {
                    n17 = byArray[n17];
                }
                n14 = nArray[n17];
                paint2.setColor(n14);
                f15 = n13;
                f11 = n12;
                f14 = n13 + n15;
                n14 = n12 + 1;
                f13 = n14;
                canvas.drawRect(f15, f11, f14, f13, paint);
            }
            n13 += n15;
            if (n16 != 0) {
                return n13;
            }
            n14 = n16;
            f10 = f12;
        }
    }

    private static int paint8BitPixelCodeString(ParsableBitArray parsableBitArray, int[] nArray, byte[] byArray, int n10, int n11, Paint paint, Canvas canvas) {
        int n12 = n11;
        Paint paint2 = paint;
        int n13 = n10;
        int n14 = 0;
        float f10 = 0.0f;
        while (true) {
            float f11;
            float f12;
            int n15;
            float f13;
            int n16;
            int n17 = 8;
            float f14 = 1.1E-44f;
            int n18 = parsableBitArray.readBits(n17);
            int n19 = 1;
            float f15 = Float.MIN_VALUE;
            if (n18 != 0) {
                n16 = n14;
                f13 = f10;
                n15 = n19;
            } else {
                n18 = (int)(parsableBitArray.readBit() ? 1 : 0);
                int n20 = 7;
                f12 = 9.8E-45f;
                if (n18 == 0) {
                    n17 = parsableBitArray.readBits(n20);
                    if (n17 != 0) {
                        n16 = n14;
                        f13 = f10;
                        n15 = n17;
                        n18 = 0;
                        f11 = 0.0f;
                    } else {
                        n16 = n19;
                        f13 = f15;
                        n18 = 0;
                        f11 = 0.0f;
                        n15 = 0;
                    }
                } else {
                    n18 = parsableBitArray.readBits(n20);
                    n17 = parsableBitArray.readBits(n17);
                    n16 = n14;
                    f13 = f10;
                    n15 = n18;
                    n18 = n17;
                }
            }
            if (n15 != 0 && paint2 != null) {
                if (byArray != null) {
                    n18 = byArray[n18];
                }
                n14 = nArray[n18];
                paint2.setColor(n14);
                f14 = n13;
                f11 = n12;
                f12 = n13 + n15;
                n14 = n12 + 1;
                float f16 = n14;
                f15 = f12;
                f12 = f16;
                canvas.drawRect(f14, f11, f15, f16, paint);
            }
            n13 += n15;
            if (n16 != 0) {
                return n13;
            }
            n14 = n16;
            f10 = f13;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void paintPixelDataSubBlock(byte[] var0, int[] var1_1, int var2_2, int var3_3, int var4_4, Paint var5_5, Canvas var6_6) {
        var7_7 = var2_2;
        var9_9 /* !! */  = var0;
        var8_8 = new ParsableBitArray(var0);
        var10_10 = var3_3;
        var11_11 = var4_4;
        var12_12 = null;
        var13_13 = null;
        var14_14 = null;
        block10: while ((var15_15 = var8_8.bitsLeft()) != 0) {
            block16: {
                block15: {
                    block17: {
                        block18: {
                            var15_15 = 8;
                            var16_16 = var8_8.readBits(var15_15);
                            if (var16_16 == (var17_17 = 240)) break block16;
                            var17_17 = 3;
                            switch (var16_16) {
                                default: {
                                    var17_17 = 4;
                                    switch (var16_16) {
                                        default: {
                                            continue block10;
                                        }
                                        case 34: {
                                            var16_16 = 16;
                                            var13_13 = DvbParser.buildClutMapTable(var16_16, var15_15, var8_8);
                                            continue block10;
                                        }
                                        case 33: {
                                            var12_12 = DvbParser.buildClutMapTable(var17_17, var15_15, var8_8);
                                            continue block10;
                                        }
                                        case 32: 
                                    }
                                    var14_14 = DvbParser.buildClutMapTable(var17_17, var17_17, var8_8);
                                    continue block10;
                                }
                                case 18: {
                                    var17_17 = 0;
                                    var18_18 /* !! */  = null;
                                    var9_9 /* !! */  = (byte[])var8_8;
                                    var10_10 = DvbParser.paint8BitPixelCodeString(var8_8, var1_1, null, var10_10, var11_11, var5_5, var6_6);
                                    continue block10;
                                }
                                case 17: {
                                    if (var7_7 == var17_17) {
                                        var9_9 /* !! */  = var13_13 == null ? DvbParser.defaultMap4To8 : var13_13;
                                        var18_18 /* !! */  = var9_9 /* !! */ ;
                                    } else {
                                        var17_17 = 0;
                                        var18_18 /* !! */  = null;
                                    }
                                    var9_9 /* !! */  = (byte[])var8_8;
                                    var10_10 = DvbParser.paint4BitPixelCodeString(var8_8, var1_1, var18_18 /* !! */ , var10_10, var11_11, var5_5, var6_6);
                                    var8_8.byteAlign();
                                    continue block10;
                                }
                                case 16: 
                            }
                            if (var7_7 == var17_17) {
                                var9_9 /* !! */  = var12_12 == null ? DvbParser.defaultMap2To8 : var12_12;
lbl50:
                                // 3 sources

                                while (true) {
                                    var18_18 /* !! */  = var9_9 /* !! */ ;
                                    break block15;
                                    break;
                                }
                            }
                            var15_15 = 2;
                            if (var7_7 != var15_15) break block17;
                            if (var14_14 != null) break block18;
                            var9_9 /* !! */  = DvbParser.defaultMap2To4;
                            ** GOTO lbl50
                        }
                        var9_9 /* !! */  = var14_14;
                        ** continue;
                    }
                    var17_17 = 0;
                    var18_18 /* !! */  = null;
                }
                var9_9 /* !! */  = (byte[])var8_8;
                var10_10 = DvbParser.paint2BitPixelCodeString(var8_8, var1_1, var18_18 /* !! */ , var10_10, var11_11, var5_5, var6_6);
                var8_8.byteAlign();
                continue;
            }
            var11_11 += 2;
            var10_10 = var3_3;
        }
    }

    private static void paintPixelDataSubBlocks(DvbParser$ObjectData dvbParser$ObjectData, DvbParser$ClutDefinition object, int n10, int n11, int n12, Paint paint, Canvas canvas) {
        int n13 = 3;
        object = n10 == n13 ? (Object)((DvbParser$ClutDefinition)object).clutEntries8Bit : (n10 == (n13 = 2) ? (Object)((DvbParser$ClutDefinition)object).clutEntries4Bit : (Object)((DvbParser$ClutDefinition)object).clutEntries2Bit);
        byte[] byArray = dvbParser$ObjectData.topFieldData;
        int n14 = n12;
        DvbParser.paintPixelDataSubBlock(byArray, (int[])object, n10, n11, n12, paint, canvas);
        byArray = dvbParser$ObjectData.bottomFieldData;
        n14 = n12 + 1;
        DvbParser.paintPixelDataSubBlock(byArray, (int[])object, n10, n11, n14, paint, canvas);
    }

    private static DvbParser$ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray, int n10) {
        int n11;
        Object object = parsableBitArray;
        int n12 = 8;
        int n13 = parsableBitArray.readBits(n12);
        parsableBitArray.skipBits(n12);
        int n14 = 2;
        int n15 = n10 + -2;
        int[] nArray = DvbParser.generateDefault2BitClutEntries();
        int[] nArray2 = DvbParser.generateDefault4BitClutEntries();
        int[] nArray3 = DvbParser.generateDefault8BitClutEntries();
        while (n15 > 0) {
            int n16;
            int n17;
            int n18;
            int n19 = ((ParsableBitArray)object).readBits(n12);
            int n20 = ((ParsableBitArray)object).readBits(n12);
            n15 += -2;
            int n21 = n20 & 0x80;
            int[] nArray4 = n21 != 0 ? nArray : ((n21 = n20 & 0x40) != 0 ? nArray2 : nArray3);
            if ((n20 &= 1) != 0) {
                n20 = ((ParsableBitArray)object).readBits(n12);
                n18 = ((ParsableBitArray)object).readBits(n12);
                n17 = ((ParsableBitArray)object).readBits(n12);
                n16 = ((ParsableBitArray)object).readBits(n12);
                n15 += -4;
            } else {
                n18 = ((ParsableBitArray)object).readBits(6) << n14;
                n17 = 4;
                n16 = ((ParsableBitArray)object).readBits(n17) << n17;
                n17 = ((ParsableBitArray)object).readBits(n17) << 4;
                int n22 = ((ParsableBitArray)object).readBits(n14);
                n20 = n22 << 6;
                n15 += -2;
                int n23 = n16;
                n16 = n20;
                n20 = n18;
                n18 = n23;
            }
            int n24 = 255;
            if (n20 == 0) {
                n16 = n24;
                n18 = 0;
                n17 = 0;
            }
            n16 &= n24;
            n16 = (byte)(255 - n16);
            n10 = n15;
            double d10 = n20;
            n11 = n13;
            double d11 = n18 += -128;
            double d12 = 1.402 * d11;
            double d13 = d10 + d12;
            n20 = (int)d13;
            double d14 = n17 += -128;
            d12 = 0.34414 * d14;
            d12 = d10 - d12;
            double d15 = 0.71414;
            d11 *= d15;
            d11 = d12 - d11;
            n12 = (int)d11;
            d12 = 1.772;
            n13 = (int)(d10 += (d14 *= d12));
            n15 = 255;
            n20 = Util.constrainValue(n20, 0, n15);
            n12 = Util.constrainValue(n12, 0, n15);
            n13 = Util.constrainValue(n13, 0, n15);
            nArray4[n19] = n12 = DvbParser.getColor(n16, n20, n12, n13);
            n15 = n10;
            n13 = n11;
            n12 = 8;
            n14 = 2;
        }
        n11 = n13;
        n12 = n13;
        object = new DvbParser$ClutDefinition(n13, nArray, nArray2, nArray3);
        return object;
    }

    private static DvbParser$DisplayDefinition parseDisplayDefinition(ParsableBitArray object) {
        int n10;
        int n11;
        int n12;
        int n13;
        ((ParsableBitArray)object).skipBits(4);
        boolean n14 = ((ParsableBitArray)object).readBit();
        ((ParsableBitArray)object).skipBits(3);
        int n15 = 16;
        int n16 = ((ParsableBitArray)object).readBits(n15);
        int n17 = ((ParsableBitArray)object).readBits(n15);
        int n18 = 0;
        if (n14) {
            int n19;
            int n20 = ((ParsableBitArray)object).readBits(n15);
            n18 = ((ParsableBitArray)object).readBits(n15);
            n13 = ((ParsableBitArray)object).readBits(n15);
            n12 = n19 = ((ParsableBitArray)object).readBits(n15);
            n11 = n18;
            n10 = n13;
            n13 = n20;
        } else {
            n13 = 0;
            n10 = 0;
            n11 = n16;
            n12 = n17;
        }
        object = new DvbParser$DisplayDefinition(n16, n17, n13, n11, n10, n12);
        return object;
    }

    /*
     * Unable to fully structure code
     */
    private static DvbParser$ObjectData parseObjectData(ParsableBitArray var0) {
        block3: {
            var1_1 = 16;
            var2_2 = var0.readBits(var1_1);
            var0.skipBits(4);
            var3_3 = var0.readBits(2);
            var4_4 = var0.readBit();
            var5_5 = 1;
            var0.skipBits(var5_5);
            var6_6 = Util.EMPTY_BYTE_ARRAY;
            if (var3_3 != var5_5) break block3;
            var3_3 = var0.readBits(8) * var1_1;
            var0.skipBits(var3_3);
            ** GOTO lbl-1000
        }
        if (var3_3 != 0) ** GOTO lbl-1000
        var3_3 = var0.readBits(var1_1);
        var1_1 = var0.readBits(var1_1);
        var5_5 = 0;
        if (var3_3 > 0) {
            var6_6 = new byte[var3_3];
            var0.readBytes(var6_6, 0, var3_3);
        }
        if (var1_1 > 0) {
            var7_7 = new byte[var1_1];
            var0.readBytes(var7_7, 0, var1_1);
        } else lbl-1000:
        // 3 sources

        {
            var7_7 = var6_6;
        }
        var0 = new DvbParser$ObjectData(var2_2, var4_4, var6_6, var7_7);
        return var0;
    }

    private static DvbParser$PageComposition parsePageComposition(ParsableBitArray object, int n10) {
        int n11 = 8;
        int n12 = ((ParsableBitArray)object).readBits(n11);
        int n13 = ((ParsableBitArray)object).readBits(4);
        int n14 = 2;
        int n15 = ((ParsableBitArray)object).readBits(n14);
        ((ParsableBitArray)object).skipBits(n14);
        n10 -= n14;
        SparseArray sparseArray = new SparseArray();
        while (n10 > 0) {
            int n16 = ((ParsableBitArray)object).readBits(n11);
            ((ParsableBitArray)object).skipBits(n11);
            int n17 = 16;
            int n18 = ((ParsableBitArray)object).readBits(n17);
            n17 = ((ParsableBitArray)object).readBits(n17);
            n10 += -6;
            DvbParser$PageRegion dvbParser$PageRegion = new DvbParser$PageRegion(n18, n17);
            sparseArray.put(n16, (Object)dvbParser$PageRegion);
        }
        object = new DvbParser$PageComposition(n12, n13, n15, sparseArray);
        return object;
    }

    private static DvbParser$RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray, int n10) {
        int n11;
        Object object = parsableBitArray;
        int n12 = 8;
        int n13 = parsableBitArray.readBits(n12);
        int n14 = 4;
        parsableBitArray.skipBits(n14);
        boolean bl2 = parsableBitArray.readBit();
        int n15 = 3;
        parsableBitArray.skipBits(n15);
        int n16 = 16;
        int n17 = parsableBitArray.readBits(n16);
        int n18 = parsableBitArray.readBits(n16);
        int n19 = parsableBitArray.readBits(n15);
        int n20 = parsableBitArray.readBits(n15);
        n15 = 2;
        parsableBitArray.skipBits(n15);
        int n21 = parsableBitArray.readBits(n12);
        int n22 = parsableBitArray.readBits(n12);
        int n23 = parsableBitArray.readBits(n14);
        int n24 = parsableBitArray.readBits(n15);
        parsableBitArray.skipBits(n15);
        int n25 = n10 + -10;
        SparseArray sparseArray = new SparseArray();
        while (n25 > 0) {
            int n26;
            int n27;
            n14 = ((ParsableBitArray)object).readBits(n16);
            n16 = ((ParsableBitArray)object).readBits(n15);
            int n28 = ((ParsableBitArray)object).readBits(n15);
            n15 = 12;
            int n29 = ((ParsableBitArray)object).readBits(n15);
            n11 = n24;
            n24 = 4;
            ((ParsableBitArray)object).skipBits(n24);
            int n30 = ((ParsableBitArray)object).readBits(n15);
            n25 += -6;
            n15 = 1;
            int n31 = 0;
            if (n16 != n15 && n16 != (n15 = 2)) {
                n27 = 0;
                n26 = 0;
            } else {
                n15 = 8;
                int n32 = ((ParsableBitArray)object).readBits(n15);
                n31 = ((ParsableBitArray)object).readBits(n15);
                n25 += -2;
                n27 = n32;
                n26 = n31;
            }
            DvbParser$RegionObject dvbParser$RegionObject = new DvbParser$RegionObject(n16, n28, n29, n30, n27, n26);
            sparseArray.put(n14, (Object)dvbParser$RegionObject);
            n14 = n24;
            n24 = n11;
            n15 = 2;
            n16 = 16;
        }
        n11 = n24;
        n15 = n17;
        n16 = n18;
        n17 = n19;
        n18 = n20;
        n19 = n21;
        n20 = n22;
        n21 = n23;
        n22 = n24;
        object = new DvbParser$RegionComposition(n13, bl2, n15, n16, n17, n18, n19, n20, n23, n24, sparseArray);
        return object;
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray, DvbParser$SubtitleService dvbParser$SubtitleService) {
        int n10 = parsableBitArray.readBits(8);
        int n11 = 16;
        int n12 = parsableBitArray.readBits(n11);
        n11 = parsableBitArray.readBits(n11);
        int n13 = parsableBitArray.getBytePosition() + n11;
        int n14 = n11 * 8;
        int n15 = parsableBitArray.bitsLeft();
        if (n14 > n15) {
            Log.w(TAG, "Data field length exceeds limit");
            int n16 = parsableBitArray.bitsLeft();
            parsableBitArray.skipBits(n16);
            return;
        }
        switch (n10) {
            default: {
                break;
            }
            case 20: {
                DvbParser$DisplayDefinition dvbParser$DisplayDefinition;
                n10 = dvbParser$SubtitleService.subtitlePageId;
                if (n12 != n10) break;
                dvbParser$SubtitleService.displayDefinition = dvbParser$DisplayDefinition = DvbParser.parseDisplayDefinition(parsableBitArray);
                break;
            }
            case 19: {
                n10 = dvbParser$SubtitleService.subtitlePageId;
                if (n12 == n10) {
                    DvbParser$ObjectData dvbParser$ObjectData = DvbParser.parseObjectData(parsableBitArray);
                    dvbParser$SubtitleService = dvbParser$SubtitleService.objects;
                    n11 = dvbParser$ObjectData.id;
                    dvbParser$SubtitleService.put(n11, dvbParser$ObjectData);
                    break;
                }
                n10 = dvbParser$SubtitleService.ancillaryPageId;
                if (n12 != n10) break;
                DvbParser$ObjectData dvbParser$ObjectData = DvbParser.parseObjectData(parsableBitArray);
                dvbParser$SubtitleService = dvbParser$SubtitleService.ancillaryObjects;
                n11 = dvbParser$ObjectData.id;
                dvbParser$SubtitleService.put(n11, dvbParser$ObjectData);
                break;
            }
            case 18: {
                n10 = dvbParser$SubtitleService.subtitlePageId;
                if (n12 == n10) {
                    DvbParser$ClutDefinition dvbParser$ClutDefinition = DvbParser.parseClutDefinition(parsableBitArray, n11);
                    dvbParser$SubtitleService = dvbParser$SubtitleService.cluts;
                    n11 = dvbParser$ClutDefinition.id;
                    dvbParser$SubtitleService.put(n11, dvbParser$ClutDefinition);
                    break;
                }
                n10 = dvbParser$SubtitleService.ancillaryPageId;
                if (n12 != n10) break;
                DvbParser$ClutDefinition dvbParser$ClutDefinition = DvbParser.parseClutDefinition(parsableBitArray, n11);
                dvbParser$SubtitleService = dvbParser$SubtitleService.ancillaryCluts;
                n11 = dvbParser$ClutDefinition.id;
                dvbParser$SubtitleService.put(n11, dvbParser$ClutDefinition);
                break;
            }
            case 17: {
                Object object = dvbParser$SubtitleService.pageComposition;
                n14 = dvbParser$SubtitleService.subtitlePageId;
                if (n12 != n14 || object == null) break;
                DvbParser$RegionComposition dvbParser$RegionComposition = DvbParser.parseRegionComposition(parsableBitArray, n11);
                n10 = ((DvbParser$PageComposition)object).state;
                if (n10 == 0) {
                    object = dvbParser$SubtitleService.regions;
                    n12 = dvbParser$RegionComposition.id;
                    if ((object = (DvbParser$RegionComposition)object.get(n12)) != null) {
                        dvbParser$RegionComposition.mergeFrom((DvbParser$RegionComposition)object);
                    }
                }
                dvbParser$SubtitleService = dvbParser$SubtitleService.regions;
                n10 = dvbParser$RegionComposition.id;
                dvbParser$SubtitleService.put(n10, dvbParser$RegionComposition);
                break;
            }
            case 16: {
                n10 = dvbParser$SubtitleService.subtitlePageId;
                if (n12 != n10) break;
                DvbParser$PageComposition dvbParser$PageComposition = dvbParser$SubtitleService.pageComposition;
                DvbParser$PageComposition dvbParser$PageComposition2 = DvbParser.parsePageComposition(parsableBitArray, n11);
                n12 = dvbParser$PageComposition2.state;
                if (n12 != 0) {
                    dvbParser$SubtitleService.pageComposition = dvbParser$PageComposition2;
                    dvbParser$SubtitleService.regions.clear();
                    dvbParser$PageComposition = dvbParser$SubtitleService.cluts;
                    dvbParser$PageComposition.clear();
                    dvbParser$SubtitleService = dvbParser$SubtitleService.objects;
                    dvbParser$SubtitleService.clear();
                    break;
                }
                if (dvbParser$PageComposition == null || (n10 = dvbParser$PageComposition.version) == (n12 = dvbParser$PageComposition2.version)) break;
                dvbParser$SubtitleService.pageComposition = dvbParser$PageComposition2;
            }
        }
        int n17 = parsableBitArray.getBytePosition();
        parsableBitArray.skipBytes(n13 -= n17);
    }

    public List decode(byte[] byArray, int n10) {
        int n11;
        Bitmap.Config config;
        Bitmap bitmap;
        int n12;
        int n13;
        DvbParser dvbParser = this;
        Object object = byArray;
        int n14 = n10;
        Object object2 = new ParsableBitArray(byArray, n10);
        while ((n13 = ((ParsableBitArray)object2).bitsLeft()) >= (n14 = 48) && (n13 = ((ParsableBitArray)object2).readBits(8)) == (n14 = 15)) {
            object = dvbParser.subtitleService;
            DvbParser.parseSubtitlingSegment((ParsableBitArray)object2, (DvbParser$SubtitleService)object);
        }
        object2 = dvbParser.subtitleService;
        object = ((DvbParser$SubtitleService)object2).pageComposition;
        if (object == null) {
            return Collections.emptyList();
        }
        object2 = ((DvbParser$SubtitleService)object2).displayDefinition;
        if (object2 == null) {
            object2 = dvbParser.defaultDisplayDefinition;
        }
        Object object3 = dvbParser.bitmap;
        if (object3 == null || (n12 = ((DvbParser$DisplayDefinition)object2).width + 1) != (n14 = object3.getWidth()) || (n14 = ((DvbParser$DisplayDefinition)object2).height + 1) != (n12 = (bitmap = dvbParser.bitmap).getHeight())) {
            n14 = ((DvbParser$DisplayDefinition)object2).width + 1;
            n12 = ((DvbParser$DisplayDefinition)object2).height + 1;
            config = Bitmap.Config.ARGB_8888;
            object3 = Bitmap.createBitmap((int)n14, (int)n12, (Bitmap.Config)config);
            dvbParser.bitmap = object3;
            bitmap = dvbParser.canvas;
            bitmap.setBitmap((Bitmap)object3);
        }
        object3 = new ArrayList();
        object = object.regions;
        n12 = 0;
        bitmap = null;
        config = null;
        for (int i10 = 0; i10 < (n11 = object.size()); ++i10) {
            float f10;
            int n15;
            Object object4;
            dvbParser.canvas.save();
            Object object5 = (DvbParser$PageRegion)object.valueAt(i10);
            int n16 = object.keyAt(i10);
            Object object6 = dvbParser.subtitleService.regions;
            DvbParser$RegionComposition dvbParser$RegionComposition = (DvbParser$RegionComposition)object6.get(n16);
            int n17 = ((DvbParser$PageRegion)object5).horizontalAddress;
            Object object7 = ((DvbParser$DisplayDefinition)object2).horizontalPositionMinimum;
            n17 += object7;
            n11 = ((DvbParser$PageRegion)object5).verticalAddress;
            object7 = ((DvbParser$DisplayDefinition)object2).verticalPositionMinimum;
            n11 += object7;
            object7 = dvbParser$RegionComposition.width + n17;
            int n18 = ((DvbParser$DisplayDefinition)object2).horizontalPositionMaximum;
            object7 = Math.min(object7, n18);
            n18 = dvbParser$RegionComposition.height + n11;
            int n19 = ((DvbParser$DisplayDefinition)object2).verticalPositionMaximum;
            n18 = Math.min(n18, n19);
            Object object8 = dvbParser.canvas;
            object8.clipRect(n17, n11, object7, n18);
            Object object9 = dvbParser.subtitleService.cluts;
            n18 = dvbParser$RegionComposition.clutId;
            object9 = (DvbParser$ClutDefinition)object9.get(n18);
            if (object9 == null) {
                object9 = dvbParser.subtitleService.ancillaryCluts;
                n18 = dvbParser$RegionComposition.clutId;
                if ((object9 = (DvbParser$ClutDefinition)object9.get(n18)) == null) {
                    object9 = dvbParser.defaultClutDefinition;
                }
            }
            Object object10 = dvbParser$RegionComposition.regionObjects;
            int n20 = 0;
            float f11 = 0.0f;
            while (n20 < (n18 = object10.size())) {
                SparseArray sparseArray;
                int n21;
                n18 = object10.keyAt(n20);
                object8 = (DvbParser$RegionObject)object10.valueAt(n20);
                DvbParser$ObjectData dvbParser$ObjectData = (DvbParser$ObjectData)dvbParser.subtitleService.objects.get(n18);
                if (dvbParser$ObjectData == null) {
                    dvbParser$ObjectData = dvbParser.subtitleService.ancillaryObjects;
                    object4 = (DvbParser$ObjectData)dvbParser$ObjectData.get(n18);
                } else {
                    object4 = dvbParser$ObjectData;
                }
                if (object4 != null) {
                    n15 = (int)(object4.nonModifyingColorFlag ? 1 : 0);
                    if (n15 != 0) {
                        n15 = 0;
                        f10 = 0.0f;
                        dvbParser$ObjectData = null;
                    } else {
                        dvbParser$ObjectData = dvbParser.defaultPaint;
                    }
                    n15 = dvbParser$RegionComposition.depth;
                    int n22 = object8.horizontalPosition + n17;
                    n19 = object8.verticalPosition;
                    int n23 = n11 + n19;
                    Canvas canvas = dvbParser.canvas;
                    object8 = object9;
                    n21 = n20;
                    n20 = n23;
                    sparseArray = object10;
                    object10 = dvbParser$ObjectData;
                    DvbParser.paintPixelDataSubBlocks((DvbParser$ObjectData)object4, (DvbParser$ClutDefinition)object9, n15, n22, n23, (Paint)dvbParser$ObjectData, canvas);
                } else {
                    n21 = n20;
                    sparseArray = object10;
                }
                n20 = n21 + 1;
                object10 = sparseArray;
            }
            n18 = (int)(dvbParser$RegionComposition.fillFlag ? 1 : 0);
            if (n18 != 0) {
                n18 = dvbParser$RegionComposition.depth;
                n19 = 3;
                if (n18 == n19) {
                    object9 = ((DvbParser$ClutDefinition)object9).clutEntries8Bit;
                    n18 = dvbParser$RegionComposition.pixelCode8Bit;
                    object7 = object9[n18];
                } else {
                    n19 = 2;
                    if (n18 == n19) {
                        object9 = ((DvbParser$ClutDefinition)object9).clutEntries4Bit;
                        n18 = dvbParser$RegionComposition.pixelCode4Bit;
                        object7 = object9[n18];
                    } else {
                        object9 = ((DvbParser$ClutDefinition)object9).clutEntries2Bit;
                        n18 = dvbParser$RegionComposition.pixelCode2Bit;
                        object7 = object9[n18];
                    }
                }
                object4 = dvbParser.fillRegionPaint;
                object4.setColor(object7);
                object8 = dvbParser.canvas;
                f10 = n17;
                float f12 = n11;
                f11 = dvbParser$RegionComposition.width + n17;
                object7 = dvbParser$RegionComposition.height + n11;
                float f13 = object7;
                object9 = dvbParser.fillRegionPaint;
                object8.drawRect(f10, f12, f11, f13, (Paint)object9);
            }
            object9 = new Cue$Builder();
            object4 = dvbParser.bitmap;
            n19 = dvbParser$RegionComposition.width;
            n15 = dvbParser$RegionComposition.height;
            object4 = Bitmap.createBitmap((Bitmap)object4, (int)n17, (int)n11, (int)n19, (int)n15);
            object9 = ((Cue$Builder)object9).setBitmap((Bitmap)object4);
            float f14 = n17;
            n18 = ((DvbParser$DisplayDefinition)object2).width;
            float f15 = n18;
            object6 = ((Cue$Builder)object9).setPosition(f14 /= f15).setPositionAnchor(0);
            float f16 = n11;
            float f17 = ((DvbParser$DisplayDefinition)object2).height;
            object5 = ((Cue$Builder)object6).setLine(f16 /= f17, 0).setLineAnchor(0);
            f14 = dvbParser$RegionComposition.width;
            object7 = ((DvbParser$DisplayDefinition)object2).width;
            f17 = object7;
            object5 = ((Cue$Builder)object5).setSize(f14 /= f17);
            n16 = dvbParser$RegionComposition.height;
            float f18 = n16;
            n17 = ((DvbParser$DisplayDefinition)object2).height;
            f14 = n17;
            object5 = ((Cue$Builder)object5).setBitmapHeight(f18 /= f14).build();
            object3.add(object5);
            object5 = dvbParser.canvas;
            dvbParser$RegionComposition = PorterDuff.Mode.CLEAR;
            object5.drawColor(0, (PorterDuff.Mode)dvbParser$RegionComposition);
            object5 = dvbParser.canvas;
            object5.restore();
        }
        return Collections.unmodifiableList(object3);
    }

    public void reset() {
        this.subtitleService.reset();
    }
}

