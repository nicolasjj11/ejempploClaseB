public class ejercicioTienda {
    public static void main(String[] args) {
        double precioCamiseta = 25.0;
        double precioPantalon = 30.0;

        double descuentoGeneral = 0.15;

        double precioCamisetaConDescuento = precioCamiseta - (precioCamiseta * descuentoGeneral);
        double precioPantalonConDescuento = precioPantalon - (precioPantalon * descuentoGeneral);

        double descuentoAdicionalCamiseta = 0.05;
        double precioSegundaCamiseta = precioCamisetaConDescuento - (precioCamisetaConDescuento * descuentoAdicionalCamiseta);

      
        double precioTotal = precioCamisetaConDescuento + precioPantalonConDescuento + precioSegundaCamiseta;

        
        System.out.println("Precio de la primera camiseta con descuento: $" + precioCamisetaConDescuento);
        System.out.println("Precio del pantalón con descuento: $" + precioPantalonConDescuento);
        System.out.println("Precio de la segunda camiseta con descuento adicional: $" + precioSegundaCamiseta);
        System.out.println("Precio total a pagar: $" + precioTotal);
    }
}

