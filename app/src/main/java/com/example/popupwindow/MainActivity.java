package com.example.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnShowPopupWindow;

    private PopupWindow popupWindow;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowPopupWindow = (Button) findViewById(R.id.btnShowPopupWindow);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        btnShowPopupWindow.setOnClickListener(v -> {
            LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            View popupView = layoutInflater.inflate(R.layout.popup_window, null);

            popupWindow = new PopupWindow(popupView, RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);
            btnShowPopupWindow.setVisibility(View.GONE);

            Button btnClose = (Button) popupView.findViewById(R.id.btnClose);
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    btnShowPopupWindow.setVisibility(View.VISIBLE);
                }
            });
        });
    }
}