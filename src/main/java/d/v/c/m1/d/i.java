/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.d;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PRIME_STATUS;
import d.v.c.m1.d.p;

public final class i
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ i(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (PrimeGetDialogViewModel$PRIME_STATUS)((Object)object);
        p10.H((PrimeGetDialogViewModel$PRIME_STATUS)((Object)object));
    }
}

