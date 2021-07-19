/*
 * Decompiled with CFR 0.151.
 */
package com.davemorrissey.labs.subscaleview;

public interface SubsamplingScaleImageView$OnImageEventListener {
    public void onImageLoadError(Exception var1);

    public void onImageLoaded();

    public void onPreviewLoadError(Exception var1);

    public void onPreviewReleased();

    public void onReady();

    public void onTileLoadError(Exception var1);
}

