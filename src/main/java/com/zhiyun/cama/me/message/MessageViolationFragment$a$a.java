/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.message;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.MessageViolation;

public final class MessageViolationFragment$a$a
extends DiffUtil$ItemCallback {
    public boolean a(MessageViolation messageViolation, MessageViolation messageViolation2) {
        return messageViolation.equals(messageViolation2);
    }

    public boolean b(MessageViolation messageViolation, MessageViolation messageViolation2) {
        int n10;
        int n11 = messageViolation.getId();
        if (n11 == (n10 = messageViolation2.getId())) {
            n11 = 1;
        } else {
            n11 = 0;
            messageViolation = null;
        }
        return n11 != 0;
    }
}

