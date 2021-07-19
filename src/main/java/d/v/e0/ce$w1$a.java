/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer$k;
import d.v.e0.ce$w1;
import d.v.e0.ie.d;
import e.a.b0;

public class ce$w1$a
extends Stabilizer$k {
    public final /* synthetic */ b0 e;
    public final /* synthetic */ ce$w1 f;

    public ce$w1$a(ce$w1 ce$w1, b0 b02) {
        this.f = ce$w1;
        this.e = b02;
    }

    public void g(int n10) {
        switch (n10) {
            default: {
                d d10 = this.f.a;
                d10.e(n10);
                break;
            }
            case 103: {
                this.f.a.g();
                b0 b02 = this.e;
                b02.onComplete();
                break;
            }
            case 102: {
                d d11 = this.f.a;
                d11.i();
                break;
            }
            case 101: {
                d d12 = this.f.a;
                d12.a();
                break;
            }
            case 100: {
                Object object = this.f.a;
                int n11 = 100;
                object.e(n11);
                this.f.a.k();
                object = this.e;
                object.onComplete();
            }
        }
    }
}

