/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package cn.sharesdk.framework;

import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.c;
import cn.sharesdk.framework.d;
import cn.sharesdk.framework.f$1;
import cn.sharesdk.framework.f$2;
import cn.sharesdk.framework.f$3;
import cn.sharesdk.framework.f$4;
import cn.sharesdk.framework.f$5;
import cn.sharesdk.framework.f$6;
import cn.sharesdk.framework.f$7;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.commons.ForbThrowable;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Field;
import java.util.HashMap;

public class f {
    private Platform a;
    private PlatformDb b;
    private d c;
    private int d;
    private int e;
    private boolean f;
    private boolean g = true;
    private boolean h;

    public f(Platform object) {
        PlatformDb platformDb;
        this.a = object;
        String string2 = ((Platform)object).getName();
        int n10 = ((Platform)object).getVersion();
        this.b = platformDb = new PlatformDb(string2, n10);
        this.a(string2);
        this.c = object = new d();
        cn.sharesdk.framework.c.a();
    }

    public static /* synthetic */ Platform a(f f10) {
        return f10.a;
    }

    private String a(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShareSDK_");
        String string2 = this.a.getName();
        stringBuilder.append(string2);
        stringBuilder.append("_");
        String string3 = this.b(n10);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private void a(d d10, int n10) {
        if (d10 != null) {
            Platform platform = this.a;
            ForbThrowable forbThrowable = new ForbThrowable();
            d10.onError(platform, n10, forbThrowable);
        }
    }

    public static /* synthetic */ void a(f f10, d d10, int n10) {
        f10.a(d10, n10);
    }

    public static /* synthetic */ d b(f f10) {
        return f10.c;
    }

    private String b(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                switch (n10) {
                    default: {
                        return "ACTION_CUSTOMER";
                    }
                    case 11: {
                        return "ACTION_GETTING_FOLLOWER_LIST";
                    }
                    case 10: {
                        return "ACTION_GETTING_BILATERAL_LIST";
                    }
                    case 9: {
                        return "ACTION_SHARE";
                    }
                    case 8: {
                        return "ACTION_USER_INFOR";
                    }
                    case 7: {
                        return "ACTION_TIMELINE";
                    }
                    case 6: {
                        return "ACTION_FOLLOWING_USER";
                    }
                    case 5: 
                }
                return "ACTION_SENDING_DIRECT_MESSAGE";
            }
            return "ACTION_GETTING_FRIEND_LIST";
        }
        return "ACTION_AUTHORIZING";
    }

    private void b(d d10, int n10) {
        if (d10 != null) {
            Platform platform = this.a;
            String string2 = "'appkey' is illegal";
            Throwable throwable = new Throwable(string2);
            d10.onError(platform, n10, throwable);
        }
    }

    public static /* synthetic */ void b(f f10, d d10, int n10) {
        f10.b(d10, n10);
    }

    public static /* synthetic */ boolean c(f f10) {
        return f10.j();
    }

    /*
     * WARNING - void declaration
     */
    private boolean j() {
        void var9_14;
        int n11;
        Object object;
        block14: {
            String string2;
            block13: {
                int n12;
                String string3;
                block12: {
                    int n13 = ShareSDK.a();
                    object = "false";
                    string2 = null;
                    string3 = "covert_url";
                    n11 = 1;
                    if (n13 != 0) {
                        n13 = this.a.getPlatformId();
                        String string4 = this.a(n13, string3, null);
                        if (string4 != null) {
                            string4.trim();
                        }
                        n13 = ((String)object).equals(string4) ^ n11;
                        this.g = n13;
                        this.a.setNetworkDevinfo();
                        return n11 != 0;
                    }
                    n13 = 0;
                    Object var6_8 = null;
                    try {
                        n12 = ShareSDK.b();
                        if (n12 != 0) break block12;
                        return false;
                    }
                    catch (Throwable throwable) {
                        SSDKLog.b().w(throwable);
                        return false;
                    }
                }
                Platform platform = this.a;
                n12 = platform.getPlatformId();
                string2 = this.a(n12, string3, null);
                if (string2 == null) break block13;
                string2.trim();
            }
            boolean n10 = ((String)object).equals(string2);
            if (!n10) {
                int n12 = n11;
                break block14;
            }
            boolean bl2 = false;
            object = null;
        }
        this.g = var9_14;
        object = this.a;
        ((Platform)object).setNetworkDevinfo();
        return n11 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String k() {
        Object object = "|";
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = "TencentWeibo";
        try {
            String string2;
            Object object3 = this.a;
            object3 = ((Platform)object3).getName();
            boolean bl2 = ((String)object2).equals(object3);
            object3 = "utf-8";
            if (bl2) {
                object2 = SSDKLog.b();
                string2 = "user id %s ==>>";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                Object object4 = this.g();
                objectArray[0] = object4 = ((PlatformDb)object4).getUserName();
                ((NLog)object2).i(string2, objectArray);
                object2 = this.g();
                object2 = ((PlatformDb)object2).getUserName();
                object2 = Data.urlEncode((String)object2, (String)object3);
                stringBuilder.append((String)object2);
            } else {
                object2 = this.g();
                object2 = ((PlatformDb)object2).getUserId();
                object2 = Data.urlEncode((String)object2, (String)object3);
                stringBuilder.append((String)object2);
            }
            stringBuilder.append((String)object);
            object2 = this.g();
            string2 = "secretType";
            object2 = ((PlatformDb)object2).get(string2);
            object2 = Data.urlEncode((String)object2, (String)object3);
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            object2 = this.g();
            string2 = "gender";
            object2 = ((PlatformDb)object2).get(string2);
            object2 = Data.urlEncode((String)object2, (String)object3);
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            object2 = this.g();
            string2 = "birthday";
            object2 = ((PlatformDb)object2).get(string2);
            object2 = Data.urlEncode((String)object2, (String)object3);
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            object2 = this.g();
            string2 = "educationJSONArrayStr";
            object2 = ((PlatformDb)object2).get(string2);
            object2 = Data.urlEncode((String)object2, (String)object3);
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            object = this.g();
            object2 = "workJSONArrayStr";
            object = ((PlatformDb)object).get((String)object2);
            object = Data.urlEncode((String)object, (String)object3);
            stringBuilder.append((String)object);
            return stringBuilder.toString();
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).w(throwable);
        }
        return stringBuilder.toString();
    }

    public int a() {
        return this.d;
    }

    public String a(int n10, String string2, String string3) {
        Object object = ShareSDK.a(n10, string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2 || (bl2 = (string2 = "null").equals(object))) {
            object = this.a;
            string2 = ((Platform)object).getName();
            object = ((Platform)object).getDevinfo(string2, string3);
        }
        return object;
    }

    public String a(Bitmap bitmap) {
        return ShareSDK.a(bitmap);
    }

    public String a(String string2, boolean bl2) {
        long l10 = System.currentTimeMillis();
        int n10 = this.g;
        String string3 = "getShortLintk use time: ";
        if (n10 == 0) {
            NLog nLog = SSDKLog.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            long l11 = System.currentTimeMillis() - l10;
            stringBuilder.append(l11);
            String string4 = stringBuilder.toString();
            Object[] objectArray = new Object[]{};
            nLog.i(string4, objectArray);
            return string2;
        }
        n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            NLog nLog = SSDKLog.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            long l12 = System.currentTimeMillis() - l10;
            stringBuilder.append(l12);
            String string5 = stringBuilder.toString();
            Object[] objectArray = new Object[]{};
            nLog.i(string5, objectArray);
            return string2;
        }
        n10 = this.a.getPlatformId();
        String string6 = this.k();
        string2 = ShareSDK.a(string2, bl2, n10, string6);
        NLog nLog = SSDKLog.b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        long l13 = System.currentTimeMillis() - l10;
        stringBuilder.append(l13);
        String string7 = stringBuilder.toString();
        Object[] objectArray = new Object[]{};
        nLog.i(string7, objectArray);
        return string2;
    }

    public void a(int n10, int n11, String string2) {
        Object[] objectArray = new Object[3];
        Integer n12 = n10;
        objectArray[0] = n12;
        n12 = n11;
        objectArray[1] = n12;
        n10 = 2;
        objectArray[n10] = string2;
        this.c(n10, objectArray);
    }

    public void a(int n10, Object object) {
        d d10 = this.c;
        Platform platform = this.a;
        d10.a(platform, n10, object);
    }

    public void a(Platform$ShareParams object) {
        if (object == null) {
            object = this.c;
            if (object != null) {
                Platform platform = this.a;
                int n10 = 9;
                NullPointerException nullPointerException = new NullPointerException();
                ((d)object).onError(platform, n10, nullPointerException);
            }
            return;
        }
        String string2 = this.a(1);
        f$5 f$5 = new f$5(this, string2, (Platform$ShareParams)object);
        f$5.start();
    }

    public void a(PlatformActionListener platformActionListener) {
        this.c.a(platformActionListener);
    }

    public void a(String string2) {
        Object object;
        CharSequence charSequence;
        int n10;
        Object[] objectArray;
        Object object2;
        block14: {
            block13: {
                object2 = ShareSDK.getDevinfo(string2, "Id");
                objectArray = null;
                object2 = String.valueOf(object2);
                object2 = ((String)object2).trim();
                n10 = ResHelper.parseInt((String)object2);
                try {
                    this.d = n10;
                }
                catch (Throwable throwable) {
                    object2 = this.a;
                    n10 = object2 instanceof CustomPlatform;
                    if (n10 != 0) break block13;
                    object2 = SSDKLog.b();
                    charSequence = new StringBuilder();
                    object = this.a.getName();
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(" failed to parse Id, this will cause method getId() always returens 0");
                    charSequence = ((StringBuilder)charSequence).toString();
                    object = new Object[]{};
                    ((NLog)object2).d(charSequence, object);
                }
            }
            object2 = ShareSDK.getDevinfo(string2, "SortId");
            object2 = String.valueOf(object2);
            object2 = ((String)object2).trim();
            n10 = ResHelper.parseInt((String)object2);
            try {
                this.e = n10;
            }
            catch (Throwable throwable) {
                object2 = this.a;
                n10 = object2 instanceof CustomPlatform;
                if (n10 != 0) break block14;
                object2 = SSDKLog.b();
                charSequence = new StringBuilder();
                object = this.a.getName();
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(" failed to parse SortId, this won't cause any problem, don't worry");
                charSequence = ((StringBuilder)charSequence).toString();
                object = new Object[]{};
                ((NLog)object2).d(charSequence, object);
            }
        }
        object2 = ShareSDK.getDevinfo(string2, "Enable");
        if (object2 == null) {
            this.h = true;
            object2 = this.a;
            n10 = object2 instanceof CustomPlatform;
            if (n10 == 0) {
                object2 = SSDKLog.b();
                charSequence = new StringBuilder();
                object = this.a.getName();
                ((StringBuilder)charSequence).append((String)object);
                object = " failed to parse Enable, this will cause platform always be enable";
                ((StringBuilder)charSequence).append((String)object);
                charSequence = ((StringBuilder)charSequence).toString();
                objectArray = new Object[]{};
                ((NLog)object2).d(charSequence, objectArray);
            }
        } else {
            object2 = ((String)object2).trim();
            objectArray = "true";
            n10 = (int)(objectArray.equals(object2) ? 1 : 0);
            this.h = n10;
        }
        this.a.initDevInfo(string2);
    }

    public void a(String string2, int n10, int n11) {
        Object[] objectArray = new Object[3];
        Integer n12 = n10;
        objectArray[0] = n12;
        n12 = n11;
        objectArray[1] = n12;
        objectArray[2] = string2;
        this.c(7, objectArray);
    }

    public void a(String string2, String string3, short s10, HashMap hashMap, HashMap hashMap2) {
        s10 = (short)(s10 | 0xA0000);
        Object[] objectArray = new Object[]{string2, string3, hashMap, hashMap2};
        this.c(s10, objectArray);
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    public void a(String[] stringArray) {
        String string2 = this.a(1);
        Thread thread = new f$6(this, string2);
        thread.start();
        thread = new f$7(this, stringArray);
        thread.start();
    }

    public int b() {
        return this.e;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(int n10, Object object) {
        int n11 = 0;
        Object var4_4 = null;
        int n12 = 1;
        if (n10 == n12) {
            d d10 = this.c;
            if (d10 == null) return;
            object = this.a;
            d10.onComplete((Platform)object, n12, null);
            return;
        }
        int n13 = 2;
        Platform platform = null;
        if (n10 == n13) {
            object = (Object[])object;
            Platform platform2 = this.a;
            Integer n14 = (Integer)object[0];
            n11 = n14;
            Integer n15 = (Integer)object[n12];
            n12 = n15;
            object = (String)object[n13];
            platform2.getFriendList(n11, n12, (String)object);
            return;
        }
        switch (n10) {
            default: {
                Object object2;
                object = (Object[])object;
                String string2 = String.valueOf(object[0]);
                String string3 = String.valueOf(object[n12]);
                Object object3 = object2 = object[n13];
                object3 = (HashMap)object2;
                n11 = 3;
                Object object4 = object = object[n11];
                object4 = (HashMap)object;
                platform = this.a;
                platform.doCustomerProtocol(string2, string3, n10, (HashMap)object3, (HashMap)object4);
                return;
            }
            case 9: {
                object = (Platform$ShareParams)object;
                Object object5 = ((InnerShareParams)object).toMap();
                Field[] fieldArray = object.getClass().getFields();
                int n16 = fieldArray.length;
                Object var9_23 = null;
                for (int i10 = 0; i10 < n16; ++i10) {
                    Object object6 = fieldArray[i10];
                    Object object7 = ((Field)object6).getName();
                    if ((object7 = ((HashMap)object5).get(object7)) != null) continue;
                    ((Field)object6).setAccessible(n12 != 0);
                    try {
                        object7 = ((Field)object6).get(object);
                    }
                    catch (Throwable throwable) {
                        NLog nLog = SSDKLog.b();
                        nLog.w(throwable);
                        object7 = null;
                    }
                    if (object7 == null) continue;
                    object6 = ((Field)object6).getName();
                    ((HashMap)object5).put(object6, object7);
                }
                object5 = this.c;
                n11 = object5 instanceof d;
                if (n11 != 0) {
                    Platform platform3 = this.a;
                    ((d)object5).a(platform3, (Platform$ShareParams)object);
                }
                try {
                    object5 = ((InnerShareParams)object).getLoopshareCustomParams();
                    n10 = ((HashMap)object5).size();
                    if (n10 > 0 && (object5 = ((InnerShareParams)object).getLoopshareCustomParams()) != null) {
                        object5 = this.a;
                        object5 = ((Platform)object5).getName();
                        String string4 = "QQ";
                        n10 = (int)(((String)object5).equals(string4) ? 1 : 0);
                        n11 = 9;
                        if (n10 != 0) {
                            object5 = ((InnerShareParams)object).getTitleUrl();
                            n10 = (int)(TextUtils.isEmpty((CharSequence)object5) ? 1 : 0);
                            if (n10 == 0) {
                                object5 = ((InnerShareParams)object).getLoopshareCustomParams();
                                f$1 f$1 = new f$1(this, (Platform$ShareParams)object);
                                ShareSDK.mobLinkGetMobID((HashMap)object5, f$1);
                                return;
                            }
                            object5 = this.c;
                            if (object5 == null) return;
                            object = "TitleUrl cannot be empty if setLoopshareCustomParams is used in QQ";
                            object5 = new Throwable((String)object);
                            object = this.c;
                            Platform platform4 = this.a;
                            ((d)object).onError(platform4, n11, (Throwable)object5);
                            return;
                        }
                        object5 = ((InnerShareParams)object).getUrl();
                        n10 = (int)(TextUtils.isEmpty((CharSequence)object5) ? 1 : 0);
                        if (n10 == 0) {
                            object5 = this.c;
                            if (object5 == null) return;
                            object5 = ((InnerShareParams)object).getLoopshareCustomParams();
                            f$2 f$2 = new f$2(this, (Platform$ShareParams)object);
                            ShareSDK.mobLinkGetMobID((HashMap)object5, f$2);
                            return;
                        }
                        object5 = this.c;
                        if (object5 == null) return;
                        object = "SetUrl cannot be empty if setLoopshareCustomParams is used";
                        object5 = new Throwable((String)object);
                        object = this.c;
                        Platform platform5 = this.a;
                        ((d)object).onError(platform5, n11, (Throwable)object5);
                        return;
                    }
                    object5 = this.a;
                    ((Platform)object5).doShare((Platform$ShareParams)object);
                    return;
                }
                catch (Throwable throwable) {
                    object = SSDKLog.b();
                    StringBuilder stringBuilder = new StringBuilder();
                    String string5 = "PlatformImpl platform.doshare() ";
                    stringBuilder.append(string5);
                    stringBuilder.append(throwable);
                    String string6 = stringBuilder.toString();
                    Object[] objectArray = new Object[]{};
                    ((NLog)object).d(string6, objectArray);
                    return;
                }
            }
            case 8: {
                void var4_15;
                Platform platform6 = this.a;
                if (object != null) {
                    Object object8 = object;
                    String string7 = (String)object;
                }
                platform6.userInfor((String)var4_15);
                return;
            }
            case 7: {
                object = (Object[])object;
                Platform platform7 = this.a;
                Integer n17 = (Integer)object[0];
                n11 = n17;
                Integer n18 = (Integer)object[n12];
                n12 = n18;
                object = (String)object[n13];
                platform7.timeline(n11, n12, (String)object);
                return;
            }
            case 6: 
        }
        Platform platform8 = this.a;
        object = (String)object;
        platform8.follow((String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(Platform$ShareParams object) {
        int n10 = 9;
        if (object == null) {
            object = this.c;
            if (object != null) {
                Platform platform = this.a;
                NullPointerException nullPointerException = new NullPointerException();
                ((d)object).onError(platform, n10, nullPointerException);
            }
            return;
        }
        try {
            int n11 = ((InnerShareParams)object).getOpenCustomEven();
            if (n11 == 0) {
                n11 = 3;
                Platform platform = this.a;
                ShareSDK.logDemoEvent(n11, platform);
            }
        }
        catch (Throwable throwable) {}
        this.c(n10, object);
    }

    public void b(String string2) {
        this.c(6, string2);
    }

    public PlatformActionListener c() {
        return this.c.a();
    }

    public void c(int n10, Object object) {
        String string2 = this.a(n10);
        Thread thread = new f$3(this, string2);
        thread.start();
        thread = new f$4(this, n10, object);
        thread.start();
    }

    public void c(String string2) {
        this.c(8, string2);
    }

    public String d(String string2) {
        return ShareSDK.a(string2);
    }

    public boolean d() {
        return this.b.isValid();
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.h;
    }

    public PlatformDb g() {
        return this.b;
    }

    public void h() {
        this.b.removeAccount();
    }

    public PlatformActionListener i() {
        return this.c;
    }
}

