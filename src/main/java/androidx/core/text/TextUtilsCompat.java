/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class TextUtilsCompat {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT;

    static {
        Locale locale;
        String string2 = "";
        ROOT = locale = new Locale(string2, string2);
    }

    private TextUtilsCompat() {
    }

    private static int getLayoutDirectionFromFirstChar(Locale object) {
        byte by2;
        byte by3;
        byte by4 = Character.getDirectionality(((String)(object = ((Locale)object).getDisplayName((Locale)object))).charAt(0));
        if (by4 != (by3 = 1) && by4 != (by2 = 2)) {
            return 0;
        }
        return by3;
    }

    public static int getLayoutDirectionFromLocale(Locale object) {
        Object object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return TextUtils.getLayoutDirectionFromLocale((Locale)object);
        }
        if (object != null && (n10 = (int)(((Locale)object).equals(object2 = ROOT) ? 1 : 0)) == 0) {
            object2 = ICUCompat.maximizeAndGetScript((Locale)object);
            if (object2 == null) {
                return TextUtilsCompat.getLayoutDirectionFromFirstChar((Locale)object);
            }
            object = ARAB_SCRIPT_SUBTAG;
            boolean bl2 = ((String)object2).equalsIgnoreCase((String)object);
            if (bl2 || (bl2 = ((String)object2).equalsIgnoreCase((String)(object = HEBR_SCRIPT_SUBTAG)))) {
                return 1;
            }
        }
        return 0;
    }

    public static String htmlEncode(String string2) {
        char c10;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return TextUtils.htmlEncode((String)string2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (n11 = 0; n11 < (c10 = string2.length()); ++n11) {
            String string3;
            char c11;
            c10 = string2.charAt(n11);
            if (c10 != (c11 = '\"')) {
                c11 = '<';
                if (c10 != c11) {
                    c11 = '>';
                    if (c10 != c11) {
                        c11 = '&';
                        if (c10 != c11) {
                            c11 = '\'';
                            if (c10 != c11) {
                                stringBuilder.append(c10);
                                continue;
                            }
                            string3 = "&#39;";
                            stringBuilder.append(string3);
                            continue;
                        }
                        string3 = "&amp;";
                        stringBuilder.append(string3);
                        continue;
                    }
                    string3 = "&gt;";
                    stringBuilder.append(string3);
                    continue;
                }
                string3 = "&lt;";
                stringBuilder.append(string3);
                continue;
            }
            string3 = "&quot;";
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }
}

