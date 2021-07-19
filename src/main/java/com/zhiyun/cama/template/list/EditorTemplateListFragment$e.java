/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.template.list;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.cama.template.list.EditorTemplateListFragment;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import d.v.c.u1.n.d0;
import java.util.List;
import java.util.Map;
import m.a.a;

public class EditorTemplateListFragment$e
extends FragmentPagerAdapter {
    private Map a;
    private List b;
    private List c;
    public final /* synthetic */ EditorTemplateListFragment d;

    public EditorTemplateListFragment$e(EditorTemplateListFragment cloneable, FragmentManager fragmentManager, int n10) {
        this.d = cloneable;
        super(fragmentManager, n10);
        this.c = cloneable = new Cloneable();
        super();
        this.a = cloneable;
    }

    public String a(int n10) {
        return ((TemplateType)this.b.get(n10)).a();
    }

    public void b(List object) {
        boolean bl2;
        Object object2 = this.b;
        if (object2 == null) {
            this.b = object;
        } else {
            object2.clear();
            object2 = this.b;
            object2.addAll(object);
        }
        this.c.clear();
        object = this.b.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (TemplateType)object.next();
            Object object3 = this.a;
            long l10 = ((TemplateType)object2).getId();
            Object object4 = l10;
            if ((object3 = (d0)object3.get(object4)) == null) {
                long l11;
                object3 = new d0();
                l10 = ((TemplateType)object2).getId();
                long l12 = l10 - (l11 = 0L);
                Object object5 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object5 == false) {
                    object5 = 1;
                    object4 = d0.F((boolean)object5);
                    ((Fragment)object3).setArguments((Bundle)object4);
                } else {
                    l10 = ((TemplateType)object2).getId();
                    object4 = d0.E(l10);
                    ((Fragment)object3).setArguments((Bundle)object4);
                }
                object4 = this.a;
                long l13 = ((TemplateType)object2).getId();
                object2 = l13;
                object4.put(object2, object3);
            }
            object2 = this.c;
            object2.add(object3);
        }
    }

    public void destroyItem(ViewGroup object, int n10, Object object2) {
        Object object3;
        super.destroyItem((ViewGroup)object, n10, object2);
        object = new Object[2];
        object[0] = object3 = Integer.valueOf(n10);
        n10 = 1;
        object[n10] = object2;
        object3 = "destroyItem: %s, %s";
        m.a.a.x((String)object3, (Object[])object);
        boolean bl2 = object2 instanceof Fragment;
        if (bl2) {
            object2 = (Fragment)object2;
            object = this.d.getChildFragmentManager().beginTransaction();
            ((FragmentTransaction)object).remove((Fragment)object2);
            ((FragmentTransaction)object).commitAllowingStateLoss();
        }
    }

    public int getCount() {
        return this.c.size();
    }

    public Fragment getItem(int n10) {
        return (Fragment)this.c.get(n10);
    }

    public long getItemId(int n10) {
        return ((TemplateType)this.b.get(n10)).hashCode();
    }

    public int getItemPosition(Object objectArray) {
        int n10;
        List list;
        boolean bl2 = objectArray instanceof d0;
        if (bl2) {
            objectArray = (d0)objectArray;
            list = this.c;
            n10 = list.indexOf(objectArray);
        } else {
            n10 = -1;
        }
        bl2 = false;
        list = null;
        if (n10 >= 0) {
            Object[] objectArray2 = new Object[1];
            Integer n11 = n10;
            objectArray2[0] = n11;
            m.a.a.b("getItemPosition: %s", objectArray2);
            return n10;
        }
        objectArray = new Object[]{};
        m.a.a.b("getItemPosition: POSITION_NONE", objectArray);
        return -2;
    }
}

