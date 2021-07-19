/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 */
package cn.sharesdk.framework.authorize;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.a.b;
import cn.sharesdk.framework.b.a.e;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.MobProduct;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class f {
    private static volatile f a;
    private MobCommunicator b;
    private String c;
    private String d;
    private DeviceHelper e;
    private b f;
    private boolean g = false;
    private HashMap h;

    public f() {
        Object object = DeviceHelper.getInstance(MobSDK.getContext());
        this.e = object;
        this.c = object = MobSDK.getAppkey();
        this.d = object = this.e.getDeviceKey();
        this.f = object = cn.sharesdk.framework.a.b.a();
    }

    private String a(String string2, String string3) {
        Object object = this.e.getDeviceKey();
        int n10 = 2;
        Object object2 = new Object[n10];
        object2[0] = object;
        object2[1] = object = MobSDK.getAppkey();
        object = Data.rawMD5(String.format("%s:%s", (Object[])object2));
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(string3);
        string2 = ((StringBuilder)object2).toString();
        return Base64.encodeToString((byte[])Data.AES128Encode((byte[])object, string2), (int)n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static f c() {
        Class<f> clazz = f.class;
        // MONITORENTER : clazz
        f f10 = a;
        if (f10 == null) {
            // MONITORENTER : clazz
            f10 = a;
            if (f10 == null) {
                a = f10 = new f();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private MobCommunicator e() {
        synchronized (this) {
            MobCommunicator mobCommunicator = this.b;
            if (mobCommunicator != null) return this.b;
            int n10 = 1024;
            String string2 = "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f";
            String string3 = "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1";
            this.b = mobCommunicator = new MobCommunicator(n10, string2, string3);
            return this.b;
        }
    }

    public void a(boolean bl2) {
        this.g = bl2;
    }

    public boolean a() {
        return this.g;
    }

    public HashMap b() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        Object object = cn.sharesdk.framework.b.a.e.a();
        boolean bl2 = this.g;
        boolean bl3 = true;
        if (bl2 != bl3) return;
        boolean bl4 = ((e)object).g();
        if (bl4 != bl3) {
            return;
        }
        object = new ArrayList();
        Object object2 = new KVPair("Content-type", "application/json");
        ((ArrayList)object).add(object2);
        Object[] objectArray = this.c;
        CharSequence charSequence = this.d;
        objectArray = this.a((String)objectArray, (String)charSequence);
        charSequence = "sign";
        object2 = new KVPair((String)charSequence, objectArray);
        ((ArrayList)object).add(object2);
        object = new HashMap();
        object2 = this.c;
        ((HashMap)object).put("appkey", object2);
        object2 = this.d;
        ((HashMap)object).put("deviceId", object2);
        object2 = new SHARESDK();
        object2 = DeviceAuthorizer.authorize((MobProduct)object2);
        ((HashMap)object).put("duid", object2);
        bl3 = false;
        objectArray = null;
        try {
            charSequence = this.c;
            boolean bl5 = TextUtils.isEmpty((CharSequence)charSequence);
            if (!(bl5 || (bl5 = TextUtils.isEmpty((CharSequence)(charSequence = this.d))) || (bl2 = TextUtils.isEmpty((CharSequence)object2)))) {
                object2 = this.e();
                charSequence = "http://p.share.mob.com/tags/getTagList";
                object = ((MobCommunicator)object2).requestSynchronized((HashMap)object, (String)charSequence, false);
                this.h = object = (HashMap)object;
                return;
            }
            object = SSDKLog.b();
            object2 = "SdkPlusTags request userTags that appkey or deviceId or duid is null";
            charSequence = new Object[]{};
            ((NLog)object).d(object2, (Object[])charSequence);
            return;
        }
        catch (Exception exception) {
            object2 = SSDKLog.b();
            charSequence = new StringBuilder();
            String string2 = "SdkPlusTags request userTags is error T===> ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(exception);
            String string3 = ((StringBuilder)charSequence).toString();
            objectArray = new Object[]{};
            ((NLog)object2).d(string3, objectArray);
        }
    }
}

