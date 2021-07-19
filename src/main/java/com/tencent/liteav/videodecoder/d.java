/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.videodecoder;

import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.videodecoder.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class d {
    private boolean a = false;
    private boolean b = false;

    private void a(c c10) {
        String string2 = "SPS: cpb_cnt_minus1";
        int n10 = c10.a(string2);
        int n11 = 4;
        c10.b(n11, "HRD: bit_rate_scale");
        String string3 = "HRD: cpb_size_scale";
        c10.b(n11, string3);
        for (n11 = 0; n11 <= n10; ++n11) {
            c10.b("HRD: bit_rate_value_minus1");
            string3 = "HRD: cpb_size_value_minus1";
            c10.b(string3);
            int n12 = 1;
            String string4 = "HRD: cbr_flag";
            c10.b(n12, string4);
        }
        n10 = 5;
        c10.b(n10, "HRD: initial_cpb_removal_delay_length_minus1");
        c10.b(n10, "HRD: cpb_removal_delay_length_minus1");
        c10.b(n10, "HRD: dpb_output_delay_length_minus1");
        c10.b(n10, "HRD: time_offset_length");
    }

    private boolean b(c object) {
        boolean bl2;
        String string2;
        boolean bl3;
        boolean bl4;
        String string3;
        boolean bl5;
        boolean bl6;
        long l10;
        boolean bl7;
        CharSequence charSequence = "VUI: aspect_ratio_info_present_flag";
        boolean n11 = ((c)object).d((String)charSequence);
        int n10 = 8;
        if (n11 && (bl7 = (int)(l10 = ((c)object).a(n10, (String)(charSequence = "VUI: aspect_ratio")))) == (bl6 = 255 != 0)) {
            int n12 = 16;
            ((c)object).b(n12, "VUI: sar_width");
            String string4 = "VUI: sar_height";
            ((c)object).b(n12, string4);
        }
        charSequence = "VUI: overscan_info_present_flag";
        boolean bl8 = ((c)object).d((String)charSequence);
        bl6 = true;
        if (bl8) {
            charSequence = "VUI: overscan_appropriate_flag";
            ((c)object).b((int)(bl6 ? 1 : 0), (String)charSequence);
        }
        if (bl5 = ((c)object).d((String)(charSequence = "VUI: video_signal_type_present_flag"))) {
            string3 = "VUI: video_format";
            ((c)object).b(3, string3);
            ((c)object).b((int)(bl6 ? 1 : 0), "VUI: video_full_range_flag");
            charSequence = "VUI: colour_description_present_flag";
            boolean bl9 = ((c)object).d((String)charSequence);
            if (bl9) {
                ((c)object).b(n10, "VUI: colour_primaries");
                ((c)object).b(n10, "VUI: transfer_characteristics");
                charSequence = "VUI: matrix_coefficients";
                ((c)object).b(n10, (String)charSequence);
            }
        }
        if (bl4 = ((c)object).d((String)(charSequence = "VUI: chroma_loc_info_present_flag"))) {
            ((c)object).b("VUI chroma_sample_loc_type_top_field");
            charSequence = "VUI chroma_sample_loc_type_bottom_field";
            ((c)object).b((String)charSequence);
        }
        if (bl3 = ((c)object).d((String)(charSequence = "VUI: timing_info_present_flag"))) {
            int n13 = 32;
            ((c)object).b(n13, "VUI: num_units_in_tick");
            string2 = "VUI: time_scale";
            ((c)object).b(n13, string2);
            charSequence = "VUI: fixed_frame_rate_flag";
            ((c)object).b((int)(bl6 ? 1 : 0), (String)charSequence);
        }
        if (bl2 = ((c)object).d((String)(charSequence = "VUI: nal_hrd_parameters_present_flag"))) {
            this.a((c)object);
        }
        if ((n10 = (int)(((c)object).d(string2 = "VUI: vcl_hrd_parameters_present_flag") ? 1 : 0)) != 0) {
            this.a((c)object);
        }
        if (bl2 || n10 != 0) {
            charSequence = "VUI: low_delay_hrd_flag";
            ((c)object).b((int)(bl6 ? 1 : 0), (String)charSequence);
        }
        ((c)object).b((int)(bl6 ? 1 : 0), "VUI: pic_struct_present_flag");
        charSequence = "VUI: bitstream_restriction_flag";
        boolean bl10 = ((c)object).e((String)charSequence);
        string2 = "VUI: motion_vectors_over_pic_boundaries_flag";
        string3 = "VUI: set bitstream_restriction_flag";
        String string5 = "[H264SPSModifier]";
        if (bl10) {
            boolean bl11 = this.a;
            if (bl11) {
                charSequence = "steve:VUI has bs restriction!!";
                Log.d((String)string5, (String)charSequence);
            }
            ((c)object).a(bl6, string3);
            ((c)object).d(string2);
            ((c)object).b("VUI max_bytes_per_pic_denom");
            ((c)object).b("VUI max_bits_per_mb_denom");
            ((c)object).b("VUI log2_max_mv_length_horizontal");
            ((c)object).b("VUI log2_max_mv_length_vertical");
            charSequence = "VUI num_reorder_frames";
            ((c)object).b((String)charSequence);
            boolean bl12 = this.b;
            if (!bl12) {
                int n14 = ((c)object).c(false);
                charSequence = new StringBuilder();
                string2 = "decode: do not add max_dec_frame_buffering when it is ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(n14);
                object = ((StringBuilder)charSequence).toString();
                TXCLog.w(string5, (String)object);
                this.b = bl6;
            }
            return false;
        }
        boolean bl13 = this.a;
        if (bl13) {
            charSequence = "steve:VUI has NO bs restriction!!";
            Log.d((String)string5, (String)charSequence);
        }
        ((c)object).a(bl6, string3);
        ((c)object).a(bl6, string2);
        ((c)object).c(0, "VUI: max_bytes_per_pic_denom");
        ((c)object).c(0, "VUI: max_bits_per_mb_denom");
        int n15 = 10;
        ((c)object).c(n15, "VUI: log2_max_mv_length_horizontal");
        string2 = "VUI: log2_max_mv_length_vertical";
        ((c)object).c(n15, string2);
        ((c)object).c(0, "VUI: num_reorder_frames");
        charSequence = "VUI: max_dec_frame_buffering";
        ((c)object).c((int)(bl6 ? 1 : 0), (String)charSequence);
        boolean bl14 = this.b;
        if (!bl14) {
            object = "decode: add max_dec_frame_buffering 1 when it is no exist";
            TXCLog.w(string5, (String)object);
            this.b = bl6;
        }
        return bl6;
    }

    public byte[] a(InputStream object) {
        String string2;
        CharSequence charSequence;
        Object object2 = new ByteArrayOutputStream();
        Object object3 = new c((InputStream)object, (OutputStream)object2);
        int n10 = 8;
        ((c)object3).b(n10, "NALU type");
        CharSequence charSequence2 = "SPS: profile_idc";
        long l10 = ((c)object3).a(n10, (String)charSequence2);
        int n11 = (int)l10;
        ((c)object3).b(n10, "SPS: constraint_set_0-3_flag and reserved_zero_4bits");
        ((c)object3).a(n10, "SPS: level_idc");
        ((c)object3).b("SPS: seq_parameter_set_id");
        int n12 = 0;
        int n13 = 1;
        int n14 = 100;
        if (n11 == n14 || n11 == (n14 = 110) || n11 == (n14 = 122) || n11 == (n14 = 144)) {
            charSequence2 = "SPS: chroma_format_idc";
            n11 = ((c)object3).a((String)charSequence2);
            if (n11 == (n14 = 3)) {
                charSequence2 = "SPS: residual_color_transform_flag";
                ((c)object3).b(n13, (String)charSequence2);
            }
            ((c)object3).b("SPS: bit_depth_luma_minus8");
            ((c)object3).b("SPS: bit_depth_chroma_minus8");
            ((c)object3).b(n13, "SPS: qpprime_y_zero_transform_bypass_flag");
            charSequence2 = "SPS: seq_scaling_matrix_present_lag";
            n11 = (int)(((c)object3).d((String)charSequence2) ? 1 : 0);
            if (n11 != 0) {
                charSequence2 = null;
                for (n11 = 0; n11 < n10; ++n11) {
                    charSequence = "SPS: seqScalingListPresentFlag";
                    n14 = (int)(((c)object3).d((String)charSequence) ? 1 : 0);
                    if (n14 == 0) continue;
                    n14 = 6;
                    if (n11 < n14) {
                        n14 = 16;
                        ((c)object3).c(n14);
                        continue;
                    }
                    n14 = 64;
                    ((c)object3).c(n14);
                }
            }
        }
        ((c)object3).b("SPS: log2_max_frame_num_minus4");
        object = "SPS: pic_order_cnt_type";
        n10 = ((c)object3).a((String)object);
        if (n10 == 0) {
            object = "SPS: log2_max_pic_order_cnt_lsb_minus4";
            ((c)object3).b((String)object);
        } else if (n10 == n13) {
            ((c)object3).b(n13, "SPS: delta_pic_order_always_zero_flag");
            ((c)object3).b("SPS: offset_for_non_ref_pic");
            ((c)object3).b("SPS: offset_for_top_to_bottom_field");
            object = "SPS: num_ref_frames_in_pic_order_cnt_cycle";
            n10 = ((c)object3).a((String)object);
            charSequence2 = null;
            for (n11 = 0; n11 < n10; ++n11) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("SPS: offsetForRefFrame [");
                ((StringBuilder)charSequence).append(n11);
                string2 = "]";
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                ((c)object3).b((String)charSequence);
            }
        }
        object = "SPS: num_ref_frames";
        n10 = ((c)object3).a((String)object);
        n11 = (int)(this.a ? 1 : 0);
        charSequence = "[H264SPSModifier]";
        if (n11 != 0) {
            charSequence2 = new StringBuilder();
            string2 = "SPS: num_ref_frames: ";
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append(n10);
            object = ((StringBuilder)charSequence2).toString();
            Log.d((String)charSequence, (String)object);
        }
        ((c)object3).b(n13, "SPS: gaps_in_frame_num_value_allowed_flag");
        ((c)object3).b("SPS: pic_width_in_mbs_minus1");
        ((c)object3).b("SPS: pic_height_in_map_units_minus1");
        object = "SPS: frame_mbs_only_flag";
        n10 = (int)(((c)object3).d((String)object) ? 1 : 0);
        if (n10 == 0) {
            object = "SPS: mb_adaptive_frame_field_flag";
            ((c)object3).b(n13, (String)object);
        }
        ((c)object3).b(n13, "SPS: direct_8x8_inference_flag");
        object = "SPS: frame_cropping_flag";
        n10 = (int)(((c)object3).d((String)object) ? 1 : 0);
        if (n10 != 0) {
            ((c)object3).b("SPS: frame_crop_left_offset");
            ((c)object3).b("SPS: frame_crop_right_offset");
            ((c)object3).b("SPS: frame_crop_top_offset");
            object = "SPS: frame_crop_bottom_offset";
            ((c)object3).b((String)object);
        }
        object = "SPS: vui_parameters_present_flag";
        n10 = (int)(((c)object3).e((String)object) ? 1 : 0);
        charSequence2 = "VUI set 1: ";
        if (n10 != 0) {
            n10 = (int)(this.a ? 1 : 0);
            if (n10 != 0) {
                object = "vui_parameters_present_flag exist!! modify max_dec_frame_buffering";
                Log.d((String)charSequence, (String)object);
            }
            ((c)object3).a(n13 != 0, (String)charSequence2);
            n10 = (int)(this.b((c)object3) ? 1 : 0);
            if (n10 == 0) {
                return null;
            }
        } else {
            n10 = (int)(this.a ? 1 : 0);
            if (n10 != 0) {
                object = "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering";
                Log.d((String)charSequence, (String)object);
            }
            ((c)object3).a(n13 != 0, (String)charSequence2);
            ((c)object3).a(false, "VUI: aspect_ratio_info_present_flag");
            ((c)object3).a(false, "VUI: overscan_info_present_flag");
            ((c)object3).a(false, "VUI: video_signal_type_present_flag");
            ((c)object3).a(false, "VUI: chroma_loc_info_present_flag");
            ((c)object3).a(false, "VUI: timing_info_present_flag");
            ((c)object3).a(false, "VUI: nal_hrd_parameters_present_flag");
            ((c)object3).a(false, "VUI: vcl_hrd_parameters_present_flag");
            ((c)object3).a(false, "VUI: pic_struct_present_flag");
            ((c)object3).a(n13 != 0, "VUI: bitstream_restriction_flag");
            ((c)object3).a(n13 != 0, "VUI: motion_vectors_over_pic_boundaries_flag");
            ((c)object3).c(0, "VUI: max_bytes_per_pic_denom");
            ((c)object3).c(0, "VUI: max_bits_per_mb_denom");
            n10 = 10;
            ((c)object3).c(n10, "VUI: log2_max_mv_length_horizontal");
            charSequence2 = "VUI: log2_max_mv_length_vertical";
            ((c)object3).c(n10, (String)charSequence2);
            ((c)object3).c(0, "VUI: num_reorder_frames");
            object = "VUI: max_dec_frame_buffering";
            ((c)object3).c(n13, (String)object);
            n10 = (int)(this.b ? 1 : 0);
            if (n10 == 0) {
                object = "decode: add max_dec_frame_buffering 1 when vui is no exist";
                TXCLog.w((String)charSequence, (String)object);
                this.b = n13;
            }
        }
        ((c)object3).c();
        object = ((ByteArrayOutputStream)object2).toByteArray();
        boolean bl2 = this.a;
        if (bl2) {
            int n15;
            object2 = "";
            while (n12 < (n15 = ((Object)object).length)) {
                n15 = object[n12] & 0xFF;
                object3 = Integer.toHexString(n15);
                n11 = ((String)object3).length();
                if (n11 == n13) {
                    charSequence2 = new StringBuilder();
                    string2 = "0";
                    ((StringBuilder)charSequence2).append(string2);
                    ((StringBuilder)charSequence2).append((String)object3);
                    object3 = ((StringBuilder)charSequence2).toString();
                }
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)object2);
                ((StringBuilder)charSequence2).append(" ");
                ((StringBuilder)charSequence2).append((String)object3);
                object2 = ((StringBuilder)charSequence2).toString();
                ++n12;
            }
            object3 = new StringBuilder();
            charSequence2 = "new SPS:";
            ((StringBuilder)object3).append((String)charSequence2);
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            Log.d((String)charSequence, (String)object2);
        }
        return object;
    }

    public byte[] a(byte[] byArray) {
        Object object;
        int n10 = this.a;
        if (n10 != 0) {
            String string2;
            int n11;
            object = null;
            String string3 = "";
            for (n10 = 0; n10 < (n11 = byArray.length); ++n10) {
                StringBuilder stringBuilder;
                int n12;
                n11 = byArray[n10] & 0xFF;
                string2 = Integer.toHexString(n11);
                int n13 = string2.length();
                if (n13 == (n12 = 1)) {
                    stringBuilder = new StringBuilder();
                    String string4 = "0";
                    stringBuilder.append(string4);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(" ");
                stringBuilder.append(string2);
                string3 = stringBuilder.toString();
            }
            object = new StringBuilder();
            string2 = "old SPS:";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            string3 = "[H264SPSModifier]";
            Log.d((String)string3, (String)object);
        }
        object = new ByteArrayInputStream(byArray);
        return this.a((InputStream)object);
    }
}

