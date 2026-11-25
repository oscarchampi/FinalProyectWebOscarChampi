Feature: Registrar nuevo usuario
  @RegistrarNew @HappyPath
    Scenario Outline: Registrar de manera exitosa un usuario con datos validos
    Given el usuario esta en la pagina de inicio
    And seleciona el boton de registro
    And ingresa un nombre de usuario "<username>" y contrasena "<password>"
    When seleciona el boton registrar
    Then realizar el registro de manera correcta
    Examples:
      | username   | password |
      | andresantiooogo | po00123  |

  @RegistrarNew @UnhappyPath @UsuarioExistente
  Scenario Outline: Validar error al registrar un usuario que ya existe
    Given el usuario esta en la pagina de inicio
    And seleciona el boton de registro
    And ingresa un nombre de usuario "<username>" y contrasena "<password>"
    When seleciona el boton registrar
    Then muestra el mensaje de alerta "<mensaje>"

    Examples:
      | username        | password | mensaje                  |
      | andresantiooogo | po00123  | This user already exist. |