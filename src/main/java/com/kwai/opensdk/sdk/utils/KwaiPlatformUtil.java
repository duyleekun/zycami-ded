/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.kwai.opensdk.sdk.utils;

import android.content.Context;
import com.kwai.opensdk.sdk.model.base.BaseReq;
import com.kwai.opensdk.sdk.utils.AppPackageUtil;
import java.util.ArrayList;

public class KwaiPlatformUtil {
    public static final String KWAI_APP_PACKAGE_NAME = "com.smile.gifmaker";
    public static final String KWAI_APP_SCHEME = "kwai://openapi";
    public static final String NEBULA_PACKAGE_NAME = "com.kuaishou.nebula";
    public static final String NEBULA_SCHEME = "ksnebula://openapi";
    private static String SIGNATURE = "3082024f308201b8a00302010202044e269662300d06092a864886f70d0101050500306b310b300906035504061302434e3110300e060355040813076265696a696e673110300e060355040713076265696a696e6731133011060355040a130a686563616f2e696e666f31133011060355040b130a686563616f2e696e666f310e300c0603550403130563616f68653020170d3131303732303038343833345a180f32303636303432323038343833345a306b310b300906035504061302434e3110300e060355040813076265696a696e673110300e060355040713076265696a696e6731133011060355040a130a686563616f2e696e666f31133011060355040b130a686563616f2e696e666f310e300c0603550403130563616f686530819f300d06092a864886f70d010101050003818d003081890281810093bce2a30779500e3a3160ce5b557f3fa34df50df25ac1ae38c181c8ad94e4709d00afbc532d27ccfd4a92c8f1bd5b19c1f04f37b8230020035e33eb39de2d482ad4c043f251fb08007cb3eac4a348e140a817784195f0fbafc7480c90f76ef966d220abd9c4ab3d246276c98ce6d77a7fcc4f451ae89eb387d9bff521898d970203010001300d06092a864886f70d0101050500038181001ce4eb9f42d76dfc4e0f5da07bc3efae2cf98b47a39790d35407f3aeb6b554cadd65e84c7252046b3ab72b2dfc86f0892e28fee3e6e4e801093e3a4f29bc560762d33839ceb29385583ded64548f245977d61925543dda7ac3d34e8153a88f9846f446ff96d4877ad808280bbd7c43b9bf5feea3dd8d6bd179bc8cf29f949163";

    public static String getPackageNameByReq(Context object, BaseReq object2) {
        object2 = ((BaseReq)object2).getPlatformArray();
        boolean bl2 = ((ArrayList)(object2 = KwaiPlatformUtil.validateAppInstalled((Context)object, (String[])object2))).isEmpty();
        if (bl2) {
            return null;
        }
        boolean bl3 = ((ArrayList)(object = KwaiPlatformUtil.matchSupportAPI((Context)object, (ArrayList)object2))).isEmpty();
        if (bl3) {
            return null;
        }
        return KwaiPlatformUtil.getPlatformPackageName((String)((ArrayList)object).get(0));
    }

    public static String getPlatformPackageName(String string2) {
        String string3 = "kwai_app";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return KWAI_APP_PACKAGE_NAME;
        }
        string3 = "nebula_app";
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            return NEBULA_PACKAGE_NAME;
        }
        return null;
    }

    public static String getPlatformScheme(String string2) {
        String string3 = "kwai_app";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return KWAI_APP_SCHEME;
        }
        string3 = "nebula_app";
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            return NEBULA_SCHEME;
        }
        return null;
    }

    private static boolean isAppSupportAPI(Context context, String string2) {
        int n10;
        int n11 = AppPackageUtil.getAppSupportAPILevel(context, string2);
        if (n11 <= (n10 = 1)) {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }

    public static boolean isAppSupportUri(Context context, String string2) {
        int n10;
        int n11 = AppPackageUtil.getAppSupportAPILevel(context, string2);
        if (n11 > (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            context = null;
        }
        return n11 != 0;
    }

    private static boolean isAppValidated(Context context, String string2, String string3) {
        boolean bl2;
        boolean bl3 = AppPackageUtil.isAppPackageInstalled(context, string2);
        if (bl3 && (bl2 = AppPackageUtil.validateSignature(context, string2, string3))) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    public static ArrayList matchSupportAPI(Context context, ArrayList object) {
        int n10 = 2;
        ArrayList<String> arrayList = new ArrayList<String>(n10);
        object = ((ArrayList)object).iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            String string2 = (String)object.next();
            string2.hashCode();
            String string3 = "kwai_app";
            boolean bl2 = string2.equals(string3);
            if (!bl2) {
                string3 = "nebula_app";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0 || (n10 = (int)(KwaiPlatformUtil.isAppSupportAPI(context, string2 = NEBULA_PACKAGE_NAME) ? 1 : 0)) == 0) continue;
                arrayList.add(string3);
                continue;
            }
            string2 = KWAI_APP_PACKAGE_NAME;
            n10 = (int)(KwaiPlatformUtil.isAppSupportAPI(context, string2) ? 1 : 0);
            if (n10 == 0) continue;
            arrayList.add(string3);
        }
        return arrayList;
    }

    public static ArrayList validateAppInstalled(Context context, String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>(2);
        for (String string2 : stringArray) {
            String string3;
            boolean bl2;
            string2.hashCode();
            String string4 = "kwai_app";
            boolean bl3 = string2.equals(string4);
            if (!bl3) {
                string4 = "nebula_app";
                bl2 = string2.equals(string4);
                if (!bl2 || !(bl2 = KwaiPlatformUtil.isAppValidated(context, string3 = NEBULA_PACKAGE_NAME, string2 = SIGNATURE))) continue;
                arrayList.add(string4);
                continue;
            }
            string3 = KWAI_APP_PACKAGE_NAME;
            string2 = SIGNATURE;
            bl2 = KwaiPlatformUtil.isAppValidated(context, string3, string2);
            if (!bl2) continue;
            arrayList.add(string4);
        }
        return arrayList;
    }
}

