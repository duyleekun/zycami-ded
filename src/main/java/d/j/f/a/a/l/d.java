/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 *  android.webkit.URLUtil
 */
package d.j.f.a.a.l;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;

public class d {
    private static final String a = "UriUtil";

    public static String a(String string2) {
        Object object;
        block7: {
            String string3 = "";
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            String string4 = a;
            if (bl2) {
                LogsUtil.r(string4, "url is null");
                return string2;
            }
            try {
                bl2 = URLUtil.isNetworkUrl((String)string2);
                if (bl2) break block7;
                string2 = "url don't starts with http or https";
            }
            catch (MalformedURLException malformedURLException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("getHostByURI error  MalformedURLException : ");
                String string5 = malformedURLException.getMessage();
                ((StringBuilder)object).append(string5);
                string5 = ((StringBuilder)object).toString();
                LogsUtil.l(string4, string5);
                return string3;
            }
            LogsUtil.l(string4, string2);
            return string3;
        }
        object = "[\\\\#]";
        String string6 = "/";
        string2 = string2.replaceAll((String)object, string6);
        object = new URL(string2);
        return ((URL)object).getHost();
    }

    private static String b(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            LogsUtil.r(a, "whiteListUrl is null");
            return null;
        }
        bl2 = URLUtil.isNetworkUrl((String)string2);
        if (!bl2) {
            return string2;
        }
        return d.a(string2);
    }

    public static boolean c(String string2, String[] stringArray) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            for (String string3 : stringArray) {
                boolean bl2 = d.d(string2, string3);
                if (!bl2) continue;
                return true;
            }
            return false;
        }
        LogsUtil.l(a, "whitelist is null");
        return false;
    }

    public static boolean d(String string2, String string3) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)string3)) == 0) {
            Object object = "..";
            n10 = string2.contains((CharSequence)object);
            if (n10 == 0 && (n10 = string2.contains((CharSequence)(object = "@"))) == 0) {
                n10 = string3.equals(string2);
                int n11 = 1;
                if (n10 == 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string3);
                    Object object2 = "?";
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    n10 = string2.startsWith((String)object);
                    if (n10 == 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string3);
                        object2 = "#";
                        ((StringBuilder)object).append((String)object2);
                        object = ((StringBuilder)object).toString();
                        n10 = string2.startsWith((String)object);
                        if (n10 == 0) {
                            object = "/";
                            n10 = string3.endsWith((String)object);
                            if (n10 == 0) {
                                return false;
                            }
                            object = Uri.parse((String)string3).getPathSegments();
                            object2 = Uri.parse((String)string2).getPathSegments();
                            int n12 = object2.size();
                            n10 = object.size();
                            if ((n12 -= n10) != n11) {
                                return false;
                            }
                            return string2.startsWith(string3);
                        }
                    }
                }
                return n11 != 0;
            }
            string2 = a;
            string3 = "url contains unsafe char";
            Log.e((String)string2, (String)string3);
        }
        return false;
    }

    public static boolean e(String string2, String[] stringArray) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            for (String string3 : stringArray) {
                boolean bl2 = d.f(string2, string3);
                if (!bl2) continue;
                return true;
            }
            return false;
        }
        LogsUtil.l(a, "whitelist is null");
        return false;
    }

    public static boolean f(String string2, String charSequence) {
        boolean bl2;
        string2 = d.a(string2);
        boolean n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = a;
        if (!n10 && !(bl2 = TextUtils.isEmpty((CharSequence)charSequence))) {
            boolean bl3 = TextUtils.isEmpty((CharSequence)(charSequence = d.b((String)charSequence)));
            if (bl3) {
                Log.e((String)string3, (String)"whitelist host is null");
                return false;
            }
            boolean bl4 = ((String)charSequence).equals(string2);
            if (bl4) {
                return true;
            }
            boolean bl5 = string2.endsWith((String)charSequence);
            if (bl5) {
                int n11 = string2.length();
                int n12 = ((String)charSequence).length();
                int n13 = n11 - n12;
                string2 = string2.substring(0, n13);
                charSequence = ".";
                n12 = (int)(string2.endsWith((String)charSequence) ? 1 : 0);
                if (n12 == 0) {
                    return false;
                }
                charSequence = "^[A-Za-z0-9.-]+$";
                try {
                    return string2.matches((String)charSequence);
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("Exception : ");
                    String string4 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string4);
                    string4 = ((StringBuilder)charSequence).toString();
                    LogsUtil.l(string3, string4);
                    return false;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    charSequence = new StringBuilder();
                    String string4 = "IndexOutOfBoundsException";
                    ((StringBuilder)charSequence).append(string4);
                    String string6 = indexOutOfBoundsException.getMessage();
                    ((StringBuilder)charSequence).append(string6);
                    string6 = ((StringBuilder)charSequence).toString();
                    LogsUtil.l(string3, string6);
                }
            }
            return false;
        }
        LogsUtil.l(string3, "url or whitelist is null");
        return false;
    }

    public static boolean g(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            string2 = d.a(string2);
            string3 = d.b(string3);
            return TextUtils.equals((CharSequence)string2, (CharSequence)string3);
        }
        Log.e((String)a, (String)"isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean h(String string2, String[] stringArray) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            for (String string3 : stringArray) {
                boolean bl2 = d.g(string2, string3);
                if (!bl2) continue;
                return true;
            }
            return false;
        }
        LogsUtil.l(a, "whitelist is null");
        return false;
    }
}

