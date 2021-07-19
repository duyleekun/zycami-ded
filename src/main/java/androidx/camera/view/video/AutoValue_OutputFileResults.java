/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.camera.view.video;

import android.net.Uri;
import androidx.camera.view.video.OutputFileResults;

public final class AutoValue_OutputFileResults
extends OutputFileResults {
    private final Uri savedUri;

    public AutoValue_OutputFileResults(Uri uri) {
        this.savedUri = uri;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof OutputFileResults;
        if (bl3) {
            object = (OutputFileResults)object;
            Uri uri = this.savedUri;
            object = ((OutputFileResults)object).getSavedUri();
            if (uri == null) {
                if (object != null) {
                    bl2 = false;
                }
            } else {
                bl2 = uri.equals(object);
            }
            return bl2;
        }
        return false;
    }

    public Uri getSavedUri() {
        return this.savedUri;
    }

    public int hashCode() {
        int n10;
        Uri uri = this.savedUri;
        if (uri == null) {
            n10 = 0;
            uri = null;
        } else {
            n10 = uri.hashCode();
        }
        return n10 ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OutputFileResults{savedUri=");
        Uri uri = this.savedUri;
        stringBuilder.append(uri);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

