/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;

public class UnrecognizedInputFormatException
extends ParserException {
    public final Uri uri;

    public UnrecognizedInputFormatException(String string2, Uri uri) {
        super(string2);
        this.uri = uri;
    }
}

