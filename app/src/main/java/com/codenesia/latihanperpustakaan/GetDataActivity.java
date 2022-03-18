package com.codenesia.latihanperpustakaan;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataActivity extends AppCompatActivity {

    private ApiInterface mApiInterface;
    private RecyclerView rvBook;
    private ListBookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        rvBook = findViewById(R.id.rv_book);
        rvBook.setHasFixedSize(true);
        rvBook.setLayoutManager(new LinearLayoutManager(this));
        callApiGetData();
    }

    private void callApiGetData() {
        Call<ResponseGetBook> callGetData = mApiInterface.getBook();

        callGetData.enqueue(new Callback<ResponseGetBook>() {
            @Override
            public void onResponse(Call<ResponseGetBook> call, Response<ResponseGetBook>
                    response) {
                Toast.makeText(GetDataActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                bookAdapter = new ListBookAdapter(response.body().getBook());
                rvBook.setAdapter(bookAdapter);
            }

            @Override
            public void onFailure(Call<ResponseGetBook> call, Throwable t) {
                Toast.makeText(GetDataActivity.this, "error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("error_api", t.getMessage());
            }
        });
    }
}