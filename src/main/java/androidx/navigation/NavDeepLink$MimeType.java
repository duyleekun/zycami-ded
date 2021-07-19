/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

public class NavDeepLink$MimeType
implements Comparable {
    public String mSubType;
    public String mType;

    public NavDeepLink$MimeType(String object) {
        String string2;
        object = object.split("/", -1);
        this.mType = string2 = object[0];
        this.mSubType = object = object[1];
    }

    public int compareTo(NavDeepLink$MimeType object) {
        String string2 = this.mType;
        String string3 = ((NavDeepLink$MimeType)object).mType;
        int n10 = string2.equals(string3);
        if (n10 != 0) {
            n10 = 2;
        } else {
            n10 = 0;
            string2 = null;
        }
        string3 = this.mSubType;
        object = ((NavDeepLink$MimeType)object).mSubType;
        boolean bl2 = string3.equals(object);
        if (bl2) {
            ++n10;
        }
        return n10;
    }
}

