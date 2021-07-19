/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Message
 *  android.os.Messenger
 */
package com.baidu.location.b;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.baidu.location.PoiRegion;
import com.baidu.location.b.b$a;
import com.baidu.location.b.b$b;
import com.baidu.location.b.o;
import com.baidu.location.b.s;
import com.baidu.location.c.a;
import com.baidu.location.f;
import com.baidu.location.f.i;
import com.baidu.location.h.l;
import com.baidu.location.indoor.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b {
    public static long c = 0L;
    public static int d = 255;
    private static b f;
    public boolean a = false;
    public boolean b = false;
    public int e = 0;
    private ArrayList g = null;
    private boolean h = false;
    private BDLocation i = null;
    private BDLocation j = null;
    private BDLocation k = null;
    private boolean l = false;
    private boolean m = false;
    private b$b n = null;

    private b() {
        ArrayList arrayList;
        this.g = arrayList = new ArrayList();
    }

    private b$a a(Messenger messenger) {
        boolean bl2;
        Object object = this.g;
        if (object == null) {
            return null;
        }
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            b$a b$a = (b$a)object.next();
            Messenger messenger2 = b$a.b;
            boolean bl3 = messenger2.equals((Object)messenger);
            if (!bl3) continue;
            return b$a;
        }
        return null;
    }

    public static b a() {
        b b10 = f;
        if (b10 == null) {
            f = b10 = new b();
        }
        return f;
    }

    private void a(b$a b$a) {
        int n10;
        if (b$a == null) {
            return;
        }
        Object object = b$a.b;
        if ((object = this.a((Messenger)object)) != null) {
            n10 = 14;
        } else {
            object = this.g;
            ((ArrayList)object).add(b$a);
            n10 = 13;
        }
        b$a.a(b$a, n10);
    }

    public static /* synthetic */ boolean a(b b10, boolean bl2) {
        b10.m = bl2;
        return bl2;
    }

    private void b(String string2) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", string2);
        string2 = com.baidu.location.h.b.e;
        intent.putExtra("pack", string2);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void f() {
        this.g();
        this.e();
    }

    private void g() {
        boolean bl2;
        Object object = this.g.iterator();
        boolean bl3 = false;
        boolean bl4 = false;
        while (bl2 = object.hasNext()) {
            LocationClientOption locationClientOption = ((b$a)object.next()).c;
            boolean bl5 = locationClientOption.openGps;
            boolean bl6 = true;
            if (bl5) {
                bl4 = bl6;
            }
            if (!(bl2 = locationClientOption.location_change_notify)) continue;
            bl3 = bl6;
        }
        com.baidu.location.h.l.a = bl3;
        boolean bl7 = this.h;
        if (bl7 != bl4) {
            this.h = bl4;
            object = com.baidu.location.f.f.a();
            bl3 = this.h;
            ((com.baidu.location.f.f)object).a(bl3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Bundle bundle, int n10) {
        Iterator iterator2 = this.g.iterator();
        try {
            int n11;
            while ((n11 = iterator2.hasNext()) != 0) {
                Object object = iterator2.next();
                object = (b$a)object;
                b$a.a(object, n10, bundle);
                n11 = ((b$a)object).d;
                int n12 = 4;
                if (n11 <= n12) continue;
                iterator2.remove();
            }
            return;
        }
        catch (Exception exception) {}
    }

    public void a(Message message) {
        Object object;
        if (message != null && (object = message.replyTo) != null) {
            boolean bl2;
            long l10;
            c = l10 = System.currentTimeMillis();
            this.a = bl2 = true;
            com.baidu.location.f.i.a().b();
            object = new b$a(this, message);
            this.a((b$a)object);
            this.f();
            boolean bl3 = this.l;
            if (bl3) {
                this.b("start");
                bl3 = false;
                message = null;
                this.e = 0;
            }
        }
    }

    public void a(BDLocation bDLocation) {
        this.b(bDLocation);
    }

    public void a(String string2) {
        BDLocation bDLocation = new BDLocation(string2);
        this.c(bDLocation);
    }

    public void a(boolean bl2) {
        this.a = bl2;
        bl2 = bl2;
        d = (int)(bl2 ? 1 : 0);
    }

    public void b() {
        this.g.clear();
        this.i = null;
        this.f();
    }

    public void b(Message object) {
        object = ((Message)object).replyTo;
        if ((object = this.a((Messenger)object)) != null) {
            ArrayList arrayList = this.g;
            arrayList.remove(object);
        }
        object = s.a();
        ((s)object).c();
        this.f();
        boolean bl2 = this.l;
        if (bl2) {
            this.b("stop");
            bl2 = false;
            object = null;
            this.e = 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(BDLocation bDLocation) {
        double d10;
        double d11;
        int n10;
        int n11;
        int n12;
        float f10;
        int n13;
        float f11;
        int n14;
        int n15;
        block15: {
            Object object;
            n15 = 4;
            n14 = 66;
            f11 = 9.2E-44f;
            n13 = 61;
            f10 = 8.5E-44f;
            n12 = 161;
            if (bDLocation != null && (n11 = bDLocation.getLocType()) == n12 && (n11 = (int)(((com.baidu.location.a.a)(object = com.baidu.location.a.a.a())).b() ? 1 : 0)) == 0) {
                object = this.j;
                if (object == null) {
                    this.j = object = new BDLocation();
                    n10 = 505;
                    ((BDLocation)object).setLocType(n10);
                }
                object = this.g.iterator();
                while ((n10 = object.hasNext()) != 0) {
                    Object object2 = object.next();
                    object2 = (b$a)object2;
                    BDLocation bDLocation2 = this.j;
                    ((b$a)object2).a(bDLocation2);
                    n10 = ((b$a)object2).d;
                    if (n10 <= n15) continue;
                    object.remove();
                }
                break block15;
            }
            n11 = (int)(bDLocation.hasAltitude() ? 1 : 0);
            if (n11 == 0 && (n11 = (int)(this.b ? 1 : 0)) != 0 && ((n11 = bDLocation.getLocType()) == n12 || (n11 = bDLocation.getLocType()) == n14)) {
                object = com.baidu.location.c.a.a();
                d11 = bDLocation.getLongitude();
                d10 = bDLocation.getLatitude();
                object = ((a)object).a(d11, d10);
                d11 = (double)object[0];
                com.baidu.location.c.a.a();
                d10 = 9999.0;
                n11 = (int)(d11 == d10 ? 0 : (d11 < d10 ? -1 : 1));
                if (n11 < 0) {
                    bDLocation.setAltitude(d11);
                }
            }
            if ((n11 = bDLocation.getLocType()) == n13) {
                object = com.baidu.location.c.a.a();
                n11 = ((a)object).a(bDLocation);
                bDLocation.setGpsAccuracyStatus(n11);
            }
            object = this.g.iterator();
            try {
                while ((n10 = object.hasNext()) != 0) {
                    Object object3 = object.next();
                    object3 = (b$a)object3;
                    ((b$a)object3).a(bDLocation);
                    n10 = ((b$a)object3).d;
                    if (n10 <= n15) continue;
                    object.remove();
                }
            }
            catch (Exception exception) {}
        }
        if ((n15 = (int)(o.h ? 1 : 0)) != 0) {
            o.h = false;
        }
        if ((n11 = com.baidu.location.h.l.Z) >= (n10 = 10000) && ((n11 = bDLocation.getLocType()) == n13 || (n13 = bDLocation.getLocType()) == n12 || (n13 = bDLocation.getLocType()) == n14)) {
            BDLocation bDLocation3;
            BDLocation bDLocation4 = this.i;
            if (bDLocation4 != null) {
                float[] fArray = new float[1];
                double d12 = bDLocation4.getLatitude();
                bDLocation4 = this.i;
                d11 = bDLocation4.getLongitude();
                d10 = bDLocation.getLatitude();
                double d13 = bDLocation.getLongitude();
                Location.distanceBetween((double)d12, (double)d11, (double)d10, (double)d13, (float[])fArray);
                f11 = fArray[0];
                n13 = com.baidu.location.h.l.ab;
                f10 = n13;
                n14 = (int)(f11 == f10 ? 0 : (f11 < f10 ? -1 : 1));
                if (n14 <= 0 && n15 == 0) {
                    return;
                }
                n15 = 0;
                this.i = null;
                bDLocation3 = new BDLocation(bDLocation);
            } else {
                bDLocation3 = new BDLocation(bDLocation);
            }
            this.i = bDLocation3;
        }
    }

    public void c() {
        boolean bl2;
        Iterator iterator2 = this.g.iterator();
        while (bl2 = iterator2.hasNext()) {
            b$a b$a = (b$a)iterator2.next();
            b$a.a();
        }
    }

    public void c(BDLocation bDLocation) {
        boolean bl2;
        Object object = o.c().a(bDLocation);
        String string2 = o.c().f();
        List list = o.c().g();
        PoiRegion poiRegion = o.c().h();
        if (object != null) {
            bDLocation.setAddr((Address)object);
        }
        if (string2 != null) {
            bDLocation.setLocationDescribe(string2);
        }
        if (list != null) {
            bDLocation.setPoiList(list);
        }
        if (poiRegion != null) {
            bDLocation.setPoiRegion(poiRegion);
        }
        if ((bl2 = ((g)(object = com.baidu.location.indoor.g.a())).f()) && (object = com.baidu.location.indoor.g.a().g()) != null) {
            object = com.baidu.location.indoor.g.a().g();
            bDLocation.setFloor((String)object);
            bl2 = true;
            bDLocation.setIndoorLocMode(bl2);
            object = com.baidu.location.indoor.g.a().h();
            if (object != null) {
                object = com.baidu.location.indoor.g.a().h();
                bDLocation.setBuildingID((String)object);
            }
        }
        this.a(bDLocation);
        o.c().c(bDLocation);
    }

    public boolean c(Message message) {
        boolean bl2;
        Object object;
        int n10;
        int n11;
        Object object2;
        Object object3;
        int n12;
        Object object4;
        boolean bl3;
        Object object5;
        block11: {
            boolean bl4;
            block13: {
                block12: {
                    object5 = message.replyTo;
                    object5 = this.a((Messenger)object5);
                    bl3 = false;
                    if (object5 == null) {
                        return false;
                    }
                    object4 = object5.c;
                    n12 = ((LocationClientOption)object4).scanSpan;
                    object3 = message.getData();
                    object2 = object5.c;
                    int bl22 = ((LocationClientOption)object2).scanSpan;
                    String string2 = "scanSpan";
                    n11 = object3.getInt(string2, bl22);
                    ((LocationClientOption)object4).scanSpan = n11;
                    object4 = object5.c;
                    n10 = ((LocationClientOption)object4).scanSpan;
                    n11 = 1000;
                    bl4 = true;
                    if (n10 < n11) {
                        object4 = s.a();
                        ((s)object4).c();
                        this.a = false;
                    } else {
                        this.a = bl4;
                    }
                    object4 = object5.c;
                    int n13 = ((LocationClientOption)object4).scanSpan;
                    int n14 = 999;
                    if (n13 <= n14 || n12 >= n11) break block11;
                    n12 = (int)(((LocationClientOption)object4).mIsNeedDeviceDirect ? 1 : 0);
                    if (n12 != 0 || (n10 = (int)(((LocationClientOption)object4).isNeedAltitude ? 1 : 0)) != 0) {
                        object4 = s.a();
                        object = object5.c;
                        n12 = (int)(object.mIsNeedDeviceDirect ? 1 : 0);
                        ((s)object4).a(n12 != 0);
                        object4 = s.a();
                        ((s)object4).b();
                    }
                    if ((n10 = (int)(this.b ? 1 : 0)) != 0) break block12;
                    object4 = object5.c;
                    n10 = (int)(((LocationClientOption)object4).isNeedAltitude ? 1 : 0);
                    if (n10 == 0) break block13;
                }
                bl3 = bl4;
            }
            this.b = bl3;
            bl3 = bl4;
        }
        object4 = object5.c;
        object = message.getData();
        n11 = (int)(object5.c.openGps ? 1 : 0);
        object2 = "openGPS";
        ((LocationClientOption)object4).openGps = n12 = (int)(object.getBoolean((String)object2, n11 != 0) ? 1 : 0);
        object4 = message.getData().getString("coorType");
        object = object5.c;
        object3 = "";
        if (object4 == null || (bl2 = ((String)object4).equals(object3))) {
            object4 = object5.c.coorType;
        }
        object.coorType = object4;
        object4 = message.getData().getString("addrType");
        object = object5.c;
        if (object4 == null || (n11 = ((String)object4).equals(object3))) {
            object4 = object5.c.addrType;
        }
        object.addrType = object4;
        object4 = com.baidu.location.h.l.g;
        object = object5.c.addrType;
        n10 = (int)(((String)object4).equals(object) ? 1 : 0);
        if (n10 == 0) {
            object4 = o.c();
            ((o)object4).k();
        }
        object4 = object5.c;
        object = message.getData();
        n11 = object5.c.timeOut;
        ((LocationClientOption)object4).timeOut = n12 = object.getInt("timeOut", n11);
        object4 = object5.c;
        object = message.getData();
        n11 = (int)(object5.c.location_change_notify ? 1 : 0);
        object2 = "location_change_notify";
        n12 = (int)(object.getBoolean((String)object2, n11 != 0) ? 1 : 0);
        ((LocationClientOption)object4).location_change_notify = n12;
        object4 = object5.c;
        object = message.getData();
        object5 = object5.c;
        int n15 = object5.priority;
        object3 = "priority";
        ((LocationClientOption)object4).priority = n15 = object.getInt((String)object3, n15);
        int n16 = (message = message.getData()).getInt((String)(object4 = "wifitimeout"), -1 >>> 1);
        if (n16 < (n15 = com.baidu.location.h.l.ai)) {
            com.baidu.location.h.l.ai = n16;
        }
        this.f();
        return bl3;
    }

    public int d(Message object) {
        int n10 = 1;
        if (object != null && (object = object.replyTo) != null && (object = this.a((Messenger)object)) != null && (object = object.c) != null) {
            return object.priority;
        }
        return n10;
    }

    public String d() {
        CharSequence charSequence = new StringBuffer(256);
        Object object = this.g;
        boolean bl2 = ((ArrayList)object).isEmpty();
        String string2 = ":";
        String string3 = "&prod=";
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            object = com.baidu.location.h.b.f;
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string2);
            object = com.baidu.location.h.b.e;
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        object = (b$a)this.g.get(0);
        String string4 = object.c.prodName;
        if (string4 != null) {
            ((StringBuffer)charSequence).append(string4);
        }
        if ((string4 = ((b$a)object).a) != null) {
            ((StringBuffer)charSequence).append(string2);
            object = ((b$a)object).a;
            ((StringBuffer)charSequence).append((String)object);
            object = "|";
            ((StringBuffer)charSequence).append((String)object);
        }
        if ((charSequence = ((StringBuffer)charSequence).toString()) != null && !(bl2 = ((String)charSequence).equals(object = ""))) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append((String)charSequence);
            charSequence = ((StringBuilder)object).toString();
        } else {
            charSequence = null;
        }
        return charSequence;
    }

    public int e(Message object) {
        int n10 = 1000;
        if (object != null && (object = object.replyTo) != null && (object = this.a((Messenger)object)) != null && (object = object.c) != null) {
            return object.scanSpan;
        }
        return n10;
    }

    public void e() {
        boolean bl2;
        Iterator iterator2 = this.g.iterator();
        while (bl2 = iterator2.hasNext()) {
            b$a b$a = (b$a)iterator2.next();
            b$a.b();
        }
    }
}

