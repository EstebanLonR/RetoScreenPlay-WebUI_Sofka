#author:Juan Esteban


Feature: Contact Us

  @SuccesfullyContactUs
  Scenario Outline: SuccesfullyContactUs
    Given el usuario se encuentra en la pagina principal del aplicativo
    When se dirige al apartado de contact us
    And diligencia el formulario de customer service
      | email   | reference   | message   |
      | <email> | <reference> | <message> |
    Then el sistema debera mostrarle un mensaje de confirmando que su mensaje ha sido enviado
    Examples:
      | email                      | reference    | message                                                                            |
      | CapitaoWhatsapp@correo.com | Vestido roto | Mi vestido recien comprado se rasgado solo...esta es mi orden de compra xxxxxxxx02 |

  @ErrorContactUs
  Scenario: ContacUs WithOut Message
    Given el usuario se encuentra en la pagina principal del aplicativo
    When se dirige al apartado de contact us
    And diligencia el formulario de customer service sin mensaje
      | email                      | reference    |
      | CapitaoWhatsapp@correo.com | Vestido roto |
    Then el sistema debera mostrarle un mensaje "The message cannot be blank."
