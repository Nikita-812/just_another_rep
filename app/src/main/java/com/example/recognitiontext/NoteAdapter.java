package com.example.recognitiontext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private final ArrayList<ItemNote> adapter = new ArrayList<>();

    private final NoteClickListener callback;

    public NoteAdapter(NoteClickListener callback) {
        this.callback = callback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(adapter.get(position));
    }

    @Override
    public int getItemCount() {
        return adapter.size();
    }

    public void setItems(List<ItemNote> adapter){
        this.adapter.clear();
        this.adapter.addAll(adapter);
        notifyDataSetChanged();
    }
        public void addItem(ItemNote item) {
        adapter.add(item);
        notifyItemInserted(getItemCount() - 1);
    }
    public void deleteItemByPosition(int position){
        adapter.remove(position);
        notifyDataSetChanged();
    }
    public void deleteItem(ItemNote itemNote){
        adapter.remove(itemNote);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView description;
        CardView root;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            root = itemView.findViewById(R.id.root);
        }
        void bind(ItemNote item){
            itemView.findViewById(R.id.root).setOnClickListener(v-> callback.onClick(item));
            description.setText(item.getName());
        }
    }
}
