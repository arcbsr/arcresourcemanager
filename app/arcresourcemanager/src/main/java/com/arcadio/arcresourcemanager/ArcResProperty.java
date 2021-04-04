package com.arcadio.arcresourcemanager;

import android.content.Context;
import android.view.View;

public class ArcResProperty {

    public enum ContentType {
        ICON,
        TEXT
    }

    public enum ResType {
        FREE(""),
        ADS("_ad"),
        PAID("_paid"),
        NONE("none");
        private String ext;

        ResType(String ext) {
            this.ext = ext;
        }

        public String getValue() {
            return ext;
        }
    }

    public enum RecyleViewType {
        HORIZONTAL(1),
        HORIZONTAL_2(2),
        HORIZONTAL_3(3),
        VERTICAL_5(5),
        VERTICAL_4(4);

        private int row_col;

        RecyleViewType(int i) {
            this.row_col = i;
        }

        public int getValue() {
            return row_col;
        }
    }

    public enum IconSize {
        VSMALL(10),
        SMALL(8),
        NORMAL(4),
        BIG(1);
        private int size;

        IconSize(int i) {
            this.size = i;
        }

        public int getValue(Context context) {
            final float scale = context.getResources().getDisplayMetrics().density;
            int padding_in_px = (int) (size * scale + 0.5f);
            return padding_in_px;
        }
    }

    public interface DlgClickListener {
        void onClose(View view);

        void onAdd(View view);

        int selectedColor();

        void onItemClick(ResourcesModule resDetail, int position, View view);

    }
}
