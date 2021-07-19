/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder$DeathRecipient
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$b;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b$a;
import com.xiaomi.push.service.ap$b$b;
import com.xiaomi.push.service.ap$b$c;
import com.xiaomi.push.service.ap$c;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.d;
import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ap$b {
    private int a;
    public Context a;
    public IBinder.DeathRecipient a;
    public Messenger a;
    private XMPushService$b a;
    private XMPushService a;
    public final ap$b$b a;
    public ap$c a;
    public d a;
    public String a;
    private List a;
    public boolean a;
    public ap$c b;
    public String b;
    private boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public ap$b() {
        ArrayList arrayList;
        Object object;
        this.a = object = ap$c.a;
        this.a = 0;
        this.a = arrayList = new ArrayList();
        this.b = null;
        this.b = false;
        super(this);
        this.a = object;
        this.a = null;
        super(this);
        this.a = object;
    }

    public ap$b(XMPushService object) {
        ArrayList arrayList;
        Object object2;
        this.a = object2 = ap$c.a;
        this.a = 0;
        this.a = arrayList = new ArrayList();
        this.b = null;
        this.b = false;
        super(this);
        this.a = object2;
        this.a = null;
        super(this);
        this.a = object2;
        this.a = object;
        object = new aq(this);
        this.a((ap$b$a)object);
    }

    public static /* synthetic */ XMPushService$b a(ap$b ap$b) {
        return ap$b.a;
    }

    public static /* synthetic */ XMPushService a(ap$b ap$b) {
        return ap$b.a;
    }

    public static String a(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (n11 != 0) {
            return string3;
        }
        String string4 = "/";
        n11 = string2.lastIndexOf(string4);
        if (n11 != (n10 = -1)) {
            string3 = string2.substring(++n11);
        }
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, int n11, String string2, String string3) {
        String string4;
        ap$c ap$c;
        this.b = ap$c = this.a;
        int n12 = 2;
        if (n10 == n12) {
            d d10 = this.a;
            string2 = this.a;
            d10.a((Context)string2, this, n11);
            return;
        }
        n12 = 3;
        if (n10 == n12) {
            d d11 = this.a;
            Context context = this.a;
            d11.a(context, this, string3, string2);
            return;
        }
        n12 = 1;
        if (n10 != n12) return;
        ap$c ap$c2 = ap$c.c;
        int n13 = ap$c == ap$c2 ? n12 : 0;
        if (n13 == 0 && (n10 = (int)((string4 = "wait").equals(string3) ? 1 : 0)) != 0) {
            this.a = n10 = this.a + n12;
        } else if (n13 != 0) {
            this.a = 0;
            Messenger messenger = this.a;
            if (messenger != null) {
                n10 = 0;
                int n14 = 16;
                ap$c = this.a.a;
                Message message = Message.obtain(null, (int)n14, (Object)((Object)ap$c));
                try {
                    string3 = this.a;
                    string3.send(message);
                }
                catch (RemoteException remoteException) {}
            }
        }
        d d12 = this.a;
        XMPushService xMPushService = this.a;
        d12.a((Context)xMPushService, this, n13 != 0, n11, string2);
    }

    public static /* synthetic */ void a(ap$b ap$b, int n10, int n11, String string2, String string3) {
        ap$b.a(n10, n11, string2, string3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(int n10, int n11, String string2) {
        String string3;
        Object object = this.b;
        n11 = 1;
        if (object == null) return n11 != 0;
        boolean bl2 = this.b;
        if (!bl2) {
            return n11 != 0;
        }
        ap$c ap$c = this.a;
        if (object == ap$c) {
            object = new StringBuilder();
            string3 = " status recovered, don't notify client:";
        } else {
            object = this.a;
            if (object != null && bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Peer alive notify status to client:");
                string2 = this.g;
                ((StringBuilder)object).append(string2);
                com.xiaomi.channel.commonutils.logger.b.b(((StringBuilder)object).toString());
                return n11 != 0;
            }
            object = new StringBuilder();
            string3 = "peer died, ignore notify ";
        }
        ((StringBuilder)object).append(string3);
        string3 = this.g;
        ((StringBuilder)object).append(string3);
        com.xiaomi.channel.commonutils.logger.b.b(((StringBuilder)object).toString());
        return false;
    }

    public static /* synthetic */ boolean a(ap$b ap$b, int n10, int n11, String string2) {
        return ap$b.a(n10, n11, string2);
    }

    private boolean b(int n10, int n11, String string2) {
        String string3 = "wait";
        int n12 = 1;
        if (n10 != n12) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return false;
                }
                return (string3.equals(string2) ^ n12) != 0;
            }
            return this.a.c();
        }
        Object object = this.a;
        ap$c ap$c = ap$c.c;
        if (object == ap$c) {
            return false;
        }
        object = this.a;
        n10 = (int)(((XMPushService)object).c() ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        n10 = 21;
        if (n11 != n10 && (n11 != (n10 = 7) || (n10 = (int)(string3.equals(string2) ? 1 : 0)) == 0)) {
            return n12 != 0;
        }
        return false;
    }

    public long a() {
        long l10 = (long)(Math.random() * 20.0 - 10.0);
        long l11 = (this.a + 1) * 15;
        return (l10 + l11) * 1000L;
    }

    public String a(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return "unknown";
                }
                return "KICK";
            }
            return "CLOSE";
        }
        return "OPEN";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        try {
            IBinder.DeathRecipient deathRecipient;
            Messenger messenger = this.a;
            if (messenger != null && (deathRecipient = this.a) != null) {
                messenger = messenger.getBinder();
                deathRecipient = this.a;
                messenger.unlinkToDeath(deathRecipient, 0);
            }
        }
        catch (Exception exception) {}
        this.b = null;
    }

    public void a(Messenger object) {
        Object object2;
        this.a();
        if (object != null) {
            this.a = object;
            boolean bl2 = true;
            this.b = bl2;
            object2 = new ap$b$c(this, this, (Messenger)object);
            this.a = object2;
            object = object.getBinder();
            object2 = this.a;
            object.linkToDeath((IBinder.DeathRecipient)object2, 0);
        }
        object = new StringBuilder();
        object2 = "peer linked with old sdk chid = ";
        ((StringBuilder)object).append((String)object2);
        object2 = this.g;
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        try {
            com.xiaomi.channel.commonutils.logger.b.b((String)object);
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            String string2 = "peer linkToDeath err: ";
            ((StringBuilder)object2).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)object2).append(string3);
            com.xiaomi.channel.commonutils.logger.b.b(((StringBuilder)object2).toString());
            string3 = null;
            this.a = null;
            this.b = false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ap$b$a ap$b$a) {
        List list = this.a;
        synchronized (list) {
            List list2 = this.a;
            list2.add(ap$b$a);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ap$c object, int n10, int n11, String string2, String string3) {
        int n12;
        Object[] objectArray;
        Object object2;
        Object object3;
        Object object4 = this.a;
        synchronized (object4) {
            boolean bl2;
            object3 = this.a;
            object3 = object3.iterator();
            while (bl2 = object3.hasNext()) {
                object2 = object3.next();
                object2 = (ap$b$a)object2;
                objectArray = this.a;
                object2.a((ap$c)objectArray, (ap$c)((Object)object), n11);
            }
        }
        object4 = this.a;
        int n13 = 0;
        object3 = null;
        if (object4 != object) {
            object2 = "update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s";
            int n14 = 7;
            objectArray = new Object[n14];
            objectArray[0] = object4;
            objectArray[1] = object;
            String string4 = this.a(n10);
            objectArray[2] = string4;
            string4 = at.a(n11);
            objectArray[3] = string4;
            objectArray[4] = string2;
            objectArray[5] = string3;
            n12 = 6;
            string4 = this.g;
            objectArray[n12] = string4;
            object4 = String.format((String)object2, objectArray);
            com.xiaomi.channel.commonutils.logger.b.a((String)object4);
            this.a = object;
        }
        if ((object4 = this.a) == null) {
            com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            return;
        }
        object4 = ap$c.b;
        if (object == object4) {
            return;
        }
        int n15 = 10100;
        object4 = this.b;
        if (object4 != null && (n12 = this.b) != 0) {
            object3 = this.a;
            n13 = object3 != null && n12 != 0 ? 1000 : n15;
        }
        object = this.a;
        object4 = this.a;
        ((XMPushService)object).b((XMPushService$i)object4);
        n15 = (int)(this.b(n10, n11, string3) ? 1 : 0);
        if (n15 != 0) {
            this.a(n10, n11, string2, string3);
            return;
        }
        object = this.a;
        object4 = this.a;
        XMPushService$i xMPushService$i = ((ap$b$b)object4).a(n10, n11, string2, string3);
        long l10 = n13;
        ((XMPushService)object).a(xMPushService$i, l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(ap$b$a ap$b$a) {
        List list = this.a;
        synchronized (list) {
            List list2 = this.a;
            list2.remove(ap$b$a);
            return;
        }
    }
}

