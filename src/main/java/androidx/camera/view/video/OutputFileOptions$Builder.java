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
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.OutputFileOptions;
import java.io.File;

public abstract class OutputFileOptions$Builder {
    public abstract OutputFileOptions build();

    public abstract OutputFileOptions$Builder setContentResolver(ContentResolver var1);

    public abstract OutputFileOptions$Builder setContentValues(ContentValues var1);

    public abstract OutputFileOptions$Builder setFile(File var1);

    public abstract OutputFileOptions$Builder setFileDescriptor(ParcelFileDescriptor var1);

    public abstract OutputFileOptions$Builder setMetadata(Metadata var1);

    public abstract OutputFileOptions$Builder setSaveCollection(Uri var1);
}

