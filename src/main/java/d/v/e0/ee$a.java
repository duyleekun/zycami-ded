/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package d.v.e0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.zhiyun.protocol.constants.BoxWorkingMode;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.e0.bb;
import d.v.e0.ee;
import d.v.e0.ee$b;
import d.v.e0.oe.q;

public class ee$a
extends Handler {
    public final /* synthetic */ ee a;

    public ee$a(ee ee2, Looper looper) {
        this.a = ee2;
        super(looper);
    }

    private /* synthetic */ void a() {
        ee$b ee$b = ee.a(this.a);
        Integer n10 = 100;
        ee$b.e(n10);
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        switch (n10) {
            default: {
                break;
            }
            case 9: {
                ee$b ee$b = ee.a(this.a);
                object = (Integer)((Message)object).obj;
                ee$b.c((Integer)object);
                break;
            }
            case 7: {
                ee$b ee$b = ee.a(this.a);
                object = (Integer)((Message)object).obj;
                ee$b.g((Integer)object);
                break;
            }
            case 6: {
                ee$b ee$b = ee.a(this.a);
                object = (Integer)((Message)object).obj;
                ee$b.i((Integer)object);
                break;
            }
            case 5: {
                object = (Integer)((Message)object).obj;
                Object object2 = this.a;
                long l10 = 180000L;
                bb bb2 = new bb(this);
                ee.b((ee)object2, (Integer)object, l10, bb2);
                object2 = ee.a(this.a);
                object2.e((Integer)object);
                break;
            }
            case 4: {
                ee$b ee$b = ee.a(this.a);
                object = (BoxWorkingMode)((Object)((Message)object).obj);
                ee$b.b((BoxWorkingMode)((Object)object));
                break;
            }
            case 3: {
                ee$b ee$b = ee.a(this.a);
                object = (WorkingMode)((Object)((Message)object).obj);
                ee$b.h((WorkingMode)((Object)object));
                break;
            }
            case 2: {
                ee$b ee$b = ee.a(this.a);
                object = (Integer)((Message)object).obj;
                int n11 = (Integer)object;
                ee$b.f(n11);
                break;
            }
            case 1: {
                q.f("Accessory connected");
                object = ee.a(this.a);
                object.a();
                break;
            }
            case 0: {
                q.f("Accessory disconnected");
                object = ee.a(this.a);
                object.d();
            }
        }
    }
}

