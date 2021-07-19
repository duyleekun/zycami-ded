/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.AbstractPushManager;
import com.xiaomi.mipush.sdk.PushConfiguration;
import com.xiaomi.mipush.sdk.ah;
import com.xiaomi.mipush.sdk.al;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.f;
import com.xiaomi.mipush.sdk.g;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.mipush.sdk.m;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.ak$a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e
implements AbstractPushManager {
    private static volatile e a;
    private Context a;
    private PushConfiguration a;
    private Map a;
    private boolean a = false;

    private e(Context context) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        this.a = context = context.getApplicationContext();
    }

    public static /* synthetic */ Context a(e e10) {
        return e10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = e.class;
        synchronized (object) {
            e e10 = a;
            if (e10 != null) return a;
            a = e10 = new e(context);
            return a;
        }
    }

    private void a() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            Enum enum_;
            Object object2;
            boolean bl3;
            boolean bl4 = ((PushConfiguration)object).getOpenHmsPush();
            Object object3 = "ASSEMBLE_PUSH : ";
            if (bl4) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" HW user switch : ");
                bl3 = this.a.getOpenHmsPush();
                ((StringBuilder)object).append(bl3);
                ((StringBuilder)object).append(" HW online switch : ");
                object2 = this.a;
                enum_ = d.a;
                bl3 = h.a((Context)object2, (d)enum_);
                ((StringBuilder)object).append(bl3);
                ((StringBuilder)object).append(" HW isSupport : ");
                object2 = ah.a;
                enum_ = m.a(this.a);
                bl3 = ((Enum)object2).equals(enum_);
                ((StringBuilder)object).append(bl3);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                object = ((StringBuilder)object).toString();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                b.a((String)object);
            }
            if ((bl4 = ((PushConfiguration)(object = this.a)).getOpenHmsPush()) && (bl4 = h.a((Context)(object = this.a), (d)((Object)(object2 = d.a)))) && (bl4 = ((Enum)(object = ah.a)).equals(enum_ = m.a(this.a)))) {
                bl4 = this.a((d)((Object)object2));
                if (!bl4) {
                    object = al.a(this.a, (d)((Object)object2));
                    this.a((d)((Object)object2), (AbstractPushManager)object);
                }
                object = "hw manager add to list";
                b.c((String)object);
            } else {
                object = d.a;
                bl3 = this.a((d)((Object)object));
                if (bl3 && (object2 = this.a((d)((Object)object))) != null) {
                    this.a((d)((Object)object));
                    object2.unregister();
                }
            }
            object = this.a;
            bl4 = ((PushConfiguration)object).getOpenFCMPush();
            if (bl4) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" FCM user switch : ");
                bl3 = this.a.getOpenFCMPush();
                ((StringBuilder)object).append(bl3);
                ((StringBuilder)object).append(" FCM online switch : ");
                object2 = this.a;
                enum_ = d.b;
                bl3 = h.a((Context)object2, (d)enum_);
                ((StringBuilder)object).append(bl3);
                ((StringBuilder)object).append(" FCM isSupport : ");
                bl3 = m.a(this.a);
                ((StringBuilder)object).append(bl3);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                object = ((StringBuilder)object).toString();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                b.a((String)object);
            }
            if ((bl4 = ((PushConfiguration)(object = this.a)).getOpenFCMPush()) && (bl4 = h.a((Context)(object = this.a), (d)((Object)(object2 = d.b)))) && (bl4 = m.a((Context)(object = this.a)))) {
                bl4 = this.a((d)((Object)object2));
                if (!bl4) {
                    object = al.a(this.a, (d)((Object)object2));
                    this.a((d)((Object)object2), (AbstractPushManager)object);
                }
                object = "fcm manager add to list";
                b.c((String)object);
            } else {
                object = d.b;
                bl3 = this.a((d)((Object)object));
                if (bl3 && (object2 = this.a((d)((Object)object))) != null) {
                    this.a((d)((Object)object));
                    object2.unregister();
                }
            }
            object = this.a;
            bl4 = ((PushConfiguration)object).getOpenCOSPush();
            if (bl4) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" COS user switch : ");
                bl3 = this.a.getOpenCOSPush();
                ((StringBuilder)object).append(bl3);
                ((StringBuilder)object).append(" COS online switch : ");
                object2 = this.a;
                enum_ = d.c;
                bl3 = h.a((Context)object2, (d)enum_);
                ((StringBuilder)object).append(bl3);
                ((StringBuilder)object).append(" COS isSupport : ");
                bl3 = m.b(this.a);
                ((StringBuilder)object).append(bl3);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                object = ((StringBuilder)object).toString();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                b.a((String)object);
            }
            if ((bl4 = ((PushConfiguration)(object = this.a)).getOpenCOSPush()) && (bl4 = h.a((Context)(object = this.a), (d)((Object)(object3 = d.c)))) && (bl4 = m.b((Context)(object = this.a)))) {
                object = al.a(this.a, (d)((Object)object3));
                this.a((d)((Object)object3), (AbstractPushManager)object);
            } else {
                object = d.c;
                bl2 = this.a((d)((Object)object));
                if (bl2 && (object3 = this.a((d)((Object)object))) != null) {
                    this.a((d)((Object)object));
                    object3.unregister();
                }
            }
            object = this.a;
            bl4 = ((PushConfiguration)object).getOpenFTOSPush();
            if (bl4 && (bl4 = h.a((Context)(object = this.a), (d)((Object)(object3 = d.d)))) && (bl4 = m.c((Context)(object = this.a)))) {
                object = al.a(this.a, (d)((Object)object3));
                this.a((d)((Object)object3), (AbstractPushManager)object);
            } else {
                object = d.d;
                bl2 = this.a((d)((Object)object));
                if (bl2 && (object3 = this.a((d)((Object)object))) != null) {
                    this.a((d)((Object)object));
                    object3.unregister();
                }
            }
        }
    }

    public static /* synthetic */ boolean a(e e10) {
        return e10.a;
    }

    public static /* synthetic */ boolean a(e e10, boolean bl2) {
        e10.a = bl2;
        return bl2;
    }

    public AbstractPushManager a(d d10) {
        return (AbstractPushManager)this.a.get((Object)d10);
    }

    public void a(PushConfiguration object) {
        boolean bl2;
        this.a = object;
        object = ak.a(this.a);
        Object object2 = hr.ao;
        int n10 = object2.a();
        int n11 = 1;
        this.a = bl2 = ((ak)object).a(n10, n11 != 0);
        object = this.a;
        bl2 = ((PushConfiguration)object).getOpenHmsPush();
        if (bl2 || (bl2 = ((PushConfiguration)(object = this.a)).getOpenFCMPush()) || (bl2 = ((PushConfiguration)(object = this.a)).getOpenCOSPush())) {
            object = ak.a(this.a);
            n11 = 101;
            String string2 = "assemblePush";
            object2 = new f(this, n11, string2);
            ((ak)object).a((ak$a)object2);
        }
    }

    public void a(d d10) {
        this.a.remove((Object)d10);
    }

    public void a(d d10, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            Map map = this.a;
            boolean bl2 = map.containsKey((Object)d10);
            if (bl2) {
                map = this.a;
                map.remove((Object)d10);
            }
            map = this.a;
            map.put(d10, abstractPushManager);
        }
    }

    public boolean a(d d10) {
        return this.a.containsKey((Object)d10);
    }

    /*
     * WARNING - void declaration
     */
    public boolean b(d object) {
        void var5_10;
        block8: {
            block4: {
                block5: {
                    block7: {
                        int n11;
                        block6: {
                            int[] nArray = g.a;
                            n11 = ((Enum)object).ordinal();
                            n11 = nArray[n11];
                            int n12 = 1;
                            boolean n10 = false;
                            if (n11 == n12) break block4;
                            n12 = 2;
                            if (n11 == n12) break block5;
                            n12 = 3;
                            if (n11 == n12) break block6;
                            n12 = 4;
                            if (n11 == n12) break block7;
                            break block8;
                        }
                        object = this.a;
                        if (object != null) {
                            int n10 = n11 = (int)(((PushConfiguration)object).getOpenCOSPush() ? 1 : 0);
                        }
                    }
                    if ((object = this.a) != null) {
                        boolean bl2 = ((PushConfiguration)object).getOpenFTOSPush();
                    }
                    break block8;
                }
                object = this.a;
                if (object != null) {
                    boolean bl3 = ((PushConfiguration)object).getOpenFCMPush();
                }
                break block8;
            }
            object = this.a;
            if (object != null) {
                boolean bl4 = ((PushConfiguration)object).getOpenHmsPush();
            }
        }
        return (boolean)var5_10;
    }

    public void register() {
        b.a("ASSEMBLE_PUSH : assemble push register");
        Object object = this.a;
        int n10 = object.size();
        if (n10 <= 0) {
            this.a();
        }
        if ((n10 = (object = this.a).size()) > 0) {
            boolean bl2;
            object = this.a.values().iterator();
            while (bl2 = object.hasNext()) {
                AbstractPushManager abstractPushManager = (AbstractPushManager)object.next();
                if (abstractPushManager == null) continue;
                abstractPushManager.register();
            }
            object = this.a;
            h.a((Context)object);
        }
    }

    public void unregister() {
        boolean bl2;
        b.a("ASSEMBLE_PUSH : assemble push unregister");
        Iterator iterator2 = this.a.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            AbstractPushManager abstractPushManager = (AbstractPushManager)iterator2.next();
            if (abstractPushManager == null) continue;
            abstractPushManager.unregister();
        }
        this.a.clear();
    }
}

