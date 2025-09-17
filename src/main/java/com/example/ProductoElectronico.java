package com.example;

public class ProductoElectronico extends Producto {

    // Atributos adicionales bien puestos
    private int garantiaMeses;
    private String marca;
    private double voltaje;
    private boolean esImportado;

    public ProductoElectronico(String nombre, double precio, String codigo, int cantidadStock, String categoria,
            boolean activo, int garantiaMeses, String marca, double voltaje, boolean esImportado) {
        super(nombre, precio, codigo, cantidadStock, categoria, activo);
        this.garantiaMeses = garantiaMeses;
        this.marca = marca;
        this.voltaje = voltaje;
        this.esImportado = esImportado;
    }

    // Método para calcular el precio electrónico
    public double calcularPrecioElectronico() {
        double precioConIva = calcularPrecioFinal(); // Precio con IVA
        // Si es importado, le metemos el 5% adicional
        if (esImportado) {
            precioConIva += super.precio * 0.05;
        }
        double descuento = calcularDescuentoGarantia();
        double precioFinal = precioConIva - (precioConIva * descuento);
        return precioFinal;
    }

    // Método para calcular descuento por garantía
    public double calcularDescuentoGarantia() {
        if (garantiaMeses >= 24) {
            return 0.10; // 10% de descuento
        } else if (garantiaMeses >= 12) {
            return 0.05; // 5% de descuento
        } else {
            return 0.0; // Sin descuento
        }
    }

    // Método para ver si la garantía es extendida
    public boolean esGarantiaExtendida() {
        return garantiaMeses > 12;
    }

    // Método para calcular costo de garantía
    public double calcularCostoGarantia() {
        return super.precio * 0.02 * garantiaMeses;
    }

    // Método para ver compatibilidad de voltaje
    public boolean esCompatibleVoltaje(double voltajeLocal) {
        double diferencia = Math.abs(voltaje - voltajeLocal);
        double diferenciaPorcentual = (diferencia / voltajeLocal) * 100;
        return diferenciaPorcentual <= 10;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public String getMarca() {
        return marca;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

}
