/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help.list;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.Feedback;

public final class FeedbackListFragment$a$a
extends DiffUtil$ItemCallback {
    public boolean a(Feedback feedback, Feedback feedback2) {
        return feedback.equals(feedback2);
    }

    public boolean b(Feedback feedback, Feedback feedback2) {
        int n10;
        int n11 = feedback.getId();
        if (n11 == (n10 = feedback2.getId())) {
            n11 = 1;
        } else {
            n11 = 0;
            feedback = null;
        }
        return n11 != 0;
    }
}

