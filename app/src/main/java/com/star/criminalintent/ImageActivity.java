package com.star.criminalintent;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    public static Intent newIntent(Context context, String imagePath) {

        Intent intent = new Intent(context, ImageActivity.class);

        intent.setData(Uri.parse(imagePath));

        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);

        Uri imagePath = getIntent().getData();

        ImageView imageView = findViewById(R.id.image_view);

        imageView.setImageURI(imagePath);
    }

    public static void startWithTransition(Activity activity, Intent intent, View sourceView) {

        String transitionName = activity.getResources().getString(R.string.image);

        ViewCompat.setTransitionName(sourceView, transitionName);

        ActivityOptionsCompat activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity, sourceView, transitionName);

        activity.startActivity(intent, activityOptionsCompat.toBundle());
    }
}
