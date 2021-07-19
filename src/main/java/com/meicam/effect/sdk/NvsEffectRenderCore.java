/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.effect.sdk;

import com.meicam.effect.sdk.NvsEffect;
import com.meicam.sdk.NvsVideoFrameInfo;
import com.meicam.sdk.NvsVideoResolution;
import java.nio.ByteBuffer;

public class NvsEffectRenderCore {
    public static final int NV_EFFECT_CORE_ERROR_UNKNOWN = 255;
    public static final int NV_EFFECT_CORE_FLAGS_CREATE_GLCONTEXT_IF_NEED = 2;
    public static final int NV_EFFECT_CORE_FLAGS_IN_SINGLE_GLTHREAD = 1;
    public static final int NV_EFFECT_CORE_FLAGS_SUPPORT_16K = 16;
    public static final int NV_EFFECT_CORE_FLAGS_SUPPORT_4K = 4;
    public static final int NV_EFFECT_CORE_FLAGS_SUPPORT_8K = 8;
    public static final int NV_EFFECT_CORE_INVALID_TEXTURE = 254;
    public static final int NV_EFFECT_CORE_NO_ERROR = 0;
    public static final int NV_EFFECT_CORE_RENDER_FLAGS_SHOW_ANIMATED_STICKER_POSTER = 8;
    public static final int NV_EFFECT_CORE_RENDER_FLAGS_SHOW_CAPTION_POSTER = 4;
    public static final int NV_EFFECT_CORE_RENDER_Flags_ISFLIPHORIZONTAL = 2;
    public static final int NV_EFFECT_CORE_RENDER_Flags_ISUPSIDEDOWN = 1;
    public long m_internalObject = 0L;

    private native void nativeCleanUp(long var1);

    private native void nativeClearCacheResources(long var1);

    private native void nativeClearEffectResources(long var1, NvsEffect var3);

    private native void nativeDestory(long var1);

    private native ByteBuffer nativeDownloadFromTexture(long var1, int var3, NvsVideoResolution var4, int var5, int var6, boolean var7);

    private native boolean nativeInitialize(long var1, int var3);

    private native int nativeRenderEffect(long var1, NvsEffect var3, int[] var4, int var5, byte[] var6, NvsVideoFrameInfo var7, int var8, NvsVideoResolution var9, int var10, long var11, int var13);

    private native ByteBuffer nativeRenderEffectWithBuffer(long var1, NvsEffect var3, byte[] var4, NvsVideoFrameInfo var5, int var6, int var7, boolean var8, long var9, int var11);

    private native int nativeUploadtoTexture(long var1, byte[] var3, NvsVideoFrameInfo var4, int var5);

    public void cleanUp() {
        long l10 = this.m_internalObject;
        this.nativeCleanUp(l10);
    }

    public void clearCacheResources() {
        long l10 = this.m_internalObject;
        this.nativeClearCacheResources(l10);
    }

    public void clearEffectResources(NvsEffect nvsEffect) {
        long l10 = this.m_internalObject;
        this.nativeClearEffectResources(l10, nvsEffect);
    }

    public ByteBuffer downloadFromTexture(int n10, NvsVideoResolution nvsVideoResolution, int n11, int n12) {
        if (n10 > 0 && nvsVideoResolution != null) {
            long l10 = this.m_internalObject;
            return this.nativeDownloadFromTexture(l10, n10, nvsVideoResolution, n11, n12, false);
        }
        return null;
    }

    public ByteBuffer downloadFromTexture(int n10, NvsVideoResolution nvsVideoResolution, int n11, int n12, boolean bl2) {
        if (n10 > 0 && nvsVideoResolution != null) {
            long l10 = this.m_internalObject;
            return this.nativeDownloadFromTexture(l10, n10, nvsVideoResolution, n11, n12, bl2);
        }
        return null;
    }

    public void finalize() {
        long l10 = this.m_internalObject;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeDestory(l10);
            this.m_internalObject = l11;
        }
        super.finalize();
    }

    public boolean initialize() {
        long l10 = this.m_internalObject;
        return this.nativeInitialize(l10, 0);
    }

    public boolean initialize(int n10) {
        long l10 = this.m_internalObject;
        return this.nativeInitialize(l10, n10);
    }

    public int renderEffect(NvsEffect nvsEffect, int n10, NvsVideoResolution nvsVideoResolution, int n11, long l10, int n12) {
        if (nvsEffect != null && nvsVideoResolution != null) {
            if (n10 > 0 && n11 > 0) {
                int[] nArray = new int[]{n10};
                long l11 = this.m_internalObject;
                return this.nativeRenderEffect(l11, nvsEffect, nArray, 1, null, null, 0, nvsVideoResolution, n11, l10, n12);
            }
            return -2;
        }
        return -1;
    }

    public int renderEffect(NvsEffect nvsEffect, int n10, byte[] byArray, NvsVideoFrameInfo nvsVideoFrameInfo, int n11, NvsVideoResolution nvsVideoResolution, int n12, long l10, int n13) {
        if (nvsEffect != null && nvsVideoResolution != null) {
            if (n10 > 0 && n12 > 0) {
                int[] nArray = new int[]{n10};
                long l11 = this.m_internalObject;
                return this.nativeRenderEffect(l11, nvsEffect, nArray, 1, byArray, nvsVideoFrameInfo, n11, nvsVideoResolution, n12, l10, n13);
            }
            return -2;
        }
        return -1;
    }

    public int renderEffect(NvsEffect nvsEffect, int[] nArray, int n10, NvsVideoResolution nvsVideoResolution, int n11, long l10, int n12) {
        if (nvsEffect != null && nvsVideoResolution != null) {
            if (nArray != null && n11 > 0) {
                long l11 = this.m_internalObject;
                return this.nativeRenderEffect(l11, nvsEffect, nArray, n10, null, null, 0, nvsVideoResolution, n11, l10, n12);
            }
            return -2;
        }
        return -1;
    }

    public ByteBuffer renderEffect(NvsEffect nvsEffect, byte[] byArray, NvsVideoFrameInfo nvsVideoFrameInfo, int n10, int n11, boolean bl2, long l10, int n12) {
        if (nvsEffect != null && nvsVideoFrameInfo != null) {
            long l11 = this.m_internalObject;
            return this.nativeRenderEffectWithBuffer(l11, nvsEffect, byArray, nvsVideoFrameInfo, n10, n11, bl2, l10, n12);
        }
        return null;
    }

    public void setInternalObject(long l10) {
        this.m_internalObject = l10;
    }

    public int uploadVideoFrameToTexture(byte[] byArray, NvsVideoFrameInfo nvsVideoFrameInfo, int n10) {
        if (nvsVideoFrameInfo != null && byArray != null && n10 > 0) {
            long l10 = this.m_internalObject;
            return this.nativeUploadtoTexture(l10, byArray, nvsVideoFrameInfo, n10);
        }
        return -1;
    }
}

