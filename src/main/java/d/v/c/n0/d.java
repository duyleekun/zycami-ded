/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.n0;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;

public final class d
extends PagerAdapter {
    private ArrayList a;
    private float b;

    public d() {
        ArrayList arrayList;
        this.b = 1.0f;
        this.a = arrayList = new ArrayList(0);
    }

    public d(List list) {
        ArrayList arrayList;
        this.b = 1.0f;
        this.a = arrayList = new ArrayList(list);
    }

    public d(List list, float f10) {
        ArrayList arrayList;
        float f11;
        this.b = f11 = 1.0f;
        this.a = arrayList = new ArrayList(list);
        list = null;
        float f12 = f10 - 0.0f;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 > 0 && (f13 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1)) < 0) {
            this.b = f10;
        }
    }

    public void a(int n10, View view) {
        this.a.add(n10, view);
        this.notifyDataSetChanged();
    }

    public void b(View view) {
        this.a.add(view);
        this.notifyDataSetChanged();
    }

    public void c(int n10, List list) {
        this.a.addAll(n10, list);
        this.notifyDataSetChanged();
    }

    public void d(List list) {
        this.a.addAll(list);
        this.notifyDataSetChanged();
    }

    public void destroyItem(ViewGroup viewGroup, int n10, Object object) {
        object = (View)object;
        viewGroup.removeView((View)object);
    }

    public int e(View view) {
        return this.a.indexOf(view);
    }

    public View f(int n10) {
        ArrayList arrayList;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (arrayList = this.a).size())) {
            return (View)this.a.get(n10);
        }
        return null;
    }

    public void g(int n10) {
        this.a.remove(n10);
        this.notifyDataSetChanged();
    }

    public int getCount() {
        return this.a.size();
    }

    public int getItemPosition(Object object) {
        return -2;
    }

    public float getPageWidth(int n10) {
        return this.b;
    }

    public void h() {
        this.a.clear();
        this.notifyDataSetChanged();
    }

    public Object instantiateItem(ViewGroup viewGroup, int n10) {
        View view = (View)this.a.get(n10);
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl2;
        if (view == object) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }
}

