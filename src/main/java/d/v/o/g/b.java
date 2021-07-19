/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.v.o.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.rtmp.TXLiveBase;

public class b {
    private static String a = "http://license.vod2.myqcloud.com/license/v1/ae97dc0d0c4b27f4d235cd81b936ed02/TXLiveSDK.licence";
    private static String b = "85c5a61a18da321ce349e551035955e8";

    public static void a(Context object, String string2, String string3) {
        boolean bl2;
        boolean bl3 = false;
        Object object2 = null;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            String string4 = "TencentLivePusher";
            Log.e((String)string4, (String)"context can not be null , licenseUrl can not be null , licenseKey can not be null.\n");
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "context == null :";
            stringBuilder.append(string5);
            if (object == null) {
                bl3 = true;
            }
            stringBuilder.append(bl3);
            object = stringBuilder.toString();
            Log.i((String)string4, (String)object);
            object = new StringBuilder();
            object2 = "licenseUrl :";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.i((String)string4, (String)object);
            object = new StringBuilder();
            string2 = "licenseKey :";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            Log.i((String)string4, (String)object);
        } else {
            TXLiveBase.setConsoleEnabled(false);
            object2 = TXLiveBase.getInstance();
            ((TXLiveBase)object2).setLicence((Context)object, string2, string3);
        }
    }

    public static void b(Context object, String string2, String string3, boolean bl2) {
        boolean bl3;
        if (object != null && !(bl3 = TextUtils.isEmpty((CharSequence)string2)) && !(bl3 = TextUtils.isEmpty((CharSequence)string3))) {
            boolean bl4;
            String string4 = "TencentLivePusher";
            Log.e((String)string4, (String)"context can not be null , licenseUrl can not be null , licenseKey can not be null.\n");
            CharSequence charSequence = new StringBuilder();
            String string5 = "context == null :";
            charSequence.append(string5);
            if (object == null) {
                bl4 = true;
            } else {
                bl4 = false;
                object = null;
            }
            charSequence.append(bl4);
            object = charSequence.toString();
            Log.i((String)string4, (String)object);
            object = new StringBuilder();
            charSequence = "licenseUrl :";
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.i((String)string4, (String)object);
            object = new StringBuilder();
            string2 = "licenseKey :";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            Log.i((String)string4, (String)object);
        } else {
            TXLiveBase.setConsoleEnabled(bl2);
            TXLiveBase tXLiveBase = TXLiveBase.getInstance();
            tXLiveBase.setLicence((Context)object, string2, string3);
        }
    }

    public static void c(Context context, boolean bl2) {
        TXLiveBase.setConsoleEnabled(bl2);
        TXLiveBase tXLiveBase = TXLiveBase.getInstance();
        String string2 = a;
        String string3 = b;
        tXLiveBase.setLicence(context, string2, string3);
    }
}

