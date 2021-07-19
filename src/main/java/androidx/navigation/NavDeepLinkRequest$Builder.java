/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.navigation;

import android.net.Uri;
import androidx.navigation.NavDeepLinkRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NavDeepLinkRequest$Builder {
    private String mAction;
    private String mMimeType;
    private Uri mUri;

    private NavDeepLinkRequest$Builder() {
    }

    public static NavDeepLinkRequest$Builder fromAction(String object) {
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            NavDeepLinkRequest$Builder navDeepLinkRequest$Builder = new NavDeepLinkRequest$Builder();
            navDeepLinkRequest$Builder.setAction((String)object);
            return navDeepLinkRequest$Builder;
        }
        object = new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
        throw object;
    }

    public static NavDeepLinkRequest$Builder fromMimeType(String string2) {
        NavDeepLinkRequest$Builder navDeepLinkRequest$Builder = new NavDeepLinkRequest$Builder();
        navDeepLinkRequest$Builder.setMimeType(string2);
        return navDeepLinkRequest$Builder;
    }

    public static NavDeepLinkRequest$Builder fromUri(Uri uri) {
        NavDeepLinkRequest$Builder navDeepLinkRequest$Builder = new NavDeepLinkRequest$Builder();
        navDeepLinkRequest$Builder.setUri(uri);
        return navDeepLinkRequest$Builder;
    }

    public NavDeepLinkRequest build() {
        Uri uri = this.mUri;
        String string2 = this.mAction;
        String string3 = this.mMimeType;
        NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(uri, string2, string3);
        return navDeepLinkRequest;
    }

    public NavDeepLinkRequest$Builder setAction(String object) {
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            this.mAction = object;
            return this;
        }
        object = new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
        throw object;
    }

    public NavDeepLinkRequest$Builder setMimeType(String string2) {
        Object object = Pattern.compile("^[-\\w*.]+/[-\\w+*.]+$").matcher(string2);
        boolean bl2 = ((Matcher)object).matches();
        if (bl2) {
            this.mMimeType = string2;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The given mimeType ");
        stringBuilder.append(string2);
        stringBuilder.append(" does not match to required \"type/subtype\" format");
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public NavDeepLinkRequest$Builder setUri(Uri uri) {
        this.mUri = uri;
        return this;
    }
}

