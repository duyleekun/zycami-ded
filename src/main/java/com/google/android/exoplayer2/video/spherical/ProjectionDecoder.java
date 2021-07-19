/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.spherical.Projection;
import com.google.android.exoplayer2.video.spherical.Projection$Mesh;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;
import java.util.ArrayList;
import java.util.zip.Inflater;

public final class ProjectionDecoder {
    private static final int MAX_COORDINATE_COUNT = 10000;
    private static final int MAX_TRIANGLE_INDICES = 128000;
    private static final int MAX_VERTEX_COUNT = 32000;
    private static final int TYPE_DFL8 = 1684433976;
    private static final int TYPE_MESH = 1835365224;
    private static final int TYPE_MSHP = 1836279920;
    private static final int TYPE_PROJ = 1886547818;
    private static final int TYPE_RAW = 1918990112;
    private static final int TYPE_YTMP = 2037673328;

    private ProjectionDecoder() {
    }

    public static Projection decode(byte[] object, int n10) {
        int n11;
        int n12;
        Object object2;
        block7: {
            object2 = new ParsableByteArray((byte[])object);
            object = null;
            n12 = ProjectionDecoder.isProj((ParsableByteArray)object2);
            if (n12 == 0) break block7;
            object2 = ProjectionDecoder.parseProj((ParsableByteArray)object2);
        }
        try {
            object2 = ProjectionDecoder.parseMshp((ParsableByteArray)object2);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            object2 = null;
        }
        if (object2 == null) {
            return null;
        }
        n12 = ((ArrayList)object2).size();
        if (n12 != (n11 = 1)) {
            int n13 = 2;
            if (n12 != n13) {
                return null;
            }
            object = new Projection;
            Projection$Mesh projection$Mesh = (Projection$Mesh)((ArrayList)object2).get(0);
            object2 = (Projection$Mesh)((ArrayList)object2).get(n11);
            object(projection$Mesh, (Projection$Mesh)object2, n10);
            return object;
        }
        object = new Projection;
        object2 = (Projection$Mesh)((ArrayList)object2).get(0);
        object((Projection$Mesh)object2, n10);
        return object;
    }

    private static int decodeZigZag(int n10) {
        int n11 = n10 >> 1;
        return -(n10 & 1) ^ n11;
    }

    private static boolean isProj(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        int n10 = parsableByteArray.readInt();
        boolean bl2 = false;
        parsableByteArray.setPosition(0);
        int n11 = 1886547818;
        if (n10 == n11) {
            bl2 = true;
        }
        return bl2;
    }

