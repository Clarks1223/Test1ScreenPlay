@CompraPaginaWeb
Feature: Realizar una compra en DemoBlaze

  @Carrito
  Scenario: Agregar dos productos al carrito y completar la compra
    Given que el Cliente se encuentra en la página de inicio de DemoBlaze
    When doy clic en el producto  1
    And agrego un producto 1 al carrito
    And regreso a la página principal
    When doy clic en el producto 2
    And agrego el producto 2 al carrito
    And visualizo el contenido del carrito
    And completo el formulario de compra con mis datos
      | name  | country | city   | card    | month | year |
      | Pablo | Russia  | Moscow | 1234567 | July  | 2024 |
    And finalizo la compra exitosamente