package com.loren.gestionventasv3.DAO;

public class FactoriaDAO {

    private static ClienteDAO clienteDAO = null;
    // private static PedidosDAO pedidosDAO = null;

    public static ClienteDAO getClienteDAO() {
        if (clienteDAO == null) {
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }

    private static ComercialDAO comercialDAO = null;

    public static ComercialDAO gerComercialDAO() {
        if (comercialDAO == null) {
            comercialDAO = new ComercialDAO();
        }
        return comercialDAO;
    }

    public Object getComercialDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
