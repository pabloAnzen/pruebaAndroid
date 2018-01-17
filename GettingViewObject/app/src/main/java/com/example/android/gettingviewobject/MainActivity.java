package com.example.android.gettingviewobject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView imagen = (ImageView) findViewById(R.id.android_cookie_image_view);
        imagen.setImageResource(R.drawable.after_cookie);
        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView texto = (TextView) findViewById(R.id.status_text_view);
        Log.i("MainActivity.java", "Este es un mensaje de información");
        texto.setText("I´m so full !!!!");
    }
}