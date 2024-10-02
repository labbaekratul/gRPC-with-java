package tech.utkorsho.sec01;

public record JsonPerson(String lastName,
                         int age,
                         String email,
                         boolean employed,
                         double salary,
                         long bankAccountNumber,
                         int balance) {
}
