/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.webkit.URLUtil
 */
package com.huawei.hms.hatool;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.hatool.i1;
import com.huawei.hms.hatool.y;
import d.j.f.a.a.h.c.d;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class t0 {
    public static final String[] a = new String[]{"e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d"};

    public static String a(String string2) {
        String string3;
        block9: {
            Object object;
            boolean bl2;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            string3 = "hmsSdk";
            if (bl3) {
                y.c(string3, "url is null");
                return string2;
            }
            bl3 = false;
            try {
                bl2 = URLUtil.isNetworkUrl((String)string2);
                if (!bl2) break block9;
            }
            catch (URISyntaxException uRISyntaxException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("getHostByURI error : ");
                String string4 = uRISyntaxException.getMessage();
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                y.b(string3, string4);
                return null;
            }
            object = Locale.US;
            object = string2.toLowerCase((Locale)object);
            String string5 = "http:";
            bl2 = ((String)object).startsWith(string5);
            if (bl2) break block9;
            object = new URI(string2);
            return ((URI)object).getHost();
        }
        string2 = "url don't starts with https";
        y.b(string3, string2);
        return null;
    }

    public static String a(String stringArray, int n10) {
        int n11 = TextUtils.isEmpty((CharSequence)stringArray);
        if (n11 == 0 && n10 > 0) {
            CharSequence charSequence = "\\.";
            n11 = (stringArray = stringArray.split((String)charSequence)).length;
            if (n11 < n10) {
                return "";
            }
            charSequence = new StringBuffer();
            int n12 = stringArray.length - n10;
            String string2 = stringArray[n12];
            ((StringBuffer)charSequence).append(string2);
            for (n12 = 1; n12 < n10; ++n12) {
                ((StringBuffer)charSequence).append(".");
                int n13 = stringArray.length - n10 + n12;
                String string3 = stringArray[n13];
                ((StringBuffer)charSequence).append(string3);
            }
            return ((StringBuffer)charSequence).toString();
        }
        y.c("hmsSdk", "url is null");
        return stringArray;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(String string2, String charSequence, int n10) {
        String string3;
        block7: {
            block8: {
                String string4;
                boolean bl2;
                block9: {
                    string2 = t0.a(string2);
                    bl2 = TextUtils.isEmpty((CharSequence)string2);
                    string3 = "hmsSdk";
                    if (bl2 || (bl2 = TextUtils.isEmpty((CharSequence)charSequence))) break block8;
                    string4 = t0.a(string2, n10);
                    bl2 = TextUtils.isEmpty((CharSequence)string4);
                    if (!bl2) break block9;
                    string2 = "get urlLastNStr is null";
                    break block7;
                }
                String string5 = d.b(string2);
                bl2 = ((String)charSequence).equals(string5);
                if (bl2) {
                    return true;
                }
                string5 = d.b(string4);
                int n11 = ((String)charSequence).equals(string5);
                if (n11 == 0) {
                    return false;
                }
                try {
                    n11 = string2.length();
                    n10 = string4.length();
                    string2 = string2.substring(0, n11 -= n10);
                    charSequence = ".";
                    n11 = (int)(string2.endsWith((String)charSequence) ? 1 : 0);
                    if (n11 == 0) {
                        return false;
                    }
                    charSequence = "^[A-Za-z0-9.-]+$";
                    return string2.matches((String)charSequence);
                }
                catch (Exception exception) {
                    block10: {
                        charSequence = new StringBuilder();
                        string4 = "Exception : ";
                        ((StringBuilder)charSequence).append(string4);
                        string2 = exception.getMessage();
                        break block10;
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            charSequence = new StringBuilder();
                            string4 = "IndexOutOfBoundsException";
                            ((StringBuilder)charSequence).append(string4);
                            string2 = indexOutOfBoundsException.getMessage();
                        }
                    }
                    ((StringBuilder)charSequence).append(string2);
                    string2 = ((StringBuilder)charSequence).toString();
                    break block7;
                }
            }
            string2 = "url or whitelistHash is null";
        }
        y.b(string3, string2);
        return false;
    }

    public static boolean b(String string2) {
        String[] stringArray = i1.a;
        boolean bl2 = stringArray.booleanValue();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        for (String string3 : a) {
            int n10 = 2;
            boolean bl4 = t0.a(string2, string3, n10);
            if (!bl4) continue;
            return bl3;
        }
        return false;
    }
}

