/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal.utils;

import androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType;

public final class ImageUtil$CodecFailedException
extends Exception {
    private ImageUtil$CodecFailedException$FailureType mFailureType;

    public ImageUtil$CodecFailedException(String object) {
        super((String)object);
        object = ImageUtil$CodecFailedException$FailureType.UNKNOWN;
        this.mFailureType = object;
    }

    public ImageUtil$CodecFailedException(String string2, ImageUtil$CodecFailedException$FailureType imageUtil$CodecFailedException$FailureType) {
        super(string2);
        this.mFailureType = imageUtil$CodecFailedException$FailureType;
    }

    public ImageUtil$CodecFailedException$FailureType getFailureType() {
        return this.mFailureType;
    }
}

