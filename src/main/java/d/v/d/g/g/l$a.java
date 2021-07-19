/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.g;

import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeCharacteristics;
import com.huawei.camera.camerakit.ModeStateCallback;
import d.v.d.g.g.l;
import d.v.d.g.g.m;
import d.v.d.h.f;
import d.v.d.i.b.d;
import d.v.d.i.c.c;
import d.v.d.i.f.u;

public class l$a
extends ModeStateCallback {
    public final /* synthetic */ l a;

    public l$a(l l10) {
        this.a = l10;
    }

    public void onConfigureFailed(Mode object, int n10) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onConfigure mode Failed errorCode=");
        ((StringBuilder)object).append(n10);
        f.a(((StringBuilder)object).toString());
        object = this.a.j();
        Integer n11 = 5;
        ((c)object).s(n11);
        object = this.a.p();
        n11 = 4;
        ((d)object).q(n11);
        l.d(this.a);
    }

    public void onConfigured(Mode object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("onConfigured mode succeed getDeviceStatus=");
        Object object3 = this.a.j();
        ((StringBuilder)object2).append(object3);
        object3 = ",mode=";
        ((StringBuilder)object2).append((String)object3);
        int bl2 = ((Mode)object).getType();
        ((StringBuilder)object2).append(bl2);
        f.a(((StringBuilder)object2).toString());
        object = this.a.j();
        object2 = 3;
        ((c)object).s((Integer)object2);
        object = this.a.n();
        int n10 = 2;
        object2 = n10;
        ((u)object).r((Integer)object2);
        object = this.a;
        object2 = ((l)object).a;
        if (object2 != null) {
            int n11 = 1;
            boolean bl3 = ((l)object).e.p().j();
            ((Mode)object2).setFaceDetection(n11, bl3);
            object = this.a.a;
            ((Mode)object).startPreview();
        }
        l.d(this.a);
    }

    public void onCreateFailed(String object, int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCreate mode Failed cameraId=");
        stringBuilder.append((String)object);
        stringBuilder.append(",modeType=");
        stringBuilder.append(n10);
        stringBuilder.append(",errorCode=");
        stringBuilder.append(n11);
        f.a(stringBuilder.toString());
        object = this.a.j();
        Integer n12 = 5;
        ((c)object).s(n12);
        object = this.a.p();
        n12 = 4;
        ((d)object).q(n12);
        l.d(this.a);
    }

    public void onCreated(Mode object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("onCreate mode succeed getDeviceStatus=");
        c c10 = this.a.j();
        ((StringBuilder)object2).append(c10);
        f.a(((StringBuilder)object2).toString());
        object2 = this.a;
        ((l)object2).a = object;
        object2 = ((l)object2).e;
        object = ((Mode)object).getModeCharacteristics();
        ((m)object2).v0((ModeCharacteristics)object);
        this.a.h();
    }

    public void onFatalError(Mode object, int n10) {
        object = new StringBuilder();
        ((StringBuilder)object).append("on Fatal Error errorCode=");
        ((StringBuilder)object).append(n10);
        f.a(((StringBuilder)object).toString());
        l.d(this.a);
    }

    public void onReleased(Mode object) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append("on Released mode=");
        int n10 = ((Mode)object).getType();
        comparable.append(n10);
        f.a(comparable.toString());
        object = this.a;
        ((l)object).a = null;
        object = ((l)object).j();
        comparable = 1;
        ((c)object).s((Integer)comparable);
        object = this.a.n();
        comparable = 4;
        ((u)object).r((Integer)comparable);
        l.d(this.a);
    }
}

