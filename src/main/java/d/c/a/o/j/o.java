/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.UriMatcher
 *  android.net.Uri
 *  android.provider.ContactsContract$Contacts
 */
package d.c.a.o.j;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import d.c.a.o.j.l;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class o
extends l {
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private static final int i = 5;
    private static final UriMatcher j;

    static {
        UriMatcher uriMatcher;
        j = uriMatcher = new UriMatcher(-1);
        String string2 = "com.android.contacts";
        int n10 = 1;
        uriMatcher.addURI(string2, "contacts/lookup/*/#", n10);
        uriMatcher.addURI(string2, "contacts/lookup/*", n10);
        uriMatcher.addURI(string2, "contacts/#/photo", 2);
        uriMatcher.addURI(string2, "contacts/#", 3);
        uriMatcher.addURI(string2, "contacts/#/display_photo", 4);
        uriMatcher.addURI(string2, "phone_lookup/*", 5);
    }

    public o(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream h(Uri object, ContentResolver contentResolver) {
        int n10;
        UriMatcher uriMatcher = j;
        int n11 = uriMatcher.match(object);
        if (n11 != (n10 = 1)) {
            n10 = 3;
            if (n11 != n10) {
                n10 = 5;
                if (n11 != n10) {
                    return contentResolver.openInputStream(object);
                }
            } else {
                return this.i(contentResolver, (Uri)object);
            }
        }
        if ((object = ContactsContract.Contacts.lookupContact((ContentResolver)contentResolver, (Uri)object)) != null) {
            return this.i(contentResolver, (Uri)object);
        }
        object = new FileNotFoundException("Contact cannot be found");
        throw object;
    }

    private InputStream i(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream((ContentResolver)contentResolver, (Uri)uri, (boolean)true);
    }

    public Class a() {
        return InputStream.class;
    }

    public void f(InputStream inputStream) {
        inputStream.close();
    }

    public InputStream g(Uri object, ContentResolver object2) {
        if ((object2 = this.h((Uri)object, (ContentResolver)object2)) != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InputStream is null for ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new FileNotFoundException((String)object);
        throw object2;
    }
}

