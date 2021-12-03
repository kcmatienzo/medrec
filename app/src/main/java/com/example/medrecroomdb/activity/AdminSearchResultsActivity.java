package com.example.medrecroomdb.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private Button btnUpdateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_searchresults);
        btnUpdateUser = findViewById(R.id.btnAdminSearchResultsUpdateUser);


        try{
            Intent intent=getIntent();
            strId = intent.getStringExtra("userId");
            id = Integer.parseInt(strId);
            patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
            patient = patientViewModel.findByPatientId(id);
            doctorViewModel= ViewModelProviders.of(this).get(DoctorViewModel.class);
            doctor = doctorViewModel.findByDoctorId(id);
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
            }else{

                editText_UserId = findViewById(R.id.editText_UserId);
                editText_UserId.setText(String.valueOf(doctor.getDoctorId()));
                editText_firstName = findViewById(R.id.editText_firstName);
                editText_firstName.setText(doctor.getFirstName());
                editText_lastName = findViewById(R.id.editText_lastName);
                editText_lastName.setText(doctor.getLastName());
                editText_address = findViewById(R.id.editText_address);
                editText_address.setText(doctor.getEmail());
                editText_email = findViewById(R.id.editText_email);
                editText_email.setText(doctor.getEmail());
                editText_phoneNumber = findViewById(R.id.editText_phoneNumber);
                editText_phoneNumber.setText(doctor.getEmail());
            }
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSearchResult = new Intent(view.getContext(), UpdateUserActivity.class);
                intentSearchResult.putExtra("userId", id.toString());
                startActivity(intentSearchResult);
            }
        });
    }
}