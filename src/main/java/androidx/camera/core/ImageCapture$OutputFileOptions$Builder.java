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
import androidx.camera.core.ImageCapture$OutputFileOptions;
import java.io.File;
import java.io.OutputStream;

public final class ImageCapture$OutputFileOptions$Builder {
    private ContentResolver mContentResolver;
    private ContentValues mContentValues;
    private File mFile;
    private ImageCapture$Metadata mMetadata;
    private OutputStream mOutputStream;
    private Uri mSaveCollection;

    public ImageCapture$OutputFileOptions$Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
    }

    public ImageCapture$OutputFileOptions$Builder(File file) {
        this.mFile = file;
    }

    public ImageCapture$OutputFileOptions$Builder(OutputStream outputStream) {
        this.mOutputStream = outputStream;
    }

    public ImageCapture$OutputFileOptions build() {
        File file = this.mFile;
        ContentResolver contentResolver = this.mContentResolver;
        Uri uri = this.mSaveCollection;
        ContentValues contentValues = this.mContentValues;
        OutputStream outputStream = this.mOutputStream;
        ImageCapture$Metadata imageCapture$Metadata = this.mMetadata;
        ImageCapture$OutputFileOptions imageCapture$OutputFileOptions = new ImageCapture$OutputFileOptions(file, contentResolver, uri, contentValues, outputStream, imageCapture$Metadata);
        return imageCapture$OutputFileOptions;
    }

    public ImageCapture$OutputFileOptions$Builder setMetadata(ImageCapture$Metadata imageCapture$Metadata) {
        this.mMetadata = imageCapture$Metadata;
        return this;
    }
}

