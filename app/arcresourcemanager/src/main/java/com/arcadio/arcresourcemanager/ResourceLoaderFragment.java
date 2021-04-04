package com.arcadio.arcresourcemanager;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResourceLoaderFragment extends DialogFragment {
//
//    private static final String TAG = "ResouceLoaderFragment";
//    private ArrayList<ResourcesModule> allData = new ArrayList();
//    private ArcRes.DlgClickListener dlgClickListener;
//    private ArcRes.DlgType dlgType;
//
//    public static ResourceLoaderFragment show(@NonNull AppCompatActivity appCompatActivity,
//                                              ArrayList<ResourcesModule> allData, ArcRes.DlgType dlgType,
//                                              ArcRes.DlgClickListener dlgClickListener) {
//        ResourceLoaderFragment ratioFragment = new ResourceLoaderFragment();
//        ratioFragment.setItems(allData, dlgType, dlgClickListener);
//        ratioFragment.show(appCompatActivity.getSupportFragmentManager(), TAG);
//        return ratioFragment;
//    }
//
//    private void setItems(ArrayList<ResourcesModule> allData, ArcRes.DlgType dlgType, ArcRes.DlgClickListener dlgClickListener) {
//        this.allData = allData;
//        this.dlgType = dlgType;
//        this.dlgClickListener = dlgClickListener;
//    }
//
//    @Override
//    public void onDismiss(@NonNull DialogInterface dialog) {
//        super.onDismiss(dialog);
//        dlgClickListener.onClose(getDialog());
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setRetainInstance(true);
//    }
//
//    @SuppressLint("WrongConstant")
//    @Nullable
//    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
//        getDialog().getWindow().requestFeature(1);
//        //getDialog().getWindow().setFlags(1024, 1024);
//        View inflate = layoutInflater.inflate(R.layout.layout_arcresource_dialog, viewGroup, false);
//
//        RecyclerView recyclerViewHeaders = inflate.findViewById(R.id.dlg_recycler_header);
//        recyclerViewHeaders.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
//        recyclerViewHeaders.setAdapter(new DlgHeaderItemAdapter(getContext(), allData, dlgType, new DlgHeaderItemAdapter.HeaderClickListner() {
//            @Override
//            public void onItemClick(ResourcesModule resourcesModule) {
//                setupItemList(resourcesModule, inflate);
//            }
//        }));
//        recyclerViewHeaders.setHasFixedSize(true);
//        setupItemList(allData.get(0), inflate);
//        inflate.findViewById(R.id.dlg_close).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//        inflate.findViewById(R.id.dlg_add).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dlgClickListener.onAdd(getDialog());
//            }
//        });
//        return inflate;
//    }
//
//    public void onActivityCreated(Bundle bundle) {
//        super.onActivityCreated(bundle);
//        //getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//    }
//
//    public void onStart() {
//        super.onStart();
//        Dialog dialog = getDialog();
//        if (dialog != null) {
//            dialog.getWindow().setLayout(-1, -1);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//    }
//
//    private void setupItemList(ResourcesModule resDetail, View view) {
//        RecyclerView recyclerViewHeaders = view.findViewById(R.id.dlg_recycler_body);
//        recyclerViewHeaders.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
//        recyclerViewHeaders.setAdapter(new DlgContentAdapter(getContext(), resDetail, new ArcRes.DlgClickListener() {
//            @Override
//            public void onClose(Dialog dialog) {
//
//            }
//
//            @Override
//            public void onAdd(Dialog dialog) {
//
//            }
//
//            @Override
//            public void onItemClick(ResourcesModule resDetail, String link, ArcRes.DlgResType resType, Dialog dialog) {
//                dlgClickListener.onItemClick(resDetail, link, resType, getDialog());
//            }
//        }, ArcRes.IconSize.SMALL));
//        recyclerViewHeaders.setHasFixedSize(true);
//    }
//
//    public void onStop() {
//        super.onStop();
//    }

}
