package com.github.shchurov.particleview.sample.burst;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.github.shchurov.particleview.ParticleView;
import com.github.shchurov.particleview.TextureAtlas;
import com.github.shchurov.particleview.sample.R;
import com.github.shchurov.particleview.sample.TextureAtlasFactory;

public class BurstActivity extends AppCompatActivity {

    private ParticleView particleView;

    public static void start(Context context) {
        Intent i = new Intent(context, BurstActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burst);
        particleView = (ParticleView) findViewById(R.id.particleView);
        TextureAtlas textureAtlas = TextureAtlasFactory.createTextureAtlas(getResources());
        final BurstParticleSystem particleSystem = new BurstParticleSystem();
        particleView.setTextureAtlas(textureAtlas);
        particleView.setParticleSystem(particleSystem);
        particleView.setFpsLogEnabled(true);
        particleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    particleSystem.addBurst(event.getX(), event.getY());
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        particleView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        particleView.onPause();
    }

}
