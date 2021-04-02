package com.release.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class InfoWebView extends AppCompatActivity {

    private ProgressDialog progressDialog;

    private WebView view;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_web_view);

        url = getIntent().getStringExtra("url");

        showProgressDialog();

        view = findViewById(R.id.infoWebView);

        if (url != null) {
            view.loadUrl(url);
        } else {
            Toast.makeText(this, "Some Error Occured !Try Again Later", Toast.LENGTH_SHORT).show();
            finish();
        }

        view.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                dismissProgressDialog();
            }
        });


    }


    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
        }
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}