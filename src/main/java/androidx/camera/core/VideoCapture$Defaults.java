/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.VideoCapture$Builder;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.VideoCaptureConfig;

public final class VideoCapture$Defaults
implements ConfigProvider {
    private static final int DEFAULT_ASPECT_RATIO = 1;
    private static final int DEFAULT_AUDIO_BIT_RATE = 64000;
    private static final int DEFAULT_AUDIO_CHANNEL_COUNT = 1;
    private static final int DEFAULT_AUDIO_MIN_BUFFER_SIZE = 1024;
    private static final int DEFAULT_AUDIO_RECORD_SOURCE = 1;
    private static final int DEFAULT_AUDIO_SAMPLE_RATE = 8000;
    private static final int DEFAULT_BIT_RATE = 0x800000;
    private static final VideoCaptureConfig DEFAULT_CONFIG;
    private static final int DEFAULT_INTRA_FRAME_INTERVAL = 1;
    private static final Size DEFAULT_MAX_RESOLUTION;
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 3;
    private static final int DEFAULT_VIDEO_FRAME_RATE = 30;

    static {
        Size size;
        DEFAULT_MAX_RESOLUTION = size = new Size(1920, 1080);
        VideoCapture$Builder videoCapture$Builder = new VideoCapture$Builder();
        videoCapture$Builder = videoCapture$Builder.setVideoFrameRate(30).setBitRate(0x800000);
        int n10 = 1;
        DEFAULT_CONFIG = videoCapture$Builder.setIFrameInterval(n10).setAudioBitRate(64000).setAudioSampleRate(8000).setAudioChannelCount(n10).setAudioRecordSource(n10).setAudioMinBufferSize(1024).setMaxResolution(size).setSurfaceOccupancyPriority(3).setTargetAspectRatio(n10).getUseCaseConfig();
    }

    public VideoCaptureConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}

