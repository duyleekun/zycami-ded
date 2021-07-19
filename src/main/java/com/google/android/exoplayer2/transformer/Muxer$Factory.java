/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 */
package com.google.android.exoplayer2.transformer;

import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.transformer.Muxer;

public interface Muxer$Factory {
    public Muxer create(ParcelFileDescriptor var1, String var2);

    public Muxer create(String var1, String var2);

    public boolean supportsOutputMimeType(String var1);
}

