/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.camera.view.video;

import android.net.Uri;
import androidx.camera.view.video.AutoValue_OutputFileResults;

public abstract class OutputFileResults {
    public static OutputFileResults create(Uri uri) {
        AutoValue_OutputFileResults autoValue_OutputFileResults = new AutoValue_OutputFileResults(uri);
        return autoValue_OutputFileResults;
    }

    public abstract Uri getSavedUri();
}

