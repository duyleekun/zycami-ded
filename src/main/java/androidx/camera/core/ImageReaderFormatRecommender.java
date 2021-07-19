/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender$FormatCombo;

public final class ImageReaderFormatRecommender {
    private ImageReaderFormatRecommender() {
    }

    public static ImageReaderFormatRecommender$FormatCombo chooseCombo() {
        return ImageReaderFormatRecommender$FormatCombo.create(256, 35);
    }
}

