/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.zhiyun.account.data.me.remote;

import android.os.Handler;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager;
import java.util.AbstractMap;
import java.util.HashMap;
import m.a.a;

public class ThirdLoginManager$1
implements PlatformActionListener {
    public final /* synthetic */ ThirdLoginManager this$0;

    public ThirdLoginManager$1(ThirdLoginManager thirdLoginManager) {
        this.this$0 = thirdLoginManager;
    }

    public void onCancel(Platform object, int n10) {
        object = ThirdLoginManager.access$200(this.this$0);
        Integer n11 = -1;
        object.obtainMessage(103, (Object)n11).sendToTarget();
        object = new StringBuilder();
        ((StringBuilder)object).append("onCancel");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onComplete(Platform object, int n10, HashMap object2) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "onComplete  ";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        String string3 = ((AbstractMap)object2).toString();
        stringBuilder.append(string3);
        String string4 = stringBuilder.toString();
        Object[] objectArray = new Object[]{};
        a.i(string4, objectArray);
        int n11 = 8;
        if (n10 != n11) return;
        object = ((Platform)object).getDb();
        string2 = ((PlatformDb)object).getUserId();
        String string5 = ((PlatformDb)object).getToken();
        String string6 = ((PlatformDb)object).getUserName();
        String string7 = ((PlatformDb)object).getUserIcon();
        String string8 = ((PlatformDb)object).getUserGender();
        long l10 = ((PlatformDb)object).getExpiresTime();
        long l11 = 1000L;
        long l12 = l10 / l11;
        object = "m";
        boolean bl2 = ((String)object).equals(string8);
        object = bl2 ? "1" : ((bl2 = ((String)(object = "f")).equals(string8)) ? "2" : "3");
        Object object3 = object;
        Object object4 = object;
        object = new AccountManager$AuthData(string2, string5, string6, string7, (String)object3);
        ((AccountManager$AuthData)object).expires_at = l12;
        ThirdPlatform thirdPlatform = ThirdPlatform.FACEBOOK;
        ThirdPlatform thirdPlatform2 = ThirdLoginManager.access$000(this.this$0);
        if (thirdPlatform != thirdPlatform2) {
            Handler handler = ThirdLoginManager.access$200(this.this$0);
            n11 = 101;
            object = handler.obtainMessage(n11, object);
            object.sendToTarget();
            return;
        }
        ThirdLoginManager thirdLoginManager = this.this$0;
        ThirdLoginManager.access$100(thirdLoginManager, (AccountManager$AuthData)object);
    }

    public void onError(Platform object, int n10, Throwable throwable) {
        object = ThirdLoginManager.access$200(this.this$0);
        Integer n11 = R$string.me_error_net;
        object.obtainMessage(102, (Object)n11).sendToTarget();
        object = new StringBuilder();
        ((StringBuilder)object).append("onError");
        ((StringBuilder)object).append(n10);
        Object[] objectArray = throwable.toString();
        ((StringBuilder)object).append((String)objectArray);
        object = ((StringBuilder)object).toString();
        objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }
}

