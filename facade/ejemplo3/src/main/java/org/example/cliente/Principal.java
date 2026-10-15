package org.example.cliente;

import org.example.fachada.FachadaInformacionDestino;
import org.example.modelo.ReporteDestino;


public class Principal {

    public static void main(String[] args) {

        FachadaInformacionDestino fachada = new FachadaInformacionDestino();

        // Cliente 1 realizando una búsqueda
        ReporteDestino resultado1 = fachada.consultarDestino("1094901234", "Carlos Gómez", "colombia");
        if (resultado1 != null) {
            System.out.println("-> Para el cliente: " + resultado1);
        }

        // Cliente 2 realizando otra búsqueda
        ReporteDestino resultado2 = fachada.consultarDestino("1094905678", "María Fernanda Torres", "japan");
        if (resultado2 != null) {
            System.out.println("-> Para el cliente: " + resultado2);
        }

    }
}