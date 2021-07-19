/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.location.Location
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 */
package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.camera.core.VideoCapture$Metadata;
import androidx.camera.core.VideoCapture$OutputFileOptions;
import androidx.camera.core.VideoCapture$OutputFileOptions$Builder;
import androidx.camera.view.video.AutoValue_OutputFileOptions$Builder;
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.OutputFileOptions$Builder;
import androidx.core.util.Preconditions;
import java.io.File;
import java.io.FileDescriptor;

public abstract class OutputFileOptions {
    private static final Metadata EMPTY_METADATA = Metadata.builder().build();

    public static OutputFileOptions$Builder builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        AutoValue_OutputFileOptions$Builder autoValue_OutputFileOptions$Builder = new AutoValue_OutputFileOptions$Builder();
        Metadata metadata = EMPTY_METADATA;
        return autoValue_OutputFileOptions$Builder.setMetadata(metadata).setContentResolver(contentResolver).setSaveCollection(uri).setContentValues(contentValues);
    }

    public static OutputFileOptions$Builder builder(ParcelFileDescriptor parcelFileDescriptor) {
        AutoValue_OutputFileOptions$Builder autoValue_OutputFileOptions$Builder;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            autoValue_OutputFileOptions$Builder = null;
        }
        Preconditions.checkArgument(n10 != 0, "Using a ParcelFileDescriptor to record a video is only supported for Android 8.0 or above.");
        autoValue_OutputFileOptions$Builder = new AutoValue_OutputFileOptions$Builder();
        Metadata metadata = EMPTY_METADATA;
        return autoValue_OutputFileOptions$Builder.setMetadata(metadata).setFileDescriptor(parcelFileDescriptor);
    }

    public static OutputFileOptions$Builder builder(File file) {
        AutoValue_OutputFileOptions$Builder autoValue_OutputFileOptions$Builder = new AutoValue_OutputFileOptions$Builder();
        Metadata metadata = EMPTY_METADATA;
        return autoValue_OutputFileOptions$Builder.setMetadata(metadata).setFile(file);
    }

    private boolean isSavingToFile() {
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

    private boolean isSavingToFileDescriptor() {
        boolean bl2;
        ParcelFileDescriptor parcelFileDescriptor = this.getFileDescriptor();
        if (parcelFileDescriptor != null) {
            bl2 = true;
        } else {
            bl2 = false;
            parcelFileDescriptor = null;
        }
        return bl2;
    }

    private boolean isSavingToMediaStore() {
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

    public abstract ContentResolver getContentResolver();

    public abstract ContentValues getContentValues();

    public abstract File getFile();

    public abstract ParcelFileDescriptor getFileDescriptor();

    public abstract Metadata getMetadata();

    public abstract Uri getSaveCollection();

    public VideoCapture$OutputFileOptions toVideoCaptureOutputFileOptions() {
        Location location;
        VideoCapture$OutputFileOptions$Builder videoCapture$OutputFileOptions$Builder;
        Object object;
        boolean bl2 = this.isSavingToFile();
        if (bl2) {
            object = (File)Preconditions.checkNotNull(this.getFile());
            videoCapture$OutputFileOptions$Builder = new VideoCapture$OutputFileOptions$Builder((File)object);
        } else {
            bl2 = this.isSavingToFileDescriptor();
            if (bl2) {
                object = ((ParcelFileDescriptor)Preconditions.checkNotNull(this.getFileDescriptor())).getFileDescriptor();
                videoCapture$OutputFileOptions$Builder = new VideoCapture$OutputFileOptions$Builder((FileDescriptor)object);
            } else {
                bl2 = this.isSavingToMediaStore();
                Preconditions.checkState(bl2);
                object = (ContentResolver)Preconditions.checkNotNull(this.getContentResolver());
                location = (Uri)Preconditions.checkNotNull(this.getSaveCollection());
                ContentValues contentValues = (ContentValues)Preconditions.checkNotNull(this.getContentValues());
                videoCapture$OutputFileOptions$Builder = new VideoCapture$OutputFileOptions$Builder((ContentResolver)object, (Uri)location, contentValues);
            }
        }
        object = new VideoCapture$Metadata();
        ((VideoCapture$Metadata)object).location = location = this.getMetadata().getLocation();
        videoCapture$OutputFileOptions$Builder.setMetadata((VideoCapture$Metadata)object);
        return videoCapture$OutputFileOptions$Builder.build();
    }
}

