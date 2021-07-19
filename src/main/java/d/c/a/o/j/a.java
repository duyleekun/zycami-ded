/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 */
package d.c.a.o.j;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import d.c.a.o.j.l;
import java.io.FileNotFoundException;

public final class a
extends l {
    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public Class a() {
        return AssetFileDescriptor.class;
    }

    public void f(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    public AssetFileDescriptor g(Uri object, ContentResolver object2) {
        CharSequence charSequence = "r";
        if ((object2 = object2.openAssetFileDescriptor(object, (String)charSequence)) != null) {
            return object2;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("FileDescriptor is null for: ");
        ((StringBuilder)charSequence).append(object);
        object = ((StringBuilder)charSequence).toString();
        object2 = new FileNotFoundException((String)object);
        throw object2;
    }
}

