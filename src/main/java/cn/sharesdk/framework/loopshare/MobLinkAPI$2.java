/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  cn.sharesdk.loopshare.ActionListener
 *  cn.sharesdk.loopshare.beans.SceneData
 */
package cn.sharesdk.framework.loopshare;

import cn.sharesdk.framework.loopshare.MobLinkAPI;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.log.NLog;

public final class MobLinkAPI$2
implements ActionListener {
    public void onError(Throwable object) {
        MobLinkAPI.c().onError((Throwable)object);
        NLog nLog = SSDKLog.b();
        Object[] objectArray = new StringBuilder();
        objectArray.append("LoopShare MobLinkAPI readPassWord onError: ");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        nLog.d(object, objectArray);
    }

    public void onResult(SceneData object) {
        object = object.a().params;
        MobLinkAPI.c().onResult(object);
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("LoopShare MobLinkAPI readPassWord onResult is ok", objectArray);
    }
}

