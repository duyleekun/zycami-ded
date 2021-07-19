/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.PopupWindow$OnDismissListener
 */
package com.google.android.exoplayer2.ui;

import android.view.View;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$Events;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$1;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.ui.TimeBar$OnScrubListener;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.Formatter;

public final class StyledPlayerControlView$ComponentListener
implements Player$EventListener,
TimeBar$OnScrubListener,
View.OnClickListener,
PopupWindow.OnDismissListener {
    public final /* synthetic */ StyledPlayerControlView this$0;

    private StyledPlayerControlView$ComponentListener(StyledPlayerControlView styledPlayerControlView) {
        this.this$0 = styledPlayerControlView;
    }

    public /* synthetic */ StyledPlayerControlView$ComponentListener(StyledPlayerControlView styledPlayerControlView, StyledPlayerControlView$1 styledPlayerControlView$1) {
        this(styledPlayerControlView);
    }

    public void onClick(View object) {
        Object object2 = StyledPlayerControlView.access$800(this.this$0);
        if (object2 == null) {
            return;
        }
        StyledPlayerControlView.access$700(this.this$0).resetHideCallbacks();
        View view = StyledPlayerControlView.access$1900(this.this$0);
        if (view == object) {
            object = StyledPlayerControlView.access$2000(this.this$0);
            object.dispatchNext((Player)object2);
        } else {
            view = StyledPlayerControlView.access$2100(this.this$0);
            if (view == object) {
                object = StyledPlayerControlView.access$2000(this.this$0);
                object.dispatchPrevious((Player)object2);
            } else {
                view = StyledPlayerControlView.access$2200(this.this$0);
                if (view == object) {
                    int n10;
                    int n11 = object2.getPlaybackState();
                    if (n11 != (n10 = 4)) {
                        object = StyledPlayerControlView.access$2000(this.this$0);
                        object.dispatchFastForward((Player)object2);
                    }
                } else {
                    view = StyledPlayerControlView.access$2300(this.this$0);
                    if (view == object) {
                        object = StyledPlayerControlView.access$2000(this.this$0);
                        object.dispatchRewind((Player)object2);
                    } else {
                        view = StyledPlayerControlView.access$2400(this.this$0);
                        if (view == object) {
                            object = this.this$0;
                            StyledPlayerControlView.access$2500((StyledPlayerControlView)((Object)object), (Player)object2);
                        } else {
                            view = StyledPlayerControlView.access$2600(this.this$0);
                            if (view == object) {
                                object = StyledPlayerControlView.access$2000(this.this$0);
                                int n12 = object2.getRepeatMode();
                                StyledPlayerControlView styledPlayerControlView = this.this$0;
                                int n13 = StyledPlayerControlView.access$2700(styledPlayerControlView);
                                n12 = RepeatModeUtil.getNextRepeatMode(n12, n13);
                                object.dispatchSetRepeatMode((Player)object2, n12);
                            } else {
                                view = StyledPlayerControlView.access$2800(this.this$0);
                                if (view == object) {
                                    object = StyledPlayerControlView.access$2000(this.this$0);
                                    boolean bl2 = object2.getShuffleModeEnabled() ^ true;
                                    object.dispatchSetShuffleModeEnabled((Player)object2, bl2);
                                } else {
                                    object2 = StyledPlayerControlView.access$2900(this.this$0);
                                    if (object2 == object) {
                                        StyledPlayerControlView.access$700(this.this$0).removeHideCallbacks();
                                        object = this.this$0;
                                        object2 = StyledPlayerControlView.access$3000((StyledPlayerControlView)((Object)object));
                                        StyledPlayerControlView.access$3100((StyledPlayerControlView)((Object)object), (RecyclerView$Adapter)object2);
                                    } else {
                                        object2 = StyledPlayerControlView.access$3200(this.this$0);
                                        if (object2 == object) {
                                            StyledPlayerControlView.access$700(this.this$0).removeHideCallbacks();
                                            object = this.this$0;
                                            object2 = StyledPlayerControlView.access$3300((StyledPlayerControlView)((Object)object));
                                            StyledPlayerControlView.access$3100((StyledPlayerControlView)((Object)object), (RecyclerView$Adapter)object2);
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

    public void onDismiss() {
        Object object = this.this$0;
        boolean bl2 = StyledPlayerControlView.access$1800(object);
        if (bl2) {
            object = StyledPlayerControlView.access$700(this.this$0);
            ((StyledPlayerControlViewLayoutManager)object).resetHideCallbacks();
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
            StyledPlayerControlView.access$1000((StyledPlayerControlView)((Object)object2));
        }
        Object object3 = object2 = new int[3];
        object2[0] = 5;
        object3[1] = 6;
        object3[2] = 8;
        bl2 = player$Events.containsAny((int)object2);
        if (bl2) {
            object2 = (Object)this.this$0;
            StyledPlayerControlView.access$1100((StyledPlayerControlView)((Object)object2));
        }
        if (bl2 = player$Events.contains(9)) {
            object2 = (Object)this.this$0;
            StyledPlayerControlView.access$1200((StyledPlayerControlView)((Object)object2));
        }
        if (bl2 = player$Events.contains(10)) {
            object2 = (Object)this.this$0;
            StyledPlayerControlView.access$1300((StyledPlayerControlView)((Object)object2));
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
            StyledPlayerControlView.access$1400((StyledPlayerControlView)((Object)object2));
        }
        object2 = new int[n10];
        object2[0] = 12;
        object2[1] = 0;
        bl2 = player$Events.containsAny((int)object2);
        if (bl2) {
            object2 = (Object)this.this$0;
            StyledPlayerControlView.access$1500((StyledPlayerControlView)((Object)object2));
        }
        if (bl2 = player$Events.contains(13)) {
            object2 = (Object)this.this$0;
            StyledPlayerControlView.access$1600((StyledPlayerControlView)((Object)object2));
        }
        if ((n10 = (int)(player$Events.contains(n10) ? 1 : 0)) != 0) {
            object = this.this$0;
            StyledPlayerControlView.access$1700((StyledPlayerControlView)((Object)object));
        }
    }

    public void onScrubMove(TimeBar timeBar, long l10) {
        timeBar = StyledPlayerControlView.access$400(this.this$0);
        if (timeBar != null) {
            timeBar = StyledPlayerControlView.access$400(this.this$0);
            StringBuilder stringBuilder = StyledPlayerControlView.access$500(this.this$0);
            Formatter formatter = StyledPlayerControlView.access$600(this.this$0);
            String string2 = Util.getStringForTime(stringBuilder, formatter, l10);
            timeBar.setText(string2);
        }
    }

    public void onScrubStart(TimeBar object, long l10) {
        object = this.this$0;
        boolean bl2 = true;
        StyledPlayerControlView.access$302((StyledPlayerControlView)((Object)object), bl2);
        object = StyledPlayerControlView.access$400(this.this$0);
        if (object != null) {
            object = StyledPlayerControlView.access$400(this.this$0);
            StringBuilder stringBuilder = StyledPlayerControlView.access$500(this.this$0);
            Formatter formatter = StyledPlayerControlView.access$600(this.this$0);
            String string2 = Util.getStringForTime(stringBuilder, formatter, l10);
            object.setText(string2);
        }
        StyledPlayerControlView.access$700(this.this$0).removeHideCallbacks();
    }

    public void onScrubStop(TimeBar object, long l10, boolean bl2) {
        object = this.this$0;
        StyledPlayerControlView.access$302((StyledPlayerControlView)((Object)object), false);
        if (!bl2 && (object = StyledPlayerControlView.access$800(this.this$0)) != null) {
            object = this.this$0;
            Player player = StyledPlayerControlView.access$800((StyledPlayerControlView)((Object)object));
            StyledPlayerControlView.access$900((StyledPlayerControlView)((Object)object), player, l10);
        }
        StyledPlayerControlView.access$700(this.this$0).resetHideCallbacks();
    }
}

