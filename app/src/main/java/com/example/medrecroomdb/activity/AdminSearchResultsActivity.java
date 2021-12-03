package com.example.medrecroomdb.activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.example.medrecroomdb.R;
import com.example.medrecroomdb.model.Doctor;
import com.example.medrecroomdb.model.Patient;
import com.example.medrecroomdb.viewmodel.DoctorViewModel;
import com.example.medrecroomdb.viewmodel.PatientViewModel;
public class AdminSearchResultsActivity extends AppCompatActivity {

    PatientViewModel patientViewModel;
    DoctorViewModel doctorViewModel;
    Patient patient;
    Doctor doctor;
    String strId;
    Integer id;
    private EditText editText_UserId, editText_firstName, editText_lastName, editText_address, editText_email, editText_phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_searchresults);
        try{
            Intent intent=getIntent();
            strId = intent.getStringExtra("userId");
            id = Integer.parseInt(strId);
            patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
            patient = patientViewModel.findByPatientId(id);
            if (patient != null)
            {
                editText_UserId = findViewById(R.id.editText_UserId);
                editText_UserId.setText(String.valueOf(patient.getPatientId()));
                editText_firstName = findViewById(R.id.editText_firstName);
                editText_firstName.setText(patient.getFirstName());
                editText_lastName = findViewById(R.id.editText_lastName);
                editText_lastName.setText(patient.getLastName());
                editText_address = findViewById(R.id.editText_address);
                editText_address.setText(patient.getEmail());
                editText_email = findViewById(R.id.editText_email);
                editText_email.setText(patient.getEmail());
                editText_phoneNumber = findViewById(R.id.editText_phoneNumber);
                editText_phoneNumber.setText(patient.getEmail());
            }
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}