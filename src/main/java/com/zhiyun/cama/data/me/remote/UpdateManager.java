/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.data.me.remote;

import android.text.TextUtils;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.data.api.entity.VersionInfoEntity$Result;
import com.zhiyun.cama.data.me.remote.UpdateManager$1;
import com.zhiyun.cama.data.me.remote.UpdateManager$2;
import com.zhiyun.cama.data.me.remote.UpdateManager$OnUpdateVersionCallback;
import d.v.c.v0.l.a;
import d.v.c.v0.u.z;
import d.v.e.l.d1;
import java.util.HashMap;
import k.f;

public class UpdateManager {
    private static final String CHANNEL_GOOGLE = "GooglePlay";
    private static final String CHANNEL_YYB = "yyb";
    private static volatile UpdateManager instance;
    private UpdateManager$OnUpdateVersionCallback mCallback;

    private UpdateManager() {
    }

    public static /* synthetic */ void access$000(UpdateManager updateManager, VersionInfoEntity$Result result2) {
        updateManager.queryLatestVersionInfo(result2);
    }

    public static /* synthetic */ void access$100(UpdateManager updateManager, VersionInfoEntity$Result result2, VersionInfoEntity$Result result3, boolean bl2) {
        updateManager.convertVersionInfo(result2, result3, bl2);
    }

