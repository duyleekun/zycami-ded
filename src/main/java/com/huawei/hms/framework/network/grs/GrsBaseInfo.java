/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GrsBaseInfo
implements Cloneable {
    private static final String TAG = "GrsBaseInfo";
    private String androidVersion;
    private String appName;
    private String countrySource;
    private String deviceModel;
    private String issueCountry;
    private String regCountry;
    private String romVersion;
    private String serCountry;
    private String uid;
    private String versionName;

    public GrsBaseInfo() {
    }

    public GrsBaseInfo(Context object) {
        object = GrsApp.getInstance().getIssueCountryCode((Context)object);
        this.issueCountry = object;
    }

    private StringBuffer getStringBuffer(StringBuffer stringBuffer, boolean bl2, Context object) {
        boolean bl3;
        String string2;
        boolean bl4;
        String string3;
        Object object2 = this.getAndroidVersion();
        boolean bl5 = TextUtils.isEmpty((CharSequence)object2);
        String string4 = "&";
        String string5 = "=";
        if (!bl5) {
            string3 = stringBuffer.toString();
            bl5 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl5) {
                stringBuffer.append(string4);
            }
            string3 = "android_version";
            stringBuffer.append(string3);
            stringBuffer.append(string5);
            stringBuffer.append((String)object2);
        }
        if (!(bl5 = TextUtils.isEmpty((CharSequence)(object2 = this.getRomVersion())))) {
            string3 = stringBuffer.toString();
            bl5 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl5) {
                stringBuffer.append(string4);
            }
            string3 = "rom_version";
            stringBuffer.append(string3);
            stringBuffer.append(string5);
            stringBuffer.append((String)object2);
        }
        if (!(bl5 = TextUtils.isEmpty((CharSequence)(object2 = this.getDeviceModel())))) {
            string3 = stringBuffer.toString();
            bl5 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl5) {
                stringBuffer.append(string4);
            }
            string3 = "device_model";
            stringBuffer.append(string3);
            stringBuffer.append(string5);
            stringBuffer.append((String)object2);
        }
        if (!(bl4 = TextUtils.isEmpty((CharSequence)(object = ((c)(object2 = new c((Context)object, string3 = "share_pre_grs_conf_"))).b()))) && !bl2) {
            block17: {
                string2 = "UTF-8";
                string2 = URLEncoder.encode((String)object, string2);
                object = stringBuffer.toString();
                bl3 = TextUtils.isEmpty((CharSequence)object);
                if (bl3) break block17;
                stringBuffer.append(string4);
            }
            object = "cp";
            stringBuffer.append((String)object);
            stringBuffer.append(string5);
            try {
                stringBuffer.append(string2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object = TAG;
                object2 = "cp UnsupportedEncodingException.";
                Logger.e((String)object, (String)object2, unsupportedEncodingException);
            }
        }
        if (!(bl3 = TextUtils.isEmpty((CharSequence)(string2 = this.getCountrySource())))) {
            object = stringBuffer.toString();
            bl3 = TextUtils.isEmpty((CharSequence)object);
            if (!bl3) {
                stringBuffer.append(string4);
            }
            object = "country_source";
            stringBuffer.append((String)object);
            stringBuffer.append(string5);
            stringBuffer.append(string2);
        }
        return stringBuffer;
    }

    private boolean isEqual(String string2, String string3) {
        boolean bl2;
        boolean bl3 = true;
        if (string2 == null && string3 == null) {
            return bl3;
        }
        if (string2 != null && string3 != null && (bl2 = string2.equals(string3))) {
            return bl3;
        }
        return false;
    }

    public GrsBaseInfo clone() {
        return (GrsBaseInfo)super.clone();
    }

    public boolean compare(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        if (object != null && (object3 = GrsBaseInfo.class) == (object2 = object.getClass()) && (bl2 = object instanceof GrsBaseInfo)) {
            boolean bl4;
            object = (GrsBaseInfo)object;
            object2 = this.serCountry;
            object3 = ((GrsBaseInfo)object).serCountry;
            bl2 = this.isEqual((String)object2, (String)object3);
            if (!(bl2 && (bl2 = this.isEqual((String)(object2 = this.versionName), (String)(object3 = ((GrsBaseInfo)object).versionName))) && (bl2 = this.isEqual((String)(object2 = this.appName), (String)(object3 = ((GrsBaseInfo)object).appName))) && (bl2 = this.isEqual((String)(object2 = this.uid), (String)(object3 = ((GrsBaseInfo)object).uid))) && (bl2 = this.isEqual((String)(object2 = this.regCountry), (String)(object3 = ((GrsBaseInfo)object).regCountry))) && (bl2 = this.isEqual((String)(object2 = this.issueCountry), (String)(object3 = ((GrsBaseInfo)object).issueCountry))) && (bl2 = this.isEqual((String)(object2 = this.androidVersion), (String)(object3 = ((GrsBaseInfo)object).androidVersion))) && (bl2 = this.isEqual((String)(object2 = this.romVersion), (String)(object3 = ((GrsBaseInfo)object).romVersion))) && (bl2 = this.isEqual((String)(object2 = this.deviceModel), (String)(object3 = ((GrsBaseInfo)object).deviceModel))) && (bl4 = this.isEqual((String)(object2 = this.countrySource), (String)(object = ((GrsBaseInfo)object).countrySource))))) {
                bl3 = false;
            }
            return bl3;
        }
        return false;
    }

    public GrsBaseInfo copy() {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        String string2 = this.appName;
        grsBaseInfo.setAppName(string2);
        string2 = this.serCountry;
        grsBaseInfo.setSerCountry(string2);
        string2 = this.regCountry;
        grsBaseInfo.setRegCountry(string2);
        string2 = this.issueCountry;
        grsBaseInfo.setIssueCountry(string2);
        string2 = this.countrySource;
        grsBaseInfo.setCountrySource(string2);
        string2 = this.androidVersion;
        grsBaseInfo.setAndroidVersion(string2);
        string2 = this.deviceModel;
        grsBaseInfo.setDeviceModel(string2);
        string2 = this.romVersion;
        grsBaseInfo.setRomVersion(string2);
        string2 = this.uid;
        grsBaseInfo.setUid(string2);
        string2 = this.versionName;
        grsBaseInfo.setVersionName(string2);
        return grsBaseInfo;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getGrsParasKey(boolean bl2, boolean bl3, Context context) {
        String string2;
        StringBuffer stringBuffer = new StringBuffer();
        Object object = b.a(context.getPackageName(), this);
        object = object != null ? ((b)object).a() : null;
        object = object != null ? ((a)object).b() : "";
        String string3 = this.getAppName();
        boolean bl4 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl4 && (bl4 = TextUtils.isEmpty((CharSequence)object))) {
            stringBuffer.append("app_name");
            String string4 = "=";
            stringBuffer.append(string4);
            stringBuffer.append(string3);
        }
        if (!(bl3 = TextUtils.isEmpty((CharSequence)(string2 = this.getGrsReqParamJoint(bl2, bl3, (String)object, context))))) {
            String string5 = stringBuffer.toString();
            bl3 = TextUtils.isEmpty((CharSequence)string5);
            if (!bl3) {
                string5 = "&";
                stringBuffer.append(string5);
            }
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    public String getGrsParasTag(boolean bl2, boolean bl3, Context context) {
        return this.getGrsParasKey(bl2, bl3, context);
    }

    /*
     * Unable to fully structure code
     */
    public String getGrsReqParamJoint(boolean var1_1, boolean var2_2, String var3_3, Context var4_4) {
        var5_5 = new StringBuffer();
        var6_6 = "1.0";
        var7_7 = var6_6.equals(var3_3);
        var8_8 = "=";
        if (var7_7) {
            var3_3 = GrsBaseInfo.TAG;
            var6_6 = "1.0 interface has no query param appname";
            Logger.v(var3_3, var6_6);
        } else {
            var7_7 = TextUtils.isEmpty((CharSequence)var3_3);
            var9_9 = "app_name";
            if (!var7_7) {
                var5_5.append(var9_9);
                var5_5.append(var8_8);
lbl17:
                // 2 sources

                while (true) {
                    var5_5.append(var3_3);
                    break;
                }
            } else {
                var3_3 = this.getAppName();
                var10_10 = TextUtils.isEmpty((CharSequence)var3_3);
                if (!var10_10) {
                    var5_5.append(var9_9);
                    var5_5.append(var8_8);
                    var3_3 = this.getAppName();
                    ** continue;
                }
            }
        }
        var3_3 = this.getVersionName();
        var7_7 = TextUtils.isEmpty((CharSequence)var3_3);
        var9_9 = "&";
        if (!var7_7) {
            var6_6 = var5_5.toString();
            var7_7 = TextUtils.isEmpty((CharSequence)var6_6);
            if (!var7_7) {
                var5_5.append(var9_9);
            }
            var6_6 = "app_version";
            var5_5.append(var6_6);
            var5_5.append(var8_8);
            var5_5.append(var3_3);
        }
        if (!(var7_7 = TextUtils.isEmpty((CharSequence)(var3_3 = this.getUid())))) {
            var6_6 = var5_5.toString();
            var7_7 = TextUtils.isEmpty((CharSequence)var6_6);
            if (!var7_7) {
                var5_5.append(var9_9);
            }
            var6_6 = "uid";
            var5_5.append(var6_6);
            var5_5.append(var8_8);
            if (var1_1) {
                var11_11 = com.huawei.hms.framework.network.grs.d.b.b(var3_3);
lbl59:
                // 2 sources

                while (true) {
                    var5_5.append(var11_11);
                    break;
                }
            } else {
                if (var2_2) {
                    var11_11 = com.huawei.hms.framework.network.grs.d.b.a(var3_3);
                    ** continue;
                }
                var5_5.append(var3_3);
            }
        }
        var11_11 = this.getRegCountry();
        var10_10 = TextUtils.isEmpty((CharSequence)var11_11);
        var6_6 = "UNKNOWN";
        if (!var10_10 && !(var10_10 = var6_6.equals(var11_11))) {
            var3_3 = var5_5.toString();
            var10_10 = TextUtils.isEmpty((CharSequence)var3_3);
            if (!var10_10) {
                var5_5.append(var9_9);
            }
            var3_3 = "reg_country";
            var5_5.append(var3_3);
            var5_5.append(var8_8);
            var5_5.append(var11_11);
        }
        if (!(var10_10 = TextUtils.isEmpty((CharSequence)(var11_11 = this.getSerCountry()))) && !(var10_10 = var6_6.equals(var11_11))) {
            var3_3 = var5_5.toString();
            var10_10 = TextUtils.isEmpty((CharSequence)var3_3);
            if (!var10_10) {
                var5_5.append(var9_9);
            }
            var3_3 = "ser_country";
            var5_5.append(var3_3);
            var5_5.append(var8_8);
            var5_5.append(var11_11);
        }
        if (!(var10_10 = TextUtils.isEmpty((CharSequence)(var11_11 = this.getIssueCountry()))) && !(var10_10 = var6_6.equals(var11_11))) {
            var3_3 = var5_5.toString();
            var10_10 = TextUtils.isEmpty((CharSequence)var3_3);
            if (!var10_10) {
                var5_5.append(var9_9);
            }
            var3_3 = "issue_country";
            var5_5.append(var3_3);
            var5_5.append(var8_8);
            var5_5.append(var11_11);
        }
        return this.getStringBuffer(var5_5, var2_2, var4_4).toString();
    }

    public String getIssueCountry() {
        return this.issueCountry;
    }

    public String getRegCountry() {
        return this.regCountry;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getSerCountry() {
        return this.serCountry;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAndroidVersion(String string2) {
        this.androidVersion = string2;
    }

    public void setAppName(String string2) {
        this.appName = string2;
    }

    public void setCountrySource(String string2) {
        this.countrySource = string2;
    }

    public void setDeviceModel(String string2) {
        this.deviceModel = string2;
    }

    public void setIssueCountry(String string2) {
        this.issueCountry = string2;
    }

    public void setRegCountry(String string2) {
        this.regCountry = string2;
    }

    public void setRomVersion(String string2) {
        this.romVersion = string2;
    }

    public void setSerCountry(String string2) {
        this.serCountry = string2;
    }

    public void setUid(String string2) {
        this.uid = string2;
    }

    public void setVersionName(String string2) {
        this.versionName = string2;
    }

    public int uniqueCode() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.appName;
        stringBuilder.append(string2);
        string2 = "#";
        stringBuilder.append(string2);
        String string3 = this.serCountry;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string3 = this.regCountry;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = this.issueCountry;
        stringBuilder.append(string2);
        return stringBuilder.toString().hashCode();
    }
}

