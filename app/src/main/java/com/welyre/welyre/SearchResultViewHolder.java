package com.welyre.welyre;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SearchResultViewHolder extends RecyclerView.ViewHolder {
    TextView searchItemView;

    public SearchResultViewHolder(View itemView) {
        super(itemView);
        searchItemView = (TextView) itemView.findViewById(R.id.tv_item);

    }

    void bind(String s){
        searchItemView.setText(s);
    }
}
