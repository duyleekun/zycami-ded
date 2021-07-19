/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 */
package d.v.c.s0.a7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import d.v.f.i.g;

public class m1 {
    public static void a(RadioGroup radioGroup, Object object) {
        if ((object = radioGroup.findViewWithTag(object)) != null) {
            int n10 = object.getId();
            radioGroup.check(n10);
        }
    }

    public static void b(CheckedGroup checkedGroup, Object object) {
        if ((object = checkedGroup.findViewWithTag(object)) != null) {
            int n10 = object.getId();
            checkedGroup.g(n10);
        }
    }

    public static RadioButton c(Context object, RadioGroup radioGroup, int n10, Object object2) {
        radioGroup = (RadioButton)LayoutInflater.from((Context)object).inflate(2131558810, (ViewGroup)radioGroup, false);
        radioGroup.setTextAppearance(2132017608);
        radioGroup.setTag(object2);
        object = g.m(object, n10);
        radioGroup.setText((CharSequence)object);
        return radioGroup;
    }

    public static RadioButton d(Context object, CheckedGroup checkedGroup, int n10, Object object2) {
        checkedGroup = (RadioButton)LayoutInflater.from((Context)object).inflate(2131558810, (ViewGroup)checkedGroup, false);
        checkedGroup.setTextAppearance(2132017608);
        checkedGroup.setTag(object2);
        object = g.m(object, n10);
        checkedGroup.setText((CharSequence)object);
        return checkedGroup;
    }

    public static RadioButton e(Context context, CheckedGroup checkedGroup, String string2, Object object) {
        context = (RadioButton)LayoutInflater.from((Context)context).inflate(2131558810, (ViewGroup)checkedGroup, false);
        context.setTextAppearance(2132017608);
        context.setTag(object);
        context.setText((CharSequence)string2);
        return context;
    }
}

