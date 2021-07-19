/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help.list;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;
import com.zhiyun.cama.me.help.list.FeedbackListFragment$a$a;
import d.v.c.h1.o;
import d.v.c.n0.e;
import d.v.c.w0.af;

public class FeedbackListFragment$a
extends o {
    private static DiffUtil$ItemCallback g;

    static {
        FeedbackListFragment$a$a feedbackListFragment$a$a = new FeedbackListFragment$a$a();
        g = feedbackListFragment$a$a;
    }

    public FeedbackListFragment$a() {
        DiffUtil$ItemCallback diffUtil$ItemCallback = g;
        super(diffUtil$ItemCallback);
    }

    public int a(int n10) {
        return 2131558702;
    }

    public void i(e object, int n10) {
        object = (af)((e)object).a;
        Object object2 = (Feedback)this.getItem(n10);
        if (object2 != null) {
            CharSequence charSequence = object2.getTitle();
            ((af)object).B((String)charSequence);
            charSequence = new StringBuilder();
            n10 = object2.getDealStatus();
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append("");
            object2 = FeedbackSet$DealStatus.from(((StringBuilder)charSequence).toString());
            ((af)object).A((FeedbackSet$DealStatus)((Object)object2));
        }
    }
}

