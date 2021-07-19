/*
 * Decompiled with CFR 0.151.
 */
package d.v.f.d;

import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import java.util.List;

public class c
extends DiffUtil$Callback {
    private List a;
    private List b;
    private DiffUtil$ItemCallback c;

    public c(DiffUtil$ItemCallback diffUtil$ItemCallback) {
        this.c = diffUtil$ItemCallback;
    }

    public void a(List list) {
        this.b = list;
    }

    public boolean areContentsTheSame(int n10, int n11) {
        DiffUtil$ItemCallback diffUtil$ItemCallback = this.c;
        Object e10 = this.a.get(n10);
        Object e11 = this.b.get(n11);
        return diffUtil$ItemCallback.areContentsTheSame(e10, e11);
    }

    public boolean areItemsTheSame(int n10, int n11) {
        DiffUtil$ItemCallback diffUtil$ItemCallback = this.c;
        Object e10 = this.a.get(n10);
        Object e11 = this.b.get(n11);
        return diffUtil$ItemCallback.areItemsTheSame(e10, e11);
    }

    public void b(List list) {
        this.a = list;
    }

    public Object getChangePayload(int n10, int n11) {
        DiffUtil$ItemCallback diffUtil$ItemCallback = this.c;
        Object e10 = this.a.get(n10);
        Object e11 = this.b.get(n11);
        return diffUtil$ItemCallback.getChangePayload(e10, e11);
    }

    public int getNewListSize() {
        int n10;
        List list = this.b;
        if (list == null) {
            n10 = 0;
            list = null;
        } else {
            n10 = list.size();
        }
        return n10;
    }

    public int getOldListSize() {
        int n10;
        List list = this.a;
        if (list == null) {
            n10 = 0;
            list = null;
        } else {
            n10 = list.size();
        }
        return n10;
    }
}

