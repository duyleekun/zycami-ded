/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction$Builder {
    private final String mAction;
    private Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;

    public PlaybackStateCompat$CustomAction$Builder(String object, CharSequence charSequence, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            bl2 = TextUtils.isEmpty((CharSequence)charSequence);
            if (!bl2) {
                if (n10 != 0) {
                    this.mAction = object;
                    this.mName = charSequence;
                    this.mIcon = n10;
                    return;
                }
                object = new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                throw object;
            }
            object = new IllegalArgumentException("You must specify a name to build a CustomAction");
            throw object;
        }
        object = new IllegalArgumentException("You must specify an action to build a CustomAction");
        throw object;
    }

    public PlaybackStateCompat$CustomAction build() {
        String string2 = this.mAction;
        CharSequence charSequence = this.mName;
        int n10 = this.mIcon;
        Bundle bundle = this.mExtras;
        PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction = new PlaybackStateCompat$CustomAction(string2, charSequence, n10, bundle);
        return playbackStateCompat$CustomAction;
    }

    public PlaybackStateCompat$CustomAction$Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }
}

