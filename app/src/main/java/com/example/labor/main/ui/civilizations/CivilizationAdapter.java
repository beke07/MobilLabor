package com.example.labor.main.ui.civilizations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labor.R;
import com.example.labor.main.model.Civilization;

import java.util.List;

public class CivilizationAdapter extends RecyclerView.Adapter<CivilizationAdapter.ViewHolder> {

    private Context context;
    private List<Civilization> civilizationList;

    public CivilizationAdapter(Context context, List<Civilization> civilizationList) {
        this.context = context;
        this.civilizationList = civilizationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_civilization, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Civilization civilization = civilizationList.get(position);

        holder.civilizationName.setText(civilization.getName());
    }

    @Override
    public int getItemCount() {
        return civilizationList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView civilizationName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            civilizationName = (TextView) itemView.findViewById(R.id.civilizationName);
        }
    }
}
