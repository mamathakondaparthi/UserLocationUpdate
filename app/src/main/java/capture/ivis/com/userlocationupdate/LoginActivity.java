package capture.ivis.com.userlocationupdate;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonObject;

import capture.ivis.com.userlocationupdate.service.Util;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends Activity implements View.OnClickListener {
  EditText et_username,et_password;
  Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username =findViewById(R.id.edtxtUname);
        et_password = findViewById(R.id.edtxtPwd);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

      switch (v.getId()){
          case R.id.btnLogin:
              LoginDetails();
      }
    }

    private void LoginDetails() {
        String user = et_username.getText().toString();
        String pass = et_password.getText().toString();

        if (Util.isNetworkAvailable(getApplicationContext())) {
            Util.showProgressDialog(LoginActivity.this);
            Util.getBaseClassService(getApplicationContext(), "")
                    .login(new Callback<JsonObject>() {
                        @Override
                        public void success(JsonObject jsonObject, Response response) {
                            Log.d("jsonObject", "" + jsonObject);
                            int userId = jsonObject.get("userId").getAsInt();
                            Log.d("id", String.valueOf(userId));
                            String userName = jsonObject.get("userName").getAsString();
                            Log.d("userName",userName);
                            if((jsonObject != null) && (jsonObject.get("userId").getAsInt() > 0)){

                            }


                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Log.d("error",error.getMessage());
                            Util.dismissDialog();
                        }
                    });
        }
        }

}

