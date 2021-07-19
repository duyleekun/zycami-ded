/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.view.Surface
 */
package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class EventLogger
implements AnalyticsListener {
    private static final String DEFAULT_TAG = "EventLogger";
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final NumberFormat TIME_FORMAT;
    private final Timeline$Period period;
    private final long startTimeMs;
    private final String tag;
    private final MappingTrackSelector trackSelector;
    private final Timeline$Window window;

    static {
        NumberFormat numberFormat;
        TIME_FORMAT = numberFormat = NumberFormat.getInstance(Locale.US);
        int n10 = 2;
        numberFormat.setMinimumFractionDigits(n10);
        numberFormat.setMaximumFractionDigits(n10);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this(mappingTrackSelector, DEFAULT_TAG);
    }

    public EventLogger(MappingTrackSelector object, String string2) {
        long l10;
        this.trackSelector = object;
        this.tag = string2;
        this.window = object = new Timeline$Window();
        this.period = object = new Timeline$Period();
        this.startTimeMs = l10 = SystemClock.elapsedRealtime();
    }

    private static String getAdaptiveSupportString(int n10, int n11) {
        int n12 = 2;
        if (n10 < n12) {
            return "N/A";
        }
        if (n11 != 0) {
            n10 = 8;
            if (n11 != n10) {
                n10 = 16;
                if (n11 == n10) {
                    return "YES";
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            return "YES_NOT_SEAMLESS";
        }
        return "NO";
    }

    private static String getDiscontinuityReasonString(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            return "?";
                        }
                        return "INTERNAL";
                    }
                    return "AD_INSERTION";
                }
                return "SEEK_ADJUSTMENT";
            }
            return "SEEK";
        }
        return "PERIOD_TRANSITION";
    }

    private String getEventString(AnalyticsListener$EventTime object, String string2, String string3, Throwable object2) {
        int n10;
        object = this.getEventTimeString((AnalyticsListener$EventTime)object);
        CharSequence charSequence = String.valueOf(string2);
        int n11 = ((String)charSequence).length() + 2;
        int n12 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n12);
        stringBuilder.append(string2);
        string2 = " [";
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        if (string3 != null) {
            object = String.valueOf(object);
            string2 = String.valueOf(object);
            int n13 = string2.length() + 2;
            n11 = String.valueOf(string3).length();
            charSequence = new StringBuilder(n13 += n11);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(", ");
            ((StringBuilder)charSequence).append(string3);
            object = ((StringBuilder)charSequence).toString();
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(string2 = Log.getThrowableString((Throwable)object2)))) == 0) {
            object = String.valueOf(object);
            object2 = "\n  ";
            string2 = string2.replace("\n", (CharSequence)object2);
            string3 = String.valueOf(object);
            n10 = string3.length() + 4;
            n11 = String.valueOf(string2).length();
            charSequence = new StringBuilder(n10 += n11);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(string2);
            char c10 = '\n';
            ((StringBuilder)charSequence).append(c10);
            object = ((StringBuilder)charSequence).toString();
        }
        return String.valueOf(object).concat("]");
    }

    private String getEventTimeString(AnalyticsListener$EventTime object) {
        StringBuilder stringBuilder;
        int n10 = ((AnalyticsListener$EventTime)object).windowIndex;
        int n11 = 18;
        Object object2 = new StringBuilder(n11);
        Object object3 = "window=";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(n10);
        String string2 = ((StringBuilder)object2).toString();
        object2 = ((AnalyticsListener$EventTime)object).mediaPeriodId;
        if (object2 != null) {
            string2 = String.valueOf(string2);
            object2 = ((AnalyticsListener$EventTime)object).timeline;
            object3 = object.mediaPeriodId.periodUid;
            int n12 = ((Timeline)object2).getIndexOfPeriod(object3);
            object3 = String.valueOf(string2);
            n11 = ((String)object3).length() + 20;
            stringBuilder = new StringBuilder(n11);
            stringBuilder.append(string2);
            stringBuilder.append(", period=");
            stringBuilder.append(n12);
            string2 = stringBuilder.toString();
            object2 = ((AnalyticsListener$EventTime)object).mediaPeriodId;
            n12 = (int)(((MediaPeriodId)object2).isAd() ? 1 : 0);
            if (n12 != 0) {
                string2 = String.valueOf(string2);
                n12 = object.mediaPeriodId.adGroupIndex;
                n11 = String.valueOf(string2).length() + 21;
                stringBuilder = new StringBuilder(n11);
                stringBuilder.append(string2);
                stringBuilder.append(", adGroup=");
                stringBuilder.append(n12);
                string2 = String.valueOf(stringBuilder.toString());
                object2 = ((AnalyticsListener$EventTime)object).mediaPeriodId;
                n12 = ((MediaPeriodId)object2).adIndexInAdGroup;
                object3 = String.valueOf(string2);
                n11 = ((String)object3).length() + 16;
                stringBuilder = new StringBuilder(n11);
                stringBuilder.append(string2);
                stringBuilder.append(", ad=");
                stringBuilder.append(n12);
                string2 = stringBuilder.toString();
            }
        }
        long l10 = ((AnalyticsListener$EventTime)object).realtimeMs;
        long l11 = this.startTimeMs;
        object2 = EventLogger.getTimeString(l10 - l11);
        object = EventLogger.getTimeString(((AnalyticsListener$EventTime)object).eventPlaybackPositionMs);
        n11 = String.valueOf(object2).length() + 23;
        int n13 = String.valueOf(object).length();
        n11 += n13;
        n13 = String.valueOf(string2).length();
        stringBuilder = new StringBuilder(n11 += n13);
        stringBuilder.append("eventTime=");
        stringBuilder.append((String)object2);
        stringBuilder.append(", mediaPos=");
        stringBuilder.append((String)object);
        stringBuilder.append(", ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static String getMediaItemTransitionReasonString(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return "?";
                    }
                    return "PLAYLIST_CHANGED";
                }
                return "SEEK";
            }
            return "AUTO";
        }
        return "REPEAT";
    }

    private static String getPlayWhenReadyChangeReasonString(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return "?";
                        }
                        return "END_OF_MEDIA_ITEM";
                    }
                    return "REMOTE";
                }
                return "AUDIO_BECOMING_NOISY";
            }
            return "AUDIO_FOCUS_LOSS";
        }
        return "USER_REQUEST";
    }

    private static String getPlaybackSuppressionReasonString(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return "?";
            }
            return "TRANSIENT_AUDIO_FOCUS_LOSS";
        }
        return "NONE";
    }

    private static String getRepeatModeString(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return "?";
                }
                return "ALL";
            }
            return "ONE";
        }
        return "OFF";
    }

    private static String getStateString(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        return "?";
                    }
                    return "ENDED";
                }
                return "READY";
            }
            return "BUFFERING";
        }
        return "IDLE";
    }

    private static String getTimeString(long l10) {
        String string2;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            string2 = "?";
        } else {
            NumberFormat numberFormat = TIME_FORMAT;
            float f10 = l10;
            float f11 = 1000.0f;
            double d10 = f10 /= f11;
            string2 = numberFormat.format(d10);
        }
        return string2;
    }

    private static String getTimelineChangeReasonString(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return "?";
            }
            return "SOURCE_UPDATE";
        }
        return "PLAYLIST_CHANGED";
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int n10) {
        int n11;
        int n12;
        TrackGroup trackGroup2;
        if (trackSelection != null && (trackGroup2 = trackSelection.getTrackGroup()) == trackGroup && (n12 = trackSelection.indexOf(n10)) != (n11 = -1)) {
            n12 = 1;
        } else {
            n12 = 0;
            trackSelection = null;
        }
        return EventLogger.getTrackStatusString(n12 != 0);
    }

    private static String getTrackStatusString(boolean bl2) {
        String string2 = bl2 ? "[X]" : "[ ]";
        return string2;
    }

    private void logd(AnalyticsListener$EventTime object, String string2) {
        object = this.getEventString((AnalyticsListener$EventTime)object, string2, null, null);
        this.logd((String)object);
    }

    private void logd(AnalyticsListener$EventTime object, String string2, String string3) {
        object = this.getEventString((AnalyticsListener$EventTime)object, string2, string3, null);
        this.logd((String)object);
    }

    private void loge(AnalyticsListener$EventTime object, String string2, String string3, Throwable throwable) {
        object = this.getEventString((AnalyticsListener$EventTime)object, string2, string3, throwable);
        this.loge((String)object);
    }

    private void loge(AnalyticsListener$EventTime object, String string2, Throwable throwable) {
        object = this.getEventString((AnalyticsListener$EventTime)object, string2, null, throwable);
        this.loge((String)object);
    }

    private void printInternalError(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, Exception exception) {
        this.loge(analyticsListener$EventTime, "internalError", string2, exception);
    }

    private void printMetadata(Metadata metadata, String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = metadata.length()); ++i10) {
            String string3 = String.valueOf(metadata.get(i10));
            String string4 = String.valueOf(string2);
            int n11 = string4.length();
            int n12 = String.valueOf(string3).length();
            StringBuilder stringBuilder = new StringBuilder(n11 += n12);
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            this.logd(string3);
        }
    }

    public void logd(String string2) {
        Log.d(this.tag, string2);
    }

    public void loge(String string2) {
        Log.e(this.tag, string2);
    }

    public void onAudioAttributesChanged(AnalyticsListener$EventTime analyticsListener$EventTime, AudioAttributes object) {
        int n10 = ((AudioAttributes)object).contentType;
        int n11 = ((AudioAttributes)object).flags;
        int n12 = ((AudioAttributes)object).usage;
        int n13 = ((AudioAttributes)object).allowedCapturePolicy;
        StringBuilder stringBuilder = new StringBuilder(47);
        stringBuilder.append(n10);
        String string2 = ",";
        stringBuilder.append(string2);
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append(n12);
        stringBuilder.append(string2);
        stringBuilder.append(n13);
        object = stringBuilder.toString();
        this.logd(analyticsListener$EventTime, "audioAttributes", (String)object);
    }

    public void onAudioDecoderInitialized(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, long l10) {
        this.logd(analyticsListener$EventTime, "audioDecoderInitialized", string2);
    }

    public void onAudioDecoderReleased(AnalyticsListener$EventTime analyticsListener$EventTime, String string2) {
        this.logd(analyticsListener$EventTime, "audioDecoderReleased", string2);
    }

    public void onAudioDisabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
        this.logd(analyticsListener$EventTime, "audioDisabled");
    }

    public void onAudioEnabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
        this.logd(analyticsListener$EventTime, "audioEnabled");
    }

    public void onAudioInputFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, Format object, DecoderReuseEvaluation decoderReuseEvaluation) {
        object = Format.toLogString((Format)object);
        this.logd(analyticsListener$EventTime, "audioInputFormat", (String)object);
    }

    public void onAudioSessionIdChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        String string2 = Integer.toString(n10);
        this.logd(analyticsListener$EventTime, "audioSessionId", string2);
    }

    public void onAudioUnderrun(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11) {
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append(n10);
        String string2 = ", ";
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        stringBuilder.append(string2);
        stringBuilder.append(l11);
        string2 = stringBuilder.toString();
        this.loge(analyticsListener$EventTime, "audioTrackUnderrun", string2, null);
    }

    public void onBandwidthEstimate(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11) {
    }

    public void onDownstreamFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, MediaLoadData object) {
        object = Format.toLogString(((MediaLoadData)object).trackFormat);
        this.logd(analyticsListener$EventTime, "downstreamFormat", (String)object);
    }

    public void onDrmKeysLoaded(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.logd(analyticsListener$EventTime, "drmKeysLoaded");
    }

    public void onDrmKeysRemoved(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.logd(analyticsListener$EventTime, "drmKeysRemoved");
    }

    public void onDrmKeysRestored(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.logd(analyticsListener$EventTime, "drmKeysRestored");
    }

    public void onDrmSessionAcquired(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.logd(analyticsListener$EventTime, "drmSessionAcquired");
    }

    public void onDrmSessionManagerError(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception) {
        this.printInternalError(analyticsListener$EventTime, "drmSessionManagerError", exception);
    }

    public void onDrmSessionReleased(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.logd(analyticsListener$EventTime, "drmSessionReleased");
    }

    public void onDroppedVideoFrames(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10) {
        String string2 = Integer.toString(n10);
        this.logd(analyticsListener$EventTime, "droppedFrames", string2);
    }

    public void onIsLoadingChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
        String string2 = Boolean.toString(bl2);
        this.logd(analyticsListener$EventTime, "loading", string2);
    }

    public void onIsPlayingChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
        String string2 = Boolean.toString(bl2);
        this.logd(analyticsListener$EventTime, "isPlaying", string2);
    }

    public void onLoadCanceled(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadError(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        this.printInternalError(analyticsListener$EventTime, "loadError", iOException);
    }

    public void onLoadStarted(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onMediaItemTransition(AnalyticsListener$EventTime object, MediaItem object2, int n10) {
        object = this.getEventTimeString((AnalyticsListener$EventTime)object);
        object2 = EventLogger.getMediaItemTransitionReasonString(n10);
        n10 = String.valueOf(object).length() + 21;
        int n11 = String.valueOf(object2).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("mediaItem [");
        stringBuilder.append((String)object);
        stringBuilder.append(", reason=");
        stringBuilder.append((String)object2);
        stringBuilder.append("]");
        object = stringBuilder.toString();
        this.logd((String)object);
    }

    public void onMetadata(AnalyticsListener$EventTime object, Metadata metadata) {
        object = String.valueOf(this.getEventTimeString((AnalyticsListener$EventTime)object));
        int n10 = ((String)object).length();
        String string2 = "metadata [";
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        this.logd((String)object);
        this.printMetadata(metadata, "  ");
        this.logd("]");
    }

    public void onPlayWhenReadyChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, int n10) {
        String string2 = EventLogger.getPlayWhenReadyChangeReasonString(n10);
        int n11 = String.valueOf(string2).length() + 7;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append(bl2);
        stringBuilder.append(", ");
        stringBuilder.append(string2);
        String string3 = stringBuilder.toString();
        this.logd(analyticsListener$EventTime, "playWhenReady", string3);
    }

    public void onPlaybackParametersChanged(AnalyticsListener$EventTime analyticsListener$EventTime, PlaybackParameters object) {
        object = ((PlaybackParameters)object).toString();
        this.logd(analyticsListener$EventTime, "playbackParameters", (String)object);
    }

    public void onPlaybackStateChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        String string2 = EventLogger.getStateString(n10);
        this.logd(analyticsListener$EventTime, "state", string2);
    }

    public void onPlaybackSuppressionReasonChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        String string2 = EventLogger.getPlaybackSuppressionReasonString(n10);
        this.logd(analyticsListener$EventTime, "playbackSuppressionReason", string2);
    }

    public void onPlayerError(AnalyticsListener$EventTime analyticsListener$EventTime, ExoPlaybackException exoPlaybackException) {
        this.loge(analyticsListener$EventTime, "playerFailed", exoPlaybackException);
    }

    public void onPositionDiscontinuity(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        String string2 = EventLogger.getDiscontinuityReasonString(n10);
        this.logd(analyticsListener$EventTime, "positionDiscontinuity", string2);
    }

    public void onRenderedFirstFrame(AnalyticsListener$EventTime analyticsListener$EventTime, Surface object) {
        object = String.valueOf(object);
        this.logd(analyticsListener$EventTime, "renderedFirstFrame", (String)object);
    }

    public void onRepeatModeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        String string2 = EventLogger.getRepeatModeString(n10);
        this.logd(analyticsListener$EventTime, "repeatMode", string2);
    }

    public void onSeekStarted(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.logd(analyticsListener$EventTime, "seekStarted");
    }

    public void onShuffleModeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
        String string2 = Boolean.toString(bl2);
        this.logd(analyticsListener$EventTime, "shuffleModeEnabled", string2);
    }

    public void onSkipSilenceEnabledChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
        String string2 = Boolean.toString(bl2);
        this.logd(analyticsListener$EventTime, "skipSilenceEnabled", string2);
    }

    public void onStaticMetadataChanged(AnalyticsListener$EventTime object, List list) {
        object = String.valueOf(this.getEventTimeString((AnalyticsListener$EventTime)object));
        int n10 = ((String)object).length();
        String string2 = "staticMetadata [";
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        this.logd((String)object);
        object = null;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object2 = (Metadata)list.get(i10);
            int n11 = ((Metadata)object2).length();
            if (n11 == 0) continue;
            n11 = 24;
            StringBuilder stringBuilder = new StringBuilder(n11);
            stringBuilder.append("  Metadata:");
            stringBuilder.append(i10);
            stringBuilder.append(" [");
            string2 = stringBuilder.toString();
            this.logd(string2);
            string2 = "    ";
            this.printMetadata((Metadata)object2, string2);
            object2 = "  ]";
            this.logd((String)object2);
        }
        this.logd("]");
    }

    public void onSurfaceSizeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        this.logd(analyticsListener$EventTime, "surfaceSize", string2);
    }

    public void onTimelineChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        String string2;
        Object object = analyticsListener$EventTime.timeline;
        int n11 = ((Timeline)object).getPeriodCount();
        Timeline timeline = analyticsListener$EventTime.timeline;
        int n12 = timeline.getWindowCount();
        String string3 = this.getEventTimeString(analyticsListener$EventTime);
        String string4 = EventLogger.getTimelineChangeReasonString(n10);
        int n13 = String.valueOf(string3).length() + 69;
        int n14 = String.valueOf(string4).length();
        Object object2 = new StringBuilder(n13 += n14);
        Object object3 = "timeline [";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(", periodCount=");
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append(", windowCount=");
        ((StringBuilder)object2).append(n12);
        ((StringBuilder)object2).append(", reason=");
        ((StringBuilder)object2).append(string4);
        string4 = ((StringBuilder)object2).toString();
        this.logd(string4);
        n10 = 0;
        string4 = null;
        int n15 = 0;
        string3 = null;
        while (true) {
            n13 = 3;
            n14 = Math.min(n11, n13);
            string2 = "]";
            if (n15 >= n14) break;
            object3 = analyticsListener$EventTime.timeline;
            object2 = this.period;
            ((Timeline)object3).getPeriod(n15, (Timeline$Period)object2);
            long l10 = this.period.getDurationMs();
            object3 = EventLogger.getTimeString(l10);
            n14 = String.valueOf(object3).length() + 11;
            StringBuilder stringBuilder = new StringBuilder(n14);
            object2 = "  period [";
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object3);
            stringBuilder.append(string2);
            object3 = stringBuilder.toString();
            this.logd((String)object3);
            ++n15;
        }
        string3 = "  ...";
        if (n11 > n13) {
            this.logd(string3);
        }
        while (n10 < (n11 = Math.min(n12, n13))) {
            object = analyticsListener$EventTime.timeline;
            object2 = this.window;
            ((Timeline)object).getWindow(n10, (Timeline$Window)object2);
            long l11 = this.window.getDurationMs();
            object = EventLogger.getTimeString(l11);
            object2 = this.window;
            boolean bl2 = ((Timeline$Window)object2).isSeekable;
            n14 = (int)(((Timeline$Window)object2).isDynamic ? 1 : 0);
            int n16 = String.valueOf(object).length() + 42;
            StringBuilder stringBuilder = new StringBuilder(n16);
            String string5 = "  window [";
            stringBuilder.append(string5);
            stringBuilder.append((String)object);
            stringBuilder.append(", seekable=");
            stringBuilder.append(bl2);
            stringBuilder.append(", dynamic=");
            stringBuilder.append(n14 != 0);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            this.logd((String)object);
            ++n10;
        }
        if (n12 > n13) {
            this.logd(string3);
        }
        this.logd(string2);
    }

    public void onTracksChanged(AnalyticsListener$EventTime analyticsListener$EventTime, TrackGroupArray object, TrackSelectionArray trackSelectionArray) {
        int n10;
        String string2;
        Object object2;
        Object object3;
        int n11;
        String string3;
        int n12;
        int n13;
        int n14;
        Object object4;
        Object object5;
        Object object6;
        String string4;
        String string5;
        String string6;
        CharSequence charSequence;
        Object object7;
        String string7;
        CharSequence charSequence2;
        String string8;
        int n15;
        EventLogger eventLogger = this;
        Object object8 = this.trackSelector;
        if (object8 != null) {
            object8 = ((MappingTrackSelector)object8).getCurrentMappedTrackInfo();
        } else {
            n15 = 0;
            object8 = null;
        }
        if (object8 == null) {
            AnalyticsListener$EventTime analyticsListener$EventTime2 = analyticsListener$EventTime;
            eventLogger.logd(analyticsListener$EventTime, "tracks", "[]");
            return;
        }
        Object object9 = analyticsListener$EventTime;
        Object object10 = "tracks [";
        object9 = String.valueOf(this.getEventTimeString(analyticsListener$EventTime));
        int n16 = ((String)object9).length();
        object10 = n16 != 0 ? ((String)object10).concat((String)object9) : (object9 = new String((String)object10));
        eventLogger.logd((String)object10);
        int n17 = ((MappingTrackSelector$MappedTrackInfo)object8).getRendererCount();
        n16 = 0;
        Object object11 = null;
        while (true) {
            string8 = ", supported=";
            charSequence2 = ", ";
            string7 = " Track:";
            object7 = "    Group:";
            charSequence = "  ]";
            string6 = "      ";
            string5 = "    ]";
            string4 = " [";
            if (n16 >= n17) break;
            object6 = ((MappingTrackSelector$MappedTrackInfo)object8).getTrackGroups(n16);
            object5 = trackSelectionArray;
            object4 = trackSelectionArray.get(n16);
            n14 = ((TrackGroupArray)object6).length;
            int n18 = n17;
            object10 = "  ";
            if (n14 == 0) {
                object9 = ((MappingTrackSelector$MappedTrackInfo)object8).getRendererName(n16);
                string8 = String.valueOf(object9);
                int n19 = string8.length() + 5;
                charSequence2 = new StringBuilder(n19);
                ((StringBuilder)charSequence2).append((String)object10);
                ((StringBuilder)charSequence2).append((String)object9);
                ((StringBuilder)charSequence2).append(" []");
                object10 = ((StringBuilder)charSequence2).toString();
                eventLogger.logd((String)object10);
            } else {
                object9 = ((MappingTrackSelector$MappedTrackInfo)object8).getRendererName(n16);
                n13 = String.valueOf(object9).length();
                n12 = n13 + 4;
                string3 = charSequence;
                charSequence = new StringBuilder(n12);
                ((StringBuilder)charSequence).append((String)object10);
                ((StringBuilder)charSequence).append((String)object9);
                ((StringBuilder)charSequence).append(string4);
                object10 = ((StringBuilder)charSequence).toString();
                eventLogger.logd((String)object10);
                object10 = null;
                for (n17 = 0; n17 < (n14 = ((TrackGroupArray)object6).length); ++n17) {
                    object9 = ((TrackGroupArray)object6).get(n17);
                    n11 = ((TrackGroup)object9).length;
                    object3 = object6;
                    int n20 = ((MappingTrackSelector$MappedTrackInfo)object8).getAdaptiveSupport(n16, n17, false);
                    charSequence = EventLogger.getAdaptiveSupportString(n11, n20);
                    n20 = String.valueOf(charSequence).length() + 44;
                    object5 = new StringBuilder(n20);
                    ((StringBuilder)object5).append((String)object7);
                    ((StringBuilder)object5).append(n17);
                    object6 = ", adaptive_supported=";
                    ((StringBuilder)object5).append((String)object6);
                    ((StringBuilder)object5).append((String)charSequence);
                    ((StringBuilder)object5).append(string4);
                    charSequence = ((StringBuilder)object5).toString();
                    eventLogger.logd((String)charSequence);
                    object5 = null;
                    for (n12 = 0; n12 < (n11 = ((TrackGroup)object9).length); ++n12) {
                        charSequence = EventLogger.getTrackStatusString((TrackSelection)object4, (TrackGroup)object9, n12);
                        n20 = ((MappingTrackSelector$MappedTrackInfo)object8).getTrackSupport(n16, n17, n12);
                        object6 = C.getFormatSupportString(n20);
                        object2 = ((TrackGroup)object9).getFormat(n12);
                        Object object12 = object9;
                        object9 = Format.toLogString((Format)object2);
                        int n21 = String.valueOf(charSequence).length() + 38;
                        int n22 = String.valueOf(object9).length();
                        n21 += n22;
                        String string9 = String.valueOf(object6);
                        n22 = string9.length();
                        string2 = string4;
                        n10 = n21 + n22;
                        object2 = object7;
                        object7 = new StringBuilder(n10);
                        ((StringBuilder)object7).append(string6);
                        ((StringBuilder)object7).append((String)charSequence);
                        ((StringBuilder)object7).append(string7);
                        ((StringBuilder)object7).append(n12);
                        ((StringBuilder)object7).append((String)charSequence2);
                        ((StringBuilder)object7).append((String)object9);
                        ((StringBuilder)object7).append(string8);
                        ((StringBuilder)object7).append((String)object6);
                        object9 = ((StringBuilder)object7).toString();
                        eventLogger.logd((String)object9);
                        object7 = object2;
                        object9 = object12;
                    }
                    object2 = object7;
                    string2 = string4;
                    eventLogger.logd(string5);
                    object6 = object3;
                }
                if (object4 != null) {
                    object5 = null;
                    for (n12 = 0; n12 < (n17 = object4.length()); ++n12) {
                        object10 = object4.getFormat((int)n12).metadata;
                        if (object10 == null) continue;
                        object9 = "    Metadata [";
                        eventLogger.logd((String)object9);
                        eventLogger.printMetadata((Metadata)object10, string6);
                        eventLogger.logd(string5);
                        break;
                    }
                }
                object10 = string3;
                eventLogger.logd(string3);
            }
            ++n16;
            n17 = n18;
        }
        object2 = object7;
        object10 = charSequence;
        string2 = string4;
        object8 = ((MappingTrackSelector$MappedTrackInfo)object8).getUnmappedTrackGroups();
        n14 = ((TrackGroupArray)object8).length;
        if (n14 > 0) {
            object9 = "  Unmapped [";
            eventLogger.logd((String)object9);
            object5 = null;
            for (n12 = 0; n12 < (n14 = ((TrackGroupArray)object8).length); ++n12) {
                n14 = 23;
                object11 = new StringBuilder(n14);
                object9 = object2;
                ((StringBuilder)object11).append((String)object2);
                ((StringBuilder)object11).append(n12);
                object7 = string2;
                ((StringBuilder)object11).append(string2);
                object11 = ((StringBuilder)object11).toString();
                eventLogger.logd((String)object11);
                object11 = ((TrackGroupArray)object8).get(n12);
                charSequence = null;
                for (n11 = 0; n11 < (n10 = ((TrackGroup)object11).length); ++n11) {
                    n10 = 0;
                    object6 = EventLogger.getTrackStatusString(false);
                    object4 = C.getFormatSupportString(0);
                    string4 = Format.toLogString(((TrackGroup)object11).getFormat(n11));
                    string3 = String.valueOf(object6);
                    n13 = string3.length() + 38;
                    int n23 = String.valueOf(string4).length();
                    n13 += n23;
                    object3 = String.valueOf(object4);
                    n23 = ((String)object3).length();
                    object = object8;
                    n15 = n13 + n23;
                    object2 = object9;
                    object9 = new StringBuilder(n15);
                    ((StringBuilder)object9).append(string6);
                    ((StringBuilder)object9).append((String)object6);
                    ((StringBuilder)object9).append(string7);
                    ((StringBuilder)object9).append(n11);
                    ((StringBuilder)object9).append((String)charSequence2);
                    ((StringBuilder)object9).append(string4);
                    ((StringBuilder)object9).append(string8);
                    ((StringBuilder)object9).append((String)object4);
                    object8 = ((StringBuilder)object9).toString();
                    eventLogger.logd((String)object8);
                    object8 = object;
                    object9 = object2;
                }
                object = object8;
                object2 = object9;
                eventLogger.logd(string5);
                string2 = object7;
            }
            eventLogger.logd((String)object10);
        }
        eventLogger.logd("]");
    }

    public void onUpstreamDiscarded(AnalyticsListener$EventTime analyticsListener$EventTime, MediaLoadData object) {
        object = Format.toLogString(((MediaLoadData)object).trackFormat);
        this.logd(analyticsListener$EventTime, "upstreamDiscarded", (String)object);
    }

    public void onVideoDecoderInitialized(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, long l10) {
        this.logd(analyticsListener$EventTime, "videoDecoderInitialized", string2);
    }

    public void onVideoDecoderReleased(AnalyticsListener$EventTime analyticsListener$EventTime, String string2) {
        this.logd(analyticsListener$EventTime, "videoDecoderReleased", string2);
    }

    public void onVideoDisabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
        this.logd(analyticsListener$EventTime, "videoDisabled");
    }

    public void onVideoEnabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
        this.logd(analyticsListener$EventTime, "videoEnabled");
    }

    public void onVideoInputFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, Format object, DecoderReuseEvaluation decoderReuseEvaluation) {
        object = Format.toLogString((Format)object);
        this.logd(analyticsListener$EventTime, "videoInputFormat", (String)object);
    }

    public void onVideoSizeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11, int n12, float f10) {
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        this.logd(analyticsListener$EventTime, "videoSize", string2);
    }

    public void onVolumeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, float f10) {
        String string2 = Float.toString(f10);
        this.logd(analyticsListener$EventTime, "volume", string2);
    }
}

