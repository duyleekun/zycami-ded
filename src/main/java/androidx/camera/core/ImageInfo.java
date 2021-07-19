/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData$Builder;

public interface ImageInfo {
    public int getRotationDegrees();

    public TagBundle getTagBundle();

    public long getTimestamp();

    public void populateExifData(ExifData.Builder var1);
}

