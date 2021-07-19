/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.ProvicyCanContinue$1;
import cn.sharesdk.framework.ProvicyCanContinue$OnBusinessListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.RHolder;
import com.mob.commons.MobProduct;
import com.mob.commons.SHARESDK;
import com.mob.commons.dialog.entity.BaseEntity;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.commons.dialog.entity.InternalPolicyUi$Builder;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class ProvicyCanContinue {
    private static volatile ProvicyCanContinue a;

    private ProvicyCanContinue() {
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ProvicyCanContinue a() {
        Class<ProvicyCanContinue> clazz = ProvicyCanContinue.class;
        // MONITORENTER : clazz
        ProvicyCanContinue provicyCanContinue = a;
        if (provicyCanContinue == null) {
            // MONITORENTER : clazz
            provicyCanContinue = a;
            if (provicyCanContinue == null) {
                a = provicyCanContinue = new ProvicyCanContinue();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return a;
    }

    private void b() {
        Object object = RHolder.getInstance();
        int n10 = ResHelper.getStyleRes(MobSDK.getContext(), "mobcommon_TranslucentTheme");
        object = ((RHolder)object).setActivityThemeId(n10);
        n10 = ResHelper.getStyleRes(MobSDK.getContext(), "mobcommon_DialogStyle");
        object = ((RHolder)object).setDialogThemeId(n10);
        n10 = ResHelper.getLayoutRes(MobSDK.getContext(), "mob_authorize_dialog");
        ((RHolder)object).setDialogLayoutId(n10);
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{"ProvicyCanContinue initMobCommonView()"};
        ((NLog)object).d("ShareSDK", objectArray);
    }

    public void a(ProvicyCanContinue$OnBusinessListener provicyCanContinue$OnBusinessListener) {
        BaseEntity baseEntity = new InternalPolicyUi$Builder();
        Object object = MobSDK.getContext().getResources();
        int n10 = ResHelper.getStringRes(MobSDK.getContext(), "mobcommon_authorize_dialog_title");
        object = object.getString(n10);
        baseEntity = baseEntity.setTitleText((String)object);
        object = MobSDK.getContext().getResources();
        n10 = ResHelper.getStringRes(MobSDK.getContext(), "mobcommon_authorize_dialog_content");
        object = object.getString(n10);
        baseEntity = baseEntity.setContentText((String)object).build();
        object = new SHARESDK();
        ProvicyCanContinue$1 provicyCanContinue$1 = new ProvicyCanContinue$1(this, provicyCanContinue$OnBusinessListener);
        MobSDK.canIContinueBusiness((MobProduct)object, (InternalPolicyUi)baseEntity, provicyCanContinue$1);
    }
}

