Feature: Añadir productos al carrito y diligenciar la información de entrega

  Scenario Outline: Un usuario registrado selecciona productos y completa la compra
    Given el usuario inicia sesion con "<usuario>" y "<contraseña>"
    When selecciona el primer producto disponible con cantidad dos y lo anade al carrito
    And selecciona el producto Caja Agata  rosas con cantidad siete y lo anade al carrito
    And diligencia el formulario de informacion de entrega con "<nombre_completo>", "<municipio>", "<dirección>", "<barrio>", "<teléfono>", "<mensaje_tarjeta>", "<firma>" y "<observaciones>"
    And selecciona la fecha y el horario de entrega
    And hace clic en Realizar pedido
    Then el sistema muestra el resumen de la compra

    Examples:
      | usuario                      | contraseña     | nombre_completo | municipio | dirección | barrio | teléfono   | mensaje_tarjeta  | firma   | observaciones |
      | jhonjaderrojas1998@gmail.com | JHONrojas1234* | Juan Pérez      | Medellín  | Calle 123 | Centro | 3001234567 | Feliz cumpleaños | Juanito | Ninguna       |
