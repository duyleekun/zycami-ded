/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import java.util.Objects;

public final class AutoValue_SurfaceSizeDefinition
extends SurfaceSizeDefinition {
    private final Size analysisSize;
    private final Size previewSize;
    private final Size recordSize;

    public AutoValue_SurfaceSizeDefinition(Size size, Size size2, Size size3) {
        Objects.requireNonNull(size, "Null analysisSize");
        this.analysisSize = size;
        Objects.requireNonNull(size2, "Null previewSize");
        this.previewSize = size2;
        Objects.requireNonNull(size3, "Null recordSize");
        this.recordSize = size3;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof SurfaceSizeDefinition;
        if (bl3) {
            boolean bl4;
            Size size = this.analysisSize;
            Size size2 = ((SurfaceSizeDefinition)(object = (SurfaceSizeDefinition)object)).getAnalysisSize();
            bl3 = size.equals((Object)size2);
            if (!(bl3 && (bl3 = (size = this.previewSize).equals((Object)(size2 = ((SurfaceSizeDefinition)object).getPreviewSize()))) && (bl4 = (size = this.recordSize).equals(object = ((SurfaceSizeDefinition)object).getRecordSize())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Size getAnalysisSize() {
        return this.analysisSize;
    }

    public Size getPreviewSize() {
        return this.previewSize;
    }

    public Size getRecordSize() {
        return this.recordSize;
    }

    public int hashCode() {
        int n10 = this.analysisSize.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.previewSize.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.recordSize.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurfaceSizeDefinition{analysisSize=");
        Size size = this.analysisSize;
        stringBuilder.append(size);
        stringBuilder.append(", previewSize=");
        size = this.previewSize;
        stringBuilder.append(size);
        stringBuilder.append(", recordSize=");
        size = this.recordSize;
        stringBuilder.append(size);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

