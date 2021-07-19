/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.exoplayer2.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$1;

public class PlayerNotificationManager$NotificationBroadcastReceiver
extends BroadcastReceiver {
    public final /* synthetic */ PlayerNotificationManager this$0;

    private PlayerNotificationManager$NotificationBroadcastReceiver(PlayerNotificationManager playerNotificationManager) {
        this.this$0 = playerNotificationManager;
    }

    public /* synthetic */ PlayerNotificationManager$NotificationBroadcastReceiver(PlayerNotificationManager playerNotificationManager, PlayerNotificationManager$1 playerNotificationManager$1) {
        this(playerNotificationManager);
    }

    public void onReceive(Context object, Intent object2) {
        Object object3;
        int n10;
        object = PlayerNotificationManager.access$500(this.this$0);
        if (object != null && (n10 = PlayerNotificationManager.access$600((PlayerNotificationManager)(object3 = this.this$0))) != 0) {
            Object object4;
            int n11;
            object3 = this.this$0;
            n10 = PlayerNotificationManager.access$700((PlayerNotificationManager)object3);
            if ((n10 = object2.getIntExtra("INSTANCE_ID", n10)) == (n11 = PlayerNotificationManager.access$700((PlayerNotificationManager)(object4 = this.this$0)))) {
                object3 = object2.getAction();
                object4 = "com.google.android.exoplayer.play";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                int n12 = 1;
                if (n11 != 0) {
                    int n13 = object.getPlaybackState();
                    if (n13 == n12) {
                        object2 = PlayerNotificationManager.access$800(this.this$0);
                        if (object2 != null) {
                            object2 = PlayerNotificationManager.access$800(this.this$0);
                            object2.preparePlayback();
                        } else {
                            object2 = PlayerNotificationManager.access$900(this.this$0);
                            object2.dispatchPrepare((Player)object);
                        }
                    } else {
                        n13 = object.getPlaybackState();
                        if (n13 == (n10 = 4)) {
                            object2 = PlayerNotificationManager.access$900(this.this$0);
                            n10 = object.getCurrentWindowIndex();
                            long l10 = -9223372036854775807L;
                            object2.dispatchSeekTo((Player)object, n10, l10);
                        }
                    }
                    object2 = PlayerNotificationManager.access$900(this.this$0);
                    object2.dispatchSetPlayWhenReady((Player)object, n12 != 0);
                } else {
                    object4 = "com.google.android.exoplayer.pause";
                    n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                    if (n11 != 0) {
                        object2 = PlayerNotificationManager.access$900(this.this$0);
                        n10 = 0;
                        object3 = null;
                        object2.dispatchSetPlayWhenReady((Player)object, false);
                    } else {
                        object4 = "com.google.android.exoplayer.prev";
                        n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                        if (n11 != 0) {
                            object2 = PlayerNotificationManager.access$900(this.this$0);
                            object2.dispatchPrevious((Player)object);
                        } else {
                            object4 = "com.google.android.exoplayer.rewind";
                            n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                            if (n11 != 0) {
                                object2 = PlayerNotificationManager.access$900(this.this$0);
                                object2.dispatchRewind((Player)object);
                            } else {
                                object4 = "com.google.android.exoplayer.ffwd";
                                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                                if (n11 != 0) {
                                    object2 = PlayerNotificationManager.access$900(this.this$0);
                                    object2.dispatchFastForward((Player)object);
                                } else {
                                    object4 = "com.google.android.exoplayer.next";
                                    n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                                    if (n11 != 0) {
                                        object2 = PlayerNotificationManager.access$900(this.this$0);
                                        object2.dispatchNext((Player)object);
                                    } else {
                                        object4 = "com.google.android.exoplayer.stop";
                                        n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                                        if (n11 != 0) {
                                            object2 = PlayerNotificationManager.access$900(this.this$0);
                                            object2.dispatchStop((Player)object, n12 != 0);
                                        } else {
                                            object4 = "com.google.android.exoplayer.dismiss";
                                            n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                                            if (n11 != 0) {
                                                object = this.this$0;
                                                PlayerNotificationManager.access$1000((PlayerNotificationManager)object, n12 != 0);
                                            } else if (object3 != null && (object4 = PlayerNotificationManager.access$1100(this.this$0)) != null && (n11 = (int)((object4 = PlayerNotificationManager.access$1200(this.this$0)).containsKey(object3) ? 1 : 0)) != 0) {
                                                object4 = PlayerNotificationManager.access$1100(this.this$0);
                                                object4.onCustomAction((Player)object, (String)object3, (Intent)object2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

