package ru.tander.contentprovidersampleapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.tander.tanderstorepolicyrepository.ApplicationPolicies;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<ApplicationPolicies> mItems = new ArrayList<>();

    void addAll(List<ApplicationPolicies> mItems) {
        this.mItems.clear();
        this.mItems.addAll(mItems);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ApplicationPolicies item = mItems.get(position);
        viewHolder.login.setText(item.getName());
        viewHolder.id.setText(String.valueOf(item.getId()));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView login;
        ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            login = (TextView) itemView.findViewById(R.id.name);
        }
    }
}