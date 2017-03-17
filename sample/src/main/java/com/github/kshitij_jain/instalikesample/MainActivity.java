package com.github.kshitij_jain.instalikesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.kshitij_jain.instalike.InstaLikeView;

public class MainActivity extends AppCompatActivity {

    private InstaLikeView mInstaLikeView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInstaLikeView = (InstaLikeView) findViewById(R.id.insta_like_view);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInstaLikeView.start();
            }
        });
    }
}
