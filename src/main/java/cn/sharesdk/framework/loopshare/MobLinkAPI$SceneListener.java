/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  cn.sharesdk.loopshare.RestoreSceneListener
 *  cn.sharesdk.loopshare.Scene
 */
package cn.sharesdk.framework.loopshare;

import cn.sharesdk.framework.loopshare.MobLinkAPI$1;
import cn.sharesdk.framework.loopshare.RestoreTempActivity;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.RestoreSceneListener;
import cn.sharesdk.loopshare.Scene;
import com.mob.tools.log.NLog;

public class MobLinkAPI$SceneListener
implements RestoreSceneListener {
    private MobLinkAPI$SceneListener() {
    }

    public /* synthetic */ MobLinkAPI$SceneListener(MobLinkAPI$1 mobLinkAPI$1) {
        this();
    }

    public void completeRestore(Scene scene) {
    }

    public void notFoundScene(Scene scene) {
    }

    public Class willRestoreScene(Scene object) {
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("LoopShare MobLinkAPI willRestoreScene ==> RestoreTempActivity", objectArray);
        return RestoreTempActivity.class;
    }
}

