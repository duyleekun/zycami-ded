/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  cn.sharesdk.loopshare.ActionListener
 *  cn.sharesdk.loopshare.MobLink
 *  cn.sharesdk.loopshare.RestoreSceneListener
 *  cn.sharesdk.loopshare.Scene
 *  cn.sharesdk.loopshare.utils.b
 */
package cn.sharesdk.framework.loopshare;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MobLinkAPI$1;
import cn.sharesdk.framework.loopshare.MobLinkAPI$2;
import cn.sharesdk.framework.loopshare.MobLinkAPI$3;
import cn.sharesdk.framework.loopshare.MobLinkAPI$SceneListener;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.MobLink;
import cn.sharesdk.loopshare.RestoreSceneListener;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.utils.b;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobLinkAPI {
    private static MoblinkActionListener a;
    private static LoopShareResultListener b;
    private static LoopSharePasswordListener c;
    private static volatile MobLinkAPI d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static MobLinkAPI a() {
        Class<MobLinkAPI> clazz = MobLinkAPI.class;
        // MONITORENTER : clazz
        MobLinkAPI mobLinkAPI = d;
        if (mobLinkAPI == null) {
            // MONITORENTER : clazz
            mobLinkAPI = d;
            if (mobLinkAPI == null) {
                d = mobLinkAPI = new MobLinkAPI();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return d;
    }

    public static /* synthetic */ MoblinkActionListener a(MoblinkActionListener moblinkActionListener) {
        a = moblinkActionListener;
        return moblinkActionListener;
    }

    private static String a(String object) {
        Pattern pattern = Pattern.compile("#(.*?)#");
        object = pattern.matcher((CharSequence)object);
        boolean bl2 = ((Matcher)object).find();
        if (bl2) {
            return ((Matcher)object).group(1);
        }
        return "";
    }

    public static void a(LoopSharePasswordListener loopSharePasswordListener) {
        c = loopSharePasswordListener;
    }

    public static void a(LoopShareResultListener loopShareResultListener) {
        b = loopShareResultListener;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void a(HashMap var0, MoblinkActionListener var1_3) {
        block16: {
            block15: {
                var2_4 = "params";
                if (var1_3 == null) break block16;
                MobLinkAPI.a = var1_3;
                var1_3 = new Scene();
                var3_5 /* !! */  = "path";
                var3_5 /* !! */  = var0.get(var3_5 /* !! */ );
                var3_5 /* !! */  = String.valueOf(var3_5 /* !! */ );
                var1_3.setPath(var3_5 /* !! */ );
                var3_5 /* !! */  = var0.get(var2_4);
                var4_6 = var3_5 /* !! */  instanceof HashMap;
                if (!var4_6) ** GOTO lbl25
                var0 = var0.get(var2_4);
                var0 = (HashMap)var0;
                var1_3.setParams((HashMap)var0);
                break block15;
lbl25:
                // 1 sources

                var0 = MobLinkAPI.a;
                if (var0 == null) break block15;
                var1_3 = "setLoopshareCustomParams\u65b9\u6cd5\u4e2d params \u4e3akey\u7684\u65f6\u5019\uff0cvalue\u9700\u8981\u4e3aHashMap\u7c7b\u578b";
                var0 = new Throwable((String)var1_3);
                var1_3 = MobLinkAPI.a;
                var1_3.onError((Throwable)var0);
                return;
            }
            var0 = new MobLinkAPI$1();
            try {
                MobLink.getMobID((Scene)var1_3, (ActionListener)var0);
            }
            catch (Throwable var0_1) {
                var1_3 = SSDKLog.b();
                var2_4 = new StringBuilder();
                var3_5 /* !! */  = "LoopShare MobLinkAPI mobLinkGetMobID";
                var2_4.append(var3_5 /* !! */ );
                var2_4.append(var0_1);
                var0_2 = var2_4.toString();
                var2_4 = new Object[]{};
                var1_3.e(var0_2, (Object[])var2_4);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void a(HashMap var0, String var1_3, LoopSharePasswordListener var2_4) {
        block8: {
            if (var2_4 == null) ** GOTO lbl16
            MobLinkAPI.a((LoopSharePasswordListener)var2_4);
            var2_4 = new MobLinkAPI$3((String)var1_3);
            ShareSDK.mobLinkGetMobID((HashMap)var0, (MoblinkActionListener)var2_4);
            var0 = SSDKLog.b();
            var1_3 = "LoopShare MobLinkAPI preparePassWord is OK";
            var2_4 = new Object[]{};
            var0.d(var1_3, var2_4);
            break block8;
lbl16:
            // 1 sources

            var0 = SSDKLog.b();
            var1_3 = "LoopShare MobLinkAPI preparePassWord listener is null";
            var2_4 = new Object[]{};
            try {
                var0.d(var1_3, var2_4);
            }
            catch (Throwable var0_1) {
                var1_3 = SSDKLog.b();
                var2_4 = new StringBuilder();
                var3_5 = "LoopShare MobLinkAPI preparePassWord ";
                var2_4.append(var3_5);
                var2_4.append(var0_1);
                var0_2 = var2_4.toString();
                var2_4 = new Object[]{};
                var1_3.e(var0_2, var2_4);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(boolean bl2, LoopSharePasswordListener object) {
        CharSequence charSequence;
        block6: {
            MobLinkAPI$2 mobLinkAPI$2;
            String string2;
            charSequence = null;
            if (object == null) {
                NLog nLog = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                charSequence = "LoopShare MobLinkAPI readPassWord listener is null";
                nLog.d(charSequence, objectArray);
                return;
            }
            MobLinkAPI.a((LoopSharePasswordListener)object);
            String string3 = MobLinkAPI.f();
            Object object2 = SSDKLog.b();
            CharSequence charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("LoopShare MobLinkAPI readPassWord clipContent: ");
            ((StringBuilder)charSequence2).append(string3);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            Object[] objectArray = new Object[]{};
            ((NLog)object2).d(charSequence2, objectArray);
            try {
                boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
                if (bl3) break block6;
                string2 = MobLinkAPI.a(string3);
                bl3 = TextUtils.isEmpty((CharSequence)string2);
                if (bl3) {
                    Object object3 = SSDKLog.b();
                    String string4 = "LoopShare MobLinkAPI readPassWord Regular match string is null ";
                    charSequence = new Object[]{};
                    ((NLog)object3).d(string4, (Object[])charSequence);
                    object3 = MobLinkAPI.c();
                    if (object3 == null) return;
                    object3 = MobLinkAPI.c();
                    charSequence = "readPassWord Regular match string is error";
                    Throwable throwable = new Throwable((String)charSequence);
                    object3.onError(throwable);
                    return;
                }
                object2 = SSDKLog.b();
                charSequence2 = new StringBuilder();
                String string5 = "LoopShare MobLinkAPI readPassWord read mobId is: ";
                ((StringBuilder)charSequence2).append(string5);
                ((StringBuilder)charSequence2).append(string2);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                charSequence = new Object[]{};
                ((NLog)object2).d(charSequence2, (Object[])charSequence);
                if (bl2) {
                    MobLinkAPI.g();
                }
                mobLinkAPI$2 = new MobLinkAPI$2();
            }
            catch (Throwable throwable) {
                LoopSharePasswordListener loopSharePasswordListener = MobLinkAPI.c();
                if (loopSharePasswordListener == null) return;
                charSequence = new StringBuilder();
                object2 = "readPassWord catch: ";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(throwable);
                Object object4 = ((StringBuilder)charSequence).toString();
                Throwable throwable2 = new Throwable((String)object4);
                object4 = MobLinkAPI.c();
                object4.onError(throwable2);
                return;
            }
            cn.sharesdk.loopshare.utils.b.a((String)string2, (ActionListener)mobLinkAPI$2);
            return;
        }
        LoopSharePasswordListener loopSharePasswordListener = MobLinkAPI.c();
        if (loopSharePasswordListener == null) return;
        loopSharePasswordListener = MobLinkAPI.c();
        charSequence = "The clipboard is empty";
        Throwable throwable = new Throwable((String)charSequence);
        loopSharePasswordListener.onError(throwable);
    }

    public static LoopShareResultListener b() {
        return b;
    }

    public static void b(LoopShareResultListener object) {
        Object[] objectArray = null;
        if (object != null) {
            MobLinkAPI.a((LoopShareResultListener)object);
        }
        object = "sdfwe435fdsr34656uthfwer32ufeh439==";
        Object[] objectArray2 = null;
        Object object2 = new MobLinkAPI$SceneListener(null);
        MobLink.registerSpecifiedSchemeListener((String)object, (RestoreSceneListener)object2);
        object = SSDKLog.b();
        object2 = "LoopShare MobLinkAPI prepareLoopShare is OK";
        objectArray2 = new Object[]{};
        try {
            ((NLog)object).d(object2, objectArray2);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            objectArray2 = new StringBuilder();
            String string2 = "LoopShare MobLinkAPI prepareLoopShare ";
            objectArray2.append(string2);
            objectArray2.append(throwable);
            String string3 = objectArray2.toString();
            objectArray = new Object[]{};
            ((NLog)object2).e(string3, objectArray);
        }
    }

    public static LoopSharePasswordListener c() {
        return c;
    }

    public static HashMap d() {
        HashMap hashMap;
        block11: {
            Object object = MobSDK.getContext();
            CharSequence charSequence = "sharesdk_moblink_sp";
            hashMap = new HashMap((Context)object, (String)charSequence);
            object = "share_restore_extra";
            charSequence = null;
            hashMap = ((a)((Object)hashMap)).b((String)object, null);
            hashMap = ((Object)hashMap).toString();
            hashMap = ((String)((Object)hashMap)).trim();
            boolean bl2 = TextUtils.isEmpty((CharSequence)((Object)hashMap));
            if (bl2) break block11;
            object = new Hashon();
            try {
                return ((Hashon)object).fromJson((String)((Object)hashMap));
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                charSequence = new StringBuilder();
                String string2 = "LoopShare MobLinkAPI getCustomDataFromLoopShare ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(throwable);
                hashMap = ((StringBuilder)charSequence).toString();
                charSequence = new Object[]{};
                ((NLog)object).e(hashMap, (Object[])charSequence);
            }
        }
        hashMap = new HashMap();
        return hashMap;
    }

    public static /* synthetic */ MoblinkActionListener e() {
        return a;
    }

    private static String f() {
        block13: {
            String string2;
            block14: {
                string2 = null;
                Object[] objectArray = null;
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 11;
                if (n10 < n11) break block13;
                Object object = MobSDK.getContext();
                Object object2 = "clipboard";
                object = object.getSystemService((String)object2);
                object = (ClipboardManager)object;
                if (object == null) break block13;
                n11 = (int)(object.hasPrimaryClip() ? 1 : 0);
                if (n11 == 0) break block13;
                object2 = object.getPrimaryClip();
                n11 = object2.getItemCount();
                if (n11 <= 0) break block13;
                object = object.getPrimaryClip();
                object = object.getItemAt(0);
                object = object.getText();
                n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n11 != 0) break block14;
                try {
                    string2 = String.valueOf(object);
                }
                catch (Throwable throwable) {
                    object2 = SSDKLog.b();
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "LoopShare MobLinkAPI getClipContent catch: ";
                    stringBuilder.append(string3);
                    stringBuilder.append(throwable);
                    String string4 = stringBuilder.toString();
                    objectArray = new Object[]{};
                    ((NLog)object2).e(string4, objectArray);
                }
            }
            return string2;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void g() {
        Object[] objectArray = null;
        try {
            String string2;
            Object object;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 11;
            if (n10 >= n11) {
                object = MobSDK.getContext();
                string2 = "clipboard";
                object = object.getSystemService(string2);
                if ((object = (ClipboardManager)object) != null) {
                    string2 = object.getPrimaryClip();
                    object.setPrimaryClip((ClipData)string2);
                    n11 = 0;
                    string2 = null;
                    object.setText(null);
                }
            }
            object = SSDKLog.b();
            string2 = "LoopShare MobLinkAPI clearClipboard is ok";
            Object[] objectArray2 = new Object[]{};
            ((NLog)object).d(string2, objectArray2);
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "LoopShare MobLinkAPI clearClipboard catch: ";
            stringBuilder.append(string3);
            stringBuilder.append(throwable);
            String string4 = stringBuilder.toString();
            objectArray = new Object[]{};
            nLog.e(string4, objectArray);
        }
    }
}

