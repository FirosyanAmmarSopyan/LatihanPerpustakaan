package com.codenesia.latihanperpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.codenesia.latihanperpustakaan.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edUsername,edPassword;
    private CheckBox cbShowPasword;
    private Button btnLogin;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initVariable();
        initOnClick();
    }

    private void initVariable(){
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        edUsername = findViewById(R.id.username);
        edPassword = findViewById(R.id.password);
        cbShowPasword = findViewById(R.id.cb_show_password);
        btnLogin = findViewById(R.id.login);
    }

    private void initOnClick(){
        cbShowPasword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbShowPasword.isChecked())
                    edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                else
                    edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callApiLogin();
            }
        });
    }

    private void callApiLogin(){
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();

        Call<ResponseLogin> callLogin = mApiInterface.login(username,password);

        callLogin.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin>
                    response) {
                response.body().getUser();
                Toast.makeText(LoginActivity.this,response.body().getMessage(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"error: "+t.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("error_api", t.getMessage());
            }
        });
    }
}