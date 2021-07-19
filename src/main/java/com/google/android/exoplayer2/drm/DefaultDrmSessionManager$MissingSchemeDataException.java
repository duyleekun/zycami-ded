/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$1;
import java.util.UUID;

public final class DefaultDrmSessionManager$MissingSchemeDataException
extends Exception {
    private DefaultDrmSessionManager$MissingSchemeDataException(UUID object) {
        object = String.valueOf(object);
        int n10 = String.valueOf(object).length() + 29;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Media does not support uuid: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        super((String)object);
    }

    public /* synthetic */ DefaultDrmSessionManager$MissingSchemeDataException(UUID uUID, DefaultDrmSessionManager$1 defaultDrmSessionManager$1) {
        this(uUID);
    }
}

