/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.google.android.exoplayer2.ui.spherical;

import android.opengl.GLES20;
import com.google.android.exoplayer2.ui.spherical.ProjectionRenderer$MeshData;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.Projection;
import com.google.android.exoplayer2.video.spherical.Projection$Mesh;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public final class ProjectionRenderer {
    private static final String[] FRAGMENT_SHADER_CODE;
    private static final float[] TEX_MATRIX_BOTTOM;
    private static final float[] TEX_MATRIX_LEFT;
    private static final float[] TEX_MATRIX_RIGHT;
    private static final float[] TEX_MATRIX_TOP;
    private static final float[] TEX_MATRIX_WHOLE;
    private static final String[] VERTEX_SHADER_CODE;
    private ProjectionRenderer$MeshData leftMeshData;
    private int mvpMatrixHandle;
    private int positionHandle;
    private int program;
    private ProjectionRenderer$MeshData rightMeshData;
    private int stereoMode;
    private int texCoordsHandle;
    private int textureHandle;
    private int uTexMatrixHandle;

    static {
        float[] fArray;
        float[] fArray2;
        VERTEX_SHADER_CODE = new String[]{"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};
        FRAGMENT_SHADER_CODE = new String[]{"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};
        int n10 = 9;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = 1.0f;
        fArray4[1] = 0.0f;
        fArray3[2] = 0.0f;
        fArray4[3] = 0.0f;
        fArray3[4] = -1.0f;
        fArray4[5] = 0.0f;
        fArray3[6] = 0.0f;
        fArray4[7] = 1.0f;
        fArray4[8] = 1.0f;
        TEX_MATRIX_WHOLE = fArray2;
        float[] fArray5 = fArray2 = new float[n10];
        float[] fArray6 = fArray2;
        fArray5[0] = 1.0f;
        fArray6[1] = 0.0f;
        fArray5[2] = 0.0f;
        fArray6[3] = 0.0f;
        fArray5[4] = -0.5f;
        fArray6[5] = 0.0f;
        fArray5[6] = 0.0f;
        fArray6[7] = 0.5f;
        fArray6[8] = 1.0f;
        TEX_MATRIX_TOP = fArray2;
        float[] fArray7 = fArray2 = new float[n10];
        float[] fArray8 = fArray2;
        fArray7[0] = 1.0f;
        fArray8[1] = 0.0f;
        fArray7[2] = 0.0f;
        fArray8[3] = 0.0f;
        fArray7[4] = -0.5f;
        fArray8[5] = 0.0f;
        fArray7[6] = 0.0f;
        fArray8[7] = 1.0f;
        fArray8[8] = 1.0f;
        TEX_MATRIX_BOTTOM = fArray2;
        float[] fArray9 = fArray2 = new float[n10];
        float[] fArray10 = fArray2;
        fArray9[0] = 0.5f;
        fArray10[1] = 0.0f;
        fArray9[2] = 0.0f;
        fArray10[3] = 0.0f;
        fArray9[4] = -1.0f;
        fArray10[5] = 0.0f;
        fArray9[6] = 0.0f;
        fArray10[7] = 1.0f;
        fArray10[8] = 1.0f;
        TEX_MATRIX_LEFT = fArray2;
        float[] fArray11 = fArray = new float[n10];
        float[] fArray12 = fArray;
        fArray11[0] = 0.5f;
        fArray12[1] = 0.0f;
        fArray11[2] = 0.0f;
        fArray12[3] = 0.0f;
        fArray11[4] = -1.0f;
        fArray12[5] = 0.0f;
        fArray11[6] = 0.5f;
        fArray12[7] = 1.0f;
        fArray12[8] = 1.0f;
        TEX_MATRIX_RIGHT = fArray;
    }

    public static boolean isSupported(Projection object) {
        Object object2 = ((Projection)object).leftMesh;
        object = ((Projection)object).rightMesh;
        int n10 = ((Projection$Mesh)object2).getSubMeshCount();
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12) {
            object2 = ((Projection$Mesh)object2).getSubMesh(0);
            int n13 = ((Projection$SubMesh)object2).textureId;
            if (n13 == 0 && (n13 = ((Projection$Mesh)object).getSubMeshCount()) == n12) {
                object = ((Projection$Mesh)object).getSubMesh(0);
                int n14 = ((Projection$SubMesh)object).textureId;
                if (n14 == 0) {
                    n11 = n12;
                }
            }
        }
        return n11 != 0;
    }

    public void draw(int n10, float[] fArray, boolean bl2) {
        int n11;
        ProjectionRenderer projectionRenderer = this;
        ProjectionRenderer$MeshData projectionRenderer$MeshData = bl2 ? this.rightMeshData : this.leftMeshData;
        if (projectionRenderer$MeshData == null) {
            return;
        }
        GLES20.glUseProgram((int)projectionRenderer.program);
        GlUtil.checkGlError();
        GLES20.glEnableVertexAttribArray((int)projectionRenderer.positionHandle);
        GLES20.glEnableVertexAttribArray((int)projectionRenderer.texCoordsHandle);
        GlUtil.checkGlError();
        int n12 = projectionRenderer.stereoMode;
        int n13 = 1;
        float[] fArray2 = n12 == n13 ? (bl2 ? TEX_MATRIX_BOTTOM : TEX_MATRIX_TOP) : (n12 == (n11 = 2) ? (bl2 ? TEX_MATRIX_RIGHT : TEX_MATRIX_LEFT) : TEX_MATRIX_WHOLE);
        GLES20.glUniformMatrix3fv((int)projectionRenderer.uTexMatrixHandle, (int)n13, (boolean)false, (float[])fArray2, (int)0);
        GLES20.glUniformMatrix4fv((int)projectionRenderer.mvpMatrixHandle, (int)n13, (boolean)false, (float[])fArray, (int)0);
        GLES20.glActiveTexture((int)33984);
        n13 = n10;
        GLES20.glBindTexture((int)36197, (int)n10);
        GLES20.glUniform1i((int)projectionRenderer.textureHandle, (int)0);
        GlUtil.checkGlError();
        int n14 = projectionRenderer.positionHandle;
        FloatBuffer floatBuffer = ProjectionRenderer$MeshData.access$000(projectionRenderer$MeshData);
        GLES20.glVertexAttribPointer((int)n14, (int)3, (int)5126, (boolean)false, (int)12, (Buffer)floatBuffer);
        GlUtil.checkGlError();
        int n15 = projectionRenderer.texCoordsHandle;
        FloatBuffer floatBuffer2 = ProjectionRenderer$MeshData.access$100(projectionRenderer$MeshData);
        GLES20.glVertexAttribPointer((int)n15, (int)2, (int)5126, (boolean)false, (int)8, (Buffer)floatBuffer2);
        GlUtil.checkGlError();
        n12 = ProjectionRenderer$MeshData.access$200(projectionRenderer$MeshData);
        int n16 = ProjectionRenderer$MeshData.access$300(projectionRenderer$MeshData);
        GLES20.glDrawArrays((int)n12, (int)0, (int)n16);
        GlUtil.checkGlError();
        GLES20.glDisableVertexAttribArray((int)projectionRenderer.positionHandle);
        GLES20.glDisableVertexAttribArray((int)projectionRenderer.texCoordsHandle);
    }

    public void init() {
        int n10;
        String[] stringArray = VERTEX_SHADER_CODE;
        String[] stringArray2 = FRAGMENT_SHADER_CODE;
        this.program = n10 = GlUtil.compileProgram(stringArray, stringArray2);
        this.mvpMatrixHandle = n10 = GLES20.glGetUniformLocation((int)n10, (String)"uMvpMatrix");
        this.uTexMatrixHandle = n10 = GLES20.glGetUniformLocation((int)this.program, (String)"uTexMatrix");
        this.positionHandle = n10 = GLES20.glGetAttribLocation((int)this.program, (String)"aPosition");
        this.texCoordsHandle = n10 = GLES20.glGetAttribLocation((int)this.program, (String)"aTexCoords");
        this.textureHandle = n10 = GLES20.glGetUniformLocation((int)this.program, (String)"uTexture");
    }

    public void setProjection(Projection object) {
        ProjectionRenderer$MeshData projectionRenderer$MeshData;
        int n10 = ProjectionRenderer.isSupported((Projection)object);
        if (n10 == 0) {
            return;
        }
        this.stereoMode = n10 = ((Projection)object).stereoMode;
        Projection$SubMesh projection$SubMesh = ((Projection)object).leftMesh.getSubMesh(0);
        this.leftMeshData = projectionRenderer$MeshData = new ProjectionRenderer$MeshData(projection$SubMesh);
        boolean bl2 = ((Projection)object).singleMesh;
        if (!bl2) {
            object = ((Projection)object).rightMesh.getSubMesh(0);
            projectionRenderer$MeshData = new ProjectionRenderer$MeshData((Projection$SubMesh)object);
        }
        this.rightMeshData = projectionRenderer$MeshData;
    }

    public void shutdown() {
        int n10 = this.program;
        if (n10 != 0) {
            GLES20.glDeleteProgram((int)n10);
        }
    }
}

