/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.MobUIShell;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

public class ReceiveActivity
extends Activity {
    private static PlatformActionListener listener;
    private static String uriScheme;

    public static void setPlatformActionListener(PlatformActionListener platformActionListener) {
        listener = platformActionListener;
    }

    public static void setUriScheme(String string2) {
        uriScheme = string2;
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
            int n11;
            boolean bl2;
            Object object = this.getIntent();
            Object object2 = object.getScheme();
            this.finish();
            if (object2 == null) return;
            Object object3 = uriScheme;
            int n12 = ((String)object2).startsWith((String)object3);
            if (n12 == 0) return;
            object = object.getDataString();
            object = ResHelper.urlToBundle((String)object);
            object2 = "result";
            object2 = object.get((String)object2);
            object2 = String.valueOf(object2);
            object3 = "action";
            object3 = object.get((String)object3);
            String string2 = "shareToQQ";
            boolean bl3 = string2.equals(object3 = String.valueOf(object3));
            if (bl3 || (bl2 = (string2 = "shareToQzone").equals(object3))) {
                object3 = "complete";
                bl2 = ((String)object3).equals(object2);
                string2 = "response";
                if (bl2) {
                    object2 = listener;
                    if (object2 != null) {
                        object = object.get(string2);
                        object = String.valueOf(object);
                        object2 = new Hashon();
                        object = ((Hashon)object2).fromJson((String)object);
                        object2 = listener;
                        object2.onComplete(null, n10, (HashMap)object);
                    }
                } else {
                    object3 = "error";
                    n12 = (int)(((String)object3).equals(object2) ? 1 : 0);
                    if (n12 != 0) {
                        object2 = listener;
                        if (object2 != null) {
                            object = object.get(string2);
                            object = String.valueOf(object);
                            object2 = new Throwable((String)object);
                            object = listener;
                            object.onError(null, n10, (Throwable)object2);
                        }
                    } else {
                        object = listener;
                        if (object != null) {
                            object.onCancel(null, n10);
                        }
                    }
                }
            }
            if ((n11 = Build.VERSION.SDK_INT) > (n12 = 22)) return;
            object2 = "android.intent.action.VIEW";
            object = new Intent((String)object2);
            object2 = MobUIShell.class;
            object.setClass((Context)this, object2);
            n12 = 0x14000000;
            object.setFlags(n12);
            this.startActivity((Intent)object);
            return;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            PlatformActionListener platformActionListener = listener;
            if (platformActionListener == null) return;
            platformActionListener.onError(null, n10, throwable);
        }
    }
}

