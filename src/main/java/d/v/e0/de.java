/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 */
package d.v.e0;

import android.util.ArrayMap;
import e.a.s0.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class de {
    public static final String A = "set_control_speed";
    public static final String B = "get_pitch_and_roll_fine_tune";
    public static final String C = "set_pitch_and_roll_fine_tune";
    public static final String D = "enable_debug_mode_true";
    public static final String E = "enable_debug_mode_false";
    public static final String F = "get_calibration_angels";
    public static final String G = "set_imu_control_register";
    public static final String H = "get_imu_control_register";
    public static final String I = "set_scene";
    public static final String J = "get_scene";
    public static final String K = "start_scan_wifi";
    public static final String L = "stop_scan_wifi";
    public static final String M = "connect_Wifi";
    public static final String N = "FIRMWARE_UPGRADE";
    public static final String O = "SAVE";
    public static final String P = "heartbeat";
    public static final String Q = "tracking";
    public static final String R = "story_moving";
    public static final String S = "active_info_get";
    public static final String T = "active_info_set";
    public static final String U = "take_panorama";
    public static final String V = "force_upgrade";
    public static final String b = "connect";
    public static final String c = "button";
    public static final String d = "move";
    public static final String e = "tracker";
    public static final String f = "set_working_mode";
    public static final String g = "get_working_mode";
    public static final String h = "set_power_mode";
    public static final String i = "get_power_mode";
    public static final String j = "take_photo";
    public static final String k = "record_video";
    public static final String l = "get_power";
    public static final String m = "back_center";
    public static final String n = "head_back";
    public static final String o = "set_roll_angle";
    public static final String p = "get_roll_angle";
    public static final String q = "get_pitch_angle";
    public static final String r = "get_yaw_angle";
    public static final String s = "get_angles";
    public static final String t = "set_strength";
    public static final String u = "get_strength";
    public static final String v = "set_camera_manufacturer";
    public static final String w = "get_camera_manufacturer";
    public static final String x = "set_yaw_control_speed";
    public static final String y = "set_pitch_control_speed";
    public static final String z = "set_roll_control_speed";
    private final Map a;

    public de() {
        Object object = new ArrayMap(40);
        object = Collections.synchronizedMap(object);
        this.a = object;
    }

    private void a(String string2, b b10) {
        boolean bl2;
        if (string2 == null) {
            return;
        }
        if (b10 != null && !(bl2 = b10.isDisposed())) {
            Map map = this.a;
            map.put(string2, b10);
        }
    }

    private boolean b(b b10) {
        boolean bl2;
        if (b10 != null && !(bl2 = b10.isDisposed())) {
            bl2 = false;
            b10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean c(String object) {
        if (object == null) {
            return false;
        }
        object = (b)this.a.get(object);
        return this.b((b)object);
    }

    public void d(String object) {
        if (object == null) {
            return;
        }
        Map map = this.a;
        boolean bl2 = this.b((b)(object = (b)map.remove(object)));
        if (!bl2) {
            object.dispose();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(List list) {
        synchronized (this) {
            Iterator iterator2 = this.a;
            iterator2 = iterator2.entrySet();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                Object object2 = (object = (Map.Entry)object).getKey();
                boolean bl3 = list.contains(object2);
                if (bl3) continue;
                object2 = object.getValue();
                if (object2 != null) {
                    object2 = object.getValue();
                    bl3 = (object2 = (b)object2).isDisposed();
                    if (!bl3) {
                        object = object.getValue();
                        object = (b)object;
                        object.dispose();
                    }
                }
                iterator2.remove();
            }
            return;
        }
    }

    public void f(String string2, b b10) {
        this.d(string2);
        this.a(string2, b10);
    }
}

