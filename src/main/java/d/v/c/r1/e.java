/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.r1;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.zhiyun.common.util.Windows;
import d.v.c.r1.a;
import d.v.c.r1.d;
import java.util.List;
import java.util.stream.Collectors;

public class e
extends ViewModel {
    public static /* synthetic */ d d(d.v.h.e.d d10) {
        d d11 = new d();
        String string2 = d10.i();
        d11 = d11.v(string2);
        long l10 = d10.u();
        long l11 = d10.J();
        double d12 = l10 - l11;
        double d13 = d10.I();
        l10 = (long)(d12 / d13);
        return d11.u(l10);
    }

    public int b(Context context, int n10, int n11, int n12) {
        context = Windows.l(context);
        int n13 = context.getWidth();
        if (n10 == 0) {
            return n13;
        }
        n13 -= n12;
        n12 = n10 + -1;
        return (n13 - (n11 *= n12)) / n10;
    }

    public List c(List stream) {
        stream = stream.stream();
        Object object = a.a;
        stream = stream.map(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }
}

