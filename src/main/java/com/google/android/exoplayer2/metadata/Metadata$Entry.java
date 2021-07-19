/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 */
package com.google.android.exoplayer2.metadata;

import android.os.Parcelable;
import com.google.android.exoplayer2.Format;

public interface Metadata$Entry
extends Parcelable {
    default public byte[] getWrappedMetadataBytes() {
        return null;
    }

    default public Format getWrappedMetadataFormat() {
        return null;
    }
}

