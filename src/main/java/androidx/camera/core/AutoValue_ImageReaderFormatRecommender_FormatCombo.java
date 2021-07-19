/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender$FormatCombo;

public final class AutoValue_ImageReaderFormatRecommender_FormatCombo
extends ImageReaderFormatRecommender$FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    public AutoValue_ImageReaderFormatRecommender_FormatCombo(int n10, int n11) {
        this.imageCaptureFormat = n10;
        this.imageAnalysisFormat = n11;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof ImageReaderFormatRecommender$FormatCombo;
        if (n10 != 0) {
            int n11;
            n10 = this.imageCaptureFormat;
            int n12 = ((ImageReaderFormatRecommender$FormatCombo)(object = (ImageReaderFormatRecommender$FormatCombo)object)).imageCaptureFormat();
            if (n10 != n12 || (n10 = this.imageAnalysisFormat) != (n11 = ((ImageReaderFormatRecommender$FormatCombo)object).imageAnalysisFormat())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.imageCaptureFormat;
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.imageAnalysisFormat;
        return n10 ^ n11;
    }

    public int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    public int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FormatCombo{imageCaptureFormat=");
        int n10 = this.imageCaptureFormat;
        stringBuilder.append(n10);
        stringBuilder.append(", imageAnalysisFormat=");
        n10 = this.imageAnalysisFormat;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

