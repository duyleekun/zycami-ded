/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.c.y0.c;

import android.app.Application;
import android.content.Context;
import androidx.core.util.Pair;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$FirmwareFailType;
import d.v.c.v0.u.z;
import d.v.c.y0.c.o$a;
import d.v.e.i.h;
import d.v.e.l.c2;
import d.v.e.l.s1;
import d.v.f.i.g;
import java.lang.constant.Constable;
import java.util.List;
import m.a.a;

public class o
extends AndroidViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private final MutableLiveData g;
    private MutableLiveData h;
    private MutableLiveData i;
    private MutableLiveData j;
    private MutableLiveData k;
    private MutableLiveData l;
    private final MutableLiveData m;
    private boolean n;
    private String o;

    public o(Application object) {
        super((Application)object);
        Constable constable = 2131231796;
        super(constable);
        this.a = object;
        super();
        this.b = object;
        super();
        this.c = object;
        super();
        this.d = object;
        super();
        this.e = object;
        super();
        this.f = object;
        constable = Boolean.FALSE;
        super(constable);
        this.g = object;
        super();
        this.h = object;
        super();
        this.i = object;
        super();
        this.j = object;
        super();
        this.k = object;
        super();
        this.l = object;
        super();
        this.m = object;
        this.n = true;
    }

    private void u(int n10) {
        Boolean bl2;
        int n11;
        MutableLiveData mutableLiveData = this.e;
        if (n10 != 0 && n10 != (n11 = 4) && n10 != (n11 = 2) && n10 != (n11 = 9) && n10 != (n11 = 6) && n10 != (n11 = 10)) {
            n10 = 0;
            bl2 = null;
        } else {
            n10 = 1;
        }
        bl2 = n10 != 0;
        mutableLiveData.setValue(bl2);
    }

    private void w(int n10) {
        int n11;
        MutableLiveData mutableLiveData = this.f;
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 5) && n10 != (n11 = 8)) {
            n12 = 0;
        }
        Boolean bl2 = n12 != 0;
        mutableLiveData.setValue(bl2);
    }

    public void b(Context object, FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType) {
        int[] nArray = o$a.a;
        int n10 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
        n10 = nArray[n10];
        nArray = null;
        int n11 = 1;
        switch (n10) {
            default: {
                n10 = 2131952200;
                object = d.v.f.i.g.m(object, n10);
                break;
            }
            case 7: {
                n10 = 2131952199;
                object = d.v.f.i.g.m(object, n10);
                break;
            }
            case 6: {
                n10 = 2131953203;
                object = d.v.f.i.g.m(object, n10);
                break;
            }
            case 5: {
                n10 = 2131952201;
                object = d.v.f.i.g.m(object, n10);
                break;
            }
            case 4: {
                n10 = 2131952203;
                object = d.v.f.i.g.m(object, n10);
                break;
            }
            case 3: {
                n10 = 2131952202;
                object = d.v.f.i.g.m(object, n10);
                break;
            }
            case 2: {
                n10 = 2131953204;
                Object[] objectArray = new Object[n11];
                String string2 = this.o;
                objectArray[0] = string2;
                object = d.v.f.i.g.n(object, n10, objectArray);
                break;
            }
            case 1: {
                n10 = 2131953205;
                Object[] objectArray = new Object[n11];
                String string3 = this.o;
                objectArray[0] = string3;
                object = d.v.f.i.g.n(object, n10, objectArray);
            }
        }
        this.h.setValue(object);
    }

    public void c(FirmwareInfo object, List object2) {
        if (object != null && object2 != null) {
            String string2;
            float f10 = ((FirmwareInfo)object).getVersion();
            Object object3 = String.valueOf(f10);
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = ((FirmwareInfo)object).getReleaseNotes();
            charSequence.append((String)objectArray);
            charSequence.append("\n");
            charSequence = charSequence.toString();
            objectArray = s1.D(((FirmwareInfo)object).getPath());
            long l10 = ((FirmwareInfo)object).getFilesize();
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            CharSequence charSequence2 = ")";
            String string3 = "(";
            if (l12 > 0) {
                long l13 = ((FirmwareInfo)object).getFilesize();
                double d10 = l13;
                string2 = c2.a(d10);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                stringBuilder.append((String)charSequence2);
                string2 = stringBuilder.toString();
            } else {
                string2 = "";
            }
            int n10 = object2.indexOf(object);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(++n10);
            stringBuilder.append("/");
            int n11 = object2.size();
            stringBuilder.append(n11);
            stringBuilder.append((String)charSequence2);
            object2 = stringBuilder.toString();
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("\nFirmware info: version = ");
            ((StringBuilder)charSequence2).append((String)object3);
            ((StringBuilder)charSequence2).append("\ncontent = ");
            ((StringBuilder)charSequence2).append((String)charSequence);
            string3 = "\nzipName = ";
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append((String)objectArray);
            ((StringBuilder)charSequence2).append("\nsize = ");
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append("\npart = ");
            ((StringBuilder)charSequence2).append((String)object2);
            object2 = ((StringBuilder)charSequence2).toString();
            objectArray = new Object[]{};
            m.a.a.b((String)object2, objectArray);
            this.i.setValue(charSequence);
            object2 = this.j;
            object3 = Pair.create(object3, string2);
            ((MutableLiveData)object2).setValue(object3);
            object2 = this.k;
            object3 = ((FirmwareInfo)object).getBeforeUpgradeTip();
            ((MutableLiveData)object2).setValue(object3);
            object2 = this.l;
            object = ((FirmwareInfo)object).getAfterUpgradeTip();
            ((MutableLiveData)object2).setValue(object);
        }
    }

    public void d(Context object, int n10) {
        Object object2;
        int n11 = 2131231834;
        int n12 = 2131952208;
        if (n10 != 0) {
            int n13 = 2;
            int n14 = 2131231836;
            int n15 = 2131953196;
            if (n10 != n13) {
                n13 = 2131951992;
                int n16 = 2131951993;
                int n17 = 2131951975;
                int n18 = 2131231835;
                int n19 = 2131952212;
                int n20 = 2131231837;
                switch (n10) {
                    default: {
                        Object object3 = this.a;
                        Object object4 = n11;
                        ((MutableLiveData)object3).setValue(object4);
                        object4 = this.b;
                        n13 = 2131951956;
                        object3 = d.v.f.i.g.m(object, n13);
                        ((MutableLiveData)object4).setValue(object3);
                        object4 = this.c;
                        String string2 = d.v.f.i.g.m(object, n12);
                        ((MutableLiveData)object4).setValue(string2);
                        object4 = this.d;
                        object = d.v.f.i.g.m(object, n15);
                        ((MutableLiveData)object4).setValue(object);
                        break;
                    }
                    case 10: {
                        MutableLiveData mutableLiveData = this.a;
                        Object object5 = n20;
                        mutableLiveData.setValue(object5);
                        mutableLiveData = this.b;
                        object5 = d.v.f.i.g.m(object, 2131951994);
                        mutableLiveData.setValue(object5);
                        mutableLiveData = this.c;
                        object5 = d.v.f.i.g.m(object, 2131951878);
                        mutableLiveData.setValue(object5);
                        mutableLiveData = this.d;
                        object5 = d.v.f.i.g.m(object, n15);
                        mutableLiveData.setValue(object5);
                        mutableLiveData = this.i;
                        n12 = 2131951965;
                        object = d.v.f.i.g.m(object, n12);
                        mutableLiveData.setValue(object);
                        break;
                    }
                    case 9: {
                        MutableLiveData mutableLiveData = this.a;
                        Object object6 = n14;
                        mutableLiveData.setValue(object6);
                        mutableLiveData = this.b;
                        object6 = d.v.f.i.g.m(object, n16);
                        mutableLiveData.setValue(object6);
                        mutableLiveData = this.c;
                        object6 = d.v.f.i.g.m(object, n13);
                        mutableLiveData.setValue(object6);
                        mutableLiveData = this.d;
                        object = d.v.f.i.g.m(object, n15);
                        mutableLiveData.setValue(object);
                        break;
                    }
                    case 8: {
                        MutableLiveData mutableLiveData = this.a;
                        Object object7 = n18;
                        mutableLiveData.setValue(object7);
                        mutableLiveData = this.b;
                        object7 = d.v.f.i.g.m(object, n17);
                        mutableLiveData.setValue(object7);
                        mutableLiveData = this.c;
                        String string3 = d.v.f.i.g.m(object, n12);
                        mutableLiveData.setValue(string3);
                        mutableLiveData = this.d;
                        object = d.v.f.i.g.m(object, n19);
                        mutableLiveData.setValue(object);
                        break;
                    }
                    case 7: {
                        MutableLiveData mutableLiveData = this.a;
                        Object object8 = n20;
                        mutableLiveData.setValue(object8);
                        mutableLiveData = this.b;
                        n13 = 2131953208;
                        object8 = d.v.f.i.g.m(object, n13);
                        mutableLiveData.setValue(object8);
                        mutableLiveData = this.c;
                        String string4 = d.v.f.i.g.m(object, n12);
                        mutableLiveData.setValue(string4);
                        mutableLiveData = this.d;
                        object = d.v.f.i.g.m(object, n15);
                        mutableLiveData.setValue(object);
                        break;
                    }
                    case 6: {
                        MutableLiveData mutableLiveData = this.a;
                        Object object9 = n14;
                        mutableLiveData.setValue(object9);
                        mutableLiveData = this.b;
                        object9 = d.v.f.i.g.m(object, n16);
                        mutableLiveData.setValue(object9);
                        mutableLiveData = this.c;
                        object9 = d.v.f.i.g.m(object, n13);
                        mutableLiveData.setValue(object9);
                        mutableLiveData = this.d;
                        object = d.v.f.i.g.m(object, n15);
                        mutableLiveData.setValue(object);
                        break;
                    }
                    case 5: {
                        MutableLiveData mutableLiveData = this.a;
                        Object object10 = n18;
                        mutableLiveData.setValue(object10);
                        mutableLiveData = this.b;
                        object10 = d.v.f.i.g.m(object, n17);
                        mutableLiveData.setValue(object10);
                        mutableLiveData = this.c;
                        n12 = 2131952034;
                        object10 = d.v.f.i.g.m(object, n12);
                        mutableLiveData.setValue(object10);
                        mutableLiveData = this.d;
                        object = d.v.f.i.g.m(object, n19);
                        mutableLiveData.setValue(object);
                        break;
                    }
                    case 4: {
                        MutableLiveData mutableLiveData = this.a;
                        Object object11 = n20;
                        mutableLiveData.setValue(object11);
                        mutableLiveData = this.b;
                        object11 = d.v.f.i.g.m(object, 2131951958);
                        mutableLiveData.setValue(object11);
                        mutableLiveData = this.c;
                        n12 = 2131951995;
                        object11 = d.v.f.i.g.m(object, n12);
                        mutableLiveData.setValue(object11);
                        mutableLiveData = this.d;
                        object = d.v.f.i.g.m(object, n19);
                        mutableLiveData.setValue(object);
                        break;
                    }
                }
            } else {
                MutableLiveData mutableLiveData = this.a;
                Object object12 = n14;
                mutableLiveData.setValue(object12);
                mutableLiveData = this.b;
                object12 = d.v.f.i.g.m(object, 2131951957);
                mutableLiveData.setValue(object12);
                mutableLiveData = this.c;
                n12 = 2131951955;
                object12 = d.v.f.i.g.m(object, n12);
                mutableLiveData.setValue(object12);
                mutableLiveData = this.d;
                object = d.v.f.i.g.m(object, n15);
                mutableLiveData.setValue(object);
            }
        } else {
            Object object13 = this.a;
            Object object14 = n11;
            ((MutableLiveData)object13).setValue(object14);
            object14 = this.b;
            int n21 = 2131952209;
            object13 = d.v.f.i.g.m(object, n21);
            ((MutableLiveData)object14).setValue(object13);
            object14 = this.c;
            object = d.v.f.i.g.m(object, n12);
            ((MutableLiveData)object14).setValue(object);
        }
        this.u(n10);
        this.w(n10);
        object = this.m;
        if ((n10 == 0 || n10 == (n11 = 4) && (n10 = (int)(((z)(object2 = z.m())).B() ? 1 : 0)) != 0) && (n10 = (int)(this.n ? 1 : 0)) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        object2 = n10 != 0;
        d.v.e.i.h.g((MutableLiveData)object, object2);
    }

    public String e() {
        Object object = this.l;
        object = object == null ? null : (String)((LiveData)object).getValue();
        return object;
    }

    public String f() {
        Object object = this.k;
        object = object == null ? null : (String)((LiveData)object).getValue();
        return object;
    }

    public MutableLiveData g() {
        return this.i;
    }

    public MutableLiveData i() {
        return this.c;
    }

    public MutableLiveData j() {
        return this.e;
    }

    public MutableLiveData k() {
        return this.g;
    }

    public MutableLiveData l() {
        return this.h;
    }

    public MutableLiveData m() {
        return this.a;
    }

    public MutableLiveData n() {
        return this.b;
    }

    public MutableLiveData o() {
        return this.f;
    }

    public MutableLiveData p() {
        return this.m;
    }

    public MutableLiveData r() {
        return this.d;
    }

    public String s() {
        Object object = this.d;
        object = object != null && (object = ((LiveData)object).getValue()) != null ? (String)this.d.getValue() : "";
        return object;
    }

    public MutableLiveData t() {
        return this.j;
    }

    public void v(String string2) {
        this.o = string2;
    }

    public void x(boolean bl2) {
        this.n = bl2;
    }
}

