/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnBufferingUpdateListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnCompletionListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnHLSKeyErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnHevcVideoDecoderErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnInfoListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnPreparedListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnSeekCompleteListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnTimedTextListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoDecoderErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoSizeChangedListener;
import com.tencent.ijk.media.player.IjkTimedText;
import com.tencent.ijk.media.player.misc.IMediaDataSource;

public abstract class AbstractMediaPlayer
implements IMediaPlayer {
    private IMediaPlayer$OnBufferingUpdateListener mOnBufferingUpdateListener;
    private IMediaPlayer$OnCompletionListener mOnCompletionListener;
    private IMediaPlayer$OnErrorListener mOnErrorListener;
    private IMediaPlayer$OnHLSKeyErrorListener mOnHLSKeyErrorListener;
    private IMediaPlayer$OnHevcVideoDecoderErrorListener mOnHevcVideoDecoderErrorListener;
    private IMediaPlayer$OnInfoListener mOnInfoListener;
    private IMediaPlayer$OnPreparedListener mOnPreparedListener;
    private IMediaPlayer$OnSeekCompleteListener mOnSeekCompleteListener;
    private IMediaPlayer$OnTimedTextListener mOnTimedTextListener;
    private IMediaPlayer$OnVideoDecoderErrorListener mOnVideoDecoderErrorListener;
    private IMediaPlayer$OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    public final void notifyHLSKeyError() {
        IMediaPlayer$OnHLSKeyErrorListener iMediaPlayer$OnHLSKeyErrorListener = this.mOnHLSKeyErrorListener;
        if (iMediaPlayer$OnHLSKeyErrorListener != null) {
            iMediaPlayer$OnHLSKeyErrorListener.onHLSKeyError(this);
        }
    }

    public final void notifyHevcVideoDecoderError() {
        IMediaPlayer$OnHevcVideoDecoderErrorListener iMediaPlayer$OnHevcVideoDecoderErrorListener = this.mOnHevcVideoDecoderErrorListener;
        if (iMediaPlayer$OnHevcVideoDecoderErrorListener != null) {
            iMediaPlayer$OnHevcVideoDecoderErrorListener.onHevcVideoDecoderError(this);
        }
    }

    public final void notifyOnBufferingUpdate(int n10) {
        IMediaPlayer$OnBufferingUpdateListener iMediaPlayer$OnBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (iMediaPlayer$OnBufferingUpdateListener != null) {
            iMediaPlayer$OnBufferingUpdateListener.onBufferingUpdate(this, n10);
        }
    }

    public final void notifyOnCompletion() {
        IMediaPlayer$OnCompletionListener iMediaPlayer$OnCompletionListener = this.mOnCompletionListener;
        if (iMediaPlayer$OnCompletionListener != null) {
            iMediaPlayer$OnCompletionListener.onCompletion(this);
        }
    }

    public final boolean notifyOnError(int n10, int n11) {
        IMediaPlayer$OnErrorListener iMediaPlayer$OnErrorListener = this.mOnErrorListener;
        n10 = iMediaPlayer$OnErrorListener != null && (n10 = (int)(iMediaPlayer$OnErrorListener.onError(this, n10, n11) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public final boolean notifyOnInfo(int n10, int n11) {
        IMediaPlayer$OnInfoListener iMediaPlayer$OnInfoListener = this.mOnInfoListener;
        n10 = iMediaPlayer$OnInfoListener != null && (n10 = (int)(iMediaPlayer$OnInfoListener.onInfo(this, n10, n11) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public final void notifyOnPrepared() {
        IMediaPlayer$OnPreparedListener iMediaPlayer$OnPreparedListener = this.mOnPreparedListener;
        if (iMediaPlayer$OnPreparedListener != null) {
            iMediaPlayer$OnPreparedListener.onPrepared(this);
        }
    }

    public final void notifyOnSeekComplete() {
        IMediaPlayer$OnSeekCompleteListener iMediaPlayer$OnSeekCompleteListener = this.mOnSeekCompleteListener;
        if (iMediaPlayer$OnSeekCompleteListener != null) {
            iMediaPlayer$OnSeekCompleteListener.onSeekComplete(this);
        }
    }

    public final void notifyOnTimedText(IjkTimedText ijkTimedText) {
        IMediaPlayer$OnTimedTextListener iMediaPlayer$OnTimedTextListener = this.mOnTimedTextListener;
        if (iMediaPlayer$OnTimedTextListener != null) {
            iMediaPlayer$OnTimedTextListener.onTimedText(this, ijkTimedText);
        }
    }

    public final void notifyOnVideoSizeChanged(int n10, int n11, int n12, int n13) {
        IMediaPlayer$OnVideoSizeChangedListener iMediaPlayer$OnVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (iMediaPlayer$OnVideoSizeChangedListener != null) {
            iMediaPlayer$OnVideoSizeChangedListener.onVideoSizeChanged(this, n10, n11, n12, n13);
        }
    }

    public final void notifyVideoDecoderError() {
        IMediaPlayer$OnVideoDecoderErrorListener iMediaPlayer$OnVideoDecoderErrorListener = this.mOnVideoDecoderErrorListener;
        if (iMediaPlayer$OnVideoDecoderErrorListener != null) {
            iMediaPlayer$OnVideoDecoderErrorListener.onVideoDecoderError(this);
        }
    }

    public void resetListeners() {
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnTimedTextListener = null;
        this.mOnHLSKeyErrorListener = null;
        this.mOnHevcVideoDecoderErrorListener = null;
        this.mOnVideoDecoderErrorListener = null;
    }

    public void setDataSource(IMediaDataSource object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void setOnBufferingUpdateListener(IMediaPlayer$OnBufferingUpdateListener iMediaPlayer$OnBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = iMediaPlayer$OnBufferingUpdateListener;
    }

    public final void setOnCompletionListener(IMediaPlayer$OnCompletionListener iMediaPlayer$OnCompletionListener) {
        this.mOnCompletionListener = iMediaPlayer$OnCompletionListener;
    }

    public final void setOnErrorListener(IMediaPlayer$OnErrorListener iMediaPlayer$OnErrorListener) {
        this.mOnErrorListener = iMediaPlayer$OnErrorListener;
    }

    public final void setOnHLSKeyErrorListener(IMediaPlayer$OnHLSKeyErrorListener iMediaPlayer$OnHLSKeyErrorListener) {
        this.mOnHLSKeyErrorListener = iMediaPlayer$OnHLSKeyErrorListener;
    }

    public final void setOnHevcVideoDecoderErrorListener(IMediaPlayer$OnHevcVideoDecoderErrorListener iMediaPlayer$OnHevcVideoDecoderErrorListener) {
        this.mOnHevcVideoDecoderErrorListener = iMediaPlayer$OnHevcVideoDecoderErrorListener;
    }

    public final void setOnInfoListener(IMediaPlayer$OnInfoListener iMediaPlayer$OnInfoListener) {
        this.mOnInfoListener = iMediaPlayer$OnInfoListener;
    }

    public final void setOnPreparedListener(IMediaPlayer$OnPreparedListener iMediaPlayer$OnPreparedListener) {
        this.mOnPreparedListener = iMediaPlayer$OnPreparedListener;
    }

    public final void setOnSeekCompleteListener(IMediaPlayer$OnSeekCompleteListener iMediaPlayer$OnSeekCompleteListener) {
        this.mOnSeekCompleteListener = iMediaPlayer$OnSeekCompleteListener;
    }

    public final void setOnTimedTextListener(IMediaPlayer$OnTimedTextListener iMediaPlayer$OnTimedTextListener) {
        this.mOnTimedTextListener = iMediaPlayer$OnTimedTextListener;
    }

    public final void setOnVideoDecoderErrorListener(IMediaPlayer$OnVideoDecoderErrorListener iMediaPlayer$OnVideoDecoderErrorListener) {
        this.mOnVideoDecoderErrorListener = iMediaPlayer$OnVideoDecoderErrorListener;
    }

    public final void setOnVideoSizeChangedListener(IMediaPlayer$OnVideoSizeChangedListener iMediaPlayer$OnVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = iMediaPlayer$OnVideoSizeChangedListener;
    }
}

