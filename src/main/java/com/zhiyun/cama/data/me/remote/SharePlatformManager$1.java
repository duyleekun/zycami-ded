/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.zhiyun.cama.data.me.remote.SharePlatformManager;
import java.util.HashMap;
import m.a.a;

public class SharePlatformManager$1
implements PlatformActionListener {
    public final /* synthetic */ SharePlatformManager this$0;

    public SharePlatformManager$1(SharePlatformManager sharePlatformManager) {
        this.this$0 = sharePlatformManager;
    }

    public void onCancel(Platform object, int n10) {
        SharePlatformManager.access$000(this.this$0).obtainMessage(1003).sendToTarget();
        object = new StringBuilder();
        ((StringBuilder)object).append("share onCancel");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }

    public void onComplete(Platform object, int n10, HashMap hashMap) {
        SharePlatformManager.access$000(this.this$0).obtainMessage(1002).sendToTarget();
        object = new StringBuilder();
        ((StringBuilder)object).append("share onComplete  ");
        ((StringBuilder)object).append(n10);
        Object[] objectArray = hashMap.toString();
        ((StringBuilder)object).append((String)objectArray);
        object = ((StringBuilder)object).toString();
        objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }

    public void onError(Platform object, int n10, Throwable throwable) {
        object = SharePlatformManager.access$000(this.this$0);
        Object object2 = new Object[]{};
        object2 = SharePlatformManager.getString(2131952937, object2);
        object.obtainMessage(1001, object2).sendToTarget();
        object = new StringBuilder();
        ((StringBuilder)object).append("share onError");
        ((StringBuilder)object).append(n10);
        Object[] objectArray = throwable.toString();
        ((StringBuilder)object).append((String)objectArray);
        object = ((StringBuilder)object).toString();
        objectArray = new Object[]{};
        a.i((String)object, objectArray);
    }
}

