package at.xp2_2017.battlefood;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class UploadRecipeUi extends AppCompatActivity implements View.OnClickListener {

    private static final int RESULT_LOAD_IMAGE = 1;
    private DatabaseReference mDatabase;
    private EditText number_adult;
    private EditText number_child;
    private EditText working_time;
    private EditText ingredients;
    private EditText instructions;
    private Button btnUpload;
    private Button btnSelectPic;
    private EditText txtRecipeName;
    private ImageView imgImageRecipe;

    private StorageReference tStorageRef;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri pickedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
            imgImageRecipe.setImageBitmap(bitmap);

            //Firebase Code
            cursor.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe_ui);


        tStorageRef = FirebaseStorage.getInstance().getReference();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference recipeRef = mDatabase.child("Recipe");
        //FirebaseStorage storage = FirebaseStorage.getInstance();
        //StorageReference storageRef = storage.getReference();

        txtRecipeName = (EditText) findViewById(R.id.txtNameRecipe);
        number_adult = (EditText) findViewById(R.id.editTextadult);
        number_child = (EditText) findViewById(R.id.editTextchild);
        working_time = (EditText) findViewById(R.id.editTexttime);
        ingredients = (EditText) findViewById(R.id.editTextIngredients);
        instructions = (EditText) findViewById(R.id.editTextinstruction);
        imgImageRecipe = (ImageView) findViewById(R.id.imgViewRecipe);
        btnSelectPic = (Button) findViewById(R.id.buttonSelPic);
        btnSelectPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent galleryIntent = new Intent(Intent.ACTION_PICK);
                galleryIntent.setType("image/*");
              //TO get image back
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });




        btnUpload = (Button) findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(txtRecipeName.getText().toString()) || TextUtils.isEmpty(number_adult.getText().toString()) ||
                        TextUtils.isEmpty(number_child.getText().toString()) ||
                        TextUtils.isEmpty(ingredients.getText().toString()) || TextUtils.isEmpty(instructions.getText().toString()))
                {
                    Toast.makeText(UploadRecipeUi.this, "Please insert all data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseReference addChildRecipe = recipeRef.push();
                    addChildRecipe.child("Name").setValue(txtRecipeName.getText().toString());
                    addChildRecipe.child("NumberOfAdult").setValue(number_adult.getText().toString());
                    addChildRecipe.child("NumberOfChild").setValue(number_child.getText().toString());
                    addChildRecipe.child("Ingredients").setValue(ingredients.getText().toString());
                    addChildRecipe.child("Instructions").setValue(instructions.getText().toString());
                    Toast.makeText(UploadRecipeUi.this, "Upload successfull", Toast.LENGTH_SHORT).show();
                    Intent toStart = new Intent(UploadRecipeUi.this, StartUI.class);
                    startActivity(toStart);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
