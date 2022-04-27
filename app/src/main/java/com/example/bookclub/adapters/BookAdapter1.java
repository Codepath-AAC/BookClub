package com.example.bookclub.adapters;

import android.content.Context;
import android.util.Log;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookclub.HomeScreenActivity;
import com.example.bookclub.R;
import com.example.bookclub.models.Book1;

import java.util.ArrayList;
import java.util.function.BiPredicate;

public class BookAdapter1 extends RecyclerView.Adapter<BookAdapter1.ViewHolder> {

    private static final String TAG = "BookAdapter1";

    private ArrayList<String> bookNames = new ArrayList<>();
    private ArrayList<String> bookImageUrls = new ArrayList<>();
    private ArrayList<Book1> books = new ArrayList<>();
    private Context context;

    private OnItemClickListener listener;

    public BookAdapter1(Context acontext, ArrayList<Book1> book1s) {
        context = acontext;
        books = book1s;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener;}

    public BookAdapter1(ArrayList<Book1> abooks, ArrayList<String> abookNames, ArrayList<String> abookImageUrls, Context acontext) {
        bookNames = abookNames;
        books = abooks;
        bookImageUrls = abookImageUrls;
        context = acontext;
    }

    @NonNull
    @Override
    public BookAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_bookitem, parent, false);

        BookAdapter1.ViewHolder viewHolder = new BookAdapter1.ViewHolder(view, listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Book1 book = books.get(position);
//
//        Glide.with(context)
//                .asBitmap()
//                .load(bookImageUrls.get(position))
//                .into(holder.bookCover);

        holder.bookName.setText(book.getTitle());

        holder.bookCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked on a book");
                Toast.makeText(context, bookNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bookCover;
        TextView bookName;


        public ViewHolder(final View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            bookCover = itemView.findViewById(R.id.bookImage);
            bookName = itemView.findViewById(R.id.bookTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(itemView, getAdapterPosition());
                }
            });

        }

    }
}
