/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.VideoCapture$Metadata;
import androidx.camera.core.VideoCapture$OutputFileOptions;
import androidx.core.util.Preconditions;
import java.io.File;
import java.io.FileDescriptor;

public final class VideoCapture$OutputFileOptions$Builder {
    private ContentResolver mContentResolver;
    private ContentValues mContentValues;
    private File mFile;
    private FileDescriptor mFileDescriptor;
    private VideoCapture$Metadata mMetadata;
    private Uri mSaveCollection;

    public VideoCapture$OutputFileOptions$Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
    }

    public VideoCapture$OutputFileOptions$Builder(File file) {
        this.mFile = file;
    }

    /*
     * WARNING - void declaration
     */
    public VideoCapture$OutputFileOptions$Builder(FileDescriptor fileDescriptor) {
        void var2_5;
        int bl2 = Build.VERSION.SDK_INT;
        int n10 = 26;
        if (bl2 >= n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        Preconditions.checkArgument((boolean)var2_5, "Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
        this.mFileDescriptor = fileDescriptor;
    }

    public VideoCapture$OutputFileOptions build() {
        File file = this.mFile;
        FileDescriptor fileDescriptor = this.mFileDescriptor;
        ContentResolver contentResolver = this.mContentResolver;
        Uri uri = this.mSaveCollection;
        ContentValues contentValues = this.mContentValues;
        VideoCapture$Metadata videoCapture$Metadata = this.mMetadata;
        VideoCapture$OutputFileOptions videoCapture$OutputFileOptions = new VideoCapture$OutputFileOptions(file, fileDescriptor, contentResolver, uri, contentValues, videoCapture$Metadata);
        return videoCapture$OutputFileOptions;
    }

    public VideoCapture$OutputFileOptions$Builder setMetadata(VideoCapture$Metadata videoCapture$Metadata) {
        this.mMetadata = videoCapture$Metadata;
        return this;
    }
}

