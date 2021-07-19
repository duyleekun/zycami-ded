/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecList
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.tencent.ijk.media.player;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.ijk.media.player.IjkMediaPlayer$OnMediaCodecSelectListener;
import java.util.ArrayList;
import java.util.Locale;

public class IjkMediaPlayer$DefaultMediaCodecSelector
implements IjkMediaPlayer$OnMediaCodecSelectListener {
    public static final IjkMediaPlayer$DefaultMediaCodecSelector sInstance;

    static {
        IjkMediaPlayer$DefaultMediaCodecSelector ijkMediaPlayer$DefaultMediaCodecSelector;
        sInstance = ijkMediaPlayer$DefaultMediaCodecSelector = new IjkMediaPlayer$DefaultMediaCodecSelector();
    }

    public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String string2, int n10, int n11) {
        int n12;
        Object object = string2;
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 0;
        Object object2 = null;
        int n15 = 16;
        if (n13 < n15) {
            return null;
        }
        n13 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n13 != 0) {
            return null;
        }
        Object object3 = IjkMediaPlayer.access$200();
        Object[] objectArray = Locale.US;
        Object object4 = new Object[3];
        object4[0] = string2;
        Object object5 = n10;
        int n16 = 1;
        object4[n16] = object5;
        object5 = n11;
        int n17 = 2;
        object4[n17] = object5;
        object5 = "onSelectCodec: mime=%s, profile=%d, level=%d";
        objectArray = String.format((Locale)objectArray, (String)object5, object4);
        Log.i((String)object3, (String)objectArray);
        object3 = new ArrayList();
        n15 = MediaCodecList.getCodecCount();
        object4 = null;
        for (n12 = 0; n12 < n15; ++n12) {
            object5 = MediaCodecList.getCodecInfoAt((int)n12);
            String[] stringArray = IjkMediaPlayer.access$200();
            Object object6 = Locale.US;
            Object[] objectArray2 = new Object[n16];
            String string3 = object5.getName();
            objectArray2[0] = string3;
            string3 = "  found codec: %s";
            object6 = String.format((Locale)object6, string3, objectArray2);
            Log.d((String)stringArray, (String)object6);
            boolean bl2 = object5.isEncoder();
            if (!bl2 && (stringArray = object5.getSupportedTypes()) != null) {
                int n18 = stringArray.length;
                objectArray2 = null;
                for (int i10 = 0; i10 < n18; ++i10) {
                    string3 = stringArray[i10];
                    boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
                    if (!bl3) {
                        Object object7 = IjkMediaPlayer.access$200();
                        Locale locale = Locale.US;
                        Object object8 = new Object[n16];
                        object8[0] = string3;
                        object2 = String.format(locale, "    mime: %s", object8);
                        Log.d((String)object7, (String)object2);
                        n14 = (int)(string3.equalsIgnoreCase((String)object) ? 1 : 0);
                        if (n14 != 0 && (object2 = IjkMediaCodecInfo.setupCandidate((MediaCodecInfo)object5, (String)object)) != null) {
                            ((ArrayList)object3).add(object2);
                            string3 = IjkMediaPlayer.access$200();
                            object7 = new Object[n17];
                            object7[0] = object8 = object5.getName();
                            int n19 = ((IjkMediaCodecInfo)object2).mRank;
                            object7[n16] = object8 = Integer.valueOf(n19);
                            object8 = "candidate codec: %s rank=%d";
                            object7 = String.format(locale, (String)object8, object7);
                            Log.i((String)string3, (String)object7);
                            ((IjkMediaCodecInfo)object2).dumpProfileLevels((String)object);
                        }
                    }
                    n14 = 0;
                    object2 = null;
                }
            }
            n14 = 0;
            object2 = null;
        }
        boolean bl4 = ((ArrayList)object3).isEmpty();
        if (bl4) {
            return null;
        }
        object = (IjkMediaCodecInfo)((ArrayList)object3).get(0);
        object3 = ((ArrayList)object3).iterator();
        while ((n14 = object3.hasNext()) != 0) {
            object2 = (IjkMediaCodecInfo)object3.next();
            n15 = ((IjkMediaCodecInfo)object2).mRank;
            n12 = ((IjkMediaCodecInfo)object).mRank;
            if (n15 <= n12) continue;
            object = object2;
        }
        n13 = ((IjkMediaCodecInfo)object).mRank;
        n14 = 600;
        if (n13 < n14) {
            object3 = IjkMediaPlayer.access$200();
            object2 = Locale.US;
            objectArray = new Object[n16];
            objectArray[0] = object = ((IjkMediaCodecInfo)object).mCodecInfo.getName();
            object = String.format((Locale)object2, "unaccetable codec: %s", objectArray);
            Log.w((String)object3, (String)object);
            return null;
        }
        object3 = IjkMediaPlayer.access$200();
        object2 = Locale.US;
        objectArray = new Object[n17];
        objectArray[0] = object4 = ((IjkMediaCodecInfo)object).mCodecInfo.getName();
        objectArray[n16] = object4 = Integer.valueOf(((IjkMediaCodecInfo)object).mRank);
        object2 = String.format((Locale)object2, "selected codec: %s rank=%d", objectArray);
        Log.i((String)object3, (String)object2);
        return ((IjkMediaCodecInfo)object).mCodecInfo.getName();
    }
}

