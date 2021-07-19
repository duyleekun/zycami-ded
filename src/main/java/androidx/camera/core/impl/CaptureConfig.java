/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.TagBundle;
import java.util.Collections;
import java.util.List;

public final class CaptureConfig {
    public static final Config$Option OPTION_JPEG_QUALITY;
    public static final Config$Option OPTION_ROTATION;
    public final List mCameraCaptureCallbacks;
    public final Config mImplementationOptions;
    public final List mSurfaces;
    private final TagBundle mTagBundle;
    public final int mTemplateType;
    private final boolean mUseRepeatingSurface;

    static {
        Class<Integer> clazz = Integer.TYPE;
        OPTION_ROTATION = Config$Option.create("camerax.core.captureConfig.rotation", clazz);
        OPTION_JPEG_QUALITY = Config$Option.create("camerax.core.captureConfig.jpegQuality", Integer.class);
    }

    public CaptureConfig(List list, Config config, int n10, List list2, boolean bl2, TagBundle tagBundle) {
        this.mSurfaces = list;
        this.mImplementationOptions = config;
        this.mTemplateType = n10;
        this.mCameraCaptureCallbacks = list = Collections.unmodifiableList(list2);
        this.mUseRepeatingSurface = bl2;
        this.mTagBundle = tagBundle;
    }

    public static CaptureConfig defaultEmptyCaptureConfig() {
        CaptureConfig$Builder captureConfig$Builder = new CaptureConfig$Builder();
        return captureConfig$Builder.build();
    }

    public List getCameraCaptureCallbacks() {
        return this.mCameraCaptureCallbacks;
    }

    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    public List getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }
}

