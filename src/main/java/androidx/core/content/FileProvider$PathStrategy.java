/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.content;

import android.net.Uri;
import java.io.File;

public interface FileProvider$PathStrategy {
    public File getFileForUri(Uri var1);

    public Uri getUriForFile(File var1);
}

