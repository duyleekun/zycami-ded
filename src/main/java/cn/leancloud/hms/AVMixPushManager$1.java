/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package cn.leancloud.hms;

import android.app.Activity;
import android.content.Context;
import cn.leancloud.AVHMSMessageService;
import cn.leancloud.AVLogger;
import cn.leancloud.hms.AVMixPushManager;
import com.huawei.hms.aaid.HmsInstanceId;

public final class AVMixPushManager$1
implements Runnable {
    public final /* synthetic */ Activity val$activity;
    public final /* synthetic */ String val$huaweiAppId;

    public AVMixPushManager$1(Activity activity, String string2) {
        this.val$activity = activity;
        this.val$huaweiAppId = string2;
    }

    public void run() {
        Object object = this.val$activity;
        object = HmsInstanceId.getInstance((Context)object);
        Object object2 = this.val$huaweiAppId;
        CharSequence charSequence = "HCM";
        object = ((HmsInstanceId)object).getToken((String)object2, (String)charSequence);
        object2 = AVMixPushManager.access$000();
        charSequence = new StringBuilder();
        String string2 = "found HMS appId: ";
        ((StringBuilder)charSequence).append(string2);
        string2 = this.val$huaweiAppId;
        ((StringBuilder)charSequence).append(string2);
        string2 = ", token: ";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        try {
            ((AVLogger)object2).d((String)charSequence);
            AVHMSMessageService.updateAVInstallation((String)object);
        }
        catch (Exception exception) {
            object2 = AVMixPushManager.access$000();
            charSequence = new StringBuilder();
            string2 = "failed to get hms token. cause: ";
            ((StringBuilder)charSequence).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            ((AVLogger)object2).w(string3);
        }
    }
}

