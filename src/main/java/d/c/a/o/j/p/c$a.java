/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.MediaStore$Images$Thumbnails
 */
package d.c.a.o.j.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import d.c.a.o.j.p.d;

public class c$a
implements d {
    private static final String[] b = new String[]{"_data"};
    private static final String c = "kind = 1 AND image_id = ?";
    private final ContentResolver a;

    public c$a(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public Cursor a(Uri object) {
        object = object.getLastPathSegment();
        ContentResolver contentResolver = this.a;
        Uri uri = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
        String[] stringArray = b;
        String[] stringArray2 = new String[]{object};
        return contentResolver.query(uri, stringArray, c, stringArray2, null);
    }
}

