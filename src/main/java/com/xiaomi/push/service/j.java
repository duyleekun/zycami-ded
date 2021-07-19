/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.bi;
import com.xiaomi.push.service.i;
import com.xiaomi.push.service.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class j
extends XMPushService$i {
    public final /* synthetic */ i a;
    public final /* synthetic */ String a;
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;

    public j(i i10, int n10, String string2, List list, String string3) {
        this.a = i10;
        this.a = string2;
        this.a = list;
        this.b = string3;
        super(n10);
    }

    public String a() {
        return "Send tiny data.";
    }

    public void a() {
        Object object = this.a;
        Iterator iterator2 = this.a;
        object = i.a((i)object, (String)((Object)iterator2));
        iterator2 = this.a;
        Object object2 = this.a;
        int n10 = 32768;
        if ((iterator2 = bi.a((List)((Object)iterator2), (String)object2, (String)object, n10)) != null) {
            boolean bl2;
            iterator2 = ((ArrayList)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object2 = (il)iterator2.next();
                ((il)object2).a("uploadWay", "longXMPushService");
                Object object3 = this.a;
                Object object4 = hm.i;
                object2 = w.a((String)object3, (String)object, (ix)object2, object4);
                object3 = this.b;
                n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n10 == 0 && (n10 = (int)(TextUtils.equals((CharSequence)(object3 = this.a), (CharSequence)(object4 = this.b)) ? 1 : 0)) == 0) {
                    object3 = ((ii)object2).a();
                    if (object3 == null) {
                        object3 = new hz();
                        object4 = "-1";
                        ((hz)object3).a((String)object4);
                        ((ii)object2).a((hz)object3);
                    }
                    object3 = ((ii)object2).a();
                    object4 = this.b;
                    String string2 = "ext_traffic_source_pkg";
                    ((hz)object3).b(string2, (String)object4);
                }
                object2 = iw.a((ix)object2);
                object3 = i.a(this.a);
                object4 = this.a;
                boolean bl3 = true;
                ((XMPushService)object3).a((String)object4, (byte[])object2, bl3);
            }
        } else {
            object = "TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.";
            com.xiaomi.channel.commonutils.logger.b.d((String)object);
        }
    }
}

