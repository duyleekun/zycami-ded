/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package d.v.c.k1.a.x;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.k1.a.v;
import d.v.h.e.a;
import java.util.ArrayList;
import java.util.List;

public interface j {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final String g = "editor";
    public static final String h = "template";
    public static final String i = "kwai";
    public static final String j = "autoEdit";
    public static final String k = "autoEditReplace";
    public static final String l = "cloudEngine";

    public String[] a();

    public ArrayList b();

    public void c(RecyclerView var1, v var2, int var3);

    public int d(List var1);

    public void e(Activity var1, Fragment var2, long var3, MutableLiveData var5);

    public void f(RecyclerView var1, v var2, a var3, MutableLiveData var4);

    public List g(List var1);

    public boolean h(List var1);

    public TemplateVideo i(List var1);

    public void j(List var1, a var2);
}

