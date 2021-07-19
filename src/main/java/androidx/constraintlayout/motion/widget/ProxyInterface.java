/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.widget;

public interface ProxyInterface {
    public int designAccess(int var1, String var2, Object var3, float[] var4, int var5, float[] var6, int var7);

    public float getKeyFramePosition(Object var1, int var2, float var3, float var4);

    public Object getKeyframeAtLocation(Object var1, float var2, float var3);

    public Boolean getPositionKeyframe(Object var1, Object var2, float var3, float var4, String[] var5, float[] var6);

    public long getTransitionTimeMs();

    public void setAttributes(int var1, String var2, Object var3, Object var4);

    public void setKeyFrame(Object var1, int var2, String var3, Object var4);

    public boolean setKeyFramePosition(Object var1, int var2, int var3, float var4, float var5);

    public void setToolPosition(float var1);
}

