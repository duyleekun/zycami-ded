/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.r.a;

import android.net.Uri;

public final class p {
    public static final Uri a = Uri.parse((String)"content://com.vivo.push.sdk.service.SystemPushConfig/config");
    public static final Uri b = Uri.parse((String)"content://com.vivo.push.sdk.service.SystemPushConfig/permission");
    public static final Uri c = Uri.parse((String)"content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
    public static final Uri d = Uri.parse((String)"content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    public static String a(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 2008: {
                return "method_stop";
            }
            case 2007: {
                return "method_sdk_unbind";
            }
            case 2006: {
                return "method_sdk_bind";
            }
            case 2005: {
                return "method_tag_unbind";
            }
            case 2004: {
                return "method_tag_bind";
            }
            case 2003: {
                return "method_alias_unbind";
            }
            case 2002: 
        }
        return "method_alias_bind";
    }
}

