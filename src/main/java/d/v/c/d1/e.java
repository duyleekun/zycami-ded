/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.d1;

import androidx.databinding.ObservableInt;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;

public class e {
    private TemplatePOJO a;
    private ObservableInt b;

    public e(TemplatePOJO templatePOJO, int n10) {
        ObservableInt observableInt;
        this.b = observableInt = new ObservableInt();
        this.a = templatePOJO;
        observableInt.set(n10);
    }

    public ObservableInt a() {
        return this.b;
    }

    public TemplatePOJO b() {
        return this.a;
    }

    public void c(int n10) {
        this.b.set(n10);
    }

    public void d(TemplatePOJO templatePOJO) {
        this.a = templatePOJO;
    }
}

