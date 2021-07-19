/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.os.SystemClock
 */
package com.mob.commons.a;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.mob.MobSDK;
import com.mob.commons.FBListener;
import com.mob.commons.a.m;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashSet;

public class m$1
implements Handler.Callback {
    public final /* synthetic */ m a;

    public m$1(m m10) {
        this.a = m10;
    }

    /*
     * WARNING - void declaration
     */
    public boolean handleMessage(Message object) {
        block18: {
            boolean bl2 = ((Message)object).what;
            long l10 = 0L;
            if (bl2) {
                boolean bl3 = true;
                if (bl2 != bl3) {
                    boolean bl4 = 2 != 0;
                    if (bl2 != bl4) {
                        boolean bl5 = 3 != 0;
                        if (bl2 == bl5) {
                            Object object2;
                            block19: {
                                object = ((Message)object).obj;
                                object = (FBListener)object;
                                if (object == null) break block18;
                                object2 = this.a;
                                object2 = m.b((m)object2);
                                ((HashSet)object2).add(object);
                                object2 = this.a;
                                long l11 = m.c((m)object2);
                                long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                                if (l12 > 0) {
                                    boolean bl6 = bl3;
                                    break block19;
                                }
                                boolean bl7 = false;
                                object2 = null;
                            }
                            try {
                                void var2_7;
                                object.onFBChanged((boolean)var2_7, bl3, l10);
                            }
                            catch (Throwable throwable) {
                                object2 = MobLog.getInstance();
                                ((NLog)object2).d(throwable);
                            }
                        }
                    } else {
                        m m10 = this.a;
                        object = (Long)((Message)object).obj;
                        l10 = (Long)object;
                        m.a(m10, l10, bl3);
                    }
                } else {
                    object = this.a;
                    m.a((m)object, bl3);
                }
            } else {
                object = DeviceHelper.getInstance(MobSDK.getContext());
                boolean bl8 = ((DeviceHelper)object).amIOnForeground();
                if (bl8) {
                    object = this.a;
                    long l13 = SystemClock.elapsedRealtime();
                    m.a((m)object, l13);
                    object = this.a;
                    m.a((m)object, false);
                } else {
                    object = this.a;
                    m.a((m)object, l10, false);
                }
                object = this.a;
                m.a((m)object);
            }
        }
        return false;
    }
}

