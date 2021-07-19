/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package d.v.c.s0.a7;

import android.widget.SeekBar;
import com.zhiyun.cama.camera.data.BeautyData;
import d.v.c.s0.a7.v0;
import d.v.c.s0.u6;
import java.util.List;

public class v0$b
implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ v0 a;

    public v0$b(v0 v02) {
        this.a = v02;
    }

    public void onProgressChanged(SeekBar object, int n10, boolean bl2) {
        if (bl2) {
            object = v0.y(this.a);
            int n11 = v0.w(this.a);
            ((BeautyData)object.get(n11)).setProgress(n10);
            object = v0.z(this.a);
            List list = v0.y(this.a);
            ((u6)object).z1(list);
            object = this.a;
            int n12 = v0.w((v0)object);
            switch (n12) {
                default: {
                    break;
                }
                case 7: {
                    object = v0.z(this.a);
                    ((u6)object).F1(n10);
                    break;
                }
                case 6: {
                    object = v0.z(this.a);
                    ((u6)object).E1(n10);
                    break;
                }
                case 5: {
                    object = v0.z(this.a);
                    ((u6)object).B1(n10);
                    break;
                }
                case 4: {
                    object = v0.z(this.a);
                    ((u6)object).H1(n10);
                    break;
                }
                case 3: {
                    object = v0.z(this.a);
                    ((u6)object).A1(n10);
                    break;
                }
                case 2: {
                    object = v0.z(this.a);
                    ((u6)object).G1(n10);
                }
            }
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}

