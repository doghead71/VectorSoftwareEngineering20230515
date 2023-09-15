package com.jamteach.testapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import databases.DBAdapter;

public class MainActivity extends AppCompatActivity {

    private final static int RC_GET_PHOTO = 1;
    private final static int RC_GET_TEXT = 2;

    private ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        handlePhotoResponse(result.getData());
                    }

                }
            }
    );

    private ActivityResultLauncher<Intent> testLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        handleTextResponse(result.getData());
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtonShare();
        setupButtonPic();
        setupButtonPicNew();
        setupButtonFragment();
        setupButtonContextMenu();
        setupButtonPreference();
        setupButtonPreferenceNew();
        setupButtonTestDB();
        setupButtonTestUrl();
    }

    private InputStream openHttpsConnection(String urlString){
        InputStream in = null;
        int response = -1;
        try {
            java.net.URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            if(!(connection instanceof HttpsURLConnection)){
                throw new IOException("Not an HTTPs connection");
            }
            HttpsURLConnection httpsConn = (HttpsURLConnection) connection;
            httpsConn.setAllowUserInteraction(false);
            httpsConn.setInstanceFollowRedirects(true);
            httpsConn.setRequestMethod("GET");
            httpsConn.connect();
            response = httpsConn.getResponseCode();
            if(response == HttpsURLConnection.HTTP_OK){
                in = httpsConn.getInputStream();
            }
        }catch (Exception ex){
            Log.d("Network-TEST", "MSG-".concat(ex.getMessage()));
        }
        return in; // remember this can be null
    }

    private Bitmap downloadImage(String url){
        Bitmap bitmap = null;
        InputStream in = null;
        try {
            in = openHttpsConnection(url);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        }catch (Exception ex){
            Log.d("Network-TEST","MSG-".concat(ex.getMessage()) );
        }
        return bitmap;
    }


    private void setupButtonTestUrl(){
        Button buttonTestUrl = findViewById(R.id.buttonTestURL);
        buttonTestUrl.setOnClickListener(view -> {
            String url = "https://jamaica-gleaner.com/sites/default/files/styles/jg_article_image/public/media/article_images/2023/09/14/captured.jpg?itok=LuCcsPG-";
            new DownloadImageTask().execute(url);
        });
    }

    private void setupButtonTestDB(){
        Button buttonTestDB = findViewById(R.id.buttonTestDB);
        buttonTestDB.setOnClickListener(view -> {
            DBAdapter db = new DBAdapter(this);
            db.open();
            db.insertUser("test","test123", "test@test.com");
            Cursor cursor = db.findUser("test");
            if(cursor != null){
                showUser(cursor);
                cursor.close();
            }
            db.close();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            db.open();
            if(db.updateUser("test", "test12345","tester@tester.net")){
                Cursor ucursor = db.findUser("test");
                if(ucursor != null){
                    showUser(ucursor);
                }
                ucursor.close();
            }
            db.close();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            db.open();
            if( db.deleteUser("test")){
                Toast.makeText(this,"Deleted user", Toast.LENGTH_LONG);
            }
            db.close();
        });
    }

    private void showUser(Cursor cursor) {
        String displayText = "{" + "\n"
                + "username: " + cursor.getString(0) + "\n"
                +"password: " + cursor.getString(1) + "\n"
                + "email: " + cursor.getString(2) + "\n" + "}";
        TextView textView = findViewById(R.id.textView);
        textView.setText(displayText);
        Toast.makeText(this, displayText,Toast.LENGTH_LONG).show();
    }

    private void setupButtonPreferenceNew() {
        Button buttonFragment = findViewById(R.id.buttonPreferenceNew);
        buttonFragment.setOnClickListener(view -> {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    private void setupButtonPreference() {
        Button buttonFragment = findViewById(R.id.buttonPreference);
        buttonFragment.setOnClickListener(view -> {
            Intent intent = new Intent(this, AppPreferenceActivity.class);
            startActivity(intent);
        });
    }

    private void setupButtonContextMenu() {
        Button buttonContextMenu = findViewById(R.id.buttonContextMenu);
        buttonContextMenu.setOnCreateContextMenuListener(this);
    }
    private void setupButtonFragment() {
        Button buttonFragment = findViewById(R.id.buttonFragment);
        buttonFragment.setOnClickListener(view -> {
            Intent intent = new Intent(this, FragmentActivity.class);
            startActivity(intent);
        });
    }

    private void setupButtonPicNew() {
        Button buttonPicNew = findViewById(R.id.buttonPicNew);
        buttonPicNew.setOnClickListener(view -> {
            openPhotoForResult(view);
        });
    }

    private void openPhotoForResult(View view) {
        Intent intent = createPhotoIntent();
        photoLauncher.launch(intent);
    }

    private void setupButtonPic() {
        Button buttonPic = findViewById(R.id.buttonPic);
        buttonPic.setOnClickListener(view -> {
            Intent intent = createPhotoIntent();
            startActivityForResult(intent, RC_GET_PHOTO);
        });
    }

    @NonNull
    private static Intent createPhotoIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/jpg");
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        return intent;
    }

    private void setupButtonShare() {
        Button buttonShare = findViewById(R.id.buttonShare);
        buttonShare.setOnClickListener(view -> {
//            Log.d("BUTTON_CLICK", "Button was Clicked on " + view.toString());
//            //Uri number = Uri.parse("http://www.jamteach.com");
//            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//            intent.putExtra(SearchManager.QUERY,"mobile development");
//            Intent chooser = Intent.createChooser(intent, "Choose to send");
//            startActivity(chooser);

            //startActivity(new Intent("com.jamteach.testapp.TestActivity"));
            Intent intent = new Intent(this, TestActivity.class);
            testLauncher.launch(intent);
            //startActivityForResult(intent, RC_GET_TEXT);
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_GET_PHOTO && resultCode == RESULT_OK){
            handlePhotoResponse(data);
        }
        if(requestCode == RC_GET_TEXT && resultCode == RESULT_OK){
            handleTextResponse(data);
        }

    }

    private void handleTextResponse(@Nullable Intent data) {
        Uri uri = data.getData();
        TextView textView = findViewById(R.id.textView);
        textView.setText(uri.toString());
    }

    private void handlePhotoResponse(@Nullable Intent data) {
        Uri uri = data.getData();
        ImageView imageView = findViewById(R.id.img);
        imageView.setImageURI(uri);
    }

    private void populateMenu(Menu menu){
        MenuItem mnu1 = menu.add(0,0,0,"Menu Item One");
        mnu1.setAlphabeticShortcut('z');
        MenuItem mnu2 = menu.add(0,1,0,"Menu Item Two");
        mnu2.setAlphabeticShortcut('b');

        Log.i("MENU", "populateMenu: completed");
    }

    public boolean onMenuChoice(MenuItem menuItem) {
        String msg = "default message";
        boolean isItemSelected = true;
        int toastLength = Toast.LENGTH_LONG;

        switch(menuItem.getItemId()) {
            case 0:
                msg = "Item one selected";
                break;
            case 1:
                msg = "Item two selected";
                break;
            default:
                msg= "Invalid option";
                toastLength = Toast.LENGTH_SHORT;
                isItemSelected = false;
        }

        Toast.makeText(this, msg, toastLength).show();
        return isItemSelected;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("MENU", "onCreateOptionsMenu: completed");
        super.onCreateOptionsMenu(menu);
        populateMenu(menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        populateMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        return onMenuChoice(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         super.onContextItemSelected(item);
        return onMenuChoice(item);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            return downloadImage(strings[0]);
        }
        @Override
        protected  void onPostExecute(Bitmap result){
            ImageView imageView = findViewById(R.id.img);
            imageView.setImageBitmap(result);
        }
    }
}