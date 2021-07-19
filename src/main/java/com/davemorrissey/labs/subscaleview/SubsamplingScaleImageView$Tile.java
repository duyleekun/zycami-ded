/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 */
package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$1;

public class SubsamplingScaleImageView$Tile {
    private Bitmap bitmap;
    private Rect fileSRect;
    private boolean loading;
    private Rect sRect;
    private int sampleSize;
    private Rect vRect;
    private boolean visible;

    private SubsamplingScaleImageView$Tile() {
    }

    public /* synthetic */ SubsamplingScaleImageView$Tile(SubsamplingScaleImageView$1 subsamplingScaleImageView$1) {
        this();
    }

    public static /* synthetic */ boolean access$400(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        return subsamplingScaleImageView$Tile.visible;
    }

    public static /* synthetic */ boolean access$4000(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        return subsamplingScaleImageView$Tile.loading;
    }

    public static /* synthetic */ boolean access$4002(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile, boolean bl2) {
        subsamplingScaleImageView$Tile.loading = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$402(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile, boolean bl2) {
        subsamplingScaleImageView$Tile.visible = bl2;
        return bl2;
    }

    public static /* synthetic */ Rect access$4100(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        return subsamplingScaleImageView$Tile.sRect;
    }

    public static /* synthetic */ Rect access$4102(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile, Rect rect) {
        subsamplingScaleImageView$Tile.sRect = rect;
        return rect;
    }

    public static /* synthetic */ Rect access$4200(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        return subsamplingScaleImageView$Tile.vRect;
    }

    public static /* synthetic */ Rect access$4202(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile, Rect rect) {
        subsamplingScaleImageView$Tile.vRect = rect;
        return rect;
    }

    public static /* synthetic */ int access$4300(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        return subsamplingScaleImageView$Tile.sampleSize;
    }

    public static /* synthetic */ int access$4302(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile, int n10) {
        subsamplingScaleImageView$Tile.sampleSize = n10;
        return n10;
    }

    public static /* synthetic */ Bitmap access$500(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        return subsamplingScaleImageView$Tile.bitmap;
    }

    public static /* synthetic */ Rect access$5000(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        return subsamplingScaleImageView$Tile.fileSRect;
    }

    public static /* synthetic */ Rect access$5002(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile, Rect rect) {
        subsamplingScaleImageView$Tile.fileSRect = rect;
        return rect;
    }

    public static /* synthetic */ Bitmap access$502(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile, Bitmap bitmap) {
        subsamplingScaleImageView$Tile.bitmap = bitmap;
        return bitmap;
    }
}

