/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 */
package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.view.video.AutoValue_OutputFileOptions;
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.OutputFileOptions;
import androidx.camera.view.video.OutputFileOptions$Builder;
import java.io.File;
import java.util.Objects;

public final class AutoValue_OutputFileOptions$Builder
extends OutputFileOptions$Builder {
    private ContentResolver contentResolver;
    private ContentValues contentValues;
    private File file;
    private ParcelFileDescriptor fileDescriptor;
    private Metadata metadata;
    private Uri saveCollection;

    public OutputFileOptions build() {
        boolean bl2;
        Object object = this.metadata;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" metadata");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            File file = this.file;
            ParcelFileDescriptor parcelFileDescriptor = this.fileDescriptor;
            ContentResolver contentResolver = this.contentResolver;
            Uri uri = this.saveCollection;
            ContentValues contentValues = this.contentValues;
            Metadata metadata = this.metadata;
            Object object2 = object;
            object = new AutoValue_OutputFileOptions(file, parcelFileDescriptor, contentResolver, uri, contentValues, metadata, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public OutputFileOptions$Builder setContentResolver(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
        return this;
    }

    public OutputFileOptions$Builder setContentValues(ContentValues contentValues) {
        this.contentValues = contentValues;
        return this;
    }

    public OutputFileOptions$Builder setFile(File file) {
        this.file = file;
        return this;
    }

    public OutputFileOptions$Builder setFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        this.fileDescriptor = parcelFileDescriptor;
        return this;
    }

    public OutputFileOptions$Builder setMetadata(Metadata metadata) {
        Objects.requireNonNull(metadata, "Null metadata");
        this.metadata = metadata;
        return this;
    }

    public OutputFileOptions$Builder setSaveCollection(Uri uri) {
        this.saveCollection = uri;
        return this;
    }
}