    private static Projection$Mesh parseMesh(ParsableByteArray parsableByteArray) {
        Object object;
        Projection$SubMesh[] projection$SubMeshArray;
        int n10;
        float f10;
        int n11;
        int n12;
        int n13 = parsableByteArray.readInt();
        if (n13 > (n12 = 10000)) {
            return null;
        }
        float[] fArray = new float[n13];
        for (n11 = 0; n11 < n13; ++n11) {
            fArray[n11] = f10 = parsableByteArray.readFloat();
        }
        n11 = parsableByteArray.readInt();
        int n14 = 32000;
        f10 = 4.4842E-41f;
        if (n11 > n14) {
            return null;
        }
        double d10 = 2.0;
        double d11 = Math.log(d10);
        double d12 = Math.ceil(Math.log((double)n13 * d10) / d11);
        int n15 = (int)d12;
        Object[] objectArray = parsableByteArray.getData();
        ParsableBitArray parsableBitArray = new ParsableBitArray((byte[])objectArray);
        int n16 = parsableByteArray.getPosition();
        int n17 = 8;
        parsableBitArray.setPosition(n16 *= n17);
        n16 = n11 * 5;
        objectArray = new float[n16];
        int n18 = 5;
        int[] nArray = new int[n18];
        int n19 = 0;
        for (n10 = 0; n10 < n11; ++n10) {
            projection$SubMeshArray = null;
            for (int i10 = 0; i10 < n18; ++i10) {
                int n20 = nArray[i10];
                int n21 = ProjectionDecoder.decodeZigZag(parsableBitArray.readBits(n15));
                n18 = n20 + n21;
                if (n18 < n13 && n18 >= 0) {
                    n20 = n19 + 1;
                    float f11 = fArray[n18];
                    objectArray[n19] = (byte)f11;
                    nArray[i10] = n18;
                    n19 = n20;
                    n18 = 5;
                    continue;
                }
                return null;
            }
            n18 = 5;
        }
        n13 = parsableBitArray.getPosition() + 7 & 0xFFFFFFF8;
        parsableBitArray.setPosition(n13);
        n13 = 32;
        n12 = parsableBitArray.readBits(n13);
        projection$SubMeshArray = new Projection$SubMesh[n12];
        for (n15 = 0; n15 < n12; ++n15) {
            n18 = parsableBitArray.readBits(n17);
            int n22 = parsableBitArray.readBits(n17);
            n10 = parsableBitArray.readBits(n13);
            if (n10 > (n13 = 128000)) {
                return null;
            }
            n19 = n18;
            double d13 = Math.ceil(Math.log((double)n11 * d10) / d11);
            n17 = (int)d13;
            n18 = n10 * 3;
            float[] fArray2 = new float[n18];
            n13 = n10 * 2;
            object = new float[n13];
            f10 = 0.0f;
            Projection$SubMesh projection$SubMesh = null;
            int n23 = 0;
            for (n14 = 0; n14 < n10; ++n14) {
                int n24 = ProjectionDecoder.decodeZigZag(parsableBitArray.readBits(n17));
                if ((n23 += n24) >= 0 && n23 < n11) {
                    n24 = n14 * 3;
                    int n25 = n23 * 5;
                    byte by2 = objectArray[n25];
                    fArray2[n24] = by2;
                    int n26 = n24 + 1;
                    int n27 = n25 + 1;
                    byte by3 = objectArray[n27];
                    fArray2[n26] = by3;
                    n26 = n25 + 2;
                    by2 = objectArray[n26];
                    fArray2[n24 += 2] = by2;
                    n24 = n14 * 2;
                    n26 = n25 + 3;
                    by2 = objectArray[n26];
                    object[n24] = by2;
                    byte by4 = objectArray[n25 += 4];
                    object[++n24] = by4;
                    continue;
                }
                return null;
            }
            n23 = n19;
            projection$SubMeshArray[n15] = projection$SubMesh = new Projection$SubMesh(n19, fArray2, (float[])object, n22);
            n13 = 32;
            d10 = 2.0;
            n17 = 8;
        }
        object = new Projection$Mesh(projection$SubMeshArray);
        return object;
    }

    private static ArrayList parseMshp(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.readUnsignedByte();
        if (n10 != 0) {
            return null;
        }
        parsableByteArray.skipBytes(7);
        n10 = parsableByteArray.readInt();
        int n11 = 1684433976;
        if (n10 == n11) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            boolean bl2 = true;
            Inflater inflater = new Inflater(bl2);
            try {
                boolean bl3 = Util.inflate(parsableByteArray, parsableByteArray2, inflater);
                if (!bl3) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            }
            catch (Throwable throwable) {
                inflater.end();
                throw throwable;
            }
        } else {
            n11 = 1918990112;
            if (n10 != n11) {
                return null;
            }
        }
        return ProjectionDecoder.parseRawMshpData(parsableByteArray);
    }

    private static ArrayList parseProj(ParsableByteArray parsableByteArray) {
        block1: {
            int n10;
            parsableByteArray.skipBytes(8);
            int n11 = parsableByteArray.getPosition();
            int n12 = parsableByteArray.limit();
            while (true) {
                int n13 = 0;
                if (n11 >= n12 || (n10 = parsableByteArray.readInt() + n11) <= n11 || n10 > n12) break block1;
                n11 = parsableByteArray.readInt();
                if (n11 == (n13 = 2037673328) || n11 == (n13 = 1836279920)) break;
                parsableByteArray.setPosition(n10);
                n11 = n10;
            }
            parsableByteArray.setLimit(n10);
            return ProjectionDecoder.parseMshp(parsableByteArray);
        }
        return null;
    }

    private static ArrayList parseRawMshpData(ParsableByteArray parsableByteArray) {
        ArrayList<Projection$Mesh> arrayList = new ArrayList<Projection$Mesh>();
        int n10 = parsableByteArray.getPosition();
        int n11 = parsableByteArray.limit();
        while (n10 < n11) {
            int n12 = parsableByteArray.readInt() + n10;
            if (n12 > n10 && n12 <= n11) {
                int n13;
                n10 = parsableByteArray.readInt();
                if (n10 == (n13 = 1835365224)) {
                    Projection$Mesh projection$Mesh = ProjectionDecoder.parseMesh(parsableByteArray);
                    if (projection$Mesh == null) {
                        return null;
                    }
                    arrayList.add(projection$Mesh);
                }
                parsableByteArray.setPosition(n12);
                n10 = n12;
                continue;
            }
            return null;
        }
        return arrayList;
    }
}

