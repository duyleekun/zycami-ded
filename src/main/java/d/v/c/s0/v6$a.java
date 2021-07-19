/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.s0;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.h1;
import d.v.a0.m1;
import d.v.a0.n1.g.w;
import d.v.c.s0.v6;
import d.v.e.i.h;
import d.v.z.l.d;
import d.v.z.l.e;
import m.a.a;

public class v6$a
implements w {
    public final /* synthetic */ v6 a;

    public v6$a(v6 v62) {
        this.a = v62;
    }

    public void a(h1 object) {
        Object[] objectArray = new StringBuilder();
        objectArray.append("ConnectCallback onConnectAgreeReply connect address ");
        String string2 = ((h1)object).a();
        objectArray.append(string2);
        objectArray = objectArray.toString();
        string2 = null;
        Object object2 = new Object[]{};
        m.a.a.b((String)objectArray, object2);
        object = ((h1)object).a();
        objectArray = v6.b(this.a);
        boolean bl2 = ((String)object).equals(objectArray);
        if (bl2 && !(bl2 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.a.b.getValue())))) {
            object = this.a;
            objectArray = m1.o().d();
            object2 = v6.d(this.a);
            boolean bl3 = objectArray.r((e)object2);
            v6.j((v6)object, bl3);
            object = new StringBuilder();
            ((StringBuilder)object).append("VtPush supportH265 = ");
            bl3 = v6.i(this.a);
            ((StringBuilder)object).append(bl3);
            object = ((StringBuilder)object).toString();
            objectArray = new Object[]{};
            m.a.a.b((String)object, objectArray);
            v6.k(this.a);
            object = this.a;
            bl3 = true;
            v6.g((v6)object, bl3);
        }
    }

    public void b(h1 object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        String string2 = ((h1)object).a();
        object2[0] = string2;
        string2 = "ConnectCallback onDisConnect connect address:%s";
        m.a.a.b(string2, object2);
        object = ((h1)object).a();
        object2 = v6.b(this.a);
        boolean bl2 = ((String)object).equals(object2);
        if (bl2) {
            object = (Boolean)this.a.b.getValue();
            bl2 = d.v.e.h.a.c((Boolean)object);
            if (bl2) {
                object = this.a.e;
                n10 = 2131951813;
                object2 = n10;
                h.e((MutableLiveData)object, object2);
            }
            object = this.a;
            v6.g((v6)object, false);
        }
    }

    public void c(h1 object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        String string2 = ((h1)object).a();
        object2[0] = string2;
        string2 = "ConnectCallback onConnectCancel address:%s";
        m.a.a.b(string2, object2);
        object = ((h1)object).a();
        object2 = v6.b(this.a);
        boolean bl2 = ((String)object).equals(object2);
        if (bl2) {
            object = this.a;
            v6.g((v6)object, false);
        }
    }

    public void d(h1 object, ZYEnumDefine$ConnectAction object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectCallback onActionTimeout connect address ");
        Object[] objectArray = ((h1)object).a();
        stringBuilder.append((String)objectArray);
        stringBuilder.append(object2);
        object2 = stringBuilder.toString();
        stringBuilder = null;
        objectArray = new Object[]{};
        m.a.a.b((String)object2, objectArray);
        object = ((h1)object).a();
        object2 = v6.b(this.a);
        boolean bl2 = ((String)object).equals(object2);
        if (bl2) {
            object = (Boolean)this.a.b.getValue();
            bl2 = d.v.e.h.a.c((Boolean)object);
            if (bl2) {
                object = this.a.e;
                int n10 = 2131951813;
                object2 = n10;
                h.e((MutableLiveData)object, object2);
            }
            object = this.a;
            v6.g((v6)object, false);
        }
    }

    public void e(h1 object, d object2) {
        if (object != null && object2 != null) {
            Object object3 = (CharSequence)this.a.g.getValue();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
            int n10 = 1;
            if (bl2 && !(bl2 = d.v.e.h.a.c((Boolean)(object3 = (Boolean)this.a.b.getValue())))) {
                object3 = this.a;
                Object object4 = ((h1)object).a();
                v6.c((v6)object3, (String)object4);
                object3 = this.a;
                object4 = object2.k();
                v6.e((v6)object3, (e)object4);
                object3 = this.a;
                object4 = v6.d((v6)object3).k();
                v6.f((v6)object3, (String)object4);
                object3 = this.a.g;
                object2 = object2.k().m();
                h.e((MutableLiveData)object3, object2);
                object2 = new Object[n10];
                object2[0] = object = ((h1)object).a();
                m.a.a.b("ConnectCallback connect address:%s", object2);
                return;
            }
            object2 = ((h1)object).a();
            boolean bl3 = object2.equals(object3 = v6.b(this.a));
            if (!bl3) {
                object2 = m1.o();
                object3 = ((h1)object).a();
                String string2 = "ConnectLimit";
                object2.s((String)object3, string2);
                object2 = new Object[n10];
                object2[0] = object = ((h1)object).a();
                object = "ConnectCallback rejectConnect another address :%s";
                m.a.a.b((String)object, object2);
            } else {
                object2 = new Object[n10];
                object2[0] = object = ((h1)object).a();
                object = "ConnectCallback same address :%s";
                m.a.a.b((String)object, object2);
            }
        }
    }
}

