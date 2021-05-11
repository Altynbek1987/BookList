package com.example.booklist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.booklist.R;
import com.example.booklist.interfaces.OnBookClickListener;
import com.example.booklist.model.BooksModels;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private OnBookClickListener onBookClickListener;

    private List<BooksModels> list;
    public BookAdapter(List<BooksModels> list) {
        this.list = list;
    }

    public void setOnBookClickListener(OnBookClickListener onBookClickListener) {
        this.onBookClickListener = onBookClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_book_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textBookName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBookClickListener.onItemClick(getAdapterPosition());
                }
            });
            textBookName = itemView.findViewById(R.id.text_book_name);
        }

        public void bind(BooksModels models) {
            textBookName.setText(models.getBookName());
        }
    }
}
