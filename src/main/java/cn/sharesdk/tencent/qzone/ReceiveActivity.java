/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.MobUIShell;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

public class ReceiveActivity
extends Activity {
    private static String a;
    private static PlatformActionListener b;

    public static void a(PlatformActionListener platformActionListener) {
        b = platformActionListener;
    }

    public static void a(String string2) {
        a = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int n10 = 9;
        try {
            boolean bl2;
            Object object = this.getIntent();
            Object object2 = object.getScheme();
            if (object2 == null) return;
            Object object3 = a;
            int n11 = ((String)object2).startsWith((String)object3);
            if (n11 == 0) return;
            this.finish();
            object = object.getDataString();
            object = ResHelper.urlToBundle((String)object);
            object2 = "result";
            object2 = object.get((String)object2);
            object2 = String.valueOf(object2);
            object3 = "action";
            object3 = object.get((String)object3);
            object3 = String.valueOf(object3);
            String string2 = "shareToQQ";
            boolean bl3 = string2.equals(object3);
            if (bl3 || (bl2 = (string2 = "shareToQzone").equals(object3))) {
                object3 = "complete";
                bl2 = ((String)object3).equals(object2);
                string2 = "response";
                if (bl2) {
                    object2 = b;
                    if (object2 != null) {
                        object = object.get(string2);
                        object = String.valueOf(object);
                        object2 = new Hashon();
                        object = ((Hashon)object2).fromJson((String)object);
                        object2 = b;
                        object2.onComplete(null, n10, (HashMap)object);
                    }
                } else {
                    object3 = "error";
                    n11 = ((String)object3).equals(object2);
                    if (n11 != 0) {
                        object2 = b;
                        if (object2 != null) {
                            object = object.get(string2);
                            object = String.valueOf(object);
                            object2 = new Throwable((String)object);
                            object = b;
                            object.onError(null, n10, (Throwable)object2);
                        }
                    } else {
                        object = b;
                        if (object != null) {
                            object.onCancel(null, n10);
                        }
                    }
                }
            }
            object2 = "android.intent.action.VIEW";
            object = new Intent((String)object2);
            object2 = MobUIShell.class;
            object.setClass((Context)this, object2);
            n11 = 0x14000000;
            object.setFlags(n11);
            this.startActivity((Intent)object);
            return;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            PlatformActionListener platformActionListener = b;
            if (platformActionListener == null) return;
            platformActionListener.onError(null, n10, throwable);
        }
    }
}

