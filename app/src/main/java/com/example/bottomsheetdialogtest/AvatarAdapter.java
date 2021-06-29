package com.example.bottomsheetdialogtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.ViewHolder>{

    List<Integer> mList;
    Context mContext;

    private int mSelectPosition = -1;
    private OnItemClickListener mListener;

    public AvatarAdapter(Context context, List<Integer> list, OnItemClickListener listener){
        mList = list;
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_avatar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Picasso.get().load(mList.get(position)).into(holder.mImgHead);
        holder.mImgHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(mList.get(position));
                if (mSelectPosition != position) {
                    notifyDataSetChanged();
                    mSelectPosition = position;
                }
            }
        });
        if (position == mSelectPosition) {
            holder.mIvSelect.setVisibility(View.VISIBLE);
        } else {
            holder.mIvSelect.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mImgHead;
        ImageView mIvSelect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgHead = itemView.findViewById(R.id.img_head);
            mIvSelect = itemView.findViewById(R.id.iv_select);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int avatarUrl);
    }
}
