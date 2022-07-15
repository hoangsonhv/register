package com.k4.app.register;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.k4.app.register.adapter.UserAdapter;
import com.k4.app.register.database.AppDatabase;
import com.k4.app.register.database.User;

import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    RecyclerView rvUser;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        appDatabase = AppDatabase.getAppDatabase(this);
        List<User> list = appDatabase.userDao().getAllUser();

        UserAdapter adapter = new UserAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);

    }
}