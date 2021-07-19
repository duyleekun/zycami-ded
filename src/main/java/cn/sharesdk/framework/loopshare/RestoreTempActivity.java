/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  cn.sharesdk.loopshare.MobLink
 *  cn.sharesdk.loopshare.SceneRestorable
 */
package cn.sharesdk.framework.loopshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.loopshare.RestoreTempActivity$1;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.MobLink;
import cn.sharesdk.loopshare.SceneRestorable;
import com.mob.tools.log.NLog;

public class RestoreTempActivity
extends Activity {
    public void onCreate(Bundle object) {
        NLog nLog = SSDKLog.b();
        CharSequence charSequence = "[LoopShare] RestoreTempActivity onCreate";
        nLog.w((String)charSequence);
        super.onCreate(object);
        object = new RestoreTempActivity$1(this);
        try {
            MobLink.setActivityDelegate((Activity)this, (SceneRestorable)object);
        }
        catch (Throwable throwable) {
            nLog = SSDKLog.b();
            charSequence = new StringBuilder();
            String string2 = "LoopShare RestoreTempActivity onCreate catch ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(throwable);
            String string3 = ((StringBuilder)charSequence).toString();
            charSequence = new Object[]{};
            nLog.d(string3, (Object[])charSequence);
            this.finish();
        }
    }

    public void onNewIntent(Intent object) {
        Object[] objectArray = SSDKLog.b();
        Object object2 = "[LoopShare] RestoreTempActivity onNewIntent";
        objectArray.w((String)object2);
        super.onNewIntent((Intent)object);
        objectArray = null;
        MobLink.updateNewIntent((Intent)object, (Activity)this);
        object = SSDKLog.b();
        object2 = "LoopShare RestoreTempActivity onNewIntent ";
        Object[] objectArray2 = new Object[]{};
        try {
            ((NLog)object).d(object2, objectArray2);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            objectArray2 = new StringBuilder();
            String string2 = "LoopShare RestoreTempActivity onNewIntent catch ";
            objectArray2.append(string2);
            objectArray2.append(throwable);
            String string3 = objectArray2.toString();
            objectArray = new Object[]{};
            ((NLog)object2).d(string3, objectArray);
        }
    }

    public void onResume() {
        SSDKLog.b().w("[LoopShare] RestoreTempActivity onResume");
        super.onResume();
        this.finish();
    }
}

