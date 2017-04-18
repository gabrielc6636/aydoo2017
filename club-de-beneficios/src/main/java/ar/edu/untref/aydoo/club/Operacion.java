package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class Operacion {

    private double importe;
    private double importeAhorrado;
    private Beneficio beneficio;
    private Mes mes;
    private List<Producto> productos = new ArrayList<Producto>();
    private Sucursal sucursal;
    public Operacion(final Beneficio beneficio,
                     final List<Producto> productos,
                     final Mes mes,
                     final Sucursal sucursal)
            throws BeneficioException {
        this.beneficio = beneficio;
        this.productos = productos;

        double importeOriginal = obtenerImporteInicial();
        double importeADescontar = obtenerDescuento(beneficio,
                                                    productos);

        this.importe = importeOriginal - importeADescontar;
        this.importeAhorrado = importeADescontar;
        this.mes = mes;

        this.sucursal = sucursal;
    }

    public double obtenerDescuento(final Beneficio beneficio,
                                   final List<Producto> productosDescuento)
            throws BeneficioException {
        List<Producto> productos
                = beneficio.obtenerValorBeneficio(productosDescuento);

        double importeInicial = 0;

        for (Producto producto: productos) {
            importeInicial = importeInicial
                    + producto.obtenerBeneficioImporte();
        }

        return importeInicial;
    }

    public double obtenerImporteInicial() {
        double importeInicial = 0;

        for (Producto producto: productos) {
            importeInicial = importeInicial
                    + producto.obtenerImporte();
        }

        return importeInicial;
    }

    public double obtenerImporte() {
        return this.importe;
    }

    public double obtenerImporteAhorrado() {
        return this.importeAhorrado;
    }

    public Mes obtenerMes() {
        return this.mes;
    }

    public List<Producto> obtenerProductos() {
        return this.productos;
    }

    public Sucursal obtenerSucursal() {
        return this.sucursal;
    }
}
