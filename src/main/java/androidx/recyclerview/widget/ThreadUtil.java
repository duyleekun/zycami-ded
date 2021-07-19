/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;

public interface ThreadUtil {
    public ThreadUtil$BackgroundCallback getBackgroundProxy(ThreadUtil$BackgroundCallback var1);

    public ThreadUtil$MainThreadCallback getMainThreadProxy(ThreadUtil$MainThreadCallback var1);
}

