/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.j;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import d.c.a.o.j.l;
import java.io.FileNotFoundException;

public class i
extends l {
    public i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public Class a() {
        return ParcelFileDescriptor.class;
    }

    public void f(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    public ParcelFileDescriptor g(Uri object, ContentResolver object2) {
        CharSequence charSequence = "r";
        if ((object2 = object2.openAssetFileDescriptor(object, (String)charSequence)) != null) {
            return object2.getParcelFileDescriptor();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("FileDescriptor is null for: ");
        ((StringBuilder)charSequence).append(object);
        object = ((StringBuilder)charSequence).toString();
        object2 = new FileNotFoundException((String)object);
        throw object2;
    }
}