    private void checkForceUpdate() {
        Object object = a.a;
        String string2 = this.getChanel();
        String string3 = this.getCurVersion();
        Object object2 = z.m();
        boolean bl2 = ((z)object2).i();
        object2 = bl2 ? "1" : "0";
        object = object.c("Android", string2, string3, "zycami", (String)object2);
        object2 = new UpdateManager$1(this);
        object.h((f)object2);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean compareVersion(String object, String object2) {
        int n10;
        int n11;
        String[] stringArray;
        Object object3;
        String[] stringArray2;
        int n12;
        Object object4;
        block34: {
            int n13;
            block33: {
                void var2_4;
                object4 = "\\.";
                n12 = 0;
                try {
                    stringArray2 = TextUtils.split((String)object, (String)object4);
                    object3 = "-";
                }
                catch (Exception exception) {
                    return n12 != 0;
                }
                String[] stringArray3 = TextUtils.split((String)var2_4, (String)object3);
                String string2 = stringArray3[0];
                stringArray = TextUtils.split((String)string2, (String)object4);
                object4 = stringArray2[0];
                n11 = Integer.parseInt((String)object4);
                object3 = stringArray[0];
                n13 = Integer.parseInt((String)object3);
                n10 = 1;
                if (n11 <= n13) break block33;
                return n10 != 0;
            }
            object4 = stringArray2[0];
            object4 = Integer.valueOf((String)object4);
            object3 = stringArray[0];
            object3 = Integer.valueOf((String)object3);
            n11 = (int)(((Integer)object4).equals(object3) ? 1 : 0);
            if (n11 == 0) break block34;
            object4 = stringArray2[n10];
            n11 = Integer.parseInt((String)object4);
            object3 = stringArray[n10];
            n13 = Integer.parseInt((String)object3);
            if (n11 <= n13) break block34;
            return n10 != 0;
        }
        object4 = stringArray2[0];
        object4 = Integer.valueOf((String)object4);
        object3 = stringArray[0];
        object3 = Integer.valueOf((String)object3);
        n11 = (int)(((Integer)object4).equals(object3) ? 1 : 0);
        if (n11 == 0) return n12 != 0;
        object4 = stringArray2[n10];
        object4 = Integer.valueOf((String)object4);
        object3 = stringArray[n10];
        object3 = Integer.valueOf((String)object3);
        n11 = (int)(((Integer)object4).equals(object3) ? 1 : 0);
        if (n11 == 0) return n12 != 0;
        n11 = 2;
        String string3 = stringArray2[n11];
        int n14 = Integer.parseInt(string3);
        String string4 = stringArray[n11];
        int n15 = Integer.parseInt(string4);
        if (n14 <= n15) return n12 != 0;
        return n10 != 0;
    }

    private void convertVersionInfo(VersionInfoEntity$Result object, VersionInfoEntity$Result object2, boolean bl2) {
        if (!bl2) {
            object = this.mCallback;
            if (object != null) {
                object.onError();
            }
        } else {
            object = this.parseForceInfo((VersionInfoEntity$Result)object);
            object2 = this.parseNewInfo((VersionInfoEntity$Result)object2);
            boolean bl3 = ((VersionInfo)object).isForceUpdate();
            ((VersionInfo)object2).setForceUpdate(bl3);
            object = ((VersionInfo)object2).getVersion();
            String string2 = this.getCurVersion();
            bl3 = this.compareVersion((String)object, string2);
            if (bl3 && (object = this.mCallback) != null) {
                object.onVersionInfo((VersionInfo)object2);
            } else {
                object = this.mCallback;
                if (object != null) {
                    object2 = new VersionInfo();
                    object.onVersionInfo((VersionInfo)object2);
                }
            }
        }
    }

    private String getChanel() {
        return CHANNEL_GOOGLE;
    }

    private String getCurVersion() {
        Object object = d1.g();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = object.split("-");
            bl2 = false;
            object = object[0];
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static UpdateManager getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = UpdateManager.class;
        synchronized (object) {
            UpdateManager updateManager = instance;
            if (updateManager != null) return instance;
            instance = updateManager = new UpdateManager();
            return instance;
        }
    }

    private VersionInfo parseForceInfo(VersionInfoEntity$Result object) {
        String string2;
        boolean bl2;
        VersionInfo versionInfo = new VersionInfo();
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((VersionInfoEntity$Result)object).fileURL)))) {
            bl2 = ((VersionInfoEntity$Result)object).forceUpdate;
            versionInfo.setForceUpdate(bl2);
            versionInfo.setSize("");
            string2 = ((VersionInfoEntity$Result)object).version;
            versionInfo.setVersion(string2);
            string2 = ((VersionInfoEntity$Result)object).fileURL;
            versionInfo.setFileURL(string2);
            object = ((VersionInfoEntity$Result)object).releaseNotes;
            versionInfo.setNotice((HashMap)object);
        }
        return versionInfo;
    }

    private VersionInfo parseNewInfo(VersionInfoEntity$Result object) {
        String string2;
        boolean bl2;
        VersionInfo versionInfo = new VersionInfo();
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((VersionInfoEntity$Result)object).fileURL)))) {
            versionInfo.setSize("");
            string2 = ((VersionInfoEntity$Result)object).versionType;
            versionInfo.setVersionType(string2);
            string2 = ((VersionInfoEntity$Result)object).version;
            versionInfo.setVersion(string2);
            string2 = ((VersionInfoEntity$Result)object).fileURL;
            versionInfo.setFileURL(string2);
            object = ((VersionInfoEntity$Result)object).releaseNotes;
            versionInfo.setNotice((HashMap)object);
        }
        return versionInfo;
    }

    private void queryLatestVersionInfo(VersionInfoEntity$Result versionInfoEntity$Result) {
        Object object = a.a;
        Object object2 = this.getChanel();
        Object object3 = z.m();
        boolean bl2 = ((z)object3).i();
        object3 = bl2 ? "1" : "0";
        object = object.b("Android", (String)object2, "zycami", (String)object3);
        object2 = new UpdateManager$2(this, versionInfoEntity$Result);
        object.h((f)object2);
    }

    public void checkUpdate(UpdateManager$OnUpdateVersionCallback updateManager$OnUpdateVersionCallback) {
        this.mCallback = updateManager$OnUpdateVersionCallback;
        if (updateManager$OnUpdateVersionCallback == null) {
            return;
        }
        this.checkForceUpdate();
    }
}

