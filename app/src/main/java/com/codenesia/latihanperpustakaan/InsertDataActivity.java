package com.codenesia.latihanperpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertDataActivity extends AppCompatActivity {
    private String title, publisher, author, stock, year;
    private Button btnInsertData;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        EditText edTitle = findViewById(R.id.title);
        EditText edPublisher = findViewById(R.id.publisher);
        EditText edAuthor = findViewById(R.id.author);
        EditText edStock = findViewById(R.id.stock);
        EditText edYear = findViewById(R.id.year);

        btnInsertData = findViewById(R.id.insert);

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = edTitle.getText().toString();
                publisher = edPublisher.getText().toString();
                author = edAuthor.getText().toString();
                stock = edStock.getText().toString();
                year = edYear.getText().toString();

                if (title.isEmpty() || publisher.isEmpty() || author.isEmpty() || stock.isEmpty() || year.isEmpty()) {
                    Toast.makeText(InsertDataActivity.this, "Semua isian harus diisi", Toast.LENGTH_LONG).show();
                } else {
                    callApiInsertData();
                }
            }
        });


    }

    private void callApiInsertData() {
        Call<ResponseInsertBook> callInsertData = mApiInterface.insertBook(title, publisher, author, stock, year);

        callInsertData.enqueue(new Callback<ResponseInsertBook>() {
            @Override
            public void onResponse(Call<ResponseInsertBook> call, Response<ResponseInsertBook>
                    response) {
                Toast.makeText(InsertDataActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseInsertBook> call, Throwable t) {
                Toast.makeText(InsertDataActivity.this, "error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("error_api", t.getMessage());
            }
        });
    }
}