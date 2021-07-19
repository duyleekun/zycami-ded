/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.zhiyun.cama.data.me.remote;

import android.os.Handler;
import android.os.Message;
import com.zhiyun.cama.data.api.entity.ShareInfo;
import com.zhiyun.cama.data.me.remote.SharePlatformManager;

public class SharePlatformManager$2
implements Handler.Callback {
    public final /* synthetic */ SharePlatformManager this$0;

    public SharePlatformManager$2(SharePlatformManager sharePlatformManager) {
        this.this$0 = sharePlatformManager;
    }

    public boolean handleMessage(Message object) {
        Object object2 = SharePlatformManager.access$100(this.this$0);
        if (object2 != null) {
            int n10 = ((Message)object).what;
            switch (n10) {
                default: {
                    break;
                }
                case 1003: {
                    object = SharePlatformManager.access$100(this.this$0);
                    object.onShareCancel();
                    break;
                }
                case 1002: {
                    object = this.this$0;
                    object2 = SharePlatformManager.access$200((SharePlatformManager)object);
                    n10 = ((ShareInfo)object2).getWorksId();
                    ShareInfo shareInfo = SharePlatformManager.access$200(this.this$0);
                    int n11 = shareInfo.getCircleId();
                    SharePlatformManager.access$300((SharePlatformManager)object, n10, n11);
                    object = SharePlatformManager.access$100(this.this$0);
                    object.onShareSuccess();
                    break;
                }
                case 1001: {
                    object2 = SharePlatformManager.access$100(this.this$0);
                    object = (String)((Message)object).obj;
                    object2.onShareFailed((String)object);
                }
            }
        }
        return false;
    }
}

