/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.zhiyun.account.data.me.remote;

import android.os.Handler;
import android.os.Message;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$OnThirdCallback;

public class ThirdLoginManager$3
implements Handler.Callback {
    public final /* synthetic */ ThirdLoginManager this$0;

    public ThirdLoginManager$3(ThirdLoginManager thirdLoginManager) {
        this.this$0 = thirdLoginManager;
    }

    public boolean handleMessage(Message object) {
        int n10 = ((Message)object).what;
        switch (n10) {
            default: {
                break;
            }
            case 103: {
                ThirdLoginManager$OnThirdCallback thirdLoginManager$OnThirdCallback = ThirdLoginManager.access$300(this.this$0);
                if (thirdLoginManager$OnThirdCallback == null) break;
                thirdLoginManager$OnThirdCallback = ThirdLoginManager.access$300(this.this$0);
                object = (Integer)((Message)object).obj;
                int n11 = (Integer)object;
                int n12 = -1;
                thirdLoginManager$OnThirdCallback.onCancel(n11, n12);
                break;
            }
            case 102: {
                ThirdLoginManager$OnThirdCallback thirdLoginManager$OnThirdCallback = ThirdLoginManager.access$300(this.this$0);
                if (thirdLoginManager$OnThirdCallback == null) break;
                thirdLoginManager$OnThirdCallback = ThirdLoginManager.access$300(this.this$0);
                object = (Integer)((Message)object).obj;
                int n13 = (Integer)object;
                thirdLoginManager$OnThirdCallback.onFailed(n13);
                break;
            }
            case 101: {
                ThirdLoginManager$OnThirdCallback thirdLoginManager$OnThirdCallback = ThirdLoginManager.access$300(this.this$0);
                if (thirdLoginManager$OnThirdCallback == null) break;
                thirdLoginManager$OnThirdCallback = ThirdLoginManager.access$300(this.this$0);
                ThirdPlatform thirdPlatform = ThirdLoginManager.access$000(this.this$0);
                object = (AccountManager$AuthData)((Message)object).obj;
                thirdLoginManager$OnThirdCallback.onSuccess(thirdPlatform, (AccountManager$AuthData)object);
            }
        }
        return false;
    }
}

