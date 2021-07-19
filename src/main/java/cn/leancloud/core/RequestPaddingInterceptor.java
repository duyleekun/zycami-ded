/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVCloud;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.GeneralRequestSignature;
import cn.leancloud.core.RequestSignature;
import cn.leancloud.utils.StringUtil;
import g.a0;
import g.a0$a;
import g.c0;
import g.u;
import g.u$a;

public class RequestPaddingInterceptor
implements u {
    private static final String DEFAULT_CONTENT_TYPE = "application/json";
    private static final String HEADER_KEY_ACCEPT = "Accept";
    private static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_KEY_LC_APPID = "X-LC-Id";
    public static final String HEADER_KEY_LC_APPKEY = "X-LC-Key";
    public static final String HEADER_KEY_LC_HOOKKEY = "X-LC-Hook-Key";
    private static final String HEADER_KEY_LC_PROD_MODE = "X-LC-Prod";
    public static final String HEADER_KEY_LC_SIGN = "X-LC-Sign";
    private static final String HEADER_KEY_USER_AGENT = "User-Agent";
    private static RequestSignature requestSignature;

    static {
        GeneralRequestSignature generalRequestSignature = new GeneralRequestSignature();
        requestSignature = generalRequestSignature;
    }

    public static void changeRequestSignature(RequestSignature requestSignature) {
        RequestPaddingInterceptor.requestSignature = requestSignature;
    }

    public c0 intercept(u$a u$a) {
        Object object = u$a.C().n();
        boolean bl2 = AVCloud.isProductionMode();
        String string2 = bl2 ? "1" : "0";
        object = ((a0$a)object).n(HEADER_KEY_LC_PROD_MODE, string2);
        string2 = AVOSCloud.getApplicationId();
        object = ((a0$a)object).n(HEADER_KEY_LC_APPID, string2);
        string2 = requestSignature.generateSign();
        object = ((a0$a)object).n(HEADER_KEY_LC_SIGN, string2);
        String string3 = DEFAULT_CONTENT_TYPE;
        object = ((a0$a)object).n(HEADER_KEY_ACCEPT, string3).n(HEADER_KEY_CONTENT_TYPE, string3);
        string2 = AppConfiguration.getUserAgent();
        string3 = HEADER_KEY_USER_AGENT;
        object = ((a0$a)object).n(string3, string2);
        string2 = AVOSCloud.getHookKey();
        bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            string2 = AVOSCloud.getHookKey();
            string3 = HEADER_KEY_LC_HOOKKEY;
            object = ((a0$a)object).n(string3, string2);
        }
        object = ((a0$a)object).b();
        return u$a.c((a0)object);
    }
}

