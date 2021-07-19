/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.media.MediaRecorder
 *  android.util.Size
 */
package d.v.d.i.g;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.MediaRecorder;
import android.util.Size;
import d.v.d.h.f;
import d.v.d.i.g.a;
import d.v.d.i.g.b;
import d.v.d.i.g.k$a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class k
extends d.v.d.i.a.a {
    public static final int i = 24;
    public static final int j = 30;
    public static final int k = 60;
    public static final int l = 1280;
    public static final int m = 1920;
    public static final int n = 3840;
    public static final int o = 720;
    public static final int p = 1080;
    public static final int q = 2160;
    public static final k$a r;
    public static final k$a s;
    public static final k$a t;
    private final List h;

    static {
        k$a k$a;
        Size size = new Size(1280, 720);
        r = k$a = new k$a(size, "720P");
        size = new Size(1920, 1080);
        s = k$a = new k$a(size, "1080P");
        size = new Size(3840, 2160);
        t = k$a = new k$a(size, "4K");
    }

    public k() {
        Object object = new ArrayList();
        this.h = object;
        this.a = object = s;
    }

    private void n(k$a k$a, int n10, int n11) {
        List list = this.h;
        boolean bl2 = list.contains(k$a);
        if (!bl2) {
            list = this.h;
            list.add(k$a);
        }
        k$a.c = n11;
        k$a.h(n10);
    }

    private boolean o() {
        boolean bl2;
        Iterator iterator2 = this.a;
        if (iterator2 == null) {
            return false;
        }
        iterator2 = this.h.iterator();
        while (bl2 = iterator2.hasNext()) {
            Size size = ((k$a)iterator2.next()).a;
            Size size2 = ((k$a)this.a).a;
            bl2 = size.equals((Object)size2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private int p(Size size, StreamConfigurationMap streamConfigurationMap) {
        double d10;
        int n10 = 30;
        if (streamConfigurationMap == null) {
            return n10;
        }
        Class<MediaRecorder> clazz = MediaRecorder.class;
        long l10 = streamConfigurationMap.getOutputMinFrameDuration(clazz, size);
        double d11 = (double)l10 / 1.0E9;
        double d12 = d11 - (d10 = 0.0);
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object > 0) {
            return (int)(1.0 / d11);
        }
        return n10;
    }

    public static boolean r(Size size) {
        int n10;
        int n11;
        int n12 = size.getWidth();
        if (n12 == (n11 = 1920) && (n10 = size.getHeight()) == (n12 = 1080)) {
            n10 = 1;
        } else {
            n10 = 0;
            size = null;
        }
        return n10 != 0;
    }

    public static boolean s(Size size) {
        int n10;
        int n11;
        int n12 = size.getWidth();
        if (n12 == (n11 = 3840) && (n10 = size.getHeight()) == (n12 = 2160)) {
            n10 = 1;
        } else {
            n10 = 0;
            size = null;
        }
        return n10 != 0;
    }

    public static boolean t(int n10) {
        int n11 = 60;
        n10 = n11 == n10 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean u(Size size) {
        int n10;
        int n11;
        int n12 = size.getWidth();
        if (n12 == (n11 = 1280) && (n10 = size.getHeight()) == (n12 = 720)) {
            n10 = 1;
        } else {
            n10 = 0;
            size = null;
        }
        return n10 != 0;
    }

    private /* synthetic */ void v(Integer n10, int n11, Size object) {
        int n12;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("support record integer=");
        ((StringBuilder)object2).append(n10);
        String string2 = ",Size=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a((String)object2);
        int n13 = object.getWidth();
        int n14 = 1280;
        if (n13 == n14 && (n13 = object.getHeight()) == (n14 = 720)) {
            object2 = r;
            n14 = n10;
            this.n((k$a)object2, n14, n11);
        }
        if ((n13 = object.getWidth()) == (n14 = 1920) && (n13 = object.getHeight()) == (n14 = 1080)) {
            object2 = s;
            n14 = n10;
            this.n((k$a)object2, n14, n11);
        }
        if ((n13 = object.getWidth()) == (n14 = 3840) && (n12 = object.getHeight()) == (n13 = 2160)) {
            object = t;
            int n15 = n10;
            this.n((k$a)object, n15, n11);
        }
    }

    private /* synthetic */ void x(int n10, Integer n11, List list) {
        a a10 = new a(this, n11, n10);
        list.forEach(a10);
    }

    public void A(k$a k$a) {
        this.a = k$a;
    }

    public void B(List object, int n10, int n11) {
        int n12;
        Object object2 = this.h;
        object2.clear();
        object = object.iterator();
        while ((n12 = object.hasNext()) != 0) {
            object2 = (Size)object.next();
            Object object3 = new StringBuilder();
            String string2 = "support record size=";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(object2);
            object3 = ((StringBuilder)object3).toString();
            d.v.d.h.f.a((String)object3);
            int n13 = object2.getWidth();
            int n14 = 1280;
            if (n13 == n14 && (n13 = object2.getHeight()) == (n14 = 720)) {
                object3 = r;
                this.n((k$a)object3, n10, n11);
            }
            if ((n13 = object2.getWidth()) == (n14 = 1920) && (n13 = object2.getHeight()) == (n14 = 1080)) {
                object3 = s;
                this.n((k$a)object3, n10, n11);
            }
            if ((n13 = object2.getWidth()) != (n14 = 3840) || (n12 = object2.getHeight()) != (n13 = 2160)) continue;
            object2 = t;
            n13 = 30;
            this.n((k$a)object2, n13, n11);
        }
        boolean bl2 = this.o();
        if (!bl2) {
            this.a = object = s;
        }
    }

    public void C(Map map, int n10) {
        this.h.clear();
        b b10 = new b(this, n10);
        map.forEach(b10);
    }

    public void b() {
        super.b();
    }

    public List q() {
        return this.h;
    }

    public /* synthetic */ void w(Integer n10, int n11, Size size) {
        this.v(n10, n11, size);
    }

    public /* synthetic */ void y(int n10, Integer n11, List list) {
        this.x(n10, n11, list);
    }

    public void z(k$a k$a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set record fpsSize =");
        stringBuilder.append(k$a);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = k$a.a;
        int n10 = stringBuilder.getHeight();
        Size size = ((k$a)this.a).a;
        int n11 = size.getHeight();
        if (n10 == n11) {
            d.v.d.h.f.a("current is same fps size ,return");
            this.a = k$a;
            return;
        }
        super.set(k$a);
    }
}

