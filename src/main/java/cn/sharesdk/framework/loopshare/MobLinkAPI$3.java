/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.loopshare;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.loopshare.MobLinkAPI;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;

public final class MobLinkAPI$3
implements MoblinkActionListener {
    public final /* synthetic */ String a;

    public MobLinkAPI$3(String string2) {
        this.a = string2;
    }

    public void onError(Throwable throwable) {
        MobLinkAPI.c().onError(throwable);
    }

    public void onResult(Object object) {
        block14: {
            if (object != null) {
                Object object2;
                Object object3 = this.a;
                int n10 = TextUtils.isEmpty((CharSequence)object3);
                Object[] objectArray = "#";
                if (n10 == 0) {
                    object3 = new StringBuilder();
                    object2 = this.a;
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append((String)objectArray);
                    ((StringBuilder)object3).append(object);
                    ((StringBuilder)object3).append((String)objectArray);
                    object = ((StringBuilder)object3).toString();
                } else {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((String)objectArray);
                    ((StringBuilder)object3).append(object);
                    ((StringBuilder)object3).append((String)objectArray);
                    object = ((StringBuilder)object3).toString();
                }
                MobLinkAPI.c().onResult(object);
                object3 = SSDKLog.b();
                objectArray = null;
                object2 = new Object[]{};
                String string2 = "LoopShare MobLinkAPI preparePassWord callback is ok";
                ((NLog)object3).d(string2, (Object[])object2);
                n10 = Build.VERSION.SDK_INT;
                int n11 = 11;
                if (n10 < n11) break block14;
                object3 = MobSDK.getContext();
                MobSDK.getContext();
                object2 = "clipboard";
                object3 = object3.getSystemService((String)object2);
                object3 = (ClipboardManager)object3;
                object2 = "CLI_LAB_A";
                object = ClipData.newPlainText((CharSequence)object2, (CharSequence)object);
                object3.setPrimaryClip((ClipData)object);
                object = SSDKLog.b();
                object3 = "LoopShare MobLinkAPI preparePassWord ClipData is ok";
                object2 = new Object[]{};
                try {
                    ((NLog)object).d(object3, (Object[])object2);
                }
                catch (Throwable throwable) {
                    object3 = SSDKLog.b();
                    object2 = new StringBuilder();
                    string2 = "LoopShare MobLinkAPI preparePassWord ClipData catch: ";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(throwable);
                    String string3 = ((StringBuilder)object2).toString();
                    objectArray = new Object[]{};
                    ((NLog)object3).d(string3, objectArray);
                }
            } else {
                object = MobLinkAPI.c();
                String string4 = "mobId is null";
                Throwable throwable = new Throwable(string4);
                object.onError(throwable);
            }
        }
    }
}

