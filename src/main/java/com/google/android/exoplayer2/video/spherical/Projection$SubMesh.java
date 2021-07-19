/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;

public final class Projection$SubMesh {
    public static final int VIDEO_TEXTURE_ID;
    public final int mode;
    public final float[] textureCoords;
    public final int textureId;
    public final float[] vertices;

    public Projection$SubMesh(int n10, float[] fArray, float[] fArray2, int n11) {
        this.textureId = n10;
        long l10 = (long)fArray.length * (long)2;
        long l11 = fArray2.length;
        long l12 = 3;
        long l13 = l10 - (l11 *= l12);
        n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        n10 = n10 == 0 ? 1 : 0;
        Assertions.checkArgument(n10 != 0);
        this.vertices = fArray;
        this.textureCoords = fArray2;
        this.mode = n11;
    }

    public int getVertexCount() {
        return this.vertices.length / 3;
    }
}

