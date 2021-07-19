/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAssetPackageParticleDescParser$NvsParticleEmitterDesc;
import com.meicam.sdk.NvsUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NvsAssetPackageParticleDescParser {
    public static final int EMITTER_PLACE_BOTTOM = 3;
    public static final int EMITTER_PLACE_CENTER = 4;
    public static final int EMITTER_PLACE_LEFT = 0;
    public static final int EMITTER_PLACE_RIGHT = 1;
    public static final int EMITTER_PLACE_TOP = 2;
    public static final int PARTICLE_TYPE_EYE = 3;
    public static final int PARTICLE_TYPE_GESTURE = 2;
    public static final int PARTICLE_TYPE_MOUTH = 4;
    public static final int PARTICLE_TYPE_NORMAL = 0;
    public static final int PARTICLE_TYPE_TOUCH = 1;
    public int m_ParticleType;
    public ArrayList m_emitters;

    /*
     * Loose catch block
     */
    public NvsAssetPackageParticleDescParser(String string2) {
        block25: {
            Object object;
            Object object2;
            int n10;
            block22: {
                int n11;
                block24: {
                    boolean bl2;
                    block23: {
                        block21: {
                            n10 = 0;
                            this.m_ParticleType = 0;
                            this.m_emitters = object2 = new ArrayList();
                            NvsUtils.checkFunctionInMainThread();
                            object2 = new JSONObject(string2);
                            string2 = "particleType";
                            string2 = object2.getString(string2);
                            object = "touch";
                            bl2 = string2.equals(object);
                            if (!bl2) break block21;
                            n11 = 1;
                            this.m_ParticleType = n11;
                            break block22;
                        }
                        object = "gesture";
                        bl2 = string2.equals(object);
                        if (!bl2) break block23;
                        n11 = 2;
                        this.m_ParticleType = n11;
                        break block22;
                    }
                    object = "eye";
                    bl2 = string2.equals(object);
                    if (!bl2) break block24;
                    n11 = 3;
                    this.m_ParticleType = n11;
                    break block22;
                }
                object = "mouth";
                n11 = (int)(string2.equals(object) ? 1 : 0);
                if (n11 == 0) break block22;
                n11 = 4;
                this.m_ParticleType = n11;
            }
            string2 = "emitterDesc";
            string2 = object2.getJSONArray(string2);
            while (true) {
                int n12 = string2.length();
                if (n10 >= n12) break block25;
                object2 = string2.getJSONObject(n10);
                object2 = this.GetEmitterDescFromJson((JSONObject)object2);
                object = this.m_emitters;
                try {
                    ((ArrayList)object).add(object2);
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                ++n10;
            }
            {
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
            }
        }
    }

    private NvsAssetPackageParticleDescParser$NvsParticleEmitterDesc GetEmitterDescFromJson(JSONObject jSONObject) {
        int n10;
        NvsAssetPackageParticleDescParser$NvsParticleEmitterDesc nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc = new NvsAssetPackageParticleDescParser$NvsParticleEmitterDesc(this);
        String string2 = "place";
        boolean bl2 = jSONObject.has(string2);
        string2 = bl2 ? jSONObject.getString(string2) : "";
        nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc.m_emitterPlace = 4;
        Object object = "left";
        bl2 = string2.equals(object);
        int n11 = 0;
        if (bl2) {
            nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc.m_emitterPlace = 0;
        } else {
            object = "right";
            bl2 = string2.equals(object);
            if (bl2) {
                nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc.m_emitterPlace = n10 = 1;
            } else {
                object = "top";
                bl2 = string2.equals(object);
                if (bl2) {
                    nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc.m_emitterPlace = n10 = 2;
                } else {
                    object = "bottom";
                    n10 = (int)(string2.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc.m_emitterPlace = n10 = 3;
                    }
                }
            }
        }
        string2 = "emitterName";
        bl2 = jSONObject.has(string2);
        if (bl2) {
            jSONObject = jSONObject.getJSONArray(string2);
            while (n11 < (n10 = jSONObject.length())) {
                string2 = jSONObject.getString(n11);
                object = nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc.m_emitterNames;
                ((ArrayList)object).add(string2);
                ++n11;
            }
        }
        return nvsAssetPackageParticleDescParser$NvsParticleEmitterDesc;
    }

    public List GetLeftEyeEmitter() {
        NvsUtils.checkFunctionInMainThread();
        return this.GetParticlePartitionEmitter(0);
    }

    public int GetLeftEyePlace() {
        NvsUtils.checkFunctionInMainThread();
        return this.GetParticlePartitionPlace(0);
    }

    public int GetParticlePartitionCount() {
        return this.m_emitters.size();
    }

    public List GetParticlePartitionEmitter(int n10) {
        NvsUtils.checkFunctionInMainThread();
        ArrayList arrayList = this.m_emitters;
        int n11 = arrayList.size();
        if (n10 >= n11) {
            return null;
        }
        return ((NvsAssetPackageParticleDescParser$NvsParticleEmitterDesc)this.m_emitters.get((int)n10)).m_emitterNames;
    }

    public int GetParticlePartitionPlace(int n10) {
        NvsUtils.checkFunctionInMainThread();
        ArrayList arrayList = this.m_emitters;
        int n11 = arrayList.size();
        if (n10 >= n11) {
            return 4;
        }
        return ((NvsAssetPackageParticleDescParser$NvsParticleEmitterDesc)this.m_emitters.get((int)n10)).m_emitterPlace;
    }

    public int GetParticleType() {
        return this.m_ParticleType;
    }

    public List GetRightEyeEmitter() {
        NvsUtils.checkFunctionInMainThread();
        return this.GetParticlePartitionEmitter(1);
    }

    public int GetRightEyePlace() {
        NvsUtils.checkFunctionInMainThread();
        return this.GetParticlePartitionPlace(1);
    }
}

