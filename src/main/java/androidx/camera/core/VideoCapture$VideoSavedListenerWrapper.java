/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.Logger;
import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.camera.core.VideoCapture$OutputFileResults;
import b.a.b.m1;
import b.a.b.n1;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class VideoCapture$VideoSavedListenerWrapper
implements VideoCapture$OnVideoSavedCallback {
    public Executor mExecutor;
    public VideoCapture$OnVideoSavedCallback mOnVideoSavedCallback;

    public VideoCapture$VideoSavedListenerWrapper(Executor executor, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.mExecutor = executor;
        this.mOnVideoSavedCallback = videoCapture$OnVideoSavedCallback;
    }

    private /* synthetic */ void a(int n10, String string2, Throwable throwable) {
        this.mOnVideoSavedCallback.onError(n10, string2, throwable);
    }

    private /* synthetic */ void c(VideoCapture$OutputFileResults videoCapture$OutputFileResults) {
        this.mOnVideoSavedCallback.onVideoSaved(videoCapture$OutputFileResults);
    }

    public /* synthetic */ void b(int n10, String string2, Throwable throwable) {
        this.a(n10, string2, throwable);
    }

    public /* synthetic */ void d(VideoCapture$OutputFileResults videoCapture$OutputFileResults) {
        this.c(videoCapture$OutputFileResults);
    }

    public void onError(int n10, String string2, Throwable throwable) {
        Executor executor = this.mExecutor;
        m1 m12 = new m1(this, n10, string2, throwable);
        try {
            executor.execute(m12);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            String string3 = "VideoCapture";
            string2 = "Unable to post to the supplied executor.";
            Logger.e(string3, string2);
        }
    }

    public void onVideoSaved(VideoCapture$OutputFileResults object) {
        Object object2 = this.mExecutor;
        n1 n12 = new n1(this, (VideoCapture$OutputFileResults)object);
        try {
            object2.execute(n12);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = "VideoCapture";
            object2 = "Unable to post to the supplied executor.";
            Logger.e((String)object, (String)object2);
        }
    }
}

