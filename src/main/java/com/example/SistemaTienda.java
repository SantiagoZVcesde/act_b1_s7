package com.example;

public class SistemaTienda {

    public static void main(String[] args) {
        // Crear productos electrónicos
        ProductoElectronico laptop = new ProductoElectronico(
            "Laptop Gamer", 
            2500000, 
            "LT001", 
            5, 
            "Electrónica", 
            true, 
            24, 
            "Dell", 
            110.0, 
            true
        );
        
        ProductoElectronico celular = new ProductoElectronico(
            "Smartphone", 
            1500000, 
            "SP002", 
            3, 
            "Electrónica", 
            true, 
            12, 
            "Samsung", 
            220.0, 
            false
        );
        
        // Crear productos alimenticios
        ProductoAlimenticio leche = new ProductoAlimenticio(
            "Leche Entera", 
            4500, 
            "LE001", 
            20, 
            "Lácteos", 
            true, 
            true, 
            "L123", 
            5
        );
        
        ProductoAlimenticio pan = new ProductoAlimenticio(
            "Pan Integral", 
            3000, 
            "PI002", 
            15, 
            "Panadería", 
            true, 
            false, 
            "P456", 
            2
        );

        // ===== OPERACIONES DE PRUEBA =====
        
        System.out.println("=== PRUEBAS DE PRODUCTO ELECTRÓNICO ===");
        
        // Venta exitosa y fallida
        System.out.println("\n--- Pruebas de venta ---");
        laptop.vender(2); // Venta exitosa
        laptop.vender(10); // Venta fallida por stock insuficiente
        
        // Cálculo de precios
        System.out.println("\n--- Cálculo de precios ---");
        double precioBaseLaptop = laptop.getPrecio();
        double precioFinalLaptop = laptop.calcularPrecioElectronico();
        System.out.println("Precio base laptop: $" + precioBaseLaptop);
        System.out.println("Precio final laptop: $" + precioFinalLaptop);
        System.out.println("Diferencia: $" + (precioFinalLaptop - precioBaseLaptop));
        
        // Reabastecimiento
        System.out.println("\n--- Reabastecimiento ---");
        laptop.reabastecer(10);
        System.out.println("Stock después de reabastecer: " + laptop.getCantidadStock());
        
        // Verificación de compatibilidad de voltaje
        System.out.println("\n--- Compatibilidad de voltaje ---");
        boolean compatible110V = laptop.esCompatibleVoltaje(110.0);
        boolean compatible220V = laptop.esCompatibleVoltaje(220.0);
        System.out.println("Compatibilidad con 110V: " + compatible110V);
        System.out.println("Compatibilidad con 220V: " + compatible220V);
        
        // Funcionalidades únicas
        System.out.println("\n--- Funcionalidades únicas ---");
        System.out.println("Garantía extendida: " + laptop.esGarantiaExtendida());
        System.out.println("Costo de garantía: $" + laptop.calcularCostoGarantia());

        System.out.println("\n=== PRUEBAS DE PRODUCTO ALIMENTICIO ===");
        
        // Venta exitosa y fallida
        System.out.println("\n--- Pruebas de venta ---");
        leche.vender(5); // Venta exitosa
        leche.vender(50); // Venta fallida por stock insuficiente
        
        // Cálculo de precios
        System.out.println("\n--- Cálculo de precios ---");
        double precioBaseLeche = leche.getPrecio();
        double precioFinalLeche = leche.calcularPrecioAlimenticio();
        System.out.println("Precio base leche: $" + precioBaseLeche);
        System.out.println("Precio final leche: $" + precioFinalLeche);
        System.out.println("Diferencia: $" + (precioFinalLeche - precioBaseLeche));
        
        // Reabastecimiento
        System.out.println("\n--- Reabastecimiento ---");
        leche.reabastecer(15);
        System.out.println("Stock después de reabastecer: " + leche.getCantidadStock());
        
        // Funcionalidades únicas
        System.out.println("\n--- Funcionalidades únicas ---");
        System.out.println("Próximo a vencer: " + leche.estaProximoAVencer());
        System.out.println("Estado de frescura: " + leche.obtenerEstadoFrescura());
        System.out.println("Descuento por vencimiento: " + (leche.calcularDescuentoVencimiento() * 100) + "%");
        
        System.out.println("\n=== COMPARACIÓN ENTRE PRECIOS BASE Y ESPECÍFICOS ===");
        System.out.println("Laptop - Precio base: $" + laptop.getPrecio() + " | Precio específico: $" + laptop.calcularPrecioElectronico());
        System.out.println("Leche - Precio base: $" + leche.getPrecio() + " | Precio específico: $" + leche.calcularPrecioAlimenticio());
    }
}