/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.v.o;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.Deflater;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static final int a = 1400457866;
    private static final int b = 604800;
    private static final String c = "053066aec10a5701532b6a2913fd5792c5573475ffa2925e96451465c744795f";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(long l10, String string2, long l11, byte[] byArray, String string3) {
        Object object;
        Object object2;
        JSONObject jSONObject;
        long l12;
        Object object3;
        int n10;
        Object object4;
        block17: {
            block16: {
                object4 = byArray;
                n10 = TextUtils.isEmpty((CharSequence)string3);
                object3 = "";
                if (n10 != 0) {
                    return object3;
                }
                long l13 = System.currentTimeMillis();
                long l14 = 1000L;
                l12 = l13 / l14;
                jSONObject = new JSONObject();
                object2 = "TLS.ver";
                String string4 = "2.0";
                try {
                    jSONObject.put((String)object2, (Object)string4);
                    object2 = "TLS.identifier";
                    string4 = string2;
                }
                catch (JSONException jSONException) {
                    l14 = l10;
                    string4 = string2;
                    break block16;
                }
                try {
                    jSONObject.put((String)object2, (Object)string2);
                    object2 = "TLS.sdkappid";
                    l14 = l10;
                }
                catch (JSONException jSONException) {
                    l14 = l10;
                    break block16;
                }
                try {
                    jSONObject.put((String)object2, l10);
                    object2 = "TLS.expire";
                }
                catch (JSONException jSONException) {
                    break block16;
                }
                try {
                    jSONObject.put((String)object2, l11);
                    object2 = "TLS.time";
                    jSONObject.put((String)object2, l12);
                    break block17;
                }
                catch (JSONException jSONException) {}
            }
            object2.printStackTrace();
        }
        n10 = 0;
        object2 = null;
        if (object4 != null) {
            n10 = 2;
            object4 = Base64.encodeToString((byte[])object4, (int)n10);
            object2 = "TLS.userbuf";
            try {
                jSONObject.put((String)object2, object4);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            object = object4;
        } else {
            object = null;
        }
        object2 = d.v.o.c.d(l10, string2, l12, l11, string3, object);
        int n11 = ((String)object2).length();
        if (n11 == 0) {
            return object3;
        }
        object4 = "TLS.sig";
        try {
            jSONObject.put((String)object4, object2);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        object2 = new Deflater();
        object4 = jSONObject.toString();
        object3 = Charset.forName("UTF-8");
        object4 = object4.getBytes((Charset)object3);
        ((Deflater)object2).setInput((byte[])object4);
        ((Deflater)object2).finish();
        object4 = new byte[2048];
        int n12 = ((Deflater)object2).deflate((byte[])object4);
        ((Deflater)object2).end();
        object4 = d.v.o.c.b(Arrays.copyOfRange(object4, 0, n12));
        return new String((byte[])object4);
    }

    private static byte[] b(byte[] byArray) {
        int n10 = 2;
        byArray = Base64.encode((byte[])byArray, (int)n10);
        String string2 = new String(byArray);
        byArray = string2.getBytes();
        string2 = null;
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray[i10];
            int n11 = 43;
            if (n10 != n11) {
                n11 = 47;
                if (n10 != n11) {
                    n11 = 61;
                    if (n10 != n11) continue;
                    byArray[i10] = n10 = 95;
                    continue;
                }
                byArray[i10] = n10 = 45;
                continue;
            }
            byArray[i10] = n10 = 42;
        }
        return byArray;
    }

    public static String c(String string2) {
        return d.v.o.c.a(1400457866L, string2, 604800L, null, c);
    }

    private static String d(long l10, String object, long l11, long l12, String string2, String string3) {
        String string4 = "HmacSHA256";
        String string5 = "UTF-8";
        StringBuilder stringBuilder = new StringBuilder();
        String string6 = "TLS.identifier:";
        stringBuilder.append(string6);
        stringBuilder.append((String)object);
        object = "\nTLS.sdkappid:";
        stringBuilder.append((String)object);
        stringBuilder.append(l10);
        stringBuilder.append("\nTLS.time:");
        stringBuilder.append(l11);
        stringBuilder.append("\nTLS.expire:");
        stringBuilder.append(l12);
        Object object2 = "\n";
        stringBuilder.append((String)object2);
        String string7 = stringBuilder.toString();
        if (string3 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string7);
            ((StringBuilder)object).append("TLS.userbuf:");
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append((String)object2);
            string7 = ((StringBuilder)object).toString();
        }
        try {
            object2 = string2.getBytes(string5);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
        object = Mac.getInstance(string4);
        SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object2, string4);
        ((Mac)object).init(secretKeySpec);
        object2 = string7.getBytes(string5);
        object2 = ((Mac)object).doFinal((byte[])object2);
        int n10 = 2;
        object2 = Base64.encode((byte[])object2, (int)n10);
        string7 = new String((byte[])object2);
        return string7;
    }
}

