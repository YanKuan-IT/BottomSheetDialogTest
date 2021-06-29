package com.example.bottomsheetdialogtest;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;

public class AvatarDialog extends BottomSheetDialog {

    private Context mContext;
    List<Integer> avatarIdList;

    private RecyclerView mRvAvatar;
    private Callback mCallback;

    public AvatarDialog(@NonNull Context context, Callback callback) {
        super(context);
        setContentView(R.layout.avatar_dialog);

        mContext = context;
        mCallback = callback;

        avatarIdList = new ArrayList<>();
        avatarIdList.add(R.drawable.user_avatar1);
        avatarIdList.add(R.drawable.user_avatar2);
        avatarIdList.add(R.drawable.user_avatar3);
        avatarIdList.add(R.drawable.user_avatar4);
        avatarIdList.add(R.drawable.user_avatar5);
        avatarIdList.add(R.drawable.user_avatar6);
        avatarIdList.add(R.drawable.user_avatar7);
        avatarIdList.add(R.drawable.user_avatar8);
        avatarIdList.add(R.drawable.user_avatar9);
        avatarIdList.add(R.drawable.user_avatar10);

        mRvAvatar = findViewById(R.id.rv_avatar);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        mRvAvatar.setLayoutManager(gridLayoutManager);
        AvatarAdapter adapter = new AvatarAdapter(mContext, avatarIdList, new AvatarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int avatarUrl) {
                mCallback.onCallback(avatarUrl);
            }
        });
        mRvAvatar.setAdapter(adapter);
    }

    public interface Callback{
        void onCallback(int avatarId);
    }

}
