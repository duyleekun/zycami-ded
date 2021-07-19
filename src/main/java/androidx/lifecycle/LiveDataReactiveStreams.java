/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher;
import androidx.lifecycle.LiveDataReactiveStreams$PublisherLiveData;
import i.g.c;

public final class LiveDataReactiveStreams {
    private LiveDataReactiveStreams() {
    }

    public static LiveData fromPublisher(c c10) {
        LiveDataReactiveStreams$PublisherLiveData liveDataReactiveStreams$PublisherLiveData = new LiveDataReactiveStreams$PublisherLiveData(c10);
        return liveDataReactiveStreams$PublisherLiveData;
    }

    public static c toPublisher(LifecycleOwner lifecycleOwner, LiveData liveData) {
        LiveDataReactiveStreams$LiveDataPublisher liveDataReactiveStreams$LiveDataPublisher = new LiveDataReactiveStreams$LiveDataPublisher(lifecycleOwner, liveData);
        return liveDataReactiveStreams$LiveDataPublisher;
    }
}

