/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  cn.sharesdk.loopshare.Scene
 *  cn.sharesdk.loopshare.SceneRestorable
 */
package cn.sharesdk.framework.loopshare;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.loopshare.MobLinkAPI;
import cn.sharesdk.framework.loopshare.RestoreTempActivity;
import cn.sharesdk.framework.loopshare.a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.SceneRestorable;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class RestoreTempActivity$1
implements SceneRestorable {
    public final /* synthetic */ RestoreTempActivity this$0;

    public RestoreTempActivity$1(RestoreTempActivity restoreTempActivity) {
        this.this$0 = restoreTempActivity;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReturnSceneData(Scene object) {
        if (object == null) return;
        Object object2 = object.getPath();
        object = object.getParams();
        Object[] objectArray = "targetAction_And";
        Object[] objectArray2 = (String)((HashMap)object).get(objectArray);
        ((HashMap)object).remove(objectArray);
        ((HashMap)object).remove("targetAction_iOS");
        objectArray = null;
        objectArray2 = "path";
        try {
            ((HashMap)object).put(objectArray2, object2);
            object2 = new Hashon();
            object2 = ((Hashon)object2).fromHashMap((HashMap)object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                Object object3 = MobSDK.getContext();
                String string2 = "sharesdk_moblink_sp";
                objectArray2 = new a((Context)object3, string2);
                object3 = "share_restore_extra";
                objectArray2.a((String)object3, object2);
                objectArray2 = SSDKLog.b();
                object3 = new StringBuilder();
                string2 = "LoopShare RestoreTempActivity save json is okd ";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                object3 = new Object[]{};
                objectArray2.d(object2, (Object[])object3);
            }
            if ((object2 = MobLinkAPI.b()) != null) {
                object2 = MobLinkAPI.b();
                object2.onResult(object);
                object = SSDKLog.b();
                object2 = "LoopShare RestoreTempActivity onResult is OK";
                objectArray2 = new Object[]{};
                ((NLog)object).d(object2, objectArray2);
            }
            object = this.this$0;
            object.finish();
            return;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            objectArray2 = new StringBuilder();
            String string3 = "LoopShare RestoreTempActivity onReturnSceneData catch ";
            objectArray2.append(string3);
            objectArray2.append(throwable);
            objectArray2 = objectArray2.toString();
            objectArray = new Object[]{};
            ((NLog)object2).d(objectArray2, objectArray);
            object2 = MobLinkAPI.b();
            if (object2 != null) {
                object2 = MobLinkAPI.b();
                object2.onError(throwable);
            }
            RestoreTempActivity restoreTempActivity = this.this$0;
            restoreTempActivity.finish();
        }
    }
}

