package com.codenesia.latihanperpustakaan;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.ListViewHolder> {
    private List<BookItem> listBook;

    public ListBookAdapter(List<BookItem> list) {
        this.listBook = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_book, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        BookItem book = listBook.get(position);

        holder.tvTitle.setText(book.getTitle());
        holder.tvPublisher.setText(book.getPublisher());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvStock.setText("Stok Buku : " + book.getStock());
        holder.tvYear.setText("Tahun Terbit : " + book.getYear());
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPublisher, tvAuthor, tvStock, tvYear;

        ListViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            tvPublisher = itemView.findViewById(R.id.publisher);
            tvAuthor = itemView.findViewById(R.id.author);
            tvStock = itemView.findViewById(R.id.stock);
            tvYear = itemView.findViewById(R.id.year);
        }
    }
}
