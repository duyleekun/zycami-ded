/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.message;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.MessageLike;

public final class MessageLikeFragment$a$a
extends DiffUtil$ItemCallback {
    public boolean a(MessageLike messageLike, MessageLike messageLike2) {
        return messageLike.equals(messageLike2);
    }

    public boolean b(MessageLike messageLike, MessageLike messageLike2) {
        int n10;
        int n11 = messageLike.getId();
        if (n11 == (n10 = messageLike2.getId())) {
            n11 = 1;
        } else {
            n11 = 0;
            messageLike = null;
        }
        return n11 != 0;
    }
}

