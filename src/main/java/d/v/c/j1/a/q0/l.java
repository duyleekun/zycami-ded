/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.PopupWindow
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.j1.a.q0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.me.help.view.MaxHeightScrollView;
import d.v.c.j1.a.q0.g;
import d.v.c.j1.a.q0.h;
import d.v.c.j1.a.q0.i;
import d.v.c.j1.a.q0.j;
import d.v.c.j1.a.q0.k;
import d.v.c.j1.a.q0.l$a;
import d.v.c.w0.ke;
import java.util.ArrayList;
import java.util.List;

public class l {
    public static RadioButton a(Context context, RadioGroup radioGroup, String string2) {
        radioGroup = (RadioButton)LayoutInflater.from((Context)context).inflate(2131558693, (ViewGroup)radioGroup, false);
        context = context.getResources().getColorStateList(2131099715, null);
        radioGroup.setTextColor((ColorStateList)context);
        radioGroup.setText((CharSequence)string2);
        return radioGroup;
    }

    public static /* synthetic */ void b(PopupWindow popupWindow, View view) {
        popupWindow.dismiss();
    }

    public static /* synthetic */ void c(ke ke2, int n10) {
        MaxHeightScrollView maxHeightScrollView = ke2.c;
        ke2 = ke2.b;
        n10 = Math.max(n10 + -2, 0);
        int n11 = ke2.getChildAt(n10).getTop();
        maxHeightScrollView.scrollTo(0, n11);
    }

    public static /* synthetic */ void d(PopupWindow popupWindow, View view) {
        popupWindow.dismiss();
    }

    public static /* synthetic */ void e(l$a l$a, ke ke2, List object, PopupWindow popupWindow, RadioGroup radioGroup, int n10) {
        View view = radioGroup.findViewById(n10);
        int n11 = radioGroup.indexOfChild(view);
        if (l$a != null) {
            object = (String)object.get(n11);
            ke2.z((String)object);
            l$a.a(n11);
        }
        ke2.d.setTextColor(-1);
        popupWindow.dismiss();
    }

    public static /* synthetic */ void f(View view, PopupWindow popupWindow) {
        int[] nArray = new int[2];
        view.getLocationInWindow(nArray);
        int n10 = nArray[1];
        popupWindow.showAtLocation(view, 48, 0, n10);
    }

    public static void g(Context context, View view, String object, ColorStateList object2, List list, l$a l$a) {
        int n10;
        if (list != null && (n10 = list.size()) > 0) {
            int n11;
            Object object3 = LayoutInflater.from((Context)context);
            int n12 = 2131558694;
            int n13 = 0;
            RadioGroup radioGroup = null;
            object3 = ke.s(object3.inflate(n12, null, false));
            ((ke)object3).z((String)object);
            Object object4 = ((ke)object3).d;
            object4.setTextColor(object2);
            object2 = list.iterator();
            while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object4 = (String)object2.next();
                radioGroup = ((ke)object3).b;
                object4 = l.a(context, radioGroup, (String)object4);
                radioGroup = ((ke)object3).b;
                radioGroup.addView((View)object4);
            }
            object2 = ((ViewDataBinding)object3).getRoot();
            n12 = -1;
            n13 = -2;
            context = new PopupWindow((View)object2, n12, n13);
            int n14 = list.indexOf(object);
            if (n14 >= 0 && n14 < (n11 = (object2 = ((ke)object3).b).getChildCount())) {
                object2 = ((ke)object3).b.getChildAt(n14);
                object4 = ((ke)object3).b;
                n13 = object2.getId();
                object4.check(n13);
                object4 = new k((PopupWindow)context);
                object2.setOnClickListener((View.OnClickListener)object4);
                object2 = ((ke)object3).c;
                object4 = new g((ke)object3, n14);
                object2.post((Runnable)object4);
            }
            object = ((ke)object3).a;
            object2 = new h((PopupWindow)context);
            object.setOnClickListener((View.OnClickListener)object2);
            object = ((ke)object3).b;
            object2 = new j(l$a, (ke)object3, list, (PopupWindow)context);
            object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
            n14 = 1;
            context.setOutsideTouchable(n14 != 0);
            context.setFocusable(n14 != 0);
            object = new i(view, (PopupWindow)context);
            view.post((Runnable)object);
        }
    }

    public static void h(Context context, View view, String string2, ColorStateList colorStateList, List object, l$a l$a) {
        int n10;
        if (object != null && (n10 = object.size()) > 0) {
            ArrayList<String> arrayList = new ArrayList<String>();
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                n10 = (Integer)object.next();
                String string3 = d.v.f.i.g.m(context, n10);
                arrayList.add(string3);
            }
            l.g(context, view, string2, colorStateList, arrayList, l$a);
        }
    }
}

