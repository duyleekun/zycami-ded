/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.utag;

import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.utag.TagRequester$1;
import com.mob.commons.utag.TagRequester$2;
import com.mob.commons.utag.TagRequester$3;
import com.mob.commons.utag.TagRequester$UserTagsResponse;
import com.mob.commons.utag.UserTagError;
import com.mob.tools.MobLog;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public final class TagRequester
implements PublicMemberKeeper {
    private static HashMap a;
    private static DeviceHelper b;
    private static boolean c;
    private TagRequester$UserTagsResponse d;
    private UserTagError e;

    static {
        b = DeviceHelper.getInstance(MobSDK.getContext());
    }

    public static /* synthetic */ TagRequester$UserTagsResponse a(TagRequester tagRequester) {
        return tagRequester.d;
    }

    public static /* synthetic */ HashMap a(HashMap hashMap, String string2) {
        return TagRequester.b(hashMap, string2);
    }

    public static /* synthetic */ void a() {
        TagRequester.d();
    }

    public static /* synthetic */ boolean a(boolean bl2) {
        c = bl2;
        return bl2;
    }

    public static /* synthetic */ UserTagError b(TagRequester tagRequester) {
        return tagRequester.e;
    }

    public static /* synthetic */ HashMap b() {
        return TagRequester.e();
    }

    private static HashMap b(HashMap hashMap, String string2) {
        MobCommunicator mobCommunicator = new MobCommunicator(1024, "e3e28dce5fe8fc1bb56a25964219d5dc2976edb171b99b1103c2c4f89ad0b66fb58669fe69eb0b5d11e8be990b0715b4de2b4e5a5dcce121f47f18063d5d99f9", "256f461cc45979b52264ac022ff1353ea5f8140d35686ffdae2faee09db2006c3b43c2bb74ce6f4c51698db6384c1c0ceca958208d65c7ed345a04ea6349ca39601818c3d5500565ba49ed49c0f4014b06980d17fc069c95d30092d0cfdaddf783ea96c5f8bdc42b6765d71a5d12192ef74646b41d92f1caeba3123e71938d39");
        return (HashMap)mobCommunicator.requestSynchronized(hashMap, string2, false);
    }

    public static /* synthetic */ DeviceHelper c() {
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void d() {
        Class<TagRequester> clazz = TagRequester.class;
        synchronized (clazz) {
            Object object;
            boolean bl2;
            Object object2 = i.k();
            a = object2;
            boolean bl3 = true;
            if (object2 != null && (bl2 = ((HashMap)object2).containsKey(object = "defHost")) && (bl2 = ((HashMap)(object2 = a)).containsKey(object = "defPort")) && (bl2 = ((HashMap)(object2 = a)).containsKey(object = "defSSLPort")) && (bl2 = ((HashMap)(object2 = a)).containsKey(object = "tagExpire"))) {
                object2 = Calendar.getInstance();
                long l10 = i.j();
                ((Calendar)object2).setTimeInMillis(l10);
                Object object3 = "yyyy-MM-dd";
                object = new SimpleDateFormat((String)object3);
                object3 = ((Calendar)object2).getTime();
                object3 = ((DateFormat)object).format((Date)object3);
                long l11 = System.currentTimeMillis();
                ((Calendar)object2).setTimeInMillis(l11);
                object2 = ((Calendar)object2).getTime();
                object2 = ((DateFormat)object).format((Date)object2);
                bl2 = ((String)object3).equals(object2) ^ bl3;
            } else {
                bl2 = false;
                object2 = null;
                i.a(null);
                object2 = new HashMap();
                a = object2;
                object = "defHost";
                Object object4 = "api.utag.mob.com";
                ((HashMap)object2).put(object, object4);
                object2 = a;
                object = "defPort";
                int n10 = 80;
                object4 = n10;
                ((HashMap)object2).put(object, object4);
                object2 = a;
                object = "defSSLPort";
                n10 = 443;
                object4 = n10;
                ((HashMap)object2).put(object, object4);
                object2 = a;
                object = "tagExpire";
                n10 = 86400;
                object4 = n10;
                ((HashMap)object2).put(object, object4);
                bl2 = bl3;
            }
            if (bl2 && !(bl2 = c)) {
                c = bl3;
                object2 = new TagRequester$3();
                ((Thread)object2).start();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static HashMap e() {
        Class<TagRequester> clazz = TagRequester.class;
        synchronized (clazz) {
            boolean bl2;
            Object object = i.l();
            if (object == null || (bl2 = ((HashMap)object).isEmpty())) {
                int n10;
                Object object2;
                Object object3;
                boolean bl3;
                object = a;
                String string2 = "defPort";
                object = ((HashMap)object).get(string2);
                boolean bl4 = false;
                string2 = null;
                if (object != null && (bl3 = object instanceof Integer)) {
                    int n11 = (Integer)(object = (Integer)object);
                    if (n11 <= 0) {
                        object = "";
                    } else {
                        object3 = new StringBuilder();
                        object2 = ":";
                        ((StringBuilder)object3).append((String)object2);
                        ((StringBuilder)object3).append(n11);
                        object = ((StringBuilder)object3).toString();
                    }
                } else {
                    boolean bl5 = false;
                    object = null;
                }
                object3 = new StringBuilder();
                object2 = "http://";
                ((StringBuilder)object3).append((String)object2);
                object2 = a;
                String string3 = "defHost";
                object2 = ((HashMap)object2).get(string3);
                ((StringBuilder)object3).append(object2);
                ((StringBuilder)object3).append((String)object);
                object = "/utag";
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                object = j.c((String)object);
                object3 = new HashMap();
                object2 = "duid";
                string2 = DeviceAuthorizer.authorize(null);
                ((HashMap)object3).put(object2, string2);
                string2 = "mac";
                object2 = b;
                object2 = ((DeviceHelper)object2).getMacAddress();
                ((HashMap)object3).put(string2, object2);
                string2 = "imei";
                object2 = b;
                object2 = ((DeviceHelper)object2).getIMEI();
                ((HashMap)object3).put(string2, object2);
                string2 = "serialno";
                object2 = b;
                object2 = ((DeviceHelper)object2).getSerialno();
                ((HashMap)object3).put(string2, object2);
                string2 = "model";
                object2 = b;
                object2 = ((DeviceHelper)object2).getModel();
                ((HashMap)object3).put(string2, object2);
                string2 = "appkey";
                object2 = MobSDK.getAppkey();
                ((HashMap)object3).put(string2, object2);
                string2 = "apppkg";
                object2 = b;
                object2 = ((DeviceHelper)object2).getPackageName();
                ((HashMap)object3).put(string2, object2);
                string2 = "appver";
                object2 = b;
                object2 = ((DeviceHelper)object2).getAppVersionName();
                ((HashMap)object3).put(string2, object2);
                string2 = "plat";
                int n12 = 1;
                object2 = n12;
                ((HashMap)object3).put(string2, object2);
                object = TagRequester.b((HashMap)object3, (String)object);
                boolean bl6 = false;
                string2 = null;
                try {
                    object3 = a;
                    object2 = "tagExpire";
                    object3 = ((HashMap)object3).get(object2);
                    object3 = String.valueOf(object3);
                    n10 = Integer.parseInt((String)object3);
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                }
                i.a((HashMap)object, n10);
            }
            return object;
        }
    }

    public void request() {
        synchronized (this) {
            Object object = new TagRequester$2(this);
            object = RxMob.create((RxMob$OnSubscribe)object);
            TagRequester$1 tagRequester$1 = new TagRequester$1(this);
            ((RxMob$Subscribable)object).subscribeOnNewThreadAndObserveOnUIThread(tagRequester$1);
            return;
        }
    }

    public TagRequester whenError(UserTagError userTagError) {
        this.e = userTagError;
        return this;
    }

    public TagRequester whenSuccess(TagRequester$UserTagsResponse tagRequester$UserTagsResponse) {
        this.d = tagRequester$UserTagsResponse;
        return this;
    }
}

