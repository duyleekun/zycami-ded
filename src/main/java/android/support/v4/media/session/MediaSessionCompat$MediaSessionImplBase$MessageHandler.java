/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.util.Log
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.MediaSessionManager$RemoteUserInfo;

public class MediaSessionCompat$MediaSessionImplBase$MessageHandler
extends Handler {
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    private static final int MSG_ADD_QUEUE_ITEM = 25;
    private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
    private static final int MSG_ADJUST_VOLUME = 2;
    private static final int MSG_COMMAND = 1;
    private static final int MSG_CUSTOM_ACTION = 20;
    private static final int MSG_FAST_FORWARD = 16;
    private static final int MSG_MEDIA_BUTTON = 21;
    private static final int MSG_NEXT = 14;
    private static final int MSG_PAUSE = 12;
    private static final int MSG_PLAY = 7;
    private static final int MSG_PLAY_MEDIA_ID = 8;
    private static final int MSG_PLAY_SEARCH = 9;
    private static final int MSG_PLAY_URI = 10;
    private static final int MSG_PREPARE = 3;
    private static final int MSG_PREPARE_MEDIA_ID = 4;
    private static final int MSG_PREPARE_SEARCH = 5;
    private static final int MSG_PREPARE_URI = 6;
    private static final int MSG_PREVIOUS = 15;
    private static final int MSG_RATE = 19;
    private static final int MSG_RATE_EXTRA = 31;
    private static final int MSG_REMOVE_QUEUE_ITEM = 27;
    private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
    private static final int MSG_REWIND = 17;
    private static final int MSG_SEEK_TO = 18;
    private static final int MSG_SET_CAPTIONING_ENABLED = 29;
    private static final int MSG_SET_PLAYBACK_SPEED = 32;
    private static final int MSG_SET_REPEAT_MODE = 23;
    private static final int MSG_SET_SHUFFLE_MODE = 30;
    private static final int MSG_SET_VOLUME = 22;
    private static final int MSG_SKIP_TO_ITEM = 11;
    private static final int MSG_STOP = 13;
    public final /* synthetic */ MediaSessionCompat$MediaSessionImplBase this$0;

    public MediaSessionCompat$MediaSessionImplBase$MessageHandler(MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase, Looper looper) {
        this.this$0 = mediaSessionCompat$MediaSessionImplBase;
        super(looper);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void onMediaButtonEvent(KeyEvent var1_1, MediaSessionCompat$Callback var2_2) {
        block8: {
            if (var1_1 /* !! */  == null || (var3_3 = var1_1 /* !! */ .getAction()) != 0) break block8;
            var4_4 = this.this$0.mState;
            var5_5 = 0L;
            var7_6 = var4_4 == null ? var5_5 : var4_4.getActions();
            var9_7 = var1_1 /* !! */ .getKeyCode();
            if (var9_7 == (var3_3 = 79)) ** GOTO lbl-1000
            var3_3 = 126;
            if (var9_7 == var3_3) ** GOTO lbl55
            var3_3 = 127;
            if (var9_7 == var3_3) ** GOTO lbl49
            switch (var9_7) {
                default: {
                    break;
                }
                case 90: {
                    var10_8 = 64;
                    cfr_temp_0 = (var7_6 &= var10_8) - var5_5;
                    var9_7 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                    if (var9_7 == 0) break;
                    var2_2.onFastForward();
                    break;
                }
                case 89: {
                    var10_9 = 8;
                    cfr_temp_1 = (var7_6 &= var10_9) - var5_5;
                    var9_7 = cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
                    if (var9_7 == 0) break;
                    var2_2.onRewind();
                    break;
                }
                case 88: {
                    var10_10 = 16;
                    cfr_temp_2 = (var7_6 &= var10_10) - var5_5;
                    var9_7 = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
                    if (var9_7 == 0) break;
                    var2_2.onSkipToPrevious();
                    break;
                }
                case 87: {
                    var10_11 = 32;
                    cfr_temp_3 = (var7_6 &= var10_11) - var5_5;
                    var9_7 = cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1);
                    if (var9_7 == 0) break;
                    var2_2.onSkipToNext();
                    break;
                }
                case 86: {
                    var10_12 = 1L;
                    cfr_temp_4 = (var7_6 &= var10_12) - var5_5;
                    var9_7 = cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1);
                    if (var9_7 == 0) break;
                    var2_2.onStop();
                    break;
                }
lbl49:
                // 1 sources

                var10_13 = 2;
                cfr_temp_5 = (var7_6 &= var10_13) - var5_5;
                var9_7 = cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1);
                if (var9_7 == 0) break;
                var2_2.onPause();
                break;
lbl55:
                // 1 sources

                var10_14 = 4;
                cfr_temp_6 = (var7_6 &= var10_14) - var5_5;
                var9_7 = cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1);
                if (var9_7 == 0) break;
                var2_2.onPlay();
                break;
                case 85: lbl-1000:
                // 2 sources

                {
                    var1_1 /* !! */  = "MediaSessionCompat";
                    var2_2 = "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already";
                    Log.w((String)var1_1 /* !! */ , (String)var2_2);
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message var1_1) {
        var2_3 = this.this$0.mCallback;
        if (var2_3 == null) {
            return;
        }
        var3_4 = var1_1 /* !! */ .getData();
        MediaSessionCompat.ensureClassLoader((Bundle)var3_4);
        var4_5 = this.this$0;
        var6_7 = var3_4.getString("data_calling_pkg");
        var7_8 = "data_calling_pid";
        var8_9 = var3_4.getInt(var7_8);
        var9_10 = "data_calling_uid";
        var10_11 = var3_4.getInt(var9_10);
        var5_6 = new MediaSessionManager$RemoteUserInfo(var6_7, var8_9, var10_11);
        var4_5.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo)var5_6);
        var3_4 = var3_4.getBundle("data_extras");
        MediaSessionCompat.ensureClassLoader((Bundle)var3_4);
        var4_5 = null;
        var11_12 = var1_1 /* !! */ .what;
        var6_7 = null;
        switch (var11_12) {
            default: {
                return;
            }
            case 32: {
                ** try [egrp 1[TRYBLOCK] [1 : 255->906)] { 
lbl28:
                // 1 sources

                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (Float)var1_1 /* !! */ ;
                var12_13 = var1_1 /* !! */ .floatValue();
                var2_3.onSetPlaybackSpeed(var12_13);
                return;
            }
            case 31: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (RatingCompat)var1_1 /* !! */ ;
                var2_3.onSetRating((RatingCompat)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 30: {
                var13_15 = var1_1 /* !! */ .arg1;
                var2_3.onSetShuffleMode(var13_15);
                return;
            }
            case 29: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (Boolean)var1_1 /* !! */ ;
                var13_16 = var1_1 /* !! */ .booleanValue();
                var2_3.onSetCaptioningEnabled(var13_16);
                return;
            }
            case 28: {
                var3_4 = this.this$0;
                var3_4 = var3_4.mQueue;
                if (var3_4 == null) return;
                var11_12 = var1_1 /* !! */ .arg1;
                if (var11_12 >= 0 && var11_12 < (var14_23 = var3_4.size())) {
                    var3_4 = this.this$0;
                    var3_4 = var3_4.mQueue;
                    var13_17 = var1_1 /* !! */ .arg1;
                    var1_1 /* !! */  = var3_4.get(var13_17);
                    var1_1 /* !! */  = (MediaSessionCompat$QueueItem)var1_1 /* !! */ ;
                } else {
                    var13_18 = false;
                    var1_1 /* !! */  = null;
                    var12_14 = 0.0f;
                }
                if (var1_1 /* !! */  == null) return;
                var1_1 /* !! */  = var1_1 /* !! */ .getDescription();
                var2_3.onRemoveQueueItem((MediaDescriptionCompat)var1_1 /* !! */ );
                return;
            }
            case 27: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (MediaDescriptionCompat)var1_1 /* !! */ ;
                var2_3.onRemoveQueueItem((MediaDescriptionCompat)var1_1 /* !! */ );
                return;
            }
            case 26: {
                var3_4 = var1_1 /* !! */ .obj;
                var3_4 = (MediaDescriptionCompat)var3_4;
                var13_19 = var1_1 /* !! */ .arg1;
                var2_3.onAddQueueItem((MediaDescriptionCompat)var3_4, var13_19);
                return;
            }
            case 25: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (MediaDescriptionCompat)var1_1 /* !! */ ;
                var2_3.onAddQueueItem((MediaDescriptionCompat)var1_1 /* !! */ );
                return;
            }
            case 23: {
                var13_20 = var1_1 /* !! */ .arg1;
                var2_3.onSetRepeatMode(var13_20);
                return;
            }
            case 22: {
                var2_3 = this.this$0;
                var13_21 = var1_1 /* !! */ .arg1;
                var2_3.setVolumeTo(var13_21, 0);
                return;
            }
            case 21: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (KeyEvent)var1_1 /* !! */ ;
                var5_6 = "android.intent.action.MEDIA_BUTTON";
                var3_4 = new Intent((String)var5_6);
                var5_6 = "android.intent.extra.KEY_EVENT";
                var3_4.putExtra((String)var5_6, (Parcelable)var1_1 /* !! */ );
                var14_24 = var2_3.onMediaButtonEvent((Intent)var3_4);
                if (var14_24 != false) return;
                this.onMediaButtonEvent((KeyEvent)var1_1 /* !! */ , (MediaSessionCompat$Callback)var2_3);
                return;
            }
            case 20: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (String)var1_1 /* !! */ ;
                var2_3.onCustomAction((String)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 19: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (RatingCompat)var1_1 /* !! */ ;
                var2_3.onSetRating((RatingCompat)var1_1 /* !! */ );
                return;
            }
            case 18: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (Long)var1_1 /* !! */ ;
                var15_25 = var1_1 /* !! */ .longValue();
                var2_3.onSeekTo(var15_25);
                return;
            }
            case 17: {
                var2_3.onRewind();
                return;
            }
            case 16: {
                var2_3.onFastForward();
                return;
            }
            case 15: {
                var2_3.onSkipToPrevious();
                return;
            }
            case 14: {
                var2_3.onSkipToNext();
                return;
            }
            case 13: {
                var2_3.onStop();
                return;
            }
            case 12: {
                var2_3.onPause();
                return;
            }
            case 11: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (Long)var1_1 /* !! */ ;
                var15_26 = var1_1 /* !! */ .longValue();
                var2_3.onSkipToQueueItem(var15_26);
                return;
            }
            case 10: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (Uri)var1_1 /* !! */ ;
                var2_3.onPlayFromUri((Uri)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 9: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (String)var1_1 /* !! */ ;
                var2_3.onPlayFromSearch((String)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 8: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (String)var1_1 /* !! */ ;
                var2_3.onPlayFromMediaId((String)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 7: {
                var2_3.onPlay();
                return;
            }
            case 6: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (Uri)var1_1 /* !! */ ;
                var2_3.onPrepareFromUri((Uri)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 5: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (String)var1_1 /* !! */ ;
                var2_3.onPrepareFromSearch((String)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 4: {
                var1_1 /* !! */  = var1_1 /* !! */ .obj;
                var1_1 /* !! */  = (String)var1_1 /* !! */ ;
                var2_3.onPrepareFromMediaId((String)var1_1 /* !! */ , (Bundle)var3_4);
                return;
            }
            case 3: {
                var2_3.onPrepare();
                return;
            }
            case 2: {
                var2_3 = this.this$0;
                var13_22 = var1_1 /* !! */ .arg1;
                var2_3.adjustVolume(var13_22, 0);
                return;
            }
            case 1: 
        }
        var1_1 /* !! */  = var1_1 /* !! */ .obj;
        var1_1 /* !! */  = (MediaSessionCompat$MediaSessionImplBase$Command)var1_1 /* !! */ ;
        var3_4 = var1_1 /* !! */ .command;
        var5_6 = var1_1 /* !! */ .extras;
        var1_1 /* !! */  = var1_1 /* !! */ .stub;
        var2_3.onCommand((String)var3_4, (Bundle)var5_6, (ResultReceiver)var1_1 /* !! */ );
        return;
lbl193:
        // 1 sources

        finally {
            this.this$0.setCurrentControllerInfo(null);
        }
    }
}

