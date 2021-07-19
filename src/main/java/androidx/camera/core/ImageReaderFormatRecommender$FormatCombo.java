/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.AutoValue_ImageReaderFormatRecommender_FormatCombo;

public abstract class ImageReaderFormatRecommender$FormatCombo {
    public static ImageReaderFormatRecommender$FormatCombo create(int n10, int n11) {
        AutoValue_ImageReaderFormatRecommender_FormatCombo autoValue_ImageReaderFormatRecommender_FormatCombo = new AutoValue_ImageReaderFormatRecommender_FormatCombo(n10, n11);
        return autoValue_ImageReaderFormatRecommender_FormatCombo;
    }

    public abstract int imageAnalysisFormat();

    public abstract int imageCaptureFormat();
}

