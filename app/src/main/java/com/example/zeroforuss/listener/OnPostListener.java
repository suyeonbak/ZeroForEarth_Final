package com.example.zeroforuss.listener;

import com.example.zeroforuss.PostInfo;

public interface OnPostListener {
    void onDelete(PostInfo postInfo);
    void onModify();
}
