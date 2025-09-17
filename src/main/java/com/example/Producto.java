package com.example;

public class Producto {

    private String nombre;
    private double precio;
    private String codigo;
    private int cantidadStock;
    private String categoria;
    private boolean activo;

    public Producto(String nombre, double precio, String codigo, int cantidadStock, String categoria, boolean activo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCantidadStock(int cantidadStock) {
        if (cantidadStock < 0) {
            throw new IllegalArgumentException("La cantidad en stock no puede ser negativa");
        }
        this.cantidadStock = cantidadStock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double calcularPrecioFinal() {
        // TODO: Calcular precio base + IVA (19%)
        // Retornar el precio base multiplicado por 1.19
        return precio * 1.19;
    }

    public boolean hayStock(int cantidad) {
        // TODO: Verificar si hay suficiente stock disponible
        // Comprobar que cantidadStock >= cantidad Y que el producto esté activo
        return cantidadStock >= cantidad && activo;
        // Retornar true si ambas condiciones se cumplen, false en caso contrario
    }

    public void vender(int cantidad) {
        // TODO: Implementar lógica de venta
        // 1. Verificar si hay suficiente stock usando hayStock()
        // 2. Si hay stock: reducir cantidadStock en la cantidad vendida
        // 3. Mostrar mensaje "Venta exitosa: [cantidad] unidades de [nombre]"
        // 4. Si no hay stock: mostrar mensaje "Error: Stock insuficiente"
        if (hayStock(cantidad)) {
            cantidadStock -= cantidad;
            System.out.println("Venta exitosa: " + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("Error: Stock insuficiente");
        }
    }

    public void reabastecer(int cantidad) {
        // TODO: Aumentar el stock del producto
        // 1. Sumar la cantidad al cantidadStock actual
        // 2. Mostrar mensaje "Reabastecimiento exitoso: +[cantidad] unidades de
        // [nombre]"
        cantidadStock += cantidad;
        System.out.println("Reabastecimiento exitoso: +" + cantidad + " unidades de " + nombre);
    }

    public double calcularDescuento() {
        // TODO: Retornar descuento base
        // La clase padre no tiene descuentos, retornar 0.0
        return 0.0;
    }

}
