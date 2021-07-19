/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.ParserException;

public class SsManifestParser$MissingFieldException
extends ParserException {
    public SsManifestParser$MissingFieldException(String string2) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "Missing required field: ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        super(string2);
    }
}

