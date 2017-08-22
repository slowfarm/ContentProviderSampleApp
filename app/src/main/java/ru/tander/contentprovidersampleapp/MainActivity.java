package ru.tander.contentprovidersampleapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ru.tander.tanderstorepolicyrepository.PolicyRepository;


public class MainActivity extends AppCompatActivity {

    private PolicyRepository policyRepository = new PolicyRepository();
    private Adapter adapter = new Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            adapter.addAll(policyRepository.getPoliciesList(this, "dorou"));
        } catch (IllegalArgumentException e) {
            showAlertDialog(e.getMessage());
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message + ". Change to " + getPackageName() + "?");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", (dialog, which) -> adapter.addAll(policyRepository.getPoliciesList(this, getPackageName())));
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
