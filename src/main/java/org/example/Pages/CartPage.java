package org.example.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage extends PageObject {

    public static final Target OPT_CATEGORIA = Target.the("Categoria {0}")
            .locatedBy("//a[@id='itemc' and text()='{0}']");
    public static final Target LNK_PRODUCTO = Target.the("Producto {0}")
            .locatedBy("//a[@class='hrefch' and text()='{0}']");
    public static final Target BTN_ADD_TO_CART = Target.the("Boton Add to cart")
            .locatedBy("//a[text()='Add to cart']");
    public static final Target BTN_CART_NAV = Target.the("Boton Cart navbar")
            .locatedBy("//a[@id='cartur']");
    public static final Target LBL_PRODUCTO_EN_CARRITO = Target.the("Producto en carrito {0}")
            .locatedBy("//tbody[@id='tbodyid']//td[text()='{0}']");
    public static final Target BTN_ELIMINAR_PRODUCTO = Target.the("Boton Delete para {0}")
            .locatedBy("//tbody[@id='tbodyid']//td[text()='{0}']/following-sibling::td/a[text()='Delete']");

    // Realizar Pedido (Place Order)
    public static final Target BTN_PLACE_ORDER = Target.the("Boton Place Order")
            .locatedBy("//button[text()='Place Order']");
    public static final Target INP_ORDER_NAME = Target.the("Input Name pedido")
            .locatedBy("//input[@id='name']");
    public static final Target INP_ORDER_COUNTRY = Target.the("Input Country pedido")
            .locatedBy("//input[@id='country']");
    public static final Target INP_ORDER_CITY = Target.the("Input City pedido")
            .locatedBy("//input[@id='city']");
    public static final Target INP_ORDER_CARD = Target.the("Input Credit Card pedido")
            .locatedBy("//input[@id='card']");
    public static final Target INP_ORDER_MONTH = Target.the("Input Month pedido")
            .locatedBy("//input[@id='month']");
    public static final Target INP_ORDER_YEAR = Target.the("Input Year pedido")
            .locatedBy("//input[@id='year']");
    public static final Target BTN_PURCHASE = Target.the("Boton Purchase")
            .locatedBy("//button[text()='Purchase']");
    public static final Target LBL_COMPRA_EXITOSA = Target.the("Mensaje compra exitosa")
            .locatedBy("//div[contains(@class,'sweet-alert')]//h2");
    public static final Target BTN_OK_COMPRA = Target.the("Boton OK confirmacion compra")
            .locatedBy("//button[text()='OK']");
}