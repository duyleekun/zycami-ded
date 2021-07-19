/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.sort;

import com.zhiyun.cama.sort.EditorSortFragment;
import d.v.c.r1.c$a;
import m.a.a;

public class EditorSortFragment$a
implements c$a {
    public final /* synthetic */ EditorSortFragment a;

    public EditorSortFragment$a(EditorSortFragment editorSortFragment) {
        this.a = editorSortFragment;
    }

    public void a(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onItemDown startPosition:");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        EditorSortFragment.x(this.a).i(n10);
    }

    public void b(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onItemUp endPosition:");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        EditorSortFragment.x(this.a).j(n10);
    }

    public void c(int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("startPosition:");
        stringBuilder.append(n10);
        stringBuilder.append(",endPos:");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b(string2, objectArray);
    }
}

