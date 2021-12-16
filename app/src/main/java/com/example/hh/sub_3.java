package com.example.hh;


import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.provider.MediaStore;

import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialPhone(View view) {
        EditText editText = (EditText) findViewById(R.id.phone_number_edit);
        dialPhoneNumber(editText.getText().toString());
    }


    public void dialPhoneNumber (String phoneNumber){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    static final int REQUEST_CAPTURE_PHOTO = 2;

    public void capturePhoto () {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CAPTURE_PHOTO);
        }
    }

    static final int REQUEST_CAPTURE_VIDEO = 3;

    public void captureVideo () {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CAPTURE_VIDEO);
        }
    }


    static final int REQUEST_SELECT_CONTACT = 4;
    public void selectContact () {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }


    public void viewContact (Uri contactUri){
        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void editContact (Uri contactUri, String email){
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setData(contactUri);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void insertContact (String name, String email){
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void showMap(Uri geoLocation){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void searchWeb (String query){
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void openWebPage (String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}