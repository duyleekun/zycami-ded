/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.camera.core.ImageCapture$Metadata;
import java.io.File;
import java.io.OutputStream;

public final class ImageCapture$OutputFileOptions {
    private final ContentResolver mContentResolver;
    private final ContentValues mContentValues;
    private final File mFile;
    private final ImageCapture$Metadata mMetadata;
    private final OutputStream mOutputStream;
    private final Uri mSaveCollection;

    public ImageCapture$OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, ImageCapture$Metadata imageCapture$Metadata) {
        this.mFile = file;
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
        this.mOutputStream = outputStream;
        if (imageCapture$Metadata == null) {
            imageCapture$Metadata = new ImageCapture$Metadata();
        }
        this.mMetadata = imageCapture$Metadata;
    }

    public ContentResolver getContentResolver() {
        return this.mContentResolver;
    }

    public ContentValues getContentValues() {
        return this.mContentValues;
    }

    public File getFile() {
        return this.mFile;
    }

    public ImageCapture$Metadata getMetadata() {
        return this.mMetadata;
    }

    public OutputStream getOutputStream() {
        return this.mOutputStream;
    }

    public Uri getSaveCollection() {
        return this.mSaveCollection;
    }
}

