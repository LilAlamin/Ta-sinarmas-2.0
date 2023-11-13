package com.example.ta_sinarmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        TextView profileDescription = findViewById(R.id.profile_description);
        TextView readMore = findViewById(R.id.read_more);

        Button gopay = findViewById(R.id.gopay_button);
        Button dana = findViewById(R.id.dana_button);

        


        ImageView gifImageView = findViewById(R.id.gif_image_view);
        Glide.with(this).asGif().load(R.drawable.pay).into(gifImageView);

        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profileDescription.getMaxLines() == 2) {
                    profileDescription.setMaxLines(Integer.MAX_VALUE);
                    readMore.setText("Tutup");
                } else {
                    profileDescription.setMaxLines(2);
                    readMore.setText("Baca Penuh");
                }
            }
        });
    }
    private boolean isAppInstalled(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}