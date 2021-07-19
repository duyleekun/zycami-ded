/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.net;

import android.net.Uri;
import androidx.core.net.ParseException;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap mHeaders;

    private MailTo() {
        HashMap hashMap;
        this.mHeaders = hashMap = new HashMap();
    }

    public static boolean isMailTo(Uri object) {
        String string2;
        boolean bl2;
        if (object != null && (bl2 = (string2 = MAILTO).equals(object = object.getScheme()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean isMailTo(String string2) {
        String string3;
        boolean bl2;
        if (string2 != null && (bl2 = string2.startsWith(string3 = MAILTO_SCHEME))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static MailTo parse(Uri uri) {
        return MailTo.parse(uri.toString());
    }

    public static MailTo parse(String stringArray) {
        Preconditions.checkNotNull(stringArray);
        int n10 = MailTo.isMailTo((String)stringArray);
        if (n10 != 0) {
            String string2;
            n10 = stringArray.indexOf(35);
            int n11 = -1;
            StringBuilder stringBuilder = null;
            if (n10 != n11) {
                stringArray = stringArray.substring(0, n10);
            }
            n10 = stringArray.indexOf(63);
            int n12 = 7;
            int n13 = 1;
            if (n10 == n11) {
                string2 = Uri.decode((String)stringArray.substring(n12));
                stringArray = null;
            } else {
                string2 = Uri.decode((String)stringArray.substring(n12, n10));
                stringArray = stringArray.substring(n10 += n13);
            }
            MailTo mailTo = new MailTo();
            if (stringArray != null) {
                String string3 = "&";
                stringArray = stringArray.split(string3);
                n12 = stringArray.length;
                for (int i10 = 0; i10 < n12; ++i10) {
                    Object object = stringArray[i10];
                    Object object2 = "=";
                    int n14 = ((String[])(object = object.split((String)object2, 2))).length;
                    if (n14 == 0) continue;
                    String string4 = Uri.decode((String)object[0]);
                    object2 = Locale.ROOT;
                    string4 = string4.toLowerCase((Locale)object2);
                    int n15 = ((String[])object).length;
                    object = n15 > n13 ? Uri.decode((String)object[n13]) : null;
                    object2 = mailTo.mHeaders;
                    ((HashMap)object2).put(string4, object);
                }
            }
            if ((stringArray = mailTo.getTo()) != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(", ");
                stringBuilder.append((String)stringArray);
                string2 = stringBuilder.toString();
            }
            mailTo.mHeaders.put(TO, string2);
            return mailTo;
        }
        stringArray = new ParseException("Not a mailto scheme");
        throw stringArray;
    }

    public String getBcc() {
        return (String)this.mHeaders.get(BCC);
    }

    public String getBody() {
        return (String)this.mHeaders.get(BODY);
    }

    public String getCc() {
        return (String)this.mHeaders.get(CC);
    }

    public Map getHeaders() {
        return this.mHeaders;
    }

    public String getSubject() {
        return (String)this.mHeaders.get(SUBJECT);
    }

    public String getTo() {
        return (String)this.mHeaders.get(TO);
    }

    public String toString() {
        char c10;
        StringBuilder stringBuilder = new StringBuilder(MAILTO_SCHEME);
        char c11 = '?';
        stringBuilder.append(c11);
        Iterator iterator2 = this.mHeaders.entrySet().iterator();
        while ((c10 = iterator2.hasNext()) != '\u0000') {
            Object object = iterator2.next();
            String string2 = Uri.encode((String)((String)object.getKey()));
            stringBuilder.append(string2);
            char c12 = '=';
            stringBuilder.append(c12);
            object = Uri.encode((String)((String)object.getValue()));
            stringBuilder.append((String)object);
            c10 = '&';
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }
}

