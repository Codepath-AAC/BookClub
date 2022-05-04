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
import com.example.bookclub.adapters.BookAdapter3;
import com.example.bookclub.adapters.BookAdapter4;
import com.example.bookclub.adapters.BookAdapter5;
import com.example.bookclub.adapters.BookAdapter6;
import com.example.bookclub.adapters.BookAdapter7;
import com.example.bookclub.models.Book1;
import com.example.bookclub.models.Book2;
import com.example.bookclub.models.Book3;
import com.example.bookclub.models.Book4;
import com.example.bookclub.models.Book5;
import com.example.bookclub.models.Book6;
import com.example.bookclub.models.Book7;
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
    private BookAdapter3 bookAdapter3;
    private BookAdapter4 bookAdapter4;
    private BookAdapter5 bookAdapter5;
    private BookAdapter6 bookAdapter6;
    private BookAdapter7 bookAdapter7;
    private BookClient client;
    private ArrayList<Book1> book1s;
    private ArrayList<Book2> book2s;
    private ArrayList<Book3> book3s;
    private ArrayList<Book4> book4s;
    private ArrayList<Book5> book5s;
    private ArrayList<Book6> book6s;
    private ArrayList<Book7> book7s;
    private RecyclerView rvBooks1, rvBooks2, rvBooks3, rvBooks4, rvBooks5, rvBooks6, rvBooks7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvBooks1 = findViewById(R.id.bookListRv1);
        rvBooks2 = findViewById(R.id.bookListRv2);
        rvBooks3 = findViewById(R.id.bookListRv3);
        rvBooks4 = findViewById(R.id.bookListRv4);
        rvBooks5 = findViewById(R.id.bookListRv5);
        rvBooks6 = findViewById(R.id.bookListRv6);
        rvBooks7 = findViewById(R.id.bookListRv7);
        blogpost = findViewById(R.id.blogBtn);
        messages = findViewById(R.id.messagesBtn);
        profile = findViewById(R.id.profileBtn);
        maps = findViewById(R.id.mapsBtn);
        favorites = findViewById(R.id.favoritesBtn);
        book1s = new ArrayList<>();
        book2s = new ArrayList<>();
        book3s = new ArrayList<>();
        book4s = new ArrayList<>();
        book5s = new ArrayList<>();
        book6s = new ArrayList<>();
        book7s = new ArrayList<>();

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


        bookAdapter3 = new BookAdapter3(this, book3s);

        bookAdapter3.setOnItemClickListener(new BookAdapter3.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreenActivity.this, BookDetailActivity.class);
                Book3 book3 = book3s.get(position);
                String title = book3.getTitle();
                String auth = book3.getAuthor();
                String image = book3.getCoverUrl();
                intent.putExtra("title", title);
                intent.putExtra("author", auth);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        rvBooks3.setAdapter(bookAdapter3);
        LinearLayoutManager llm3 = new LinearLayoutManager(this);
        llm3.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvBooks3.setLayoutManager(llm3);

        fetchBooks3("Fantasy");


        bookAdapter4 = new BookAdapter4(this, book4s);

        bookAdapter4.setOnItemClickListener(new BookAdapter4.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreenActivity.this, BookDetailActivity.class);
                Book4 book4 = book4s.get(position);
                String title = book4.getTitle();
                String auth = book4.getAuthor();
                String image = book4.getCoverUrl();
                intent.putExtra("title", title);
                intent.putExtra("author", auth);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        rvBooks4.setAdapter(bookAdapter4);
        LinearLayoutManager llm4 = new LinearLayoutManager(this);
        llm4.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvBooks4.setLayoutManager(llm4);

        fetchBooks4("Mystery");




        bookAdapter5 = new BookAdapter5(this, book5s);

        bookAdapter5.setOnItemClickListener(new BookAdapter5.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreenActivity.this, BookDetailActivity.class);
                Book5 book5 = book5s.get(position);
                String title = book5.getTitle();
                String auth = book5.getAuthor();
                String image = book5.getCoverUrl();
                intent.putExtra("title", title);
                intent.putExtra("author", auth);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        rvBooks5.setAdapter(bookAdapter5);
        LinearLayoutManager llm5 = new LinearLayoutManager(this);
        llm5.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvBooks5.setLayoutManager(llm5);

        fetchBooks5("Classic");


        bookAdapter6 = new BookAdapter6(this, book6s);

        bookAdapter6.setOnItemClickListener(new BookAdapter6.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreenActivity.this, BookDetailActivity.class);
                Book6 book6 = book6s.get(position);
                String title = book6.getTitle();
                String auth = book6.getAuthor();
                String image = book6.getCoverUrl();
                intent.putExtra("title", title);
                intent.putExtra("author", auth);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        rvBooks6.setAdapter(bookAdapter6);
        LinearLayoutManager llm6 = new LinearLayoutManager(this);
        llm6.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvBooks6.setLayoutManager(llm6);

        fetchBooks6("Romance");


        bookAdapter7 = new BookAdapter7(this, book7s);

        bookAdapter7.setOnItemClickListener(new BookAdapter7.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(
                        HomeScreenActivity.this,
                        "An item at position " + position + " clicked!",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreenActivity.this, BookDetailActivity.class);
                Book7 book7 = book7s.get(position);
                String title = book7.getTitle();
                String auth = book7.getAuthor();
                String image = book7.getCoverUrl();
                intent.putExtra("title", title);
                intent.putExtra("author", auth);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        rvBooks7.setAdapter(bookAdapter7);
        LinearLayoutManager llm7 = new LinearLayoutManager(this);
        llm7.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvBooks7.setLayoutManager(llm7);

        fetchBooks7("Comic");

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

    private void fetchBooks3(String query) {
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
                        final ArrayList<Book3> books = Book3.fromJson(docs);
                        // Remove all books from the adapter
                        book3s.clear();
                        // Load model objects into the adapter
                        for (Book3 book : books) {
                            book3s.add(book); // add book through the adapter
                        }
                        bookAdapter3.notifyDataSetChanged();
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
        private void fetchBooks4(String query) {
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
                            final ArrayList<Book4> books = Book4.fromJson(docs);
                            // Remove all books from the adapter
                            book4s.clear();
                            // Load model objects into the adapter
                            for (Book4 book : books) {
                                book4s.add(book); // add book through the adapter
                            }
                            bookAdapter4.notifyDataSetChanged();
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
    private void fetchBooks5(String query) {
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
                        final ArrayList<Book5> books = Book5.fromJson(docs);
                        // Remove all books from the adapter
                        book5s.clear();
                        // Load model objects into the adapter
                        for (Book5 book : books) {
                            book5s.add(book); // add book through the adapter
                        }
                        bookAdapter5.notifyDataSetChanged();
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
    private void fetchBooks6(String query) {
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
                        final ArrayList<Book6> books = Book6.fromJson(docs);
                        // Remove all books from the adapter
                        book6s.clear();
                        // Load model objects into the adapter
                        for (Book6 book : books) {
                            book6s.add(book); // add book through the adapter
                        }
                        bookAdapter6.notifyDataSetChanged();
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
    private void fetchBooks7(String query) {
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
                        final ArrayList<Book7> books = Book7.fromJson(docs);
                        // Remove all books from the adapter
                        book7s.clear();
                        // Load model objects into the adapter
                        for (Book7 book : books) {
                            book7s.add(book); // add book through the adapter
                        }
                        bookAdapter7.notifyDataSetChanged();
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
