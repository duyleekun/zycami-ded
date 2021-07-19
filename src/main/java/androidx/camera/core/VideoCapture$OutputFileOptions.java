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
import androidx.camera.core.VideoCapture$Metadata;
import java.io.File;
import java.io.FileDescriptor;

public final class VideoCapture$OutputFileOptions {
    private static final VideoCapture$Metadata EMPTY_METADATA;
    private final ContentResolver mContentResolver;
    private final ContentValues mContentValues;
    private final File mFile;
    private final FileDescriptor mFileDescriptor;
    private final VideoCapture$Metadata mMetadata;
    private final Uri mSaveCollection;

    static {
        VideoCapture$Metadata videoCapture$Metadata;
        EMPTY_METADATA = videoCapture$Metadata = new VideoCapture$Metadata();
    }

    public VideoCapture$OutputFileOptions(File file, FileDescriptor fileDescriptor, ContentResolver contentResolver, Uri uri, ContentValues contentValues, VideoCapture$Metadata videoCapture$Metadata) {
        this.mFile = file;
        this.mFileDescriptor = fileDescriptor;
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
        if (videoCapture$Metadata == null) {
            videoCapture$Metadata = EMPTY_METADATA;
        }
        this.mMetadata = videoCapture$Metadata;
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

    public FileDescriptor getFileDescriptor() {
        return this.mFileDescriptor;
    }

    public VideoCapture$Metadata getMetadata() {
        return this.mMetadata;
    }

    public Uri getSaveCollection() {
        return this.mSaveCollection;
    }

    public boolean isSavingToFile() {
        boolean bl2;
        File file = this.getFile();
        if (file != null) {
            bl2 = true;
        } else {
            bl2 = false;
            file = null;
        }
        return bl2;
    }

    public boolean isSavingToFileDescriptor() {
        boolean bl2;
        FileDescriptor fileDescriptor = this.getFileDescriptor();
        if (fileDescriptor != null) {
            bl2 = true;
        } else {
            bl2 = false;
            fileDescriptor = null;
        }
        return bl2;
    }

    public boolean isSavingToMediaStore() {
        boolean bl2;
        Uri uri = this.getSaveCollection();
        if (uri != null && (uri = this.getContentResolver()) != null && (uri = this.getContentValues()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            uri = null;
        }
        return bl2;
    }
}

