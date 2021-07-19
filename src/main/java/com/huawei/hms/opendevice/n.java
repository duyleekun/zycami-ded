/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.m;
import com.huawei.hms.opendevice.n$a;
import com.huawei.hms.opendevice.n$b;
import com.huawei.hms.opendevice.r;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import d.j.a.f.a;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    public static void a(Context context, String string2) {
        m m10 = new m(context, string2);
        m10.start();
    }

    public static /* synthetic */ void a(Context context, String string2, String string3, String string4) {
        n.b(context, string2, string3, string4);
    }

    public static /* synthetic */ boolean a(Context context) {
        return n.b(context);
    }

    public static /* synthetic */ boolean a(Context context, String string2, String string3) {
        return n.d(context, string2, string3);
    }

    public static /* synthetic */ String b(Context context, String string2, String string3) {
        return n.c(context, string2, string3);
    }

    public static void b(Context object, String charSequence, String string2, String string3) {
        int n10;
        JSONObject jSONObject;
        String string4;
        block25: {
            boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
            string4 = "ReportAaidToken";
            if (bl2) {
                HMSLog.e(string4, "Https response is empty.");
                return;
            }
            jSONObject = new JSONObject((String)charSequence);
            charSequence = "ret";
            int n11 = 256;
            n10 = jSONObject.optInt((String)charSequence, n11);
            if (n10 != 0) break block25;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            string2 = "SHA-256";
            charSequence = r.a((String)charSequence, string2);
            object = i.a((Context)object);
            string2 = "reportAaidAndToken";
            boolean bl3 = ((PushPreferences)object).saveString(string2, (String)charSequence);
            charSequence = new StringBuilder();
            string2 = "Report success ";
            ((StringBuilder)charSequence).append(string2);
            object = bl3 ? "and save success." : "but save failure.";
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            HMSLog.d(string4, (String)object);
            return;
        }
        object = new StringBuilder();
        string2 = "Https response body's ret code: ";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        charSequence = ", error message: ";
        ((StringBuilder)object).append((String)charSequence);
        charSequence = "msg";
        charSequence = jSONObject.optString((String)charSequence);
        ((StringBuilder)object).append((String)charSequence);
        object = ((StringBuilder)object).toString();
        try {
            HMSLog.e(string4, (String)object);
        }
        catch (Exception exception) {
            object = "Exception occur.";
            HMSLog.e(string4, (String)object);
        }
        catch (JSONException jSONException) {
            object = "Has JSONException.";
            HMSLog.e(string4, (String)object);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static boolean b(Context object) {
        void var2_5;
        int n10;
        int n11;
        Object object2 = new PackageManagerHelper((Context)object);
        object = "com.huawei.android.pushagent";
        int bl2 = ((PackageManagerHelper)object2).getPackageVersionCode((String)object);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("NC version code: ");
        ((StringBuilder)object2).append(bl2);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "ReportAaidToken";
        HMSLog.d(string2, (String)object2);
        int n12 = 90101400;
        if (n12 <= bl2 && bl2 < (n11 = 100000000) || bl2 >= (n10 = 100001301)) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        return (boolean)var2_5;
    }

    public static String c(Context object, String string2, String object2) {
        JSONObject jSONObject;
        String string3 = "region";
        try {
            jSONObject = new JSONObject();
        }
        catch (JSONException jSONException) {
            HMSLog.e("ReportAaidToken", "Catch JSONException.");
            return null;
        }
        Object object3 = new JSONObject();
        String string4 = "timezone";
        Object object4 = TimeZone.getDefault();
        object4 = ((TimeZone)object4).getID();
        object3.put(string4, object4);
        string4 = "country";
        object4 = SystemUtils.getLocalCountry();
        object3.put(string4, object4);
        string4 = new JSONObject();
        object4 = new PackageManagerHelper((Context)object);
        String string5 = "com.huawei.android.pushagent";
        object4 = ((PackageManagerHelper)object4).getPackageVersionName(string5);
        string5 = "agent_version";
        string4.put(string5, object4);
        object4 = "hms_version";
        int n10 = Util.getHmsVersion((Context)object);
        string5 = String.valueOf(n10);
        string4.put((String)object4, (Object)string5);
        object4 = new JSONObject();
        string5 = "dev_type";
        Object object5 = n$a.a;
        object5 = ((n$a)((Object)object5)).a();
        object4.put(string5, object5);
        string5 = "dev_sub_type";
        object5 = "phone";
        object4.put(string5, object5);
        string5 = "os_type";
        object5 = n$b.b;
        object5 = ((n$b)((Object)object5)).a();
        object4.put(string5, object5);
        string5 = "os_version";
        int n11 = HwBuildEx$VERSION.EMUI_SDK_INT;
        object5 = String.valueOf(n11);
        object4.put(string5, object5);
        string5 = "id";
        object5 = UUID.randomUUID();
        object5 = ((UUID)object5).toString();
        jSONObject.put(string5, object5);
        string5 = "global";
        jSONObject.put(string5, object3);
        object3 = "push_agent";
        jSONObject.put((String)object3, (Object)string4);
        object3 = "hardware";
        jSONObject.put((String)object3, object4);
        object3 = "aaid";
        jSONObject.put((String)object3, (Object)string2);
        string2 = "token";
        jSONObject.put(string2, object2);
        string2 = "app_id";
        object2 = a.a((Context)object);
        object3 = "client/app_id";
        object2 = ((a)object2).g((String)object3);
        jSONObject.put(string2, object2);
        object = a.a((Context)object);
        object = ((a)object).g(string3);
        jSONObject.put(string3, object);
        return jSONObject.toString();
    }

    public static boolean d(Context object, String string2, String string3) {
        object = i.a((Context)object);
        CharSequence charSequence = "reportAaidAndToken";
        boolean bl2 = ((PushPreferences)object).containsKey((String)charSequence);
        String string4 = "ReportAaidToken";
        boolean bl3 = true;
        if (!bl2) {
            HMSLog.d(string4, "It hasn't been reported, this time needs report.");
            return bl3;
        }
        boolean bl4 = TextUtils.isEmpty((CharSequence)(object = ((PushPreferences)object).getString((String)charSequence)));
        if (bl4) {
            HMSLog.e(string4, "It has been reported, but sp file is empty, this time needs report.");
            return bl3;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        string2 = r.a(((StringBuilder)charSequence).toString(), "SHA-256");
        return ((String)object).equals(string2) ^ bl3;
    }
}

