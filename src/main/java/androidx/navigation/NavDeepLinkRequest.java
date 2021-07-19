/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 */
package androidx.navigation;

import android.content.Intent;
import android.net.Uri;

public class NavDeepLinkRequest {
    private final String mAction;
    private final String mMimeType;
    private final Uri mUri;

    public NavDeepLinkRequest(Intent object) {
        Uri uri = object.getData();
        String string2 = object.getAction();
        object = object.getType();
        this(uri, string2, (String)object);
    }

    public NavDeepLinkRequest(Uri uri, String string2, String string3) {
        this.mUri = uri;
        this.mAction = string2;
        this.mMimeType = string3;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NavDeepLinkRequest");
        stringBuilder.append("{");
        Object object = this.mUri;
        if (object != null) {
            stringBuilder.append(" uri=");
            object = this.mUri.toString();
            stringBuilder.append((String)object);
        }
        if ((object = this.mAction) != null) {
            stringBuilder.append(" action=");
            object = this.mAction;
            stringBuilder.append((String)object);
        }
        if ((object = this.mMimeType) != null) {
            stringBuilder.append(" mimetype=");
            object = this.mMimeType;
            stringBuilder.append((String)object);
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}

