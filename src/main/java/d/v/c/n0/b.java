/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n0;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class b
extends FragmentPagerAdapter {
    private List a;
    private String[] b;

    public b(FragmentManager arrayList, int n10, List list) {
        super((FragmentManager)((Object)arrayList), n10);
        this.a = arrayList = new ArrayList();
        arrayList.clear();
        this.a.addAll(list);
    }

    public b(FragmentManager arrayList, int n10, List list, String[] stringArray) {
        super((FragmentManager)((Object)arrayList), n10);
        this.a = arrayList = new ArrayList();
        arrayList.clear();
        this.a.addAll(list);
        this.b = stringArray;
    }

    private boolean a(Object object) {
        boolean bl2;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void b(List list) {
        this.a.clear();
        this.a.addAll(list);
        this.notifyDataSetChanged();
    }

    public int getCount() {
        List list = this.a;
        int n10 = this.a(list);
        if (n10 != 0) {
            n10 = 0;
            list = null;
        } else {
            list = this.a;
            n10 = list.size();
        }
        return n10;
    }

    public Fragment getItem(int n10) {
        Fragment fragment;
        List list = this.a;
        boolean bl2 = this.a(list);
        if (bl2) {
            n10 = 0;
            fragment = null;
        } else {
            list = this.a;
            fragment = (Fragment)list.get(n10);
        }
        return fragment;
    }

    public long getItemId(int n10) {
        return n10;
    }

    public int getItemPosition(Object object) {
        int n10;
        List list = this.a;
        boolean bl2 = this.a(list);
        if (bl2) {
            n10 = -1;
        } else {
            list = this.a;
            n10 = list.indexOf(object);
        }
        return n10;
    }

    public CharSequence getPageTitle(int n10) {
        String[] stringArray = this.a;
        boolean bl2 = this.a(stringArray);
        String string2 = null;
        if (!bl2 && !(bl2 = this.a(stringArray = this.b))) {
            stringArray = this.b;
            string2 = stringArray[n10];
        }
        return string2;
    }
}

