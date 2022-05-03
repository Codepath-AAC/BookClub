package com.example.bookclub.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.bookclub.R;
import com.example.bookclub.models.Book2;

import java.util.ArrayList;

public class BookAdapter2 extends RecyclerView.Adapter<BookAdapter2.ViewHolder> {

    private static final String TAG = "BookAdapter1";

    private ArrayList<String> bookNames = new ArrayList<>();
    private ArrayList<String> bookImageUrls = new ArrayList<>();
    private ArrayList<Book2> mBooks = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener listener;

    public BookAdapter2(Context context, ArrayList<Book2> book2s) {
        mContext = context;
        mBooks = book2s;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener;}

    public BookAdapter2(ArrayList<Book2> books, ArrayList<String> abookNames, ArrayList<String> abookImageUrls, Context context) {
        bookNames = abookNames;
        mBooks = books;
        bookImageUrls = abookImageUrls;
        mContext = context;
    }

    @NonNull
    @Override
    public BookAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_bookitem, parent, false);

        BookAdapter2.ViewHolder viewHolder = new BookAdapter2.ViewHolder(view, listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter2.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Book2 book = mBooks.get(position);
        Glide.with(getContext())
                .load(Uri.parse(book.getCoverUrl()))
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(holder.bookCover);


        holder.bookName.setText(book.getTitle());
        holder.bookCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked on a book");
                //Toast.makeText(mContext, bookNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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

    private Context getContext() {
        return mContext;
    }
}
