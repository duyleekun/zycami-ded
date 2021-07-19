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
import androidx.camera.view.video.AutoValue_OutputFileOptions$1;
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.OutputFileOptions;
import java.io.File;

public final class AutoValue_OutputFileOptions
extends OutputFileOptions {
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final File file;
    private final ParcelFileDescriptor fileDescriptor;
    private final Metadata metadata;
    private final Uri saveCollection;

    private AutoValue_OutputFileOptions(File file, ParcelFileDescriptor parcelFileDescriptor, ContentResolver contentResolver, Uri uri, ContentValues contentValues, Metadata metadata) {
        this.file = file;
        this.fileDescriptor = parcelFileDescriptor;
        this.contentResolver = contentResolver;
        this.saveCollection = uri;
        this.contentValues = contentValues;
        this.metadata = metadata;
    }

    public /* synthetic */ AutoValue_OutputFileOptions(File file, ParcelFileDescriptor parcelFileDescriptor, ContentResolver contentResolver, Uri uri, ContentValues contentValues, Metadata metadata, AutoValue_OutputFileOptions$1 autoValue_OutputFileOptions$1) {
        this(file, parcelFileDescriptor, contentResolver, uri, contentValues, metadata);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof OutputFileOptions;
        if (bl3) {
            boolean bl4;
            File file;
            object = (OutputFileOptions)object;
            Object object2 = this.file;
            if (!((object2 == null ? (object2 = ((OutputFileOptions)object).getFile()) == null : (bl3 = ((File)object2).equals(file = ((OutputFileOptions)object).getFile()))) && ((object2 = this.fileDescriptor) == null ? (object2 = ((OutputFileOptions)object).getFileDescriptor()) == null : (bl3 = object2.equals(file = ((OutputFileOptions)object).getFileDescriptor()))) && ((object2 = this.contentResolver) == null ? (object2 = ((OutputFileOptions)object).getContentResolver()) == null : (bl3 = object2.equals(file = ((OutputFileOptions)object).getContentResolver()))) && ((object2 = this.saveCollection) == null ? (object2 = ((OutputFileOptions)object).getSaveCollection()) == null : (bl3 = object2.equals((Object)(file = ((OutputFileOptions)object).getSaveCollection())))) && ((object2 = this.contentValues) == null ? (object2 = ((OutputFileOptions)object).getContentValues()) == null : (bl3 = object2.equals((Object)(file = ((OutputFileOptions)object).getContentValues())))) && (bl4 = (object2 = this.metadata).equals(object = ((OutputFileOptions)object).getMetadata())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    public ContentValues getContentValues() {
        return this.contentValues;
    }

    public File getFile() {
        return this.file;
    }

    public ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public Uri getSaveCollection() {
        return this.saveCollection;
    }

    public int hashCode() {
        int n10;
        int n11;
        File file = this.file;
        int n12 = 0;
        if (file == null) {
            n11 = 0;
            file = null;
        } else {
            n11 = file.hashCode();
        }
        int n13 = 1000003;
        n11 = (n11 ^ n13) * n13;
        ParcelFileDescriptor parcelFileDescriptor = this.fileDescriptor;
        if (parcelFileDescriptor == null) {
            n10 = 0;
            parcelFileDescriptor = null;
        } else {
            n10 = parcelFileDescriptor.hashCode();
        }
        n11 = (n11 ^ n10) * n13;
        parcelFileDescriptor = this.contentResolver;
        if (parcelFileDescriptor == null) {
            n10 = 0;
            parcelFileDescriptor = null;
        } else {
            n10 = parcelFileDescriptor.hashCode();
        }
        n11 = (n11 ^ n10) * n13;
        parcelFileDescriptor = this.saveCollection;
        if (parcelFileDescriptor == null) {
            n10 = 0;
            parcelFileDescriptor = null;
        } else {
            n10 = parcelFileDescriptor.hashCode();
        }
        n11 = (n11 ^ n10) * n13;
        parcelFileDescriptor = this.contentValues;
        if (parcelFileDescriptor != null) {
            n12 = parcelFileDescriptor.hashCode();
        }
        n11 = (n11 ^ n12) * n13;
        n12 = this.metadata.hashCode();
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OutputFileOptions{file=");
        Object object = this.file;
        stringBuilder.append(object);
        stringBuilder.append(", fileDescriptor=");
        object = this.fileDescriptor;
        stringBuilder.append(object);
        stringBuilder.append(", contentResolver=");
        object = this.contentResolver;
        stringBuilder.append(object);
        stringBuilder.append(", saveCollection=");
        object = this.saveCollection;
        stringBuilder.append(object);
        stringBuilder.append(", contentValues=");
        object = this.contentValues;
        stringBuilder.append(object);
        stringBuilder.append(", metadata=");
        object = this.metadata;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

