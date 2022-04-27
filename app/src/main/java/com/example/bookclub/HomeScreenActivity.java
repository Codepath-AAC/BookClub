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
import com.example.bookclub.models.Book1;
import com.example.bookclub.net.BookClient;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import okhttp3.Headers;

public class HomeScreenActivity extends AppCompatActivity
{
    Button messages, profile, maps, favorites;
    private BookAdapter1 bookAdapter1;
    private BookClient client;
    private ArrayList<Book1> book1s;
    private RecyclerView rvBooks1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvBooks1 = findViewById(R.id.bookListRv1);
        messages = findViewById(R.id.messagesBtn);
        profile = findViewById(R.id.profileBtn);
        maps = findViewById(R.id.mapsBtn);
        favorites = findViewById(R.id.favoritesBtn);
        book1s = new ArrayList<>();

        bookAdapter1 = new BookAdapter1(this, book1s);
        bookAdapter1.setOnItemClickListener(new BookAdapter1.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        rvBooks1.setAdapter(bookAdapter1);

        rvBooks1.setLayoutManager(new LinearLayoutManager(this));

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreenActivity.this, DirectMessagingActivity.class);
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
                        books.clear();
                        // Load model objects into the adapter
                        for (Book1 book : books) {
                            books.add(book); // add book through the adapter
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
}
