package com.example.springsecurityapplication.services;

import com.example.springsecurityapplication.models.Person;
import com.example.springsecurityapplication.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person getPersonFindByLogin(Person person){
        Optional<Person> person_db = personRepository.findByLogin(person.getLogin());
        return person_db.orElse(null);
    }

    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        personRepository.save(person);
    }

    // Данный метод позволяет получить всех пользователей
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    // Данный метод позволяет получить пользователя по id
    public Person getPersonById(int id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    //    // Данный метод позволяет сохранить пользователя
//    @Transactional
//    public void savePerson(Person person){
//        personRepository.save(person);
//    }
//
//
// Данный метод позволяет обновить пароль пользователя
    @Transactional
    public void updatePassword(int id, String password){
        personRepository.updatePersonById(id,passwordEncoder.encode(password));
    }
    // Данный метод позволяет обновить данные пользователя
    @Transactional
    public void updatePerson(int id, Person person){
        person.setId(id);
        personRepository.save(person);
    }

    // Данный метод позволяет удалить пользовател по id
    @Transactional
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }


    // Данный метод позволяет получить пользователя по email адресу
    public Person getPersonEmail(String email){
        Optional<Person> optionalPersons = personRepository.findByEmail(email);
        return optionalPersons.orElse(null);
    }

    // Данный метод позволяет получить пользователя по номеру телефона
    public Person getPersonPhoneNumber(String phone_number){
        Optional<Person> optionalPersons = personRepository.findByPhoneNumber(phone_number);
        return optionalPersons.orElse(null);
    }

    // Данный метод позволяет получить пользователя по фамилии и отсортировать по возрасту
    public Person getPersonLastNameOrderByBirthday(String last_name){
        Optional<Person> optionalPersons = personRepository.findByLastnameOrderByBirthday(last_name);
        return optionalPersons.orElse(null);
    }


    // Данный метод позволяет получить пользователя по фамилии, где начало равно определенной последовательности
    public Person getPersonLastNameStartingWith(String starting_with){
        Optional<Person> optionalPersons = personRepository.findByLastnameStartingWith(starting_with);
        return optionalPersons.orElse(null);
    }


    public boolean checkIfValidOldPassword(Person person, String oldPassword) {

        return false;
    }

    public Person changeUserPassword(Person person, String password) {
        Optional<Person> optionalPersons = personRepository.findByPassword(password);
        return optionalPersons.orElse(null);
    }
}
