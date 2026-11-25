Feature: Flujos de compra, carrito y contacto en DemoBlaze

  Background:
    Given el usuario esta en la pagina de inicio
    And el usuario esta logueado en la tienda con usuario "roxanacorrales" y contrasena "12345678"

  @Tarea @AgregarCarrito @HappyPath
  Scenario Outline: Agregar un producto al carrito de compras
    When selecciona la categoria "<categoria>"
    And selecciona el producto "<producto>"
    And agrega el producto al carrito de compras
    Then verifica en el carrito que se muestre el producto "<producto>"

    Examples:
      | categoria | producto      |
      | Laptops   | Sony vaio i5  |

  @Tarea @RealizarCompra @HappyPath
  Scenario Outline: Realizar el pedido de un producto desde el carrito
    Given el usuario agrega el producto "<producto>" de la categoria "<categoria>" al carrito
    And se dirige al carrito de compras
    When inicia el proceso de realizar pedido
    And ingresa los datos de compra
      | nombre       | pais | ciudad   | tarjeta          | mes | anio |
      | Oscar Champi | Peru | Arequipa | 4557880123456789 | 11  | 2028 |
    And confirma la compra
    Then realiza su compra de manera exitosa con el mensaje "Thank you for your purchase!"

    Examples:
      | categoria | producto          |
      | Phones    | Samsung galaxy s6 |

  @Tarea @EliminarCarrito
  Scenario Outline: Eliminar un producto del carrito de compras
    Given el usuario agrega el producto "<producto>" de la categoria "<categoria>" al carrito
    And se dirige al carrito de compras
    When elimina el producto "<producto>" del carrito
    Then verifica que el producto "<producto>" ya no se muestre en el carrito

    Examples:
      | categoria | producto         |
      | Phones    | Nokia lumia 1520 |

  @Tarea @Contacto
  Scenario: Enviar un mensaje desde el formulario de contacto
    When abre el formulario de contacto
    And ingresa los datos de contacto
      | correo               | nombre       | mensaje                                   |
      | oscar.qa@example.com | Oscar Champi | Consulta sobre disponibilidad de laptops |
    And envia el mensaje de contacto
    Then muestra el mensaje de alerta "Thanks for the message!!"

  @Tarea @SobreNosotros
  Scenario: Reproducir video sobre nosotros
    When seleciona el boton de sobre nosotros
    And reproduce el boton de play
    Then el video se reproduce correctamente