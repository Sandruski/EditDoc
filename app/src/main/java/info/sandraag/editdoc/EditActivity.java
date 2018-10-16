package info.sandraag.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edit_text = findViewById(R.id.edit_text);

        // Pas 2. Rebem els paràmetres de l'activitat que ens crida
        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra("text");
            if (text != null)
                edit_text.setText(text);

        }
    }

    public void onSave(View view) {

        // Pas 3. Retornem el resultat
        String new_text = edit_text.getText().toString();
        Intent data = new Intent();
        data.putExtra("text", new_text);
        setResult(RESULT_OK, data);
        finish();
    }
}
