/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.navigation.NavDeepLink;

public final class NavDeepLink$Builder {
    private String mAction;
    private String mMimeType;
    private String mUriPattern;

    public static NavDeepLink$Builder fromAction(String object) {
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            NavDeepLink$Builder navDeepLink$Builder = new NavDeepLink$Builder();
            navDeepLink$Builder.setAction((String)object);
            return navDeepLink$Builder;
        }
        object = new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        throw object;
    }

    public static NavDeepLink$Builder fromMimeType(String string2) {
        NavDeepLink$Builder navDeepLink$Builder = new NavDeepLink$Builder();
        navDeepLink$Builder.setMimeType(string2);
        return navDeepLink$Builder;
    }

    public static NavDeepLink$Builder fromUriPattern(String string2) {
        NavDeepLink$Builder navDeepLink$Builder = new NavDeepLink$Builder();
        navDeepLink$Builder.setUriPattern(string2);
        return navDeepLink$Builder;
    }

    public NavDeepLink build() {
        String string2 = this.mUriPattern;
        String string3 = this.mAction;
        String string4 = this.mMimeType;
        NavDeepLink navDeepLink = new NavDeepLink(string2, string3, string4);
        return navDeepLink;
    }

    public NavDeepLink$Builder setAction(String object) {
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            this.mAction = object;
            return this;
        }
        object = new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        throw object;
    }

    public NavDeepLink$Builder setMimeType(String string2) {
        this.mMimeType = string2;
        return this;
    }

    public NavDeepLink$Builder setUriPattern(String string2) {
        this.mUriPattern = string2;
        return this;
    }
}

