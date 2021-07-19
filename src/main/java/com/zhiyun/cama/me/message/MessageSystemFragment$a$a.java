/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.message;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.MessageSystem;

public final class MessageSystemFragment$a$a
extends DiffUtil$ItemCallback {
    public boolean a(MessageSystem messageSystem, MessageSystem messageSystem2) {
        return messageSystem.equals(messageSystem2);
    }

    public boolean b(MessageSystem messageSystem, MessageSystem messageSystem2) {
        int n10;
        int n11 = messageSystem.getId();
        if (n11 == (n10 = messageSystem2.getId())) {
            n11 = 1;
        } else {
            n11 = 0;
            messageSystem = null;
        }
        return n11 != 0;
    }
}

