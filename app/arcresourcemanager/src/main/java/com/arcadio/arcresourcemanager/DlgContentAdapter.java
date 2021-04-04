package com.arcadio.arcresourcemanager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DlgContentAdapter extends RecyclerView.Adapter<DlgContentAdapter.ViewHolder> {

    private ResourcesModule resourcesModule;
    private Context context;
    public int selectedIndex = -1;
    private ArcResProperty.DlgClickListener dlgClickListener;
    private ArcResProperty.IconSize iconSize;

    public DlgContentAdapter(Context context2, ResourcesModule resourcesModule,
                             ArcResProperty.IconSize iconSize) {
        this.context = context2;
        this.resourcesModule = resourcesModule;
        this.iconSize = iconSize;
    }

    public void setListener(ArcResProperty.DlgClickListener dlgContentAdapter) {
        this.dlgClickListener = dlgContentAdapter;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dlg_content_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (selectedIndex == position & dlgClickListener != null) {
            holder.icon.setBackgroundColor(dlgClickListener.selectedColor());
        } else {
            holder.icon.setBackgroundColor(Color.TRANSPARENT);
        }
        Glide.with(context).asBitmap().load(resourcesModule.getLink(position)).thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.icon);

        holder.icon.setPadding(iconSize.getValue(context), iconSize.getValue(context), iconSize.getValue(context), iconSize.getValue(context));
        holder.title.setVisibility(View.INVISIBLE);
        holder.icon.setVisibility(View.VISIBLE);

        if (resourcesModule.getPricingType(position) == ArcResProperty.ResType.FREE) {
            holder.premium.setVisibility(View.INVISIBLE);
        } else {
            holder.premium.setVisibility(View.VISIBLE);
        }
        holder.itemView.setOnClickListener(v -> {
            selectedIndex = position;
            notifyDataSetChanged();
            Log.w("get clicked", resourcesModule.getLink(position));
            if (dlgClickListener != null)
                dlgClickListener.onItemClick(resourcesModule, position, holder.icon);
        });
    }

    public int getItemCount() {
        return resourcesModule.getResLinks().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon, premium;
        TextView title;

        public ViewHolder(View view) {
            super(view);
            this.icon = view.findViewById(R.id.dlg_head_item);
            this.premium = view.findViewById(R.id.dlg_item_premium);
            this.title = view.findViewById(R.id.dlg_head_item_title);
        }

    }

}
