/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.m;
import com.mob.tools.log.NLog;

public final class i$a
extends m {
    public String a;
    public String b;
    public int c;
    public String d;

    public i$a() {
        String string2;
        this.b = string2 = "";
        this.c = 0;
        this.d = string2;
    }

    public final int a() {
        return 19;
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        String string2 = this.a;
        bundle.putString("_launch_wxminiprogram_username", string2);
        string2 = this.b;
        bundle.putString("_launch_wxminiprogram_path", string2);
        int n10 = this.c;
        bundle.putInt("_launch_wxminiprogram_type", n10);
        string2 = this.d;
        bundle.putString("_launch_wxminiprogram_extData", string2);
    }

    public final boolean a(boolean n10) {
        int n11;
        Object object = this.a;
        if (object != null && (n10 = ((String)object).length()) != 0 && (n10 = ((String)(object = this.a)).length()) <= (n11 = 10240)) {
            int n12;
            n10 = this.c;
            n11 = 1;
            if (n10 >= 0 && n10 <= (n12 = 2)) {
                return n11 != 0;
            }
            object = SSDKLog.b();
            Object[] objectArray = new Object[n11];
            objectArray[0] = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
            ((NLog)object).d("checkArgs fail", objectArray);
            return false;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("checkArgs fail, userName is invalid", objectArray);
        return false;
    }
}

