/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui.spherical;

import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;
import java.nio.FloatBuffer;

public class ProjectionRenderer$MeshData {
    private final int drawMode;
    private final FloatBuffer textureBuffer;
    private final FloatBuffer vertexBuffer;
    private final int vertexCount;

    public ProjectionRenderer$MeshData(Projection$SubMesh projection$SubMesh) {
        FloatBuffer floatBuffer;
        int n10;
        this.vertexCount = n10 = projection$SubMesh.getVertexCount();
        this.vertexBuffer = floatBuffer = GlUtil.createBuffer(projection$SubMesh.vertices);
        this.textureBuffer = floatBuffer = GlUtil.createBuffer(projection$SubMesh.textureCoords);
        int n11 = projection$SubMesh.mode;
        n10 = 1;
        this.drawMode = n11 != n10 ? (n11 != (n10 = 2) ? (n11 = 4) : (n11 = 6)) : (n11 = 5);
    }

    public static /* synthetic */ FloatBuffer access$000(ProjectionRenderer$MeshData projectionRenderer$MeshData) {
        return projectionRenderer$MeshData.vertexBuffer;
    }

    public static /* synthetic */ FloatBuffer access$100(ProjectionRenderer$MeshData projectionRenderer$MeshData) {
        return projectionRenderer$MeshData.textureBuffer;
    }

    public static /* synthetic */ int access$200(ProjectionRenderer$MeshData projectionRenderer$MeshData) {
        return projectionRenderer$MeshData.drawMode;
    }

    public static /* synthetic */ int access$300(ProjectionRenderer$MeshData projectionRenderer$MeshData) {
        return projectionRenderer$MeshData.vertexCount;
    }
}

