/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.d1;

import androidx.databinding.ObservableInt;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.d1.e;

public class f$a
extends DiffUtil$ItemCallback {
    public boolean a(e object, e object2) {
        int n10;
        int n11 = ((ObservableInt)(object = ((e)object).a())).get();
        if (n11 == (n10 = ((ObservableInt)(object2 = ((e)object2).a())).get())) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public boolean b(e object, e object2) {
        object = ((e)object).b();
        object2 = ((e)object2).b();
        return ((TemplatePOJO)object).equals(object2);
    }
}

