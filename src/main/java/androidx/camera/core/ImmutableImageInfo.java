/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.AutoValue_ImmutableImageInfo;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData$Builder;

public abstract class ImmutableImageInfo
implements ImageInfo {
    public static ImageInfo create(TagBundle tagBundle, long l10, int n10) {
        AutoValue_ImmutableImageInfo autoValue_ImmutableImageInfo = new AutoValue_ImmutableImageInfo(tagBundle, l10, n10);
        return autoValue_ImmutableImageInfo;
    }

    public abstract int getRotationDegrees();

    public abstract TagBundle getTagBundle();

    public abstract long getTimestamp();

    public void populateExifData(ExifData$Builder exifData$Builder) {
        int n10 = this.getRotationDegrees();
        exifData$Builder.setOrientationDegrees(n10);
    }
}

