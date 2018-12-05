package com.welyre.welyre;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainDataAdapter extends RecyclerView.Adapter<SearchResultViewHolder> {
    private int numberOfItems;
    private String[] items;

    public MainDataAdapter(int numberofitems, String[] itemList){
        numberOfItems = numberofitems;
        items = itemList;
    }

    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.searchresult_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        SearchResultViewHolder viewHolder = new SearchResultViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SearchResultViewHolder  searchResultViewHolder, int i) {
        searchResultViewHolder.bind(items[i]);
    }

    public int getItemCount() {
        return numberOfItems;
    }
}