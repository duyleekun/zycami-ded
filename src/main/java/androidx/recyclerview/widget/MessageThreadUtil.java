/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.MessageThreadUtil$1;
import androidx.recyclerview.widget.MessageThreadUtil$2;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;

public class MessageThreadUtil
implements ThreadUtil {
    public ThreadUtil$BackgroundCallback getBackgroundProxy(ThreadUtil$BackgroundCallback threadUtil$BackgroundCallback) {
        MessageThreadUtil$2 messageThreadUtil$2 = new MessageThreadUtil$2(this, threadUtil$BackgroundCallback);
        return messageThreadUtil$2;
    }

    public ThreadUtil$MainThreadCallback getMainThreadProxy(ThreadUtil$MainThreadCallback threadUtil$MainThreadCallback) {
        MessageThreadUtil$1 messageThreadUtil$1 = new MessageThreadUtil$1(this, threadUtil$MainThreadCallback);
        return messageThreadUtil$1;
    }
}

