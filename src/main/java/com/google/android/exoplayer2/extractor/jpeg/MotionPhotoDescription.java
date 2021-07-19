/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.jpeg.MotionPhotoDescription$ContainerItem;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

public final class MotionPhotoDescription {
    public final List items;
    public final long photoPresentationTimestampUs;

    public MotionPhotoDescription(long l10, List list) {
        this.photoPresentationTimestampUs = l10;
        this.items = list;
    }

    public MotionPhotoMetadata getMotionPhotoMetadata(long l10) {
        long l11;
        int n10;
        MotionPhotoDescription motionPhotoDescription = this;
        Object object = this.items;
        int n11 = object.size();
        if (n11 < (n10 = 2)) {
            return null;
        }
        object = this.items;
        long l12 = -1;
        long l13 = l10;
        long l14 = l12;
        long l15 = l12;
        long l16 = l12;
        long l17 = l12;
        int n12 = 0;
        for (n11 = object.size() + -1; n11 >= 0; n11 += -1) {
            MotionPhotoDescription$ContainerItem motionPhotoDescription$ContainerItem = (MotionPhotoDescription$ContainerItem)motionPhotoDescription.items.get(n11);
            String string2 = motionPhotoDescription$ContainerItem.mime;
            String string3 = "video/mp4";
            n10 = string3.equals(string2) | n12;
            if (n11 == 0) {
                long l18 = 0L;
                l11 = motionPhotoDescription$ContainerItem.padding;
                l11 = l13 - l11;
                l13 = l18;
            } else {
                l11 = motionPhotoDescription$ContainerItem.length;
                l11 = l13 - l11;
                long l19 = l13;
                l13 = l11;
                l11 = l19;
            }
            if (n10 != 0 && (n12 = (int)(l13 == l11 ? 0 : (l13 < l11 ? -1 : 1))) != 0) {
                l17 = l11 - l13;
                l16 = l13;
                n12 = 0;
            } else {
                n12 = n10;
            }
            if (n11 != 0) continue;
            l14 = l13;
            l15 = l11;
        }
        n11 = (int)(l16 == l12 ? 0 : (l16 < l12 ? -1 : 1));
        if (n11 != 0 && (n11 = (int)(l17 == l12 ? 0 : (l17 < l12 ? -1 : 1))) != 0 && (n11 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1))) != 0 && (n11 = (int)(l15 == l12 ? 0 : (l15 < l12 ? -1 : 1))) != 0) {
            l11 = motionPhotoDescription.photoPresentationTimestampUs;
            object = new MotionPhotoMetadata(l14, l15, l11, l16, l17);
            return object;
        }
        return null;
    }
}

