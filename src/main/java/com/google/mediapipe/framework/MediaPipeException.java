/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.common.base.Charsets;
import com.google.mediapipe.framework.MediaPipeException$StatusCode;
import java.nio.charset.Charset;

public class MediaPipeException
extends RuntimeException {
    private final MediaPipeException$StatusCode statusCode;
    private final String statusMessage;

    public MediaPipeException(int n10, String string2) {
        MediaPipeException$StatusCode mediaPipeException$StatusCode;
        CharSequence charSequence = new StringBuilder();
        String string3 = MediaPipeException$StatusCode.values()[n10].description();
        charSequence.append(string3);
        charSequence.append(": ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.statusCode = mediaPipeException$StatusCode = MediaPipeException$StatusCode.values()[n10];
        this.statusMessage = string2;
    }

    public MediaPipeException(int n10, byte[] byArray) {
        Charset charset = Charsets.UTF_8;
        String string2 = new String(byArray, charset);
        this(n10, string2);
    }

    public MediaPipeException$StatusCode getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }
}

