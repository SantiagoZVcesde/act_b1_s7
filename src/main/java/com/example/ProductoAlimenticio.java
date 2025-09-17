package com.example;

public class ProductoAlimenticio extends Producto {

    private boolean refrigerado;
    private String lote;
    private int diasParaVencer;

    // Constructor
    public ProductoAlimenticio(String nombre, double precio, String codigo, int cantidadStock, String categoria,
        boolean activo, boolean refrigerado, String lote, int diasParaVencer) {
        super(nombre, precio, codigo, cantidadStock, categoria, activo);
        this.refrigerado = refrigerado;
        this.lote = lote;
        this.diasParaVencer = diasParaVencer;
    }

    // Método para calcular precio con lógica específica
    public double calcularPrecioAlimenticio() {
        double precioConIVA = calcularPrecioFinal();
        double precioConRecargo = precioConIVA;

        if (refrigerado) {
            double recargo = super.precioBase * 0.08;
            precioConRecargo += recargo;
        }

        double descuento = calcularDescuentoVencimiento();
        double precioFinal = precioConRecargo * (1 - descuento);

        return precioFinal;
    }

    // Método para calcular descuento por vencimiento
    public double calcularDescuentoVencimiento() {
        if (diasParaVencer <= 3) {
            return 0.50;
        } else if (diasParaVencer <= 7) {
            return 0.30;
        } else if (diasParaVencer <= 15) {
            return 0.15;
        }
        return 0.0;
    }

    // Métodos de verificación de estado
    public boolean estaProximoAVencer() {
        return diasParaVencer <= 7;
    }

    public boolean estaVencido() {
        return diasParaVencer <= 0;
    }

    public String obtenerEstadoFrescura() {
        if (estaVencido()) {
            return "VENCIDO";
        } else if (diasParaVencer <= 3) {
            return "URGENTE";
        } else if (diasParaVencer <= 7) {
            return "PRÓXIMO A VENCER";
        } else if (diasParaVencer <= 15) {
            return "CONSUMIR PRONTO";
        }
        return "FRESCO";
    }

    public double calcularPerdidaPorVencimiento() {
        return estaVencido() ? super.precioBase * getCantidadStock() : 0.0;
    }

    // Getters y setters
    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }
}
