package com.example.pagingexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItemAdapter extends PagedListAdapter<Item, ItemAdapter.ItemHolder> {

    private Context context;
    public ItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = getItem(position);
        if(item != null){
            Glide.with(context).load(item.getOwner().getProfileImage()).into(holder.imgHolder);
            holder.tvName.setText(item.getOwner().getDisplayName());
            holder.tvId.setText(item.getOwner().getUserId().toString());
        }

    }

    private static DiffUtil.ItemCallback<Item> DIFF_CALLBACK = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return (oldItem.getAnswerId()==newItem.getAnswerId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return ( oldItem.getAnswerId().equals(newItem.getAnswerId()) && oldItem.isAccepted() == newItem.isAccepted()
                    && oldItem.getLastActivityDate().equals(newItem.getLastActivityDate()) && oldItem.getQuestionId().equals(newItem.getQuestionId())
                    && oldItem.getCreationDate().equals(newItem.getCreationDate()) );
        }
    };

    public class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView imgHolder;
        private TextView tvName, tvId;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgHolder = itemView.findViewById(R.id.imgHolder);
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
        }
    }
}
