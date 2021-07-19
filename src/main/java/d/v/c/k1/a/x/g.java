/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package d.v.c.k1.a.x;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import d.v.c.k1.a.x.a;
import d.v.c.k1.a.x.b;
import d.v.c.k1.a.x.l;
import d.v.j.g.b0;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class g
extends l {
    public static /* synthetic */ void k(Fragment fragment, ArrayList arrayList, Long l10, List stringArray) {
        stringArray = b0.a((List)stringArray);
        long l11 = l10;
        EditorTemplateEditActivity.X(fragment, stringArray, arrayList, l11);
    }

    public static /* synthetic */ void l(Throwable throwable) {
    }

    public void e(Activity object, Fragment object2, long l10, MutableLiveData mutableLiveData) {
        object = new AiUseCase((LifecycleOwner)object2, true);
        ArrayList arrayList = this.b();
        a a10 = new a((Fragment)object2, arrayList);
        object2 = b.a;
        ((AiUseCase)object).L(arrayList, a10, (Consumer)object2);
    }
}

