package com.example.bookclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private EditText etBookName;
    private Button btnBookCover;
    private ImageView ivPostBook;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBookName = findViewById(R.id.etBookName);
        btnBookCover = findViewById(R.id.btnBookCover);
        ivPostBook = findViewById(R.id.ivPostBook);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
}