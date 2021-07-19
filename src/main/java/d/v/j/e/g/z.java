/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.api.entity.template.Description;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.e.g.z$a;
import e.a.i0;
import java.util.Optional;

public interface z {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;

    public void a();

    public i0 b(long var1, String var3);

    public void c(int var1);

    public TemplatePOJO d();

    public void e(z$a var1);

    public void f(TemplatePOJO var1, Optional var2);

    public i0 g(long var1);

    public LiveData getLatestDraft();

    public LiveData h();

    public void i(String var1, String var2, Description var3);
}

