/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.impl.TagBundle;
import java.util.Objects;

public final class AutoValue_ImmutableImageInfo
extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final TagBundle tagBundle;
    private final long timestamp;

    public AutoValue_ImmutableImageInfo(TagBundle tagBundle, long l10, int n10) {
        Objects.requireNonNull(tagBundle, "Null tagBundle");
        this.tagBundle = tagBundle;
        this.timestamp = l10;
        this.rotationDegrees = n10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof ImmutableImageInfo;
        if (n10 != 0) {
            int n11;
            long l10;
            long l11;
            long l12;
            TagBundle tagBundle = this.tagBundle;
            TagBundle tagBundle2 = ((ImmutableImageInfo)(object = (ImmutableImageInfo)object)).getTagBundle();
            n10 = tagBundle.equals(tagBundle2);
            if (n10 == 0 || (n10 = (l12 = (l11 = this.timestamp) - (l10 = ((ImmutableImageInfo)object).getTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0 || (n10 = this.rotationDegrees) != (n11 = ((ImmutableImageInfo)object).getRotationDegrees())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public TagBundle getTagBundle() {
        return this.tagBundle;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int n10 = this.tagBundle.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        long l10 = this.timestamp;
        long l11 = l10 >>> 32;
        int n12 = (int)(l10 ^ l11);
        n10 = (n10 ^ n12) * n11;
        n11 = this.rotationDegrees;
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableImageInfo{tagBundle=");
        TagBundle tagBundle = this.tagBundle;
        stringBuilder.append(tagBundle);
        stringBuilder.append(", timestamp=");
        long l10 = this.timestamp;
        stringBuilder.append(l10);
        stringBuilder.append(", rotationDegrees=");
        int n10 = this.rotationDegrees;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

