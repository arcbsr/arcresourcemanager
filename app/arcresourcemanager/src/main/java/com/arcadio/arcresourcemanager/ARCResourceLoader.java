package com.arcadio.arcresourcemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ARCResourceLoader {
    private ArcResProperty.DlgClickListener dlgClickListener;
    private ArcResProperty.IconSize iconSize = ArcResProperty.IconSize.NORMAL;
    private Context context;
    private View view;
    private ArcResProperty.RecyleViewType recyleViewType;
    private DlgContentAdapter dlgContentAdapter = null;

    public ARCResourceLoader(RelativeLayout relativeLayout) {
        this.context = relativeLayout.getContext();
        relativeLayout.removeAllViews();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.view = (View) inflater.inflate(R.layout.layout_arcresource_dialog, relativeLayout, true);

    }

    public void storeButton(boolean shouldShow) {
        view.findViewById(R.id.dlg_add).setVisibility(shouldShow ? View.VISIBLE : View.GONE);
    }

    public void setOncontentClickListener(ArcResProperty.DlgClickListener dlgClickListener) {
        this.dlgClickListener = dlgClickListener;
        if (dlgContentAdapter != null) {
            dlgContentAdapter.setListener(dlgClickListener);
        }
    }

    public void showResList(ArrayList<ResourcesModule> allData, ArcResProperty.ContentType dlgType,
                            ArcResProperty.RecyleViewType recyleViewType, ArcResProperty.IconSize iconSize) {
        this.iconSize = iconSize;

        this.recyleViewType = recyleViewType;
        showHeaderList(context, view, allData, dlgType);
    }

    private void showHeaderList(Context activity, final View view, ArrayList<ResourcesModule> allData, ArcResProperty.ContentType dlgType) {
        RecyclerView recyclerViewHeaders = view.findViewById(R.id.dlg_recycler_header);
        recyclerViewHeaders.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false));
        recyclerViewHeaders.setAdapter(new DlgHeaderItemAdapter(activity, allData, dlgType, new DlgHeaderItemAdapter.HeaderClickListner() {
            @Override
            public void onItemClick(ResourcesModule resourcesModule) {
                //setupItemList(resourcesModule, inflate);
                setupItemList(resourcesModule, view);
            }
        }));
        recyclerViewHeaders.setHasFixedSize(true);
        setupItemList(allData.get(0), view);
        view.findViewById(R.id.dlg_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dlgClickListener != null)
                    dlgClickListener.onClose(v);
            }
        });
        view.findViewById(R.id.dlg_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dlgClickListener != null)
                    dlgClickListener.onAdd(v);
            }
        });
    }


    private void setupItemList(ResourcesModule resDetail, final View view) {
        RecyclerView recyclerViewContent = view.findViewById(R.id.dlg_recycler_body);
        recyclerViewContent.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, recyleViewType.getValue(), GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setSpanCount(recyleViewType.getValue());
        switch (recyleViewType) {
            case HORIZONTAL:
                gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
                break;
            case HORIZONTAL_2:
                gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
                break;
            case HORIZONTAL_3:
                gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
                break;
            case VERTICAL_4:
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                break;
            case VERTICAL_5:
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                break;
        }
        recyclerViewContent.setLayoutManager(gridLayoutManager);
        dlgContentAdapter = new DlgContentAdapter(view.getContext(), resDetail, iconSize);
        recyclerViewContent.setAdapter(dlgContentAdapter);
        if (dlgClickListener != null)
            dlgContentAdapter.setListener(dlgClickListener);
        recyclerViewContent.setHasFixedSize(true);
    }
}
