package info.sandraag.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DocActivity extends AppCompatActivity {

    public static final int EDIT_TITLE = 0;
    public static final int EDIT_DOC = 1;
    // Model
    private String title = "Title", doc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent a dapibus leo. Praesent fringilla condimentum tortor quis mattis. Vestibulum eu porta sapien. Nulla facilisi. Vivamus a bibendum turpis. Praesent pretium at sem non efficitur. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam in euismod neque, eu feugiat justo. Pellentesque vel nisl tellus. Donec cursus, metus nec laoreet ultricies, neque nunc euismod quam, non pulvinar enim augue condimentum quam.";

    // Referències a objectes de la pantalla
    private TextView title_view;
    private TextView doc_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        title_view = findViewById(R.id.title_view);
        doc_view = findViewById(R.id.doc_view);

        title_view.setText(title);
        doc_view.setText(doc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doc_menu, menu); // Fico les meves opcions de menú
        return super.onCreateOptionsMenu(menu); // La classe base fica les seves opcions de menú
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.option_edit_title: {
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("text", title);
                startActivityForResult(intent, EDIT_TITLE); // Ctrl + Alt + C: crear una constant d'una variable
                break;
            }
            case R.id.option_edit_doc: {
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("text", doc);
                startActivityForResult(intent, EDIT_DOC); // Ctrl + Alt + C: crear una constant d'una variable
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case EDIT_TITLE:
                if (resultCode == RESULT_OK) {
                    title = data.getStringExtra("text");
                    title_view.setText(title);
                }
                // Tirar amb el botó enrere == RESULT_CANCELED
                break;
            case EDIT_DOC:
                if (resultCode == RESULT_OK) {
                    doc = data.getStringExtra("text");
                    doc_view.setText(doc);
                }
                // Tirar amb el botó enrere == RESULT_CANCELED
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
