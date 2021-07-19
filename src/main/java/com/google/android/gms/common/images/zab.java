/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

public final class zab {
    public final Uri uri;

    public zab(Uri uri) {
        this.uri = uri;
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof zab;
        if (!bl2) {
            return false;
        }
        if (this == object) {
            return true;
        }
        object = ((zab)object).uri;
        Uri uri = this.uri;
        return Objects.equal(object, uri);
    }

    public final int hashCode() {
        Object[] objectArray = new Object[1];
        Uri uri = this.uri;
        objectArray[0] = uri;
        return Objects.hashCode(objectArray);
    }
}

