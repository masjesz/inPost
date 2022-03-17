Feature: Paczkomaty

  Scenario: Powinien zwrócić listę 10 paczkomatów w Warszawie
    Given Mam listę paczkomatów
    When Zapisuje listę adresów do pliku
    Then Wszystkie paczkomaty mają poprawny adres