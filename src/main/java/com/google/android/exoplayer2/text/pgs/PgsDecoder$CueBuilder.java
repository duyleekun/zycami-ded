/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PgsDecoder$CueBuilder {
    private final ParsableByteArray bitmapData;
    private int bitmapHeight;
    private int bitmapWidth;
    private int bitmapX;
    private int bitmapY;
    private final int[] colors;
    private boolean colorsSet;
    private int planeHeight;
    private int planeWidth;

    public PgsDecoder$CueBuilder() {
        Object object = new ParsableByteArray();
        this.bitmapData = object;
        object = new int[256];
        this.colors = (int[])object;
    }

    public static /* synthetic */ void access$000(PgsDecoder$CueBuilder pgsDecoder$CueBuilder, ParsableByteArray parsableByteArray, int n10) {
        pgsDecoder$CueBuilder.parsePaletteSection(parsableByteArray, n10);
    }

    public static /* synthetic */ void access$100(PgsDecoder$CueBuilder pgsDecoder$CueBuilder, ParsableByteArray parsableByteArray, int n10) {
        pgsDecoder$CueBuilder.parseBitmapSection(parsableByteArray, n10);
    }

    public static /* synthetic */ void access$200(PgsDecoder$CueBuilder pgsDecoder$CueBuilder, ParsableByteArray parsableByteArray, int n10) {
        pgsDecoder$CueBuilder.parseIdentifierSection(parsableByteArray, n10);
    }

    private void parseBitmapSection(ParsableByteArray parsableByteArray, int n10) {
        ParsableByteArray parsableByteArray2;
        Object object;
        int n11 = 4;
        if (n10 < n11) {
            return;
        }
        parsableByteArray.skipBytes(3);
        int n12 = parsableByteArray.readUnsignedByte() & 0x80;
        if (n12 != 0) {
            n12 = 1;
        } else {
            n12 = 0;
            object = null;
        }
        n10 += -4;
        if (n12 != 0) {
            int n13;
            n12 = 7;
            if (n10 < n12) {
                return;
            }
            n12 = parsableByteArray.readUnsignedInt24();
            if (n12 < n11) {
                return;
            }
            this.bitmapWidth = n13 = parsableByteArray.readUnsignedShort();
            this.bitmapHeight = n13 = parsableByteArray.readUnsignedShort();
            ParsableByteArray parsableByteArray3 = this.bitmapData;
            parsableByteArray3.reset(n12 -= n11);
            n10 += -7;
        }
        if ((n11 = (parsableByteArray2 = this.bitmapData).getPosition()) < (n12 = ((ParsableByteArray)(object = this.bitmapData)).limit()) && n10 > 0) {
            n10 = Math.min(n10, n12 -= n11);
            object = this.bitmapData.getData();
            parsableByteArray.readBytes((byte[])object, n11, n10);
            parsableByteArray = this.bitmapData;
            parsableByteArray.setPosition(n11 += n10);
        }
    }

    private void parseIdentifierSection(ParsableByteArray parsableByteArray, int n10) {
        int n11;
        int n12 = 19;
        if (n10 < n12) {
            return;
        }
        this.planeWidth = n10 = parsableByteArray.readUnsignedShort();
        this.planeHeight = n10 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(11);
        this.bitmapX = n10 = parsableByteArray.readUnsignedShort();
        this.bitmapY = n11 = parsableByteArray.readUnsignedShort();
    }

    private void parsePaletteSection(ParsableByteArray parsableByteArray, int n10) {
        PgsDecoder$CueBuilder pgsDecoder$CueBuilder = this;
        int n11 = n10 % 5;
        int n12 = 2;
        if (n11 != n12) {
            return;
        }
        parsableByteArray.skipBytes(n12);
        int[] nArray = this.colors;
        int n13 = 0;
        Arrays.fill(nArray, 0);
        n12 = n10 / 5;
        int n14 = 0;
        int[] nArray2 = null;
        while (n14 < n12) {
            int n15 = parsableByteArray.readUnsignedByte();
            int n16 = parsableByteArray.readUnsignedByte();
            int n17 = parsableByteArray.readUnsignedByte();
            int n18 = parsableByteArray.readUnsignedByte();
            int n19 = parsableByteArray.readUnsignedByte();
            double d10 = n16;
            double d11 = n17 + -128;
            double d12 = 1.402 * d11 + d10;
            int n20 = (int)d12;
            n10 = n14++;
            double d13 = n18 += -128;
            double d14 = 0.34414 * d13;
            d14 = d10 - d14;
            double d15 = 0.71414;
            n16 = (int)(d14 -= (d11 *= d15));
            double d16 = 1.772;
            n13 = (int)(d10 += (d13 *= d16));
            nArray2 = pgsDecoder$CueBuilder.colors;
            n17 = n19 << 24;
            n18 = 255;
            n19 = 0;
            int n21 = Util.constrainValue(n20, 0, n18) << 16;
            n16 = Util.constrainValue(n16, 0, n18) << 8 | (n17 |= n21);
            nArray2[n15] = n13 = Util.constrainValue(n13, 0, n18) | n16;
            n13 = 0;
        }
        pgsDecoder$CueBuilder.colorsSet = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Cue build() {
        ParsableByteArray parsableByteArray;
        int n10;
        int n11 = this.planeWidth;
        if (n11 == 0) return null;
        n11 = this.planeHeight;
        if (n11 == 0) return null;
        n11 = this.bitmapWidth;
        if (n11 == 0) return null;
        n11 = this.bitmapHeight;
        if (n11 == 0) return null;
        Object object = this.bitmapData;
        n11 = ((ParsableByteArray)object).limit();
        if (n11 == 0) return null;
        object = this.bitmapData;
        n11 = ((ParsableByteArray)object).getPosition();
        if (n11 != (n10 = (parsableByteArray = this.bitmapData).limit())) return null;
        n11 = (int)(this.colorsSet ? 1 : 0);
        if (n11 == 0) {
            return null;
        }
        object = this.bitmapData;
        n10 = 0;
        float f10 = 0.0f;
        parsableByteArray = null;
        ((ParsableByteArray)object).setPosition(0);
        n11 = this.bitmapWidth;
        int n12 = this.bitmapHeight;
        Object object2 = new int[n11 *= n12];
        int n13 = 0;
        float f11 = 0.0f;
        while (true) {
            Object object3;
            int n14;
            Object object4;
            if (n13 >= n11) {
                n11 = this.bitmapWidth;
                n13 = this.bitmapHeight;
                object4 = Bitmap.Config.ARGB_8888;
                object = Bitmap.createBitmap((int[])object2, (int)n11, (int)n13, (Bitmap.Config)object4);
                object2 = new Cue$Builder;
                ((Cue$Builder)object2)();
                object = ((Cue$Builder)object2).setBitmap((Bitmap)object);
                float f12 = this.bitmapX;
                f11 = this.planeWidth;
                object = ((Cue$Builder)object).setPosition(f12 /= f11).setPositionAnchor(0);
                f12 = this.bitmapY;
                f11 = this.planeHeight;
                object = ((Cue$Builder)object).setLine(f12 /= f11, 0).setLineAnchor(0);
                f10 = this.bitmapWidth;
                f12 = this.planeWidth;
                object = ((Cue$Builder)object).setSize(f10 /= f12);
                f10 = this.bitmapHeight;
                f12 = this.planeHeight;
                return ((Cue$Builder)object).setBitmapHeight(f10 /= f12).build();
            }
            object4 = this.bitmapData;
            Object object5 = ((ParsableByteArray)object4).readUnsignedByte();
            if (object5 != 0) {
                n14 = n13 + 1;
                object3 = this.colors;
                object5 = object3[object5];
                object2[n13] = object5;
            } else {
                int n15;
                object4 = this.bitmapData;
                object5 = ((ParsableByteArray)object4).readUnsignedByte();
                if (object5 == 0) continue;
                n14 = object5 & 0x40;
                if (n14 == 0) {
                    n14 = object5 & 0x3F;
                } else {
                    n14 = (object5 & 0x3F) << 8;
                    object3 = this.bitmapData;
                    n15 = ((ParsableByteArray)object3).readUnsignedByte();
                    n14 |= n15;
                }
                if ((object5 &= 0x80) == 0) {
                    object5 = 0;
                    object4 = null;
                } else {
                    object4 = this.colors;
                    object3 = this.bitmapData;
                    n15 = ((ParsableByteArray)object3).readUnsignedByte();
                    object5 = object4[n15];
                }
                Arrays.fill((int[])object2, n13, n14 += n13, object5);
            }
            n13 = n14;
        }
    }

    public void reset() {
        this.planeWidth = 0;
        this.planeHeight = 0;
        this.bitmapX = 0;
        this.bitmapY = 0;
        this.bitmapWidth = 0;
        this.bitmapHeight = 0;
        this.bitmapData.reset(0);
        this.colorsSet = false;
    }
}

