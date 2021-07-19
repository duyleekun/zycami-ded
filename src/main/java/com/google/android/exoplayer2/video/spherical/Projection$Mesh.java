/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;

public final class Projection$Mesh {
    private final Projection$SubMesh[] subMeshes;

    public Projection$Mesh(Projection$SubMesh ... projection$SubMeshArray) {
        this.subMeshes = projection$SubMeshArray;
    }

    public Projection$SubMesh getSubMesh(int n10) {
        return this.subMeshes[n10];
    }

    public int getSubMeshCount() {
        return this.subMeshes.length;
    }
}

