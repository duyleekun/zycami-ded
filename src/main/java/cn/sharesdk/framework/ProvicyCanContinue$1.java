/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.ProvicyCanContinue;
import cn.sharesdk.framework.ProvicyCanContinue$OnBusinessListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.OperationCallback;
import com.mob.tools.log.NLog;

public class ProvicyCanContinue$1
extends OperationCallback {
    public final /* synthetic */ ProvicyCanContinue$OnBusinessListener a;
    public final /* synthetic */ ProvicyCanContinue b;

    public ProvicyCanContinue$1(ProvicyCanContinue provicyCanContinue, ProvicyCanContinue$OnBusinessListener provicyCanContinue$OnBusinessListener) {
        this.b = provicyCanContinue;
        this.a = provicyCanContinue$OnBusinessListener;
    }

    public void onComplete(Boolean object) {
        Object[] objectArray = SSDKLog.b();
        int n10 = 1;
        Object[] objectArray2 = new Object[n10];
        CharSequence charSequence = new StringBuilder();
        charSequence.append("canIContinueBusiness: onComplete(), ");
        charSequence.append(object);
        charSequence = charSequence.toString();
        objectArray2[0] = charSequence;
        charSequence = "ShareSDK";
        objectArray.d(charSequence, objectArray2);
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.a;
            if (object != null) {
                object.onContinue();
            }
            object = SSDKLog.b();
            objectArray = new Object[n10];
            String string2 = "MobSDK.canIContinueBusiness if ";
            objectArray[0] = string2;
            ((NLog)object).d(charSequence, objectArray);
        } else {
            object = this.a;
            if (object != null) {
                object.onStop();
            }
            object = SSDKLog.b();
            objectArray = new Object[n10];
            String string3 = "MobSDK.canIContinueBusiness else ";
            objectArray[0] = string3;
            ((NLog)object).d(charSequence, objectArray);
        }
    }

    public void onFailure(Throwable throwable) {
        Object object = SSDKLog.b();
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        CharSequence charSequence = new StringBuilder();
        charSequence.append("canIContinueBusiness: onFailure() ");
        charSequence.append(throwable);
        charSequence = charSequence.toString();
        objectArray[0] = charSequence;
        charSequence = "ShareSDK";
        ((NLog)object).d(charSequence, objectArray);
        object = this.a;
        if (object != null) {
            object.onError(throwable);
        }
    }
}

