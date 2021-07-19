/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin
 *  com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApi;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsConfig;
import com.huawei.hms.framework.network.grs.f;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import java.io.IOException;
import java.util.Locale;

public class GrsManager
implements BasePlugin {
    private static final int GRS_KEY_INDEX = 1;
    private static final int GRS_PATH_INDEX = 2;
    private static final String GRS_SCHEMA = "grs://";
    private static final int GRS_SERVICE_INDEX = 0;
    private static final int MAX_GRS_SPLIT = 3;
    private static final String SEPARATOR = "/";
    private static final String TAG = "GrsManager";
    private static volatile GrsManager instance;
    private GrsConfig grsConfig;
    private f grsInterceptor;

    private GrsManager() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static GrsManager getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = GrsManager.class;
        synchronized (object) {
            GrsManager grsManager = instance;
            if (grsManager != null) return instance;
            instance = grsManager = new GrsManager();
            return instance;
        }
    }

    private String getServiceNameUrl(String string2, String string3) {
        return GrsApi.synGetGrsUrl(string2, string3);
    }

    public static boolean isGRSSchema(String string2) {
        String string3;
        boolean bl2;
        if (string2 != null && (bl2 = string2.startsWith(string3 = GRS_SCHEMA))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private String[] parseGRSSchema(String string2) {
        Locale locale = Locale.ENGLISH;
        int n10 = string2.toLowerCase(locale).indexOf(GRS_SCHEMA) + 6;
        return StringUtils.substring(string2, n10).split(SEPARATOR, 3);
    }

    public PluginInterceptor getInterceptor() {
        f f10 = this.grsInterceptor;
        if (f10 == null) {
            this.grsInterceptor = f10 = new f();
        }
        return this.grsInterceptor;
    }

    public boolean initGrs(Context object, GrsConfig object2) {
        boolean bl2;
        GrsConfig grsConfig = this.grsConfig;
        if (grsConfig == null || !(bl2 = grsConfig.equal((GrsConfig)object2))) {
            this.grsConfig = object2;
            object2 = null;
            object = object != null ? object.getApplicationContext() : null;
            grsConfig = this.grsConfig;
            if (grsConfig != null) {
                object2 = grsConfig.getGrsBaseInfo((Context)object);
            }
            GrsApi.grsSdkInit(object, (GrsBaseInfo)object2);
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String parseGrs(String var1_1) {
        var2_2 = "/";
        var3_3 = var1_1.endsWith((String)var2_2);
        var4_4 = 1;
        if (var3_3 != 0) {
            var5_5 = "grs://";
            var3_3 = var1_1.indexOf(var5_5);
            var6_6 = var1_1.length() - var4_4;
            var1_1 = StringUtils.substring((String)var1_1, var3_3, var6_6);
        }
        var1_1 = this.parseGRSSchema((String)var1_1);
        var3_3 = ((String[])var1_1).length;
        var6_6 = 0;
        var7_7 = 2;
        if (var3_3 == var4_4) {
            var5_5 = var1_1[0];
            var8_8 = "ROOT";
lbl16:
            // 2 sources

            while (true) {
                var5_5 = this.getServiceNameUrl(var5_5, (String)var8_8);
                break;
            }
        } else {
            var3_3 = ((String[])var1_1).length;
            if (var3_3 >= var7_7) {
                var5_5 = var1_1[0];
                var8_8 = var1_1[var4_4];
                ** continue;
            }
            var8_8 = "parseGrs params.length<1.";
            Logger.i("GrsManager", var8_8);
            var5_5 = "";
        }
        var4_4 = (int)TextUtils.isEmpty((CharSequence)var5_5);
        if (var4_4 == 0) {
            var4_4 = ((String[])var1_1).length;
            if (var4_4 > var7_7) {
                var4_4 = (int)var5_5.endsWith((String)var2_2);
                if (var4_4 != 0) {
                    var2_2 = new StringBuilder();
                    var2_2.append(var5_5);
                    var1_1 = var1_1[var7_7];
                    var2_2.append((String)var1_1);
                    var5_5 = var2_2.toString();
                } else {
                    var8_8 = new StringBuilder();
                    var8_8.append(var5_5);
                    var8_8.append((String)var2_2);
                    var1_1 = var1_1[var7_7];
                    var8_8.append((String)var1_1);
                    var5_5 = var8_8.toString();
                }
            }
            return var5_5;
        }
        var1_1 = new IOException("can not get url, do grsUrl(serviceName or key) error?");
        throw var1_1;
    }
}

