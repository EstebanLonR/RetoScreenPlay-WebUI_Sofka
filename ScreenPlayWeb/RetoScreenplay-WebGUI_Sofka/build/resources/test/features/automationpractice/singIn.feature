#author: Juan Esteban

Feature:Sing In

  @SignInSuccesfully
  Scenario:Sing In
    Given el usuario se encuentra en la pagina principal del aplicativo
    When el se dirige al apartado de sing in
    And diligencia el formulario con sus credenciales
      | email                      | password   |
      | CapitaoWhatsapp@correo.com | 12345678uI |
    Then el sistema debera mostrarle su usuario logeado en la pagina

  @ForgotPassword
  Scenario Outline: Forgot Password
    Given el usuario se encuentra en la pagina principal del aplicativo
    When el se dirige al apartado de sing in
    And se dirige el apartado de forgot password y manda su email
      | email   |
      | <email> |
    Then el sistema debera mostrarle el mensaje "A confirmation email has been sent to your address"
    Examples:
      | email                      |
      | CapitaoWhatsapp@correo.com |
