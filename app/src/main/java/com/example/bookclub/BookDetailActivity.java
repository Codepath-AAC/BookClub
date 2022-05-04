package com.example.bookclub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.bookclub.databinding.ActivityBookDetailBinding;

public class BookDetailActivity extends AppCompatActivity {

    private ImageView ivBookCover, ivFavorite;
    private TextView tvTitle, tvAuthor;
    private Button backBtn;
    private Toolbar toolbar;

    private AppBarConfiguration appBarConfiguration;
    private ActivityBookDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        backBtn = findViewById(R.id.backbtn);
        ivFavorite = findViewById(R.id.favoritesStar);
        ivBookCover = findViewById(R.id.ivBookCover);
        tvTitle = findViewById(R.id.tvTitle);
        tvAuthor = findViewById(R.id.tvAuthor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        String image = getIntent().getStringExtra("image");
        getSupportActionBar().setTitle(title);
        tvTitle.setText(title);
        tvAuthor.setText(author);
        Glide.with(BookDetailActivity.this)
                .load(Uri.parse(image))
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(ivBookCover);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookDetailActivity.this, HomeScreenActivity.class);
                startActivity(i);
            }
        });

        ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("BookDetail", "FAVORITED");
                ivFavorite.setImageResource(R.drawable.ic_favorites);
            }
        });


    }


}