/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import d.v.c.h1.r$a;
import java.util.List;

public abstract class r
extends RecyclerView$Adapter {
    public List a;
    private int b = 0;

    public static /* synthetic */ int a(r r10) {
        return r10.b;
    }

    public abstract boolean b(Object var1, Object var2);

    public abstract boolean c(Object var1, Object var2);

    public int d() {
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

    public void e(DiffUtil$DiffResult diffUtil$DiffResult) {
        diffUtil$DiffResult.dispatchUpdatesTo(this);
    }

    public void f(List objectArray) {
        int n10;
        this.b = n10 = this.b + 1;
        List list = this.a;
        if (list == null) {
            if (objectArray == null) {
                return;
            }
            this.a = objectArray;
            this.notifyDataSetChanged();
        } else if (objectArray == null) {
            int n11 = list.size();
            n10 = 0;
            this.a = null;
            this.notifyItemRangeRemoved(0, n11);
        } else {
            r$a r$a = new r$a(this, list, (List)objectArray, n10);
            objectArray = new Void[]{};
            r$a.execute(objectArray);
        }
    }

    public List getData() {
        return this.a;
    }

    public Object getItem(int n10) {
        Object var4_4;
        boolean bl2;
        List list = this.a;
        if (list != null && !(bl2 = list.isEmpty())) {
            list = this.a;
            var4_4 = list.get(n10);
        } else {
            n10 = 0;
            var4_4 = null;
        }
        return var4_4;
    }

    public int getItemCount() {
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

