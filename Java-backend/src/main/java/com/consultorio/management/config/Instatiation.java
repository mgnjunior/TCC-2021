package com.consultorio.management.config;

import com.consultorio.management.entity.model.Medic;
import com.consultorio.management.entity.model.Patient;
import com.consultorio.management.entity.model.User;
import com.consultorio.management.repository.MedicRepository;
import com.consultorio.management.repository.PatientRepository;
import com.consultorio.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Medic medic = Medic.builder()
                .crm(10L)
                .firstName("Jose")
                .secondName("Pedro")
                .email("josepedro@email.com")
                .build();

        Patient patient = Patient.builder()
                .cpf("12345678910")
                .firstName("Luis")
                .secondName("naval")
                .email("luznaval@email.com")
                .build();

        patientRepository.save(patient);

        User user = User.builder()
                .login("user")
                .pass("123")
                .build();

        userRepository.save(user);

        medicRepository.save(medic);
    }
}
