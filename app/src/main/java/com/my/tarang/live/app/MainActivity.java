package com.my.tarang.live.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    private String channel = "";
    private String quality = "";

    private ArrayList<HashMap<String, Object>> list = new ArrayList<>();

    private LinearLayout main_bg;
    private LinearLayout linear13;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private TextView textview1;
    private LinearLayout linear9;
    private TextView textview5;
    private LinearLayout linear10;
    private TextView textview4;
    private LinearLayout linear11;
    private TextView textview3;
    private LinearLayout linear12;
    private TextView textview2;
    private TextView textview6;

    private Intent i = new Intent();
    private RequestNetwork requestNet;
    private RequestNetwork.RequestListener _requestNet_request_listener;
    private AlertDialog loadingDialog;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.main);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {
        main_bg = findViewById(R.id.main_bg);
        linear13 = findViewById(R.id.linear13);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        linear4 = findViewById(R.id.linear4);
        linear5 = findViewById(R.id.linear5);
        linear6 = findViewById(R.id.linear6);
        linear7 = findViewById(R.id.linear7);
        linear8 = findViewById(R.id.linear8);
        textview1 = findViewById(R.id.textview1);
        linear9 = findViewById(R.id.linear9);
        textview5 = findViewById(R.id.textview5);
        linear10 = findViewById(R.id.linear10);
        textview4 = findViewById(R.id.textview4);
        linear11 = findViewById(R.id.linear11);
        textview3 = findViewById(R.id.textview3);
        linear12 = findViewById(R.id.linear12);
        textview2 = findViewById(R.id.textview2);
        textview6 = findViewById(R.id.textview6);
        requestNet = new RequestNetwork(this);

        linear8.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    channel = "tarangtv-origin";
                    _show_quality_select(channel);
                }
            });

        linear9.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    channel = "otv-origin";
                    _show_quality_select(channel);
                }
            });

        linear10.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    channel = "alankar-origin";
                    _show_quality_select(channel);
                }
            });

        linear11.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    channel = "tarangmusic-origin";
                    _show_quality_select(channel);
                }
            });

        linear12.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    channel = "prarthana-origin";
                    _show_quality_select(channel);
                }
            });

        _requestNet_request_listener =
            new RequestNetwork.RequestListener() {
            @Override
            public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
                final String _tag = _param1;
                final String _response = _param2;
                final HashMap<String, Object> _responseHeaders = _param3;
            }

            @Override
            public void onErrorResponse(String _param1, String _param2) {
                final String _tag = _param1;
                final String _message = _param2;
            }
        };
    }

    private void initializeLogic() {
        // Hide Status Bar //
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        ;

        textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
    }

    public void _show_quality_select(final String _channel) {
        Context context = MainActivity.this;

        loadingDialog = new AlertDialog.Builder(context).create();
        LayoutInflater loading_compLI = getLayoutInflater();
        View loading_compCV = (View) loading_compLI.inflate(R.layout.qualityselection, null);

        final LinearLayout linear2jduhd = loading_compCV.findViewById(R.id.linear2);
        linear2jduhd.setBackground(
            new GradientDrawable() {
                public GradientDrawable getIns(int a, int b) {
                    this.setCornerRadius(a);
                    this.setColor(b);
                    return this;
                }
            }.getIns((int) 30, 0xFF25232A));

        final TextView textview1 = loading_compCV.findViewById(R.id.textview1);
        final TextView textview2 = loading_compCV.findViewById(R.id.textview2);
        final TextView textview3 = loading_compCV.findViewById(R.id.textview3);
        final TextView textview4 = loading_compCV.findViewById(R.id.textview4);
        textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);
        textview4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/font.ttf"), 0);

        final LinearLayout sm = loading_compCV.findViewById(R.id.sm);
        final LinearLayout md = loading_compCV.findViewById(R.id.md);
        final LinearLayout bg = loading_compCV.findViewById(R.id.bg);
        sm.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    loadingDialog.dismiss();
                    quality = "live_240p";
                    i.setClass(getApplicationContext(), PlayerActivity.class);
                    i.putExtra("c", _channel);
                    i.putExtra("q", quality);
                    startActivity(i);
                }
            });
        md.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    loadingDialog.dismiss();
                    quality = "live_360p";
                    i.setClass(getApplicationContext(), PlayerActivity.class);
                    i.putExtra("c", _channel);
                    i.putExtra("q", quality);
                    startActivity(i);
                }
            });
        bg.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    loadingDialog.dismiss();
                    quality = "live_720p";
                    i.setClass(getApplicationContext(), PlayerActivity.class);
                    i.putExtra("c", _channel);
                    i.putExtra("q", quality);
                    startActivity(i);
                }
            });

        loadingDialog.setView(loading_compCV);
        loadingDialog.setCancelable(true);
        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Set custom dim color and fade effect
        Window window = loadingDialog.getWindow();
        if (window != null) {
            // Customize dim color
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setDimAmount(1f); // Change the dim amount (0-1) to your preference
        }

        // Show the dialog
        loadingDialog.show();
    }
}
