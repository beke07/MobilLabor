package com.example.labor.main.view.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labor.R;
import com.example.labor.main.model.Civilization;

import java.util.List;

public class CivilizationAdapter extends RecyclerView.Adapter<CivilizationAdapter.ViewHolder> {

    private Context context;
    private List<Civilization> civilizationList;
    private OnCivilizationListener onCivilizationListener;
    private MainPresenter presenter;

    public CivilizationAdapter(
            Context context,
            List<Civilization> civilizationList,
            OnCivilizationListener onCivilizationListener,
            MainPresenter mainPresenter) {
        this.context = context;
        this.civilizationList = civilizationList;
        this.onCivilizationListener = onCivilizationListener;
        this.presenter = mainPresenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cicvilizationView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_civilization, parent, false);

        return new ViewHolder(cicvilizationView, onCivilizationListener, presenter);
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

    protected static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView civilizationName;
        OnCivilizationListener onCivilizationListener;
        MainPresenter presenter;

        public ViewHolder(@NonNull View itemView, OnCivilizationListener onCivilizationListener, MainPresenter presenter) {
            super(itemView);
            civilizationName = itemView.findViewById(R.id.civilizationName);

            configureDeleteButton(itemView);

            this.onCivilizationListener = onCivilizationListener;
            this.presenter = presenter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCivilizationListener.onCivilizationClick(getAdapterPosition());
        }

        private void configureDeleteButton(final View itemView){
            Button deleteButton = (Button) itemView.findViewById(R.id.deleteButton);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.removeCivilization(getAdapterPosition());
                }
            });
        }
    }

    public interface OnCivilizationListener{
        void onCivilizationClick(int position);
    }
}
