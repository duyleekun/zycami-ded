/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.net;

import android.net.Uri;

public final class UriCompat {
    private UriCompat() {
    }

    public static String toSafeString(Uri object) {
        String string2 = object.getScheme();
        CharSequence charSequence = object.getSchemeSpecificPart();
        int n10 = 58;
        int n11 = 64;
        if (string2 != null) {
            CharSequence charSequence2 = "tel";
            int n12 = string2.equalsIgnoreCase((String)charSequence2);
            if (n12 == 0 && (n12 = string2.equalsIgnoreCase((String)(charSequence2 = "sip"))) == 0 && (n12 = string2.equalsIgnoreCase((String)(charSequence2 = "sms"))) == 0 && (n12 = string2.equalsIgnoreCase((String)(charSequence2 = "smsto"))) == 0 && (n12 = string2.equalsIgnoreCase((String)(charSequence2 = "mailto"))) == 0 && (n12 = (int)(string2.equalsIgnoreCase((String)(charSequence2 = "nfc")) ? 1 : 0)) == 0) {
                charSequence2 = "http";
                n12 = (int)(string2.equalsIgnoreCase((String)charSequence2) ? 1 : 0);
                if (n12 != 0 || (n12 = (int)(string2.equalsIgnoreCase((String)(charSequence2 = "https")) ? 1 : 0)) != 0 || (n12 = (int)(string2.equalsIgnoreCase((String)(charSequence2 = "ftp")) ? 1 : 0)) != 0 || (n12 = (int)(string2.equalsIgnoreCase((String)(charSequence2 = "rtsp")) ? 1 : 0)) != 0) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("//");
                    charSequence2 = object.getHost();
                    String string3 = "";
                    charSequence2 = charSequence2 != null ? object.getHost() : string3;
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    n12 = object.getPort();
                    int n13 = -1;
                    if (n12 != n13) {
                        charSequence2 = new StringBuilder();
                        ((StringBuilder)charSequence2).append(":");
                        int n14 = object.getPort();
                        ((StringBuilder)charSequence2).append(n14);
                        string3 = ((StringBuilder)charSequence2).toString();
                    }
                    ((StringBuilder)charSequence).append(string3);
                    object = "/...";
                    ((StringBuilder)charSequence).append((String)object);
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            } else {
                object = new StringBuilder(n11);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append((char)n10);
                if (charSequence != null) {
                    string2 = null;
                    for (int i10 = 0; i10 < (n10 = ((String)charSequence).length()); ++i10) {
                        n10 = ((String)charSequence).charAt(i10);
                        if (n10 != (n12 = 45) && n10 != n11 && n10 != (n12 = 46)) {
                            n10 = 120;
                            ((StringBuilder)object).append((char)n10);
                            continue;
                        }
                        ((StringBuilder)object).append((char)n10);
                    }
                }
                return ((StringBuilder)object).toString();
            }
        }
        object = new StringBuilder(n11);
        if (string2 != null) {
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((char)n10);
        }
        if (charSequence != null) {
            ((StringBuilder)object).append((String)charSequence);
        }
        return ((StringBuilder)object).toString();
    }
}

