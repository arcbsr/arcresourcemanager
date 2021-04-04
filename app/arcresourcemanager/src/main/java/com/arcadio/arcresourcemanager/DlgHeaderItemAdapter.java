package com.arcadio.arcresourcemanager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DlgHeaderItemAdapter extends RecyclerView.Adapter<DlgHeaderItemAdapter.ViewHolder> {

    private ArrayList<ResourcesModule> allData;
    private Context context;
    public int selectedIndex = 0;
    private ArcResProperty.ContentType dlgType;
    private HeaderClickListner headerClickListner;

    public interface HeaderClickListner {
        void onItemClick(ResourcesModule resourcesModule);
    }

    public DlgHeaderItemAdapter(Context context2, ArrayList<ResourcesModule> allData, ArcResProperty.ContentType dlgType, HeaderClickListner headerClickListner) {
        this.context = context2;
        this.allData = allData;
        this.dlgType = dlgType;
        this.headerClickListner = headerClickListner;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dlg_head_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (selectedIndex == position) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.dlg_content));
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
        if (dlgType == ArcResProperty.ContentType.ICON) {

            Glide.with(context).asBitmap().load(allData.get(position).getLink(0)).into(holder.icon);
            holder.title.setVisibility(View.INVISIBLE);
            holder.icon.setVisibility(View.VISIBLE);
        } else if (dlgType == ArcResProperty.ContentType.TEXT) {
            holder.icon.setVisibility(View.INVISIBLE);
            holder.title.setVisibility(View.VISIBLE);
            holder.title.setText(allData.get(position).catgoryName);
        }
        if (allData.get(position).isFreeAsset()) {
            holder.premiumicon.setVisibility(View.INVISIBLE);
        } else {
            holder.premiumicon.setVisibility(View.VISIBLE);
        }
        holder.itemView.setOnClickListener(v -> {
            if (selectedIndex == position) {
                return;
            }
            selectedIndex = position;
            notifyDataSetChanged();
            headerClickListner.onItemClick(allData.get(position));
        });
    }

    public int getItemCount() {
        return allData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon, premiumicon;
        TextView title;

        public ViewHolder(View view) {
            super(view);
            this.icon = view.findViewById(R.id.dlg_head_item);
            this.premiumicon = view.findViewById(R.id.dlg_item_premium);
            this.title = view.findViewById(R.id.dlg_head_item_title);

        }

    }

}
