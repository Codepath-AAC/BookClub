package com.example.bookclub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.bookclub.adapters.BookAdapter1;
import com.example.bookclub.adapters.BookAdapter2;
import com.example.bookclub.models.Book1;
import com.example.bookclub.models.Book2;
import com.example.bookclub.net.BookClient;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import okhttp3.Headers;

public class HomeScreenActivity extends AppCompatActivity {

    public static final String TAG = "HomeScreenActivity";
    Button blogpost, messages, profile, maps, favorites;
    private BookAdapter1 bookAdapter1;
    private BookAdapter2 bookAdapter2;
    private BookClient client;
    private ArrayList<Book1> book1s;
    private ArrayList<Book2> book2s;
    private RecyclerView rvBooks1, rvBooks2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvBooks1 = findViewById(R.id.bookListRv1);
        rvBooks2 = findViewById(R.id.bookListRv2);
        blogpost = findViewById(R.id.blogBtn);
        messages = findViewById(R.id.messagesBtn);
        profile = findViewById(R.id.profileBtn);
        maps = findViewById(R.id.mapsBtn);
        favorites = findViewById(R.id.favoritesBtn);
        book1s = new ArrayList<>();
        book2s = new ArrayList<>();

        bookAdapter1 = new BookAdapter1(this, book1s);

        bookAdapter1.setOnItemClickListener(new BookAdapter1.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreenActivity.this, BookDetailActivity.class);
                Book1 book1 = book1s.get(position);
                String title = book1.getTitle();
                String auth = book1.getAuthor();
                String image = book1.getCoverUrl();
                intent.putExtra("title", title);
                intent.putExtra("author", auth);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        rvBooks1.setAdapter(bookAdapter1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvBooks1.setLayoutManager(llm);

        fetchBooks("Trending");

        bookAdapter2 = new BookAdapter2(this, book2s);

        bookAdapter2.setOnItemClickListener(new BookAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreenActivity.this, BookDetailActivity.class);
                Book2 book2 = book2s.get(position);
                String title = book2.getTitle();
                String auth = book2.getAuthor();
                String image = book2.getCoverUrl();
                intent.putExtra("title", title);
                intent.putExtra("author", auth);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        rvBooks2.setAdapter(bookAdapter2);
        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvBooks2.setLayoutManager(llm2);

        fetchBooks2("Oscar Wilde");


        blogpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenActivity.this, BlogpostActivity.class);
                startActivity(i);
            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenActivity.this, MessagingActivity.class);
                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenActivity.this, FavoritesActivity.class);
                startActivity(i);
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenActivity.this, LocationActivity.class);
                startActivity(i);
            }
        });
    }


    private void fetchBooks(String query) {
        client = new BookClient();
        client.getBooks(query, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON response) {
                try {
                    JSONArray docs;
                    if (response != null) {
                        // Get the docs json array
                        docs = response.jsonObject.getJSONArray("docs");
                        // Parse json array into array of model objects
                        final ArrayList<Book1> books = Book1.fromJson(docs);
                        // Remove all books from the adapter
                        book1s.clear();
                        // Load model objects into the adapter
                        for (Book1 book : books) {
                            book1s.add(book); // add book through the adapter
                        }
                        bookAdapter1.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    // Invalid JSON format, show appropriate error.
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String responseString, Throwable throwable) {
                // Handle failed request here
                Log.e(HomeScreenActivity.class.getSimpleName(),
                        "Request failed with code " + statusCode + ". Response message: " + responseString);
            }
        });
    }

    private void fetchBooks2(String query) {
        client = new BookClient();
        client.getBooks(query, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JSON response) {
                try {
                    JSONArray docs;
                    if (response != null) {
                        // Get the docs json array
                        docs = response.jsonObject.getJSONArray("docs");
                        // Parse json array into array of model objects
                        final ArrayList<Book2> books = Book2.fromJson(docs);
                        // Remove all books from the adapter
                        book2s.clear();
                        // Load model objects into the adapter
                        for (Book2 book : books) {
                            book2s.add(book); // add book through the adapter
                        }
                        bookAdapter2.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    // Invalid JSON format, show appropriate error.
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String responseString, Throwable throwable) {
                // Handle failed request here
                Log.e(HomeScreenActivity.class.getSimpleName(),
                        "Request failed with code " + statusCode + ". Response message: " + responseString);
            }
        });


    }
}
