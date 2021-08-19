package com.example.contactroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.contactroom.model.Contact;
import com.example.contactroom.model.ContactViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ContactViewModel contactViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
                .getApplication())
                .create(ContactViewModel.class);

        contactViewModel.getAllContacts().observe(this, contacts -> {
            StringBuilder builder = new StringBuilder();
            for (Contact contact : contacts) {
                builder.append(" - ").append(contact.getName()).append(" ").append((contact.getOccupation()));
            }
            textView.setText(builder.toString());
        });
    }
}