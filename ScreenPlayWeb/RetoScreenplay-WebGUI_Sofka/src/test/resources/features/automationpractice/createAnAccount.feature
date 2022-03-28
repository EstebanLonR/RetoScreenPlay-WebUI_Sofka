#author:Juan Esteban

Feature: Register

  @SuccesfullyRegistered
  Scenario Outline: Succesfully Register
    Given el usuario se encuentra en la pagina principal del aplicativo
    When el se dirige al apartado de Register
    And diligencia el formulario de registro con sus informacion
      | email   | title   | firstName   | lastName   | password   | address   | city   | state   | zipCode   | phone   |
      | <email> | <title> | <firstName> | <lastName> | <password> | <address> | <city> | <state> | <zipCode> | <phone> |
    Then el debera de ver la pagina "MY ACCOUNT"
    Examples:
      | email                      | title | firstName | lastName | password            | address          | city         | state    | zipCode | phone      |
      | Capitaowassap10@correo.com | Mr    | Bartolo   | Incapie  | contraseñasegurA123 | Calle de por ahi | PorAhiPorAca | Delaware | 00004   | 1112223344 |

  @CreateAccountWithEmailRegistered
  Scenario: CreateAccountWithEmailRegistered
    Given el usuario se encuentra en la pagina principal del aplicativo
    When el se dirige al apartado de Register
    And diligencia su correo "CapitaoWhatsapp@correo.com"
    Then el sistema debera mostrarle un mensaje de error "An account using this email address has already been registered."
