/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.camera.core;

import android.net.Uri;

public class ImageCapture$OutputFileResults {
    private Uri mSavedUri;

    public ImageCapture$OutputFileResults(Uri uri) {
        this.mSavedUri = uri;
    }

    public Uri getSavedUri() {
        return this.mSavedUri;
    }
}

