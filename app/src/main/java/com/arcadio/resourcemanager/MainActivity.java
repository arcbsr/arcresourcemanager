package com.arcadio.resourcemanager;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.arcadio.arcresourcemanager.ARCResourceLoader;
import com.arcadio.arcresourcemanager.ArcResProperty;
import com.arcadio.arcresourcemanager.ResourcesModule;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ResourcesModule> allData = new ArrayList();

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        /*if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        setContentView(R.layout.activity_main);


        allData.add(new ResourcesModule("file:///android_asset", "stickers", "boom", "webp",
                27, 1, 0, false));
        allData.add(new ResourcesModule("file:///android_asset", "stickers", "emojy", "webp",
                28, 0, 0, false));
        allData.add(new ResourcesModule("file:///android_asset", "stickers", "boom", "webp",
                28, 0, 0, false));
        allData.add(new ResourcesModule("file:///android_asset", "stickers", "emojy", "webp",
                28, 0, 0, false));
        allData.add(new ResourcesModule("file:///android_asset", "stickers", "boom", "webp",
                28, 0, 0, false));
        allData.add(new ResourcesModule("file:///android_asset", "stickers", "emojy", "webp",
                28, 0, 0, false));
        allData.add(new ResourcesModule("file:///android_asset", "stickers", "boom", "webp",
                28, 0, 0, false));
        allData.add(new ResourcesModule("file:///android_asset", "stickers", "emojy", "webp",
                28, 0, 0, false));
        /*findViewById(R.id.showdlg).setOnClickListener((View.OnClickListener) v -> {
            ARCResourceLoader resourceLoader = new ARCResourceLoader((RelativeLayout) findViewById(R.id.relview));
            resourceLoader.showResList(allData, ArcResProperty.ContentType.ICON,
                    ArcResProperty.RecyleViewType.VERTICAL_5, ArcResProperty.IconSize.BIG);
        });*/
        selectedview = findViewById(R.id.hor);
        findViewById(R.id.hor).setOnClickListener((View.OnClickListener) v -> {
            selectedview = v;
            ARCResourceLoader resourceLoader = new ARCResourceLoader((RelativeLayout) findViewById(R.id.relview));
            resourceLoader.showResList(allData, contentType,
                    ArcResProperty.RecyleViewType.HORIZONTAL, iconSize);
        });
        findViewById(R.id.hor2).setOnClickListener((View.OnClickListener) v -> {
            selectedview = v;
            ARCResourceLoader resourceLoader = new ARCResourceLoader((RelativeLayout) findViewById(R.id.relview));
            resourceLoader.showResList(allData, contentType,
                    ArcResProperty.RecyleViewType.HORIZONTAL_2, iconSize);
        });
        findViewById(R.id.hor3).setOnClickListener((View.OnClickListener) v -> {
            selectedview = v;
            ARCResourceLoader resourceLoader = new ARCResourceLoader((RelativeLayout) findViewById(R.id.relview));
            resourceLoader.showResList(allData, contentType,
                    ArcResProperty.RecyleViewType.HORIZONTAL_3, iconSize);
        });
        findViewById(R.id.ver4).setOnClickListener((View.OnClickListener) v -> {
            selectedview = v;
            ARCResourceLoader resourceLoader = new ARCResourceLoader((RelativeLayout) findViewById(R.id.relview));
            resourceLoader.showResList(allData, contentType,
                    ArcResProperty.RecyleViewType.VERTICAL_4, iconSize);
        });
        findViewById(R.id.ver5).setOnClickListener((View.OnClickListener) v -> {
            selectedview = v;
            ARCResourceLoader resourceLoader = new ARCResourceLoader((RelativeLayout) findViewById(R.id.relview));
            resourceLoader.showResList(allData, contentType,
                    ArcResProperty.RecyleViewType.VERTICAL_5, iconSize);
        });
        ((Switch) findViewById(R.id.switch1)).setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (contentType == ArcResProperty.ContentType.ICON) {
                contentType = ArcResProperty.ContentType.TEXT;
            } else {
                contentType = ArcResProperty.ContentType.ICON;
            }
            selectedview.performClick();
        });
        ((Spinner) findViewById(R.id.spinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        iconSize = ArcResProperty.IconSize.BIG;
                        break;
                    case 1:
                        iconSize = ArcResProperty.IconSize.NORMAL;
                        break;
                    case 2:
                        iconSize = ArcResProperty.IconSize.SMALL;
                        break;
                    case 3:
                        iconSize = ArcResProperty.IconSize.VSMALL;
                        break;
                }
                selectedview.performClick();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    View selectedview = null;
    private ArcResProperty.ContentType contentType = ArcResProperty.ContentType.ICON;
    private ArcResProperty.IconSize iconSize = ArcResProperty.IconSize.BIG;
}