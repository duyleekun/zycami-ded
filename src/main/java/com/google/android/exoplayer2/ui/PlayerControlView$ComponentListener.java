/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.exoplayer2.ui;

import android.view.View;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$Events;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerControlView$1;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.ui.TimeBar$OnScrubListener;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.Formatter;

public final class PlayerControlView$ComponentListener
implements Player$EventListener,
TimeBar$OnScrubListener,
View.OnClickListener {
    public final /* synthetic */ PlayerControlView this$0;

    private PlayerControlView$ComponentListener(PlayerControlView playerControlView) {
        this.this$0 = playerControlView;
    }

    public /* synthetic */ PlayerControlView$ComponentListener(PlayerControlView playerControlView, PlayerControlView$1 playerControlView$1) {
        this(playerControlView);
    }

    public void onClick(View object) {
        Player player = PlayerControlView.access$500(this.this$0);
        if (player == null) {
            return;
        }
        View view = PlayerControlView.access$1300(this.this$0);
        if (view == object) {
            object = PlayerControlView.access$1400(this.this$0);
            object.dispatchNext(player);
        } else {
            view = PlayerControlView.access$1500(this.this$0);
            if (view == object) {
                object = PlayerControlView.access$1400(this.this$0);
                object.dispatchPrevious(player);
            } else {
                view = PlayerControlView.access$1600(this.this$0);
                if (view == object) {
                    int n10;
                    int n11 = player.getPlaybackState();
                    if (n11 != (n10 = 4)) {
                        object = PlayerControlView.access$1400(this.this$0);
                        object.dispatchFastForward(player);
                    }
                } else {
                    view = PlayerControlView.access$1700(this.this$0);
                    if (view == object) {
                        object = PlayerControlView.access$1400(this.this$0);
                        object.dispatchRewind(player);
                    } else {
                        view = PlayerControlView.access$1800(this.this$0);
                        if (view == object) {
                            object = this.this$0;
                            PlayerControlView.access$1900((PlayerControlView)((Object)object), player);
                        } else {
                            view = PlayerControlView.access$2000(this.this$0);
                            if (view == object) {
                                object = this.this$0;
                                PlayerControlView.access$2100((PlayerControlView)((Object)object), player);
                            } else {
                                view = PlayerControlView.access$2200(this.this$0);
                                if (view == object) {
                                    object = PlayerControlView.access$1400(this.this$0);
                                    int n12 = player.getRepeatMode();
                                    PlayerControlView playerControlView = this.this$0;
                                    int n13 = PlayerControlView.access$2300(playerControlView);
                                    n12 = RepeatModeUtil.getNextRepeatMode(n12, n13);
                                    object.dispatchSetRepeatMode(player, n12);
                                } else {
                                    view = PlayerControlView.access$2400(this.this$0);
                                    if (view == object) {
                                        object = PlayerControlView.access$1400(this.this$0);
                                        boolean bl2 = player.getShuffleModeEnabled() ^ true;
                                        object.dispatchSetShuffleModeEnabled(player, bl2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void onEvents(Player object, Player$Events player$Events) {
        int n10 = 2;
        Object object2 = new int[n10];
        object2[0] = 5;
        object2[1] = 6;
        boolean bl2 = player$Events.containsAny((int)object2);
        if (bl2) {
            object2 = (Object)this.this$0;
            PlayerControlView.access$700((PlayerControlView)((Object)object2));
        }
        Object object3 = object2 = new int[3];
        object2[0] = 5;
        object3[1] = 6;
        object3[2] = 8;
        bl2 = player$Events.containsAny((int)object2);
        if (bl2) {
            object2 = (Object)this.this$0;
            PlayerControlView.access$800((PlayerControlView)((Object)object2));
        }
        if (bl2 = player$Events.contains(9)) {
            object2 = (Object)this.this$0;
            PlayerControlView.access$900((PlayerControlView)((Object)object2));
        }
        if (bl2 = player$Events.contains(10)) {
            object2 = (Object)this.this$0;
            PlayerControlView.access$1000((PlayerControlView)((Object)object2));
        }
        Object object4 = object2 = new int[4];
        Object object5 = object2;
        object4[0] = 9;
        object5[1] = 10;
        object4[2] = 12;
        object5[3] = 0;
        bl2 = player$Events.containsAny((int)object2);
        if (bl2) {
            object2 = (Object)this.this$0;
            PlayerControlView.access$1100((PlayerControlView)((Object)object2));
        }
        Object object6 = object = (Object)new int[n10];
        object6[0] = 12;
        object6[1] = false;
        n10 = (int)(player$Events.containsAny((int[])object) ? 1 : 0);
        if (n10 != 0) {
            object = this.this$0;
            PlayerControlView.access$1200((PlayerControlView)((Object)object));
        }
    }

    public void onScrubMove(TimeBar timeBar, long l10) {
        timeBar = PlayerControlView.access$200(this.this$0);
        if (timeBar != null) {
            timeBar = PlayerControlView.access$200(this.this$0);
            StringBuilder stringBuilder = PlayerControlView.access$300(this.this$0);
            Formatter formatter = PlayerControlView.access$400(this.this$0);
            String string2 = Util.getStringForTime(stringBuilder, formatter, l10);
            timeBar.setText(string2);
        }
    }

    public void onScrubStart(TimeBar object, long l10) {
        object = this.this$0;
        boolean bl2 = true;
        PlayerControlView.access$102((PlayerControlView)((Object)object), bl2);
        object = PlayerControlView.access$200(this.this$0);
        if (object != null) {
            object = PlayerControlView.access$200(this.this$0);
            StringBuilder stringBuilder = PlayerControlView.access$300(this.this$0);
            Formatter formatter = PlayerControlView.access$400(this.this$0);
            String string2 = Util.getStringForTime(stringBuilder, formatter, l10);
            object.setText(string2);
        }
    }

    public void onScrubStop(TimeBar object, long l10, boolean bl2) {
        object = this.this$0;
        PlayerControlView.access$102((PlayerControlView)((Object)object), false);
        if (!bl2 && (object = PlayerControlView.access$500(this.this$0)) != null) {
            object = this.this$0;
            Player player = PlayerControlView.access$500((PlayerControlView)((Object)object));
            PlayerControlView.access$600((PlayerControlView)((Object)object), player, l10);
        }
    }
}

