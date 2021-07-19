/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.provider.MediaStore$Images$Media
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.p0.p;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.permission.Permission;
import d.v.c.p0.p.b;
import d.v.c.p0.p.c;
import d.v.c.p0.p.d;
import d.v.c.p0.p.e;
import d.v.c.p0.p.e$a;
import d.v.e.l.s1;
import d.v.x.c$b;
import java.util.List;

public class f {
    private static final int c = 10001;
    private final FragmentActivity a;
    private final e b;

    public f(FragmentActivity object, RecyclerView recyclerView) {
        this.a = object;
        this.b = object = new e();
        Object object2 = new d(this);
        ((e)object).r((View.OnClickListener)object2);
        object2 = new c(this);
        ((e)object).s((e$a)object2);
        Context context = recyclerView.getContext();
        object2 = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager((RecyclerView$LayoutManager)object2);
        recyclerView.setAdapter((RecyclerView$Adapter)object);
    }

    private void a() {
        Object object = Permission.STORAGE;
        c$b c$b = new c$b((Permission)((Object)object));
        object = new b(this);
        c$b = c$b.a((d.v.x.b)object);
        object = this.a.getSupportFragmentManager();
        c$b.b((FragmentManager)object);
    }

    private void b(String string2) {
        this.b.d(string2);
        this.b.notifyDataSetChanged();
    }

    private void c(int n10) {
        this.b.k(n10);
        this.b.notifyDataSetChanged();
    }

    public static /* synthetic */ void e(f f10) {
        f10.j();
    }

    public static /* synthetic */ void f(f f10, int n10) {
        f10.c(n10);
    }

    private /* synthetic */ void g(View view) {
        this.a();
    }

    private void j() {
        Object object = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Intent intent = new Intent("android.intent.action.PICK");
        String string2 = "image/*";
        intent.setDataAndType((Uri)object, string2);
        object = this.a.getPackageManager();
        object = intent.resolveActivity((PackageManager)object);
        if (object != null) {
            object = this.a;
            int n10 = 10001;
            ((ComponentActivity)object).startActivityForResult(intent, n10);
        }
    }

    public List d() {
        return this.b.f();
    }

    public /* synthetic */ void h(View view) {
        this.g(view);
    }

    public boolean i(int n10, int n11, Intent intent) {
        boolean bl2 = false;
        int n12 = -1;
        if (n11 != n12) {
            return false;
        }
        Object object = this.a;
        intent = intent.getData();
        object = s1.F((Context)object, (Uri)intent);
        int n13 = 10001;
        if (n10 == n13) {
            this.b((String)object);
            bl2 = true;
        }
        return bl2;
    }

    public void k(int n10) {
        this.b.q(n10);
    }

    public void l(int n10) {
        this.b.t(n10);
    }
}

