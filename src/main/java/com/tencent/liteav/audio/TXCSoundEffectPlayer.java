/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.tencent.liteav.audio;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.liteav.audio.TXAudioEffectManager$AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXCSoundEffectPlayer$a;
import com.tencent.liteav.audio.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.d;
import com.tencent.liteav.basic.util.g;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TXCSoundEffectPlayer
implements TXAudioEffectManager$TXMusicPlayObserver {
    private static final String TAG = "AudioCenter:TXCSoundEffectPlayer";
    private static WeakReference mWeakSoundEffectListener;
    private List mShortEffectorIDList;

    static {
        g.f();
    }

    public TXCSoundEffectPlayer() {
        ArrayList arrayList;
        this.mShortEffectorIDList = arrayList = new ArrayList();
    }

    /*
     * Unable to fully structure code
     */
    private String checkIfAssetsFile(String var1_1) {
        block38: {
            block37: {
                block36: {
                    var2_2 = "AudioCenter:TXCSoundEffectPlayer";
                    var3_3 = TextUtils.isEmpty((CharSequence)var1_1);
                    if (var3_3 != 0 || (var4_4 = TXCCommonUtil.getAppContext()) == null) break block38;
                    var4_4 = "/assets/";
                    var3_3 = var1_1.startsWith((String)var4_4);
                    if (var3_3 == 0) {
                        return var1_1;
                    }
                    var3_3 = 8;
                    var4_4 = var1_1.substring(var3_3);
                    var5_7 = TXCCommonUtil.getAppContext();
                    var5_7 = var5_7.getAssets();
                    var5_7 = var5_7.openFd((String)var4_4);
                    try {
                        var6_9 = var5_7.getLength();
                    }
                    catch (Exception var5_8) {
                        var8_10 = new StringBuilder();
                        var9_11 = "playAudioEffect openFd error ";
                        var8_10.append(var9_11);
                        var5_7 = var5_8.toString();
                        var8_10.append((String)var5_7);
                        var5_7 = var8_10.toString();
                        TXCLog.e(var2_2, (String)var5_7);
                        var6_9 = 0L;
                    }
                    var9_11 = this.getEffectCachePath();
                    var10_12 = new Comparable<File>(var9_11);
                    var11_13 = var10_12.exists();
                    if (var11_13 != 0) ** GOTO lbl44
                    var10_12.mkdirs();
                    ** GOTO lbl51
lbl44:
                    // 1 sources

                    var11_13 = var10_12.isFile();
                    if (var11_13 == 0) ** GOTO lbl51
                    var10_12.delete();
                    var10_12.mkdirs();
lbl51:
                    // 3 sources

                    var12_14 = File.separatorChar;
                    var12_14 = var4_4.lastIndexOf(var12_14);
                    var11_13 = -1;
                    var13_15 = "_";
                    if (var12_14 == var11_13) break block36;
                    var14_16 = new StringBuilder();
                    var14_16.append(var9_11);
                    var9_11 = File.separator;
                    var14_16.append(var9_11);
                    var14_16.append(var6_9);
                    var14_16.append(var13_15);
                    ++var12_14;
                    var5_7 = var4_4.substring(var12_14);
                    var14_16.append((String)var5_7);
                    var1_1 = var14_16.toString();
                    break block37;
                }
                var10_12 = new Comparable<File>();
                var10_12.append(var9_11);
                var9_11 = File.separator;
                var10_12.append(var9_11);
                var10_12.append(var6_9);
                var10_12.append(var13_15);
                var10_12.append((String)var4_4);
                var1_1 = var10_12.toString();
            }
            var15_17 = d.a(var1_1);
            if (var15_17) break block38;
            var5_7 = TXCCommonUtil.getAppContext();
            d.a((Context)var5_7, (String)var4_4, var1_1);
            {
                catch (Exception var4_5) {
                    var5_7 = new StringBuilder();
                    var8_10 = "playAudioEffect error ";
                    var5_7.append((String)var8_10);
                    var4_6 = var4_5.toString();
                    var5_7.append(var4_6);
                    var4_6 = var5_7.toString();
                    TXCLog.e(var2_2, var4_6);
                }
            }
        }
        return var1_1;
    }

    private String getEffectCachePath() {
        Object object = TXCCommonUtil.getAppContext();
        if (object == null) {
            return "";
        }
        object = new StringBuilder();
        Object object2 = TXCCommonUtil.getAppContext().getCacheDir();
        ((StringBuilder)object).append(object2);
        object2 = File.separator;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("liteav_effect");
        return ((StringBuilder)object).toString();
    }

    public static TXCSoundEffectPlayer getInstance() {
        return TXCSoundEffectPlayer$a.a();
    }

    public void clearCache() {
        block12: {
            Object object = TXCCommonUtil.getAppContext();
            if (object == null) {
                return;
            }
            CharSequence charSequence = this.getEffectCachePath();
            object = new File((String)charSequence);
            boolean n10 = ((File)object).exists();
            if (!n10) break block12;
            boolean bl2 = ((File)object).isDirectory();
            if (!bl2) break block12;
            long l10 = d.a((File)object);
            int n11 = 0x3200000;
            long l11 = n11;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 <= 0) break block12;
            object = ((File)object).listFiles();
            int n12 = ((Object)object).length;
            String string2 = null;
            for (int i10 = 0; i10 < n12; ++i10) {
                Object object2 = object[i10];
                try {
                    ((File)object2).delete();
                    continue;
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    string2 = "clearCache error ";
                    ((StringBuilder)charSequence).append(string2);
                    String string3 = exception.toString();
                    ((StringBuilder)charSequence).append(string3);
                    string3 = ((StringBuilder)charSequence).toString();
                    charSequence = TAG;
                    TXCLog.w((String)charSequence, string3);
                    break;
                }
            }
        }
    }

    public void onComplete(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onMusicPlayFinish -> effect id = ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        object = mWeakSoundEffectListener;
        if (object != null && (object = ((Reference)object).get()) != null) {
            object = (b)mWeakSoundEffectListener.get();
            object.a(n10);
        }
    }

    public void onPlayProgress(int n10, long l10, long l11) {
    }

    public void onStart(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onStart -> effect id = ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", errCode = ");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        object = mWeakSoundEffectListener;
        if (object != null && (object = ((Reference)object).get()) != null) {
            object = (b)mWeakSoundEffectListener.get();
            object.a(n10, n11);
        }
    }

    public void pauseEffectWithId(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("pauseEffectWithId -> effect id = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(n10);
    }

    public boolean playEffectWithId(int n10, String string2, boolean bl2, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("playEffectWithId -> effect id = ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", path = ");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", loop = ");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        String string3 = TAG;
        TXCLog.i(string3, (String)object);
        string2 = this.checkIfAssetsFile(string2);
        object = new TXAudioEffectManager$AudioMusicParam(n10, string2);
        ((TXAudioEffectManager$AudioMusicParam)object).publish = bl2;
        ((TXAudioEffectManager$AudioMusicParam)object).loopCount = n11;
        ((TXAudioEffectManager$AudioMusicParam)object).isShortFile = true;
        boolean bl3 = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic((TXAudioEffectManager$AudioMusicParam)object);
        TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(n10, this);
        Object object2 = this.mShortEffectorIDList;
        Integer n12 = n10;
        object2.add(n12);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("playEffectWithId ->effect id = ");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(", startPlayMusic result = ");
        ((StringBuilder)object2).append(bl3);
        String string4 = ((StringBuilder)object2).toString();
        TXCLog.i(string3, string4);
        return bl3;
    }

    public void resumeEffectWithId(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("resumeEffectWithId -> effect id = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(n10);
    }

    public void setEffectsVolume(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setEffectsVolume -> volume = ");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        Object object2 = TAG;
        TXCLog.i((String)object2, (String)object);
        object = this.mShortEffectorIDList.iterator();
        while ((n10 = object.hasNext()) != 0) {
            object2 = (Integer)object.next();
            n10 = (Integer)object2;
            TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance();
            float f11 = 100.0f * f10;
            int n11 = (int)f11;
            tXAudioEffectManagerImpl.setMusicVolume(n10, n11);
        }
    }

    public void setSoundEffectListener(b b10) {
        if (b10 == null) {
            b10 = null;
            mWeakSoundEffectListener = null;
        } else {
            WeakReference<b> weakReference;
            mWeakSoundEffectListener = weakReference = new WeakReference<b>(b10);
        }
    }

    public void setVolumeOfEffect(int n10, float f10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setVolumeOfEffect -> effect id = ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", volume = ");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        object = TXAudioEffectManagerImpl.getCacheInstance();
        int n11 = (int)(f10 * 100.0f);
        ((TXAudioEffectManagerImpl)object).setMusicVolume(n10, n11);
    }

    public void stopAllEffect() {
        int n10;
        String string2 = TAG;
        TXCLog.i(string2, "stopAllEffect -> start");
        Iterator iterator2 = this.mShortEffectorIDList.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Integer n11 = (Integer)iterator2.next();
            n10 = n11;
            TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance();
            tXAudioEffectManagerImpl.stopPlayMusic(n10);
        }
        this.mShortEffectorIDList.clear();
        TXCLog.i(string2, "stopAllEffect -> finish");
    }

    public void stopEffectWithId(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stopEffectWithId -> effect id = ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(n10, null);
        TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(n10);
        object = this.mShortEffectorIDList;
        Integer n11 = n10;
        n10 = object.indexOf(n11);
        if (n10 >= 0) {
            object = this.mShortEffectorIDList;
            object.remove(n10);
        }
    }
}

